package com.brainotek.wowmylawn.koin.module

import com.brainotek.wowmylawn.viewModel.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val ViewModelModule = module {

    /**
     * The viewModel keyword helps declaring a factory instance of ViewModel. [UserViewModel]
     * This instance will be handled by internal ViewModelFactory
     * and reattach [UserViewModel] ViewModel instance if needed.
     */
    viewModel {
        UserViewModel()
    }
}