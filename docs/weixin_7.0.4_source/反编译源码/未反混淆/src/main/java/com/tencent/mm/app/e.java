package com.tencent.mm.app;

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
import com.tencent.mm.ai.r;
import com.tencent.mm.blink.a;
import com.tencent.mm.blink.b;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.c;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cc;
import com.tencent.mm.network.e;
import com.tencent.mm.network.f;
import com.tencent.mm.network.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.o;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import junit.framework.Assert;

public final class e implements ServiceConnection {
    private static boolean cea = false;
    private static Object lock = new Object();
    private ReentrantLock ceb = new ReentrantLock();
    private boolean cec = false;
    private IBinder ced = null;
    private Runnable cee = new Runnable() {
        private int cei = 0;

        public final void run() {
            AppMethodBeat.i(57666);
            try {
                e.this.ceb.lock();
                boolean z = e.this.ced != null && e.this.ced.isBinderAlive();
                ab.i("MicroMsg.CoreServiceConnection", "mZombieWaker run serviceBinder: %s, binderAlive: %b", e.this.ced, Boolean.valueOf(z));
                if (z) {
                    ab.w("MicroMsg.CoreServiceConnection", "mZombieWaker run binderAlive return directly.");
                    return;
                }
                e.this.ceb.unlock();
                ab.e("MicroMsg.CoreServiceConnection", String.format("CoreService started but not responding, possibly zombie. Use step %d to restart CoreService.", new Object[]{Integer.valueOf(this.cei)}));
                if (this.cei == 1) {
                    int cS = e.cS("com.tencent.mm:push");
                    if (cS != -1) {
                        ab.i("MicroMsg.CoreServiceConnection", String.format("Push Process %d killed.", new Object[]{Integer.valueOf(cS)}));
                        ab.dot();
                        Process.killProcess(cS);
                    } else {
                        ab.i("MicroMsg.CoreServiceConnection", "Push Process not found.");
                    }
                }
                Context context = ah.getContext();
                Intent intent = new Intent(context, CoreService.class);
                try {
                    ab.i("MicroMsg.CoreServiceConnection", "unbinding CoreService...");
                    context.unbindService(e.this);
                    try {
                        if (c.Ij()) {
                            context.bindService(intent, e.this, 1);
                        } else {
                            context.stopService(intent);
                            context.bindService(intent, e.this, 1);
                            context.startService(intent);
                        }
                    } catch (Exception e) {
                        ab.e("MicroMsg.CoreServiceConnection", "CoreServiceConnection mZombieWaker Exception:%s", e.getMessage());
                    }
                } catch (Exception e2) {
                    try {
                        if (c.Ij()) {
                            context.bindService(intent, e.this, 1);
                        } else {
                            context.stopService(intent);
                            context.bindService(intent, e.this, 1);
                            context.startService(intent);
                        }
                    } catch (Exception e3) {
                        ab.e("MicroMsg.CoreServiceConnection", "CoreServiceConnection mZombieWaker Exception:%s", e3.getMessage());
                    }
                } catch (Throwable th) {
                    try {
                        if (c.Ij()) {
                            context.bindService(intent, e.this, 1);
                        } else {
                            context.stopService(intent);
                            context.bindService(intent, e.this, 1);
                            context.startService(intent);
                        }
                    } catch (Exception e4) {
                        ab.e("MicroMsg.CoreServiceConnection", "CoreServiceConnection mZombieWaker Exception:%s", e4.getMessage());
                    }
                    AppMethodBeat.o(57666);
                }
                if (this.cei == 1) {
                    this.cei = 0;
                } else {
                    this.cei++;
                }
                al.n(this, 10000);
                ab.i("MicroMsg.CoreServiceConnection", String.format("ZombieWaker posted again with step %d", new Object[]{Integer.valueOf(this.cei)}));
                AppMethodBeat.o(57666);
            } finally {
                e.this.ceb.unlock();
                AppMethodBeat.o(57666);
            }
        }
    };

    public e() {
        AppMethodBeat.i(57667);
        AppMethodBeat.o(57667);
    }

    static {
        AppMethodBeat.i(57676);
        AppMethodBeat.o(57676);
    }

    public final void onServiceConnected(final ComponentName componentName, final IBinder iBinder) {
        AppMethodBeat.i(57668);
        ab.w("MicroMsg.CoreServiceConnection", "onServiceConnected ");
        cS("com.tencent.mm:push");
        if (!c.Ij()) {
            synchronized (lock) {
                try {
                    ab.i("MicroMsg.CoreServiceConnection", "remove zombie killer.");
                    al.af(this.cee);
                    cea = false;
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(57668);
                    }
                }
            }
            try {
                this.ceb.lock();
                this.cec = false;
                this.ced = iBinder;
                this.ceb.unlock();
                b.HQ().o(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(57662);
                        e.a(e.this, iBinder);
                        AppMethodBeat.o(57662);
                    }
                });
            } catch (Throwable th2) {
                this.ceb.unlock();
                AppMethodBeat.o(57668);
            }
        } else if (iBinder == null) {
            ab.w("MicroMsg.CoreServiceConnection", "onServiceConnected binder == null");
            AppMethodBeat.o(57668);
            return;
        } else if (((h) g.RM().Rn()).SG()) {
            synchronized (lock) {
                try {
                    ab.i("MicroMsg.CoreServiceConnection", "remove zombie killer.");
                    al.af(this.cee);
                    cea = false;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(57668);
                }
            }
            try {
                this.ceb.lock();
                this.cec = false;
                if (this.ced == null || !bo.gW(this.ced.hashCode(), iBinder.hashCode())) {
                    this.ced = iBinder;
                    this.ceb.unlock();
                    b.HQ().o(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(57661);
                            e.a(e.this, iBinder);
                            AppMethodBeat.o(57661);
                        }
                    });
                    AppMethodBeat.o(57668);
                    return;
                }
                ab.w("MicroMsg.CoreServiceConnection", "onServiceConnected binder == serviceBinder");
                this.ceb.unlock();
                return;
            } catch (Throwable th3) {
                this.ceb.unlock();
                AppMethodBeat.o(57668);
            }
        }
        AppMethodBeat.o(57668);
    }

    public final void onServiceDisconnected(final ComponentName componentName) {
        AppMethodBeat.i(57669);
        ab.w("MicroMsg.CoreServiceConnection", "onServiceDisconnected ");
        if (((h) g.RM().Rn()).SG()) {
            try {
                this.ceb.lock();
                this.cec = false;
                this.ced = null;
                this.ceb.unlock();
                b.HQ().o(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(57665);
                        e.a(e.this);
                        AppMethodBeat.o(57665);
                    }
                });
            } catch (Throwable th) {
                this.ceb.unlock();
                AppMethodBeat.o(57669);
            }
        }
        AppMethodBeat.o(57669);
    }

    public final void aU(Context context) {
        AppMethodBeat.i(57670);
        a.jD("bindCore");
        try {
            this.ceb.lock();
            boolean z = this.ced != null && this.ced.isBinderAlive();
            ab.i("MicroMsg.CoreServiceConnection", "enter bindCore, isBinding: %b, binderAlive: %b", Boolean.valueOf(this.cec), Boolean.valueOf(z));
            if (this.cec || z) {
                ab.w("MicroMsg.CoreServiceConnection", "bindCore reenter, isBinding: %b, binderAlive: %b, return directly.", Boolean.valueOf(this.cec), Boolean.valueOf(z));
                return;
            }
            this.ceb.unlock();
            Intent intent;
            if (c.Ij()) {
                intent = new Intent(context, CoreService.class);
                ab.i("MicroMsg.CoreServiceConnection", "prepare dispatcher / bind core service");
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
                                        ab.i("MicroMsg.CoreServiceConnection", "ZombieWaker posted.");
                                        al.n(this.cee, 40000);
                                    }
                                } finally {
                                    while (true) {
                                    }
                                    AppMethodBeat.o(57670);
                                }
                            }
                            return;
                        } catch (Throwable th) {
                            this.ceb.unlock();
                            AppMethodBeat.o(57670);
                        }
                    }
                    ab.e("MicroMsg.CoreServiceConnection", "bindService failed, may be caused by some crashes");
                    AppMethodBeat.o(57670);
                } catch (Exception e) {
                    ab.e("MicroMsg.CoreServiceConnection", "CoreServiceConnection bindService Exception:%s", e.getMessage());
                    AppMethodBeat.o(57670);
                }
            } else if (com.tencent.mm.booter.b.c(context, "noop", false)) {
                try {
                    this.ceb.lock();
                    this.cec = true;
                    this.ceb.unlock();
                    synchronized (lock) {
                        try {
                            if (!cea) {
                                cea = true;
                                ab.i("MicroMsg.CoreServiceConnection", "ZombieWaker posted.");
                                al.n(this.cee, 10000);
                            }
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.o(57670);
                        }
                    }
                    intent = new Intent(context, CoreService.class);
                    ab.i("MicroMsg.CoreServiceConnection", "prepare dispatcher / bind core service");
                    try {
                        if (context.bindService(intent, this, 1)) {
                            AppMethodBeat.o(57670);
                        } else {
                            ab.e("MicroMsg.CoreServiceConnection", "bindService failed, may be caused by some crashes");
                        }
                    } catch (Exception e2) {
                        ab.e("MicroMsg.CoreServiceConnection", "bindCore() bindService Exception:%S", e2.getMessage());
                        AppMethodBeat.o(57670);
                    }
                } catch (Throwable th2) {
                    this.ceb.unlock();
                    AppMethodBeat.o(57670);
                }
            } else {
                ab.i("MicroMsg.CoreServiceConnection", "ensureServiceInstance return false");
                AppMethodBeat.o(57670);
            }
        } finally {
            this.ceb.unlock();
            AppMethodBeat.o(57670);
        }
    }

    public static int cS(String str) {
        AppMethodBeat.i(57671);
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.CoreServiceConnection", "getPicByProcessName() processName == null");
            AppMethodBeat.o(57671);
            return -1;
        }
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) ah.getContext().getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            ab.i("MicroMsg.CoreServiceConnection", "getPicByProcessName() processes == null");
            AppMethodBeat.o(57671);
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
        AppMethodBeat.o(57671);
        return i;
    }

    public static void Bc() {
        AppMethodBeat.i(57672);
        ab.e("MicroMsg.CoreServiceConnection", "killPushProcess() pid = %s, stack[%s]", Integer.valueOf(cS("com.tencent.mm:push")), bo.dpG());
        Process.killProcess(cS("com.tencent.mm:push"));
        AppMethodBeat.o(57672);
    }

    static /* synthetic */ void a(e eVar, IBinder iBinder) {
        AppMethodBeat.i(57673);
        a.jD("onServiceConnected");
        if (iBinder == null) {
            Assert.assertTrue("WorkerProfile onServiceConnected binder == null", false);
            com.tencent.mm.sdk.a.b.A("WorkerProfile onServiceConnected binder == null", "it will result in accInfo being null");
        }
        com.tencent.mm.network.e rVar = new r(f.a.m(iBinder));
        try {
            rVar.ftR.a(new s.a() {
                public final boolean check() {
                    return true;
                }
            });
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
        }
        try {
            rVar.ftR.a(new com.tencent.mm.network.g.a() {
                public final void gi(final int i) {
                    AppMethodBeat.i(57664);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(57663);
                            if (com.tencent.mm.kernel.b.Re() != null) {
                                com.tencent.mm.kernel.b.Re().kx(i);
                            }
                            AppMethodBeat.o(57663);
                        }
                    });
                    AppMethodBeat.o(57664);
                }
            });
        } catch (Exception e2) {
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e2));
        }
        g.RQ();
        com.tencent.mm.kernel.b RO = g.RO();
        ab.w("MMKernel.CoreNetwork", "setting up remote dispatcher ".concat(String.valueOf(rVar)));
        RO.eJn.b(rVar);
        rVar.a(new com.tencent.mm.network.h.a() {
            public final void networkAnalysisCallBack(int i, int i2, boolean z, String str) {
                AppMethodBeat.i(57925);
                ab.i("MMKernel.CoreNetwork", "callback, kv:%s", str);
                b.b(i, i2, z, str);
                AppMethodBeat.o(57925);
            }
        });
        try {
            i adh = rVar.adh();
            if (adh != null) {
                adh.c(RO.eJq);
            }
        } catch (RemoteException e3) {
            ab.e("MMKernel.CoreNetwork", "exception:%s", bo.l(e3));
        }
        rVar.a(new y.a() {
            private byte[] eJt;

            public final byte[] Ri() {
                AppMethodBeat.i(57926);
                if (g.RK()) {
                    com.tencent.mm.protocal.x.a aVar = new com.tencent.mm.protocal.x.a();
                    g.RQ();
                    g.RN();
                    aVar.uin = a.QF();
                    g.RQ();
                    aVar.fIi = bo.anf((String) g.RP().Ry().get(8195, null));
                    aVar.netType = com.tencent.mm.protocal.a.getNetType(ah.getContext());
                    aVar.vyo = com.tencent.mm.protocal.a.dlZ();
                    try {
                        byte[] ZT = aVar.ZT();
                        this.eJt = aVar.eJt;
                        AppMethodBeat.o(57926);
                        return ZT;
                    } catch (Exception e) {
                        ab.e("MMKernel.CoreNetwork", "exception:%s", bo.l(e));
                        AppMethodBeat.o(57926);
                        return null;
                    }
                }
                AppMethodBeat.o(57926);
                return null;
            }

            public final int K(byte[] bArr) {
                int i = 0;
                AppMethodBeat.i(57927);
                com.tencent.mm.protocal.x.b bVar = new com.tencent.mm.protocal.x.b();
                try {
                    bVar.P(bArr);
                    i = (int) bVar.vyM;
                    AppMethodBeat.o(57927);
                    return i;
                } catch (Exception e) {
                    ab.e("MMKernel.CoreNetwork", "exception:%s", bo.l(e));
                    AppMethodBeat.o(57927);
                    return i;
                }
            }

            public final byte[] Rj() {
                return this.eJt;
            }
        });
        com.tencent.mm.network.c adg = rVar.adg();
        if (adg == null) {
            ab.f("MMKernel.CoreNetwork", "accInfo is null, it would assert before!!!");
            RO.eJo.reset();
            RO.eJo.acW();
        } else {
            String str;
            com.tencent.mm.sdk.a.b.a(new com.tencent.mm.sdk.a.a() {
                public final void lG(String str) {
                    AppMethodBeat.i(57928);
                    ab.w("MMKernel.CoreNetwork", "CallbackForReset errorStack %s ", str);
                    g.RQ();
                    if (g.RR() != null) {
                        g.RQ();
                        cc RR = g.RR();
                        RR.isRunning = true;
                        for (com.tencent.mm.model.cc.a aVar : RR.fnN) {
                            if (aVar != null) {
                                aVar.aaG();
                            }
                        }
                        RR.isRunning = false;
                    }
                    g.RQ();
                    if (g.RP() != null) {
                        g.RQ();
                        g.RP().jC(str);
                    }
                    AppMethodBeat.o(57928);
                }
            });
            g.RQ();
            com.tencent.mm.storage.y yVar = g.RP().eJH;
            Assert.assertTrue("setAutoAuth, getSysCfg() is null, stack = " + bo.dpG(), yVar != null);
            int Ml = yVar.Ml(47);
            String str2 = (String) yVar.get(2);
            String str3 = (String) yVar.get(3);
            String str4 = (String) yVar.get(25);
            String str5 = (String) yVar.get(24);
            o.a hN = o.hN((String) yVar.get(6), (String) yVar.get(7));
            ab.d("MMKernel.CoreNetwork", "dkidc host[s:%s l:%s] builtin[s:%s l:%s] ports[%s] timeout[%s] mmtls[%d]", str5, str4, str2, str3, str, r4, Integer.valueOf(Ml));
            Assert.assertTrue("setAutoAuth, autoAuth is null, stack = " + bo.dpG(), true);
            rVar.a(false, str2, str3, hN.vys, hN.vyt, hN.vyu, hN.vyv, str5, str4);
            rVar.cI((Ml & 1) == 0);
            g.RQ();
            g.RN();
            Assert.assertTrue("setAutoAuth, accInfo is null, stack = " + bo.dpG(), adg != null);
            if (g.RK() && g.RN().eJb) {
                RO.eJo.d(rVar);
                com.tencent.mm.network.b.a(new com.tencent.mm.network.b.a() {
                    public final e Rk() {
                        AppMethodBeat.i(57930);
                        try {
                            e eVar = b.this.eJo.ftA;
                            AppMethodBeat.o(57930);
                            return eVar;
                        } catch (Throwable th) {
                            ab.e("MMKernel.CoreNetwork", "%s", bo.l(th));
                            AppMethodBeat.o(57930);
                            return null;
                        }
                    }
                });
                ab.i("MMKernel.CoreNetwork", "setAutoAuth differrent accStg uin[%d], accInfo uin[%d], acc init[%b]", Integer.valueOf(com.tencent.mm.kernel.a.QF()), Integer.valueOf(adg.QF()), Boolean.valueOf(g.RN().QY()));
                if (com.tencent.mm.kernel.a.QF() != adg.QF()) {
                    ab.w("MMKernel.CoreNetwork", "update acc info with acc stg: uin =" + adg.QF());
                    str = "setAutoAuth, getConfigStg() is null, stack = " + bo.dpG();
                    g.RQ();
                    Assert.assertTrue(str, g.RP().Ry() != null);
                    g.RQ();
                    String str6 = (String) g.RP().Ry().get(2, null);
                    adg.a(new byte[0], new byte[0], new byte[0], com.tencent.mm.kernel.a.QF());
                    adg.setUsername(str6);
                }
            } else {
                ab.w("MMKernel.CoreNetwork", "need to clear acc info and maybe stop networking accHasReady():%b isInitializedNotifyAllDone:%b", Boolean.valueOf(g.RK()), Boolean.valueOf(g.RN().eJb));
                com.tencent.mm.plugin.report.e.pXa.a(148, g.RK() ? 44 : 43, 1, false);
                adg.reset();
                rVar.reset();
                RO.eJo.d(rVar);
                com.tencent.mm.network.b.a(new com.tencent.mm.network.b.a() {
                    public final e Rk() {
                        AppMethodBeat.i(57929);
                        try {
                            e eVar = b.this.eJo.ftA;
                            AppMethodBeat.o(57929);
                            return eVar;
                        } catch (Throwable th) {
                            ab.e("MMKernel.CoreNetwork", "%s", bo.l(th));
                            AppMethodBeat.o(57929);
                            return null;
                        }
                    }
                });
                if (com.tencent.mm.kernel.a.QF() != adg.QF()) {
                    com.tencent.mm.plugin.report.e.pXa.a(148, 45, 1, false);
                    ab.w("MMKernel.CoreNetwork", "summerauth update acc info with acc stg: old acc uin=%d, acc stg uin=%d, acc init %b %b", Integer.valueOf(adg.QF()), Integer.valueOf(com.tencent.mm.kernel.a.QF()), Boolean.valueOf(g.RN().QY()), Boolean.valueOf(g.RN().eJb));
                    adg.hB(com.tencent.mm.kernel.a.QF());
                } else {
                    ab.i("MMKernel.CoreNetwork", "acc info uin same with acc stg", Integer.valueOf(adg.QF()), Integer.valueOf(com.tencent.mm.kernel.a.QF()));
                }
            }
        }
        if (com.tencent.mm.model.a.XF()) {
            try {
                g.RQ();
                if (g.RN().eIQ != null) {
                    g.RQ();
                    if (g.RO().eJo.ftA != null) {
                        g.RQ();
                        com.tencent.mm.model.a aVar = g.RN().eIQ;
                        g.RQ();
                        com.tencent.mm.network.c adg2 = g.RO().eJo.ftA.adg();
                        long anU = bo.anU();
                        if (adg2 == null) {
                            ab.e("MicroMsg.AccInfoCacheInWorker", "reuseToPush  accinfo == null");
                            com.tencent.mm.plugin.report.e.pXa.a(226, 6, 1, false);
                        } else {
                            ab.i("MicroMsg.AccInfoCacheInWorker", "reuseToPush islogin:%b cache:%s", Boolean.valueOf(adg2.adb()), Integer.valueOf(aVar.XE()));
                            if (adg2.adb()) {
                                long j;
                                if (aVar.XE() > 0) {
                                    com.tencent.mm.plugin.report.e.pXa.a(226, 7, 1, false);
                                    ab.e("MicroMsg.AccInfoCacheInWorker", "reuseToPush  something Error! islogin && isCacheValid . Clean Cache Now !");
                                    aVar.fka = null;
                                } else {
                                    ab.w("MicroMsg.AccInfoCacheInWorker", "reuseToPush Here, DANGER! . HERE means worker just init , try set from push now!");
                                    com.tencent.mm.plugin.report.e.pXa.a(226, 8, 1, false);
                                }
                                aVar.fka = adg2.adf();
                                com.tencent.mm.plugin.report.e eVar2 = com.tencent.mm.plugin.report.e.pXa;
                                if (aVar.XE() > 0) {
                                    j = 9;
                                } else {
                                    j = 10;
                                }
                                eVar2.a(226, j, 1, false);
                            } else if (aVar.XE() <= 0) {
                                com.tencent.mm.plugin.report.e.pXa.a(226, 11, 1, false);
                                ab.w("MicroMsg.AccInfoCacheInWorker", "reuseToPush something is null. give up %s", aVar.toString());
                            } else {
                                int S = adg2.S(aVar.fka);
                                ab.i("MicroMsg.AccInfoCacheInWorker", "reuseToPush parseBuf ret:%s time:%s  cache:%s", Integer.valueOf(S), Long.valueOf(bo.gb(anU)), Integer.valueOf(aVar.XE()));
                                if (S != 0) {
                                    ab.e("MicroMsg.AccInfoCacheInWorker", "reuseToPush parseBuf ret:%s", Integer.valueOf(S));
                                    aVar.fka = null;
                                } else {
                                    aVar.fkb = 0;
                                }
                                com.tencent.mm.plugin.report.e.pXa.a(226, (long) (S + 20), 1, false);
                            }
                        }
                    }
                }
                r2 = new Object[2];
                g.RQ();
                r2[0] = g.RN().eIQ;
                g.RQ();
                r2[1] = g.RO().eJo.ftA;
                ab.i("MicroMsg.AccInfoCacheInWorker", "tryReuseToPush but object is null [%s, %s]", r2);
            } catch (Throwable th) {
                ab.e("MicroMsg.AccInfoCacheInWorker", "tryReuseToPush Exception:%s", bo.l(th));
            }
        }
        if (g.RK()) {
            g.RQ();
            if (g.RO().eJo != null) {
                g.RQ();
                if (g.RO().eJo.ftA != null) {
                    g.RQ();
                    g.RO().eJo.ftA.cG(true);
                }
            }
        }
        if (g.RK()) {
            com.tencent.mm.sdk.b.a.xxA.m(new gi());
        }
        a.jD("onServiceConnected done");
        AppMethodBeat.o(57673);
    }

    static /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(57674);
        g.RN();
        if (!com.tencent.mm.kernel.a.QX() || com.tencent.mm.kernel.a.QT()) {
            g.RQ();
            g.RO().eJo.acW();
            g.RQ();
            g.RO().eJo.reset();
            AppMethodBeat.o(57674);
            return;
        }
        g.RQ();
        g.RO().eJo.acV();
        eVar.aU(ah.getContext());
        AppMethodBeat.o(57674);
    }
}
