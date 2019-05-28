package com.tencent.p177mm.plugin.collect.model;

import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p1629b.p1630a.C44420a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.collect.model.m */
public final class C2833m extends C44420a {
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

    public C2833m(int i) {
        AppMethodBeat.m2504i(40980);
        HashMap hashMap = new HashMap();
        hashMap.put("set_amount", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("wallet_type", String.valueOf(i));
        mo70315M(hashMap);
        C4990ab.m7417i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "setAmount: %s, walletType: %s", Integer.valueOf(0), Integer.valueOf(i));
        AppMethodBeat.m2505o(40980);
    }

    public C2833m(long j, String str, int i) {
        AppMethodBeat.m2504i(40981);
        HashMap hashMap = new HashMap();
        hashMap.put("amount", String.valueOf(j));
        hashMap.put("set_amount", "1");
        try {
            if (!C5046bo.isNullOrNil(str)) {
                hashMap.put("desc", URLEncoder.encode(str, "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            C4990ab.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferGetQrCode", e, "", new Object[0]);
        }
        hashMap.put("wallet_type", String.valueOf(i));
        mo70315M(hashMap);
        this.cSh = j;
        this.desc = str;
        C4990ab.m7417i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "amount: %d, setAmount: %s, desc: %s, walletType: %s", Long.valueOf(j), Integer.valueOf(1), str, Integer.valueOf(i));
        AppMethodBeat.m2505o(40981);
    }

    /* renamed from: a */
    public final void mo6950a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(40982);
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
        this.kCv = jSONObject.optInt(C8741b.CURRENCY, 0);
        this.kCw = jSONObject.optString("currencyunit", "");
        this.kCx = jSONObject.optString("notice", "");
        this.kCy = jSONObject.optString("notice_url", "");
        this.kCz = jSONObject.optString("recv_realname", "");
        this.kCA = jSONObject.optInt("set_amount", 0);
        if (this.kCA == 0) {
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_HK_PAY_URL_STRING, this.kCn);
            C4990ab.m7417i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "set payurl: %s", this.kCn);
        }
        C4990ab.m7411d("MicroMsg.NetSceneH5F2fTransferGetQrCode", "url: %s, currency: %s", this.kCn, Integer.valueOf(this.kCv));
        AppMethodBeat.m2505o(40982);
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
