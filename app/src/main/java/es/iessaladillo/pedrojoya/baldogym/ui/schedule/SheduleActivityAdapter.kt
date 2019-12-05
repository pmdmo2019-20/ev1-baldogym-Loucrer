package es.iessaladillo.pedrojoya.baldogym.ui.schedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.iessaladillo.pedrojoya.baldogym.R
import es.iessaladillo.pedrojoya.baldogym.data.entity.TrainingSession
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.schedule_activity_item.view.*
import kotlinx.android.synthetic.main.schedule_activity_item.view.btnJoin
import kotlinx.android.synthetic.main.schedule_activity_item.view.lblHourSession
import kotlinx.android.synthetic.main.schedule_activity_item.view.lblNameActivity
import kotlinx.android.synthetic.main.schedule_activity_item.view.lblNumbersParticipants
import kotlinx.android.synthetic.main.schedule_activity_item.view.lblTrainer
import kotlinx.android.synthetic.main.training_session_activity.*

class SheduleActivityAdapter : RecyclerView.Adapter<SheduleActivityAdapter.ViewHolder>() {

    private var data: List<TrainingSession> = emptyList()
    var onItemClickListener: ((Int) -> Unit)? = null

    init {
        setHasStableIds(true)
    }


    override fun getItemId(position: Int): Long = data[position].id

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.schedule_activity_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = data.size



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val activity: TrainingSession = data[position]
        holder.bind(activity)
    }

    fun submitList(newList: List<TrainingSession>) {
        data = newList
        notifyDataSetChanged()
    }

    fun getItem(position: Int): TrainingSession = data[position]


    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),LayoutContainer {

        init {
            containerView.setOnClickListener { onItemClickListener?.invoke(adapterPosition) }
        }

        fun bind(activity: TrainingSession) {
            activity.run {
                containerView.img.setImageResource(photoResId)
                containerView.lblHourSession.text = time
                containerView.lblNameActivity.text = name
                containerView.lblTrainer.text = trainer
                containerView.lblRoom.text = room
                containerView.lblNumbersParticipants.text = participants.toString()
            }
        }
    }
}