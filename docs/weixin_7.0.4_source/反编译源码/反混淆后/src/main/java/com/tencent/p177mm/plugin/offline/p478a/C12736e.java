package com.tencent.p177mm.plugin.offline.p478a;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.protocal.protobuf.bez;
import com.tencent.p177mm.protocal.protobuf.bfa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.wallet_core.p649c.C36378u;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.offline.a.e */
public final class C12736e extends C36378u {
    private final C7472b ehh;
    private C1202f ehi;
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

    public C12736e(int i, String str, String str2, String str3) {
        AppMethodBeat.m2504i(43390);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bez();
        c1196a.fsK = new bfa();
        c1196a.uri = "/cgi-bin/mmpay-bin/offlinepayconfirm";
        c1196a.fsI = 609;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        c1196a.fsO = C36391e.atB(str3);
        this.ehh = c1196a.acD();
        bez bez = (bez) this.ehh.fsG.fsP;
        bez.wIU = i;
        bez.f15075Id = str;
        bez.guu = str2;
        bez.vRP = C22594k.cPy();
        this.oYb = i;
        AppMethodBeat.m2505o(43390);
    }

    public final int getType() {
        return 609;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(43391);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(43391);
        return a;
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(43392);
        if (i != 0) {
            C4990ab.m7412e("MicroMsg.NetSceneOfflinePayConfirm", "Cmd : 609, errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        }
        bfa bfa = (bfa) ((C7472b) c1929q).fsH.fsP;
        if (i == 0 && i2 == 0) {
            try {
                if (bfa.wqA != null) {
                    JSONObject jSONObject = new JSONObject(bfa.wqA);
                    this.oXY = jSONObject.optString(C8741b.TRANSACTION_ID);
                    this.kCl = jSONObject.optInt("retcode");
                    this.kCm = jSONObject.optString("retmsg");
                    this.oXZ = jSONObject.optInt("wx_error_type");
                    this.oYa = jSONObject.optString("wx_error_msg");
                    C4990ab.m7411d("MicroMsg.NetSceneOfflinePayConfirm", "onGYNetEnd %s", jSONObject.toString());
                    if (jSONObject.has("real_name_info")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
                        this.oYd = optJSONObject.optString("guide_flag");
                        this.oYe = optJSONObject.optString("guide_wording");
                        this.oYf = optJSONObject.optString("left_button_wording");
                        this.oYg = optJSONObject.optString("right_button_wording");
                        this.oYh = optJSONObject.optString("upload_credit_url");
                        if ("1".equals(this.oYd) || "2".equals(this.oYd)) {
                            this.oYc = new RealnameGuideHelper();
                            this.oYc.mo74571a(this.oYd, this.oYe, this.oYf, this.oYg, this.oYh, 0);
                        }
                    }
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.NetSceneOfflinePayConfirm", e, "", new Object[0]);
                i = 1000;
                i2 = 2;
                str = C4996ah.getContext().getString(C25738R.string.fdx);
            }
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(43392);
    }
}
