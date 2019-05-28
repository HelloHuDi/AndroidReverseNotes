package com.tencent.p177mm.plugin.wallet_ecard.p1315a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.Exif;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bfx;
import com.tencent.p177mm.protocal.protobuf.bfy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_ecard.a.d */
public final class C22678d extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public int kCl;
    public String kCm;
    public bfy tQi;
    public String tQj;
    public String tQk;
    public String tQl;

    public C22678d(String str, String str2, String str3, String str4, String str5, int i, boolean z, int i2, String str6) {
        this(str, str2, str3, str4, str5, i, z, false, i2, str6);
    }

    public C22678d(String str, String str2, String str3, String str4, String str5, int i, boolean z, boolean z2, int i2, String str6) {
        AppMethodBeat.m2504i(48058);
        this.kCl = 0;
        this.kCm = "";
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bfx();
        c1196a.fsK = new bfy();
        c1196a.fsI = Exif.PARSE_EXIF_ERROR_CORRUPT;
        c1196a.uri = "/cgi-bin/mmpay-bin/openecard";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
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
        C4990ab.m7411d("MicroMsg.NetSceneOpenECard", "cardNo: %s", str3);
        C4990ab.m7417i("MicroMsg.NetSceneOpenECard", "cardType: %s, reqSerial: %s, openScene: %s, mobileNo: %s, bankType: %s, bankCardInfo: %s", str, str2, Integer.valueOf(i), str4, str5, str6);
        AppMethodBeat.m2505o(48058);
    }

    public C22678d(String str, String str2, int i) {
        AppMethodBeat.m2504i(48059);
        this.kCl = 0;
        this.kCm = "";
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bfx();
        c1196a.fsK = new bfy();
        c1196a.fsI = Exif.PARSE_EXIF_ERROR_CORRUPT;
        c1196a.uri = "/cgi-bin/mmpay-bin/openecard";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        bfx bfx = (bfx) this.ehh.fsG.fsP;
        bfx.vKZ = str;
        bfx.vLa = str2;
        this.ehh.ftb = true;
        bfx.wJM = 0;
        bfx.cHF = i;
        bfx.wJJ = true;
        C4990ab.m7417i("MicroMsg.NetSceneOpenECard", "create NetSceneOpenECard with reuse exist card, cardType: %s, reqSerial: %s, openScene: %s", str, str2, Integer.valueOf(i));
        AppMethodBeat.m2505o(48059);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(48060);
        C4990ab.m7417i("MicroMsg.NetSceneOpenECard", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.tQi = (bfy) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneOpenECard", "ret_code: %d, ret_msg: %s", Integer.valueOf(this.tQi.kdT), this.tQi.kdU);
        if (!C5046bo.isNullOrNil(this.tQi.wJH)) {
            C4990ab.m7411d("MicroMsg.NetSceneOpenECard", "rettext: %s", this.tQi.wJH);
            try {
                JSONObject jSONObject = new JSONObject(this.tQi.wJH);
                this.kCl = jSONObject.optInt("retcode", 0);
                this.kCm = jSONObject.optString("retmsg", "");
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.NetSceneOpenECard", e, "", new Object[0]);
            }
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(48060);
    }

    public final int getType() {
        return Exif.PARSE_EXIF_ERROR_CORRUPT;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(48061);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(48061);
        return a;
    }
}
