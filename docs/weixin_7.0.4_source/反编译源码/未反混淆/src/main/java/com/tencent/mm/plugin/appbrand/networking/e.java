package com.tencent.mm.plugin.appbrand.networking;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.q;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

@l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016J\u0006\u0010\u000f\u001a\u00020\rJ\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/networking/INetworkService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "mListeners", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/appbrand/networking/IOnNetworkStateChanged;", "mRuntime", "getMRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "addListener", "", "l", "notifyNetworkStateChanged", "onRegister", "onUnregister", "removeListener", "luggage-wxa-app_release"})
public class e implements b, b {
    final i gPI;
    private final ConcurrentLinkedDeque<c> ipI = new ConcurrentLinkedDeque();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onNetworkStateChanged"})
    static final class a implements c {
        final /* synthetic */ e ipJ;

        a(e eVar) {
            this.ipJ = eVar;
        }

        public final void aEU() {
            AppMethodBeat.i(87585);
            com.tencent.mm.plugin.appbrand.jsapi.q.a.k(this.ipJ.gPI.xT());
            AppMethodBeat.o(87585);
        }
    }

    public e(i iVar) {
        j.p(iVar, "rt");
        AppMethodBeat.i(87591);
        this.gPI = iVar;
        AppMethodBeat.o(87591);
    }

    public void SH() {
        AppMethodBeat.i(87586);
        a(new a(this));
        AppMethodBeat.o(87586);
    }

    public void SI() {
        AppMethodBeat.i(87587);
        this.ipI.clear();
        AppMethodBeat.o(87587);
    }

    public final void aIQ() {
        AppMethodBeat.i(87588);
        q xT = this.gPI.xT();
        if (xT != null) {
            if (xT.isRunning()) {
                Iterator it = this.ipI.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).aEU();
                }
            }
            AppMethodBeat.o(87588);
            return;
        }
        AppMethodBeat.o(87588);
    }

    public final void a(c cVar) {
        AppMethodBeat.i(87589);
        this.ipI.add(cVar);
        AppMethodBeat.o(87589);
    }

    public final void b(c cVar) {
        AppMethodBeat.i(87590);
        this.ipI.remove(cVar);
        AppMethodBeat.o(87590);
    }
}
