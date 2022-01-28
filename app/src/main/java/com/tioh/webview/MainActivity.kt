package com.tioh.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MainActivity : AppCompatActivity() {

    private lateinit var webView: CustomWebView
    private lateinit var swipeRefresh: SwipeRefreshLayout

    private var basePath = BuildConfig.BASE_URL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.web_view)
        swipeRefresh = findViewById(R.id.refresh_container)

        webView.swipeRefresh = swipeRefresh
        swipeRefresh.setOnRefreshListener {
            webView.reload()
        }
        webView.loadUrl(basePath)
    }
}