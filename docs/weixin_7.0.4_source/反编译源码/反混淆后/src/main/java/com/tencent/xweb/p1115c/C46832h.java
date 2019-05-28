package com.tencent.xweb.p1115c;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebView.FindListener;
import com.tencent.xweb.C36589p;
import com.tencent.xweb.C36591r;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.C6031l;
import com.tencent.xweb.C6035t;
import com.tencent.xweb.WebView.C41116b;
import com.tencent.xweb.WebView.C46827a;
import com.tencent.xweb.p685x5.p1116a.p1117a.p1118a.p1119a.C16404b;
import java.util.Map;

/* renamed from: com.tencent.xweb.c.h */
public interface C46832h {
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

    C6031l getCurWebChromeClient();

    C36592s getCurWebviewClient();

    C24524e getDefalutOpProvider();

    C46827a getFullscreenVideoKind();

    C41116b getHitTestResult();

    float getScale();

    C36589p getSettings();

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

    void setJSExceptionListener(C6035t c6035t);

    void setVerticalScrollBarEnabled(boolean z);

    void setWebChromeClient(C6031l c6031l);

    void setWebViewCallbackClient(C36591r c36591r);

    void setWebViewClient(C36592s c36592s);

    void setWebViewClientExtension(C16404b c16404b);

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
