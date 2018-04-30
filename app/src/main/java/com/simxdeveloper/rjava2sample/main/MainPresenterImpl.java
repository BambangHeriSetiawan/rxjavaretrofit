package com.simxdeveloper.rjava2sample.main;

import com.simxdeveloper.rjava2sample.data.RepositoryService;
import io.reactivex.disposables.CompositeDisposable;

/**
 * User: simx Date: 30/04/18 13:11
 */
public class MainPresenterImpl {
  private MainPresenter presenter;
  private CompositeDisposable disposable;
  public MainPresenterImpl (MainPresenter presenter) {
    this.presenter = presenter;
    this.disposable = new CompositeDisposable ();
  }

  public void getListMovie () {
    disposable.add (RepositoryService.getListMovie ().subscribe (
        responseListMovie -> presenter.showData(responseListMovie),
        throwable -> presenter.showError(throwable.getMessage ())
    ));
  }
  public void dispose(){
    disposable.dispose ();
  }

  public void getLastMovie () {
    disposable.add (RepositoryService.getLastMovie ().subscribe (
        responseListMovie -> presenter.showLastMovie(responseListMovie),
        throwable -> presenter.showError (throwable.getMessage ())
    ));
  }
}
