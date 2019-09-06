package com.example.fragmenteventbus

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe


class FragmentB : Fragment() {
    lateinit var sonuc: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var v = inflater.inflate(R.layout.fragment_b, container, false)

        sonuc = v.findViewById(R.id.tvsonuc)

        return v
    }

    fun sayilariTopla(sayi1: Int, sayi2: Int) {
        var toplam = sayi1 + sayi2
        sonuc.setText(toplam.toString())
    }

    @Subscribe
    internal fun onToplamEvent(event: DataEvent.ToplamEvent) {

        var toplam = event.gettoplam()
        sonuc.setText("TOPLAM: " + toplam)
        Log.e("aki", "fragment b, mainactivtyden gelen toplam değişkeni aldı.")


    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        EventBus.getDefault().register(this)
    }

    override fun onDetach() {
        super.onDetach()
        EventBus.getDefault().unregister(this)
    }

}
