package com.gpigroup

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gpigroup.R
//import kotlinx.android.synthetic.main.activity_internal.*


class RedirectionActivity : AppCompatActivity() {

    val appPackageName = "it.ipzs.cieid"
    val className = "it.ipzs.cieid.BaseActivity"
    val URL = "URL"
    val ERROR = "ERROR"
    val webView: WebView = findViewById(R.id.webView)


    //javascript necessario
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_redirection)



        //opzioni sicurezza webview
        webView.settings.apply {
            javaScriptEnabled = true
            allowContentAccess = false
            allowFileAccess = false
            allowFileAccessFromFileURLs = false
            allowUniversalAccessFromFileURLs = false
        }

        //inserire url service provider
        webView.loadUrl("")


        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
            }

            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                // The webView is about to navigate to the specified host.
                if (
                    url.toString().contains("OpenApp") ||
                    url.toString().contains("login/livello2") ||
                    url.toString().contains("login/livello1")) {
                    val intent = Intent()
                    try {
                        intent.setClassName(appPackageName, className)
                        //settare la url caricata dalla webview su /OpenApp
                        intent.data = Uri.parse(url)
                        intent.action = Intent.ACTION_VIEW
                        startActivityForResult(intent, 0)

                    } catch (a : ActivityNotFoundException) {
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
                            )
                        )
                    }
                    return true

                }
                return super.shouldOverrideUrlLoading(view, url)
            }

        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (resultCode) {
            RESULT_OK -> {
                val url = data?.getStringExtra(URL)
                if (!TextUtils.isEmpty(url)) {
                    webView.loadUrl(url!!)
                } else {
                    when (data?.getIntExtra(ERROR, 0)) {
                        RedirectionError.GENERIC_ERROR.code -> Toast.makeText(this, "GENERIC ERROR", Toast.LENGTH_LONG).show()
                        RedirectionError.CIE_NOT_REGISTERED.code -> Toast.makeText(this, "CIE NOT REGISTERED", Toast.LENGTH_LONG).show()
                        RedirectionError.AUTHENTICATION_ERROR.code -> Toast.makeText(this, "AUTHENTICATION ERROR", Toast.LENGTH_LONG).show()
                        RedirectionError.NO_SECURE_DEVICE.code -> Toast.makeText(this, "DEVICE NOT SECURE FOR AUTHENTICATION", Toast.LENGTH_LONG).show()
                    }
                }
            }
            RESULT_CANCELED -> {
                Toast.makeText(this,"OPERATION ABORTED",Toast.LENGTH_LONG).show()
            }
            else -> {
                Toast.makeText(this,"GENERIC ERROR",Toast.LENGTH_LONG).show()
            }
        }

    }

}