package com.tencent.p177mm.sdk.p604g.p606b;

import android.os.Build.VERSION;
import android.os.Looper;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.p604g.p608d.C4967b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.tencent.mm.sdk.g.b.c */
public class C40613c implements C4946a {
    private static final C40615b xEn = new C40614a();
    private static final RuntimePermission xEo = new RuntimePermission("modifyThread");
    private volatile int cml;
    private String name;
    private final ReentrantLock xDM = new ReentrantLock();
    private final AtomicInteger xEe = new AtomicInteger(-536870912);
    private final BlockingQueue<Runnable> xEf;
    private final HashSet<C23494c> xEg = new HashSet();
    private final HashSet<C23494c> xEh = new HashSet();
    private final Condition xEi = this.xDM.newCondition();
    private int xEj;
    private long xEk;
    private volatile C40615b xEl;
    private volatile int xEm;

    /* renamed from: com.tencent.mm.sdk.g.b.c$c */
    final class C23494c extends AbstractQueuedSynchronizer implements C4967b {
        /* renamed from: id */
        volatile int f4419id;
        Runnable xEq;
        volatile long xEr;

        C23494c(Runnable runnable) {
            AppMethodBeat.m2504i(52595);
            setState(-1);
            this.xEq = runnable;
            AppMethodBeat.m2505o(52595);
        }

        public static boolean dqj() {
            AppMethodBeat.m2504i(52596);
            if (VERSION.SDK_INT >= 23) {
                boolean isIdle = Looper.myLooper().getQueue().isIdle();
                AppMethodBeat.m2505o(52596);
                return isIdle;
            }
            AppMethodBeat.m2505o(52596);
            return false;
        }

        public final void run() {
            AppMethodBeat.m2504i(52597);
            C40613c.this.mo64062b(this);
            AppMethodBeat.m2505o(52597);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean isHeldExclusively() {
            AppMethodBeat.m2504i(52598);
            if (getState() != 0) {
                AppMethodBeat.m2505o(52598);
                return true;
            }
            AppMethodBeat.m2505o(52598);
            return false;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean tryAcquire(int i) {
            AppMethodBeat.m2504i(52599);
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                AppMethodBeat.m2505o(52599);
                return true;
            }
            AppMethodBeat.m2505o(52599);
            return false;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean tryRelease(int i) {
            AppMethodBeat.m2504i(52600);
            setExclusiveOwnerThread(null);
            setState(0);
            AppMethodBeat.m2505o(52600);
            return true;
        }

        public final boolean isLocked() {
            AppMethodBeat.m2504i(52601);
            boolean isHeldExclusively = isHeldExclusively();
            AppMethodBeat.m2505o(52601);
            return isHeldExclusively;
        }

        public final String getKey() {
            AppMethodBeat.m2504i(52602);
            String str = "ForkThreadPool#" + C40613c.this.name + this.f4419id;
            AppMethodBeat.m2505o(52602);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.sdk.g.b.c$a */
    public static class C40614a implements C40615b {
        /* renamed from: a */
        public final void mo64065a(Runnable runnable, C40613c c40613c) {
            AppMethodBeat.m2504i(52594);
            RejectedExecutionException rejectedExecutionException = new RejectedExecutionException("Task " + runnable.toString() + " rejected from " + c40613c.toString());
            AppMethodBeat.m2505o(52594);
            throw rejectedExecutionException;
        }
    }

    /* renamed from: com.tencent.mm.sdk.g.b.c$b */
    public interface C40615b {
        /* renamed from: a */
        void mo64065a(Runnable runnable, C40613c c40613c);
    }

    /* renamed from: gX */
    private static boolean m70051gX(int i, int i2) {
        return i >= i2;
    }

    /* renamed from: Mf */
    private boolean m70044Mf(int i) {
        AppMethodBeat.m2504i(52603);
        boolean compareAndSet = this.xEe.compareAndSet(i, i - 1);
        AppMethodBeat.m2505o(52603);
        return compareAndSet;
    }

    private void dqf() {
        AppMethodBeat.m2504i(52604);
        do {
        } while (!m70044Mf(this.xEe.get()));
        AppMethodBeat.m2505o(52604);
    }

    static {
        AppMethodBeat.m2504i(52625);
        AppMethodBeat.m2505o(52625);
    }

    /* renamed from: Mg */
    private void m70045Mg(int i) {
        AppMethodBeat.m2504i(52605);
        int i2;
        do {
            i2 = this.xEe.get();
            if (i != -536870912 && C40613c.m70051gX(i2, i)) {
                break;
            }
        } while (!this.xEe.compareAndSet(i2, (536870911 & i2) | i));
        AppMethodBeat.m2505o(52605);
    }

    /* JADX WARNING: Missing block: B:20:0x0045, code skipped:
            r6.xEe.set(1610612736);
            r6.xEi.signalAll();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dqg() {
        AppMethodBeat.m2504i(52606);
        while (true) {
            Object obj;
            int i = this.xEe.get();
            if (i < 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null || C40613c.m70051gX(i, ErrorDialogData.SUPPRESSED) || ((-536870912 & i) == 0 && !this.xEf.isEmpty())) {
                AppMethodBeat.m2505o(52606);
            } else if ((536870911 & i) != 0) {
                AppMethodBeat.m2505o(52606);
                return;
            } else {
                ReentrantLock reentrantLock = this.xDM;
                reentrantLock.lock();
                try {
                    if (this.xEe.compareAndSet(i, ErrorDialogData.SUPPRESSED)) {
                        break;
                    }
                    reentrantLock.unlock();
                } finally {
                    reentrantLock.unlock();
                    AppMethodBeat.m2505o(52606);
                }
            }
        }
        AppMethodBeat.m2505o(52606);
    }

    /* renamed from: aq */
    private void m70050aq(Runnable runnable) {
        AppMethodBeat.m2504i(52607);
        this.xEl.mo64065a(runnable, this);
        AppMethodBeat.m2505o(52607);
    }

    /* JADX WARNING: Missing block: B:7:0x0023, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(52608);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private boolean m70049a(Runnable runnable, boolean z) {
        Throwable th;
        boolean z2 = false;
        AppMethodBeat.m2504i(52608);
        loop0:
        while (true) {
            int i = this.xEe.get();
            int i2 = i & -536870912;
            if (i2 < 0 || (i2 == 0 && runnable == null && !this.xEf.isEmpty())) {
                while (true) {
                    int i3 = i;
                    int i4 = i3 & 536870911;
                    if (i4 >= 536870911) {
                        break loop0;
                    }
                    if (i4 >= (z ? this.cml : this.xEm)) {
                        break loop0;
                    } else if (this.xEe.compareAndSet(i3, i3 + 1)) {
                        C23494c c23494c;
                        try {
                            c23494c = new C23494c(runnable);
                            ReentrantLock reentrantLock;
                            try {
                                boolean z3;
                                reentrantLock = this.xDM;
                                reentrantLock.lock();
                                i3 = this.xEe.get() & -536870912;
                                if (i3 < 0 || (i3 == 0 && runnable == null)) {
                                    this.xEg.add(c23494c);
                                    i3 = this.xEg.size();
                                    if (i3 > this.xEj) {
                                        this.xEj = i3;
                                    }
                                    z3 = true;
                                } else {
                                    i3 = 0;
                                    z3 = false;
                                }
                                reentrantLock.unlock();
                                if (z3) {
                                    c23494c.f4419id = i3;
                                    C7305d.xDG.execute(c23494c);
                                    z2 = true;
                                }
                                if (!z2) {
                                    m70047a(c23494c);
                                }
                                AppMethodBeat.m2505o(52608);
                            } catch (Throwable th2) {
                                th = th2;
                                m70047a(c23494c);
                                AppMethodBeat.m2505o(52608);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            c23494c = null;
                            m70047a(c23494c);
                            AppMethodBeat.m2505o(52608);
                            throw th;
                        }
                    } else {
                        i = this.xEe.get();
                        if ((i & -536870912) == i2) {
                        }
                    }
                }
            }
        }
        AppMethodBeat.m2505o(52608);
        return z2;
    }

    /* renamed from: a */
    private void m70047a(C23494c c23494c) {
        AppMethodBeat.m2504i(52609);
        ReentrantLock reentrantLock = this.xDM;
        reentrantLock.lock();
        if (c23494c != null) {
            try {
                this.xEg.remove(c23494c);
            } catch (Throwable th) {
                reentrantLock.unlock();
                AppMethodBeat.m2505o(52609);
            }
        }
        dqf();
        dqg();
        reentrantLock.unlock();
        AppMethodBeat.m2505o(52609);
    }

    /* renamed from: a */
    private void m70048a(C23494c c23494c, boolean z) {
        AppMethodBeat.m2504i(52610);
        ReentrantLock reentrantLock = this.xDM;
        if ((this.xEe.get() & 536870911) > this.cml || z) {
            dqf();
            reentrantLock.lock();
            try {
                this.xEk += c23494c.xEr;
                c23494c.xEr = 0;
                this.xEg.remove(c23494c);
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                AppMethodBeat.m2505o(52610);
            }
        } else {
            reentrantLock.lock();
            try {
                this.xEk += c23494c.xEr;
                c23494c.xEr = 0;
                c23494c.release(1);
                this.xEh.add(c23494c);
                reentrantLock.unlock();
            } catch (Throwable th2) {
                reentrantLock.unlock();
                AppMethodBeat.m2505o(52610);
            }
        }
        dqg();
        AppMethodBeat.m2505o(52610);
    }

    private Runnable dqh() {
        AppMethodBeat.m2504i(52611);
        int i = this.xEe.get();
        int i2 = -536870912 & i;
        if (i2 < 0 || (i2 < 536870912 && !this.xEf.isEmpty())) {
            i2 = 536870911 & i;
            if (i2 <= this.xEm || ((i2 <= 1 && !this.xEf.isEmpty()) || !m70044Mf(i))) {
                Runnable runnable = (Runnable) this.xEf.poll();
                AppMethodBeat.m2505o(52611);
                return runnable;
            }
            AppMethodBeat.m2505o(52611);
            return null;
        }
        dqf();
        AppMethodBeat.m2505o(52611);
        return null;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public final void mo64062b(C23494c c23494c) {
        Throwable th;
        boolean z;
        Runnable e = null;
        AppMethodBeat.m2504i(52612);
        Thread currentThread = Thread.currentThread();
        Runnable dqh = c23494c.xEq == null ? dqh() : c23494c.xEq;
        c23494c.xEq = null;
        c23494c.release(1);
        boolean z2 = true;
        boolean z3 = false;
        while (true) {
            if (dqh == null) {
                if (!z3) {
                    break;
                }
                try {
                    dqh = dqh();
                    if (dqh == null) {
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (z2) {
                        m70048a(c23494c, true);
                    }
                    AppMethodBeat.m2505o(52612);
                    throw th;
                }
            }
            c23494c.acquire(1);
            if ((C40613c.m70051gX(this.xEe.get(), 536870912) || (Thread.interrupted() && C40613c.m70051gX(this.xEe.get(), 536870912))) && !currentThread.isInterrupted()) {
                break;
            }
            try {
                beforeExecute(currentThread, dqh);
                try {
                    dqh.run();
                    z3 = C23494c.dqj();
                    if (!z3) {
                        dqh = dqh();
                        c23494c.xEq = dqh;
                        if (dqh != null) {
                            C7305d.xDG.execute(c23494c);
                            z2 = false;
                        }
                    }
                    c23494c.xEr++;
                    c23494c.release(1);
                    dqh = null;
                } catch (RuntimeException e2) {
                    e = e2;
                    AppMethodBeat.m2505o(52612);
                    throw e;
                } catch (Error e3) {
                    e = e3;
                    AppMethodBeat.m2505o(52612);
                    throw e;
                } catch (Throwable th3) {
                    if (e == null) {
                        if (!C23494c.dqj()) {
                            e = dqh();
                            c23494c.xEq = e;
                            if (e != null) {
                                C7305d.xDG.execute(c23494c);
                                z = false;
                                AppMethodBeat.m2505o(52612);
                            }
                        }
                    }
                    z = z2;
                    AppMethodBeat.m2505o(52612);
                }
            } catch (Throwable th4) {
                th = th4;
                c23494c.xEr++;
                c23494c.release(1);
                AppMethodBeat.m2505o(52612);
                throw th;
            }
        }
        if (z2) {
            m70048a(c23494c, false);
            AppMethodBeat.m2505o(52612);
            return;
        }
        AppMethodBeat.m2505o(52612);
    }

    private boolean dqi() {
        AppMethodBeat.m2504i(52613);
        if ((this.xEe.get() & -536870912) >= 0) {
            AppMethodBeat.m2505o(52613);
            return false;
        }
        ReentrantLock reentrantLock = this.xDM;
        reentrantLock.lock();
        try {
            Iterator it = this.xEh.iterator();
            if (!it.hasNext()) {
                return false;
            }
            C23494c c23494c = (C23494c) it.next();
            c23494c.xEq = null;
            C7305d.xDG.execute(c23494c);
            it.remove();
            reentrantLock.unlock();
            AppMethodBeat.m2505o(52613);
            return true;
        } finally {
            reentrantLock.unlock();
            AppMethodBeat.m2505o(52613);
        }
    }

    public C40613c(String str, BlockingQueue<Runnable> blockingQueue) {
        AppMethodBeat.m2504i(52614);
        if (blockingQueue == null || str == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.m2505o(52614);
            throw nullPointerException;
        }
        this.name = str;
        this.cml = 6;
        this.xEm = 6;
        this.xEf = blockingQueue;
        this.xEl = new C40614a();
        AppMethodBeat.m2505o(52614);
    }

    public C40613c(String str, int i, int i2, BlockingQueue<Runnable> blockingQueue) {
        AppMethodBeat.m2504i(52615);
        if (i < 0 || i2 <= 0 || i2 < i) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.m2505o(52615);
            throw illegalArgumentException;
        } else if (blockingQueue == null || str == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.m2505o(52615);
            throw nullPointerException;
        } else {
            this.cml = i;
            this.name = str;
            this.xEm = i2;
            this.xEf = blockingQueue;
            this.xEl = new C40614a();
            AppMethodBeat.m2505o(52615);
        }
    }

    public void execute(Runnable runnable) {
        boolean z = true;
        AppMethodBeat.m2504i(52616);
        if (runnable == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.m2505o(52616);
            throw nullPointerException;
        }
        boolean z2;
        int i = this.xEe.get();
        if ((i & 536870911) < this.cml) {
            if (m70049a(runnable, true)) {
                AppMethodBeat.m2505o(52616);
                return;
            }
            i = this.xEe.get();
        }
        if (i < 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 || !this.xEf.offer(runnable)) {
            if (!m70049a(runnable, false)) {
                m70050aq(runnable);
            }
            AppMethodBeat.m2505o(52616);
        } else if (dqi()) {
            AppMethodBeat.m2505o(52616);
        } else {
            i = this.xEe.get();
            if (i >= 0) {
                z = false;
            }
            if (z || !remove(runnable)) {
                if ((i & 536870911) == 0) {
                    m70049a(null, false);
                }
                AppMethodBeat.m2505o(52616);
                return;
            }
            m70050aq(runnable);
            AppMethodBeat.m2505o(52616);
        }
    }

    public final void shutdown() {
        AppMethodBeat.m2504i(52617);
        ReentrantLock reentrantLock = this.xDM;
        reentrantLock.lock();
        try {
            m70045Mg(0);
            reentrantLock.unlock();
            dqg();
            AppMethodBeat.m2505o(52617);
        } catch (Throwable th) {
            reentrantLock.unlock();
            AppMethodBeat.m2505o(52617);
        }
    }

    private List<Runnable> shutdownNow() {
        AppMethodBeat.m2504i(52618);
        ReentrantLock reentrantLock = this.xDM;
        reentrantLock.lock();
        ReentrantLock reentrantLock2;
        try {
            m70045Mg(536870912);
            reentrantLock2 = this.xDM;
            reentrantLock2.lock();
            Iterator it = this.xEg.iterator();
            while (it.hasNext()) {
                it.next();
            }
            reentrantLock2.unlock();
            BlockingQueue blockingQueue = this.xEf;
            ArrayList arrayList = new ArrayList();
            blockingQueue.drainTo(arrayList);
            if (!blockingQueue.isEmpty()) {
                for (Object obj : (Runnable[]) blockingQueue.toArray(new Runnable[0])) {
                    if (blockingQueue.remove(obj)) {
                        arrayList.add(obj);
                    }
                }
            }
            reentrantLock.unlock();
            dqg();
            AppMethodBeat.m2505o(52618);
            return arrayList;
        } catch (Throwable th) {
            reentrantLock.unlock();
            AppMethodBeat.m2505o(52618);
        }
    }

    public boolean isShutdown() {
        boolean z;
        AppMethodBeat.m2504i(52619);
        if (this.xEe.get() < 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.m2505o(52619);
            return false;
        }
        AppMethodBeat.m2505o(52619);
        return true;
    }

    public final void reset() {
        AppMethodBeat.m2504i(52620);
        shutdownNow();
        m70045Mg(-536870912);
        AppMethodBeat.m2505o(52620);
    }

    /* renamed from: p */
    public final void mo10173p(final Runnable runnable, long j) {
        AppMethodBeat.m2504i(52621);
        C7305d.xDG.mo10159p(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(52593);
                C40613c.this.execute(runnable);
                AppMethodBeat.m2505o(52593);
            }
        }, j);
        AppMethodBeat.m2505o(52621);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(52622);
        shutdown();
        AppMethodBeat.m2505o(52622);
    }

    public final int getCorePoolSize() {
        return this.cml;
    }

    public final boolean remove(Runnable runnable) {
        AppMethodBeat.m2504i(52623);
        boolean remove = this.xEf.remove(runnable);
        dqg();
        AppMethodBeat.m2505o(52623);
        return remove;
    }

    public String toString() {
        AppMethodBeat.m2504i(52624);
        ReentrantLock reentrantLock = this.xDM;
        reentrantLock.lock();
        try {
            Object obj;
            long j = this.xEk;
            int size = this.xEg.size();
            Iterator it = this.xEg.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2;
                C23494c c23494c = (C23494c) it.next();
                j += c23494c.xEr;
                if (c23494c.isLocked()) {
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                i = i2;
            }
            reentrantLock.unlock();
            int i3 = this.xEe.get();
            if (i3 < 0) {
                obj = 1;
            } else {
                obj = null;
            }
            String str = obj != null ? "Running" : C40613c.m70051gX(i3, 1610612736) ? "Terminated" : "Shutting down";
            str = super.toString() + "[" + str + ", pool size = " + size + ", active threads = " + i + ", queued tasks = " + this.xEf.size() + ", completed tasks = " + j + "]";
            AppMethodBeat.m2505o(52624);
            return str;
        } catch (Throwable th) {
            reentrantLock.unlock();
            AppMethodBeat.m2505o(52624);
        }
    }

    /* Access modifiers changed, original: protected */
    public void beforeExecute(Thread thread, Runnable runnable) {
    }
}
