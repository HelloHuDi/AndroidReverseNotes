package com.tencent.p177mm.sdk.p604g.p606b;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Printer;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.p604g.p607c.C4962e;
import com.tencent.p177mm.sdk.p604g.p608d.C4967b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
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

/* renamed from: com.tencent.mm.sdk.g.b.d */
public class C7299d implements C4946a {
    private static final RuntimePermission xEo = new RuntimePermission("modifyThread");
    private volatile int cml;
    private final ReentrantLock xDM = new ReentrantLock();
    private final AtomicInteger xEe = new AtomicInteger(-536870912);
    private final BlockingQueue<Runnable> xEf;
    private final HashSet<C4952c> xEg = new HashSet();
    private final HashSet<C4952c> xEh = new HashSet();
    private final Condition xEi = this.xDM.newCondition();
    private int xEj;
    private long xEk;
    private volatile int xEm;
    volatile C4962e xEs;
    private volatile C4951b xEt;
    private volatile int xEu;
    private volatile boolean xEv = false;
    private final BlockingQueue<Runnable> xEw;
    private C4950a xEx;

    /* renamed from: com.tencent.mm.sdk.g.b.d$a */
    public interface C4950a {
        /* renamed from: Me */
        void mo10180Me(int i);

        void dqa();
    }

    /* renamed from: com.tencent.mm.sdk.g.b.d$b */
    public interface C4951b {
        /* renamed from: at */
        void mo10182at(Runnable runnable);
    }

    /* renamed from: com.tencent.mm.sdk.g.b.d$c */
    final class C4952c extends AbstractQueuedSynchronizer implements Printer, Runnable {
        Handler handler;
        final HandlerThread oAl;
        volatile boolean xEA = false;
        volatile Runnable xEq;
        volatile long xEr;
        volatile String xEz;

        C4952c(Runnable runnable) {
            AppMethodBeat.m2504i(52627);
            setState(-1);
            this.xEq = runnable;
            this.xEz = C7299d.m12265as(runnable);
            this.oAl = C7299d.this.xEs.mo10206a(this, "HandlerThreadPool#".concat(String.valueOf((536870911 & C7299d.this.xEe.get()) + 1)), this);
            AppMethodBeat.m2505o(52627);
        }

        public final boolean dqj() {
            AppMethodBeat.m2504i(52628);
            if (VERSION.SDK_INT >= 23) {
                boolean isIdle = this.handler.getLooper().getQueue().isIdle();
                AppMethodBeat.m2505o(52628);
                return isIdle;
            }
            AppMethodBeat.m2505o(52628);
            return false;
        }

        public final void run() {
            AppMethodBeat.m2504i(52629);
            C7299d.this.mo15646a(this);
            AppMethodBeat.m2505o(52629);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean isHeldExclusively() {
            AppMethodBeat.m2504i(52630);
            if (getState() != 0) {
                AppMethodBeat.m2505o(52630);
                return true;
            }
            AppMethodBeat.m2505o(52630);
            return false;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean tryAcquire(int i) {
            AppMethodBeat.m2504i(52631);
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                AppMethodBeat.m2505o(52631);
                return true;
            }
            AppMethodBeat.m2505o(52631);
            return false;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean tryRelease(int i) {
            AppMethodBeat.m2504i(52632);
            setExclusiveOwnerThread(null);
            setState(0);
            AppMethodBeat.m2505o(52632);
            return true;
        }

        public final boolean tryLock() {
            AppMethodBeat.m2504i(52633);
            boolean tryAcquire = tryAcquire(1);
            AppMethodBeat.m2505o(52633);
            return tryAcquire;
        }

        public final boolean isLocked() {
            AppMethodBeat.m2504i(52634);
            boolean isHeldExclusively = isHeldExclusively();
            AppMethodBeat.m2505o(52634);
            return isHeldExclusively;
        }

        /* Access modifiers changed, original: final */
        public final void dqo() {
            AppMethodBeat.m2504i(52635);
            if (getState() >= 0) {
                HandlerThread handlerThread = this.oAl;
                if (!(handlerThread == null || handlerThread.isInterrupted())) {
                    try {
                        handlerThread.quit();
                        handlerThread.interrupt();
                        AppMethodBeat.m2505o(52635);
                        return;
                    } catch (SecurityException e) {
                    }
                }
            }
            AppMethodBeat.m2505o(52635);
        }

        public final void println(String str) {
            this.xEA = !this.xEA;
        }
    }

    /* renamed from: as */
    static /* synthetic */ String m12265as(Runnable runnable) {
        AppMethodBeat.m2504i(52662);
        String ar = C7299d.m12264ar(runnable);
        AppMethodBeat.m2505o(52662);
        return ar;
    }

    /* renamed from: gX */
    private static boolean m12268gX(int i, int i2) {
        return i >= i2;
    }

    public final void reset() {
        AppMethodBeat.m2504i(52636);
        shutdownNow();
        m12257Mg(-536870912);
        AppMethodBeat.m2505o(52636);
    }

    public final void shutdown() {
        AppMethodBeat.m2504i(52637);
        ReentrantLock reentrantLock = this.xDM;
        reentrantLock.lock();
        try {
            dqk();
            m12257Mg(0);
            m12269po(false);
            reentrantLock.unlock();
            dqg();
            AppMethodBeat.m2505o(52637);
        } catch (Throwable th) {
            reentrantLock.unlock();
            AppMethodBeat.m2505o(52637);
        }
    }

    private List<Runnable> shutdownNow() {
        AppMethodBeat.m2504i(52638);
        ReentrantLock reentrantLock = this.xDM;
        reentrantLock.lock();
        ReentrantLock reentrantLock2;
        try {
            dqk();
            m12257Mg(536870912);
            reentrantLock2 = this.xDM;
            reentrantLock2.lock();
            Iterator it = this.xEg.iterator();
            while (it.hasNext()) {
                ((C4952c) it.next()).dqo();
            }
            reentrantLock2.unlock();
            ArrayList arrayList = new ArrayList();
            C7299d.m12261a(this.xEf);
            C7299d.m12261a(this.xEw);
            reentrantLock.unlock();
            dqg();
            AppMethodBeat.m2505o(52638);
            return arrayList;
        } catch (Throwable th) {
            reentrantLock.unlock();
            AppMethodBeat.m2505o(52638);
        }
    }

    /* renamed from: a */
    private static void m12261a(BlockingQueue<Runnable> blockingQueue) {
        int i = 0;
        AppMethodBeat.m2504i(52639);
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
        AppMethodBeat.m2505o(52639);
    }

    static {
        AppMethodBeat.m2504i(52663);
        AppMethodBeat.m2505o(52663);
    }

    private void dqk() {
        AppMethodBeat.m2504i(52640);
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(xEo);
            ReentrantLock reentrantLock = this.xDM;
            reentrantLock.lock();
            try {
                Iterator it = this.xEg.iterator();
                while (it.hasNext()) {
                    securityManager.checkAccess(((C4952c) it.next()).oAl);
                }
            } finally {
                reentrantLock.unlock();
                AppMethodBeat.m2505o(52640);
            }
        } else {
            AppMethodBeat.m2505o(52640);
        }
    }

    /* renamed from: Mg */
    private void m12257Mg(int i) {
        AppMethodBeat.m2504i(52641);
        int i2;
        do {
            i2 = this.xEe.get();
            if (i != -536870912 && C7299d.m12268gX(i2, i)) {
                break;
            }
        } while (!this.xEe.compareAndSet(i2, (536870911 & i2) | i));
        AppMethodBeat.m2505o(52641);
    }

    private void dqf() {
        AppMethodBeat.m2504i(52642);
        int i;
        do {
            i = this.xEe.get();
        } while (!this.xEe.compareAndSet(i, i - 1));
        AppMethodBeat.m2505o(52642);
    }

    /* Access modifiers changed, original: protected */
    public void beforeExecute(Thread thread, Runnable runnable) {
    }

    /* Access modifiers changed, original: protected */
    public void afterExecute(Runnable runnable, Throwable th) {
    }

    public C7299d(int i, int i2, BlockingQueue<Runnable> blockingQueue, C4962e c4962e, C4951b c4951b, C4950a c4950a) {
        AppMethodBeat.m2504i(52643);
        this.cml = i;
        this.xEu = i2;
        this.xEm = i;
        this.xEf = blockingQueue;
        this.xEs = c4962e;
        this.xEt = c4951b;
        this.xEw = new LinkedBlockingDeque();
        this.xEx = c4950a;
        AppMethodBeat.m2505o(52643);
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d1 A:{Catch:{ all -> 0x00e2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo15646a(C4952c c4952c) {
        Throwable th;
        boolean z;
        Throwable e = null;
        AppMethodBeat.m2504i(52644);
        HandlerThread handlerThread = c4952c.oAl;
        Runnable dqh = c4952c.xEq == null ? dqh() : c4952c.xEq;
        c4952c.xEz = C7299d.m12264ar(dqh);
        c4952c.xEq = null;
        c4952c.release(1);
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
                    AppMethodBeat.m2505o(52644);
                    throw th;
                }
            }
            Runnable runnable = dqh;
            c4952c.acquire(1);
            if ((C7299d.m12268gX(this.xEe.get(), 536870912) || (Thread.interrupted() && C7299d.m12268gX(this.xEe.get(), 536870912))) && !handlerThread.isInterrupted()) {
                handlerThread.quit();
                handlerThread.interrupt();
                break;
            }
            try {
                c4952c.xEz = C7299d.m12264ar(runnable);
                beforeExecute(handlerThread, runnable);
                try {
                    runnable.run();
                    afterExecute(runnable, null);
                    z3 = c4952c.dqj();
                    if (!z3) {
                        c4952c.handler.post(c4952c);
                        z2 = false;
                    }
                    c4952c.xEr++;
                    c4952c.release(1);
                    if (C7305d.xDB) {
                        C4990ab.m7416i("HandlerThreadPool", dqn());
                        dqh = null;
                    } else {
                        dqh = null;
                    }
                } catch (RuntimeException e2) {
                    e = e2;
                    AppMethodBeat.m2505o(52644);
                    throw e;
                } catch (Error e3) {
                    e = e3;
                    AppMethodBeat.m2505o(52644);
                    throw e;
                } catch (Throwable th3) {
                    afterExecute(runnable, e);
                    if (e != null || c4952c.dqj()) {
                        z = z2;
                    } else {
                        c4952c.handler.post(c4952c);
                        z = false;
                    }
                    AppMethodBeat.m2505o(52644);
                }
            } catch (Throwable th4) {
                th = th4;
                c4952c.xEr++;
                c4952c.release(1);
                if (C7305d.xDB) {
                }
                AppMethodBeat.m2505o(52644);
                throw th;
            }
        }
        if (z2) {
            m12260a(c4952c, false);
            AppMethodBeat.m2505o(52644);
            return;
        }
        AppMethodBeat.m2505o(52644);
    }

    private boolean dqi() {
        AppMethodBeat.m2504i(52645);
        if ((this.xEe.get() & -536870912) >= 0) {
            AppMethodBeat.m2505o(52645);
            return false;
        }
        ReentrantLock reentrantLock = this.xDM;
        reentrantLock.lock();
        try {
            C4952c c4952c;
            Iterator it = this.xEh.iterator();
            while (it.hasNext()) {
                c4952c = (C4952c) it.next();
                if (!c4952c.xEA && c4952c.oAl.isAlive()) {
                    c4952c.xEq = null;
                    c4952c.xEz = C7299d.m12264ar(null);
                    c4952c.handler.post(c4952c);
                    it.remove();
                    return true;
                }
            }
            if (it.hasNext()) {
                c4952c = (C4952c) it.next();
                c4952c.xEq = null;
                c4952c.xEz = C7299d.m12264ar(null);
                c4952c.handler.post(c4952c);
                it.remove();
                C4990ab.m7421w("HandlerThreadPool", "[notifyWorker] fallback! thread id:%s %s", Integer.valueOf(c4952c.oAl.getThreadId()), c4952c.xEz);
                reentrantLock.unlock();
                AppMethodBeat.m2505o(52645);
                return true;
            }
            reentrantLock.unlock();
            AppMethodBeat.m2505o(52645);
            return false;
        } finally {
            reentrantLock.unlock();
            AppMethodBeat.m2505o(52645);
        }
    }

    /* renamed from: a */
    private void m12260a(C4952c c4952c, boolean z) {
        AppMethodBeat.m2504i(52646);
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
                this.xEk += c4952c.xEr;
                this.xEg.remove(c4952c);
                c4952c.oAl.quit();
            } catch (Throwable th) {
                reentrantLock.unlock();
                AppMethodBeat.m2505o(52646);
            }
        } else {
            this.xEh.add(c4952c);
        }
        c4952c.release(1);
        c4952c.xEq = null;
        c4952c.xEz = null;
        reentrantLock.unlock();
        dqg();
        AppMethodBeat.m2505o(52646);
    }

    private Runnable dqh() {
        AppMethodBeat.m2504i(52647);
        int i = this.xEe.get() & -536870912;
        if (i < 0 || (i < 536870912 && !dql())) {
            Runnable runnable = (Runnable) this.xEf.poll();
            if (runnable == null && getActiveCount() < this.xEu && !this.xEw.isEmpty()) {
                this.xEw.size();
                runnable = (Runnable) this.xEw.poll();
                C4950a c4950a = this.xEx;
                C7299d.m12264ar(runnable);
                c4950a.dqa();
            }
            AppMethodBeat.m2505o(52647);
            return runnable;
        }
        AppMethodBeat.m2505o(52647);
        return null;
    }

    private boolean dql() {
        AppMethodBeat.m2504i(52648);
        if (this.xEf.isEmpty() && this.xEw.isEmpty()) {
            AppMethodBeat.m2505o(52648);
            return true;
        }
        AppMethodBeat.m2505o(52648);
        return false;
    }

    /* renamed from: ar */
    private static String m12264ar(Runnable runnable) {
        AppMethodBeat.m2504i(52649);
        String str;
        if (runnable == null) {
            str = "";
            AppMethodBeat.m2505o(52649);
            return str;
        }
        if (runnable instanceof C4967b) {
            str = ((C4967b) runnable).getKey();
        } else {
            str = runnable.getClass().getName();
        }
        AppMethodBeat.m2505o(52649);
        return str;
    }

    /* renamed from: po */
    private void m12269po(boolean z) {
        AppMethodBeat.m2504i(52650);
        ReentrantLock reentrantLock = this.xDM;
        reentrantLock.lock();
        C4952c c4952c;
        try {
            Iterator it = this.xEg.iterator();
            while (it.hasNext()) {
                c4952c = (C4952c) it.next();
                HandlerThread handlerThread = c4952c.oAl;
                if (!handlerThread.isInterrupted() && c4952c.tryLock()) {
                    handlerThread.quit();
                    handlerThread.interrupt();
                    c4952c.release(1);
                    continue;
                }
                if (z) {
                    break;
                }
            }
        } catch (SecurityException e) {
            C4990ab.m7412e("HandlerThreadPool", e.toString());
            c4952c.release(1);
            continue;
        } catch (Throwable th) {
            reentrantLock.unlock();
            AppMethodBeat.m2505o(52650);
        }
        reentrantLock.unlock();
        AppMethodBeat.m2505o(52650);
    }

    /* JADX WARNING: Missing block: B:20:0x0047, code skipped:
            r7.xEe.set(1610612736);
            r7.xEi.signalAll();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dqg() {
        AppMethodBeat.m2504i(52651);
        while (true) {
            boolean z;
            int i = this.xEe.get();
            if (i < 0) {
                z = true;
            } else {
                z = false;
            }
            if (z || C7299d.m12268gX(i, ErrorDialogData.SUPPRESSED) || ((-536870912 & i) == 0 && !dql())) {
                AppMethodBeat.m2505o(52651);
            } else if ((536870911 & i) != 0) {
                m12269po(true);
                AppMethodBeat.m2505o(52651);
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
                    AppMethodBeat.m2505o(52651);
                }
            }
        }
        AppMethodBeat.m2505o(52651);
    }

    private int getActiveCount() {
        AppMethodBeat.m2504i(52652);
        ReentrantLock reentrantLock = this.xDM;
        reentrantLock.lock();
        int i = 0;
        try {
            Iterator it = this.xEg.iterator();
            while (it.hasNext()) {
                int i2;
                if (((C4952c) it.next()).isLocked()) {
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                i = i2;
            }
            return i;
        } finally {
            reentrantLock.unlock();
            AppMethodBeat.m2505o(52652);
        }
    }

    public final int getCorePoolSize() {
        return this.cml;
    }

    public void execute(Runnable runnable) {
        AppMethodBeat.m2504i(52653);
        if (runnable == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.m2505o(52653);
            throw nullPointerException;
        }
        boolean z;
        int i = this.xEe.get();
        int i2 = i & 536870911;
        if (i2 < this.cml) {
            if (m12262a(runnable, true)) {
                AppMethodBeat.m2505o(52653);
                return;
            }
            i = this.xEe.get();
        }
        String ar = C7299d.m12264ar(runnable);
        if (i < 0) {
            z = true;
        } else {
            z = false;
        }
        if (z && m12267el(ar, this.xEu)) {
            this.xEw.offer(runnable);
            this.xEx.mo10180Me(i2);
            AppMethodBeat.m2505o(52653);
            return;
        }
        boolean z2;
        if (i < 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 || !this.xEf.offer(runnable)) {
            if (!m12262a(runnable, false)) {
                m12263aq(runnable);
            }
            AppMethodBeat.m2505o(52653);
        } else if (dqi()) {
            AppMethodBeat.m2505o(52653);
        } else {
            int i3 = this.xEe.get();
            if (i3 < 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 || !remove(runnable)) {
                if ((i3 & 536870911) == 0) {
                    m12262a(null, false);
                }
                AppMethodBeat.m2505o(52653);
                return;
            }
            m12263aq(runnable);
            AppMethodBeat.m2505o(52653);
        }
    }

    /* renamed from: p */
    public final void mo10173p(final Runnable runnable, long j) {
        AppMethodBeat.m2504i(52654);
        C7305d.xDG.mo10159p(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(52626);
                C7299d.this.execute(runnable);
                AppMethodBeat.m2505o(52626);
            }
        }, j);
        AppMethodBeat.m2505o(52654);
    }

    /* renamed from: aq */
    private void m12263aq(Runnable runnable) {
        AppMethodBeat.m2504i(52655);
        this.xEt.mo10182at(runnable);
        AppMethodBeat.m2505o(52655);
    }

    /* renamed from: el */
    private boolean m12267el(String str, int i) {
        AppMethodBeat.m2504i(52656);
        ReentrantLock reentrantLock = this.xDM;
        reentrantLock.lock();
        try {
            Iterator it = this.xEg.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int i3;
                C4952c c4952c = (C4952c) it.next();
                if (c4952c.isLocked() && str.equals(c4952c.xEz)) {
                    i3 = i2 + 1;
                    if (i3 >= i) {
                        reentrantLock.unlock();
                        AppMethodBeat.m2505o(52656);
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
            AppMethodBeat.m2505o(52656);
        }
    }

    public final boolean remove(Runnable runnable) {
        AppMethodBeat.m2504i(52657);
        boolean remove = this.xEf.remove(runnable);
        boolean remove2 = this.xEw.remove(runnable);
        dqg();
        if (remove || remove2) {
            AppMethodBeat.m2505o(52657);
            return true;
        }
        AppMethodBeat.m2505o(52657);
        return false;
    }

    /* JADX WARNING: Missing block: B:19:0x0044, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(52658);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private boolean m12262a(Runnable runnable, boolean z) {
        Throwable th;
        boolean z2 = false;
        AppMethodBeat.m2504i(52658);
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
                        C4952c c4952c;
                        try {
                            c4952c = new C4952c(runnable);
                            ReentrantLock reentrantLock;
                            try {
                                HandlerThread handlerThread = c4952c.oAl;
                                if (handlerThread != null) {
                                    boolean z3;
                                    reentrantLock = this.xDM;
                                    reentrantLock.lock();
                                    i4 = this.xEe.get() & -536870912;
                                    if (i4 >= 0 && (i4 != 0 || runnable != null)) {
                                        z3 = false;
                                    } else if (handlerThread.isAlive()) {
                                        IllegalThreadStateException illegalThreadStateException = new IllegalThreadStateException();
                                        AppMethodBeat.m2505o(52658);
                                        throw illegalThreadStateException;
                                    } else if (m12267el(C7299d.m12264ar(runnable), this.xEu)) {
                                        reentrantLock.unlock();
                                        m12266b(c4952c);
                                        AppMethodBeat.m2505o(52658);
                                    } else {
                                        this.xEg.add(c4952c);
                                        i3 = this.xEg.size();
                                        if (i3 > this.xEj) {
                                            this.xEj = i3;
                                        }
                                        z3 = true;
                                    }
                                    reentrantLock.unlock();
                                    if (z3) {
                                        c4952c.oAl.start();
                                        c4952c.handler = new Handler(c4952c.oAl.getLooper());
                                        c4952c.handler.post(c4952c);
                                        z2 = true;
                                    }
                                }
                                if (!z2) {
                                    m12266b(c4952c);
                                }
                                AppMethodBeat.m2505o(52658);
                            } catch (Throwable th2) {
                                th = th2;
                                m12266b(c4952c);
                                AppMethodBeat.m2505o(52658);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            c4952c = null;
                            m12266b(c4952c);
                            AppMethodBeat.m2505o(52658);
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
        AppMethodBeat.m2505o(52658);
        return z2;
    }

    /* renamed from: b */
    private void m12266b(C4952c c4952c) {
        AppMethodBeat.m2504i(52659);
        ReentrantLock reentrantLock = this.xDM;
        reentrantLock.lock();
        if (c4952c != null) {
            try {
                c4952c.oAl.quit();
                this.xEg.remove(c4952c);
            } catch (Throwable th) {
                reentrantLock.unlock();
                AppMethodBeat.m2505o(52659);
            }
        }
        dqf();
        dqg();
        reentrantLock.unlock();
        AppMethodBeat.m2505o(52659);
    }

    public final String dqm() {
        AppMethodBeat.m2504i(52660);
        ReentrantLock reentrantLock = this.xDM;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            C4952c c4952c;
            reentrantLock.lock();
            Iterator it = this.xEh.iterator();
            stringBuilder.append("recycleWorker:\n");
            while (it.hasNext()) {
                c4952c = (C4952c) it.next();
                stringBuilder.append(c4952c.oAl.getThreadId()).append(" ").append(c4952c.xEA).append(" ").append(c4952c.isLocked()).append(", ");
            }
            stringBuilder.append("\nworker:\n");
            it = this.xEg.iterator();
            while (it.hasNext()) {
                c4952c = (C4952c) it.next();
                stringBuilder.append(c4952c.oAl.getThreadId()).append(" ").append(c4952c.xEA).append(" ").append(c4952c.isLocked()).append(", ");
            }
            reentrantLock.unlock();
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(52660);
            return stringBuilder2;
        } catch (Throwable th) {
            reentrantLock.unlock();
            AppMethodBeat.m2505o(52660);
        }
    }

    private String dqn() {
        AppMethodBeat.m2504i(52661);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("print:\n-------------------------------------------------------------------------\n");
        ReentrantLock reentrantLock = this.xDM;
        try {
            reentrantLock.lock();
            Iterator it = this.xEg.iterator();
            while (it.hasNext()) {
                stringBuilder.append(String.format("worker[%s]:", new Object[]{((C4952c) it.next()).oAl.getName()}));
                for (int i = 0; ((long) i) < r0.xEr; i++) {
                    stringBuilder.append("*");
                }
                stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            reentrantLock.unlock();
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(52661);
            return stringBuilder2;
        } catch (Throwable th) {
            reentrantLock.unlock();
            AppMethodBeat.m2505o(52661);
        }
    }
}
