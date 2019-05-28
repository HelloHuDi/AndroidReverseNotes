package com.tencent.p177mm.plugin.appbrand.networking;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p242c.C1695b;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.jsapi.p314q.C33387a;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016J\u0006\u0010\u000f\u001a\u00020\rJ\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/networking/INetworkService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "mListeners", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/appbrand/networking/IOnNetworkStateChanged;", "mRuntime", "getMRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "addListener", "", "l", "notifyNetworkStateChanged", "onRegister", "onUnregister", "removeListener", "luggage-wxa-app_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.networking.e */
public class C27211e implements C1695b, C42638b {
    final C6750i gPI;
    private final ConcurrentLinkedDeque<C42639c> ipI = new ConcurrentLinkedDeque();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onNetworkStateChanged"})
    /* renamed from: com.tencent.mm.plugin.appbrand.networking.e$a */
    static final class C27210a implements C42639c {
        final /* synthetic */ C27211e ipJ;

        C27210a(C27211e c27211e) {
            this.ipJ = c27211e;
        }

        public final void aEU() {
            AppMethodBeat.m2504i(87585);
            C33387a.m54580k(this.ipJ.gPI.mo15032xT());
            AppMethodBeat.m2505o(87585);
        }
    }

    public C27211e(C6750i c6750i) {
        C25052j.m39376p(c6750i, "rt");
        AppMethodBeat.m2504i(87591);
        this.gPI = c6750i;
        AppMethodBeat.m2505o(87591);
    }

    /* renamed from: SH */
    public void mo5202SH() {
        AppMethodBeat.m2504i(87586);
        mo44871a(new C27210a(this));
        AppMethodBeat.m2505o(87586);
    }

    /* renamed from: SI */
    public void mo5203SI() {
        AppMethodBeat.m2504i(87587);
        this.ipI.clear();
        AppMethodBeat.m2505o(87587);
    }

    public final void aIQ() {
        AppMethodBeat.m2504i(87588);
        C38492q xT = this.gPI.mo15032xT();
        if (xT != null) {
            if (xT.isRunning()) {
                Iterator it = this.ipI.iterator();
                while (it.hasNext()) {
                    ((C42639c) it.next()).aEU();
                }
            }
            AppMethodBeat.m2505o(87588);
            return;
        }
        AppMethodBeat.m2505o(87588);
    }

    /* renamed from: a */
    public final void mo44871a(C42639c c42639c) {
        AppMethodBeat.m2504i(87589);
        this.ipI.add(c42639c);
        AppMethodBeat.m2505o(87589);
    }

    /* renamed from: b */
    public final void mo44873b(C42639c c42639c) {
        AppMethodBeat.m2504i(87590);
        this.ipI.remove(c42639c);
        AppMethodBeat.m2505o(87590);
    }
}
