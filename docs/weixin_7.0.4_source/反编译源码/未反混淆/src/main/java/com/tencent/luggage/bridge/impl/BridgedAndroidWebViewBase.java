package com.tencent.luggage.bridge.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.tencent.luggage.bridge.s;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import org.a.a;

public class BridgedAndroidWebViewBase extends WebView implements s {
    private static boolean bOT = false;

    public BridgedAndroidWebViewBase(Context context) {
        this(context, null);
    }

    public BridgedAndroidWebViewBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BridgedAndroidWebViewBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(90754);
        getSettings().setDomStorageEnabled(true);
        getSettings().setJavaScriptEnabled(true);
        if (VERSION.SDK_INT >= 19) {
            setWebContentsDebuggingEnabled(true);
        }
        AppMethodBeat.o(90754);
    }

    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    public void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.i(90755);
        if (VERSION.SDK_INT < 17) {
            AppMethodBeat.o(90755);
            return;
        }
        addJavascriptInterface(obj, str);
        AppMethodBeat.o(90755);
    }

    public final void by(final String str) {
        AppMethodBeat.i(90756);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            bz(str);
            AppMethodBeat.o(90756);
            return;
        }
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(90753);
                BridgedAndroidWebViewBase.this.bz(str);
                AppMethodBeat.o(90753);
            }
        });
        AppMethodBeat.o(90756);
    }

    public final void bz(String str) {
        AppMethodBeat.i(90757);
        if (TextUtils.isEmpty(str)) {
            d.e("BridgedAndroidWebViewBase", "Empty script");
            AppMethodBeat.o(90757);
        } else if (VERSION.SDK_INT >= 19) {
            super.evaluateJavascript(str, null);
            AppMethodBeat.o(90757);
        } else {
            if (bOT) {
                if (bA(str)) {
                    AppMethodBeat.o(90757);
                    return;
                }
                bOT = false;
            }
            try {
                super.loadUrl("javascript:".concat(String.valueOf(str)));
                AppMethodBeat.o(90757);
            } catch (Exception e) {
                d.i("BridgedAndroidWebViewBase", "evaluateJavascript failed : %s", e);
                AppMethodBeat.o(90757);
            }
        }
    }

    private boolean bA(String str) {
        AppMethodBeat.i(90758);
        try {
            Object obj = a.ep(a.ep(this).awS("mProvider").object).awS("mWebViewCore").object;
            Message obtain = Message.obtain(null, JsApiUploadEncryptedFileToCDN.CTRL_INDEX, str);
            a.ep(obj).u("sendMessage", obtain);
            AppMethodBeat.o(90758);
            return true;
        } catch (Exception e) {
            d.e(getClass().getName(), "reflectEvalJS, exception = %s", e);
            AppMethodBeat.o(90758);
            return false;
        }
    }
}
