package com.example.dagger2.ui.auth

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.example.dagger2.R
import com.example.dagger2.SessionManager
import com.example.dagger2.viewModels.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {


    @Inject
    lateinit var viewModel: AuthViewModel

    @Inject
    lateinit var logo: Drawable

    @Inject
    lateinit var requestManager: RequestManager

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory


    @Inject
    lateinit var sessionManager: SessionManager
    lateinit var idFromUser: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        viewModel = ViewModelProvider(this, providerFactory).get(viewModel::class.java)

        setImageManager()



        sessionManager.authUser.observe(this, Observer {

            it.let {
                println("debug is : ${it.id}")
            }

        })


        login_button.setOnClickListener({

            idFromUser = user_id_input.text.toString()

            idFromUser.let {
                val result = it.toInt()

                viewModel.authWithId(result)
            }

        })

    }



    private fun setImageManager() {

        requestManager.load(logo)
            .into(login_logo)
    }
}
