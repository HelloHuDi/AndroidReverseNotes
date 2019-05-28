package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.k.ad;
import com.tencent.mm.protocal.protobuf.amq;
import com.tencent.mm.protocal.protobuf.amr;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i extends m implements k {
    private b ehh;
    private f ehi;
    public String mUrl;
    public LinkedList<xd> phm;

    public i(String str, String str2) {
        AppMethodBeat.i(43991);
        a aVar = new a();
        aVar.fsJ = new amq();
        aVar.fsK = new amr();
        aVar.uri = "/cgi-bin/micromsg-bin/getproductdiscount";
        aVar.fsI = ad.CTRL_INDEX;
        this.ehh = aVar.acD();
        amq amq = (amq) this.ehh.fsG.fsP;
        amq.vRN = str;
        this.mUrl = str2;
        amq.Url = str2;
        AppMethodBeat.o(43991);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(43992);
        amr amr = (amr) ((b) qVar).fsH.fsP;
        if (i2 == 0 && i3 == 0 && amr.vKp == 0) {
            ab.d("MicroMsg.NetSceneMallGetProductDiscount", "resp.ProductInfo " + amr.wrq);
            try {
                JSONArray optJSONArray = new JSONObject(amr.wrq).optJSONArray("discount_list");
                if (optJSONArray != null) {
                    this.phm = new LinkedList();
                    int length = optJSONArray.length();
                    for (int i4 = 0; i4 < length; i4++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i4);
                        xd xdVar = new xd();
                        xdVar.Title = jSONObject.getString("title");
                        xdVar.vQt = jSONObject.getInt("fee");
                        this.phm.add(xdVar);
                    }
                }
            } catch (Exception e) {
            }
        }
        if (i3 == 0 && amr.vKp != 0) {
            i3 = amr.vKp;
            str = amr.vKq;
        }
        ab.d("MicroMsg.NetSceneMallGetProductDiscount", "errCode " + i3 + ", errMsg " + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(43992);
    }

    public final int getType() {
        return ad.CTRL_INDEX;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(43993);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(43993);
        return a;
    }
}
