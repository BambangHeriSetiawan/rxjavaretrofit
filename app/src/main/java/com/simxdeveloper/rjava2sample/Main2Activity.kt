package com.simxdeveloper.rjava2sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.simxdeveloper.rjava2sample.data.APICreate

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var apiCreate:APICreate = APICreate()
        var surs = apiCreate.listMovieLastestObservable().subscribe(
                {
                    Log.d("",it.toString())
                },{
            Log.d("",it.toString())
        }
        )

    }
}
