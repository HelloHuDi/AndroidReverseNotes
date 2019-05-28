package com.tencent.p177mm.plugin.appbrand.jsapi.p314q;

import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p314q.C16674d.C16675a;
import com.tencent.p177mm.plugin.appbrand.networking.C42638b;
import com.tencent.p177mm.plugin.appbrand.networking.C42639c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkTypeWxa;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType;", "Lcom/tencent/mm/plugin/appbrand/networking/IOnNetworkStateChanged;", "()V", "mCached", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType$NetworkType;", "mCanUseCache", "", "getNetworkType", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "onNetworkStateChanged", "", "onRegistered", "onUnregistered", "Companion", "luggage-wxa-app_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.q.e */
public final class C17093e extends C16674d implements C42639c {
    @Deprecated
    public static final C17094a hXG = new C17094a();
    private final AtomicReference<C16675a> hXE = new AtomicReference(null);
    private boolean hXF;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkTypeWxa$Companion;", "", "()V", "TAG", "", "luggage-wxa-app_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.q.e$a */
    static final class C17094a {
        private C17094a() {
        }

        public /* synthetic */ C17094a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(87579);
        AppMethodBeat.m2505o(87579);
    }

    public C17093e() {
        AppMethodBeat.m2504i(87578);
        AppMethodBeat.m2505o(87578);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: v */
    public final C16675a mo30644v(C2241c c2241c) {
        C16675a c16675a;
        AppMethodBeat.m2504i(87574);
        C25052j.m39376p(c2241c, "component");
        long nanoTime = System.nanoTime();
        if (this.hXF) {
            c16675a = (C16675a) this.hXE.get();
            if (c16675a == null) {
                c16675a = super.mo30644v(c2241c);
                this.hXE.set(c16675a);
            }
        } else {
            c16675a = super.mo30644v(c2241c);
        }
        nanoTime = System.nanoTime() - nanoTime;
        C45124d.m82932v("Luggage.Wxa.JsApiGetNetworkTypeWxa", "getNetworkType cost[ %d ns, %d ms] ret[%s]", Long.valueOf(nanoTime), Long.valueOf(TimeUnit.NANOSECONDS.toMillis(nanoTime)), c16675a.value);
        C25052j.m39375o(c16675a, "type");
        AppMethodBeat.m2505o(87574);
        return c16675a;
    }

    public final void aEU() {
        AppMethodBeat.m2504i(87575);
        this.hXE.set(null);
        AppMethodBeat.m2505o(87575);
    }

    /* renamed from: g */
    public final void mo31168g(C2241c c2241c) {
        AppMethodBeat.m2504i(87576);
        C25052j.m39376p(c2241c, "component");
        C42638b c42638b = (C42638b) c2241c.mo5936B(C42638b.class);
        if (c42638b != null) {
            c42638b.mo44871a(this);
            this.hXF = true;
            AppMethodBeat.m2505o(87576);
            return;
        }
        AppMethodBeat.m2505o(87576);
    }

    /* renamed from: h */
    public final void mo31169h(C2241c c2241c) {
        AppMethodBeat.m2504i(87577);
        C25052j.m39376p(c2241c, "component");
        C42638b c42638b = (C42638b) c2241c.mo5936B(C42638b.class);
        if (c42638b != null) {
            c42638b.mo44873b(this);
            AppMethodBeat.m2505o(87577);
            return;
        }
        AppMethodBeat.m2505o(87577);
    }
}
