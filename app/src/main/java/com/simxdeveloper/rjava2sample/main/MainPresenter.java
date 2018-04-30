package com.simxdeveloper.rjava2sample.main;

import com.simxdeveloper.rjava2sample.model.ResponseListMovie; /**
 * User: simx Date: 30/04/18 13:11
 */
public interface MainPresenter {

  void showData (ResponseListMovie responseListMovie);

  void showError (String message);

  void showLastMovie (ResponseListMovie responseListMovie);

}
