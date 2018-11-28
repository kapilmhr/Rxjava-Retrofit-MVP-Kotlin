package app.frantic.rxjavamvpkotlin.presenter

import app.frantic.rxjavamvpkotlin.FlowerContract
import app.frantic.rxjavamvpkotlin.network.RestApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class FlowerPresenter(val mainView:FlowerContract.MainView): FlowerContract.MainPresenter{

    var disposable: Disposable? = null

    override fun fetchFlowers() {
//        disposable = RestApi.instance.getListOfFlower()
        disposable = RestApi.instance.requestAPI.getFlowerList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe ({
                mainView.onSuccess(it)
            },{
                mainView.onError(it.message!!)
            })
    }

    override fun onStop() {
        if (disposable!=null){
            disposable!!.dispose()
        }
    }
}