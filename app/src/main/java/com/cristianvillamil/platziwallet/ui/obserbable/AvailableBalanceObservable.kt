package com.cristianvillamil.platziwallet.ui.obserbable

class AvailableBalanceObservable : Observable {
    private val ammountObserverList: ArrayList<Observer> = arrayListOf()
    private var ammount: Double = 0.0
    fun changeAmmount(newValue: Double){
        ammount = newValue
        notifyObservers(ammount)
    }
    override fun addObserver(observer: Observer) {
        ammountObserverList.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        ammountObserverList.remove(observer)
    }

    override fun notifyObservers(newValue: Double) {
        ammountObserverList.forEach{
            it.notifyChange(newValue)
        }
    }
}