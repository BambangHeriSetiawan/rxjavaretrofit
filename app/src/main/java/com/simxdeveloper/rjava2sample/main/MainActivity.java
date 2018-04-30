package com.simxdeveloper.rjava2sample.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.simxdeveloper.rjava2sample.R;
import com.simxdeveloper.rjava2sample.data.APICreate;
import com.simxdeveloper.rjava2sample.model.ResponseListMovie;

public class MainActivity extends AppCompatActivity implements MainPresenter {
  private MainPresenterImpl presenter;
  TextView tvSample;
  @Override
  protected void onCreate (Bundle savedInstanceState) {
    super.onCreate (savedInstanceState);
    setContentView (R.layout.activity_main);
    tvSample = findViewById (R.id.tv_sample);
    presenter = new MainPresenterImpl (this);
    presenter.getListMovie();
    presenter.getLastMovie();

  }

  @Override
  public void showData (ResponseListMovie responseListMovie) {
    tvSample.setText (responseListMovie.toString ());
  }

  @Override
  public void showError (String message) {
    tvSample.setText (message);
  }

  @Override
  public void showLastMovie (ResponseListMovie responseListMovie) {
    Log.e ("MainActivity", "showLastMovie: " + responseListMovie.toString ());
  }

  @Override
  protected void onDestroy () {
    super.onDestroy ();
    presenter.dispose ();
  }
}
