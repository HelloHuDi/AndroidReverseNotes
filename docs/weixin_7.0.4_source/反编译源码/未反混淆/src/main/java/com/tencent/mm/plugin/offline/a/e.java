package com.tencent.mm.plugin.offline.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bez;
import com.tencent.mm.protocal.protobuf.bfa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.wallet_core.c.u;
import org.json.JSONObject;

public final class e extends u {
    private final b ehh;
    private f ehi;
    public int kCl = -1;
    private String kCm = "";
    public String oXY = "";
    public int oXZ = -1;
    public String oYa = "";
    public int oYb = 1;
    public RealnameGuideHelper oYc;
    private String oYd;
    private String oYe;
    private String oYf;
    private String oYg;
    private String oYh;

    public e(int i, String str, String str2, String str3) {
        AppMethodBeat.i(43390);
        a aVar = new a();
        aVar.fsJ = new bez();
        aVar.fsK = new bfa();
        aVar.uri = "/cgi-bin/mmpay-bin/offlinepayconfirm";
        aVar.fsI = 609;
        aVar.fsL = 0;
        aVar.fsM = 0;
        aVar.fsO = com.tencent.mm.wallet_core.ui.e.atB(str3);
        this.ehh = aVar.acD();
        bez bez = (bez) this.ehh.fsG.fsP;
        bez.wIU = i;
        bez.Id = str;
        bez.guu = str2;
        bez.vRP = k.cPy();
        this.oYb = i;
        AppMethodBeat.o(43390);
    }

    public final int getType() {
        return 609;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(43391);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(43391);
        return a;
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(43392);
        if (i != 0) {
            ab.e("MicroMsg.NetSceneOfflinePayConfirm", "Cmd : 609, errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        }
        bfa bfa = (bfa) ((b) qVar).fsH.fsP;
        if (i == 0 && i2 == 0) {
            try {
                if (bfa.wqA != null) {
                    JSONObject jSONObject = new JSONObject(bfa.wqA);
                    this.oXY = jSONObject.optString(FirebaseAnalytics.b.TRANSACTION_ID);
                    this.kCl = jSONObject.optInt("retcode");
                    this.kCm = jSONObject.optString("retmsg");
                    this.oXZ = jSONObject.optInt("wx_error_type");
                    this.oYa = jSONObject.optString("wx_error_msg");
                    ab.d("MicroMsg.NetSceneOfflinePayConfirm", "onGYNetEnd %s", jSONObject.toString());
                    if (jSONObject.has("real_name_info")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
                        this.oYd = optJSONObject.optString("guide_flag");
                        this.oYe = optJSONObject.optString("guide_wording");
                        this.oYf = optJSONObject.optString("left_button_wording");
                        this.oYg = optJSONObject.optString("right_button_wording");
                        this.oYh = optJSONObject.optString("upload_credit_url");
                        if ("1".equals(this.oYd) || "2".equals(this.oYd)) {
                            this.oYc = new RealnameGuideHelper();
                            this.oYc.a(this.oYd, this.oYe, this.oYf, this.oYg, this.oYh, 0);
                        }
                    }
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.NetSceneOfflinePayConfirm", e, "", new Object[0]);
                i = 1000;
                i2 = 2;
                str = ah.getContext().getString(R.string.fdx);
            }
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(43392);
    }
}
