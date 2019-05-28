package com.tencent.mm.plugin.webview.model;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afv;
import com.tencent.mm.protocal.protobuf.afw;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

public final class m extends com.tencent.mm.ai.m implements k {
    public b ehh;
    private f ehi;

    public m(String str, String str2, Map<String, Object> map) {
        AppMethodBeat.i(6601);
        a aVar = new a();
        aVar.fsJ = new afv();
        aVar.fsK = new afw();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizjsapiredirecturl";
        this.ehh = aVar.acD();
        afv afv = (afv) this.ehh.fsG.fsP;
        afv.wbO = str;
        afv.vOV = str2;
        afv.wmY = (String) map.get("groupId");
        afv.tyv = (String) map.get(Param.TIMESTAMP);
        afv.kmt = (String) map.get("nonceStr");
        afv.signature = (String) map.get("signature");
        afv.wmZ = map.get("params").toString();
        AppMethodBeat.o(6601);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(6602);
        ab.d("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(6602);
    }

    public final int getType() {
        return 1393;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(6603);
        this.ehi = fVar;
        ab.i("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(6603);
        return a;
    }

    public final afw cXw() {
        if (this.ehh == null || this.ehh.fsH.fsP == null) {
            return null;
        }
        return (afw) this.ehh.fsH.fsP;
    }
}
