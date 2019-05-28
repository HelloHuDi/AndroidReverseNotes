package com.tencent.p177mm.plugin.appbrand.p297h;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.xweb.C36586f;
import com.tencent.xweb.C41128i;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.tencent.mm.plugin.appbrand.h.u */
public final class C10258u implements C6747i, C26901k, C26902r {
    private C41128i ife;
    private volatile boolean iff;
    private volatile boolean ifg;
    private volatile CountDownLatch ifh;
    private Handler mHandler;

    /* renamed from: com.tencent.mm.plugin.appbrand.h.u$4 */
    class C102604 implements ValueCallback<String> {
        C102604() {
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            AppMethodBeat.m2504i(117457);
            C4990ab.m7411d("MicroMsg.AppBrandMessBasedJsEngine", "invoke callFromJsThread ret %s", (String) obj);
            AppMethodBeat.m2505o(117457);
        }
    }

    public final void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.m2504i(117458);
        this.ife.AMb.addJavascriptInterface(obj, str);
        AppMethodBeat.m2505o(117458);
    }

    public final void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(117459);
        if (this.iff) {
            AppMethodBeat.m2505o(117459);
            return;
        }
        C102621 c102621 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(117454);
                C41128i a = C10258u.this.ife;
                String str = str;
                ValueCallback valueCallback = valueCallback;
                if (!a.iff) {
                    a.AMb.evaluateJavascript(str, valueCallback);
                }
                AppMethodBeat.m2505o(117454);
            }
        };
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            c102621.run();
            AppMethodBeat.m2505o(117459);
            return;
        }
        this.mHandler.post(c102621);
        AppMethodBeat.m2505o(117459);
    }

    /* renamed from: a */
    public final void mo14967a(final URL url, final String str, final ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(117460);
        if (this.iff) {
            AppMethodBeat.m2505o(117460);
            return;
        }
        C102612 c102612 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(117455);
                C41128i a = C10258u.this.ife;
                URL url = url;
                String str = str;
                ValueCallback valueCallback = valueCallback;
                if (!a.iff) {
                    a.AMb.evaluateJavascript(str, valueCallback, url);
                }
                AppMethodBeat.m2505o(117455);
            }
        };
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            c102612.run();
            AppMethodBeat.m2505o(117460);
            return;
        }
        this.mHandler.post(c102612);
        AppMethodBeat.m2505o(117460);
    }

    /* renamed from: a */
    public final void mo14968a(URL url, String str, String str2, String str3, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(117461);
        mo14967a(url, str3, valueCallback);
        AppMethodBeat.m2505o(117461);
    }

    public final void setJsExceptionHandler(final C33211h c33211h) {
        AppMethodBeat.m2504i(117462);
        C41128i c41128i = this.ife;
        c41128i.AMb.mo41188a(new C36586f() {
            /* renamed from: C */
            public final void mo21696C(String str, String str2) {
                AppMethodBeat.m2504i(117456);
                c33211h.mo5989C(str, str2);
                AppMethodBeat.m2505o(117456);
            }
        });
        AppMethodBeat.m2505o(117462);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(117463);
        if (!this.iff) {
            C41128i c41128i = this.ife;
            if (!c41128i.iff) {
                c41128i.AMb.cleanup();
            }
            c41128i.iff = true;
        }
        this.iff = true;
        AppMethodBeat.m2505o(117463);
    }

    /* renamed from: af */
    public final <T extends C2169j> T mo14970af(Class<T> cls) {
        AppMethodBeat.m2504i(117464);
        if (!cls.isInstance(this)) {
            AppMethodBeat.m2505o(117464);
            return null;
        } else if (cls != C26901k.class || this.ife.AMb.dUA()) {
            AppMethodBeat.m2505o(117464);
            return this;
        } else {
            AppMethodBeat.m2505o(117464);
            return null;
        }
    }

    public final void pause() {
        AppMethodBeat.m2504i(117465);
        if (this.ife.dTW()) {
            this.ife.AMb.pause();
            AppMethodBeat.m2505o(117465);
            return;
        }
        this.ifg = true;
        evaluateJavascript("var ret = WeixinJsThreadCaller.callFromJsThread();", new C102604());
        AppMethodBeat.m2505o(117465);
    }

    public final void resume() {
        AppMethodBeat.m2504i(117466);
        if (this.ife.dTW()) {
            this.ife.AMb.resume();
            AppMethodBeat.m2505o(117466);
            return;
        }
        this.ifg = false;
        if (this.ifh != null) {
            this.ifh.countDown();
            this.ifh = null;
        }
        AppMethodBeat.m2505o(117466);
    }

    public final int getNativeBufferId() {
        AppMethodBeat.m2504i(117467);
        int nativeBufferId = this.ife.AMb.getNativeBufferId();
        AppMethodBeat.m2505o(117467);
        return nativeBufferId;
    }

    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(117468);
        this.ife.AMb.setNativeBuffer(i, byteBuffer);
        AppMethodBeat.m2505o(117468);
    }

    public final ByteBuffer getNativeBuffer(int i) {
        AppMethodBeat.m2504i(117469);
        ByteBuffer nativeBuffer = this.ife.AMb.getNativeBuffer(i);
        AppMethodBeat.m2505o(117469);
        return nativeBuffer;
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final int callFromJsThread() {
        AppMethodBeat.m2504i(117470);
        C4990ab.m7411d("MicroMsg.AppBrandMessBasedJsEngine", "enter callFromJsThread, pendingPause %b", Boolean.valueOf(this.ifg));
        if (this.ifg) {
            C4990ab.m7417i("MicroMsg.AppBrandMessBasedJsEngine", "pause await threadId %d", Long.valueOf(Thread.currentThread().getId()));
            this.ifg = false;
            this.ifh = new CountDownLatch(1);
            try {
                this.ifh.await();
            } catch (InterruptedException e) {
                C4990ab.m7413e("MicroMsg.AppBrandMessBasedJsEngine", "pause await e = %s", e);
            }
        }
        AppMethodBeat.m2505o(117470);
        return 1;
    }
}
