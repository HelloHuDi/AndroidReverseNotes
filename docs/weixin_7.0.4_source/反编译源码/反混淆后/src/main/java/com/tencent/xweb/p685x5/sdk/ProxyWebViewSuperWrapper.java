package com.tencent.xweb.p685x5.sdk;

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
import com.tencent.xweb.C24530n;
import com.tencent.xweb.C31147o;
import com.tencent.xweb.C46945h;
import com.tencent.xweb.p685x5.C24535a;
import com.tencent.xweb.p685x5.C24535a.C24536e;
import com.tencent.xweb.p685x5.C24535a.C24540c;
import com.tencent.xweb.p685x5.C46836g;
import com.tencent.xweb.p685x5.C46836g.C24542f;
import com.tencent.xweb.p685x5.C46836g.C31151b;
import com.tencent.xweb.p685x5.p1116a.p1117a.p1118a.p1119a.C16404b;
import com.tencent.xweb.p685x5.p1116a.p1117a.p1118a.p1119a.C46834a;

/* renamed from: com.tencent.xweb.x5.sdk.ProxyWebViewSuperWrapper */
public class ProxyWebViewSuperWrapper extends ProxyWebViewClientExtension implements C46834a {
    C16404b mXWebProxyImp;

    public void invalidate() {
    }

    public ProxyWebViewSuperWrapper(C16404b c16404b) {
        AppMethodBeat.m2504i(84994);
        this.mXWebProxyImp = c16404b;
        this.mXWebProxyImp.setSuperProvider(this);
        AppMethodBeat.m2505o(84994);
    }

    public void onPreReadFinished() {
        AppMethodBeat.m2504i(84995);
        this.mXWebProxyImp.onPreReadFinished();
        AppMethodBeat.m2505o(84995);
    }

    public void onPromptScaleSaved() {
        AppMethodBeat.m2504i(84996);
        this.mXWebProxyImp.onPromptScaleSaved();
        AppMethodBeat.m2505o(84996);
    }

    public void onUrlChange(String str, String str2) {
        AppMethodBeat.m2504i(84997);
        this.mXWebProxyImp.onUrlChange(str, str2);
        AppMethodBeat.m2505o(84997);
    }

    public void onHideListBox() {
        AppMethodBeat.m2504i(84998);
        this.mXWebProxyImp.onHideListBox();
        AppMethodBeat.m2505o(84998);
    }

    public void onShowListBox(String[] strArr, int[] iArr, int[] iArr2, int i) {
        AppMethodBeat.m2504i(84999);
        this.mXWebProxyImp.onShowListBox(strArr, iArr, iArr2, i);
        AppMethodBeat.m2505o(84999);
    }

    public void onShowMutilListBox(String[] strArr, int[] iArr, int[] iArr2, int[] iArr3) {
        AppMethodBeat.m2504i(85000);
        this.mXWebProxyImp.onShowMutilListBox(strArr, iArr, iArr2, iArr3);
        AppMethodBeat.m2505o(85000);
    }

    public void onTransitionToCommitted() {
        AppMethodBeat.m2504i(85001);
        this.mXWebProxyImp.onTransitionToCommitted();
        AppMethodBeat.m2505o(85001);
    }

    public void showTranslateBubble(int i, String str, String str2, int i2) {
        AppMethodBeat.m2504i(85002);
        this.mXWebProxyImp.showTranslateBubble(i, str, str2, i2);
        AppMethodBeat.m2505o(85002);
    }

    public void onUploadProgressStart(int i) {
        AppMethodBeat.m2504i(85003);
        this.mXWebProxyImp.onUploadProgressStart(i);
        AppMethodBeat.m2505o(85003);
    }

    public void onUploadProgressChange(int i, int i2, String str) {
        AppMethodBeat.m2504i(85004);
        this.mXWebProxyImp.onUploadProgressChange(i, i2, str);
        AppMethodBeat.m2505o(85004);
    }

    public void onFlingScrollBegin(int i, int i2, int i3) {
        AppMethodBeat.m2504i(85005);
        this.mXWebProxyImp.onFlingScrollBegin(i, i2, i3);
        AppMethodBeat.m2505o(85005);
    }

    public void onFlingScrollEnd() {
        AppMethodBeat.m2504i(85006);
        this.mXWebProxyImp.onFlingScrollEnd();
        AppMethodBeat.m2505o(85006);
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(85007);
        this.mXWebProxyImp.onScrollChanged(i, i2, i3, i4);
        AppMethodBeat.m2505o(85007);
    }

    public void onSoftKeyBoardShow() {
        AppMethodBeat.m2504i(85008);
        this.mXWebProxyImp.onSoftKeyBoardShow();
        AppMethodBeat.m2505o(85008);
    }

    public void onSoftKeyBoardHide(int i) {
        AppMethodBeat.m2504i(85009);
        this.mXWebProxyImp.onSoftKeyBoardHide(i);
        AppMethodBeat.m2505o(85009);
    }

    public void onSetButtonStatus(boolean z, boolean z2) {
        AppMethodBeat.m2504i(85010);
        this.mXWebProxyImp.onSetButtonStatus(z, z2);
        AppMethodBeat.m2505o(85010);
    }

    public void onHistoryItemChanged() {
        AppMethodBeat.m2504i(85011);
        this.mXWebProxyImp.onHistoryItemChanged();
        AppMethodBeat.m2505o(85011);
    }

    public void hideAddressBar() {
        AppMethodBeat.m2504i(85012);
        this.mXWebProxyImp.hideAddressBar();
        AppMethodBeat.m2505o(85012);
    }

    public void handlePluginTag(String str, String str2, boolean z, String str3) {
        AppMethodBeat.m2504i(85013);
        this.mXWebProxyImp.handlePluginTag(str, str2, z, str3);
        AppMethodBeat.m2505o(85013);
    }

    public void onDoubleTapStart() {
        AppMethodBeat.m2504i(85014);
        this.mXWebProxyImp.onDoubleTapStart();
        AppMethodBeat.m2505o(85014);
    }

    public void onPinchToZoomStart() {
        AppMethodBeat.m2504i(85015);
        this.mXWebProxyImp.onPinchToZoomStart();
        AppMethodBeat.m2505o(85015);
    }

    public void onSlidingTitleOffScreen(int i, int i2) {
        AppMethodBeat.m2504i(85016);
        this.mXWebProxyImp.onSlidingTitleOffScreen(i, i2);
        AppMethodBeat.m2505o(85016);
    }

    public void onMissingPluginClicked(String str, String str2, String str3, int i) {
        AppMethodBeat.m2504i(85017);
        this.mXWebProxyImp.onMissingPluginClicked(str, str2, str3, i);
        AppMethodBeat.m2505o(85017);
    }

    public void onReportAdFilterInfo(int i, int i2, String str, boolean z) {
        AppMethodBeat.m2504i(85018);
        this.mXWebProxyImp.onReportAdFilterInfo(i, i2, str, z);
        AppMethodBeat.m2505o(85018);
    }

    public void onReportHtmlInfo(int i, String str) {
        AppMethodBeat.m2504i(85019);
        this.mXWebProxyImp.onReportHtmlInfo(i, str);
        AppMethodBeat.m2505o(85019);
    }

    public void onNativeCrashReport(int i, String str) {
        AppMethodBeat.m2504i(85020);
        this.mXWebProxyImp.onNativeCrashReport(i, str);
        AppMethodBeat.m2505o(85020);
    }

    public Object onMiscCallBack(String str, Bundle bundle) {
        AppMethodBeat.m2504i(85021);
        Object onMiscCallBack = this.mXWebProxyImp.onMiscCallBack(str, bundle);
        AppMethodBeat.m2505o(85021);
        return onMiscCallBack;
    }

    public Object onMiscCallBack(String str, Bundle bundle, Object obj, Object obj2, Object obj3, Object obj4) {
        AppMethodBeat.m2504i(85022);
        Object onMiscCallBack = this.mXWebProxyImp.onMiscCallBack(str, bundle, obj, obj2, obj3, obj4);
        AppMethodBeat.m2505o(85022);
        return onMiscCallBack;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.m2504i(85023);
        boolean onInterceptTouchEvent = this.mXWebProxyImp.onInterceptTouchEvent(motionEvent, view);
        AppMethodBeat.m2505o(85023);
        return onInterceptTouchEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.m2504i(85024);
        boolean onTouchEvent = this.mXWebProxyImp.onTouchEvent(motionEvent, view);
        AppMethodBeat.m2505o(85024);
        return onTouchEvent;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.m2504i(85025);
        boolean dispatchTouchEvent = this.mXWebProxyImp.dispatchTouchEvent(motionEvent, view);
        AppMethodBeat.m2505o(85025);
        return dispatchTouchEvent;
    }

    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
        AppMethodBeat.m2504i(85026);
        boolean overScrollBy = this.mXWebProxyImp.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, view);
        AppMethodBeat.m2505o(85026);
        return overScrollBy;
    }

    public void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        AppMethodBeat.m2504i(85027);
        this.mXWebProxyImp.onScrollChanged(i, i2, i3, i4, view);
        AppMethodBeat.m2505o(85027);
    }

    public void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
        AppMethodBeat.m2504i(85028);
        this.mXWebProxyImp.onOverScrolled(i, i2, z, z2, view);
        AppMethodBeat.m2505o(85028);
    }

    public void computeScroll(View view) {
        AppMethodBeat.m2504i(85029);
        this.mXWebProxyImp.computeScroll(view);
        AppMethodBeat.m2505o(85029);
    }

    public void onMetricsSavedCountReceived(String str, boolean z, long j, String str2, int i) {
        AppMethodBeat.m2504i(85030);
        this.mXWebProxyImp.onMetricsSavedCountReceived(str, z, j, str2, i);
        AppMethodBeat.m2505o(85030);
    }

    public boolean notifyAutoAudioPlay(String str, JsResult jsResult) {
        AppMethodBeat.m2504i(85031);
        boolean notifyAutoAudioPlay = this.mXWebProxyImp.notifyAutoAudioPlay(str, new C24542f(jsResult));
        AppMethodBeat.m2505o(85031);
        return notifyAutoAudioPlay;
    }

    public boolean allowJavaScriptOpenWindowAutomatically(String str, String str2) {
        AppMethodBeat.m2504i(85032);
        boolean allowJavaScriptOpenWindowAutomatically = this.mXWebProxyImp.allowJavaScriptOpenWindowAutomatically(str, str2);
        AppMethodBeat.m2505o(85032);
        return allowJavaScriptOpenWindowAutomatically;
    }

    public boolean notifyJavaScriptOpenWindowsBlocked(String str, String[] strArr, ValueCallback<Boolean> valueCallback, boolean z) {
        AppMethodBeat.m2504i(85033);
        boolean notifyJavaScriptOpenWindowsBlocked = this.mXWebProxyImp.notifyJavaScriptOpenWindowsBlocked(str, strArr, valueCallback, z);
        AppMethodBeat.m2505o(85033);
        return notifyJavaScriptOpenWindowsBlocked;
    }

    public boolean onShowLongClickPopupMenu() {
        AppMethodBeat.m2504i(85034);
        boolean onShowLongClickPopupMenu = this.mXWebProxyImp.onShowLongClickPopupMenu();
        AppMethodBeat.m2505o(85034);
        return onShowLongClickPopupMenu;
    }

    public void onResponseReceived(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse, int i) {
        AppMethodBeat.m2504i(85035);
        this.mXWebProxyImp.onResponseReceived(new C31151b(webResourceRequest), C46836g.m89071a(webResourceResponse), i);
        AppMethodBeat.m2505o(85035);
    }

    public void didFirstVisuallyNonEmptyPaint() {
        AppMethodBeat.m2504i(85036);
        this.mXWebProxyImp.didFirstVisuallyNonEmptyPaint();
        AppMethodBeat.m2505o(85036);
    }

    public void documentAvailableInMainFrame() {
        AppMethodBeat.m2504i(85037);
        this.mXWebProxyImp.documentAvailableInMainFrame();
        AppMethodBeat.m2505o(85037);
    }

    public void onReceivedViewSource(String str) {
        AppMethodBeat.m2504i(85038);
        this.mXWebProxyImp.onReceivedViewSource(str);
        AppMethodBeat.m2505o(85038);
    }

    public void onPrefetchResourceHit(boolean z) {
        AppMethodBeat.m2504i(85039);
        this.mXWebProxyImp.onPrefetchResourceHit(z);
        AppMethodBeat.m2505o(85039);
    }

    public void onReceivedSslErrorCancel() {
        AppMethodBeat.m2504i(85040);
        this.mXWebProxyImp.onReceivedSslErrorCancel();
        AppMethodBeat.m2505o(85040);
    }

    public boolean shouldDiscardCurrentPage() {
        AppMethodBeat.m2504i(85041);
        boolean shouldDiscardCurrentPage = this.mXWebProxyImp.shouldDiscardCurrentPage();
        AppMethodBeat.m2505o(85041);
        return shouldDiscardCurrentPage;
    }

    public void hasDiscardCurrentPage(boolean z) {
        AppMethodBeat.m2504i(85042);
        this.mXWebProxyImp.hasDiscardCurrentPage(z);
        AppMethodBeat.m2505o(85042);
    }

    public void super_onPreReadFinished() {
        AppMethodBeat.m2504i(85043);
        super.onPreReadFinished();
        AppMethodBeat.m2505o(85043);
    }

    public void super_onPromptScaleSaved() {
        AppMethodBeat.m2504i(85044);
        super.onPromptScaleSaved();
        AppMethodBeat.m2505o(85044);
    }

    public void super_onUrlChange(String str, String str2) {
        AppMethodBeat.m2504i(85045);
        super.onUrlChange(str, str2);
        AppMethodBeat.m2505o(85045);
    }

    public void super_onHideListBox() {
        AppMethodBeat.m2504i(85046);
        super.onHideListBox();
        AppMethodBeat.m2505o(85046);
    }

    public void super_onShowListBox(String[] strArr, int[] iArr, int[] iArr2, int i) {
        AppMethodBeat.m2504i(85047);
        super.onShowListBox(strArr, iArr, iArr2, i);
        AppMethodBeat.m2505o(85047);
    }

    public void super_onShowMutilListBox(String[] strArr, int[] iArr, int[] iArr2, int[] iArr3) {
        AppMethodBeat.m2504i(85048);
        super.onShowMutilListBox(strArr, iArr, iArr2, iArr3);
        AppMethodBeat.m2505o(85048);
    }

    public void super_onInputBoxTextChanged(IX5WebViewExtension iX5WebViewExtension, String str) {
        AppMethodBeat.m2504i(85049);
        super.onInputBoxTextChanged(iX5WebViewExtension, str);
        AppMethodBeat.m2505o(85049);
    }

    public void super_onTransitionToCommitted() {
        AppMethodBeat.m2504i(85050);
        super.onTransitionToCommitted();
        AppMethodBeat.m2505o(85050);
    }

    public void super_showTranslateBubble(int i, String str, String str2, int i2) {
        AppMethodBeat.m2504i(85051);
        super.showTranslateBubble(i, str, str2, i2);
        AppMethodBeat.m2505o(85051);
    }

    public void super_onUploadProgressStart(int i) {
        AppMethodBeat.m2504i(85052);
        super.onUploadProgressStart(i);
        AppMethodBeat.m2505o(85052);
    }

    public void super_onUploadProgressChange(int i, int i2, String str) {
        AppMethodBeat.m2504i(85053);
        super.onUploadProgressChange(i, i2, str);
        AppMethodBeat.m2505o(85053);
    }

    public void super_onFlingScrollBegin(int i, int i2, int i3) {
        AppMethodBeat.m2504i(85054);
        super.onFlingScrollBegin(i, i2, i3);
        AppMethodBeat.m2505o(85054);
    }

    public void super_onFlingScrollEnd() {
        AppMethodBeat.m2504i(85055);
        super.onFlingScrollEnd();
        AppMethodBeat.m2505o(85055);
    }

    public void super_onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(85056);
        super.onScrollChanged(i, i2, i3, i4);
        AppMethodBeat.m2505o(85056);
    }

    public void super_onSoftKeyBoardShow() {
        AppMethodBeat.m2504i(85057);
        super.onSoftKeyBoardShow();
        AppMethodBeat.m2505o(85057);
    }

    public void super_onSoftKeyBoardHide(int i) {
        AppMethodBeat.m2504i(85058);
        super.onSoftKeyBoardHide(i);
        AppMethodBeat.m2505o(85058);
    }

    public void super_onSetButtonStatus(boolean z, boolean z2) {
        AppMethodBeat.m2504i(85059);
        super.onSetButtonStatus(z, z2);
        AppMethodBeat.m2505o(85059);
    }

    public void super_onHistoryItemChanged() {
        AppMethodBeat.m2504i(85060);
        super.onHistoryItemChanged();
        AppMethodBeat.m2505o(85060);
    }

    public void super_hideAddressBar() {
        AppMethodBeat.m2504i(85061);
        super.hideAddressBar();
        AppMethodBeat.m2505o(85061);
    }

    public void super_handlePluginTag(String str, String str2, boolean z, String str3) {
        AppMethodBeat.m2504i(85062);
        super.handlePluginTag(str, str2, z, str3);
        AppMethodBeat.m2505o(85062);
    }

    public void super_onDoubleTapStart() {
        AppMethodBeat.m2504i(85063);
        super.onDoubleTapStart();
        AppMethodBeat.m2505o(85063);
    }

    public void super_onPinchToZoomStart() {
        AppMethodBeat.m2504i(85064);
        super.onPinchToZoomStart();
        AppMethodBeat.m2505o(85064);
    }

    public void super_onSlidingTitleOffScreen(int i, int i2) {
        AppMethodBeat.m2504i(85065);
        super.onSlidingTitleOffScreen(i, i2);
        AppMethodBeat.m2505o(85065);
    }

    public boolean super_preShouldOverrideUrlLoading(IX5WebViewExtension iX5WebViewExtension, String str) {
        AppMethodBeat.m2504i(85066);
        boolean preShouldOverrideUrlLoading = super.preShouldOverrideUrlLoading(iX5WebViewExtension, str);
        AppMethodBeat.m2505o(85066);
        return preShouldOverrideUrlLoading;
    }

    public void super_onMissingPluginClicked(String str, String str2, String str3, int i) {
        AppMethodBeat.m2504i(85067);
        super.onMissingPluginClicked(str, str2, str3, i);
        AppMethodBeat.m2505o(85067);
    }

    public void super_onReportAdFilterInfo(int i, int i2, String str, boolean z) {
        AppMethodBeat.m2504i(85068);
        super.onReportAdFilterInfo(i, i2, str, z);
        AppMethodBeat.m2505o(85068);
    }

    public void super_onReportHtmlInfo(int i, String str) {
        AppMethodBeat.m2504i(85069);
        super.onReportHtmlInfo(i, str);
        AppMethodBeat.m2505o(85069);
    }

    public void super_onNativeCrashReport(int i, String str) {
        AppMethodBeat.m2504i(85070);
        super.onNativeCrashReport(i, str);
        AppMethodBeat.m2505o(85070);
    }

    public Object super_onMiscCallBack(String str, Bundle bundle) {
        AppMethodBeat.m2504i(85071);
        Object onMiscCallBack = super.onMiscCallBack(str, bundle);
        AppMethodBeat.m2505o(85071);
        return onMiscCallBack;
    }

    public Object super_onMiscCallBack(String str, Bundle bundle, Object obj, Object obj2, Object obj3, Object obj4) {
        AppMethodBeat.m2504i(85072);
        Object onMiscCallBack = super.onMiscCallBack(str, bundle, obj, obj2, obj3, obj4);
        AppMethodBeat.m2505o(85072);
        return onMiscCallBack;
    }

    public boolean super_onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.m2504i(85073);
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent, view);
        AppMethodBeat.m2505o(85073);
        return onInterceptTouchEvent;
    }

    public boolean super_onTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.m2504i(85074);
        boolean onTouchEvent = super.onTouchEvent(motionEvent, view);
        AppMethodBeat.m2505o(85074);
        return onTouchEvent;
    }

    public boolean super_dispatchTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.m2504i(85075);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent, view);
        AppMethodBeat.m2505o(85075);
        return dispatchTouchEvent;
    }

    public boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
        AppMethodBeat.m2504i(85076);
        boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, view);
        AppMethodBeat.m2505o(85076);
        return overScrollBy;
    }

    public void super_onScrollChanged(int i, int i2, int i3, int i4, View view) {
        AppMethodBeat.m2504i(85077);
        super.onScrollChanged(i, i2, i3, i4, view);
        AppMethodBeat.m2505o(85077);
    }

    public void super_onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
        AppMethodBeat.m2504i(85078);
        super.onOverScrolled(i, i2, z, z2, view);
        AppMethodBeat.m2505o(85078);
    }

    public void super_computeScroll(View view) {
        AppMethodBeat.m2504i(85079);
        super.computeScroll(view);
        AppMethodBeat.m2505o(85079);
    }

    public void super_onMetricsSavedCountReceived(String str, boolean z, long j, String str2, int i) {
        AppMethodBeat.m2504i(85080);
        super.onMetricsSavedCountReceived(str, z, j, str2, i);
        AppMethodBeat.m2505o(85080);
    }

    public boolean super_notifyAutoAudioPlay(String str, C46945h c46945h) {
        AppMethodBeat.m2504i(85081);
        boolean notifyAutoAudioPlay = super.notifyAutoAudioPlay(str, new C24540c(c46945h));
        AppMethodBeat.m2505o(85081);
        return notifyAutoAudioPlay;
    }

    public boolean super_allowJavaScriptOpenWindowAutomatically(String str, String str2) {
        AppMethodBeat.m2504i(85082);
        boolean allowJavaScriptOpenWindowAutomatically = super.allowJavaScriptOpenWindowAutomatically(str, str2);
        AppMethodBeat.m2505o(85082);
        return allowJavaScriptOpenWindowAutomatically;
    }

    public boolean super_notifyJavaScriptOpenWindowsBlocked(String str, String[] strArr, ValueCallback<Boolean> valueCallback, boolean z) {
        AppMethodBeat.m2504i(85083);
        boolean notifyJavaScriptOpenWindowsBlocked = super.notifyJavaScriptOpenWindowsBlocked(str, strArr, valueCallback, z);
        AppMethodBeat.m2505o(85083);
        return notifyJavaScriptOpenWindowsBlocked;
    }

    public boolean super_onShowLongClickPopupMenu() {
        AppMethodBeat.m2504i(85084);
        boolean onShowLongClickPopupMenu = super.onShowLongClickPopupMenu();
        AppMethodBeat.m2505o(85084);
        return onShowLongClickPopupMenu;
    }

    public void super_onResponseReceived(C24530n c24530n, C31147o c31147o, int i) {
        AppMethodBeat.m2504i(85085);
        super.onResponseReceived(C24536e.m38192a(c24530n), C24535a.m38191b(c31147o), i);
        AppMethodBeat.m2505o(85085);
    }

    public void super_didFirstVisuallyNonEmptyPaint() {
        AppMethodBeat.m2504i(85086);
        super.didFirstVisuallyNonEmptyPaint();
        AppMethodBeat.m2505o(85086);
    }

    public void super_documentAvailableInMainFrame() {
        AppMethodBeat.m2504i(85087);
        super.documentAvailableInMainFrame();
        AppMethodBeat.m2505o(85087);
    }

    public void super_onReceivedViewSource(String str) {
        AppMethodBeat.m2504i(85088);
        super.onReceivedViewSource(str);
        AppMethodBeat.m2505o(85088);
    }

    public void super_onPrefetchResourceHit(boolean z) {
        AppMethodBeat.m2504i(85089);
        super.onPrefetchResourceHit(z);
        AppMethodBeat.m2505o(85089);
    }

    public void super_onReceivedSslErrorCancel() {
        AppMethodBeat.m2504i(85090);
        super.onReceivedSslErrorCancel();
        AppMethodBeat.m2505o(85090);
    }
}
