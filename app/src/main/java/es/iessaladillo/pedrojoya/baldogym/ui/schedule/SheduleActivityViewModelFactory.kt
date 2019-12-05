package es.iessaladillo.pedrojoya.baldogym.ui.schedule

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import es.iessaladillo.pedrojoya.baldogym.data.LocalRepository

class SheduleActivityViewModelFactory(val repository: LocalRepository, val application: Application) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = SheduleActivityViewModel(
        repository,
        application
    ) as T
}