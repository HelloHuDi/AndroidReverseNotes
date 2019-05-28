package com.tencent.mm.plugin.appbrand.jsapi.q;

import a.f.b.j;
import a.l;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.networking.b;
import com.tencent.mm.plugin.appbrand.networking.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkTypeWxa;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType;", "Lcom/tencent/mm/plugin/appbrand/networking/IOnNetworkStateChanged;", "()V", "mCached", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType$NetworkType;", "mCanUseCache", "", "getNetworkType", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "onNetworkStateChanged", "", "onRegistered", "onUnregistered", "Companion", "luggage-wxa-app_release"})
public final class e extends d implements c {
    @Deprecated
    public static final a hXG = new a();
    private final AtomicReference<com.tencent.mm.plugin.appbrand.jsapi.q.d.a> hXE = new AtomicReference(null);
    private boolean hXF;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkTypeWxa$Companion;", "", "()V", "TAG", "", "luggage-wxa-app_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(87579);
        AppMethodBeat.o(87579);
    }

    public e() {
        AppMethodBeat.i(87578);
        AppMethodBeat.o(87578);
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.plugin.appbrand.jsapi.q.d.a v(com.tencent.mm.plugin.appbrand.jsapi.c cVar) {
        com.tencent.mm.plugin.appbrand.jsapi.q.d.a aVar;
        AppMethodBeat.i(87574);
        j.p(cVar, "component");
        long nanoTime = System.nanoTime();
        if (this.hXF) {
            aVar = (com.tencent.mm.plugin.appbrand.jsapi.q.d.a) this.hXE.get();
            if (aVar == null) {
                aVar = super.v(cVar);
                this.hXE.set(aVar);
            }
        } else {
            aVar = super.v(cVar);
        }
        nanoTime = System.nanoTime() - nanoTime;
        d.v("Luggage.Wxa.JsApiGetNetworkTypeWxa", "getNetworkType cost[ %d ns, %d ms] ret[%s]", Long.valueOf(nanoTime), Long.valueOf(TimeUnit.NANOSECONDS.toMillis(nanoTime)), aVar.value);
        j.o(aVar, "type");
        AppMethodBeat.o(87574);
        return aVar;
    }

    public final void aEU() {
        AppMethodBeat.i(87575);
        this.hXE.set(null);
        AppMethodBeat.o(87575);
    }

    public final void g(com.tencent.mm.plugin.appbrand.jsapi.c cVar) {
        AppMethodBeat.i(87576);
        j.p(cVar, "component");
        b bVar = (b) cVar.B(b.class);
        if (bVar != null) {
            bVar.a(this);
            this.hXF = true;
            AppMethodBeat.o(87576);
            return;
        }
        AppMethodBeat.o(87576);
    }

    public final void h(com.tencent.mm.plugin.appbrand.jsapi.c cVar) {
        AppMethodBeat.i(87577);
        j.p(cVar, "component");
        b bVar = (b) cVar.B(b.class);
        if (bVar != null) {
            bVar.b(this);
            AppMethodBeat.o(87577);
            return;
        }
        AppMethodBeat.o(87577);
    }
}
