package com.example.KeluargaKu

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.KeluargaKu.databinding.IntroBinding

class intro : Fragment() {
    private lateinit var binding: IntroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.intro,
            container, false)
        binding = IntroBinding.bind(view)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        val login = view.findViewById<TextView>(R.id.textView11)
        login.setOnClickListener {
            val intent1 = Intent(activity,Login::class.java)
            startActivity(intent1)
        }

        val register = view.findViewById<TextView>(R.id.textView10)
        register.setOnClickListener {
            val intent2 = Intent(activity,Register::class.java)
            startActivity(intent2)
        }
        return view
    }
}