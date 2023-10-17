package com.isaanggi.ruangseni

class Data {
    val dataGambar = setupImages()
}

private fun setupImages(): List<Struktur> {
    return listOf(
        Struktur(R.drawable.gambar1, R.string.gambar_satu),
        Struktur(R.drawable.gambar2, R.string.gambar_dua),
        Struktur(R.drawable.gambar3, R.string.gambar_tiga),
        Struktur(R.drawable.gambar4, R.string.gambar_empat),
        Struktur(R.drawable.gambar5, R.string.gambar_lima),
        )
}