package com.tencent.p177mm.wallet_core.tenpay.model;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.SetPwdInfo;
import com.tencent.p177mm.plugin.wallet_core.model.Authen;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C24144d;
import com.tencent.p177mm.wallet_core.p649c.C44426i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.wallet_core.tenpay.model.n */
public abstract class C30875n extends C46723p implements C44426i {
    private static int AgF = 0;
    protected Map<String, String> AgD = new HashMap();
    public int AgE = 0;
    private boolean AgG = false;
    public int AgH = 0;
    public int AgI = 0;
    public String AgJ = null;
    public JSONObject AgK = null;
    private boolean AgL = false;
    public int AgM = -1;
    protected int cQO;
    public RealnameGuideHelper oYc;
    private String oYd;
    private String oYe;
    private String oYf;
    private String oYg;
    private String oYh;
    public int tAz = 0;
    public String tqG;

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo49383a(String str, String str2, int i, int i2, String str3, String str4) {
        AgF++;
        this.AgD.put("req_key", str);
        this.AgD.put(C8741b.TRANSACTION_ID, str2);
        this.AgD.put("pay_scene", String.valueOf(i));
        this.AgD.put("bank_type", str3);
        this.AgD.put("channel", String.valueOf(i2));
        this.AgD.put("bind_serial", str4);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo49382a(Orders orders, Authen authen) {
        List list = orders.tAq;
        String str = null;
        if (list.size() > 0) {
            str = ((Commodity) list.get(0)).cAa;
        }
        mo49383a(orders.czZ, str, authen.pGr.cIf, authen.pGr.cIb, authen.pbn, authen.pbo);
    }

    public final Map<String, String> dOr() {
        return this.AgD;
    }

    /* renamed from: a */
    public void mo9383a(int i, String str, JSONObject jSONObject) {
        boolean z;
        JSONObject optJSONObject;
        if (!this.AgG) {
            this.AgI = i;
            this.AgJ = str;
            this.AgK = jSONObject;
            this.AgG = true;
            if (jSONObject != null) {
                this.AgE = jSONObject.optInt("query_order_flag", 0);
            }
        }
        if (jSONObject == null || !jSONObject.has("real_name_info")) {
            z = false;
        } else {
            optJSONObject = jSONObject.optJSONObject("real_name_info");
            this.oYd = optJSONObject.optString("guide_flag");
            this.oYe = optJSONObject.optString("guide_wording");
            this.oYf = optJSONObject.optString("left_button_wording");
            this.oYg = optJSONObject.optString("right_button_wording");
            this.oYh = optJSONObject.optString("upload_credit_url");
            z = true;
        }
        SetPwdInfo setPwdInfo = null;
        if (jSONObject != null && jSONObject.has("set_pwd_info")) {
            optJSONObject = jSONObject.optJSONObject("set_pwd_info");
            setPwdInfo = new SetPwdInfo();
            setPwdInfo.nZa = optJSONObject.optString("guide_wording");
            setPwdInfo.nZb = optJSONObject.optString("left_button_wording");
            setPwdInfo.nZc = optJSONObject.optString("right_button_wording");
            setPwdInfo.twa = optJSONObject.optInt("send_pwd_msg");
            z = true;
        }
        if (z && ("1".equals(this.oYd) || "2".equals(this.oYd) || setPwdInfo != null)) {
            this.oYc = new RealnameGuideHelper();
            this.oYc.mo74570a(this.oYd, setPwdInfo, this.oYe, this.oYf, this.oYg, this.oYh, this.cQO);
        }
        this.tqG = jSONObject.optString("forget_pwd_url", "");
        this.AgM = jSONObject.optInt("is_clear_failure", -1);
        C4990ab.m7417i("MicroMsg.NetSceneTenpayDelayQueryBase", "forget_pwd_url %s", this.tqG);
        this.AgL = true;
        super.mo9383a(i, str, jSONObject);
    }

    public final boolean dOs() {
        return this.AgE == 1;
    }

    /* renamed from: a */
    public void mo26460a(C24144d c24144d, JSONObject jSONObject) {
        C4990ab.m7417i("MicroMsg.NetSceneTenpayDelayQueryBase", "always callback: %s,%s", Integer.valueOf(c24144d.errCode), c24144d.aIm);
        super.mo26460a(c24144d, jSONObject);
        if (!this.AgL && !this.AgG) {
            this.AgH = c24144d.errType;
            this.AgI = c24144d.errCode;
            this.AgJ = c24144d.aIm;
            if (jSONObject != null) {
                this.AgE = jSONObject.optInt("query_order_flag", 0);
                this.AgK = jSONObject;
            }
            this.AgG = true;
        }
    }

    public boolean cNK() {
        return false;
    }

    public final boolean dOi() {
        return false;
    }
}
