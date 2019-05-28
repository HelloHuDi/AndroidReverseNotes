package com.tencent.p177mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19483d;
import com.tencent.p177mm.plugin.wallet_core.model.mall.C40113c;
import com.tencent.p177mm.protocal.protobuf.akd;
import com.tencent.p177mm.protocal.protobuf.ake;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.recharge.model.d */
public final class C28809d extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;
    public int fmR;
    public String gyD;
    public String pFP;
    public String pFQ = null;
    public MallRechargeProduct pFY = null;
    public List<MallRechargeProduct> pFZ = null;
    public String pGa;

    public C28809d(int i, String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(44196);
        this.pFP = str;
        this.fmR = i;
        this.gyD = str5;
        this.pGa = str2;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new akd();
        c1196a.fsK = new ake();
        c1196a.uri = "/cgi-bin/micromsg-bin/getlatestpayproductinfo";
        c1196a.fsI = C19483d.CTRL_INDEX;
        c1196a.fsL = 229;
        c1196a.fsM = 1000000229;
        this.ehh = c1196a.acD();
        akd akd = (akd) this.ehh.fsG.fsP;
        akd.wjV = str;
        akd.wjW = str3;
        akd.wpE = str2;
        akd.wjX = str4;
        akd.wdB = C40113c.cQT().acH(str);
        C4990ab.m7410d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("funcId:%s, appId:%s, productId:%s, remark:%s", new Object[]{str, str3, str2, str4}));
        AppMethodBeat.m2505o(44196);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(44197);
        C4990ab.m7410d("MicroMsg.NetSceneGetLatestPayProductInfo", "errCode " + i3 + ", errMsg " + str);
        ake ake = (ake) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7410d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.OurterRemark " + ake.wka);
        String str2 = ake.wka;
        this.pFQ = "";
        if (!C5046bo.isNullOrNil(str2)) {
            String[] split = str2.split("&");
            if (split != null && split.length > 0) {
                Object obj = 1;
                for (String split2 : split) {
                    String[] split3 = split2.split("=");
                    if (split3.length == 2) {
                        if (obj == null) {
                            this.pFQ += " ";
                        } else {
                            obj = null;
                        }
                        this.pFQ += split3[1];
                    }
                }
            }
        }
        if (!C5046bo.isNullOrNil(ake.wpG)) {
            try {
                this.pFZ = C43421b.m77504a(this.pFP, new JSONObject(ake.wpG).optJSONArray("product_info"));
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", e, "", new Object[0]);
            }
        }
        if (i2 == 0 && i3 == 0) {
            str2 = ake.wpF;
            C4990ab.m7410d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.Product ".concat(String.valueOf(str2)));
            if (!C5046bo.isNullOrNil(str2)) {
                try {
                    this.pFY = C43421b.m77506e(this.pFP, new JSONObject(str2));
                    this.pFY.pFQ = this.pFQ;
                } catch (JSONException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", e2, "", new Object[0]);
                }
            }
        }
        C4990ab.m7410d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("OutErrCode : %d ,OutErrMsg : %s , WxErrCode : %d , WxErrMsg : %s", new Object[]{Integer.valueOf(ake.wjY), ake.wjZ, Integer.valueOf(ake.wkb), ake.wkc}));
        if (i3 == 0) {
            if (ake.wkb != 0) {
                i3 = ake.wkb;
            } else {
                i3 = ake.wjY;
            }
        }
        if (C5046bo.isNullOrNil(str)) {
            if (C5046bo.isNullOrNil(ake.wkc)) {
                str = ake.wjZ;
            } else {
                str = ake.wkc;
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(44197);
    }

    public final int getType() {
        return C19483d.CTRL_INDEX;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44198);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(44198);
        return a;
    }
}
