package es.iessaladillo.pedrojoya.baldogym.ui.trainingsession

import android.content.Context
import android.content.Intent
import android.nfc.NfcAdapter.EXTRA_ID
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import es.iessaladillo.pedrojoya.baldogym.R
import es.iessaladillo.pedrojoya.baldogym.data.LocalRepository
import es.iessaladillo.pedrojoya.baldogym.data.entity.TrainingSession
import es.iessaladillo.pedrojoya.baldogym.ui.schedule.SheduleActivityViewModel
import es.iessaladillo.pedrojoya.baldogym.ui.schedule.SheduleActivityViewModelFactory

class TrainingSessionActivity : AppCompatActivity() {

/*
    private var currentActivity: TrainingSession by lazy { createInfo() }
*/


    private val viewModel : SheduleActivityViewModel by viewModels{
        SheduleActivityViewModelFactory(
            LocalRepository,
            application
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.training_session_activity)
        createInfo()
    }

    private fun createInfo(): TrainingSession {
        var newActivity = viewModel.getTraining().copy()
        return newActivity
    }




}
