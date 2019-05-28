package com.tencent.mm.modelgeo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ady;
import com.tencent.mm.protocal.protobuf.adz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e extends m implements k {
    private String cBF = "";
    public final b ehh;
    private f ehi;

    public e(double d, double d2) {
        AppMethodBeat.i(78144);
        a aVar = new a();
        aVar.fsJ = new ady();
        aVar.fsK = new adz();
        aVar.uri = "/cgi-bin/micromsg-bin/getaddress";
        aVar.fsI = 655;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ady ady = (ady) this.ehh.fsG.fsP;
        ady.vNI = d;
        ady.vNH = d2;
        AppMethodBeat.o(78144);
    }

    public final int getType() {
        return 655;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(78145);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78145);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78146);
        ab.d("MicroMsg.NetSceneGetAddress", "onGYNetEnd errType %d errCode%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            this.cBF = ((adz) ((b) qVar).fsH.fsP).wlX;
            ab.d("MicroMsg.NetSceneGetAddress", this.cBF);
            if (this.ehi != null) {
                this.ehi.onSceneEnd(i2, i3, str, this);
            }
            AppMethodBeat.o(78146);
            return;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(78146);
    }

    public final Addr agD() {
        AppMethodBeat.i(78147);
        if (bo.isNullOrNil(this.cBF)) {
            AppMethodBeat.o(78147);
            return null;
        }
        Addr addr = new Addr();
        try {
            ab.d("MicroMsg.NetSceneGetAddress", "tofutest retJson: %s", this.cBF);
            JSONObject jSONObject = new JSONObject(this.cBF);
            addr.fBq = jSONObject.optString("request_id");
            JSONArray jSONArray = jSONObject.getJSONArray("results");
            addr.fBg = jSONArray.getJSONObject(1).getString("address_name");
            JSONObject jSONObject2 = jSONArray.getJSONObject(0);
            addr.fBh = jSONObject2.getString("p");
            addr.fBi = jSONObject2.getString("c");
            addr.fBk = jSONObject2.getString("d");
            addr.fBl = "";
            addr.fBm = "";
            addr.fBn = "";
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString("dtype");
                    if ("ST".equals(string)) {
                        addr.fBm = jSONObject2.getString("name");
                    } else if ("ST_NO".equals(string)) {
                        addr.fBn = jSONObject2.getString("name");
                    }
                    if ("FORMAT_ADDRESS".equals(string)) {
                        addr.fBo = jSONObject2.getString("rough_address_name");
                    }
                } catch (Exception e) {
                }
            }
            if (!bo.isNullOrNil(addr.fBn)) {
                addr.fBm = "";
            }
            AppMethodBeat.o(78147);
            return addr;
        } catch (Exception e2) {
            AppMethodBeat.o(78147);
            return null;
        }
    }
}
