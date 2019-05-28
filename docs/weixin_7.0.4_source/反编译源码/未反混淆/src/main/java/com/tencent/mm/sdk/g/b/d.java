package com.tencent.mm.sdk.g.b;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Printer;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.c.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class d implements a {
    private static final RuntimePermission xEo = new RuntimePermission("modifyThread");
    private volatile int cml;
    private final ReentrantLock xDM = new ReentrantLock();
    private final AtomicInteger xEe = new AtomicInteger(-536870912);
    private final BlockingQueue<Runnable> xEf;
    private final HashSet<c> xEg = new HashSet();
    private final HashSet<c> xEh = new HashSet();
    private final Condition xEi = this.xDM.newCondition();
    private int xEj;
    private long xEk;
    private volatile int xEm;
    volatile e xEs;
    private volatile b xEt;
    private volatile int xEu;
    private volatile boolean xEv = false;
    private final BlockingQueue<Runnable> xEw;
    private a xEx;

    public interface a {
        void Me(int i);

        void dqa();
    }

    public interface b {
        void at(Runnable runnable);
    }

    final class c extends AbstractQueuedSynchronizer implements Printer, Runnable {
        Handler handler;
        final HandlerThread oAl;
        volatile boolean xEA = false;
        volatile Runnable xEq;
        volatile long xEr;
        volatile String xEz;

        c(Runnable runnable) {
            AppMethodBeat.i(52627);
            setState(-1);
            this.xEq = runnable;
            this.xEz = d.as(runnable);
            this.oAl = d.this.xEs.a(this, "HandlerThreadPool#".concat(String.valueOf((536870911 & d.this.xEe.get()) + 1)), this);
            AppMethodBeat.o(52627);
        }

        public final boolean dqj() {
            AppMethodBeat.i(52628);
            if (VERSION.SDK_INT >= 23) {
                boolean isIdle = this.handler.getLooper().getQueue().isIdle();
                AppMethodBeat.o(52628);
                return isIdle;
            }
            AppMethodBeat.o(52628);
            return false;
        }

        public final void run() {
            AppMethodBeat.i(52629);
            d.this.a(this);
            AppMethodBeat.o(52629);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean isHeldExclusively() {
            AppMethodBeat.i(52630);
            if (getState() != 0) {
                AppMethodBeat.o(52630);
                return true;
            }
            AppMethodBeat.o(52630);
            return false;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean tryAcquire(int i) {
            AppMethodBeat.i(52631);
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                AppMethodBeat.o(52631);
                return true;
            }
            AppMethodBeat.o(52631);
            return false;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean tryRelease(int i) {
            AppMethodBeat.i(52632);
            setExclusiveOwnerThread(null);
            setState(0);
            AppMethodBeat.o(52632);
            return true;
        }

        public final boolean tryLock() {
            AppMethodBeat.i(52633);
            boolean tryAcquire = tryAcquire(1);
            AppMethodBeat.o(52633);
            return tryAcquire;
        }

        public final boolean isLocked() {
            AppMethodBeat.i(52634);
            boolean isHeldExclusively = isHeldExclusively();
            AppMethodBeat.o(52634);
            return isHeldExclusively;
        }

        /* Access modifiers changed, original: final */
        public final void dqo() {
            AppMethodBeat.i(52635);
            if (getState() >= 0) {
                HandlerThread handlerThread = this.oAl;
                if (!(handlerThread == null || handlerThread.isInterrupted())) {
                    try {
                        handlerThread.quit();
                        handlerThread.interrupt();
                        AppMethodBeat.o(52635);
                        return;
                    } catch (SecurityException e) {
                    }
                }
            }
            AppMethodBeat.o(52635);
        }

        public final void println(String str) {
            this.xEA = !this.xEA;
        }
    }

    static /* synthetic */ String as(Runnable runnable) {
        AppMethodBeat.i(52662);
        String ar = ar(runnable);
        AppMethodBeat.o(52662);
        return ar;
    }

    private static boolean gX(int i, int i2) {
        return i >= i2;
    }

    public final void reset() {
        AppMethodBeat.i(52636);
        shutdownNow();
        Mg(-536870912);
        AppMethodBeat.o(52636);
    }

    public final void shutdown() {
        AppMethodBeat.i(52637);
        ReentrantLock reentrantLock = this.xDM;
        reentrantLock.lock();
        try {
            dqk();
            Mg(0);
            po(false);
            reentrantLock.unlock();
            dqg();
            AppMethodBeat.o(52637);
        } catch (Throwable th) {
            reentrantLock.unlock();
            AppMethodBeat.o(52637);
        }
    }

    private List<Runnable> shutdownNow() {
        AppMethodBeat.i(52638);
        ReentrantLock reentrantLock = this.xDM;
        reentrantLock.lock();
        ReentrantLock reentrantLock2;
        try {
            dqk();
            Mg(536870912);
            reentrantLock2 = this.xDM;
            reentrantLock2.lock();
            Iterator it = this.xEg.iterator();
            while (it.hasNext()) {
                ((c) it.next()).dqo();
            }
            reentrantLock2.unlock();
            ArrayList arrayList = new ArrayList();
            a(this.xEf);
            a(this.xEw);
            reentrantLock.unlock();
            dqg();
            AppMethodBeat.o(52638);
            return arrayList;
        } catch (Throwable th) {
            reentrantLock.unlock();
            AppMethodBeat.o(52638);
        }
    }

    private static void a(BlockingQueue<Runnable> blockingQueue) {
        int i = 0;
        AppMethodBeat.i(52639);
        ArrayList arrayList = new ArrayList();
        blockingQueue.drainTo(arrayList);
        if (!blockingQueue.isEmpty()) {
            Runnable[] runnableArr = (Runnable[]) blockingQueue.toArray(new Runnable[0]);
            int length = runnableArr.length;
            while (i < length) {
                Object obj = runnableArr[i];
                if (blockingQueue.remove(obj)) {
                    arrayList.add(obj);
                }
                i++;
            }
        }
        AppMethodBeat.o(52639);
    }

    static {
        AppMethodBeat.i(52663);
        AppMethodBeat.o(52663);
    }

    private void dqk() {
        AppMethodBeat.i(52640);
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(xEo);
            ReentrantLock reentrantLock = this.xDM;
            reentrantLock.lock();
            try {
                Iterator it = this.xEg.iterator();
                while (it.hasNext()) {
                    securityManager.checkAccess(((c) it.next()).oAl);
                }
            } finally {
                reentrantLock.unlock();
                AppMethodBeat.o(52640);
            }
        } else {
            AppMethodBeat.o(52640);
        }
    }

    private void Mg(int i) {
        AppMethodBeat.i(52641);
        int i2;
        do {
            i2 = this.xEe.get();
            if (i != -536870912 && gX(i2, i)) {
                break;
            }
        } while (!this.xEe.compareAndSet(i2, (536870911 & i2) | i));
        AppMethodBeat.o(52641);
    }

    private void dqf() {
        AppMethodBeat.i(52642);
        int i;
        do {
            i = this.xEe.get();
        } while (!this.xEe.compareAndSet(i, i - 1));
        AppMethodBeat.o(52642);
    }

    /* Access modifiers changed, original: protected */
    public void beforeExecute(Thread thread, Runnable runnable) {
    }

    /* Access modifiers changed, original: protected */
    public void afterExecute(Runnable runnable, Throwable th) {
    }

    public d(int i, int i2, BlockingQueue<Runnable> blockingQueue, e eVar, b bVar, a aVar) {
        AppMethodBeat.i(52643);
        this.cml = i;
        this.xEu = i2;
        this.xEm = i;
        this.xEf = blockingQueue;
        this.xEs = eVar;
        this.xEt = bVar;
        this.xEw = new LinkedBlockingDeque();
        this.xEx = aVar;
        AppMethodBeat.o(52643);
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d1 A:{Catch:{ all -> 0x00e2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(c cVar) {
        Throwable th;
        boolean z;
        Throwable e = null;
        AppMethodBeat.i(52644);
        HandlerThread handlerThread = cVar.oAl;
        Runnable dqh = cVar.xEq == null ? dqh() : cVar.xEq;
        cVar.xEz = ar(dqh);
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
                    }
                    AppMethodBeat.o(52644);
                    throw th;
                }
            }
            Runnable runnable = dqh;
            cVar.acquire(1);
            if ((gX(this.xEe.get(), 536870912) || (Thread.interrupted() && gX(this.xEe.get(), 536870912))) && !handlerThread.isInterrupted()) {
                handlerThread.quit();
                handlerThread.interrupt();
                break;
            }
            try {
                cVar.xEz = ar(runnable);
                beforeExecute(handlerThread, runnable);
                try {
                    runnable.run();
                    afterExecute(runnable, null);
                    z3 = cVar.dqj();
                    if (!z3) {
                        cVar.handler.post(cVar);
                        z2 = false;
                    }
                    cVar.xEr++;
                    cVar.release(1);
                    if (com.tencent.mm.sdk.g.d.xDB) {
                        ab.i("HandlerThreadPool", dqn());
                        dqh = null;
                    } else {
                        dqh = null;
                    }
                } catch (RuntimeException e2) {
                    e = e2;
                    AppMethodBeat.o(52644);
                    throw e;
                } catch (Error e3) {
                    e = e3;
                    AppMethodBeat.o(52644);
                    throw e;
                } catch (Throwable th3) {
                    afterExecute(runnable, e);
                    if (e != null || cVar.dqj()) {
                        z = z2;
                    } else {
                        cVar.handler.post(cVar);
                        z = false;
                    }
                    AppMethodBeat.o(52644);
                }
            } catch (Throwable th4) {
                th = th4;
                cVar.xEr++;
                cVar.release(1);
                if (com.tencent.mm.sdk.g.d.xDB) {
                }
                AppMethodBeat.o(52644);
                throw th;
            }
        }
        if (z2) {
            a(cVar, false);
            AppMethodBeat.o(52644);
            return;
        }
        AppMethodBeat.o(52644);
    }

    private boolean dqi() {
        AppMethodBeat.i(52645);
        if ((this.xEe.get() & -536870912) >= 0) {
            AppMethodBeat.o(52645);
            return false;
        }
        ReentrantLock reentrantLock = this.xDM;
        reentrantLock.lock();
        try {
            c cVar;
            Iterator it = this.xEh.iterator();
            while (it.hasNext()) {
                cVar = (c) it.next();
                if (!cVar.xEA && cVar.oAl.isAlive()) {
                    cVar.xEq = null;
                    cVar.xEz = ar(null);
                    cVar.handler.post(cVar);
                    it.remove();
                    return true;
                }
            }
            if (it.hasNext()) {
                cVar = (c) it.next();
                cVar.xEq = null;
                cVar.xEz = ar(null);
                cVar.handler.post(cVar);
                it.remove();
                ab.w("HandlerThreadPool", "[notifyWorker] fallback! thread id:%s %s", Integer.valueOf(cVar.oAl.getThreadId()), cVar.xEz);
                reentrantLock.unlock();
                AppMethodBeat.o(52645);
                return true;
            }
            reentrantLock.unlock();
            AppMethodBeat.o(52645);
            return false;
        } finally {
            reentrantLock.unlock();
            AppMethodBeat.o(52645);
        }
    }

    private void a(c cVar, boolean z) {
        AppMethodBeat.i(52646);
        if ((this.xEe.get() & -536870912) >= 0) {
            z = true;
        }
        if (z) {
            dqf();
        }
        ReentrantLock reentrantLock = this.xDM;
        reentrantLock.lock();
        if (z) {
            try {
                this.xEk += cVar.xEr;
                this.xEg.remove(cVar);
                cVar.oAl.quit();
            } catch (Throwable th) {
                reentrantLock.unlock();
                AppMethodBeat.o(52646);
            }
        } else {
            this.xEh.add(cVar);
        }
        cVar.release(1);
        cVar.xEq = null;
        cVar.xEz = null;
        reentrantLock.unlock();
        dqg();
        AppMethodBeat.o(52646);
    }

    private Runnable dqh() {
        AppMethodBeat.i(52647);
        int i = this.xEe.get() & -536870912;
        if (i < 0 || (i < 536870912 && !dql())) {
            Runnable runnable = (Runnable) this.xEf.poll();
            if (runnable == null && getActiveCount() < this.xEu && !this.xEw.isEmpty()) {
                this.xEw.size();
                runnable = (Runnable) this.xEw.poll();
                a aVar = this.xEx;
                ar(runnable);
                aVar.dqa();
            }
            AppMethodBeat.o(52647);
            return runnable;
        }
        AppMethodBeat.o(52647);
        return null;
    }

    private boolean dql() {
        AppMethodBeat.i(52648);
        if (this.xEf.isEmpty() && this.xEw.isEmpty()) {
            AppMethodBeat.o(52648);
            return true;
        }
        AppMethodBeat.o(52648);
        return false;
    }

    private static String ar(Runnable runnable) {
        AppMethodBeat.i(52649);
        String str;
        if (runnable == null) {
            str = "";
            AppMethodBeat.o(52649);
            return str;
        }
        if (runnable instanceof com.tencent.mm.sdk.g.d.b) {
            str = ((com.tencent.mm.sdk.g.d.b) runnable).getKey();
        } else {
            str = runnable.getClass().getName();
        }
        AppMethodBeat.o(52649);
        return str;
    }

    private void po(boolean z) {
        AppMethodBeat.i(52650);
        ReentrantLock reentrantLock = this.xDM;
        reentrantLock.lock();
        c cVar;
        try {
            Iterator it = this.xEg.iterator();
            while (it.hasNext()) {
                cVar = (c) it.next();
                HandlerThread handlerThread = cVar.oAl;
                if (!handlerThread.isInterrupted() && cVar.tryLock()) {
                    handlerThread.quit();
                    handlerThread.interrupt();
                    cVar.release(1);
                    continue;
                }
                if (z) {
                    break;
                }
            }
        } catch (SecurityException e) {
            ab.e("HandlerThreadPool", e.toString());
            cVar.release(1);
            continue;
        } catch (Throwable th) {
            reentrantLock.unlock();
            AppMethodBeat.o(52650);
        }
        reentrantLock.unlock();
        AppMethodBeat.o(52650);
    }

    /* JADX WARNING: Missing block: B:20:0x0047, code skipped:
            r7.xEe.set(1610612736);
            r7.xEi.signalAll();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dqg() {
        AppMethodBeat.i(52651);
        while (true) {
            boolean z;
            int i = this.xEe.get();
            if (i < 0) {
                z = true;
            } else {
                z = false;
            }
            if (z || gX(i, ErrorDialogData.SUPPRESSED) || ((-536870912 & i) == 0 && !dql())) {
                AppMethodBeat.o(52651);
            } else if ((536870911 & i) != 0) {
                po(true);
                AppMethodBeat.o(52651);
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
                    AppMethodBeat.o(52651);
                }
            }
        }
        AppMethodBeat.o(52651);
    }

    private int getActiveCount() {
        AppMethodBeat.i(52652);
        ReentrantLock reentrantLock = this.xDM;
        reentrantLock.lock();
        int i = 0;
        try {
            Iterator it = this.xEg.iterator();
            while (it.hasNext()) {
                int i2;
                if (((c) it.next()).isLocked()) {
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                i = i2;
            }
            return i;
        } finally {
            reentrantLock.unlock();
            AppMethodBeat.o(52652);
        }
    }

    public final int getCorePoolSize() {
        return this.cml;
    }

    public void execute(Runnable runnable) {
        AppMethodBeat.i(52653);
        if (runnable == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(52653);
            throw nullPointerException;
        }
        boolean z;
        int i = this.xEe.get();
        int i2 = i & 536870911;
        if (i2 < this.cml) {
            if (a(runnable, true)) {
                AppMethodBeat.o(52653);
                return;
            }
            i = this.xEe.get();
        }
        String ar = ar(runnable);
        if (i < 0) {
            z = true;
        } else {
            z = false;
        }
        if (z && el(ar, this.xEu)) {
            this.xEw.offer(runnable);
            this.xEx.Me(i2);
            AppMethodBeat.o(52653);
            return;
        }
        boolean z2;
        if (i < 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 || !this.xEf.offer(runnable)) {
            if (!a(runnable, false)) {
                aq(runnable);
            }
            AppMethodBeat.o(52653);
        } else if (dqi()) {
            AppMethodBeat.o(52653);
        } else {
            int i3 = this.xEe.get();
            if (i3 < 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 || !remove(runnable)) {
                if ((i3 & 536870911) == 0) {
                    a(null, false);
                }
                AppMethodBeat.o(52653);
                return;
            }
            aq(runnable);
            AppMethodBeat.o(52653);
        }
    }

    public final void p(final Runnable runnable, long j) {
        AppMethodBeat.i(52654);
        com.tencent.mm.sdk.g.d.xDG.p(new Runnable() {
            public final void run() {
                AppMethodBeat.i(52626);
                d.this.execute(runnable);
                AppMethodBeat.o(52626);
            }
        }, j);
        AppMethodBeat.o(52654);
    }

    private void aq(Runnable runnable) {
        AppMethodBeat.i(52655);
        this.xEt.at(runnable);
        AppMethodBeat.o(52655);
    }

    private boolean el(String str, int i) {
        AppMethodBeat.i(52656);
        ReentrantLock reentrantLock = this.xDM;
        reentrantLock.lock();
        try {
            Iterator it = this.xEg.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int i3;
                c cVar = (c) it.next();
                if (cVar.isLocked() && str.equals(cVar.xEz)) {
                    i3 = i2 + 1;
                    if (i3 >= i) {
                        reentrantLock.unlock();
                        AppMethodBeat.o(52656);
                        return true;
                    }
                } else {
                    i3 = i2;
                }
                i2 = i3;
            }
            return false;
        } finally {
            reentrantLock.unlock();
            AppMethodBeat.o(52656);
        }
    }

    public final boolean remove(Runnable runnable) {
        AppMethodBeat.i(52657);
        boolean remove = this.xEf.remove(runnable);
        boolean remove2 = this.xEw.remove(runnable);
        dqg();
        if (remove || remove2) {
            AppMethodBeat.o(52657);
            return true;
        }
        AppMethodBeat.o(52657);
        return false;
    }

    /* JADX WARNING: Missing block: B:19:0x0044, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(52658);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(Runnable runnable, boolean z) {
        Throwable th;
        boolean z2 = false;
        AppMethodBeat.i(52658);
        loop0:
        while (true) {
            int i = this.xEe.get();
            int i2 = i & -536870912;
            if (i2 < 0 || (i2 == 0 && runnable == null && !dql())) {
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
                                HandlerThread handlerThread = cVar.oAl;
                                if (handlerThread != null) {
                                    boolean z3;
                                    reentrantLock = this.xDM;
                                    reentrantLock.lock();
                                    i4 = this.xEe.get() & -536870912;
                                    if (i4 >= 0 && (i4 != 0 || runnable != null)) {
                                        z3 = false;
                                    } else if (handlerThread.isAlive()) {
                                        IllegalThreadStateException illegalThreadStateException = new IllegalThreadStateException();
                                        AppMethodBeat.o(52658);
                                        throw illegalThreadStateException;
                                    } else if (el(ar(runnable), this.xEu)) {
                                        reentrantLock.unlock();
                                        b(cVar);
                                        AppMethodBeat.o(52658);
                                    } else {
                                        this.xEg.add(cVar);
                                        i3 = this.xEg.size();
                                        if (i3 > this.xEj) {
                                            this.xEj = i3;
                                        }
                                        z3 = true;
                                    }
                                    reentrantLock.unlock();
                                    if (z3) {
                                        cVar.oAl.start();
                                        cVar.handler = new Handler(cVar.oAl.getLooper());
                                        cVar.handler.post(cVar);
                                        z2 = true;
                                    }
                                }
                                if (!z2) {
                                    b(cVar);
                                }
                                AppMethodBeat.o(52658);
                            } catch (Throwable th2) {
                                th = th2;
                                b(cVar);
                                AppMethodBeat.o(52658);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            cVar = null;
                            b(cVar);
                            AppMethodBeat.o(52658);
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
        AppMethodBeat.o(52658);
        return z2;
    }

    private void b(c cVar) {
        AppMethodBeat.i(52659);
        ReentrantLock reentrantLock = this.xDM;
        reentrantLock.lock();
        if (cVar != null) {
            try {
                cVar.oAl.quit();
                this.xEg.remove(cVar);
            } catch (Throwable th) {
                reentrantLock.unlock();
                AppMethodBeat.o(52659);
            }
        }
        dqf();
        dqg();
        reentrantLock.unlock();
        AppMethodBeat.o(52659);
    }

    public final String dqm() {
        AppMethodBeat.i(52660);
        ReentrantLock reentrantLock = this.xDM;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            c cVar;
            reentrantLock.lock();
            Iterator it = this.xEh.iterator();
            stringBuilder.append("recycleWorker:\n");
            while (it.hasNext()) {
                cVar = (c) it.next();
                stringBuilder.append(cVar.oAl.getThreadId()).append(" ").append(cVar.xEA).append(" ").append(cVar.isLocked()).append(", ");
            }
            stringBuilder.append("\nworker:\n");
            it = this.xEg.iterator();
            while (it.hasNext()) {
                cVar = (c) it.next();
                stringBuilder.append(cVar.oAl.getThreadId()).append(" ").append(cVar.xEA).append(" ").append(cVar.isLocked()).append(", ");
            }
            reentrantLock.unlock();
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(52660);
            return stringBuilder2;
        } catch (Throwable th) {
            reentrantLock.unlock();
            AppMethodBeat.o(52660);
        }
    }

    private String dqn() {
        AppMethodBeat.i(52661);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("print:\n-------------------------------------------------------------------------\n");
        ReentrantLock reentrantLock = this.xDM;
        try {
            reentrantLock.lock();
            Iterator it = this.xEg.iterator();
            while (it.hasNext()) {
                stringBuilder.append(String.format("worker[%s]:", new Object[]{((c) it.next()).oAl.getName()}));
                for (int i = 0; ((long) i) < r0.xEr; i++) {
                    stringBuilder.append("*");
                }
                stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            reentrantLock.unlock();
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(52661);
            return stringBuilder2;
        } catch (Throwable th) {
            reentrantLock.unlock();
            AppMethodBeat.o(52661);
        }
    }
}
