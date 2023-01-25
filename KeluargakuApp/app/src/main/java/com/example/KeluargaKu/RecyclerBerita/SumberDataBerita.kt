package com.example.KeluargaKu.RecyclerBerita

class SumberDataBerita {companion object {
    fun buatSetData(): ArrayList<ListObjBerita> {
        val list = ArrayList<ListObjBerita>()
        list.add(
            ListObjBerita(
                "Berita 1",
                "Pusyanra adalah Pusat pelayanan keluarga sejahtera. Atau dikenal dengan PPKS. ",
                "https://keluargaku.or.id/storage/images/slide/X7n8FrsAv0BVMEN4rafysWo5CAroozqSkgzyBQi3.jpeg",
                "20101010",
                "Workshop Pemrograman Mobile",
                "201"
            )
        )
        list.add(
            ListObjBerita(
                "Berita 2",
                "Pusyanra adalah Pusat pelayanan keluarga sejahtera. Atau dikenal dengan PPKS. ",
                "https://keluargaku.or.id/storage/images/slide/h4S0KhOIptkRcqUkqsMt05yP2N8cYVhqX1oCilVM.jpeg",
                "20101011",
                "Workshop Pemrograman Framework",
                "202"
            )
        )
        list.add(
            ListObjBerita(
                "Berita 3",
                "Pusyanra adalah Pusat pelayanan keluarga sejahtera. Atau dikenal dengan PPKS. ",
                "https://keluargaku.or.id/storage/images/slide/Vvepkqf1rBWtFGWIG3f3VW3mhPbumKaY8TyIOHhM.jpeg",
                "20101012",
                "KTI",
                "203"
            )
        )
        list.add(
            ListObjBerita(
                "Berita 4",
                "Pusyanra adalah Pusat pelayanan keluarga sejahtera. Atau dikenal dengan PPKS. ",
                "https://keluargaku.or.id/storage/images/slide/nYlTzQTkaKiC3PH2Vhj99WTJ5jFcU4FCRP44NqGd.jpeg",
                "20101013",
                "Big Data",
                "204"
            )
        )
        list.add(
            ListObjBerita(
                "Berita 5",
                "Pusyanra adalah Pusat pelayanan keluarga sejahtera. Atau dikenal dengan PPKS. ",
                "https://keluargaku.or.id/storage/images/slide/BZT5183lR9Astv791PAem78imlgUFwOa9hLXQNUI.jpeg",
                "20101014",
                "Basis Data",
                "205"
            )
        )
        return list
    }
}
}
