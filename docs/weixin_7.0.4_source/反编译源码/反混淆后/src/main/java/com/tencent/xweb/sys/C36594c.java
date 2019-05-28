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
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.C24530n;
import com.tencent.xweb.C31147o;
import com.tencent.xweb.C36588j;
import com.tencent.xweb.C41127g;
import com.tencent.xweb.C46945h;
import com.tencent.xweb.C6031l.C6032a;
import com.tencent.xweb.p1428a.C31137a;
import java.util.Map;
import org.xwalk.core.Log;

/* renamed from: com.tencent.xweb.sys.c */
public final class C36594c {

    /* renamed from: com.tencent.xweb.sys.c$b */
    public static class C16397b extends C6032a {
        public FileChooserParams APH;

        public C16397b(FileChooserParams fileChooserParams) {
            this.APH = fileChooserParams;
        }

        @TargetApi(21)
        public final int getMode() {
            AppMethodBeat.m2504i(84651);
            if (this.APH != null) {
                int mode = this.APH.getMode();
                AppMethodBeat.m2505o(84651);
                return mode;
            }
            AppMethodBeat.m2505o(84651);
            return 0;
        }

        @TargetApi(21)
        public final String[] getAcceptTypes() {
            AppMethodBeat.m2504i(84652);
            String[] acceptTypes;
            if (this.APH != null) {
                acceptTypes = this.APH.getAcceptTypes();
                AppMethodBeat.m2505o(84652);
                return acceptTypes;
            }
            acceptTypes = new String[0];
            AppMethodBeat.m2505o(84652);
            return acceptTypes;
        }

        @TargetApi(21)
        public final boolean isCaptureEnabled() {
            AppMethodBeat.m2504i(84653);
            if (this.APH != null) {
                boolean isCaptureEnabled = this.APH.isCaptureEnabled();
                AppMethodBeat.m2505o(84653);
                return isCaptureEnabled;
            }
            AppMethodBeat.m2505o(84653);
            return false;
        }
    }

    @JgClassChecked(author = 30, fComment = "checked", lastDate = "20171024", reviewer = 30, vComment = {EType.JSEXECUTECHECK})
    /* renamed from: com.tencent.xweb.sys.c$a */
    public static class C31148a implements C36588j {
        SslErrorHandler APG;

        public C31148a(SslErrorHandler sslErrorHandler) {
            this.APG = sslErrorHandler;
        }

        public final void proceed() {
            AppMethodBeat.m2504i(84649);
            this.APG.proceed();
            AppMethodBeat.m2505o(84649);
        }

        public final void cancel() {
            AppMethodBeat.m2504i(84650);
            this.APG.cancel();
            AppMethodBeat.m2505o(84650);
        }
    }

    /* renamed from: com.tencent.xweb.sys.c$c */
    public static class C36593c extends C41127g {
        public JsPromptResult APJ;

        public C36593c(JsPromptResult jsPromptResult) {
            this.APJ = jsPromptResult;
        }

        public final void confirmWithResult(String str) {
        }

        public final void confirm() {
            AppMethodBeat.m2504i(84654);
            if (this.APJ != null) {
                this.APJ.confirm();
            }
            AppMethodBeat.m2505o(84654);
        }

        public final void cancel() {
            AppMethodBeat.m2504i(84655);
            if (this.APJ != null) {
                this.APJ.cancel();
            }
            AppMethodBeat.m2505o(84655);
        }
    }

    /* renamed from: com.tencent.xweb.sys.c$d */
    public static class C36595d extends C46945h {
        public JsResult APK;

        public C36595d(JsResult jsResult) {
            this.APK = jsResult;
        }

        public final void confirmWithResult(String str) {
        }

        public final void confirm() {
            AppMethodBeat.m2504i(84656);
            if (this.APK != null) {
                this.APK.confirm();
            }
            AppMethodBeat.m2505o(84656);
        }

        public final void cancel() {
            AppMethodBeat.m2504i(84657);
            if (this.APK != null) {
                this.APK.cancel();
            }
            AppMethodBeat.m2505o(84657);
        }
    }

    /* renamed from: com.tencent.xweb.sys.c$e */
    public static class C36596e implements C24530n {
        private boolean APL;
        private boolean APM;
        C31137a APN;
        private String method;
        private Uri url;
        private Map<String, String> vfl;

        public C36596e(WebResourceRequest webResourceRequest) {
            AppMethodBeat.m2504i(84658);
            if (VERSION.SDK_INT >= 21) {
                this.url = webResourceRequest.getUrl();
                this.APL = webResourceRequest.isForMainFrame();
                this.APM = webResourceRequest.hasGesture();
                this.method = webResourceRequest.getMethod();
                this.vfl = webResourceRequest.getRequestHeaders();
                this.APN = new C31137a(this);
            }
            AppMethodBeat.m2505o(84658);
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

    /* renamed from: a */
    public static WebResourceResponse m60684a(C31147o c31147o) {
        AppMethodBeat.m2504i(84659);
        if (c31147o == null) {
            AppMethodBeat.m2505o(84659);
            return null;
        }
        WebResourceResponse webResourceResponse;
        if (c31147o.AMD && VERSION.SDK_INT >= 21) {
            try {
                webResourceResponse = new WebResourceResponse(c31147o.mMimeType, c31147o.mEncoding, c31147o.mStatusCode, c31147o.mReasonPhrase, c31147o.mResponseHeaders, c31147o.mInputStream);
                AppMethodBeat.m2505o(84659);
                return webResourceResponse;
            } catch (Exception e) {
                Log.m81046e("SysWebDataTrans", "create webkit WebResourceResponse error :" + e.getMessage());
            }
        }
        webResourceResponse = new WebResourceResponse(c31147o.mMimeType, c31147o.mEncoding, c31147o.mInputStream);
        if (VERSION.SDK_INT >= 21) {
            if (!(c31147o.mStatusCode <= 100 || c31147o.mReasonPhrase == null || c31147o.mReasonPhrase.isEmpty())) {
                webResourceResponse.setStatusCodeAndReasonPhrase(c31147o.mStatusCode, c31147o.mReasonPhrase);
            }
            webResourceResponse.setResponseHeaders(c31147o.mResponseHeaders);
        }
        AppMethodBeat.m2505o(84659);
        return webResourceResponse;
    }
}
