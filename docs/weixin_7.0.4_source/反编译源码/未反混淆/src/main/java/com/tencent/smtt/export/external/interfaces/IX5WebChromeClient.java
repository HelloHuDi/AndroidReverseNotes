package com.tencent.smtt.export.external.interfaces;

import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.webkit.ValueCallback;

public interface IX5WebChromeClient {

    public interface CustomViewCallback {
        void onCustomViewHidden();
    }

    public static abstract class FileChooserParams {
        public static final int MODE_OPEN = 0;
        public static final int MODE_OPEN_FOLDER = 2;
        public static final int MODE_OPEN_MULTIPLE = 1;
        public static final int MODE_SAVE = 3;

        public static Uri[] parseResult(int i, Intent intent) {
            return null;
        }

        public abstract Intent createIntent();

        public abstract String[] getAcceptTypes();

        public abstract String getFilenameHint();

        public abstract int getMode();

        public abstract CharSequence getTitle();

        public abstract boolean isCaptureEnabled();
    }

    Bitmap getDefaultVideoPoster();

    void getVisitedHistory(ValueCallback<String[]> valueCallback);

    void onCloseWindow(IX5WebViewBase iX5WebViewBase);

    @Deprecated
    void onConsoleMessage(String str, int i, String str2);

    boolean onConsoleMessage(ConsoleMessage consoleMessage);

    boolean onCreateWindow(IX5WebViewBase iX5WebViewBase, boolean z, boolean z2, Message message);

    void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater);

    void onGeolocationPermissionsHidePrompt();

    void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback);

    void onGeolocationStartUpdating(ValueCallback<Location> valueCallback, ValueCallback<Bundle> valueCallback2);

    void onGeolocationStopUpdating();

    void onHideCustomView();

    boolean onJsAlert(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult);

    boolean onJsBeforeUnload(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult);

    boolean onJsConfirm(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult);

    boolean onJsPrompt(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3, JsPromptResult jsPromptResult);

    boolean onJsTimeout();

    void onProgressChanged(IX5WebViewBase iX5WebViewBase, int i);

    void onReachedMaxAppCacheSize(long j, long j2, QuotaUpdater quotaUpdater);

    void onReceivedIcon(IX5WebViewBase iX5WebViewBase, Bitmap bitmap);

    void onReceivedTitle(IX5WebViewBase iX5WebViewBase, String str);

    void onReceivedTouchIconUrl(IX5WebViewBase iX5WebViewBase, String str, boolean z);

    void onRequestFocus(IX5WebViewBase iX5WebViewBase);

    void onShowCustomView(View view, int i, CustomViewCallback customViewCallback);

    void onShowCustomView(View view, CustomViewCallback customViewCallback);

    boolean onShowFileChooser(IX5WebViewBase iX5WebViewBase, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams);

    void openFileChooser(ValueCallback<Uri[]> valueCallback, String str, String str2, boolean z);
}
