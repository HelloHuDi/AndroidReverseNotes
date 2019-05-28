package com.tencent.smtt.export.external.extension.proxy;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.MediaAccessPermissionsCallback;
import java.util.HashMap;

public class ProxyWebChromeClientExtension implements IX5WebChromeClientExtension {
    private static boolean sCompatibleNewOnSavePassword = true;
    private static boolean sCompatibleOpenFileChooser = true;
    protected IX5WebChromeClientExtension mWebChromeClient;

    public void acquireWakeLock() {
        AppMethodBeat.i(63791);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.acquireWakeLock();
        }
        AppMethodBeat.o(63791);
    }

    public void addFlashView(View view, LayoutParams layoutParams) {
        AppMethodBeat.i(63784);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.addFlashView(view, layoutParams);
        }
        AppMethodBeat.o(63784);
    }

    public void exitFullScreenFlash() {
        AppMethodBeat.i(63786);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.exitFullScreenFlash();
        }
        AppMethodBeat.o(63786);
    }

    public Context getApplicationContex() {
        AppMethodBeat.i(63793);
        if (this.mWebChromeClient != null) {
            Context applicationContex = this.mWebChromeClient.getApplicationContex();
            AppMethodBeat.o(63793);
            return applicationContex;
        }
        AppMethodBeat.o(63793);
        return null;
    }

    public View getVideoLoadingProgressView() {
        AppMethodBeat.i(63773);
        if (this.mWebChromeClient != null) {
            View videoLoadingProgressView = this.mWebChromeClient.getVideoLoadingProgressView();
            AppMethodBeat.o(63773);
            return videoLoadingProgressView;
        }
        AppMethodBeat.o(63773);
        return null;
    }

    public Object getX5WebChromeClientInstance() {
        return this.mWebChromeClient;
    }

    public IX5WebChromeClientExtension getmWebChromeClient() {
        return this.mWebChromeClient;
    }

    public void h5videoExitFullScreen(String str) {
        AppMethodBeat.i(63790);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.h5videoExitFullScreen(str);
        }
        AppMethodBeat.o(63790);
    }

    public void h5videoRequestFullScreen(String str) {
        AppMethodBeat.i(63789);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.h5videoRequestFullScreen(str);
        }
        AppMethodBeat.o(63789);
    }

    public void jsExitFullScreen() {
        AppMethodBeat.i(63788);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.jsExitFullScreen();
        }
        AppMethodBeat.o(63788);
    }

    public void jsRequestFullScreen() {
        AppMethodBeat.i(63787);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.jsRequestFullScreen();
        }
        AppMethodBeat.o(63787);
    }

    public boolean onAddFavorite(IX5WebViewExtension iX5WebViewExtension, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(63777);
        if (this.mWebChromeClient != null) {
            boolean onAddFavorite = this.mWebChromeClient.onAddFavorite(iX5WebViewExtension, str, str2, jsResult);
            AppMethodBeat.o(63777);
            return onAddFavorite;
        }
        AppMethodBeat.o(63777);
        return false;
    }

    public void onAllMetaDataFinished(IX5WebViewExtension iX5WebViewExtension, HashMap<String, String> hashMap) {
        AppMethodBeat.i(63794);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onAllMetaDataFinished(iX5WebViewExtension, hashMap);
        }
        AppMethodBeat.o(63794);
    }

    public void onBackforwardFinished(int i) {
        AppMethodBeat.i(63774);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onBackforwardFinished(i);
        }
        AppMethodBeat.o(63774);
    }

    public void onColorModeChanged(long j) {
    }

    public void onHitTestResultFinished(IX5WebViewExtension iX5WebViewExtension, HitTestResult hitTestResult) {
        AppMethodBeat.i(63776);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onHitTestResultFinished(iX5WebViewExtension, hitTestResult);
        }
        AppMethodBeat.o(63776);
    }

    public void onHitTestResultForPluginFinished(IX5WebViewExtension iX5WebViewExtension, HitTestResult hitTestResult, Bundle bundle) {
        AppMethodBeat.i(63775);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onHitTestResultForPluginFinished(iX5WebViewExtension, hitTestResult, bundle);
        }
        AppMethodBeat.o(63775);
    }

    public Object onMiscCallBack(String str, Bundle bundle) {
        AppMethodBeat.i(63796);
        if (this.mWebChromeClient != null) {
            Object onMiscCallBack = this.mWebChromeClient.onMiscCallBack(str, bundle);
            AppMethodBeat.o(63796);
            return onMiscCallBack;
        }
        AppMethodBeat.o(63796);
        return null;
    }

    public boolean onPageNotResponding(Runnable runnable) {
        AppMethodBeat.i(63795);
        if (this.mWebChromeClient != null) {
            boolean onPageNotResponding = this.mWebChromeClient.onPageNotResponding(runnable);
            AppMethodBeat.o(63795);
            return onPageNotResponding;
        }
        AppMethodBeat.o(63795);
        return false;
    }

    public boolean onPermissionRequest(String str, long j, MediaAccessPermissionsCallback mediaAccessPermissionsCallback) {
        return false;
    }

    public void onPrepareX5ReadPageDataFinished(IX5WebViewExtension iX5WebViewExtension, HashMap<String, String> hashMap) {
        AppMethodBeat.i(63778);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onPrepareX5ReadPageDataFinished(iX5WebViewExtension, hashMap);
        }
        AppMethodBeat.o(63778);
    }

    public void onPrintPage() {
    }

    public void onPromptNotScalable(IX5WebViewExtension iX5WebViewExtension) {
        AppMethodBeat.i(63780);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onPromptNotScalable(iX5WebViewExtension);
        }
        AppMethodBeat.o(63780);
    }

    public void onPromptScaleSaved(IX5WebViewExtension iX5WebViewExtension) {
        AppMethodBeat.i(63779);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onPromptScaleSaved(iX5WebViewExtension);
        }
        AppMethodBeat.o(63779);
    }

    public boolean onSavePassword(ValueCallback<String> valueCallback, String str, String str2, String str3, String str4, String str5, boolean z) {
        AppMethodBeat.i(63782);
        if (this.mWebChromeClient != null && sCompatibleNewOnSavePassword) {
            try {
                boolean onSavePassword = this.mWebChromeClient.onSavePassword(valueCallback, str, str2, str3, str4, str5, z);
                AppMethodBeat.o(63782);
                return onSavePassword;
            } catch (NoSuchMethodError e) {
                if (e.getMessage() == null || !e.getMessage().contains("onSavePassword")) {
                    AppMethodBeat.o(63782);
                    throw e;
                }
                sCompatibleNewOnSavePassword = false;
            }
        }
        AppMethodBeat.o(63782);
        return false;
    }

    public boolean onSavePassword(String str, String str2, String str3, boolean z, Message message) {
        AppMethodBeat.i(63781);
        if (this.mWebChromeClient != null) {
            try {
                boolean onSavePassword = this.mWebChromeClient.onSavePassword(str, str2, str3, z, message);
                AppMethodBeat.o(63781);
                return onSavePassword;
            } catch (NoSuchMethodError e) {
            }
        }
        AppMethodBeat.o(63781);
        return false;
    }

    public void onX5ReadModeAvailableChecked(HashMap<String, String> hashMap) {
        AppMethodBeat.i(63783);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onX5ReadModeAvailableChecked(hashMap);
        }
        AppMethodBeat.o(63783);
    }

    public void openFileChooser(ValueCallback<Uri[]> valueCallback, String str, String str2) {
        AppMethodBeat.i(63797);
        if (this.mWebChromeClient != null && sCompatibleOpenFileChooser) {
            try {
                this.mWebChromeClient.openFileChooser(valueCallback, str, str2);
                AppMethodBeat.o(63797);
                return;
            } catch (NoSuchMethodError e) {
                if (e.getMessage() == null || !e.getMessage().contains("openFileChooser")) {
                    AppMethodBeat.o(63797);
                    throw e;
                }
                sCompatibleOpenFileChooser = false;
            }
        }
        AppMethodBeat.o(63797);
    }

    public void releaseWakeLock() {
        AppMethodBeat.i(63792);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.releaseWakeLock();
        }
        AppMethodBeat.o(63792);
    }

    public void requestFullScreenFlash() {
        AppMethodBeat.i(63785);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.requestFullScreenFlash();
        }
        AppMethodBeat.o(63785);
    }

    public void setWebChromeClientExtend(IX5WebChromeClientExtension iX5WebChromeClientExtension) {
        this.mWebChromeClient = iX5WebChromeClientExtension;
    }
}
