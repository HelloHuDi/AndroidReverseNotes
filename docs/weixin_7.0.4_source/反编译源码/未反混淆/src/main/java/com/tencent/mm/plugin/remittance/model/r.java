package com.tencent.mm.plugin.remittance.model;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.b.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class r extends a {
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

    public r(String str) {
        AppMethodBeat.i(44762);
        HashMap hashMap = new HashMap();
        try {
            if (!bo.isNullOrNil(str)) {
                hashMap.put("qrcode_url", URLEncoder.encode(str, "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            ab.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferScanQrCode", e, "", new Object[0]);
        }
        M(hashMap);
        ab.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "qrcode_url: %s", str);
        AppMethodBeat.o(44762);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(44763);
        this.pPg = jSONObject.optString("recv_username", "");
        this.kCz = jSONObject.optString("recv_realname", "");
        this.pPh = jSONObject.optString("recv_nickname", "");
        this.desc = jSONObject.optString("desc", "");
        this.cSh = jSONObject.optLong("amount", 0);
        this.kCA = jSONObject.optInt("set_amount", 0);
        this.kCv = jSONObject.optInt(b.CURRENCY, 0);
        this.kCw = jSONObject.optString("currencyunit", "");
        this.pPi = jSONObject.optString("qrcodeid", "");
        this.kCx = jSONObject.optString("notice", "");
        this.kCy = jSONObject.optString("notice_url", "");
        ab.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_username: %s, recv_nickname: %s, desc: %s, amount: %s, setAmount: %s, currencyunit: %s", this.pPg, this.pPh, this.desc, Long.valueOf(this.cSh), Integer.valueOf(this.kCA), this.kCw);
        ab.d("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_realname: %s", this.kCz);
        AppMethodBeat.o(44763);
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
