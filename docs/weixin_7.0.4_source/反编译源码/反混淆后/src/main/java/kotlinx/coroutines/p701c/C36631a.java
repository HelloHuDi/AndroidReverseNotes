package kotlinx.coroutines.p701c;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.C36623af;
import kotlinx.coroutines.C41158bs;
import kotlinx.coroutines.p700a.C31181j;
import kotlinx.coroutines.p700a.C46845m;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44847aa;
import p000a.p005f.p007b.C25052j;
import p000a.p009h.C0016h;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0000\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0003EFGB)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0011\u0010\r\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0007H\bJ\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0004H\u0002J!\u0010&\u001a\u00020'2\n\u0010(\u001a\u00060)j\u0002`*2\u0006\u0010+\u001a\u00020,H\u0000¢\u0006\u0002\b-J\u0011\u0010\u0014\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0007H\bJ\t\u0010.\u001a\u00020$H\bJ\t\u0010/\u001a\u00020\u0004H\bJ&\u00100\u001a\u00020$2\n\u0010(\u001a\u00060)j\u0002`*2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u00101\u001a\u00020\u0019J\u0014\u00102\u001a\u00020$2\n\u00103\u001a\u00060)j\u0002`*H\u0016J\t\u00104\u001a\u00020$H\bJ\t\u00105\u001a\u00020\u0004H\bJ\u0014\u00106\u001a\u00020\u00042\n\u00107\u001a\u00060 R\u00020\u0000H\u0002J\u000e\u00108\u001a\b\u0018\u00010 R\u00020\u0000H\u0002J\u0014\u00109\u001a\u00020$2\n\u00107\u001a\u00060 R\u00020\u0000H\u0002J$\u0010:\u001a\u00020$2\n\u00107\u001a\u00060 R\u00020\u00002\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u0004H\u0002J\b\u0010=\u001a\u00020$H\u0002J\u0010\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020'H\u0002J\u000e\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020\u0007J\u0018\u0010B\u001a\u00020\u00042\u0006\u0010?\u001a\u00020'2\u0006\u00101\u001a\u00020\u0019H\u0002J\b\u0010C\u001a\u00020\tH\u0016J\b\u0010D\u001a\u00020\u0019H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\r\u001a\u00020\u00048Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0014\u001a\u00020\u00048Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0018\u00010 R\u00020\u00000\u001fX\u0004¢\u0006\u0004\n\u0002\u0010!¨\u0006H"}, dWq = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "corePoolSize", "", "maxPoolSize", "idleWorkerKeepAliveNs", "", "schedulerName", "", "(IIJLjava/lang/String;)V", "_isTerminated", "Lkotlinx/atomicfu/AtomicInt;", "blockingWorkers", "getBlockingWorkers", "()I", "controlState", "Lkotlinx/atomicfu/AtomicLong;", "cpuPermits", "Ljava/util/concurrent/Semaphore;", "createdWorkers", "getCreatedWorkers", "globalQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "isTerminated", "", "()Z", "parkedWorkersStack", "random", "Ljava/util/Random;", "workers", "", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "[Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "state", "close", "", "createNewWorker", "createTask", "Lkotlinx/coroutines/scheduling/Task;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "createTask$kotlinx_coroutines_core", "decrementBlockingWorkers", "decrementCreatedWorkers", "dispatch", "fair", "execute", "command", "incrementBlockingWorkers", "incrementCreatedWorkers", "parkedWorkersStackNextIndex", "worker", "parkedWorkersStackPop", "parkedWorkersStackPush", "parkedWorkersStackTopUpdate", "oldIndex", "newIndex", "requestCpuWorker", "runSafely", "task", "shutdown", "timeout", "submitToLocalQueue", "toString", "tryUnpark", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.c.a */
public final class C36631a implements Closeable, Executor {
    private static final AtomicLongFieldUpdater BRW = AtomicLongFieldUpdater.newUpdater(C36631a.class, "BRV");
    static final AtomicLongFieldUpdater BRZ = AtomicLongFieldUpdater.newUpdater(C36631a.class, "BRY");
    private static final AtomicIntegerFieldUpdater BSb = AtomicIntegerFieldUpdater.newUpdater(C36631a.class, "BSa");
    private static final int BSf = ((int) TimeUnit.SECONDS.toNanos(1));
    private static final int BSg = ((int) C0016h.m16aj(C0016h.m15ai(C31192m.BSS / 4, 10), (long) BSf));
    private static final C46845m BSh = new C46845m("NOT_IN_STACK");
    public static final C31190a BSi = new C31190a();
    private final C24593e BRT;
    private final Semaphore BRU;
    private volatile long BRV;
    private final C24592b[] BRX;
    volatile long BRY;
    private volatile int BSa;
    private final int BSc;
    private final long BSd;
    private final String BSe;
    private final int cml;
    private final Random random;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002J\u0018\u00100\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00101\u001a\u00020\u0010H\u0002J\b\u00102\u001a\u00020\fH\u0002J\b\u00103\u001a\u00020-H\u0002J\b\u00104\u001a\u00020-H\u0002J\u0010\u00105\u001a\u00020-2\u0006\u00106\u001a\u00020\u0010H\u0002J\u000f\u00107\u001a\u0004\u0018\u000108H\u0000¢\u0006\u0002\b9J\n\u0010:\u001a\u0004\u0018\u000108H\u0002J\u0010\u0010;\u001a\u00020-2\u0006\u0010<\u001a\u00020/H\u0002J\u0006\u0010=\u001a\u00020-J\u0015\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u0003H\u0000¢\u0006\u0002\b@J\b\u0010A\u001a\u00020-H\u0016J\u0006\u0010B\u001a\u00020\fJ\u0006\u0010C\u001a\u00020\fJ\u0015\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020$H\u0000¢\u0006\u0002\bFJ\n\u0010G\u001a\u0004\u0018\u000108H\u0002J\b\u0010H\u001a\u00020-H\u0002R$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0011\u0010\u000e\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, dWq = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "index", "", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "indexInArray", "getIndexInArray", "()I", "setIndexInArray", "(I)V", "isBlocking", "", "()Z", "isParking", "lastExhaustionTime", "", "lastStealIndex", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "getLocalQueue", "()Lkotlinx/coroutines/scheduling/WorkQueue;", "nextParkedWorker", "", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "parkTimeNs", "rngState", "scheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "spins", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "getState", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "setState", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)V", "terminationDeadline", "terminationState", "Lkotlinx/atomicfu/AtomicInt;", "afterTask", "", "taskMode", "Lkotlinx/coroutines/scheduling/TaskMode;", "beforeTask", "taskSubmissionTime", "blockingQuiescence", "blockingWorkerIdle", "cpuWorkerIdle", "doPark", "nanos", "findTask", "Lkotlinx/coroutines/scheduling/Task;", "findTask$kotlinx_coroutines_core", "findTaskWithCpuPermit", "idleReset", "mode", "idleResetBeforeUnpark", "nextInt", "upperBound", "nextInt$kotlinx_coroutines_core", "run", "tryAcquireCpuPermit", "tryForbidTermination", "tryReleaseCpu", "newState", "tryReleaseCpu$kotlinx_coroutines_core", "trySteal", "tryTerminateWorker", "kotlinx-coroutines-core"})
    /* renamed from: kotlinx.coroutines.c.a$b */
    public final class C24592b extends Thread {
        private static final AtomicIntegerFieldUpdater BSn = AtomicIntegerFieldUpdater.newUpdater(C24592b.class, "BSm");
        volatile int BSj;
        final C31193o BSk;
        volatile C36632c BSl;
        private volatile int BSm;
        private long BSo;
        volatile Object BSp;
        private long BSq;
        private volatile int BSr;
        private int BSs;
        private int BSt;
        private int BSu;

        static {
            AppMethodBeat.m2504i(118352);
            AppMethodBeat.m2505o(118352);
        }

        private C24592b() {
            AppMethodBeat.m2504i(118350);
            setDaemon(true);
            this.BSk = new C31193o();
            this.BSl = C36632c.RETIRING;
            this.BSm = 0;
            this.BSp = C36631a.BSh;
            this.BSs = C36631a.BSg;
            this.BSt = C36631a.this.random.nextInt();
            AppMethodBeat.m2505o(118350);
        }

        /* renamed from: Vd */
        private void m38234Vd(int i) {
            AppMethodBeat.m2504i(118339);
            setName(C36631a.this.BSe + "-worker-" + (i == 0 ? "TERMINATED" : String.valueOf(i)));
            this.BSj = i;
            AppMethodBeat.m2505o(118339);
        }

        public C24592b(C36631a c36631a, int i) {
            this();
            AppMethodBeat.m2504i(118351);
            m38234Vd(i);
            AppMethodBeat.m2505o(118351);
        }

        public final boolean ema() {
            return this.BSl == C36632c.PARKING;
        }

        public final boolean emb() {
            AppMethodBeat.m2504i(118340);
            int i = this.BSm;
            switch (i) {
                case -1:
                    AppMethodBeat.m2505o(118340);
                    return false;
                case 0:
                    boolean compareAndSet = BSn.compareAndSet(this, 0, -1);
                    AppMethodBeat.m2505o(118340);
                    return compareAndSet;
                case 1:
                    AppMethodBeat.m2505o(118340);
                    return false;
                default:
                    Throwable illegalStateException = new IllegalStateException("Invalid terminationState = ".concat(String.valueOf(i)).toString());
                    AppMethodBeat.m2505o(118340);
                    throw illegalStateException;
            }
        }

        public final boolean emc() {
            AppMethodBeat.m2504i(118341);
            if (this.BSl == C36632c.CPU_ACQUIRED) {
                AppMethodBeat.m2505o(118341);
                return true;
            } else if (C36631a.this.BRU.tryAcquire()) {
                this.BSl = C36632c.CPU_ACQUIRED;
                AppMethodBeat.m2505o(118341);
                return true;
            } else {
                AppMethodBeat.m2505o(118341);
                return false;
            }
        }

        /* renamed from: a */
        public final boolean mo41374a(C36632c c36632c) {
            AppMethodBeat.m2504i(118342);
            C25052j.m39376p(c36632c, "newState");
            C36632c c36632c2 = this.BSl;
            boolean z = c36632c2 == C36632c.CPU_ACQUIRED;
            if (z) {
                C36631a.this.BRU.release();
            }
            if (c36632c2 != c36632c) {
                this.BSl = c36632c;
            }
            AppMethodBeat.m2505o(118342);
            return z;
        }

        public final void run() {
            AppMethodBeat.m2504i(118343);
            Object obj = null;
            while (!C36631a.m60729c(C36631a.this) && this.BSl != C36632c.TERMINATED) {
                C36635i emf = emf();
                if (emf == null) {
                    int i;
                    if (this.BSl == C36632c.CPU_ACQUIRED) {
                        i = this.BSr;
                        if (i <= 1500) {
                            this.BSr = i + 1;
                            if (i >= 1000) {
                                Thread.yield();
                            }
                        } else {
                            if (this.BSs < C36631a.BSf) {
                                this.BSs = C0016h.m20in((this.BSs * 3) >>> 1, C36631a.BSf);
                            }
                            mo41374a(C36632c.PARKING);
                            m38236oc((long) this.BSs);
                        }
                    } else {
                        mo41374a(C36632c.PARKING);
                        if (emd()) {
                            this.BSm = 0;
                            if (this.BSo == 0) {
                                this.BSo = System.nanoTime() + C36631a.this.BSd;
                            }
                            m38236oc(C36631a.this.BSd);
                            if (System.nanoTime() - this.BSo >= 0) {
                                this.BSo = 0;
                                synchronized (C36631a.this.BRX) {
                                    try {
                                        if (C36631a.m60729c(C36631a.this)) {
                                        } else if (((int) (C36631a.this.BRY & 2097151)) <= C36631a.this.cml) {
                                        } else if (!emd()) {
                                        } else if (BSn.compareAndSet(this, 0, 1)) {
                                            i = this.BSj;
                                            m38234Vd(0);
                                            C36631a.m60725a(C36631a.this, this, i, 0);
                                            int andDecrement = (int) (C36631a.BRZ.getAndDecrement(C36631a.this) & 2097151);
                                            if (andDecrement != i) {
                                                C24592b c24592b = C36631a.this.BRX[andDecrement];
                                                if (c24592b == null) {
                                                    C25052j.dWJ();
                                                }
                                                C36631a.this.BRX[i] = c24592b;
                                                c24592b.m38234Vd(i);
                                                C36631a.m60725a(C36631a.this, c24592b, andDecrement, i);
                                            }
                                            C36631a.this.BRX[andDecrement] = null;
                                            C37091y c37091y = C37091y.AUy;
                                            this.BSl = C36632c.TERMINATED;
                                        }
                                    } catch (Throwable th) {
                                        AppMethodBeat.m2505o(118343);
                                    }
                                }
                            }
                        }
                    }
                    obj = 1;
                } else {
                    Throwable assertionError;
                    C41160l eml = emf.eml();
                    if (obj != null) {
                        this.BSo = 0;
                        this.BSu = 0;
                        if (this.BSl == C36632c.PARKING) {
                            obj = eml == C41160l.PROBABLY_BLOCKING ? 1 : null;
                            if (C44847aa.AUz && obj == null) {
                                assertionError = new AssertionError("Assertion failed");
                                AppMethodBeat.m2505o(118343);
                                throw assertionError;
                            }
                            this.BSl = C36632c.BLOCKING;
                            this.BSs = C36631a.BSg;
                        }
                        this.BSr = 0;
                        obj = null;
                    }
                    long j = emf.BSM;
                    if (eml != C41160l.NON_BLOCKING) {
                        C36631a.BRZ.addAndGet(C36631a.this, 2097152);
                        if (mo41374a(C36632c.BLOCKING)) {
                            C36631a.m60730d(C36631a.this);
                        }
                    } else if (C36631a.this.BRU.availablePermits() != 0) {
                        long nanoTime = C31192m.BSX.nanoTime();
                        if (nanoTime - j >= C31192m.BSS && nanoTime - this.BSq >= C31192m.BSS * 5) {
                            this.BSq = nanoTime;
                            C36631a.m60730d(C36631a.this);
                        }
                    }
                    C36631a.m60728b(emf);
                    if (eml != C41160l.NON_BLOCKING) {
                        C36631a.BRZ.addAndGet(C36631a.this, -2097152);
                        C36632c c36632c = this.BSl;
                        if (c36632c == C36632c.TERMINATED) {
                            continue;
                        } else {
                            Object obj2;
                            if (c36632c == C36632c.BLOCKING) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if (C44847aa.AUz && obj2 == null) {
                                assertionError = new AssertionError("Expected BLOCKING state, but has ".concat(String.valueOf(c36632c)));
                                AppMethodBeat.m2505o(118343);
                                throw assertionError;
                            }
                            this.BSl = C36632c.RETIRING;
                        }
                    } else {
                        continue;
                    }
                }
            }
            mo41374a(C36632c.TERMINATED);
            AppMethodBeat.m2505o(118343);
        }

        /* renamed from: Ve */
        private int m38235Ve(int i) {
            this.BSt ^= this.BSt << 13;
            this.BSt ^= this.BSt >> 17;
            this.BSt ^= this.BSt << 5;
            int i2 = i - 1;
            if ((i2 & i) == 0) {
                return i2 & this.BSt;
            }
            return (this.BSt & BaseClientBuilder.API_PRIORITY_OTHER) % i;
        }

        /* renamed from: oc */
        private final void m38236oc(long j) {
            AppMethodBeat.m2504i(118344);
            C36631a.m60724a(C36631a.this, this);
            LockSupport.parkNanos(j);
            AppMethodBeat.m2505o(118344);
        }

        private final boolean emd() {
            AppMethodBeat.m2504i(118345);
            C36635i emi = C36631a.this.BRT.emi();
            if (emi != null) {
                this.BSk.mo50961a(emi, C36631a.this.BRT);
                AppMethodBeat.m2505o(118345);
                return false;
            }
            AppMethodBeat.m2505o(118345);
            return true;
        }

        public final void eme() {
            AppMethodBeat.m2504i(118346);
            this.BSs = C36631a.BSg;
            this.BSr = 0;
            AppMethodBeat.m2505o(118346);
        }

        public final C36635i emf() {
            AppMethodBeat.m2504i(118347);
            C36635i emg;
            if (emc()) {
                emg = emg();
                AppMethodBeat.m2505o(118347);
                return emg;
            }
            emg = this.BSk.emn();
            if (emg == null) {
                emg = C36631a.this.BRT.emi();
            }
            AppMethodBeat.m2505o(118347);
            return emg;
        }

        private final C36635i emg() {
            C36635i c36635i;
            AppMethodBeat.m2504i(118348);
            Object obj = m38235Ve(C36631a.this.cml * 2) == 0 ? 1 : null;
            if (obj != null) {
                c36635i = (C36635i) C36631a.this.BRT.elE();
                if (c36635i != null) {
                    AppMethodBeat.m2505o(118348);
                    return c36635i;
                }
            }
            c36635i = this.BSk.emn();
            if (c36635i != null) {
                AppMethodBeat.m2505o(118348);
                return c36635i;
            }
            if (obj == null) {
                c36635i = (C36635i) C36631a.this.BRT.elE();
                if (c36635i != null) {
                    AppMethodBeat.m2505o(118348);
                    return c36635i;
                }
            }
            c36635i = emh();
            AppMethodBeat.m2505o(118348);
            return c36635i;
        }

        private final C36635i emh() {
            AppMethodBeat.m2504i(118349);
            int g = ((int) (C36631a.this.BRY & 2097151));
            if (g < 2) {
                AppMethodBeat.m2505o(118349);
                return null;
            }
            int i = this.BSu;
            if (i == 0) {
                i = m38235Ve(g);
            }
            i++;
            if (i > g) {
                i = 1;
            }
            this.BSu = i;
            C24592b c24592b = C36631a.this.BRX[i];
            if (c24592b == null || c24592b == this || !this.BSk.mo50962a(c24592b.BSk, C36631a.this.BRT)) {
                AppMethodBeat.m2505o(118349);
                return null;
            }
            C36635i emn = this.BSk.emn();
            AppMethodBeat.m2505o(118349);
            return emn;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u00020\u00048\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0002R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u00020\u00048\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0002R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, dWq = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", "", "()V", "ADDED", "", "ADDED_REQUIRES_HELP", "ALLOWED", "BLOCKING_MASK", "", "BLOCKING_SHIFT", "CREATED_MASK", "FORBIDDEN", "MAX_PARK_TIME_NS", "MAX_PARK_TIME_NS$annotations", "MAX_SPINS", "MAX_SUPPORTED_POOL_SIZE", "MAX_YIELDS", "MIN_PARK_TIME_NS", "MIN_PARK_TIME_NS$annotations", "MIN_SUPPORTED_POOL_SIZE", "NOT_ADDED", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "kotlinx-coroutines-core"})
    /* renamed from: kotlinx.coroutines.c.a$a */
    public static final class C31190a {
        private C31190a() {
        }

        public /* synthetic */ C31190a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, dWq = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "RETIRING", "TERMINATED", "kotlinx-coroutines-core"})
    /* renamed from: kotlinx.coroutines.c.a$c */
    public enum C36632c {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        RETIRING,
        TERMINATED;

        static {
            AppMethodBeat.m2505o(118336);
        }
    }

    public C36631a(int i, int i2, long j, String str) {
        boolean z = true;
        C25052j.m39376p(str, "schedulerName");
        AppMethodBeat.m2504i(118329);
        this.cml = i;
        this.BSc = i2;
        this.BSd = j;
        this.BSe = str;
        Throwable illegalArgumentException;
        if (this.cml > 0) {
            if (this.BSc >= this.cml) {
                if (this.BSc <= 2097150) {
                    if (this.BSd <= 0) {
                        z = false;
                    }
                    if (z) {
                        this.BRT = new C24593e();
                        this.BRU = new Semaphore(this.cml, false);
                        this.BRV = 0;
                        this.BRX = new C24592b[(this.BSc + 1)];
                        this.BRY = 0;
                        this.random = new Random();
                        this.BSa = 0;
                        AppMethodBeat.m2505o(118329);
                        return;
                    }
                    illegalArgumentException = new IllegalArgumentException(("Idle worker keep alive time " + this.BSd + " must be positive").toString());
                    AppMethodBeat.m2505o(118329);
                    throw illegalArgumentException;
                }
                illegalArgumentException = new IllegalArgumentException(("Max pool size " + this.BSc + " should not exceed maximal supported number of threads 2097150").toString());
                AppMethodBeat.m2505o(118329);
                throw illegalArgumentException;
            }
            illegalArgumentException = new IllegalArgumentException(("Max pool size " + this.BSc + " should be greater than or equals to core pool size " + this.cml).toString());
            AppMethodBeat.m2505o(118329);
            throw illegalArgumentException;
        }
        illegalArgumentException = new IllegalArgumentException(("Core pool size " + this.cml + " should be at least 1").toString());
        AppMethodBeat.m2505o(118329);
        throw illegalArgumentException;
    }

    /* renamed from: c */
    public static final /* synthetic */ boolean m60729c(C36631a c36631a) {
        AppMethodBeat.m2504i(118330);
        boolean isTerminated = c36631a.isTerminated();
        AppMethodBeat.m2505o(118330);
        return isTerminated;
    }

    /* renamed from: d */
    public static final /* synthetic */ void m60730d(C36631a c36631a) {
        AppMethodBeat.m2504i(118332);
        c36631a.elU();
        AppMethodBeat.m2505o(118332);
    }

    private final boolean isTerminated() {
        return this.BSa != 0;
    }

    static {
        AppMethodBeat.m2504i(118335);
        AppMethodBeat.m2505o(118335);
    }

    public final void execute(Runnable runnable) {
        AppMethodBeat.m2504i(118319);
        C25052j.m39376p(runnable, "command");
        C36631a.m60723a(this, runnable);
        AppMethodBeat.m2505o(118319);
    }

    /* renamed from: a */
    public final void mo58444a(Runnable runnable, C36636j c36636j, boolean z) {
        Object obj;
        AppMethodBeat.m2504i(118321);
        C25052j.m39376p(runnable, "block");
        C25052j.m39376p(c36636j, "taskContext");
        C41158bs.elC();
        C36635i a = C36631a.m60722a(runnable, c36636j);
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof C24592b)) {
            currentThread = null;
        }
        C24592b c24592b = (C24592b) currentThread;
        int obj2;
        if (c24592b == null) {
            obj2 = 1;
        } else if (C36631a.this != this) {
            obj2 = 1;
        } else if (c24592b.BSl == C36632c.TERMINATED) {
            obj2 = 1;
        } else {
            boolean b;
            Object obj3 = -1;
            if (a.eml() == C41160l.NON_BLOCKING) {
                Object obj4;
                if (c24592b.BSl == C36632c.BLOCKING) {
                    obj4 = 1;
                } else {
                    obj4 = null;
                }
                if (obj4 != null) {
                    obj3 = null;
                } else if (!c24592b.emc()) {
                    obj2 = 1;
                }
            }
            if (z) {
                b = c24592b.BSk.mo50964b(a, this.BRT);
            } else {
                b = c24592b.BSk.mo50961a(a, this.BRT);
            }
            if (!b || c24592b.BSk.emm() > C31192m.BST) {
                obj2 = null;
            } else {
                obj2 = obj3;
            }
        }
        switch (obj2) {
            case -1:
                AppMethodBeat.m2505o(118321);
                return;
            case 1:
                if (this.BRT.mo50945en(a)) {
                    elU();
                    AppMethodBeat.m2505o(118321);
                    return;
                }
                Throwable rejectedExecutionException = new RejectedExecutionException(this.BSe + " was terminated");
                AppMethodBeat.m2505o(118321);
                throw rejectedExecutionException;
            default:
                elU();
                AppMethodBeat.m2505o(118321);
                return;
        }
    }

    /* renamed from: a */
    public static C36635i m60722a(Runnable runnable, C36636j c36636j) {
        AppMethodBeat.m2504i(118323);
        C25052j.m39376p(runnable, "block");
        C25052j.m39376p(c36636j, "taskContext");
        long nanoTime = C31192m.BSX.nanoTime();
        if (runnable instanceof C36635i) {
            ((C36635i) runnable).BSM = nanoTime;
            ((C36635i) runnable).BSN = c36636j;
            C36635i c36635i = (C36635i) runnable;
            AppMethodBeat.m2505o(118323);
            return c36635i;
        }
        C36635i c36911k = new C36911k(runnable, nanoTime, c36636j);
        AppMethodBeat.m2505o(118323);
        return c36911k;
    }

    private final void elU() {
        AppMethodBeat.m2504i(118324);
        if (this.BRU.availablePermits() == 0) {
            elV();
            AppMethodBeat.m2505o(118324);
        } else if (elV()) {
            AppMethodBeat.m2505o(118324);
        } else {
            long j = this.BRY;
            if (((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21)) < this.cml) {
                int elW = elW();
                if (elW == 1 && this.cml > 1) {
                    elW();
                }
                if (elW > 0) {
                    AppMethodBeat.m2505o(118324);
                    return;
                }
            }
            elV();
            AppMethodBeat.m2505o(118324);
        }
    }

    private final boolean elV() {
        AppMethodBeat.m2504i(118325);
        while (true) {
            C24592b elT = elT();
            if (elT == null) {
                AppMethodBeat.m2505o(118325);
                return false;
            }
            elT.eme();
            boolean ema = elT.ema();
            LockSupport.unpark(elT);
            if (ema && elT.emb()) {
                AppMethodBeat.m2505o(118325);
                return true;
            }
        }
    }

    /* JADX WARNING: Missing block: B:18:0x0041, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(118326);
     */
    /* JADX WARNING: Missing block: B:44:?, code skipped:
            return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int elW() {
        int i = 0;
        AppMethodBeat.m2504i(118326);
        synchronized (this.BRX) {
            try {
                if (isTerminated()) {
                } else {
                    long j = this.BRY;
                    int i2 = (int) (j & 2097151);
                    int i3 = i2 - ((int) ((j & 4398044413952L) >> 21));
                    if (i3 >= this.cml) {
                        AppMethodBeat.m2505o(118326);
                        return 0;
                    } else if (i2 >= this.BSc || this.BRU.availablePermits() == 0) {
                    } else {
                        int i4 = ((int) (this.BRY & 2097151)) + 1;
                        if (i4 <= 0 || this.BRX[i4] != null) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        Throwable illegalArgumentException;
                        if (i2 == 0) {
                            illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
                            AppMethodBeat.m2505o(118326);
                            throw illegalArgumentException;
                        }
                        C24592b c24592b = new C24592b(this, i4);
                        c24592b.start();
                        if (i4 == ((int) (BRZ.incrementAndGet(this) & 2097151))) {
                            i = 1;
                        }
                        if (i == 0) {
                            illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
                            AppMethodBeat.m2505o(118326);
                            throw illegalArgumentException;
                        }
                        this.BRX[i4] = c24592b;
                        i = i3 + 1;
                        AppMethodBeat.m2505o(118326);
                        return i;
                    }
                }
            } finally {
                AppMethodBeat.m2505o(118326);
            }
        }
        return -1;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String toString() {
        AppMethodBeat.m2504i(118327);
        ArrayList arrayList = new ArrayList();
        C24592b[] c24592bArr = this.BRX;
        int length = c24592bArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i < length) {
            int i7;
            C24592b c24592b = c24592bArr[i];
            if (c24592b != null) {
                int emm;
                C31193o c31193o = c24592b.BSk;
                if (c31193o.BSZ != null) {
                    emm = c31193o.emm() + 1;
                } else {
                    emm = c31193o.emm();
                }
                switch (C36633b.eQZ[c24592b.BSl.ordinal()]) {
                    case 1:
                        i6++;
                        i7 = i2;
                        continue;
                    case 2:
                        i5++;
                        arrayList.add(String.valueOf(emm) + "b");
                        i7 = i2;
                        continue;
                    case 3:
                        i4++;
                        arrayList.add(String.valueOf(emm) + "c");
                        i7 = i2;
                        continue;
                    case 4:
                        i3++;
                        if (emm > 0) {
                            arrayList.add(String.valueOf(emm) + "r");
                            i7 = i2;
                            continue;
                        }
                    case 5:
                        i7 = i2 + 1;
                        continue;
                }
            }
            i7 = i2;
            i++;
            i2 = i7;
            i3 = i3;
        }
        long j = this.BRY;
        StringBuilder append = new StringBuilder().append(this.BSe).append('@').append(C36623af.m60717ee(this)).append('[').append("Pool Size {core = ").append(this.cml).append(", max = ").append(this.BSc).append("}, Worker States {CPU = ").append(i4).append(", blocking = ").append(i5).append(", parked = ").append(i6).append(", retired = ").append(i3).append(", terminated = ").append(i2).append("}, running workers queues = ").append(arrayList).append(", global queue size = ");
        long j2 = ((C31181j) this.BRT.BRx).BRz;
        String stringBuilder = append.append((((int) ((j2 & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j2) >> 0))) & 1073741823).append(", Control State Workers {created = ").append((int) (2097151 & j)).append(", blocking = ").append((int) ((4398044413952L & j) >> 21)).append('}').append("]").toString();
        AppMethodBeat.m2505o(118327);
        return stringBuilder;
    }

    /* renamed from: a */
    private static void m60726a(C36635i c36635i) {
        AppMethodBeat.m2504i(118328);
        try {
            c36635i.run();
        } catch (Throwable th) {
            Thread currentThread = Thread.currentThread();
            C25052j.m39375o(currentThread, "thread");
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        } finally {
            C41158bs.elC();
            AppMethodBeat.m2505o(118328);
        }
    }

    private final C24592b elT() {
        AppMethodBeat.m2504i(118318);
        while (true) {
            long j = this.BRV;
            C24592b c24592b = this.BRX[(int) (2097151 & j)];
            if (c24592b == null) {
                AppMethodBeat.m2505o(118318);
                return null;
            }
            long j2 = -2097152 & (2097152 + j);
            int a = C36631a.m60720a(c24592b);
            if (a >= 0) {
                if (BRW.compareAndSet(this, j, j2 | ((long) a))) {
                    c24592b.BSp = BSh;
                    AppMethodBeat.m2505o(118318);
                    return c24592b;
                }
            }
        }
    }

    /* renamed from: a */
    private static int m60720a(C24592b c24592b) {
        C46845m c46845m = c24592b.BSp;
        while (c46845m != BSh) {
            if (c46845m == null) {
                return 0;
            }
            C24592b c24592b2 = (C24592b) c46845m;
            int i = c24592b2.BSj;
            if (i != 0) {
                return i;
            }
            c46845m = c24592b2.BSp;
        }
        return -1;
    }

    /* JADX WARNING: Missing block: B:35:0x008b, code skipped:
            if (r1 == null) goto L_0x008d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() {
        int i = 1;
        AppMethodBeat.m2504i(118320);
        if (BSb.compareAndSet(this, 0, 1)) {
            int i2;
            Throwable illegalStateException;
            Thread currentThread = Thread.currentThread();
            if (!(currentThread instanceof C24592b)) {
                currentThread = null;
            }
            C24592b c24592b = (C24592b) currentThread;
            synchronized (this.BRX) {
                try {
                    i2 = (int) (this.BRY & 2097151);
                } finally {
                    AppMethodBeat.m2505o(118320);
                }
            }
            if (i2 > 0) {
                int i3 = 1;
                while (true) {
                    C24592b c24592b2 = this.BRX[i3];
                    if (c24592b2 == null) {
                        C25052j.dWJ();
                    }
                    if (c24592b2 != c24592b) {
                        while (c24592b2.isAlive()) {
                            LockSupport.unpark(c24592b2);
                            c24592b2.join(10000);
                        }
                        C36632c c36632c = c24592b2.BSl;
                        if ((c36632c == C36632c.TERMINATED ? 1 : 0) == 0) {
                            illegalStateException = new IllegalStateException("Expected TERMINATED state, but found ".concat(String.valueOf(c36632c)).toString());
                            AppMethodBeat.m2505o(118320);
                            throw illegalStateException;
                        }
                        c24592b2.BSk.mo50963b(this.BRT);
                    }
                    if (i3 == i2) {
                        break;
                    }
                    i3++;
                }
            }
            this.BRT.close();
            while (true) {
                C36635i emf;
                if (c24592b != null) {
                    emf = c24592b.emf();
                }
                emf = (C36635i) this.BRT.elE();
                if (emf == null) {
                    break;
                }
                C36631a.m60726a(emf);
            }
            if (c24592b != null) {
                c24592b.mo41374a(C36632c.TERMINATED);
            }
            if (this.BRU.availablePermits() != this.cml) {
                i = 0;
            }
            if (C44847aa.AUz && i == 0) {
                illegalStateException = new AssertionError("Assertion failed");
                throw illegalStateException;
            } else {
                this.BRV = 0;
                this.BRY = 0;
            }
        }
        AppMethodBeat.m2505o(118320);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m60725a(C36631a c36631a, C24592b c24592b, int i, int i2) {
        AppMethodBeat.m2504i(118334);
        while (true) {
            long j = c36631a.BRV;
            int i3 = (int) (2097151 & j);
            long j2 = (2097152 + j) & -2097152;
            int a = i3 == i ? i2 == 0 ? C36631a.m60720a(c24592b) : i2 : i3;
            if (a >= 0) {
                if (BRW.compareAndSet(c36631a, j, j2 | ((long) a))) {
                    AppMethodBeat.m2505o(118334);
                    return;
                }
            }
        }
    }
}
