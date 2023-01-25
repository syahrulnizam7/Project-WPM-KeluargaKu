package com.example.KeluargaKu

class Anggota (
        val id: String,
        val nama: String,
        val email: String,
        val username: String,
        val password: String,
        val noHP: String,
        val umur: String,
        val alamat: String,
    ){
        constructor() : this("", "", "", "", "", "", "", "")
    }
