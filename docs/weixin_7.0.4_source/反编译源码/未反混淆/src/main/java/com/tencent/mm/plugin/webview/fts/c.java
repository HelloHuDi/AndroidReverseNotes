package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.r.r;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.azw;
import com.tencent.mm.protocal.protobuf.cml;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends m implements k {
    public int cIv = -1;
    b ehh;
    private f ehi;
    private int ufH;
    public g ufI;

    public c(Map<String, Object> map, int i) {
        AppMethodBeat.i(5711);
        a aVar = new a();
        aVar.fsJ = new css();
        aVar.fsK = new cst();
        aVar.uri = "/cgi-bin/mmux-bin/wxaapp/weappsearchguide";
        aVar.fsI = 1866;
        this.ehh = aVar.acD();
        this.ufH = i;
        axy abJ = aa.abJ();
        css css = (css) this.ehh.fsG.fsP;
        if (abJ != null) {
            css.xpX = (double) abJ.vRq;
            css.xpY = (double) abJ.vRp;
        }
        css.xpZ = aa.bVP();
        css.tZU = r.aLE();
        css.cvF = aa.t(map, "statSessionId");
        css.scene = aa.d((Map) map, "scene", 0);
        String t = aa.t(map, "extReqParams");
        if (!bo.isNullOrNil(t)) {
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
        ab.i("MicroMsg.NetSceneWeAppSearchGuide", "weappsearchguide req, version = %d, sessionId = %s, scene = %d, extParam = %s", Integer.valueOf(css.tZU), css.cvF, Integer.valueOf(css.scene), t);
        AppMethodBeat.o(5711);
    }

    public final int getType() {
        return this.ehh.fsI;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(5712);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(5712);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(5713);
        ab.i("MicroMsg.NetSceneWeAppSearchGuide", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ufI = new g((cst) this.ehh.fsH.fsP, this.ufH);
        g gVar = this.ufI;
        azw azw = new azw();
        azw.Scene = gVar.scene;
        azw.vOy = gVar.cBF;
        azw.wDF = gVar.interval;
        azw.wDE = gVar.ufA;
        azw.wDG = gVar.ufH;
        byte[] bArr2 = null;
        try {
            bArr2 = azw.toByteArray();
        } catch (IOException e) {
        }
        if (bArr2 != null) {
            File file = new File(com.tencent.mm.plugin.record.b.XZ(), g.Iv(gVar.scene));
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            com.tencent.mm.a.e.b(file.getAbsolutePath(), bArr2, bArr2.length);
            ab.i("MicroMsg.FTS.FTSWebViewLogic", "SearchGuideCacheObj saved, scene:%d", Integer.valueOf(gVar.scene));
        } else {
            ab.w("MicroMsg.FTS.FTSWebViewLogic", "SearchGuideCacheObj toBytes fail, scene:%d!", Integer.valueOf(gVar.scene));
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(5713);
    }
}
