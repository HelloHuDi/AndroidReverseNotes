package com.tencent.p177mm.p199ax;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p199ax.C6328d.C6329a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3472n;
import com.tencent.p177mm.plugin.p1140r.C16841a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.chg;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C36001bm;
import java.util.Map;

/* renamed from: com.tencent.mm.ax.e */
public final class C9061e implements C3472n {
    /* renamed from: a */
    public final C1198b mo7932a(String str, Map<String, String> map, C1197a c1197a) {
        AppMethodBeat.m2504i(78429);
        C4990ab.m7411d("dancy", "dancy consumeNewXml， subType:%s", str);
        if (C5046bo.nullAsNil(str).equals("newtips") && map != null) {
            C36001bm c36001bm;
            C16841a.bVt();
            if (map == null) {
                C4990ab.m7412e("MicroMsg.NewTipsManager", "parse newtips map fail! map is null!!");
                c36001bm = null;
            } else {
                Object obj;
                long anT = C5046bo.anT();
                C36001bm c36001bm2 = new C36001bm();
                c36001bm2.field_tipId = C5046bo.getInt((String) map.get(".sysmsg.newtips.control.tips_id"), 0);
                c36001bm2.field_tipVersion = C5046bo.getInt((String) map.get(".sysmsg.newtips.control.tips_version"), 0);
                c36001bm2.field_tipType = C5046bo.getInt((String) map.get(".sysmsg.newtips.control.tips_type"), 0);
                c36001bm2.field_beginShowTime = Math.max(C5046bo.getLong((String) map.get(".sysmsg.newtips.control.begin_time"), 0), anT);
                c36001bm2.field_overdueTime = C5046bo.getLong((String) map.get(".sysmsg.newtips.control.overdue_time"), 0);
                c36001bm2.field_disappearTime = C5046bo.getLong((String) map.get(".sysmsg.newtips.control.disappear_time"), 0);
                if (map.get(".sysmsg.newtips.control.tips_showInfo") != null) {
                    c36001bm2.field_tipsShowInfo = new chg();
                    c36001bm2.field_tipsShowInfo.showType = C5046bo.getInt((String) map.get(".sysmsg.newtips.control.tips_showInfo.show_type"), 0);
                    c36001bm2.field_tipsShowInfo.title = (String) map.get(".sysmsg.newtips.control.tips_showInfo.title");
                    c36001bm2.field_tipsShowInfo.kKZ = (String) map.get(".sysmsg.newtips.control.tips_showInfo.icon_url");
                    c36001bm2.field_tipsShowInfo.path = (String) map.get(".sysmsg.newtips.control.tips_showInfo.path");
                }
                c36001bm2.field_extInfo = (String) map.get(".sysmsg.newtips.control.tips_showInfo.");
                C16841a.bVu().mo48500Ms(c36001bm2.field_tipId);
                C16841a.bVv();
                if (C1301c.m2772a(c36001bm2) && C1301c.m2773b(c36001bm2) && C1301c.m2774c(c36001bm2) && !c36001bm2.field_isReject) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    c36001bm2.field_isExit = true;
                    C16841a.bVu().mo48501a(c36001bm2, new String[0]);
                }
                c36001bm = c36001bm2;
            }
            if (c36001bm != null) {
                int i;
                int i2 = c36001bm.field_tipId;
                int i3 = c36001bm.field_tipVersion;
                int i4 = c36001bm.field_tipType;
                C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_newtips_report", 0).edit().putLong("newtips_gettipstime", C5046bo.anU()).commit();
                int i5 = c36001bm.field_tipsShowInfo != null ? c36001bm.field_tipsShowInfo.showType : 0;
                String str2 = c36001bm.field_tipsShowInfo != null ? c36001bm.field_tipsShowInfo.title : "";
                String str3 = c36001bm.field_tipsShowInfo != null ? c36001bm.field_tipsShowInfo.kKZ : "";
                String str4 = c36001bm.field_tipsShowInfo != null ? c36001bm.field_tipsShowInfo.path : "";
                C16841a.bVv();
                if (!C1301c.m2773b(c36001bm)) {
                    i = 2;
                } else if (!C1301c.m2774c(c36001bm)) {
                    i = 3;
                } else if (C1301c.m2772a(c36001bm)) {
                    Object obj2;
                    C36001bm Ms = C16841a.bVu().mo48500Ms(c36001bm.field_tipId);
                    if (Ms == null || c36001bm.field_tipType != Ms.field_tipType) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (obj2 == null) {
                        i = 5;
                    } else {
                        if (C16841a.bVu().mo48500Ms(c36001bm.field_tipId) != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if (obj2 == null) {
                            i = 6;
                        } else if (c36001bm.field_isReject) {
                            i = 7;
                        } else {
                            i = 0;
                        }
                    }
                } else {
                    i = 4;
                }
                C7060h.pYm.mo8381e(14995, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(r12), "", "", "", "", "", "", "", Integer.valueOf(i5), str2, str3, str4, Integer.valueOf(i), Integer.valueOf(C32321b.fKQ), "");
                C6329a c6329a = C16841a.bVt().fKT;
                if (c6329a != null) {
                    C16841a.bVv();
                    if (C1301c.m2775d(c36001bm)) {
                        C4990ab.m7411d("dancy", "dancy consumeNewXml notifyShowNewTips isExit: %s, begintime: %s", Boolean.valueOf(c36001bm.field_isExit), Long.valueOf(c36001bm.field_beginShowTime));
                        c6329a.mo14568e(c36001bm);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(78429);
        return null;
    }
}
