package com.tencent.p177mm.plugin.offline.p478a;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p232b.p233a.C37819a;
import com.tencent.p177mm.plugin.offline.C7007k;
import com.tencent.p177mm.plugin.offline.p1006c.C28630a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p649c.C40928b;
import com.tencent.xweb.util.C6037d;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.offline.a.m */
public final class C21403m extends C46117h {
    String cEW;
    public int oYA;
    int oYB;
    public String oYn;
    public String oYo;
    public String oYp;
    public String oYr;
    public int oYs;
    public String oYt;
    public String oYu;
    public String oYv;
    private String oYx;
    private int oYy;
    public String oYz;
    public String token;

    public C21403m(String str, int i) {
        this(str, i, i);
        AppMethodBeat.m2504i(43407);
        AppMethodBeat.m2505o(43407);
    }

    public C21403m(String str, int i, int i2) {
        Object obj;
        int i3;
        CharSequence genUserSig;
        AppMethodBeat.m2504i(43408);
        this.token = "";
        this.oYn = "";
        this.oYo = "";
        this.oYp = "";
        this.oYr = "";
        this.oYs = 0;
        this.oYt = "";
        this.oYu = "";
        this.oYv = "";
        this.oYA = 0;
        this.oYB = 0;
        this.cEW = C6037d.m9506x((System.currentTimeMillis()).getBytes());
        C4990ab.m7419v("MicroMsg.NetSceneTenpayWxOfflineGetToken", "scene %s stack %s ", Integer.valueOf(i), C5046bo.dpG().toString());
        String token = C28630a.getToken();
        C7007k.bXg();
        String Ax = C7007k.m11709Ax(196628);
        if (TextUtils.isEmpty(Ax)) {
            Ax = C1427q.m3028LM();
        }
        if (TextUtils.isEmpty(token)) {
            obj = Ax + "&" + str + "&" + (((int) (Math.random() * 1000000.0d)) + 1000000);
        } else {
            obj = Ax + "&" + str + "&" + (((int) (Math.random() * 1000000.0d)) + 1000000) + "&" + token;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("token_src", obj);
        String str2 = "";
        C7007k.bXg();
        String Ax2 = C7007k.m11709Ax(196617);
        switch (i2) {
            case 0:
                i3 = 12;
                break;
            case 1:
                i3 = 13;
                break;
            case 2:
                i3 = 14;
                break;
            case 3:
                i3 = 15;
                break;
            case 4:
                i3 = 16;
                break;
            case 5:
                i3 = 17;
                break;
            case 6:
                i3 = 18;
                break;
            case 7:
                i3 = 19;
                break;
            case 8:
                i3 = 20;
                break;
            case 9:
                i3 = 24;
                break;
            case 10:
                i3 = 72;
                break;
            default:
                i3 = 12;
                break;
        }
        C7060h.pYm.mo8378a(135, (long) i3, 1, true);
        C37819a c37819a = new C37819a();
        c37819a.mo60512ep(this.cEW);
        c37819a.cTl = 1;
        C40928b.dNJ();
        if (C40928b.isCertExist(Ax2)) {
            c37819a.cTm = 1;
            C40928b.dNJ();
            c37819a.cTn = (long) C40928b.getLastError();
            c37819a.ajK();
            c37819a = new C37819a();
            c37819a.mo60512ep(this.cEW);
            c37819a.cTl = 3;
            C40928b.dNJ();
            genUserSig = C40928b.genUserSig(Ax2, obj);
            if (C5046bo.isNullOrNil(genUserSig)) {
                c37819a.cTm = 0;
                C40928b.dNJ();
                c37819a.cTn = (long) C40928b.getLastError();
                c37819a.ajK();
            } else {
                c37819a.cTm = 1;
                C40928b.dNJ();
                c37819a.cTn = (long) C40928b.getLastError();
                c37819a.ajK();
            }
            C4990ab.m7416i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().isCertExist(cn) true");
        } else {
            StringBuilder stringBuilder = new StringBuilder("NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().getLastError():");
            C40928b.dNJ();
            C4990ab.m7412e("MicroMsg.NetSceneTenpayWxOfflineGetToken", stringBuilder.append(C40928b.getLastError()).toString());
            c37819a.cTm = 0;
            C40928b.dNJ();
            c37819a.cTn = (long) C40928b.getLastError();
            c37819a.ajK();
            C7060h.pYm.mo8378a(135, 6, 1, true);
            C37819a c37819a2 = new C37819a();
            c37819a2.mo60512ep(this.cEW);
            c37819a2.cTl = 2;
            C1720g.m3537RQ();
            Ax = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_OFFLINE_IEMI_STRING_SYNC, (Object) "");
            if (Ax == null || !Ax.equals(C1427q.m3026LK())) {
                c37819a2.cTm = 0;
                C40928b.dNJ();
                c37819a2.cTn = (long) C40928b.getLastError();
                C4990ab.m7416i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is diff between create and getToken");
                C7060h.pYm.mo8378a(135, 5, 1, true);
            } else {
                C4990ab.m7416i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is same between create and getToken");
                c37819a2.cTm = 1;
                C40928b.dNJ();
                c37819a2.cTn = (long) C40928b.getLastError();
            }
            c37819a2.ajK();
            C4990ab.m7412e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().isCertExist return false! cn: ".concat(String.valueOf(Ax2)));
            obj = str2;
        }
        if (TextUtils.isEmpty(genUserSig)) {
            C4990ab.m7412e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken sign is empty!");
            C7060h.pYm.mo8378a(135, 4, 1, true);
        } else {
            C4990ab.m7416i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "sign is valid");
        }
        hashMap.put("sign", genUserSig);
        hashMap.put("cert_no", Ax2);
        hashMap.put("type", C21402k.oYq);
        hashMap.put("version_number", C21402k.oYq);
        if (C28630a.bYq() == 2) {
            hashMap.put("last_token", C28630a.bYr());
        } else {
            hashMap.put("last_token", C28630a.getToken());
        }
        C4990ab.m7417i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "inOfflineUI: %B", Boolean.valueOf(C7007k.oXK));
        if (i == 65281) {
            hashMap.put("fetch_tag", "2");
        } else if (C7007k.oXK) {
            hashMap.put("fetch_tag", "1");
        } else {
            hashMap.put("fetch_tag", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        if (i == 65281) {
            i = 3;
        }
        hashMap.put("scene", String.valueOf(i));
        mo74062M(hashMap);
        AppMethodBeat.m2505o(43408);
    }

    public final int bgI() {
        if (C7007k.oXK) {
            return 52;
        }
        return 1725;
    }

    /* renamed from: a */
    public final void mo36860a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(43409);
        C4990ab.m7411d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        if (i == 0) {
            this.token = jSONObject.optString("token");
            this.oYn = jSONObject.optString("valid_end");
            this.oYo = jSONObject.optString("encrypt_str");
            this.oYp = jSONObject.optString("deviceid");
            this.oYr = jSONObject.optString("token_v2");
            this.oYs = jSONObject.optInt("algorithm_type");
            this.oYt = jSONObject.optString("card_list");
            this.oYu = jSONObject.optString("key_list");
            this.oYv = jSONObject.optString("token_pin");
            this.oYx = jSONObject.optString("auth_codes");
            this.oYy = jSONObject.optInt("update_interval");
            this.oYz = jSONObject.optString("code_ver");
            this.oYA = jSONObject.optInt("reget_token_num", 0);
            this.oYB = jSONObject.optInt("cipher_type", 0);
            if (this.oYA > 0) {
                C7007k.oXL = this.oYA;
            } else {
                C7007k.oXL = 10;
            }
            C4990ab.m7411d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "json: %s", jSONObject.toString());
        }
        AppMethodBeat.m2505o(43409);
    }

    public final boolean bXn() {
        AppMethodBeat.m2504i(43410);
        C4990ab.m7416i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "do save token");
        C7007k.bXg();
        C7007k.m11711aT(196626, this.oYn);
        C7007k.bXg();
        C7007k.m11711aT(196627, this.oYo);
        C7007k.bXg();
        C7007k.m11711aT(196628, this.oYp);
        C7007k.bXg();
        C7007k.m11711aT(196632, (System.currentTimeMillis() / 1000));
        C28630a.m45525r(this.token, this.oYr, this.oYt, this.oYu);
        C28630a.m45492AD(this.oYs);
        C7007k.bXg();
        C7007k.m11711aT(196647, this.oYv);
        C7007k.bXg();
        String Ax = C7007k.m11709Ax(196617);
        C40928b.dNJ();
        C40928b.clearToken(Ax);
        C40928b.dNJ();
        boolean F = C40928b.m70952F(Ax, this.oYx, this.oYB == 1);
        C37819a c37819a = new C37819a();
        c37819a.mo60512ep(this.cEW);
        c37819a.cTl = 3;
        if (F) {
            c37819a.cTm = 1;
            C40928b.dNJ();
            c37819a.cTn = (long) C40928b.getLastError();
            C4990ab.m7416i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens success!");
        } else {
            c37819a.cTm = 0;
            C40928b.dNJ();
            c37819a.cTn = (long) C40928b.getLastError();
            C4990ab.m7412e("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens failed!");
            StringBuilder stringBuilder = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
            C40928b.dNJ();
            C4990ab.m7412e("MicroMsg.NetSceneTenpayWxOfflineGetToken", stringBuilder.append(C40928b.getLastError()).toString());
        }
        c37819a.ajK();
        C7007k.bXg();
        C7007k.m11711aT(196649, this.oYy);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_OFFLINE_CODE_VER_STRING, this.oYz);
        AppMethodBeat.m2505o(43410);
        return F;
    }

    /* renamed from: ZU */
    public final int mo36859ZU() {
        if (C7007k.oXK) {
            return 571;
        }
        return 1725;
    }

    public final String getUri() {
        if (C7007k.oXK) {
            return "/cgi-bin/mmpay-bin/tenpay/offlinegettoken";
        }
        return "/cgi-bin/mmpay-bin/tenpay/offlinegettokenbackground";
    }
}
