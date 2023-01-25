package com.example.KeluargaKu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.KeluargaKu.Anggota
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity(), View.OnClickListener {
    private lateinit var edNama: EditText
    private lateinit var edEmail: EditText
    private lateinit var edUsername: EditText
    private lateinit var edPassword: EditText
    private lateinit var edConfPass: EditText
    private lateinit var edNoHP: EditText
    private lateinit var edUmur: EditText
    private lateinit var edAlamat: EditText
    private lateinit var btnSimpan: Button
    private lateinit var gantiLogin: TextView
    private lateinit var ref: DatabaseReference
    private lateinit var anggotaList: MutableList<Anggota>
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.daftar)

        ref = FirebaseDatabase.getInstance().getReference("anggota")
        edNama = findViewById(R.id.edtNama)
        edEmail = findViewById(R.id.edtEmail)
        edUsername = findViewById(R.id.edtUsername)
        edPassword = findViewById(R.id.edtPassword)
        edConfPass = findViewById(R.id.edtConfirPassword)
        edNoHP = findViewById(R.id.edtNoHP)
        edUmur = findViewById(R.id.edtUmur)
        edAlamat = findViewById(R.id.edtAlamat)
        btnSimpan = findViewById(R.id.btn_daftar)
        gantiLogin = findViewById(R.id.textLogin)

        btnSimpan.setOnClickListener(this)
        anggotaList = mutableListOf()
        // Initialising auth object
        auth = Firebase.auth

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    anggotaList.clear()
                    for (a in snapshot.children) {
                        val anggota = a.getValue(Anggota::class.java)
                        if (anggota != null) {
                            anggotaList.add(anggota)
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        gantiLogin.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(v: View?) {
        simpanData()
    }

    private fun simpanData() {
        val nama = edNama.text.toString().trim()
        val email = edEmail.text.toString()
        val username = edUsername.text.toString()
        val password = edPassword.text.toString()
        val confirmPassword = edConfPass.text.toString()
        val noHP = edNoHP.text.toString()
        val umur = edUmur.text.toString()
        val alamat = edAlamat.text.toString()

        if (nama.isEmpty() or email.isEmpty() or username.isEmpty() or password.isEmpty() or confirmPassword.isEmpty() or noHP.isEmpty() or umur.isEmpty())  {
            Toast.makeText(this, "Isi data secara lengkap tidak boleh kosong",
                Toast.LENGTH_SHORT)
                .show()
            return
        }

        if (password != confirmPassword) {
            Toast.makeText(this, "Kata Sandi dan Konfirmasi Kata Sandi tidak cocok!", Toast.LENGTH_SHORT)
                .show()
            return
        }

        val anggotaId = ref.push().key
        val anggota = Anggota(anggotaId!!, nama, email, username, password, noHP, umur, alamat)

        ref.child(anggotaId).setValue(anggota).addOnCompleteListener {
            Toast.makeText(applicationContext, "Data berhasil ditambahkan",
                Toast.LENGTH_SHORT).show()
        }

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Register berhasil!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Register gagal!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}