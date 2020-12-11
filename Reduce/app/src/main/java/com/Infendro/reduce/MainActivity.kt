package com.Infendro.reduce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val nom = nominator.text.toString().toInt()
        val denom = denominator.text.toString().toInt()

        val ggt = getGGT(nom,denom)

        nominator.setText(nom/ggt)
        denominator.setText(denom/ggt)
    }

    fun getGGT(n1: Int, n2:Int) : Int{
        var divider = n2
        var rest = n1%n2
        var ggt = 0;
        while(rest!=0){
            ggt = rest

            val temp = rest
            rest %= divider
            divider = temp

            if(rest!=0){
                break
            }
        }
        return ggt;
    }
}