package kr.co.tjoeun.library_20200713

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile_photo.*

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

        val imgUrl = "https://lh3.googleusercontent.com/proxy/zohuDN_imkYt9xNIGRkdRfiZLH6hUer1r3Z6s3wjj3vtgMIhe61iwzJA0f3jPjGIViapUVHKM1nWsHXw_etzgIpJzvrIyVosSLxacmKVLU_qpYNFiHAriYRABaLGRo4"
        Glide.with(mContext).load(imgUrl).into(profileImg)

    }

    override fun setupEvents() {
    }
}