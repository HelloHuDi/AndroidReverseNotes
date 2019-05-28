package com.tencent.luggage.bridge.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.tencent.luggage.bridge.C25684s;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import org.p1430a.C41166a;

public class BridgedAndroidWebViewBase extends WebView implements C25684s {
    private static boolean bOT = false;

    public BridgedAndroidWebViewBase(Context context) {
        this(context, null);
    }

    public BridgedAndroidWebViewBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BridgedAndroidWebViewBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(90754);
        getSettings().setDomStorageEnabled(true);
        getSettings().setJavaScriptEnabled(true);
        if (VERSION.SDK_INT >= 19) {
            setWebContentsDebuggingEnabled(true);
        }
        AppMethodBeat.m2505o(90754);
    }

    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    public void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.m2504i(90755);
        if (VERSION.SDK_INT < 17) {
            AppMethodBeat.m2505o(90755);
            return;
        }
        addJavascriptInterface(obj, str);
        AppMethodBeat.m2505o(90755);
    }

    /* renamed from: by */
    public final void mo43469by(final String str) {
        AppMethodBeat.m2504i(90756);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            mo52822bz(str);
            AppMethodBeat.m2505o(90756);
            return;
        }
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(90753);
                BridgedAndroidWebViewBase.this.mo52822bz(str);
                AppMethodBeat.m2505o(90753);
            }
        });
        AppMethodBeat.m2505o(90756);
    }

    /* renamed from: bz */
    public final void mo52822bz(String str) {
        AppMethodBeat.m2504i(90757);
        if (TextUtils.isEmpty(str)) {
            C45124d.m82927e("BridgedAndroidWebViewBase", "Empty script");
            AppMethodBeat.m2505o(90757);
        } else if (VERSION.SDK_INT >= 19) {
            super.evaluateJavascript(str, null);
            AppMethodBeat.m2505o(90757);
        } else {
            if (bOT) {
                if (m52479bA(str)) {
                    AppMethodBeat.m2505o(90757);
                    return;
                }
                bOT = false;
            }
            try {
                super.loadUrl("javascript:".concat(String.valueOf(str)));
                AppMethodBeat.m2505o(90757);
            } catch (Exception e) {
                C45124d.m82930i("BridgedAndroidWebViewBase", "evaluateJavascript failed : %s", e);
                AppMethodBeat.m2505o(90757);
            }
        }
    }

    /* renamed from: bA */
    private boolean m52479bA(String str) {
        AppMethodBeat.m2504i(90758);
        try {
            Object obj = C41166a.m71622ep(C41166a.m71622ep(this).awS("mProvider").object).awS("mWebViewCore").object;
            Message obtain = Message.obtain(null, JsApiUploadEncryptedFileToCDN.CTRL_INDEX, str);
            C41166a.m71622ep(obj).mo65761u("sendMessage", obtain);
            AppMethodBeat.m2505o(90758);
            return true;
        } catch (Exception e) {
            C45124d.m82928e(getClass().getName(), "reflectEvalJS, exception = %s", e);
            AppMethodBeat.m2505o(90758);
            return false;
        }
    }
}
