package com.tencent.mm.vending.g;

import android.os.Looper;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.h.f;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.h.h;
import com.tencent.mm.vending.j.k;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import junit.framework.Assert;

public class e<_Var> implements c<_Var> {
    private volatile boolean b = false;
    boolean d = false;
    volatile Object h;
    volatile boolean i;
    volatile Object j;
    private int m = 0;
    private long n = -1;
    private boolean o = false;
    private boolean v = false;
    boolean w = false;
    private boolean x = false;
    volatile d zXK = d.Idle;
    private Queue<b> zXL = new LinkedList();
    private volatile com.tencent.mm.vending.h.d zXM = this.zXN;
    private volatile com.tencent.mm.vending.h.d zXN = g.dMq();
    b zXO;
    b zXP;
    private b zXQ = new c();
    private com.tencent.mm.vending.h.d zXR;
    f zXS = new f(this.zXN, this.zXT);
    private com.tencent.mm.vending.h.f.a zXT = new com.tencent.mm.vending.h.f.a() {
        public final void dMl() {
            AppMethodBeat.i(126061);
            g dMp = g.dMp();
            e eVar = e.this;
            Stack stack = (Stack) dMp.b.get();
            if (stack == null) {
                stack = new Stack();
                dMp.b.set(stack);
            }
            stack.push(eVar);
            AppMethodBeat.o(126061);
        }

        public final void cT(Object obj) {
            AppMethodBeat.i(126062);
            ((Stack) g.dMp().b.get()).pop();
            synchronized (e.this) {
                try {
                    e.this.zXO = e.this.zXP;
                    e.this.zXP = null;
                    if (e.this.d) {
                        com.tencent.mm.vending.f.a.i("Vending.Pipeline", "gonna retry, do not store functional result.", new Object[0]);
                    } else {
                        e.this.h = obj;
                    }
                    if (e.this.zXK == d.Interrupted) {
                        com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupted, just return", new Object[0]);
                    } else if (e.this.zXK == d.Pausing) {
                        com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pausing, just return.", new Object[0]);
                        AppMethodBeat.o(126062);
                    } else {
                        e.this.zXK = d.Resolved;
                        e.this.cS(e.this.a(obj));
                        AppMethodBeat.o(126062);
                    }
                } finally {
                    AppMethodBeat.o(126062);
                }
            }
        }

        public final void interrupt() {
            AppMethodBeat.i(126063);
            e.this.a(true);
            AppMethodBeat.o(126063);
        }
    };
    List<Pair<com.tencent.mm.vending.g.d.a, com.tencent.mm.vending.h.d>> zXU;
    private List<Pair<com.tencent.mm.vending.g.d.b, com.tencent.mm.vending.h.d>> zXV;
    private Object zXW;
    Object zXX;

    public static class a extends Error {
        public a(String str, Object... objArr) {
            super(String.format(str, objArr));
            AppMethodBeat.i(126013);
            AppMethodBeat.o(126013);
        }
    }

    static class b {
        public long c;
        public boolean d;
        public com.tencent.mm.vending.h.d zXD;
        public com.tencent.mm.vending.c.a zYf;

        public b(com.tencent.mm.vending.c.a aVar, com.tencent.mm.vending.h.d dVar, long j, boolean z) {
            this.zYf = aVar;
            this.zXD = dVar;
            this.c = j;
            this.d = z;
        }
    }

    enum d {
        Idle,
        Resolved,
        Invoking,
        Pausing,
        Interrupted,
        AllDone;

        static {
            AppMethodBeat.o(126016);
        }
    }

    class c implements b {
        c() {
        }

        public final void cR(Object obj) {
            AppMethodBeat.i(126064);
            synchronized (e.this) {
                if (e.this.zXK == d.Interrupted) {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupted, skip this interrupt.", new Object[0]);
                } else if (e.a(e.this) || e.this.zXK == d.Pausing) {
                    try {
                        com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupt Pipeline(%s)", e.this);
                        e.this.a(false);
                        e.this.w = true;
                        e.this.zXX = obj;
                        if (e.this.zXU != null) {
                            for (Pair a : e.this.zXU) {
                                e.this.a(a, obj);
                            }
                        }
                        AppMethodBeat.o(126064);
                    } finally {
                        AppMethodBeat.o(126064);
                    }
                } else {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupt not in func scope or pending, skip this retryOrInterrupt.", new Object[0]);
                    AppMethodBeat.o(126064);
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
            AppMethodBeat.i(126065);
            synchronized (e.this) {
                try {
                    i = e.this;
                    synchronized (i) {
                        if (e.this.zXK == d.Interrupted || e.this.zXK == d.Idle) {
                            com.tencent.mm.vending.f.a.w("Vending.Pipeline", "current is state(%s), ignore pause.", e.this.zXK);
                        } else if (!e.a(e.this)) {
                            com.tencent.mm.vending.f.a.e("Vending.Pipeline", "you are using mario().pause() out of a functional scope on %s!", e.this);
                        } else if (e.b(e.this)) {
                            e.this.zXK = d.Pausing;
                        } else {
                            com.tencent.mm.vending.f.a.e("Vending.Pipeline", "you are using mario().pause() out of calling thread on %s!", e.this);
                        }
                    }
                } catch (Throwable th) {
                    i = 126065;
                } finally {
                    AppMethodBeat.o(
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

        public final void B(Object... objArr) {
            AppMethodBeat.i(126066);
            synchronized (e.this) {
                try {
                    if (e.this.zXK != d.Pausing) {
                        com.tencent.mm.vending.f.a.i("Vending.Pipeline", "state is not pausing %s, skip this wormhole", e.this.zXK);
                    } else {
                        Object obj;
                        e eVar = e.this;
                        if (objArr.length == 0) {
                            obj = null;
                        } else if (objArr.length == 1) {
                            obj = objArr[0];
                        } else {
                            obj = k.E(objArr);
                        }
                        eVar.j = obj;
                        e.this.i = true;
                        com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pipline(%s) wormhole().", e.this);
                        resume();
                        AppMethodBeat.o(126066);
                    }
                } finally {
                    AppMethodBeat.o(126066);
                }
            }
        }

        /* JADX WARNING: Missing block: B:15:0x004d, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(126067);
     */
        /* JADX WARNING: Missing block: B:21:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void resume() {
            AppMethodBeat.i(126067);
            synchronized (e.this) {
                try {
                    if (e.this.zXK != d.Pausing) {
                        com.tencent.mm.vending.f.a.e("Vending.Pipeline", "this Pipeline(%s) is not pausing! why call resume?", e.this);
                    } else {
                        if (e.a(e.this)) {
                            e.this.zXK = d.Invoking;
                        } else {
                            e.this.zXK = d.Resolved;
                        }
                        if (!e.b(e.this)) {
                            e.this.cS(e.this.a(e.this.h));
                        }
                    }
                } finally {
                    AppMethodBeat.o(126067);
                }
            }
        }
    }

    public e() {
        AppMethodBeat.i(126034);
        AppMethodBeat.o(126034);
    }

    public c<_Var> asS(String str) {
        AppMethodBeat.i(126035);
        if (str == null) {
            Assert.assertNotNull("schedulerTypeString should not be null!", str);
            AppMethodBeat.o(126035);
        } else {
            this.zXM = g.asU(str);
            Assert.assertNotNull("mCurrentScheduler should not be null!", this.zXM);
            AppMethodBeat.o(126035);
        }
        return this;
    }

    public c<_Var> b(com.tencent.mm.vending.h.d dVar) {
        AppMethodBeat.i(126036);
        if (dVar == null) {
            Assert.assertNotNull("scheduler should not be null!", dVar);
            AppMethodBeat.o(126036);
        } else {
            this.zXM = dVar;
            AppMethodBeat.o(126036);
        }
        return this;
    }

    public c<_Var> a(com.tencent.mm.vending.e.b bVar) {
        AppMethodBeat.i(126037);
        Assert.assertNotNull("keeper should not be null!", bVar);
        bVar.keep(this);
        AppMethodBeat.o(126037);
        return this;
    }

    public synchronized c<_Var> ny(long j) {
        this.n = j;
        return this;
    }

    public synchronized c<_Var> rg(boolean z) {
        this.o = z;
        return this;
    }

    public synchronized c<_Var> a(final com.tencent.mm.vending.g.c.a<_Var> aVar) {
        AppMethodBeat.i(126038);
        D(new Object[0]);
        a(new com.tencent.mm.vending.c.a<_Var, _Var>() {
            public final _Var call(_Var _var) {
                AppMethodBeat.i(126071);
                Object call = aVar.call();
                AppMethodBeat.o(126071);
                return call;
            }
        }, true);
        AppMethodBeat.o(126038);
        return this;
    }

    public synchronized c<_Var> C(Object... objArr) {
        c D;
        AppMethodBeat.i(126039);
        D = D(objArr);
        AppMethodBeat.o(126039);
        return D;
    }

    private c<_Var> D(Object... objArr) {
        AppMethodBeat.i(126040);
        if (this.zXK != d.Idle) {
            AppMethodBeat.o(126040);
        } else {
            this.zXK = d.Resolved;
            Object E = objArr.length == 0 ? null : objArr.length == 1 ? objArr[0] : k.E(objArr);
            this.h = E;
            cS(this.h);
            AppMethodBeat.o(126040);
        }
        return this;
    }

    public final b dMj() {
        return this.zXQ;
    }

    public <_Ret> c<_Ret> f(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        AppMethodBeat.i(126042);
        c c = asS("Vending.UI").c(aVar);
        AppMethodBeat.o(126042);
        return c;
    }

    public <_Ret> c<_Ret> d(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        AppMethodBeat.i(126043);
        c c = asS("Vending.LOGIC").c(aVar);
        AppMethodBeat.o(126043);
        return c;
    }

    public <_Ret> c<_Ret> e(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        AppMethodBeat.i(126044);
        c c = asS("Vending.HEAVY_WORK").c(aVar);
        AppMethodBeat.o(126044);
        return c;
    }

    private <_Ret> c<_Ret> a(com.tencent.mm.vending.c.a<_Ret, _Var> aVar, boolean z) {
        AppMethodBeat.i(126045);
        a();
        this.zXL.add(new b(aVar, this.zXM, this.n, z));
        this.n = -1;
        if (this.zXK == d.Idle) {
            AppMethodBeat.o(126045);
        } else if (this.zXK != d.Resolved) {
            AppMethodBeat.o(126045);
        } else {
            cS(this.h);
            AppMethodBeat.o(126045);
        }
        return this;
    }

    public synchronized <_Ret> c<_Ret> c(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        c a;
        AppMethodBeat.i(126046);
        a = a((com.tencent.mm.vending.c.a) aVar, this.o);
        AppMethodBeat.o(126046);
        return a;
    }

    private void a() {
        AppMethodBeat.i(126047);
        if (this.b) {
            a aVar = new a("This Pipeline(%s) has terminate and do not allow any next().", this);
            AppMethodBeat.o(126047);
            throw aVar;
        }
        AppMethodBeat.o(126047);
    }

    /* Access modifiers changed, original: final */
    public final void a(final Pair<com.tencent.mm.vending.g.d.a, com.tencent.mm.vending.h.d> pair, final Object obj) {
        AppMethodBeat.i(126048);
        com.tencent.mm.vending.h.d dVar = (com.tencent.mm.vending.h.d) pair.second;
        AnonymousClass3 anonymousClass3 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(126060);
                ((com.tencent.mm.vending.g.d.a) pair.first).bi(obj);
                AppMethodBeat.o(126060);
            }
        };
        if (dVar == null) {
            com.tencent.mm.vending.f.a.e("Vending.Pipeline", "Default scheduler %s is not available!!!", this.zXN);
            AppMethodBeat.o(126048);
            return;
        }
        dVar.o(anonymousClass3);
        AppMethodBeat.o(126048);
    }

    private void b(final Pair<com.tencent.mm.vending.g.d.b, com.tencent.mm.vending.h.d> pair, final Object obj) {
        AppMethodBeat.i(126049);
        final RuntimeException runtimeException = new RuntimeException("object is not right: ".concat(String.valueOf(obj)));
        new f((com.tencent.mm.vending.h.d) pair.second, null).a(new com.tencent.mm.vending.c.a<Void, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(126059);
                Void dMm = dMm();
                AppMethodBeat.o(126059);
                return dMm;
            }

            private Void dMm() {
                AppMethodBeat.i(126058);
                try {
                    ((com.tencent.mm.vending.g.d.b) pair.first).az(obj);
                    Void voidR = zXH;
                    AppMethodBeat.o(126058);
                    return voidR;
                } catch (ClassCastException e) {
                    if (runtimeException.getCause() == null) {
                        runtimeException.initCause(e);
                    }
                    RuntimeException runtimeException = runtimeException;
                    AppMethodBeat.o(126058);
                    throw runtimeException;
                }
            }
        }, null, this.o);
        AppMethodBeat.o(126049);
    }

    public final synchronized d<_Var> dMk() {
        this.b = true;
        return this;
    }

    public final synchronized d<_Var> a(com.tencent.mm.vending.g.d.a aVar) {
        AppMethodBeat.i(126051);
        com.tencent.mm.vending.h.d dVar = this.zXN;
        this.b = true;
        if (this.zXU == null) {
            this.zXU = new LinkedList();
        }
        Pair pair = new Pair(aVar, dVar);
        if (this.w) {
            a(pair, this.zXX);
        } else {
            this.zXU.add(pair);
        }
        AppMethodBeat.o(126051);
        return this;
    }

    public final synchronized d<_Var> a(com.tencent.mm.vending.g.d.b<_Var> bVar) {
        AppMethodBeat.i(126052);
        a((com.tencent.mm.vending.g.d.b) bVar, this.zXN);
        AppMethodBeat.o(126052);
        return this;
    }

    public final synchronized d<_Var> a(com.tencent.mm.vending.h.d dVar, com.tencent.mm.vending.g.d.b<_Var> bVar) {
        AppMethodBeat.i(126053);
        a((com.tencent.mm.vending.g.d.b) bVar, dVar);
        AppMethodBeat.o(126053);
        return this;
    }

    public final synchronized void a(boolean z) {
        AppMethodBeat.i(126054);
        if (this.zXK == d.Interrupted || this.zXK == d.AllDone) {
            AppMethodBeat.o(126054);
        } else {
            if (z) {
                if (this.zXL.size() > 0) {
                    com.tencent.mm.vending.f.a.w("Vending.Pipeline", "Pipe is not finish and be interrupt! %s pipes did not run", Integer.valueOf(this.zXL.size()));
                }
            }
            this.zXK = d.Interrupted;
            this.zXL.clear();
            this.h = null;
            if (this.zXR != null) {
                this.zXR.cancel();
            }
            AppMethodBeat.o(126054);
        }
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized Object a(Object obj) {
        Object obj2;
        AppMethodBeat.i(126055);
        if (this.d) {
            this.m++;
            com.tencent.mm.vending.f.a.i("Vending.Pipeline", "Functional %s, gonna retry %s.", this.zXO.zYf.toString(), Integer.valueOf(this.m));
            ((LinkedList) this.zXL).add(0, this.zXO);
            this.d = false;
        } else {
            if (this.i) {
                this.h = this.j;
                this.j = null;
                this.i = false;
            } else {
                this.h = obj;
            }
            this.m = 0;
        }
        obj2 = this.h;
        AppMethodBeat.o(126055);
        return obj2;
    }

    /* Access modifiers changed, original: final */
    public final void cS(final Object obj) {
        AppMethodBeat.i(126056);
        if (this.zXK != d.Resolved) {
            AppMethodBeat.o(126056);
            return;
        }
        this.zXK = d.Invoking;
        b bVar = (b) this.zXL.peek();
        if (bVar == null) {
            if (this.b) {
                this.zXK = d.AllDone;
                this.v = true;
                this.zXW = obj;
                if (this.zXV != null) {
                    for (Pair b : this.zXV) {
                        b(b, this.zXW);
                    }
                    AppMethodBeat.o(126056);
                    return;
                }
            }
            this.zXK = d.Resolved;
            AppMethodBeat.o(126056);
            return;
        }
        final com.tencent.mm.vending.c.a aVar = bVar.zYf;
        com.tencent.mm.vending.h.d dVar = bVar.zXD;
        long j = bVar.c;
        final boolean z = bVar.d;
        if (this.zXK == d.Pausing) {
            com.tencent.mm.vending.f.a.i("Vending.Pipeline", "This pipeline is Pausing. We will stop dequeFunctionAndInvoke and waiting resume() call", new Object[0]);
            AppMethodBeat.o(126056);
            return;
        }
        this.zXP = (b) this.zXL.poll();
        this.zXS.c(dVar);
        if (j < 0) {
            this.zXS.a(aVar, obj, z);
            AppMethodBeat.o(126056);
            return;
        }
        if (Looper.myLooper() == null) {
            this.zXR = new com.tencent.mm.vending.h.c();
        } else {
            this.zXR = new h(Looper.myLooper(), Looper.myLooper().toString());
        }
        this.zXR.l(new Runnable() {
            public final void run() {
                AppMethodBeat.i(126068);
                e.this.zXS.a(aVar, obj, z);
                AppMethodBeat.o(126068);
            }
        }, j);
        AppMethodBeat.o(126056);
    }

    public void dead() {
        AppMethodBeat.i(126041);
        a(true);
        AppMethodBeat.o(126041);
    }

    private void a(com.tencent.mm.vending.g.d.b bVar, com.tencent.mm.vending.h.d dVar) {
        AppMethodBeat.i(126050);
        this.b = true;
        cS(this.h);
        if (this.zXV == null) {
            this.zXV = new LinkedList();
        }
        Pair pair = new Pair(bVar, dVar);
        if (this.v) {
            b(pair, this.zXW);
            AppMethodBeat.o(126050);
            return;
        }
        this.zXV.add(pair);
        AppMethodBeat.o(126050);
    }
}
