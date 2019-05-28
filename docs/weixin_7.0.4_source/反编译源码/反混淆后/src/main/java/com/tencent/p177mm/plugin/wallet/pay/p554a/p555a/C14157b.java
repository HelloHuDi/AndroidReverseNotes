package com.tencent.p177mm.plugin.wallet.pay.p554a.p555a;

import com.facebook.appevents.UserDataStore;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.wallet.pay.p554a.C46349b;
import com.tencent.p177mm.plugin.wallet_core.model.Authen;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.utils.C40147b;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p649c.C24144d;
import com.tencent.p177mm.wallet_core.p649c.C36379x;
import com.tencent.p177mm.wallet_core.tenpay.model.C30875n;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.pay.a.a.b */
public class C14157b extends C30875n {
    private Map<String, String> oYG;
    private Map<String, String> toe;
    public boolean tof;
    public Orders tog;
    public Authen toh;
    public String toi;
    public String toj;
    private String tok;
    public String token;
    public int tol;
    public String tom;
    public int ton;
    public JSONArray too;

    public C14157b(Authen authen, Orders orders) {
        this(authen, orders, false);
    }

    public C14157b(Authen authen, Orders orders, boolean z) {
        this(authen, orders, z, (byte) 0);
    }

    private C14157b(Authen authen, Orders orders, boolean z, byte b) {
        boolean z2 = true;
        AppMethodBeat.m2504i(45921);
        this.tof = false;
        this.tog = null;
        this.token = null;
        this.toi = null;
        this.toj = null;
        this.tok = null;
        this.tol = 0;
        this.ton = 0;
        this.toh = authen;
        this.tog = orders;
        IllegalArgumentException illegalArgumentException;
        if (authen == null) {
            illegalArgumentException = new IllegalArgumentException("authen == null");
            AppMethodBeat.m2505o(45921);
            throw illegalArgumentException;
        }
        mo49382a(orders, authen);
        if (authen.pGr == null) {
            illegalArgumentException = new IllegalArgumentException("authen.payInfo == null");
            AppMethodBeat.m2505o(45921);
            throw illegalArgumentException;
        }
        C4990ab.m7416i("MicroMsg.NetSceneTenpayAuthen", "pay channel :" + authen.pGr.cIb);
        this.oYG = new HashMap();
        this.toe = new HashMap();
        boolean z3 = (z || C5046bo.isNullOrNil(this.toh.twc)) ? false : true;
        C4990ab.m7417i("MicroMsg.NetSceneTenpayAuthen", "hy: has pwd: %b", Boolean.valueOf(z3));
        mo70325a(authen.pGr, this.oYG, this.toe, z3);
        if (z) {
            this.oYG.put("brief_reg", "1");
        } else {
            this.oYG.put("passwd", authen.twc);
        }
        this.tAz = orders.tAz;
        this.oYG.put("default_favorcomposedid", authen.twn);
        this.oYG.put("favorcomposedid", authen.two);
        this.oYG.put("arrive_type", authen.twk);
        this.oYG.put("sms_flag", authen.twp);
        this.oYG.put("ban_sms_bind_serial", authen.twq);
        this.oYG.put("ban_sms_bank_type", authen.twr);
        this.oYG.put("busi_sms_flag", authen.tws);
        this.oYG.put("buttontype", authen.pGr.vwn);
        this.oYG.put("mobile_area", authen.twt);
        C4990ab.m7417i("MicroMsg.NetSceneTenpayAuthen", "buttontype %s not_support_retry %s, mobile area: %s", Integer.valueOf(authen.pGr.vwn), Integer.valueOf(this.tAz), authen.twt);
        switch (authen.bJt) {
            case 1:
                this.oYG.put("flag", "1");
                this.oYG.put("bank_type", authen.pbn);
                this.oYG.put("true_name", authen.twd);
                this.oYG.put("identify_card", authen.twe);
                if (authen.twf > 0) {
                    this.oYG.put("cre_type", authen.twf);
                }
                this.oYG.put("mobile_no", authen.tuk);
                this.oYG.put("bank_card_id", authen.twg);
                if (!C5046bo.isNullOrNil(authen.twh)) {
                    this.oYG.put("cvv2", authen.twh);
                }
                if (!C5046bo.isNullOrNil(authen.twi)) {
                    this.oYG.put("valid_thru", authen.twi);
                }
                this.oYG.put("creid_renewal", String.valueOf(authen.twu));
                this.oYG.put("birth_date", authen.twv);
                this.oYG.put("cre_expire_date", authen.tww);
                break;
            case 2:
                this.oYG.put("flag", "2");
                this.oYG.put("bank_type", authen.pbn);
                this.oYG.put("h_bind_serial", authen.pbo);
                this.oYG.put("card_tail", authen.twj);
                if (!C5046bo.isNullOrNil(authen.twd)) {
                    this.oYG.put("true_name", authen.twd);
                }
                if (!C5046bo.isNullOrNil(authen.twe)) {
                    this.oYG.put("identify_card", authen.twe);
                }
                this.oYG.put("cre_type", authen.twf);
                this.oYG.put("mobile_no", authen.tuk);
                this.oYG.put("bank_card_id", authen.twg);
                if (!C5046bo.isNullOrNil(authen.twh)) {
                    this.oYG.put("cvv2", authen.twh);
                }
                if (!C5046bo.isNullOrNil(authen.twi)) {
                    this.oYG.put("valid_thru", authen.twi);
                }
                this.oYG.put("creid_renewal", String.valueOf(authen.twu));
                this.oYG.put("birth_date", authen.twv);
                this.oYG.put("cre_expire_date", authen.tww);
                break;
            case 3:
                if (authen.twb == 1) {
                    this.oYG.put("reset_flag", "1");
                    if (!C5046bo.isNullOrNil(authen.tuk)) {
                        this.oYG.put("mobile_no", authen.tuk);
                    }
                    if (!C5046bo.isNullOrNil(authen.twh)) {
                        this.oYG.put("cvv2", authen.twh);
                    }
                    if (!C5046bo.isNullOrNil(authen.twi)) {
                        this.oYG.put("valid_thru", authen.twi);
                    }
                }
                this.oYG.put("flag", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                this.oYG.put("bank_type", authen.pbn);
                this.oYG.put("bind_serial", authen.pbo);
                break;
            case 4:
                this.oYG.put("flag", "4");
                this.oYG.put("bank_type", authen.pbn);
                this.oYG.put("first_name", authen.twl);
                this.oYG.put("last_name", authen.twm);
                this.oYG.put(UserDataStore.COUNTRY, authen.country);
                this.oYG.put("area", authen.duc);
                this.oYG.put("city", authen.dud);
                this.oYG.put("address", authen.fBg);
                this.oYG.put("phone_number", authen.nuN);
                this.oYG.put("zip_code", authen.gIO);
                this.oYG.put(Scopes.EMAIL, authen.dtV);
                this.oYG.put("bank_card_id", authen.twg);
                if (!C5046bo.isNullOrNil(authen.twh)) {
                    this.oYG.put("cvv2", authen.twh);
                }
                if (!C5046bo.isNullOrNil(authen.twi)) {
                    this.oYG.put("valid_thru", authen.twi);
                    break;
                }
                break;
            case 5:
                this.oYG.put("flag", "5");
                this.oYG.put("bank_type", authen.pbn);
                this.oYG.put("first_name", authen.twl);
                this.oYG.put("last_name", authen.twm);
                this.oYG.put(UserDataStore.COUNTRY, authen.country);
                this.oYG.put("area", authen.duc);
                this.oYG.put("city", authen.dud);
                this.oYG.put("address", authen.fBg);
                this.oYG.put("phone_number", authen.nuN);
                this.oYG.put("zip_code", authen.gIO);
                this.oYG.put(Scopes.EMAIL, authen.dtV);
                this.oYG.put("bank_card_id", authen.twg);
                if (!C5046bo.isNullOrNil(authen.twh)) {
                    this.oYG.put("cvv2", authen.twh);
                }
                if (!C5046bo.isNullOrNil(authen.twi)) {
                    this.oYG.put("valid_thru", authen.twi);
                }
                this.oYG.put("h_bind_serial", authen.pbo);
                this.oYG.put("card_tail", authen.twj);
                break;
            case 6:
                if (authen.twb == 1) {
                    this.oYG.put("reset_flag", "1");
                    if (!C5046bo.isNullOrNil(authen.twh)) {
                        this.oYG.put("cvv2", authen.twh);
                    }
                    if (!C5046bo.isNullOrNil(authen.twi)) {
                        this.oYG.put("valid_thru", authen.twi);
                    }
                }
                this.oYG.put("phone_number", authen.tuk);
                this.oYG.put("flag", "6");
                this.oYG.put("bank_type", authen.pbn);
                this.oYG.put("bind_serial", authen.pbo);
                break;
        }
        mo9384aj(this.oYG);
        mo70323M(this.oYG);
        Map bxy = ((C30052l) C1720g.m3528K(C30052l.class)).bxy();
        if (bxy != null) {
            this.toe.putAll(bxy);
        }
        String str = authen.pGr.vwp;
        int i = authen.pGr.aPn ? 2 : 1;
        if (authen.pGr.tKd != 1) {
            z2 = false;
        }
        C46349b.m87111r(str, i, z2);
        if (C36379x.dNS()) {
            this.toe.put("uuid_for_bindcard", C36379x.dNU());
            this.toe.put("bindcard_scene", C36379x.dNT());
        }
        mo70328ba(this.toe);
        AppMethodBeat.m2505o(45921);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: aj */
    public void mo9384aj(Map<String, String> map) {
    }

    public final boolean bXl() {
        AppMethodBeat.m2504i(45922);
        super.bXl();
        this.oYG.put("is_repeat_send", "1");
        mo70323M(this.oYG);
        AppMethodBeat.m2505o(45922);
        return true;
    }

    public int bgI() {
        return 0;
    }

    /* renamed from: a */
    public void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(45923);
        super.mo9383a(i, str, jSONObject);
        C4990ab.m7416i("MicroMsg.NetSceneTenpayAuthen", " errCode: " + i + " errMsg :" + str);
        C4990ab.m7411d("MicroMsg.NetSceneTenpayAuthen", "banlance_mobile: %s", this.toi);
        this.tof = "1".equals(jSONObject.optString("is_free_sms"));
        this.token = jSONObject.optString("token");
        this.toi = jSONObject.optString("balance_mobile");
        this.toj = jSONObject.optString("balance_help_url");
        this.tok = jSONObject.optString("modify_mobile_url");
        String optString = jSONObject.optString("bind_serial");
        if (!C5046bo.isNullOrNil(optString)) {
            C4990ab.m7416i("MicroMsg.NetSceneTenpayAuthen", "Pay Success! saving bind_serial:".concat(String.valueOf(optString)));
        }
        if ("1".equals(jSONObject.optString("pay_flag"))) {
            this.tpw = true;
            this.tog = Orders.m68757a(jSONObject, this.tog);
        } else {
            this.tpw = false;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("verify_cre_tail_info");
        if (optJSONObject != null) {
            this.tol = optJSONObject.optInt("is_can_verify_tail", 0);
            this.tom = optJSONObject.optString("verify_tail_wording");
        }
        this.ton = jSONObject.optInt("no_reset_mobile", 0);
        C4990ab.m7416i("MicroMsg.NetSceneTenpayAuthen", "pay_scene:" + this.toh.pGr.cIf);
        if (this.toh.pGr.cIf == 21) {
            this.too = jSONObject.optJSONArray("fetch_charge_show_info");
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_FETCH_CHARGE_RATE_VERSION_STRING_SYNC, jSONObject.optString("charge_rate_version"));
        }
        if (i == 0 && this.toh.pGr.cIf == 39) {
            C4990ab.m7416i("MicroMsg.NetSceneTenpayAuthen", "it's the sns scene, parse the sns pay data");
            C40147b.m68846aK(jSONObject);
        } else {
            C4990ab.m7416i("MicroMsg.NetSceneTenpayAuthen", "it's not the sns scene or occurs error,  errCode:".concat(String.valueOf(i)));
        }
        for (C40931c c40931c : C24143a.atm("PayProcess")) {
            c40931c.mqu.putInt("key_is_clear_failure", this.AgM);
        }
        AppMethodBeat.m2505o(45923);
    }

    /* renamed from: a */
    public final void mo26460a(C24144d c24144d, JSONObject jSONObject) {
        int i = 2;
        AppMethodBeat.m2504i(45924);
        super.mo26460a(c24144d, jSONObject);
        String str;
        if (this.AfF != 0 || this.AfG != 0) {
            str = this.toh.pGr.vwp;
            if (!this.toh.pGr.aPn) {
                i = 1;
            }
            C46349b.m87110dr(str, i);
            C46349b.m87109bz(this.toh.pGr.vwp, this.AfM);
        } else if (this.tpw) {
            str = this.toh.pGr.vwp;
            if (!this.toh.pGr.aPn) {
                i = 1;
            }
            C46349b.m87110dr(str, i);
            C46349b.m87109bz(this.toh.pGr.vwp, this.AfM);
            AppMethodBeat.m2505o(45924);
            return;
        }
        AppMethodBeat.m2505o(45924);
    }

    public final String getToken() {
        return this.token;
    }

    public String getUri() {
        if (this.toh.pGr.cIf == 11) {
            return "/cgi-bin/mmpay-bin/tenpay/saveauthen";
        }
        if (this.toh.pGr.cIf == 21) {
            return "/cgi-bin/mmpay-bin/tenpay/fetchauthen";
        }
        return "/cgi-bin/mmpay-bin/tenpay/authen";
    }

    /* renamed from: ZU */
    public int mo9382ZU() {
        if (this.toh.pGr.cIf == 11) {
            return 1610;
        }
        if (this.toh.pGr.cIf == 21) {
            return 1605;
        }
        return 461;
    }

    public final boolean cNJ() {
        return this.toh.pGr.tKd == 1;
    }

    public final boolean cNK() {
        if (this.toh.pGr.cIf == 11 || this.toh.pGr.cIf == 21) {
            return true;
        }
        return false;
    }
}
