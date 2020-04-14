package com.dasol.kbatis

import com.dasol.kbatis.configs.H2PersistenceConfig
import com.dasol.kbatis.controllers.ArticleController
import com.dasol.kbatis.models.Article
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@AutoConfigureMockMvc
@ContextConfiguration(classes = [H2PersistenceConfig::class, ArticleController::class])
@WebMvcTest
class ArticleIntegrationTests {

    @Autowired
    lateinit var mockMvc: MockMvc

    private val jacksonObjectMapper = ObjectMapper().registerKotlinModule()

    @Test
    fun selectAll() {
        val mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/articles"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andReturn()

        val articles: List<Article> = jacksonObjectMapper.readValue(mvcResult.response.contentAsString)
        assert(articles.isNotEmpty())
    }

}