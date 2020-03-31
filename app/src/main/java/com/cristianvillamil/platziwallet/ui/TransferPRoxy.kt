package com.cristianvillamil.platziwallet.ui

class TransferPRoxy {
    val MAX_TRANFER_AMOUNT = 1000000
    val MIN_TRANSFER_AMOUNT = 100
    fun checkTransfer(amount: Double) : String {
        return when {
            amount > MAX_TRANFER_AMOUNT -> {
                "Excede el monto"
            }
            amount < MIN_TRANSFER_AMOUNT -> {
                "Monto minimo"
            }
            else ->{
                doTransfer(amount)
                return "Transferencia realizada"
            }
        }
    }
    private fun doTransfer(amount: Double){

    }
}