package com.tencent.p177mm.p199ax;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.p1140r.C16841a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C30297bn;
import com.tencent.p177mm.storage.C36001bm;

/* renamed from: com.tencent.mm.ax.c */
public final class C1301c {
    /* renamed from: a */
    public static boolean m2772a(C36001bm c36001bm) {
        AppMethodBeat.m2504i(78420);
        if (c36001bm == null) {
            C4990ab.m7412e("MicroMsg.NewTipsManager", "check time, tipsInfo is null!!!");
            AppMethodBeat.m2505o(78420);
            return false;
        }
        boolean z;
        long anT = C5046bo.anT();
        if (c36001bm.field_overdueTime == 0 && c36001bm.field_disappearTime == 0) {
            z = true;
        } else {
            Long valueOf = Long.valueOf(Math.min(c36001bm.field_beginShowTime + c36001bm.field_overdueTime, c36001bm.field_disappearTime));
            z = anT >= c36001bm.field_beginShowTime && anT <= valueOf.longValue();
            if (anT > valueOf.longValue()) {
                C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_newtips_report", 0).edit().putLong("newtips_makeread_time", C5046bo.anU()).commit();
            }
        }
        C4990ab.m7417i("MicroMsg.NewTipsManager", "timeEffective current: %s, overdueTime: %s, disappearTime: %s, show:%s", Long.valueOf(anT), Long.valueOf(c36001bm.field_overdueTime), Long.valueOf(c36001bm.field_disappearTime), Boolean.valueOf(z));
        AppMethodBeat.m2505o(78420);
        return z;
    }

    /* renamed from: b */
    public static boolean m2773b(C36001bm c36001bm) {
        AppMethodBeat.m2504i(78421);
        if (c36001bm == null) {
            C4990ab.m7412e("MicroMsg.NewTipsManager", "check path, tipsInfo is null!!!");
            AppMethodBeat.m2505o(78421);
            return false;
        }
        C36001bm Ms = C16841a.bVu().mo48500Ms(c36001bm.field_tipId);
        if (!(Ms == null || Ms.field_tipsShowInfo == null || c36001bm.field_tipsShowInfo == null)) {
            String str = Ms.field_tipsShowInfo.path;
            String str2 = c36001bm.field_tipsShowInfo.path;
            if (!(str == null && str2 == null) && (str == null || !str.equals(str2))) {
                C4990ab.m7417i("MicroMsg.NewTipsManager", "path illegal, localPath:%s, newPath:%s", str, str2);
            } else {
                AppMethodBeat.m2505o(78421);
                return true;
            }
        }
        AppMethodBeat.m2505o(78421);
        return false;
    }

    /* renamed from: c */
    public static boolean m2774c(C36001bm c36001bm) {
        AppMethodBeat.m2504i(78422);
        if (c36001bm == null) {
            C4990ab.m7412e("MicroMsg.NewTipsManager", "check version, tipsInfo is null!!!");
            AppMethodBeat.m2505o(78422);
            return false;
        }
        C36001bm Ms = C16841a.bVu().mo48500Ms(c36001bm.field_tipId);
        if (Ms == null || (c36001bm.field_tipVersion <= Ms.field_tipVersion && (c36001bm.field_hadRead || c36001bm.field_tipVersion != Ms.field_tipVersion))) {
            AppMethodBeat.m2505o(78422);
            return false;
        }
        AppMethodBeat.m2505o(78422);
        return true;
    }

    /* renamed from: d */
    protected static boolean m2775d(C36001bm c36001bm) {
        AppMethodBeat.m2504i(78423);
        if (c36001bm == null) {
            C4990ab.m7412e("MicroMsg.NewTipsManager", "can not show new  tips！！ tipsInfo is null !!");
            AppMethodBeat.m2505o(78423);
            return false;
        } else if (c36001bm.field_isExit && !c36001bm.field_hadRead && C1301c.m2772a(c36001bm)) {
            AppMethodBeat.m2505o(78423);
            return true;
        } else {
            C4990ab.m7417i("MicroMsg.NewTipsManager", "can not show tips, isExit:%s, hadRead:%s, timeEffective:%s", Boolean.valueOf(c36001bm.field_isExit), Boolean.valueOf(c36001bm.field_hadRead), Boolean.valueOf(C1301c.m2772a(c36001bm)));
            AppMethodBeat.m2505o(78423);
            return false;
        }
    }

    /* renamed from: lQ */
    public static boolean m2776lQ(int i) {
        AppMethodBeat.m2504i(78424);
        C36001bm Ms = C16841a.bVu().mo48500Ms(i);
        String format;
        int i2;
        int i3;
        long j;
        int i4;
        String str;
        String str2;
        String str3;
        long j2;
        if (Ms == null) {
            C4990ab.m7412e("MicroMsg.NewTipsManager", "showDot, newTipsInfo is null !!");
            AppMethodBeat.m2505o(78424);
            return false;
        } else if (C1301c.m2775d(C16841a.bVu().mo48500Ms(i)) && Ms.field_tipsShowInfo != null && Ms.field_tipsShowInfo.showType == C32321b.fKL) {
            if (Ms == null) {
                C4990ab.m7412e("MicroMsg.NewTipsManager", "reportShowNewTips, newTipsInfo is null !!");
            } else {
                format = String.format("newtips_show_%d-%d", new Object[]{Integer.valueOf(Ms.field_tipId), Integer.valueOf(Ms.field_tipVersion)});
                if (!C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_newtips_report", 0).getBoolean(format, false)) {
                    int i5 = Ms.field_tipId;
                    i2 = Ms.field_tipVersion;
                    i3 = Ms.field_tipType;
                    j = C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_newtips_report", 0).getLong("newtips_gettipstime", 0);
                    C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_newtips_report", 0).edit().putLong("newtips_realshow_time", C5046bo.anU()).commit();
                    i4 = Ms.field_tipsShowInfo != null ? Ms.field_tipsShowInfo.showType : 0;
                    str = Ms.field_tipsShowInfo != null ? Ms.field_tipsShowInfo.title : "";
                    str2 = Ms.field_tipsShowInfo != null ? Ms.field_tipsShowInfo.kKZ : "";
                    str3 = Ms.field_tipsShowInfo != null ? Ms.field_tipsShowInfo.path : "";
                    C7060h.pYm.mo8381e(14995, Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), "", "", "", Long.valueOf(j2), "", "", "", Integer.valueOf(i4), str, str2, str3, "", Integer.valueOf(C32321b.fKR), "");
                    C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_newtips_report", 0).edit().putBoolean(format, true).commit();
                }
            }
            AppMethodBeat.m2505o(78424);
            return true;
        } else {
            if (Ms == null) {
                C4990ab.m7412e("MicroMsg.NewTipsManager", "reportDismissNewTips, newTipsInfo is null !!");
            } else {
                String format2 = String.format("newtips_dismiss_%d-%d", new Object[]{Integer.valueOf(Ms.field_tipId), Integer.valueOf(Ms.field_tipVersion)});
                if (!C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_newtips_report", 0).getBoolean(format2, false)) {
                    i2 = Ms.field_tipId;
                    i3 = Ms.field_tipVersion;
                    int i6 = Ms.field_tipType;
                    j = C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_newtips_report", 0).getLong("newtips_gettipstime", 0);
                    j2 = Ms.field_beginShowTime;
                    long j3 = Ms.field_overdueTime;
                    long j4 = Ms.field_disappearTime;
                    long j5 = C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_newtips_report", 0).getLong("newtips_makeread_time", 0) - C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_newtips_report", 0).getLong("newtips_realshow_time", 0);
                    i4 = 0;
                    long anT = C5046bo.anT();
                    if (!C1301c.m2773b(Ms) || !C1301c.m2774c(Ms)) {
                        i4 = 1;
                    } else if (Ms.field_hadRead) {
                        i4 = 4;
                    } else if (Ms.field_disappearTime != 0 && anT > Ms.field_disappearTime) {
                        i4 = 3;
                    } else if (Ms.field_overdueTime != 0 && Ms.field_beginShowTime + Ms.field_overdueTime <= Ms.field_disappearTime && anT > Ms.field_beginShowTime + Ms.field_overdueTime) {
                        i4 = 2;
                    }
                    int i7 = Ms.field_tipsShowInfo != null ? Ms.field_tipsShowInfo.showType : 0;
                    str2 = Ms.field_tipsShowInfo != null ? Ms.field_tipsShowInfo.title : "";
                    str3 = Ms.field_tipsShowInfo != null ? Ms.field_tipsShowInfo.kKZ : "";
                    format = Ms.field_tipsShowInfo != null ? Ms.field_tipsShowInfo.path : "";
                    long j6 = Ms.field_pagestaytime;
                    C7060h.pYm.mo8381e(14995, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i6), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(r20), Long.valueOf(r22), Long.valueOf(j5), Integer.valueOf(i4), Integer.valueOf(i7), str2, str3, format, "", Integer.valueOf(C32321b.fKS), Long.valueOf(j6));
                    if (i6 == C32321b.fKC) {
                        C30297bn bVu = C16841a.bVu();
                        str = "delete from NewTipsInfo where tipId = " + Ms.field_tipId;
                        C4990ab.m7416i("MicroMsg.NewTipsInfoStorage", "delete sql: ".concat(String.valueOf(str)));
                        bVu.bSd.mo10108hY("NewTipsInfo", str);
                        bVu.mo15641b(Ms.field_tipId, 5, Integer.valueOf(Ms.field_tipId));
                    }
                    C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_newtips_report", 0).edit().putBoolean(format2, true).commit();
                }
            }
            AppMethodBeat.m2505o(78424);
            return false;
        }
    }
}
