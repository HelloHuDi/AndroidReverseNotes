package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends m implements k {
    private b ehh;
    private f ehi;
    public int kCl;
    public String kCm;
    public bfy tQi;
    public String tQj;
    public String tQk;
    public String tQl;

    public d(String str, String str2, String str3, String str4, String str5, int i, boolean z, int i2, String str6) {
        this(str, str2, str3, str4, str5, i, z, false, i2, str6);
    }

    public d(String str, String str2, String str3, String str4, String str5, int i, boolean z, boolean z2, int i2, String str6) {
        AppMethodBeat.i(48058);
        this.kCl = 0;
        this.kCm = "";
        a aVar = new a();
        aVar.fsJ = new bfx();
        aVar.fsK = new bfy();
        aVar.fsI = Exif.PARSE_EXIF_ERROR_CORRUPT;
        aVar.uri = "/cgi-bin/mmpay-bin/openecard";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        bfx bfx = (bfx) this.ehh.fsG.fsP;
        bfx.vKZ = str;
        bfx.vLa = str2;
        this.ehh.ftb = true;
        if (z) {
            bfx.wJK = str3;
        } else {
            bfx.wJL = str3;
        }
        if (z2) {
            bfx.wJM = 1;
        } else {
            bfx.wJM = 0;
        }
        bfx.tuk = str4;
        bfx.pbn = str5;
        bfx.cHF = i;
        bfx.wJJ = false;
        bfx.cME = i2;
        bfx.wJN = str6;
        this.tQj = str3;
        this.tQk = str4;
        this.tQl = str5;
        ab.d("MicroMsg.NetSceneOpenECard", "cardNo: %s", str3);
        ab.i("MicroMsg.NetSceneOpenECard", "cardType: %s, reqSerial: %s, openScene: %s, mobileNo: %s, bankType: %s, bankCardInfo: %s", str, str2, Integer.valueOf(i), str4, str5, str6);
        AppMethodBeat.o(48058);
    }

    public d(String str, String str2, int i) {
        AppMethodBeat.i(48059);
        this.kCl = 0;
        this.kCm = "";
        a aVar = new a();
        aVar.fsJ = new bfx();
        aVar.fsK = new bfy();
        aVar.fsI = Exif.PARSE_EXIF_ERROR_CORRUPT;
        aVar.uri = "/cgi-bin/mmpay-bin/openecard";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        bfx bfx = (bfx) this.ehh.fsG.fsP;
        bfx.vKZ = str;
        bfx.vLa = str2;
        this.ehh.ftb = true;
        bfx.wJM = 0;
        bfx.cHF = i;
        bfx.wJJ = true;
        ab.i("MicroMsg.NetSceneOpenECard", "create NetSceneOpenECard with reuse exist card, cardType: %s, reqSerial: %s, openScene: %s", str, str2, Integer.valueOf(i));
        AppMethodBeat.o(48059);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(48060);
        ab.i("MicroMsg.NetSceneOpenECard", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.tQi = (bfy) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneOpenECard", "ret_code: %d, ret_msg: %s", Integer.valueOf(this.tQi.kdT), this.tQi.kdU);
        if (!bo.isNullOrNil(this.tQi.wJH)) {
            ab.d("MicroMsg.NetSceneOpenECard", "rettext: %s", this.tQi.wJH);
            try {
                JSONObject jSONObject = new JSONObject(this.tQi.wJH);
                this.kCl = jSONObject.optInt("retcode", 0);
                this.kCm = jSONObject.optString("retmsg", "");
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.NetSceneOpenECard", e, "", new Object[0]);
            }
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(48060);
    }

    public final int getType() {
        return Exif.PARSE_EXIF_ERROR_CORRUPT;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(48061);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(48061);
        return a;
    }
}
