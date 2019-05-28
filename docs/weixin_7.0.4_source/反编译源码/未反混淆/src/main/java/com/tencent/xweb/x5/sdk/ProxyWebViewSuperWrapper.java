package com.tencent.xweb.x5.sdk;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.xweb.h;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.x5.a.a.a.a.a;
import com.tencent.xweb.x5.a.a.a.a.b;
import com.tencent.xweb.x5.a.c;
import com.tencent.xweb.x5.a.e;
import com.tencent.xweb.x5.g;
import com.tencent.xweb.x5.g.f;

public class ProxyWebViewSuperWrapper extends ProxyWebViewClientExtension implements a {
    b mXWebProxyImp;

    public void invalidate() {
    }

    public ProxyWebViewSuperWrapper(b bVar) {
        AppMethodBeat.i(84994);
        this.mXWebProxyImp = bVar;
        this.mXWebProxyImp.setSuperProvider(this);
        AppMethodBeat.o(84994);
    }

    public void onPreReadFinished() {
        AppMethodBeat.i(84995);
        this.mXWebProxyImp.onPreReadFinished();
        AppMethodBeat.o(84995);
    }

    public void onPromptScaleSaved() {
        AppMethodBeat.i(84996);
        this.mXWebProxyImp.onPromptScaleSaved();
        AppMethodBeat.o(84996);
    }

    public void onUrlChange(String str, String str2) {
        AppMethodBeat.i(84997);
        this.mXWebProxyImp.onUrlChange(str, str2);
        AppMethodBeat.o(84997);
    }

    public void onHideListBox() {
        AppMethodBeat.i(84998);
        this.mXWebProxyImp.onHideListBox();
        AppMethodBeat.o(84998);
    }

    public void onShowListBox(String[] strArr, int[] iArr, int[] iArr2, int i) {
        AppMethodBeat.i(84999);
        this.mXWebProxyImp.onShowListBox(strArr, iArr, iArr2, i);
        AppMethodBeat.o(84999);
    }

    public void onShowMutilListBox(String[] strArr, int[] iArr, int[] iArr2, int[] iArr3) {
        AppMethodBeat.i(85000);
        this.mXWebProxyImp.onShowMutilListBox(strArr, iArr, iArr2, iArr3);
        AppMethodBeat.o(85000);
    }

    public void onTransitionToCommitted() {
        AppMethodBeat.i(85001);
        this.mXWebProxyImp.onTransitionToCommitted();
        AppMethodBeat.o(85001);
    }

    public void showTranslateBubble(int i, String str, String str2, int i2) {
        AppMethodBeat.i(85002);
        this.mXWebProxyImp.showTranslateBubble(i, str, str2, i2);
        AppMethodBeat.o(85002);
    }

    public void onUploadProgressStart(int i) {
        AppMethodBeat.i(85003);
        this.mXWebProxyImp.onUploadProgressStart(i);
        AppMethodBeat.o(85003);
    }

    public void onUploadProgressChange(int i, int i2, String str) {
        AppMethodBeat.i(85004);
        this.mXWebProxyImp.onUploadProgressChange(i, i2, str);
        AppMethodBeat.o(85004);
    }

    public void onFlingScrollBegin(int i, int i2, int i3) {
        AppMethodBeat.i(85005);
        this.mXWebProxyImp.onFlingScrollBegin(i, i2, i3);
        AppMethodBeat.o(85005);
    }

    public void onFlingScrollEnd() {
        AppMethodBeat.i(85006);
        this.mXWebProxyImp.onFlingScrollEnd();
        AppMethodBeat.o(85006);
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(85007);
        this.mXWebProxyImp.onScrollChanged(i, i2, i3, i4);
        AppMethodBeat.o(85007);
    }

    public void onSoftKeyBoardShow() {
        AppMethodBeat.i(85008);
        this.mXWebProxyImp.onSoftKeyBoardShow();
        AppMethodBeat.o(85008);
    }

    public void onSoftKeyBoardHide(int i) {
        AppMethodBeat.i(85009);
        this.mXWebProxyImp.onSoftKeyBoardHide(i);
        AppMethodBeat.o(85009);
    }

    public void onSetButtonStatus(boolean z, boolean z2) {
        AppMethodBeat.i(85010);
        this.mXWebProxyImp.onSetButtonStatus(z, z2);
        AppMethodBeat.o(85010);
    }

    public void onHistoryItemChanged() {
        AppMethodBeat.i(85011);
        this.mXWebProxyImp.onHistoryItemChanged();
        AppMethodBeat.o(85011);
    }

    public void hideAddressBar() {
        AppMethodBeat.i(85012);
        this.mXWebProxyImp.hideAddressBar();
        AppMethodBeat.o(85012);
    }

    public void handlePluginTag(String str, String str2, boolean z, String str3) {
        AppMethodBeat.i(85013);
        this.mXWebProxyImp.handlePluginTag(str, str2, z, str3);
        AppMethodBeat.o(85013);
    }

    public void onDoubleTapStart() {
        AppMethodBeat.i(85014);
        this.mXWebProxyImp.onDoubleTapStart();
        AppMethodBeat.o(85014);
    }

    public void onPinchToZoomStart() {
        AppMethodBeat.i(85015);
        this.mXWebProxyImp.onPinchToZoomStart();
        AppMethodBeat.o(85015);
    }

    public void onSlidingTitleOffScreen(int i, int i2) {
        AppMethodBeat.i(85016);
        this.mXWebProxyImp.onSlidingTitleOffScreen(i, i2);
        AppMethodBeat.o(85016);
    }

    public void onMissingPluginClicked(String str, String str2, String str3, int i) {
        AppMethodBeat.i(85017);
        this.mXWebProxyImp.onMissingPluginClicked(str, str2, str3, i);
        AppMethodBeat.o(85017);
    }

    public void onReportAdFilterInfo(int i, int i2, String str, boolean z) {
        AppMethodBeat.i(85018);
        this.mXWebProxyImp.onReportAdFilterInfo(i, i2, str, z);
        AppMethodBeat.o(85018);
    }

    public void onReportHtmlInfo(int i, String str) {
        AppMethodBeat.i(85019);
        this.mXWebProxyImp.onReportHtmlInfo(i, str);
        AppMethodBeat.o(85019);
    }

    public void onNativeCrashReport(int i, String str) {
        AppMethodBeat.i(85020);
        this.mXWebProxyImp.onNativeCrashReport(i, str);
        AppMethodBeat.o(85020);
    }

    public Object onMiscCallBack(String str, Bundle bundle) {
        AppMethodBeat.i(85021);
        Object onMiscCallBack = this.mXWebProxyImp.onMiscCallBack(str, bundle);
        AppMethodBeat.o(85021);
        return onMiscCallBack;
    }

    public Object onMiscCallBack(String str, Bundle bundle, Object obj, Object obj2, Object obj3, Object obj4) {
        AppMethodBeat.i(85022);
        Object onMiscCallBack = this.mXWebProxyImp.onMiscCallBack(str, bundle, obj, obj2, obj3, obj4);
        AppMethodBeat.o(85022);
        return onMiscCallBack;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(85023);
        boolean onInterceptTouchEvent = this.mXWebProxyImp.onInterceptTouchEvent(motionEvent, view);
        AppMethodBeat.o(85023);
        return onInterceptTouchEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(85024);
        boolean onTouchEvent = this.mXWebProxyImp.onTouchEvent(motionEvent, view);
        AppMethodBeat.o(85024);
        return onTouchEvent;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(85025);
        boolean dispatchTouchEvent = this.mXWebProxyImp.dispatchTouchEvent(motionEvent, view);
        AppMethodBeat.o(85025);
        return dispatchTouchEvent;
    }

    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
        AppMethodBeat.i(85026);
        boolean overScrollBy = this.mXWebProxyImp.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, view);
        AppMethodBeat.o(85026);
        return overScrollBy;
    }

    public void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        AppMethodBeat.i(85027);
        this.mXWebProxyImp.onScrollChanged(i, i2, i3, i4, view);
        AppMethodBeat.o(85027);
    }

    public void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
        AppMethodBeat.i(85028);
        this.mXWebProxyImp.onOverScrolled(i, i2, z, z2, view);
        AppMethodBeat.o(85028);
    }

    public void computeScroll(View view) {
        AppMethodBeat.i(85029);
        this.mXWebProxyImp.computeScroll(view);
        AppMethodBeat.o(85029);
    }

    public void onMetricsSavedCountReceived(String str, boolean z, long j, String str2, int i) {
        AppMethodBeat.i(85030);
        this.mXWebProxyImp.onMetricsSavedCountReceived(str, z, j, str2, i);
        AppMethodBeat.o(85030);
    }

    public boolean notifyAutoAudioPlay(String str, JsResult jsResult) {
        AppMethodBeat.i(85031);
        boolean notifyAutoAudioPlay = this.mXWebProxyImp.notifyAutoAudioPlay(str, new f(jsResult));
        AppMethodBeat.o(85031);
        return notifyAutoAudioPlay;
    }

    public boolean allowJavaScriptOpenWindowAutomatically(String str, String str2) {
        AppMethodBeat.i(85032);
        boolean allowJavaScriptOpenWindowAutomatically = this.mXWebProxyImp.allowJavaScriptOpenWindowAutomatically(str, str2);
        AppMethodBeat.o(85032);
        return allowJavaScriptOpenWindowAutomatically;
    }

    public boolean notifyJavaScriptOpenWindowsBlocked(String str, String[] strArr, ValueCallback<Boolean> valueCallback, boolean z) {
        AppMethodBeat.i(85033);
        boolean notifyJavaScriptOpenWindowsBlocked = this.mXWebProxyImp.notifyJavaScriptOpenWindowsBlocked(str, strArr, valueCallback, z);
        AppMethodBeat.o(85033);
        return notifyJavaScriptOpenWindowsBlocked;
    }

    public boolean onShowLongClickPopupMenu() {
        AppMethodBeat.i(85034);
        boolean onShowLongClickPopupMenu = this.mXWebProxyImp.onShowLongClickPopupMenu();
        AppMethodBeat.o(85034);
        return onShowLongClickPopupMenu;
    }

    public void onResponseReceived(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse, int i) {
        AppMethodBeat.i(85035);
        this.mXWebProxyImp.onResponseReceived(new g.b(webResourceRequest), g.a(webResourceResponse), i);
        AppMethodBeat.o(85035);
    }

    public void didFirstVisuallyNonEmptyPaint() {
        AppMethodBeat.i(85036);
        this.mXWebProxyImp.didFirstVisuallyNonEmptyPaint();
        AppMethodBeat.o(85036);
    }

    public void documentAvailableInMainFrame() {
        AppMethodBeat.i(85037);
        this.mXWebProxyImp.documentAvailableInMainFrame();
        AppMethodBeat.o(85037);
    }

    public void onReceivedViewSource(String str) {
        AppMethodBeat.i(85038);
        this.mXWebProxyImp.onReceivedViewSource(str);
        AppMethodBeat.o(85038);
    }

    public void onPrefetchResourceHit(boolean z) {
        AppMethodBeat.i(85039);
        this.mXWebProxyImp.onPrefetchResourceHit(z);
        AppMethodBeat.o(85039);
    }

    public void onReceivedSslErrorCancel() {
        AppMethodBeat.i(85040);
        this.mXWebProxyImp.onReceivedSslErrorCancel();
        AppMethodBeat.o(85040);
    }

    public boolean shouldDiscardCurrentPage() {
        AppMethodBeat.i(85041);
        boolean shouldDiscardCurrentPage = this.mXWebProxyImp.shouldDiscardCurrentPage();
        AppMethodBeat.o(85041);
        return shouldDiscardCurrentPage;
    }

    public void hasDiscardCurrentPage(boolean z) {
        AppMethodBeat.i(85042);
        this.mXWebProxyImp.hasDiscardCurrentPage(z);
        AppMethodBeat.o(85042);
    }

    public void super_onPreReadFinished() {
        AppMethodBeat.i(85043);
        super.onPreReadFinished();
        AppMethodBeat.o(85043);
    }

    public void super_onPromptScaleSaved() {
        AppMethodBeat.i(85044);
        super.onPromptScaleSaved();
        AppMethodBeat.o(85044);
    }

    public void super_onUrlChange(String str, String str2) {
        AppMethodBeat.i(85045);
        super.onUrlChange(str, str2);
        AppMethodBeat.o(85045);
    }

    public void super_onHideListBox() {
        AppMethodBeat.i(85046);
        super.onHideListBox();
        AppMethodBeat.o(85046);
    }

    public void super_onShowListBox(String[] strArr, int[] iArr, int[] iArr2, int i) {
        AppMethodBeat.i(85047);
        super.onShowListBox(strArr, iArr, iArr2, i);
        AppMethodBeat.o(85047);
    }

    public void super_onShowMutilListBox(String[] strArr, int[] iArr, int[] iArr2, int[] iArr3) {
        AppMethodBeat.i(85048);
        super.onShowMutilListBox(strArr, iArr, iArr2, iArr3);
        AppMethodBeat.o(85048);
    }

    public void super_onInputBoxTextChanged(IX5WebViewExtension iX5WebViewExtension, String str) {
        AppMethodBeat.i(85049);
        super.onInputBoxTextChanged(iX5WebViewExtension, str);
        AppMethodBeat.o(85049);
    }

    public void super_onTransitionToCommitted() {
        AppMethodBeat.i(85050);
        super.onTransitionToCommitted();
        AppMethodBeat.o(85050);
    }

    public void super_showTranslateBubble(int i, String str, String str2, int i2) {
        AppMethodBeat.i(85051);
        super.showTranslateBubble(i, str, str2, i2);
        AppMethodBeat.o(85051);
    }

    public void super_onUploadProgressStart(int i) {
        AppMethodBeat.i(85052);
        super.onUploadProgressStart(i);
        AppMethodBeat.o(85052);
    }

    public void super_onUploadProgressChange(int i, int i2, String str) {
        AppMethodBeat.i(85053);
        super.onUploadProgressChange(i, i2, str);
        AppMethodBeat.o(85053);
    }

    public void super_onFlingScrollBegin(int i, int i2, int i3) {
        AppMethodBeat.i(85054);
        super.onFlingScrollBegin(i, i2, i3);
        AppMethodBeat.o(85054);
    }

    public void super_onFlingScrollEnd() {
        AppMethodBeat.i(85055);
        super.onFlingScrollEnd();
        AppMethodBeat.o(85055);
    }

    public void super_onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(85056);
        super.onScrollChanged(i, i2, i3, i4);
        AppMethodBeat.o(85056);
    }

    public void super_onSoftKeyBoardShow() {
        AppMethodBeat.i(85057);
        super.onSoftKeyBoardShow();
        AppMethodBeat.o(85057);
    }

    public void super_onSoftKeyBoardHide(int i) {
        AppMethodBeat.i(85058);
        super.onSoftKeyBoardHide(i);
        AppMethodBeat.o(85058);
    }

    public void super_onSetButtonStatus(boolean z, boolean z2) {
        AppMethodBeat.i(85059);
        super.onSetButtonStatus(z, z2);
        AppMethodBeat.o(85059);
    }

    public void super_onHistoryItemChanged() {
        AppMethodBeat.i(85060);
        super.onHistoryItemChanged();
        AppMethodBeat.o(85060);
    }

    public void super_hideAddressBar() {
        AppMethodBeat.i(85061);
        super.hideAddressBar();
        AppMethodBeat.o(85061);
    }

    public void super_handlePluginTag(String str, String str2, boolean z, String str3) {
        AppMethodBeat.i(85062);
        super.handlePluginTag(str, str2, z, str3);
        AppMethodBeat.o(85062);
    }

    public void super_onDoubleTapStart() {
        AppMethodBeat.i(85063);
        super.onDoubleTapStart();
        AppMethodBeat.o(85063);
    }

    public void super_onPinchToZoomStart() {
        AppMethodBeat.i(85064);
        super.onPinchToZoomStart();
        AppMethodBeat.o(85064);
    }

    public void super_onSlidingTitleOffScreen(int i, int i2) {
        AppMethodBeat.i(85065);
        super.onSlidingTitleOffScreen(i, i2);
        AppMethodBeat.o(85065);
    }

    public boolean super_preShouldOverrideUrlLoading(IX5WebViewExtension iX5WebViewExtension, String str) {
        AppMethodBeat.i(85066);
        boolean preShouldOverrideUrlLoading = super.preShouldOverrideUrlLoading(iX5WebViewExtension, str);
        AppMethodBeat.o(85066);
        return preShouldOverrideUrlLoading;
    }

    public void super_onMissingPluginClicked(String str, String str2, String str3, int i) {
        AppMethodBeat.i(85067);
        super.onMissingPluginClicked(str, str2, str3, i);
        AppMethodBeat.o(85067);
    }

    public void super_onReportAdFilterInfo(int i, int i2, String str, boolean z) {
        AppMethodBeat.i(85068);
        super.onReportAdFilterInfo(i, i2, str, z);
        AppMethodBeat.o(85068);
    }

    public void super_onReportHtmlInfo(int i, String str) {
        AppMethodBeat.i(85069);
        super.onReportHtmlInfo(i, str);
        AppMethodBeat.o(85069);
    }

    public void super_onNativeCrashReport(int i, String str) {
        AppMethodBeat.i(85070);
        super.onNativeCrashReport(i, str);
        AppMethodBeat.o(85070);
    }

    public Object super_onMiscCallBack(String str, Bundle bundle) {
        AppMethodBeat.i(85071);
        Object onMiscCallBack = super.onMiscCallBack(str, bundle);
        AppMethodBeat.o(85071);
        return onMiscCallBack;
    }

    public Object super_onMiscCallBack(String str, Bundle bundle, Object obj, Object obj2, Object obj3, Object obj4) {
        AppMethodBeat.i(85072);
        Object onMiscCallBack = super.onMiscCallBack(str, bundle, obj, obj2, obj3, obj4);
        AppMethodBeat.o(85072);
        return onMiscCallBack;
    }

    public boolean super_onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(85073);
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent, view);
        AppMethodBeat.o(85073);
        return onInterceptTouchEvent;
    }

    public boolean super_onTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(85074);
        boolean onTouchEvent = super.onTouchEvent(motionEvent, view);
        AppMethodBeat.o(85074);
        return onTouchEvent;
    }

    public boolean super_dispatchTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(85075);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent, view);
        AppMethodBeat.o(85075);
        return dispatchTouchEvent;
    }

    public boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
        AppMethodBeat.i(85076);
        boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, view);
        AppMethodBeat.o(85076);
        return overScrollBy;
    }

    public void super_onScrollChanged(int i, int i2, int i3, int i4, View view) {
        AppMethodBeat.i(85077);
        super.onScrollChanged(i, i2, i3, i4, view);
        AppMethodBeat.o(85077);
    }

    public void super_onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
        AppMethodBeat.i(85078);
        super.onOverScrolled(i, i2, z, z2, view);
        AppMethodBeat.o(85078);
    }

    public void super_computeScroll(View view) {
        AppMethodBeat.i(85079);
        super.computeScroll(view);
        AppMethodBeat.o(85079);
    }

    public void super_onMetricsSavedCountReceived(String str, boolean z, long j, String str2, int i) {
        AppMethodBeat.i(85080);
        super.onMetricsSavedCountReceived(str, z, j, str2, i);
        AppMethodBeat.o(85080);
    }

    public boolean super_notifyAutoAudioPlay(String str, h hVar) {
        AppMethodBeat.i(85081);
        boolean notifyAutoAudioPlay = super.notifyAutoAudioPlay(str, new c(hVar));
        AppMethodBeat.o(85081);
        return notifyAutoAudioPlay;
    }

    public boolean super_allowJavaScriptOpenWindowAutomatically(String str, String str2) {
        AppMethodBeat.i(85082);
        boolean allowJavaScriptOpenWindowAutomatically = super.allowJavaScriptOpenWindowAutomatically(str, str2);
        AppMethodBeat.o(85082);
        return allowJavaScriptOpenWindowAutomatically;
    }

    public boolean super_notifyJavaScriptOpenWindowsBlocked(String str, String[] strArr, ValueCallback<Boolean> valueCallback, boolean z) {
        AppMethodBeat.i(85083);
        boolean notifyJavaScriptOpenWindowsBlocked = super.notifyJavaScriptOpenWindowsBlocked(str, strArr, valueCallback, z);
        AppMethodBeat.o(85083);
        return notifyJavaScriptOpenWindowsBlocked;
    }

    public boolean super_onShowLongClickPopupMenu() {
        AppMethodBeat.i(85084);
        boolean onShowLongClickPopupMenu = super.onShowLongClickPopupMenu();
        AppMethodBeat.o(85084);
        return onShowLongClickPopupMenu;
    }

    public void super_onResponseReceived(n nVar, o oVar, int i) {
        AppMethodBeat.i(85085);
        super.onResponseReceived(e.a(nVar), com.tencent.xweb.x5.a.b(oVar), i);
        AppMethodBeat.o(85085);
    }

    public void super_didFirstVisuallyNonEmptyPaint() {
        AppMethodBeat.i(85086);
        super.didFirstVisuallyNonEmptyPaint();
        AppMethodBeat.o(85086);
    }

    public void super_documentAvailableInMainFrame() {
        AppMethodBeat.i(85087);
        super.documentAvailableInMainFrame();
        AppMethodBeat.o(85087);
    }

    public void super_onReceivedViewSource(String str) {
        AppMethodBeat.i(85088);
        super.onReceivedViewSource(str);
        AppMethodBeat.o(85088);
    }

    public void super_onPrefetchResourceHit(boolean z) {
        AppMethodBeat.i(85089);
        super.onPrefetchResourceHit(z);
        AppMethodBeat.o(85089);
    }

    public void super_onReceivedSslErrorCancel() {
        AppMethodBeat.i(85090);
        super.onReceivedSslErrorCancel();
        AppMethodBeat.o(85090);
    }
}
