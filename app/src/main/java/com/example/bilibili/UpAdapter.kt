package com.example.bilibili

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class UpAdapter(val upList: List<Up>, private val textView: TextView, private val imageView: ImageView) :
    RecyclerView.Adapter<UpAdapter.ViewHolder>(){
        inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
            val upHeadPicture:ImageView =view.findViewById(R.id.upHeadPicture)
            val upName:TextView =view.findViewById(R.id.upName)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(parent.context)
            .inflate(R.layout.up,parent,false)
        val viewHolder =ViewHolder(view)
        viewHolder.itemView.setOnClickListener{
            val position =viewHolder.adapterPosition
            val up =upList[position]
            when(up.name){
                "嘉然今天吃什么"->{
                    textView.text=up.name+"的视频动态"
                    imageView.setImageResource(R.drawable.jiaranp)
                }
                "向晚大魔王"->{
                    textView.text=up.name+"的视频动态"
                    imageView.setImageResource(R.drawable.xiangwanp)
                }
                "冰糖IO"->{
                    textView.text=up.name+"的视频动态"
                    imageView.setImageResource(R.drawable.bingtangp)
                }
                "阿梓从小就很可爱"->{
                    textView.text=up.name+"的视频动态"
                    imageView.setImageResource(R.drawable.azip)
                }
                "咩栗"->{
                    textView.text=up.name+"的视频动态"
                    imageView.setImageResource(R.drawable.mielip)
                }
                "多多poi"->{
                    textView.text=up.name+"的视频动态"
                    imageView.setImageResource(R.drawable.duoduop)
                }
            }

        }
        viewHolder.itemView.setOnLongClickListener {
            val position =viewHolder.adapterPosition
            val up =upList[position]
            val intent = Intent(parent.context,DetailActivity::class.java).apply {
                putExtra("upName",up.name)
            }
            val activity =parent.context as Activity
            activity.startActivityForResult(intent,1)
            true
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val up =upList[position]
        holder.upHeadPicture.setImageResource(up.headPicture)
        holder.upName.text=up.name
    }

    override fun getItemCount(): Int {
        return upList.size
    }

}

