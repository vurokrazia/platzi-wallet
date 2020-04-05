package com.cristianvillamil.platziwallet.ui.home.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cristianvillamil.platziwallet.UserSingleton
import com.cristianvillamil.platziwallet.ui.home.FavoriteTransfer
import com.cristianvillamil.platziwallet.ui.home.HomeContract
import com.cristianvillamil.platziwallet.ui.home.data.HomeIterator
import com.cristianvillamil.platziwallet.ui.home.data.User

class HomePresenter(private val view:HomeContract.View) : HomeContract.Presenter {
    private val homeIterator = HomeIterator()
    private val percentageLiveData : MutableLiveData<String> = MutableLiveData()
    override fun retrieveFavoriteTransfers() {
        view.showLoader()
        homeIterator.retrieveFavoriteTransferFromCache(object :HomeContract.OnResponseCallback{
            override fun onResponse(favoriteList: List<FavoriteTransfer>) {
                var user = User.Builder()
                    .setUserName("Yisus")
                    .setPassword("")
                percentageLiveData.value = "40%"
                view.hideLoader()
                view.showFavoriteTransfers(favoriteList)
            }

        })
    }
    override fun getPercentageLiveData(): LiveData <String> = percentageLiveData
}
