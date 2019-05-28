package com.tencent.mm.plugin.monitor;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Debug.MemoryInfo;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.kvdata.BDStatusInfo;
import com.tencent.mm.plugin.report.kvdata.HeavyDetailInfo;
import com.tencent.mm.plugin.report.kvdata.TableInfo;
import com.tencent.mm.plugin.report.kvdata.log_14375;
import com.tencent.mm.plugin.report.service.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.z;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements at {
    private static final long startTime = System.currentTimeMillis();
    private a foI = new a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(84525);
            ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv abTestListener onNotifyChange stack[%s]", bo.dpG());
            if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                d.xDH.o(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(84524);
                        b.a(b.this);
                        AppMethodBeat.o(84524);
                    }
                }, 100);
            }
            AppMethodBeat.o(84525);
        }
    };
    private boolean jZS = false;
    private boolean jZT = true;
    private BroadcastReceiver jZU;
    private Runnable jZV;
    private c nqj = new c<mp>() {
        {
            AppMethodBeat.i(84528);
            this.xxI = mp.class.getName().hashCode();
            AppMethodBeat.o(84528);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(84529);
            d.xDH.al(b.this.oEI);
            d.xDH.o(b.this.oEI, 3000);
            AppMethodBeat.o(84529);
            return false;
        }
    };
    private long oEA = 1024;
    private long oEB = 1440;
    private long oEC = 20;
    private long oED = 1440;
    private long oEE = 0;
    private a.a oEF;
    private long oEG = 0;
    private f oEH = new f() {
        public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
            AppMethodBeat.i(84517);
            String str2 = "MicroMsg.SubCoreBaseMonitor";
            String str3 = "summerhv onIDKeyCallback onSceneEnd[%d][%d, %d, %s]";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(mVar == null ? -1 : mVar.getType());
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = str;
            ab.i(str2, str3, objArr);
            if (i == 0 && i2 == 0) {
                e.cgp();
            }
            AppMethodBeat.o(84517);
        }
    };
    private Runnable oEI = new Runnable() {
        public final void run() {
            AppMethodBeat.i(84526);
            ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportAllRunnable run");
            if (g.RK()) {
                b.b(b.this);
                b.c(b.this);
                b.d(b.this);
                b.e(b.this);
                b.f(b.this);
                d.xDH.al(b.this.oEJ);
                d.xDH.o(b.this.oEJ, 10000);
                AppMethodBeat.o(84526);
                return;
            }
            ab.w("MicroMsg.SubCoreBaseMonitor", "account has not initalized!");
            AppMethodBeat.o(84526);
        }
    };
    private Runnable oEJ = new Runnable() {
        public final void run() {
            AppMethodBeat.i(84527);
            ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportHeavyUserRunnable run");
            if (g.RK()) {
                b.h(b.this);
            }
            AppMethodBeat.o(84527);
        }
    };
    private ap oEK = new ap(g.RS().oAl.getLooper(), new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(84530);
            b.e(b.this);
            AppMethodBeat.o(84530);
            return true;
        }
    }, true);
    private long oEt = 1024;
    private long oEu = 10;
    private long oEv = 1800;
    private long oEw = 3000000;
    private long oEx = 15000;
    private long oEy = 100000;
    private long oEz = 10000;

    public b() {
        AppMethodBeat.i(84536);
        AppMethodBeat.o(84536);
    }

    static /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(84543);
        boolean je = bVar.je(true);
        AppMethodBeat.o(84543);
        return je;
    }

    static {
        AppMethodBeat.i(84555);
        AppMethodBeat.o(84555);
    }

    private boolean je(boolean z) {
        boolean z2;
        AppMethodBeat.i(84537);
        com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100212");
        ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg update[%b] abTest[%s][%b][%s] default[%d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d]", Boolean.valueOf(z), ll, Boolean.valueOf(ll.isValid()), ll.dru(), Long.valueOf(1024), Long.valueOf(10), Long.valueOf(1800), Long.valueOf(3000000), Long.valueOf(15000), Long.valueOf(15000), Long.valueOf(100000), Long.valueOf(10000), Long.valueOf(1440), Long.valueOf(20), Long.valueOf(1440));
        if (ll.isValid()) {
            ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg abTest valid!");
            Map dru = ll.dru();
            long j = bo.getLong((String) dru.get("sdsize"), 1024);
            long j2 = bo.getLong((String) dru.get("sdratio"), 10);
            long j3 = bo.getLong((String) dru.get("dbsize"), 1800);
            long j4 = bo.getLong((String) dru.get("fdbsize"), 1024);
            long j5 = bo.getLong((String) dru.get("msg"), 3000000);
            long j6 = bo.getLong((String) dru.get("conv"), 15000);
            long j7 = bo.getLong((String) dru.get("contact"), 100000);
            long j8 = bo.getLong((String) dru.get("chatroom"), 10000);
            long j9 = bo.getLong((String) dru.get("sditv"), 1440);
            long j10 = bo.getLong((String) dru.get("sdwait"), 20);
            long j11 = bo.getLong((String) dru.get("dbitv"), 1440);
            ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg sd[%d, %d] sdr[%d, %d] db[%d, %d] fdbsize[%d, %d] msg[%d, %d] conv[%d, %d] contact[%d, %d] chatroom[%d, %d] sditv[%d, %d] sdwait[%d, %d] dbitv[%d, %d]", Long.valueOf(this.oEt), Long.valueOf(j), Long.valueOf(this.oEu), Long.valueOf(j2), Long.valueOf(this.oEv), Long.valueOf(j3), Long.valueOf(this.oEA), Long.valueOf(j4), Long.valueOf(this.oEw), Long.valueOf(j5), Long.valueOf(this.oEx), Long.valueOf(j6), Long.valueOf(this.oEy), Long.valueOf(j7), Long.valueOf(this.oEz), Long.valueOf(j8), Long.valueOf(this.oEB), Long.valueOf(j9), Long.valueOf(this.oEC), Long.valueOf(j10), Long.valueOf(this.oED), Long.valueOf(j11));
            if (this.oEt != j) {
                this.oEt = j;
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.oEu != j2) {
                this.oEu = j2;
                z2 = true;
            }
            if (this.oEv != j3) {
                this.oEv = j3;
                z2 = true;
            }
            if (this.oEA != j4) {
                this.oEA = j4;
                z2 = true;
            }
            if (this.oEw != j5) {
                this.oEw = j5;
                z2 = true;
            }
            if (this.oEx != j6) {
                this.oEx = j6;
                z2 = true;
            }
            if (this.oEy != j7) {
                this.oEy = j7;
                z2 = true;
            }
            if (this.oEz != j8) {
                this.oEz = j8;
                z2 = true;
            }
            if (this.oEB != j9) {
                this.oEB = j9;
                z2 = true;
            }
            if (this.oEC != j10) {
                this.oEC = j10;
                z2 = true;
            }
            if (this.oED != j11) {
                this.oED = j11;
                z2 = true;
            }
        } else {
            z2 = false;
        }
        if (z2) {
            h.pYm.a(509, 0, 1, true);
            if (z) {
                h.pYm.a(509, 18, 1, true);
            }
        }
        if (this.oEt <= 0) {
            h.pYm.a(509, 30, 1, true);
            this.oEt = 1024;
        }
        if (this.oEu <= 0) {
            h.pYm.a(509, 31, 1, true);
            this.oEu = 10;
        }
        if (this.oEv <= 0) {
            h.pYm.a(509, 32, 1, true);
            this.oEv = 1800;
        }
        if (this.oEw <= 0) {
            h.pYm.a(509, 33, 1, true);
            this.oEw = 3000000;
        }
        if (this.oEx <= 0) {
            h.pYm.a(509, 34, 1, true);
            this.oEx = 15000;
        }
        if (this.oEy <= 0) {
            h.pYm.a(509, 35, 1, true);
            this.oEy = 100000;
        }
        if (this.oEz <= 0) {
            h.pYm.a(509, 36, 1, true);
            this.oEz = 10000;
        }
        if (this.oEB <= 0) {
            h.pYm.a(509, 37, 1, true);
            this.oEB = 1440;
        }
        if (this.oEC <= 0) {
            h.pYm.a(509, 38, 1, true);
            this.oEC = 20;
        }
        if (this.oED <= 0) {
            h.pYm.a(509, 39, 1, true);
            this.oED = 1440;
        }
        if (this.oEA <= 0) {
            h.pYm.a(509, 40, 1, true);
            this.oEA = 1024;
        }
        AppMethodBeat.o(84537);
        return z2;
    }

    public final HashMap<Integer, com.tencent.mm.cd.h.d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(84538);
        com.tencent.mm.sdk.b.a.xxA.b(this.nqj);
        com.tencent.mm.model.c.c.abi().c(this.foI);
        boolean je = je(false);
        g.RQ();
        this.oEG = ((Long) g.RP().Ry().get(ac.a.USERINFO_HEAVY_USER_FLAG_LONG, Long.valueOf(0))).longValue();
        e.ki(this.oEG != 0);
        ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountPostReset heavyuser[%d], reloadHeavyUser[%b] abTestListener[%s]", Long.valueOf(this.oEG), Boolean.valueOf(je), this.foI);
        g.RQ();
        g.RO().eJo.a(989, this.oEH);
        g.RQ();
        g.RO().eJo.a(988, this.oEH);
        g.RQ();
        g.RO().eJo.a(987, this.oEH);
        g.RQ();
        g.RO().eJo.a(986, this.oEH);
        g.RQ();
        this.oEE = ((Long) g.RP().Ry().get(ac.a.USERINFO_WECHAT_FILE_SCAN_LAST_TIME_LONG, Long.valueOf(0))).longValue();
        Context context = ah.getContext();
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            boolean z2 = intExtra == 2 || intExtra == 5;
            this.jZS = z2;
        } else {
            this.jZS = false;
        }
        this.jZT = ((PowerManager) context.getSystemService("power")).isScreenOn();
        this.jZU = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                boolean z;
                AppMethodBeat.i(84533);
                String action = intent.getAction();
                int i = -1;
                switch (action.hashCode()) {
                    case -2128145023:
                        if (action.equals("android.intent.action.SCREEN_OFF")) {
                            i = 1;
                            break;
                        }
                        break;
                    case -1886648615:
                        if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                            i = 3;
                            break;
                        }
                        break;
                    case -1454123155:
                        if (action.equals("android.intent.action.SCREEN_ON")) {
                            i = 0;
                            break;
                        }
                        break;
                    case 1019184907:
                        if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                            i = 2;
                            break;
                        }
                        break;
                }
                switch (i) {
                    case 0:
                        b.this.jZT = true;
                        break;
                    case 1:
                        b.this.jZT = false;
                        break;
                    case 2:
                        b.this.jZS = true;
                        break;
                    case 3:
                        b.this.jZS = false;
                        break;
                }
                String str = "MicroMsg.SubCoreBaseMonitor";
                String str2 = "summerhv Action received: %s, interactive: %s, charging: %s, lastScanTime:%d, delayTimerRunnable null[%b]";
                Object[] objArr = new Object[5];
                objArr[0] = action;
                objArr[1] = Boolean.valueOf(b.this.jZT);
                objArr[2] = Boolean.valueOf(b.this.jZS);
                objArr[3] = Long.valueOf(b.this.oEE);
                if (b.this.jZV == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[4] = Boolean.valueOf(z);
                ab.v(str, str2, objArr);
                if (b.this.jZV == null && b.this.jZS && !b.this.jZT) {
                    if (com.tencent.mm.sdk.a.b.dnO()) {
                        b.this.oEC = 0;
                    } else if (SystemClock.uptimeMillis() - b.this.oEE < b.this.oEB * 60000) {
                        ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv last scan time not matched in [%d]min", Long.valueOf(b.this.oEB));
                        AppMethodBeat.o(84533);
                        return;
                    }
                    final AnonymousClass1 anonymousClass1 = new a() {
                        public final void a(int i, a.a aVar) {
                            AppMethodBeat.i(84531);
                            b.this.oEE = SystemClock.uptimeMillis();
                            ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv callback errType[%d] lastScanTime[%d], result[%s][%s]", Integer.valueOf(i), Long.valueOf(b.this.oEE), b.this.oEF, aVar);
                            b.this.oEF = null;
                            if (i == 0 && !aVar.fIa) {
                                g.RQ();
                                g.RP().Ry().set(ac.a.USERINFO_WECHAT_FILE_SCAN_LAST_TIME_LONG, Long.valueOf(b.this.oEE));
                                g.RQ();
                                g.RP().Ry().dsb();
                                try {
                                    b.b(b.this, aVar);
                                    AppMethodBeat.o(84531);
                                    return;
                                } catch (Exception e) {
                                    ab.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e, "doReportSDInfo err!", new Object[0]);
                                    h.pYm.a(418, 6, 1, true);
                                }
                            }
                            AppMethodBeat.o(84531);
                        }
                    };
                    b.this.jZV = new Runnable() {
                        public final void run() {
                            int i;
                            AppMethodBeat.i(84532);
                            b.this.jZV = null;
                            List bOv = ((j) g.K(j.class)).Yo().bOv();
                            if (bo.ek(bOv)) {
                                ab.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask all finished!");
                                i = 0;
                            } else {
                                d.post(new com.tencent.mm.model.bf.AnonymousClass1(bOv), "checkUnfinishedDeleteMsgTask");
                                i = bOv.size();
                            }
                            ab.i("MicroMsg.SubCoreBaseMonitor", "summerdel checkUnfinishedDeleteMsgTask ret[%s]", Integer.valueOf(i));
                            if (i > 0) {
                                h.pYm.a(418, 8, 1, true);
                            }
                            b.this.oEF = b.a(b.this, anonymousClass1);
                            ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan started[%s]", b.this.oEF);
                            AppMethodBeat.o(84532);
                        }
                    };
                    d.xDH.a(b.this.jZV, "MicroMsg.SubCoreBaseMonitor", b.this.oEC * 60000);
                    ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan post delay[%d]min", Long.valueOf(b.this.oEC));
                    AppMethodBeat.o(84533);
                } else if (b.this.jZV != null) {
                    d.xDH.al(b.this.jZV);
                    b.this.jZV = null;
                    ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan remove[%s]", b.this.oEF);
                    AppMethodBeat.o(84533);
                } else {
                    if (b.this.oEF != null) {
                        b.this.oEF.fIa = true;
                        ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan canceled[%s]", b.this.oEF);
                        b.this.oEF = null;
                    }
                    AppMethodBeat.o(84533);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        context.registerReceiver(this.jZU, intentFilter);
        String str = "MicroMsg.SubCoreBaseMonitor";
        String str2 = "summerhv registerReceiver auto scan %s. Device status:%s interactive,%s charging mLastAutoScanTime[%d], mAutoScanInterval[%d], mAutoScanWaitTime[%d].";
        Object[] objArr = new Object[6];
        objArr[0] = this.oEF != null ? "enabled" : "disabled";
        objArr[1] = this.jZT ? "" : " not";
        objArr[2] = this.jZS ? "" : " not";
        objArr[3] = Long.valueOf(this.oEE);
        objArr[4] = Long.valueOf(this.oEB * 60000);
        objArr[5] = Long.valueOf(this.oEC * 60000);
        ab.i(str, str2, objArr);
        this.oEK.stopTimer();
        AppMethodBeat.o(84538);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(84539);
        ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountRelease [%d]", Long.valueOf(startTime), Long.valueOf(System.currentTimeMillis()));
        if (this.jZU != null) {
            ah.getContext().unregisterReceiver(this.jZU);
            ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver mChargeAndInteractiveReceiver[%s]", this.jZU);
            this.jZU = null;
        }
        if (this.jZV != null) {
            d.xDH.al(this.jZV);
            this.jZV = null;
            ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver remove[%s]", this.oEF);
        }
        if (this.oEF != null) {
            this.oEF.fIa = true;
            ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver canceled[%s]", this.oEF);
            this.oEF = null;
        }
        g.RQ();
        g.RO().eJo.b(989, this.oEH);
        g.RQ();
        g.RO().eJo.b(988, this.oEH);
        g.RQ();
        g.RO().eJo.b(987, this.oEH);
        g.RQ();
        g.RO().eJo.b(986, this.oEH);
        com.tencent.mm.model.c.c.abi().d(this.foI);
        com.tencent.mm.sdk.b.a.xxA.d(this.nqj);
        AppMethodBeat.o(84539);
    }

    private static boolean RQ(String str) {
        AppMethodBeat.i(84540);
        g.RQ();
        if (g.RP().eJM.equals(str + "/")) {
            AppMethodBeat.o(84540);
            return true;
        }
        AppMethodBeat.o(84540);
        return false;
    }

    private a.a a(com.tencent.mm.vfs.b bVar, a.a aVar, com.tencent.mm.plugin.monitor.a.b bVar2, a.c cVar, Map<String, Integer> map, boolean z, int i) {
        AppMethodBeat.i(84541);
        if (aVar.fIa) {
            ab.i("MicroMsg.SubCoreBaseMonitor", "summclean scanFile been canceled fileResult[%s], subDirResult[%s]", aVar, bVar2);
            AppMethodBeat.o(84541);
        } else {
            if (aVar.bna < i) {
                aVar.bna++;
            }
            if (bVar.isDirectory()) {
                Object obj;
                com.tencent.mm.plugin.monitor.a.b bVar3;
                String w = com.tencent.mm.vfs.j.w(bVar.dMD());
                if (bVar2 == null) {
                    if (map == null || map.size() <= 0 || map.get(w) == null) {
                        if (com.tencent.mm.compatible.util.e.eSn.equals(bVar.getParent() + "/")) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj == null || RQ(w)) {
                            if (RQ(bVar.getParent())) {
                                bVar3 = new com.tencent.mm.plugin.monitor.a.b(w, 203);
                            } else {
                                bVar3 = bVar2;
                            }
                        } else if (Pattern.matches("[a-fA-F0-9]{32}temp[0-9]{13}", bVar.getName())) {
                            bVar3 = new com.tencent.mm.plugin.monitor.a.b(w, 202);
                        } else if (Pattern.matches("[a-fA-F0-9]{32}", bVar.getName())) {
                            bVar3 = new com.tencent.mm.plugin.monitor.a.b(w, 201);
                        } else {
                            bVar3 = new com.tencent.mm.plugin.monitor.a.b(w, 203);
                        }
                    } else {
                        bVar3 = new com.tencent.mm.plugin.monitor.a.b(w, ((Integer) map.get(w)).intValue());
                        map.remove(w);
                    }
                    if (bVar3 != null) {
                        aVar.oEq.add(bVar3);
                        ab.d("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile start scan subDir[%s], fileResult[%s], newSubDirResult[%s]", w, aVar, bVar3);
                    }
                } else {
                    bVar3 = bVar2;
                }
                aVar.oEo++;
                if (bVar3 != null) {
                    bVar3.oEo++;
                }
                if (cVar != null) {
                    cVar.oEo++;
                }
                if (i > 15) {
                    ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile been stopped as depth[%d] over limit path[%s], fileResult[%s]", Integer.valueOf(i), com.tencent.mm.vfs.j.w(bVar.dMD()), aVar);
                    AppMethodBeat.o(84541);
                } else {
                    String[] list = bVar.list();
                    if (list == null) {
                        ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile dir is empty[%s] ret", com.tencent.mm.vfs.j.w(bVar.dMD()));
                        AppMethodBeat.o(84541);
                    } else if (z) {
                        a.c cVar2 = cVar;
                        for (String str : list) {
                            if (!bo.isNullOrNil(str) && Pattern.matches("[a-fA-F0-9]{32}temp[0-9]{13}", str)) {
                                cVar2 = new a.c(com.tencent.mm.vfs.j.w(bVar.dMD()) + "/" + str);
                                aVar.oEr.add(cVar2);
                            }
                            a(new com.tencent.mm.vfs.b(com.tencent.mm.vfs.j.w(bVar.mUri) + "/" + str), aVar, bVar3, cVar2, map, false, i + 1);
                        }
                    } else {
                        Object obj2 = 1;
                        int length = list.length;
                        int i2 = 0;
                        while (i2 < length) {
                            a(new com.tencent.mm.vfs.b(com.tencent.mm.vfs.j.w(bVar.dMD()) + "/" + list[i2]), aVar, bVar3, cVar, map, false, i + 1);
                            if (obj2 == null || aVar.bna <= 15) {
                                obj = obj2;
                            } else {
                                h.pYm.a(418, 7, 1, true);
                                h.pYm.e(13778, Integer.valueOf(2), Integer.valueOf(2), com.tencent.mm.vfs.j.w(bVar.dMD()) + "/" + r18);
                                obj = null;
                            }
                            i2++;
                            obj2 = obj;
                        }
                    }
                }
            } else {
                aVar.oEp++;
                if (bVar2 != null) {
                    bVar2.oEp++;
                }
                if (cVar != null) {
                    cVar.oEp++;
                }
                if (bVar.exists()) {
                    long length2 = bVar.length();
                    if (length2 <= 0 || length2 >= 2147483648L) {
                        aVar.fileLenInvalidCount++;
                        if (bVar2 != null) {
                            bVar2.fileLenInvalidCount++;
                        }
                        if (cVar != null) {
                            cVar.oEs++;
                        }
                    } else {
                        aVar.jrb += length2;
                        if (bVar2 != null) {
                            bVar2.jrb += length2;
                        }
                        if (cVar != null) {
                            cVar.jrb = length2 + cVar.jrb;
                        }
                    }
                } else {
                    ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile file not exist[%s][%d] ret", com.tencent.mm.vfs.j.w(bVar.dMD()), Long.valueOf(aVar.oEp));
                    AppMethodBeat.o(84541);
                }
            }
            AppMethodBeat.o(84541);
        }
        return aVar;
    }

    private synchronized void k(int i, long j, long j2) {
        long j3;
        AppMethodBeat.i(84542);
        boolean z = j > j2;
        if (z) {
            j3 = this.oEG | ((long) i);
        } else {
            j3 = this.oEG & ((long) (i ^ -1));
        }
        ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser type[%d] value[%d] limit[%d] heavy[%b] mHeavyUser[%d] newHeavyUser[%d] tid[%s]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), Long.valueOf(this.oEG), Long.valueOf(j3), Long.valueOf(Thread.currentThread().getId()));
        if (j3 != this.oEG) {
            if (this.oEG == 0) {
                h.pYm.a(509, 1, 1, true);
            }
            if (j3 == 0) {
                h.pYm.a(509, 2, 1, true);
            }
        }
        ac.a aVar = null;
        ac.a aVar2;
        switch (i) {
            case 1:
                aVar2 = ac.a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_SIZE_LONG;
                h.pYm.a(509, z ? 3 : 4, 1, true);
                aVar = aVar2;
                break;
            case 2:
                aVar2 = ac.a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_RATIO_LONG;
                h.pYm.a(509, z ? 5 : 6, 1, true);
                aVar = aVar2;
                break;
            case 4:
                aVar2 = ac.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_SIZE_LONG;
                h.pYm.a(509, z ? 7 : 8, 1, true);
                aVar = aVar2;
                break;
            case 8:
                aVar2 = ac.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_MESSAGE_LONG;
                h.pYm.a(509, z ? 9 : 10, 1, true);
                aVar = aVar2;
                break;
            case 16:
                aVar2 = ac.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONVERSATION_LONG;
                h.pYm.a(509, z ? 11 : 12, 1, true);
                aVar = aVar2;
                break;
            case 32:
                aVar2 = ac.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONTACT_LONG;
                h.pYm.a(509, z ? 13 : 14, 1, true);
                aVar = aVar2;
                break;
            case 64:
                aVar2 = ac.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CHATROOM_LONG;
                h.pYm.a(509, z ? 15 : 16, 1, true);
                aVar = aVar2;
                break;
            case 128:
                aVar2 = ac.a.USERINFO_HEAVY_USER_REPORT_TYPE_FAV_DB_SIZE_LONG;
                h.pYm.a(509, z ? 19 : 20, 1, true);
                aVar = aVar2;
                break;
        }
        this.oEG = j3;
        e.ki(j3 != 0);
        final long j4 = j3;
        final long j5 = j;
        d.xDH.ak(new Runnable() {
            public final void run() {
                AppMethodBeat.i(84522);
                if (g.RK()) {
                    g.RQ();
                    g.RP().Ry().set(ac.a.USERINFO_HEAVY_USER_FLAG_LONG, Long.valueOf(j4));
                    if (aVar != null) {
                        g.RQ();
                        g.RP().Ry().set(aVar, Long.valueOf(j5));
                    }
                    ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser heavyUser[%d, %d], fkey[%s], value[%d]", Long.valueOf(j4), Long.valueOf(b.this.oEG), aVar, Long.valueOf(j5));
                    AppMethodBeat.o(84522);
                    return;
                }
                AppMethodBeat.o(84522);
            }
        });
        AppMethodBeat.o(84542);
    }

    static /* synthetic */ void b(b bVar) {
        AppMethodBeat.i(84544);
        if (g.RK()) {
            g.RQ();
            long longValue = ((Long) g.RP().Ry().get(ac.a.USERINFO_REPORT_SD_STATUS_TIME_LONG, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 259200000 || longValue > currentTimeMillis) {
                g.RQ();
                g.RP().Ry().set(ac.a.USERINFO_REPORT_SD_STATUS_TIME_LONG, Long.valueOf(currentTimeMillis));
                d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(84521);
                        try {
                            int round;
                            int i;
                            long j;
                            long j2;
                            long j3;
                            long j4;
                            long j5;
                            int i2;
                            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(ac.eSj + "SdcardInfo.cfg");
                            h.pYm.a(340, bVar.exists() ? 10 : 11, 1, true);
                            boolean dpr = bd.dpr();
                            String path = com.tencent.mm.compatible.util.h.getDataDirectory().getPath();
                            String path2 = com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getPath();
                            StatFs statFs = new StatFs(path);
                            long blockSize = (long) statFs.getBlockSize();
                            long blockCount = (long) statFs.getBlockCount();
                            long availableBlocks = (long) statFs.getAvailableBlocks();
                            long j6 = blockSize * blockCount;
                            long j7 = blockSize * availableBlocks;
                            if (blockCount > 0) {
                                round = Math.round((((float) availableBlocks) * 100.0f) / ((float) blockCount));
                            } else {
                                round = -1;
                            }
                            statFs = new StatFs(path2);
                            long blockSize2 = (long) statFs.getBlockSize();
                            long blockCount2 = (long) statFs.getBlockCount();
                            long availableBlocks2 = (long) statFs.getAvailableBlocks();
                            long j8 = blockSize2 * blockCount2;
                            long j9 = blockSize2 * availableBlocks2;
                            int i3 = -1;
                            if (blockCount2 > 0) {
                                i3 = Math.round((((float) availableBlocks2) * 100.0f) / ((float) blockCount2));
                            }
                            boolean equals = com.tencent.mm.compatible.util.e.eSl.equals(path2);
                            if (equals) {
                                i = i3;
                                j = j9;
                                j2 = j8;
                                j3 = availableBlocks2;
                                j4 = blockCount2;
                                j5 = blockSize2;
                            } else {
                                statFs = new StatFs(com.tencent.mm.compatible.util.e.eSl);
                                j5 = (long) statFs.getBlockSize();
                                j4 = (long) statFs.getBlockCount();
                                long availableBlocks3 = (long) statFs.getAvailableBlocks();
                                long j10 = j5 * j4;
                                long j11 = j5 * availableBlocks3;
                                if (j4 > 0) {
                                    i = Math.round((((float) availableBlocks3) * 100.0f) / ((float) j4));
                                    j = j11;
                                    j2 = j10;
                                    j3 = availableBlocks3;
                                } else {
                                    i = i3;
                                    j = j11;
                                    j2 = j10;
                                    j3 = availableBlocks3;
                                }
                            }
                            String amQ = bd.amQ(com.tencent.mm.compatible.util.e.eSl);
                            String amQ2 = bd.amQ(path);
                            String str = "MicroMsg.SubCoreBaseMonitor";
                            String str2 = "summerStorage [%s, %s, %s] [%s] [%b] [%d,%d,%d,%d,%d,%d] [%d,%d,%d,%d,%d,%d] [%b] [%d,%d,%d,%d,%d,%d], [%d][%s]";
                            Object[] objArr = new Object[26];
                            objArr[0] = path;
                            objArr[1] = path2;
                            objArr[2] = com.tencent.mm.compatible.util.e.eSl;
                            objArr[3] = amQ;
                            objArr[4] = Boolean.valueOf(dpr);
                            objArr[5] = Long.valueOf(blockSize);
                            objArr[6] = Long.valueOf(blockCount);
                            objArr[7] = Long.valueOf(availableBlocks);
                            objArr[8] = Long.valueOf(j6);
                            objArr[9] = Long.valueOf(j7);
                            objArr[10] = Integer.valueOf(round);
                            objArr[11] = Long.valueOf(blockSize2);
                            objArr[12] = Long.valueOf(blockCount2);
                            objArr[13] = Long.valueOf(availableBlocks2);
                            objArr[14] = Long.valueOf(j8);
                            objArr[15] = Long.valueOf(j9);
                            objArr[16] = Integer.valueOf(i3);
                            objArr[17] = Boolean.valueOf(equals);
                            objArr[18] = Long.valueOf(j5);
                            objArr[19] = Long.valueOf(j4);
                            objArr[20] = Long.valueOf(j3);
                            objArr[21] = Long.valueOf(j2);
                            objArr[22] = Long.valueOf(j);
                            objArr[23] = Integer.valueOf(i);
                            if (bVar.exists()) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            objArr[24] = Integer.valueOf(i2);
                            objArr[25] = amQ2;
                            ab.i(str, str2, objArr);
                            h.pYm.a(340, 0, 1, true);
                            h.pYm.a(340, dpr ? 1 : 2, 1, true);
                            h.pYm.a(340, equals ? 3 : 4, 1, true);
                            h hVar = h.pYm;
                            objArr = new Object[2];
                            objArr[0] = Integer.valueOf(5000);
                            String str3 = "%s;%s;%s;%s;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%s";
                            Object[] objArr2 = new Object[26];
                            objArr2[0] = path;
                            objArr2[1] = path2;
                            objArr2[2] = com.tencent.mm.compatible.util.e.eSl;
                            objArr2[3] = amQ;
                            objArr2[4] = Integer.valueOf(dpr ? 1 : 0);
                            objArr2[5] = Long.valueOf(blockSize);
                            objArr2[6] = Long.valueOf(blockCount);
                            objArr2[7] = Long.valueOf(availableBlocks);
                            objArr2[8] = Long.valueOf(j6);
                            objArr2[9] = Long.valueOf(j7);
                            objArr2[10] = Integer.valueOf(round);
                            objArr2[11] = Long.valueOf(blockSize2);
                            objArr2[12] = Long.valueOf(blockCount2);
                            objArr2[13] = Long.valueOf(availableBlocks2);
                            objArr2[14] = Long.valueOf(j8);
                            objArr2[15] = Long.valueOf(j9);
                            objArr2[16] = Integer.valueOf(i3);
                            objArr2[17] = Integer.valueOf(equals ? 1 : 0);
                            objArr2[18] = Long.valueOf(j5);
                            objArr2[19] = Long.valueOf(j4);
                            objArr2[20] = Long.valueOf(j3);
                            objArr2[21] = Long.valueOf(j2);
                            objArr2[22] = Long.valueOf(j);
                            objArr2[23] = Integer.valueOf(i);
                            if (bVar.exists()) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            objArr2[24] = Integer.valueOf(i2);
                            objArr2[25] = amQ2;
                            objArr[1] = String.format(str3, objArr2);
                            hVar.e(11098, objArr);
                            h.pYm.e(11098, Integer.valueOf(ReaderCallback.HIDDEN_BAR), path + ";" + amQ2);
                            h.pYm.e(11098, Integer.valueOf(ReaderCallback.SHOW_BAR), com.tencent.mm.compatible.util.e.eSl + ";" + amQ);
                            hVar = h.pYm;
                            objArr = new Object[2];
                            objArr[0] = Integer.valueOf(ReaderCallback.COPY_SELECT_TEXT);
                            objArr[1] = Integer.valueOf(bVar.exists() ? 1 : 0);
                            hVar.e(11098, objArr);
                            hVar = h.pYm;
                            objArr = new Object[2];
                            objArr[0] = Integer.valueOf(ReaderCallback.SEARCH_SELECT_TEXT);
                            objArr[1] = Integer.valueOf(dpr ? 1 : 0);
                            hVar.e(11098, objArr);
                            h.pYm.a(340, 7, 1, true);
                            AppMethodBeat.o(84521);
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e, "reportSDStatus err!", new Object[0]);
                            h.pYm.a(340, 8, 1, true);
                            AppMethodBeat.o(84521);
                        }
                    }
                }, "reportSDStatus");
            }
        }
        AppMethodBeat.o(84544);
    }

    static /* synthetic */ void c(b bVar) {
        AppMethodBeat.i(84545);
        g.RQ();
        long longValue = ((Long) g.RP().Ry().get(ac.a.USERINFO_WECHAT_DB_REPORT_LAST_TIME_LONG, Long.valueOf(0))).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - longValue > bVar.oED * 60000 || longValue > currentTimeMillis) {
            g.RQ();
            g.RP().Ry().set(ac.a.USERINFO_WECHAT_DB_REPORT_LAST_TIME_LONG, Long.valueOf(currentTimeMillis));
            currentTimeMillis = (bVar.oEv * 1024) * 1024;
            final long j = bVar.oEw;
            final long j2 = (bVar.oEA * 1024) * 1024;
            final long j3 = bVar.oEx;
            final long j4 = bVar.oEy;
            final long j5 = bVar.oEz;
            d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(84518);
                    try {
                        log_14375 log_14375 = new log_14375();
                        log_14375.type_ = 1;
                        BDStatusInfo bDStatusInfo = new BDStatusInfo();
                        log_14375.dbStatusInfo_ = bDStatusInfo;
                        g.RQ();
                        long length = new com.tencent.mm.vfs.b(g.RP().Rw()).length();
                        bDStatusInfo.mmDBSize_ = length;
                        StringBuilder stringBuilder = new StringBuilder();
                        g.RQ();
                        long length2 = new com.tencent.mm.vfs.b(stringBuilder.append(g.RP().cachePath).append("SnsMicroMsg.db").toString()).length();
                        bDStatusInfo.snsDBSize_ = length2;
                        stringBuilder = new StringBuilder();
                        g.RQ();
                        long length3 = new com.tencent.mm.vfs.b(stringBuilder.append(g.RP().cachePath).append("enFavorite.db").toString()).length();
                        bDStatusInfo.favDBSize_ = length3;
                        b.a(b.this, 4, length, currentTimeMillis);
                        b.a(b.this, 128, length3, j2);
                        String str = length + ";" + length2 + ";" + length3;
                        g.RQ();
                        com.tencent.mm.cd.h hVar = g.RP().eJO;
                        if (hVar == null || !hVar.isOpen()) {
                            ab.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo db is not open!");
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            ArrayList arrayList = new ArrayList();
                            Cursor a = hVar.a("SELECT name FROM sqlite_master WHERE type='table'", null, 2);
                            if (a != null) {
                                int columnIndex = a.getColumnIndex("name");
                                while (a.moveToNext()) {
                                    arrayList.add(a.getString(columnIndex));
                                }
                                a.close();
                            }
                            String str2 = str + ";" + arrayList.size();
                            bDStatusInfo.mmDBTableCount_ = arrayList.size();
                            LinkedList linkedList = new LinkedList();
                            bDStatusInfo.tableList_ = linkedList;
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                str = (String) it.next();
                                Cursor a2 = hVar.a("select count(*) from ".concat(String.valueOf(str)), null, 2);
                                length = 0;
                                if (a2 != null) {
                                    if (a2.moveToFirst()) {
                                        length = a2.getLong(0);
                                    }
                                    a2.close();
                                }
                                String str3 = str2 + ";" + str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + length;
                                TableInfo tableInfo = new TableInfo();
                                tableInfo.name_ = str;
                                tableInfo.count_ = length;
                                linkedList.add(tableInfo);
                                if (ShareConstants.WEB_DIALOG_PARAM_MESSAGE.equals(str)) {
                                    b.a(b.this, 8, length, j);
                                    str2 = str3;
                                } else if ("rconversation".equals(str)) {
                                    b.a(b.this, 16, length, j3);
                                    str2 = str3;
                                } else if ("rcontact".equals(str)) {
                                    b.a(b.this, 32, length, j4);
                                    str2 = str3;
                                } else {
                                    if ("chatroom".equals(str)) {
                                        b.a(b.this, 64, length, j5);
                                    }
                                    str2 = str3;
                                }
                            }
                            ab.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo dump all table count %d last %d", Integer.valueOf(arrayList.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            str = str2;
                        }
                        h.pYm.e(13778, Integer.valueOf(1), Integer.valueOf(1), str);
                        h.pYm.c(14375, log_14375);
                        h.pYm.a(418, 3, 1, true);
                        ab.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo result[%s]", str);
                        AppMethodBeat.o(84518);
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e, "reportDBInfo err!", new Object[0]);
                        h.pYm.a(418, 4, 1, true);
                        AppMethodBeat.o(84518);
                    }
                }
            }, "reportDBInfo");
        }
        AppMethodBeat.o(84545);
    }

    static /* synthetic */ void d(b bVar) {
        AppMethodBeat.i(84546);
        if (g.RK()) {
            g.RQ();
            long longValue = ((Long) g.RP().Ry().get(ac.a.USERINFO_INSTALL_LAST_REPORT_TIME_LONG, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 259200000 || longValue > currentTimeMillis) {
                g.RQ();
                g.RP().Ry().set(ac.a.USERINFO_INSTALL_LAST_REPORT_TIME_LONG, Long.valueOf(currentTimeMillis));
                d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(84519);
                        try {
                            g.RQ();
                            int intValue = ((Integer) g.RP().Ry().get(ac.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(0))).intValue();
                            g.RQ();
                            long longValue = ((Long) g.RP().Ry().get(ac.a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(0))).longValue();
                            long r = b.r(b.this);
                            int i = (intValue <= 0 || com.tencent.mm.protocal.d.vxo == intValue) ? 1 : 0;
                            StringBuilder append = new StringBuilder().append(intValue).append(";").append(com.tencent.mm.protocal.d.vxo).append(";");
                            if (i != 0) {
                                i = 1;
                            } else {
                                i = 0;
                            }
                            String stringBuilder = append.append(i).append(";").append(new SimpleDateFormat("yyyyMMdd").format(new Date(longValue))).append(";").append(r).toString();
                            h.pYm.a(418, 1, 1, true);
                            h.pYm.e(13778, Integer.valueOf(3), Integer.valueOf(1), stringBuilder);
                            ab.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion install result[%s]", stringBuilder);
                            AppMethodBeat.o(84519);
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e, "reportVersion err!", new Object[0]);
                            h.pYm.a(418, 2, 1, true);
                            AppMethodBeat.o(84519);
                        }
                    }
                }, "reportVersion");
            }
        }
        AppMethodBeat.o(84546);
    }

    static /* synthetic */ void e(b bVar) {
        AppMethodBeat.i(84547);
        if (g.RK()) {
            int i;
            g.RQ();
            z Ry = g.RP().Ry();
            int intValue = ((Integer) Ry.get(ac.a.USERINFO_MM_LVFETIME_REPORT_PID_INT, Integer.valueOf(0))).intValue();
            long longValue = ((Long) Ry.get(ac.a.USERINFO_MM_LVFETIME_REPORT_LIFETIME_LONG, Long.valueOf(0))).longValue();
            int intValue2 = ((Integer) Ry.get(ac.a.USERINFO_MM_LVFETIME_REPORT_MEMORY_PSS_INT, Integer.valueOf(0))).intValue();
            int myPid = Process.myPid();
            MemoryInfo[] processMemoryInfo = ((ActivityManager) ah.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[]{myPid});
            if (processMemoryInfo == null || processMemoryInfo.length <= 0 || processMemoryInfo[0] == null) {
                i = -1;
            } else {
                i = processMemoryInfo[0].getTotalPss();
            }
            if (intValue == 0) {
                Ry.set(ac.a.USERINFO_MM_LVFETIME_REPORT_PID_INT, Integer.valueOf(myPid));
                Ry.set(ac.a.USERINFO_MM_LVFETIME_REPORT_LIFETIME_LONG, Long.valueOf(System.currentTimeMillis() - startTime));
                ac.a aVar = ac.a.USERINFO_MM_LVFETIME_REPORT_MEMORY_PSS_INT;
                if (i <= 0) {
                    i = 0;
                }
                Ry.set(aVar, Integer.valueOf(i));
            } else if (intValue != myPid) {
                h.pYm.e(13778, Integer.valueOf(5), Integer.valueOf(1), Long.valueOf(longValue));
                h.pYm.e(13778, Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(intValue2));
                Ry.set(ac.a.USERINFO_MM_LVFETIME_REPORT_PID_INT, Integer.valueOf(myPid));
                long currentTimeMillis = System.currentTimeMillis() - startTime;
                if (i <= 0) {
                    i = 0;
                }
                Ry.set(ac.a.USERINFO_MM_LVFETIME_REPORT_LIFETIME_LONG, Long.valueOf(currentTimeMillis));
                Ry.set(ac.a.USERINFO_MM_LVFETIME_REPORT_MEMORY_PSS_INT, Integer.valueOf(i));
                ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportLifeTime lifeTime[%d -> %d]ms,  pss[%d -> %d], pid[%d -> %d]", Long.valueOf(longValue), Long.valueOf(currentTimeMillis), Integer.valueOf(intValue2), Integer.valueOf(i), Integer.valueOf(intValue), Integer.valueOf(myPid));
            } else {
                Ry.set(ac.a.USERINFO_MM_LVFETIME_REPORT_LIFETIME_LONG, Long.valueOf(System.currentTimeMillis() - startTime));
                if (i > intValue2) {
                    Ry.set(ac.a.USERINFO_MM_LVFETIME_REPORT_MEMORY_PSS_INT, Integer.valueOf(i));
                }
            }
            Ry.dsb();
            bVar.oEK.ae(180000, 180000);
        }
        AppMethodBeat.o(84547);
    }

    static /* synthetic */ void f(b bVar) {
        AppMethodBeat.i(84548);
        if (g.RN().QY()) {
            g.RQ();
            long longValue = ((Long) g.RP().Ry().get(ac.a.USERINFO_REPORT_ECDH_AUTH_TIME_LONG, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 86400000 || longValue > currentTimeMillis) {
                g.RQ();
                g.RP().Ry().set(ac.a.USERINFO_REPORT_ECDH_AUTH_TIME_LONG, Long.valueOf(currentTimeMillis));
                d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(84523);
                        ab.i("MicroMsg.SubCoreBaseMonitor", "reportECDHAuth USE_ECDH[%s] USE_ML[%b]", Boolean.valueOf(com.tencent.mm.protocal.f.vxx), Boolean.valueOf(com.tencent.mm.protocal.f.vxy));
                        h.pYm.a(148, com.tencent.mm.protocal.f.vxx ? 100 : 101, 1, true);
                        h.pYm.a(148, com.tencent.mm.protocal.f.vxy ? 102 : 103, 1, true);
                        AppMethodBeat.o(84523);
                    }
                }, "reportECDHAuth");
            }
        }
        AppMethodBeat.o(84548);
    }

    static /* synthetic */ void h(b bVar) {
        AppMethodBeat.i(84549);
        if (bVar.oEG != 0) {
            g.RQ();
            long longValue = ((Long) g.RP().Ry().get(ac.a.USERINFO_HEAVY_USER_REPORT_TIME_LONG, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 86400000 || longValue > currentTimeMillis) {
                h.pYm.a(509, 17, 1, true);
                g.RQ();
                g.RP().Ry().set(ac.a.USERINFO_HEAVY_USER_REPORT_TIME_LONG, Long.valueOf(currentTimeMillis));
                g.RQ();
                longValue = ((Long) g.RP().Ry().get(ac.a.USERINFO_HEAVY_USER_FLAG_LONG, Long.valueOf(0))).longValue();
                log_14375 log_14375 = new log_14375();
                log_14375.type_ = 4;
                HeavyDetailInfo heavyDetailInfo = new HeavyDetailInfo();
                log_14375.heavyDetailInfo_ = heavyDetailInfo;
                heavyDetailInfo.flag_ = longValue;
                String valueOf = String.valueOf(longValue);
                g.RQ();
                long longValue2 = ((Long) g.RP().Ry().get(ac.a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_SIZE_LONG, Long.valueOf(0))).longValue();
                heavyDetailInfo.sdFileSize_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                g.RQ();
                longValue2 = ((Long) g.RP().Ry().get(ac.a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_RATIO_LONG, Long.valueOf(0))).longValue();
                heavyDetailInfo.sdFileRatio_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                g.RQ();
                longValue2 = ((Long) g.RP().Ry().get(ac.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_SIZE_LONG, Long.valueOf(0))).longValue();
                heavyDetailInfo.dbSize_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                g.RQ();
                longValue2 = ((Long) g.RP().Ry().get(ac.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_MESSAGE_LONG, Long.valueOf(0))).longValue();
                heavyDetailInfo.message_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                g.RQ();
                longValue2 = ((Long) g.RP().Ry().get(ac.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONVERSATION_LONG, Long.valueOf(0))).longValue();
                heavyDetailInfo.conversation_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                g.RQ();
                longValue2 = ((Long) g.RP().Ry().get(ac.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONTACT_LONG, Long.valueOf(0))).longValue();
                heavyDetailInfo.contact_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                g.RQ();
                longValue2 = ((Long) g.RP().Ry().get(ac.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CHATROOM_LONG, Long.valueOf(0))).longValue();
                heavyDetailInfo.chatroom_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                g.RQ();
                longValue2 = ((Long) g.RP().Ry().get(ac.a.USERINFO_HEAVY_USER_REPORT_TYPE_FAV_DB_SIZE_LONG, Long.valueOf(0))).longValue();
                heavyDetailInfo.favDbSize_ = longValue2;
                String str = valueOf + ";" + longValue2;
                ah.getContext().getSharedPreferences("heavyDetailInfo", 0).edit().putLong("sdFileSize", heavyDetailInfo.sdFileSize_).putLong("sdFileRatio", heavyDetailInfo.sdFileRatio_).putLong("dbSize", heavyDetailInfo.dbSize_).putLong(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, heavyDetailInfo.message_).putLong("conversation", heavyDetailInfo.conversation_).putLong("contact", heavyDetailInfo.contact_).putLong("chatroom", heavyDetailInfo.chatroom_).putLong("favDbSize", heavyDetailInfo.favDbSize_).putLong("flag", heavyDetailInfo.flag_).apply();
                try {
                    JSONObject put = new JSONObject().put("sdFileSize", heavyDetailInfo.sdFileSize_).put("sdFileRatio", heavyDetailInfo.sdFileRatio_).put("dbSize", heavyDetailInfo.dbSize_).put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, heavyDetailInfo.message_).put("conversation", heavyDetailInfo.conversation_).put("contact", heavyDetailInfo.contact_).put("chatroom", heavyDetailInfo.chatroom_).put("favDbSize", heavyDetailInfo.favDbSize_).put("flag", heavyDetailInfo.flag_);
                    String str2 = g.RP().cachePath + "heavyDetailInfo";
                    byte[] bytes = put.toString().getBytes();
                    com.tencent.mm.vfs.e.b(str2, bytes, bytes.length);
                } catch (JSONException e) {
                    ab.e("MicroMsg.SubCoreBaseMonitor", "Failed to write heavyDetailInfo");
                }
                h.pYm.e(13778, Integer.valueOf(4), Integer.valueOf(1), str);
                h.pYm.c(14375, log_14375);
                ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportHeavyUser report heavy result[%s]", str);
            }
        }
        AppMethodBeat.o(84549);
    }

    static /* synthetic */ long r(b bVar) {
        AppMethodBeat.i(84554);
        g.RQ();
        if (g.RP().isSDCardAvailable()) {
            com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(com.tencent.mm.compatible.util.e.euX);
            if (bVar2.exists() && bVar2.isDirectory()) {
                com.tencent.mm.vfs.b[] dMF = bVar2.dMF();
                if (dMF == null || dMF.length == 0) {
                    ab.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion getOldestXlogDay failed as no files");
                    AppMethodBeat.o(84554);
                    return 0;
                }
                Arrays.sort(dMF, new Comparator<com.tencent.mm.vfs.b>() {
                    public final /* synthetic */ int compare(Object obj, Object obj2) {
                        AppMethodBeat.i(84520);
                        long lastModified = ((com.tencent.mm.vfs.b) obj).lastModified() - ((com.tencent.mm.vfs.b) obj2).lastModified();
                        if (lastModified > 0) {
                            AppMethodBeat.o(84520);
                            return 1;
                        } else if (lastModified == 0) {
                            AppMethodBeat.o(84520);
                            return 0;
                        } else {
                            AppMethodBeat.o(84520);
                            return -1;
                        }
                    }

                    public final boolean equals(Object obj) {
                        return true;
                    }
                });
                long j = 0;
                for (com.tencent.mm.vfs.b name : dMF) {
                    String name2 = name.getName();
                    if (!bo.isNullOrNil(name2) && name2.endsWith(".xlog")) {
                        j = bo.getLong(name2.substring(name2.length() - 13, name2.length() - 5), 0);
                        if (j > 0) {
                            break;
                        }
                    }
                }
                AppMethodBeat.o(84554);
                return j;
            }
            ab.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion getOldestXlogDay failed as path not exist");
            AppMethodBeat.o(84554);
            return 0;
        }
        ab.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion getOldestXlogDay failed as sdcard not available");
        AppMethodBeat.o(84554);
        return 0;
    }
}
