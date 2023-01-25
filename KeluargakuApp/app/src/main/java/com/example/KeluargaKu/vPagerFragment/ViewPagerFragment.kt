package com.example.KeluargaKu.vPagerFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.KeluargaKu.R
import com.example.KeluargaKu.databinding.FragmentViewPagerBinding
import com.example.KeluargaKu.vPagerFragment.screens.HalamanKedua
import com.example.KeluargaKu.vPagerFragment.screens.HalamanKetiga
import com.example.KeluargaKu.vPagerFragment.screens.HalamanPertama


class ViewPagerFragment : Fragment() {
    lateinit var binding: FragmentViewPagerBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_pager,
            container, false)
        binding = FragmentViewPagerBinding.bind(view)
        val fragmentList = arrayListOf(
            HalamanPertama(),
            HalamanKedua(),
            HalamanKetiga()
        )

        val adapter = ViewPagerAdapter(fragmentList,
            requireActivity().supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter
        return view
    }
}