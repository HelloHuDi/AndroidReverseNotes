package com.tencent.mm.plugin.wallet.pay.a.c;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.pay.a.d;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class f extends m {
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
    public d tou = null;

    public f(PayInfo payInfo, int i) {
        AppMethodBeat.i(45938);
        if (payInfo == null) {
            ab.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "error payinfo is null %s", bo.dpG().toString());
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
        l lVar = (l) g.K(l.class);
        hashMap.put("is_root", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (lVar == null || !(lVar.bxo() || lVar.bxB())) {
            hashMap.put("is_device_open_touch", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            ab.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "is_device_open_touch is false");
        } else {
            hashMap.put("is_device_open_touch", "1");
            Map bxw = lVar.bxw();
            if (bxw != null) {
                hashMap.putAll(bxw);
            }
            ab.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "is_device_open_touch is true");
        }
        if (payInfo != null) {
            this.cIf = payInfo.cIf;
        }
        a(payInfo, (Map) hashMap, (Map) hashMap2);
        M(hashMap);
        ba(hashMap2);
        AppMethodBeat.o(45938);
    }

    public final int bgI() {
        return 112;
    }

    public final void a(com.tencent.mm.wallet_core.c.d dVar, JSONObject jSONObject) {
        AppMethodBeat.i(45939);
        super.a(dVar, jSONObject);
        int i = this.cIf;
        String str = this.tos;
        int i2 = dVar.errCode;
        ab.v("Micromsg.WalletPayLinkReport", "kvQrcode scene %s reqKey %s errcode %s", Integer.valueOf(i), str, Integer.valueOf(i2));
        h.pYm.e(15000, Integer.valueOf(i), str, Integer.valueOf(i2));
        AppMethodBeat.o(45939);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(45940);
        try {
            int cQm;
            this.aIm = str;
            this.pWy = Orders.ap(jSONObject);
            if (this.pWy != null) {
                this.pWy.czZ = this.tos;
            }
            long optLong = jSONObject.optJSONObject("bindqueryresp").optLong("time_stamp");
            if (optLong > 0) {
                w.setTimeStamp(String.valueOf(optLong));
            } else {
                ab.w("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "no time_stamp in qrcodeusebindquery.");
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("query_order_info");
            if (optJSONObject != null) {
                ab.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "get query_order_info");
                r.cPI().tDe = optJSONObject.optInt("query_order_time", 5) * 1000;
                r.cPI().mRetryCount = optJSONObject.optInt("query_order_count", 0);
                r.cPI().tDf = optJSONObject.optString("default_query_order_wording", "");
            }
            r.cPI().tDg = jSONObject.optString("pay_remind_wording");
            af.a(jSONObject.optJSONObject("bindqueryresp"), this.cIf, false);
            l lVar = (l) g.K(l.class);
            if (lVar != null) {
                ab.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "IFingerPrintMgr is not null");
                lVar.bxp();
                cQm = r.cPI().cQm();
                if (cQm == 0) {
                    if (lVar.bxn()) {
                        lVar.hq(r.cPI().cQk());
                        lVar.hr(false);
                    } else if (lVar.bxA()) {
                        lVar.hr(r.cPI().cQk());
                        lVar.hq(false);
                    }
                } else if (cQm == 1 && lVar.bxn()) {
                    lVar.hq(r.cPI().cQk());
                    lVar.hr(false);
                } else if (cQm == 2 && lVar.bxA()) {
                    lVar.hr(r.cPI().cQk());
                    lVar.hq(false);
                }
            } else {
                ab.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "IFingerPrintMgr is null");
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
                d dVar;
                optJSONObject = jSONObject.optJSONObject("user_notify_info");
                if (optJSONObject == null) {
                    dVar = null;
                } else {
                    cQm = optJSONObject.optInt("notify_flag", 0);
                    String optString = optJSONObject.optString("notify_wording", "");
                    String optString2 = optJSONObject.optString("left_button_wording", "");
                    String optString3 = optJSONObject.optString("right_button_wording", "");
                    String optString4 = optJSONObject.optString("confirm_button_wording", "");
                    if (cQm == 0) {
                        dVar = null;
                    } else {
                        dVar = new d();
                        dVar.tob = cQm;
                        dVar.toc = optString;
                        dVar.nZb = optString2;
                        dVar.nZc = optString3;
                        dVar.tod = optString4;
                    }
                }
                this.tou = dVar;
            }
            AppMethodBeat.o(45940);
        } catch (Exception e) {
            ab.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "hy: " + e.toString());
            AppMethodBeat.o(45940);
        }
    }

    public int ZU() {
        return 1593;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/qrcodeusebindquery";
    }
}
