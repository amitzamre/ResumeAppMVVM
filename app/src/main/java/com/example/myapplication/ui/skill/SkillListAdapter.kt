package com.example.myapplication.ui.skill

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.local.skills.Skill

class SkillListAdapter(private val skillList:List<Skill>):RecyclerView.Adapter<SkillListAdapter.SkillViewHolder>() {

    class SkillViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val skillName:TextView=itemView.findViewById(R.id.skill_details)
        var skilRating:RatingBar=itemView.findViewById(R.id.skillRatingBar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        val iteView=LayoutInflater.from(parent.context).inflate(R.layout.skills_details_list,parent,false)
        return SkillViewHolder(iteView)
    }

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        val currentItem=skillList[position]
        holder.skilRating.numStars=currentItem.skillrating.toInt()
        Log.d("skill rating","${currentItem.skillrating.toInt()}")
        holder.skillName.text=currentItem.skillname
        Log.d("skill rating","${currentItem.skillname}")

    }

    override fun getItemCount()=skillList.size
}