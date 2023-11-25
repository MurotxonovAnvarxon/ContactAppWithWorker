package com.example.contactappwithworker.presenter.add


interface AddContract {
    interface ViewModel{
        fun onEventDispatcher(intent: Intent)
    }
//    data class UIState()

    interface Intent{
        data class AddButtonClick(val firstName : String, val lastName : String, val phone : String) :
            Intent
    }

}