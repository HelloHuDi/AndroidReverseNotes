package com.tencent.p177mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.appbrand.p328r.C27278r;
import com.tencent.p177mm.plugin.websearch.api.C14425b;
import com.tencent.p177mm.plugin.websearch.api.C22760s;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.protocal.protobuf.cvj;
import com.tencent.p177mm.protocal.protobuf.cvk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.LinkedList;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.webview.fts.e */
public final class C43877e extends C14425b implements C1918k {
    private C1202f ehi;
    private C7472b fAT;
    C22760s fpL;
    private cvk ufJ;

    public C43877e(C22760s c22760s) {
        AppMethodBeat.m2504i(5718);
        this.fpL = c22760s;
        this.f2956Kg = c22760s.ctj;
        this.gOW = c22760s.scene;
        this.tZt = c22760s.cIv;
        if (C5046bo.isNullOrNil(c22760s.ctj)) {
            C4990ab.m7412e("MicroMsg.FTS.NetSceneWebSuggest", "keyword is unavailable");
            AppMethodBeat.m2505o(5718);
            return;
        }
        C4990ab.m7417i("MicroMsg.FTS.NetSceneWebSuggest", "Constructors: query=%s", c22760s.ctj);
        C1196a c1196a = new C1196a();
        int i = (c22760s.scene == 201 || c22760s.tZI == 1) ? 1 : 0;
        if (i == 0 || !C27278r.aNV()) {
            c1196a.fsI = 1161;
            c1196a.uri = "/cgi-bin/mmsearch-bin/searchsuggestion";
        } else {
            c1196a.fsI = 1747;
            c1196a.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_weappsuggestion";
        }
        c1196a.fsJ = new cvj();
        c1196a.fsK = new cvk();
        this.fAT = c1196a.acD();
        cvj cvj = (cvj) this.fAT.fsG.fsP;
        cvj.wkD = c22760s.ctj;
        cvj.vQd = (long) c22760s.businessType;
        cvj.wCu = C46400aa.m87305HV(0);
        cvj.wUr = c22760s.tZw;
        cvj.wDI = C46400aa.abJ();
        cvj.Scene = c22760s.scene;
        cvj.wCy = c22760s.cvF;
        if (c22760s.tZK != null) {
            try {
                cvj.wCz = new C1332b(c22760s.tZK.toByteArray());
            } catch (Exception e) {
            }
        }
        if (c22760s.tZJ != null) {
            try {
                cvj.wCA = new C1332b(c22760s.tZJ.toByteArray());
            } catch (IOException e2) {
            }
        }
        try {
            JSONArray jSONArray = new JSONArray(c22760s.tZB);
            cvj.xrr = new LinkedList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                cvj.xrr.add(URLDecoder.decode(jSONArray.getString(i2), "UTF-8"));
            }
        } catch (Exception e3) {
            C4990ab.printErrStackTrace("MicroMsg.FTS.NetSceneWebSuggest", e3, "decode json error", new Object[0]);
        }
        String str = "MicroMsg.FTS.NetSceneWebSuggest";
        String str2 = "businessTypeList is %d | contains location = %b | scene=%d | businessType=%d | isHomePage=%b | webViewId=%d";
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(c22760s.businessType);
        objArr[1] = Boolean.valueOf(cvj.wDI != null);
        objArr[2] = Integer.valueOf(c22760s.scene);
        objArr[3] = Integer.valueOf(c22760s.businessType);
        objArr[4] = Integer.valueOf(c22760s.tZw);
        objArr[5] = Integer.valueOf(c22760s.cIv);
        C4990ab.m7417i(str, str2, objArr);
        AppMethodBeat.m2505o(5718);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(5719);
        C4990ab.m7417i("MicroMsg.FTS.NetSceneWebSuggest", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.ufJ = (cvk) this.fAT.fsH.fsP;
            if (this.ufJ != null) {
                C4990ab.m7419v("MicroMsg.FTS.NetSceneWebSuggest", "return data\n%s", this.ufJ.vOy);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(5719);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(5719);
    }

    public final int getType() {
        return 1161;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(5720);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.fAT, this);
        AppMethodBeat.m2505o(5720);
        return a;
    }

    public final String abH() {
        return this.ufJ != null ? this.ufJ.vOy : "";
    }
}
