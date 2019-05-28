package com.tencent.p177mm.modelgeo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.ady;
import com.tencent.p177mm.protocal.protobuf.adz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.modelgeo.e */
public final class C9691e extends C1207m implements C1918k {
    private String cBF = "";
    public final C7472b ehh;
    private C1202f ehi;

    public C9691e(double d, double d2) {
        AppMethodBeat.m2504i(78144);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ady();
        c1196a.fsK = new adz();
        c1196a.uri = "/cgi-bin/micromsg-bin/getaddress";
        c1196a.fsI = 655;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ady ady = (ady) this.ehh.fsG.fsP;
        ady.vNI = d;
        ady.vNH = d2;
        AppMethodBeat.m2505o(78144);
    }

    public final int getType() {
        return 655;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78145);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(78145);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78146);
        C4990ab.m7411d("MicroMsg.NetSceneGetAddress", "onGYNetEnd errType %d errCode%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            this.cBF = ((adz) ((C7472b) c1929q).fsH.fsP).wlX;
            C4990ab.m7410d("MicroMsg.NetSceneGetAddress", this.cBF);
            if (this.ehi != null) {
                this.ehi.onSceneEnd(i2, i3, str, this);
            }
            AppMethodBeat.m2505o(78146);
            return;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(78146);
    }

    public final Addr agD() {
        AppMethodBeat.m2504i(78147);
        if (C5046bo.isNullOrNil(this.cBF)) {
            AppMethodBeat.m2505o(78147);
            return null;
        }
        Addr addr = new Addr();
        try {
            C4990ab.m7411d("MicroMsg.NetSceneGetAddress", "tofutest retJson: %s", this.cBF);
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
            if (!C5046bo.isNullOrNil(addr.fBn)) {
                addr.fBm = "";
            }
            AppMethodBeat.m2505o(78147);
            return addr;
        } catch (Exception e2) {
            AppMethodBeat.m2505o(78147);
            return null;
        }
    }
}
