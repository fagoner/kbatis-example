package com.dasol.kbatis.controllers

import com.dasol.kbatis.mappers.ArticleMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@RestController
class ArticleController {

    @Autowired
    lateinit var articleMapper: ArticleMapper

    @GetMapping("/articles")
    @ResponseStatus(HttpStatus.OK)
//    @CrossOrigin(allowedHeaders = ["*"], origins = ["*"],methods = [RequestMethod.GET])
    fun selectAll() = articleMapper.selectAll()

}