package com.dasol.kbatis.mappers

import com.dasol.kbatis.models.Article
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface ArticleMapper {

    @Select("SELECT * FROM ARTICLES;")
    fun selectAll(): List<Article>

}