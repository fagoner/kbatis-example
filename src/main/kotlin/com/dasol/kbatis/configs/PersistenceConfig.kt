package com.dasol.kbatis.configs

import org.apache.ibatis.session.SqlSessionFactory
import javax.sql.DataSource

interface PersistenceConfig {

    fun dataSource(): DataSource
    fun sqlSessionFactory(): SqlSessionFactory

}