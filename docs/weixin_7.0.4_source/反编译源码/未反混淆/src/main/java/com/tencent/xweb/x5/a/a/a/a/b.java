package com.tencent.xweb.x5.a.a.a.a;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.xweb.h;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import org.xwalk.core.Log;

public class b {
    private static final String TAG = "ProxyWebViewClientExtension";
    a mSuperProvider;

    public void setSuperProvider(a aVar) {
        this.mSuperProvider = aVar;
    }

    public void onMissingPluginClicked(String str, String str2, String str3, int i) {
        AppMethodBeat.i(4089);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onMissingPluginClicked(str, str2, str3, i);
        }
        AppMethodBeat.o(4089);
    }

    public void onHideListBox() {
        AppMethodBeat.i(4090);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onHideListBox();
        }
        AppMethodBeat.o(4090);
    }

    public void onShowListBox(String[] strArr, int[] iArr, int[] iArr2, int i) {
        AppMethodBeat.i(4091);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onShowListBox(strArr, iArr, iArr2, i);
        }
        AppMethodBeat.o(4091);
    }

    public void onShowMutilListBox(String[] strArr, int[] iArr, int[] iArr2, int[] iArr3) {
        AppMethodBeat.i(4092);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onShowMutilListBox(strArr, iArr, iArr2, iArr3);
        }
        AppMethodBeat.o(4092);
    }

    public void onFlingScrollBegin(int i, int i2, int i3) {
        AppMethodBeat.i(4093);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onFlingScrollBegin(i, i2, i3);
        }
        AppMethodBeat.o(4093);
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(4094);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onScrollChanged(i, i2, i3, i4);
        }
        AppMethodBeat.o(4094);
    }

    public void onTransitionToCommitted() {
        AppMethodBeat.i(4095);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onTransitionToCommitted();
        }
        AppMethodBeat.o(4095);
    }

    public void onUploadProgressStart(int i) {
        AppMethodBeat.i(4096);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onUploadProgressStart(i);
        }
        AppMethodBeat.o(4096);
    }

    public void onUploadProgressChange(int i, int i2, String str) {
        AppMethodBeat.i(4097);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onUploadProgressChange(i, i2, str);
        }
        AppMethodBeat.o(4097);
    }

    public void onSoftKeyBoardShow() {
        AppMethodBeat.i(4098);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onSoftKeyBoardShow();
        }
        AppMethodBeat.o(4098);
    }

    public void onSoftKeyBoardHide(int i) {
        AppMethodBeat.i(4099);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onSoftKeyBoardHide(i);
        }
        AppMethodBeat.o(4099);
    }

    public void onSetButtonStatus(boolean z, boolean z2) {
        AppMethodBeat.i(4100);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onSetButtonStatus(z, z2);
        }
        AppMethodBeat.o(4100);
    }

    public void onHistoryItemChanged() {
        AppMethodBeat.i(4101);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onHistoryItemChanged();
        }
        AppMethodBeat.o(4101);
    }

    public void hideAddressBar() {
        AppMethodBeat.i(4102);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_hideAddressBar();
        }
        AppMethodBeat.o(4102);
    }

    public void handlePluginTag(String str, String str2, boolean z, String str3) {
        AppMethodBeat.i(4103);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_handlePluginTag(str, str2, z, str3);
        }
        AppMethodBeat.o(4103);
    }

    public void onDoubleTapStart() {
        AppMethodBeat.i(4104);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onDoubleTapStart();
        }
        AppMethodBeat.o(4104);
    }

    public void onPinchToZoomStart() {
        AppMethodBeat.i(4105);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onPinchToZoomStart();
        }
        AppMethodBeat.o(4105);
    }

    public void onSlidingTitleOffScreen(int i, int i2) {
        AppMethodBeat.i(4106);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onSlidingTitleOffScreen(i, i2);
        }
        AppMethodBeat.o(4106);
    }

    public void onPreReadFinished() {
        AppMethodBeat.i(4107);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onPreReadFinished();
        }
        AppMethodBeat.o(4107);
    }

    public void onPromptScaleSaved() {
        AppMethodBeat.i(4108);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onPromptScaleSaved();
        }
        AppMethodBeat.o(4108);
    }

    public void onFlingScrollEnd() {
        AppMethodBeat.i(4109);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onFlingScrollEnd();
        }
        AppMethodBeat.o(4109);
    }

    public void onUrlChange(String str, String str2) {
        AppMethodBeat.i(4110);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onUrlChange(str, str2);
        }
        AppMethodBeat.o(4110);
    }

    public void onReportAdFilterInfo(int i, int i2, String str, boolean z) {
        AppMethodBeat.i(4111);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onReportAdFilterInfo(i, i2, str, z);
        }
        AppMethodBeat.o(4111);
    }

    public void onNativeCrashReport(int i, String str) {
        AppMethodBeat.i(4112);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onNativeCrashReport(i, str);
        }
        AppMethodBeat.o(4112);
    }

    public Object onMiscCallBack(String str, Bundle bundle) {
        AppMethodBeat.i(4113);
        if (this.mSuperProvider != null) {
            Object super_onMiscCallBack = this.mSuperProvider.super_onMiscCallBack(str, bundle);
            AppMethodBeat.o(4113);
            return super_onMiscCallBack;
        }
        AppMethodBeat.o(4113);
        return null;
    }

    public void onReportHtmlInfo(int i, String str) {
        AppMethodBeat.i(4114);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onReportHtmlInfo(i, str);
        }
        AppMethodBeat.o(4114);
    }

    public Object onMiscCallBack(String str, Bundle bundle, Object obj, Object obj2, Object obj3, Object obj4) {
        AppMethodBeat.i(4115);
        if (this.mSuperProvider != null) {
            Object super_onMiscCallBack = this.mSuperProvider.super_onMiscCallBack(str, bundle, obj, obj2, obj3, obj4);
            AppMethodBeat.o(4115);
            return super_onMiscCallBack;
        }
        AppMethodBeat.o(4115);
        return null;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(4116);
        if (this.mSuperProvider != null) {
            boolean super_onInterceptTouchEvent = this.mSuperProvider.super_onInterceptTouchEvent(motionEvent, view);
            AppMethodBeat.o(4116);
            return super_onInterceptTouchEvent;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(4116);
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(4117);
        if (this.mSuperProvider != null) {
            boolean super_onTouchEvent = this.mSuperProvider.super_onTouchEvent(motionEvent, view);
            AppMethodBeat.o(4117);
            return super_onTouchEvent;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(4117);
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(4118);
        if (this.mSuperProvider != null) {
            boolean super_dispatchTouchEvent = this.mSuperProvider.super_dispatchTouchEvent(motionEvent, view);
            AppMethodBeat.o(4118);
            return super_dispatchTouchEvent;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(4118);
        return false;
    }

    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
        AppMethodBeat.i(4119);
        if (this.mSuperProvider != null) {
            boolean super_overScrollBy = this.mSuperProvider.super_overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, view);
            AppMethodBeat.o(4119);
            return super_overScrollBy;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(4119);
        return false;
    }

    public void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        AppMethodBeat.i(4120);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onScrollChanged(i, i2, i3, i4, view);
            AppMethodBeat.o(4120);
            return;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(4120);
    }

    public void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
        AppMethodBeat.i(ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITH_CORE);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onOverScrolled(i, i2, z, z2, view);
            AppMethodBeat.o(ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITH_CORE);
            return;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITH_CORE);
    }

    public void computeScroll(View view) {
        AppMethodBeat.i(ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITHOUT_CORE);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_computeScroll(view);
        }
        AppMethodBeat.o(ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITHOUT_CORE);
    }

    public void onMetricsSavedCountReceived(String str, boolean z, long j, String str2, int i) {
        AppMethodBeat.i(4123);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onMetricsSavedCountReceived(str, z, j, str2, i);
            AppMethodBeat.o(4123);
            return;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(4123);
    }

    public void showTranslateBubble(int i, String str, String str2, int i2) {
        AppMethodBeat.i(4124);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_showTranslateBubble(i, str, str2, i2);
            AppMethodBeat.o(4124);
            return;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(4124);
    }

    public boolean notifyAutoAudioPlay(String str, h hVar) {
        AppMethodBeat.i(4125);
        if (this.mSuperProvider != null) {
            boolean super_notifyAutoAudioPlay = this.mSuperProvider.super_notifyAutoAudioPlay(str, hVar);
            AppMethodBeat.o(4125);
            return super_notifyAutoAudioPlay;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(4125);
        return false;
    }

    public boolean onShowLongClickPopupMenu() {
        AppMethodBeat.i(4126);
        if (this.mSuperProvider != null) {
            boolean super_onShowLongClickPopupMenu = this.mSuperProvider.super_onShowLongClickPopupMenu();
            AppMethodBeat.o(4126);
            return super_onShowLongClickPopupMenu;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(4126);
        return false;
    }

    public void onResponseReceived(n nVar, o oVar, int i) {
        AppMethodBeat.i(4127);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onResponseReceived(nVar, oVar, i);
            AppMethodBeat.o(4127);
            return;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(4127);
    }

    public boolean allowJavaScriptOpenWindowAutomatically(String str, String str2) {
        AppMethodBeat.i(4128);
        if (this.mSuperProvider != null) {
            boolean super_allowJavaScriptOpenWindowAutomatically = this.mSuperProvider.super_allowJavaScriptOpenWindowAutomatically(str, str2);
            AppMethodBeat.o(4128);
            return super_allowJavaScriptOpenWindowAutomatically;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(4128);
        return false;
    }

    public boolean notifyJavaScriptOpenWindowsBlocked(String str, String[] strArr, ValueCallback<Boolean> valueCallback, boolean z) {
        AppMethodBeat.i(4129);
        if (this.mSuperProvider != null) {
            boolean super_notifyJavaScriptOpenWindowsBlocked = this.mSuperProvider.super_notifyJavaScriptOpenWindowsBlocked(str, strArr, valueCallback, z);
            AppMethodBeat.o(4129);
            return super_notifyJavaScriptOpenWindowsBlocked;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(4129);
        return false;
    }

    public void documentAvailableInMainFrame() {
        AppMethodBeat.i(4130);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_documentAvailableInMainFrame();
        }
        AppMethodBeat.o(4130);
    }

    public void didFirstVisuallyNonEmptyPaint() {
        AppMethodBeat.i(ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITH_CORE);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_didFirstVisuallyNonEmptyPaint();
        }
        AppMethodBeat.o(ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITH_CORE);
    }

    public void onReceivedViewSource(String str) {
        AppMethodBeat.i(ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITHOUT_CORE);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onReceivedViewSource(str);
        }
        AppMethodBeat.o(ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITHOUT_CORE);
    }

    public void onPrefetchResourceHit(boolean z) {
        AppMethodBeat.i(4133);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onPrefetchResourceHit(z);
        }
        AppMethodBeat.o(4133);
    }

    public void onReceivedSslErrorCancel() {
        AppMethodBeat.i(4134);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onReceivedSslErrorCancel();
        }
        AppMethodBeat.o(4134);
    }

    public void invalidate() {
    }

    public boolean shouldDiscardCurrentPage() {
        return false;
    }

    public void hasDiscardCurrentPage(boolean z) {
    }
}
