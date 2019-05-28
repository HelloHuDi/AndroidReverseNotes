package kotlinx.coroutines;

import a.c.e;
import a.f.b.j;
import a.h.h;
import a.l;
import a.v;
import a.y;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.a.m;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.a.r;

@l(dWo = {1, 1, 13}, dWp = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0003345B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0004J\u0010\u0010\u0017\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u0019H\u0002J\u001c\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\n\u0010\u001d\u001a\u00060\u0018j\u0002`\u0019H\u0016J\u0014\u0010\u001e\u001a\u00020\f2\n\u0010\u001f\u001a\u00060\u0018j\u0002`\u0019H\u0002J\u0019\u0010 \u001a\u00020\u00162\n\u0010\u001f\u001a\u00060\u0018j\u0002`\u0019H\u0000¢\u0006\u0002\b!J\b\u0010\"\u001a\u00020\fH$J\b\u0010#\u001a\u00020\u0012H\u0016J\u0015\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\bH\u0000¢\u0006\u0002\b&J\b\u0010'\u001a\u00020\u0016H\u0004J\b\u0010(\u001a\u00020\u0016H\u0004J\u0015\u0010)\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\bH\u0000¢\u0006\u0002\b*J\u0010\u0010+\u001a\u00020,2\u0006\u0010%\u001a\u00020\bH\u0002J\u001e\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u00122\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001600H\u0016J\u0010\u00101\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\bH\u0002J\b\u00102\u001a\u00020\u0016H$R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\fX¤\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\f8DX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u00066"}, dWq = {"Lkotlinx/coroutines/EventLoopBase;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "Lkotlinx/coroutines/EventLoop;", "()V", "_delayed", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopBase$DelayedTask;", "_queue", "", "isCompleted", "", "()Z", "isDelayedEmpty", "isEmpty", "isQueueEmpty", "nextTime", "", "getNextTime", "()J", "closeQueue", "", "dequeue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "enqueueImpl", "task", "execute", "execute$kotlinx_coroutines_core", "isCorrectThread", "processNextEvent", "removeDelayedImpl", "delayedTask", "removeDelayedImpl$kotlinx_coroutines_core", "rescheduleAllDelayed", "resetAll", "schedule", "schedule$kotlinx_coroutines_core", "scheduleImpl", "", "scheduleResumeAfterDelay", "timeMillis", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "shouldUnpark", "unpark", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "kotlinx-coroutines-core"})
public abstract class at extends w implements aj, as {
    private static final AtomicReferenceFieldUpdater BQk = AtomicReferenceFieldUpdater.newUpdater(at.class, Object.class, "BQj");
    private static final AtomicReferenceFieldUpdater BQm = AtomicReferenceFieldUpdater.newUpdater(at.class, Object.class, "BQl");
    volatile Object BQj = null;
    volatile Object BQl = null;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"Lkotlinx/coroutines/EventLoopBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopBase$DelayedTask;", "timeMillis", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "kotlinx-coroutines-core"})
    final class a extends b {
        private final i<y> BQn;
        final /* synthetic */ at BQo;

        /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
            jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 5, insn: 0x0006: INVOKE  (r5 java.lang.Object), (r0 java.lang.String) a.f.b.j.p(java.lang.Object, java.lang.String):void type: STATIC, block:B:0:0x0000, method: kotlinx.coroutines.at.a.<init>(kotlinx.coroutines.at, kotlinx.coroutines.i):void
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:162)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:133)
            	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
            	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal$$Lambda$62/1208201215.accept(Unknown Source)
            	at java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at jadx.core.dex.visitors.DepthTraversal$$Lambda$61/1008374824.accept(Unknown Source)
            	at java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            */
        public a(kotlinx.coroutines.at r3, long r4) {
            /*
            r2 = this;
            r2 = 118575; // 0x1cf2f float:1.66159E-40 double:5.8584E-319;
            r0 = "cont";
            a.f.b.j.p(r5, r0);
            r3.BQo = r4;
            r3.<init>();
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2);
            r3.BQn = r5;
            r1 = r3.BQn;
            r3 = (kotlinx.coroutines.ap) r3;
            r0 = "receiver$0";
            a.f.b.j.p(r1, r0);
            r0 = "handle";
            a.f.b.j.p(r3, r0);
            r0 = new kotlinx.coroutines.aq;
            r0.<init>(r3);
            r0 = (kotlinx.coroutines.h) r0;
            r0 = (a.f.a.b) r0;
            r1.h(r0);
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.at$a.<init>(kotlinx.coroutines.at, kotlinx.coroutines.i):void");
        }

        public final void run() {
            AppMethodBeat.i(118574);
            this.BQn.a(this.BQo, y.AUy);
            AppMethodBeat.o(118574);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0000H\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u001c\u0010\u001e\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00000\f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0007J\b\u0010%\u001a\u00020&H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R0\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, dWq = {"Lkotlinx/coroutines/EventLoopBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "timeMillis", "", "(J)V", "_heap", "", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "nanoTime", "compareTo", "other", "dispose", "", "rescheduleOnShutdown", "schedule", "delayed", "eventLoop", "Lkotlinx/coroutines/EventLoopBase;", "timeToExecute", "", "now", "toString", "", "kotlinx-coroutines-core"})
    public static abstract class b implements Comparable<b>, Runnable, r, ap {
        private Object BQp;
        private int index = -1;
        public final long nanoTime = (bs.elC().nanoTime() + au.nY(1000));

        public /* synthetic */ int compareTo(Object obj) {
            b bVar = (b) obj;
            j.p(bVar, FacebookRequestErrorClassification.KEY_OTHER);
            long j = this.nanoTime - bVar.nanoTime;
            if (j > 0) {
                return 1;
            }
            if (j < 0) {
                return -1;
            }
            return 0;
        }

        public final q<?> elp() {
            Object obj = this.BQp;
            if (!(obj instanceof q)) {
                obj = null;
            }
            return (q) obj;
        }

        public final void a(q<?> qVar) {
            if ((this.BQp != au.BQq ? 1 : null) == null) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.BQp = qVar;
        }

        public final int getIndex() {
            return this.index;
        }

        public final void setIndex(int i) {
            this.index = i;
        }

        public final synchronized int a(q<b> qVar, at atVar) {
            int i;
            j.p(qVar, "delayed");
            j.p(atVar, "eventLoop");
            if (this.BQp == au.BQq) {
                i = 2;
            } else {
                r rVar = this;
                synchronized (qVar) {
                    Object obj;
                    j.p(rVar, "node");
                    if (rVar.elp() == null) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    r[] rVarArr;
                    int i2;
                    rVar.a(qVar);
                    r[] rVarArr2 = qVar.BRS;
                    if (rVarArr2 == null) {
                        rVarArr2 = new r[4];
                        qVar.BRS = rVarArr2;
                    } else if (qVar.size >= rVarArr2.length) {
                        Object[] copyOf = Arrays.copyOf(rVarArr2, qVar.size * 2);
                        j.o(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                        qVar.BRS = (r[]) copyOf;
                        rVarArr = (r[]) copyOf;
                        i2 = qVar.size;
                        qVar.size = i2 + 1;
                        rVarArr[i2] = rVar;
                        rVar.setIndex(i2);
                        qVar.Vb(i2);
                    }
                    rVarArr = rVarArr2;
                    i2 = qVar.size;
                    qVar.size = i2 + 1;
                    rVarArr[i2] = rVar;
                    rVar.setIndex(i2);
                    qVar.Vb(i2);
                }
                i = 0;
            }
            return i;
        }

        public final synchronized void dispose() {
            Object obj = this.BQp;
            if (obj != au.BQq) {
                if (!(obj instanceof q)) {
                    obj = null;
                }
                q qVar = (q) obj;
                if (qVar != null) {
                    qVar.a(this);
                }
                this.BQp = au.BQq;
            }
        }

        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + ']';
        }
    }

    public abstract void ele();

    /* Access modifiers changed, original: protected|final */
    public final boolean isEmpty() {
        return elm() && eln();
    }

    private final boolean elm() {
        m mVar = this.BQj;
        if (mVar == null) {
            return true;
        }
        if (mVar instanceof kotlinx.coroutines.a.j) {
            return ((kotlinx.coroutines.a.j) mVar).isEmpty();
        }
        return mVar == au.BQr;
    }

    private final boolean eln() {
        q qVar = (q) this.BQl;
        return qVar == null || qVar.isEmpty();
    }

    public final void a(e eVar, Runnable runnable) {
        j.p(eVar, "context");
        j.p(runnable, "block");
        aE(runnable);
    }

    public final void a(i<? super y> iVar) {
        j.p(iVar, "continuation");
        b aVar = new a(this, iVar);
        at atVar = this;
        while (true) {
            j.p(aVar, "delayedTask");
            q qVar = (q) atVar.BQl;
            if (qVar == null) {
                at atVar2 = atVar;
                BQm.compareAndSet(atVar2, null, new q());
                Object obj = atVar2.BQl;
                if (obj == null) {
                    j.dWJ();
                }
                qVar = (q) obj;
            }
            switch (aVar.a(qVar, atVar)) {
                case 0:
                    b bVar;
                    Object obj2;
                    qVar = (q) atVar.BQl;
                    if (qVar != null) {
                        bVar = (b) qVar.elR();
                    } else {
                        bVar = null;
                    }
                    if (bVar == aVar) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        atVar.ele();
                        return;
                    }
                    return;
                case 1:
                    atVar = ag.BPW;
                case 2:
                    return;
                default:
                    throw new IllegalStateException("unexpected result".toString());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0025 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0142  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long elo() {
        q qVar = (q) this.BQl;
        m mVar;
        Runnable runnable;
        m mVar2;
        if (qVar == null || qVar.isEmpty()) {
            while (true) {
                mVar = this.BQj;
                if (mVar != null) {
                    runnable = null;
                    break;
                } else if (mVar instanceof kotlinx.coroutines.a.j) {
                    if (mVar == null) {
                        throw new v("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                    }
                    kotlinx.coroutines.a.j jVar = (kotlinx.coroutines.a.j) mVar;
                    while (true) {
                        long j = jVar.BRz;
                        if ((1152921504606846976L & j) != 0) {
                            mVar2 = kotlinx.coroutines.a.j.BRD;
                            break;
                        }
                        int i = (int) ((1073741823 & j) >> null);
                        if ((((int) ((1152921503533105152L & j) >> 30)) & jVar.mask) == (jVar.mask & i)) {
                            mVar2 = null;
                            break;
                        }
                        m mVar3 = jVar.BRB.get(jVar.mask & i);
                        if (mVar3 == null) {
                            if (jVar.BRC) {
                                mVar2 = null;
                                break;
                            }
                        } else if (mVar3 instanceof kotlinx.coroutines.a.j.b) {
                            mVar2 = null;
                            break;
                        } else {
                            int i2 = (i + 1) & 1073741823;
                            AtomicLongFieldUpdater atomicLongFieldUpdater = kotlinx.coroutines.a.j.BRA;
                            kotlinx.coroutines.a.j.a aVar = kotlinx.coroutines.a.j.BRE;
                            if (atomicLongFieldUpdater.compareAndSet(jVar, j, kotlinx.coroutines.a.j.a.K(j, i2))) {
                                jVar.BRB.set(jVar.mask & i, null);
                                mVar2 = mVar3;
                                break;
                            } else if (jVar.BRC) {
                                jVar = jVar;
                                do {
                                    jVar = kotlinx.coroutines.a.j.a(jVar, i, i2);
                                } while (jVar != null);
                                mVar2 = mVar3;
                                break;
                            }
                        }
                    }
                    if (mVar2 != kotlinx.coroutines.a.j.BRD) {
                        runnable = (Runnable) mVar2;
                        break;
                    }
                    BQk.compareAndSet(this, mVar, ((kotlinx.coroutines.a.j) mVar).elO());
                } else if (mVar == au.BQr) {
                    runnable = null;
                    break;
                } else if (BQk.compareAndSet(this, mVar, null)) {
                    if (mVar == null) {
                        throw new v("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                    }
                    runnable = (Runnable) mVar;
                }
            }
            if (runnable != null) {
                runnable.run();
            }
            mVar2 = this.BQj;
            if (mVar2 != null) {
                if (mVar2 instanceof kotlinx.coroutines.a.j) {
                    if (!((kotlinx.coroutines.a.j) mVar2).isEmpty()) {
                        return 0;
                    }
                } else if (mVar2 == au.BQr) {
                    return Long.MAX_VALUE;
                } else {
                    return 0;
                }
            }
            qVar = (q) this.BQl;
            if (qVar != null) {
                return Long.MAX_VALUE;
            }
            b bVar = (b) qVar.elR();
            if (bVar == null) {
                return Long.MAX_VALUE;
            }
            return h.ai(bVar.nanoTime - bs.elC().nanoTime(), 0);
        }
        long nanoTime = bs.elC().nanoTime();
        r elS;
        do {
            synchronized (qVar) {
                elS = qVar.elS();
                if (elS == null) {
                    elS = null;
                } else {
                    Object obj;
                    boolean aF;
                    b bVar2 = (b) elS;
                    if (nanoTime - bVar2.nanoTime >= 0) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        aF = aF(bVar2);
                    } else {
                        aF = false;
                    }
                    if (aF) {
                        elS = qVar.Va(0);
                    } else {
                        elS = null;
                    }
                }
            }
        } while (((b) elS) != null);
        while (true) {
            mVar = this.BQj;
            if (mVar != null) {
            }
        }
        if (runnable != null) {
        }
        mVar2 = this.BQj;
        if (mVar2 != null) {
        }
        qVar = (q) this.BQl;
        if (qVar != null) {
        }
    }

    public final void aE(Runnable runnable) {
        while (true) {
            j.p(runnable, "task");
            if (this.aF(runnable)) {
                this.ele();
                return;
            }
            this = ag.BPW;
        }
    }

    private final boolean aF(Runnable runnable) {
        while (true) {
            m mVar = this.BQj;
            if (mVar == null) {
                if (BQk.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (mVar instanceof kotlinx.coroutines.a.j) {
                if (mVar != null) {
                    switch (((kotlinx.coroutines.a.j) mVar).eo(runnable)) {
                        case 0:
                            return true;
                        case 1:
                            BQk.compareAndSet(this, mVar, ((kotlinx.coroutines.a.j) mVar).elO());
                            break;
                        case 2:
                            return false;
                        default:
                            break;
                    }
                }
                throw new v("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
            } else if (mVar == au.BQr) {
                return false;
            } else {
                kotlinx.coroutines.a.j jVar = new kotlinx.coroutines.a.j(8, true);
                if (mVar == null) {
                    throw new v("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
                jVar.eo((Runnable) mVar);
                jVar.eo(runnable);
                if (BQk.compareAndSet(this, mVar, jVar)) {
                    return true;
                }
            }
        }
    }
}
