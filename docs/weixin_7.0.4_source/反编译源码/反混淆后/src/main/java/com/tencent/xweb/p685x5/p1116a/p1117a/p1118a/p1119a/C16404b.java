package com.tencent.xweb.p685x5.p1116a.p1117a.p1118a.p1119a;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.xweb.C24530n;
import com.tencent.xweb.C31147o;
import com.tencent.xweb.C46945h;
import org.xwalk.core.Log;

/* renamed from: com.tencent.xweb.x5.a.a.a.a.b */
public class C16404b {
    private static final String TAG = "ProxyWebViewClientExtension";
    C46834a mSuperProvider;

    public void setSuperProvider(C46834a c46834a) {
        this.mSuperProvider = c46834a;
    }

    public void onMissingPluginClicked(String str, String str2, String str3, int i) {
        AppMethodBeat.m2504i(4089);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onMissingPluginClicked(str, str2, str3, i);
        }
        AppMethodBeat.m2505o(4089);
    }

    public void onHideListBox() {
        AppMethodBeat.m2504i(4090);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onHideListBox();
        }
        AppMethodBeat.m2505o(4090);
    }

    public void onShowListBox(String[] strArr, int[] iArr, int[] iArr2, int i) {
        AppMethodBeat.m2504i(4091);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onShowListBox(strArr, iArr, iArr2, i);
        }
        AppMethodBeat.m2505o(4091);
    }

    public void onShowMutilListBox(String[] strArr, int[] iArr, int[] iArr2, int[] iArr3) {
        AppMethodBeat.m2504i(4092);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onShowMutilListBox(strArr, iArr, iArr2, iArr3);
        }
        AppMethodBeat.m2505o(4092);
    }

    public void onFlingScrollBegin(int i, int i2, int i3) {
        AppMethodBeat.m2504i(4093);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onFlingScrollBegin(i, i2, i3);
        }
        AppMethodBeat.m2505o(4093);
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(4094);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onScrollChanged(i, i2, i3, i4);
        }
        AppMethodBeat.m2505o(4094);
    }

    public void onTransitionToCommitted() {
        AppMethodBeat.m2504i(4095);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onTransitionToCommitted();
        }
        AppMethodBeat.m2505o(4095);
    }

    public void onUploadProgressStart(int i) {
        AppMethodBeat.m2504i(4096);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onUploadProgressStart(i);
        }
        AppMethodBeat.m2505o(4096);
    }

    public void onUploadProgressChange(int i, int i2, String str) {
        AppMethodBeat.m2504i(4097);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onUploadProgressChange(i, i2, str);
        }
        AppMethodBeat.m2505o(4097);
    }

    public void onSoftKeyBoardShow() {
        AppMethodBeat.m2504i(4098);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onSoftKeyBoardShow();
        }
        AppMethodBeat.m2505o(4098);
    }

    public void onSoftKeyBoardHide(int i) {
        AppMethodBeat.m2504i(4099);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onSoftKeyBoardHide(i);
        }
        AppMethodBeat.m2505o(4099);
    }

    public void onSetButtonStatus(boolean z, boolean z2) {
        AppMethodBeat.m2504i(4100);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onSetButtonStatus(z, z2);
        }
        AppMethodBeat.m2505o(4100);
    }

    public void onHistoryItemChanged() {
        AppMethodBeat.m2504i(4101);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onHistoryItemChanged();
        }
        AppMethodBeat.m2505o(4101);
    }

    public void hideAddressBar() {
        AppMethodBeat.m2504i(4102);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_hideAddressBar();
        }
        AppMethodBeat.m2505o(4102);
    }

    public void handlePluginTag(String str, String str2, boolean z, String str3) {
        AppMethodBeat.m2504i(4103);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_handlePluginTag(str, str2, z, str3);
        }
        AppMethodBeat.m2505o(4103);
    }

    public void onDoubleTapStart() {
        AppMethodBeat.m2504i(4104);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onDoubleTapStart();
        }
        AppMethodBeat.m2505o(4104);
    }

    public void onPinchToZoomStart() {
        AppMethodBeat.m2504i(4105);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onPinchToZoomStart();
        }
        AppMethodBeat.m2505o(4105);
    }

    public void onSlidingTitleOffScreen(int i, int i2) {
        AppMethodBeat.m2504i(4106);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onSlidingTitleOffScreen(i, i2);
        }
        AppMethodBeat.m2505o(4106);
    }

    public void onPreReadFinished() {
        AppMethodBeat.m2504i(4107);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onPreReadFinished();
        }
        AppMethodBeat.m2505o(4107);
    }

    public void onPromptScaleSaved() {
        AppMethodBeat.m2504i(4108);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onPromptScaleSaved();
        }
        AppMethodBeat.m2505o(4108);
    }

    public void onFlingScrollEnd() {
        AppMethodBeat.m2504i(4109);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onFlingScrollEnd();
        }
        AppMethodBeat.m2505o(4109);
    }

    public void onUrlChange(String str, String str2) {
        AppMethodBeat.m2504i(4110);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onUrlChange(str, str2);
        }
        AppMethodBeat.m2505o(4110);
    }

    public void onReportAdFilterInfo(int i, int i2, String str, boolean z) {
        AppMethodBeat.m2504i(4111);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onReportAdFilterInfo(i, i2, str, z);
        }
        AppMethodBeat.m2505o(4111);
    }

    public void onNativeCrashReport(int i, String str) {
        AppMethodBeat.m2504i(4112);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onNativeCrashReport(i, str);
        }
        AppMethodBeat.m2505o(4112);
    }

    public Object onMiscCallBack(String str, Bundle bundle) {
        AppMethodBeat.m2504i(4113);
        if (this.mSuperProvider != null) {
            Object super_onMiscCallBack = this.mSuperProvider.super_onMiscCallBack(str, bundle);
            AppMethodBeat.m2505o(4113);
            return super_onMiscCallBack;
        }
        AppMethodBeat.m2505o(4113);
        return null;
    }

    public void onReportHtmlInfo(int i, String str) {
        AppMethodBeat.m2504i(4114);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onReportHtmlInfo(i, str);
        }
        AppMethodBeat.m2505o(4114);
    }

    public Object onMiscCallBack(String str, Bundle bundle, Object obj, Object obj2, Object obj3, Object obj4) {
        AppMethodBeat.m2504i(4115);
        if (this.mSuperProvider != null) {
            Object super_onMiscCallBack = this.mSuperProvider.super_onMiscCallBack(str, bundle, obj, obj2, obj3, obj4);
            AppMethodBeat.m2505o(4115);
            return super_onMiscCallBack;
        }
        AppMethodBeat.m2505o(4115);
        return null;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.m2504i(4116);
        if (this.mSuperProvider != null) {
            boolean super_onInterceptTouchEvent = this.mSuperProvider.super_onInterceptTouchEvent(motionEvent, view);
            AppMethodBeat.m2505o(4116);
            return super_onInterceptTouchEvent;
        }
        Log.m81046e(TAG, "mSuperProvider Is null");
        AppMethodBeat.m2505o(4116);
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.m2504i(4117);
        if (this.mSuperProvider != null) {
            boolean super_onTouchEvent = this.mSuperProvider.super_onTouchEvent(motionEvent, view);
            AppMethodBeat.m2505o(4117);
            return super_onTouchEvent;
        }
        Log.m81046e(TAG, "mSuperProvider Is null");
        AppMethodBeat.m2505o(4117);
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.m2504i(4118);
        if (this.mSuperProvider != null) {
            boolean super_dispatchTouchEvent = this.mSuperProvider.super_dispatchTouchEvent(motionEvent, view);
            AppMethodBeat.m2505o(4118);
            return super_dispatchTouchEvent;
        }
        Log.m81046e(TAG, "mSuperProvider Is null");
        AppMethodBeat.m2505o(4118);
        return false;
    }

    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
        AppMethodBeat.m2504i(4119);
        if (this.mSuperProvider != null) {
            boolean super_overScrollBy = this.mSuperProvider.super_overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, view);
            AppMethodBeat.m2505o(4119);
            return super_overScrollBy;
        }
        Log.m81046e(TAG, "mSuperProvider Is null");
        AppMethodBeat.m2505o(4119);
        return false;
    }

    public void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        AppMethodBeat.m2504i(4120);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onScrollChanged(i, i2, i3, i4, view);
            AppMethodBeat.m2505o(4120);
            return;
        }
        Log.m81046e(TAG, "mSuperProvider Is null");
        AppMethodBeat.m2505o(4120);
    }

    public void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
        AppMethodBeat.m2504i(ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITH_CORE);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onOverScrolled(i, i2, z, z2, view);
            AppMethodBeat.m2505o(ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITH_CORE);
            return;
        }
        Log.m81046e(TAG, "mSuperProvider Is null");
        AppMethodBeat.m2505o(ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITH_CORE);
    }

    public void computeScroll(View view) {
        AppMethodBeat.m2504i(ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITHOUT_CORE);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_computeScroll(view);
        }
        AppMethodBeat.m2505o(ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITHOUT_CORE);
    }

    public void onMetricsSavedCountReceived(String str, boolean z, long j, String str2, int i) {
        AppMethodBeat.m2504i(4123);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onMetricsSavedCountReceived(str, z, j, str2, i);
            AppMethodBeat.m2505o(4123);
            return;
        }
        Log.m81046e(TAG, "mSuperProvider Is null");
        AppMethodBeat.m2505o(4123);
    }

    public void showTranslateBubble(int i, String str, String str2, int i2) {
        AppMethodBeat.m2504i(4124);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_showTranslateBubble(i, str, str2, i2);
            AppMethodBeat.m2505o(4124);
            return;
        }
        Log.m81046e(TAG, "mSuperProvider Is null");
        AppMethodBeat.m2505o(4124);
    }

    public boolean notifyAutoAudioPlay(String str, C46945h c46945h) {
        AppMethodBeat.m2504i(4125);
        if (this.mSuperProvider != null) {
            boolean super_notifyAutoAudioPlay = this.mSuperProvider.super_notifyAutoAudioPlay(str, c46945h);
            AppMethodBeat.m2505o(4125);
            return super_notifyAutoAudioPlay;
        }
        Log.m81046e(TAG, "mSuperProvider Is null");
        AppMethodBeat.m2505o(4125);
        return false;
    }

    public boolean onShowLongClickPopupMenu() {
        AppMethodBeat.m2504i(4126);
        if (this.mSuperProvider != null) {
            boolean super_onShowLongClickPopupMenu = this.mSuperProvider.super_onShowLongClickPopupMenu();
            AppMethodBeat.m2505o(4126);
            return super_onShowLongClickPopupMenu;
        }
        Log.m81046e(TAG, "mSuperProvider Is null");
        AppMethodBeat.m2505o(4126);
        return false;
    }

    public void onResponseReceived(C24530n c24530n, C31147o c31147o, int i) {
        AppMethodBeat.m2504i(4127);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onResponseReceived(c24530n, c31147o, i);
            AppMethodBeat.m2505o(4127);
            return;
        }
        Log.m81046e(TAG, "mSuperProvider Is null");
        AppMethodBeat.m2505o(4127);
    }

    public boolean allowJavaScriptOpenWindowAutomatically(String str, String str2) {
        AppMethodBeat.m2504i(4128);
        if (this.mSuperProvider != null) {
            boolean super_allowJavaScriptOpenWindowAutomatically = this.mSuperProvider.super_allowJavaScriptOpenWindowAutomatically(str, str2);
            AppMethodBeat.m2505o(4128);
            return super_allowJavaScriptOpenWindowAutomatically;
        }
        Log.m81046e(TAG, "mSuperProvider Is null");
        AppMethodBeat.m2505o(4128);
        return false;
    }

    public boolean notifyJavaScriptOpenWindowsBlocked(String str, String[] strArr, ValueCallback<Boolean> valueCallback, boolean z) {
        AppMethodBeat.m2504i(4129);
        if (this.mSuperProvider != null) {
            boolean super_notifyJavaScriptOpenWindowsBlocked = this.mSuperProvider.super_notifyJavaScriptOpenWindowsBlocked(str, strArr, valueCallback, z);
            AppMethodBeat.m2505o(4129);
            return super_notifyJavaScriptOpenWindowsBlocked;
        }
        Log.m81046e(TAG, "mSuperProvider Is null");
        AppMethodBeat.m2505o(4129);
        return false;
    }

    public void documentAvailableInMainFrame() {
        AppMethodBeat.m2504i(4130);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_documentAvailableInMainFrame();
        }
        AppMethodBeat.m2505o(4130);
    }

    public void didFirstVisuallyNonEmptyPaint() {
        AppMethodBeat.m2504i(ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITH_CORE);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_didFirstVisuallyNonEmptyPaint();
        }
        AppMethodBeat.m2505o(ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITH_CORE);
    }

    public void onReceivedViewSource(String str) {
        AppMethodBeat.m2504i(ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITHOUT_CORE);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onReceivedViewSource(str);
        }
        AppMethodBeat.m2505o(ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITHOUT_CORE);
    }

    public void onPrefetchResourceHit(boolean z) {
        AppMethodBeat.m2504i(4133);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onPrefetchResourceHit(z);
        }
        AppMethodBeat.m2505o(4133);
    }

    public void onReceivedSslErrorCancel() {
        AppMethodBeat.m2504i(4134);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onReceivedSslErrorCancel();
        }
        AppMethodBeat.m2505o(4134);
    }

    public void invalidate() {
    }

    public boolean shouldDiscardCurrentPage() {
        return false;
    }

    public void hasDiscardCurrentPage(boolean z) {
    }
}
