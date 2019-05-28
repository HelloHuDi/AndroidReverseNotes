package com.tencent.xweb.p685x5.p1116a.p1117a.p1118a.p1119a;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.xweb.C24530n;
import com.tencent.xweb.C31147o;
import com.tencent.xweb.C46945h;

/* renamed from: com.tencent.xweb.x5.a.a.a.a.a */
public interface C46834a {
    boolean super_allowJavaScriptOpenWindowAutomatically(String str, String str2);

    void super_computeScroll(View view);

    void super_didFirstVisuallyNonEmptyPaint();

    boolean super_dispatchTouchEvent(MotionEvent motionEvent, View view);

    void super_documentAvailableInMainFrame();

    void super_handlePluginTag(String str, String str2, boolean z, String str3);

    void super_hideAddressBar();

    boolean super_notifyAutoAudioPlay(String str, C46945h c46945h);

    boolean super_notifyJavaScriptOpenWindowsBlocked(String str, String[] strArr, ValueCallback<Boolean> valueCallback, boolean z);

    void super_onDoubleTapStart();

    void super_onFlingScrollBegin(int i, int i2, int i3);

    void super_onFlingScrollEnd();

    void super_onHideListBox();

    void super_onHistoryItemChanged();

    boolean super_onInterceptTouchEvent(MotionEvent motionEvent, View view);

    void super_onMetricsSavedCountReceived(String str, boolean z, long j, String str2, int i);

    Object super_onMiscCallBack(String str, Bundle bundle);

    Object super_onMiscCallBack(String str, Bundle bundle, Object obj, Object obj2, Object obj3, Object obj4);

    void super_onMissingPluginClicked(String str, String str2, String str3, int i);

    void super_onNativeCrashReport(int i, String str);

    void super_onOverScrolled(int i, int i2, boolean z, boolean z2, View view);

    void super_onPinchToZoomStart();

    void super_onPreReadFinished();

    void super_onPrefetchResourceHit(boolean z);

    void super_onPromptScaleSaved();

    void super_onReceivedSslErrorCancel();

    void super_onReceivedViewSource(String str);

    void super_onReportAdFilterInfo(int i, int i2, String str, boolean z);

    void super_onReportHtmlInfo(int i, String str);

    void super_onResponseReceived(C24530n c24530n, C31147o c31147o, int i);

    void super_onScrollChanged(int i, int i2, int i3, int i4);

    void super_onScrollChanged(int i, int i2, int i3, int i4, View view);

    void super_onSetButtonStatus(boolean z, boolean z2);

    void super_onShowListBox(String[] strArr, int[] iArr, int[] iArr2, int i);

    boolean super_onShowLongClickPopupMenu();

    void super_onShowMutilListBox(String[] strArr, int[] iArr, int[] iArr2, int[] iArr3);

    void super_onSlidingTitleOffScreen(int i, int i2);

    void super_onSoftKeyBoardHide(int i);

    void super_onSoftKeyBoardShow();

    boolean super_onTouchEvent(MotionEvent motionEvent, View view);

    void super_onTransitionToCommitted();

    void super_onUploadProgressChange(int i, int i2, String str);

    void super_onUploadProgressStart(int i);

    void super_onUrlChange(String str, String str2);

    boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view);

    void super_showTranslateBubble(int i, String str, String str2, int i2);
}
