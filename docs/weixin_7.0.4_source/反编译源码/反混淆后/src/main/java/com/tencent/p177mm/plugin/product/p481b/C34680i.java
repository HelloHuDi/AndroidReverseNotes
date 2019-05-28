package com.tencent.p177mm.plugin.product.p481b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C42524ad;
import com.tencent.p177mm.protocal.protobuf.C44188xd;
import com.tencent.p177mm.protocal.protobuf.amq;
import com.tencent.p177mm.protocal.protobuf.amr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.product.b.i */
public final class C34680i extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public String mUrl;
    public LinkedList<C44188xd> phm;

    public C34680i(String str, String str2) {
        AppMethodBeat.m2504i(43991);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new amq();
        c1196a.fsK = new amr();
        c1196a.uri = "/cgi-bin/micromsg-bin/getproductdiscount";
        c1196a.fsI = C42524ad.CTRL_INDEX;
        this.ehh = c1196a.acD();
        amq amq = (amq) this.ehh.fsG.fsP;
        amq.vRN = str;
        this.mUrl = str2;
        amq.Url = str2;
        AppMethodBeat.m2505o(43991);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(43992);
        amr amr = (amr) ((C7472b) c1929q).fsH.fsP;
        if (i2 == 0 && i3 == 0 && amr.vKp == 0) {
            C4990ab.m7410d("MicroMsg.NetSceneMallGetProductDiscount", "resp.ProductInfo " + amr.wrq);
            try {
                JSONArray optJSONArray = new JSONObject(amr.wrq).optJSONArray("discount_list");
                if (optJSONArray != null) {
                    this.phm = new LinkedList();
                    int length = optJSONArray.length();
                    for (int i4 = 0; i4 < length; i4++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i4);
                        C44188xd c44188xd = new C44188xd();
                        c44188xd.Title = jSONObject.getString("title");
                        c44188xd.vQt = jSONObject.getInt("fee");
                        this.phm.add(c44188xd);
                    }
                }
            } catch (Exception e) {
            }
        }
        if (i3 == 0 && amr.vKp != 0) {
            i3 = amr.vKp;
            str = amr.vKq;
        }
        C4990ab.m7410d("MicroMsg.NetSceneMallGetProductDiscount", "errCode " + i3 + ", errMsg " + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(43992);
    }

    public final int getType() {
        return C42524ad.CTRL_INDEX;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(43993);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(43993);
        return a;
    }
}
