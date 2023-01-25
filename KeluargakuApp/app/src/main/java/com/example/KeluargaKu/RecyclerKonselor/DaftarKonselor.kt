package com.example.KeluargaKu.RecyclerKonselor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.KeluargaKu.R
import kotlinx.android.synthetic.main.fragment_daftar_konselor.*

class DaftarKonselor : AppCompatActivity() {
    private lateinit var konselorAdapter: KonselorRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_daftar_konselor)
        initRecyclerView()
        tambahDataSet()
    }

    private fun tambahDataSet() {
        val data = SumberDataKonselor.buatSetData()
        konselorAdapter.submitList(data)
    }

    private fun initRecyclerView() {
        recycle_view.apply {
            layoutManager = LinearLayoutManager(this@DaftarKonselor)
            val spacingAtas = DekorasiSpasiGambar(28)
            addItemDecoration(spacingAtas)
            konselorAdapter = KonselorRecyclerAdapter()
            adapter = konselorAdapter
        }
    }
}