package com.tencent.mm.plugin.appbrand.jsapi.auth;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

@l(dWo = {1, 1, 13}, dWp = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J(\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIExecutorService;", "mConcurrentMaxCount", "", "(I)V", "mInFlightTasks", "Ljava/util/concurrent/atomic/AtomicInteger;", "mTaskQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lcom/tencent/mm/sdk/thread/runnable/KeyRunnable;", "cleanup", "", "dispatch", "task", "dispatchNext", "execute", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "data", "Lorg/json/JSONObject;", "callbackId", "schedule", "Companion", "plugin-appbrand-integration_release"})
public final class a implements b {
    private static final HashMap<String, a> hBu = new HashMap();
    private static final b hBv = b.hBx;
    @Deprecated
    public static final a hBw = new a();
    private final LinkedBlockingQueue<com.tencent.mm.sdk.g.d.b> hBr = new LinkedBlockingQueue();
    private final AtomicInteger hBs = new AtomicInteger(0);
    private final int hBt;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, dWq = {"<anonymous>", "", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "data", "Lorg/json/JSONObject;", "callbackId", "", "execute"})
    static final class b implements b {
        public static final b hBx = new b();

        static {
            AppMethodBeat.i(134644);
            AppMethodBeat.o(134644);
        }

        b() {
        }

        public final void a(f fVar, h hVar, JSONObject jSONObject, int i) {
            AppMethodBeat.i(134643);
            j.p(fVar, ProviderConstants.API_PATH);
            j.p(hVar, "component");
            j.p(jSONObject, "data");
            a.hBw;
            ab.e("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "dummy execute name[" + fVar.getName() + "], callbackId[" + i + "], appId[" + hVar.getAppId() + ']');
            AppMethodBeat.o(134643);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion;", "", "()V", "DUMMY_IMPL", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIExecutorService;", "TAG", "", "gAppIdToQueueMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "Lkotlin/collections/HashMap;", "obtainByRuntime", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "plugin-appbrand-integration_release"})
    static final class a {

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion$obtainByRuntime$1$1"})
        static final class a extends k implements a.f.a.a<a> {
            final /* synthetic */ i hBy;

            @l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\t"}, dWq = {"<anonymous>", "", "appId", "", "kotlin.jvm.PlatformType", "state", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "onRunningStateChanged", "com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion$obtainByRuntime$1$1$1$1", "com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion$obtainByRuntime$1$1$$special$$inlined$apply$lambda$1"})
            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.a$a$a$1 */
            static final class AnonymousClass1 implements com.tencent.mm.plugin.appbrand.b.c.a {
                final /* synthetic */ a hBz;

                AnonymousClass1(a aVar) {
                    this.hBz = aVar;
                }

                public final void a(String str, com.tencent.mm.plugin.appbrand.b.b bVar) {
                    AppMethodBeat.i(134645);
                    if (bVar == com.tencent.mm.plugin.appbrand.b.b.DESTROYED) {
                        a.hBw;
                        synchronized (a.hBu) {
                            try {
                                a.hBw;
                                a aVar = (a) a.hBu.remove(this.hBz.hBy.getAppId());
                                if (aVar != null) {
                                    a.b(aVar);
                                    y yVar = y.AUy;
                                }
                            } finally {
                                AppMethodBeat.o(134645);
                            }
                        }
                        return;
                    }
                    AppMethodBeat.o(134645);
                }
            }

            a(i iVar) {
                this.hBy = iVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                int i;
                a aVar;
                AppMethodBeat.i(134646);
                com.tencent.mm.plugin.appbrand.config.h ye = this.hBy.ye();
                if (!(ye instanceof AppBrandSysConfigLU)) {
                    ye = null;
                }
                AppBrandSysConfigLU appBrandSysConfigLU = (AppBrandSysConfigLU) ye;
                if (appBrandSysConfigLU != null) {
                    AppBrandGlobalSystemConfig appBrandGlobalSystemConfig = appBrandSysConfigLU.bQO;
                    if (appBrandGlobalSystemConfig != null) {
                        i = appBrandGlobalSystemConfig.hgi;
                        aVar = new a(i);
                        a.hBw;
                        a.hBu.put(this.hBy.getAppId(), aVar);
                        this.hBy.asW().a(new AnonymousClass1(this));
                        AppMethodBeat.o(134646);
                        return aVar;
                    }
                }
                i = 10;
                aVar = new a(i);
                a.hBw;
                a.hBu.put(this.hBy.getAppId(), aVar);
                this.hBy.asW().a(new AnonymousClass1(this));
                AppMethodBeat.o(134646);
                return aVar;
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static b u(i iVar) {
            AppMethodBeat.i(134647);
            b aCy;
            if (iVar == null) {
                aCy = a.hBv;
                AppMethodBeat.o(134647);
                return aCy;
            }
            synchronized (a.hBu) {
                try {
                    a.hBw;
                    a aVar = (a) a.hBu.get(iVar.getAppId());
                    aCy = aVar != null ? aVar : (b) new a(iVar).invoke();
                } finally {
                    AppMethodBeat.o(134647);
                }
            }
            return aCy;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$execute$task$1", "Lcom/tencent/mm/sdk/thread/runnable/KeyRunnable;", "getKey", "", "run", "", "plugin-appbrand-integration_release"})
    public static final class c implements com.tencent.mm.sdk.g.d.b {
        final /* synthetic */ a hBA;
        final /* synthetic */ h hBB;
        final /* synthetic */ f hBC;
        final /* synthetic */ JSONObject hBD;
        final /* synthetic */ int hBE;
        final /* synthetic */ String hBF;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onAuthResult"})
        static final class a implements d {
            final /* synthetic */ c hBG;

            a(c cVar) {
                this.hBG = cVar;
            }

            public final void aCB() {
                AppMethodBeat.i(134648);
                a.hBw;
                ab.d("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "execute() done, " + this.hBG.hBF);
                a.a(this.hBG.hBA);
                AppMethodBeat.o(134648);
            }
        }

        c(a aVar, h hVar, f fVar, JSONObject jSONObject, int i, String str) {
            this.hBA = aVar;
            this.hBB = hVar;
            this.hBC = fVar;
            this.hBD = jSONObject;
            this.hBE = i;
            this.hBF = str;
        }

        public final void run() {
            AppMethodBeat.i(134649);
            if (this.hBB.isRunning()) {
                this.hBC.a(this.hBB, this.hBD, this.hBE, new a(this));
                AppMethodBeat.o(134649);
                return;
            }
            a.a(this.hBA);
            AppMethodBeat.o(134649);
        }

        public final String getKey() {
            return this.hBF;
        }
    }

    public static final b u(i iVar) {
        AppMethodBeat.i(134656);
        b u = a.u(iVar);
        AppMethodBeat.o(134656);
        return u;
    }

    public a(int i) {
        AppMethodBeat.i(134652);
        this.hBt = i;
        AppMethodBeat.o(134652);
    }

    static {
        AppMethodBeat.i(134653);
        AppMethodBeat.o(134653);
    }

    public final void a(f fVar, h hVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(134650);
        j.p(fVar, ProviderConstants.API_PATH);
        j.p(hVar, "component");
        j.p(jSONObject, "data");
        String str = "name[" + fVar.getName() + "], callbackId[" + i + "], appId[" + hVar.getAppId() + ']';
        c cVar = new c(this, hVar, fVar, jSONObject, i, str);
        ab.d("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "dispatch ".concat(String.valueOf(str)));
        a((com.tencent.mm.sdk.g.d.b) cVar);
        AppMethodBeat.o(134650);
    }

    private final void a(com.tencent.mm.sdk.g.d.b bVar) {
        AppMethodBeat.i(134651);
        while (this.hBs.incrementAndGet() > this.hBt) {
            this.hBr.offer(bVar);
            if (this.hBs.decrementAndGet() >= this.hBt) {
                AppMethodBeat.o(134651);
                return;
            }
            com.tencent.mm.sdk.g.d.b bVar2 = (com.tencent.mm.sdk.g.d.b) this.hBr.poll();
            if (bVar2 == null) {
                AppMethodBeat.o(134651);
                return;
            }
            bVar = bVar2;
        }
        ab.d("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "schedule " + bVar.getKey());
        bVar.run();
        AppMethodBeat.o(134651);
    }

    public static final /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(134655);
        aVar.hBr.clear();
        AppMethodBeat.o(134655);
    }
}
