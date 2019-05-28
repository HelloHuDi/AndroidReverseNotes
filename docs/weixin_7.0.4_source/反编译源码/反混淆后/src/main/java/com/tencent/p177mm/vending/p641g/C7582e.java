package com.tencent.p177mm.vending.p641g;

import android.os.Looper;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p639e.C5685b;
import com.tencent.p177mm.vending.p640f.C5687a;
import com.tencent.p177mm.vending.p641g.C5692d.C5690a;
import com.tencent.p177mm.vending.p641g.C5692d.C5691b;
import com.tencent.p177mm.vending.p641g.C7361c.C5689a;
import com.tencent.p177mm.vending.p642h.C5703d;
import com.tencent.p177mm.vending.p642h.C5706f;
import com.tencent.p177mm.vending.p642h.C5706f.C5705a;
import com.tencent.p177mm.vending.p642h.C5707g;
import com.tencent.p177mm.vending.p642h.C7367c;
import com.tencent.p177mm.vending.p642h.C7369h;
import com.tencent.p177mm.vending.p644j.C7984k;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.vending.g.e */
public class C7582e<_Var> implements C7361c<_Var> {
    /* renamed from: b */
    private volatile boolean f2105b = false;
    /* renamed from: d */
    boolean f2106d = false;
    /* renamed from: h */
    volatile Object f2107h;
    /* renamed from: i */
    volatile boolean f2108i;
    /* renamed from: j */
    volatile Object f2109j;
    /* renamed from: m */
    private int f2110m = 0;
    /* renamed from: n */
    private long f2111n = -1;
    /* renamed from: o */
    private boolean f2112o = false;
    /* renamed from: v */
    private boolean f2113v = false;
    /* renamed from: w */
    boolean f2114w = false;
    /* renamed from: x */
    private boolean f2115x = false;
    volatile C5697d zXK = C5697d.Idle;
    private Queue<C5696b> zXL = new LinkedList();
    private volatile C5703d zXM = this.zXN;
    private volatile C5703d zXN = C5707g.dMq();
    C5696b zXO;
    C5696b zXP;
    private C5688b zXQ = new C7365c();
    private C5703d zXR;
    C5706f zXS = new C5706f(this.zXN, this.zXT);
    private C5705a zXT = new C73621();
    List<Pair<C5690a, C5703d>> zXU;
    private List<Pair<C5691b, C5703d>> zXV;
    private Object zXW;
    Object zXX;

    /* renamed from: com.tencent.mm.vending.g.e$a */
    public static class C5695a extends Error {
        public C5695a(String str, Object... objArr) {
            super(String.format(str, objArr));
            AppMethodBeat.m2504i(126013);
            AppMethodBeat.m2505o(126013);
        }
    }

    /* renamed from: com.tencent.mm.vending.g.e$b */
    static class C5696b {
        /* renamed from: c */
        public long f1346c;
        /* renamed from: d */
        public boolean f1347d;
        public C5703d zXD;
        public C5681a zYf;

        public C5696b(C5681a c5681a, C5703d c5703d, long j, boolean z) {
            this.zYf = c5681a;
            this.zXD = c5703d;
            this.f1346c = j;
            this.f1347d = z;
        }
    }

    /* renamed from: com.tencent.mm.vending.g.e$d */
    enum C5697d {
        Idle,
        Resolved,
        Invoking,
        Pausing,
        Interrupted,
        AllDone;

        static {
            AppMethodBeat.m2505o(126016);
        }
    }

    /* renamed from: com.tencent.mm.vending.g.e$1 */
    class C73621 implements C5705a {
        C73621() {
        }

        public final void dMl() {
            AppMethodBeat.m2504i(126061);
            C5701g dMp = C5701g.dMp();
            C7582e c7582e = C7582e.this;
            Stack stack = (Stack) dMp.f1348b.get();
            if (stack == null) {
                stack = new Stack();
                dMp.f1348b.set(stack);
            }
            stack.push(c7582e);
            AppMethodBeat.m2505o(126061);
        }

        /* renamed from: cT */
        public final void mo11596cT(Object obj) {
            AppMethodBeat.m2504i(126062);
            ((Stack) C5701g.dMp().f1348b.get()).pop();
            synchronized (C7582e.this) {
                try {
                    C7582e.this.zXO = C7582e.this.zXP;
                    C7582e.this.zXP = null;
                    if (C7582e.this.f2106d) {
                        C5687a.m8542i("Vending.Pipeline", "gonna retry, do not store functional result.", new Object[0]);
                    } else {
                        C7582e.this.f2107h = obj;
                    }
                    if (C7582e.this.zXK == C5697d.Interrupted) {
                        C5687a.m8542i("Vending.Pipeline", "interrupted, just return", new Object[0]);
                    } else if (C7582e.this.zXK == C5697d.Pausing) {
                        C5687a.m8542i("Vending.Pipeline", "pausing, just return.", new Object[0]);
                        AppMethodBeat.m2505o(126062);
                    } else {
                        C7582e.this.zXK = C5697d.Resolved;
                        C7582e.this.mo16873cS(C7582e.this.mo16869a(obj));
                        AppMethodBeat.m2505o(126062);
                    }
                } finally {
                    AppMethodBeat.m2505o(126062);
                }
            }
        }

        public final void interrupt() {
            AppMethodBeat.m2504i(126063);
            C7582e.this.mo16871a(true);
            AppMethodBeat.m2505o(126063);
        }
    }

    /* renamed from: com.tencent.mm.vending.g.e$c */
    class C7365c implements C5688b {
        C7365c() {
        }

        /* renamed from: cR */
        public final void mo11582cR(Object obj) {
            AppMethodBeat.m2504i(126064);
            synchronized (C7582e.this) {
                if (C7582e.this.zXK == C5697d.Interrupted) {
                    C5687a.m8542i("Vending.Pipeline", "interrupted, skip this interrupt.", new Object[0]);
                } else if (C7582e.m13426a(C7582e.this) || C7582e.this.zXK == C5697d.Pausing) {
                    try {
                        C5687a.m8542i("Vending.Pipeline", "interrupt Pipeline(%s)", C7582e.this);
                        C7582e.this.mo16871a(false);
                        C7582e.this.f2114w = true;
                        C7582e.this.zXX = obj;
                        if (C7582e.this.zXU != null) {
                            for (Pair a : C7582e.this.zXU) {
                                C7582e.this.mo16870a(a, obj);
                            }
                        }
                        AppMethodBeat.m2505o(126064);
                    } finally {
                        AppMethodBeat.m2505o(126064);
                    }
                } else {
                    C5687a.m8542i("Vending.Pipeline", "interrupt not in func scope or pending, skip this retryOrInterrupt.", new Object[0]);
                    AppMethodBeat.m2505o(126064);
                }
            }
        }

        /* JADX WARNING: Missing block: B:38:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void dMi() {
            int i;
            int i2 = 126065;
            AppMethodBeat.m2504i(126065);
            synchronized (C7582e.this) {
                try {
                    i = C7582e.this;
                    synchronized (i) {
                        if (C7582e.this.zXK == C5697d.Interrupted || C7582e.this.zXK == C5697d.Idle) {
                            C5687a.m8543w("Vending.Pipeline", "current is state(%s), ignore pause.", C7582e.this.zXK);
                        } else if (!C7582e.m13426a(C7582e.this)) {
                            C5687a.m8541e("Vending.Pipeline", "you are using mario().pause() out of a functional scope on %s!", C7582e.this);
                        } else if (C7582e.m13428b(C7582e.this)) {
                            C7582e.this.zXK = C5697d.Pausing;
                        } else {
                            C5687a.m8541e("Vending.Pipeline", "you are using mario().pause() out of calling thread on %s!", C7582e.this);
                        }
                    }
                } catch (Throwable th) {
                    i = 126065;
                } finally {
                    AppMethodBeat.m2505o(
/*
Method generation error in method: com.tencent.mm.vending.g.e.c.dMi():void, dex: classes.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005b: INVOKE  (wrap: int
  ?: MERGE  (r7_1 int) = (r7_0 'i2' int), (r2_3 'i' int)) com.tencent.matrix.trace.core.AppMethodBeat.o(int):void type: STATIC in method: com.tencent.mm.vending.g.e.c.dMi():void, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:205)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:102)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:52)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:300)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:230)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:321)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:259)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:221)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.addInnerClasses(ClassGen.java:234)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:220)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r7_1 int) = (r7_0 'i2' int), (r2_3 'i' int) in method: com.tencent.mm.vending.g.e.c.dMi():void, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:101)
	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:688)
	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:658)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:340)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 30 more
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:213)
	... 35 more

*/

        /* renamed from: B */
        public final void mo11581B(Object... objArr) {
            AppMethodBeat.m2504i(126066);
            synchronized (C7582e.this) {
                try {
                    if (C7582e.this.zXK != C5697d.Pausing) {
                        C5687a.m8542i("Vending.Pipeline", "state is not pausing %s, skip this wormhole", C7582e.this.zXK);
                    } else {
                        Object obj;
                        C7582e c7582e = C7582e.this;
                        if (objArr.length == 0) {
                            obj = null;
                        } else if (objArr.length == 1) {
                            obj = objArr[0];
                        } else {
                            obj = C7984k.m14169E(objArr);
                        }
                        c7582e.f2109j = obj;
                        C7582e.this.f2108i = true;
                        C5687a.m8542i("Vending.Pipeline", "pipline(%s) wormhole().", C7582e.this);
                        resume();
                        AppMethodBeat.m2505o(126066);
                    }
                } finally {
                    AppMethodBeat.m2505o(126066);
                }
            }
        }

        /* JADX WARNING: Missing block: B:15:0x004d, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(126067);
     */
        /* JADX WARNING: Missing block: B:21:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void resume() {
            AppMethodBeat.m2504i(126067);
            synchronized (C7582e.this) {
                try {
                    if (C7582e.this.zXK != C5697d.Pausing) {
                        C5687a.m8541e("Vending.Pipeline", "this Pipeline(%s) is not pausing! why call resume?", C7582e.this);
                    } else {
                        if (C7582e.m13426a(C7582e.this)) {
                            C7582e.this.zXK = C5697d.Invoking;
                        } else {
                            C7582e.this.zXK = C5697d.Resolved;
                        }
                        if (!C7582e.m13428b(C7582e.this)) {
                            C7582e.this.mo16873cS(C7582e.this.mo16869a(C7582e.this.f2107h));
                        }
                    }
                } finally {
                    AppMethodBeat.m2505o(126067);
                }
            }
        }
    }

    public C7582e() {
        AppMethodBeat.m2504i(126034);
        AppMethodBeat.m2505o(126034);
    }

    public C7361c<_Var> asS(String str) {
        AppMethodBeat.m2504i(126035);
        if (str == null) {
            Assert.assertNotNull("schedulerTypeString should not be null!", str);
            AppMethodBeat.m2505o(126035);
        } else {
            this.zXM = C5707g.asU(str);
            Assert.assertNotNull("mCurrentScheduler should not be null!", this.zXM);
            AppMethodBeat.m2505o(126035);
        }
        return this;
    }

    /* renamed from: b */
    public C7361c<_Var> mo15891b(C5703d c5703d) {
        AppMethodBeat.m2504i(126036);
        if (c5703d == null) {
            Assert.assertNotNull("scheduler should not be null!", c5703d);
            AppMethodBeat.m2505o(126036);
        } else {
            this.zXM = c5703d;
            AppMethodBeat.m2505o(126036);
        }
        return this;
    }

    /* renamed from: a */
    public C7361c<_Var> mo15890a(C5685b c5685b) {
        AppMethodBeat.m2504i(126037);
        Assert.assertNotNull("keeper should not be null!", c5685b);
        c5685b.keep(this);
        AppMethodBeat.m2505o(126037);
        return this;
    }

    /* renamed from: ny */
    public synchronized C7361c<_Var> mo15897ny(long j) {
        this.f2111n = j;
        return this;
    }

    /* renamed from: rg */
    public synchronized C7361c<_Var> mo15898rg(boolean z) {
        this.f2112o = z;
        return this;
    }

    /* renamed from: a */
    public synchronized C7361c<_Var> mo16868a(final C5689a<_Var> c5689a) {
        AppMethodBeat.m2504i(126038);
        m13422D(new Object[0]);
        m13423a(new C5681a<_Var, _Var>() {
            public final _Var call(_Var _var) {
                AppMethodBeat.m2504i(126071);
                Object call = c5689a.call();
                AppMethodBeat.m2505o(126071);
                return call;
            }
        }, true);
        AppMethodBeat.m2505o(126038);
        return this;
    }

    /* renamed from: C */
    public synchronized C7361c<_Var> mo16867C(Object... objArr) {
        C7361c D;
        AppMethodBeat.m2504i(126039);
        D = m13422D(objArr);
        AppMethodBeat.m2505o(126039);
        return D;
    }

    /* renamed from: D */
    private C7361c<_Var> m13422D(Object... objArr) {
        AppMethodBeat.m2504i(126040);
        if (this.zXK != C5697d.Idle) {
            AppMethodBeat.m2505o(126040);
        } else {
            this.zXK = C5697d.Resolved;
            Object E = objArr.length == 0 ? null : objArr.length == 1 ? objArr[0] : C7984k.m14169E(objArr);
            this.f2107h = E;
            mo16873cS(this.f2107h);
            AppMethodBeat.m2505o(126040);
        }
        return this;
    }

    public final C5688b dMj() {
        return this.zXQ;
    }

    /* renamed from: f */
    public <_Ret> C7361c<_Ret> mo15896f(C5681a<_Ret, _Var> c5681a) {
        AppMethodBeat.m2504i(126042);
        C7361c c = asS("Vending.UI").mo15892c(c5681a);
        AppMethodBeat.m2505o(126042);
        return c;
    }

    /* renamed from: d */
    public <_Ret> C7361c<_Ret> mo15893d(C5681a<_Ret, _Var> c5681a) {
        AppMethodBeat.m2504i(126043);
        C7361c c = asS("Vending.LOGIC").mo15892c(c5681a);
        AppMethodBeat.m2505o(126043);
        return c;
    }

    /* renamed from: e */
    public <_Ret> C7361c<_Ret> mo15895e(C5681a<_Ret, _Var> c5681a) {
        AppMethodBeat.m2504i(126044);
        C7361c c = asS("Vending.HEAVY_WORK").mo15892c(c5681a);
        AppMethodBeat.m2505o(126044);
        return c;
    }

    /* renamed from: a */
    private <_Ret> C7361c<_Ret> m13423a(C5681a<_Ret, _Var> c5681a, boolean z) {
        AppMethodBeat.m2504i(126045);
        m13424a();
        this.zXL.add(new C5696b(c5681a, this.zXM, this.f2111n, z));
        this.f2111n = -1;
        if (this.zXK == C5697d.Idle) {
            AppMethodBeat.m2505o(126045);
        } else if (this.zXK != C5697d.Resolved) {
            AppMethodBeat.m2505o(126045);
        } else {
            mo16873cS(this.f2107h);
            AppMethodBeat.m2505o(126045);
        }
        return this;
    }

    /* renamed from: c */
    public synchronized <_Ret> C7361c<_Ret> mo15892c(C5681a<_Ret, _Var> c5681a) {
        C7361c a;
        AppMethodBeat.m2504i(126046);
        a = m13423a((C5681a) c5681a, this.f2112o);
        AppMethodBeat.m2505o(126046);
        return a;
    }

    /* renamed from: a */
    private void m13424a() {
        AppMethodBeat.m2504i(126047);
        if (this.f2105b) {
            C5695a c5695a = new C5695a("This Pipeline(%s) has terminate and do not allow any next().", this);
            AppMethodBeat.m2505o(126047);
            throw c5695a;
        }
        AppMethodBeat.m2505o(126047);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo16870a(final Pair<C5690a, C5703d> pair, final Object obj) {
        AppMethodBeat.m2504i(126048);
        C5703d c5703d = (C5703d) pair.second;
        C56933 c56933 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(126060);
                ((C5690a) pair.first).mo9345bi(obj);
                AppMethodBeat.m2505o(126060);
            }
        };
        if (c5703d == null) {
            C5687a.m8541e("Vending.Pipeline", "Default scheduler %s is not available!!!", this.zXN);
            AppMethodBeat.m2505o(126048);
            return;
        }
        c5703d.mo10061o(c56933);
        AppMethodBeat.m2505o(126048);
    }

    /* renamed from: b */
    private void m13427b(final Pair<C5691b, C5703d> pair, final Object obj) {
        AppMethodBeat.m2504i(126049);
        final RuntimeException runtimeException = new RuntimeException("object is not right: ".concat(String.valueOf(obj)));
        new C5706f((C5703d) pair.second, null).mo11599a(new C5681a<Void, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(126059);
                Void dMm = dMm();
                AppMethodBeat.m2505o(126059);
                return dMm;
            }

            private Void dMm() {
                AppMethodBeat.m2504i(126058);
                try {
                    ((C5691b) pair.first).mo5270az(obj);
                    Void voidR = zXH;
                    AppMethodBeat.m2505o(126058);
                    return voidR;
                } catch (ClassCastException e) {
                    if (runtimeException.getCause() == null) {
                        runtimeException.initCause(e);
                    }
                    RuntimeException runtimeException = runtimeException;
                    AppMethodBeat.m2505o(126058);
                    throw runtimeException;
                }
            }
        }, null, this.f2112o);
        AppMethodBeat.m2505o(126049);
    }

    public final synchronized C5692d<_Var> dMk() {
        this.f2105b = true;
        return this;
    }

    /* renamed from: a */
    public final synchronized C5692d<_Var> mo11586a(C5690a c5690a) {
        AppMethodBeat.m2504i(126051);
        C5703d c5703d = this.zXN;
        this.f2105b = true;
        if (this.zXU == null) {
            this.zXU = new LinkedList();
        }
        Pair pair = new Pair(c5690a, c5703d);
        if (this.f2114w) {
            mo16870a(pair, this.zXX);
        } else {
            this.zXU.add(pair);
        }
        AppMethodBeat.m2505o(126051);
        return this;
    }

    /* renamed from: a */
    public final synchronized C5692d<_Var> mo11587a(C5691b<_Var> c5691b) {
        AppMethodBeat.m2504i(126052);
        m13425a((C5691b) c5691b, this.zXN);
        AppMethodBeat.m2505o(126052);
        return this;
    }

    /* renamed from: a */
    public final synchronized C5692d<_Var> mo11588a(C5703d c5703d, C5691b<_Var> c5691b) {
        AppMethodBeat.m2504i(126053);
        m13425a((C5691b) c5691b, c5703d);
        AppMethodBeat.m2505o(126053);
        return this;
    }

    /* renamed from: a */
    public final synchronized void mo16871a(boolean z) {
        AppMethodBeat.m2504i(126054);
        if (this.zXK == C5697d.Interrupted || this.zXK == C5697d.AllDone) {
            AppMethodBeat.m2505o(126054);
        } else {
            if (z) {
                if (this.zXL.size() > 0) {
                    C5687a.m8543w("Vending.Pipeline", "Pipe is not finish and be interrupt! %s pipes did not run", Integer.valueOf(this.zXL.size()));
                }
            }
            this.zXK = C5697d.Interrupted;
            this.zXL.clear();
            this.f2107h = null;
            if (this.zXR != null) {
                this.zXR.cancel();
            }
            AppMethodBeat.m2505o(126054);
        }
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: a */
    public final synchronized Object mo16869a(Object obj) {
        Object obj2;
        AppMethodBeat.m2504i(126055);
        if (this.f2106d) {
            this.f2110m++;
            C5687a.m8542i("Vending.Pipeline", "Functional %s, gonna retry %s.", this.zXO.zYf.toString(), Integer.valueOf(this.f2110m));
            ((LinkedList) this.zXL).add(0, this.zXO);
            this.f2106d = false;
        } else {
            if (this.f2108i) {
                this.f2107h = this.f2109j;
                this.f2109j = null;
                this.f2108i = false;
            } else {
                this.f2107h = obj;
            }
            this.f2110m = 0;
        }
        obj2 = this.f2107h;
        AppMethodBeat.m2505o(126055);
        return obj2;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: cS */
    public final void mo16873cS(final Object obj) {
        AppMethodBeat.m2504i(126056);
        if (this.zXK != C5697d.Resolved) {
            AppMethodBeat.m2505o(126056);
            return;
        }
        this.zXK = C5697d.Invoking;
        C5696b c5696b = (C5696b) this.zXL.peek();
        if (c5696b == null) {
            if (this.f2105b) {
                this.zXK = C5697d.AllDone;
                this.f2113v = true;
                this.zXW = obj;
                if (this.zXV != null) {
                    for (Pair b : this.zXV) {
                        m13427b(b, this.zXW);
                    }
                    AppMethodBeat.m2505o(126056);
                    return;
                }
            }
            this.zXK = C5697d.Resolved;
            AppMethodBeat.m2505o(126056);
            return;
        }
        final C5681a c5681a = c5696b.zYf;
        C5703d c5703d = c5696b.zXD;
        long j = c5696b.f1346c;
        final boolean z = c5696b.f1347d;
        if (this.zXK == C5697d.Pausing) {
            C5687a.m8542i("Vending.Pipeline", "This pipeline is Pausing. We will stop dequeFunctionAndInvoke and waiting resume() call", new Object[0]);
            AppMethodBeat.m2505o(126056);
            return;
        }
        this.zXP = (C5696b) this.zXL.poll();
        this.zXS.mo11600c(c5703d);
        if (j < 0) {
            this.zXS.mo11599a(c5681a, obj, z);
            AppMethodBeat.m2505o(126056);
            return;
        }
        if (Looper.myLooper() == null) {
            this.zXR = new C7367c();
        } else {
            this.zXR = new C7369h(Looper.myLooper(), Looper.myLooper().toString());
        }
        this.zXR.mo10060l(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(126068);
                C7582e.this.zXS.mo11599a(c5681a, obj, z);
                AppMethodBeat.m2505o(126068);
            }
        }, j);
        AppMethodBeat.m2505o(126056);
    }

    public void dead() {
        AppMethodBeat.m2504i(126041);
        mo16871a(true);
        AppMethodBeat.m2505o(126041);
    }

    /* renamed from: a */
    private void m13425a(C5691b c5691b, C5703d c5703d) {
        AppMethodBeat.m2504i(126050);
        this.f2105b = true;
        mo16873cS(this.f2107h);
        if (this.zXV == null) {
            this.zXV = new LinkedList();
        }
        Pair pair = new Pair(c5691b, c5703d);
        if (this.f2113v) {
            m13427b(pair, this.zXW);
            AppMethodBeat.m2505o(126050);
            return;
        }
        this.zXV.add(pair);
        AppMethodBeat.m2505o(126050);
    }
}
