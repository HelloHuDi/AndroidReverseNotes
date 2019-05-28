package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.r.r;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.b;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.protocal.protobuf.cvj;
import com.tencent.mm.protocal.protobuf.cvk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.LinkedList;
import org.json.JSONArray;

public final class e extends b implements k {
    private f ehi;
    private com.tencent.mm.ai.b fAT;
    s fpL;
    private cvk ufJ;

    public e(s sVar) {
        AppMethodBeat.i(5718);
        this.fpL = sVar;
        this.Kg = sVar.ctj;
        this.gOW = sVar.scene;
        this.tZt = sVar.cIv;
        if (bo.isNullOrNil(sVar.ctj)) {
            ab.e("MicroMsg.FTS.NetSceneWebSuggest", "keyword is unavailable");
            AppMethodBeat.o(5718);
            return;
        }
        ab.i("MicroMsg.FTS.NetSceneWebSuggest", "Constructors: query=%s", sVar.ctj);
        a aVar = new a();
        int i = (sVar.scene == 201 || sVar.tZI == 1) ? 1 : 0;
        if (i == 0 || !r.aNV()) {
            aVar.fsI = 1161;
            aVar.uri = "/cgi-bin/mmsearch-bin/searchsuggestion";
        } else {
            aVar.fsI = 1747;
            aVar.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_weappsuggestion";
        }
        aVar.fsJ = new cvj();
        aVar.fsK = new cvk();
        this.fAT = aVar.acD();
        cvj cvj = (cvj) this.fAT.fsG.fsP;
        cvj.wkD = sVar.ctj;
        cvj.vQd = (long) sVar.businessType;
        cvj.wCu = aa.HV(0);
        cvj.wUr = sVar.tZw;
        cvj.wDI = aa.abJ();
        cvj.Scene = sVar.scene;
        cvj.wCy = sVar.cvF;
        if (sVar.tZK != null) {
            try {
                cvj.wCz = new com.tencent.mm.bt.b(sVar.tZK.toByteArray());
            } catch (Exception e) {
            }
        }
        if (sVar.tZJ != null) {
            try {
                cvj.wCA = new com.tencent.mm.bt.b(sVar.tZJ.toByteArray());
            } catch (IOException e2) {
            }
        }
        try {
            JSONArray jSONArray = new JSONArray(sVar.tZB);
            cvj.xrr = new LinkedList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                cvj.xrr.add(URLDecoder.decode(jSONArray.getString(i2), "UTF-8"));
            }
        } catch (Exception e3) {
            ab.printErrStackTrace("MicroMsg.FTS.NetSceneWebSuggest", e3, "decode json error", new Object[0]);
        }
        String str = "MicroMsg.FTS.NetSceneWebSuggest";
        String str2 = "businessTypeList is %d | contains location = %b | scene=%d | businessType=%d | isHomePage=%b | webViewId=%d";
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(sVar.businessType);
        objArr[1] = Boolean.valueOf(cvj.wDI != null);
        objArr[2] = Integer.valueOf(sVar.scene);
        objArr[3] = Integer.valueOf(sVar.businessType);
        objArr[4] = Integer.valueOf(sVar.tZw);
        objArr[5] = Integer.valueOf(sVar.cIv);
        ab.i(str, str2, objArr);
        AppMethodBeat.o(5718);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(5719);
        ab.i("MicroMsg.FTS.NetSceneWebSuggest", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.ufJ = (cvk) this.fAT.fsH.fsP;
            if (this.ufJ != null) {
                ab.v("MicroMsg.FTS.NetSceneWebSuggest", "return data\n%s", this.ufJ.vOy);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(5719);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(5719);
    }

    public final int getType() {
        return 1161;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(5720);
        this.ehi = fVar;
        int a = a(eVar, this.fAT, this);
        AppMethodBeat.o(5720);
        return a;
    }

    public final String abH() {
        return this.ufJ != null ? this.ufJ.vOy : "";
    }
}
