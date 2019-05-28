package kotlinx.coroutines;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.p700a.C24581r;
import kotlinx.coroutines.p700a.C31181j;
import kotlinx.coroutines.p700a.C31181j.C31182a;
import kotlinx.coroutines.p700a.C31181j.C31183b;
import kotlinx.coroutines.p700a.C31185q;
import kotlinx.coroutines.p700a.C46845m;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p002c.C41366e;
import p000a.p005f.p007b.C25052j;
import p000a.p009h.C0016h;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0003345B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0004J\u0010\u0010\u0017\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u0019H\u0002J\u001c\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\n\u0010\u001d\u001a\u00060\u0018j\u0002`\u0019H\u0016J\u0014\u0010\u001e\u001a\u00020\f2\n\u0010\u001f\u001a\u00060\u0018j\u0002`\u0019H\u0002J\u0019\u0010 \u001a\u00020\u00162\n\u0010\u001f\u001a\u00060\u0018j\u0002`\u0019H\u0000¢\u0006\u0002\b!J\b\u0010\"\u001a\u00020\fH$J\b\u0010#\u001a\u00020\u0012H\u0016J\u0015\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\bH\u0000¢\u0006\u0002\b&J\b\u0010'\u001a\u00020\u0016H\u0004J\b\u0010(\u001a\u00020\u0016H\u0004J\u0015\u0010)\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\bH\u0000¢\u0006\u0002\b*J\u0010\u0010+\u001a\u00020,2\u0006\u0010%\u001a\u00020\bH\u0002J\u001e\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u00122\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001600H\u0016J\u0010\u00101\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\bH\u0002J\b\u00102\u001a\u00020\u0016H$R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\fX¤\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\f8DX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u00066"}, dWq = {"Lkotlinx/coroutines/EventLoopBase;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "Lkotlinx/coroutines/EventLoop;", "()V", "_delayed", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopBase$DelayedTask;", "_queue", "", "isCompleted", "", "()Z", "isDelayedEmpty", "isEmpty", "isQueueEmpty", "nextTime", "", "getNextTime", "()J", "closeQueue", "", "dequeue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "enqueueImpl", "task", "execute", "execute$kotlinx_coroutines_core", "isCorrectThread", "processNextEvent", "removeDelayedImpl", "delayedTask", "removeDelayedImpl$kotlinx_coroutines_core", "rescheduleAllDelayed", "resetAll", "schedule", "schedule$kotlinx_coroutines_core", "scheduleImpl", "", "scheduleResumeAfterDelay", "timeMillis", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "shouldUnpark", "unpark", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.at */
public abstract class C16450at extends C24596w implements C31186aj, C36625as {
    private static final AtomicReferenceFieldUpdater BQk = AtomicReferenceFieldUpdater.newUpdater(C16450at.class, Object.class, "BQj");
    private static final AtomicReferenceFieldUpdater BQm = AtomicReferenceFieldUpdater.newUpdater(C16450at.class, Object.class, "BQl");
    volatile Object BQj = null;
    volatile Object BQl = null;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"Lkotlinx/coroutines/EventLoopBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopBase$DelayedTask;", "timeMillis", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "kotlinx-coroutines-core"})
    /* renamed from: kotlinx.coroutines.at$a */
    final class C16451a extends C16452b {
        private final C24594i<C37091y> BQn;
        final /* synthetic */ C16450at BQo;

        /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
            jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 5, insn: 0x0006: INVOKE  (r5 java.lang.Object), (r0 java.lang.String) a.f.b.j.p(java.lang.Object, java.lang.String):void type: STATIC, block:B:0:0x0000, method: kotlinx.coroutines.at.a.<init>(kotlinx.coroutines.at, kotlinx.coroutines.i):void
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:162)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:133)
            	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
            	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal$$Lambda$62/242951823.accept(Unknown Source)
            	at java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at jadx.core.dex.visitors.DepthTraversal$$Lambda$61/384311550.accept(Unknown Source)
            	at java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            */
        public C16451a(kotlinx.coroutines.C16450at r3, long r4) {
            /*
            r2 = this;
            r2 = 118575; // 0x1cf2f float:1.66159E-40 double:5.8584E-319;
            r0 = "cont";
            p000a.p005f.p007b.C25052j.m39376p(r5, r0);
            r3.BQo = r4;
            r3.<init>();
            com.tencent.matrix.trace.core.AppMethodBeat.m2504i(r2);
            r3.BQn = r5;
            r1 = r3.BQn;
            r3 = (kotlinx.coroutines.C41155ap) r3;
            r0 = "receiver$0";
            p000a.p005f.p007b.C25052j.m39376p(r1, r0);
            r0 = "handle";
            p000a.p005f.p007b.C25052j.m39376p(r3, r0);
            r0 = new kotlinx.coroutines.aq;
            r0.<init>(r3);
            r0 = (kotlinx.coroutines.C25024h) r0;
            r0 = (p000a.p005f.p006a.C17126b) r0;
            r1.mo41383h(r0);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r2);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C16450at$C16451a.<init>(kotlinx.coroutines.at, kotlinx.coroutines.i):void");
        }

        public final void run() {
            AppMethodBeat.m2504i(118574);
            this.BQn.mo41382a(this.BQo, C37091y.AUy);
            AppMethodBeat.m2505o(118574);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0000H\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u001c\u0010\u001e\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00000\f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0007J\b\u0010%\u001a\u00020&H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R0\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, dWq = {"Lkotlinx/coroutines/EventLoopBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "timeMillis", "", "(J)V", "_heap", "", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "nanoTime", "compareTo", "other", "dispose", "", "rescheduleOnShutdown", "schedule", "delayed", "eventLoop", "Lkotlinx/coroutines/EventLoopBase;", "timeToExecute", "", "now", "toString", "", "kotlinx-coroutines-core"})
    /* renamed from: kotlinx.coroutines.at$b */
    public static abstract class C16452b implements Comparable<C16452b>, Runnable, C24581r, C41155ap {
        private Object BQp;
        private int index = -1;
        public final long nanoTime = (C41158bs.elC().nanoTime() + C24589au.m38233nY(1000));

        public /* synthetic */ int compareTo(Object obj) {
            C16452b c16452b = (C16452b) obj;
            C25052j.m39376p(c16452b, FacebookRequestErrorClassification.KEY_OTHER);
            long j = this.nanoTime - c16452b.nanoTime;
            if (j > 0) {
                return 1;
            }
            if (j < 0) {
                return -1;
            }
            return 0;
        }

        public final C31185q<?> elp() {
            Object obj = this.BQp;
            if (!(obj instanceof C31185q)) {
                obj = null;
            }
            return (C31185q) obj;
        }

        /* renamed from: a */
        public final void mo30321a(C31185q<?> c31185q) {
            if ((this.BQp != C24589au.BQq ? 1 : null) == null) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.BQp = c31185q;
        }

        public final int getIndex() {
            return this.index;
        }

        public final void setIndex(int i) {
            this.index = i;
        }

        /* renamed from: a */
        public final synchronized int mo30320a(C31185q<C16452b> c31185q, C16450at c16450at) {
            int i;
            C25052j.m39376p(c31185q, "delayed");
            C25052j.m39376p(c16450at, "eventLoop");
            if (this.BQp == C24589au.BQq) {
                i = 2;
            } else {
                C24581r c24581r = this;
                synchronized (c31185q) {
                    Object obj;
                    C25052j.m39376p(c24581r, "node");
                    if (c24581r.elp() == null) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    C24581r[] c24581rArr;
                    int i2;
                    c24581r.mo30321a(c31185q);
                    C24581r[] c24581rArr2 = c31185q.BRS;
                    if (c24581rArr2 == null) {
                        c24581rArr2 = new C24581r[4];
                        c31185q.BRS = c24581rArr2;
                    } else if (c31185q.size >= c24581rArr2.length) {
                        Object[] copyOf = Arrays.copyOf(c24581rArr2, c31185q.size * 2);
                        C25052j.m39375o(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                        c31185q.BRS = (C24581r[]) copyOf;
                        c24581rArr = (C24581r[]) copyOf;
                        i2 = c31185q.size;
                        c31185q.size = i2 + 1;
                        c24581rArr[i2] = c24581r;
                        c24581r.setIndex(i2);
                        c31185q.mo50951Vb(i2);
                    }
                    c24581rArr = c24581rArr2;
                    i2 = c31185q.size;
                    c31185q.size = i2 + 1;
                    c24581rArr[i2] = c24581r;
                    c24581r.setIndex(i2);
                    c31185q.mo50951Vb(i2);
                }
                i = 0;
            }
            return i;
        }

        public final synchronized void dispose() {
            Object obj = this.BQp;
            if (obj != C24589au.BQq) {
                if (!(obj instanceof C31185q)) {
                    obj = null;
                }
                C31185q c31185q = (C31185q) obj;
                if (c31185q != null) {
                    c31185q.mo50952a(this);
                }
                this.BQp = C24589au.BQq;
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
        C46845m c46845m = this.BQj;
        if (c46845m == null) {
            return true;
        }
        if (c46845m instanceof C31181j) {
            return ((C31181j) c46845m).isEmpty();
        }
        return c46845m == C24589au.BQr;
    }

    private final boolean eln() {
        C31185q c31185q = (C31185q) this.BQl;
        return c31185q == null || c31185q.isEmpty();
    }

    /* renamed from: a */
    public final void mo30313a(C41366e c41366e, Runnable runnable) {
        C25052j.m39376p(c41366e, "context");
        C25052j.m39376p(runnable, "block");
        mo30315aE(runnable);
    }

    /* renamed from: a */
    public final void mo30314a(C24594i<? super C37091y> c24594i) {
        C25052j.m39376p(c24594i, "continuation");
        C16452b c16451a = new C16451a(this, c24594i);
        C16450at c16450at = this;
        while (true) {
            C25052j.m39376p(c16451a, "delayedTask");
            C31185q c31185q = (C31185q) c16450at.BQl;
            if (c31185q == null) {
                C16450at c16450at2 = c16450at;
                BQm.compareAndSet(c16450at2, null, new C31185q());
                Object obj = c16450at2.BQl;
                if (obj == null) {
                    C25052j.dWJ();
                }
                c31185q = (C31185q) obj;
            }
            switch (c16451a.mo30320a(c31185q, c16450at)) {
                case 0:
                    C16452b c16452b;
                    Object obj2;
                    c31185q = (C31185q) c16450at.BQl;
                    if (c31185q != null) {
                        c16452b = (C16452b) c31185q.elR();
                    } else {
                        c16452b = null;
                    }
                    if (c16452b == c16451a) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        c16450at.ele();
                        return;
                    }
                    return;
                case 1:
                    c16450at = C41153ag.BPW;
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
        C31185q c31185q = (C31185q) this.BQl;
        C46845m c46845m;
        Runnable runnable;
        C46845m c46845m2;
        if (c31185q == null || c31185q.isEmpty()) {
            while (true) {
                c46845m = this.BQj;
                if (c46845m != null) {
                    runnable = null;
                    break;
                } else if (c46845m instanceof C31181j) {
                    if (c46845m == null) {
                        throw new C44941v("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                    }
                    C31181j c31181j = (C31181j) c46845m;
                    while (true) {
                        long j = c31181j.BRz;
                        if ((1152921504606846976L & j) != 0) {
                            c46845m2 = C31181j.BRD;
                            break;
                        }
                        int i = (int) ((1073741823 & j) >> null);
                        if ((((int) ((1152921503533105152L & j) >> 30)) & c31181j.mask) == (c31181j.mask & i)) {
                            c46845m2 = null;
                            break;
                        }
                        C46845m c46845m3 = c31181j.BRB.get(c31181j.mask & i);
                        if (c46845m3 == null) {
                            if (c31181j.BRC) {
                                c46845m2 = null;
                                break;
                            }
                        } else if (c46845m3 instanceof C31183b) {
                            c46845m2 = null;
                            break;
                        } else {
                            int i2 = (i + 1) & 1073741823;
                            AtomicLongFieldUpdater atomicLongFieldUpdater = C31181j.BRA;
                            C31182a c31182a = C31181j.BRE;
                            if (atomicLongFieldUpdater.compareAndSet(c31181j, j, C31182a.m50270K(j, i2))) {
                                c31181j.BRB.set(c31181j.mask & i, null);
                                c46845m2 = c46845m3;
                                break;
                            } else if (c31181j.BRC) {
                                c31181j = c31181j;
                                do {
                                    c31181j = C31181j.m50263a(c31181j, i, i2);
                                } while (c31181j != null);
                                c46845m2 = c46845m3;
                                break;
                            }
                        }
                    }
                    if (c46845m2 != C31181j.BRD) {
                        runnable = (Runnable) c46845m2;
                        break;
                    }
                    BQk.compareAndSet(this, c46845m, ((C31181j) c46845m).elO());
                } else if (c46845m == C24589au.BQr) {
                    runnable = null;
                    break;
                } else if (BQk.compareAndSet(this, c46845m, null)) {
                    if (c46845m == null) {
                        throw new C44941v("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                    }
                    runnable = (Runnable) c46845m;
                }
            }
            if (runnable != null) {
                runnable.run();
            }
            c46845m2 = this.BQj;
            if (c46845m2 != null) {
                if (c46845m2 instanceof C31181j) {
                    if (!((C31181j) c46845m2).isEmpty()) {
                        return 0;
                    }
                } else if (c46845m2 == C24589au.BQr) {
                    return Long.MAX_VALUE;
                } else {
                    return 0;
                }
            }
            c31185q = (C31185q) this.BQl;
            if (c31185q != null) {
                return Long.MAX_VALUE;
            }
            C16452b c16452b = (C16452b) c31185q.elR();
            if (c16452b == null) {
                return Long.MAX_VALUE;
            }
            return C0016h.m15ai(c16452b.nanoTime - C41158bs.elC().nanoTime(), 0);
        }
        long nanoTime = C41158bs.elC().nanoTime();
        C24581r elS;
        do {
            synchronized (c31185q) {
                elS = c31185q.elS();
                if (elS == null) {
                    elS = null;
                } else {
                    Object obj;
                    boolean aF;
                    C16452b c16452b2 = (C16452b) elS;
                    if (nanoTime - c16452b2.nanoTime >= 0) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        aF = m25230aF(c16452b2);
                    } else {
                        aF = false;
                    }
                    if (aF) {
                        elS = c31185q.mo50950Va(0);
                    } else {
                        elS = null;
                    }
                }
            }
        } while (((C16452b) elS) != null);
        while (true) {
            c46845m = this.BQj;
            if (c46845m != null) {
            }
        }
        if (runnable != null) {
        }
        c46845m2 = this.BQj;
        if (c46845m2 != null) {
        }
        c31185q = (C31185q) this.BQl;
        if (c31185q != null) {
        }
    }

    /* renamed from: aE */
    public final void mo30315aE(Runnable runnable) {
        while (true) {
            C25052j.m39376p(runnable, "task");
            if (this.m25230aF(runnable)) {
                this.ele();
                return;
            }
            this = C41153ag.BPW;
        }
    }

    /* renamed from: aF */
    private final boolean m25230aF(Runnable runnable) {
        while (true) {
            C46845m c46845m = this.BQj;
            if (c46845m == null) {
                if (BQk.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (c46845m instanceof C31181j) {
                if (c46845m != null) {
                    switch (((C31181j) c46845m).mo50947eo(runnable)) {
                        case 0:
                            return true;
                        case 1:
                            BQk.compareAndSet(this, c46845m, ((C31181j) c46845m).elO());
                            break;
                        case 2:
                            return false;
                        default:
                            break;
                    }
                }
                throw new C44941v("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
            } else if (c46845m == C24589au.BQr) {
                return false;
            } else {
                C31181j c31181j = new C31181j(8, true);
                if (c46845m == null) {
                    throw new C44941v("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
                c31181j.mo50947eo((Runnable) c46845m);
                c31181j.mo50947eo(runnable);
                if (BQk.compareAndSet(this, c46845m, c31181j)) {
                    return true;
                }
            }
        }
    }
}
