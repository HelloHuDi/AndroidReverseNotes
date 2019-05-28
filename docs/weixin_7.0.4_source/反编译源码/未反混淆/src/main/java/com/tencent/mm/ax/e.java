package com.tencent.mm.ax;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bm;
import java.util.Map;

public final class e implements n {
    public final b a(String str, Map<String, String> map, a aVar) {
        AppMethodBeat.i(78429);
        ab.d("dancy", "dancy consumeNewXml， subType:%s", str);
        if (bo.nullAsNil(str).equals("newtips") && map != null) {
            bm bmVar;
            com.tencent.mm.plugin.r.a.bVt();
            if (map == null) {
                ab.e("MicroMsg.NewTipsManager", "parse newtips map fail! map is null!!");
                bmVar = null;
            } else {
                Object obj;
                long anT = bo.anT();
                bm bmVar2 = new bm();
                bmVar2.field_tipId = bo.getInt((String) map.get(".sysmsg.newtips.control.tips_id"), 0);
                bmVar2.field_tipVersion = bo.getInt((String) map.get(".sysmsg.newtips.control.tips_version"), 0);
                bmVar2.field_tipType = bo.getInt((String) map.get(".sysmsg.newtips.control.tips_type"), 0);
                bmVar2.field_beginShowTime = Math.max(bo.getLong((String) map.get(".sysmsg.newtips.control.begin_time"), 0), anT);
                bmVar2.field_overdueTime = bo.getLong((String) map.get(".sysmsg.newtips.control.overdue_time"), 0);
                bmVar2.field_disappearTime = bo.getLong((String) map.get(".sysmsg.newtips.control.disappear_time"), 0);
                if (map.get(".sysmsg.newtips.control.tips_showInfo") != null) {
                    bmVar2.field_tipsShowInfo = new chg();
                    bmVar2.field_tipsShowInfo.showType = bo.getInt((String) map.get(".sysmsg.newtips.control.tips_showInfo.show_type"), 0);
                    bmVar2.field_tipsShowInfo.title = (String) map.get(".sysmsg.newtips.control.tips_showInfo.title");
                    bmVar2.field_tipsShowInfo.kKZ = (String) map.get(".sysmsg.newtips.control.tips_showInfo.icon_url");
                    bmVar2.field_tipsShowInfo.path = (String) map.get(".sysmsg.newtips.control.tips_showInfo.path");
                }
                bmVar2.field_extInfo = (String) map.get(".sysmsg.newtips.control.tips_showInfo.");
                com.tencent.mm.plugin.r.a.bVu().Ms(bmVar2.field_tipId);
                com.tencent.mm.plugin.r.a.bVv();
                if (c.a(bmVar2) && c.b(bmVar2) && c.c(bmVar2) && !bmVar2.field_isReject) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    bmVar2.field_isExit = true;
                    com.tencent.mm.plugin.r.a.bVu().a(bmVar2, new String[0]);
                }
                bmVar = bmVar2;
            }
            if (bmVar != null) {
                int i;
                int i2 = bmVar.field_tipId;
                int i3 = bmVar.field_tipVersion;
                int i4 = bmVar.field_tipType;
                ah.getContext().getSharedPreferences(ah.doA() + "_newtips_report", 0).edit().putLong("newtips_gettipstime", bo.anU()).commit();
                int i5 = bmVar.field_tipsShowInfo != null ? bmVar.field_tipsShowInfo.showType : 0;
                String str2 = bmVar.field_tipsShowInfo != null ? bmVar.field_tipsShowInfo.title : "";
                String str3 = bmVar.field_tipsShowInfo != null ? bmVar.field_tipsShowInfo.kKZ : "";
                String str4 = bmVar.field_tipsShowInfo != null ? bmVar.field_tipsShowInfo.path : "";
                com.tencent.mm.plugin.r.a.bVv();
                if (!c.b(bmVar)) {
                    i = 2;
                } else if (!c.c(bmVar)) {
                    i = 3;
                } else if (c.a(bmVar)) {
                    Object obj2;
                    bm Ms = com.tencent.mm.plugin.r.a.bVu().Ms(bmVar.field_tipId);
                    if (Ms == null || bmVar.field_tipType != Ms.field_tipType) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (obj2 == null) {
                        i = 5;
                    } else {
                        if (com.tencent.mm.plugin.r.a.bVu().Ms(bmVar.field_tipId) != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if (obj2 == null) {
                            i = 6;
                        } else if (bmVar.field_isReject) {
                            i = 7;
                        } else {
                            i = 0;
                        }
                    }
                } else {
                    i = 4;
                }
                h.pYm.e(14995, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(r12), "", "", "", "", "", "", "", Integer.valueOf(i5), str2, str3, str4, Integer.valueOf(i), Integer.valueOf(b.fKQ), "");
                d.a aVar2 = com.tencent.mm.plugin.r.a.bVt().fKT;
                if (aVar2 != null) {
                    com.tencent.mm.plugin.r.a.bVv();
                    if (c.d(bmVar)) {
                        ab.d("dancy", "dancy consumeNewXml notifyShowNewTips isExit: %s, begintime: %s", Boolean.valueOf(bmVar.field_isExit), Long.valueOf(bmVar.field_beginShowTime));
                        aVar2.e(bmVar);
                    }
                }
            }
        }
        AppMethodBeat.o(78429);
        return null;
    }
}
