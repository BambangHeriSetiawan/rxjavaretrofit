package com.simxdeveloper.rjava2sample.model

import com.google.gson.annotations.SerializedName


class ResultsItem {

    @SerializedName("overview")
    var overview: String? = null

    @SerializedName("original_language")
    var originalLanguage: String? = null

    @SerializedName("original_title")
    var originalTitle: String? = null

    @SerializedName("video")
    var isVideo: Boolean = false

    @SerializedName("title")
    var title: String? = null

    @SerializedName("genre_ids")
    var genreIds: List<Int>? = null

    @SerializedName("poster_path")
    var posterPath: String? = null

    @SerializedName("backdrop_path")
    var backdropPath: String? = null

    @SerializedName("release_date")
    var releaseDate: String? = null

    @SerializedName("vote_average")
    var voteAverage: Double = 0.toDouble()

    @SerializedName("popularity")
    var popularity: Double = 0.toDouble()

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("adult")
    var isAdult: Boolean = false

    @SerializedName("vote_count")
    var voteCount: Int = 0

    override fun toString(): String {
        return "ResultsItem{" +
                "overview = '" + overview + '\''.toString() +
                ",original_language = '" + originalLanguage + '\''.toString() +
                ",original_title = '" + originalTitle + '\''.toString() +
                ",video = '" + isVideo + '\''.toString() +
                ",title = '" + title + '\''.toString() +
                ",genre_ids = '" + genreIds + '\''.toString() +
                ",poster_path = '" + posterPath + '\''.toString() +
                ",backdrop_path = '" + backdropPath + '\''.toString() +
                ",release_date = '" + releaseDate + '\''.toString() +
                ",vote_average = '" + voteAverage + '\''.toString() +
                ",popularity = '" + popularity + '\''.toString() +
                ",id = '" + id + '\''.toString() +
                ",adult = '" + isAdult + '\''.toString() +
                ",vote_count = '" + voteCount + '\''.toString() +
                "}"
    }
}