package kr.co.tjoeun.library_20200713

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
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

        val imgUrl = "https://i.pinimg.com/736x/0b/2f/8a/0b2f8a51314ab1ebe0505aee843a33b1.jpg"
        Glide.with(mContext).load(imgUrl).into(profileImg)

    }

    override fun setupEvents() {

        callBtn.setOnClickListener {

//            TedPermission 을 이용해서 통화 권한을 허락할 것인지 질문!
            val permissionListener = object : PermissionListener{
//                승인을 받은 상황 -> 전화 ok
                override fun onPermissionGranted() {
                    val phoneNum = phoneNumTxt.toString()
                    val myUri = Uri.parse("tel:${phoneNum}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

//                최종 거부된 상황 -> 전화 x
                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {

                    Toast.makeText(mContext, "통화 권한이 거부되어 통화 연결이 불가능합니다.", Toast.LENGTH_SHORT)

                }

            }

//            실제 권한 확인 요청
            TedPermission.with(mContext) //with -> 어느 화면에서 권한을 확인할 것인지
                .setPermissions(Manifest.permission.CALL_PHONE)
                .setDeniedMessage("설정 에서 통화 권한을 허용해주어야 합니다.")
                .setPermissionListener(permissionListener)
                .check()

        }
    }
}