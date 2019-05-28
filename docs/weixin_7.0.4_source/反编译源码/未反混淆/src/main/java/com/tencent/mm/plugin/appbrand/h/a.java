package com.tencent.mm.plugin.appbrand.h;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.c;
import com.tencent.mm.d.a.l;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.URL;
import java.nio.ByteBuffer;

public abstract class a extends d implements i, k, m, q, r, s {
    private final c cid;
    public final l ieS = a(this.cid, e.aGX());
    private final e ieT = new e(new com.tencent.mm.plugin.appbrand.h.e.a() {
        public final l oT(int i) {
            AppMethodBeat.i(113929);
            l gm = a.this.cid.gm(i);
            AppMethodBeat.o(113929);
            return gm;
        }
    });
    private com.tencent.mm.plugin.appbrand.h.m.a ieU;

    public abstract l a(c cVar, int i);

    public abstract c r(String str, byte[] bArr);

    public final /* bridge */ /* synthetic */ void Ce(String str) {
        super.Ce(str);
    }

    public final /* bridge */ /* synthetic */ void a(URL url, String str, String str2, String str3, ValueCallback valueCallback) {
        super.a(url, str, str2, str3, valueCallback);
    }

    public final /* bridge */ /* synthetic */ long aGW() {
        return super.aGW();
    }

    public /* bridge */ /* synthetic */ void addJavascriptInterface(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
    }

    public final /* bridge */ /* synthetic */ j af(Class cls) {
        return super.af(cls);
    }

    public /* bridge */ /* synthetic */ void evaluateJavascript(String str, ValueCallback valueCallback) {
        super.evaluateJavascript(str, valueCallback);
    }

    public final /* bridge */ /* synthetic */ void f(Runnable runnable) {
        super.f(runnable);
    }

    public final /* bridge */ /* synthetic */ long getIsolatePtr() {
        return super.getIsolatePtr();
    }

    public final /* bridge */ /* synthetic */ ByteBuffer getNativeBuffer(int i) {
        return super.getNativeBuffer(i);
    }

    public final /* bridge */ /* synthetic */ int getNativeBufferId() {
        return super.getNativeBufferId();
    }

    public final /* bridge */ /* synthetic */ void oQ(int i) {
        super.oQ(i);
    }

    public final /* bridge */ /* synthetic */ ByteBuffer oR(int i) {
        return super.oR(i);
    }

    public final /* bridge */ /* synthetic */ int oS(int i) {
        return super.oS(i);
    }

    public final /* bridge */ /* synthetic */ void pause() {
        super.pause();
    }

    public final /* bridge */ /* synthetic */ void resume() {
        super.resume();
    }

    public final /* bridge */ /* synthetic */ void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        super.setNativeBuffer(i, byteBuffer);
    }

    public final /* bridge */ /* synthetic */ void setThreadPriority(int i) {
        super.setThreadPriority(i);
    }

    public final /* bridge */ /* synthetic */ boolean yE() {
        return super.yE();
    }

    public a(String str, byte[] bArr) {
        this.cid = r(str, bArr);
        e eVar = this.ieT;
        ab.i("MicroMsg.AppBrandJ2V8ContextMgr", "setMainContext id:%d", Integer.valueOf(1));
        eVar.ifa.put(1, this);
    }

    /* Access modifiers changed, original: protected|final */
    public final c aGQ() {
        return this.cid;
    }

    /* Access modifiers changed, original: protected|final */
    public final l aGR() {
        return this.ieS;
    }

    public final boolean aGS() {
        return true;
    }

    public final int aGT() {
        return e.aGX();
    }

    public final g oO(int i) {
        return this.ieT.oO(i);
    }

    public final g aGU() {
        return this.ieT.oO(1);
    }

    public final g aGV() {
        return this.ieT.aGV();
    }

    public final void oP(int i) {
        d dVar;
        e eVar = this.ieT;
        ab.i("MicroMsg.AppBrandJ2V8ContextMgr", "destroyJsContext id:%d", Integer.valueOf(i));
        synchronized (eVar.ifa) {
            dVar = (d) eVar.ifa.get(i);
            eVar.ifa.delete(i);
        }
        if (dVar != null) {
            dVar.destroy();
        }
    }

    public final synchronized void a(com.tencent.mm.plugin.appbrand.h.m.a aVar) {
        this.ieU = aVar;
    }

    public void destroy() {
        this.ieS.chO.l(new Runnable() {
            public final void run() {
                com.tencent.mm.plugin.appbrand.h.m.a b;
                AppMethodBeat.i(113930);
                synchronized (a.this) {
                    try {
                        b = a.this.ieU;
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(113930);
                        }
                    }
                }
                if (b != null) {
                    b.onDestroy();
                }
                AppMethodBeat.o(113930);
            }
        });
        e eVar = this.ieT;
        synchronized (eVar.ifa) {
            for (int i = 0; i < eVar.ifa.size(); i++) {
                int keyAt = eVar.ifa.keyAt(i);
                if (keyAt != 1) {
                    ab.i("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d", Integer.valueOf(keyAt));
                    if (eVar.ifa.get(keyAt) == null) {
                        ab.w("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d null", Integer.valueOf(keyAt));
                    } else {
                        ((d) eVar.ifa.get(keyAt)).destroy();
                    }
                }
            }
            eVar.ifa.clear();
        }
        super.destroy();
        this.cid.quit();
    }

    public void setJsExceptionHandler(h hVar) {
        this.ieS.a(e.aGX(), hVar);
    }
}
