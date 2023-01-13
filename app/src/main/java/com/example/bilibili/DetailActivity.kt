package com.example.bilibili

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.up.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val upName =intent.getStringExtra("upName")
        when(upName){
            "嘉然今天吃什么"->{
                bigHead.setImageResource(R.drawable.jiaran)
                upNameIn.text=upName
                fansNum.text="171.0万"
            }
            "向晚大魔王"->{
                bigHead.setImageResource(R.drawable.xiangwan)
                upNameIn.text=upName
                fansNum.text="58.4万"
            }
            "冰糖IO"->{
                bigHead.setImageResource(R.drawable.bingtang)
                upNameIn.text=upName
                fansNum.text="144.6万"
            }
            "阿梓从小就很可爱"->{
                bigHead.setImageResource(R.drawable.azi)
                upNameIn.text=upName
                fansNum.text="74.4万"
            }
            "咩栗"->{
                bigHead.setImageResource(R.drawable.mieli)
                upNameIn.text=upName
                fansNum.text="86.9万"
            }
            "多多poi"->{
                bigHead.setImageResource(R.drawable.duoduo)
                upNameIn.text=upName
                fansNum.text="260.5万"
            }
        }
        unFollow.setOnClickListener {
            val intent =Intent()
            when(upName){
                "嘉然今天吃什么"->{
                    intent.putExtra("unFollowIndex",0)
                }
                "向晚大魔王"->{
                    intent.putExtra("unFollowIndex",2)
                }
                "冰糖IO"->{
                    intent.putExtra("unFollowIndex",1)
                }
                "阿梓从小就很可爱"->{
                    intent.putExtra("unFollowIndex",5)
                }
                "咩栗"->{
                    intent.putExtra("unFollowIndex",3)
                }
                "多多poi"->{
                    intent.putExtra("unFollowIndex",4)
                }
            }

            setResult(RESULT_OK,intent)
            finish()
        }
    }
}