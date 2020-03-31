package com.cristianvillamil.platziwallet.ui.home.presenter

import com.cristianvillamil.platziwallet.UserSingleton
import com.cristianvillamil.platziwallet.ui.home.FavoriteTransfer
import com.cristianvillamil.platziwallet.ui.home.HomeContract
import com.cristianvillamil.platziwallet.ui.home.data.HomeIterator
import com.cristianvillamil.platziwallet.ui.home.data.User

class HomePresenter(private val view:HomeContract.View) : HomeContract.Presenter {
    private val homeIterator = HomeIterator()
    override fun retrieveFavoriteTransfers() {
        view.showLoader()
        homeIterator.retriewFavoriteTransferFromCache(object :HomeContract.OnResponseCallback{
            override fun onResponse(favoriteList: List<FavoriteTransfer>) {
                var user = User.Builder()
                    .setUserName("Yisus")
                    .setPassword("")
                view.hideLoader()
                view.showFavoriteTransfers(favoriteList)
            }

        })
    }

}
