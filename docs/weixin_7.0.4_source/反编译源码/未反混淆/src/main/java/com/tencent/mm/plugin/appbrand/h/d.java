package com.tencent.mm.plugin.appbrand.h;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.c;
import com.tencent.mm.d.a.l;
import com.tencent.mm.d.a.l.AnonymousClass10;
import com.tencent.mm.d.a.l.AnonymousClass4;
import com.tencent.mm.d.a.l.AnonymousClass8;
import com.tencent.mm.d.a.l.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.URL;
import java.nio.ByteBuffer;

abstract class d implements g, k, l, n, p, r, s {
    public abstract c aGQ();

    public abstract l aGR();

    d() {
    }

    public void a(g gVar, String str) {
        if (gVar instanceof d) {
            l aGR = aGR();
            aGR.chO.k(new com.tencent.mm.d.a.l.AnonymousClass2(str, ((d) gVar).aGR()));
            return;
        }
        String str2;
        String str3 = "MicroMsg.AppBrandJ2V8Context";
        String str4 = "shareObject with unsupported implementation %s";
        Object[] objArr = new Object[1];
        if (gVar == null) {
            str2 = null;
        } else {
            str2 = gVar.getClass().getName();
        }
        objArr[0] = str2;
        ab.e(str3, str4, objArr);
    }

    public void addJavascriptInterface(Object obj, String str) {
        l aGR = aGR();
        Class cls = JavascriptInterface.class;
        if (!TextUtils.isEmpty(str)) {
            aGR.chO.k(new AnonymousClass10(obj, str, cls));
        }
    }

    public void evaluateJavascript(String str, final ValueCallback<String> valueCallback) {
        aGR().a(str, valueCallback == null ? null : new b() {
            public final void ds(String str) {
                AppMethodBeat.i(113934);
                valueCallback.onReceiveValue(str);
                AppMethodBeat.o(113934);
            }
        });
    }

    public void a(URL url, String str, final ValueCallback<String> valueCallback) {
        if (url == null) {
            evaluateJavascript(str, valueCallback);
        } else {
            aGR().a(url.toString(), str, valueCallback == null ? null : new b() {
                public final void ds(String str) {
                    AppMethodBeat.i(113935);
                    valueCallback.onReceiveValue(str);
                    AppMethodBeat.o(113935);
                }
            });
        }
    }

    public void a(URL url, String str, String str2, String str3, final ValueCallback<String> valueCallback) {
        String str4;
        b anonymousClass3 = valueCallback == null ? null : new b() {
            public final void ds(String str) {
                AppMethodBeat.i(113936);
                valueCallback.onReceiveValue(str);
                AppMethodBeat.o(113936);
            }
        };
        l aGR = aGR();
        if (url == null) {
            str4 = null;
        } else {
            str4 = url.toString();
        }
        aGR.chO.k(new AnonymousClass8(str4, anonymousClass3, str3, str, str2));
    }

    public void destroy() {
        aGR().destroy();
    }

    public <T extends j> T af(Class<T> cls) {
        return cls.isInstance(this) ? this : null;
    }

    public int getNativeBufferId() {
        return aGR().chr.Cv();
    }

    public void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        aGR().chr.a(i, byteBuffer);
    }

    public ByteBuffer getNativeBuffer(int i) {
        return aGR().chr.gq(i);
    }

    public int oS(int i) {
        return aGR().chP.gn(i);
    }

    public ByteBuffer oR(int i) {
        return aGR().chP.gp(i);
    }

    public void oQ(int i) {
        aGR().chP.destroy(i);
    }

    public void pause() {
        aGQ().pause();
    }

    public void resume() {
        aGQ().resume();
    }

    public void f(Runnable runnable) {
        aGQ().f(runnable, 0);
    }

    public void setThreadPriority(int i) {
        aGQ().setThreadPriority(i);
    }

    public boolean yE() {
        return aGQ().Cs();
    }

    public long getIsolatePtr() {
        return aGQ().getIsolatePtr();
    }

    public long aGW() {
        return aGR().CB().getPtr();
    }

    public void Ce(String str) {
        l aGR = aGR();
        aGR.chO.k(new com.tencent.mm.d.a.l.AnonymousClass3(str));
    }

    public void a(String str, String str2, ValueCallback<String> valueCallback) {
        l aGR = aGR();
        aGR.chO.k(new AnonymousClass4(str, str2));
    }
}
