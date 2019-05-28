package com.tencent.mm.ax;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bn;

public final class c {
    public static boolean a(bm bmVar) {
        AppMethodBeat.i(78420);
        if (bmVar == null) {
            ab.e("MicroMsg.NewTipsManager", "check time, tipsInfo is null!!!");
            AppMethodBeat.o(78420);
            return false;
        }
        boolean z;
        long anT = bo.anT();
        if (bmVar.field_overdueTime == 0 && bmVar.field_disappearTime == 0) {
            z = true;
        } else {
            Long valueOf = Long.valueOf(Math.min(bmVar.field_beginShowTime + bmVar.field_overdueTime, bmVar.field_disappearTime));
            z = anT >= bmVar.field_beginShowTime && anT <= valueOf.longValue();
            if (anT > valueOf.longValue()) {
                ah.getContext().getSharedPreferences(ah.doA() + "_newtips_report", 0).edit().putLong("newtips_makeread_time", bo.anU()).commit();
            }
        }
        ab.i("MicroMsg.NewTipsManager", "timeEffective current: %s, overdueTime: %s, disappearTime: %s, show:%s", Long.valueOf(anT), Long.valueOf(bmVar.field_overdueTime), Long.valueOf(bmVar.field_disappearTime), Boolean.valueOf(z));
        AppMethodBeat.o(78420);
        return z;
    }

    public static boolean b(bm bmVar) {
        AppMethodBeat.i(78421);
        if (bmVar == null) {
            ab.e("MicroMsg.NewTipsManager", "check path, tipsInfo is null!!!");
            AppMethodBeat.o(78421);
            return false;
        }
        bm Ms = a.bVu().Ms(bmVar.field_tipId);
        if (!(Ms == null || Ms.field_tipsShowInfo == null || bmVar.field_tipsShowInfo == null)) {
            String str = Ms.field_tipsShowInfo.path;
            String str2 = bmVar.field_tipsShowInfo.path;
            if (!(str == null && str2 == null) && (str == null || !str.equals(str2))) {
                ab.i("MicroMsg.NewTipsManager", "path illegal, localPath:%s, newPath:%s", str, str2);
            } else {
                AppMethodBeat.o(78421);
                return true;
            }
        }
        AppMethodBeat.o(78421);
        return false;
    }

    public static boolean c(bm bmVar) {
        AppMethodBeat.i(78422);
        if (bmVar == null) {
            ab.e("MicroMsg.NewTipsManager", "check version, tipsInfo is null!!!");
            AppMethodBeat.o(78422);
            return false;
        }
        bm Ms = a.bVu().Ms(bmVar.field_tipId);
        if (Ms == null || (bmVar.field_tipVersion <= Ms.field_tipVersion && (bmVar.field_hadRead || bmVar.field_tipVersion != Ms.field_tipVersion))) {
            AppMethodBeat.o(78422);
            return false;
        }
        AppMethodBeat.o(78422);
        return true;
    }

    protected static boolean d(bm bmVar) {
        AppMethodBeat.i(78423);
        if (bmVar == null) {
            ab.e("MicroMsg.NewTipsManager", "can not show new  tips！！ tipsInfo is null !!");
            AppMethodBeat.o(78423);
            return false;
        } else if (bmVar.field_isExit && !bmVar.field_hadRead && a(bmVar)) {
            AppMethodBeat.o(78423);
            return true;
        } else {
            ab.i("MicroMsg.NewTipsManager", "can not show tips, isExit:%s, hadRead:%s, timeEffective:%s", Boolean.valueOf(bmVar.field_isExit), Boolean.valueOf(bmVar.field_hadRead), Boolean.valueOf(a(bmVar)));
            AppMethodBeat.o(78423);
            return false;
        }
    }

    public static boolean lQ(int i) {
        AppMethodBeat.i(78424);
        bm Ms = a.bVu().Ms(i);
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
            ab.e("MicroMsg.NewTipsManager", "showDot, newTipsInfo is null !!");
            AppMethodBeat.o(78424);
            return false;
        } else if (d(a.bVu().Ms(i)) && Ms.field_tipsShowInfo != null && Ms.field_tipsShowInfo.showType == b.fKL) {
            if (Ms == null) {
                ab.e("MicroMsg.NewTipsManager", "reportShowNewTips, newTipsInfo is null !!");
            } else {
                format = String.format("newtips_show_%d-%d", new Object[]{Integer.valueOf(Ms.field_tipId), Integer.valueOf(Ms.field_tipVersion)});
                if (!ah.getContext().getSharedPreferences(ah.doA() + "_newtips_report", 0).getBoolean(format, false)) {
                    int i5 = Ms.field_tipId;
                    i2 = Ms.field_tipVersion;
                    i3 = Ms.field_tipType;
                    j = ah.getContext().getSharedPreferences(ah.doA() + "_newtips_report", 0).getLong("newtips_gettipstime", 0);
                    ah.getContext().getSharedPreferences(ah.doA() + "_newtips_report", 0).edit().putLong("newtips_realshow_time", bo.anU()).commit();
                    i4 = Ms.field_tipsShowInfo != null ? Ms.field_tipsShowInfo.showType : 0;
                    str = Ms.field_tipsShowInfo != null ? Ms.field_tipsShowInfo.title : "";
                    str2 = Ms.field_tipsShowInfo != null ? Ms.field_tipsShowInfo.kKZ : "";
                    str3 = Ms.field_tipsShowInfo != null ? Ms.field_tipsShowInfo.path : "";
                    h.pYm.e(14995, Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), "", "", "", Long.valueOf(j2), "", "", "", Integer.valueOf(i4), str, str2, str3, "", Integer.valueOf(b.fKR), "");
                    ah.getContext().getSharedPreferences(ah.doA() + "_newtips_report", 0).edit().putBoolean(format, true).commit();
                }
            }
            AppMethodBeat.o(78424);
            return true;
        } else {
            if (Ms == null) {
                ab.e("MicroMsg.NewTipsManager", "reportDismissNewTips, newTipsInfo is null !!");
            } else {
                String format2 = String.format("newtips_dismiss_%d-%d", new Object[]{Integer.valueOf(Ms.field_tipId), Integer.valueOf(Ms.field_tipVersion)});
                if (!ah.getContext().getSharedPreferences(ah.doA() + "_newtips_report", 0).getBoolean(format2, false)) {
                    i2 = Ms.field_tipId;
                    i3 = Ms.field_tipVersion;
                    int i6 = Ms.field_tipType;
                    j = ah.getContext().getSharedPreferences(ah.doA() + "_newtips_report", 0).getLong("newtips_gettipstime", 0);
                    j2 = Ms.field_beginShowTime;
                    long j3 = Ms.field_overdueTime;
                    long j4 = Ms.field_disappearTime;
                    long j5 = ah.getContext().getSharedPreferences(ah.doA() + "_newtips_report", 0).getLong("newtips_makeread_time", 0) - ah.getContext().getSharedPreferences(ah.doA() + "_newtips_report", 0).getLong("newtips_realshow_time", 0);
                    i4 = 0;
                    long anT = bo.anT();
                    if (!b(Ms) || !c(Ms)) {
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
                    h.pYm.e(14995, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i6), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(r20), Long.valueOf(r22), Long.valueOf(j5), Integer.valueOf(i4), Integer.valueOf(i7), str2, str3, format, "", Integer.valueOf(b.fKS), Long.valueOf(j6));
                    if (i6 == b.fKC) {
                        bn bVu = a.bVu();
                        str = "delete from NewTipsInfo where tipId = " + Ms.field_tipId;
                        ab.i("MicroMsg.NewTipsInfoStorage", "delete sql: ".concat(String.valueOf(str)));
                        bVu.bSd.hY("NewTipsInfo", str);
                        bVu.b(Ms.field_tipId, 5, Integer.valueOf(Ms.field_tipId));
                    }
                    ah.getContext().getSharedPreferences(ah.doA() + "_newtips_report", 0).edit().putBoolean(format2, true).commit();
                }
            }
            AppMethodBeat.o(78424);
            return false;
        }
    }
}
