package com.example.KeluargaKu.RecyclerBerita

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.KeluargaKu.R
import kotlinx.android.synthetic.main.fragment_daftar_berita.*

class DaftarBerita : AppCompatActivity() {
    private lateinit var beritaAdapter: BeritaRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_daftar_berita)
        initRecyclerView()
        tambahDataSet()
    }

    private fun tambahDataSet() {
        val data = SumberDataBerita.buatSetData()
        beritaAdapter.submitList(data)
    }

    private fun initRecyclerView() {
        recycle_viewberita.apply {
            layoutManager = LinearLayoutManager(this@DaftarBerita)
            val spacingAtas = DekorasiSpasiGambarBerita(28)
            addItemDecoration(spacingAtas)
            beritaAdapter = BeritaRecyclerAdapter()
            adapter = beritaAdapter
        }
    }
}