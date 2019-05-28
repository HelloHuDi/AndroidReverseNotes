package com.tencent.p177mm.plugin.remittance.model;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C37719fw;
import com.tencent.p177mm.plugin.wallet_core.model.C29628a;
import com.tencent.p177mm.protocal.protobuf.C7282rn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C44426i;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.remittance.model.v */
public final class C39603v extends C5749m implements C44426i {
    public String cAa;
    public String cBT = null;
    public String cEa;
    public C29628a cMO;
    private int cQO;
    public String kBE;
    public String kDV;
    public int nUf;
    public int nZf;
    public String pOU = "";
    public C37719fw pOV = null;
    public String pPA = "";
    public String pPB = "";
    public String pPC;
    public int pPD;
    public String pPE;
    public String pPF;
    public int pPG;
    public String pPH;
    public String pPI;
    public String pPJ;
    public String pPK;
    public int pPL = 0;
    public C7282rn pPM;
    public int pPl = 0;
    public C39604a pPm;
    public String pPn;
    public String pPo;
    public double pPp;
    public double pPq;
    public String pPr;
    public boolean pPs;
    public double pPt;
    public double pPu;
    public double pPv;
    public String pPw;
    public String pPx;
    public String pPy;
    public double pPz = 0.0d;
    public String username = "";

    /* renamed from: com.tencent.mm.plugin.remittance.model.v$a */
    public static class C39604a {
        public String cEh;
        public String pPN;
        public String pPO;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x01c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C39603v(double d, String str, String str2, String str3, int i, int i2, String str4, int i3, String str5, String str6, String str7, String str8, String str9, int i4, String str10, String str11, String str12, String str13, String str14, C37719fw c37719fw, String str15, String str16, String str17, String str18, int i5, String str19, int i6) {
        AppMethodBeat.m2504i(44772);
        C4990ab.m7417i("Micromsg.NetSceneTenpayRemittanceGen", "payScene: %s, channel: %s dynamicCodeUrl: %s mch_name: %s nickname: %s receiver_true_name %s placeorder_reserves: %s unpayType: %s cancel_outtradeno:%s cancel_reason:%s", Integer.valueOf(i), Integer.valueOf(i4), str11, str12, str13, str14, str18, String.valueOf(i5), str19, Integer.valueOf(i6));
        this.pPz = d;
        this.cQO = i;
        this.username = str2;
        this.pOU = str11;
        HashMap hashMap = new HashMap();
        hashMap.put("scene", String.valueOf(i));
        hashMap.put("transfer_scene", String.valueOf(i2));
        hashMap.put("fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str);
        hashMap.put("receiver_name", str2);
        hashMap.put("receiver_openid", str10);
        hashMap.put("mask_truename", str3);
        hashMap.put("mch_name", str12);
        hashMap.put("nickname", str13);
        hashMap.put("receiver_true_name", str14);
        String str20 = "dynamic_code_source";
        Object obj = (c37719fw == null || c37719fw.czT.czW != 1) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1";
        hashMap.put(str20, obj);
        hashMap.put("input_name", str15);
        hashMap.put("checkname_sign", str16);
        hashMap.put("truename_extend", str17);
        hashMap.put("placeorder_reserves", str18);
        hashMap.put("cancel_outtradeno", str19);
        hashMap.put("unpay_type", String.valueOf(i5));
        hashMap.put("cancel_reason", String.valueOf(i6));
        this.pOV = c37719fw;
        try {
            long longValue;
            int i7;
            HashMap hashMap2;
            if (this.cQO == 33 || this.cQO == 32) {
                C4990ab.m7411d("Micromsg.NetSceneTenpayRemittanceGen", "f2f desc: %s, recvDesc: %s", str4, str8);
                if (!C5046bo.isNullOrNil(str4)) {
                    hashMap.put("f2f_payer_desc", C18178q.encode(str4, "UTF-8"));
                }
                if (!C5046bo.isNullOrNil(str8)) {
                    hashMap.put("desc", C18178q.encode(str8, "UTF-8"));
                }
                if (!C5046bo.isNullOrNil(str11)) {
                    hashMap.put("dynamic_code_url", C18178q.encode(str11, "UTF-8"));
                }
                hashMap.put("transfer_qrcode_id", str9);
                if (i2 == 0 || i2 == 2) {
                    C1720g.m3537RQ();
                    longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(147457, Long.valueOf(0))).longValue();
                    i7 = 0;
                    if ((16 & longValue) == 0) {
                        i7 = 2;
                    } else if ((longValue & 32) != 0) {
                        i7 = 1;
                    }
                    hashMap.put("delay_confirm_flag", String.valueOf(i7));
                    C4990ab.m7411d("Micromsg.NetSceneTenpayRemittanceGen", "delay flag: %d", Integer.valueOf(i7));
                }
                mo70323M(hashMap);
                if (this.cQO == 32 || this.cQO == 33) {
                    hashMap2 = new HashMap();
                    hashMap2.put("channel", String.valueOf(i4));
                    mo70328ba(hashMap2);
                }
                AppMethodBeat.m2505o(44772);
            }
            if (!C5046bo.isNullOrNil(str4)) {
                hashMap.put("desc", C18178q.encode(str4, "UTF-8"));
            }
            if (C5046bo.m7563gW(i3, 0)) {
                if (!C5046bo.isNullOrNil(str5)) {
                    hashMap.put("address_name", C18178q.encode(str5, "UTF-8"));
                }
                if (!C5046bo.isNullOrNil(str6)) {
                    hashMap.put("phone_num", C18178q.encode(str6, "UTF-8"));
                }
                if (!C5046bo.isNullOrNil(str7)) {
                    hashMap.put("address", C18178q.encode(str7, "UTF-8"));
                }
            }
            hashMap.put("transfer_qrcode_id", str9);
            C1720g.m3537RQ();
            longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(147457, Long.valueOf(0))).longValue();
            i7 = 0;
            if ((16 & longValue) == 0) {
            }
            hashMap.put("delay_confirm_flag", String.valueOf(i7));
            C4990ab.m7411d("Micromsg.NetSceneTenpayRemittanceGen", "delay flag: %d", Integer.valueOf(i7));
            mo70323M(hashMap);
            hashMap2 = new HashMap();
            hashMap2.put("channel", String.valueOf(i4));
            mo70328ba(hashMap2);
            AppMethodBeat.m2505o(44772);
        } catch (UnsupportedEncodingException e) {
            C4990ab.m7413e("Micromsg.NetSceneTenpayRemittanceGen", e.getMessage(), e);
        }
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        if (this.cQO == 32 || this.cQO == 33) {
            return 1582;
        }
        return 1544;
    }

    public final int bgI() {
        return 0;
    }

    public final String getUri() {
        if (this.cQO == 32 || this.cQO == 33) {
            return "/cgi-bin/mmpay-bin/f2fplaceorder";
        }
        return "/cgi-bin/mmpay-bin/transferplaceorder";
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(44773);
        C4990ab.m7410d("Micromsg.NetSceneTenpayRemittanceGen", "errCode " + i + " errMsg: " + str);
        if (i == 0 || i == 2) {
            boolean z;
            JSONObject optJSONObject;
            if (jSONObject.has("used_fee")) {
                this.pPv = jSONObject.optDouble("used_fee");
            } else {
                C4990ab.m7412e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
            }
            this.cBT = jSONObject.optString("req_key");
            this.pPl = jSONObject.optInt("tansfering_num", 0);
            this.pPn = jSONObject.optString("transfer_interrupt_desc");
            this.pPo = jSONObject.optString("appmsgcontent");
            this.pPr = jSONObject.optString("transfer_interrupt_charge_desc");
            if (jSONObject.optInt("is_show_charge") == 1) {
                z = true;
            } else {
                z = false;
            }
            this.pPs = z;
            this.pPw = jSONObject.optString("receiver_true_name");
            this.pPx = jSONObject.optString("f2f_id", "");
            this.kBE = jSONObject.optString("trans_id", "");
            this.kDV = jSONObject.optString("extend_str", "");
            this.pPy = jSONObject.optString("receiver_open_id", "");
            this.nUf = jSONObject.optInt("amount", 0);
            this.cEa = jSONObject.optString("transfer_id", "");
            this.cAa = jSONObject.optString(C8741b.TRANSACTION_ID, "");
            this.pPC = jSONObject.optString("receiver_openid", "");
            if (C5046bo.isNullOrNil(this.pPw)) {
                C4990ab.m7412e("Micromsg.NetSceneTenpayRemittanceGen", "receiver_true_name is null");
            }
            if (jSONObject.has("remain_fee")) {
                this.pPt = jSONObject.optDouble("remain_fee");
            } else {
                C4990ab.m7412e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
            }
            if (jSONObject.has("exceed_fee")) {
                this.pPu = jSONObject.optDouble("exceed_fee");
            } else {
                C4990ab.m7412e("Micromsg.NetSceneTenpayRemittanceGen", "exceed_fee is null");
            }
            if (jSONObject.has("charge_fee")) {
                this.pPp = jSONObject.optDouble("charge_fee");
            } else {
                C4990ab.m7412e("Micromsg.NetSceneTenpayRemittanceGen", "charge_fee is null");
            }
            if (jSONObject.has("free_limit")) {
                this.pPq = jSONObject.optDouble("free_limit");
            } else {
                C4990ab.m7412e("Micromsg.NetSceneTenpayRemittanceGen", "free_limit is null");
            }
            if (jSONObject.has("showmessage")) {
                C4990ab.m7416i("Micromsg.NetSceneTenpayRemittanceGen", "has alert item");
                C29628a c29628a = new C29628a();
                optJSONObject = jSONObject.optJSONObject("showmessage");
                c29628a.nZb = optJSONObject.optString("left_button_wording");
                c29628a.nZc = optJSONObject.optString("right_button_wording");
                c29628a.kCs = optJSONObject.optString("right_button_url");
                this.cMO = c29628a;
                this.cMO.cEh = str;
            }
            if (jSONObject.has("fee")) {
                this.pPA = jSONObject.optString("fee");
            }
            if (jSONObject.has("double_check_wording")) {
                C4990ab.m7416i("Micromsg.NetSceneTenpayRemittanceGen", "has fee, show alert");
                this.pPB = jSONObject.optString("double_check_wording");
            }
            if (jSONObject.has("zaitu_message")) {
                C4990ab.m7416i("Micromsg.NetSceneTenpayRemittanceGen", "has zaitu_message");
                C39604a c39604a = new C39604a();
                optJSONObject = jSONObject.optJSONObject("zaitu_message");
                c39604a.cEh = optJSONObject.optString("wording");
                c39604a.pPN = optJSONObject.optString("open_button");
                c39604a.pPO = optJSONObject.optString("bill_url");
                C4990ab.m7411d("Micromsg.NetSceneTenpayRemittanceGen", "parseZaituMessage() wording:%s open_button:%s bill_url:%s", C5046bo.nullAsNil(c39604a.cEh), C5046bo.nullAsNil(c39604a.pPN), C5046bo.nullAsNil(c39604a.pPO));
                this.pPm = c39604a;
            }
            this.pPD = jSONObject.optInt("scan_scene", 0);
            this.pPE = jSONObject.optString("placeorder_suc_sign");
            this.pPF = jSONObject.optString("pay_suc_extend");
            if (TextUtils.isEmpty(this.pPo)) {
                C4990ab.m7412e("Micromsg.NetSceneTenpayRemittanceGen", "appmsgcontent is null");
            }
            this.pPG = jSONObject.optInt("get_dynamic_code_flag", 0);
            this.pPH = jSONObject.optString("get_dynamic_code_sign", "");
            this.pPI = jSONObject.optString("get_dynamic_code_extend", "");
            this.pPJ = jSONObject.optString("show_paying_wording", "");
            this.pPK = jSONObject.optString("dynamic_code_spam_wording", "");
            this.pPL = jSONObject.optInt("need_checkname", 0);
            this.nZf = jSONObject.optInt("return_to_session", 0);
            C4990ab.m7417i("Micromsg.NetSceneTenpayRemittanceGen", "return_to_session:%s", Integer.valueOf(this.nZf));
            JSONObject optJSONObject2 = jSONObject.optJSONObject("namemessage");
            if (optJSONObject2 != null) {
                this.pPM = new C7282rn();
                this.pPM.title = optJSONObject2.optString("title");
                this.pPM.pRD = optJSONObject2.optString("checkname_sign");
                this.pPM.pcw = optJSONObject2.optString(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
                this.pPM.cEh = optJSONObject2.optString("wording");
                this.pPM.vYN = optJSONObject2.optInt("message_type", 0);
            }
            AppMethodBeat.m2505o(44773);
            return;
        }
        AppMethodBeat.m2505o(44773);
    }

    public final boolean cfq() {
        return true;
    }
}
