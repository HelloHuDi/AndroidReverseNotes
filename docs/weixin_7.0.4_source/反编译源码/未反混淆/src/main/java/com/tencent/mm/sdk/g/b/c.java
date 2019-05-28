package com.tencent.mm.sdk.g.b;

import android.os.Build.VERSION;
import android.os.Looper;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
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

public class c implements a {
    private static final b xEn = new a();
    private static final RuntimePermission xEo = new RuntimePermission("modifyThread");
    private volatile int cml;
    private String name;
    private final ReentrantLock xDM = new ReentrantLock();
    private final AtomicInteger xEe = new AtomicInteger(-536870912);
    private final BlockingQueue<Runnable> xEf;
    private final HashSet<c> xEg = new HashSet();
    private final HashSet<c> xEh = new HashSet();
    private final Condition xEi = this.xDM.newCondition();
    private int xEj;
    private long xEk;
    private volatile b xEl;
    private volatile int xEm;

    final class c extends AbstractQueuedSynchronizer implements com.tencent.mm.sdk.g.d.b {
        volatile int id;
        Runnable xEq;
        volatile long xEr;

        c(Runnable runnable) {
            AppMethodBeat.i(52595);
            setState(-1);
            this.xEq = runnable;
            AppMethodBeat.o(52595);
        }

        public static boolean dqj() {
            AppMethodBeat.i(52596);
            if (VERSION.SDK_INT >= 23) {
                boolean isIdle = Looper.myLooper().getQueue().isIdle();
                AppMethodBeat.o(52596);
                return isIdle;
            }
            AppMethodBeat.o(52596);
            return false;
        }

        public final void run() {
            AppMethodBeat.i(52597);
            c.this.b(this);
            AppMethodBeat.o(52597);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean isHeldExclusively() {
            AppMethodBeat.i(52598);
            if (getState() != 0) {
                AppMethodBeat.o(52598);
                return true;
            }
            AppMethodBeat.o(52598);
            return false;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean tryAcquire(int i) {
            AppMethodBeat.i(52599);
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                AppMethodBeat.o(52599);
                return true;
            }
            AppMethodBeat.o(52599);
            return false;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean tryRelease(int i) {
            AppMethodBeat.i(52600);
            setExclusiveOwnerThread(null);
            setState(0);
            AppMethodBeat.o(52600);
            return true;
        }

        public final boolean isLocked() {
            AppMethodBeat.i(52601);
            boolean isHeldExclusively = isHeldExclusively();
            AppMethodBeat.o(52601);
            return isHeldExclusively;
        }

        public final String getKey() {
            AppMethodBeat.i(52602);
            String str = "ForkThreadPool#" + c.this.name + this.id;
            AppMethodBeat.o(52602);
            return str;
        }
    }

    public static class a implements b {
        public final void a(Runnable runnable, c cVar) {
            AppMethodBeat.i(52594);
            RejectedExecutionException rejectedExecutionException = new RejectedExecutionException("Task " + runnable.toString() + " rejected from " + cVar.toString());
            AppMethodBeat.o(52594);
            throw rejectedExecutionException;
        }
    }

    public interface b {
        void a(Runnable runnable, c cVar);
    }

    private static boolean gX(int i, int i2) {
        return i >= i2;
    }

    private boolean Mf(int i) {
        AppMethodBeat.i(52603);
        boolean compareAndSet = this.xEe.compareAndSet(i, i - 1);
        AppMethodBeat.o(52603);
        return compareAndSet;
    }

    private void dqf() {
        AppMethodBeat.i(52604);
        do {
        } while (!Mf(this.xEe.get()));
        AppMethodBeat.o(52604);
    }

    static {
        AppMethodBeat.i(52625);
        AppMethodBeat.o(52625);
    }

    private void Mg(int i) {
        AppMethodBeat.i(52605);
        int i2;
        do {
            i2 = this.xEe.get();
            if (i != -536870912 && gX(i2, i)) {
                break;
            }
        } while (!this.xEe.compareAndSet(i2, (536870911 & i2) | i));
        AppMethodBeat.o(52605);
    }

    /* JADX WARNING: Missing block: B:20:0x0045, code skipped:
            r6.xEe.set(1610612736);
            r6.xEi.signalAll();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dqg() {
        AppMethodBeat.i(52606);
        while (true) {
            Object obj;
            int i = this.xEe.get();
            if (i < 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null || gX(i, ErrorDialogData.SUPPRESSED) || ((-536870912 & i) == 0 && !this.xEf.isEmpty())) {
                AppMethodBeat.o(52606);
            } else if ((536870911 & i) != 0) {
                AppMethodBeat.o(52606);
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
                    AppMethodBeat.o(52606);
                }
            }
        }
        AppMethodBeat.o(52606);
    }

    private void aq(Runnable runnable) {
        AppMethodBeat.i(52607);
        this.xEl.a(runnable, this);
        AppMethodBeat.o(52607);
    }

    /* JADX WARNING: Missing block: B:7:0x0023, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(52608);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(Runnable runnable, boolean z) {
        Throwable th;
        boolean z2 = false;
        AppMethodBeat.i(52608);
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
                        c cVar;
                        try {
                            cVar = new c(runnable);
                            ReentrantLock reentrantLock;
                            try {
                                boolean z3;
                                reentrantLock = this.xDM;
                                reentrantLock.lock();
                                i3 = this.xEe.get() & -536870912;
                                if (i3 < 0 || (i3 == 0 && runnable == null)) {
                                    this.xEg.add(cVar);
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
                                    cVar.id = i3;
                                    d.xDG.execute(cVar);
                                    z2 = true;
                                }
                                if (!z2) {
                                    a(cVar);
                                }
                                AppMethodBeat.o(52608);
                            } catch (Throwable th2) {
                                th = th2;
                                a(cVar);
                                AppMethodBeat.o(52608);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            cVar = null;
                            a(cVar);
                            AppMethodBeat.o(52608);
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
        AppMethodBeat.o(52608);
        return z2;
    }

    private void a(c cVar) {
        AppMethodBeat.i(52609);
        ReentrantLock reentrantLock = this.xDM;
        reentrantLock.lock();
        if (cVar != null) {
            try {
                this.xEg.remove(cVar);
            } catch (Throwable th) {
                reentrantLock.unlock();
                AppMethodBeat.o(52609);
            }
        }
        dqf();
        dqg();
        reentrantLock.unlock();
        AppMethodBeat.o(52609);
    }

    private void a(c cVar, boolean z) {
        AppMethodBeat.i(52610);
        ReentrantLock reentrantLock = this.xDM;
        if ((this.xEe.get() & 536870911) > this.cml || z) {
            dqf();
            reentrantLock.lock();
            try {
                this.xEk += cVar.xEr;
                cVar.xEr = 0;
                this.xEg.remove(cVar);
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                AppMethodBeat.o(52610);
            }
        } else {
            reentrantLock.lock();
            try {
                this.xEk += cVar.xEr;
                cVar.xEr = 0;
                cVar.release(1);
                this.xEh.add(cVar);
                reentrantLock.unlock();
            } catch (Throwable th2) {
                reentrantLock.unlock();
                AppMethodBeat.o(52610);
            }
        }
        dqg();
        AppMethodBeat.o(52610);
    }

    private Runnable dqh() {
        AppMethodBeat.i(52611);
        int i = this.xEe.get();
        int i2 = -536870912 & i;
        if (i2 < 0 || (i2 < 536870912 && !this.xEf.isEmpty())) {
            i2 = 536870911 & i;
            if (i2 <= this.xEm || ((i2 <= 1 && !this.xEf.isEmpty()) || !Mf(i))) {
                Runnable runnable = (Runnable) this.xEf.poll();
                AppMethodBeat.o(52611);
                return runnable;
            }
            AppMethodBeat.o(52611);
            return null;
        }
        dqf();
        AppMethodBeat.o(52611);
        return null;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(c cVar) {
        Throwable th;
        boolean z;
        Runnable e = null;
        AppMethodBeat.i(52612);
        Thread currentThread = Thread.currentThread();
        Runnable dqh = cVar.xEq == null ? dqh() : cVar.xEq;
        cVar.xEq = null;
        cVar.release(1);
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
                        a(cVar, true);
                    }
                    AppMethodBeat.o(52612);
                    throw th;
                }
            }
            cVar.acquire(1);
            if ((gX(this.xEe.get(), 536870912) || (Thread.interrupted() && gX(this.xEe.get(), 536870912))) && !currentThread.isInterrupted()) {
                break;
            }
            try {
                beforeExecute(currentThread, dqh);
                try {
                    dqh.run();
                    z3 = c.dqj();
                    if (!z3) {
                        dqh = dqh();
                        cVar.xEq = dqh;
                        if (dqh != null) {
                            d.xDG.execute(cVar);
                            z2 = false;
                        }
                    }
                    cVar.xEr++;
                    cVar.release(1);
                    dqh = null;
                } catch (RuntimeException e2) {
                    e = e2;
                    AppMethodBeat.o(52612);
                    throw e;
                } catch (Error e3) {
                    e = e3;
                    AppMethodBeat.o(52612);
                    throw e;
                } catch (Throwable th3) {
                    if (e == null) {
                        if (!c.dqj()) {
                            e = dqh();
                            cVar.xEq = e;
                            if (e != null) {
                                d.xDG.execute(cVar);
                                z = false;
                                AppMethodBeat.o(52612);
                            }
                        }
                    }
                    z = z2;
                    AppMethodBeat.o(52612);
                }
            } catch (Throwable th4) {
                th = th4;
                cVar.xEr++;
                cVar.release(1);
                AppMethodBeat.o(52612);
                throw th;
            }
        }
        if (z2) {
            a(cVar, false);
            AppMethodBeat.o(52612);
            return;
        }
        AppMethodBeat.o(52612);
    }

    private boolean dqi() {
        AppMethodBeat.i(52613);
        if ((this.xEe.get() & -536870912) >= 0) {
            AppMethodBeat.o(52613);
            return false;
        }
        ReentrantLock reentrantLock = this.xDM;
        reentrantLock.lock();
        try {
            Iterator it = this.xEh.iterator();
            if (!it.hasNext()) {
                return false;
            }
            c cVar = (c) it.next();
            cVar.xEq = null;
            d.xDG.execute(cVar);
            it.remove();
            reentrantLock.unlock();
            AppMethodBeat.o(52613);
            return true;
        } finally {
            reentrantLock.unlock();
            AppMethodBeat.o(52613);
        }
    }

    public c(String str, BlockingQueue<Runnable> blockingQueue) {
        AppMethodBeat.i(52614);
        if (blockingQueue == null || str == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(52614);
            throw nullPointerException;
        }
        this.name = str;
        this.cml = 6;
        this.xEm = 6;
        this.xEf = blockingQueue;
        this.xEl = new a();
        AppMethodBeat.o(52614);
    }

    public c(String str, int i, int i2, BlockingQueue<Runnable> blockingQueue) {
        AppMethodBeat.i(52615);
        if (i < 0 || i2 <= 0 || i2 < i) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(52615);
            throw illegalArgumentException;
        } else if (blockingQueue == null || str == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(52615);
            throw nullPointerException;
        } else {
            this.cml = i;
            this.name = str;
            this.xEm = i2;
            this.xEf = blockingQueue;
            this.xEl = new a();
            AppMethodBeat.o(52615);
        }
    }

    public void execute(Runnable runnable) {
        boolean z = true;
        AppMethodBeat.i(52616);
        if (runnable == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(52616);
            throw nullPointerException;
        }
        boolean z2;
        int i = this.xEe.get();
        if ((i & 536870911) < this.cml) {
            if (a(runnable, true)) {
                AppMethodBeat.o(52616);
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
            if (!a(runnable, false)) {
                aq(runnable);
            }
            AppMethodBeat.o(52616);
        } else if (dqi()) {
            AppMethodBeat.o(52616);
        } else {
            i = this.xEe.get();
            if (i >= 0) {
                z = false;
            }
            if (z || !remove(runnable)) {
                if ((i & 536870911) == 0) {
                    a(null, false);
                }
                AppMethodBeat.o(52616);
                return;
            }
            aq(runnable);
            AppMethodBeat.o(52616);
        }
    }

    public final void shutdown() {
        AppMethodBeat.i(52617);
        ReentrantLock reentrantLock = this.xDM;
        reentrantLock.lock();
        try {
            Mg(0);
            reentrantLock.unlock();
            dqg();
            AppMethodBeat.o(52617);
        } catch (Throwable th) {
            reentrantLock.unlock();
            AppMethodBeat.o(52617);
        }
    }

    private List<Runnable> shutdownNow() {
        AppMethodBeat.i(52618);
        ReentrantLock reentrantLock = this.xDM;
        reentrantLock.lock();
        ReentrantLock reentrantLock2;
        try {
            Mg(536870912);
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
            AppMethodBeat.o(52618);
            return arrayList;
        } catch (Throwable th) {
            reentrantLock.unlock();
            AppMethodBeat.o(52618);
        }
    }

    public boolean isShutdown() {
        boolean z;
        AppMethodBeat.i(52619);
        if (this.xEe.get() < 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(52619);
            return false;
        }
        AppMethodBeat.o(52619);
        return true;
    }

    public final void reset() {
        AppMethodBeat.i(52620);
        shutdownNow();
        Mg(-536870912);
        AppMethodBeat.o(52620);
    }

    public final void p(final Runnable runnable, long j) {
        AppMethodBeat.i(52621);
        d.xDG.p(new Runnable() {
            public final void run() {
                AppMethodBeat.i(52593);
                c.this.execute(runnable);
                AppMethodBeat.o(52593);
            }
        }, j);
        AppMethodBeat.o(52621);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(52622);
        shutdown();
        AppMethodBeat.o(52622);
    }

    public final int getCorePoolSize() {
        return this.cml;
    }

    public final boolean remove(Runnable runnable) {
        AppMethodBeat.i(52623);
        boolean remove = this.xEf.remove(runnable);
        dqg();
        AppMethodBeat.o(52623);
        return remove;
    }

    public String toString() {
        AppMethodBeat.i(52624);
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
                c cVar = (c) it.next();
                j += cVar.xEr;
                if (cVar.isLocked()) {
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
            String str = obj != null ? "Running" : gX(i3, 1610612736) ? "Terminated" : "Shutting down";
            str = super.toString() + "[" + str + ", pool size = " + size + ", active threads = " + i + ", queued tasks = " + this.xEf.size() + ", completed tasks = " + j + "]";
            AppMethodBeat.o(52624);
            return str;
        } catch (Throwable th) {
            reentrantLock.unlock();
            AppMethodBeat.o(52624);
        }
    }

    /* Access modifiers changed, original: protected */
    public void beforeExecute(Thread thread, Runnable runnable) {
    }
}
