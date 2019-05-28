package com.tencent.p177mm.plugin.appbrand.p297h;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import java.net.URL;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.h.w */
public final class C42452w extends WebView implements C6747i, C38236o {
    private boolean ifl;
    private final LinkedList<Pair<String, ValueCallback<String>>> ifm;
    private boolean ifn;
    private volatile boolean mDestroyed;
    private C7306ak mHandler;

    public final void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.m2504i(117472);
        if (!(obj == null || C5046bo.isNullOrNil(str))) {
            super.addJavascriptInterface(obj, str);
        }
        AppMethodBeat.m2505o(117472);
    }

    /* renamed from: a */
    public final void mo14967a(URL url, String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(117474);
        evaluateJavascript(str, valueCallback);
        AppMethodBeat.m2505o(117474);
    }

    /* renamed from: a */
    public final void mo14968a(URL url, String str, String str2, String str3, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(117475);
        evaluateJavascript(str3, valueCallback);
        AppMethodBeat.m2505o(117475);
    }

    public final void setJsExceptionHandler(C33211h c33211h) {
    }

    public final void destroy() {
        AppMethodBeat.m2504i(117476);
        this.mDestroyed = true;
        super.destroy();
        AppMethodBeat.m2505o(117476);
    }

    /* renamed from: af */
    public final <T extends C2169j> T mo14970af(Class<T> cls) {
        AppMethodBeat.m2504i(117477);
        if (cls.isInstance(this)) {
            AppMethodBeat.m2505o(117477);
            return this;
        }
        AppMethodBeat.m2505o(117477);
        return null;
    }

    public final void setJsRuntimeTitle(String str) {
        AppMethodBeat.m2504i(117478);
        evaluateJavascript("document.title=\"" + str + "\"", null);
        AppMethodBeat.m2505o(117478);
    }

    /* JADX WARNING: Missing block: B:13:0x0037, code skipped:
            if (r7.mDestroyed != false) goto L_0x005e;
     */
    /* JADX WARNING: Missing block: B:14:0x0039, code skipped:
            r0 = new com.tencent.p177mm.plugin.appbrand.p297h.C42452w.C332131(r7);
     */
    /* JADX WARNING: Missing block: B:15:0x004a, code skipped:
            if (android.os.Looper.getMainLooper().getThread() != java.lang.Thread.currentThread()) goto L_0x0059;
     */
    /* JADX WARNING: Missing block: B:16:0x004c, code skipped:
            r0.run();
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(117473);
     */
    /* JADX WARNING: Missing block: B:21:0x0059, code skipped:
            r7.mHandler.post(r0);
     */
    /* JADX WARNING: Missing block: B:22:0x005e, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(117473);
     */
    /* JADX WARNING: Missing block: B:27:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:28:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(117473);
        if (!this.ifl) {
            this.ifl = true;
            loadDataWithBaseURL("https://servicewechat.com/js-engine", "<html>\n  <head>\n    <meta http-equiv=\"Content-Security-Policy\" content=\"default-src 'none';script-src 'unsafe-eval';\">\n  </head>\n  <body></body>\n</html>", "text/html", ProtocolPackage.ServerEncoding, null);
        }
        synchronized (this.ifm) {
            try {
                if (!this.ifn) {
                    this.ifm.add(new Pair(str, valueCallback));
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(117473);
            }
        }
    }
}
