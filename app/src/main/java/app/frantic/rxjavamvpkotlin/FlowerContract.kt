package app.frantic.rxjavamvpkotlin

import app.frantic.rxjavamvpkotlin.model.Flower
import retrofit2.Response

interface FlowerContract{
    interface MainView{
        fun onSuccess(flowerList: List<Flower>)
        fun onError(error: String)

    }

    interface MainPresenter {
        fun fetchFlowers()
        fun onStop()
    }

}