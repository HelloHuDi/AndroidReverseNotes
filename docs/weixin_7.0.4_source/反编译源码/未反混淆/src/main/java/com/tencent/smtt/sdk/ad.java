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
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.r;
import com.tencent.smtt.utils.w;
import java.io.InputStream;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map;

@SuppressLint({"NewApi", "Override"})
class ad extends WebViewClient {
    private static String c = null;
    private WebViewClient a;
    private WebView b;

    static class f implements WebResourceRequest {
        android.webkit.WebResourceRequest a;

        f(android.webkit.WebResourceRequest webResourceRequest) {
            this.a = webResourceRequest;
        }

        public String getMethod() {
            AppMethodBeat.i(64219);
            String method = this.a.getMethod();
            AppMethodBeat.o(64219);
            return method;
        }

        public Map<String, String> getRequestHeaders() {
            AppMethodBeat.i(64220);
            Map requestHeaders = this.a.getRequestHeaders();
            AppMethodBeat.o(64220);
            return requestHeaders;
        }

        public Uri getUrl() {
            AppMethodBeat.i(64221);
            Uri url = this.a.getUrl();
            AppMethodBeat.o(64221);
            return url;
        }

        public boolean hasGesture() {
            AppMethodBeat.i(64222);
            boolean hasGesture = this.a.hasGesture();
            AppMethodBeat.o(64222);
            return hasGesture;
        }

        public boolean isForMainFrame() {
            AppMethodBeat.i(64223);
            boolean isForMainFrame = this.a.isForMainFrame();
            AppMethodBeat.o(64223);
            return isForMainFrame;
        }

        public boolean isRedirect() {
            boolean booleanValue;
            AppMethodBeat.i(64224);
            if (VERSION.SDK_INT >= 24) {
                Object a = r.a(this.a, "isRedirect");
                if (a instanceof Boolean) {
                    booleanValue = ((Boolean) a).booleanValue();
                    AppMethodBeat.o(64224);
                    return booleanValue;
                }
            }
            booleanValue = false;
            AppMethodBeat.o(64224);
            return booleanValue;
        }
    }

    static class a extends ClientCertRequest {
        private android.webkit.ClientCertRequest a;

        public a(android.webkit.ClientCertRequest clientCertRequest) {
            this.a = clientCertRequest;
        }

        public void cancel() {
            AppMethodBeat.i(64202);
            this.a.cancel();
            AppMethodBeat.o(64202);
        }

        public String getHost() {
            AppMethodBeat.i(64203);
            String host = this.a.getHost();
            AppMethodBeat.o(64203);
            return host;
        }

        public String[] getKeyTypes() {
            AppMethodBeat.i(64204);
            String[] keyTypes = this.a.getKeyTypes();
            AppMethodBeat.o(64204);
            return keyTypes;
        }

        public int getPort() {
            AppMethodBeat.i(64205);
            int port = this.a.getPort();
            AppMethodBeat.o(64205);
            return port;
        }

        public Principal[] getPrincipals() {
            AppMethodBeat.i(64206);
            Principal[] principals = this.a.getPrincipals();
            AppMethodBeat.o(64206);
            return principals;
        }

        public void ignore() {
            AppMethodBeat.i(64207);
            this.a.ignore();
            AppMethodBeat.o(64207);
        }

        public void proceed(PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
            AppMethodBeat.i(64208);
            this.a.proceed(privateKey, x509CertificateArr);
            AppMethodBeat.o(64208);
        }
    }

    static class g extends WebResourceResponse {
        android.webkit.WebResourceResponse a;

        public g(android.webkit.WebResourceResponse webResourceResponse) {
            this.a = webResourceResponse;
        }

        public InputStream getData() {
            AppMethodBeat.i(64225);
            InputStream data = this.a.getData();
            AppMethodBeat.o(64225);
            return data;
        }

        public String getEncoding() {
            AppMethodBeat.i(64226);
            String encoding = this.a.getEncoding();
            AppMethodBeat.o(64226);
            return encoding;
        }

        public String getMimeType() {
            AppMethodBeat.i(64227);
            String mimeType = this.a.getMimeType();
            AppMethodBeat.o(64227);
            return mimeType;
        }

        public String getReasonPhrase() {
            AppMethodBeat.i(64228);
            String reasonPhrase = this.a.getReasonPhrase();
            AppMethodBeat.o(64228);
            return reasonPhrase;
        }

        public Map<String, String> getResponseHeaders() {
            AppMethodBeat.i(64229);
            Map responseHeaders = this.a.getResponseHeaders();
            AppMethodBeat.o(64229);
            return responseHeaders;
        }

        public int getStatusCode() {
            AppMethodBeat.i(64230);
            int statusCode = this.a.getStatusCode();
            AppMethodBeat.o(64230);
            return statusCode;
        }

        public void setData(InputStream inputStream) {
            AppMethodBeat.i(64231);
            this.a.setData(inputStream);
            AppMethodBeat.o(64231);
        }

        public void setEncoding(String str) {
            AppMethodBeat.i(64232);
            this.a.setEncoding(str);
            AppMethodBeat.o(64232);
        }

        public void setMimeType(String str) {
            AppMethodBeat.i(64233);
            this.a.setMimeType(str);
            AppMethodBeat.o(64233);
        }

        public void setResponseHeaders(Map<String, String> map) {
            AppMethodBeat.i(64234);
            this.a.setResponseHeaders(map);
            AppMethodBeat.o(64234);
        }

        public void setStatusCodeAndReasonPhrase(int i, String str) {
            AppMethodBeat.i(64235);
            this.a.setStatusCodeAndReasonPhrase(i, str);
            AppMethodBeat.o(64235);
        }
    }

    static class b implements HttpAuthHandler {
        private android.webkit.HttpAuthHandler a;

        b(android.webkit.HttpAuthHandler httpAuthHandler) {
            this.a = httpAuthHandler;
        }

        public void cancel() {
            AppMethodBeat.i(64210);
            this.a.cancel();
            AppMethodBeat.o(64210);
        }

        public void proceed(String str, String str2) {
            AppMethodBeat.i(64209);
            this.a.proceed(str, str2);
            AppMethodBeat.o(64209);
        }

        public boolean useHttpAuthUsernamePassword() {
            AppMethodBeat.i(64211);
            boolean useHttpAuthUsernamePassword = this.a.useHttpAuthUsernamePassword();
            AppMethodBeat.o(64211);
            return useHttpAuthUsernamePassword;
        }
    }

    static class d implements SslError {
        android.net.http.SslError a;

        d(android.net.http.SslError sslError) {
            this.a = sslError;
        }

        public boolean addError(int i) {
            AppMethodBeat.i(64215);
            boolean addError = this.a.addError(i);
            AppMethodBeat.o(64215);
            return addError;
        }

        public SslCertificate getCertificate() {
            AppMethodBeat.i(64214);
            SslCertificate certificate = this.a.getCertificate();
            AppMethodBeat.o(64214);
            return certificate;
        }

        public int getPrimaryError() {
            AppMethodBeat.i(64217);
            int primaryError = this.a.getPrimaryError();
            AppMethodBeat.o(64217);
            return primaryError;
        }

        public boolean hasError(int i) {
            AppMethodBeat.i(64216);
            boolean hasError = this.a.hasError(i);
            AppMethodBeat.o(64216);
            return hasError;
        }
    }

    class e implements WebResourceRequest {
        private String b;
        private boolean c;
        private boolean d;
        private boolean e;
        private String f;
        private Map<String, String> g;

        public e(String str, boolean z, boolean z2, boolean z3, String str2, Map<String, String> map) {
            this.b = str;
            this.c = z;
            this.d = z2;
            this.e = z3;
            this.f = str2;
            this.g = map;
        }

        public String getMethod() {
            return this.f;
        }

        public Map<String, String> getRequestHeaders() {
            return this.g;
        }

        public Uri getUrl() {
            AppMethodBeat.i(64218);
            Uri parse = Uri.parse(this.b);
            AppMethodBeat.o(64218);
            return parse;
        }

        public boolean hasGesture() {
            return this.e;
        }

        public boolean isForMainFrame() {
            return this.c;
        }

        public boolean isRedirect() {
            return this.d;
        }
    }

    static class c implements SslErrorHandler {
        android.webkit.SslErrorHandler a;

        c(android.webkit.SslErrorHandler sslErrorHandler) {
            this.a = sslErrorHandler;
        }

        public void cancel() {
            AppMethodBeat.i(64213);
            this.a.cancel();
            AppMethodBeat.o(64213);
        }

        public void proceed() {
            AppMethodBeat.i(64212);
            this.a.proceed();
            AppMethodBeat.o(64212);
        }
    }

    ad(WebView webView, WebViewClient webViewClient) {
        this.b = webView;
        this.a = webViewClient;
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        AppMethodBeat.i(64248);
        this.b.a(webView);
        this.a.doUpdateVisitedHistory(this.b, str, z);
        AppMethodBeat.o(64248);
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        AppMethodBeat.i(64241);
        this.b.a(webView);
        this.a.onFormResubmission(this.b, message, message2);
        AppMethodBeat.o(64241);
    }

    public void onLoadResource(WebView webView, String str) {
        AppMethodBeat.i(64236);
        this.b.a(webView);
        this.a.onLoadResource(this.b, str);
        AppMethodBeat.o(64236);
    }

    public void onPageFinished(WebView webView, String str) {
        AppMethodBeat.i(64242);
        if (c == null) {
            w a = w.a();
            if (a != null) {
                a.a(true);
                c = Boolean.toString(true);
            }
        }
        this.b.a(webView);
        WebView webView2 = this.b;
        webView2.a++;
        this.a.onPageFinished(this.b, str);
        if (TbsConfig.APP_QZONE.equals(webView.getContext().getApplicationInfo().packageName)) {
            this.b.a(webView.getContext());
        }
        TbsLog.app_extra("SystemWebViewClient", webView.getContext());
        WebView.d();
        if (!(TbsShareManager.mHasQueryed || this.b.getContext() == null || !TbsShareManager.isThirdPartyApp(this.b.getContext()))) {
            TbsShareManager.mHasQueryed = true;
            new Thread(new ae(this)).start();
        }
        if (!(this.b.getContext() == null || TbsLogReport.getInstance(this.b.getContext()).getShouldUploadEventReport())) {
            TbsLogReport.getInstance(this.b.getContext()).setShouldUploadEventReport(true);
            TbsLogReport.getInstance(this.b.getContext()).dailyReport();
        }
        AppMethodBeat.o(64242);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.i(64243);
        this.b.a(webView);
        this.a.onPageStarted(this.b, str, bitmap);
        AppMethodBeat.o(64243);
    }

    public void onReceivedClientCertRequest(WebView webView, android.webkit.ClientCertRequest clientCertRequest) {
        AppMethodBeat.i(64251);
        if (VERSION.SDK_INT >= 21) {
            this.b.a(webView);
            this.a.onReceivedClientCertRequest(this.b, new a(clientCertRequest));
        }
        AppMethodBeat.o(64251);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        AppMethodBeat.i(64244);
        this.b.a(webView);
        this.a.onReceivedError(this.b, i, str, str2);
        AppMethodBeat.o(64244);
    }

    public void onReceivedError(WebView webView, android.webkit.WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        com.tencent.smtt.export.external.interfaces.WebResourceError webResourceError2 = null;
        AppMethodBeat.i(64245);
        this.b.a(webView);
        WebResourceRequest fVar = webResourceRequest != null ? new f(webResourceRequest) : null;
        if (webResourceError != null) {
            webResourceError2 = new af(this, webResourceError);
        }
        this.a.onReceivedError(this.b, fVar, webResourceError2);
        AppMethodBeat.o(64245);
    }

    public void onReceivedHttpAuthRequest(WebView webView, android.webkit.HttpAuthHandler httpAuthHandler, String str, String str2) {
        AppMethodBeat.i(64247);
        this.b.a(webView);
        this.a.onReceivedHttpAuthRequest(this.b, new b(httpAuthHandler), str, str2);
        AppMethodBeat.o(64247);
    }

    public void onReceivedHttpError(WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceResponse webResourceResponse) {
        AppMethodBeat.i(64246);
        this.b.a(webView);
        this.a.onReceivedHttpError(this.b, new f(webResourceRequest), new g(webResourceResponse));
        AppMethodBeat.o(64246);
    }

    @TargetApi(12)
    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        AppMethodBeat.i(64249);
        if (VERSION.SDK_INT >= 12) {
            this.b.a(webView);
            this.a.onReceivedLoginRequest(this.b, str, str2, str3);
        }
        AppMethodBeat.o(64249);
    }

    @TargetApi(8)
    public void onReceivedSslError(WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
        AppMethodBeat.i(64250);
        if (VERSION.SDK_INT >= 8) {
            this.b.a(webView);
            this.a.onReceivedSslError(this.b, new c(sslErrorHandler), new d(sslError));
        }
        AppMethodBeat.o(64250);
    }

    public void onScaleChanged(WebView webView, float f, float f2) {
        AppMethodBeat.i(64252);
        this.b.a(webView);
        this.a.onScaleChanged(this.b, f, f2);
        AppMethodBeat.o(64252);
    }

    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        AppMethodBeat.i(64253);
        this.b.a(webView);
        this.a.onTooManyRedirects(this.b, message, message2);
        AppMethodBeat.o(64253);
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        AppMethodBeat.i(64254);
        this.b.a(webView);
        this.a.onUnhandledKeyEvent(this.b, keyEvent);
        AppMethodBeat.o(64254);
    }

    public android.webkit.WebResourceResponse shouldInterceptRequest(WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
        AppMethodBeat.i(64239);
        if (VERSION.SDK_INT < 21) {
            AppMethodBeat.o(64239);
            return null;
        } else if (webResourceRequest == null) {
            AppMethodBeat.o(64239);
            return null;
        } else {
            boolean z = false;
            if (VERSION.SDK_INT >= 24) {
                Object a = r.a((Object) webResourceRequest, "isRedirect");
                if (a instanceof Boolean) {
                    z = ((Boolean) a).booleanValue();
                }
            }
            WebResourceResponse shouldInterceptRequest = this.a.shouldInterceptRequest(this.b, new e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
            if (shouldInterceptRequest == null) {
                AppMethodBeat.o(64239);
                return null;
            }
            android.webkit.WebResourceResponse webResourceResponse = new android.webkit.WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData());
            webResourceResponse.setResponseHeaders(shouldInterceptRequest.getResponseHeaders());
            int statusCode = shouldInterceptRequest.getStatusCode();
            String reasonPhrase = shouldInterceptRequest.getReasonPhrase();
            if (!(statusCode == webResourceResponse.getStatusCode() && (reasonPhrase == null || reasonPhrase.equals(webResourceResponse.getReasonPhrase())))) {
                webResourceResponse.setStatusCodeAndReasonPhrase(statusCode, reasonPhrase);
            }
            AppMethodBeat.o(64239);
            return webResourceResponse;
        }
    }

    @TargetApi(11)
    public android.webkit.WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        AppMethodBeat.i(64238);
        if (VERSION.SDK_INT < 11) {
            AppMethodBeat.o(64238);
            return null;
        }
        WebResourceResponse shouldInterceptRequest = this.a.shouldInterceptRequest(this.b, str);
        if (shouldInterceptRequest == null) {
            AppMethodBeat.o(64238);
            return null;
        }
        android.webkit.WebResourceResponse webResourceResponse = new android.webkit.WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData());
        AppMethodBeat.o(64238);
        return webResourceResponse;
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        AppMethodBeat.i(64240);
        this.b.a(webView);
        boolean shouldOverrideKeyEvent = this.a.shouldOverrideKeyEvent(this.b, keyEvent);
        AppMethodBeat.o(64240);
        return shouldOverrideKeyEvent;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        AppMethodBeat.i(64237);
        if (str == null || this.b.showDebugView(str)) {
            AppMethodBeat.o(64237);
            return true;
        }
        this.b.a(webView);
        boolean shouldOverrideUrlLoading = this.a.shouldOverrideUrlLoading(this.b, str);
        AppMethodBeat.o(64237);
        return shouldOverrideUrlLoading;
    }
}
