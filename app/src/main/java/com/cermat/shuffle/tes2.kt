package com.cermat.shuffle

import kotlin.jvm.JvmStatic
import com.cermat.shuffle.tes2
import java.util.*

object tes2 {
    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        print("Masukkan jumlah nama: ")
        val jumlahNama = scanner.nextInt()
        val namaList: MutableList<String> = ArrayList()
        for (i in 1..jumlahNama) {
            print("Masukkan nama ke-$i: ")
            val nama = scanner.next()
            namaList.add(nama)
        }
        println(namaList)
        randomPickName(namaList, scanner)
    }

    fun randomPickName(namaList: MutableList<String>, scanner: Scanner) {
        val random = Random()
        while (namaList.isNotEmpty()) {
            val pickedIndex = random.nextInt(namaList.size)
            val pickedName = namaList.removeAt(pickedIndex)
            println("Nama yang dipilih: $pickedName")
            if (namaList.isNotEmpty()) {
                print("Apakah Anda ingin memilih nama lagi dari yang tersisa? (ya/tidak): ")
                val choice = scanner.next()
                if (choice.equals("tidak", ignoreCase = true)) {
                    break
                }
            }
        }
        println("Semua nama telah dipilih.")
    }
}