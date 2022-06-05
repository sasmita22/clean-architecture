package com.hiroshisasmita.cleanarchitecture.data.network.query

data class PopularMovieQuery(
    var page: Int
) {
    fun toMap(): HashMap<String, Any> {
        val queryMap = HashMap<String, Any>()
        queryMap["page"] = page
        return queryMap
    }
}
