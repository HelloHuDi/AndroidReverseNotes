package com.tencent.p177mm.plugin.appbrand.p297h;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p224d.p225a.C32488l;
import com.tencent.p177mm.p224d.p225a.C45301c;
import com.tencent.p177mm.plugin.appbrand.p297h.C33208e.C33209a;
import com.tencent.p177mm.plugin.appbrand.p297h.C6748m.C6749a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.net.URL;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.mm.plugin.appbrand.h.a */
public abstract class C16613a extends C31294d implements C6747i, C26901k, C6748m, C38237q, C26902r, C10257s {
    private final C45301c cid;
    public final C32488l ieS = mo30572a(this.cid, C33208e.aGX());
    private final C33208e ieT = new C33208e(new C21681());
    private C6749a ieU;

    /* renamed from: com.tencent.mm.plugin.appbrand.h.a$1 */
    class C21681 implements C33209a {
        C21681() {
        }

        /* renamed from: oT */
        public final C32488l mo6005oT(int i) {
            AppMethodBeat.m2504i(113929);
            C32488l gm = C16613a.this.cid.mo73186gm(i);
            AppMethodBeat.m2505o(113929);
            return gm;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.h.a$2 */
    class C166142 implements Runnable {
        C166142() {
        }

        public final void run() {
            C6749a b;
            AppMethodBeat.m2504i(113930);
            synchronized (C16613a.this) {
                try {
                    b = C16613a.this.ieU;
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(113930);
                    }
                }
            }
            if (b != null) {
                b.onDestroy();
            }
            AppMethodBeat.m2505o(113930);
        }
    }

    /* renamed from: a */
    public abstract C32488l mo30572a(C45301c c45301c, int i);

    /* renamed from: r */
    public abstract C45301c mo30587r(String str, byte[] bArr);

    /* renamed from: Ce */
    public final /* bridge */ /* synthetic */ void mo30571Ce(String str) {
        super.mo30571Ce(str);
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo14968a(URL url, String str, String str2, String str3, ValueCallback valueCallback) {
        super.mo14968a(url, str, str2, str3, valueCallback);
    }

    public final /* bridge */ /* synthetic */ long aGW() {
        return super.aGW();
    }

    public /* bridge */ /* synthetic */ void addJavascriptInterface(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
    }

    /* renamed from: af */
    public final /* bridge */ /* synthetic */ C2169j mo14970af(Class cls) {
        return super.mo14970af(cls);
    }

    public /* bridge */ /* synthetic */ void evaluateJavascript(String str, ValueCallback valueCallback) {
        super.evaluateJavascript(str, valueCallback);
    }

    /* renamed from: f */
    public final /* bridge */ /* synthetic */ void mo30581f(Runnable runnable) {
        super.mo30581f(runnable);
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

    /* renamed from: oQ */
    public final /* bridge */ /* synthetic */ void mo30584oQ(int i) {
        super.mo30584oQ(i);
    }

    /* renamed from: oR */
    public final /* bridge */ /* synthetic */ ByteBuffer mo30585oR(int i) {
        return super.mo30585oR(i);
    }

    /* renamed from: oS */
    public final /* bridge */ /* synthetic */ int mo30586oS(int i) {
        return super.mo30586oS(i);
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

    /* renamed from: yE */
    public final /* bridge */ /* synthetic */ boolean mo30589yE() {
        return super.mo30589yE();
    }

    public C16613a(String str, byte[] bArr) {
        this.cid = mo30587r(str, bArr);
        C33208e c33208e = this.ieT;
        C4990ab.m7417i("MicroMsg.AppBrandJ2V8ContextMgr", "setMainContext id:%d", Integer.valueOf(1));
        c33208e.ifa.put(1, this);
    }

    /* Access modifiers changed, original: protected|final */
    public final C45301c aGQ() {
        return this.cid;
    }

    /* Access modifiers changed, original: protected|final */
    public final C32488l aGR() {
        return this.ieS;
    }

    public final boolean aGS() {
        return true;
    }

    public final int aGT() {
        return C33208e.aGX();
    }

    /* renamed from: oO */
    public final C38235g mo30582oO(int i) {
        return this.ieT.mo53758oO(i);
    }

    public final C38235g aGU() {
        return this.ieT.mo53758oO(1);
    }

    public final C38235g aGV() {
        return this.ieT.aGV();
    }

    /* renamed from: oP */
    public final void mo30583oP(int i) {
        C31294d c31294d;
        C33208e c33208e = this.ieT;
        C4990ab.m7417i("MicroMsg.AppBrandJ2V8ContextMgr", "destroyJsContext id:%d", Integer.valueOf(i));
        synchronized (c33208e.ifa) {
            c31294d = (C31294d) c33208e.ifa.get(i);
            c33208e.ifa.delete(i);
        }
        if (c31294d != null) {
            c31294d.destroy();
        }
    }

    /* renamed from: a */
    public final synchronized void mo14974a(C6749a c6749a) {
        this.ieU = c6749a;
    }

    public void destroy() {
        this.ieS.chO.mo73188l(new C166142());
        C33208e c33208e = this.ieT;
        synchronized (c33208e.ifa) {
            for (int i = 0; i < c33208e.ifa.size(); i++) {
                int keyAt = c33208e.ifa.keyAt(i);
                if (keyAt != 1) {
                    C4990ab.m7417i("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d", Integer.valueOf(keyAt));
                    if (c33208e.ifa.get(keyAt) == null) {
                        C4990ab.m7421w("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d null", Integer.valueOf(keyAt));
                    } else {
                        ((C31294d) c33208e.ifa.get(keyAt)).destroy();
                    }
                }
            }
            c33208e.ifa.clear();
        }
        super.destroy();
        this.cid.quit();
    }

    public void setJsExceptionHandler(C33211h c33211h) {
        this.ieS.mo53120a(C33208e.aGX(), c33211h);
    }
}
