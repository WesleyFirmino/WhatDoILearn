package com.devventurus.whatdoilearn.DI

import com.devventurus.whatdoilearn.data.LearnedItemRepository
import com.devventurus.whatdoilearn.data.database.LearnedItemDataBase
import com.devventurus.whatdoilearn.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


object LearnedItemModule {
    val module = module {
        factory {
            CoroutineScope(Dispatchers.IO)
        }
        factory {
            LearnedItemRepository(get())
        }
        single {
            LearnedItemDataBase.getDatabase(get(), get())
        }
        single {
            get<LearnedItemDataBase>().learnedItemDao()
        }
        viewModel { MainViewModel(get()) }
    }
}