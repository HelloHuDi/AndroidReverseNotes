package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.ig;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.b;
import com.tencent.mm.protocal.protobuf.csw;
import com.tencent.mm.protocal.protobuf.csx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;

public final class r extends b implements k {
    private f eIc;
    private com.tencent.mm.ai.b fpJ;
    private csx fpM;

    public r(String str, int i, int i2) {
        AppMethodBeat.i(93740);
        this.Kg = str;
        this.gOW = i;
        this.tZt = i2;
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.NetSceneWeAppSuggest", "keyword is unavailable");
            AppMethodBeat.o(93740);
            return;
        }
        ab.i("MicroMsg.NetSceneWeAppSuggest", "Constructors: query = %s", str);
        a aVar = new a();
        aVar.fsI = 1173;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearchsuggestion";
        aVar.fsJ = new csw();
        aVar.fsK = new csx();
        this.fpJ = aVar.acD();
        csw csw = (csw) this.fpJ.fsG.fsP;
        csw.query = str;
        ig igVar = new ig();
        com.tencent.mm.sdk.b.a.xxA.m(igVar);
        csw.wCu = igVar.cDp.cDq;
        Object obj = g.RP().Ry().get(ac.a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_ID_STRING_SYNC, null);
        if (obj != null && (obj instanceof String)) {
            csw.xqg = (String) obj;
        }
        csw.wCy = b.fpD;
        csw.xqb = b.fpE;
        AppMethodBeat.o(93740);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(93741);
        ab.i("MicroMsg.NetSceneWeAppSuggest", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.fpM = (csx) this.fpJ.fsH.fsP;
            if (this.fpM != null) {
                ab.v("MicroMsg.NetSceneWeAppSuggest", "return data\n%s", this.fpM.vOy);
            }
            this.eIc.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(93741);
            return;
        }
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(93741);
    }

    public final int getType() {
        return 1173;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(93742);
        this.eIc = fVar;
        int a = a(eVar, this.fpJ, this);
        AppMethodBeat.o(93742);
        return a;
    }

    public final String abH() {
        return this.fpM != null ? this.fpM.vOy : "";
    }
}
