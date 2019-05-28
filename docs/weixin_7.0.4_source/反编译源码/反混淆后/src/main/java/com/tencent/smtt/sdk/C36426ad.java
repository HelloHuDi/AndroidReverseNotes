package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.WebResourceError;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.utils.C30951r;
import com.tencent.smtt.utils.C36447w;
import com.tencent.smtt.utils.TbsLog;
import java.io.InputStream;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map;

@SuppressLint({"NewApi", "Override"})
/* renamed from: com.tencent.smtt.sdk.ad */
class C36426ad extends WebViewClient {
    /* renamed from: c */
    private static String f15122c = null;
    /* renamed from: a */
    private WebViewClient f15123a;
    /* renamed from: b */
    private WebView f15124b;

    /* renamed from: com.tencent.smtt.sdk.ad$f */
    static class C16145f implements WebResourceRequest {
        /* renamed from: a */
        android.webkit.WebResourceRequest f3019a;

        C16145f(android.webkit.WebResourceRequest webResourceRequest) {
            this.f3019a = webResourceRequest;
        }

        public String getMethod() {
            AppMethodBeat.m2504i(64219);
            String method = this.f3019a.getMethod();
            AppMethodBeat.m2505o(64219);
            return method;
        }

        public Map<String, String> getRequestHeaders() {
            AppMethodBeat.m2504i(64220);
            Map requestHeaders = this.f3019a.getRequestHeaders();
            AppMethodBeat.m2505o(64220);
            return requestHeaders;
        }

        public Uri getUrl() {
            AppMethodBeat.m2504i(64221);
            Uri url = this.f3019a.getUrl();
            AppMethodBeat.m2505o(64221);
            return url;
        }

        public boolean hasGesture() {
            AppMethodBeat.m2504i(64222);
            boolean hasGesture = this.f3019a.hasGesture();
            AppMethodBeat.m2505o(64222);
            return hasGesture;
        }

        public boolean isForMainFrame() {
            AppMethodBeat.m2504i(64223);
            boolean isForMainFrame = this.f3019a.isForMainFrame();
            AppMethodBeat.m2505o(64223);
            return isForMainFrame;
        }

        public boolean isRedirect() {
            boolean booleanValue;
            AppMethodBeat.m2504i(64224);
            if (VERSION.SDK_INT >= 24) {
                Object a = C30951r.m49577a(this.f3019a, "isRedirect");
                if (a instanceof Boolean) {
                    booleanValue = ((Boolean) a).booleanValue();
                    AppMethodBeat.m2505o(64224);
                    return booleanValue;
                }
            }
            booleanValue = false;
            AppMethodBeat.m2505o(64224);
            return booleanValue;
        }
    }

    /* renamed from: com.tencent.smtt.sdk.ad$a */
    static class C24266a extends ClientCertRequest {
        /* renamed from: a */
        private android.webkit.ClientCertRequest f4518a;

        public C24266a(android.webkit.ClientCertRequest clientCertRequest) {
            this.f4518a = clientCertRequest;
        }

        public void cancel() {
            AppMethodBeat.m2504i(64202);
            this.f4518a.cancel();
            AppMethodBeat.m2505o(64202);
        }

        public String getHost() {
            AppMethodBeat.m2504i(64203);
            String host = this.f4518a.getHost();
            AppMethodBeat.m2505o(64203);
            return host;
        }

        public String[] getKeyTypes() {
            AppMethodBeat.m2504i(64204);
            String[] keyTypes = this.f4518a.getKeyTypes();
            AppMethodBeat.m2505o(64204);
            return keyTypes;
        }

        public int getPort() {
            AppMethodBeat.m2504i(64205);
            int port = this.f4518a.getPort();
            AppMethodBeat.m2505o(64205);
            return port;
        }

        public Principal[] getPrincipals() {
            AppMethodBeat.m2504i(64206);
            Principal[] principals = this.f4518a.getPrincipals();
            AppMethodBeat.m2505o(64206);
            return principals;
        }

        public void ignore() {
            AppMethodBeat.m2504i(64207);
            this.f4518a.ignore();
            AppMethodBeat.m2505o(64207);
        }

        public void proceed(PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
            AppMethodBeat.m2504i(64208);
            this.f4518a.proceed(privateKey, x509CertificateArr);
            AppMethodBeat.m2505o(64208);
        }
    }

    /* renamed from: com.tencent.smtt.sdk.ad$g */
    static class C36425g extends WebResourceResponse {
        /* renamed from: a */
        android.webkit.WebResourceResponse f15121a;

        public C36425g(android.webkit.WebResourceResponse webResourceResponse) {
            this.f15121a = webResourceResponse;
        }

        public InputStream getData() {
            AppMethodBeat.m2504i(64225);
            InputStream data = this.f15121a.getData();
            AppMethodBeat.m2505o(64225);
            return data;
        }

        public String getEncoding() {
            AppMethodBeat.m2504i(64226);
            String encoding = this.f15121a.getEncoding();
            AppMethodBeat.m2505o(64226);
            return encoding;
        }

        public String getMimeType() {
            AppMethodBeat.m2504i(64227);
            String mimeType = this.f15121a.getMimeType();
            AppMethodBeat.m2505o(64227);
            return mimeType;
        }

        public String getReasonPhrase() {
            AppMethodBeat.m2504i(64228);
            String reasonPhrase = this.f15121a.getReasonPhrase();
            AppMethodBeat.m2505o(64228);
            return reasonPhrase;
        }

        public Map<String, String> getResponseHeaders() {
            AppMethodBeat.m2504i(64229);
            Map responseHeaders = this.f15121a.getResponseHeaders();
            AppMethodBeat.m2505o(64229);
            return responseHeaders;
        }

        public int getStatusCode() {
            AppMethodBeat.m2504i(64230);
            int statusCode = this.f15121a.getStatusCode();
            AppMethodBeat.m2505o(64230);
            return statusCode;
        }

        public void setData(InputStream inputStream) {
            AppMethodBeat.m2504i(64231);
            this.f15121a.setData(inputStream);
            AppMethodBeat.m2505o(64231);
        }

        public void setEncoding(String str) {
            AppMethodBeat.m2504i(64232);
            this.f15121a.setEncoding(str);
            AppMethodBeat.m2505o(64232);
        }

        public void setMimeType(String str) {
            AppMethodBeat.m2504i(64233);
            this.f15121a.setMimeType(str);
            AppMethodBeat.m2505o(64233);
        }

        public void setResponseHeaders(Map<String, String> map) {
            AppMethodBeat.m2504i(64234);
            this.f15121a.setResponseHeaders(map);
            AppMethodBeat.m2505o(64234);
        }

        public void setStatusCodeAndReasonPhrase(int i, String str) {
            AppMethodBeat.m2504i(64235);
            this.f15121a.setStatusCodeAndReasonPhrase(i, str);
            AppMethodBeat.m2505o(64235);
        }
    }

    /* renamed from: com.tencent.smtt.sdk.ad$b */
    static class C36427b implements HttpAuthHandler {
        /* renamed from: a */
        private android.webkit.HttpAuthHandler f15125a;

        C36427b(android.webkit.HttpAuthHandler httpAuthHandler) {
            this.f15125a = httpAuthHandler;
        }

        public void cancel() {
            AppMethodBeat.m2504i(64210);
            this.f15125a.cancel();
            AppMethodBeat.m2505o(64210);
        }

        public void proceed(String str, String str2) {
            AppMethodBeat.m2504i(64209);
            this.f15125a.proceed(str, str2);
            AppMethodBeat.m2505o(64209);
        }

        public boolean useHttpAuthUsernamePassword() {
            AppMethodBeat.m2504i(64211);
            boolean useHttpAuthUsernamePassword = this.f15125a.useHttpAuthUsernamePassword();
            AppMethodBeat.m2505o(64211);
            return useHttpAuthUsernamePassword;
        }
    }

    /* renamed from: com.tencent.smtt.sdk.ad$d */
    static class C36428d implements SslError {
        /* renamed from: a */
        android.net.http.SslError f15126a;

        C36428d(android.net.http.SslError sslError) {
            this.f15126a = sslError;
        }

        public boolean addError(int i) {
            AppMethodBeat.m2504i(64215);
            boolean addError = this.f15126a.addError(i);
            AppMethodBeat.m2505o(64215);
            return addError;
        }

        public SslCertificate getCertificate() {
            AppMethodBeat.m2504i(64214);
            SslCertificate certificate = this.f15126a.getCertificate();
            AppMethodBeat.m2505o(64214);
            return certificate;
        }

        public int getPrimaryError() {
            AppMethodBeat.m2504i(64217);
            int primaryError = this.f15126a.getPrimaryError();
            AppMethodBeat.m2505o(64217);
            return primaryError;
        }

        public boolean hasError(int i) {
            AppMethodBeat.m2504i(64216);
            boolean hasError = this.f15126a.hasError(i);
            AppMethodBeat.m2505o(64216);
            return hasError;
        }
    }

    /* renamed from: com.tencent.smtt.sdk.ad$e */
    class C36429e implements WebResourceRequest {
        /* renamed from: b */
        private String f15128b;
        /* renamed from: c */
        private boolean f15129c;
        /* renamed from: d */
        private boolean f15130d;
        /* renamed from: e */
        private boolean f15131e;
        /* renamed from: f */
        private String f15132f;
        /* renamed from: g */
        private Map<String, String> f15133g;

        public C36429e(String str, boolean z, boolean z2, boolean z3, String str2, Map<String, String> map) {
            this.f15128b = str;
            this.f15129c = z;
            this.f15130d = z2;
            this.f15131e = z3;
            this.f15132f = str2;
            this.f15133g = map;
        }

        public String getMethod() {
            return this.f15132f;
        }

        public Map<String, String> getRequestHeaders() {
            return this.f15133g;
        }

        public Uri getUrl() {
            AppMethodBeat.m2504i(64218);
            Uri parse = Uri.parse(this.f15128b);
            AppMethodBeat.m2505o(64218);
            return parse;
        }

        public boolean hasGesture() {
            return this.f15131e;
        }

        public boolean isForMainFrame() {
            return this.f15129c;
        }

        public boolean isRedirect() {
            return this.f15130d;
        }
    }

    /* renamed from: com.tencent.smtt.sdk.ad$c */
    static class C36430c implements SslErrorHandler {
        /* renamed from: a */
        android.webkit.SslErrorHandler f15134a;

        C36430c(android.webkit.SslErrorHandler sslErrorHandler) {
            this.f15134a = sslErrorHandler;
        }

        public void cancel() {
            AppMethodBeat.m2504i(64213);
            this.f15134a.cancel();
            AppMethodBeat.m2505o(64213);
        }

        public void proceed() {
            AppMethodBeat.m2504i(64212);
            this.f15134a.proceed();
            AppMethodBeat.m2505o(64212);
        }
    }

    C36426ad(WebView webView, WebViewClient webViewClient) {
        this.f15124b = webView;
        this.f15123a = webViewClient;
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        AppMethodBeat.m2504i(64248);
        this.f15124b.mo49871a(webView);
        this.f15123a.doUpdateVisitedHistory(this.f15124b, str, z);
        AppMethodBeat.m2505o(64248);
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        AppMethodBeat.m2504i(64241);
        this.f15124b.mo49871a(webView);
        this.f15123a.onFormResubmission(this.f15124b, message, message2);
        AppMethodBeat.m2505o(64241);
    }

    public void onLoadResource(WebView webView, String str) {
        AppMethodBeat.m2504i(64236);
        this.f15124b.mo49871a(webView);
        this.f15123a.onLoadResource(this.f15124b, str);
        AppMethodBeat.m2505o(64236);
    }

    public void onPageFinished(WebView webView, String str) {
        AppMethodBeat.m2504i(64242);
        if (f15122c == null) {
            C36447w a = C36447w.m60203a();
            if (a != null) {
                a.mo57637a(true);
                f15122c = Boolean.toString(true);
            }
        }
        this.f15124b.mo49871a(webView);
        WebView webView2 = this.f15124b;
        webView2.f13877a++;
        this.f15123a.onPageFinished(this.f15124b, str);
        if (TbsConfig.APP_QZONE.equals(webView.getContext().getApplicationInfo().packageName)) {
            this.f15124b.mo49870a(webView.getContext());
        }
        TbsLog.app_extra("SystemWebViewClient", webView.getContext());
        WebView.m49491d();
        if (!(TbsShareManager.mHasQueryed || this.f15124b.getContext() == null || !TbsShareManager.isThirdPartyApp(this.f15124b.getContext()))) {
            TbsShareManager.mHasQueryed = true;
            new Thread(new C16146ae(this)).start();
        }
        if (!(this.f15124b.getContext() == null || TbsLogReport.getInstance(this.f15124b.getContext()).getShouldUploadEventReport())) {
            TbsLogReport.getInstance(this.f15124b.getContext()).setShouldUploadEventReport(true);
            TbsLogReport.getInstance(this.f15124b.getContext()).dailyReport();
        }
        AppMethodBeat.m2505o(64242);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(64243);
        this.f15124b.mo49871a(webView);
        this.f15123a.onPageStarted(this.f15124b, str, bitmap);
        AppMethodBeat.m2505o(64243);
    }

    public void onReceivedClientCertRequest(WebView webView, android.webkit.ClientCertRequest clientCertRequest) {
        AppMethodBeat.m2504i(64251);
        if (VERSION.SDK_INT >= 21) {
            this.f15124b.mo49871a(webView);
            this.f15123a.onReceivedClientCertRequest(this.f15124b, new C24266a(clientCertRequest));
        }
        AppMethodBeat.m2505o(64251);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        AppMethodBeat.m2504i(64244);
        this.f15124b.mo49871a(webView);
        this.f15123a.onReceivedError(this.f15124b, i, str, str2);
        AppMethodBeat.m2505o(64244);
    }

    public void onReceivedError(WebView webView, android.webkit.WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        com.tencent.smtt.export.external.interfaces.WebResourceError webResourceError2 = null;
        AppMethodBeat.m2504i(64245);
        this.f15124b.mo49871a(webView);
        WebResourceRequest c16145f = webResourceRequest != null ? new C16145f(webResourceRequest) : null;
        if (webResourceError != null) {
            webResourceError2 = new C5811af(this, webResourceError);
        }
        this.f15123a.onReceivedError(this.f15124b, c16145f, webResourceError2);
        AppMethodBeat.m2505o(64245);
    }

    public void onReceivedHttpAuthRequest(WebView webView, android.webkit.HttpAuthHandler httpAuthHandler, String str, String str2) {
        AppMethodBeat.m2504i(64247);
        this.f15124b.mo49871a(webView);
        this.f15123a.onReceivedHttpAuthRequest(this.f15124b, new C36427b(httpAuthHandler), str, str2);
        AppMethodBeat.m2505o(64247);
    }

    public void onReceivedHttpError(WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceResponse webResourceResponse) {
        AppMethodBeat.m2504i(64246);
        this.f15124b.mo49871a(webView);
        this.f15123a.onReceivedHttpError(this.f15124b, new C16145f(webResourceRequest), new C36425g(webResourceResponse));
        AppMethodBeat.m2505o(64246);
    }

    @TargetApi(12)
    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        AppMethodBeat.m2504i(64249);
        if (VERSION.SDK_INT >= 12) {
            this.f15124b.mo49871a(webView);
            this.f15123a.onReceivedLoginRequest(this.f15124b, str, str2, str3);
        }
        AppMethodBeat.m2505o(64249);
    }

    @TargetApi(8)
    public void onReceivedSslError(WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
        AppMethodBeat.m2504i(64250);
        if (VERSION.SDK_INT >= 8) {
            this.f15124b.mo49871a(webView);
            this.f15123a.onReceivedSslError(this.f15124b, new C36430c(sslErrorHandler), new C36428d(sslError));
        }
        AppMethodBeat.m2505o(64250);
    }

    public void onScaleChanged(WebView webView, float f, float f2) {
        AppMethodBeat.m2504i(64252);
        this.f15124b.mo49871a(webView);
        this.f15123a.onScaleChanged(this.f15124b, f, f2);
        AppMethodBeat.m2505o(64252);
    }

    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        AppMethodBeat.m2504i(64253);
        this.f15124b.mo49871a(webView);
        this.f15123a.onTooManyRedirects(this.f15124b, message, message2);
        AppMethodBeat.m2505o(64253);
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(64254);
        this.f15124b.mo49871a(webView);
        this.f15123a.onUnhandledKeyEvent(this.f15124b, keyEvent);
        AppMethodBeat.m2505o(64254);
    }

    public android.webkit.WebResourceResponse shouldInterceptRequest(WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
        AppMethodBeat.m2504i(64239);
        if (VERSION.SDK_INT < 21) {
            AppMethodBeat.m2505o(64239);
            return null;
        } else if (webResourceRequest == null) {
            AppMethodBeat.m2505o(64239);
            return null;
        } else {
            boolean z = false;
            if (VERSION.SDK_INT >= 24) {
                Object a = C30951r.m49577a((Object) webResourceRequest, "isRedirect");
                if (a instanceof Boolean) {
                    z = ((Boolean) a).booleanValue();
                }
            }
            WebResourceResponse shouldInterceptRequest = this.f15123a.shouldInterceptRequest(this.f15124b, new C36429e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
            if (shouldInterceptRequest == null) {
                AppMethodBeat.m2505o(64239);
                return null;
            }
            android.webkit.WebResourceResponse webResourceResponse = new android.webkit.WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData());
            webResourceResponse.setResponseHeaders(shouldInterceptRequest.getResponseHeaders());
            int statusCode = shouldInterceptRequest.getStatusCode();
            String reasonPhrase = shouldInterceptRequest.getReasonPhrase();
            if (!(statusCode == webResourceResponse.getStatusCode() && (reasonPhrase == null || reasonPhrase.equals(webResourceResponse.getReasonPhrase())))) {
                webResourceResponse.setStatusCodeAndReasonPhrase(statusCode, reasonPhrase);
            }
            AppMethodBeat.m2505o(64239);
            return webResourceResponse;
        }
    }

    @TargetApi(11)
    public android.webkit.WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        AppMethodBeat.m2504i(64238);
        if (VERSION.SDK_INT < 11) {
            AppMethodBeat.m2505o(64238);
            return null;
        }
        WebResourceResponse shouldInterceptRequest = this.f15123a.shouldInterceptRequest(this.f15124b, str);
        if (shouldInterceptRequest == null) {
            AppMethodBeat.m2505o(64238);
            return null;
        }
        android.webkit.WebResourceResponse webResourceResponse = new android.webkit.WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData());
        AppMethodBeat.m2505o(64238);
        return webResourceResponse;
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(64240);
        this.f15124b.mo49871a(webView);
        boolean shouldOverrideKeyEvent = this.f15123a.shouldOverrideKeyEvent(this.f15124b, keyEvent);
        AppMethodBeat.m2505o(64240);
        return shouldOverrideKeyEvent;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        AppMethodBeat.m2504i(64237);
        if (str == null || this.f15124b.showDebugView(str)) {
            AppMethodBeat.m2505o(64237);
            return true;
        }
        this.f15124b.mo49871a(webView);
        boolean shouldOverrideUrlLoading = this.f15123a.shouldOverrideUrlLoading(this.f15124b, str);
        AppMethodBeat.m2505o(64237);
        return shouldOverrideUrlLoading;
    }
}
