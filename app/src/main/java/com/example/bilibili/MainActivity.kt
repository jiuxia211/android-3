package com.example.bilibili

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val upList = ArrayList<Up>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUp()
        val layoutManager =LinearLayoutManager(this)
        layoutManager.orientation =LinearLayoutManager.HORIZONTAL
        recycleView.layoutManager =layoutManager
        val adapter =UpAdapter(upList,text1,image1)
        recycleView.adapter =adapter
    }
    private fun initUp(){
        upList.add(Up("嘉然今天吃什么",R.drawable.jiaran))
        upList.add(Up("冰糖IO",R.drawable.bingtang))
        upList.add(Up("向晚大魔王",R.drawable.xiangwan))
        upList.add(Up("咩栗",R.drawable.mieli))
        upList.add(Up("多多poi",R.drawable.duoduo))
        upList.add(Up("阿梓从小就很可爱",R.drawable.azi))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            1->if (resultCode== AppCompatActivity.RESULT_OK){
                val unFollowIndex = data?.getIntExtra("unFollowIndex",-1)
                if (unFollowIndex != null) {
                    upList.removeAt(unFollowIndex)
                    recycleView.adapter?.notifyDataSetChanged()//留有一点bug 取关后视频动态还留在屏幕上
                }
            }
        }
    }
}

