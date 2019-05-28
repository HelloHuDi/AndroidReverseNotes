package com.tencent.xweb.xwalk;

import android.content.Context;
import android.net.Uri;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView.FindListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.j;
import com.tencent.xweb.n;
import java.util.Map;
import org.xwalk.core.XWalkDownloadListener;
import org.xwalk.core.XWalkFindListener;
import org.xwalk.core.XWalkGeolocationPermissionsCallback;
import org.xwalk.core.XWalkJavascriptResult;
import org.xwalk.core.XWalkUIClient.ConsoleMessageType;
import org.xwalk.core.XWalkWebResourceRequest;

public final class f {

    public static class g implements j {
        ValueCallback<Boolean> ARW;

        public g(ValueCallback<Boolean> valueCallback) {
            this.ARW = valueCallback;
        }

        public final void proceed() {
            AppMethodBeat.i(85227);
            this.ARW.onReceiveValue(Boolean.TRUE);
            AppMethodBeat.o(85227);
        }

        public final void cancel() {
            AppMethodBeat.i(85228);
            this.ARW.onReceiveValue(Boolean.FALSE);
            AppMethodBeat.o(85228);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.f$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] ARS = new int[ConsoleMessageType.values().length];

        static {
            AppMethodBeat.i(85216);
            try {
                ARS[ConsoleMessageType.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                ARS[ConsoleMessageType.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                ARS[ConsoleMessageType.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                ARS[ConsoleMessageType.INFO.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                ARS[ConsoleMessageType.WARNING.ordinal()] = 5;
                AppMethodBeat.o(85216);
            } catch (NoSuchFieldError e5) {
                AppMethodBeat.o(85216);
            }
        }
    }

    public static class d extends com.tencent.xweb.g {
        public XWalkJavascriptResult ARV;

        public d(XWalkJavascriptResult xWalkJavascriptResult) {
            this.ARV = xWalkJavascriptResult;
        }

        public final void confirmWithResult(String str) {
            AppMethodBeat.i(85222);
            this.ARV.confirmWithResult(str);
            AppMethodBeat.o(85222);
        }

        public final void confirm() {
            AppMethodBeat.i(85223);
            this.ARV.confirm();
            AppMethodBeat.o(85223);
        }

        public final void cancel() {
            AppMethodBeat.i(85224);
            this.ARV.cancel();
            AppMethodBeat.o(85224);
        }
    }

    public static class f extends XWalkFindListener {
        FindListener AQm;

        public f(FindListener findListener) {
            this.AQm = findListener;
        }

        public final void onFindResultReceived(int i, int i2, boolean z) {
            AppMethodBeat.i(85226);
            if (this.AQm != null) {
                this.AQm.onFindResultReceived(i, i2, z);
            }
            AppMethodBeat.o(85226);
        }
    }

    public static class b implements Callback {
        XWalkGeolocationPermissionsCallback ARU;

        public b(XWalkGeolocationPermissionsCallback xWalkGeolocationPermissionsCallback) {
            this.ARU = xWalkGeolocationPermissionsCallback;
        }

        public final void invoke(String str, boolean z, boolean z2) {
            AppMethodBeat.i(85218);
            if (this.ARU != null) {
                this.ARU.invoke(str, z, z2);
            }
            AppMethodBeat.o(85218);
        }
    }

    public static class e extends XWalkDownloadListener {
        DownloadListener AQl;

        public e(Context context, DownloadListener downloadListener) {
            super(context);
            this.AQl = downloadListener;
        }

        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            AppMethodBeat.i(85225);
            if (this.AQl != null) {
                this.AQl.onDownloadStart(str, str2, str3, str4, j);
            }
            AppMethodBeat.o(85225);
        }
    }

    public static class h implements n {
        private boolean APL;
        private boolean APM;
        com.tencent.xweb.a.a APN = new com.tencent.xweb.a.a(this);
        private String method;
        private Uri url;
        private Map<String, String> vfl;

        public h(XWalkWebResourceRequest xWalkWebResourceRequest) {
            AppMethodBeat.i(85229);
            this.url = xWalkWebResourceRequest.getUrl();
            this.APL = xWalkWebResourceRequest.isForMainFrame();
            this.APM = xWalkWebResourceRequest.hasGesture();
            this.method = xWalkWebResourceRequest.getMethod();
            this.vfl = xWalkWebResourceRequest.getRequestHeaders();
            AppMethodBeat.o(85229);
        }

        public final Uri getUrl() {
            return this.url;
        }

        public final boolean isForMainFrame() {
            return this.APL;
        }

        public final boolean hasGesture() {
            return this.APM;
        }

        public final String getMethod() {
            return this.method;
        }

        public final Map<String, String> getRequestHeaders() {
            return this.vfl;
        }
    }

    public static class a implements CustomViewCallback {
        org.xwalk.core.CustomViewCallback ART;

        a(org.xwalk.core.CustomViewCallback customViewCallback) {
            this.ART = customViewCallback;
        }

        public final void onCustomViewHidden() {
            AppMethodBeat.i(85217);
            this.ART.onCustomViewHidden();
            AppMethodBeat.o(85217);
        }
    }

    public static class c extends com.tencent.xweb.h {
        public XWalkJavascriptResult ARV;

        public c(XWalkJavascriptResult xWalkJavascriptResult) {
            this.ARV = xWalkJavascriptResult;
        }

        public final void confirmWithResult(String str) {
            AppMethodBeat.i(85219);
            this.ARV.confirmWithResult(str);
            AppMethodBeat.o(85219);
        }

        public final void confirm() {
            AppMethodBeat.i(85220);
            this.ARV.confirm();
            AppMethodBeat.o(85220);
        }

        public final void cancel() {
            AppMethodBeat.i(85221);
            this.ARV.cancel();
            AppMethodBeat.o(85221);
        }
    }
}
