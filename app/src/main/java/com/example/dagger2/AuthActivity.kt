package com.example.dagger2

import android.graphics.drawable.Drawable
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.RequestManager
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import kotlin.math.log

class AuthActivity : DaggerAppCompatActivity() {


    @Inject
    lateinit var logo: Drawable
    @Inject
    lateinit var requestManager: RequestManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        setImageManager()
    }

    private fun setImageManager() {

        requestManager.load(logo)
            .into(R.id.login_logo as ImageView)
    }
}
