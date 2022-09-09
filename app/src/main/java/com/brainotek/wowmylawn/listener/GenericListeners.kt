package com.brainotek.wowmylawn.listener


interface GenericListeners {

    fun onTapGetStarted() {}

    fun onTapDone(){}

    fun onTapSideDrawer(){}

    fun onTapSelectAddress(){}


    /*
    * When login button click
    * */
    fun onTapLogin() {}

    /**
     * When user click on Back Button
     */
    fun onTapBack() {}

    /*
    * When user click on register
    * */
    fun onTapRegister() {}

    fun createBooking() {}


    /**
     * When User click profile icon
     */
    fun onTapProfile() {}



    fun onTapMyBookings(){}
}