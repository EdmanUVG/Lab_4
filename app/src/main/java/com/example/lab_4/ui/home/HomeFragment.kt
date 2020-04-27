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
import com.example.lab_4.ui.about.AboutViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_gallery)
        val buttonRegister: Button = root.findViewById(R.id.btn_iniciar)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            //            textView.text = it

            buttonRegister.setOnClickListener {
                activity?.let {
                    val intent = Intent(it, RegisterActivity::class.java)
                    it.startActivity(intent)
                }
            }
        })
        return root
    }
}
