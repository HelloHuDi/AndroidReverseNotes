package com.tencent.mm.wallet_core.tenpay.model;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.id_verify.util.SetPwdInfo;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public abstract class n extends p implements i {
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
    public final void a(String str, String str2, int i, int i2, String str3, String str4) {
        AgF++;
        this.AgD.put("req_key", str);
        this.AgD.put(b.TRANSACTION_ID, str2);
        this.AgD.put("pay_scene", String.valueOf(i));
        this.AgD.put("bank_type", str3);
        this.AgD.put("channel", String.valueOf(i2));
        this.AgD.put("bind_serial", str4);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(Orders orders, Authen authen) {
        List list = orders.tAq;
        String str = null;
        if (list.size() > 0) {
            str = ((Commodity) list.get(0)).cAa;
        }
        a(orders.czZ, str, authen.pGr.cIf, authen.pGr.cIb, authen.pbn, authen.pbo);
    }

    public final Map<String, String> dOr() {
        return this.AgD;
    }

    public void a(int i, String str, JSONObject jSONObject) {
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
            this.oYc.a(this.oYd, setPwdInfo, this.oYe, this.oYf, this.oYg, this.oYh, this.cQO);
        }
        this.tqG = jSONObject.optString("forget_pwd_url", "");
        this.AgM = jSONObject.optInt("is_clear_failure", -1);
        ab.i("MicroMsg.NetSceneTenpayDelayQueryBase", "forget_pwd_url %s", this.tqG);
        this.AgL = true;
        super.a(i, str, jSONObject);
    }

    public final boolean dOs() {
        return this.AgE == 1;
    }

    public void a(d dVar, JSONObject jSONObject) {
        ab.i("MicroMsg.NetSceneTenpayDelayQueryBase", "always callback: %s,%s", Integer.valueOf(dVar.errCode), dVar.aIm);
        super.a(dVar, jSONObject);
        if (!this.AgL && !this.AgG) {
            this.AgH = dVar.errType;
            this.AgI = dVar.errCode;
            this.AgJ = dVar.aIm;
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
