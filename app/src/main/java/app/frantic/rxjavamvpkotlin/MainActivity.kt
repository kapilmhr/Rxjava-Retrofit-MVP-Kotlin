package app.frantic.rxjavamvpkotlin

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import app.frantic.rxjavamvpkotlin.adapter.FlowerAdapter
import app.frantic.rxjavamvpkotlin.model.Flower
import app.frantic.rxjavamvpkotlin.presenter.FlowerPresenter

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),FlowerContract.MainView {
    lateinit var presenter:FlowerPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = FlowerPresenter(this)
        presenter.fetchFlowers()
    }

    override fun onSuccess(flowerList: List<Flower>) {

        recyclerView.adapter = FlowerAdapter(flowerList)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    override fun onError(error: String) {
        print("error: ${error}")
        Log.d("error",error+" --- ")
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

}
