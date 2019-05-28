package com.tencent.mm.plugin.appbrand;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.luggage.g.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.d;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.l.g;
import com.tencent.mm.plugin.appbrand.l.l;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.s.w;
import com.tencent.mm.plugin.appbrand.widget.b.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.WebView;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;

public class i implements com.tencent.mm.vending.e.b {
    volatile boolean Pf;
    public volatile boolean eMP;
    i gNA;
    public volatile AppBrandInitConfig gNB;
    volatile q gNC;
    volatile q gND;
    public com.tencent.mm.plugin.appbrand.widget.c gNE;
    com.tencent.mm.plugin.appbrand.ui.q gNF;
    public e gNG;
    private volatile p gNH = null;
    public final ConcurrentLinkedDeque<j> gNI = new ConcurrentLinkedDeque();
    private final LinkedHashSet<k> gNJ = new LinkedHashSet();
    volatile d gNK = new d();
    private com.tencent.mm.plugin.appbrand.s.d gNL;
    public m gNM;
    public volatile com.tencent.mm.plugin.appbrand.b.c gNN;
    public com.tencent.mm.plugin.appbrand.j.a gNO;
    boolean gNP;
    boolean gNQ;
    public boolean gNR;
    public boolean gNS = false;
    public boolean gNT = true;
    private Set<android.support.v4.app.a.a> gNU = Collections.newSetFromMap(new ConcurrentHashMap());
    boolean gNV = false;
    private final Set<com.tencent.mm.vending.e.a> gNW = new CopyOnWriteArraySet();
    LinkedList<b> gNX = new LinkedList();
    private com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a gNY = new com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a() {
        private boolean gOd = false;

        public final void ats() {
            AppMethodBeat.i(86654);
            if (this.gOd) {
                i.c(i.this);
            }
            this.gOd = false;
            AppMethodBeat.o(86654);
        }

        public final void att() {
            this.gOd = true;
        }
    };
    Runnable gNZ = new Runnable() {
        public final void run() {
            AppMethodBeat.i(86655);
            i.this.atf();
            AppMethodBeat.o(86655);
        }
    };
    Activity gNy;
    public ab gNz;
    private final Deque<Runnable> gOa = new LinkedBlockingDeque();
    public volatile String mAppId;
    public volatile boolean mFinished;
    Handler mHandler;

    /* renamed from: com.tencent.mm.plugin.appbrand.i$8 */
    class AnonymousClass8 implements a {
        final /* synthetic */ ConcurrentLinkedQueue gOi;
        final /* synthetic */ b gOj;
        final /* synthetic */ a gOk;

        AnonymousClass8(ConcurrentLinkedQueue concurrentLinkedQueue, b bVar, a aVar) {
            this.gOi = concurrentLinkedQueue;
            this.gOj = bVar;
            this.gOk = aVar;
        }

        public final void done() {
            AppMethodBeat.i(86659);
            if (this.gOi.remove(this.gOj)) {
                if (this.gOi.isEmpty()) {
                    this.gOk.done();
                }
                AppMethodBeat.o(86659);
                return;
            }
            ab.e("MicroMsg.AppBrandRuntime", "[%s]prepare duplicate ready() called", i.this.mAppId);
            AppMethodBeat.o(86659);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.i$10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ int gOm;

        AnonymousClass10(int i) {
            this.gOm = i;
        }

        public final void run() {
            AppMethodBeat.i(86661);
            if (i.this.gNF != null) {
                i.this.gNF.setProgress(this.gOm);
            }
            AppMethodBeat.o(86661);
        }
    }

    class c implements a, com.tencent.mm.vending.e.a {
        private boolean gOp;

        private c() {
            AppMethodBeat.i(86666);
            i.this.keep(this);
            this.gOp = false;
            AppMethodBeat.o(86666);
        }

        /* synthetic */ c(i iVar, byte b) {
            this();
        }

        public final void done() {
            AppMethodBeat.i(86667);
            if (!this.gOp) {
                i iVar = i.this;
                if (!iVar.mFinished) {
                    if (iVar.eMP) {
                        ab.e("MicroMsg.AppBrandRuntime", "initRuntime, mInitialized TRUE !!!  go check callee %s", bo.l(new Throwable()));
                        AppMethodBeat.o(86667);
                        return;
                    }
                    ab.d("MicroMsg.AppBrandRuntime", "initRuntime %s", iVar.mAppId);
                    new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(86662);
                            if (i.this.mFinished) {
                                AppMethodBeat.o(86662);
                                return;
                            }
                            i.a(i.this);
                            i.this.eMP = true;
                            i iVar = i.this;
                            iVar.mHandler.removeCallbacks(iVar.gNZ);
                            AppMethodBeat.o(86662);
                        }
                    }.run();
                }
            }
            AppMethodBeat.o(86667);
        }

        public final void dead() {
            this.gOp = true;
        }
    }

    interface a {
        void done();
    }

    public static abstract class b {
        a gOo;

        public abstract void prepare();

        public final void wL() {
            if (this.gOo != null) {
                this.gOo.done();
            }
        }
    }

    public i(Activity activity, ab abVar) {
        AppMethodBeat.i(86668);
        this.gNy = activity;
        this.gNz = abVar;
        this.mHandler = new Handler();
        this.gNE = new com.tencent.mm.plugin.appbrand.widget.c(activity);
        this.gNE.setLayoutParams(new LayoutParams(-1, -1));
        this.gNL = new com.tencent.mm.plugin.appbrand.s.d();
        this.gNM = new m();
        AppMethodBeat.o(86668);
    }

    public final void keep(com.tencent.mm.vending.e.a aVar) {
        AppMethodBeat.i(86669);
        if (aVar != null) {
            this.gNW.add(aVar);
        }
        AppMethodBeat.o(86669);
    }

    /* Access modifiers changed, original: protected|final */
    public final void c(AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(86670);
        if (appBrandInitConfig == null) {
            ab.i("MicroMsg.AppBrandRuntime", "null current config, ignored");
            AppMethodBeat.o(86670);
            return;
        }
        this.gNB = appBrandInitConfig;
        this.mAppId = appBrandInitConfig.appId;
        this.gNN = new com.tencent.mm.plugin.appbrand.b.c(this);
        this.gNN.gWy.start();
        this.gNN.a(new com.tencent.mm.plugin.appbrand.b.c.a() {
            public final void a(String str, com.tencent.mm.plugin.appbrand.b.b bVar) {
                Object obj;
                AppMethodBeat.i(86651);
                i iVar = i.this;
                HashMap hashMap = new HashMap();
                switch (com.tencent.mm.plugin.appbrand.page.j.AnonymousClass1.gWN[bVar.ordinal()]) {
                    case 1:
                        obj = "background";
                        break;
                    case 2:
                        obj = "active";
                        break;
                    case 3:
                        obj = "suspend";
                        break;
                    default:
                        AppMethodBeat.o(86651);
                        return;
                }
                hashMap.put("status", obj);
                new com.tencent.mm.plugin.appbrand.page.j().t(hashMap).i(iVar.xT()).aCj();
                AppMethodBeat.o(86651);
            }
        });
        this.gNG = new e(this.gNy);
        ab.i("MicroMsg.AppBrandRuntime", "init %s, config %s", this.mAppId, this.gNB);
        this.eMP = false;
        this.mFinished = false;
        this.Pf = false;
        this.gNP = false;
        this.gNQ = false;
        this.gNR = false;
        AppMethodBeat.o(86670);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(b bVar) {
        AppMethodBeat.i(86672);
        this.gNX.add(bVar);
        AppMethodBeat.o(86672);
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0034  */
    /* JADX WARNING: Missing block: B:12:0x0043, code skipped:
            if (r7.gVs == r6.gNB.gVs) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(AppBrandInitConfig appBrandInitConfig) {
        int i = 1;
        AppMethodBeat.i(86673);
        if (this.eMP) {
            ab.d("MicroMsg.AppBrandRuntime", "updateConfig %s", appBrandInitConfig);
            if (appBrandInitConfig != null) {
                if (this.gNR) {
                    this.gNR = false;
                }
                if (i != 0) {
                    atn();
                }
                this.gNB = appBrandInitConfig;
                AppMethodBeat.o(86673);
                return;
            }
            i = 0;
            if (i != 0) {
            }
            this.gNB = appBrandInitConfig;
            AppMethodBeat.o(86673);
            return;
        }
        ab.d("MicroMsg.AppBrandRuntime", "updateConfig %s, not initialized", appBrandInitConfig);
        AppMethodBeat.o(86673);
    }

    public final String getAppId() {
        return this.mAppId;
    }

    public final int asT() {
        return this.gNB.gVs;
    }

    public final i asU() {
        AppMethodBeat.i(86674);
        i d = this.gNz.d(this);
        AppMethodBeat.o(86674);
        return d;
    }

    public q xT() {
        return this.gNC;
    }

    public q asV() {
        return this.gND;
    }

    public Activity getContext() {
        return this.gNy;
    }

    public AppBrandInitConfig yf() {
        return this.gNB;
    }

    public h ye() {
        AppMethodBeat.i(86675);
        h hVar = (h) aa(h.class);
        AppMethodBeat.o(86675);
        return hVar;
    }

    public final com.tencent.mm.plugin.appbrand.config.a getAppConfig() {
        AppMethodBeat.i(86676);
        com.tencent.mm.plugin.appbrand.config.a aVar = (com.tencent.mm.plugin.appbrand.config.a) c(com.tencent.mm.plugin.appbrand.config.a.class, false);
        AppMethodBeat.o(86676);
        return aVar;
    }

    public final com.tencent.mm.plugin.appbrand.b.c asW() {
        return this.gNN;
    }

    /* Access modifiers changed, original: protected */
    public com.tencent.mm.plugin.appbrand.j.a asX() {
        AppMethodBeat.i(86678);
        com.tencent.mm.plugin.appbrand.j.a.c cVar = new com.tencent.mm.plugin.appbrand.j.a.c();
        AppMethodBeat.o(86678);
        return cVar;
    }

    public p asE() {
        return this.gNH;
    }

    public final void asY() {
        AppMethodBeat.i(86679);
        if (this.gNH == null) {
            this.gNH = asZ();
        }
        AppMethodBeat.o(86679);
    }

    /* Access modifiers changed, original: protected */
    public p asZ() {
        AppMethodBeat.i(86680);
        t tVar = new t(this);
        AppMethodBeat.o(86680);
        return tVar;
    }

    /* Access modifiers changed, original: protected */
    public com.tencent.mm.plugin.appbrand.ui.q ata() {
        return null;
    }

    public final String atc() {
        AppMethodBeat.i(86682);
        String str;
        if (this.gNB == null) {
            str = "";
            AppMethodBeat.o(86682);
            return str;
        } else if (!bo.isNullOrNil(this.gNB.hgC)) {
            str = this.gNB.hgC;
            AppMethodBeat.o(86682);
            return str;
        } else if (getAppConfig() == null) {
            str = "";
            AppMethodBeat.o(86682);
            return str;
        } else {
            str = getAppConfig().ayw();
            AppMethodBeat.o(86682);
            return str;
        }
    }

    public final <T extends j> T c(Class<T> cls, boolean z) {
        T t;
        AppMethodBeat.i(86683);
        T t2 = null;
        Iterator descendingIterator = this.gNI.descendingIterator();
        while (descendingIterator.hasNext()) {
            t = (j) descendingIterator.next();
            if (cls.isInstance(t)) {
                t2 = t;
                break;
            }
        }
        if (t2 == null && z) {
            try {
                t = (j) cls.newInstance();
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrandRuntime", "Make sure %s has default constructor", cls.getName());
            }
            AppMethodBeat.o(86683);
            return t;
        }
        t = t2;
        AppMethodBeat.o(86683);
        return t;
    }

    public final <T extends j> T aa(Class<T> cls) {
        AppMethodBeat.i(86684);
        j c = c(cls, !this.gNV);
        AppMethodBeat.o(86684);
        return c;
    }

    public final <T extends k> T ab(Class<T> cls) {
        k kVar;
        AppMethodBeat.i(86685);
        synchronized (this.gNJ) {
            try {
                Iterator it = this.gNJ.iterator();
                while (it.hasNext()) {
                    kVar = (k) it.next();
                    if (cls.isInstance(kVar)) {
                    }
                }
                AppMethodBeat.o(86685);
                return null;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(86685);
            }
        }
        return kVar;
    }

    public final boolean a(k kVar) {
        AppMethodBeat.i(86686);
        synchronized (this.gNJ) {
            try {
                this.gNJ.add(kVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(86686);
            }
        }
        return true;
    }

    public final <T extends com.tencent.mm.kernel.c.a> T K(Class<T> cls) {
        AppMethodBeat.i(86687);
        com.tencent.mm.kernel.c.a U = this.gNK.U(cls);
        AppMethodBeat.o(86687);
        return U;
    }

    public final <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> cls, N n) {
        AppMethodBeat.i(86688);
        this.gNK.a(cls, n);
        AppMethodBeat.o(86688);
    }

    @Deprecated
    public Looper atd() {
        AppMethodBeat.i(86689);
        Looper mainLooper = Looper.getMainLooper();
        AppMethodBeat.o(86689);
        return mainLooper;
    }

    public final boolean finished() {
        return this.mFinished;
    }

    public final boolean ate() {
        return this.eMP;
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
    }

    /* Access modifiers changed, original: protected */
    public void atf() {
    }

    /* Access modifiers changed, original: protected */
    public void yb() {
    }

    /* Access modifiers changed, original: protected */
    public void atg() {
    }

    /* Access modifiers changed, original: protected */
    public q ath() {
        AppMethodBeat.i(86690);
        q qVar = new q();
        AppMethodBeat.o(86690);
        return qVar;
    }

    /* Access modifiers changed, original: protected */
    public q ati() {
        AppMethodBeat.i(86691);
        q qVar = new q(getContext(), this);
        AppMethodBeat.o(86691);
        return qVar;
    }

    /* Access modifiers changed, original: protected */
    public void onCreate() {
    }

    public boolean atj() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void onReady() {
    }

    /* Access modifiers changed, original: final */
    public final void atk() {
        AppMethodBeat.i(86692);
        if (!this.eMP) {
            AppMethodBeat.o(86692);
        } else if (this.mFinished) {
            AppMethodBeat.o(86692);
        } else {
            ab.i("MicroMsg.AppBrandRuntime", "onPause: %s", this.mAppId);
            onPause();
            this.gNN.gWy.nt(1);
            this.gNC.atW();
            this.gND.wW();
            g.wP(this.mAppId);
            g.a(this.mAppId, com.tencent.mm.plugin.appbrand.g.b.ON_PAUSE);
            ab.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onPause");
            try {
                bc.a(ah.getContext(), null);
                AppMethodBeat.o(86692);
            } catch (SecurityException e) {
                ab.printErrStackTrace("MicroMsg.AppBrandUserCaptureScreenMonitor", e, "[NOT CRASH] pause set null callback", new Object[0]);
                AppMethodBeat.o(86692);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
    }

    /* Access modifiers changed, original: final */
    public final void atl() {
        AppMethodBeat.i(86693);
        if (this.eMP) {
            ab.i("MicroMsg.AppBrandRuntime", "onResume: %s", this.mAppId);
            if (this.mFinished || this.gNP) {
                d(null);
                AppMethodBeat.o(86693);
                return;
            }
            g.wU(this.mAppId);
            g.wQ(this.mAppId);
            g.a(this.mAppId, com.tencent.mm.plugin.appbrand.g.b.ON_RESUME);
            onResume();
            this.gND.wU();
            this.gNN.gWy.nt(3);
            final boolean z = this.gNQ;
            this.gNE.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(86665);
                    i.this.gNC.dw(z);
                    if (z) {
                        i iVar = i.this;
                        iVar.gND.af(iVar.atc(), true);
                    }
                    AppMethodBeat.o(86665);
                }
            });
            com.tencent.mm.plugin.appbrand.s.d dVar = this.gNL;
            ab.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onResume");
            try {
                bc.a(ah.getContext(), dVar.iRh);
            } catch (SecurityException e) {
                ab.printErrStackTrace("MicroMsg.AppBrandUserCaptureScreenMonitor", e, "[NOT CRASH] resume set callback", new Object[0]);
            }
            atq();
            this.gNP = false;
            this.gNQ = false;
            AppMethodBeat.o(86693);
            return;
        }
        AppMethodBeat.o(86693);
    }

    /* Access modifiers changed, original: protected */
    public void onResume() {
    }

    /* Access modifiers changed, original: protected */
    public void atm() {
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
    }

    public final void cleanup() {
        AppMethodBeat.i(86694);
        ab.i("MicroMsg.AppBrandRuntime", "dl: cleanup, finished?[%b] initialized?[%b]", Boolean.valueOf(this.mFinished), Boolean.valueOf(this.eMP));
        if (this.mFinished) {
            AppMethodBeat.o(86694);
            return;
        }
        Iterator it;
        this.mFinished = true;
        ab.i("MicroMsg.AppBrandRuntime", "onDestroy: %s", this.mAppId);
        onDestroy();
        for (com.tencent.mm.vending.e.a dead : this.gNW) {
            dead.dead();
        }
        this.gNW.clear();
        this.gNH = null;
        AppBrandMainProcessService.b(this.gNY);
        MMToClientEvent.f(this.gNC);
        g.wO(this.mAppId);
        g.a(this.mAppId, com.tencent.mm.plugin.appbrand.g.b.ON_DESTROY);
        f.az(getContext());
        com.tencent.mm.plugin.appbrand.b.c cVar = this.gNN;
        com.tencent.mm.plugin.appbrand.b.d dVar = cVar.gWy;
        dVar.gWG.set(true);
        com.tencent.mm.sdk.d.d.c cVar2 = dVar.xCt;
        if (cVar2 != null) {
            com.tencent.mm.sdk.d.d.c.f(cVar2);
        }
        dVar.a(com.tencent.mm.plugin.appbrand.b.b.DESTROYED);
        synchronized (cVar.gWz) {
            try {
                cVar.gWz.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(86694);
            }
        }
        com.tencent.mm.plugin.appbrand.l.f aIE = com.tencent.mm.plugin.appbrand.l.f.aIE();
        String str = this.mAppId;
        if (aIE.hGk.containsKey(str)) {
            aIE.hGk.remove(str);
        }
        com.tencent.mm.plugin.appbrand.l.c aIB = com.tencent.mm.plugin.appbrand.l.c.aIB();
        str = this.mAppId;
        if (aIB.hGk.containsKey(str)) {
            com.tencent.mm.plugin.appbrand.l.b bVar = (com.tencent.mm.plugin.appbrand.l.b) aIB.hGk.remove(str);
            synchronized (bVar.iov) {
                try {
                    it = bVar.iov.iterator();
                    while (it.hasNext()) {
                        ((com.tencent.mm.plugin.appbrand.l.a.b) it.next()).isRunning = false;
                    }
                    bVar.iov.clear();
                } catch (Throwable th) {
                    AppMethodBeat.o(86694);
                }
            }
        }
        com.tencent.mm.plugin.appbrand.l.i aIG = com.tencent.mm.plugin.appbrand.l.i.aIG();
        str = this.mAppId;
        if (aIG.hGk.containsKey(str)) {
            g gVar = (g) aIG.hGk.remove(str);
            synchronized (gVar.ioU) {
                try {
                    it = gVar.ioU.iterator();
                    while (it.hasNext()) {
                        ((com.tencent.mm.plugin.appbrand.l.h) it.next()).isRunning = false;
                    }
                    gVar.ioU.clear();
                } catch (Throwable th2) {
                    AppMethodBeat.o(86694);
                }
            }
        }
        l aII = l.aII();
        str = this.mAppId;
        if (aII.hGk.containsKey(str)) {
            com.tencent.mm.plugin.appbrand.jsapi.websocket.d dVar2 = (com.tencent.mm.plugin.appbrand.jsapi.websocket.d) aII.hGk.remove(str);
            if (dVar2 != null) {
                dVar2.release();
            }
        }
        g.wT(this.mAppId);
        if (this.eMP) {
            this.gNC.cleanup();
            this.gND.cleanup();
        }
        this.gNE.removeAllViews();
        this.gNE.setOnHierarchyChangeListener(null);
        this.gNI.clear();
        synchronized (this.gNJ) {
            try {
                this.gNJ.clear();
            } catch (Throwable th3) {
                while (true) {
                    AppMethodBeat.o(86694);
                }
            }
        }
        this.gNK = new d();
        this.gOa.clear();
    }

    public final void finish() {
        AppMethodBeat.i(86695);
        this.Pf = true;
        f.az(this.gNy);
        this.gNy.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(86652);
                i iVar = i.this;
                iVar.gNz.f(iVar);
                AppMethodBeat.o(86652);
            }
        });
        AppMethodBeat.o(86695);
    }

    public final void a(AppBrandInitConfig appBrandInitConfig, MiniProgramNavigationBackResult miniProgramNavigationBackResult) {
        String str = null;
        AppMethodBeat.i(86696);
        AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        appBrandLaunchReferrer.appId = appBrandInitConfig.appId;
        appBrandLaunchReferrer.hgQ = 3;
        appBrandLaunchReferrer.cFM = miniProgramNavigationBackResult == null ? null : miniProgramNavigationBackResult.gQt.toString();
        if (miniProgramNavigationBackResult != null) {
            str = miniProgramNavigationBackResult.gQu.toString();
        }
        appBrandLaunchReferrer.hgR = str;
        this.gNB.hgF.a(appBrandLaunchReferrer);
        b(appBrandInitConfig);
        AppMethodBeat.o(86696);
    }

    /* Access modifiers changed, original: protected */
    public void b(AppBrandInitConfig appBrandInitConfig) {
    }

    /* Access modifiers changed, original: protected */
    public void d(AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(138229);
        cleanup();
        if (appBrandInitConfig == null) {
            appBrandInitConfig = yf();
        }
        c(appBrandInitConfig);
        asS();
        ab.i("MicroMsg.AppBrandRuntime", "reload: %s", this.mAppId);
        AppMethodBeat.o(138229);
    }

    public void close() {
        AppMethodBeat.i(86698);
        f.az(getContext());
        a(null);
        AppMethodBeat.o(86698);
    }

    public final void a(final MiniProgramNavigationBackResult miniProgramNavigationBackResult) {
        AppMethodBeat.i(86699);
        if (this.gNy == null) {
            AppMethodBeat.o(86699);
            return;
        }
        this.gNy.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(86653);
                if (!i.this.eMP || i.this.mFinished) {
                    i.this.gNz.f(i.this);
                    AppMethodBeat.o(86653);
                    return;
                }
                i.this.gNz.a(i.this, miniProgramNavigationBackResult);
                AppMethodBeat.o(86653);
            }
        });
        AppMethodBeat.o(86699);
    }

    /* Access modifiers changed, original: protected|final */
    public final void atn() {
        AppMethodBeat.i(86700);
        this.gNP = true;
        ab.d("MicroMsg.AppBrandRuntime", "setWillRestart");
        AppMethodBeat.o(86700);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean ato() {
        AppMethodBeat.i(86701);
        if (!this.gNT) {
            AppMethodBeat.o(86701);
            return false;
        } else if (this.gNy != null && this.gNy.isFinishing()) {
            AppMethodBeat.o(86701);
            return false;
        } else if (this.gND == null || this.gND.getCurrentPage() == null || this.gND.getCurrentPage().mSwiping) {
            AppMethodBeat.o(86701);
            return false;
        } else {
            AppMethodBeat.o(86701);
            return true;
        }
    }

    public final void atp() {
        AppMethodBeat.i(86702);
        this.gNN.gWy.nt(12);
        AppMethodBeat.o(86702);
    }

    /* Access modifiers changed, original: protected */
    @TargetApi(21)
    public void atq() {
        AppMethodBeat.i(86703);
        if (VERSION.SDK_INT < 21) {
            AppMethodBeat.o(86703);
            return;
        }
        TaskDescription taskDescription;
        if (getAppConfig() == null) {
            taskDescription = new TaskDescription(yf().cwz);
        } else {
            taskDescription = new TaskDescription(yf().cwz, null, w.bx(getAppConfig().heS.hfw, WebView.NIGHT_MODE_COLOR));
        }
        this.gNy.setTaskDescription(taskDescription);
        com.tencent.mm.modelappbrand.a.b.abR().a(new com.tencent.mm.modelappbrand.a.b.b() {
            public final void x(Bitmap bitmap) {
                AppMethodBeat.i(86656);
                i.this.gNy.setTaskDescription(new TaskDescription(taskDescription.getLabel(), bitmap, taskDescription.getPrimaryColor()));
                AppMethodBeat.o(86656);
            }
        }, yf().iconUrl, com.tencent.mm.modelappbrand.a.f.fqH);
        AppMethodBeat.o(86703);
    }

    public final boolean atr() {
        AppMethodBeat.i(86704);
        if (this.gNN.gWy.awz() == com.tencent.mm.plugin.appbrand.b.b.SUSPEND) {
            cleanup();
            AppMethodBeat.o(86704);
            return true;
        }
        AppMethodBeat.o(86704);
        return false;
    }

    public final void B(Runnable runnable) {
        AppMethodBeat.i(86706);
        if (runnable == null) {
            AppMethodBeat.o(86706);
        } else if (this.mFinished) {
            AppMethodBeat.o(86706);
        } else {
            com.tencent.mm.plugin.appbrand.s.p O = com.tencent.mm.plugin.appbrand.s.p.O(runnable);
            keep(O);
            this.gNy.runOnUiThread(O);
            AppMethodBeat.o(86706);
        }
    }

    public final void asS() {
        View view;
        AppMethodBeat.i(86671);
        if (this.gNF != null) {
            atb();
        }
        com.tencent.mm.plugin.appbrand.ui.q ata = ata();
        if (ata != null) {
            final View view2 = ata.getView();
            this.gNE.addView(view2, -1, -1);
            this.gNF = ata;
            view2.setClickable(true);
            this.gNE.setOnHierarchyChangeListener(new OnHierarchyChangeListener() {
                public final void onChildViewAdded(View view, View view2) {
                }

                public final void onChildViewRemoved(View view, View view2) {
                    AppMethodBeat.i(86660);
                    if (view2 == view2 && !i.this.mFinished) {
                        i.this.asV().setActuallyVisible(true);
                    }
                    AppMethodBeat.o(86660);
                }
            });
        }
        ab.i("MicroMsg.AppBrandRuntime", "appOnCreate: %s, %s", this.gNB.cwz, this.gNB.appId);
        AppBrandMainProcessService.a(this.gNY);
        n.wX(this.mAppId);
        a(com.tencent.mm.plugin.appbrand.jsapi.base.f.class, new z());
        a(com.tencent.mm.plugin.appbrand.networking.b.class, new com.tencent.mm.plugin.appbrand.networking.d(this));
        a(com.tencent.mm.plugin.appbrand.widget.g.class, com.tencent.mm.plugin.appbrand.widget.g.iUd);
        a(com.tencent.mm.plugin.appbrand.d.b.class, new com.tencent.mm.plugin.appbrand.luggage.b.m(this));
        a(com.tencent.mm.plugin.appbrand.d.a.class, new com.tencent.mm.plugin.appbrand.luggage.b.k(this));
        onCreate();
        this.gNN.gWy.nt(3);
        g.wU(this.mAppId);
        g.wN(this.mAppId);
        g.a(this.mAppId, com.tencent.mm.plugin.appbrand.g.b.ON_CREATE);
        atq();
        final c cVar = new c(this, (byte) 0);
        if (this.gNF == null) {
            view = this.gNE;
        } else {
            view = this.gNF.getView();
        }
        view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public final boolean onPreDraw() {
                AppMethodBeat.i(86658);
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                view.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(86657);
                        i iVar = i.this;
                        c cVar = cVar;
                        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue(iVar.gNX);
                        iVar.gNX = new LinkedList();
                        Iterator it = concurrentLinkedQueue.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) it.next();
                            bVar.gOo = new AnonymousClass8(concurrentLinkedQueue, bVar, cVar);
                            bVar.prepare();
                        }
                        AppMethodBeat.o(86657);
                    }
                });
                AppMethodBeat.o(86658);
                return true;
            }
        });
        this.mHandler.postDelayed(this.gNZ, 10000);
        AppMethodBeat.o(86671);
    }

    public final void a(com.tencent.mm.plugin.appbrand.config.a aVar) {
        AppMethodBeat.i(86677);
        this.gNI.add(aVar);
        AppMethodBeat.o(86677);
    }

    public final void atb() {
        AppMethodBeat.i(86681);
        if (this.mFinished) {
            this.gNF = null;
            AppMethodBeat.o(86681);
        } else if (this.gNF == null) {
            ab.e("MicroMsg.AppBrandRuntime", "hideSplash, splash view null");
            AppMethodBeat.o(86681);
        } else {
            this.gNF.aHS();
            this.gNF = null;
            AppMethodBeat.o(86681);
        }
    }

    public final void A(Runnable runnable) {
        AppMethodBeat.i(86705);
        if (this.Pf || this.mFinished) {
            ab.w("MicroMsg.AppBrandRuntime", "runOnRuntimeReady runtime[%s] finishing, stack %s", this.mAppId, Log.getStackTraceString(new Throwable()));
            AppMethodBeat.o(86705);
        } else if (this.eMP) {
            this.gNy.runOnUiThread(runnable);
            AppMethodBeat.o(86705);
        } else {
            this.gOa.offerLast(runnable);
            AppMethodBeat.o(86705);
        }
    }
}
