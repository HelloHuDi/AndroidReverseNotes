package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.facebook.device.yearclass.YearClass;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.game.luggage.d.e;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc;
import com.tencent.mm.plugin.webview.luggage.jsapi.bd;
import com.tencent.mm.plugin.webview.ui.tools.game.e.b;
import com.tencent.mm.plugin.wepkg.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

public class p extends bd<e> {
    public final String name() {
        return "reportGameWeb";
    }

    public final int biG() {
        return 0;
    }

    public final void b(a aVar) {
        AppMethodBeat.i(135887);
        TreeMap treeMap = new TreeMap(new Comparator<Integer>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                AppMethodBeat.i(135886);
                int compareTo = ((Integer) obj).compareTo((Integer) obj2);
                AppMethodBeat.o(135886);
                return compareTo;
            }
        });
        treeMap.put(Integer.valueOf(com.tencent.mm.plugin.webview.ui.tools.game.e.a.uDu), ((e) aVar.bOZ).bDI());
        treeMap.put(Integer.valueOf(com.tencent.mm.plugin.webview.ui.tools.game.e.a.uDv), at.gB(ah.getContext()));
        treeMap.put(Integer.valueOf(com.tencent.mm.plugin.webview.ui.tools.game.e.a.uDw), String.valueOf(YearClass.get(ah.getContext())));
        try {
            treeMap.put(Integer.valueOf(com.tencent.mm.plugin.webview.ui.tools.game.e.a.uDx), q.encode(bo.nullAsNil(((e) aVar.bOZ).cWL()), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
        }
        treeMap.put(Integer.valueOf(com.tencent.mm.plugin.webview.ui.tools.game.e.a.uDy), Integer.valueOf(((e) aVar.bOZ).NQ(((e) aVar.bOZ).cWL()) ? 1 : 0));
        treeMap.put(Integer.valueOf(com.tencent.mm.plugin.webview.ui.tools.game.e.a.uDz), Integer.valueOf(1));
        if (aVar.bOZ instanceof f) {
            treeMap.put(Integer.valueOf(com.tencent.mm.plugin.webview.ui.tools.game.e.a.uDA), Integer.valueOf(1));
        } else {
            treeMap.put(Integer.valueOf(com.tencent.mm.plugin.webview.ui.tools.game.e.a.uDA), Integer.valueOf(0));
        }
        treeMap.put(Integer.valueOf(com.tencent.mm.plugin.webview.ui.tools.game.e.a.uDB), ((e) aVar.bOZ).bDH().dgj());
        Integer valueOf = Integer.valueOf(com.tencent.mm.plugin.webview.ui.tools.game.e.a.uDC);
        ((e) aVar.bOZ).bDH();
        treeMap.put(valueOf, c.dgk());
        JSONObject jSONObject = aVar.bPa.bOf;
        String optString = jSONObject.optString("type");
        boolean equals = "1".equals(jSONObject.optString("isReportNow"));
        jSONObject = jSONObject.optJSONObject("data");
        if (jSONObject == null) {
            ab.i("MicroMsg.JsApiReportGameWeb", "data is null or not json");
            aVar.a("data_is_null", null);
            AppMethodBeat.o(135887);
        } else if ("1".equals(optString)) {
            treeMap.put(Integer.valueOf(b.uDE), Boolean.valueOf(equals));
            Map aO = com.tencent.mm.plugin.webview.ui.tools.game.f.aO(jSONObject);
            for (Integer num : aO.keySet()) {
                if (!treeMap.containsKey(num)) {
                    treeMap.put(num, aO.get(num));
                }
            }
            com.tencent.mm.plugin.webview.ui.tools.game.f.y(((e) aVar.bOZ).cWL(), treeMap);
            aVar.a("", null);
            AppMethodBeat.o(135887);
        } else if ("2".equals(optString)) {
            Map aO2 = com.tencent.mm.plugin.webview.ui.tools.game.f.aO(jSONObject);
            for (Integer num2 : aO2.keySet()) {
                if (!treeMap.containsKey(num2)) {
                    treeMap.put(num2, aO2.get(num2));
                }
            }
            ab.i("MicroMsg.JsApiReportGameWeb", "report web runtime. isReportNow:%b, reportData: [%s]", Boolean.valueOf(equals), com.tencent.mm.plugin.webview.ui.tools.game.e.aI(treeMap));
            h.pYm.a(16145, r0, equals, false);
            aVar.a("", null);
            AppMethodBeat.o(135887);
        } else {
            ab.i("MicroMsg.JsApiReportGameWeb", "type is error. type:%s", optString);
            aVar.a("type_not_right", null);
            AppMethodBeat.o(135887);
        }
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
