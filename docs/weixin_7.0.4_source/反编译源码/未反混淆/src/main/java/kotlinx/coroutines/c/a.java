package kotlinx.coroutines.c;

import a.aa;
import a.f.b.j;
import a.h.h;
import a.l;
import a.y;
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
import kotlinx.coroutines.a.m;
import kotlinx.coroutines.af;
import kotlinx.coroutines.bs;

@l(dWo = {1, 1, 13}, dWp = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0000\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0003EFGB)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0011\u0010\r\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0007H\bJ\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0004H\u0002J!\u0010&\u001a\u00020'2\n\u0010(\u001a\u00060)j\u0002`*2\u0006\u0010+\u001a\u00020,H\u0000¢\u0006\u0002\b-J\u0011\u0010\u0014\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0007H\bJ\t\u0010.\u001a\u00020$H\bJ\t\u0010/\u001a\u00020\u0004H\bJ&\u00100\u001a\u00020$2\n\u0010(\u001a\u00060)j\u0002`*2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u00101\u001a\u00020\u0019J\u0014\u00102\u001a\u00020$2\n\u00103\u001a\u00060)j\u0002`*H\u0016J\t\u00104\u001a\u00020$H\bJ\t\u00105\u001a\u00020\u0004H\bJ\u0014\u00106\u001a\u00020\u00042\n\u00107\u001a\u00060 R\u00020\u0000H\u0002J\u000e\u00108\u001a\b\u0018\u00010 R\u00020\u0000H\u0002J\u0014\u00109\u001a\u00020$2\n\u00107\u001a\u00060 R\u00020\u0000H\u0002J$\u0010:\u001a\u00020$2\n\u00107\u001a\u00060 R\u00020\u00002\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u0004H\u0002J\b\u0010=\u001a\u00020$H\u0002J\u0010\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020'H\u0002J\u000e\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020\u0007J\u0018\u0010B\u001a\u00020\u00042\u0006\u0010?\u001a\u00020'2\u0006\u00101\u001a\u00020\u0019H\u0002J\b\u0010C\u001a\u00020\tH\u0016J\b\u0010D\u001a\u00020\u0019H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\r\u001a\u00020\u00048Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0014\u001a\u00020\u00048Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0018\u00010 R\u00020\u00000\u001fX\u0004¢\u0006\u0004\n\u0002\u0010!¨\u0006H"}, dWq = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "corePoolSize", "", "maxPoolSize", "idleWorkerKeepAliveNs", "", "schedulerName", "", "(IIJLjava/lang/String;)V", "_isTerminated", "Lkotlinx/atomicfu/AtomicInt;", "blockingWorkers", "getBlockingWorkers", "()I", "controlState", "Lkotlinx/atomicfu/AtomicLong;", "cpuPermits", "Ljava/util/concurrent/Semaphore;", "createdWorkers", "getCreatedWorkers", "globalQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "isTerminated", "", "()Z", "parkedWorkersStack", "random", "Ljava/util/Random;", "workers", "", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "[Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "state", "close", "", "createNewWorker", "createTask", "Lkotlinx/coroutines/scheduling/Task;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "createTask$kotlinx_coroutines_core", "decrementBlockingWorkers", "decrementCreatedWorkers", "dispatch", "fair", "execute", "command", "incrementBlockingWorkers", "incrementCreatedWorkers", "parkedWorkersStackNextIndex", "worker", "parkedWorkersStackPop", "parkedWorkersStackPush", "parkedWorkersStackTopUpdate", "oldIndex", "newIndex", "requestCpuWorker", "runSafely", "task", "shutdown", "timeout", "submitToLocalQueue", "toString", "tryUnpark", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core"})
public final class a implements Closeable, Executor {
    private static final AtomicLongFieldUpdater BRW = AtomicLongFieldUpdater.newUpdater(a.class, "BRV");
    static final AtomicLongFieldUpdater BRZ = AtomicLongFieldUpdater.newUpdater(a.class, "BRY");
    private static final AtomicIntegerFieldUpdater BSb = AtomicIntegerFieldUpdater.newUpdater(a.class, "BSa");
    private static final int BSf = ((int) TimeUnit.SECONDS.toNanos(1));
    private static final int BSg = ((int) h.aj(h.ai(m.BSS / 4, 10), (long) BSf));
    private static final m BSh = new m("NOT_IN_STACK");
    public static final a BSi = new a();
    private final e BRT;
    private final Semaphore BRU;
    private volatile long BRV;
    private final b[] BRX;
    volatile long BRY;
    private volatile int BSa;
    private final int BSc;
    private final long BSd;
    private final String BSe;
    private final int cml;
    private final Random random;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002J\u0018\u00100\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00101\u001a\u00020\u0010H\u0002J\b\u00102\u001a\u00020\fH\u0002J\b\u00103\u001a\u00020-H\u0002J\b\u00104\u001a\u00020-H\u0002J\u0010\u00105\u001a\u00020-2\u0006\u00106\u001a\u00020\u0010H\u0002J\u000f\u00107\u001a\u0004\u0018\u000108H\u0000¢\u0006\u0002\b9J\n\u0010:\u001a\u0004\u0018\u000108H\u0002J\u0010\u0010;\u001a\u00020-2\u0006\u0010<\u001a\u00020/H\u0002J\u0006\u0010=\u001a\u00020-J\u0015\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u0003H\u0000¢\u0006\u0002\b@J\b\u0010A\u001a\u00020-H\u0016J\u0006\u0010B\u001a\u00020\fJ\u0006\u0010C\u001a\u00020\fJ\u0015\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020$H\u0000¢\u0006\u0002\bFJ\n\u0010G\u001a\u0004\u0018\u000108H\u0002J\b\u0010H\u001a\u00020-H\u0002R$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0011\u0010\u000e\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, dWq = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "index", "", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "indexInArray", "getIndexInArray", "()I", "setIndexInArray", "(I)V", "isBlocking", "", "()Z", "isParking", "lastExhaustionTime", "", "lastStealIndex", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "getLocalQueue", "()Lkotlinx/coroutines/scheduling/WorkQueue;", "nextParkedWorker", "", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "parkTimeNs", "rngState", "scheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "spins", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "getState", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "setState", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)V", "terminationDeadline", "terminationState", "Lkotlinx/atomicfu/AtomicInt;", "afterTask", "", "taskMode", "Lkotlinx/coroutines/scheduling/TaskMode;", "beforeTask", "taskSubmissionTime", "blockingQuiescence", "blockingWorkerIdle", "cpuWorkerIdle", "doPark", "nanos", "findTask", "Lkotlinx/coroutines/scheduling/Task;", "findTask$kotlinx_coroutines_core", "findTaskWithCpuPermit", "idleReset", "mode", "idleResetBeforeUnpark", "nextInt", "upperBound", "nextInt$kotlinx_coroutines_core", "run", "tryAcquireCpuPermit", "tryForbidTermination", "tryReleaseCpu", "newState", "tryReleaseCpu$kotlinx_coroutines_core", "trySteal", "tryTerminateWorker", "kotlinx-coroutines-core"})
    public final class b extends Thread {
        private static final AtomicIntegerFieldUpdater BSn = AtomicIntegerFieldUpdater.newUpdater(b.class, "BSm");
        volatile int BSj;
        final o BSk;
        volatile c BSl;
        private volatile int BSm;
        private long BSo;
        volatile Object BSp;
        private long BSq;
        private volatile int BSr;
        private int BSs;
        private int BSt;
        private int BSu;

        static {
            AppMethodBeat.i(118352);
            AppMethodBeat.o(118352);
        }

        private b() {
            AppMethodBeat.i(118350);
            setDaemon(true);
            this.BSk = new o();
            this.BSl = c.RETIRING;
            this.BSm = 0;
            this.BSp = a.BSh;
            this.BSs = a.BSg;
            this.BSt = a.this.random.nextInt();
            AppMethodBeat.o(118350);
        }

        private void Vd(int i) {
            AppMethodBeat.i(118339);
            setName(a.this.BSe + "-worker-" + (i == 0 ? "TERMINATED" : String.valueOf(i)));
            this.BSj = i;
            AppMethodBeat.o(118339);
        }

        public b(a aVar, int i) {
            this();
            AppMethodBeat.i(118351);
            Vd(i);
            AppMethodBeat.o(118351);
        }

        public final boolean ema() {
            return this.BSl == c.PARKING;
        }

        public final boolean emb() {
            AppMethodBeat.i(118340);
            int i = this.BSm;
            switch (i) {
                case -1:
                    AppMethodBeat.o(118340);
                    return false;
                case 0:
                    boolean compareAndSet = BSn.compareAndSet(this, 0, -1);
                    AppMethodBeat.o(118340);
                    return compareAndSet;
                case 1:
                    AppMethodBeat.o(118340);
                    return false;
                default:
                    Throwable illegalStateException = new IllegalStateException("Invalid terminationState = ".concat(String.valueOf(i)).toString());
                    AppMethodBeat.o(118340);
                    throw illegalStateException;
            }
        }

        public final boolean emc() {
            AppMethodBeat.i(118341);
            if (this.BSl == c.CPU_ACQUIRED) {
                AppMethodBeat.o(118341);
                return true;
            } else if (a.this.BRU.tryAcquire()) {
                this.BSl = c.CPU_ACQUIRED;
                AppMethodBeat.o(118341);
                return true;
            } else {
                AppMethodBeat.o(118341);
                return false;
            }
        }

        public final boolean a(c cVar) {
            AppMethodBeat.i(118342);
            j.p(cVar, "newState");
            c cVar2 = this.BSl;
            boolean z = cVar2 == c.CPU_ACQUIRED;
            if (z) {
                a.this.BRU.release();
            }
            if (cVar2 != cVar) {
                this.BSl = cVar;
            }
            AppMethodBeat.o(118342);
            return z;
        }

        public final void run() {
            AppMethodBeat.i(118343);
            Object obj = null;
            while (!a.c(a.this) && this.BSl != c.TERMINATED) {
                i emf = emf();
                if (emf == null) {
                    int i;
                    if (this.BSl == c.CPU_ACQUIRED) {
                        i = this.BSr;
                        if (i <= 1500) {
                            this.BSr = i + 1;
                            if (i >= 1000) {
                                Thread.yield();
                            }
                        } else {
                            if (this.BSs < a.BSf) {
                                this.BSs = h.in((this.BSs * 3) >>> 1, a.BSf);
                            }
                            a(c.PARKING);
                            oc((long) this.BSs);
                        }
                    } else {
                        a(c.PARKING);
                        if (emd()) {
                            this.BSm = 0;
                            if (this.BSo == 0) {
                                this.BSo = System.nanoTime() + a.this.BSd;
                            }
                            oc(a.this.BSd);
                            if (System.nanoTime() - this.BSo >= 0) {
                                this.BSo = 0;
                                synchronized (a.this.BRX) {
                                    try {
                                        if (a.c(a.this)) {
                                        } else if (((int) (a.this.BRY & 2097151)) <= a.this.cml) {
                                        } else if (!emd()) {
                                        } else if (BSn.compareAndSet(this, 0, 1)) {
                                            i = this.BSj;
                                            Vd(0);
                                            a.a(a.this, this, i, 0);
                                            int andDecrement = (int) (a.BRZ.getAndDecrement(a.this) & 2097151);
                                            if (andDecrement != i) {
                                                b bVar = a.this.BRX[andDecrement];
                                                if (bVar == null) {
                                                    j.dWJ();
                                                }
                                                a.this.BRX[i] = bVar;
                                                bVar.Vd(i);
                                                a.a(a.this, bVar, andDecrement, i);
                                            }
                                            a.this.BRX[andDecrement] = null;
                                            y yVar = y.AUy;
                                            this.BSl = c.TERMINATED;
                                        }
                                    } catch (Throwable th) {
                                        AppMethodBeat.o(118343);
                                    }
                                }
                            }
                        }
                    }
                    obj = 1;
                } else {
                    Throwable assertionError;
                    l eml = emf.eml();
                    if (obj != null) {
                        this.BSo = 0;
                        this.BSu = 0;
                        if (this.BSl == c.PARKING) {
                            obj = eml == l.PROBABLY_BLOCKING ? 1 : null;
                            if (aa.AUz && obj == null) {
                                assertionError = new AssertionError("Assertion failed");
                                AppMethodBeat.o(118343);
                                throw assertionError;
                            }
                            this.BSl = c.BLOCKING;
                            this.BSs = a.BSg;
                        }
                        this.BSr = 0;
                        obj = null;
                    }
                    long j = emf.BSM;
                    if (eml != l.NON_BLOCKING) {
                        a.BRZ.addAndGet(a.this, 2097152);
                        if (a(c.BLOCKING)) {
                            a.d(a.this);
                        }
                    } else if (a.this.BRU.availablePermits() != 0) {
                        long nanoTime = m.BSX.nanoTime();
                        if (nanoTime - j >= m.BSS && nanoTime - this.BSq >= m.BSS * 5) {
                            this.BSq = nanoTime;
                            a.d(a.this);
                        }
                    }
                    a.b(emf);
                    if (eml != l.NON_BLOCKING) {
                        a.BRZ.addAndGet(a.this, -2097152);
                        c cVar = this.BSl;
                        if (cVar == c.TERMINATED) {
                            continue;
                        } else {
                            Object obj2;
                            if (cVar == c.BLOCKING) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if (aa.AUz && obj2 == null) {
                                assertionError = new AssertionError("Expected BLOCKING state, but has ".concat(String.valueOf(cVar)));
                                AppMethodBeat.o(118343);
                                throw assertionError;
                            }
                            this.BSl = c.RETIRING;
                        }
                    } else {
                        continue;
                    }
                }
            }
            a(c.TERMINATED);
            AppMethodBeat.o(118343);
        }

        private int Ve(int i) {
            this.BSt ^= this.BSt << 13;
            this.BSt ^= this.BSt >> 17;
            this.BSt ^= this.BSt << 5;
            int i2 = i - 1;
            if ((i2 & i) == 0) {
                return i2 & this.BSt;
            }
            return (this.BSt & BaseClientBuilder.API_PRIORITY_OTHER) % i;
        }

        private final void oc(long j) {
            AppMethodBeat.i(118344);
            a.a(a.this, this);
            LockSupport.parkNanos(j);
            AppMethodBeat.o(118344);
        }

        private final boolean emd() {
            AppMethodBeat.i(118345);
            i emi = a.this.BRT.emi();
            if (emi != null) {
                this.BSk.a(emi, a.this.BRT);
                AppMethodBeat.o(118345);
                return false;
            }
            AppMethodBeat.o(118345);
            return true;
        }

        public final void eme() {
            AppMethodBeat.i(118346);
            this.BSs = a.BSg;
            this.BSr = 0;
            AppMethodBeat.o(118346);
        }

        public final i emf() {
            AppMethodBeat.i(118347);
            i emg;
            if (emc()) {
                emg = emg();
                AppMethodBeat.o(118347);
                return emg;
            }
            emg = this.BSk.emn();
            if (emg == null) {
                emg = a.this.BRT.emi();
            }
            AppMethodBeat.o(118347);
            return emg;
        }

        private final i emg() {
            i iVar;
            AppMethodBeat.i(118348);
            Object obj = Ve(a.this.cml * 2) == 0 ? 1 : null;
            if (obj != null) {
                iVar = (i) a.this.BRT.elE();
                if (iVar != null) {
                    AppMethodBeat.o(118348);
                    return iVar;
                }
            }
            iVar = this.BSk.emn();
            if (iVar != null) {
                AppMethodBeat.o(118348);
                return iVar;
            }
            if (obj == null) {
                iVar = (i) a.this.BRT.elE();
                if (iVar != null) {
                    AppMethodBeat.o(118348);
                    return iVar;
                }
            }
            iVar = emh();
            AppMethodBeat.o(118348);
            return iVar;
        }

        private final i emh() {
            AppMethodBeat.i(118349);
            int g = ((int) (a.this.BRY & 2097151));
            if (g < 2) {
                AppMethodBeat.o(118349);
                return null;
            }
            int i = this.BSu;
            if (i == 0) {
                i = Ve(g);
            }
            i++;
            if (i > g) {
                i = 1;
            }
            this.BSu = i;
            b bVar = a.this.BRX[i];
            if (bVar == null || bVar == this || !this.BSk.a(bVar.BSk, a.this.BRT)) {
                AppMethodBeat.o(118349);
                return null;
            }
            i emn = this.BSk.emn();
            AppMethodBeat.o(118349);
            return emn;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u00020\u00048\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0002R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u00020\u00048\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0002R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, dWq = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", "", "()V", "ADDED", "", "ADDED_REQUIRES_HELP", "ALLOWED", "BLOCKING_MASK", "", "BLOCKING_SHIFT", "CREATED_MASK", "FORBIDDEN", "MAX_PARK_TIME_NS", "MAX_PARK_TIME_NS$annotations", "MAX_SPINS", "MAX_SUPPORTED_POOL_SIZE", "MAX_YIELDS", "MIN_PARK_TIME_NS", "MIN_PARK_TIME_NS$annotations", "MIN_SUPPORTED_POOL_SIZE", "NOT_ADDED", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "kotlinx-coroutines-core"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, dWq = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "RETIRING", "TERMINATED", "kotlinx-coroutines-core"})
    public enum c {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        RETIRING,
        TERMINATED;

        static {
            AppMethodBeat.o(118336);
        }
    }

    public a(int i, int i2, long j, String str) {
        boolean z = true;
        j.p(str, "schedulerName");
        AppMethodBeat.i(118329);
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
                        this.BRT = new e();
                        this.BRU = new Semaphore(this.cml, false);
                        this.BRV = 0;
                        this.BRX = new b[(this.BSc + 1)];
                        this.BRY = 0;
                        this.random = new Random();
                        this.BSa = 0;
                        AppMethodBeat.o(118329);
                        return;
                    }
                    illegalArgumentException = new IllegalArgumentException(("Idle worker keep alive time " + this.BSd + " must be positive").toString());
                    AppMethodBeat.o(118329);
                    throw illegalArgumentException;
                }
                illegalArgumentException = new IllegalArgumentException(("Max pool size " + this.BSc + " should not exceed maximal supported number of threads 2097150").toString());
                AppMethodBeat.o(118329);
                throw illegalArgumentException;
            }
            illegalArgumentException = new IllegalArgumentException(("Max pool size " + this.BSc + " should be greater than or equals to core pool size " + this.cml).toString());
            AppMethodBeat.o(118329);
            throw illegalArgumentException;
        }
        illegalArgumentException = new IllegalArgumentException(("Core pool size " + this.cml + " should be at least 1").toString());
        AppMethodBeat.o(118329);
        throw illegalArgumentException;
    }

    public static final /* synthetic */ boolean c(a aVar) {
        AppMethodBeat.i(118330);
        boolean isTerminated = aVar.isTerminated();
        AppMethodBeat.o(118330);
        return isTerminated;
    }

    public static final /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(118332);
        aVar.elU();
        AppMethodBeat.o(118332);
    }

    private final boolean isTerminated() {
        return this.BSa != 0;
    }

    static {
        AppMethodBeat.i(118335);
        AppMethodBeat.o(118335);
    }

    public final void execute(Runnable runnable) {
        AppMethodBeat.i(118319);
        j.p(runnable, "command");
        a(this, runnable);
        AppMethodBeat.o(118319);
    }

    public final void a(Runnable runnable, j jVar, boolean z) {
        Object obj;
        AppMethodBeat.i(118321);
        j.p(runnable, "block");
        j.p(jVar, "taskContext");
        bs.elC();
        i a = a(runnable, jVar);
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof b)) {
            currentThread = null;
        }
        b bVar = (b) currentThread;
        int obj2;
        if (bVar == null) {
            obj2 = 1;
        } else if (a.this != this) {
            obj2 = 1;
        } else if (bVar.BSl == c.TERMINATED) {
            obj2 = 1;
        } else {
            boolean b;
            Object obj3 = -1;
            if (a.eml() == l.NON_BLOCKING) {
                Object obj4;
                if (bVar.BSl == c.BLOCKING) {
                    obj4 = 1;
                } else {
                    obj4 = null;
                }
                if (obj4 != null) {
                    obj3 = null;
                } else if (!bVar.emc()) {
                    obj2 = 1;
                }
            }
            if (z) {
                b = bVar.BSk.b(a, this.BRT);
            } else {
                b = bVar.BSk.a(a, this.BRT);
            }
            if (!b || bVar.BSk.emm() > m.BST) {
                obj2 = null;
            } else {
                obj2 = obj3;
            }
        }
        switch (obj2) {
            case -1:
                AppMethodBeat.o(118321);
                return;
            case 1:
                if (this.BRT.en(a)) {
                    elU();
                    AppMethodBeat.o(118321);
                    return;
                }
                Throwable rejectedExecutionException = new RejectedExecutionException(this.BSe + " was terminated");
                AppMethodBeat.o(118321);
                throw rejectedExecutionException;
            default:
                elU();
                AppMethodBeat.o(118321);
                return;
        }
    }

    public static i a(Runnable runnable, j jVar) {
        AppMethodBeat.i(118323);
        j.p(runnable, "block");
        j.p(jVar, "taskContext");
        long nanoTime = m.BSX.nanoTime();
        if (runnable instanceof i) {
            ((i) runnable).BSM = nanoTime;
            ((i) runnable).BSN = jVar;
            i iVar = (i) runnable;
            AppMethodBeat.o(118323);
            return iVar;
        }
        i kVar = new k(runnable, nanoTime, jVar);
        AppMethodBeat.o(118323);
        return kVar;
    }

    private final void elU() {
        AppMethodBeat.i(118324);
        if (this.BRU.availablePermits() == 0) {
            elV();
            AppMethodBeat.o(118324);
        } else if (elV()) {
            AppMethodBeat.o(118324);
        } else {
            long j = this.BRY;
            if (((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21)) < this.cml) {
                int elW = elW();
                if (elW == 1 && this.cml > 1) {
                    elW();
                }
                if (elW > 0) {
                    AppMethodBeat.o(118324);
                    return;
                }
            }
            elV();
            AppMethodBeat.o(118324);
        }
    }

    private final boolean elV() {
        AppMethodBeat.i(118325);
        while (true) {
            b elT = elT();
            if (elT == null) {
                AppMethodBeat.o(118325);
                return false;
            }
            elT.eme();
            boolean ema = elT.ema();
            LockSupport.unpark(elT);
            if (ema && elT.emb()) {
                AppMethodBeat.o(118325);
                return true;
            }
        }
    }

    /* JADX WARNING: Missing block: B:18:0x0041, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(118326);
     */
    /* JADX WARNING: Missing block: B:44:?, code skipped:
            return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int elW() {
        int i = 0;
        AppMethodBeat.i(118326);
        synchronized (this.BRX) {
            try {
                if (isTerminated()) {
                } else {
                    long j = this.BRY;
                    int i2 = (int) (j & 2097151);
                    int i3 = i2 - ((int) ((j & 4398044413952L) >> 21));
                    if (i3 >= this.cml) {
                        AppMethodBeat.o(118326);
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
                            AppMethodBeat.o(118326);
                            throw illegalArgumentException;
                        }
                        b bVar = new b(this, i4);
                        bVar.start();
                        if (i4 == ((int) (BRZ.incrementAndGet(this) & 2097151))) {
                            i = 1;
                        }
                        if (i == 0) {
                            illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
                            AppMethodBeat.o(118326);
                            throw illegalArgumentException;
                        }
                        this.BRX[i4] = bVar;
                        i = i3 + 1;
                        AppMethodBeat.o(118326);
                        return i;
                    }
                }
            } finally {
                AppMethodBeat.o(118326);
            }
        }
        return -1;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String toString() {
        AppMethodBeat.i(118327);
        ArrayList arrayList = new ArrayList();
        b[] bVarArr = this.BRX;
        int length = bVarArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i < length) {
            int i7;
            b bVar = bVarArr[i];
            if (bVar != null) {
                int emm;
                o oVar = bVar.BSk;
                if (oVar.BSZ != null) {
                    emm = oVar.emm() + 1;
                } else {
                    emm = oVar.emm();
                }
                switch (b.eQZ[bVar.BSl.ordinal()]) {
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
        StringBuilder append = new StringBuilder().append(this.BSe).append('@').append(af.ee(this)).append('[').append("Pool Size {core = ").append(this.cml).append(", max = ").append(this.BSc).append("}, Worker States {CPU = ").append(i4).append(", blocking = ").append(i5).append(", parked = ").append(i6).append(", retired = ").append(i3).append(", terminated = ").append(i2).append("}, running workers queues = ").append(arrayList).append(", global queue size = ");
        long j2 = ((kotlinx.coroutines.a.j) this.BRT.BRx).BRz;
        String stringBuilder = append.append((((int) ((j2 & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j2) >> 0))) & 1073741823).append(", Control State Workers {created = ").append((int) (2097151 & j)).append(", blocking = ").append((int) ((4398044413952L & j) >> 21)).append('}').append("]").toString();
        AppMethodBeat.o(118327);
        return stringBuilder;
    }

    private static void a(i iVar) {
        AppMethodBeat.i(118328);
        try {
            iVar.run();
        } catch (Throwable th) {
            Thread currentThread = Thread.currentThread();
            j.o(currentThread, "thread");
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        } finally {
            bs.elC();
            AppMethodBeat.o(118328);
        }
    }

    private final b elT() {
        AppMethodBeat.i(118318);
        while (true) {
            long j = this.BRV;
            b bVar = this.BRX[(int) (2097151 & j)];
            if (bVar == null) {
                AppMethodBeat.o(118318);
                return null;
            }
            long j2 = -2097152 & (2097152 + j);
            int a = a(bVar);
            if (a >= 0) {
                if (BRW.compareAndSet(this, j, j2 | ((long) a))) {
                    bVar.BSp = BSh;
                    AppMethodBeat.o(118318);
                    return bVar;
                }
            }
        }
    }

    private static int a(b bVar) {
        m mVar = bVar.BSp;
        while (mVar != BSh) {
            if (mVar == null) {
                return 0;
            }
            b bVar2 = (b) mVar;
            int i = bVar2.BSj;
            if (i != 0) {
                return i;
            }
            mVar = bVar2.BSp;
        }
        return -1;
    }

    /* JADX WARNING: Missing block: B:35:0x008b, code skipped:
            if (r1 == null) goto L_0x008d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() {
        int i = 1;
        AppMethodBeat.i(118320);
        if (BSb.compareAndSet(this, 0, 1)) {
            int i2;
            Throwable illegalStateException;
            Thread currentThread = Thread.currentThread();
            if (!(currentThread instanceof b)) {
                currentThread = null;
            }
            b bVar = (b) currentThread;
            synchronized (this.BRX) {
                try {
                    i2 = (int) (this.BRY & 2097151);
                } finally {
                    AppMethodBeat.o(118320);
                }
            }
            if (i2 > 0) {
                int i3 = 1;
                while (true) {
                    b bVar2 = this.BRX[i3];
                    if (bVar2 == null) {
                        j.dWJ();
                    }
                    if (bVar2 != bVar) {
                        while (bVar2.isAlive()) {
                            LockSupport.unpark(bVar2);
                            bVar2.join(10000);
                        }
                        c cVar = bVar2.BSl;
                        if ((cVar == c.TERMINATED ? 1 : 0) == 0) {
                            illegalStateException = new IllegalStateException("Expected TERMINATED state, but found ".concat(String.valueOf(cVar)).toString());
                            AppMethodBeat.o(118320);
                            throw illegalStateException;
                        }
                        bVar2.BSk.b(this.BRT);
                    }
                    if (i3 == i2) {
                        break;
                    }
                    i3++;
                }
            }
            this.BRT.close();
            while (true) {
                i emf;
                if (bVar != null) {
                    emf = bVar.emf();
                }
                emf = (i) this.BRT.elE();
                if (emf == null) {
                    break;
                }
                a(emf);
            }
            if (bVar != null) {
                bVar.a(c.TERMINATED);
            }
            if (this.BRU.availablePermits() != this.cml) {
                i = 0;
            }
            if (aa.AUz && i == 0) {
                illegalStateException = new AssertionError("Assertion failed");
                throw illegalStateException;
            } else {
                this.BRV = 0;
                this.BRY = 0;
            }
        }
        AppMethodBeat.o(118320);
    }

    public static final /* synthetic */ void a(a aVar, b bVar, int i, int i2) {
        AppMethodBeat.i(118334);
        while (true) {
            long j = aVar.BRV;
            int i3 = (int) (2097151 & j);
            long j2 = (2097152 + j) & -2097152;
            int a = i3 == i ? i2 == 0 ? a(bVar) : i2 : i3;
            if (a >= 0) {
                if (BRW.compareAndSet(aVar, j, j2 | ((long) a))) {
                    AppMethodBeat.o(118334);
                    return;
                }
            }
        }
    }
}
