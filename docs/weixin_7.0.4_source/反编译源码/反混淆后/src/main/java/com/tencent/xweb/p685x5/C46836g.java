package com.tencent.xweb.p685x5;

import android.net.Uri;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.xweb.C24530n;
import com.tencent.xweb.C31147o;
import com.tencent.xweb.C36588j;
import com.tencent.xweb.C41127g;
import com.tencent.xweb.C46945h;
import com.tencent.xweb.C6031l.C6032a;
import java.util.Map;

@JgClassChecked(author = 30, fComment = "checked", lastDate = "20171020", reviewer = 30, vComment = {EType.JSEXECUTECHECK})
/* renamed from: com.tencent.xweb.x5.g */
public final class C46836g {

    /* renamed from: com.tencent.xweb.x5.g$1 */
    static /* synthetic */ class C164051 {
        static final /* synthetic */ int[] AQu = new int[MessageLevel.values().length];

        static {
            AppMethodBeat.m2504i(84821);
            try {
                AQu[MessageLevel.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                AQu[MessageLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                AQu[MessageLevel.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                AQu[MessageLevel.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                AQu[MessageLevel.WARNING.ordinal()] = 5;
                AppMethodBeat.m2505o(84821);
            } catch (NoSuchFieldError e5) {
                AppMethodBeat.m2505o(84821);
            }
        }
    }

    /* renamed from: com.tencent.xweb.x5.g$c */
    public static class C24541c implements CustomViewCallback {
        IX5WebChromeClient.CustomViewCallback AQw;

        C24541c(IX5WebChromeClient.CustomViewCallback customViewCallback) {
            this.AQw = customViewCallback;
        }

        public final void onCustomViewHidden() {
            AppMethodBeat.m2504i(84825);
            this.AQw.onCustomViewHidden();
            AppMethodBeat.m2505o(84825);
        }
    }

    /* renamed from: com.tencent.xweb.x5.g$f */
    public static class C24542f extends C46945h {
        public JsResult AQz;

        public C24542f(JsResult jsResult) {
            this.AQz = jsResult;
        }

        public final void confirmWithResult(String str) {
        }

        public final void confirm() {
            AppMethodBeat.m2504i(84830);
            this.AQz.confirm();
            AppMethodBeat.m2505o(84830);
        }

        public final void cancel() {
            AppMethodBeat.m2504i(84831);
            this.AQz.cancel();
            AppMethodBeat.m2505o(84831);
        }
    }

    /* renamed from: com.tencent.xweb.x5.g$d */
    public static class C25017d extends C6032a {
        public FileChooserParams AQx;

        public C25017d(FileChooserParams fileChooserParams) {
            this.AQx = fileChooserParams;
        }

        public final int getMode() {
            AppMethodBeat.m2504i(84826);
            if (this.AQx != null) {
                int mode = this.AQx.getMode();
                AppMethodBeat.m2505o(84826);
                return mode;
            }
            AppMethodBeat.m2505o(84826);
            return 0;
        }

        public final String[] getAcceptTypes() {
            AppMethodBeat.m2504i(84827);
            String[] acceptTypes;
            if (this.AQx != null) {
                acceptTypes = this.AQx.getAcceptTypes();
                AppMethodBeat.m2505o(84827);
                return acceptTypes;
            }
            acceptTypes = new String[0];
            AppMethodBeat.m2505o(84827);
            return acceptTypes;
        }

        public final boolean isCaptureEnabled() {
            AppMethodBeat.m2504i(84828);
            if (this.AQx != null) {
                boolean isCaptureEnabled = this.AQx.isCaptureEnabled();
                AppMethodBeat.m2505o(84828);
                return isCaptureEnabled;
            }
            AppMethodBeat.m2505o(84828);
            return false;
        }
    }

    /* renamed from: com.tencent.xweb.x5.g$b */
    public static class C31151b implements C24530n {
        private boolean APL;
        private boolean APM;
        private String method;
        private Uri url;
        private Map<String, String> vfl;

        public C31151b(WebResourceRequest webResourceRequest) {
            AppMethodBeat.m2504i(84824);
            this.url = webResourceRequest.getUrl();
            this.APL = webResourceRequest.isForMainFrame();
            this.APM = webResourceRequest.hasGesture();
            this.method = webResourceRequest.getMethod();
            this.vfl = webResourceRequest.getRequestHeaders();
            AppMethodBeat.m2505o(84824);
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

    /* renamed from: com.tencent.xweb.x5.g$e */
    public static class C36597e implements Callback {
        GeolocationPermissionsCallback AQy;

        public C36597e(GeolocationPermissionsCallback geolocationPermissionsCallback) {
            this.AQy = geolocationPermissionsCallback;
        }

        public final void invoke(String str, boolean z, boolean z2) {
            AppMethodBeat.m2504i(84829);
            if (this.AQy != null) {
                this.AQy.invoke(str, z, z2);
            }
            AppMethodBeat.m2505o(84829);
        }
    }

    /* renamed from: com.tencent.xweb.x5.g$a */
    public static class C44591a implements C36588j {
        SslErrorHandler AQv;

        public C44591a(SslErrorHandler sslErrorHandler) {
            this.AQv = sslErrorHandler;
        }

        public final void proceed() {
            AppMethodBeat.m2504i(84822);
            this.AQv.proceed();
            AppMethodBeat.m2505o(84822);
        }

        public final void cancel() {
            AppMethodBeat.m2504i(84823);
            this.AQv.cancel();
            AppMethodBeat.m2505o(84823);
        }
    }

    /* renamed from: com.tencent.xweb.x5.g$g */
    public static class C44592g extends C41127g {
        public JsPromptResult AQA;

        public C44592g(JsPromptResult jsPromptResult) {
            this.AQA = jsPromptResult;
        }

        public final void confirmWithResult(String str) {
        }

        public final void confirm() {
            AppMethodBeat.m2504i(84832);
            this.AQA.confirm();
            AppMethodBeat.m2505o(84832);
        }

        public final void cancel() {
            AppMethodBeat.m2504i(84833);
            this.AQA.cancel();
            AppMethodBeat.m2505o(84833);
        }
    }

    /* renamed from: a */
    public static C31147o m89071a(WebResourceResponse webResourceResponse) {
        AppMethodBeat.m2504i(84834);
        if (webResourceResponse == null) {
            AppMethodBeat.m2505o(84834);
            return null;
        }
        C31147o c31147o = new C31147o(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceResponse.getResponseHeaders(), webResourceResponse.getData());
        AppMethodBeat.m2505o(84834);
        return c31147o;
    }
}
