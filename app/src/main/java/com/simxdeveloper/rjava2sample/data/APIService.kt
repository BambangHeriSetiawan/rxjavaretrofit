package com.simxdeveloper.rjava2sample.data

import com.simxdeveloper.rjava2sample.model.ResponseListMovie
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

/**
 * User: simx
 * Date: 30/04/18 14:22
 */
interface APIService {
    @GET("movie/now_playing")
    fun getList(@Query("api_key") api_key:String):Observable<ResponseListMovie>

    @GET("movie/list")
    fun getLatest(@Query("api_key") api_key:String):Observable<ResponseListMovie>

}