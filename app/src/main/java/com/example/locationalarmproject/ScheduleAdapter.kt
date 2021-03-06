package com.example.locationalarmproject

import android.content.Context
import android.graphics.drawable.ClipDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Filter
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter
import java.util.ArrayList
import java.util.jar.Attributes

/**
 * RealmRecyclerViewAdapterクラスの継承
 */
class ScheduleAdapter (data: OrderedRealmCollection<Schedule>) :
    RealmRecyclerViewAdapter<Schedule, ScheduleAdapter.ViewHolder>(data,true){

    private var listener: ((Long?)-> Unit)? = null

    fun setOnItemClickListener(listener:(Long?)-> Unit){
        this.listener = listener
    }


    init {
        setHasStableIds(true)
    }

    class ViewHolder(cell: View) : RecyclerView.ViewHolder(cell){
        val date: TextView = cell.findViewById(android.R.id.text1)
        val title: TextView = cell.findViewById(android.R.id.text1)
        val detail:TextView = cell.findViewById(android.R.id.text2)

    }

    /**
     * セルが必要になるたびに呼び出される
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(android.R.layout.simple_expandable_list_item_2,
            parent, false)
        return ViewHolder(view)


    }

    override fun onBindViewHolder(
        holder: ScheduleAdapter.ViewHolder,
        position: Int) {
        val schedule: Schedule? = getItem(position)

        holder.title.text = schedule?.title
        holder.detail.text = schedule?.detail
        holder.itemView.setOnClickListener {
            listener?.invoke(schedule?.id)
        }

    }

    override fun getItemId(position: Int): Long {
        return getItem(position)?.id ?: 0
    }







}