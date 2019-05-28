package com.tencent.mm.plugin.appbrand.h;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.f;
import com.tencent.xweb.i;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;

public final class u implements i, k, r {
    private i ife;
    private volatile boolean iff;
    private volatile boolean ifg;
    private volatile CountDownLatch ifh;
    private Handler mHandler;

    public final void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.i(117458);
        this.ife.AMb.addJavascriptInterface(obj, str);
        AppMethodBeat.o(117458);
    }

    public final void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        AppMethodBeat.i(117459);
        if (this.iff) {
            AppMethodBeat.o(117459);
            return;
        }
        AnonymousClass1 anonymousClass1 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(117454);
                i a = u.this.ife;
                String str = str;
                ValueCallback valueCallback = valueCallback;
                if (!a.iff) {
                    a.AMb.evaluateJavascript(str, valueCallback);
                }
                AppMethodBeat.o(117454);
            }
        };
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            anonymousClass1.run();
            AppMethodBeat.o(117459);
            return;
        }
        this.mHandler.post(anonymousClass1);
        AppMethodBeat.o(117459);
    }

    public final void a(final URL url, final String str, final ValueCallback<String> valueCallback) {
        AppMethodBeat.i(117460);
        if (this.iff) {
            AppMethodBeat.o(117460);
            return;
        }
        AnonymousClass2 anonymousClass2 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(117455);
                i a = u.this.ife;
                URL url = url;
                String str = str;
                ValueCallback valueCallback = valueCallback;
                if (!a.iff) {
                    a.AMb.evaluateJavascript(str, valueCallback, url);
                }
                AppMethodBeat.o(117455);
            }
        };
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            anonymousClass2.run();
            AppMethodBeat.o(117460);
            return;
        }
        this.mHandler.post(anonymousClass2);
        AppMethodBeat.o(117460);
    }

    public final void a(URL url, String str, String str2, String str3, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(117461);
        a(url, str3, valueCallback);
        AppMethodBeat.o(117461);
    }

    public final void setJsExceptionHandler(final h hVar) {
        AppMethodBeat.i(117462);
        i iVar = this.ife;
        iVar.AMb.a(new f() {
            public final void C(String str, String str2) {
                AppMethodBeat.i(117456);
                hVar.C(str, str2);
                AppMethodBeat.o(117456);
            }
        });
        AppMethodBeat.o(117462);
    }

    public final void destroy() {
        AppMethodBeat.i(117463);
        if (!this.iff) {
            i iVar = this.ife;
            if (!iVar.iff) {
                iVar.AMb.cleanup();
            }
            iVar.iff = true;
        }
        this.iff = true;
        AppMethodBeat.o(117463);
    }

    public final <T extends j> T af(Class<T> cls) {
        AppMethodBeat.i(117464);
        if (!cls.isInstance(this)) {
            AppMethodBeat.o(117464);
            return null;
        } else if (cls != k.class || this.ife.AMb.dUA()) {
            AppMethodBeat.o(117464);
            return this;
        } else {
            AppMethodBeat.o(117464);
            return null;
        }
    }

    public final void pause() {
        AppMethodBeat.i(117465);
        if (this.ife.dTW()) {
            this.ife.AMb.pause();
            AppMethodBeat.o(117465);
            return;
        }
        this.ifg = true;
        evaluateJavascript("var ret = WeixinJsThreadCaller.callFromJsThread();", new ValueCallback<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                AppMethodBeat.i(117457);
                ab.d("MicroMsg.AppBrandMessBasedJsEngine", "invoke callFromJsThread ret %s", (String) obj);
                AppMethodBeat.o(117457);
            }
        });
        AppMethodBeat.o(117465);
    }

    public final void resume() {
        AppMethodBeat.i(117466);
        if (this.ife.dTW()) {
            this.ife.AMb.resume();
            AppMethodBeat.o(117466);
            return;
        }
        this.ifg = false;
        if (this.ifh != null) {
            this.ifh.countDown();
            this.ifh = null;
        }
        AppMethodBeat.o(117466);
    }

    public final int getNativeBufferId() {
        AppMethodBeat.i(117467);
        int nativeBufferId = this.ife.AMb.getNativeBufferId();
        AppMethodBeat.o(117467);
        return nativeBufferId;
    }

    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        AppMethodBeat.i(117468);
        this.ife.AMb.setNativeBuffer(i, byteBuffer);
        AppMethodBeat.o(117468);
    }

    public final ByteBuffer getNativeBuffer(int i) {
        AppMethodBeat.i(117469);
        ByteBuffer nativeBuffer = this.ife.AMb.getNativeBuffer(i);
        AppMethodBeat.o(117469);
        return nativeBuffer;
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final int callFromJsThread() {
        AppMethodBeat.i(117470);
        ab.d("MicroMsg.AppBrandMessBasedJsEngine", "enter callFromJsThread, pendingPause %b", Boolean.valueOf(this.ifg));
        if (this.ifg) {
            ab.i("MicroMsg.AppBrandMessBasedJsEngine", "pause await threadId %d", Long.valueOf(Thread.currentThread().getId()));
            this.ifg = false;
            this.ifh = new CountDownLatch(1);
            try {
                this.ifh.await();
            } catch (InterruptedException e) {
                ab.e("MicroMsg.AppBrandMessBasedJsEngine", "pause await e = %s", e);
            }
        }
        AppMethodBeat.o(117470);
        return 1;
    }
}
