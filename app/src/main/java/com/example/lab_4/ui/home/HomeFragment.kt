package com.example.lab_4.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.lab_4.R
import com.example.lab_4.activities.RegisterActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // OTRA FORMA DE LLAMAR AL SIGUIENTE FRAGMENT
        //btn_iniciar.setOnClickListener { Navigation.createNavigateOnClickListener(R.id.action_nav_home_to_nav_register) }
//
//        btn_iniciar.setOnClickListener {
//            findNavController().navigate(R.id.action_nav_home_to_nav_register)
//        }

        // Llama a la actividad Register
        
        btn_iniciar.setOnClickListener {
            activity?.let {
                val intent = Intent(it, RegisterActivity::class.java)
                it.startActivity(intent)
            }
        }
    }
}
