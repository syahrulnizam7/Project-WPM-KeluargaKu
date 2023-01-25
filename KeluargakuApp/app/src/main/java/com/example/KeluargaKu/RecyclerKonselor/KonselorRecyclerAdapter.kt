package com.example.KeluargaKu.RecyclerKonselor

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.KeluargaKu.R
import kotlinx.android.synthetic.main.layout_list_konselor.view.*
import java.util.*

class KonselorRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items : List<ListObjKonselor> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DosenViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_list_konselor, parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DosenViewHolder -> {
                holder.bind(items.get(position))
                holder.klik.setOnClickListener {
                    holder.kalau_diklik(items.get(position))
                }
            }
        }
    }

    fun submitList(listDosen: List<ListObjKonselor>) {
        items = listDosen
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class DosenViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val foto_dosen: ImageView = itemView.gambar_dosen
        val nama_dosen: TextView = itemView.nama_dosen
        val kom_dosen: TextView = itemView.kompetensi_dosen
        var klik: RelativeLayout = itemView.findViewById(R.id.rl_klik)

        fun bind(listObjDosen: ListObjKonselor) {
            nama_dosen.setText(listObjDosen.nama)
            kom_dosen.setText(listObjDosen.kompetensi)

            val requestOp = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOp)
                .load(listObjDosen.gambar)
                .into(foto_dosen)
        }
        fun kalau_diklik(get: ListObjKonselor) {
            val position: Int = adapterPosition
            Toast.makeText(itemView.context, "Kamu memilih : ${get.nama}",
                Toast.LENGTH_SHORT)
                .show()

            val intent = Intent(itemView.context, DetailKonselor::class.java)
            intent.putExtra("namanya", get.nama)
            intent.putExtra("kompetensinya", get.kompetensi)
            intent.putExtra("fotonya", get.gambar)
            intent.putExtra("nipnya", get.nip)
            intent.putExtra("namamknya", get.namamk)
            intent.putExtra("ruangannya", get.ruangan)
            itemView.context.startActivity(intent)
        }
    }
}

