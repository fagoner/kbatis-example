package com.dasol.kbatis

import com.dasol.kbatis.configs.H2PersistenceConfig
import com.dasol.kbatis.mappers.ArticleMapper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.support.AnnotationConfigContextLoader

@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [ H2PersistenceConfig::class ], loader = AnnotationConfigContextLoader::class)
class ArticleMapperTests {

    @Autowired
    lateinit var articleMapper: ArticleMapper

    @Test
    fun selectAll() {
        val result = articleMapper.selectAll()
        assert(result.isNotEmpty())
    }

}