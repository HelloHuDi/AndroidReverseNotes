package com.tencent.p177mm.plugin.appbrand.jsapi.auth;

import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.p177mm.plugin.appbrand.config.C16597h;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.plugin.appbrand.p281b.C10136c.C10137a;
import com.tencent.p177mm.plugin.appbrand.p281b.C45524b;
import com.tencent.p177mm.sdk.p604g.p608d.C4967b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J(\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIExecutorService;", "mConcurrentMaxCount", "", "(I)V", "mInFlightTasks", "Ljava/util/concurrent/atomic/AtomicInteger;", "mTaskQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lcom/tencent/mm/sdk/thread/runnable/KeyRunnable;", "cleanup", "", "dispatch", "task", "dispatchNext", "execute", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "data", "Lorg/json/JSONObject;", "callbackId", "schedule", "Companion", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.a */
public final class C19306a implements C2225b {
    private static final HashMap<String, C19306a> hBu = new HashMap();
    private static final C2225b hBv = C19307b.hBx;
    @Deprecated
    public static final C19308a hBw = new C19308a();
    private final LinkedBlockingQueue<C4967b> hBr = new LinkedBlockingQueue();
    private final AtomicInteger hBs = new AtomicInteger(0);
    private final int hBt;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, dWq = {"<anonymous>", "", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "data", "Lorg/json/JSONObject;", "callbackId", "", "execute"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.a$b */
    static final class C19307b implements C2225b {
        public static final C19307b hBx = new C19307b();

        static {
            AppMethodBeat.m2504i(134644);
            AppMethodBeat.m2505o(134644);
        }

        C19307b() {
        }

        /* renamed from: a */
        public final void mo6091a(C33245f c33245f, C33327h c33327h, JSONObject jSONObject, int i) {
            AppMethodBeat.m2504i(134643);
            C25052j.m39376p(c33245f, ProviderConstants.API_PATH);
            C25052j.m39376p(c33327h, "component");
            C25052j.m39376p(jSONObject, "data");
            C19306a.hBw;
            C4990ab.m7412e("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "dummy execute name[" + c33245f.getName() + "], callbackId[" + i + "], appId[" + c33327h.getAppId() + ']');
            AppMethodBeat.m2505o(134643);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion;", "", "()V", "DUMMY_IMPL", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIExecutorService;", "TAG", "", "gAppIdToQueueMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "Lkotlin/collections/HashMap;", "obtainByRuntime", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.a$a */
    static final class C19308a {

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion$obtainByRuntime$1$1"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.a$a$a */
        static final class C19309a extends C25053k implements C31214a<C19306a> {
            final /* synthetic */ C6750i hBy;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\t"}, dWq = {"<anonymous>", "", "appId", "", "kotlin.jvm.PlatformType", "state", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "onRunningStateChanged", "com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion$obtainByRuntime$1$1$1$1", "com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion$obtainByRuntime$1$1$$special$$inlined$apply$lambda$1"})
            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.a$a$a$1 */
            static final class C103281 implements C10137a {
                final /* synthetic */ C19309a hBz;

                C103281(C19309a c19309a) {
                    this.hBz = c19309a;
                }

                /* renamed from: a */
                public final void mo6006a(String str, C45524b c45524b) {
                    AppMethodBeat.m2504i(134645);
                    if (c45524b == C45524b.DESTROYED) {
                        C19306a.hBw;
                        synchronized (C19306a.hBu) {
                            try {
                                C19306a.hBw;
                                C19306a c19306a = (C19306a) C19306a.hBu.remove(this.hBz.hBy.getAppId());
                                if (c19306a != null) {
                                    C19306a.m29982b(c19306a);
                                    C37091y c37091y = C37091y.AUy;
                                }
                            } finally {
                                AppMethodBeat.m2505o(134645);
                            }
                        }
                        return;
                    }
                    AppMethodBeat.m2505o(134645);
                }
            }

            C19309a(C6750i c6750i) {
                this.hBy = c6750i;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                int i;
                C19306a c19306a;
                AppMethodBeat.m2504i(134646);
                C16597h ye = this.hBy.mo15034ye();
                if (!(ye instanceof AppBrandSysConfigLU)) {
                    ye = null;
                }
                AppBrandSysConfigLU appBrandSysConfigLU = (AppBrandSysConfigLU) ye;
                if (appBrandSysConfigLU != null) {
                    AppBrandGlobalSystemConfig appBrandGlobalSystemConfig = appBrandSysConfigLU.bQO;
                    if (appBrandGlobalSystemConfig != null) {
                        i = appBrandGlobalSystemConfig.hgi;
                        c19306a = new C19306a(i);
                        C19306a.hBw;
                        C19306a.hBu.put(this.hBy.getAppId(), c19306a);
                        this.hBy.asW().mo21486a(new C103281(this));
                        AppMethodBeat.m2505o(134646);
                        return c19306a;
                    }
                }
                i = 10;
                c19306a = new C19306a(i);
                C19306a.hBw;
                C19306a.hBu.put(this.hBy.getAppId(), c19306a);
                this.hBy.asW().mo21486a(new C103281(this));
                AppMethodBeat.m2505o(134646);
                return c19306a;
            }
        }

        private C19308a() {
        }

        public /* synthetic */ C19308a(byte b) {
            this();
        }

        /* renamed from: u */
        public static C2225b m29986u(C6750i c6750i) {
            AppMethodBeat.m2504i(134647);
            C2225b aCy;
            if (c6750i == null) {
                aCy = C19306a.hBv;
                AppMethodBeat.m2505o(134647);
                return aCy;
            }
            synchronized (C19306a.hBu) {
                try {
                    C19306a.hBw;
                    C19306a c19306a = (C19306a) C19306a.hBu.get(c6750i.getAppId());
                    aCy = c19306a != null ? c19306a : (C2225b) new C19309a(c6750i).invoke();
                } finally {
                    AppMethodBeat.m2505o(134647);
                }
            }
            return aCy;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$execute$task$1", "Lcom/tencent/mm/sdk/thread/runnable/KeyRunnable;", "getKey", "", "run", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.a$c */
    public static final class C19310c implements C4967b {
        final /* synthetic */ C19306a hBA;
        final /* synthetic */ C33327h hBB;
        final /* synthetic */ C33245f hBC;
        final /* synthetic */ JSONObject hBD;
        final /* synthetic */ int hBE;
        final /* synthetic */ String hBF;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onAuthResult"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.a$c$a */
        static final class C6768a implements C2227d {
            final /* synthetic */ C19310c hBG;

            C6768a(C19310c c19310c) {
                this.hBG = c19310c;
            }

            public final void aCB() {
                AppMethodBeat.m2504i(134648);
                C19306a.hBw;
                C4990ab.m7410d("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "execute() done, " + this.hBG.hBF);
                C19306a.m29980a(this.hBG.hBA);
                AppMethodBeat.m2505o(134648);
            }
        }

        C19310c(C19306a c19306a, C33327h c33327h, C33245f c33245f, JSONObject jSONObject, int i, String str) {
            this.hBA = c19306a;
            this.hBB = c33327h;
            this.hBC = c33245f;
            this.hBD = jSONObject;
            this.hBE = i;
            this.hBF = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(134649);
            if (this.hBB.isRunning()) {
                this.hBC.mo21765a(this.hBB, this.hBD, this.hBE, new C6768a(this));
                AppMethodBeat.m2505o(134649);
                return;
            }
            C19306a.m29980a(this.hBA);
            AppMethodBeat.m2505o(134649);
        }

        public final String getKey() {
            return this.hBF;
        }
    }

    /* renamed from: u */
    public static final C2225b m29983u(C6750i c6750i) {
        AppMethodBeat.m2504i(134656);
        C2225b u = C19308a.m29986u(c6750i);
        AppMethodBeat.m2505o(134656);
        return u;
    }

    public C19306a(int i) {
        AppMethodBeat.m2504i(134652);
        this.hBt = i;
        AppMethodBeat.m2505o(134652);
    }

    static {
        AppMethodBeat.m2504i(134653);
        AppMethodBeat.m2505o(134653);
    }

    /* renamed from: a */
    public final void mo6091a(C33245f c33245f, C33327h c33327h, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(134650);
        C25052j.m39376p(c33245f, ProviderConstants.API_PATH);
        C25052j.m39376p(c33327h, "component");
        C25052j.m39376p(jSONObject, "data");
        String str = "name[" + c33245f.getName() + "], callbackId[" + i + "], appId[" + c33327h.getAppId() + ']';
        C19310c c19310c = new C19310c(this, c33327h, c33245f, jSONObject, i, str);
        C4990ab.m7410d("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "dispatch ".concat(String.valueOf(str)));
        m29981a((C4967b) c19310c);
        AppMethodBeat.m2505o(134650);
    }

    /* renamed from: a */
    private final void m29981a(C4967b c4967b) {
        AppMethodBeat.m2504i(134651);
        while (this.hBs.incrementAndGet() > this.hBt) {
            this.hBr.offer(c4967b);
            if (this.hBs.decrementAndGet() >= this.hBt) {
                AppMethodBeat.m2505o(134651);
                return;
            }
            C4967b c4967b2 = (C4967b) this.hBr.poll();
            if (c4967b2 == null) {
                AppMethodBeat.m2505o(134651);
                return;
            }
            c4967b = c4967b2;
        }
        C4990ab.m7410d("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "schedule " + c4967b.getKey());
        c4967b.run();
        AppMethodBeat.m2505o(134651);
    }

    /* renamed from: b */
    public static final /* synthetic */ void m29982b(C19306a c19306a) {
        AppMethodBeat.m2504i(134655);
        c19306a.hBr.clear();
        AppMethodBeat.m2505o(134655);
    }
}
