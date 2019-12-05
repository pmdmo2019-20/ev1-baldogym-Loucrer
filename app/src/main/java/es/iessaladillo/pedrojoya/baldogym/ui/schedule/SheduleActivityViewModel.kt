package es.iessaladillo.pedrojoya.baldogym.ui.schedule

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.baldogym.data.Repository
import es.iessaladillo.pedrojoya.baldogym.data.entity.TrainingSession
import es.iessaladillo.pedrojoya.baldogym.data.entity.WeekDay
import es.iessaladillo.pedrojoya.baldogym.data.entity.getCurrentWeekDay

class SheduleActivityViewModel(private val repository: Repository, private val application: Application) : ViewModel(){

    private val _activities: MutableLiveData<List<TrainingSession>> = MutableLiveData()
    val activities: LiveData<List<TrainingSession>>//El liveData donde la actividad observara.
        get() = _activities



    private val _currentFilter: MutableLiveData<WeekDay> =
        MutableLiveData(WeekDay.MONDAY)


    init {
        _currentFilter.value = getCurrentWeekDay()
        queryActivities(_currentFilter.value!!)
    }


    private fun queryActivities(filter: WeekDay) {
        when (filter) {
            WeekDay.MONDAY ->
                refreshLists(repository.filterMonday())
            WeekDay.TUESDAY ->
                refreshLists(repository.filterTuesday())
            WeekDay.WEDNESDAY ->
                refreshLists(repository.filterWednesday())
            WeekDay.THURSDAY ->
                refreshLists(repository.filterThursday())
            WeekDay.FRIDAY ->
                refreshLists(repository.filterFriday())
            WeekDay.SATURDAY ->
                refreshLists(repository.filterSaturday())
            WeekDay.FRIDAY ->
                refreshLists(repository.filterSunday())
        }
    }


    private fun refreshLists(newList: List<TrainingSession>) {
        _activities.value = newList.sortedByDescending { it.id }
    }

    fun getTraining(): TrainingSession{
       return repository.getTrining()
    }

    fun PutTraining(position: Number) {
        repository.PutTrining(position)
    }

    fun filterMon() {
        refreshLists(repository.filterMonday())
    }

    fun filterTus() {
        refreshLists(repository.filterTuesday())
    }

    fun filterWed() {
        refreshLists(repository.filterWednesday())
    }

    fun filterThur() {
        refreshLists(repository.filterThursday())
    }

    fun filterFri() {
        refreshLists(repository.filterFriday())
    }

    fun filterSatur() {
        refreshLists(repository.filterSaturday())
    }

    fun filterSund() {
        refreshLists(repository.filterSunday())
    }


}