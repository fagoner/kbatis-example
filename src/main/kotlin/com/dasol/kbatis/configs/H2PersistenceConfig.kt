package com.dasol.kbatis.configs

import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.annotation.MapperScan
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import javax.sql.DataSource

@Configuration
@MapperScan("com.dasol.kbatis.mappers")
@EnableAutoConfiguration(exclude = [ DataSourceAutoConfiguration::class, MybatisAutoConfiguration::class ])
class H2PersistenceConfig : PersistenceConfig {

    @Bean
    override fun dataSource(): DataSource {
        return EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("sql/schema.sql")
                .addScript("sql/data.sql")
                .build()
    }

    @Bean
    @Throws(Exception::class)
    override fun sqlSessionFactory(): SqlSessionFactory {
        val factoryBean = SqlSessionFactoryBean()
        factoryBean.setDataSource(this.dataSource())
        return factoryBean.`object`!!
    }

}