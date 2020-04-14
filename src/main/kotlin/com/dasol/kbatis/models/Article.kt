package com.dasol.kbatis.models

class Article(val id: Long, val title: String, val author: String) {

    override fun toString(): String {
        return "Article(id=$id, title='$title', author='$author')"
    }

}