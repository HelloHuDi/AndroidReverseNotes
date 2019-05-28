package com.tencent.smtt.export.external.extension.interfaces;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;

public interface IX5WebViewClientExtension {
    public static final int FRAME_LOADTYPE_BACK = 1;
    public static final int FRAME_LOADTYPE_BACKWMLDECKNOTACCESSIBLE = 10;
    public static final int FRAME_LOADTYPE_FORWARD = 2;
    public static final int FRAME_LOADTYPE_INDEXEDBACKFORWARD = 3;
    public static final int FRAME_LOADTYPE_PREREAD = 11;
    public static final int FRAME_LOADTYPE_REDIRECT = 7;
    public static final int FRAME_LOADTYPE_RELOAD = 4;
    public static final int FRAME_LOADTYPE_RELOADALLOWINGSTALEDATA = 5;
    public static final int FRAME_LOADTYPE_RELOADFROMORIGIN = 9;
    public static final int FRAME_LOADTYPE_REPLACE = 8;
    public static final int FRAME_LOADTYPE_SAME = 6;
    public static final int FRAME_LOADTYPE_STANDARD = 0;
    public static final int HTMLTYPE_JS_SCROLLTO = 1;

    boolean allowJavaScriptOpenWindowAutomatically(String str, String str2);

    void computeScroll(View view);

    void didFirstVisuallyNonEmptyPaint();

    boolean dispatchTouchEvent(MotionEvent motionEvent, View view);

    void documentAvailableInMainFrame();

    void handlePluginTag(String str, String str2, boolean z, String str3);

    void hideAddressBar();

    void invalidate();

    boolean notifyAutoAudioPlay(String str, JsResult jsResult);

    boolean notifyJavaScriptOpenWindowsBlocked(String str, String[] strArr, ValueCallback<Boolean> valueCallback, boolean z);

    void onDoubleTapStart();

    void onFlingScrollBegin(int i, int i2, int i3);

    void onFlingScrollEnd();

    void onHideListBox();

    void onHistoryItemChanged();

    void onInputBoxTextChanged(IX5WebViewExtension iX5WebViewExtension, String str);

    boolean onInterceptTouchEvent(MotionEvent motionEvent, View view);

    void onMetricsSavedCountReceived(String str, boolean z, long j, String str2, int i);

    Object onMiscCallBack(String str, Bundle bundle);

    Object onMiscCallBack(String str, Bundle bundle, Object obj, Object obj2, Object obj3, Object obj4);

    void onMissingPluginClicked(String str, String str2, String str3, int i);

    void onNativeCrashReport(int i, String str);

    void onOverScrolled(int i, int i2, boolean z, boolean z2, View view);

    void onPinchToZoomStart();

    void onPreReadFinished();

    void onPrefetchResourceHit(boolean z);

    void onPreloadCallback(int i, String str);

    void onPromptScaleSaved();

    void onReceivedSslErrorCancel();

    void onReceivedViewSource(String str);

    void onReportAdFilterInfo(int i, int i2, String str, boolean z);

    void onReportHtmlInfo(int i, String str);

    void onResponseReceived(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse, int i);

    void onScrollChanged(int i, int i2, int i3, int i4);

    void onScrollChanged(int i, int i2, int i3, int i4, View view);

    void onSetButtonStatus(boolean z, boolean z2);

    void onShowListBox(String[] strArr, int[] iArr, int[] iArr2, int i);

    boolean onShowLongClickPopupMenu();

    void onShowMutilListBox(String[] strArr, int[] iArr, int[] iArr2, int[] iArr3);

    void onSlidingTitleOffScreen(int i, int i2);

    void onSoftKeyBoardHide(int i);

    void onSoftKeyBoardShow();

    boolean onTouchEvent(MotionEvent motionEvent, View view);

    void onTransitionToCommitted();

    void onUploadProgressChange(int i, int i2, String str);

    void onUploadProgressStart(int i);

    void onUrlChange(String str, String str2);

    boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view);

    boolean preShouldOverrideUrlLoading(IX5WebViewExtension iX5WebViewExtension, String str);

    void showTranslateBubble(int i, String str, String str2, int i2);
}
