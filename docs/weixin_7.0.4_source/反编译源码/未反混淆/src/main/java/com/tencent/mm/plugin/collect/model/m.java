package com.tencent.mm.plugin.collect.model;

import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.wallet_core.b.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class m extends a {
    public long cSh;
    public String desc;
    public int kCA;
    public int kCl;
    public String kCm;
    public String kCn;
    public int kCo;
    public String kCp;
    public String kCq;
    public String kCr;
    public String kCs;
    public String kCt;
    public String kCu;
    public int kCv;
    public String kCw;
    public String kCx;
    public String kCy;
    public String kCz;

    public m(int i) {
        AppMethodBeat.i(40980);
        HashMap hashMap = new HashMap();
        hashMap.put("set_amount", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("wallet_type", String.valueOf(i));
        M(hashMap);
        ab.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "setAmount: %s, walletType: %s", Integer.valueOf(0), Integer.valueOf(i));
        AppMethodBeat.o(40980);
    }

    public m(long j, String str, int i) {
        AppMethodBeat.i(40981);
        HashMap hashMap = new HashMap();
        hashMap.put("amount", String.valueOf(j));
        hashMap.put("set_amount", "1");
        try {
            if (!bo.isNullOrNil(str)) {
                hashMap.put("desc", URLEncoder.encode(str, "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            ab.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferGetQrCode", e, "", new Object[0]);
        }
        hashMap.put("wallet_type", String.valueOf(i));
        M(hashMap);
        this.cSh = j;
        this.desc = str;
        ab.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "amount: %d, setAmount: %s, desc: %s, walletType: %s", Long.valueOf(j), Integer.valueOf(1), str, Integer.valueOf(i));
        AppMethodBeat.o(40981);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(40982);
        this.kCl = jSONObject.optInt("retcode", 0);
        this.kCm = jSONObject.optString("retmsg", "");
        this.kCn = jSONObject.optString("qrcode_url", "");
        this.kCo = jSONObject.optInt("alert_type", 0);
        this.kCp = jSONObject.optString("alert_title", "");
        this.kCq = jSONObject.optString("left_button_text", "");
        this.kCr = jSONObject.optString("right_button_text", "");
        this.kCs = jSONObject.optString("right_button_url", "");
        this.kCt = jSONObject.optString("bottom_text", "");
        this.kCu = jSONObject.optString("bottom_url", "");
        this.kCv = jSONObject.optInt(b.CURRENCY, 0);
        this.kCw = jSONObject.optString("currencyunit", "");
        this.kCx = jSONObject.optString("notice", "");
        this.kCy = jSONObject.optString("notice_url", "");
        this.kCz = jSONObject.optString("recv_realname", "");
        this.kCA = jSONObject.optInt("set_amount", 0);
        if (this.kCA == 0) {
            g.RQ();
            g.RP().Ry().set(ac.a.USERINFO_WALLET_HK_PAY_URL_STRING, this.kCn);
            ab.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "set payurl: %s", this.kCn);
        }
        ab.d("MicroMsg.NetSceneH5F2fTransferGetQrCode", "url: %s, currency: %s", this.kCn, Integer.valueOf(this.kCv));
        AppMethodBeat.o(40982);
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/h5f2ftransfergetqrcode";
    }

    public final int getType() {
        return 1335;
    }

    public final int bgG() {
        return 1335;
    }

    public final boolean bgH() {
        return true;
    }
}
