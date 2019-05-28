package com.tencent.p177mm.plugin.remittance.model;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p1629b.p1630a.C44420a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.remittance.model.r */
public final class C13050r extends C44420a {
    public long cSh;
    public String desc;
    public int kCA;
    public int kCv;
    public String kCw;
    public String kCx;
    public String kCy;
    public String kCz;
    public String pPg;
    public String pPh;
    public String pPi;

    public C13050r(String str) {
        AppMethodBeat.m2504i(44762);
        HashMap hashMap = new HashMap();
        try {
            if (!C5046bo.isNullOrNil(str)) {
                hashMap.put("qrcode_url", URLEncoder.encode(str, "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            C4990ab.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferScanQrCode", e, "", new Object[0]);
        }
        mo70315M(hashMap);
        C4990ab.m7417i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "qrcode_url: %s", str);
        AppMethodBeat.m2505o(44762);
    }

    /* renamed from: a */
    public final void mo6950a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(44763);
        this.pPg = jSONObject.optString("recv_username", "");
        this.kCz = jSONObject.optString("recv_realname", "");
        this.pPh = jSONObject.optString("recv_nickname", "");
        this.desc = jSONObject.optString("desc", "");
        this.cSh = jSONObject.optLong("amount", 0);
        this.kCA = jSONObject.optInt("set_amount", 0);
        this.kCv = jSONObject.optInt(C8741b.CURRENCY, 0);
        this.kCw = jSONObject.optString("currencyunit", "");
        this.pPi = jSONObject.optString("qrcodeid", "");
        this.kCx = jSONObject.optString("notice", "");
        this.kCy = jSONObject.optString("notice_url", "");
        C4990ab.m7417i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_username: %s, recv_nickname: %s, desc: %s, amount: %s, setAmount: %s, currencyunit: %s", this.pPg, this.pPh, this.desc, Long.valueOf(this.cSh), Integer.valueOf(this.kCA), this.kCw);
        C4990ab.m7411d("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_realname: %s", this.kCz);
        AppMethodBeat.m2505o(44763);
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/h5f2ftransferscanqrcode";
    }

    public final int getType() {
        return 1301;
    }

    public final int bgG() {
        return 1301;
    }
}
