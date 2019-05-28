package com.tencent.xweb.c;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebView.FindListener;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.l;
import com.tencent.xweb.p;
import com.tencent.xweb.r;
import com.tencent.xweb.s;
import com.tencent.xweb.t;
import java.util.Map;

public interface h {
    void addJavascriptInterface(Object obj, String str);

    boolean canGoBack();

    boolean canGoForward();

    void clearHistory();

    void clearMatches();

    void clearSslPreferences();

    void clearView();

    void destroy();

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    void findAllAsync(String str);

    void findNext(boolean z);

    String getAbstractInfo();

    int getContentHeight();

    l getCurWebChromeClient();

    s getCurWebviewClient();

    e getDefalutOpProvider();

    a getFullscreenVideoKind();

    b getHitTestResult();

    float getScale();

    p getSettings();

    String getTitle();

    ViewGroup getTopView();

    String getUrl();

    String getVersionInfo();

    View getView();

    int getVisibleTitleHeight();

    int getWebScrollX();

    int getWebScrollY();

    View getWebViewUI();

    Object getX5WebViewExtension();

    void goBack();

    boolean hasEnteredFullscreen();

    boolean isOverScrollStart();

    boolean isSupportExtendPluginForAppbrand();

    void leaveFullscreen();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    @TargetApi(8)
    void loadUrl(String str, Map<String, String> map);

    void onPause();

    void onResume();

    boolean overlayHorizontalScrollbar();

    void reload();

    void removeJavascriptInterface(String str);

    boolean savePage(String str, String str2, int i);

    void setDownloadListener(DownloadListener downloadListener);

    void setFindListener(FindListener findListener);

    void setHorizontalScrollBarEnabled(boolean z);

    void setJSExceptionListener(t tVar);

    void setVerticalScrollBarEnabled(boolean z);

    void setWebChromeClient(l lVar);

    void setWebViewCallbackClient(r rVar);

    void setWebViewClient(s sVar);

    void setWebViewClientExtension(com.tencent.xweb.x5.a.a.a.a.b bVar);

    void stopLoading();

    void super_computeScroll();

    boolean super_dispatchTouchEvent(MotionEvent motionEvent);

    boolean super_onInterceptTouchEvent(MotionEvent motionEvent);

    void super_onOverScrolled(int i, int i2, boolean z, boolean z2);

    void super_onScrollChanged(int i, int i2, int i3, int i4);

    boolean super_onTouchEvent(MotionEvent motionEvent);

    boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z);

    boolean supportFeature(int i);

    boolean zoomIn();

    boolean zoomOut();
}
