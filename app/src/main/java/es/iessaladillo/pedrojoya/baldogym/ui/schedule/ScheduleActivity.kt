package es.iessaladillo.pedrojoya.baldogym.ui.schedule

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.iessaladillo.pedrojoya.baldogym.R
import es.iessaladillo.pedrojoya.baldogym.data.LocalRepository
import es.iessaladillo.pedrojoya.baldogym.data.entity.TrainingSession
import es.iessaladillo.pedrojoya.baldogym.ui.trainingsession.TrainingSessionActivity
import kotlinx.android.synthetic.main.schedule_activity.*
import kotlinx.android.synthetic.main.training_session_activity.*

class ScheduleActivity : AppCompatActivity() {


    private lateinit var currentActivity: TrainingSession

    private val viewModel : SheduleActivityViewModel by viewModels{
        SheduleActivityViewModelFactory(
            LocalRepository,
            application
        )
    }

    private val listAdapter: SheduleActivityAdapter = SheduleActivityAdapter()
        .also {
            /*it.onItemClickListener = { position ->
                goInfo(position)
            }*/
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.schedule_activity)
        setupViews()
        observerViewModelData()
    }

    private fun observerViewModelData() {
        viewModel.activities.observe(this) {
            showActivities(it)
        }
    }



    private fun setupViews() {
        setupRecyclerView()
        onOptionsItemSelected()
    }




    fun onOptionsItemSelected() {
            btnMon.setOnClickListener { viewModel.filterMon() }
            btnTus.setOnClickListener{viewModel.filterTus()}
            btnWed.setOnClickListener {viewModel.filterWed()}
            btnThur.setOnClickListener {viewModel.filterThur()}
            btnFri.setOnClickListener {viewModel.filterFri()}
            btnSatur.setOnClickListener {viewModel.filterSatur()}
            btnSund.setOnClickListener {viewModel.filterSund()}
    }


    private fun setupRecyclerView() {
        lstActivities.run {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            itemAnimator = DefaultItemAnimator()
            adapter = listAdapter
        }
    }

    private fun showActivities(activities: List<TrainingSession>) {
        lstActivities.post {
            listAdapter.submitList(activities)
            invisibleUnless(activities.isEmpty())
        }
    }

    private fun invisibleUnless(condition: Boolean) {
        lblEmptyView.visibility = if (condition) View.VISIBLE else View.INVISIBLE
    }


}
