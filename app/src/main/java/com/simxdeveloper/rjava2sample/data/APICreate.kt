package com.simxdeveloper.rjava2sample.data

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.simxdeveloper.rjava2sample.model.ResponseListMovie
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import java.util.logging.Level

/**
 * User: simx
 * Date: 30/04/18 14:30
 */
class APICreate {

    val gson: Gson = GsonBuilder().create()
    val client:OkHttpClient = OkHttpClient.Builder()
            .readTimeout(1,TimeUnit.MINUTES)
            .writeTimeout(1,TimeUnit.MINUTES)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor { chain ->
                val origin:Request = chain.request();
                val request:Request = origin
                        .newBuilder()
                        .header("Accept","application/json")
                        .header("Content-Type","multipart/from-data")
                        .build()
                return@addInterceptor  chain.proceed(request)
            }
            .build()
    val retrofit: Retrofit = Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://api.themoviedb.org/3/")
            .client(client)
            .build()
    val service:APIService = retrofit.create(APIService::class.java)
    fun api ():APIService {
        return service
    }

    open fun listMovieObservable ():Observable<ResponseListMovie>{
        return api().getList("8bd5fd5cf00be94f16916661aac61163").subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
    }

    open fun listMovieLastestObservable():Observable<ResponseListMovie>{
        return api().getList("8bd5fd5cf00be94f16916661aac61163").subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
    }

}