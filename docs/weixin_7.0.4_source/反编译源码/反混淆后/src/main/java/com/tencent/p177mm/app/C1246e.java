package com.tencent.p177mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.blink.C1311a;
import com.tencent.p177mm.blink.C1314b;
import com.tencent.p177mm.booter.C1324b;
import com.tencent.p177mm.booter.C45270c;
import com.tencent.p177mm.booter.CoreService;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1682b;
import com.tencent.p177mm.kernel.C1682b.C16856;
import com.tencent.p177mm.kernel.C1682b.C16867;
import com.tencent.p177mm.kernel.C1682b.C16878;
import com.tencent.p177mm.kernel.C1682b.C16894;
import com.tencent.p177mm.kernel.C1682b.C16905;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.model.C1810a;
import com.tencent.p177mm.network.C1897b;
import com.tencent.p177mm.network.C1898c;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1903f.C1904a;
import com.tencent.p177mm.network.C1906g.C1907a;
import com.tencent.p177mm.network.C1912i;
import com.tencent.p177mm.network.C1933s.C1934a;
import com.tencent.p177mm.p183ai.C41739r;
import com.tencent.p177mm.p230g.p231a.C6483gi;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.protocal.C4838o;
import com.tencent.p177mm.protocal.C4838o.C4837a;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5144y;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.app.e */
public final class C1246e implements ServiceConnection {
    private static boolean cea = false;
    private static Object lock = new Object();
    private ReentrantLock ceb = new ReentrantLock();
    private boolean cec = false;
    private IBinder ced = null;
    private Runnable cee = new C12506();

    /* renamed from: com.tencent.mm.app.e$4 */
    class C12474 extends C1907a {
        C12474() {
        }

        /* renamed from: gi */
        public final void mo4533gi(final int i) {
            AppMethodBeat.m2504i(57664);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(57663);
                    if (C1682b.m3427Re() != null) {
                        C1682b.m3427Re().mo5389kx(i);
                    }
                    AppMethodBeat.m2505o(57663);
                }
            });
            AppMethodBeat.m2505o(57664);
        }
    }

    /* renamed from: com.tencent.mm.app.e$6 */
    class C12506 implements Runnable {
        private int cei = 0;

        C12506() {
        }

        public final void run() {
            AppMethodBeat.m2504i(57666);
            try {
                C1246e.this.ceb.lock();
                boolean z = C1246e.this.ced != null && C1246e.this.ced.isBinderAlive();
                C4990ab.m7417i("MicroMsg.CoreServiceConnection", "mZombieWaker run serviceBinder: %s, binderAlive: %b", C1246e.this.ced, Boolean.valueOf(z));
                if (z) {
                    C4990ab.m7420w("MicroMsg.CoreServiceConnection", "mZombieWaker run binderAlive return directly.");
                    return;
                }
                C1246e.this.ceb.unlock();
                C4990ab.m7412e("MicroMsg.CoreServiceConnection", String.format("CoreService started but not responding, possibly zombie. Use step %d to restart CoreService.", new Object[]{Integer.valueOf(this.cei)}));
                if (this.cei == 1) {
                    int cS = C1246e.m2689cS("com.tencent.mm:push");
                    if (cS != -1) {
                        C4990ab.m7416i("MicroMsg.CoreServiceConnection", String.format("Push Process %d killed.", new Object[]{Integer.valueOf(cS)}));
                        C4990ab.dot();
                        Process.killProcess(cS);
                    } else {
                        C4990ab.m7416i("MicroMsg.CoreServiceConnection", "Push Process not found.");
                    }
                }
                Context context = C4996ah.getContext();
                Intent intent = new Intent(context, CoreService.class);
                try {
                    C4990ab.m7416i("MicroMsg.CoreServiceConnection", "unbinding CoreService...");
                    context.unbindService(C1246e.this);
                    try {
                        if (C45270c.m83434Ij()) {
                            context.bindService(intent, C1246e.this, 1);
                        } else {
                            context.stopService(intent);
                            context.bindService(intent, C1246e.this, 1);
                            context.startService(intent);
                        }
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.CoreServiceConnection", "CoreServiceConnection mZombieWaker Exception:%s", e.getMessage());
                    }
                } catch (Exception e2) {
                    try {
                        if (C45270c.m83434Ij()) {
                            context.bindService(intent, C1246e.this, 1);
                        } else {
                            context.stopService(intent);
                            context.bindService(intent, C1246e.this, 1);
                            context.startService(intent);
                        }
                    } catch (Exception e3) {
                        C4990ab.m7413e("MicroMsg.CoreServiceConnection", "CoreServiceConnection mZombieWaker Exception:%s", e3.getMessage());
                    }
                } catch (Throwable th) {
                    try {
                        if (C45270c.m83434Ij()) {
                            context.bindService(intent, C1246e.this, 1);
                        } else {
                            context.stopService(intent);
                            context.bindService(intent, C1246e.this, 1);
                            context.startService(intent);
                        }
                    } catch (Exception e4) {
                        C4990ab.m7413e("MicroMsg.CoreServiceConnection", "CoreServiceConnection mZombieWaker Exception:%s", e4.getMessage());
                    }
                    AppMethodBeat.m2505o(57666);
                }
                if (this.cei == 1) {
                    this.cei = 0;
                } else {
                    this.cei++;
                }
                C5004al.m7442n(this, 10000);
                C4990ab.m7416i("MicroMsg.CoreServiceConnection", String.format("ZombieWaker posted again with step %d", new Object[]{Integer.valueOf(this.cei)}));
                AppMethodBeat.m2505o(57666);
            } finally {
                C1246e.this.ceb.unlock();
                AppMethodBeat.m2505o(57666);
            }
        }
    }

    /* renamed from: com.tencent.mm.app.e$3 */
    class C12533 extends C1934a {
        C12533() {
        }

        public final boolean check() {
            return true;
        }
    }

    public C1246e() {
        AppMethodBeat.m2504i(57667);
        AppMethodBeat.m2505o(57667);
    }

    static {
        AppMethodBeat.m2504i(57676);
        AppMethodBeat.m2505o(57676);
    }

    public final void onServiceConnected(final ComponentName componentName, final IBinder iBinder) {
        AppMethodBeat.m2504i(57668);
        C4990ab.m7420w("MicroMsg.CoreServiceConnection", "onServiceConnected ");
        C1246e.m2689cS("com.tencent.mm:push");
        if (!C45270c.m83434Ij()) {
            synchronized (lock) {
                try {
                    C4990ab.m7416i("MicroMsg.CoreServiceConnection", "remove zombie killer.");
                    C5004al.m7439af(this.cee);
                    cea = false;
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(57668);
                    }
                }
            }
            try {
                this.ceb.lock();
                this.cec = false;
                this.ced = iBinder;
                this.ceb.unlock();
                C1314b.m2812HQ().mo4642o(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(57662);
                        C1246e.m2686a(C1246e.this, iBinder);
                        AppMethodBeat.m2505o(57662);
                    }
                });
            } catch (Throwable th2) {
                this.ceb.unlock();
                AppMethodBeat.m2505o(57668);
            }
        } else if (iBinder == null) {
            C4990ab.m7420w("MicroMsg.CoreServiceConnection", "onServiceConnected binder == null");
            AppMethodBeat.m2505o(57668);
            return;
        } else if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            synchronized (lock) {
                try {
                    C4990ab.m7416i("MicroMsg.CoreServiceConnection", "remove zombie killer.");
                    C5004al.m7439af(this.cee);
                    cea = false;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(57668);
                }
            }
            try {
                this.ceb.lock();
                this.cec = false;
                if (this.ced == null || !C5046bo.m7563gW(this.ced.hashCode(), iBinder.hashCode())) {
                    this.ced = iBinder;
                    this.ceb.unlock();
                    C1314b.m2812HQ().mo4642o(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(57661);
                            C1246e.m2686a(C1246e.this, iBinder);
                            AppMethodBeat.m2505o(57661);
                        }
                    });
                    AppMethodBeat.m2505o(57668);
                    return;
                }
                C4990ab.m7420w("MicroMsg.CoreServiceConnection", "onServiceConnected binder == serviceBinder");
                this.ceb.unlock();
                return;
            } catch (Throwable th3) {
                this.ceb.unlock();
                AppMethodBeat.m2505o(57668);
            }
        }
        AppMethodBeat.m2505o(57668);
    }

    public final void onServiceDisconnected(final ComponentName componentName) {
        AppMethodBeat.m2504i(57669);
        C4990ab.m7420w("MicroMsg.CoreServiceConnection", "onServiceDisconnected ");
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            try {
                this.ceb.lock();
                this.cec = false;
                this.ced = null;
                this.ceb.unlock();
                C1314b.m2812HQ().mo4642o(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(57665);
                        C1246e.m2685a(C1246e.this);
                        AppMethodBeat.m2505o(57665);
                    }
                });
            } catch (Throwable th) {
                this.ceb.unlock();
                AppMethodBeat.m2505o(57669);
            }
        }
        AppMethodBeat.m2505o(57669);
    }

    /* renamed from: aU */
    public final void mo4530aU(Context context) {
        AppMethodBeat.m2504i(57670);
        C1311a.m2807jD("bindCore");
        try {
            this.ceb.lock();
            boolean z = this.ced != null && this.ced.isBinderAlive();
            C4990ab.m7417i("MicroMsg.CoreServiceConnection", "enter bindCore, isBinding: %b, binderAlive: %b", Boolean.valueOf(this.cec), Boolean.valueOf(z));
            if (this.cec || z) {
                C4990ab.m7421w("MicroMsg.CoreServiceConnection", "bindCore reenter, isBinding: %b, binderAlive: %b, return directly.", Boolean.valueOf(this.cec), Boolean.valueOf(z));
                return;
            }
            this.ceb.unlock();
            Intent intent;
            if (C45270c.m83434Ij()) {
                intent = new Intent(context, CoreService.class);
                C4990ab.m7416i("MicroMsg.CoreServiceConnection", "prepare dispatcher / bind core service");
                try {
                    if (context.bindService(intent, this, 1)) {
                        try {
                            this.ceb.lock();
                            this.cec = true;
                            this.ceb.unlock();
                            synchronized (lock) {
                                try {
                                    if (!cea) {
                                        cea = true;
                                        C4990ab.m7416i("MicroMsg.CoreServiceConnection", "ZombieWaker posted.");
                                        C5004al.m7442n(this.cee, 40000);
                                    }
                                } finally {
                                    while (true) {
                                    }
                                    AppMethodBeat.m2505o(57670);
                                }
                            }
                            return;
                        } catch (Throwable th) {
                            this.ceb.unlock();
                            AppMethodBeat.m2505o(57670);
                        }
                    }
                    C4990ab.m7412e("MicroMsg.CoreServiceConnection", "bindService failed, may be caused by some crashes");
                    AppMethodBeat.m2505o(57670);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.CoreServiceConnection", "CoreServiceConnection bindService Exception:%s", e.getMessage());
                    AppMethodBeat.m2505o(57670);
                }
            } else if (C1324b.m2837c(context, "noop", false)) {
                try {
                    this.ceb.lock();
                    this.cec = true;
                    this.ceb.unlock();
                    synchronized (lock) {
                        try {
                            if (!cea) {
                                cea = true;
                                C4990ab.m7416i("MicroMsg.CoreServiceConnection", "ZombieWaker posted.");
                                C5004al.m7442n(this.cee, 10000);
                            }
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.m2505o(57670);
                        }
                    }
                    intent = new Intent(context, CoreService.class);
                    C4990ab.m7416i("MicroMsg.CoreServiceConnection", "prepare dispatcher / bind core service");
                    try {
                        if (context.bindService(intent, this, 1)) {
                            AppMethodBeat.m2505o(57670);
                        } else {
                            C4990ab.m7412e("MicroMsg.CoreServiceConnection", "bindService failed, may be caused by some crashes");
                        }
                    } catch (Exception e2) {
                        C4990ab.m7413e("MicroMsg.CoreServiceConnection", "bindCore() bindService Exception:%S", e2.getMessage());
                        AppMethodBeat.m2505o(57670);
                    }
                } catch (Throwable th2) {
                    this.ceb.unlock();
                    AppMethodBeat.m2505o(57670);
                }
            } else {
                C4990ab.m7416i("MicroMsg.CoreServiceConnection", "ensureServiceInstance return false");
                AppMethodBeat.m2505o(57670);
            }
        } finally {
            this.ceb.unlock();
            AppMethodBeat.m2505o(57670);
        }
    }

    /* renamed from: cS */
    public static int m2689cS(String str) {
        AppMethodBeat.m2504i(57671);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.CoreServiceConnection", "getPicByProcessName() processName == null");
            AppMethodBeat.m2505o(57671);
            return -1;
        }
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) C4996ah.getContext().getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            C4990ab.m7416i("MicroMsg.CoreServiceConnection", "getPicByProcessName() processes == null");
            AppMethodBeat.m2505o(57671);
            return -1;
        }
        int i;
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(str)) {
                i = runningAppProcessInfo.pid;
                break;
            }
        }
        i = -1;
        AppMethodBeat.m2505o(57671);
        return i;
    }

    /* renamed from: Bc */
    public static void m2684Bc() {
        AppMethodBeat.m2504i(57672);
        C4990ab.m7413e("MicroMsg.CoreServiceConnection", "killPushProcess() pid = %s, stack[%s]", Integer.valueOf(C1246e.m2689cS("com.tencent.mm:push")), C5046bo.dpG());
        Process.killProcess(C1246e.m2689cS("com.tencent.mm:push"));
        AppMethodBeat.m2505o(57672);
    }

    /* renamed from: a */
    static /* synthetic */ void m2686a(C1246e c1246e, IBinder iBinder) {
        AppMethodBeat.m2504i(57673);
        C1311a.m2807jD("onServiceConnected");
        if (iBinder == null) {
            Assert.assertTrue("WorkerProfile onServiceConnected binder == null", false);
            C4872b.m7233A("WorkerProfile onServiceConnected binder == null", "it will result in accInfo being null");
        }
        C1902e c41739r = new C41739r(C1904a.m4088m(iBinder));
        try {
            c41739r.ftR.mo5556a(new C12533());
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
        }
        try {
            c41739r.ftR.mo5553a(new C12474());
        } catch (Exception e2) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e2));
        }
        C1720g.m3537RQ();
        C1682b RO = C1720g.m3535RO();
        C4990ab.m7420w("MMKernel.CoreNetwork", "setting up remote dispatcher ".concat(String.valueOf(c41739r)));
        RO.eJn.mo5171b(c41739r);
        c41739r.mo5522a(new C16894());
        try {
            C1912i adh = c41739r.adh();
            if (adh != null) {
                adh.mo5597c(RO.eJq);
            }
        } catch (RemoteException e3) {
            C4990ab.m7413e("MMKernel.CoreNetwork", "exception:%s", C5046bo.m7574l(e3));
        }
        c41739r.mo5524a(new C16905());
        C1898c adg = c41739r.adg();
        if (adg == null) {
            C4990ab.m7414f("MMKernel.CoreNetwork", "accInfo is null, it would assert before!!!");
            RO.eJo.reset();
            RO.eJo.acW();
        } else {
            String str;
            C4872b.m7234a(new C16856());
            C1720g.m3537RQ();
            C5144y c5144y = C1720g.m3536RP().eJH;
            Assert.assertTrue("setAutoAuth, getSysCfg() is null, stack = " + C5046bo.dpG(), c5144y != null);
            int Ml = c5144y.mo10573Ml(47);
            String str2 = (String) c5144y.get(2);
            String str3 = (String) c5144y.get(3);
            String str4 = (String) c5144y.get(25);
            String str5 = (String) c5144y.get(24);
            C4837a hN = C4838o.m7197hN((String) c5144y.get(6), (String) c5144y.get(7));
            C4990ab.m7411d("MMKernel.CoreNetwork", "dkidc host[s:%s l:%s] builtin[s:%s l:%s] ports[%s] timeout[%s] mmtls[%d]", str5, str4, str2, str3, str, r4, Integer.valueOf(Ml));
            Assert.assertTrue("setAutoAuth, autoAuth is null, stack = " + C5046bo.dpG(), true);
            c41739r.mo5525a(false, str2, str3, hN.vys, hN.vyt, hN.vyu, hN.vyv, str5, str4);
            c41739r.mo5534cI((Ml & 1) == 0);
            C1720g.m3537RQ();
            C1720g.m3534RN();
            Assert.assertTrue("setAutoAuth, accInfo is null, stack = " + C5046bo.dpG(), adg != null);
            if (C1720g.m3531RK() && C1720g.m3534RN().eJb) {
                RO.eJo.mo14551d(c41739r);
                C1897b.m4021a(new C16878());
                C4990ab.m7417i("MMKernel.CoreNetwork", "setAutoAuth differrent accStg uin[%d], accInfo uin[%d], acc init[%b]", Integer.valueOf(C1668a.m3383QF()), Integer.valueOf(adg.mo5480QF()), Boolean.valueOf(C1720g.m3534RN().mo5161QY()));
                if (C1668a.m3383QF() != adg.mo5480QF()) {
                    C4990ab.m7420w("MMKernel.CoreNetwork", "update acc info with acc stg: uin =" + adg.mo5480QF());
                    str = "setAutoAuth, getConfigStg() is null, stack = " + C5046bo.dpG();
                    C1720g.m3537RQ();
                    Assert.assertTrue(str, C1720g.m3536RP().mo5239Ry() != null);
                    C1720g.m3537RQ();
                    String str6 = (String) C1720g.m3536RP().mo5239Ry().get(2, null);
                    adg.mo5482a(new byte[0], new byte[0], new byte[0], C1668a.m3383QF());
                    adg.setUsername(str6);
                }
            } else {
                C4990ab.m7421w("MMKernel.CoreNetwork", "need to clear acc info and maybe stop networking accHasReady():%b isInitializedNotifyAllDone:%b", Boolean.valueOf(C1720g.m3531RK()), Boolean.valueOf(C1720g.m3534RN().eJb));
                C7053e.pXa.mo8378a(148, C1720g.m3531RK() ? 44 : 43, 1, false);
                adg.reset();
                c41739r.reset();
                RO.eJo.mo14551d(c41739r);
                C1897b.m4021a(new C16867());
                if (C1668a.m3383QF() != adg.mo5480QF()) {
                    C7053e.pXa.mo8378a(148, 45, 1, false);
                    C4990ab.m7421w("MMKernel.CoreNetwork", "summerauth update acc info with acc stg: old acc uin=%d, acc stg uin=%d, acc init %b %b", Integer.valueOf(adg.mo5480QF()), Integer.valueOf(C1668a.m3383QF()), Boolean.valueOf(C1720g.m3534RN().mo5161QY()), Boolean.valueOf(C1720g.m3534RN().eJb));
                    adg.mo5489hB(C1668a.m3383QF());
                } else {
                    C4990ab.m7417i("MMKernel.CoreNetwork", "acc info uin same with acc stg", Integer.valueOf(adg.mo5480QF()), Integer.valueOf(C1668a.m3383QF()));
                }
            }
        }
        if (C1810a.m3717XF()) {
            try {
                C1720g.m3537RQ();
                if (C1720g.m3534RN().eIQ != null) {
                    C1720g.m3537RQ();
                    if (C1720g.m3535RO().eJo.ftA != null) {
                        C1720g.m3537RQ();
                        C1810a c1810a = C1720g.m3534RN().eIQ;
                        C1720g.m3537RQ();
                        C1898c adg2 = C1720g.m3535RO().eJo.ftA.adg();
                        long anU = C5046bo.anU();
                        if (adg2 == null) {
                            C4990ab.m7412e("MicroMsg.AccInfoCacheInWorker", "reuseToPush  accinfo == null");
                            C7053e.pXa.mo8378a(226, 6, 1, false);
                        } else {
                            C4990ab.m7417i("MicroMsg.AccInfoCacheInWorker", "reuseToPush islogin:%b cache:%s", Boolean.valueOf(adg2.adb()), Integer.valueOf(c1810a.mo5375XE()));
                            if (adg2.adb()) {
                                long j;
                                if (c1810a.mo5375XE() > 0) {
                                    C7053e.pXa.mo8378a(226, 7, 1, false);
                                    C4990ab.m7412e("MicroMsg.AccInfoCacheInWorker", "reuseToPush  something Error! islogin && isCacheValid . Clean Cache Now !");
                                    c1810a.fka = null;
                                } else {
                                    C4990ab.m7420w("MicroMsg.AccInfoCacheInWorker", "reuseToPush Here, DANGER! . HERE means worker just init , try set from push now!");
                                    C7053e.pXa.mo8378a(226, 8, 1, false);
                                }
                                c1810a.fka = adg2.adf();
                                C7053e c7053e = C7053e.pXa;
                                if (c1810a.mo5375XE() > 0) {
                                    j = 9;
                                } else {
                                    j = 10;
                                }
                                c7053e.mo8378a(226, j, 1, false);
                            } else if (c1810a.mo5375XE() <= 0) {
                                C7053e.pXa.mo8378a(226, 11, 1, false);
                                C4990ab.m7421w("MicroMsg.AccInfoCacheInWorker", "reuseToPush something is null. give up %s", c1810a.toString());
                            } else {
                                int S = adg2.mo5481S(c1810a.fka);
                                C4990ab.m7417i("MicroMsg.AccInfoCacheInWorker", "reuseToPush parseBuf ret:%s time:%s  cache:%s", Integer.valueOf(S), Long.valueOf(C5046bo.m7566gb(anU)), Integer.valueOf(c1810a.mo5375XE()));
                                if (S != 0) {
                                    C4990ab.m7413e("MicroMsg.AccInfoCacheInWorker", "reuseToPush parseBuf ret:%s", Integer.valueOf(S));
                                    c1810a.fka = null;
                                } else {
                                    c1810a.fkb = 0;
                                }
                                C7053e.pXa.mo8378a(226, (long) (S + 20), 1, false);
                            }
                        }
                    }
                }
                r2 = new Object[2];
                C1720g.m3537RQ();
                r2[0] = C1720g.m3534RN().eIQ;
                C1720g.m3537RQ();
                r2[1] = C1720g.m3535RO().eJo.ftA;
                C4990ab.m7417i("MicroMsg.AccInfoCacheInWorker", "tryReuseToPush but object is null [%s, %s]", r2);
            } catch (Throwable th) {
                C4990ab.m7413e("MicroMsg.AccInfoCacheInWorker", "tryReuseToPush Exception:%s", C5046bo.m7574l(th));
            }
        }
        if (C1720g.m3531RK()) {
            C1720g.m3537RQ();
            if (C1720g.m3535RO().eJo != null) {
                C1720g.m3537RQ();
                if (C1720g.m3535RO().eJo.ftA != null) {
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.ftA.mo5532cG(true);
                }
            }
        }
        if (C1720g.m3531RK()) {
            C4879a.xxA.mo10055m(new C6483gi());
        }
        C1311a.m2807jD("onServiceConnected done");
        AppMethodBeat.m2505o(57673);
    }

    /* renamed from: a */
    static /* synthetic */ void m2685a(C1246e c1246e) {
        AppMethodBeat.m2504i(57674);
        C1720g.m3534RN();
        if (!C1668a.m3395QX() || C1668a.m3393QT()) {
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.acW();
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.reset();
            AppMethodBeat.m2505o(57674);
            return;
        }
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.acV();
        c1246e.mo4530aU(C4996ah.getContext());
        AppMethodBeat.m2505o(57674);
    }
}
