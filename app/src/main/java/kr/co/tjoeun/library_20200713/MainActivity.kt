package kr.co.tjoeun.library_20200713

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setValues()
        setupEvents()

        goToPhotoViewBtn.setOnClickListener {
            val myIntent = Intent(mContext, ProfilePhotoActivity::class.java)
            startActivity(myIntent)
        }
    }

    override fun setValues() {

    }

    override fun setupEvents() {
    }
}