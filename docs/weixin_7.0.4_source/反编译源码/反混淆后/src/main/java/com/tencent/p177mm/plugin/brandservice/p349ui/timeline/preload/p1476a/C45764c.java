package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p1476a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.brandservice.C6808d;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C2711e;
import com.tencent.p177mm.plugin.webview.preload.C43924a;
import com.tencent.p177mm.protocal.protobuf.C15336et;
import com.tencent.p177mm.protocal.protobuf.C35916er;
import com.tencent.p177mm.protocal.protobuf.C7537es;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.XWalkCoreWrapper;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.c */
public final class C45764c {
    /* renamed from: FO */
    public static void m84585FO(String str) {
        AppMethodBeat.m2504i(14401);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.Preload.BizAppMsgReportMgr", "url is null, err");
            AppMethodBeat.m2505o(14401);
            return;
        }
        C35916er c35916er = new C35916er();
        c35916er.Url = str;
        C43924a.m78793kT(50);
        C43924a.m78793kT(56);
        C45764c.m84587a(c35916er, 0);
        AppMethodBeat.m2505o(14401);
    }

    /* renamed from: a */
    static void m84587a(final C35916er c35916er, final int i) {
        AppMethodBeat.m2504i(14402);
        C1226w.m2654a(C45764c.m84586a(c35916er).acD(), new C1224a() {
            /* renamed from: a */
            public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                AppMethodBeat.m2504i(14399);
                C4990ab.m7417i("MicroMsg.Preload.BizAppMsgReportMgr", "callback, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                C15336et c15336et = (C15336et) c7472b.fsH.fsP;
                if (i == 0 && i2 == 0 && c15336et != null) {
                    if (i > 0) {
                        C43924a.m78793kT(57);
                    }
                    C4990ab.m7417i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]url:%s", c35916er.Url);
                    C43924a.m78793kT(51);
                } else if (i2 != XWalkCoreWrapper.INVOKE_NOTITY_FUNCTION_ID_IDKEY) {
                    if (i > 0) {
                        C43924a.m78793kT(58);
                    }
                    C43924a.m78793kT(52);
                    if (C6808d.aVT().mo61566a(new C45763a(c35916er))) {
                        C4990ab.m7416i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]");
                    } else {
                        C4990ab.m7420w("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync], insert fail");
                    }
                } else if (i < 3) {
                    C45764c.m84587a(c35916er, i + 1);
                } else {
                    C43924a.m78793kT(52);
                    C43924a.m78793kT(59);
                    if (C6808d.aVT().mo61566a(new C45763a(c35916er))) {
                        C4990ab.m7416i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]");
                    } else {
                        C4990ab.m7420w("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync], insert fail");
                    }
                }
                AppMethodBeat.m2505o(14399);
                return 0;
            }
        });
        AppMethodBeat.m2505o(14402);
    }

    public static void aXs() {
        AppMethodBeat.m2504i(14403);
        Cursor query = C6808d.aVT().bSd.query("BizAppMsgReportContext", null, null, null, null, null, "reportTime DESC limit 50");
        final LinkedList linkedList = new LinkedList();
        while (query.moveToNext()) {
            C45763a c45763a = new C45763a();
            c45763a.mo8995d(query);
            linkedList.add(c45763a);
        }
        query.close();
        final LinkedList bb = C45764c.m84589bb(linkedList);
        if (bb.size() <= 0) {
            C6808d.aVT().mo61567ba(linkedList);
            C4990ab.m7420w("MicroMsg.Preload.BizAppMsgReportMgr", "list is null, return");
            AppMethodBeat.m2505o(14403);
            return;
        }
        C43924a.m78793kT(53);
        C1226w.m2654a(C45764c.m84588b(bb, 1).acD(), new C1224a() {
            /* renamed from: a */
            public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                AppMethodBeat.m2504i(14400);
                C4990ab.m7417i("MicroMsg.Preload.BizAppMsgReportMgr", "callback, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                C15336et c15336et = (C15336et) c7472b.fsH.fsP;
                if (i == 0 && i2 == 0 && c15336et != null) {
                    C4990ab.m7417i("MicroMsg.Preload.BizAppMsgReportMgr", "[report batch]reportList:%d", Integer.valueOf(bb.size()));
                    C43924a.m78793kT(54);
                    C6808d.aVT().mo61567ba(linkedList);
                } else {
                    C4990ab.m7413e("MicroMsg.Preload.BizAppMsgReportMgr", "[report batch]reportList:%d fail", Integer.valueOf(bb.size()));
                    C43924a.m78793kT(55);
                }
                AppMethodBeat.m2505o(14400);
                return 0;
            }
        });
        AppMethodBeat.m2505o(14403);
    }

    /* renamed from: bb */
    private static LinkedList<C35916er> m84589bb(List<C45763a> list) {
        AppMethodBeat.m2504i(14404);
        LinkedList linkedList = new LinkedList();
        if (list.size() > 0) {
            C4990ab.m7417i("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] list size:%d", Integer.valueOf(list.size()));
            for (C45763a c45763a : list) {
                if (C5046bo.isNullOrNil(c45763a.field_url)) {
                    C4990ab.m7420w("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] url is null, err");
                } else if (System.currentTimeMillis() - c45763a.field_reportTime >= C2711e.jQZ) {
                    C43924a.m78790e(908, 60, 1, true);
                } else {
                    C35916er c35916er = new C35916er();
                    c35916er.Url = c45763a.field_url;
                    c35916er.vGy = c45763a.field_reportTime;
                    linkedList.add(c35916er);
                    C4990ab.m7419v("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] url:%s reportTime:%d", c35916er.Url, Long.valueOf(c35916er.vGy));
                }
            }
        }
        AppMethodBeat.m2505o(14404);
        return linkedList;
    }

    /* renamed from: a */
    private static C1196a m84586a(C35916er c35916er) {
        AppMethodBeat.m2504i(14405);
        LinkedList linkedList = new LinkedList();
        linkedList.add(c35916er);
        C1196a b = C45764c.m84588b(linkedList, 0);
        AppMethodBeat.m2505o(14405);
        return b;
    }

    /* renamed from: b */
    private static C1196a m84588b(LinkedList<C35916er> linkedList, int i) {
        AppMethodBeat.m2504i(14406);
        C1196a c1196a = new C1196a();
        c1196a.fsI = 2998;
        c1196a.uri = "/cgi-bin/mmbiz-bin/appmsgreport";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        C7537es c7537es = new C7537es();
        c7537es.vGC = linkedList;
        c7537es.vGD = i;
        c1196a.fsJ = c7537es;
        c1196a.fsK = new C15336et();
        AppMethodBeat.m2505o(14406);
        return c1196a;
    }
}
