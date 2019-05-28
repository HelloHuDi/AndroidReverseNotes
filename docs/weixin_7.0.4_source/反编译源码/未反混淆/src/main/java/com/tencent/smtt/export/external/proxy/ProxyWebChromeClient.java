package com.tencent.smtt.export.external.proxy;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.FileChooserParams;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.QuotaUpdater;

public class ProxyWebChromeClient implements IX5WebChromeClient {
    protected IX5WebChromeClient mWebChromeClient;

    public Bitmap getDefaultVideoPoster() {
        return null;
    }

    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        AppMethodBeat.i(63854);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.getVisitedHistory(valueCallback);
        }
        AppMethodBeat.o(63854);
    }

    public IX5WebChromeClient getmWebChromeClient() {
        return this.mWebChromeClient;
    }

    public void onCloseWindow(IX5WebViewBase iX5WebViewBase) {
        AppMethodBeat.i(63853);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onCloseWindow(iX5WebViewBase);
        }
        AppMethodBeat.o(63853);
    }

    public void onConsoleMessage(String str, int i, String str2) {
        AppMethodBeat.i(63850);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onConsoleMessage(str, i, str2);
        }
        AppMethodBeat.o(63850);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        AppMethodBeat.i(63833);
        if (this.mWebChromeClient != null) {
            boolean onConsoleMessage = this.mWebChromeClient.onConsoleMessage(consoleMessage);
            AppMethodBeat.o(63833);
            return onConsoleMessage;
        }
        AppMethodBeat.o(63833);
        return false;
    }

    public boolean onCreateWindow(IX5WebViewBase iX5WebViewBase, boolean z, boolean z2, Message message) {
        AppMethodBeat.i(63834);
        if (this.mWebChromeClient != null) {
            boolean onCreateWindow = this.mWebChromeClient.onCreateWindow(iX5WebViewBase, z, z2, message);
            AppMethodBeat.o(63834);
            return onCreateWindow;
        }
        AppMethodBeat.o(63834);
        return false;
    }

    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        AppMethodBeat.i(63849);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        }
        AppMethodBeat.o(63849);
    }

    public void onGeolocationPermissionsHidePrompt() {
        AppMethodBeat.i(63851);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onGeolocationPermissionsHidePrompt();
        }
        AppMethodBeat.o(63851);
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        AppMethodBeat.i(63835);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
        }
        AppMethodBeat.o(63835);
    }

    public void onGeolocationStartUpdating(ValueCallback<Location> valueCallback, ValueCallback<Bundle> valueCallback2) {
        AppMethodBeat.i(63856);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onGeolocationStartUpdating(valueCallback, valueCallback2);
        }
        AppMethodBeat.o(63856);
    }

    public void onGeolocationStopUpdating() {
        AppMethodBeat.i(63857);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onGeolocationStopUpdating();
        }
        AppMethodBeat.o(63857);
    }

    public void onHideCustomView() {
        AppMethodBeat.i(63836);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onHideCustomView();
        }
        AppMethodBeat.o(63836);
    }

    public boolean onJsAlert(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(63837);
        if (this.mWebChromeClient != null) {
            boolean onJsAlert = this.mWebChromeClient.onJsAlert(iX5WebViewBase, str, str2, jsResult);
            AppMethodBeat.o(63837);
            return onJsAlert;
        }
        AppMethodBeat.o(63837);
        return false;
    }

    public boolean onJsBeforeUnload(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(63839);
        if (this.mWebChromeClient != null) {
            boolean onJsBeforeUnload = this.mWebChromeClient.onJsBeforeUnload(iX5WebViewBase, str, str2, jsResult);
            AppMethodBeat.o(63839);
            return onJsBeforeUnload;
        }
        AppMethodBeat.o(63839);
        return false;
    }

    public boolean onJsConfirm(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(63852);
        if (this.mWebChromeClient != null) {
            boolean onJsConfirm = this.mWebChromeClient.onJsConfirm(iX5WebViewBase, str, str2, jsResult);
            AppMethodBeat.o(63852);
            return onJsConfirm;
        }
        AppMethodBeat.o(63852);
        return false;
    }

    public boolean onJsPrompt(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        AppMethodBeat.i(63838);
        if (this.mWebChromeClient != null) {
            boolean onJsPrompt = this.mWebChromeClient.onJsPrompt(iX5WebViewBase, str, str2, str3, jsPromptResult);
            AppMethodBeat.o(63838);
            return onJsPrompt;
        }
        AppMethodBeat.o(63838);
        return false;
    }

    public boolean onJsTimeout() {
        AppMethodBeat.i(63840);
        if (this.mWebChromeClient != null) {
            boolean onJsTimeout = this.mWebChromeClient.onJsTimeout();
            AppMethodBeat.o(63840);
            return onJsTimeout;
        }
        AppMethodBeat.o(63840);
        return false;
    }

    public void onProgressChanged(IX5WebViewBase iX5WebViewBase, int i) {
        AppMethodBeat.i(63841);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onProgressChanged(iX5WebViewBase, i);
        }
        AppMethodBeat.o(63841);
    }

    public void onReachedMaxAppCacheSize(long j, long j2, QuotaUpdater quotaUpdater) {
        AppMethodBeat.i(63842);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
        }
        AppMethodBeat.o(63842);
    }

    public void onReceivedIcon(IX5WebViewBase iX5WebViewBase, Bitmap bitmap) {
        AppMethodBeat.i(63843);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onReceivedIcon(iX5WebViewBase, bitmap);
        }
        AppMethodBeat.o(63843);
    }

    public void onReceivedTitle(IX5WebViewBase iX5WebViewBase, String str) {
        AppMethodBeat.i(63845);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onReceivedTitle(iX5WebViewBase, str);
        }
        AppMethodBeat.o(63845);
    }

    public void onReceivedTouchIconUrl(IX5WebViewBase iX5WebViewBase, String str, boolean z) {
        AppMethodBeat.i(63844);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onReceivedTouchIconUrl(iX5WebViewBase, str, z);
        }
        AppMethodBeat.o(63844);
    }

    public void onRequestFocus(IX5WebViewBase iX5WebViewBase) {
        AppMethodBeat.i(63846);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onRequestFocus(iX5WebViewBase);
        }
        AppMethodBeat.o(63846);
    }

    public void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
        AppMethodBeat.i(63848);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onShowCustomView(view, customViewCallback);
        }
        AppMethodBeat.o(63848);
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        AppMethodBeat.i(63847);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onShowCustomView(view, customViewCallback);
        }
        AppMethodBeat.o(63847);
    }

    public boolean onShowFileChooser(IX5WebViewBase iX5WebViewBase, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        return false;
    }

    public void openFileChooser(ValueCallback<Uri[]> valueCallback, String str, String str2, boolean z) {
        AppMethodBeat.i(63855);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.openFileChooser(valueCallback, str, str2, z);
        }
        AppMethodBeat.o(63855);
    }

    public void setWebChromeClient(IX5WebChromeClient iX5WebChromeClient) {
        this.mWebChromeClient = iX5WebChromeClient;
    }
}
