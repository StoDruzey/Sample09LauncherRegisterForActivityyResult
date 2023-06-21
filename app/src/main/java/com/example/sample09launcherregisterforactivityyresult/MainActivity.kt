package com.example.sample09launcherregisterforactivityyresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.sample09launcherregisterforactivityyresult.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    val activityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == SETRESULT_CLE) {
            requireNotNull(binding).textView.text = it.data?.getStringExtra(RETOUR_CLE)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityMainBinding.inflate(layoutInflater, null, false)
            .also {
                setContentView(it.root)
                binding = it
            }
            .apply {
                textView.setOnClickListener {
                    val intent = Intent(this@MainActivity, SecondActivity::class.java)
                        .putExtra(SecondActivity.ALLER_CLE, textView.text.toString())
                    activityLauncher.launch(intent)
                }
            }
    }

    companion object {
        const val RETOUR_CLE = "retour_cle"
        const val SETRESULT_CLE = 888
    }
}