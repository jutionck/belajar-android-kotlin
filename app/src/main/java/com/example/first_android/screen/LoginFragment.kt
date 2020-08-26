package com.example.first_android.screen

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.first_android.R
import kotlinx.android.synthetic.main.fragment_login2.*

class LoginFragment : Fragment(), View.OnClickListener {

    private var sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences =
            activity?.getSharedPreferences(getString(R.string.shared_preferences_name), Context.MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnLogin.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v) {
            btnLogin -> {
                with(sharedPreferences?.edit()) {
                    this?.putString(getString(R.string.username_key), usernameTextInput.text.toString())
                    this?.commit()
                }
                v?.findNavController()?.navigate(R.id.action_loginFragment2_to_homeFragment2)
            }
        }
    }
}