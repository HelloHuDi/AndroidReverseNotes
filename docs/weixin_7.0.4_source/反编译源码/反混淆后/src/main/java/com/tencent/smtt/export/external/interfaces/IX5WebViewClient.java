package com.tencent.smtt.export.external.interfaces;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;

public interface IX5WebViewClient {
    public static final int ERROR_AUTHENTICATION = -4;
    public static final int ERROR_BAD_URL = -12;
    public static final int ERROR_CONNECT = -6;
    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    public static final int ERROR_FILE = -13;
    public static final int ERROR_FILE_NOT_FOUND = -14;
    public static final int ERROR_HOST_LOOKUP = -2;
    public static final int ERROR_IO = -7;
    public static final int ERROR_PROXY_AUTHENTICATION = -5;
    public static final int ERROR_REDIRECT_LOOP = -9;
    public static final int ERROR_TIMEOUT = -8;
    public static final int ERROR_TOO_MANY_REQUESTS = -15;
    public static final int ERROR_UNKNOWN = -1;
    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
    public static final int ERROR_UNSUPPORTED_SCHEME = -10;
    public static final int INTERCEPT_BY_ISP = -16;

    void doUpdateVisitedHistory(IX5WebViewBase iX5WebViewBase, String str, boolean z);

    void onContentSizeChanged(IX5WebViewBase iX5WebViewBase, int i, int i2);

    void onDetectedBlankScreen(IX5WebViewBase iX5WebViewBase, String str, int i);

    void onFormResubmission(IX5WebViewBase iX5WebViewBase, Message message, Message message2);

    void onLoadResource(IX5WebViewBase iX5WebViewBase, String str);

    void onPageFinished(IX5WebViewBase iX5WebViewBase, int i, int i2, String str);

    void onPageFinished(IX5WebViewBase iX5WebViewBase, String str);

    void onPageStarted(IX5WebViewBase iX5WebViewBase, int i, int i2, String str, Bitmap bitmap);

    void onPageStarted(IX5WebViewBase iX5WebViewBase, String str, Bitmap bitmap);

    void onReceivedClientCertRequest(IX5WebViewBase iX5WebViewBase, ClientCertRequest clientCertRequest);

    void onReceivedError(IX5WebViewBase iX5WebViewBase, int i, String str, String str2);

    void onReceivedError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceError webResourceError);

    void onReceivedHttpAuthRequest(IX5WebViewBase iX5WebViewBase, HttpAuthHandler httpAuthHandler, String str, String str2);

    void onReceivedHttpError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse);

    void onReceivedLoginRequest(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3);

    void onReceivedSslError(IX5WebViewBase iX5WebViewBase, SslErrorHandler sslErrorHandler, SslError sslError);

    void onScaleChanged(IX5WebViewBase iX5WebViewBase, float f, float f2);

    @Deprecated
    void onTooManyRedirects(IX5WebViewBase iX5WebViewBase, Message message, Message message2);

    void onUnhandledKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent);

    WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest);

    WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, Bundle bundle);

    WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, String str);

    boolean shouldOverrideKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent);

    boolean shouldOverrideUrlLoading(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest);

    boolean shouldOverrideUrlLoading(IX5WebViewBase iX5WebViewBase, String str);
}
