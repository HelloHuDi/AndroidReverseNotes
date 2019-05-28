package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bfw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends m implements k {
    private b ehh;
    private f ehi;
    public int kCl = 0;
    public String kCm = "";
    public bfw tQm;
    public String token = null;

    public e(String str, String str2, int i, String str3) {
        AppMethodBeat.i(48062);
        a aVar = new a();
        aVar.fsJ = new bfv();
        aVar.fsK = new bfw();
        aVar.fsI = 1958;
        aVar.uri = "/cgi-bin/mmpay-bin/openecardauth";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        bfv bfv = (bfv) this.ehh.fsG.fsP;
        bfv.vKZ = str;
        bfv.wJG = str2;
        bfv.cHF = i;
        bfv.token = str3;
        this.token = null;
        ab.i("MicroMsg.NetSceneOpenECardAuth", "cardType: %s, scene: %d, token: %s, wxp_passwd_enc==null: %s", str, Integer.valueOf(i), str3, Boolean.valueOf(bo.isNullOrNil(str2)));
        ab.i("MicroMsg.NetSceneOpenECardAuth", "cardType: %s, scene: %d", str, Integer.valueOf(i));
        AppMethodBeat.o(48062);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(48063);
        ab.i("MicroMsg.NetSceneOpenECardAuth", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.tQm = (bfw) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneOpenECardAuth", "ret_code: %d, ret_msg: %s, is_token_invalid: %s", Integer.valueOf(this.tQm.kdT), this.tQm.kdU, Boolean.valueOf(this.tQm.wJI));
        if (!bo.isNullOrNil(this.tQm.wJH)) {
            ab.d("MicroMsg.NetSceneOpenECardAuth", "rettext: %s", this.tQm.wJH);
            try {
                JSONObject jSONObject = new JSONObject(this.tQm.wJH);
                this.kCl = jSONObject.optInt("retcode", 0);
                this.kCm = jSONObject.optString("retmsg", "");
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.NetSceneOpenECardAuth", e, "", new Object[0]);
            }
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(48063);
    }

    public final int getType() {
        return 1958;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(48064);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(48064);
        return a;
    }
}
