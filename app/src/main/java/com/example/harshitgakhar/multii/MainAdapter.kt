package com.example.harshitgakhar.multii

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_row.view.*

/**
 * Created by harshit gakhar on 17-02-2019.
 */
class MainAdapter(val home: Home):RecyclerView.Adapter<CustomViewHolder>()
{
    val itemtitle = listOf("joke1","joke2","joke3","joke4")
    override fun getItemCount(): Int {
        return home.value.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
    val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow =  layoutInflater.inflate(R.layout.item_row,parent,false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
  // val itemtitle= itemtitle.get(position)
        val videoo= home.value.get(position)
        holder?.view?.joke?.text = videoo.joke
     }
}
class CustomViewHolder(val view: View):RecyclerView.ViewHolder(view)
{

}