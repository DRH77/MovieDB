package id.kotlin.moviedb

import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Response
import javax.security.auth.callback.Callback

class HomeActivity: AppCompatActivity(), HomeView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressBar = findViewById<ProgressBar>(R.id.pb_home)

        val dataSource = NetworkProvider.providesHttpAdapter().create(HomeDataSource::class.java)
        dataSource.discoverMovie().enqueue(object : retrofit2.Callback<HomeResponse>{
            override fun onResponse(call: retrofit2.Call<HomeResponse>, response: Response<HomeResponse>
            ) {
                progressBar.visibility = View.GONE

                val result = response.body()?.results
                val itemAdapter = findViewById<RecyclerView>(R.id.rv_home)
                itemAdapter.addItemDecoration(DividerItemDecoration(this@HomeActivity, DividerItemDecoration.VERTICAL))
                itemAdapter.adapter = HomeAdapter(result?: emptyList())
            }
            override fun onFailure(call: retrofit2.Call<HomeResponse>, t:Throwable){
                Log.e(HomeActivity::class.java.simpleName, "${t.printStackTrace()}")
            }
        })
    }

    override fun onShowLoading() {

    }

    override fun onHideLoading() {
        TODO("Not yet implemented")
    }

    override fun onResponse(result: List<Result>) {
        TODO("Not yet implemented")
    }

    override fun onFailure(error: Throwable) {
        TODO("Not yet implemented")
    }
}