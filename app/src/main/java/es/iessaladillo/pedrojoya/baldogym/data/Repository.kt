package es.iessaladillo.pedrojoya.baldogym.data

import es.iessaladillo.pedrojoya.baldogym.data.entity.TrainingSession

interface Repository {

    /*Nos devuelve toda la lista de actividades segun el dia en que estemos*/
    fun  queryAllActivities():List<TrainingSession>

    /*Son los metodos para filtar segun por dia*/
    fun filterMonday(): List<TrainingSession>
    fun filterTuesday(): List<TrainingSession>
    fun filterWednesday(): List<TrainingSession>
    fun filterThursday(): List<TrainingSession>
    fun filterFriday(): List<TrainingSession>
    fun filterSaturday(): List<TrainingSession>
    fun filterSunday(): List<TrainingSession>
    fun putInfo(idActivity: Integer): TrainingSession
    fun getTrining(): TrainingSession
    fun PutTrining(position: Number)
    // TODO

}