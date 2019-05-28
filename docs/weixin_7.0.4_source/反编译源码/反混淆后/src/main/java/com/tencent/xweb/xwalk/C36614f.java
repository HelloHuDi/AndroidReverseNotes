package com.tencent.xweb.xwalk;

import android.content.Context;
import android.net.Uri;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView.FindListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.C24530n;
import com.tencent.xweb.C36588j;
import com.tencent.xweb.C41127g;
import com.tencent.xweb.C46945h;
import com.tencent.xweb.p1428a.C31137a;
import java.util.Map;
import org.xwalk.core.XWalkDownloadListener;
import org.xwalk.core.XWalkFindListener;
import org.xwalk.core.XWalkGeolocationPermissionsCallback;
import org.xwalk.core.XWalkJavascriptResult;
import org.xwalk.core.XWalkUIClient.ConsoleMessageType;
import org.xwalk.core.XWalkWebResourceRequest;

/* renamed from: com.tencent.xweb.xwalk.f */
public final class C36614f {

    /* renamed from: com.tencent.xweb.xwalk.f$g */
    public static class C6068g implements C36588j {
        ValueCallback<Boolean> ARW;

        public C6068g(ValueCallback<Boolean> valueCallback) {
            this.ARW = valueCallback;
        }

        public final void proceed() {
            AppMethodBeat.m2504i(85227);
            this.ARW.onReceiveValue(Boolean.TRUE);
            AppMethodBeat.m2505o(85227);
        }

        public final void cancel() {
            AppMethodBeat.m2504i(85228);
            this.ARW.onReceiveValue(Boolean.FALSE);
            AppMethodBeat.m2505o(85228);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.f$1 */
    static /* synthetic */ class C245661 {
        static final /* synthetic */ int[] ARS = new int[ConsoleMessageType.values().length];

        static {
            AppMethodBeat.m2504i(85216);
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
                AppMethodBeat.m2505o(85216);
            } catch (NoSuchFieldError e5) {
                AppMethodBeat.m2505o(85216);
            }
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.f$d */
    public static class C24567d extends C41127g {
        public XWalkJavascriptResult ARV;

        public C24567d(XWalkJavascriptResult xWalkJavascriptResult) {
            this.ARV = xWalkJavascriptResult;
        }

        public final void confirmWithResult(String str) {
            AppMethodBeat.m2504i(85222);
            this.ARV.confirmWithResult(str);
            AppMethodBeat.m2505o(85222);
        }

        public final void confirm() {
            AppMethodBeat.m2504i(85223);
            this.ARV.confirm();
            AppMethodBeat.m2505o(85223);
        }

        public final void cancel() {
            AppMethodBeat.m2504i(85224);
            this.ARV.cancel();
            AppMethodBeat.m2505o(85224);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.f$f */
    public static class C24568f extends XWalkFindListener {
        FindListener AQm;

        public C24568f(FindListener findListener) {
            this.AQm = findListener;
        }

        public final void onFindResultReceived(int i, int i2, boolean z) {
            AppMethodBeat.m2504i(85226);
            if (this.AQm != null) {
                this.AQm.onFindResultReceived(i, i2, z);
            }
            AppMethodBeat.m2505o(85226);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.f$b */
    public static class C36611b implements Callback {
        XWalkGeolocationPermissionsCallback ARU;

        public C36611b(XWalkGeolocationPermissionsCallback xWalkGeolocationPermissionsCallback) {
            this.ARU = xWalkGeolocationPermissionsCallback;
        }

        public final void invoke(String str, boolean z, boolean z2) {
            AppMethodBeat.m2504i(85218);
            if (this.ARU != null) {
                this.ARU.invoke(str, z, z2);
            }
            AppMethodBeat.m2505o(85218);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.f$e */
    public static class C36612e extends XWalkDownloadListener {
        DownloadListener AQl;

        public C36612e(Context context, DownloadListener downloadListener) {
            super(context);
            this.AQl = downloadListener;
        }

        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            AppMethodBeat.m2504i(85225);
            if (this.AQl != null) {
                this.AQl.onDownloadStart(str, str2, str3, str4, j);
            }
            AppMethodBeat.m2505o(85225);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.f$h */
    public static class C36613h implements C24530n {
        private boolean APL;
        private boolean APM;
        C31137a APN = new C31137a(this);
        private String method;
        private Uri url;
        private Map<String, String> vfl;

        public C36613h(XWalkWebResourceRequest xWalkWebResourceRequest) {
            AppMethodBeat.m2504i(85229);
            this.url = xWalkWebResourceRequest.getUrl();
            this.APL = xWalkWebResourceRequest.isForMainFrame();
            this.APM = xWalkWebResourceRequest.hasGesture();
            this.method = xWalkWebResourceRequest.getMethod();
            this.vfl = xWalkWebResourceRequest.getRequestHeaders();
            AppMethodBeat.m2505o(85229);
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

    /* renamed from: com.tencent.xweb.xwalk.f$a */
    public static class C36615a implements CustomViewCallback {
        org.xwalk.core.CustomViewCallback ART;

        C36615a(org.xwalk.core.CustomViewCallback customViewCallback) {
            this.ART = customViewCallback;
        }

        public final void onCustomViewHidden() {
            AppMethodBeat.m2504i(85217);
            this.ART.onCustomViewHidden();
            AppMethodBeat.m2505o(85217);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.f$c */
    public static class C36616c extends C46945h {
        public XWalkJavascriptResult ARV;

        public C36616c(XWalkJavascriptResult xWalkJavascriptResult) {
            this.ARV = xWalkJavascriptResult;
        }

        public final void confirmWithResult(String str) {
            AppMethodBeat.m2504i(85219);
            this.ARV.confirmWithResult(str);
            AppMethodBeat.m2505o(85219);
        }

        public final void confirm() {
            AppMethodBeat.m2504i(85220);
            this.ARV.confirm();
            AppMethodBeat.m2505o(85220);
        }

        public final void cancel() {
            AppMethodBeat.m2504i(85221);
            this.ARV.cancel();
            AppMethodBeat.m2505o(85221);
        }
    }
}
