package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.IPackageStatsObserver.Stub;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.v4.app.Fragment;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.av;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.d.b;
import com.tencent.mm.model.d.c;
import com.tencent.mm.model.d.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.m;
import java.io.File;

public final class n {
    public static n ceT;
    public boolean ceU;
    public ak ceV = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(15385);
            super.handleMessage(message);
            LauncherUI instance;
            if (message.what == -1999) {
                if (!n.this.ceU) {
                    instance = LauncherUI.getInstance();
                    if (instance != null && instance.yjL) {
                        instance.yjJ.getMainTabUI().aqG("tab_main");
                        HomeUI homeUI = instance.getHomeUI();
                        if (homeUI.yiv) {
                            homeUI.yix = true;
                        }
                        f fVar = com.tencent.mm.plugin.sns.b.n.qFx;
                        if (fVar != null) {
                            fVar.cmm();
                        }
                        for (Fragment fragment : instance.yjJ.getMainTabUI().ynQ.values()) {
                            if (!(fragment instanceof MainUI)) {
                                ((m) fragment).dwh();
                            }
                        }
                    }
                    System.gc();
                    AppMethodBeat.o(15385);
                    return;
                }
            } else if (message.what == -2999) {
                if (n.this.ceU) {
                    AppMethodBeat.o(15385);
                    return;
                }
                instance = LauncherUI.getInstance();
                if (instance != null) {
                    MainTabUI mainTabUI = instance.yjJ.getMainTabUI();
                    if (mainTabUI.ynQ.containsKey(Integer.valueOf(0))) {
                        ((m) mainTabUI.ynQ.get(Integer.valueOf(0))).dwh();
                    }
                }
                if (g.RN().QY()) {
                    aw.ZE();
                    at oJ = bw.oJ("plugin.emoji");
                    if (oJ != null) {
                        oJ.iy(0);
                    }
                    a abr = b.abr();
                    a abl = com.tencent.mm.model.d.a.abl();
                    c abt = c.abt();
                    aw.RS().aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(16391);
                            File file = new File(b.fpk + "MMSQL.trace");
                            if (!file.exists()) {
                                ab.w("MicroMsg.SQLTraceManager", "SqlTrace file is not  exists");
                                AppMethodBeat.o(16391);
                            } else if (g.RN().QY()) {
                                long currentTimeMillis = System.currentTimeMillis();
                                long bO = b.bO(ah.getContext());
                                boolean z = false;
                                if (bO > currentTimeMillis) {
                                    z = true;
                                } else if (currentTimeMillis - bO > 86400000) {
                                    z = true;
                                } else if (currentTimeMillis - bO > b.this.fpr && b.this.foQ) {
                                    z = true;
                                }
                                ab.i("MicroMsg.SQLTraceManager", "check need upload ,file size is %d,time out  %b", Long.valueOf(file.length()), Boolean.valueOf(z));
                                if (z && r2 > b.this.fpq) {
                                    b bVar = b.this;
                                    Context context = ah.getContext();
                                    String packageName = ah.getContext().getPackageName();
                                    try {
                                        PackageManager.class.getMethod("getPackageSizeInfo", new Class[]{String.class, IPackageStatsObserver.class}).invoke(context.getPackageManager(), new Object[]{packageName, new Stub() {
                                            public final void onGetStatsCompleted(PackageStats packageStats, boolean z) {
                                                AppMethodBeat.i(16392);
                                                b.this.ceM[0] = packageStats.cacheSize;
                                                b.this.ceM[1] = packageStats.dataSize;
                                                b.this.ceM[2] = packageStats.codeSize;
                                                ab.i("MicroMsg.SQLTraceManager", "package cacheSize :%d ,dataSize :%d ,codeSize :%d ", Long.valueOf(packageStats.cacheSize), Long.valueOf(packageStats.dataSize), Long.valueOf(packageStats.codeSize));
                                                AppMethodBeat.o(16392);
                                            }
                                        }});
                                    } catch (Exception e) {
                                        bVar.ceM[0] = -1;
                                        bVar.ceM[1] = -1;
                                        bVar.ceM[2] = -1;
                                    }
                                    if (b.this.ceM[1] != 0 || b.this.foP > 1) {
                                        ab.i("MicroMsg.SQLTraceManager", "start file upload ,file length is %d ", Long.valueOf(file.length()));
                                        if (file.length() > b.this.fpp) {
                                            ab.e("MicroMsg.SQLTraceManager", "log file invaild format");
                                        } else {
                                            String ph = b.ph(b.fpk + "MMSQL.trace");
                                            ab.i("MicroMsg.SQLTraceManager", "read content success");
                                            b.this.pg(ph);
                                        }
                                        ab.i("MicroMsg.SQLTraceManager", "set last Upload Time %d ", Long.valueOf(System.currentTimeMillis()));
                                        b.a(b.this, file);
                                        b.this.foQ = false;
                                        b.this.foP = 0;
                                        b.c(ah.getContext(), System.currentTimeMillis());
                                        AppMethodBeat.o(16391);
                                        return;
                                    }
                                    ab.i("MicroMsg.SQLTraceManager", "wait for get packageStats");
                                    b.this.foP = 1 + b.this.foP;
                                }
                                AppMethodBeat.o(16391);
                            } else {
                                ab.w("MicroMsg.SQLTraceManager", "acc not ready ");
                                AppMethodBeat.o(16391);
                            }
                        }
                    });
                    d.xDH.ak(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(16376);
                            File file = new File(a.foO);
                            if (!file.exists()) {
                                ab.w("MicroMsg.HandlerTraceManager", "summer handler trace file is not exists");
                                AppMethodBeat.o(16376);
                            } else if (g.RN().QY()) {
                                long j = a.this.ehZ.getLong("handler_report_lastUploadTime", 0);
                                long currentTimeMillis = System.currentTimeMillis();
                                Object obj = (currentTimeMillis - j > a.this.foW || j > currentTimeMillis) ? 1 : null;
                                if (a.this.foQ && obj != null) {
                                    ab.i("MicroMsg.HandlerTraceManager", "summer check need upload ,file size is %d,time out %b", Long.valueOf(file.length()), Boolean.TRUE);
                                    a aVar = a.this;
                                    Context context = ah.getContext();
                                    String packageName = ah.getContext().getPackageName();
                                    try {
                                        PackageManager.class.getMethod("getPackageSizeInfo", new Class[]{String.class, IPackageStatsObserver.class}).invoke(context.getPackageManager(), new Object[]{packageName, new Stub() {
                                            public final void onGetStatsCompleted(PackageStats packageStats, boolean z) {
                                                AppMethodBeat.i(16378);
                                                a.this.ceM[0] = packageStats.cacheSize;
                                                a.this.ceM[1] = packageStats.dataSize;
                                                a.this.ceM[2] = packageStats.codeSize;
                                                ab.i("MicroMsg.HandlerTraceManager", "package cacheSize :%d ,dataSize :%d ,codeSize :%d ", Long.valueOf(packageStats.cacheSize), Long.valueOf(packageStats.dataSize), Long.valueOf(packageStats.codeSize));
                                                AppMethodBeat.o(16378);
                                            }
                                        }});
                                    } catch (Exception e) {
                                        aVar.ceM[0] = -1;
                                        aVar.ceM[1] = -1;
                                        aVar.ceM[2] = -1;
                                    }
                                    if (a.this.ceM[1] != 0 || a.this.foP > 1) {
                                        if (file.length() > a.this.foV) {
                                            ab.e("MicroMsg.HandlerTraceManager", "summer log file invaild format");
                                        } else {
                                            String pf = a.pf(a.foO);
                                            a aVar2 = a.this;
                                            Intent intent = new Intent();
                                            intent.setClassName(ah.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver");
                                            intent.setAction("uncatch_exception");
                                            intent.putExtra("exceptionPid", Process.myPid());
                                            String str = "userName";
                                            String T = av.fly.T("login_weixin_username", "");
                                            if (bo.isNullOrNil(T)) {
                                                T = av.fly.T("login_user_name", "never_login_crash");
                                            }
                                            intent.putExtra(str, T);
                                            intent.putExtra("tag", "handler");
                                            intent.putExtra("exceptionMsg", Base64.encodeToString((aVar2.abm() + pf).getBytes(), 2));
                                            ah.getContext().sendBroadcast(intent);
                                        }
                                        a.a(a.this, file);
                                        a.this.foQ = false;
                                        a.this.foP = 0;
                                        a.this.ehZ.edit().putLong("handler_report_lastUploadTime", System.currentTimeMillis()).commit();
                                        AppMethodBeat.o(16376);
                                        return;
                                    }
                                    a.this.foP = 1 + a.this.foP;
                                }
                                AppMethodBeat.o(16376);
                            } else {
                                ab.w("MicroMsg.HandlerTraceManager", "summer acc not ready ");
                                AppMethodBeat.o(16376);
                            }
                        }

                        public final String toString() {
                            AppMethodBeat.i(16377);
                            String str = super.toString() + "|checkAndUpload";
                            AppMethodBeat.o(16377);
                            return str;
                        }
                    });
                    abt.a(abr);
                    abt.a(abl);
                    aw.RS().aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(16417);
                            if (c.this.fpA) {
                                ab.i("MicroMsg.TraceConfigUpdater", "summer update isUpdating and ret");
                                AppMethodBeat.o(16417);
                                return;
                            }
                            long j = c.this.ehZ.getLong("trace_config_last_update_time", 0);
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - j > 86400000 || j > currentTimeMillis) {
                                c.c(c.this);
                                c.this.fpA = true;
                                aw.Rg().a((int) JsApiGetBackgroundAudioState.CTRL_INDEX, c.this);
                                aw.Rg().a(160, c.this);
                                aw.Rg().a(new k(21), 0);
                                AppMethodBeat.o(16417);
                                return;
                            }
                            ab.i("MicroMsg.TraceConfigUpdater", "summer last update time: " + j + " current time: " + currentTimeMillis + " in same day");
                            AppMethodBeat.o(16417);
                        }
                    });
                }
                System.gc();
            }
            AppMethodBeat.o(15385);
        }
    };

    public n() {
        AppMethodBeat.i(15386);
        AppMethodBeat.o(15386);
    }

    public static n Bw() {
        AppMethodBeat.i(15387);
        if (ceT == null) {
            ceT = new n();
        }
        n nVar = ceT;
        AppMethodBeat.o(15387);
        return nVar;
    }
}
