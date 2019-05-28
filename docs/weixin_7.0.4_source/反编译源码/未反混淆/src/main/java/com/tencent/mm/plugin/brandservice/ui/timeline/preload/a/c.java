package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.plugin.brandservice.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.e;
import com.tencent.mm.plugin.webview.preload.a;
import com.tencent.mm.protocal.protobuf.er;
import com.tencent.mm.protocal.protobuf.es;
import com.tencent.mm.protocal.protobuf.et;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.XWalkCoreWrapper;

public final class c {
    public static void FO(String str) {
        AppMethodBeat.i(14401);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.Preload.BizAppMsgReportMgr", "url is null, err");
            AppMethodBeat.o(14401);
            return;
        }
        er erVar = new er();
        erVar.Url = str;
        a.kT(50);
        a.kT(56);
        a(erVar, 0);
        AppMethodBeat.o(14401);
    }

    static void a(final er erVar, final int i) {
        AppMethodBeat.i(14402);
        w.a(a(erVar).acD(), new w.a() {
            public final int a(int i, int i2, String str, b bVar, m mVar) {
                AppMethodBeat.i(14399);
                ab.i("MicroMsg.Preload.BizAppMsgReportMgr", "callback, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                et etVar = (et) bVar.fsH.fsP;
                if (i == 0 && i2 == 0 && etVar != null) {
                    if (i > 0) {
                        a.kT(57);
                    }
                    ab.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]url:%s", erVar.Url);
                    a.kT(51);
                } else if (i2 != XWalkCoreWrapper.INVOKE_NOTITY_FUNCTION_ID_IDKEY) {
                    if (i > 0) {
                        a.kT(58);
                    }
                    a.kT(52);
                    if (d.aVT().a(new a(erVar))) {
                        ab.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]");
                    } else {
                        ab.w("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync], insert fail");
                    }
                } else if (i < 3) {
                    c.a(erVar, i + 1);
                } else {
                    a.kT(52);
                    a.kT(59);
                    if (d.aVT().a(new a(erVar))) {
                        ab.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync]");
                    } else {
                        ab.w("MicroMsg.Preload.BizAppMsgReportMgr", "[report sync], insert fail");
                    }
                }
                AppMethodBeat.o(14399);
                return 0;
            }
        });
        AppMethodBeat.o(14402);
    }

    public static void aXs() {
        AppMethodBeat.i(14403);
        Cursor query = d.aVT().bSd.query("BizAppMsgReportContext", null, null, null, null, null, "reportTime DESC limit 50");
        final LinkedList linkedList = new LinkedList();
        while (query.moveToNext()) {
            a aVar = new a();
            aVar.d(query);
            linkedList.add(aVar);
        }
        query.close();
        final LinkedList bb = bb(linkedList);
        if (bb.size() <= 0) {
            d.aVT().ba(linkedList);
            ab.w("MicroMsg.Preload.BizAppMsgReportMgr", "list is null, return");
            AppMethodBeat.o(14403);
            return;
        }
        a.kT(53);
        w.a(b(bb, 1).acD(), new w.a() {
            public final int a(int i, int i2, String str, b bVar, m mVar) {
                AppMethodBeat.i(14400);
                ab.i("MicroMsg.Preload.BizAppMsgReportMgr", "callback, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                et etVar = (et) bVar.fsH.fsP;
                if (i == 0 && i2 == 0 && etVar != null) {
                    ab.i("MicroMsg.Preload.BizAppMsgReportMgr", "[report batch]reportList:%d", Integer.valueOf(bb.size()));
                    a.kT(54);
                    d.aVT().ba(linkedList);
                } else {
                    ab.e("MicroMsg.Preload.BizAppMsgReportMgr", "[report batch]reportList:%d fail", Integer.valueOf(bb.size()));
                    a.kT(55);
                }
                AppMethodBeat.o(14400);
                return 0;
            }
        });
        AppMethodBeat.o(14403);
    }

    private static LinkedList<er> bb(List<a> list) {
        AppMethodBeat.i(14404);
        LinkedList linkedList = new LinkedList();
        if (list.size() > 0) {
            ab.i("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] list size:%d", Integer.valueOf(list.size()));
            for (a aVar : list) {
                if (bo.isNullOrNil(aVar.field_url)) {
                    ab.w("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] url is null, err");
                } else if (System.currentTimeMillis() - aVar.field_reportTime >= e.jQZ) {
                    a.e(908, 60, 1, true);
                } else {
                    er erVar = new er();
                    erVar.Url = aVar.field_url;
                    erVar.vGy = aVar.field_reportTime;
                    linkedList.add(erVar);
                    ab.v("MicroMsg.Preload.BizAppMsgReportMgr", "[processReportList] url:%s reportTime:%d", erVar.Url, Long.valueOf(erVar.vGy));
                }
            }
        }
        AppMethodBeat.o(14404);
        return linkedList;
    }

    private static b.a a(er erVar) {
        AppMethodBeat.i(14405);
        LinkedList linkedList = new LinkedList();
        linkedList.add(erVar);
        b.a b = b(linkedList, 0);
        AppMethodBeat.o(14405);
        return b;
    }

    private static b.a b(LinkedList<er> linkedList, int i) {
        AppMethodBeat.i(14406);
        b.a aVar = new b.a();
        aVar.fsI = 2998;
        aVar.uri = "/cgi-bin/mmbiz-bin/appmsgreport";
        aVar.fsL = 0;
        aVar.fsM = 0;
        es esVar = new es();
        esVar.vGC = linkedList;
        esVar.vGD = i;
        aVar.fsJ = esVar;
        aVar.fsK = new et();
        AppMethodBeat.o(14406);
        return aVar;
    }
}
