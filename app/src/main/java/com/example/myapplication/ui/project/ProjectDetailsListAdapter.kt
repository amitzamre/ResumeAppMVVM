package com.example.myapplication.ui.project

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.local.projects.Project

class ProjectDetailsListAdapter(private val projectList:List<Project>) :RecyclerView.Adapter<ProjectDetailsListAdapter.ProjectDetailsViewHolder>(){

    class ProjectDetailsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val projectName: TextView =itemView.findViewById(R.id.project_title)
        val decription: TextView=itemView.findViewById(R.id.decription)
        val duration: TextView=itemView.findViewById(R.id.duration)
        val role: TextView=itemView.findViewById(R.id.role)
        val expandableLayout: ConstraintLayout = itemView.findViewById(R.id.expandableLayout)

    }

    /**
     * Called when RecyclerView needs a new [ViewHolder] of the given type to represent
     * an item.
     *
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     *
     *
     * The new ViewHolder will be used to display items of the adapter using
     * [.onBindViewHolder]. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary [View.findViewById] calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     * an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see .getItemViewType
     * @see .onBindViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectDetailsViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.project_details_list,parent,false)
        return ProjectDetailsViewHolder(itemView)
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the [ViewHolder.itemView] to reflect the item at the given
     * position.
     *
     *
     * Note that unlike [android.widget.ListView], RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the `position` parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use [ViewHolder.getBindingAdapterPosition] which
     * will have the updated adapter position.
     *
     * Override [.onBindViewHolder] instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: ProjectDetailsViewHolder, position: Int) {
        try{
            val currentItem=projectList[position]
            holder.projectName.text=currentItem.projectName
            holder.decription.text=currentItem.decription
            holder.duration.text=currentItem.duration
            holder.role.text=currentItem.role
            val isExpanded: Boolean = currentItem.isExpanded
            holder.expandableLayout.visibility = if (isExpanded) VISIBLE else GONE
            holder.projectName.setOnClickListener {
                currentItem.isExpanded = ! currentItem.isExpanded
                notifyItemChanged(position)
            }
        }catch (e:Exception){
            Log.e("Error settingtemplate","${e.printStackTrace()}")
        }

    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount()=projectList.size

}