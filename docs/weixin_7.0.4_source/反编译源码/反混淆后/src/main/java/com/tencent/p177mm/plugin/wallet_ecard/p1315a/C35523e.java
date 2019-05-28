package com.tencent.p177mm.plugin.wallet_ecard.p1315a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bfv;
import com.tencent.p177mm.protocal.protobuf.bfw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_ecard.a.e */
public final class C35523e extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public int kCl = 0;
    public String kCm = "";
    public bfw tQm;
    public String token = null;

    public C35523e(String str, String str2, int i, String str3) {
        AppMethodBeat.m2504i(48062);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bfv();
        c1196a.fsK = new bfw();
        c1196a.fsI = 1958;
        c1196a.uri = "/cgi-bin/mmpay-bin/openecardauth";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        bfv bfv = (bfv) this.ehh.fsG.fsP;
        bfv.vKZ = str;
        bfv.wJG = str2;
        bfv.cHF = i;
        bfv.token = str3;
        this.token = null;
        C4990ab.m7417i("MicroMsg.NetSceneOpenECardAuth", "cardType: %s, scene: %d, token: %s, wxp_passwd_enc==null: %s", str, Integer.valueOf(i), str3, Boolean.valueOf(C5046bo.isNullOrNil(str2)));
        C4990ab.m7417i("MicroMsg.NetSceneOpenECardAuth", "cardType: %s, scene: %d", str, Integer.valueOf(i));
        AppMethodBeat.m2505o(48062);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(48063);
        C4990ab.m7417i("MicroMsg.NetSceneOpenECardAuth", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.tQm = (bfw) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneOpenECardAuth", "ret_code: %d, ret_msg: %s, is_token_invalid: %s", Integer.valueOf(this.tQm.kdT), this.tQm.kdU, Boolean.valueOf(this.tQm.wJI));
        if (!C5046bo.isNullOrNil(this.tQm.wJH)) {
            C4990ab.m7411d("MicroMsg.NetSceneOpenECardAuth", "rettext: %s", this.tQm.wJH);
            try {
                JSONObject jSONObject = new JSONObject(this.tQm.wJH);
                this.kCl = jSONObject.optInt("retcode", 0);
                this.kCm = jSONObject.optString("retmsg", "");
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.NetSceneOpenECardAuth", e, "", new Object[0]);
            }
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(48063);
    }

    public final int getType() {
        return 1958;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(48064);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(48064);
        return a;
    }
}
