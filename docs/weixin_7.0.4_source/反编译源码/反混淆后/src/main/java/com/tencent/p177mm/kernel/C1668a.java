package com.tencent.p177mm.kernel;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1706e.C17072;
import com.tencent.p177mm.kernel.C1706e.C17083;
import com.tencent.p177mm.kernel.C1706e.C17094;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.p238a.C6610c;
import com.tencent.p177mm.model.C1810a;
import com.tencent.p177mm.model.C1815as;
import com.tencent.p177mm.model.C1819b;
import com.tencent.p177mm.model.C1842cf;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.model.C7484ax;
import com.tencent.p177mm.network.C1898c;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p178a.C1179i;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p183ai.C1231y;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p230g.p231a.C6464cc;
import com.tencent.p177mm.p230g.p231a.C6465cd;
import com.tencent.p177mm.p230g.p231a.C6483gi;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.protocal.C4815f;
import com.tencent.p177mm.protocal.C4824j.C4823c.C4822a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C4997aj;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C5144y;
import com.tencent.p177mm.storage.C7574bs;
import com.tencent.p177mm.storage.C7580z;
import com.tencent.p177mm.storage.C7622by;
import com.tencent.p177mm.vfs.FileSystemManager;
import com.tencent.p177mm.vfs.FileSystemManager.MaintenanceBroadcastReceiver;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.kernel.a */
public final class C1668a {
    private static boolean eIJ = true;
    private static boolean eIK = false;
    static C1647b eIM = new C1647b();
    private static String eIN = "NoResetUinStack";
    private static String eIO = null;
    private static boolean eIP;
    private static int eIY = -1;
    private C1671c eIH;
    private C1231y eII;
    byte[] eIL = new byte[0];
    public C1810a eIQ;
    public C1705c eIR;
    public int eIS;
    public boolean eIT = false;
    private boolean eIU = false;
    public int eIV = 0;
    public int eIW;
    public List<C1815as> eIX = new LinkedList();
    long eIZ;
    private volatile C1646a eJa = C1646a.NotReady;
    public volatile boolean eJb = false;
    private String eJc = "";
    private Map<String, Integer> eJd = new HashMap();

    /* renamed from: com.tencent.mm.kernel.a$2 */
    class C16432 implements Runnable {
        C16432() {
        }

        public final void run() {
            AppMethodBeat.m2504i(57881);
            C1815as[] c1815asArr = new C1815as[C1668a.this.eIX.size()];
            C1668a.this.eIX.toArray(c1815asArr);
            for (C1815as ZB : c1815asArr) {
                ZB.mo5390ZB();
            }
            AppMethodBeat.m2505o(57881);
        }
    }

    /* renamed from: com.tencent.mm.kernel.a$3 */
    class C16443 implements Runnable {
        C16443() {
        }

        public final void run() {
            AppMethodBeat.m2504i(57882);
            C1668a.this.mo5160QV();
            AppMethodBeat.m2505o(57882);
        }
    }

    /* renamed from: com.tencent.mm.kernel.a$4 */
    class C16454 implements Runnable {
        C16454() {
        }

        public final void run() {
            AppMethodBeat.m2504i(57883);
            C1720g.m3537RQ().releaseAll();
            AppMethodBeat.m2505o(57883);
        }
    }

    /* renamed from: com.tencent.mm.kernel.a$a */
    enum C1646a {
        NotReady,
        AccountHasReady;

        static {
            AppMethodBeat.m2505o(57886);
        }
    }

    /* renamed from: com.tencent.mm.kernel.a$b */
    static final class C1647b {
        private static boolean eJl = true;
        private boolean eJj = false;
        private C5144y eJk;
        private int uin = 0;

        C1647b() {
        }

        /* renamed from: QF */
        private synchronized int m3316QF() {
            int i;
            AppMethodBeat.m2504i(57887);
            if (!this.eJj) {
                m3317Rd();
                this.eJj = true;
            }
            i = this.uin;
            AppMethodBeat.m2505o(57887);
            return i;
        }

        /* renamed from: a */
        public final synchronized void mo5106a(C5144y c5144y) {
            this.eJk = c5144y;
        }

        /* renamed from: hB */
        private synchronized void m3321hB(int i) {
            AppMethodBeat.m2504i(57888);
            C4990ab.m7417i("MMKernel.CoreAccount", "Uin From %s To %s hash:%d thread:%d[%s] stack:%s", C1183p.getString(this.uin), C1183p.getString(i), Integer.valueOf(C1179i.m2593bL(i, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), C5046bo.dpG());
            Assert.assertNotNull(this.eJk);
            C1647b.m3320a(this.eJk, i);
            this.uin = i;
            AppMethodBeat.m2505o(57888);
        }

        /* renamed from: Rd */
        private synchronized void m3317Rd() {
            int i = 0;
            synchronized (this) {
                AppMethodBeat.m2504i(57889);
                Assert.assertNotNull(this.eJk);
                C5144y c5144y = this.eJk;
                if (c5144y == null) {
                    C4990ab.m7420w("MMKernel.CoreAccount", "summer read detault uin exception sysCfg is null!");
                } else {
                    Integer num = (Integer) c5144y.get(1);
                    if (num == null) {
                        if (c5144y.xIr) {
                            C7053e.pXa.mo8378a(148, 40, 1, false);
                        }
                        Integer valueOf = Integer.valueOf(C4996ah.getContext().getSharedPreferences("system_config_prefs", C1448h.m3078Mu()).getInt("default_uin", 0));
                        if (valueOf != null) {
                            C4990ab.m7417i("MMKernel.CoreAccount", "summer read detault uin[%d], bakUin[%d] sysCfg.isOpenException[%b]", num, valueOf, Boolean.valueOf(c5144y.xIr));
                            if (eJl) {
                                C4990ab.m7421w("MMKernel.CoreAccount", "summer read detault uin exception backup uin[%d], stack[%s]", valueOf, C5046bo.dpG());
                                C7053e.pXa.mo8381e(11911, Integer.valueOf(C5046bo.m7567h(valueOf)));
                                eJl = false;
                            }
                            C1647b.m3320a(c5144y, valueOf.intValue());
                            num = valueOf;
                        }
                    }
                    C4990ab.m7417i("MMKernel.CoreAccount", "summer getDefaultUin uin[%d]", Integer.valueOf(C5046bo.m7567h(num)));
                    i = C5046bo.m7567h(num);
                }
                this.uin = i;
                AppMethodBeat.m2505o(57889);
            }
        }

        /* renamed from: a */
        private static void m3320a(C5144y c5144y, int i) {
            AppMethodBeat.m2504i(57890);
            C4990ab.m7417i("MMKernel.CoreAccount", "setSysUin uin: %d, stack: %s", Integer.valueOf(i), C5046bo.dpG());
            C4996ah.getContext().getSharedPreferences("system_config_prefs", C1448h.m3078Mu()).edit().putInt("default_uin", i).commit();
            c5144y.set(1, Integer.valueOf(i));
            AppMethodBeat.m2505o(57890);
        }
    }

    static {
        AppMethodBeat.m2504i(57921);
        AppMethodBeat.m2505o(57921);
    }

    public C1668a(C1671c c1671c) {
        int i;
        AppMethodBeat.m2504i(57893);
        Assert.assertNotNull(eIM);
        C1720g.m3537RQ();
        eIJ = C5046bo.m7567h((Integer) C1720g.m3536RP().eJH.get(17)) != 0;
        if (C4815f.vxx) {
            i = 763;
        } else {
            i = 702;
        }
        C4822a.vxR = new C7484ax(i);
        this.eIH = c1671c;
        AppMethodBeat.m2505o(57893);
    }

    /* renamed from: QF */
    public static int m3383QF() {
        AppMethodBeat.m2504i(57894);
        int a = C1647b.m3318a(eIM);
        AppMethodBeat.m2505o(57894);
        return a;
    }

    /* renamed from: QG */
    public static String m3384QG() {
        AppMethodBeat.m2504i(57895);
        String c1183p = new C1183p(C1647b.m3318a(eIM)).toString();
        AppMethodBeat.m2505o(57895);
        return c1183p;
    }

    /* renamed from: QH */
    public static String m3385QH() {
        return eIO;
    }

    /* renamed from: lD */
    public static String m3405lD(String str) {
        eIO = str;
        return str;
    }

    /* renamed from: QI */
    public static boolean m3386QI() {
        return eIP;
    }

    /* renamed from: QJ */
    public static void m3387QJ() {
        eIP = true;
    }

    /* renamed from: QK */
    public static String m3388QK() {
        return eIN;
    }

    /* renamed from: lE */
    public static void m3406lE(String str) {
        eIN = str;
    }

    /* renamed from: jN */
    static boolean m3402jN(int i) {
        return i != 0;
    }

    /* renamed from: QL */
    protected static void m3389QL() {
        AppMethodBeat.m2504i(57896);
        C1647b.m3319a(eIM, 0);
        AppMethodBeat.m2505o(57896);
    }

    /* renamed from: QM */
    protected static void m3390QM() {
        AppMethodBeat.m2504i(57897);
        C1647b.m3319a(eIM, 0);
        AppMethodBeat.m2505o(57897);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: QO */
    public final void mo5155QO() {
        AppMethodBeat.m2504i(57899);
        C4990ab.m7421w("MMKernel.CoreAccount", "account storage release  uin:%s thread:%s stack:%s", C1183p.getString(C1647b.m3318a(eIM)), Thread.currentThread().getName(), C5046bo.dpG());
        if (mo5161QY()) {
            this.eIH.onAccountRelease();
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5245jC(null);
            m3391QN();
            C1720g.m3537RQ();
            C1720g.m3536RP().eJV.clear();
            AppMethodBeat.m2505o(57899);
            return;
        }
        C4990ab.m7417i("MMKernel.CoreAccount", "Fatal crash error!!! status is not initialized when release(), this callStack is:%s, last reset stack is:%s", C5046bo.dpG().toString(), eIN);
        AppMethodBeat.m2505o(57899);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: cl */
    public final void mo5164cl(boolean z) {
        boolean z2;
        int doL;
        Object obj;
        AppMethodBeat.m2504i(57900);
        if (!z) {
            z2 = WXHardCoderJNI.hcBootEnable;
            int i = WXHardCoderJNI.hcBootDelay;
            int i2 = WXHardCoderJNI.hcBootCPU;
            int i3 = WXHardCoderJNI.hcBootIO;
            if (WXHardCoderJNI.hcBootThr) {
                doL = C1720g.m3539RS().doL();
            } else {
                doL = 0;
            }
            this.eIS = WXHardCoderJNI.startPerformance(z2, i, i2, i3, doL, WXHardCoderJNI.hcBootTimeout, 101, WXHardCoderJNI.hcBootAction, "MMKernel.CoreAccount");
            C4990ab.m7417i("MMKernel.CoreAccount", "summerhardcoder startPerformance[%s] stack[%s]", Integer.valueOf(this.eIS), C5046bo.dpG());
        }
        C4990ab.m7416i("MMKernel.CoreAccount", "UserStatusChange: clear");
        synchronized (this.eIX) {
            try {
                this.eIX.clear();
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(57900);
                }
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        final int a = C1647b.m3318a(eIM);
        C4990ab.m7417i("MMKernel.CoreAccount", "dkacc setAccuin %s hash:%d thread:%d[%s] stack:%s", C1183p.getString(a), Integer.valueOf(C1179i.m2593bL(a, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), C5046bo.dpG());
        if (a != 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            C4990ab.m7420w("MMKernel.CoreAccount", "setAccUin, Reset by MMCore.resetAccUin");
        } else {
            boolean z3;
            long currentTimeMillis2;
            C1183p.getString(a);
            C4872b.dnL();
            C1720g.m3537RQ();
            C1706e RP = C1720g.m3536RP();
            C16421 c16421 = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(57880);
                    C1668a.this.eJa = C1646a.AccountHasReady;
                    String x = C1178g.m2591x(("mm" + a).getBytes());
                    FileSystemManager dMy = FileSystemManager.dMy();
                    dMy.ens().mo11627ir("account", x).mo11628ri(false);
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
                    C4990ab.m7416i("VFS.Debug", "SetEnv ${account} = " + x + " and broadcast.");
                    AppMethodBeat.m2505o(57880);
                }
            };
            C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0).edit().putBoolean("isLogin", true).apply();
            String x = C1178g.m2591x("mm".concat(String.valueOf(a)).getBytes());
            RP.eJM = RP.eJL + x + "/";
            RP.cachePath = C5128ac.eSj + x + "/";
            File file = new File(RP.cachePath);
            C4990ab.m7416i("MMKernel.CoreStorage", "dkacc cachePath:" + RP.cachePath + " accPath:" + RP.eJM);
            if (file.exists()) {
                z3 = false;
            } else {
                C4990ab.m7421w("MMKernel.CoreStorage", "setUin REBUILD data now ! DO NOT FUCKING TELL ME DB BROKEN !!! uin:%s data:%s sd:%s", C1183p.getString(a), RP.cachePath, RP.eJM);
                file.mkdirs();
                if (!RP.cachePath.equalsIgnoreCase(RP.eJM)) {
                    currentTimeMillis2 = System.currentTimeMillis();
                    new File(RP.eJM).renameTo(new File(C6457e.eSn + (x + "temp" + System.currentTimeMillis())));
                    C4990ab.m7417i("MMKernel.CoreStorage", "find the old files and rename then %s" + (System.currentTimeMillis() - currentTimeMillis2), x);
                }
                z3 = true;
            }
            RP.eJU = new C1842cf(RP.cachePath, z3);
            RP.mo5232Rq();
            x = RP.cachePath + "MicroMsg.db";
            String str = RP.cachePath + "EnMicroMsg.db";
            String str2 = RP.cachePath + "EnMicroMsg2.db";
            RP.mo5245jC(null);
            RP.mo5246lJ(str);
            RP.eJN = new C7480h(new C17072());
            C7480h c7480h = RP.eJN;
            long j = (long) a;
            C1427q.m3026LK();
            if (c7480h.mo16660b(x, str, str2, j, C1706e.m3483Jx(), true)) {
                boolean z4;
                String str3 = RP.eJN.ybS;
                if (!C5046bo.isNullOrNil(str3)) {
                    C4990ab.m7412e("MMKernel.CoreStorage", "dbinit failed :".concat(String.valueOf(str3)));
                    C4872b.m7233A("init db Failed: [ " + str3 + "]", "DBinit");
                }
                c7480h = RP.eJN;
                if (c7480h.ybP != null) {
                    z4 = c7480h.ybP.ybo;
                } else {
                    z4 = false;
                }
                if (z4) {
                    RP.eJT = true;
                }
                RP.eJP = new C7580z(RP.eJN);
                RP.eJR = new C7622by(RP.eJN);
                RP.eJN.ybR = new C17083();
                RP.eJS = RP.eJR.duv();
                RP.eJO = new C7480h(RP.eJK);
                c7480h = RP.eJO;
                j = (long) a;
                C1427q.m3026LK();
                if (c7480h.mo16660b(x, str, str2, j, new HashMap(), true)) {
                    int intValue;
                    boolean z5;
                    RP.eJQ = new C7574bs(RP.eJP);
                    RP.eJQ.mo10116c(new C17094());
                    RP.eJQ.duo();
                    c16421.run();
                    if (z3) {
                        currentTimeMillis2 = ((Long) RP.eJP.get(C5127a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(0))).longValue();
                        intValue = ((Integer) RP.eJP.get(C5127a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(0))).intValue();
                        if (currentTimeMillis2 > 0) {
                            C4990ab.m7421w("MMKernel.CoreStorage", "summerinstall new install but firsttime[%d] > 0", Long.valueOf(currentTimeMillis2));
                        } else {
                            RP.eJP.set(C5127a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
                        }
                        if (intValue > 0) {
                            C4990ab.m7421w("MMKernel.CoreStorage", "summerinstall new install but version[%d] > 0", Integer.valueOf(intValue));
                        } else {
                            RP.eJP.set(C5127a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(C7243d.vxo));
                        }
                        C4990ab.m7417i("MMKernel.CoreStorage", "edw setAccUin, summerinstall time[%d]，version[%d], clientversion[%d]", (Long) RP.eJP.get(C5127a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(0)), (Integer) RP.eJP.get(C5127a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(0)), Integer.valueOf(C7243d.vxo));
                    }
                    if (!z) {
                        C1720g.m3537RQ();
                        C4990ab.m7417i("MMKernel.CoreAccount", "summerinit validateUsername username[%s]", C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(2, null)));
                        if (C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(2, null)).length() <= 0) {
                            C4990ab.m7412e("MMKernel.CoreAccount", "username of acc stg not set: uin=" + C1647b.m3318a(eIM));
                            m3391QN();
                            C1647b.m3319a(eIM, 0);
                            eIN = C5046bo.dpG().toString();
                            C5004al.m7441d(new C16454());
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        if (obj == null) {
                            C7053e.pXa.mo8378a(598, 21, 1, true);
                            C4990ab.m7420w("MMKernel.CoreAccount", "setAccUin, validateUsername false no need initialize!");
                        }
                    }
                    C4879a.xxA.mo10055m(new C6465cd());
                    C1720g.m3537RQ();
                    C1706e RP2 = C1720g.m3536RP();
                    C1705c c1705c = new C1705c();
                    doL = C5046bo.m7567h((Integer) RP2.eJP.get(14, null));
                    int i4 = C7243d.vxo;
                    C4990ab.m7411d("MMKernel.CoreStorage", "sVer: %s, cVer: %s.", Integer.toHexString(doL), Integer.toHexString(i4));
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
                        C4990ab.m7416i("MMKernel.CoreStorage", "[initialize] need not init emoji");
                    } else {
                        RP2.eJP.set(274480, Boolean.TRUE);
                        C4990ab.m7416i("MMKernel.CoreStorage", "[initialize] need init emoji");
                    }
                    if (doL != 0 && doL < 637599744) {
                        RP2.eJP.set(348162, Boolean.TRUE);
                    }
                    if ((doL != i4 ? 1 : null) != null) {
                        C4990ab.m7420w("MMKernel.CoreStorage", "account storage version changed from " + Integer.toHexString(doL) + " to " + Integer.toHexString(i4) + ", init=" + z5);
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
                        C4996ah.getContext().getSharedPreferences("update_config_prefs", C1448h.m3078Mu()).edit().clear().commit();
                        if ((doL & -256) == (i4 & -256) || doL == 0) {
                            C4990ab.m7410d("MMKernel.CoreStorage", "lock show_whatsnew from if.");
                            C4997aj.amA("show_whatsnew");
                        }
                    } else {
                        C4990ab.m7410d("MMKernel.CoreStorage", "lock show_whatsnew from else.");
                        C4997aj.amA("show_whatsnew");
                    }
                    z4 = RP2.eJP.getBoolean(C5127a.USERINFO_STORY_WHATS_NEW_BOOLEAN_SYNC, false);
                    RP2.eJP.set(C5127a.USERINFO_STORY_WHATS_NEW_BOOLEAN_SYNC, Boolean.FALSE);
                    C4990ab.m7417i("MMKernel.CoreStorage", "unlock show_whatsnew from testWhatsNew, %s.", Boolean.valueOf(z4));
                    if (z4) {
                        C4997aj.amB("show_whatsnew");
                    }
                    c1705c.eKe = z2;
                    c1705c.eKf = doL;
                    this.eIR = c1705c;
                    C4990ab.m7417i("MMKernel.CoreAccount", "check is update :%b ", Boolean.valueOf(c1705c.eKe));
                    this.eIU = true;
                    if (!this.eIT) {
                        mo5156QP();
                        C1720g.m3534RN().mo5162QZ();
                    }
                    C6665av.fly.mo14897ak("last_login_uin", C1183p.getString(a));
                    C7053e.pXa.mo8383hB(a);
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
                    C4990ab.m7417i(x, str, objArr);
                    this.eIQ = new C1810a();
                    C4990ab.m7417i("MMKernel.CoreAccount", "setAccUin done :%s", C1183p.getString(a));
                    C4879a.xxA.mo10055m(new C6483gi());
                    C1720g.m3537RQ();
                    if (C1720g.m3535RO().eJo != null) {
                        C1720g.m3537RQ();
                        if (C1720g.m3535RO().eJo.ftA != null) {
                            C1720g.m3537RQ();
                            C1720g.m3535RO().eJo.ftA.mo5532cG(true);
                            C1720g.m3537RQ();
                            C1898c adg = C1720g.m3535RO().eJo.ftA.adg();
                            if (!(a == 0 || adg == null || a == adg.mo5480QF())) {
                                C4990ab.m7421w("MMKernel.CoreAccount", "summerauth update acc info with acc stg: old acc uin=%d, this uin=%d", Integer.valueOf(adg.mo5480QF()), Integer.valueOf(a));
                                C7053e.pXa.mo8378a(148, 46, 1, false);
                                adg.mo5489hB(a);
                            }
                        }
                    }
                } else {
                    C1819b c1819b = new C1819b((byte) 0);
                    AppMethodBeat.m2505o(57900);
                    throw c1819b;
                }
            }
            SQLiteException sQLiteException = new SQLiteException("main db init failed");
            AppMethodBeat.m2505o(57900);
            throw sQLiteException;
        }
        C4990ab.m7417i("MMKernel.CoreAccount", "start time check setUinImpl end total time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        C4990ab.m7416i("MMKernel.CoreAccount", "mAccountStatus to AccountHasReady");
        AppMethodBeat.m2505o(57900);
    }

    /* renamed from: QP */
    public final void mo5156QP() {
        AppMethodBeat.m2504i(57901);
        if (this.eIU) {
            this.eIU = false;
            C4990ab.m7417i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized tid:%d, stack[%s]", Long.valueOf(Thread.currentThread().getId()), C5046bo.dpG());
            long currentTimeMillis = System.currentTimeMillis();
            this.eIH.onAccountInitialized(this.eIR);
            C4990ab.m7417i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized run tid[%d] take[%d]ms", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            mo5157QQ();
            AppMethodBeat.m2505o(57901);
            return;
        }
        C4990ab.m7416i("MMKernel.CoreAccount", "no need do account initialized notify.");
        AppMethodBeat.m2505o(57901);
    }

    /* renamed from: QQ */
    public final void mo5157QQ() {
        AppMethodBeat.m2504i(57902);
        if (mo5161QY() && C6610c.m10890Sa().eLa) {
            C4990ab.m7416i("MMKernel.CoreAccount", "Flush client version.");
            C1720g.m3536RP().mo5231Rp();
        }
        AppMethodBeat.m2505o(57902);
    }

    /* renamed from: QR */
    public final synchronized C1231y mo5158QR() {
        C1231y c1231y;
        AppMethodBeat.m2504i(57903);
        if (this.eII == null) {
            this.eII = new C1231y();
        }
        c1231y = this.eII;
        AppMethodBeat.m2505o(57903);
        return c1231y;
    }

    /* renamed from: QS */
    public static boolean m3392QS() {
        return eIK;
    }

    /* renamed from: cm */
    public static void m3401cm(boolean z) {
        eIK = z;
    }

    /* renamed from: QT */
    public static boolean m3393QT() {
        AppMethodBeat.m2504i(57904);
        if (eIJ) {
            String string;
            String str = "MMKernel.CoreAccount";
            String str2 = "account holded :%s init:%b";
            Object[] objArr = new Object[2];
            C1720g.m3537RQ();
            if (C1720g.m3534RN() != null) {
                C1720g.m3537RQ();
                C1720g.m3534RN();
                string = C1183p.getString(C1647b.m3318a(eIM));
            } else {
                string = "-1";
            }
            objArr[0] = string;
            objArr[1] = Boolean.valueOf(C1720g.m3534RN().mo5161QY());
            C4990ab.m7421w(str, str2, objArr);
        }
        boolean z = eIJ;
        AppMethodBeat.m2505o(57904);
        return z;
    }

    public static void hold() {
        String string;
        AppMethodBeat.m2504i(57905);
        String str = "MMKernel.CoreAccount";
        String str2 = " HOLD ACCOUNT! uin:%s stack:%s init:%b";
        Object[] objArr = new Object[3];
        C1720g.m3537RQ();
        if (C1720g.m3534RN() != null) {
            C1720g.m3537RQ();
            C1720g.m3534RN();
            string = C1183p.getString(C1647b.m3318a(eIM));
        } else {
            string = "-1";
        }
        objArr[0] = string;
        objArr[1] = C5046bo.dpG();
        objArr[2] = Boolean.valueOf(C1720g.m3534RN().mo5161QY());
        C4990ab.m7421w(str, str2, objArr);
        eIJ = true;
        C1720g.m3537RQ();
        C1720g.m3536RP().eJH.set(17, Integer.valueOf(1));
        AppMethodBeat.m2505o(57905);
    }

    public static void unhold() {
        String string;
        AppMethodBeat.m2504i(57906);
        String str = "MMKernel.CoreAccount";
        String str2 = " UN HOLD ACCOUNT! uin:%s init:%b";
        Object[] objArr = new Object[2];
        C1720g.m3537RQ();
        if (C1720g.m3534RN() != null) {
            C1720g.m3537RQ();
            C1720g.m3534RN();
            string = C1183p.getString(C1647b.m3318a(eIM));
        } else {
            string = "-1";
        }
        objArr[0] = string;
        objArr[1] = Boolean.valueOf(C1720g.m3534RN().mo5161QY());
        C4990ab.m7421w(str, str2, objArr);
        eIJ = false;
        C1720g.m3537RQ();
        C1720g.m3536RP().eJH.set(17, Integer.valueOf(0));
        AppMethodBeat.m2505o(57906);
    }

    /* renamed from: QU */
    public final void mo5159QU() {
        AppMethodBeat.m2504i(57907);
        if (mo5161QY()) {
            AppMethodBeat.m2505o(57907);
            return;
        }
        C1819b c1819b = new C1819b();
        AppMethodBeat.m2505o(57907);
        throw c1819b;
    }

    /* renamed from: QV */
    public final void mo5160QV() {
        AppMethodBeat.m2504i(57908);
        new C7306ak(Looper.getMainLooper()).post(new C16432());
        AppMethodBeat.m2505o(57908);
    }

    /* renamed from: cd */
    public final void mo5163cd(int i, int i2) {
        AppMethodBeat.m2504i(57909);
        int i3 = (this.eIV == i && this.eIW == i2) ? 0 : 1;
        C4990ab.m7411d("MMKernel.CoreAccount", "online status, %d, %d, %d ,%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.eIW), Integer.valueOf(this.eIV));
        if (i3 == 0) {
            AppMethodBeat.m2505o(57909);
            return;
        }
        this.eIV = i;
        this.eIW = i2;
        new C7306ak(Looper.getMainLooper()).post(new C16443());
        AppMethodBeat.m2505o(57909);
    }

    /* renamed from: jO */
    public static void m3403jO(int i) {
        AppMethodBeat.m2504i(57910);
        if (eIY == -1 || eIY != i) {
            eIY = i;
            C1668a.m3382Mz().edit().putInt("notification.user.state", i).commit();
            C4990ab.m7417i("MMKernel.CoreAccount", "[NOTIFICATION SETTINGS]save UserStatus: %d", Integer.valueOf(i));
            AppMethodBeat.m2505o(57910);
            return;
        }
        AppMethodBeat.m2505o(57910);
    }

    /* renamed from: QW */
    public static int m3394QW() {
        AppMethodBeat.m2504i(57911);
        int i = C1668a.m3382Mz().getInt("notification.user.state", 0);
        AppMethodBeat.m2505o(57911);
        return i;
    }

    /* renamed from: Mz */
    public static SharedPreferences m3382Mz() {
        AppMethodBeat.m2504i(57912);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("notify_key_pref_settings", C1448h.m3078Mu());
        AppMethodBeat.m2505o(57912);
        return sharedPreferences;
    }

    /* renamed from: jP */
    public static boolean m3404jP(int i) {
        return (i & 1) != 0;
    }

    /* JADX WARNING: Missing block: B:14:0x004b, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(57914);
     */
    /* JADX WARNING: Missing block: B:24:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initialize() {
        AppMethodBeat.m2504i(57914);
        if (mo5161QY()) {
            AppMethodBeat.m2505o(57914);
            return;
        }
        synchronized (this.eIL) {
            try {
                if (mo5161QY()) {
                } else {
                    if (C1647b.m3318a(eIM) != 0) {
                        this.eIZ = SystemClock.elapsedRealtime();
                        C4990ab.m7421w("MMKernel.CoreAccount", "auto set up account storage uin: %d, stack: %s", Integer.valueOf(r0), C5046bo.dpG());
                        mo5164cl(false);
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(57914);
            }
        }
    }

    /* renamed from: QX */
    public static boolean m3395QX() {
        AppMethodBeat.m2504i(57915);
        if (C1647b.m3318a(eIM) != 0) {
            AppMethodBeat.m2505o(57915);
            return true;
        }
        AppMethodBeat.m2505o(57915);
        return false;
    }

    /* renamed from: QY */
    public final boolean mo5161QY() {
        return this.eJa == C1646a.AccountHasReady;
    }

    /* renamed from: QZ */
    public final void mo5162QZ() {
        AppMethodBeat.m2504i(57916);
        C4990ab.m7417i("MMKernel.CoreAccount", "summerasyncinit setInitializedNotifyAllDone[%b] to true stack[%s]", Boolean.valueOf(this.eJb), C5046bo.dpG());
        this.eJb = true;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C4990ab.m7417i("MMKernel.CoreAccount", "summerhardcoder setInitializedNotifyAllDone [%d %d] take[%d]ms, stack[%s]", Long.valueOf(this.eIZ), Long.valueOf(elapsedRealtime), Long.valueOf(elapsedRealtime - this.eIZ), C5046bo.dpG());
        C4879a.xxA.mo10055m(new C6464cc());
        AppMethodBeat.m2505o(57916);
    }

    /* renamed from: Ra */
    public static int m3396Ra() {
        AppMethodBeat.m2504i(57917);
        int i = C4996ah.getContext().getSharedPreferences("system_config_prefs", C1448h.m3078Mu()).getInt("default_uin", 0);
        AppMethodBeat.m2505o(57917);
        return i;
    }

    /* renamed from: Rb */
    public static String m3397Rb() {
        AppMethodBeat.m2504i(57918);
        C1720g.m3537RQ();
        if (C5046bo.isNullOrNil(C1720g.m3534RN().eJc)) {
            C1668a.m3398Rc();
        }
        C1720g.m3537RQ();
        String str = C1720g.m3534RN().eJc;
        AppMethodBeat.m2505o(57918);
        return str;
    }

    /* renamed from: Rc */
    public static void m3398Rc() {
        AppMethodBeat.m2504i(57919);
        C1720g.m3537RQ();
        C1720g.m3534RN().eJc = C1427q.m3028LM() + "_" + System.currentTimeMillis();
        C1720g.m3537RQ();
        C1720g.m3534RN().eJd.clear();
        AppMethodBeat.m2505o(57919);
    }

    /* renamed from: lF */
    public static int m3407lF(String str) {
        int i;
        AppMethodBeat.m2504i(57920);
        C1720g.m3537RQ();
        if (C1720g.m3534RN().eJd.get(str) == null) {
            i = 0;
        } else {
            C1720g.m3537RQ();
            i = ((Integer) C1720g.m3534RN().eJd.get(str)).intValue();
        }
        int anT = (int) C5046bo.anT();
        if (i == 0) {
            C1720g.m3537RQ();
            C1720g.m3534RN().eJd.put(str, Integer.valueOf(anT));
            AppMethodBeat.m2505o(57920);
            return i;
        }
        i = anT - i;
        C1720g.m3537RQ();
        C1720g.m3534RN().eJd.put(str, Integer.valueOf(anT));
        if (i >= 0) {
            AppMethodBeat.m2505o(57920);
            return i;
        }
        AppMethodBeat.m2505o(57920);
        return 0;
    }

    /* renamed from: QN */
    private void m3391QN() {
        AppMethodBeat.m2504i(57898);
        this.eJa = C1646a.NotReady;
        this.eJb = false;
        C4990ab.m7416i("MMKernel.CoreAccount", "mAccountStatus to NotReady");
        C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0).edit().putBoolean("isLogin", false).commit();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
        C4990ab.m7421w("MMKernel.CoreAccount", "[arthurdan.AccountNR] account storage reset! uin:%d, resetStack is:%s, resetTime:%s", Integer.valueOf(C1647b.m3318a(eIM)), eIN, simpleDateFormat.format(new Date()));
        AppMethodBeat.m2505o(57898);
    }

    public final void release() {
        AppMethodBeat.m2504i(57913);
        synchronized (this.eIL) {
            try {
                mo5155QO();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(57913);
            }
        }
    }
}
