package com.tencent.mm.plugin.websearch.widget;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.ayr;
import com.tencent.mm.protocal.protobuf.ays;
import com.tencent.mm.protocal.protobuf.cvf;
import com.tencent.mm.protocal.protobuf.cxo;
import com.tencent.mm.protocal.protobuf.li;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c implements p {
    static /* synthetic */ List adU(String str) {
        AppMethodBeat.i(91434);
        List adT = adT(str);
        AppMethodBeat.o(91434);
        return adT;
    }

    public final void a(final String str, String str2, final o oVar) {
        int i = 1;
        AppMethodBeat.i(91432);
        if (!TextUtils.isEmpty(str)) {
            boolean equals;
            com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100440");
            if (ll.isValid()) {
                Map dru = ll.dru();
                String str3 = "WidgetLocalSearchService";
                String str4 = "switch conf is %s";
                Object[] objArr = new Object[1];
                objArr[0] = dru == null ? "" : dru.toString();
                ab.i(str3, str4, objArr);
                equals = "1".equals(dru.get("isOpen"));
            } else {
                equals = false;
            }
            if (equals) {
                a aVar = new a();
                aVar.fsI = 2782;
                aVar.uri = "/cgi-bin/mmux-bin/wxaapp/wxaapp_weappsearch_localdata";
                aVar.fsJ = new ayr();
                aVar.fsK = new ays();
                b acD = aVar.acD();
                ayr ayr = (ayr) acD.fsG.fsP;
                ayr.wCy = str2;
                ayr.wol = str;
                ayr.wCv = 0;
                ayr.wCu = aa.HV(0);
                cxo cxo = new cxo();
                cxo.xsT = true;
                cxo.xsP = ayr.wCu;
                cvf cvf = new cvf();
                cvf.xrk = new li();
                axy abJ = aa.abJ();
                if (abJ != null) {
                    li liVar = cvf.xrk;
                    if (d.agz().agC()) {
                        i = 0;
                    }
                    liVar.vOU = i;
                    ayr.wCw = (double) abJ.vRq;
                    ayr.wCx = (double) abJ.vRp;
                } else {
                    cvf.xrk.vOU = 1;
                    ayr.wCw = 0.0d;
                    ayr.wCx = 0.0d;
                }
                cvf.xrl = ((com.tencent.mm.plugin.appbrand.service.a) g.K(com.tencent.mm.plugin.appbrand.service.a.class)).auH();
                try {
                    ayr.wCz = new com.tencent.mm.bt.b(cvf.toByteArray());
                    ayr.wCA = new com.tencent.mm.bt.b(cxo.toByteArray());
                } catch (IOException e) {
                    ab.printErrStackTrace("WidgetLocalSearchService", e, "", new Object[0]);
                }
                w.a(acD, new w.a() {
                    public final int a(int i, int i2, String str, b bVar, m mVar) {
                        AppMethodBeat.i(91431);
                        String str2 = null;
                        if (i == 0 && i2 == 0) {
                            str2 = ((ays) bVar.fsH.fsP).vOy;
                        }
                        if (oVar != null) {
                            oVar.m(str, c.adU(str2));
                        }
                        AppMethodBeat.o(91431);
                        return 0;
                    }
                });
                AppMethodBeat.o(91432);
                return;
            }
        }
        if (oVar != null) {
            oVar.m(str, null);
        }
        AppMethodBeat.o(91432);
    }

    private static List<WidgetData> adT(String str) {
        AppMethodBeat.i(91433);
        if (TextUtils.isEmpty(str)) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.o(91433);
            return emptyList;
        }
        List<WidgetData> arrayList;
        try {
            arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str);
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            String optString = jSONObject.optString("searchID");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                arrayList = Collections.EMPTY_LIST;
                AppMethodBeat.o(91433);
                return arrayList;
            }
            jSONObject = optJSONArray.optJSONObject(0);
            if (jSONObject != null && jSONObject.has("items")) {
                optJSONArray = jSONObject.optJSONArray("items");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    WidgetData l = WidgetData.l(optJSONArray.optJSONObject(i), optString);
                    if (l != null) {
                        arrayList.add(l);
                    }
                }
            }
            AppMethodBeat.o(91433);
            return arrayList;
        } catch (JSONException e) {
            ab.printErrStackTrace("WidgetLocalSearchService", e, "", new Object[0]);
            arrayList = Collections.emptyList();
            AppMethodBeat.o(91433);
            return arrayList;
        }
    }
}
