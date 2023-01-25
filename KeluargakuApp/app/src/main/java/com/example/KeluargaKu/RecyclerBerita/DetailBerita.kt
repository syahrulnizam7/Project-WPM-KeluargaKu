package com.example.KeluargaKu.RecyclerBerita

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.KeluargaKu.R
import kotlinx.android.synthetic.main.detail_konselor.*


class DetailBerita: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_konselor)
        if (intent.hasExtra("namanya")) {
            val nama: String = this.intent.getStringExtra("namanya").toString()
            val foto: String = this.intent.getStringExtra("fotonya").toString()
            val nip: String = this.intent.getStringExtra("nipnya").toString()
            val namamk: String = this.intent.getStringExtra("namamknya").toString()
            val ruangan: String = this.intent.getStringExtra("ruangannya").toString()
            setDetil(foto, nama, nip, namamk, ruangan)
        }
    }

    fun setDetil(foto: String, nama: String, nip : String, namamk :String, ruangan :String){
        val requestOp = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        nama_detail_dosen.text = nama
        nip_dosen.text = nip
        namamk_dosen.text = namamk
        ruangan_dosen.text = ruangan

        Glide.with(this)
            .load(foto)
            .apply(requestOp)
            .centerCrop()
            .into(foto_detail)
    }
}