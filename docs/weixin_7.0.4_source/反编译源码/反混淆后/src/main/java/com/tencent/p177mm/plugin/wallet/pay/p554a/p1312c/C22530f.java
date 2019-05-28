package com.tencent.p177mm.plugin.wallet.pay.p554a.p1312c;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet.pay.p554a.C35446d;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C43804af;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C24144d;
import com.tencent.p177mm.wallet_core.p649c.C30862w;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.pay.a.c.f */
public class C22530f extends C5749m {
    public String aIm;
    private int cIf = 0;
    public String cRb;
    public String cRc;
    public String cRd;
    public String cRe;
    public String cRf;
    public Orders pWy = null;
    private int scene = 0;
    private String tos = null;
    public int tot = 0;
    public C35446d tou = null;

    public C22530f(PayInfo payInfo, int i) {
        AppMethodBeat.m2504i(45938);
        if (payInfo == null) {
            C4990ab.m7413e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "error payinfo is null %s", C5046bo.dpG().toString());
            this.tos = "";
        } else {
            this.tos = payInfo.czZ;
        }
        this.scene = i;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap.put("support_cardtag3", "1");
        hashMap.put("req_key", this.tos);
        hashMap.put("bind_query_scene", String.valueOf(i));
        hashMap.put("is_merge", "1");
        C30052l c30052l = (C30052l) C1720g.m3528K(C30052l.class);
        hashMap.put("is_root", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (c30052l == null || !(c30052l.bxo() || c30052l.bxB())) {
            hashMap.put("is_device_open_touch", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            C4990ab.m7416i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "is_device_open_touch is false");
        } else {
            hashMap.put("is_device_open_touch", "1");
            Map bxw = c30052l.bxw();
            if (bxw != null) {
                hashMap.putAll(bxw);
            }
            C4990ab.m7416i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "is_device_open_touch is true");
        }
        if (payInfo != null) {
            this.cIf = payInfo.cIf;
        }
        mo70324a(payInfo, (Map) hashMap, (Map) hashMap2);
        mo70323M(hashMap);
        mo70328ba(hashMap2);
        AppMethodBeat.m2505o(45938);
    }

    public final int bgI() {
        return 112;
    }

    /* renamed from: a */
    public final void mo26460a(C24144d c24144d, JSONObject jSONObject) {
        AppMethodBeat.m2504i(45939);
        super.mo26460a(c24144d, jSONObject);
        int i = this.cIf;
        String str = this.tos;
        int i2 = c24144d.errCode;
        C4990ab.m7419v("Micromsg.WalletPayLinkReport", "kvQrcode scene %s reqKey %s errcode %s", Integer.valueOf(i), str, Integer.valueOf(i2));
        C7060h.pYm.mo8381e(15000, Integer.valueOf(i), str, Integer.valueOf(i2));
        AppMethodBeat.m2505o(45939);
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(45940);
        try {
            int cQm;
            this.aIm = str;
            this.pWy = Orders.m68762ap(jSONObject);
            if (this.pWy != null) {
                this.pWy.czZ = this.tos;
            }
            long optLong = jSONObject.optJSONObject("bindqueryresp").optLong("time_stamp");
            if (optLong > 0) {
                C30862w.setTimeStamp(String.valueOf(optLong));
            } else {
                C4990ab.m7420w("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "no time_stamp in qrcodeusebindquery.");
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("query_order_info");
            if (optJSONObject != null) {
                C4990ab.m7416i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "get query_order_info");
                C14241r.cPI().tDe = optJSONObject.optInt("query_order_time", 5) * 1000;
                C14241r.cPI().mRetryCount = optJSONObject.optInt("query_order_count", 0);
                C14241r.cPI().tDf = optJSONObject.optString("default_query_order_wording", "");
            }
            C14241r.cPI().tDg = jSONObject.optString("pay_remind_wording");
            C43804af.m78521a(jSONObject.optJSONObject("bindqueryresp"), this.cIf, false);
            C30052l c30052l = (C30052l) C1720g.m3528K(C30052l.class);
            if (c30052l != null) {
                C4990ab.m7416i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "IFingerPrintMgr is not null");
                c30052l.bxp();
                cQm = C14241r.cPI().cQm();
                if (cQm == 0) {
                    if (c30052l.bxn()) {
                        c30052l.mo48312hq(C14241r.cPI().cQk());
                        c30052l.mo48313hr(false);
                    } else if (c30052l.bxA()) {
                        c30052l.mo48313hr(C14241r.cPI().cQk());
                        c30052l.mo48312hq(false);
                    }
                } else if (cQm == 1 && c30052l.bxn()) {
                    c30052l.mo48312hq(C14241r.cPI().cQk());
                    c30052l.mo48313hr(false);
                } else if (cQm == 2 && c30052l.bxA()) {
                    c30052l.mo48313hr(C14241r.cPI().cQk());
                    c30052l.mo48312hq(false);
                }
            } else {
                C4990ab.m7412e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "IFingerPrintMgr is null");
            }
            if (jSONObject.has("real_name_info")) {
                optJSONObject = jSONObject.optJSONObject("real_name_info");
                this.cRb = optJSONObject.optString("guide_flag");
                this.cRc = optJSONObject.optString("guide_wording");
                this.cRd = optJSONObject.optString("left_button_wording");
                this.cRe = optJSONObject.optString("right_button_wording");
                this.cRf = optJSONObject.optString("upload_credit_url");
                this.tot = optJSONObject.optInt("guide_type", 0);
            }
            if (jSONObject.has("user_notify_info")) {
                C35446d c35446d;
                optJSONObject = jSONObject.optJSONObject("user_notify_info");
                if (optJSONObject == null) {
                    c35446d = null;
                } else {
                    cQm = optJSONObject.optInt("notify_flag", 0);
                    String optString = optJSONObject.optString("notify_wording", "");
                    String optString2 = optJSONObject.optString("left_button_wording", "");
                    String optString3 = optJSONObject.optString("right_button_wording", "");
                    String optString4 = optJSONObject.optString("confirm_button_wording", "");
                    if (cQm == 0) {
                        c35446d = null;
                    } else {
                        c35446d = new C35446d();
                        c35446d.tob = cQm;
                        c35446d.toc = optString;
                        c35446d.nZb = optString2;
                        c35446d.nZc = optString3;
                        c35446d.tod = optString4;
                    }
                }
                this.tou = c35446d;
            }
            AppMethodBeat.m2505o(45940);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "hy: " + e.toString());
            AppMethodBeat.m2505o(45940);
        }
    }

    /* renamed from: ZU */
    public int mo9382ZU() {
        return 1593;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/qrcodeusebindquery";
    }
}
