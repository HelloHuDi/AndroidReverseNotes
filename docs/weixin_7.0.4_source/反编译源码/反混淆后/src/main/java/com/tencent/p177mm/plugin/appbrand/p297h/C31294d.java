package com.tencent.p177mm.plugin.appbrand.p297h;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p224d.p225a.C32488l;
import com.tencent.p177mm.p224d.p225a.C32488l.C14842;
import com.tencent.p177mm.p224d.p225a.C32488l.C14853;
import com.tencent.p177mm.p224d.p225a.C32488l.C14864;
import com.tencent.p177mm.p224d.p225a.C32488l.C2606310;
import com.tencent.p177mm.p224d.p225a.C32488l.C32490b;
import com.tencent.p177mm.p224d.p225a.C32488l.C324928;
import com.tencent.p177mm.p224d.p225a.C45301c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.net.URL;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.mm.plugin.appbrand.h.d */
abstract class C31294d implements C38235g, C26901k, C19243l, C33212n, C45565p, C26902r, C10257s {
    public abstract C45301c aGQ();

    public abstract C32488l aGR();

    C31294d() {
    }

    /* renamed from: a */
    public void mo30573a(C38235g c38235g, String str) {
        if (c38235g instanceof C31294d) {
            C32488l aGR = aGR();
            aGR.chO.mo73187k(new C14842(str, ((C31294d) c38235g).aGR()));
            return;
        }
        String str2;
        String str3 = "MicroMsg.AppBrandJ2V8Context";
        String str4 = "shareObject with unsupported implementation %s";
        Object[] objArr = new Object[1];
        if (c38235g == null) {
            str2 = null;
        } else {
            str2 = c38235g.getClass().getName();
        }
        objArr[0] = str2;
        C4990ab.m7413e(str3, str4, objArr);
    }

    public void addJavascriptInterface(Object obj, String str) {
        C32488l aGR = aGR();
        Class cls = JavascriptInterface.class;
        if (!TextUtils.isEmpty(str)) {
            aGR.chO.mo73187k(new C2606310(obj, str, cls));
        }
    }

    public void evaluateJavascript(String str, final ValueCallback<String> valueCallback) {
        aGR().mo53121a(str, valueCallback == null ? null : new C32490b() {
            /* renamed from: ds */
            public final void mo21687ds(String str) {
                AppMethodBeat.m2504i(113934);
                valueCallback.onReceiveValue(str);
                AppMethodBeat.m2505o(113934);
            }
        });
    }

    /* renamed from: a */
    public void mo14967a(URL url, String str, final ValueCallback<String> valueCallback) {
        if (url == null) {
            evaluateJavascript(str, valueCallback);
        } else {
            aGR().mo53122a(url.toString(), str, valueCallback == null ? null : new C32490b() {
                /* renamed from: ds */
                public final void mo21687ds(String str) {
                    AppMethodBeat.m2504i(113935);
                    valueCallback.onReceiveValue(str);
                    AppMethodBeat.m2505o(113935);
                }
            });
        }
    }

    /* renamed from: a */
    public void mo14968a(URL url, String str, String str2, String str3, final ValueCallback<String> valueCallback) {
        String str4;
        C32490b c102563 = valueCallback == null ? null : new C32490b() {
            /* renamed from: ds */
            public final void mo21687ds(String str) {
                AppMethodBeat.m2504i(113936);
                valueCallback.onReceiveValue(str);
                AppMethodBeat.m2505o(113936);
            }
        };
        C32488l aGR = aGR();
        if (url == null) {
            str4 = null;
        } else {
            str4 = url.toString();
        }
        aGR.chO.mo73187k(new C324928(str4, c102563, str3, str, str2));
    }

    public void destroy() {
        aGR().destroy();
    }

    /* renamed from: af */
    public <T extends C2169j> T mo14970af(Class<T> cls) {
        return cls.isInstance(this) ? this : null;
    }

    public int getNativeBufferId() {
        return aGR().chr.mo20675Cv();
    }

    public void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        aGR().chr.mo20676a(i, byteBuffer);
    }

    public ByteBuffer getNativeBuffer(int i) {
        return aGR().chr.mo20677gq(i);
    }

    /* renamed from: oS */
    public int mo30586oS(int i) {
        return aGR().chP.mo4933gn(i);
    }

    /* renamed from: oR */
    public ByteBuffer mo30585oR(int i) {
        return aGR().chP.mo4935gp(i);
    }

    /* renamed from: oQ */
    public void mo30584oQ(int i) {
        aGR().chP.destroy(i);
    }

    public void pause() {
        aGQ().pause();
    }

    public void resume() {
        aGQ().resume();
    }

    /* renamed from: f */
    public void mo30581f(Runnable runnable) {
        aGQ().mo73184f(runnable, 0);
    }

    public void setThreadPriority(int i) {
        aGQ().setThreadPriority(i);
    }

    /* renamed from: yE */
    public boolean mo30589yE() {
        return aGQ().mo73182Cs();
    }

    public long getIsolatePtr() {
        return aGQ().getIsolatePtr();
    }

    public long aGW() {
        return aGR().mo53119CB().getPtr();
    }

    /* renamed from: Ce */
    public void mo30571Ce(String str) {
        C32488l aGR = aGR();
        aGR.chO.mo73187k(new C14853(str));
    }

    /* renamed from: a */
    public void mo30574a(String str, String str2, ValueCallback<String> valueCallback) {
        C32488l aGR = aGR();
        aGR.chO.mo73187k(new C14864(str, str2));
    }
}
