package com.tencent.mm.plugin.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.PowerManager;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.ju;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.f.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.j;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class b implements c, com.tencent.mm.kernel.b.c {
    private static HashMap<Integer, d> jZD;
    private static b jZG;
    private a jKo = new a() {
        public final void a(h hVar, final h.c cVar) {
            AppMethodBeat.i(18575);
            if (hVar == null) {
                AppMethodBeat.o(18575);
            } else if (cVar == null || cVar.oqK == null) {
                AppMethodBeat.o(18575);
            } else {
                b.a(b.this, new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(18574);
                        ab.d("MicroMsg.CalcWxService", "on notify change [%s] [%d]", cVar.oqJ, Integer.valueOf(cVar.oqK.size()));
                        if ("delete".equals(cVar.oqJ)) {
                            AppMethodBeat.o(18574);
                            return;
                        }
                        int i = "delete".equals(cVar.oqJ) ? 2 : 1;
                        Iterator it = cVar.oqK.iterator();
                        while (it.hasNext()) {
                            bi biVar = (bi) it.next();
                            if (biVar != null) {
                                boolean contains;
                                b bVar = b.this;
                                long j = biVar.field_msgId;
                                if (bVar.jZK) {
                                    contains = bVar.jZJ.contains(Long.valueOf(j));
                                } else {
                                    contains = false;
                                }
                                if (contains) {
                                    ab.d("MicroMsg.CalcWxService", "it locked now [%d]", Long.valueOf(biVar.field_msgId));
                                } else {
                                    b.this.jZH.aa(new com.tencent.mm.plugin.f.c.a(biVar, i));
                                }
                            }
                        }
                        AppMethodBeat.o(18574);
                    }
                });
                AppMethodBeat.o(18575);
            }
        }
    };
    private com.tencent.mm.plugin.f.b.b jZE;
    private t.a jZF;
    private al jZH;
    private com.tencent.mm.plugin.f.c.c jZI = null;
    public HashSet<Long> jZJ = new HashSet();
    public boolean jZK = false;
    private boolean jZL = false;
    public com.tencent.mm.plugin.f.c.c jZM = null;
    com.tencent.mm.plugin.f.c.b jZN = null;
    private HashMap<Integer, com.tencent.mm.plugin.f.a.a> jZO = new HashMap();
    private com.tencent.mm.plugin.f.c.c.a jZP = new com.tencent.mm.plugin.f.c.c.a() {
        public final void finish() {
            AppMethodBeat.i(18588);
            b.a(b.this, new Runnable() {
                public final void run() {
                    AppMethodBeat.i(18587);
                    b.this.jZM = null;
                    b.this.fD(false);
                    AppMethodBeat.o(18587);
                }
            });
            AppMethodBeat.o(18588);
        }
    };
    private com.tencent.mm.plugin.f.c.c.a jZQ = new com.tencent.mm.plugin.f.c.c.a() {
        public final void finish() {
            AppMethodBeat.i(18594);
            b.a(b.this, new Runnable() {
                public final void run() {
                    AppMethodBeat.i(18593);
                    b.this.jZI = null;
                    b.i(b.this);
                    AppMethodBeat.o(18593);
                }
            });
            AppMethodBeat.o(18594);
        }
    };
    private com.tencent.mm.sdk.b.c<ch> jZR = new com.tencent.mm.sdk.b.c<ch>() {
        {
            AppMethodBeat.i(18577);
            this.xxI = ch.class.getName().hashCode();
            AppMethodBeat.o(18577);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(18578);
            final ch chVar = (ch) bVar;
            b.a(b.this, new Runnable() {
                public final void run() {
                    AppMethodBeat.i(18576);
                    if (chVar == null) {
                        AppMethodBeat.o(18576);
                    } else if (bo.isNullOrNil(chVar.cvw.talker)) {
                        AppMethodBeat.o(18576);
                    } else {
                        try {
                            com.tencent.mm.plugin.f.b.b aZd = b.aZc().aZd();
                            long j = chVar.cvw.cvx;
                            String str = chVar.cvw.talker;
                            int i = chVar.cvw.msgType;
                            String[] strArr = new String[]{String.valueOf(j), String.valueOf(i), str};
                            int delete = aZd.bSd.delete("WxFileIndex2", "msgId=? AND msgType=? AND username=? ", strArr);
                            ab.i("MicroMsg.WxFileIndexStorage", "delete by msg [%d %d %s] result[%d]", Long.valueOf(j), Integer.valueOf(i), str, Integer.valueOf(delete));
                            AppMethodBeat.o(18576);
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.CalcWxService", e, "", new Object[0]);
                            com.tencent.mm.plugin.report.service.h.pYm.a(664, 6, 1, false);
                            AppMethodBeat.o(18576);
                        }
                    }
                }
            });
            AppMethodBeat.o(18578);
            return false;
        }
    };
    private boolean jZS = false;
    private boolean jZT = true;
    private BroadcastReceiver jZU;
    private Runnable jZV;
    private boolean jZW = false;
    private com.tencent.mm.sdk.b.c<bp> jZX = new com.tencent.mm.sdk.b.c<bp>() {
        {
            AppMethodBeat.i(18582);
            this.xxI = bp.class.getName().hashCode();
            AppMethodBeat.o(18582);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(18584);
            boolean aZl = aZl();
            AppMethodBeat.o(18584);
            return aZl;
        }

        private boolean aZl() {
            AppMethodBeat.i(18583);
            ab.i("MicroMsg.CalcWxService", "%s clean wx file index event ", b.this.aZk());
            b.this.jZW = true;
            try {
                g.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(18581);
                        g.RP().Ry().set(ac.a.USERINFO_CALC_WX_SCAN_MAX_MSGID2_LONG, Long.valueOf(-1));
                        g.RP().Ry().set(ac.a.USERINFO_CALC_WX_SCAN_CURR_MSGID2_LONG, Long.valueOf(0));
                        g.RP().Ry().dsb();
                        b.aZc().aZd().delete();
                        b.this.jZW = false;
                        AppMethodBeat.o(18581);
                    }
                });
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.CalcWxService", e, "%s clean wx file error", b.this.aZk());
            }
            AppMethodBeat.o(18583);
            return false;
        }
    };

    public b() {
        AppMethodBeat.i(18595);
        AppMethodBeat.o(18595);
    }

    static /* synthetic */ void m(b bVar) {
        AppMethodBeat.i(18615);
        bVar.stopScan();
        AppMethodBeat.o(18615);
    }

    static {
        AppMethodBeat.i(18616);
        HashMap hashMap = new HashMap();
        jZD = hashMap;
        hashMap.put(Integer.valueOf("WXFILEINDEX_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.f.b.b.fnj;
            }
        });
        AppMethodBeat.o(18616);
    }

    public static synchronized b aZc() {
        b bVar;
        synchronized (b.class) {
            AppMethodBeat.i(18596);
            if (jZG == null) {
                jZG = new b();
            }
            bVar = jZG;
            AppMethodBeat.o(18596);
        }
        return bVar;
    }

    public final com.tencent.mm.plugin.f.b.b aZd() {
        AppMethodBeat.i(18597);
        if (this.jZE == null) {
            this.jZE = new com.tencent.mm.plugin.f.b.b(this.jZF);
        }
        com.tencent.mm.plugin.f.b.b bVar = this.jZE;
        AppMethodBeat.o(18597);
        return bVar;
    }

    public final void f(Runnable runnable) {
        AppMethodBeat.i(18598);
        try {
            if (this.jZH != null) {
                this.jZH.aa(runnable);
                AppMethodBeat.o(18598);
                return;
            }
            ab.w("MicroMsg.CalcWxService", "%s post runnable but thread is null ", aZk());
            AppMethodBeat.o(18598);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.CalcWxService", e, "post error: [%s]", e.toString());
            AppMethodBeat.o(18598);
        }
    }

    public final void fD(final boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(18599);
        String str = "MicroMsg.CalcWxService";
        String str2 = "%s manual scan now manualScanTask[%b] uiClick[%b]";
        Object[] objArr = new Object[3];
        objArr[0] = aZk();
        if (this.jZM != null) {
            z2 = true;
        }
        objArr[1] = Boolean.valueOf(z2);
        objArr[2] = Boolean.valueOf(z);
        ab.d(str, str2, objArr);
        f(new Runnable() {
            public final void run() {
                AppMethodBeat.i(18585);
                if (z) {
                    b.this.jZL = true;
                }
                if (b.this.jZL) {
                    if (b.this.jZM == null) {
                        ju juVar = new ju();
                        if (b.this.aZg()) {
                            b.this.jZL = false;
                            juVar.cES.cco = true;
                            com.tencent.mm.sdk.b.a.xxA.m(juVar);
                            com.tencent.mm.plugin.report.service.h.pYm.a(664, 9, 1, false);
                            AppMethodBeat.o(18585);
                            return;
                        }
                        if (z) {
                            com.tencent.mm.plugin.report.service.h.pYm.a(664, 7, 1, false);
                        }
                        juVar.cES.progress = b.aZi();
                        juVar.cES.cET = b.aZf();
                        juVar.cES.cco = false;
                        com.tencent.mm.sdk.b.a.xxA.m(juVar);
                        b.this.jZM = new com.tencent.mm.plugin.f.c.c(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, b.aZi(), b.aZj(), b.this.jZP);
                        b.this.jZH.aa(b.this.jZM);
                        if (((Long) g.RP().Ry().get(ac.a.USERINFO_CALC_WX_SCAN_START_TIME_LONG, Long.valueOf(0))).longValue() <= 0) {
                            g.RP().Ry().set(ac.a.USERINFO_CALC_WX_SCAN_START_TIME_LONG, Long.valueOf(bo.anT()));
                        }
                    }
                    AppMethodBeat.o(18585);
                    return;
                }
                AppMethodBeat.o(18585);
            }
        });
        AppMethodBeat.o(18599);
    }

    public final void aZe() {
        boolean z = false;
        AppMethodBeat.i(18600);
        final com.tencent.mm.vfs.b[] a = new com.tencent.mm.vfs.b(e.eSn).a(new com.tencent.mm.vfs.c() {
            public final boolean f(com.tencent.mm.vfs.b bVar) {
                AppMethodBeat.i(18589);
                if (bVar.isDirectory()) {
                    AppMethodBeat.o(18589);
                    return false;
                } else if (bVar.getName().endsWith(".apk") || bVar.getName().endsWith(".temp")) {
                    AppMethodBeat.o(18589);
                    return true;
                } else {
                    AppMethodBeat.o(18589);
                    return false;
                }
            }
        });
        if (a != null && a.length > 0) {
            String str = "MicroMsg.CalcWxService";
            String str2 = "%s stop manual scan now manualScanTask[%b]";
            Object[] objArr = new Object[2];
            objArr[0] = aZk();
            if (this.jZM != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            ab.i(str, str2, objArr);
            f(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(18590);
                    if (a == null || a.length == 0) {
                        ab.e("MicroMsg.CalcWxService", "apkList is null or 0");
                        AppMethodBeat.o(18590);
                        return;
                    }
                    int i = 0;
                    com.tencent.mm.vfs.b bVar = null;
                    com.tencent.mm.vfs.b bVar2 = null;
                    for (com.tencent.mm.vfs.b bVar3 : a) {
                        if (bVar3.getName().endsWith(".temp")) {
                            if (bo.gb(bVar3.lastModified()) > 86400000) {
                                bVar3.delete();
                            } else if (bVar == null) {
                                bVar = bVar3;
                            } else if (bVar3.lastModified() > bVar.lastModified()) {
                                bVar.delete();
                                bVar = bVar3;
                            } else {
                                bVar3.delete();
                            }
                        } else if (bVar3.getName().endsWith(".apk")) {
                            PackageInfo packageArchiveInfo = ah.getContext().getPackageManager().getPackageArchiveInfo(j.w(bVar3.dMD()), 128);
                            if (packageArchiveInfo != null) {
                                if (packageArchiveInfo.packageName == null || packageArchiveInfo.packageName.equals("com.tencent.mm")) {
                                    ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
                                    if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                                        int i2 = applicationInfo.metaData.getInt(TbsDownloader.TBS_METADATA);
                                        ab.d("MicroMsg.CalcWxService", "startCleanAPKFiles:%d, currentVersion;%d", Integer.valueOf(i2), Integer.valueOf(com.tencent.mm.protocal.d.vxo));
                                        if (i2 <= com.tencent.mm.protocal.d.vxo) {
                                            bVar3.delete();
                                        } else if (bVar2 == null) {
                                            i = i2;
                                            bVar2 = bVar3;
                                        } else if (i2 > i) {
                                            bVar2.delete();
                                            i = i2;
                                            bVar2 = bVar3;
                                        } else {
                                            bVar3.delete();
                                        }
                                    }
                                } else {
                                    bVar3.delete();
                                }
                            }
                            if (i != 0) {
                                bVar3.delete();
                            } else if (bVar2 == null) {
                                bVar2 = bVar3;
                            } else if (bVar3.lastModified() > bVar2.lastModified()) {
                                bVar2.delete();
                                bVar2 = bVar3;
                            } else {
                                bVar3.delete();
                            }
                        }
                    }
                    AppMethodBeat.o(18590);
                }
            });
        }
        AppMethodBeat.o(18600);
    }

    private void stopScan() {
        AppMethodBeat.i(18601);
        f(new Runnable() {
            public final void run() {
                AppMethodBeat.i(18592);
                if (b.this.jZI != null) {
                    if (b.this.jZH != null) {
                        b.this.jZH;
                        al.af(b.this.jZI);
                    }
                    b.this.jZI.isStop = true;
                    b.this.jZI = null;
                    com.tencent.mm.plugin.report.service.h.pYm.a(664, 2, 1, false);
                }
                if (b.this.jZN != null) {
                    b.this.jZN.isStop = true;
                }
                AppMethodBeat.o(18592);
            }
        });
        AppMethodBeat.o(18601);
    }

    public final void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        AppMethodBeat.i(18602);
        ab.i("MicroMsg.CalcWxService", "%s CalcWxService Initialized", aZk());
        if (this.jZH == null) {
            ab.i("MicroMsg.CalcWxService", "%s init calc wx thread", aZk());
            this.jZH = new al("calc-wx");
        }
        this.jZF = t.a(hashCode(), g.RP().cachePath + "WxFileIndex.db", jZD, true);
        this.jZO.put(Integer.valueOf(43), new com.tencent.mm.plugin.f.a.e());
        this.jZO.put(Integer.valueOf(62), new com.tencent.mm.plugin.f.a.e());
        this.jZO.put(Integer.valueOf(44), new com.tencent.mm.plugin.f.a.e());
        this.jZO.put(Integer.valueOf(34), new f());
        this.jZO.put(Integer.valueOf(3), new com.tencent.mm.plugin.f.a.d());
        this.jZO.put(Integer.valueOf(49), new com.tencent.mm.plugin.f.a.c());
        this.jZO.put(Integer.valueOf(268435505), new com.tencent.mm.plugin.f.a.b());
        aZf();
        ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(this.jKo, null);
        com.tencent.mm.sdk.b.a.xxA.b(this.jZR);
        Context context = ah.getContext();
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            boolean z = intExtra == 2 || intExtra == 5;
            this.jZS = z;
        } else {
            this.jZS = false;
        }
        this.jZT = ((PowerManager) context.getSystemService("power")).isScreenOn();
        this.jZU = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(18580);
                String action = intent.getAction();
                boolean z = true;
                switch (action.hashCode()) {
                    case -2128145023:
                        if (action.equals("android.intent.action.SCREEN_OFF")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1886648615:
                        if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1454123155:
                        if (action.equals("android.intent.action.SCREEN_ON")) {
                            z = false;
                            break;
                        }
                        break;
                    case 1019184907:
                        if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        b.this.jZT = true;
                        break;
                    case true:
                        b.this.jZT = false;
                        break;
                    case true:
                        b.this.jZS = true;
                        break;
                    case true:
                        b.this.jZS = false;
                        break;
                }
                if (!b.this.jZS || b.this.jZT) {
                    if (b.this.jZV != null) {
                        aw.RS();
                        al.af(b.this.jZV);
                        b.this.jZV = null;
                    }
                    b.m(b.this);
                } else {
                    ab.i("MicroMsg.CalcWxService", "it is charging and screen off, 5 min to calc");
                    if (b.this.jZV == null) {
                        b.this.jZV = new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(18579);
                                b.this.aZe();
                                ab.i("MicroMsg.CalcWxService", "start to calc");
                                if (b.this.aZg()) {
                                    b bVar = b.this;
                                    if (bo.gb(((Long) g.RP().Ry().get(ac.a.USERINFO_CALC_WX_SCAN_REPORT_TIME_LONG, Long.valueOf(0))).longValue()) >= 259200000) {
                                        if (bVar.jZN != null) {
                                            bVar.jZN.isStop = true;
                                        }
                                        bVar.jZN = new com.tencent.mm.plugin.f.c.b();
                                        bVar.f(bVar.jZN);
                                        g.RP().Ry().set(ac.a.USERINFO_CALC_WX_SCAN_REPORT_TIME_LONG, Long.valueOf(bo.anU()));
                                    }
                                    AppMethodBeat.o(18579);
                                    return;
                                }
                                com.tencent.mm.plugin.report.service.h.pYm.a(664, 1, 1, false);
                                b.i(b.this);
                                AppMethodBeat.o(18579);
                            }
                        };
                        aw.RS().m(b.this.jZV, 300000);
                        AppMethodBeat.o(18580);
                        return;
                    }
                }
                AppMethodBeat.o(18580);
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        context.registerReceiver(this.jZU, intentFilter);
        com.tencent.mm.sdk.b.a.xxA.b(this.jZX);
        if (this.jZW) {
            com.tencent.mm.sdk.b.a.xxA.m(new bp());
        }
        AppMethodBeat.o(18602);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(18603);
        ab.i("MicroMsg.CalcWxService", "CalcWxService Release");
        this.jZJ.clear();
        this.jZK = false;
        if (this.jZF != null) {
            this.jZF.mJ(hashCode());
            this.jZF = null;
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(this.jKo);
        com.tencent.mm.sdk.b.a.xxA.d(this.jZR);
        this.jZO.clear();
        if (this.jZU != null) {
            ah.getContext().unregisterReceiver(this.jZU);
            this.jZU = null;
        }
        if (this.jZV != null) {
            aw.RS();
            al.af(this.jZV);
            this.jZV = null;
        }
        stopScan();
        if (this.jZH != null) {
            ab.i("MicroMsg.CalcWxService", "%s quit calc wx thread", aZk());
            this.jZH.oAl.quit();
        }
        this.jZH = null;
        com.tencent.mm.sdk.b.a.xxA.d(this.jZX);
        AppMethodBeat.o(18603);
    }

    public static long aZf() {
        AppMethodBeat.i(18604);
        long longValue = ((Long) g.RP().Ry().get(ac.a.USERINFO_CALC_WX_SCAN_MAX_MSGID2_LONG, Long.valueOf(-1))).longValue();
        if (longValue <= -1) {
            longValue = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Ry(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            g.RP().Ry().set(ac.a.USERINFO_CALC_WX_SCAN_MAX_MSGID2_LONG, Long.valueOf(longValue));
        }
        AppMethodBeat.o(18604);
        return longValue;
    }

    public final boolean aZg() {
        AppMethodBeat.i(18605);
        boolean z = aZi() >= aZf();
        ab.i("MicroMsg.CalcWxService", "%d scan finish [%d %d %b]", Integer.valueOf(hashCode()), Long.valueOf(aZf()), Long.valueOf(aZi()), Boolean.valueOf(z));
        if (z && ((Long) g.RP().Ry().get(ac.a.USERINFO_CALC_WX_SCAN_FINISH_TIME_LONG, Long.valueOf(0))).longValue() <= 0) {
            g.RP().Ry().set(ac.a.USERINFO_CALC_WX_SCAN_FINISH_TIME_LONG, Long.valueOf(bo.anT()));
        }
        AppMethodBeat.o(18605);
        return z;
    }

    public final void aZh() {
        AppMethodBeat.i(18606);
        this.jZK = false;
        this.jZJ.clear();
        ab.d("MicroMsg.CalcWxService", "%d unlock msg change [%s]", Integer.valueOf(hashCode()), bo.dpG());
        AppMethodBeat.o(18606);
    }

    public final void O(bi biVar) {
        AppMethodBeat.i(18607);
        if (biVar == null) {
            AppMethodBeat.o(18607);
            return;
        }
        try {
            com.tencent.mm.plugin.f.a.a aVar = (com.tencent.mm.plugin.f.a.a) this.jZO.get(Integer.valueOf(biVar.getType()));
            if (aVar != null) {
                aVar.P(biVar);
            }
            AppMethodBeat.o(18607);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.CalcWxService", e, "", new Object[0]);
            com.tencent.mm.plugin.report.service.h.pYm.a(664, 5, 1, false);
            AppMethodBeat.o(18607);
        }
    }

    public static void C(int i, long j) {
        int i2;
        int i3 = 30;
        AppMethodBeat.i(18608);
        if (j <= 1000) {
            i2 = i + 5;
        } else {
            i2 = i - 5;
        }
        if (i2 <= 30) {
            i3 = i2;
        }
        if (i3 < 5) {
            i3 = 5;
        }
        g.RP().Ry().set(ac.a.USERINFO_CALC_WX_SCAN_STEP_INT, Integer.valueOf(i3));
        com.tencent.mm.plugin.report.service.h.pYm.a(664, (long) ((Integer) com.tencent.mm.plugin.report.service.h.a(i3, new int[]{5, 10, 20, 25, 30}, 10, 15)).intValue(), 1, false);
        AppMethodBeat.o(18608);
    }

    public final void gS(long j) {
        AppMethodBeat.i(18609);
        ab.d("MicroMsg.CalcWxService", "%d update scan msgid[%d]", Integer.valueOf(hashCode()), Long.valueOf(j));
        g.RP().Ry().set(ac.a.USERINFO_CALC_WX_SCAN_CURR_MSGID2_LONG, Long.valueOf(j));
        AppMethodBeat.o(18609);
    }

    public static long aZi() {
        AppMethodBeat.i(18610);
        long longValue = ((Long) g.RP().Ry().get(ac.a.USERINFO_CALC_WX_SCAN_CURR_MSGID2_LONG, Long.valueOf(0))).longValue();
        AppMethodBeat.o(18610);
        return longValue;
    }

    public static int aZj() {
        AppMethodBeat.i(18611);
        int intValue = ((Integer) g.RP().Ry().get(ac.a.USERINFO_CALC_WX_SCAN_STEP_INT, Integer.valueOf(5))).intValue();
        AppMethodBeat.o(18611);
        return intValue;
    }

    public final String aZk() {
        AppMethodBeat.i(18612);
        String str = hashCode();
        AppMethodBeat.o(18612);
        return str;
    }

    static /* synthetic */ boolean e(b bVar) {
        return (bVar.jZL || !bVar.jZS || bVar.jZT) ? false : true;
    }

    static /* synthetic */ void i(b bVar) {
        AppMethodBeat.i(18614);
        bVar.f(new Runnable() {
            public final void run() {
                AppMethodBeat.i(18591);
                if (!b.e(b.this)) {
                    if (b.this.jZI != null) {
                        b.this.jZI.isStop = true;
                        b.this.jZI = null;
                    }
                    AppMethodBeat.o(18591);
                } else if (b.this.aZg()) {
                    com.tencent.mm.plugin.report.service.h.pYm.a(664, 3, 1, false);
                    AppMethodBeat.o(18591);
                } else if (b.this.jZI != null) {
                    AppMethodBeat.o(18591);
                } else {
                    b.this.jZI = new com.tencent.mm.plugin.f.c.c(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, b.aZi(), b.aZj(), b.this.jZQ);
                    b.this.jZH.m(b.this.jZI, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                    if (((Long) g.RP().Ry().get(ac.a.USERINFO_CALC_WX_SCAN_START_TIME_LONG, Long.valueOf(0))).longValue() <= 0) {
                        g.RP().Ry().set(ac.a.USERINFO_CALC_WX_SCAN_START_TIME_LONG, Long.valueOf(bo.anT()));
                    }
                    AppMethodBeat.o(18591);
                }
            }
        });
        AppMethodBeat.o(18614);
    }
}
