package com.example.sample09launcherregisterforactivityyresult

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sample09launcherregisterforactivityyresult.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivitySecondBinding.inflate(layoutInflater, null, false)
            .also {
                setContentView(it.root)
            }
            .apply {
                editText.setText(intent.getStringExtra(ALLER_CLE))

                button.setOnClickListener {
                    setResult(
                        MainActivity.SETRESULT_CLE,
                        Intent().putExtra(MainActivity.RETOUR_CLE, editText.text.toString())
                    )
                    finish()
                }
            }
    }

    companion object {
        const val ALLER_CLE = "aller_cle"
    }
}