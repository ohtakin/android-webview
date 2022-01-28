package com.tioh.webview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.os.Build
import android.util.AttributeSet
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

@SuppressLint("SetJavaScriptEnabled")
class CustomWebView(context: Context, attrs: AttributeSet?) : WebView(context, attrs) {

    var swipeRefresh: SwipeRefreshLayout? = null

    init {
        this.webViewClient = CustomWebViewClient()
        this.webChromeClient = CustomWebChromeClient()
        settings.apply {
            javaScriptEnabled = true
            setSupportMultipleWindows(true)
            javaScriptCanOpenWindowsAutomatically = true
            loadWithOverviewMode = true
            useWideViewPort = true
            setSupportZoom(true)
            builtInZoomControls = true

            // cache
            cacheMode = WebSettings.LOAD_NO_CACHE
            domStorageEnabled = true
            displayZoomControls = true

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                safeBrowsingEnabled = true
            }
            mediaPlaybackRequiresUserGesture = false
            allowContentAccess = true
            setGeolocationEnabled(true)
            allowFileAccess = true
        }
        fitsSystemWindows = true
    }


    inner class CustomWebViewClient: WebViewClient() {

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            swipeRefresh?.isRefreshing = false
        }
    }

    inner class CustomWebChromeClient: WebChromeClient() {

    }
}