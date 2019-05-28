package com.tencent.xweb.sys;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.g;
import com.tencent.xweb.h;
import com.tencent.xweb.j;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import java.util.Map;
import org.xwalk.core.Log;

public final class c {

    public static class b extends com.tencent.xweb.l.a {
        public FileChooserParams APH;

        public b(FileChooserParams fileChooserParams) {
            this.APH = fileChooserParams;
        }

        @TargetApi(21)
        public final int getMode() {
            AppMethodBeat.i(84651);
            if (this.APH != null) {
                int mode = this.APH.getMode();
                AppMethodBeat.o(84651);
                return mode;
            }
            AppMethodBeat.o(84651);
            return 0;
        }

        @TargetApi(21)
        public final String[] getAcceptTypes() {
            AppMethodBeat.i(84652);
            String[] acceptTypes;
            if (this.APH != null) {
                acceptTypes = this.APH.getAcceptTypes();
                AppMethodBeat.o(84652);
                return acceptTypes;
            }
            acceptTypes = new String[0];
            AppMethodBeat.o(84652);
            return acceptTypes;
        }

        @TargetApi(21)
        public final boolean isCaptureEnabled() {
            AppMethodBeat.i(84653);
            if (this.APH != null) {
                boolean isCaptureEnabled = this.APH.isCaptureEnabled();
                AppMethodBeat.o(84653);
                return isCaptureEnabled;
            }
            AppMethodBeat.o(84653);
            return false;
        }
    }

    @JgClassChecked(author = 30, fComment = "checked", lastDate = "20171024", reviewer = 30, vComment = {EType.JSEXECUTECHECK})
    public static class a implements j {
        SslErrorHandler APG;

        public a(SslErrorHandler sslErrorHandler) {
            this.APG = sslErrorHandler;
        }

        public final void proceed() {
            AppMethodBeat.i(84649);
            this.APG.proceed();
            AppMethodBeat.o(84649);
        }

        public final void cancel() {
            AppMethodBeat.i(84650);
            this.APG.cancel();
            AppMethodBeat.o(84650);
        }
    }

    public static class c extends g {
        public JsPromptResult APJ;

        public c(JsPromptResult jsPromptResult) {
            this.APJ = jsPromptResult;
        }

        public final void confirmWithResult(String str) {
        }

        public final void confirm() {
            AppMethodBeat.i(84654);
            if (this.APJ != null) {
                this.APJ.confirm();
            }
            AppMethodBeat.o(84654);
        }

        public final void cancel() {
            AppMethodBeat.i(84655);
            if (this.APJ != null) {
                this.APJ.cancel();
            }
            AppMethodBeat.o(84655);
        }
    }

    public static class d extends h {
        public JsResult APK;

        public d(JsResult jsResult) {
            this.APK = jsResult;
        }

        public final void confirmWithResult(String str) {
        }

        public final void confirm() {
            AppMethodBeat.i(84656);
            if (this.APK != null) {
                this.APK.confirm();
            }
            AppMethodBeat.o(84656);
        }

        public final void cancel() {
            AppMethodBeat.i(84657);
            if (this.APK != null) {
                this.APK.cancel();
            }
            AppMethodBeat.o(84657);
        }
    }

    public static class e implements n {
        private boolean APL;
        private boolean APM;
        com.tencent.xweb.a.a APN;
        private String method;
        private Uri url;
        private Map<String, String> vfl;

        public e(WebResourceRequest webResourceRequest) {
            AppMethodBeat.i(84658);
            if (VERSION.SDK_INT >= 21) {
                this.url = webResourceRequest.getUrl();
                this.APL = webResourceRequest.isForMainFrame();
                this.APM = webResourceRequest.hasGesture();
                this.method = webResourceRequest.getMethod();
                this.vfl = webResourceRequest.getRequestHeaders();
                this.APN = new com.tencent.xweb.a.a(this);
            }
            AppMethodBeat.o(84658);
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

    public static WebResourceResponse a(o oVar) {
        AppMethodBeat.i(84659);
        if (oVar == null) {
            AppMethodBeat.o(84659);
            return null;
        }
        WebResourceResponse webResourceResponse;
        if (oVar.AMD && VERSION.SDK_INT >= 21) {
            try {
                webResourceResponse = new WebResourceResponse(oVar.mMimeType, oVar.mEncoding, oVar.mStatusCode, oVar.mReasonPhrase, oVar.mResponseHeaders, oVar.mInputStream);
                AppMethodBeat.o(84659);
                return webResourceResponse;
            } catch (Exception e) {
                Log.e("SysWebDataTrans", "create webkit WebResourceResponse error :" + e.getMessage());
            }
        }
        webResourceResponse = new WebResourceResponse(oVar.mMimeType, oVar.mEncoding, oVar.mInputStream);
        if (VERSION.SDK_INT >= 21) {
            if (!(oVar.mStatusCode <= 100 || oVar.mReasonPhrase == null || oVar.mReasonPhrase.isEmpty())) {
                webResourceResponse.setStatusCodeAndReasonPhrase(oVar.mStatusCode, oVar.mReasonPhrase);
            }
            webResourceResponse.setResponseHeaders(oVar.mResponseHeaders);
        }
        AppMethodBeat.o(84659);
        return webResourceResponse;
    }
}
