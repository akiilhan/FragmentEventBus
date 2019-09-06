package com.example.fragmenteventbus

class DataEvent {

     class SayilariAl(var sayi1: Int, var sayi2: Int) {

        fun getsayi1(): Int {

            return sayi1

        }

        fun setsayi1(sayi1: Int) {
            this.sayi1 = sayi1

        }

        fun getsayi2(): Int {

            return sayi2

        }

        fun setsayi2(sayi2: Int) {
            this.sayi2 = sayi2

        }
    }

    internal class ToplamEvent(var toplam: Int) {

        fun gettoplam(): Int {

            return toplam

        }

        fun settoplam(toplam: Int) {
            this.toplam = toplam

        }
    }


}