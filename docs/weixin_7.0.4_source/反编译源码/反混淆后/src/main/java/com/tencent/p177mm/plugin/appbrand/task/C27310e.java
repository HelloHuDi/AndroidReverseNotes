package com.tencent.p177mm.plugin.appbrand.task;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a.C32718b;
import com.tencent.p177mm.p230g.p231a.C42079vp;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.C42751y;
import com.tencent.p177mm.plugin.appbrand.C42751y.C11068a;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.p177mm.plugin.appbrand.debugger.C26852t;
import com.tencent.p177mm.plugin.appbrand.game.C42439b;
import com.tencent.p177mm.plugin.appbrand.p297h.C38238z;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.report.C42671g;
import com.tencent.p177mm.plugin.appbrand.report.quality.C27285a;
import com.tencent.p177mm.plugin.appbrand.report.quality.C38501b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p685x5.sdk.C24544d;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.tencent.mm.plugin.appbrand.task.e */
public class C27310e {
    private static C27315c iEk = C27315c.NOT_PRELOAD;
    private static final HashSet<C27314a> iEl = new HashSet();
    private static final Queue<C44709u> iEm = new ConcurrentLinkedQueue();
    private static final Queue<C38492q> iEn = new ConcurrentLinkedQueue();
    private static volatile String iEo = null;
    private static volatile String iEp = null;
    private static volatile AppBrandPreloadProfiler iEq = null;
    private static volatile C38519g iEr = C38519g.NIL;
    private static final C4884c iEs = new C273112();
    private static volatile boolean iEt = false;
    private static volatile boolean iEu = false;
    private static volatile boolean iEv = false;
    private static volatile int iEw = BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: com.tencent.mm.plugin.appbrand.task.e$3 */
    static class C197433 implements Runnable {
        C197433() {
        }

        public final void run() {
            AppMethodBeat.m2504i(132795);
            C27310e.access$700();
            AppMethodBeat.m2505o(132795);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.task.e$2 */
    static class C273112 extends C4884c<C42079vp> {

        /* renamed from: com.tencent.mm.plugin.appbrand.task.e$2$1 */
        class C273121 implements Runnable {

            /* renamed from: com.tencent.mm.plugin.appbrand.task.e$2$1$1 */
            class C273131 implements IdleHandler {
                C273131() {
                }

                public final boolean queueIdle() {
                    AppMethodBeat.m2504i(132791);
                    Looper.myQueue().removeIdleHandler(this);
                    C27310e.access$600();
                    AppMethodBeat.m2505o(132791);
                    return false;
                }
            }

            C273121() {
            }

            public final void run() {
                AppMethodBeat.m2504i(132792);
                Looper.myQueue().addIdleHandler(new C273131());
                AppMethodBeat.m2505o(132792);
            }
        }

        C273112() {
            AppMethodBeat.m2504i(132793);
            this.xxI = C42079vp.class.getName().hashCode();
            AppMethodBeat.m2505o(132793);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(132794);
            if (C4996ah.doF() || C4996ah.doG()) {
                C45673m.runOnUiThread(new C273121());
                dead();
            }
            AppMethodBeat.m2505o(132794);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.task.e$a */
    public interface C27314a {
        void onReady();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.task.e$c */
    enum C27315c {
        NOT_PRELOAD,
        PRELOADING,
        PRELOADED;

        static {
            AppMethodBeat.m2505o(132802);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.task.e$4 */
    static class C273164 implements Runnable {
        C273164() {
        }

        public final void run() {
            AppMethodBeat.m2504i(132796);
            C27310e.access$600();
            C27310e.access$700();
            AppMethodBeat.m2505o(132796);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.task.e$b */
    public enum C27317b {
        PROCESS_COLD_BOOT,
        SYNC_LAUNCH,
        SYNC_GET_CODE;

        static {
            AppMethodBeat.m2505o(132799);
        }
    }

    static /* synthetic */ void access$100() {
        AppMethodBeat.m2504i(132815);
        C27310e.reset();
        AppMethodBeat.m2505o(132815);
    }

    static /* synthetic */ void access$700() {
        AppMethodBeat.m2504i(132821);
        C27310e.done();
        AppMethodBeat.m2505o(132821);
    }

    static {
        AppMethodBeat.m2504i(132822);
        AppMethodBeat.m2505o(132822);
    }

    private static synchronized void reset() {
        synchronized (C27310e.class) {
            AppMethodBeat.m2504i(132803);
            iEk = C27315c.NOT_PRELOAD;
            iEl.clear();
            iEm.clear();
            iEn.clear();
            iEo = null;
            iEp = null;
            iEq = null;
            iEr = C38519g.NIL;
            AppMethodBeat.m2505o(132803);
        }
    }

    /* renamed from: DJ */
    public static synchronized void m43367DJ(String str) {
        synchronized (C27310e.class) {
            iEo = str;
            iEp = str;
        }
    }

    /* renamed from: a */
    public static void m43373a(C38519g c38519g, C27314a c27314a, boolean z, AppBrandPreloadProfiler appBrandPreloadProfiler) {
        C27315c c27315c;
        AppMethodBeat.m2504i(132804);
        C4990ab.m7417i("MicroMsg.AppBrandProcessPreloader[applaunch]", "AppBrandPreloader.preload serviceType = [%s]", c38519g.name());
        synchronized (C27310e.class) {
            try {
                if (iEk == C27315c.PRELOADED && z) {
                    C27310e.reset();
                }
                c27315c = iEk;
                if (c27315c == C27315c.NOT_PRELOAD || c27315c == C27315c.PRELOADING) {
                    if (c27314a != null) {
                        iEl.add(c27314a);
                    }
                    iEk = C27315c.PRELOADING;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(132804);
            }
        }
        if (c27315c != C27315c.PRELOADING) {
            if (c27315c == C27315c.PRELOADED) {
                if (c27314a != null) {
                    c27314a.onReady();
                }
                AppMethodBeat.m2505o(132804);
                return;
            }
            C27310e.m43375b(c38519g, appBrandPreloadProfiler);
            AppMethodBeat.m2505o(132804);
        }
    }

    /* renamed from: b */
    private static void m43375b(final C38519g c38519g, AppBrandPreloadProfiler appBrandPreloadProfiler) {
        AppMethodBeat.m2504i(132805);
        if (iEr != C38519g.NIL) {
            IllegalStateException illegalStateException = new IllegalStateException("AppBrandPreloader.preload preload sServiceType is not nil");
            AppMethodBeat.m2505o(132805);
            throw illegalStateException;
        }
        long j;
        iEr = c38519g;
        if (appBrandPreloadProfiler == null) {
            appBrandPreloadProfiler = new AppBrandPreloadProfiler();
        }
        iEq = appBrandPreloadProfiler;
        C7060h c7060h = C7060h.pYm;
        if (c38519g == C38519g.WAGAME) {
            j = 5;
        } else {
            j = 0;
        }
        c7060h.mo15419k(915, j, 1);
        C4990ab.m7416i("MicroMsg.AppBrandProcessPreloader[applaunch]", "TRACE_ORDER:AppBrandProcessPreloader.java");
        C42677e.aNS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(132790);
                try {
                    C27310e.iEq.startTime = SystemClock.elapsedRealtime();
                    C4990ab.m7416i("MicroMsg.AppBrandProcessPreloader[applaunch]", "preInit start");
                    C5004al.m7436Ma(-2);
                    WxaCommLibRuntimeReader.m42567sg();
                    C38238z.aBv();
                    if (c38519g == C38519g.WAGAME) {
                        C27310e.m43364BK();
                        C27310e.m43365BL();
                        C4990ab.m7416i("MicroMsg.AppBrandProcessPreloader[applaunch]", "[wagame] misc preload done");
                        return;
                    }
                    C27310e.m43366BM();
                    if (C42751y.auw()) {
                        C27310e.aLT();
                        C4990ab.m7416i("MicroMsg.AppBrandProcessPreloader[applaunch]", "webview already init done");
                        C4990ab.m7416i("MicroMsg.AppBrandProcessPreloader[applaunch]", "misc preload done");
                        C5004al.m7436Ma(10);
                        AppMethodBeat.m2505o(132790);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    C42751y.m75787a(new C11068a() {
                        public final void atR() {
                            AppMethodBeat.m2504i(132788);
                            C27285a.aLz();
                            C38501b.m65163a(true, null, currentTimeMillis, C42671g.aLe());
                            C27310e.aLT();
                            AppMethodBeat.m2505o(132788);
                        }

                        public final void atS() {
                            AppMethodBeat.m2504i(132789);
                            C27310e.aLT();
                            AppMethodBeat.m2505o(132789);
                        }
                    });
                    C4990ab.m7416i("MicroMsg.AppBrandProcessPreloader[applaunch]", "misc preload done");
                    C5004al.m7436Ma(10);
                    AppMethodBeat.m2505o(132790);
                } catch (Throwable th) {
                    C4990ab.m7413e("MicroMsg.AppBrandProcessPreloader[applaunch]", "skip preload runtime, load CommLib get exception %s", Log.getStackTraceString(th));
                    C27310e.access$100();
                } finally {
                    C4990ab.m7416i("MicroMsg.AppBrandProcessPreloader[applaunch]", "misc preload done");
                    C5004al.m7436Ma(10);
                    AppMethodBeat.m2505o(132790);
                }
            }
        });
        AppMethodBeat.m2505o(132805);
    }

    private static void aLO() {
        AppMethodBeat.m2504i(132806);
        if (iEn.size() > 0) {
            AppMethodBeat.m2505o(132806);
            return;
        }
        C38492q c42439b;
        if (iEr == C38519g.WAGAME) {
            c42439b = new C42439b();
        } else {
            c42439b = new C19722s();
        }
        c42439b.mo61195Dw();
        iEn.add(c42439b);
        AppMethodBeat.m2505o(132806);
    }

    /* JADX WARNING: Missing block: B:16:0x005c, code skipped:
            if (r2 == false) goto L_0x0095;
     */
    /* JADX WARNING: Missing block: B:17:0x005e, code skipped:
            com.tencent.p177mm.plugin.appbrand.task.C27310e.m43375b(r9, null);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(132807);
     */
    /* JADX WARNING: Missing block: B:28:0x0095, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(132807);
     */
    /* JADX WARNING: Missing block: B:31:?, code skipped:
            return true;
     */
    /* JADX WARNING: Missing block: B:32:?, code skipped:
            return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static boolean m43374a(C38519g c38519g, C27314a c27314a) {
        AppMethodBeat.m2504i(132807);
        synchronized (C27310e.class) {
            try {
                C4990ab.m7417i("MicroMsg.AppBrandProcessPreloader[applaunch]", "Checking shouldWaitPreloading.. mCurrentPreloadState is [%s] ", iEk.name());
                if (iEk == C27315c.PRELOADING && c38519g == iEr) {
                    iEl.add(c27314a);
                    iEq.iEj = SystemClock.elapsedRealtime();
                } else {
                    boolean z;
                    if (C19742b.aLG()) {
                        if (iEk == C27315c.NOT_PRELOAD) {
                            C4990ab.m7416i("MicroMsg.AppBrandProcessPreloader[applaunch]", "[ForcePreload] wait preload (not preload currently)");
                            iEl.add(c27314a);
                            iEk = C27315c.PRELOADING;
                            z = true;
                        } else if (iEk == C27315c.PRELOADED && (iEr != c38519g || iEn.peek() == null)) {
                            C4990ab.m7416i("MicroMsg.AppBrandProcessPreloader[applaunch]", "[ForcePreload] wait preload (preloaded)");
                            C27310e.reset();
                            iEl.add(c27314a);
                            iEk = C27315c.PRELOADING;
                            z = true;
                        }
                    }
                    z = false;
                }
            } finally {
                AppMethodBeat.m2505o(132807);
            }
        }
        return true;
    }

    public static AppBrandPreloadProfiler aLP() {
        return iEq;
    }

    /* renamed from: a */
    public static C19722s m43370a(String str, C38519g c38519g) {
        long j;
        C27315c c27315c;
        C19722s c19722s = null;
        AppMethodBeat.m2504i(132808);
        C7060h c7060h = C7060h.pYm;
        if (c38519g == C38519g.WAGAME) {
            j = 12;
        } else {
            j = 10;
        }
        c7060h.mo15419k(915, j, 1);
        synchronized (C27310e.class) {
            try {
                c27315c = iEk;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(132808);
            }
        }
        if (c27315c == C27315c.NOT_PRELOAD) {
            C4990ab.m7416i("MicroMsg.AppBrandProcessPreloader[applaunch]", "AppBrandProcessPreloader not preload, just return null");
        } else if (c27315c == C27315c.PRELOADING) {
            if (C5058f.IS_FLAVOR_RED || C5058f.DEBUG) {
                IllegalStateException illegalStateException = new IllegalStateException("getServices when preloading");
                AppMethodBeat.m2505o(132808);
                throw illegalStateException;
            }
            C4990ab.printErrStackTrace("MicroMsg.AppBrandProcessPreloader[applaunch]", new IllegalStateException(), "AppBrandProcessPreloader is preloading when getServices, it need to wait! software fall in panic !", new Object[0]);
            AppMethodBeat.m2505o(132808);
        } else if (!C5046bo.isNullOrNil(str) && str.equals(iEp)) {
            C4990ab.m7417i("MicroMsg.AppBrandProcessPreloader[applaunch]", "CurrentService is occupied req = [%s] cur = [%s]", str, iEp);
            AppMethodBeat.m2505o(132808);
        } else if (c38519g != iEr) {
            C4990ab.m7412e("MicroMsg.AppBrandProcessPreloader[applaunch]", "AppBrandProcessPreloader's ServiceType mismatch when getServices, watch it! But it's ok, just return null.");
            AppMethodBeat.m2505o(132808);
        } else {
            iEp = str;
            c19722s = (C19722s) iEn.poll();
            if (c19722s != null) {
                c7060h = C7060h.pYm;
                if (c38519g == C38519g.WAGAME) {
                    j = 7;
                } else {
                    j = 2;
                }
                c7060h.mo15419k(915, j, 1);
            }
            AppMethodBeat.m2505o(132808);
        }
        return c19722s;
    }

    /* renamed from: DK */
    public static C44709u m43368DK(String str) {
        AppMethodBeat.m2504i(132809);
        if (C5046bo.isNullOrNil(str) || !str.equals(iEo)) {
            iEo = str;
            C44709u c44709u = (C44709u) iEm.poll();
            AppMethodBeat.m2505o(132809);
            return c44709u;
        }
        AppMethodBeat.m2505o(132809);
        return null;
    }

    /* renamed from: Sv */
    private static void m43369Sv() {
        AppMethodBeat.m2504i(132810);
        if (C5004al.isMainThread()) {
            C27310e.done();
            AppMethodBeat.m2505o(132810);
            return;
        }
        C5004al.m7441d(new C197433());
        AppMethodBeat.m2505o(132810);
    }

    private static void done() {
        long j;
        AppMethodBeat.m2504i(132811);
        C4990ab.m7416i("MicroMsg.AppBrandProcessPreloader[applaunch]", "preInit finished");
        iEq.aLL();
        C7060h c7060h = C7060h.pYm;
        if (iEr == C38519g.WAGAME) {
            j = 6;
        } else {
            j = 1;
        }
        c7060h.mo15419k(915, j, 1);
        C27310e.m43372a(iEq, iEr);
        LinkedList<C27314a> linkedList = new LinkedList();
        synchronized (C27310e.class) {
            try {
                iEk = C27315c.PRELOADED;
                linkedList.addAll(iEl);
                iEl.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(132811);
            }
        }
        for (C27314a c27314a : linkedList) {
            if (c27314a != null) {
                c27314a.onReady();
            }
        }
    }

    public static synchronized boolean auw() {
        boolean z;
        synchronized (C27310e.class) {
            z = iEk == C27315c.PRELOADED;
        }
        return z;
    }

    public static synchronized boolean aLQ() {
        boolean z = true;
        synchronized (C27310e.class) {
            AppMethodBeat.m2504i(132812);
            if (C27315c.NOT_PRELOAD == iEk) {
                AppMethodBeat.m2505o(132812);
            } else if (!C27310e.auw() || iEm.size() > 0 || iEn.size() > 0) {
                z = false;
                AppMethodBeat.m2505o(132812);
            } else {
                AppMethodBeat.m2505o(132812);
            }
        }
        return z;
    }

    public static boolean aLR() {
        return iEu;
    }

    /* renamed from: a */
    private static void m43372a(AppBrandPreloadProfiler appBrandPreloadProfiler, C38519g c38519g) {
        AppMethodBeat.m2504i(132813);
        String str = "[PreloadProfile]";
        if (appBrandPreloadProfiler == null) {
            C4990ab.m7412e("MicroMsg.AppBrandProcessPreloader[applaunch]", str + "AppBrandPreloadProfiler == null");
            AppMethodBeat.m2505o(132813);
            return;
        }
        StringBuilder append = new StringBuilder().append(str).append(" ");
        String str2 = "Preload for [%s]Type | ";
        Object[] objArr = new Object[1];
        objArr[0] = c38519g == null ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : c38519g.name();
        StringBuilder append2 = append.append(C5046bo.m7584t(str2, objArr));
        String str3 = "Preload request at [%d] | ";
        Object[] objArr2 = new Object[1];
        objArr2[0] = Long.valueOf(appBrandPreloadProfiler.iEh == Long.MAX_VALUE ? -1 : appBrandPreloadProfiler.iEh);
        C4990ab.m7416i("MicroMsg.AppBrandProcessPreloader[applaunch]", append2.append(C5046bo.m7584t(str3, objArr2)).append(C5046bo.m7584t("Process prepared cost [%s]ms | ", C27310e.m43371a(appBrandPreloadProfiler.iEh, "req", appBrandPreloadProfiler.iEi, "proc"))).append(C5046bo.m7584t("Trans-thread prepared cost [%s]ms | ", C27310e.m43371a(appBrandPreloadProfiler.iEi, "proc", appBrandPreloadProfiler.startTime, "start"))).append(C5046bo.m7584t("Preload prepared cost [%s]ms | ", C27310e.m43371a(appBrandPreloadProfiler.startTime, "start", appBrandPreloadProfiler.endTime, "end"))).append(C5046bo.m7584t("All cost [%s]ms ", C27310e.m43371a(appBrandPreloadProfiler.iEh, "req", appBrandPreloadProfiler.endTime, "end"))).toString());
        AppMethodBeat.m2505o(132813);
    }

    /* renamed from: a */
    private static String m43371a(long j, String str, long j2, String str2) {
        AppMethodBeat.m2504i(132814);
        String t;
        if (j == Long.MAX_VALUE || j2 == Long.MAX_VALUE) {
            String str3 = "Unkown(%s=%s,%s=%s)";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = j == Long.MAX_VALUE ? "?" : "ok";
            objArr[2] = str2;
            objArr[3] = j2 == Long.MAX_VALUE ? "?" : "ok";
            t = C5046bo.m7584t(str3, objArr);
            AppMethodBeat.m2505o(132814);
            return t;
        }
        t = String.valueOf(j2 - j);
        AppMethodBeat.m2505o(132814);
        return t;
    }

    /* renamed from: BK */
    static /* synthetic */ void m43364BK() {
        AppMethodBeat.m2504i(132816);
        C42142a c42142a = C32718b.eGM;
        C5141c ll = C42142a.m74295ll("100413");
        if (ll == null) {
            C4990ab.m7416i("MicroMsg.AppBrandProcessPreloader[applaunch]", "[PreloadWAGameABTest] item is null");
            AppMethodBeat.m2505o(132816);
            return;
        }
        boolean z = ll.isValid() && "1".equals(ll.dru().get("shouldOpen"));
        iEv = z;
        iEw = C5046bo.getInt((String) ll.dru().get("preloadLibVersion"), BaseClientBuilder.API_PRIORITY_OTHER);
        C4990ab.m7417i("MicroMsg.AppBrandProcessPreloader[applaunch]", "[PreloadWAGameABTest] sShouldPreloadWAGame:%b, sPreloadWxCommLibVersion :%d", Boolean.valueOf(iEv), Integer.valueOf(iEw));
        AppMethodBeat.m2505o(132816);
    }

    /* renamed from: BL */
    static /* synthetic */ void m43365BL() {
        int i = 1;
        AppMethodBeat.m2504i(132817);
        if (C26852t.azr()) {
            int i2 = (!iEv || WxaCommLibRuntimeReader.avQ().gVu < iEw) ? 0 : 1;
            C4990ab.m7417i("MicroMsg.AppBrandProcessPreloader[applaunch]", "[PreloadWAGameABTest] checking... sShouldPreloadWAGame: [%b] WxaCommLibRuntimeReader.pkgVersion = [%d], sPreloadWxaCommLibVersion = [%d]", Boolean.valueOf(iEv), Integer.valueOf(r3), Integer.valueOf(iEw));
            if (C19742b.aLG()) {
                C4990ab.m7416i("MicroMsg.AppBrandProcessPreloader[applaunch]", "[PreloadWAGameABTest] forcePreload");
            } else {
                i = i2;
            }
        } else {
            C4990ab.m7416i("MicroMsg.AppBrandProcessPreloader[applaunch]", "[PreloadWAGameABTest] hardcode disable preload for remote debug");
            i = 0;
        }
        if (i == 0) {
            C4990ab.m7416i("MicroMsg.AppBrandProcessPreloader[applaunch]", "preloadNextRuntimeForWAGame disable preload");
            C27310e.m43369Sv();
            AppMethodBeat.m2505o(132817);
            return;
        }
        try {
            C27310e.aLO();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandProcessPreloader[applaunch]", e, "preloadNextRuntimeOnUiThreadForWAGame exception.", new Object[0]);
        }
        C27310e.m43369Sv();
        AppMethodBeat.m2505o(132817);
    }

    /* renamed from: BM */
    static /* synthetic */ void m43366BM() {
        AppMethodBeat.m2504i(132818);
        C42142a c42142a = C32718b.eGM;
        C5141c ll = C42142a.m74295ll("100308");
        if (ll == null) {
            C4990ab.m7416i("MicroMsg.AppBrandProcessPreloader[applaunch]", "initPreloadABTest item is null");
            AppMethodBeat.m2505o(132818);
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
        C4990ab.m7417i("MicroMsg.AppBrandProcessPreloader[applaunch]", "initPreloadABTest close:%b, openDevelopCrt:%b", Boolean.valueOf(iEt), Boolean.valueOf(iEu));
        AppMethodBeat.m2505o(132818);
    }

    static /* synthetic */ void aLT() {
        AppMethodBeat.m2504i(132819);
        C273164 c273164 = new C273164();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            c273164.run();
            AppMethodBeat.m2505o(132819);
            return;
        }
        C5004al.m7441d(c273164);
        AppMethodBeat.m2505o(132819);
    }

    static /* synthetic */ void access$600() {
        boolean z = true;
        AppMethodBeat.m2504i(132820);
        if (!WebView.isSys()) {
            if (WebView.isX5()) {
                if (WebView.getUsingTbsCoreVersion(C4996ah.getContext()) == 0) {
                    C4990ab.m7416i("MicroMsg.AppBrandProcessPreloader[applaunch]", "closeWAServiceClientPreload without x5");
                } else if (!C24544d.canOpenWebPlus(C4996ah.getContext())) {
                    C4990ab.m7416i("MicroMsg.AppBrandProcessPreloader[applaunch]", "closeWAServiceClientPreload can not OpenWebPlus");
                }
            }
            z = iEt;
        }
        if (z) {
            C4990ab.m7416i("MicroMsg.AppBrandProcessPreloader[applaunch]", "preloadNextRuntimeOnUiThreadForWAService disable preload");
            AppMethodBeat.m2505o(132820);
            return;
        }
        C4990ab.m7416i("MicroMsg.AppBrandProcessPreloader[applaunch]", "preloadNextRuntimeOnUiThreadForWAService");
        C5004al.m7436Ma(-8);
        try {
            C27310e.aLO();
            if (iEm.size() <= 0 && iEr != C38519g.WAGAME) {
                C27242w c27242w = new C27242w();
                c27242w.mo71746Dw();
                iEm.add(c27242w);
            }
            AppMethodBeat.m2505o(132820);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandProcessPreloader[applaunch]", th, "preloadNextRuntimeOnUiThreadForWAService exception.", new Object[0]);
            if (C5047bp.dpL()) {
                AppMethodBeat.m2505o(132820);
            } else {
                AppMethodBeat.m2505o(132820);
            }
        }
    }
}
