package kr.co.tjoeun.library_20200713

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    val mContext = this

    abstract fun setValues()
    abstract fun setupEvents()

}