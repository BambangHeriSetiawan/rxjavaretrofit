package com.simxdeveloper.rjava2sample.data;

import com.simxdeveloper.rjava2sample.data.ApiService;
import com.simxdeveloper.rjava2sample.model.ResponseListMovie;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * User: simx Date: 30/04/18 13:19
 */
public class RepositoryService {
  public static Observable<ResponseListMovie> getListMovie(){
    return ApiService.Factory.create ().getListMovie ("8bd5fd5cf00be94f16916661aac61163")
        .subscribeOn (Schedulers.newThread ())
        .observeOn (AndroidSchedulers.mainThread ());
  }
  public static Observable<ResponseListMovie> getLastMovie(){
    return ApiService.Factory.create ().getListMovie ("8bd5fd5cf00be94f16916661aac61163")
        .subscribeOn (Schedulers.newThread ())
        .observeOn (AndroidSchedulers.mainThread ());
  }
}
