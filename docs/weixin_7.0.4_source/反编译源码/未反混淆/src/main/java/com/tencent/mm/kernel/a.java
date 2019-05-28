package com.tencent.mm.kernel;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.a.i;
import com.tencent.mm.a.p;
import com.tencent.mm.ai.y;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.g.a.cc;
import com.tencent.mm.g.a.cd;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.model.as;
import com.tencent.mm.model.av;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.z;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.mm.vfs.FileSystemManager.MaintenanceBroadcastReceiver;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import junit.framework.Assert;

public final class a {
    private static boolean eIJ = true;
    private static boolean eIK = false;
    static b eIM = new b();
    private static String eIN = "NoResetUinStack";
    private static String eIO = null;
    private static boolean eIP;
    private static int eIY = -1;
    private c eIH;
    private y eII;
    byte[] eIL = new byte[0];
    public com.tencent.mm.model.a eIQ;
    public e.c eIR;
    public int eIS;
    public boolean eIT = false;
    private boolean eIU = false;
    public int eIV = 0;
    public int eIW;
    public List<as> eIX = new LinkedList();
    long eIZ;
    private volatile a eJa = a.NotReady;
    public volatile boolean eJb = false;
    private String eJc = "";
    private Map<String, Integer> eJd = new HashMap();

    enum a {
        NotReady,
        AccountHasReady;

        static {
            AppMethodBeat.o(57886);
        }
    }

    static final class b {
        private static boolean eJl = true;
        private boolean eJj = false;
        private com.tencent.mm.storage.y eJk;
        private int uin = 0;

        b() {
        }

        private synchronized int QF() {
            int i;
            AppMethodBeat.i(57887);
            if (!this.eJj) {
                Rd();
                this.eJj = true;
            }
            i = this.uin;
            AppMethodBeat.o(57887);
            return i;
        }

        public final synchronized void a(com.tencent.mm.storage.y yVar) {
            this.eJk = yVar;
        }

        private synchronized void hB(int i) {
            AppMethodBeat.i(57888);
            ab.i("MMKernel.CoreAccount", "Uin From %s To %s hash:%d thread:%d[%s] stack:%s", p.getString(this.uin), p.getString(i), Integer.valueOf(i.bL(i, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), bo.dpG());
            Assert.assertNotNull(this.eJk);
            a(this.eJk, i);
            this.uin = i;
            AppMethodBeat.o(57888);
        }

        private synchronized void Rd() {
            int i = 0;
            synchronized (this) {
                AppMethodBeat.i(57889);
                Assert.assertNotNull(this.eJk);
                com.tencent.mm.storage.y yVar = this.eJk;
                if (yVar == null) {
                    ab.w("MMKernel.CoreAccount", "summer read detault uin exception sysCfg is null!");
                } else {
                    Integer num = (Integer) yVar.get(1);
                    if (num == null) {
                        if (yVar.xIr) {
                            e.pXa.a(148, 40, 1, false);
                        }
                        Integer valueOf = Integer.valueOf(ah.getContext().getSharedPreferences("system_config_prefs", h.Mu()).getInt("default_uin", 0));
                        if (valueOf != null) {
                            ab.i("MMKernel.CoreAccount", "summer read detault uin[%d], bakUin[%d] sysCfg.isOpenException[%b]", num, valueOf, Boolean.valueOf(yVar.xIr));
                            if (eJl) {
                                ab.w("MMKernel.CoreAccount", "summer read detault uin exception backup uin[%d], stack[%s]", valueOf, bo.dpG());
                                e.pXa.e(11911, Integer.valueOf(bo.h(valueOf)));
                                eJl = false;
                            }
                            a(yVar, valueOf.intValue());
                            num = valueOf;
                        }
                    }
                    ab.i("MMKernel.CoreAccount", "summer getDefaultUin uin[%d]", Integer.valueOf(bo.h(num)));
                    i = bo.h(num);
                }
                this.uin = i;
                AppMethodBeat.o(57889);
            }
        }

        private static void a(com.tencent.mm.storage.y yVar, int i) {
            AppMethodBeat.i(57890);
            ab.i("MMKernel.CoreAccount", "setSysUin uin: %d, stack: %s", Integer.valueOf(i), bo.dpG());
            ah.getContext().getSharedPreferences("system_config_prefs", h.Mu()).edit().putInt("default_uin", i).commit();
            yVar.set(1, Integer.valueOf(i));
            AppMethodBeat.o(57890);
        }
    }

    static {
        AppMethodBeat.i(57921);
        AppMethodBeat.o(57921);
    }

    public a(c cVar) {
        int i;
        AppMethodBeat.i(57893);
        Assert.assertNotNull(eIM);
        g.RQ();
        eIJ = bo.h((Integer) g.RP().eJH.get(17)) != 0;
        if (f.vxx) {
            i = 763;
        } else {
            i = 702;
        }
        com.tencent.mm.protocal.j.c.a.vxR = new ax(i);
        this.eIH = cVar;
        AppMethodBeat.o(57893);
    }

    public static int QF() {
        AppMethodBeat.i(57894);
        int a = b.a(eIM);
        AppMethodBeat.o(57894);
        return a;
    }

    public static String QG() {
        AppMethodBeat.i(57895);
        String pVar = new p(b.a(eIM)).toString();
        AppMethodBeat.o(57895);
        return pVar;
    }

    public static String QH() {
        return eIO;
    }

    public static String lD(String str) {
        eIO = str;
        return str;
    }

    public static boolean QI() {
        return eIP;
    }

    public static void QJ() {
        eIP = true;
    }

    public static String QK() {
        return eIN;
    }

    public static void lE(String str) {
        eIN = str;
    }

    static boolean jN(int i) {
        return i != 0;
    }

    protected static void QL() {
        AppMethodBeat.i(57896);
        b.a(eIM, 0);
        AppMethodBeat.o(57896);
    }

    protected static void QM() {
        AppMethodBeat.i(57897);
        b.a(eIM, 0);
        AppMethodBeat.o(57897);
    }

    /* Access modifiers changed, original: final */
    public final void QO() {
        AppMethodBeat.i(57899);
        ab.w("MMKernel.CoreAccount", "account storage release  uin:%s thread:%s stack:%s", p.getString(b.a(eIM)), Thread.currentThread().getName(), bo.dpG());
        if (QY()) {
            this.eIH.onAccountRelease();
            g.RQ();
            g.RP().jC(null);
            QN();
            g.RQ();
            g.RP().eJV.clear();
            AppMethodBeat.o(57899);
            return;
        }
        ab.i("MMKernel.CoreAccount", "Fatal crash error!!! status is not initialized when release(), this callStack is:%s, last reset stack is:%s", bo.dpG().toString(), eIN);
        AppMethodBeat.o(57899);
    }

    /* Access modifiers changed, original: final */
    public final void cl(boolean z) {
        boolean z2;
        int doL;
        Object obj;
        AppMethodBeat.i(57900);
        if (!z) {
            z2 = WXHardCoderJNI.hcBootEnable;
            int i = WXHardCoderJNI.hcBootDelay;
            int i2 = WXHardCoderJNI.hcBootCPU;
            int i3 = WXHardCoderJNI.hcBootIO;
            if (WXHardCoderJNI.hcBootThr) {
                doL = g.RS().doL();
            } else {
                doL = 0;
            }
            this.eIS = WXHardCoderJNI.startPerformance(z2, i, i2, i3, doL, WXHardCoderJNI.hcBootTimeout, 101, WXHardCoderJNI.hcBootAction, "MMKernel.CoreAccount");
            ab.i("MMKernel.CoreAccount", "summerhardcoder startPerformance[%s] stack[%s]", Integer.valueOf(this.eIS), bo.dpG());
        }
        ab.i("MMKernel.CoreAccount", "UserStatusChange: clear");
        synchronized (this.eIX) {
            try {
                this.eIX.clear();
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(57900);
                }
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        final int a = b.a(eIM);
        ab.i("MMKernel.CoreAccount", "dkacc setAccuin %s hash:%d thread:%d[%s] stack:%s", p.getString(a), Integer.valueOf(i.bL(a, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), bo.dpG());
        if (a != 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            ab.w("MMKernel.CoreAccount", "setAccUin, Reset by MMCore.resetAccUin");
        } else {
            boolean z3;
            long currentTimeMillis2;
            p.getString(a);
            com.tencent.mm.sdk.a.b.dnL();
            g.RQ();
            e RP = g.RP();
            AnonymousClass1 anonymousClass1 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(57880);
                    a.this.eJa = a.AccountHasReady;
                    String x = g.x(("mm" + a).getBytes());
                    FileSystemManager dMy = FileSystemManager.dMy();
                    dMy.ens().ir("account", x).ri(false);
                    dMy.ent();
                    Context context = FileSystemManager.sContext;
                    long j = dMy.Cam;
                    if (420000 >= 0 && j < 0) {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.SCREEN_ON");
                        intentFilter.addAction("android.intent.action.SCREEN_OFF");
                        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
                        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
                        context.registerReceiver(dMy.Cak, intentFilter);
                        MaintenanceBroadcastReceiver maintenanceBroadcastReceiver = dMy.Cak;
                        maintenanceBroadcastReceiver.jZT = ((PowerManager) context.getSystemService("power")).isScreenOn();
                        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                        if (registerReceiver != null) {
                            boolean z;
                            int intExtra = registerReceiver.getIntExtra("status", -1);
                            if (intExtra == 2 || intExtra == 5) {
                                z = true;
                            } else {
                                z = false;
                            }
                            maintenanceBroadcastReceiver.jZS = z;
                        }
                    } else if (420000 < 0 && j >= 0) {
                        context.unregisterReceiver(dMy.Cak);
                    }
                    dMy.Cam = 420000;
                    dMy.Can = 259200000;
                    dMy.Cao = true;
                    ab.i("VFS.Debug", "SetEnv ${account} = " + x + " and broadcast.");
                    AppMethodBeat.o(57880);
                }
            };
            ah.getContext().getSharedPreferences(ah.doA(), 0).edit().putBoolean("isLogin", true).apply();
            String x = g.x("mm".concat(String.valueOf(a)).getBytes());
            RP.eJM = RP.eJL + x + "/";
            RP.cachePath = ac.eSj + x + "/";
            File file = new File(RP.cachePath);
            ab.i("MMKernel.CoreStorage", "dkacc cachePath:" + RP.cachePath + " accPath:" + RP.eJM);
            if (file.exists()) {
                z3 = false;
            } else {
                ab.w("MMKernel.CoreStorage", "setUin REBUILD data now ! DO NOT FUCKING TELL ME DB BROKEN !!! uin:%s data:%s sd:%s", p.getString(a), RP.cachePath, RP.eJM);
                file.mkdirs();
                if (!RP.cachePath.equalsIgnoreCase(RP.eJM)) {
                    currentTimeMillis2 = System.currentTimeMillis();
                    new File(RP.eJM).renameTo(new File(com.tencent.mm.compatible.util.e.eSn + (x + "temp" + System.currentTimeMillis())));
                    ab.i("MMKernel.CoreStorage", "find the old files and rename then %s" + (System.currentTimeMillis() - currentTimeMillis2), x);
                }
                z3 = true;
            }
            RP.eJU = new cf(RP.cachePath, z3);
            RP.Rq();
            x = RP.cachePath + "MicroMsg.db";
            String str = RP.cachePath + "EnMicroMsg.db";
            String str2 = RP.cachePath + "EnMicroMsg2.db";
            RP.jC(null);
            RP.lJ(str);
            RP.eJN = new com.tencent.mm.cd.h(new com.tencent.mm.cd.h.a() {
                public final void RF() {
                    AppMethodBeat.i(57940);
                    if (e.this.eJP != null) {
                        ab.i("MMKernel.CoreStorage", "summer preCloseCallback userConfigStg: " + e.this.eJP);
                        e.this.eJP.dsb();
                        e.this.eJP.mHandlerThread.quitSafely();
                    }
                    e.this.eJJ.RF();
                    AppMethodBeat.o(57940);
                }

                public final void RG() {
                    AppMethodBeat.i(57941);
                    e.this.eJJ.RG();
                    AppMethodBeat.o(57941);
                }

                public final void RH() {
                    AppMethodBeat.i(57942);
                    e.this.eJJ.RH();
                    AppMethodBeat.o(57942);
                }
            });
            com.tencent.mm.cd.h hVar = RP.eJN;
            long j = (long) a;
            q.LK();
            if (hVar.b(x, str, str2, j, e.Jx(), true)) {
                boolean z4;
                String str3 = RP.eJN.ybS;
                if (!bo.isNullOrNil(str3)) {
                    ab.e("MMKernel.CoreStorage", "dbinit failed :".concat(String.valueOf(str3)));
                    com.tencent.mm.sdk.a.b.A("init db Failed: [ " + str3 + "]", "DBinit");
                }
                hVar = RP.eJN;
                if (hVar.ybP != null) {
                    z4 = hVar.ybP.ybo;
                } else {
                    z4 = false;
                }
                if (z4) {
                    RP.eJT = true;
                }
                RP.eJP = new z(RP.eJN);
                RP.eJR = new by(RP.eJN);
                RP.eJN.ybR = new com.tencent.mm.cd.h.e() {
                    public final void RI() {
                        AppMethodBeat.i(57943);
                        if (e.this.eJR != null) {
                            e.this.eJR.fni.hY("TablesVersion", "delete from TablesVersion");
                            AppMethodBeat.o(57943);
                            return;
                        }
                        ab.e("MMKernel.CoreStorage", "tablesVersionStorage is null");
                        AppMethodBeat.o(57943);
                    }
                };
                RP.eJS = RP.eJR.duv();
                RP.eJO = new com.tencent.mm.cd.h(RP.eJK);
                hVar = RP.eJO;
                j = (long) a;
                q.LK();
                if (hVar.b(x, str, str2, j, new HashMap(), true)) {
                    int intValue;
                    boolean z5;
                    RP.eJQ = new bs(RP.eJP);
                    RP.eJQ.c(new com.tencent.mm.sdk.e.k.a() {
                        public final void a(String str, m mVar) {
                            AppMethodBeat.i(57944);
                            q.ku(str);
                            AppMethodBeat.o(57944);
                        }
                    });
                    RP.eJQ.duo();
                    anonymousClass1.run();
                    if (z3) {
                        currentTimeMillis2 = ((Long) RP.eJP.get(com.tencent.mm.storage.ac.a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(0))).longValue();
                        intValue = ((Integer) RP.eJP.get(com.tencent.mm.storage.ac.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(0))).intValue();
                        if (currentTimeMillis2 > 0) {
                            ab.w("MMKernel.CoreStorage", "summerinstall new install but firsttime[%d] > 0", Long.valueOf(currentTimeMillis2));
                        } else {
                            RP.eJP.set(com.tencent.mm.storage.ac.a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
                        }
                        if (intValue > 0) {
                            ab.w("MMKernel.CoreStorage", "summerinstall new install but version[%d] > 0", Integer.valueOf(intValue));
                        } else {
                            RP.eJP.set(com.tencent.mm.storage.ac.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(d.vxo));
                        }
                        ab.i("MMKernel.CoreStorage", "edw setAccUin, summerinstall time[%d]，version[%d], clientversion[%d]", (Long) RP.eJP.get(com.tencent.mm.storage.ac.a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(0)), (Integer) RP.eJP.get(com.tencent.mm.storage.ac.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(0)), Integer.valueOf(d.vxo));
                    }
                    if (!z) {
                        g.RQ();
                        ab.i("MMKernel.CoreAccount", "summerinit validateUsername username[%s]", bo.nullAsNil((String) g.RP().Ry().get(2, null)));
                        if (bo.nullAsNil((String) g.RP().Ry().get(2, null)).length() <= 0) {
                            ab.e("MMKernel.CoreAccount", "username of acc stg not set: uin=" + b.a(eIM));
                            QN();
                            b.a(eIM, 0);
                            eIN = bo.dpG().toString();
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(57883);
                                    g.RQ().releaseAll();
                                    AppMethodBeat.o(57883);
                                }
                            });
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        if (obj == null) {
                            e.pXa.a(598, 21, 1, true);
                            ab.w("MMKernel.CoreAccount", "setAccUin, validateUsername false no need initialize!");
                        }
                    }
                    com.tencent.mm.sdk.b.a.xxA.m(new cd());
                    g.RQ();
                    e RP2 = g.RP();
                    e.c cVar = new e.c();
                    doL = bo.h((Integer) RP2.eJP.get(14, null));
                    int i4 = d.vxo;
                    ab.d("MMKernel.CoreStorage", "sVer: %s, cVer: %s.", Integer.toHexString(doL), Integer.toHexString(i4));
                    if (i4 == doL) {
                        z5 = false;
                    } else if (i4 > 570425344 && doL <= 570425344) {
                        z5 = true;
                    } else if (i4 <= 570556456 || doL > 570556456) {
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    if (z5) {
                        RP2.eJP.set(8197, (Object) "");
                        RP2.eJP.set(15, Integer.valueOf(0));
                    }
                    if (doL != i4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (doL > 620822536 || doL == i4) {
                        RP2.eJP.set(274480, Boolean.FALSE);
                        ab.i("MMKernel.CoreStorage", "[initialize] need not init emoji");
                    } else {
                        RP2.eJP.set(274480, Boolean.TRUE);
                        ab.i("MMKernel.CoreStorage", "[initialize] need init emoji");
                    }
                    if (doL != 0 && doL < 637599744) {
                        RP2.eJP.set(348162, Boolean.TRUE);
                    }
                    if ((doL != i4 ? 1 : null) != null) {
                        ab.w("MMKernel.CoreStorage", "account storage version changed from " + Integer.toHexString(doL) + " to " + Integer.toHexString(i4) + ", init=" + z5);
                        if (((Integer) RP2.eJH.get(37, Integer.valueOf(0))).intValue() == 0) {
                            RP2.eJH.set(37, Integer.valueOf(doL));
                        }
                        RP2.eJP.set(30, Boolean.FALSE);
                        RP2.eJP.set(-2046825377, Boolean.FALSE);
                        RP2.eJP.set(-2046825369, Boolean.FALSE);
                        RP2.eJP.set(54, Boolean.FALSE);
                        RP2.eJP.set(-2046825368, Boolean.FALSE);
                        RP2.eJP.set(-2046825366, Boolean.TRUE);
                        RP2.eJP.set(62, Boolean.TRUE);
                        ah.getContext().getSharedPreferences("update_config_prefs", h.Mu()).edit().clear().commit();
                        if ((doL & -256) == (i4 & -256) || doL == 0) {
                            ab.d("MMKernel.CoreStorage", "lock show_whatsnew from if.");
                            aj.amA("show_whatsnew");
                        }
                    } else {
                        ab.d("MMKernel.CoreStorage", "lock show_whatsnew from else.");
                        aj.amA("show_whatsnew");
                    }
                    z4 = RP2.eJP.getBoolean(com.tencent.mm.storage.ac.a.USERINFO_STORY_WHATS_NEW_BOOLEAN_SYNC, false);
                    RP2.eJP.set(com.tencent.mm.storage.ac.a.USERINFO_STORY_WHATS_NEW_BOOLEAN_SYNC, Boolean.FALSE);
                    ab.i("MMKernel.CoreStorage", "unlock show_whatsnew from testWhatsNew, %s.", Boolean.valueOf(z4));
                    if (z4) {
                        aj.amB("show_whatsnew");
                    }
                    cVar.eKe = z2;
                    cVar.eKf = doL;
                    this.eIR = cVar;
                    ab.i("MMKernel.CoreAccount", "check is update :%b ", Boolean.valueOf(cVar.eKe));
                    this.eIU = true;
                    if (!this.eIT) {
                        QP();
                        g.RN().QZ();
                    }
                    av.fly.ak("last_login_uin", p.getString(a));
                    e.pXa.hB(a);
                    x = "MMKernel.CoreAccount";
                    str = "SmcLogic.setUin, class loader %s, %s";
                    Object[] objArr = new Object[2];
                    if (getClass().getClassLoader() == null) {
                        intValue = -1;
                    } else {
                        intValue = getClass().getClassLoader().hashCode();
                    }
                    objArr[0] = Integer.valueOf(intValue);
                    if (Thread.currentThread().getContextClassLoader() == null) {
                        intValue = -1;
                    } else {
                        intValue = Thread.currentThread().getContextClassLoader().hashCode();
                    }
                    objArr[1] = Integer.valueOf(intValue);
                    ab.i(x, str, objArr);
                    this.eIQ = new com.tencent.mm.model.a();
                    ab.i("MMKernel.CoreAccount", "setAccUin done :%s", p.getString(a));
                    com.tencent.mm.sdk.b.a.xxA.m(new gi());
                    g.RQ();
                    if (g.RO().eJo != null) {
                        g.RQ();
                        if (g.RO().eJo.ftA != null) {
                            g.RQ();
                            g.RO().eJo.ftA.cG(true);
                            g.RQ();
                            com.tencent.mm.network.c adg = g.RO().eJo.ftA.adg();
                            if (!(a == 0 || adg == null || a == adg.QF())) {
                                ab.w("MMKernel.CoreAccount", "summerauth update acc info with acc stg: old acc uin=%d, this uin=%d", Integer.valueOf(adg.QF()), Integer.valueOf(a));
                                e.pXa.a(148, 46, 1, false);
                                adg.hB(a);
                            }
                        }
                    }
                } else {
                    com.tencent.mm.model.b bVar = new com.tencent.mm.model.b((byte) 0);
                    AppMethodBeat.o(57900);
                    throw bVar;
                }
            }
            SQLiteException sQLiteException = new SQLiteException("main db init failed");
            AppMethodBeat.o(57900);
            throw sQLiteException;
        }
        ab.i("MMKernel.CoreAccount", "start time check setUinImpl end total time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        ab.i("MMKernel.CoreAccount", "mAccountStatus to AccountHasReady");
        AppMethodBeat.o(57900);
    }

    public final void QP() {
        AppMethodBeat.i(57901);
        if (this.eIU) {
            this.eIU = false;
            ab.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized tid:%d, stack[%s]", Long.valueOf(Thread.currentThread().getId()), bo.dpG());
            long currentTimeMillis = System.currentTimeMillis();
            this.eIH.onAccountInitialized(this.eIR);
            ab.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized run tid[%d] take[%d]ms", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            QQ();
            AppMethodBeat.o(57901);
            return;
        }
        ab.i("MMKernel.CoreAccount", "no need do account initialized notify.");
        AppMethodBeat.o(57901);
    }

    public final void QQ() {
        AppMethodBeat.i(57902);
        if (QY() && com.tencent.mm.kernel.a.c.Sa().eLa) {
            ab.i("MMKernel.CoreAccount", "Flush client version.");
            g.RP().Rp();
        }
        AppMethodBeat.o(57902);
    }

    public final synchronized y QR() {
        y yVar;
        AppMethodBeat.i(57903);
        if (this.eII == null) {
            this.eII = new y();
        }
        yVar = this.eII;
        AppMethodBeat.o(57903);
        return yVar;
    }

    public static boolean QS() {
        return eIK;
    }

    public static void cm(boolean z) {
        eIK = z;
    }

    public static boolean QT() {
        AppMethodBeat.i(57904);
        if (eIJ) {
            String string;
            String str = "MMKernel.CoreAccount";
            String str2 = "account holded :%s init:%b";
            Object[] objArr = new Object[2];
            g.RQ();
            if (g.RN() != null) {
                g.RQ();
                g.RN();
                string = p.getString(b.a(eIM));
            } else {
                string = "-1";
            }
            objArr[0] = string;
            objArr[1] = Boolean.valueOf(g.RN().QY());
            ab.w(str, str2, objArr);
        }
        boolean z = eIJ;
        AppMethodBeat.o(57904);
        return z;
    }

    public static void hold() {
        String string;
        AppMethodBeat.i(57905);
        String str = "MMKernel.CoreAccount";
        String str2 = " HOLD ACCOUNT! uin:%s stack:%s init:%b";
        Object[] objArr = new Object[3];
        g.RQ();
        if (g.RN() != null) {
            g.RQ();
            g.RN();
            string = p.getString(b.a(eIM));
        } else {
            string = "-1";
        }
        objArr[0] = string;
        objArr[1] = bo.dpG();
        objArr[2] = Boolean.valueOf(g.RN().QY());
        ab.w(str, str2, objArr);
        eIJ = true;
        g.RQ();
        g.RP().eJH.set(17, Integer.valueOf(1));
        AppMethodBeat.o(57905);
    }

    public static void unhold() {
        String string;
        AppMethodBeat.i(57906);
        String str = "MMKernel.CoreAccount";
        String str2 = " UN HOLD ACCOUNT! uin:%s init:%b";
        Object[] objArr = new Object[2];
        g.RQ();
        if (g.RN() != null) {
            g.RQ();
            g.RN();
            string = p.getString(b.a(eIM));
        } else {
            string = "-1";
        }
        objArr[0] = string;
        objArr[1] = Boolean.valueOf(g.RN().QY());
        ab.w(str, str2, objArr);
        eIJ = false;
        g.RQ();
        g.RP().eJH.set(17, Integer.valueOf(0));
        AppMethodBeat.o(57906);
    }

    public final void QU() {
        AppMethodBeat.i(57907);
        if (QY()) {
            AppMethodBeat.o(57907);
            return;
        }
        com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
        AppMethodBeat.o(57907);
        throw bVar;
    }

    public final void QV() {
        AppMethodBeat.i(57908);
        new ak(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(57881);
                as[] asVarArr = new as[a.this.eIX.size()];
                a.this.eIX.toArray(asVarArr);
                for (as ZB : asVarArr) {
                    ZB.ZB();
                }
                AppMethodBeat.o(57881);
            }
        });
        AppMethodBeat.o(57908);
    }

    public final void cd(int i, int i2) {
        AppMethodBeat.i(57909);
        int i3 = (this.eIV == i && this.eIW == i2) ? 0 : 1;
        ab.d("MMKernel.CoreAccount", "online status, %d, %d, %d ,%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.eIW), Integer.valueOf(this.eIV));
        if (i3 == 0) {
            AppMethodBeat.o(57909);
            return;
        }
        this.eIV = i;
        this.eIW = i2;
        new ak(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(57882);
                a.this.QV();
                AppMethodBeat.o(57882);
            }
        });
        AppMethodBeat.o(57909);
    }

    public static void jO(int i) {
        AppMethodBeat.i(57910);
        if (eIY == -1 || eIY != i) {
            eIY = i;
            Mz().edit().putInt("notification.user.state", i).commit();
            ab.i("MMKernel.CoreAccount", "[NOTIFICATION SETTINGS]save UserStatus: %d", Integer.valueOf(i));
            AppMethodBeat.o(57910);
            return;
        }
        AppMethodBeat.o(57910);
    }

    public static int QW() {
        AppMethodBeat.i(57911);
        int i = Mz().getInt("notification.user.state", 0);
        AppMethodBeat.o(57911);
        return i;
    }

    public static SharedPreferences Mz() {
        AppMethodBeat.i(57912);
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("notify_key_pref_settings", h.Mu());
        AppMethodBeat.o(57912);
        return sharedPreferences;
    }

    public static boolean jP(int i) {
        return (i & 1) != 0;
    }

    /* JADX WARNING: Missing block: B:14:0x004b, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(57914);
     */
    /* JADX WARNING: Missing block: B:24:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initialize() {
        AppMethodBeat.i(57914);
        if (QY()) {
            AppMethodBeat.o(57914);
            return;
        }
        synchronized (this.eIL) {
            try {
                if (QY()) {
                } else {
                    if (b.a(eIM) != 0) {
                        this.eIZ = SystemClock.elapsedRealtime();
                        ab.w("MMKernel.CoreAccount", "auto set up account storage uin: %d, stack: %s", Integer.valueOf(r0), bo.dpG());
                        cl(false);
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(57914);
            }
        }
    }

    public static boolean QX() {
        AppMethodBeat.i(57915);
        if (b.a(eIM) != 0) {
            AppMethodBeat.o(57915);
            return true;
        }
        AppMethodBeat.o(57915);
        return false;
    }

    public final boolean QY() {
        return this.eJa == a.AccountHasReady;
    }

    public final void QZ() {
        AppMethodBeat.i(57916);
        ab.i("MMKernel.CoreAccount", "summerasyncinit setInitializedNotifyAllDone[%b] to true stack[%s]", Boolean.valueOf(this.eJb), bo.dpG());
        this.eJb = true;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ab.i("MMKernel.CoreAccount", "summerhardcoder setInitializedNotifyAllDone [%d %d] take[%d]ms, stack[%s]", Long.valueOf(this.eIZ), Long.valueOf(elapsedRealtime), Long.valueOf(elapsedRealtime - this.eIZ), bo.dpG());
        com.tencent.mm.sdk.b.a.xxA.m(new cc());
        AppMethodBeat.o(57916);
    }

    public static int Ra() {
        AppMethodBeat.i(57917);
        int i = ah.getContext().getSharedPreferences("system_config_prefs", h.Mu()).getInt("default_uin", 0);
        AppMethodBeat.o(57917);
        return i;
    }

    public static String Rb() {
        AppMethodBeat.i(57918);
        g.RQ();
        if (bo.isNullOrNil(g.RN().eJc)) {
            Rc();
        }
        g.RQ();
        String str = g.RN().eJc;
        AppMethodBeat.o(57918);
        return str;
    }

    public static void Rc() {
        AppMethodBeat.i(57919);
        g.RQ();
        g.RN().eJc = q.LM() + "_" + System.currentTimeMillis();
        g.RQ();
        g.RN().eJd.clear();
        AppMethodBeat.o(57919);
    }

    public static int lF(String str) {
        int i;
        AppMethodBeat.i(57920);
        g.RQ();
        if (g.RN().eJd.get(str) == null) {
            i = 0;
        } else {
            g.RQ();
            i = ((Integer) g.RN().eJd.get(str)).intValue();
        }
        int anT = (int) bo.anT();
        if (i == 0) {
            g.RQ();
            g.RN().eJd.put(str, Integer.valueOf(anT));
            AppMethodBeat.o(57920);
            return i;
        }
        i = anT - i;
        g.RQ();
        g.RN().eJd.put(str, Integer.valueOf(anT));
        if (i >= 0) {
            AppMethodBeat.o(57920);
            return i;
        }
        AppMethodBeat.o(57920);
        return 0;
    }

    private void QN() {
        AppMethodBeat.i(57898);
        this.eJa = a.NotReady;
        this.eJb = false;
        ab.i("MMKernel.CoreAccount", "mAccountStatus to NotReady");
        ah.getContext().getSharedPreferences(ah.doA(), 0).edit().putBoolean("isLogin", false).commit();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
        ab.w("MMKernel.CoreAccount", "[arthurdan.AccountNR] account storage reset! uin:%d, resetStack is:%s, resetTime:%s", Integer.valueOf(b.a(eIM)), eIN, simpleDateFormat.format(new Date()));
        AppMethodBeat.o(57898);
    }

    public final void release() {
        AppMethodBeat.i(57913);
        synchronized (this.eIL) {
            try {
                QO();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(57913);
            }
        }
    }
}
