package com.example.fragmenteventbus

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import org.greenrobot.eventbus.EventBus


class FragmentA : Fragment() {
    lateinit var sayi1: EditText
    lateinit var sayi2: EditText
    lateinit var btnGonder: Button

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var v = inflater.inflate(R.layout.fragment_a, container, false)

        sayi1 = v.findViewById(R.id.etsayi1)
        sayi2 = v.findViewById(R.id.etsayi2)
        btnGonder = v.findViewById(R.id.btnactivityGonder)

        btnGonder.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                sendDataToActivity()
            }
        })
        return v


    }

    private fun sendDataToActivity() {

        var s1: Int = Integer.parseInt(sayi1.text.toString())
        var s2: Int = Integer.parseInt(sayi2.text.toString())

//        var listenerr = activity as MyInterface
//        listenerr.sayilariTopla(s1, s2)
        Log.e("aki","Fragment a mainactivity'e sayilari gönderdi.")
        EventBus.getDefault().post(DataEvent.SayilariAl(s1,s2)) //-> bende s1ve s22 olan bir nesne var diye yayın yapıyor.


    }


}

