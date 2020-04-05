package com.cristianvillamil.platziwallet.ui.obserbable

interface Observable {
    fun addObserver(observer:   Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers(newValue:Double)
}