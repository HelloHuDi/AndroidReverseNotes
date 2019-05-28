package com.tencent.p177mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.p328r.C27278r;
import com.tencent.p177mm.plugin.record.C34797b;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.webview.fts.C43869b.C43870g;
import com.tencent.p177mm.protocal.protobuf.axy;
import com.tencent.p177mm.protocal.protobuf.azw;
import com.tencent.p177mm.protocal.protobuf.cml;
import com.tencent.p177mm.protocal.protobuf.css;
import com.tencent.p177mm.protocal.protobuf.cst;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.fts.c */
public final class C40218c extends C1207m implements C1918k {
    public int cIv = -1;
    C7472b ehh;
    private C1202f ehi;
    private int ufH;
    public C43870g ufI;

    public C40218c(Map<String, Object> map, int i) {
        AppMethodBeat.m2504i(5711);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new css();
        c1196a.fsK = new cst();
        c1196a.uri = "/cgi-bin/mmux-bin/wxaapp/weappsearchguide";
        c1196a.fsI = 1866;
        this.ehh = c1196a.acD();
        this.ufH = i;
        axy abJ = C46400aa.abJ();
        css css = (css) this.ehh.fsG.fsP;
        if (abJ != null) {
            css.xpX = (double) abJ.vRq;
            css.xpY = (double) abJ.vRp;
        }
        css.xpZ = C46400aa.bVP();
        css.tZU = C27278r.aLE();
        css.cvF = C46400aa.m87342t(map, "statSessionId");
        css.scene = C46400aa.m87332d((Map) map, "scene", 0);
        String t = C46400aa.m87342t(map, "extReqParams");
        if (!C5046bo.isNullOrNil(t)) {
            try {
                JSONArray jSONArray = new JSONArray(t);
                css.xqa = new LinkedList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    cml cml = new cml();
                    cml.key = jSONObject.optString("key", "");
                    cml.waD = jSONObject.optLong("uintValue", 0);
                    cml.waE = jSONObject.optString("textValue", "");
                    css.xqa.push(cml);
                }
            } catch (Exception e) {
            }
        }
        C4990ab.m7417i("MicroMsg.NetSceneWeAppSearchGuide", "weappsearchguide req, version = %d, sessionId = %s, scene = %d, extParam = %s", Integer.valueOf(css.tZU), css.cvF, Integer.valueOf(css.scene), t);
        AppMethodBeat.m2505o(5711);
    }

    public final int getType() {
        return this.ehh.fsI;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(5712);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(5712);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(5713);
        C4990ab.m7417i("MicroMsg.NetSceneWeAppSearchGuide", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ufI = new C43870g((cst) this.ehh.fsH.fsP, this.ufH);
        C43870g c43870g = this.ufI;
        azw azw = new azw();
        azw.Scene = c43870g.scene;
        azw.vOy = c43870g.cBF;
        azw.wDF = c43870g.interval;
        azw.wDE = c43870g.ufA;
        azw.wDG = c43870g.ufH;
        byte[] bArr2 = null;
        try {
            bArr2 = azw.toByteArray();
        } catch (IOException e) {
        }
        if (bArr2 != null) {
            File file = new File(C34797b.m57159XZ(), C43870g.m78683Iv(c43870g.scene));
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            C1173e.m2559b(file.getAbsolutePath(), bArr2, bArr2.length);
            C4990ab.m7417i("MicroMsg.FTS.FTSWebViewLogic", "SearchGuideCacheObj saved, scene:%d", Integer.valueOf(c43870g.scene));
        } else {
            C4990ab.m7421w("MicroMsg.FTS.FTSWebViewLogic", "SearchGuideCacheObj toBytes fail, scene:%d!", Integer.valueOf(c43870g.scene));
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(5713);
    }
}
