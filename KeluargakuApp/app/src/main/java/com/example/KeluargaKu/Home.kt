package com.example.KeluargaKu

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.KeluargaKu.RecyclerBerita.DaftarBerita
import com.example.KeluargaKu.RecyclerKonselor.DaftarKonselor
import com.example.KeluargaKu.databinding.HomeBinding
class Home : Fragment() {
    //banner
    lateinit var viewPager: ViewPager
    lateinit var viewPagerAdapterSlider: ViewPagerAdapterSlider
    lateinit var imageList: List<Int>

    //menu
    private lateinit var binding: HomeBinding
    private var linearLayout: LinearLayout? = null
    private val menu = arrayOf("Berita", "DaftarKonselor","Media","Aktivitas","Tentang")
    private val gambar = intArrayOf(
        R.drawable.menudashboard,
        R.drawable.daftar_konselor,
        R.drawable.media,
        R.drawable.aktivitas,
        R.drawable.tentang_kami,
    )

    //berita
    private lateinit var binding2: HomeBinding
    private var linearLayout2: LinearLayout? = null
    private val menu2 = arrayOf("Kegiatan1", "Kegiatan2","Kegiatan3")
    private val gambar2 = intArrayOf(
        R.drawable.berita1,
        R.drawable.berita2,
        R.drawable.berita3,
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(
            R.layout.home,
            container, false)
        binding = HomeBinding.bind(view)
        binding2 = HomeBinding.bind(view)

        linearLayout = view.findViewById(R.id.linear1)
        linearLayout2 = view.findViewById(R.id.linear2)

        val layoutInflater = LayoutInflater.from(requireContext())
        val layoutInflater2 = LayoutInflater.from(requireContext())

        for(i in menu.indices){
            val view: View =layoutInflater.inflate(R.layout.menu_dashboard,linearLayout, false)
            val imageView = view.findViewById<ImageView>(R.id.iv)
            imageView.setImageResource(gambar[i])
            val tv = view.findViewById<TextView>(R.id.tv)
            tv.text = menu[i]
            linearLayout?.addView(view)

            imageView.setOnClickListener{
                if (menu[i] == "Tentang"){
                    val keabout = Intent(activity,Tentang::class.java)
                    startActivity(keabout)
                }
                if (menu[i] == "DaftarKonselor"){
                    val kedaftarkonselor = Intent(activity, DaftarKonselor::class.java)
                    startActivity(kedaftarkonselor)
                }
                if (menu[i] == "Berita"){
                    val keberita = Intent(activity, DaftarBerita::class.java)
                    startActivity(keberita)
                }

            }
        }

        for(i in menu2.indices){
            val view: View =layoutInflater.inflate(R.layout.menu_berita,linearLayout2, false)
            val imageView = view.findViewById<ImageView>(R.id.iv)
            imageView.setImageResource(gambar2[i])
            val tv = view.findViewById<TextView>(R.id.tv)
            tv.text = menu2[i]
            linearLayout2?.addView(view)

            imageView.setOnClickListener{

            }
        }

        val keprofil=view.findViewById<ImageView>(R.id.avatar)
        keprofil.setOnClickListener {
            val keprofil = Intent(activity,Profil::class.java)
            startActivity(keprofil)
        }


        // initializing variables
        // of below line with their id.
        viewPager = view.findViewById(R.id.idViewPager)

        // on below line we are initializing
        // our image list and adding data to it.
        imageList = ArrayList<Int>()
        imageList = imageList + R.drawable.banner1
        imageList = imageList + R.drawable.banner2
        imageList = imageList + R.drawable.banner3

        // on below line we are initializing our view
        // pager adapter and adding image list to it.
        viewPagerAdapterSlider = ViewPagerAdapterSlider(requireContext(), imageList)

        // on below line we are setting
        // adapter to our view pager.
        viewPager.adapter = viewPagerAdapterSlider

        return view
    }
}