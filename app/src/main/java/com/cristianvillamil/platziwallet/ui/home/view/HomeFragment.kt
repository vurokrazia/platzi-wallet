package com.cristianvillamil.platziwallet.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cristianvillamil.platziwallet.R
import com.cristianvillamil.platziwallet.ui.home.FavoriteTransfer
import com.cristianvillamil.platziwallet.ui.home.HomeContract
import com.cristianvillamil.platziwallet.ui.home.data.MessageFactory
import com.cristianvillamil.platziwallet.ui.home.data.MessageFactory.Companion.TYPE_ERROR
import com.cristianvillamil.platziwallet.ui.home.presenter.HomePresenter
import com.cristianvillamil.platziwallet.ui.obserbable.AvailableBalanceObservable
import androidx.lifecycle.Observer
import com.cristianvillamil.platziwallet.ui.home.data.MessageFactory.Companion.TYPE_SUCCESS
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View {
    private var homePresenter: HomeContract.Presenter? = null
    private val availableBalanceObservable = AvailableBalanceObservable()
    override fun showLoader() {
        homeLoader.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        homeLoader.visibility = View.GONE
    }

    override fun showFavoriteTransfers(favoriteTransfer: List<FavoriteTransfer>) {
        favoriteTransferAdapter.setData(favoriteTransfer)
        val dialogFactory = MessageFactory()
        context?.let {
            val errorDialog = dialogFactory.getDialog(it, TYPE_SUCCESS)
            errorDialog.show()
        }
    }

    private val favoriteTransferAdapter =
        FavoriteTransferAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        homePresenter = HomePresenter(this)
        homePresenter?.retrieveFavoriteTransfers()
        circularProgress.setProgressWithAnimation(
            70f,
            1000,
            AccelerateDecelerateInterpolator(),
            500
        )
        Picasso
            .get()
            .load("https://media.licdn.com/dms/image/C4E03AQFcCuDIJl0mKg/profile-displayphoto-shrink_200_200/0?e=1583366400&v=beta&t=ymt3xgMe5bKS-2knNDL9mQYFksP9ZHne5ugIqEyRjZs")
            .into(profilePhotoImageView)
        /*
            availableBalanceObservable.addObserver(object : Observer {
                override fun notifyChange(newValue: Double) {
                    amountValueTextView.text = "$ $newValue"
                }
            })
        */
        homePresenter!!.getPercentageLiveData().observe(this, Observer<String> { value ->
            percentageText.text = value
        })
        //#percentageText
    }

    private fun initRecyclerView() {
        favoriteTransfersRecyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        favoriteTransfersRecyclerView.adapter = favoriteTransferAdapter
    }
}