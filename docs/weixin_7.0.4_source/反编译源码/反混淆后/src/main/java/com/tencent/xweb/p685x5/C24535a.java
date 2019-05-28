package com.tencent.xweb.p685x5;

import android.net.Uri;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebViewCallbackClient;
import com.tencent.xweb.C24530n;
import com.tencent.xweb.C31147o;
import com.tencent.xweb.C36591r;
import com.tencent.xweb.C46945h;
import java.util.Map;
import org.xwalk.core.Log;

/* renamed from: com.tencent.xweb.x5.a */
public final class C24535a {

    /* renamed from: com.tencent.xweb.x5.a$f */
    public static class C24534f implements WebViewCallbackClient {
        C36591r AQq;

        public C24534f(C36591r c36591r) {
            this.AQq = c36591r;
        }

        public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.m2504i(84788);
            if (this.AQq != null) {
                boolean A = this.AQq.mo31055A(motionEvent);
                AppMethodBeat.m2505o(84788);
                return A;
            }
            AppMethodBeat.m2505o(84788);
            return false;
        }

        public final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
            AppMethodBeat.m2504i(84789);
            if (this.AQq != null) {
                boolean b = this.AQq.mo31059b(i, i2, i3, i4, i5, i6, i7, i8, z);
                AppMethodBeat.m2505o(84789);
                return b;
            }
            AppMethodBeat.m2505o(84789);
            return false;
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.m2504i(84790);
            if (this.AQq != null) {
                boolean B = this.AQq.mo31056B(motionEvent);
                AppMethodBeat.m2505o(84790);
                return B;
            }
            AppMethodBeat.m2505o(84790);
            return false;
        }

        public final void computeScroll(View view) {
            AppMethodBeat.m2504i(84791);
            if (this.AQq != null) {
                this.AQq.aGs();
            }
            AppMethodBeat.m2505o(84791);
        }

        public final void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
            AppMethodBeat.m2504i(84792);
            if (this.AQq != null) {
                this.AQq.mo31060d(i, i2, z, z2);
            }
            AppMethodBeat.m2505o(84792);
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.m2504i(84793);
            if (this.AQq != null) {
                boolean C = this.AQq.mo31057C(motionEvent);
                AppMethodBeat.m2505o(84793);
                return C;
            }
            AppMethodBeat.m2505o(84793);
            return false;
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            AppMethodBeat.m2504i(84794);
            if (this.AQq != null) {
                this.AQq.onScrollChanged(i, i2, i3, i4, view);
            }
            AppMethodBeat.m2505o(84794);
        }

        public final void invalidate() {
        }
    }

    /* renamed from: com.tencent.xweb.x5.a$e */
    public static class C24536e implements WebResourceRequest {
        public C24530n AQp;

        /* renamed from: a */
        public static WebResourceRequest m38192a(C24530n c24530n) {
            AppMethodBeat.m2504i(84782);
            if (c24530n == null) {
                AppMethodBeat.m2505o(84782);
                return null;
            }
            WebResourceRequest c24536e = new C24536e(c24530n);
            AppMethodBeat.m2505o(84782);
            return c24536e;
        }

        private C24536e(C24530n c24530n) {
            this.AQp = c24530n;
        }

        public final Uri getUrl() {
            AppMethodBeat.m2504i(84783);
            Uri url = this.AQp.getUrl();
            AppMethodBeat.m2505o(84783);
            return url;
        }

        public final boolean isForMainFrame() {
            AppMethodBeat.m2504i(84784);
            boolean isForMainFrame = this.AQp.isForMainFrame();
            AppMethodBeat.m2505o(84784);
            return isForMainFrame;
        }

        public final boolean isRedirect() {
            return false;
        }

        public final boolean hasGesture() {
            AppMethodBeat.m2504i(84785);
            boolean hasGesture = this.AQp.hasGesture();
            AppMethodBeat.m2505o(84785);
            return hasGesture;
        }

        public final String getMethod() {
            AppMethodBeat.m2504i(84786);
            String method = this.AQp.getMethod();
            AppMethodBeat.m2505o(84786);
            return method;
        }

        public final Map<String, String> getRequestHeaders() {
            AppMethodBeat.m2504i(84787);
            Map requestHeaders = this.AQp.getRequestHeaders();
            AppMethodBeat.m2505o(84787);
            return requestHeaders;
        }
    }

    /* renamed from: com.tencent.xweb.x5.a$b */
    public static class C24537b implements FindListener {
        WebView.FindListener AQm;

        public C24537b(WebView.FindListener findListener) {
            this.AQm = findListener;
        }

        public final void onFindResultReceived(int i, int i2, boolean z) {
            AppMethodBeat.m2504i(84778);
            if (this.AQm != null) {
                this.AQm.onFindResultReceived(i, i2, z);
            }
            AppMethodBeat.m2505o(84778);
        }
    }

    /* renamed from: com.tencent.xweb.x5.a$d */
    public static class C24538d<T> implements ValueCallback<T> {
        android.webkit.ValueCallback<T> AQo;

        public C24538d(android.webkit.ValueCallback<T> valueCallback) {
            this.AQo = valueCallback;
        }

        public final void onReceiveValue(T t) {
            AppMethodBeat.m2504i(84781);
            if (this.AQo != null) {
                this.AQo.onReceiveValue(t);
            }
            AppMethodBeat.m2505o(84781);
        }
    }

    /* renamed from: com.tencent.xweb.x5.a$a */
    public static class C24539a implements DownloadListener {
        android.webkit.DownloadListener AQl;

        public C24539a(android.webkit.DownloadListener downloadListener) {
            this.AQl = downloadListener;
        }

        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            AppMethodBeat.m2504i(84777);
            if (this.AQl != null) {
                this.AQl.onDownloadStart(str, str2, str3, str4, j);
            }
            AppMethodBeat.m2505o(84777);
        }
    }

    /* renamed from: com.tencent.xweb.x5.a$c */
    public static class C24540c implements JsResult {
        public C46945h AQn;

        public C24540c(C46945h c46945h) {
            this.AQn = c46945h;
        }

        public final void confirm() {
            AppMethodBeat.m2504i(84779);
            this.AQn.confirm();
            AppMethodBeat.m2505o(84779);
        }

        public final void cancel() {
            AppMethodBeat.m2504i(84780);
            this.AQn.cancel();
            AppMethodBeat.m2505o(84780);
        }
    }

    /* renamed from: b */
    public static WebResourceResponse m38191b(C31147o c31147o) {
        AppMethodBeat.m2504i(84795);
        if (c31147o == null) {
            AppMethodBeat.m2505o(84795);
            return null;
        }
        WebResourceResponse webResourceResponse;
        if (c31147o.AMD && VERSION.SDK_INT >= 21) {
            try {
                webResourceResponse = new WebResourceResponse(c31147o.mMimeType, c31147o.mEncoding, c31147o.mStatusCode, c31147o.mReasonPhrase, c31147o.mResponseHeaders, c31147o.mInputStream);
                AppMethodBeat.m2505o(84795);
                return webResourceResponse;
            } catch (Exception e) {
                Log.m81046e("SysWebDataTrans", "create webkit WebResourceResponse error :" + e.getMessage());
            }
        }
        webResourceResponse = new WebResourceResponse(c31147o.mMimeType, c31147o.mEncoding, c31147o.mInputStream);
        if (!(c31147o.mStatusCode <= 100 || c31147o.mReasonPhrase == null || c31147o.mReasonPhrase.isEmpty())) {
            webResourceResponse.setStatusCodeAndReasonPhrase(c31147o.mStatusCode, c31147o.mReasonPhrase);
        }
        webResourceResponse.setResponseHeaders(c31147o.mResponseHeaders);
        AppMethodBeat.m2505o(84795);
        return webResourceResponse;
    }
}
