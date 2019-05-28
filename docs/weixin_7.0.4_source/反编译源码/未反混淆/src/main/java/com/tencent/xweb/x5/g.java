package com.tencent.xweb.x5;

import android.net.Uri;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.jg.EType;
import com.jg.JgClassChecked;
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
import com.tencent.xweb.h;
import com.tencent.xweb.j;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import java.util.Map;

@JgClassChecked(author = 30, fComment = "checked", lastDate = "20171020", reviewer = 30, vComment = {EType.JSEXECUTECHECK})
public final class g {

    /* renamed from: com.tencent.xweb.x5.g$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] AQu = new int[MessageLevel.values().length];

        static {
            AppMethodBeat.i(84821);
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
                AppMethodBeat.o(84821);
            } catch (NoSuchFieldError e5) {
                AppMethodBeat.o(84821);
            }
        }
    }

    public static class c implements CustomViewCallback {
        IX5WebChromeClient.CustomViewCallback AQw;

        c(IX5WebChromeClient.CustomViewCallback customViewCallback) {
            this.AQw = customViewCallback;
        }

        public final void onCustomViewHidden() {
            AppMethodBeat.i(84825);
            this.AQw.onCustomViewHidden();
            AppMethodBeat.o(84825);
        }
    }

    public static class f extends h {
        public JsResult AQz;

        public f(JsResult jsResult) {
            this.AQz = jsResult;
        }

        public final void confirmWithResult(String str) {
        }

        public final void confirm() {
            AppMethodBeat.i(84830);
            this.AQz.confirm();
            AppMethodBeat.o(84830);
        }

        public final void cancel() {
            AppMethodBeat.i(84831);
            this.AQz.cancel();
            AppMethodBeat.o(84831);
        }
    }

    public static class d extends com.tencent.xweb.l.a {
        public FileChooserParams AQx;

        public d(FileChooserParams fileChooserParams) {
            this.AQx = fileChooserParams;
        }

        public final int getMode() {
            AppMethodBeat.i(84826);
            if (this.AQx != null) {
                int mode = this.AQx.getMode();
                AppMethodBeat.o(84826);
                return mode;
            }
            AppMethodBeat.o(84826);
            return 0;
        }

        public final String[] getAcceptTypes() {
            AppMethodBeat.i(84827);
            String[] acceptTypes;
            if (this.AQx != null) {
                acceptTypes = this.AQx.getAcceptTypes();
                AppMethodBeat.o(84827);
                return acceptTypes;
            }
            acceptTypes = new String[0];
            AppMethodBeat.o(84827);
            return acceptTypes;
        }

        public final boolean isCaptureEnabled() {
            AppMethodBeat.i(84828);
            if (this.AQx != null) {
                boolean isCaptureEnabled = this.AQx.isCaptureEnabled();
                AppMethodBeat.o(84828);
                return isCaptureEnabled;
            }
            AppMethodBeat.o(84828);
            return false;
        }
    }

    public static class b implements n {
        private boolean APL;
        private boolean APM;
        private String method;
        private Uri url;
        private Map<String, String> vfl;

        public b(WebResourceRequest webResourceRequest) {
            AppMethodBeat.i(84824);
            this.url = webResourceRequest.getUrl();
            this.APL = webResourceRequest.isForMainFrame();
            this.APM = webResourceRequest.hasGesture();
            this.method = webResourceRequest.getMethod();
            this.vfl = webResourceRequest.getRequestHeaders();
            AppMethodBeat.o(84824);
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

    public static class e implements Callback {
        GeolocationPermissionsCallback AQy;

        public e(GeolocationPermissionsCallback geolocationPermissionsCallback) {
            this.AQy = geolocationPermissionsCallback;
        }

        public final void invoke(String str, boolean z, boolean z2) {
            AppMethodBeat.i(84829);
            if (this.AQy != null) {
                this.AQy.invoke(str, z, z2);
            }
            AppMethodBeat.o(84829);
        }
    }

    public static class a implements j {
        SslErrorHandler AQv;

        public a(SslErrorHandler sslErrorHandler) {
            this.AQv = sslErrorHandler;
        }

        public final void proceed() {
            AppMethodBeat.i(84822);
            this.AQv.proceed();
            AppMethodBeat.o(84822);
        }

        public final void cancel() {
            AppMethodBeat.i(84823);
            this.AQv.cancel();
            AppMethodBeat.o(84823);
        }
    }

    public static class g extends com.tencent.xweb.g {
        public JsPromptResult AQA;

        public g(JsPromptResult jsPromptResult) {
            this.AQA = jsPromptResult;
        }

        public final void confirmWithResult(String str) {
        }

        public final void confirm() {
            AppMethodBeat.i(84832);
            this.AQA.confirm();
            AppMethodBeat.o(84832);
        }

        public final void cancel() {
            AppMethodBeat.i(84833);
            this.AQA.cancel();
            AppMethodBeat.o(84833);
        }
    }

    public static o a(WebResourceResponse webResourceResponse) {
        AppMethodBeat.i(84834);
        if (webResourceResponse == null) {
            AppMethodBeat.o(84834);
            return null;
        }
        o oVar = new o(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceResponse.getResponseHeaders(), webResourceResponse.getData());
        AppMethodBeat.o(84834);
        return oVar;
    }
}
