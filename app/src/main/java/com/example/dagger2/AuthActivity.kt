package com.example.dagger2

import android.graphics.drawable.Drawable
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.widget.ImageViewCompat
import com.bumptech.glide.RequestManager
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
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
            .into(login_logo)
    }
}
