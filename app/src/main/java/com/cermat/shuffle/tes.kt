package com.cermat.shuffle

import kotlin.jvm.JvmStatic
import com.cermat.shuffle.tes
import java.util.*

object tes {
    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        print("Masukkan maksimum angka yang bisa dipilih: ")
        val maxNumber = scanner.nextInt()
        randomPickNumber(maxNumber, scanner)
    }

    fun randomPickNumber(maxNumber: Int, scanner: Scanner) {
        val numbers: MutableList<Int> = ArrayList()
        for (i in 1..maxNumber) {
            numbers.add(i)
        }
        val random = Random()
        while (!numbers.isEmpty()) {
            val pickedIndex = random.nextInt(numbers.size)
            val pickedNumber = numbers.removeAt(pickedIndex)
            println("Angka yang dipilih: $pickedNumber")
            if (!numbers.isEmpty()) {
                print("Apakah Anda ingin mengacak lagi dari angka yang tersisa? (ya/tidak): ")
                val choice = scanner.next()
                if (choice.equals("tidak", ignoreCase = true)) {
                    break
                }
            }
        }
        println("Semua angka telah dipilih.")
    }
}