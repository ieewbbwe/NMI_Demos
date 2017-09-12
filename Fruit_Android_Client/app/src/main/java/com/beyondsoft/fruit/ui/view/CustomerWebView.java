package com.beyondsoft.fruit.ui.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.android_mobile.core.utiles.Lg;

/**
 * Created by picher on 2017/9/12.
 * Describe：
 */

public class CustomerWebView extends WebView {

    String webSell = "<html><head><body>" +
            "<meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no\">\n" +
            "<meta name=\"format-detection\" content=\"telephone=no\" />\n" +
            "<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n" +
            "<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\">\n" +
            "<meta http-equiv=\"pragma\" content=\"no-cache\" />" +
            "<meta http-equiv=\"Content-Type\" content=\"text/html charset=utf-8\" />" +
            "<link href=\"product.css\" type=\"text/css\" rel=\"stylesheet\"/>" +
            "</head>" +
            "<div class=\"mobile-html\">%s</div></body></html>";

    public CustomerWebView(Context context) {
        this(context,null);
    }

    public CustomerWebView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomerWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        WebSettings webSetting = getSettings();
        webSetting.setSupportZoom(true);
        webSetting.setUseWideViewPort(false);
        webSetting.setDefaultTextEncodingName("utf-8");
        webSetting.setLoadWithOverviewMode(true);
        webSetting.setUseWideViewPort(true);
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSetting.setDomStorageEnabled(true);
        webSetting.setAllowFileAccess(true);

        setWebChromeClient(new WebChromeClient());

        setWebViewClient(new DefaultWebClient());

    }

    public void loadUrlForMobile(String content) {
        Lg.print("picher",content);
        loadDataWithBaseURL(null, String.format(webSell, content), "text/html", "UTF-8", null);
    }

    //可自定义拦截信息
    public static class DefaultWebClient extends WebViewClient {

        public DefaultWebClient( ) {
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //改变打开方式
           /* Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);*/
            return true;
        }
    }
}
