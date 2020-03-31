package id.kotlin.moviedb

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity: AppCompatActivity(), HomeView{

    //private lateinit var progressBar: ProgressBar
    //private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //progressBar = findViewById(R.id.pb_home)
        //recyclerView = findViewById(R.id.rv_home)

        val presenter = HomePresenter(this)
        presenter.discoverMovie()
    }

    override fun onShowLoading() {
        // kotlin android ext
        pb_home.visibility = View.VISIBLE
        //progressBar.visibility = View.VISIBLE
    }

    override fun onHideLoading() {
        pb_home.visibility = View.GONE
        rv_home.visibility = View.VISIBLE
        //progressBar.visibility = View.GONE
        //recyclerView.visibility = View.VISIBLE
    }

    override fun onResponse(result: List<Result>) {
        rv_home.addItemDecoration(DividerItemDecoration(this@HomeActivity, DividerItemDecoration.VERTICAL))
        rv_home.adapter = HomeAdapter(result)
        //recyclerView.addItemDecoration(DividerItemDecoration(this@HomeActivity, DividerItemDecoration.VERTICAL))
        //recyclerView.adapter = HomeAdapter(result)
    }

    override fun onFailure(error: Throwable) {
        Log.e(HomeActivity::class.java.simpleName, "${error.printStackTrace()}")
    }
}