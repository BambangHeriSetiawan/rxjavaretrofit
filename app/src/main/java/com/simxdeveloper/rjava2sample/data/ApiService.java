package com.simxdeveloper.rjava2sample.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.simxdeveloper.rjava2sample.model.ResponseListMovie;
import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * User: simx Date: 30/04/18 13:12
 */
public interface ApiService {

  @GET("movie/now_playing")
  Observable<ResponseListMovie> getListMovie(@Query ("api_key") String apiKey);
  @GET("movie/now_playing")
  Observable<ResponseListMovie> getLastMove(@Query ("api_key") String apiKey);

  class Factory{
    public static ApiService create(){
      return createRetro ("https://api.themoviedb.org/3/").create (ApiService.class);
    }
    private static Gson gson = new GsonBuilder ()
        .setLenient()
        .create();

    public static Retrofit createRetro(String base_url) {
      Retrofit retrofit = new Retrofit.Builder()
          .baseUrl(base_url)
          .addConverterFactory(GsonConverterFactory.create(gson))
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .client(client())
          .build();
      return retrofit;
    }
    private static OkHttpClient client() {
      return new OkHttpClient.Builder()
          .readTimeout(60, TimeUnit.SECONDS)
          .connectTimeout(60, TimeUnit.SECONDS)
          .addInterceptor(new HttpLoggingInterceptor()
              .setLevel(HttpLoggingInterceptor.Level.BODY)
          ).addInterceptor(chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                .header("Accept", "applicaion/json")
                .header("Content-Type", "multipart/form-data")
                .method(original.method(), original.body())
                .build();
            return chain.proceed(request);
          }).build();
    }


  }
}
