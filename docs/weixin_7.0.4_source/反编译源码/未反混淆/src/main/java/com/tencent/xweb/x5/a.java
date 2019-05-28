package com.tencent.xweb.x5;

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
import com.tencent.xweb.h;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.r;
import java.util.Map;
import org.xwalk.core.Log;

public final class a {

    public static class f implements WebViewCallbackClient {
        r AQq;

        public f(r rVar) {
            this.AQq = rVar;
        }

        public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.i(84788);
            if (this.AQq != null) {
                boolean A = this.AQq.A(motionEvent);
                AppMethodBeat.o(84788);
                return A;
            }
            AppMethodBeat.o(84788);
            return false;
        }

        public final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
            AppMethodBeat.i(84789);
            if (this.AQq != null) {
                boolean b = this.AQq.b(i, i2, i3, i4, i5, i6, i7, i8, z);
                AppMethodBeat.o(84789);
                return b;
            }
            AppMethodBeat.o(84789);
            return false;
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.i(84790);
            if (this.AQq != null) {
                boolean B = this.AQq.B(motionEvent);
                AppMethodBeat.o(84790);
                return B;
            }
            AppMethodBeat.o(84790);
            return false;
        }

        public final void computeScroll(View view) {
            AppMethodBeat.i(84791);
            if (this.AQq != null) {
                this.AQq.aGs();
            }
            AppMethodBeat.o(84791);
        }

        public final void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
            AppMethodBeat.i(84792);
            if (this.AQq != null) {
                this.AQq.d(i, i2, z, z2);
            }
            AppMethodBeat.o(84792);
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.i(84793);
            if (this.AQq != null) {
                boolean C = this.AQq.C(motionEvent);
                AppMethodBeat.o(84793);
                return C;
            }
            AppMethodBeat.o(84793);
            return false;
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            AppMethodBeat.i(84794);
            if (this.AQq != null) {
                this.AQq.onScrollChanged(i, i2, i3, i4, view);
            }
            AppMethodBeat.o(84794);
        }

        public final void invalidate() {
        }
    }

    public static class e implements WebResourceRequest {
        public n AQp;

        public static WebResourceRequest a(n nVar) {
            AppMethodBeat.i(84782);
            if (nVar == null) {
                AppMethodBeat.o(84782);
                return null;
            }
            WebResourceRequest eVar = new e(nVar);
            AppMethodBeat.o(84782);
            return eVar;
        }

        private e(n nVar) {
            this.AQp = nVar;
        }

        public final Uri getUrl() {
            AppMethodBeat.i(84783);
            Uri url = this.AQp.getUrl();
            AppMethodBeat.o(84783);
            return url;
        }

        public final boolean isForMainFrame() {
            AppMethodBeat.i(84784);
            boolean isForMainFrame = this.AQp.isForMainFrame();
            AppMethodBeat.o(84784);
            return isForMainFrame;
        }

        public final boolean isRedirect() {
            return false;
        }

        public final boolean hasGesture() {
            AppMethodBeat.i(84785);
            boolean hasGesture = this.AQp.hasGesture();
            AppMethodBeat.o(84785);
            return hasGesture;
        }

        public final String getMethod() {
            AppMethodBeat.i(84786);
            String method = this.AQp.getMethod();
            AppMethodBeat.o(84786);
            return method;
        }

        public final Map<String, String> getRequestHeaders() {
            AppMethodBeat.i(84787);
            Map requestHeaders = this.AQp.getRequestHeaders();
            AppMethodBeat.o(84787);
            return requestHeaders;
        }
    }

    public static class b implements FindListener {
        WebView.FindListener AQm;

        public b(WebView.FindListener findListener) {
            this.AQm = findListener;
        }

        public final void onFindResultReceived(int i, int i2, boolean z) {
            AppMethodBeat.i(84778);
            if (this.AQm != null) {
                this.AQm.onFindResultReceived(i, i2, z);
            }
            AppMethodBeat.o(84778);
        }
    }

    public static class d<T> implements ValueCallback<T> {
        android.webkit.ValueCallback<T> AQo;

        public d(android.webkit.ValueCallback<T> valueCallback) {
            this.AQo = valueCallback;
        }

        public final void onReceiveValue(T t) {
            AppMethodBeat.i(84781);
            if (this.AQo != null) {
                this.AQo.onReceiveValue(t);
            }
            AppMethodBeat.o(84781);
        }
    }

    public static class a implements DownloadListener {
        android.webkit.DownloadListener AQl;

        public a(android.webkit.DownloadListener downloadListener) {
            this.AQl = downloadListener;
        }

        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            AppMethodBeat.i(84777);
            if (this.AQl != null) {
                this.AQl.onDownloadStart(str, str2, str3, str4, j);
            }
            AppMethodBeat.o(84777);
        }
    }

    public static class c implements JsResult {
        public h AQn;

        public c(h hVar) {
            this.AQn = hVar;
        }

        public final void confirm() {
            AppMethodBeat.i(84779);
            this.AQn.confirm();
            AppMethodBeat.o(84779);
        }

        public final void cancel() {
            AppMethodBeat.i(84780);
            this.AQn.cancel();
            AppMethodBeat.o(84780);
        }
    }

    public static WebResourceResponse b(o oVar) {
        AppMethodBeat.i(84795);
        if (oVar == null) {
            AppMethodBeat.o(84795);
            return null;
        }
        WebResourceResponse webResourceResponse;
        if (oVar.AMD && VERSION.SDK_INT >= 21) {
            try {
                webResourceResponse = new WebResourceResponse(oVar.mMimeType, oVar.mEncoding, oVar.mStatusCode, oVar.mReasonPhrase, oVar.mResponseHeaders, oVar.mInputStream);
                AppMethodBeat.o(84795);
                return webResourceResponse;
            } catch (Exception e) {
                Log.e("SysWebDataTrans", "create webkit WebResourceResponse error :" + e.getMessage());
            }
        }
        webResourceResponse = new WebResourceResponse(oVar.mMimeType, oVar.mEncoding, oVar.mInputStream);
        if (!(oVar.mStatusCode <= 100 || oVar.mReasonPhrase == null || oVar.mReasonPhrase.isEmpty())) {
            webResourceResponse.setStatusCodeAndReasonPhrase(oVar.mStatusCode, oVar.mReasonPhrase);
        }
        webResourceResponse.setResponseHeaders(oVar.mResponseHeaders);
        AppMethodBeat.o(84795);
        return webResourceResponse;
    }
}
