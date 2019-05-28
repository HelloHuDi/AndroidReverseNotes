package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f.a;
import com.tencent.mm.ba.i;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;

public final class h {
    public static void run() {
        SharedPreferences sharedPreferences;
        Editor edit;
        int i;
        int i2;
        AppMethodBeat.i(15851);
        Context context = ah.getContext();
        AnonymousClass1 anonymousClass1 = new a() {
            public final void gj(int i) {
                AppMethodBeat.i(15850);
                ab.i("MicroMsg.PostTaskLightweightJob", "CrashStatus report: key %s ", Integer.valueOf(i));
                com.tencent.mm.plugin.report.service.h.pYm.a(25, (long) i, 1, false);
                AppMethodBeat.o(15850);
            }
        };
        if (context != null) {
            try {
                sharedPreferences = context.getSharedPreferences("crash_status_file", 4);
                String[] split = sharedPreferences.getString("crashlist", "").split(";");
                if (split != null && split.length > 0) {
                    edit = sharedPreferences.edit();
                    edit.putString("crashlist", "");
                    edit.commit();
                    for (i = 0; i < split.length; i++) {
                        String[] split2 = split[i] == null ? null : split[i].split(",");
                        if (split2 != null && split2.length >= 2) {
                            if (split2[1].equals("anr")) {
                                anonymousClass1.gj(10);
                            } else {
                                anonymousClass1.gj(11);
                                if ("com.tencent.mm".equals(split2[0])) {
                                    anonymousClass1.gj(14);
                                }
                                if ("com.tencent.mm:push".equals(split2[0])) {
                                    anonymousClass1.gj(17);
                                }
                                if ("com.tencent.mm:tools".equals(split2[0])) {
                                    anonymousClass1.gj(20);
                                }
                                if ("com.tencent.mm:toolsmp".equals(split2[0])) {
                                    anonymousClass1.gj(20);
                                }
                                if (split2[1].equals("java")) {
                                    anonymousClass1.gj(12);
                                    if ("com.tencent.mm".equals(split2[0])) {
                                        anonymousClass1.gj(15);
                                    }
                                    if ("com.tencent.mm:push".equals(split2[0])) {
                                        anonymousClass1.gj(18);
                                    }
                                    if ("com.tencent.mm:tools".equals(split2[0])) {
                                        anonymousClass1.gj(21);
                                    }
                                    if ("com.tencent.mm:toolsmp".equals(split2[0])) {
                                        anonymousClass1.gj(21);
                                    }
                                }
                                if (split2[1].equals("jni")) {
                                    anonymousClass1.gj(13);
                                    if ("com.tencent.mm".equals(split2[0])) {
                                        anonymousClass1.gj(16);
                                    }
                                    if ("com.tencent.mm:push".equals(split2[0])) {
                                        anonymousClass1.gj(19);
                                    }
                                    if ("com.tencent.mm:tools".equals(split2[0])) {
                                        anonymousClass1.gj(22);
                                    }
                                    if ("com.tencent.mm:toolsmp".equals(split2[0])) {
                                        anonymousClass1.gj(22);
                                    }
                                }
                                if (split2[1].equals("first")) {
                                    if ("com.tencent.mm".equals(split2[0])) {
                                        anonymousClass1.gj(23);
                                    }
                                    if ("com.tencent.mm:push".equals(split2[0])) {
                                        anonymousClass1.gj(24);
                                    }
                                    if ("com.tencent.mm:tools".equals(split2[0])) {
                                        anonymousClass1.gj(25);
                                    }
                                    if ("com.tencent.mm:toolsmp".equals(split2[0])) {
                                        anonymousClass1.gj(25);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
        context = ah.getContext();
        i = g.Nu().getInt("AndroidGooglePlayCrashUploadSizeLimit", 3072);
        if (context != null && i > 0) {
            try {
                sharedPreferences = context.getSharedPreferences("crash_status_file", 4);
                if (sharedPreferences.getInt("googleplaysizelimit", 3072) != i) {
                    edit = sharedPreferences.edit();
                    edit.putInt("googleplaysizelimit", i);
                    edit.commit();
                }
            } catch (Throwable th2) {
            }
        }
        aw.ZK();
        if (com.tencent.mm.platformtools.ah.gb(com.tencent.mm.platformtools.ah.d((Long) c.Ry().get(ac.a.USERINFO_REPORT_LAST_TIME_REPORT_DYNACFG_VER_LONG, null))) > 21600000) {
            com.tencent.mm.plugin.report.service.h.pYm.a(279, (long) (g.Nu().getInt("AndroidDynamicConfigVer", 0) % 16), 1, false);
            aw.ZK();
            c.Ry().set(ac.a.USERINFO_REPORT_LAST_TIME_REPORT_DYNACFG_VER_LONG, Long.valueOf(com.tencent.mm.platformtools.ah.anU()));
        }
        aw.ZK();
        if (com.tencent.mm.platformtools.ah.gb(com.tencent.mm.platformtools.ah.d((Long) c.Ry().get(ac.a.USERINFO_REPORT_LAST_TIME_REPORT_VIDEO_SEND_RECV_COUNT_LONG, null))) > 21600000) {
            aw.ZK();
            c.Ry().set(ac.a.USERINFO_REPORT_LAST_TIME_REPORT_VIDEO_SEND_RECV_COUNT_LONG, Long.valueOf(com.tencent.mm.platformtools.ah.anU()));
            t all = o.all();
            int[] iArr = new int[]{0, 0, 0, 0, 0, 0};
            try {
                ab.i("MicroMsg.VideoInfoStorage", "reportVideoMsgCount sql:%s", "select status, videofuncflag, human from videoinfo2 where lastmodifytime > ".concat(String.valueOf(bo.anT() - 21600)));
                Cursor a = all.fni.a(r2, null, 2);
                while (a.moveToNext()) {
                    i2 = a.getInt(0);
                    int i3 = a.getInt(1);
                    String string = a.getString(2);
                    if (111 == i2) {
                        if (i3 == 3) {
                            i2 = 0;
                        } else {
                            i2 = 3;
                        }
                        iArr[i2] = iArr[i2] + 1;
                    } else if (199 == i2) {
                        if (r.Yz().equals(string)) {
                            i2 = i3 == 3 ? 1 : 4;
                            iArr[i2] = iArr[i2] + 1;
                        } else {
                            i2 = i3 == 3 ? 2 : 5;
                            iArr[i2] = iArr[i2] + 1;
                        }
                    }
                }
                a.close();
                com.tencent.mm.plugin.report.service.h.pYm.e(12696, Integer.valueOf(10010), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(iArr[2]), Integer.valueOf(iArr[3]), Integer.valueOf(iArr[4]), Integer.valueOf(iArr[5]));
            } catch (Exception e) {
            }
        }
        if (bo.anU() - bo.a((Long) com.tencent.mm.kernel.g.RP().Ry().get(81939, null), 0) > 86400000) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            i iVar = new i();
        }
        long currentTimeMillis = System.currentTimeMillis();
        aw.ZK();
        boolean booleanValue = ((Boolean) c.Ry().get(233475, Boolean.FALSE)).booleanValue();
        aw.ZK();
        if (c.XM().dsw() <= 0) {
            if (!booleanValue) {
                aw.ZK();
                c.XR().aoX("officialaccounts");
                aw.ZK();
                c.Ry().set(233475, Boolean.TRUE);
            }
        } else if (booleanValue) {
            aw.ZK();
            c.Ry().set(233475, Boolean.FALSE);
        }
        com.tencent.mm.plugin.webwx.a.g.ddf().ddh().ddd();
        ab.i("MicroMsg.PostTaskLightweightJob", "use time %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(15851);
    }
}
