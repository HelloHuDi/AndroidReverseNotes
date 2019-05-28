package com.tencent.p177mm.plugin.game.luggage.p429b;

import android.content.Context;
import com.facebook.device.yearclass.YearClass;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.plugin.game.luggage.p432d.C12140e;
import com.tencent.p177mm.plugin.game.luggage.p432d.C16771f;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C46419bd;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.C43961e;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.C43961e.C22977a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.C43961e.C22978b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.C43962f;
import com.tencent.p177mm.plugin.wepkg.C30003c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.luggage.b.p */
public class C20972p extends C46419bd<C12140e> {

    /* renamed from: com.tencent.mm.plugin.game.luggage.b.p$1 */
    class C209731 implements Comparator<Integer> {
        C209731() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(135886);
            int compareTo = ((Integer) obj).compareTo((Integer) obj2);
            AppMethodBeat.m2505o(135886);
            return compareTo;
        }
    }

    public final String name() {
        return "reportGameWeb";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        AppMethodBeat.m2504i(135887);
        TreeMap treeMap = new TreeMap(new C209731());
        treeMap.put(Integer.valueOf(C22977a.uDu), ((C12140e) c32183a.bOZ).bDI());
        treeMap.put(Integer.valueOf(C22977a.uDv), C5023at.m7471gB(C4996ah.getContext()));
        treeMap.put(Integer.valueOf(C22977a.uDw), String.valueOf(YearClass.get(C4996ah.getContext())));
        try {
            treeMap.put(Integer.valueOf(C22977a.uDx), C18178q.encode(C5046bo.nullAsNil(((C12140e) c32183a.bOZ).cWL()), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
        }
        treeMap.put(Integer.valueOf(C22977a.uDy), Integer.valueOf(((C12140e) c32183a.bOZ).mo23964NQ(((C12140e) c32183a.bOZ).cWL()) ? 1 : 0));
        treeMap.put(Integer.valueOf(C22977a.uDz), Integer.valueOf(1));
        if (c32183a.bOZ instanceof C16771f) {
            treeMap.put(Integer.valueOf(C22977a.uDA), Integer.valueOf(1));
        } else {
            treeMap.put(Integer.valueOf(C22977a.uDA), Integer.valueOf(0));
        }
        treeMap.put(Integer.valueOf(C22977a.uDB), ((C12140e) c32183a.bOZ).bDH().dgj());
        Integer valueOf = Integer.valueOf(C22977a.uDC);
        ((C12140e) c32183a.bOZ).bDH();
        treeMap.put(valueOf, C30003c.dgk());
        JSONObject jSONObject = c32183a.bPa.bOf;
        String optString = jSONObject.optString("type");
        boolean equals = "1".equals(jSONObject.optString("isReportNow"));
        jSONObject = jSONObject.optJSONObject("data");
        if (jSONObject == null) {
            C4990ab.m7416i("MicroMsg.JsApiReportGameWeb", "data is null or not json");
            c32183a.mo52824a("data_is_null", null);
            AppMethodBeat.m2505o(135887);
        } else if ("1".equals(optString)) {
            treeMap.put(Integer.valueOf(C22978b.uDE), Boolean.valueOf(equals));
            Map aO = C43962f.m78895aO(jSONObject);
            for (Integer num : aO.keySet()) {
                if (!treeMap.containsKey(num)) {
                    treeMap.put(num, aO.get(num));
                }
            }
            C43962f.m78896y(((C12140e) c32183a.bOZ).cWL(), treeMap);
            c32183a.mo52824a("", null);
            AppMethodBeat.m2505o(135887);
        } else if ("2".equals(optString)) {
            Map aO2 = C43962f.m78895aO(jSONObject);
            for (Integer num2 : aO2.keySet()) {
                if (!treeMap.containsKey(num2)) {
                    treeMap.put(num2, aO2.get(num2));
                }
            }
            C4990ab.m7417i("MicroMsg.JsApiReportGameWeb", "report web runtime. isReportNow:%b, reportData: [%s]", Boolean.valueOf(equals), C43961e.m78892aI(treeMap));
            C7060h.pYm.mo8376a(16145, r0, equals, false);
            c32183a.mo52824a("", null);
            AppMethodBeat.m2505o(135887);
        } else {
            C4990ab.m7417i("MicroMsg.JsApiReportGameWeb", "type is error. type:%s", optString);
            c32183a.mo52824a("type_not_right", null);
            AppMethodBeat.m2505o(135887);
        }
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
