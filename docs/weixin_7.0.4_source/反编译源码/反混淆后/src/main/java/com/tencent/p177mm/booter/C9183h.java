package com.tencent.p177mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.app.C1255f.C1254a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p707ba.C32328i;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webwx.p1071a.C23163g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.booter.h */
public final class C9183h {

    /* renamed from: com.tencent.mm.booter.h$1 */
    static class C91841 implements C1254a {
        C91841() {
        }

        /* renamed from: gj */
        public final void mo4540gj(int i) {
            AppMethodBeat.m2504i(15850);
            C4990ab.m7417i("MicroMsg.PostTaskLightweightJob", "CrashStatus report: key %s ", Integer.valueOf(i));
            C7060h.pYm.mo8378a(25, (long) i, 1, false);
            AppMethodBeat.m2505o(15850);
        }
    }

    public static void run() {
        SharedPreferences sharedPreferences;
        Editor edit;
        int i;
        int i2;
        AppMethodBeat.m2504i(15851);
        Context context = C4996ah.getContext();
        C91841 c91841 = new C91841();
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
                                c91841.mo4540gj(10);
                            } else {
                                c91841.mo4540gj(11);
                                if ("com.tencent.mm".equals(split2[0])) {
                                    c91841.mo4540gj(14);
                                }
                                if ("com.tencent.mm:push".equals(split2[0])) {
                                    c91841.mo4540gj(17);
                                }
                                if ("com.tencent.mm:tools".equals(split2[0])) {
                                    c91841.mo4540gj(20);
                                }
                                if ("com.tencent.mm:toolsmp".equals(split2[0])) {
                                    c91841.mo4540gj(20);
                                }
                                if (split2[1].equals("java")) {
                                    c91841.mo4540gj(12);
                                    if ("com.tencent.mm".equals(split2[0])) {
                                        c91841.mo4540gj(15);
                                    }
                                    if ("com.tencent.mm:push".equals(split2[0])) {
                                        c91841.mo4540gj(18);
                                    }
                                    if ("com.tencent.mm:tools".equals(split2[0])) {
                                        c91841.mo4540gj(21);
                                    }
                                    if ("com.tencent.mm:toolsmp".equals(split2[0])) {
                                        c91841.mo4540gj(21);
                                    }
                                }
                                if (split2[1].equals("jni")) {
                                    c91841.mo4540gj(13);
                                    if ("com.tencent.mm".equals(split2[0])) {
                                        c91841.mo4540gj(16);
                                    }
                                    if ("com.tencent.mm:push".equals(split2[0])) {
                                        c91841.mo4540gj(19);
                                    }
                                    if ("com.tencent.mm:tools".equals(split2[0])) {
                                        c91841.mo4540gj(22);
                                    }
                                    if ("com.tencent.mm:toolsmp".equals(split2[0])) {
                                        c91841.mo4540gj(22);
                                    }
                                }
                                if (split2[1].equals("first")) {
                                    if ("com.tencent.mm".equals(split2[0])) {
                                        c91841.mo4540gj(23);
                                    }
                                    if ("com.tencent.mm:push".equals(split2[0])) {
                                        c91841.mo4540gj(24);
                                    }
                                    if ("com.tencent.mm:tools".equals(split2[0])) {
                                        c91841.mo4540gj(25);
                                    }
                                    if ("com.tencent.mm:toolsmp".equals(split2[0])) {
                                        c91841.mo4540gj(25);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
        context = C4996ah.getContext();
        i = C26373g.m41964Nu().getInt("AndroidGooglePlayCrashUploadSizeLimit", 3072);
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
        C9638aw.m17190ZK();
        if (C42252ah.m74623gb(C42252ah.m74617d((Long) C18628c.m29072Ry().get(C5127a.USERINFO_REPORT_LAST_TIME_REPORT_DYNACFG_VER_LONG, null))) > 21600000) {
            C7060h.pYm.mo8378a(279, (long) (C26373g.m41964Nu().getInt("AndroidDynamicConfigVer", 0) % 16), 1, false);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_REPORT_LAST_TIME_REPORT_DYNACFG_VER_LONG, Long.valueOf(C42252ah.anU()));
        }
        C9638aw.m17190ZK();
        if (C42252ah.m74623gb(C42252ah.m74617d((Long) C18628c.m29072Ry().get(C5127a.USERINFO_REPORT_LAST_TIME_REPORT_VIDEO_SEND_RECV_COUNT_LONG, null))) > 21600000) {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_REPORT_LAST_TIME_REPORT_VIDEO_SEND_RECV_COUNT_LONG, Long.valueOf(C42252ah.anU()));
            C9720t all = C37961o.all();
            int[] iArr = new int[]{0, 0, 0, 0, 0, 0};
            try {
                C4990ab.m7417i("MicroMsg.VideoInfoStorage", "reportVideoMsgCount sql:%s", "select status, videofuncflag, human from videoinfo2 where lastmodifytime > ".concat(String.valueOf(C5046bo.anT() - 21600)));
                Cursor a = all.fni.mo10104a(r2, null, 2);
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
                        if (C1853r.m3846Yz().equals(string)) {
                            i2 = i3 == 3 ? 1 : 4;
                            iArr[i2] = iArr[i2] + 1;
                        } else {
                            i2 = i3 == 3 ? 2 : 5;
                            iArr[i2] = iArr[i2] + 1;
                        }
                    }
                }
                a.close();
                C7060h.pYm.mo8381e(12696, Integer.valueOf(10010), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(iArr[2]), Integer.valueOf(iArr[3]), Integer.valueOf(iArr[4]), Integer.valueOf(iArr[5]));
            } catch (Exception e) {
            }
        }
        if (C5046bo.anU() - C5046bo.m7514a((Long) C1720g.m3536RP().mo5239Ry().get(81939, null), 0) > 86400000) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            C32328i c32328i = new C32328i();
        }
        long currentTimeMillis = System.currentTimeMillis();
        C9638aw.m17190ZK();
        boolean booleanValue = ((Boolean) C18628c.m29072Ry().get(233475, Boolean.FALSE)).booleanValue();
        C9638aw.m17190ZK();
        if (C18628c.m29078XM().dsw() <= 0) {
            if (!booleanValue) {
                C9638aw.m17190ZK();
                C18628c.m29083XR().aoX("officialaccounts");
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(233475, Boolean.TRUE);
            }
        } else if (booleanValue) {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(233475, Boolean.FALSE);
        }
        C23163g.ddf().ddh().ddd();
        C4990ab.m7417i("MicroMsg.PostTaskLightweightJob", "use time %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(15851);
    }
}
