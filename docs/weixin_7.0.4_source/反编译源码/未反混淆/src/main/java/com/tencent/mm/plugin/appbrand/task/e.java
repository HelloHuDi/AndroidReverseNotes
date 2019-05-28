package com.tencent.mm.plugin.appbrand.task;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vp;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.debugger.t;
import com.tencent.mm.plugin.appbrand.h.z;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.plugin.appbrand.report.g;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.xweb.WebView;
import com.tencent.xweb.x5.sdk.d;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class e {
    private static c iEk = c.NOT_PRELOAD;
    private static final HashSet<a> iEl = new HashSet();
    private static final Queue<u> iEm = new ConcurrentLinkedQueue();
    private static final Queue<q> iEn = new ConcurrentLinkedQueue();
    private static volatile String iEo = null;
    private static volatile String iEp = null;
    private static volatile AppBrandPreloadProfiler iEq = null;
    private static volatile g iEr = g.NIL;
    private static final com.tencent.mm.sdk.b.c iEs = new com.tencent.mm.sdk.b.c<vp>() {
        {
            AppMethodBeat.i(132793);
            this.xxI = vp.class.getName().hashCode();
            AppMethodBeat.o(132793);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(132794);
            if (ah.doF() || ah.doG()) {
                m.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(132792);
                        Looper.myQueue().addIdleHandler(new IdleHandler() {
                            public final boolean queueIdle() {
                                AppMethodBeat.i(132791);
                                Looper.myQueue().removeIdleHandler(this);
                                e.access$600();
                                AppMethodBeat.o(132791);
                                return false;
                            }
                        });
                        AppMethodBeat.o(132792);
                    }
                });
                dead();
            }
            AppMethodBeat.o(132794);
            return false;
        }
    };
    private static volatile boolean iEt = false;
    private static volatile boolean iEu = false;
    private static volatile boolean iEv = false;
    private static volatile int iEw = BaseClientBuilder.API_PRIORITY_OTHER;

    public interface a {
        void onReady();
    }

    enum c {
        NOT_PRELOAD,
        PRELOADING,
        PRELOADED;

        static {
            AppMethodBeat.o(132802);
        }
    }

    public enum b {
        PROCESS_COLD_BOOT,
        SYNC_LAUNCH,
        SYNC_GET_CODE;

        static {
            AppMethodBeat.o(132799);
        }
    }

    static /* synthetic */ void access$100() {
        AppMethodBeat.i(132815);
        reset();
        AppMethodBeat.o(132815);
    }

    static /* synthetic */ void access$700() {
        AppMethodBeat.i(132821);
        done();
        AppMethodBeat.o(132821);
    }

    static {
        AppMethodBeat.i(132822);
        AppMethodBeat.o(132822);
    }

    private static synchronized void reset() {
        synchronized (e.class) {
            AppMethodBeat.i(132803);
            iEk = c.NOT_PRELOAD;
            iEl.clear();
            iEm.clear();
            iEn.clear();
            iEo = null;
            iEp = null;
            iEq = null;
            iEr = g.NIL;
            AppMethodBeat.o(132803);
        }
    }

    public static synchronized void DJ(String str) {
        synchronized (e.class) {
            iEo = str;
            iEp = str;
        }
    }

    public static void a(g gVar, a aVar, boolean z, AppBrandPreloadProfiler appBrandPreloadProfiler) {
        c cVar;
        AppMethodBeat.i(132804);
        ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "AppBrandPreloader.preload serviceType = [%s]", gVar.name());
        synchronized (e.class) {
            try {
                if (iEk == c.PRELOADED && z) {
                    reset();
                }
                cVar = iEk;
                if (cVar == c.NOT_PRELOAD || cVar == c.PRELOADING) {
                    if (aVar != null) {
                        iEl.add(aVar);
                    }
                    iEk = c.PRELOADING;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(132804);
            }
        }
        if (cVar != c.PRELOADING) {
            if (cVar == c.PRELOADED) {
                if (aVar != null) {
                    aVar.onReady();
                }
                AppMethodBeat.o(132804);
                return;
            }
            b(gVar, appBrandPreloadProfiler);
            AppMethodBeat.o(132804);
        }
    }

    private static void b(final g gVar, AppBrandPreloadProfiler appBrandPreloadProfiler) {
        AppMethodBeat.i(132805);
        if (iEr != g.NIL) {
            IllegalStateException illegalStateException = new IllegalStateException("AppBrandPreloader.preload preload sServiceType is not nil");
            AppMethodBeat.o(132805);
            throw illegalStateException;
        }
        long j;
        iEr = gVar;
        if (appBrandPreloadProfiler == null) {
            appBrandPreloadProfiler = new AppBrandPreloadProfiler();
        }
        iEq = appBrandPreloadProfiler;
        h hVar = h.pYm;
        if (gVar == g.WAGAME) {
            j = 5;
        } else {
            j = 0;
        }
        hVar.k(915, j, 1);
        ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "TRACE_ORDER:AppBrandProcessPreloader.java");
        com.tencent.mm.plugin.appbrand.s.e.aNS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(132790);
                try {
                    e.iEq.startTime = SystemClock.elapsedRealtime();
                    ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "preInit start");
                    al.Ma(-2);
                    WxaCommLibRuntimeReader.sg();
                    z.aBv();
                    if (gVar == g.WAGAME) {
                        e.BK();
                        e.BL();
                        ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "[wagame] misc preload done");
                        return;
                    }
                    e.BM();
                    if (y.auw()) {
                        e.aLT();
                        ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "webview already init done");
                        ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "misc preload done");
                        al.Ma(10);
                        AppMethodBeat.o(132790);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    y.a(new com.tencent.mm.plugin.appbrand.y.a() {
                        public final void atR() {
                            AppMethodBeat.i(132788);
                            com.tencent.mm.plugin.appbrand.report.quality.a.aLz();
                            com.tencent.mm.plugin.appbrand.report.quality.b.a(true, null, currentTimeMillis, g.aLe());
                            e.aLT();
                            AppMethodBeat.o(132788);
                        }

                        public final void atS() {
                            AppMethodBeat.i(132789);
                            e.aLT();
                            AppMethodBeat.o(132789);
                        }
                    });
                    ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "misc preload done");
                    al.Ma(10);
                    AppMethodBeat.o(132790);
                } catch (Throwable th) {
                    ab.e("MicroMsg.AppBrandProcessPreloader[applaunch]", "skip preload runtime, load CommLib get exception %s", Log.getStackTraceString(th));
                    e.access$100();
                } finally {
                    ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "misc preload done");
                    al.Ma(10);
                    AppMethodBeat.o(132790);
                }
            }
        });
        AppMethodBeat.o(132805);
    }

    private static void aLO() {
        AppMethodBeat.i(132806);
        if (iEn.size() > 0) {
            AppMethodBeat.o(132806);
            return;
        }
        q bVar;
        if (iEr == g.WAGAME) {
            bVar = new com.tencent.mm.plugin.appbrand.game.b();
        } else {
            bVar = new s();
        }
        bVar.Dw();
        iEn.add(bVar);
        AppMethodBeat.o(132806);
    }

    /* JADX WARNING: Missing block: B:16:0x005c, code skipped:
            if (r2 == false) goto L_0x0095;
     */
    /* JADX WARNING: Missing block: B:17:0x005e, code skipped:
            b(r9, null);
            com.tencent.matrix.trace.core.AppMethodBeat.o(132807);
     */
    /* JADX WARNING: Missing block: B:28:0x0095, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(132807);
     */
    /* JADX WARNING: Missing block: B:31:?, code skipped:
            return true;
     */
    /* JADX WARNING: Missing block: B:32:?, code skipped:
            return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(g gVar, a aVar) {
        AppMethodBeat.i(132807);
        synchronized (e.class) {
            try {
                ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "Checking shouldWaitPreloading.. mCurrentPreloadState is [%s] ", iEk.name());
                if (iEk == c.PRELOADING && gVar == iEr) {
                    iEl.add(aVar);
                    iEq.iEj = SystemClock.elapsedRealtime();
                } else {
                    boolean z;
                    if (b.aLG()) {
                        if (iEk == c.NOT_PRELOAD) {
                            ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "[ForcePreload] wait preload (not preload currently)");
                            iEl.add(aVar);
                            iEk = c.PRELOADING;
                            z = true;
                        } else if (iEk == c.PRELOADED && (iEr != gVar || iEn.peek() == null)) {
                            ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "[ForcePreload] wait preload (preloaded)");
                            reset();
                            iEl.add(aVar);
                            iEk = c.PRELOADING;
                            z = true;
                        }
                    }
                    z = false;
                }
            } finally {
                AppMethodBeat.o(132807);
            }
        }
        return true;
    }

    public static AppBrandPreloadProfiler aLP() {
        return iEq;
    }

    public static s a(String str, g gVar) {
        long j;
        c cVar;
        s sVar = null;
        AppMethodBeat.i(132808);
        h hVar = h.pYm;
        if (gVar == g.WAGAME) {
            j = 12;
        } else {
            j = 10;
        }
        hVar.k(915, j, 1);
        synchronized (e.class) {
            try {
                cVar = iEk;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(132808);
            }
        }
        if (cVar == c.NOT_PRELOAD) {
            ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "AppBrandProcessPreloader not preload, just return null");
        } else if (cVar == c.PRELOADING) {
            if (f.IS_FLAVOR_RED || f.DEBUG) {
                IllegalStateException illegalStateException = new IllegalStateException("getServices when preloading");
                AppMethodBeat.o(132808);
                throw illegalStateException;
            }
            ab.printErrStackTrace("MicroMsg.AppBrandProcessPreloader[applaunch]", new IllegalStateException(), "AppBrandProcessPreloader is preloading when getServices, it need to wait! software fall in panic !", new Object[0]);
            AppMethodBeat.o(132808);
        } else if (!bo.isNullOrNil(str) && str.equals(iEp)) {
            ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "CurrentService is occupied req = [%s] cur = [%s]", str, iEp);
            AppMethodBeat.o(132808);
        } else if (gVar != iEr) {
            ab.e("MicroMsg.AppBrandProcessPreloader[applaunch]", "AppBrandProcessPreloader's ServiceType mismatch when getServices, watch it! But it's ok, just return null.");
            AppMethodBeat.o(132808);
        } else {
            iEp = str;
            sVar = (s) iEn.poll();
            if (sVar != null) {
                hVar = h.pYm;
                if (gVar == g.WAGAME) {
                    j = 7;
                } else {
                    j = 2;
                }
                hVar.k(915, j, 1);
            }
            AppMethodBeat.o(132808);
        }
        return sVar;
    }

    public static u DK(String str) {
        AppMethodBeat.i(132809);
        if (bo.isNullOrNil(str) || !str.equals(iEo)) {
            iEo = str;
            u uVar = (u) iEm.poll();
            AppMethodBeat.o(132809);
            return uVar;
        }
        AppMethodBeat.o(132809);
        return null;
    }

    private static void Sv() {
        AppMethodBeat.i(132810);
        if (al.isMainThread()) {
            done();
            AppMethodBeat.o(132810);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(132795);
                e.access$700();
                AppMethodBeat.o(132795);
            }
        });
        AppMethodBeat.o(132810);
    }

    private static void done() {
        long j;
        AppMethodBeat.i(132811);
        ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "preInit finished");
        iEq.aLL();
        h hVar = h.pYm;
        if (iEr == g.WAGAME) {
            j = 6;
        } else {
            j = 1;
        }
        hVar.k(915, j, 1);
        a(iEq, iEr);
        LinkedList<a> linkedList = new LinkedList();
        synchronized (e.class) {
            try {
                iEk = c.PRELOADED;
                linkedList.addAll(iEl);
                iEl.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(132811);
            }
        }
        for (a aVar : linkedList) {
            if (aVar != null) {
                aVar.onReady();
            }
        }
    }

    public static synchronized boolean auw() {
        boolean z;
        synchronized (e.class) {
            z = iEk == c.PRELOADED;
        }
        return z;
    }

    public static synchronized boolean aLQ() {
        boolean z = true;
        synchronized (e.class) {
            AppMethodBeat.i(132812);
            if (c.NOT_PRELOAD == iEk) {
                AppMethodBeat.o(132812);
            } else if (!auw() || iEm.size() > 0 || iEn.size() > 0) {
                z = false;
                AppMethodBeat.o(132812);
            } else {
                AppMethodBeat.o(132812);
            }
        }
        return z;
    }

    public static boolean aLR() {
        return iEu;
    }

    private static void a(AppBrandPreloadProfiler appBrandPreloadProfiler, g gVar) {
        AppMethodBeat.i(132813);
        String str = "[PreloadProfile]";
        if (appBrandPreloadProfiler == null) {
            ab.e("MicroMsg.AppBrandProcessPreloader[applaunch]", str + "AppBrandPreloadProfiler == null");
            AppMethodBeat.o(132813);
            return;
        }
        StringBuilder append = new StringBuilder().append(str).append(" ");
        String str2 = "Preload for [%s]Type | ";
        Object[] objArr = new Object[1];
        objArr[0] = gVar == null ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : gVar.name();
        StringBuilder append2 = append.append(bo.t(str2, objArr));
        String str3 = "Preload request at [%d] | ";
        Object[] objArr2 = new Object[1];
        objArr2[0] = Long.valueOf(appBrandPreloadProfiler.iEh == Long.MAX_VALUE ? -1 : appBrandPreloadProfiler.iEh);
        ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", append2.append(bo.t(str3, objArr2)).append(bo.t("Process prepared cost [%s]ms | ", a(appBrandPreloadProfiler.iEh, "req", appBrandPreloadProfiler.iEi, "proc"))).append(bo.t("Trans-thread prepared cost [%s]ms | ", a(appBrandPreloadProfiler.iEi, "proc", appBrandPreloadProfiler.startTime, "start"))).append(bo.t("Preload prepared cost [%s]ms | ", a(appBrandPreloadProfiler.startTime, "start", appBrandPreloadProfiler.endTime, "end"))).append(bo.t("All cost [%s]ms ", a(appBrandPreloadProfiler.iEh, "req", appBrandPreloadProfiler.endTime, "end"))).toString());
        AppMethodBeat.o(132813);
    }

    private static String a(long j, String str, long j2, String str2) {
        AppMethodBeat.i(132814);
        String t;
        if (j == Long.MAX_VALUE || j2 == Long.MAX_VALUE) {
            String str3 = "Unkown(%s=%s,%s=%s)";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = j == Long.MAX_VALUE ? "?" : "ok";
            objArr[2] = str2;
            objArr[3] = j2 == Long.MAX_VALUE ? "?" : "ok";
            t = bo.t(str3, objArr);
            AppMethodBeat.o(132814);
            return t;
        }
        t = String.valueOf(j2 - j);
        AppMethodBeat.o(132814);
        return t;
    }

    static /* synthetic */ void BK() {
        AppMethodBeat.i(132816);
        com.tencent.mm.ipcinvoker.wx_extension.a.a aVar = com.tencent.mm.ipcinvoker.wx_extension.a.a.b.eGM;
        com.tencent.mm.storage.c ll = com.tencent.mm.ipcinvoker.wx_extension.a.a.ll("100413");
        if (ll == null) {
            ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "[PreloadWAGameABTest] item is null");
            AppMethodBeat.o(132816);
            return;
        }
        boolean z = ll.isValid() && "1".equals(ll.dru().get("shouldOpen"));
        iEv = z;
        iEw = bo.getInt((String) ll.dru().get("preloadLibVersion"), BaseClientBuilder.API_PRIORITY_OTHER);
        ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "[PreloadWAGameABTest] sShouldPreloadWAGame:%b, sPreloadWxCommLibVersion :%d", Boolean.valueOf(iEv), Integer.valueOf(iEw));
        AppMethodBeat.o(132816);
    }

    static /* synthetic */ void BL() {
        int i = 1;
        AppMethodBeat.i(132817);
        if (t.azr()) {
            int i2 = (!iEv || WxaCommLibRuntimeReader.avQ().gVu < iEw) ? 0 : 1;
            ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "[PreloadWAGameABTest] checking... sShouldPreloadWAGame: [%b] WxaCommLibRuntimeReader.pkgVersion = [%d], sPreloadWxaCommLibVersion = [%d]", Boolean.valueOf(iEv), Integer.valueOf(r3), Integer.valueOf(iEw));
            if (b.aLG()) {
                ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "[PreloadWAGameABTest] forcePreload");
            } else {
                i = i2;
            }
        } else {
            ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "[PreloadWAGameABTest] hardcode disable preload for remote debug");
            i = 0;
        }
        if (i == 0) {
            ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "preloadNextRuntimeForWAGame disable preload");
            Sv();
            AppMethodBeat.o(132817);
            return;
        }
        try {
            aLO();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AppBrandProcessPreloader[applaunch]", e, "preloadNextRuntimeOnUiThreadForWAGame exception.", new Object[0]);
        }
        Sv();
        AppMethodBeat.o(132817);
    }

    static /* synthetic */ void BM() {
        AppMethodBeat.i(132818);
        com.tencent.mm.ipcinvoker.wx_extension.a.a aVar = com.tencent.mm.ipcinvoker.wx_extension.a.a.b.eGM;
        com.tencent.mm.storage.c ll = com.tencent.mm.ipcinvoker.wx_extension.a.a.ll("100308");
        if (ll == null) {
            ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "initPreloadABTest item is null");
            AppMethodBeat.o(132818);
            return;
        }
        boolean z = ll.isValid() && "1".equals(ll.dru().get("closeWAServiceClientPreload"));
        iEt = z;
        if (ll.isValid() && "1".equals(ll.dru().get("openDevelopControlPreload"))) {
            z = true;
        } else {
            z = false;
        }
        iEu = z;
        ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "initPreloadABTest close:%b, openDevelopCrt:%b", Boolean.valueOf(iEt), Boolean.valueOf(iEu));
        AppMethodBeat.o(132818);
    }

    static /* synthetic */ void aLT() {
        AppMethodBeat.i(132819);
        AnonymousClass4 anonymousClass4 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(132796);
                e.access$600();
                e.access$700();
                AppMethodBeat.o(132796);
            }
        };
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            anonymousClass4.run();
            AppMethodBeat.o(132819);
            return;
        }
        al.d(anonymousClass4);
        AppMethodBeat.o(132819);
    }

    static /* synthetic */ void access$600() {
        boolean z = true;
        AppMethodBeat.i(132820);
        if (!WebView.isSys()) {
            if (WebView.isX5()) {
                if (WebView.getUsingTbsCoreVersion(ah.getContext()) == 0) {
                    ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "closeWAServiceClientPreload without x5");
                } else if (!d.canOpenWebPlus(ah.getContext())) {
                    ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "closeWAServiceClientPreload can not OpenWebPlus");
                }
            }
            z = iEt;
        }
        if (z) {
            ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "preloadNextRuntimeOnUiThreadForWAService disable preload");
            AppMethodBeat.o(132820);
            return;
        }
        ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "preloadNextRuntimeOnUiThreadForWAService");
        al.Ma(-8);
        try {
            aLO();
            if (iEm.size() <= 0 && iEr != g.WAGAME) {
                w wVar = new w();
                wVar.Dw();
                iEm.add(wVar);
            }
            AppMethodBeat.o(132820);
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.AppBrandProcessPreloader[applaunch]", th, "preloadNextRuntimeOnUiThreadForWAService exception.", new Object[0]);
            if (bp.dpL()) {
                AppMethodBeat.o(132820);
            } else {
                AppMethodBeat.o(132820);
            }
        }
    }
}
