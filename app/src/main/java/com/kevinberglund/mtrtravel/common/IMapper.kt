package com.kevinberglund.mtrtravel.common

interface IMapper<To : Any, From : Any> {

    fun map(model: From): To

    fun mapList(list: List<From>?): List<To>? {
        return list?.map { map(it) }
    }
}