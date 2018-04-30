package com.simxdeveloper.rjava2sample.model

import com.google.gson.annotations.SerializedName

open class ResponseListMovie {

    @SerializedName("dates")
    var dates: Dates? = null

    @SerializedName("page")
    var page: Int = 0

    @SerializedName("total_pages")
    var totalPages: Int = 0

    @SerializedName("results")
    var results: List<ResultsItem>? = null

    @SerializedName("total_results")
    var totalResults: Int = 0

    override fun toString(): String {
        return "ResponseListMovie{" +
                "dates = '" + dates + '\''.toString() +
                ",page = '" + page + '\''.toString() +
                ",total_pages = '" + totalPages + '\''.toString() +
                ",results = '" + results + '\''.toString() +
                ",total_results = '" + totalResults + '\''.toString() +
                "}"
    }
}