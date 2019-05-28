package com.tencent.smtt.export.external.extension.interfaces;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.MediaAccessPermissionsCallback;
import java.util.HashMap;

public interface IX5WebChromeClientExtension {
    public static final int AUDIO_BUFFERING_DISABLE = -3;
    public static final int AUDIO_BUFFERING_END = -1;
    public static final int AUDIO_BUFFERING_START = -2;

    void acquireWakeLock();

    void addFlashView(View view, LayoutParams layoutParams);

    void exitFullScreenFlash();

    Context getApplicationContex();

    View getVideoLoadingProgressView();

    Object getX5WebChromeClientInstance();

    void h5videoExitFullScreen(String str);

    void h5videoRequestFullScreen(String str);

    void jsExitFullScreen();

    void jsRequestFullScreen();

    boolean onAddFavorite(IX5WebViewExtension iX5WebViewExtension, String str, String str2, JsResult jsResult);

    void onAllMetaDataFinished(IX5WebViewExtension iX5WebViewExtension, HashMap<String, String> hashMap);

    void onBackforwardFinished(int i);

    void onColorModeChanged(long j);

    void onHitTestResultFinished(IX5WebViewExtension iX5WebViewExtension, HitTestResult hitTestResult);

    void onHitTestResultForPluginFinished(IX5WebViewExtension iX5WebViewExtension, HitTestResult hitTestResult, Bundle bundle);

    Object onMiscCallBack(String str, Bundle bundle);

    boolean onPageNotResponding(Runnable runnable);

    boolean onPermissionRequest(String str, long j, MediaAccessPermissionsCallback mediaAccessPermissionsCallback);

    void onPrepareX5ReadPageDataFinished(IX5WebViewExtension iX5WebViewExtension, HashMap<String, String> hashMap);

    void onPrintPage();

    void onPromptNotScalable(IX5WebViewExtension iX5WebViewExtension);

    void onPromptScaleSaved(IX5WebViewExtension iX5WebViewExtension);

    boolean onSavePassword(ValueCallback<String> valueCallback, String str, String str2, String str3, String str4, String str5, boolean z);

    boolean onSavePassword(String str, String str2, String str3, boolean z, Message message);

    void onX5ReadModeAvailableChecked(HashMap<String, String> hashMap);

    void openFileChooser(ValueCallback<Uri[]> valueCallback, String str, String str2);

    void releaseWakeLock();

    void requestFullScreenFlash();
}
