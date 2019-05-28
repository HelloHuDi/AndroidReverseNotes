package com.tencent.p177mm.plugin.appbrand;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.p057v4.app.C6184a.C0315a;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.luggage.p147g.C8873f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.kernel.p242c.C1698d;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C26433b;
import com.tencent.p177mm.modelappbrand.p873a.C42201f;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33185b;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19092p;
import com.tencent.p177mm.plugin.appbrand.appstorage.C36710t;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.p177mm.plugin.appbrand.config.C16597h;
import com.tencent.p177mm.plugin.appbrand.config.C38163a;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService.C2172a;
import com.tencent.p177mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10441j;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10442k;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C10333f;
import com.tencent.p177mm.plugin.appbrand.jsapi.websocket.C10562d;
import com.tencent.p177mm.plugin.appbrand.luggage.p908b.C38433m;
import com.tencent.p177mm.plugin.appbrand.luggage.p908b.C44704k;
import com.tencent.p177mm.plugin.appbrand.networking.C19614d;
import com.tencent.p177mm.plugin.appbrand.networking.C42638b;
import com.tencent.p177mm.plugin.appbrand.p1219d.C19162a;
import com.tencent.p177mm.plugin.appbrand.p1219d.C33139b;
import com.tencent.p177mm.plugin.appbrand.p281b.C10136c;
import com.tencent.p177mm.plugin.appbrand.p281b.C10136c.C10137a;
import com.tencent.p177mm.plugin.appbrand.p281b.C26788d;
import com.tencent.p177mm.plugin.appbrand.p281b.C45524b;
import com.tencent.p177mm.plugin.appbrand.p298j.C42458a;
import com.tencent.p177mm.plugin.appbrand.p298j.C42458a.C42459c;
import com.tencent.p177mm.plugin.appbrand.p321l.C10567c;
import com.tencent.p177mm.plugin.appbrand.p321l.C19546l;
import com.tencent.p177mm.plugin.appbrand.p321l.C27146b;
import com.tencent.p177mm.plugin.appbrand.p321l.C42598f;
import com.tencent.p177mm.plugin.appbrand.p321l.C42599g;
import com.tencent.p177mm.plugin.appbrand.p321l.C42600h;
import com.tencent.p177mm.plugin.appbrand.p321l.C42601i;
import com.tencent.p177mm.plugin.appbrand.p321l.p1537a.C38413b;
import com.tencent.p177mm.plugin.appbrand.p329s.C10732w;
import com.tencent.p177mm.plugin.appbrand.p329s.C19719p;
import com.tencent.p177mm.plugin.appbrand.p329s.C45684d;
import com.tencent.p177mm.plugin.appbrand.p336ui.C27333q;
import com.tencent.p177mm.plugin.appbrand.page.C27229m;
import com.tencent.p177mm.plugin.appbrand.page.C38470q;
import com.tencent.p177mm.plugin.appbrand.page.C38470q.C38469b;
import com.tencent.p177mm.plugin.appbrand.page.C42647j;
import com.tencent.p177mm.plugin.appbrand.page.C42647j.C426461;
import com.tencent.p177mm.plugin.appbrand.widget.C10979g;
import com.tencent.p177mm.plugin.appbrand.widget.C45713c;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C2514e;
import com.tencent.p177mm.sdk.p602d.C4887d.C4890c;
import com.tencent.p177mm.sdk.platformtools.C30292bc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p639e.C5684a;
import com.tencent.p177mm.vending.p639e.C5685b;
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

/* renamed from: com.tencent.mm.plugin.appbrand.i */
public class C6750i implements C5685b {
    /* renamed from: Pf */
    volatile boolean f1966Pf;
    public volatile boolean eMP;
    C6750i gNA;
    public volatile AppBrandInitConfig gNB;
    volatile C38492q gNC;
    volatile C38470q gND;
    public C45713c gNE;
    C27333q gNF;
    public C2514e gNG;
    private volatile C19092p gNH = null;
    public final ConcurrentLinkedDeque<C10441j> gNI = new ConcurrentLinkedDeque();
    private final LinkedHashSet<C10442k> gNJ = new LinkedHashSet();
    volatile C1698d gNK = new C1698d();
    private C45684d gNL;
    public C27229m gNM;
    public volatile C10136c gNN;
    public C42458a gNO;
    boolean gNP;
    boolean gNQ;
    public boolean gNR;
    public boolean gNS = false;
    public boolean gNT = true;
    private Set<C0315a> gNU = Collections.newSetFromMap(new ConcurrentHashMap());
    boolean gNV = false;
    private final Set<C5684a> gNW = new CopyOnWriteArraySet();
    LinkedList<C6764b> gNX = new LinkedList();
    private C2172a gNY = new C67624();
    Runnable gNZ = new C67665();
    Activity gNy;
    public C26719ab gNz;
    private final Deque<Runnable> gOa = new LinkedBlockingDeque();
    public volatile String mAppId;
    public volatile boolean mFinished;
    Handler mHandler;

    /* renamed from: com.tencent.mm.plugin.appbrand.i$1 */
    class C21701 implements C10137a {
        C21701() {
        }

        /* renamed from: a */
        public final void mo6006a(String str, C45524b c45524b) {
            Object obj;
            AppMethodBeat.m2504i(86651);
            C6750i c6750i = C6750i.this;
            HashMap hashMap = new HashMap();
            switch (C426461.gWN[c45524b.ordinal()]) {
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
                    AppMethodBeat.m2505o(86651);
                    return;
            }
            hashMap.put("status", obj);
            new C42647j().mo34958t(hashMap).mo61031i(c6750i.mo15032xT()).aCj();
            AppMethodBeat.m2505o(86651);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.i$2 */
    class C21712 implements Runnable {
        C21712() {
        }

        public final void run() {
            AppMethodBeat.m2504i(86652);
            C6750i c6750i = C6750i.this;
            c6750i.gNz.mo44514f(c6750i);
            AppMethodBeat.m2505o(86652);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.i$12 */
    class C675112 implements C38469b {
        C675112() {
        }

        public final void atu() {
            AppMethodBeat.m2504i(86663);
            C6750i.m11182b(C6750i.this);
            AppMethodBeat.m2505o(86663);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.i$8 */
    class C67528 implements C6761a {
        final /* synthetic */ ConcurrentLinkedQueue gOi;
        final /* synthetic */ C6764b gOj;
        final /* synthetic */ C6761a gOk;

        C67528(ConcurrentLinkedQueue concurrentLinkedQueue, C6764b c6764b, C6761a c6761a) {
            this.gOi = concurrentLinkedQueue;
            this.gOj = c6764b;
            this.gOk = c6761a;
        }

        public final void done() {
            AppMethodBeat.m2504i(86659);
            if (this.gOi.remove(this.gOj)) {
                if (this.gOi.isEmpty()) {
                    this.gOk.done();
                }
                AppMethodBeat.m2505o(86659);
                return;
            }
            C4990ab.m7413e("MicroMsg.AppBrandRuntime", "[%s]prepare duplicate ready() called", C6750i.this.mAppId);
            AppMethodBeat.m2505o(86659);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.i$10 */
    class C675410 implements Runnable {
        final /* synthetic */ int gOm;

        C675410(int i) {
            this.gOm = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(86661);
            if (C6750i.this.gNF != null) {
                C6750i.this.gNF.setProgress(this.gOm);
            }
            AppMethodBeat.m2505o(86661);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.i$11 */
    class C675511 implements Runnable {
        C675511() {
        }

        public final void run() {
            AppMethodBeat.m2504i(86662);
            if (C6750i.this.mFinished) {
                AppMethodBeat.m2505o(86662);
                return;
            }
            C6750i.m11181a(C6750i.this);
            C6750i.this.eMP = true;
            C6750i c6750i = C6750i.this;
            c6750i.mHandler.removeCallbacks(c6750i.gNZ);
            AppMethodBeat.m2505o(86662);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.i$13 */
    class C675613 implements Runnable {
        C675613() {
        }

        public final void run() {
            AppMethodBeat.m2504i(86664);
            C6750i.m11182b(C6750i.this);
            AppMethodBeat.m2505o(86664);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.i$c */
    class C6757c implements C6761a, C5684a {
        private boolean gOp;

        private C6757c() {
            AppMethodBeat.m2504i(86666);
            C6750i.this.keep(this);
            this.gOp = false;
            AppMethodBeat.m2505o(86666);
        }

        /* synthetic */ C6757c(C6750i c6750i, byte b) {
            this();
        }

        public final void done() {
            AppMethodBeat.m2504i(86667);
            if (!this.gOp) {
                C6750i c6750i = C6750i.this;
                if (!c6750i.mFinished) {
                    if (c6750i.eMP) {
                        C4990ab.m7413e("MicroMsg.AppBrandRuntime", "initRuntime, mInitialized TRUE !!!  go check callee %s", C5046bo.m7574l(new Throwable()));
                        AppMethodBeat.m2505o(86667);
                        return;
                    }
                    C4990ab.m7411d("MicroMsg.AppBrandRuntime", "initRuntime %s", c6750i.mAppId);
                    new C675511().run();
                }
            }
            AppMethodBeat.m2505o(86667);
        }

        public final void dead() {
            this.gOp = true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.i$a */
    interface C6761a {
        void done();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.i$4 */
    class C67624 extends C2172a {
        private boolean gOd = false;

        C67624() {
        }

        public final void ats() {
            AppMethodBeat.m2504i(86654);
            if (this.gOd) {
                C6750i.m11183c(C6750i.this);
            }
            this.gOd = false;
            AppMethodBeat.m2505o(86654);
        }

        public final void att() {
            this.gOd = true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.i$b */
    public static abstract class C6764b {
        C6761a gOo;

        public abstract void prepare();

        /* renamed from: wL */
        public final void mo15047wL() {
            if (this.gOo != null) {
                this.gOo.done();
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.i$5 */
    class C67665 implements Runnable {
        C67665() {
        }

        public final void run() {
            AppMethodBeat.m2504i(86655);
            C6750i.this.atf();
            AppMethodBeat.m2505o(86655);
        }
    }

    public C6750i(Activity activity, C26719ab c26719ab) {
        AppMethodBeat.m2504i(86668);
        this.gNy = activity;
        this.gNz = c26719ab;
        this.mHandler = new Handler();
        this.gNE = new C45713c(activity);
        this.gNE.setLayoutParams(new LayoutParams(-1, -1));
        this.gNL = new C45684d();
        this.gNM = new C27229m();
        AppMethodBeat.m2505o(86668);
    }

    public final void keep(C5684a c5684a) {
        AppMethodBeat.m2504i(86669);
        if (c5684a != null) {
            this.gNW.add(c5684a);
        }
        AppMethodBeat.m2505o(86669);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final void mo15017c(AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.m2504i(86670);
        if (appBrandInitConfig == null) {
            C4990ab.m7416i("MicroMsg.AppBrandRuntime", "null current config, ignored");
            AppMethodBeat.m2505o(86670);
            return;
        }
        this.gNB = appBrandInitConfig;
        this.mAppId = appBrandInitConfig.appId;
        this.gNN = new C10136c(this);
        this.gNN.gWy.start();
        this.gNN.mo21486a(new C21701());
        this.gNG = new C2514e(this.gNy);
        C4990ab.m7417i("MicroMsg.AppBrandRuntime", "init %s, config %s", this.mAppId, this.gNB);
        this.eMP = false;
        this.mFinished = false;
        this.f1966Pf = false;
        this.gNP = false;
        this.gNQ = false;
        this.gNR = false;
        AppMethodBeat.m2505o(86670);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo14983a(C6764b c6764b) {
        AppMethodBeat.m2504i(86672);
        this.gNX.add(c6764b);
        AppMethodBeat.m2505o(86672);
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0034  */
    /* JADX WARNING: Missing block: B:12:0x0043, code skipped:
            if (r7.gVs == r6.gNB.gVs) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void mo14980a(AppBrandInitConfig appBrandInitConfig) {
        int i = 1;
        AppMethodBeat.m2504i(86673);
        if (this.eMP) {
            C4990ab.m7411d("MicroMsg.AppBrandRuntime", "updateConfig %s", appBrandInitConfig);
            if (appBrandInitConfig != null) {
                if (this.gNR) {
                    this.gNR = false;
                }
                if (i != 0) {
                    atn();
                }
                this.gNB = appBrandInitConfig;
                AppMethodBeat.m2505o(86673);
                return;
            }
            i = 0;
            if (i != 0) {
            }
            this.gNB = appBrandInitConfig;
            AppMethodBeat.m2505o(86673);
            return;
        }
        C4990ab.m7411d("MicroMsg.AppBrandRuntime", "updateConfig %s, not initialized", appBrandInitConfig);
        AppMethodBeat.m2505o(86673);
    }

    public final String getAppId() {
        return this.mAppId;
    }

    public final int asT() {
        return this.gNB.gVs;
    }

    public final C6750i asU() {
        AppMethodBeat.m2504i(86674);
        C6750i d = this.gNz.mo44513d(this);
        AppMethodBeat.m2505o(86674);
        return d;
    }

    /* renamed from: xT */
    public C38492q mo15032xT() {
        return this.gNC;
    }

    public C38470q asV() {
        return this.gND;
    }

    public Activity getContext() {
        return this.gNy;
    }

    /* renamed from: yf */
    public AppBrandInitConfig mo15035yf() {
        return this.gNB;
    }

    /* renamed from: ye */
    public C16597h mo15034ye() {
        AppMethodBeat.m2504i(86675);
        C16597h c16597h = (C16597h) mo14986aa(C16597h.class);
        AppMethodBeat.m2505o(86675);
        return c16597h;
    }

    public final C38163a getAppConfig() {
        AppMethodBeat.m2504i(86676);
        C38163a c38163a = (C38163a) mo15016c(C38163a.class, false);
        AppMethodBeat.m2505o(86676);
        return c38163a;
    }

    public final C10136c asW() {
        return this.gNN;
    }

    /* Access modifiers changed, original: protected */
    public C42458a asX() {
        AppMethodBeat.m2504i(86678);
        C42459c c42459c = new C42459c();
        AppMethodBeat.m2505o(86678);
        return c42459c;
    }

    public C19092p asE() {
        return this.gNH;
    }

    public final void asY() {
        AppMethodBeat.m2504i(86679);
        if (this.gNH == null) {
            this.gNH = asZ();
        }
        AppMethodBeat.m2505o(86679);
    }

    /* Access modifiers changed, original: protected */
    public C19092p asZ() {
        AppMethodBeat.m2504i(86680);
        C36710t c36710t = new C36710t(this);
        AppMethodBeat.m2505o(86680);
        return c36710t;
    }

    /* Access modifiers changed, original: protected */
    public C27333q ata() {
        return null;
    }

    public final String atc() {
        AppMethodBeat.m2504i(86682);
        String str;
        if (this.gNB == null) {
            str = "";
            AppMethodBeat.m2505o(86682);
            return str;
        } else if (!C5046bo.isNullOrNil(this.gNB.hgC)) {
            str = this.gNB.hgC;
            AppMethodBeat.m2505o(86682);
            return str;
        } else if (getAppConfig() == null) {
            str = "";
            AppMethodBeat.m2505o(86682);
            return str;
        } else {
            str = getAppConfig().ayw();
            AppMethodBeat.m2505o(86682);
            return str;
        }
    }

    /* renamed from: c */
    public final <T extends C10441j> T mo15016c(Class<T> cls, boolean z) {
        T t;
        AppMethodBeat.m2504i(86683);
        T t2 = null;
        Iterator descendingIterator = this.gNI.descendingIterator();
        while (descendingIterator.hasNext()) {
            t = (C10441j) descendingIterator.next();
            if (cls.isInstance(t)) {
                t2 = t;
                break;
            }
        }
        if (t2 == null && z) {
            try {
                t = (C10441j) cls.newInstance();
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrandRuntime", "Make sure %s has default constructor", cls.getName());
            }
            AppMethodBeat.m2505o(86683);
            return t;
        }
        t = t2;
        AppMethodBeat.m2505o(86683);
        return t;
    }

    /* renamed from: aa */
    public final <T extends C10441j> T mo14986aa(Class<T> cls) {
        AppMethodBeat.m2504i(86684);
        C10441j c = mo15016c(cls, !this.gNV);
        AppMethodBeat.m2505o(86684);
        return c;
    }

    /* renamed from: ab */
    public final <T extends C10442k> T mo14987ab(Class<T> cls) {
        C10442k c10442k;
        AppMethodBeat.m2504i(86685);
        synchronized (this.gNJ) {
            try {
                Iterator it = this.gNJ.iterator();
                while (it.hasNext()) {
                    c10442k = (C10442k) it.next();
                    if (cls.isInstance(c10442k)) {
                    }
                }
                AppMethodBeat.m2505o(86685);
                return null;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(86685);
            }
        }
        return c10442k;
    }

    /* renamed from: a */
    public final boolean mo14985a(C10442k c10442k) {
        AppMethodBeat.m2504i(86686);
        synchronized (this.gNJ) {
            try {
                this.gNJ.add(c10442k);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(86686);
            }
        }
        return true;
    }

    /* renamed from: K */
    public final <T extends C1694a> T mo14978K(Class<T> cls) {
        AppMethodBeat.m2504i(86687);
        C1694a U = this.gNK.mo5209U(cls);
        AppMethodBeat.m2505o(86687);
        return U;
    }

    /* renamed from: a */
    public final <T extends C1694a, N extends T> void mo14984a(Class<T> cls, N n) {
        AppMethodBeat.m2504i(86688);
        this.gNK.mo5210a(cls, n);
        AppMethodBeat.m2505o(86688);
    }

    @Deprecated
    public Looper atd() {
        AppMethodBeat.m2504i(86689);
        Looper mainLooper = Looper.getMainLooper();
        AppMethodBeat.m2505o(86689);
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
    /* renamed from: yb */
    public void mo15033yb() {
    }

    /* Access modifiers changed, original: protected */
    public void atg() {
    }

    /* Access modifiers changed, original: protected */
    public C38492q ath() {
        AppMethodBeat.m2504i(86690);
        C38492q c38492q = new C38492q();
        AppMethodBeat.m2505o(86690);
        return c38492q;
    }

    /* Access modifiers changed, original: protected */
    public C38470q ati() {
        AppMethodBeat.m2504i(86691);
        C38470q c38470q = new C38470q(getContext(), this);
        AppMethodBeat.m2505o(86691);
        return c38470q;
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
        AppMethodBeat.m2504i(86692);
        if (!this.eMP) {
            AppMethodBeat.m2505o(86692);
        } else if (this.mFinished) {
            AppMethodBeat.m2505o(86692);
        } else {
            C4990ab.m7417i("MicroMsg.AppBrandRuntime", "onPause: %s", this.mAppId);
            onPause();
            this.gNN.gWy.mo44560nt(1);
            this.gNC.atW();
            this.gND.mo21680wW();
            C33183g.m54280wP(this.mAppId);
            C33183g.m54273a(this.mAppId, C33185b.ON_PAUSE);
            C4990ab.m7416i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onPause");
            try {
                C30292bc.m48192a(C4996ah.getContext(), null);
                AppMethodBeat.m2505o(86692);
            } catch (SecurityException e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandUserCaptureScreenMonitor", e, "[NOT CRASH] pause set null callback", new Object[0]);
                AppMethodBeat.m2505o(86692);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
    }

    /* Access modifiers changed, original: final */
    public final void atl() {
        AppMethodBeat.m2504i(86693);
        if (this.eMP) {
            C4990ab.m7417i("MicroMsg.AppBrandRuntime", "onResume: %s", this.mAppId);
            if (this.mFinished || this.gNP) {
                mo15020d(null);
                AppMethodBeat.m2505o(86693);
                return;
            }
            C33183g.m54285wU(this.mAppId);
            C33183g.m54281wQ(this.mAppId);
            C33183g.m54273a(this.mAppId, C33185b.ON_RESUME);
            onResume();
            this.gND.mo21679wU();
            this.gNN.gWy.mo44560nt(3);
            final boolean z = this.gNQ;
            this.gNE.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(86665);
                    C6750i.this.gNC.mo34948dw(z);
                    if (z) {
                        C6750i c6750i = C6750i.this;
                        c6750i.gND.mo21671af(c6750i.atc(), true);
                    }
                    AppMethodBeat.m2505o(86665);
                }
            });
            C45684d c45684d = this.gNL;
            C4990ab.m7416i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onResume");
            try {
                C30292bc.m48192a(C4996ah.getContext(), c45684d.iRh);
            } catch (SecurityException e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandUserCaptureScreenMonitor", e, "[NOT CRASH] resume set callback", new Object[0]);
            }
            atq();
            this.gNP = false;
            this.gNQ = false;
            AppMethodBeat.m2505o(86693);
            return;
        }
        AppMethodBeat.m2505o(86693);
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
        AppMethodBeat.m2504i(86694);
        C4990ab.m7417i("MicroMsg.AppBrandRuntime", "dl: cleanup, finished?[%b] initialized?[%b]", Boolean.valueOf(this.mFinished), Boolean.valueOf(this.eMP));
        if (this.mFinished) {
            AppMethodBeat.m2505o(86694);
            return;
        }
        Iterator it;
        this.mFinished = true;
        C4990ab.m7417i("MicroMsg.AppBrandRuntime", "onDestroy: %s", this.mAppId);
        onDestroy();
        for (C5684a dead : this.gNW) {
            dead.dead();
        }
        this.gNW.clear();
        this.gNH = null;
        AppBrandMainProcessService.m54353b(this.gNY);
        MMToClientEvent.m75202f(this.gNC);
        C33183g.m54279wO(this.mAppId);
        C33183g.m54273a(this.mAppId, C33185b.ON_DESTROY);
        C8873f.m15846az(getContext());
        C10136c c10136c = this.gNN;
        C26788d c26788d = c10136c.gWy;
        c26788d.gWG.set(true);
        C4890c c4890c = c26788d.xCt;
        if (c4890c != null) {
            C4890c.m7281f(c4890c);
        }
        c26788d.mo21489a(C45524b.DESTROYED);
        synchronized (c10136c.gWz) {
            try {
                c10136c.gWz.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(86694);
            }
        }
        C42598f aIE = C42598f.aIE();
        String str = this.mAppId;
        if (aIE.hGk.containsKey(str)) {
            aIE.hGk.remove(str);
        }
        C10567c aIB = C10567c.aIB();
        str = this.mAppId;
        if (aIB.hGk.containsKey(str)) {
            C27146b c27146b = (C27146b) aIB.hGk.remove(str);
            synchronized (c27146b.iov) {
                try {
                    it = c27146b.iov.iterator();
                    while (it.hasNext()) {
                        ((C38413b) it.next()).isRunning = false;
                    }
                    c27146b.iov.clear();
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(86694);
                }
            }
        }
        C42601i aIG = C42601i.aIG();
        str = this.mAppId;
        if (aIG.hGk.containsKey(str)) {
            C42599g c42599g = (C42599g) aIG.hGk.remove(str);
            synchronized (c42599g.ioU) {
                try {
                    it = c42599g.ioU.iterator();
                    while (it.hasNext()) {
                        ((C42600h) it.next()).isRunning = false;
                    }
                    c42599g.ioU.clear();
                } catch (Throwable th2) {
                    AppMethodBeat.m2505o(86694);
                }
            }
        }
        C19546l aII = C19546l.aII();
        str = this.mAppId;
        if (aII.hGk.containsKey(str)) {
            C10562d c10562d = (C10562d) aII.hGk.remove(str);
            if (c10562d != null) {
                c10562d.release();
            }
        }
        C33183g.m54284wT(this.mAppId);
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
                    AppMethodBeat.m2505o(86694);
                }
            }
        }
        this.gNK = new C1698d();
        this.gOa.clear();
    }

    public final void finish() {
        AppMethodBeat.m2504i(86695);
        this.f1966Pf = true;
        C8873f.m15846az(this.gNy);
        this.gNy.runOnUiThread(new C21712());
        AppMethodBeat.m2505o(86695);
    }

    /* renamed from: a */
    public final void mo14981a(AppBrandInitConfig appBrandInitConfig, MiniProgramNavigationBackResult miniProgramNavigationBackResult) {
        String str = null;
        AppMethodBeat.m2504i(86696);
        AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        appBrandLaunchReferrer.appId = appBrandInitConfig.appId;
        appBrandLaunchReferrer.hgQ = 3;
        appBrandLaunchReferrer.cFM = miniProgramNavigationBackResult == null ? null : miniProgramNavigationBackResult.gQt.toString();
        if (miniProgramNavigationBackResult != null) {
            str = miniProgramNavigationBackResult.gQu.toString();
        }
        appBrandLaunchReferrer.hgR = str;
        this.gNB.hgF.mo73344a(appBrandLaunchReferrer);
        mo15015b(appBrandInitConfig);
        AppMethodBeat.m2505o(86696);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo15015b(AppBrandInitConfig appBrandInitConfig) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: d */
    public void mo15020d(AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.m2504i(138229);
        cleanup();
        if (appBrandInitConfig == null) {
            appBrandInitConfig = mo15035yf();
        }
        mo15017c(appBrandInitConfig);
        asS();
        C4990ab.m7417i("MicroMsg.AppBrandRuntime", "reload: %s", this.mAppId);
        AppMethodBeat.m2505o(138229);
    }

    public void close() {
        AppMethodBeat.m2504i(86698);
        C8873f.m15846az(getContext());
        mo14979a(null);
        AppMethodBeat.m2505o(86698);
    }

    /* renamed from: a */
    public final void mo14979a(final MiniProgramNavigationBackResult miniProgramNavigationBackResult) {
        AppMethodBeat.m2504i(86699);
        if (this.gNy == null) {
            AppMethodBeat.m2505o(86699);
            return;
        }
        this.gNy.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(86653);
                if (!C6750i.this.eMP || C6750i.this.mFinished) {
                    C6750i.this.gNz.mo44514f(C6750i.this);
                    AppMethodBeat.m2505o(86653);
                    return;
                }
                C6750i.this.gNz.mo34752a(C6750i.this, miniProgramNavigationBackResult);
                AppMethodBeat.m2505o(86653);
            }
        });
        AppMethodBeat.m2505o(86699);
    }

    /* Access modifiers changed, original: protected|final */
    public final void atn() {
        AppMethodBeat.m2504i(86700);
        this.gNP = true;
        C4990ab.m7410d("MicroMsg.AppBrandRuntime", "setWillRestart");
        AppMethodBeat.m2505o(86700);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean ato() {
        AppMethodBeat.m2504i(86701);
        if (!this.gNT) {
            AppMethodBeat.m2505o(86701);
            return false;
        } else if (this.gNy != null && this.gNy.isFinishing()) {
            AppMethodBeat.m2505o(86701);
            return false;
        } else if (this.gND == null || this.gND.getCurrentPage() == null || this.gND.getCurrentPage().mSwiping) {
            AppMethodBeat.m2505o(86701);
            return false;
        } else {
            AppMethodBeat.m2505o(86701);
            return true;
        }
    }

    public final void atp() {
        AppMethodBeat.m2504i(86702);
        this.gNN.gWy.mo44560nt(12);
        AppMethodBeat.m2505o(86702);
    }

    /* Access modifiers changed, original: protected */
    @TargetApi(21)
    public void atq() {
        AppMethodBeat.m2504i(86703);
        if (VERSION.SDK_INT < 21) {
            AppMethodBeat.m2505o(86703);
            return;
        }
        TaskDescription taskDescription;
        if (getAppConfig() == null) {
            taskDescription = new TaskDescription(mo15035yf().cwz);
        } else {
            taskDescription = new TaskDescription(mo15035yf().cwz, null, C10732w.m18401bx(getAppConfig().heS.hfw, WebView.NIGHT_MODE_COLOR));
        }
        this.gNy.setTaskDescription(taskDescription);
        C37926b.abR().mo60685a(new C26433b() {
            /* renamed from: x */
            public final void mo6524x(Bitmap bitmap) {
                AppMethodBeat.m2504i(86656);
                C6750i.this.gNy.setTaskDescription(new TaskDescription(taskDescription.getLabel(), bitmap, taskDescription.getPrimaryColor()));
                AppMethodBeat.m2505o(86656);
            }
        }, mo15035yf().iconUrl, C42201f.fqH);
        AppMethodBeat.m2505o(86703);
    }

    public final boolean atr() {
        AppMethodBeat.m2504i(86704);
        if (this.gNN.gWy.awz() == C45524b.SUSPEND) {
            cleanup();
            AppMethodBeat.m2505o(86704);
            return true;
        }
        AppMethodBeat.m2505o(86704);
        return false;
    }

    /* renamed from: B */
    public final void mo14977B(Runnable runnable) {
        AppMethodBeat.m2504i(86706);
        if (runnable == null) {
            AppMethodBeat.m2505o(86706);
        } else if (this.mFinished) {
            AppMethodBeat.m2505o(86706);
        } else {
            C19719p O = C19719p.m30531O(runnable);
            keep(O);
            this.gNy.runOnUiThread(O);
            AppMethodBeat.m2505o(86706);
        }
    }

    public final void asS() {
        View view;
        AppMethodBeat.m2504i(86671);
        if (this.gNF != null) {
            atb();
        }
        C27333q ata = ata();
        if (ata != null) {
            final View view2 = ata.getView();
            this.gNE.addView(view2, -1, -1);
            this.gNF = ata;
            view2.setClickable(true);
            this.gNE.setOnHierarchyChangeListener(new OnHierarchyChangeListener() {
                public final void onChildViewAdded(View view, View view2) {
                }

                public final void onChildViewRemoved(View view, View view2) {
                    AppMethodBeat.m2504i(86660);
                    if (view2 == view2 && !C6750i.this.mFinished) {
                        C6750i.this.asV().setActuallyVisible(true);
                    }
                    AppMethodBeat.m2505o(86660);
                }
            });
        }
        C4990ab.m7417i("MicroMsg.AppBrandRuntime", "appOnCreate: %s, %s", this.gNB.cwz, this.gNB.appId);
        AppBrandMainProcessService.m54348a(this.gNY);
        C38450n.m65045wX(this.mAppId);
        mo14984a(C10333f.class, new C19932z());
        mo14984a(C42638b.class, new C19614d(this));
        mo14984a(C10979g.class, C10979g.iUd);
        mo14984a(C33139b.class, new C38433m(this));
        mo14984a(C19162a.class, new C44704k(this));
        onCreate();
        this.gNN.gWy.mo44560nt(3);
        C33183g.m54285wU(this.mAppId);
        C33183g.m54278wN(this.mAppId);
        C33183g.m54273a(this.mAppId, C33185b.ON_CREATE);
        atq();
        final C6757c c6757c = new C6757c(this, (byte) 0);
        if (this.gNF == null) {
            view = this.gNE;
        } else {
            view = this.gNF.getView();
        }
        view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {

            /* renamed from: com.tencent.mm.plugin.appbrand.i$7$1 */
            class C67601 implements Runnable {
                C67601() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(86657);
                    C6750i c6750i = C6750i.this;
                    C6757c c6757c = c6757c;
                    ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue(c6750i.gNX);
                    c6750i.gNX = new LinkedList();
                    Iterator it = concurrentLinkedQueue.iterator();
                    while (it.hasNext()) {
                        C6764b c6764b = (C6764b) it.next();
                        c6764b.gOo = new C67528(concurrentLinkedQueue, c6764b, c6757c);
                        c6764b.prepare();
                    }
                    AppMethodBeat.m2505o(86657);
                }
            }

            public final boolean onPreDraw() {
                AppMethodBeat.m2504i(86658);
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                view.post(new C67601());
                AppMethodBeat.m2505o(86658);
                return true;
            }
        });
        this.mHandler.postDelayed(this.gNZ, 10000);
        AppMethodBeat.m2505o(86671);
    }

    /* renamed from: a */
    public final void mo14982a(C38163a c38163a) {
        AppMethodBeat.m2504i(86677);
        this.gNI.add(c38163a);
        AppMethodBeat.m2505o(86677);
    }

    public final void atb() {
        AppMethodBeat.m2504i(86681);
        if (this.mFinished) {
            this.gNF = null;
            AppMethodBeat.m2505o(86681);
        } else if (this.gNF == null) {
            C4990ab.m7412e("MicroMsg.AppBrandRuntime", "hideSplash, splash view null");
            AppMethodBeat.m2505o(86681);
        } else {
            this.gNF.aHS();
            this.gNF = null;
            AppMethodBeat.m2505o(86681);
        }
    }

    /* renamed from: A */
    public final void mo14976A(Runnable runnable) {
        AppMethodBeat.m2504i(86705);
        if (this.f1966Pf || this.mFinished) {
            C4990ab.m7421w("MicroMsg.AppBrandRuntime", "runOnRuntimeReady runtime[%s] finishing, stack %s", this.mAppId, Log.getStackTraceString(new Throwable()));
            AppMethodBeat.m2505o(86705);
        } else if (this.eMP) {
            this.gNy.runOnUiThread(runnable);
            AppMethodBeat.m2505o(86705);
        } else {
            this.gOa.offerLast(runnable);
            AppMethodBeat.m2505o(86705);
        }
    }
}
