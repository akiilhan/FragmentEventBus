package com.example.fragmenteventbus



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class MainActivity : AppCompatActivity() {
    var manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragmentA()
        addFragmentB()
    }

    private fun addFragmentA() {
        var fragmentA = FragmentA()
        var transaction = manager.beginTransaction()
        transaction.add(R.id.containerA, fragmentA, "fragA")
        transaction.commit()


    }

    private fun addFragmentB() {
        var fragmentB = FragmentB()
        var transaction = manager.beginTransaction()
        transaction.add(R.id.containerB, fragmentB, "fragB")
        transaction.commit()
    }

    /**override fun sayilariTopla(sayi1: Int, sayi2: Int) {

    var fragment_B = manager.findFragmentByTag("fragB") as FragmentB
    fragment_B.sayilariTopla(sayi1, sayi2)
    }*/

    @Subscribe
     fun onDataEvent(event: DataEvent.SayilariAl) {

        var sayi1 = event.getsayi1()
        var sayi2 = event.getsayi2()
        var toplam = sayi1 + sayi2
        Log.e("aki", "mainactivity sayiları aldı ve topladı. Fragment b'ye gönderdi")
        EventBus.getDefault().post(DataEvent.ToplamEvent(toplam))

    }


    // Kanala register olmak istiyorsan asağıdaki fonksyonların içinde olnalı.

    override fun onStart() { //-> radyoyu açtım
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

}
