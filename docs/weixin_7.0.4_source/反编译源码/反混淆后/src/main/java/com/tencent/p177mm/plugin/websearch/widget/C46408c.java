package com.tencent.p177mm.plugin.websearch.widget;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.appbrand.service.C27297a;
import com.tencent.p177mm.plugin.websearch.api.C22758p;
import com.tencent.p177mm.plugin.websearch.api.C43853o;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.websearch.api.WidgetData;
import com.tencent.p177mm.protocal.protobuf.C35933li;
import com.tencent.p177mm.protocal.protobuf.axy;
import com.tencent.p177mm.protocal.protobuf.ayr;
import com.tencent.p177mm.protocal.protobuf.ays;
import com.tencent.p177mm.protocal.protobuf.cvf;
import com.tencent.p177mm.protocal.protobuf.cxo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5141c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.websearch.widget.c */
public final class C46408c implements C22758p {
    static /* synthetic */ List adU(String str) {
        AppMethodBeat.m2504i(91434);
        List adT = C46408c.adT(str);
        AppMethodBeat.m2505o(91434);
        return adT;
    }

    /* renamed from: a */
    public final void mo38341a(final String str, String str2, final C43853o c43853o) {
        int i = 1;
        AppMethodBeat.m2504i(91432);
        if (!TextUtils.isEmpty(str)) {
            boolean equals;
            C5141c ll = C18624c.abi().mo17131ll("100440");
            if (ll.isValid()) {
                Map dru = ll.dru();
                String str3 = "WidgetLocalSearchService";
                String str4 = "switch conf is %s";
                Object[] objArr = new Object[1];
                objArr[0] = dru == null ? "" : dru.toString();
                C4990ab.m7417i(str3, str4, objArr);
                equals = "1".equals(dru.get("isOpen"));
            } else {
                equals = false;
            }
            if (equals) {
                C1196a c1196a = new C1196a();
                c1196a.fsI = 2782;
                c1196a.uri = "/cgi-bin/mmux-bin/wxaapp/wxaapp_weappsearch_localdata";
                c1196a.fsJ = new ayr();
                c1196a.fsK = new ays();
                C7472b acD = c1196a.acD();
                ayr ayr = (ayr) acD.fsG.fsP;
                ayr.wCy = str2;
                ayr.wol = str;
                ayr.wCv = 0;
                ayr.wCu = C46400aa.m87305HV(0);
                cxo cxo = new cxo();
                cxo.xsT = true;
                cxo.xsP = ayr.wCu;
                cvf cvf = new cvf();
                cvf.xrk = new C35933li();
                axy abJ = C46400aa.abJ();
                if (abJ != null) {
                    C35933li c35933li = cvf.xrk;
                    if (C26443d.agz().agC()) {
                        i = 0;
                    }
                    c35933li.vOU = i;
                    ayr.wCw = (double) abJ.vRq;
                    ayr.wCx = (double) abJ.vRp;
                } else {
                    cvf.xrk.vOU = 1;
                    ayr.wCw = 0.0d;
                    ayr.wCx = 0.0d;
                }
                cvf.xrl = ((C27297a) C1720g.m3528K(C27297a.class)).auH();
                try {
                    ayr.wCz = new C1332b(cvf.toByteArray());
                    ayr.wCA = new C1332b(cxo.toByteArray());
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("WidgetLocalSearchService", e, "", new Object[0]);
                }
                C1226w.m2654a(acD, new C1224a() {
                    /* renamed from: a */
                    public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                        AppMethodBeat.m2504i(91431);
                        String str2 = null;
                        if (i == 0 && i2 == 0) {
                            str2 = ((ays) c7472b.fsH.fsP).vOy;
                        }
                        if (c43853o != null) {
                            c43853o.mo7485m(str, C46408c.adU(str2));
                        }
                        AppMethodBeat.m2505o(91431);
                        return 0;
                    }
                });
                AppMethodBeat.m2505o(91432);
                return;
            }
        }
        if (c43853o != null) {
            c43853o.mo7485m(str, null);
        }
        AppMethodBeat.m2505o(91432);
    }

    private static List<WidgetData> adT(String str) {
        AppMethodBeat.m2504i(91433);
        if (TextUtils.isEmpty(str)) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.m2505o(91433);
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
                AppMethodBeat.m2505o(91433);
                return arrayList;
            }
            jSONObject = optJSONArray.optJSONObject(0);
            if (jSONObject != null && jSONObject.has("items")) {
                optJSONArray = jSONObject.optJSONArray("items");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    WidgetData l = WidgetData.m47141l(optJSONArray.optJSONObject(i), optString);
                    if (l != null) {
                        arrayList.add(l);
                    }
                }
            }
            AppMethodBeat.m2505o(91433);
            return arrayList;
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("WidgetLocalSearchService", e, "", new Object[0]);
            arrayList = Collections.emptyList();
            AppMethodBeat.m2505o(91433);
            return arrayList;
        }
    }
}
