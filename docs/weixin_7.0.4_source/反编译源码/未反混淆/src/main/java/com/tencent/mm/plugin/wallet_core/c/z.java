package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class z extends m {
    public Orders tux;

    public z(String str) {
        AppMethodBeat.i(46549);
        HashMap hashMap = new HashMap();
        hashMap.put("trans_id", str);
        M(hashMap);
        AppMethodBeat.o(46549);
    }

    public z(String str, int i) {
        AppMethodBeat.i(46550);
        HashMap hashMap = new HashMap();
        hashMap.put("trans_id", str);
        hashMap.put("pay_type", String.valueOf(i));
        M(hashMap);
        AppMethodBeat.o(46550);
    }

    public final int bgI() {
        return 3;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46551);
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2;
                this.tux = new Orders();
                Commodity commodity = new Commodity();
                commodity.pbX = jSONObject.getString("buy_uin");
                commodity.pbY = jSONObject.getString("buy_name");
                commodity.pbZ = jSONObject.optString("sale_uin");
                commodity.pca = jSONObject.optString("sale_name");
                commodity.cAa = jSONObject.getString("trans_id");
                commodity.desc = jSONObject.optString("goods_name");
                commodity.kCJ = jSONObject.optDouble("pay_num") / 100.0d;
                commodity.pce = jSONObject.getString("trade_state");
                commodity.pcf = jSONObject.getString("trade_state_name");
                commodity.pcj = jSONObject.getString("buy_bank_name");
                commodity.pcq = jSONObject.optString("discount", "");
                commodity.pch = jSONObject.optInt("modify_timestamp");
                commodity.pcl = jSONObject.optString("fee_type");
                commodity.pcm = jSONObject.optString("appusername");
                commodity.pbP = jSONObject.optString("app_telephone");
                commodity.tAR = jSONObject.optDouble("original_total_fee", -1.0d) / 100.0d;
                commodity.pcl = jSONObject.optString("fee_type", "");
                int i2 = 1;
                JSONObject optJSONObject = jSONObject.optJSONObject("subscribe_biz_info");
                if (optJSONObject != null) {
                    Promotions promotions = new Promotions();
                    promotions.type = Orders.tAP;
                    promotions.name = optJSONObject.optString("nickname");
                    promotions.pcm = optJSONObject.optString("username");
                    commodity.tAS = promotions.pcm;
                    promotions.pia = optJSONObject.optString("logo_round_url");
                    promotions.url = optJSONObject.optString("subscribe_biz_url");
                    i2 = optJSONObject.optInt("recommend_level");
                    commodity.tAh = i2;
                    if (!bo.isNullOrNil(promotions.name)) {
                        commodity.tBa.add(promotions);
                    }
                }
                int i3 = i2;
                JSONArray jSONArray = jSONObject.getJSONArray("activity_info");
                int length = jSONArray.length();
                for (i2 = 0; i2 < length; i2++) {
                    jSONObject2 = jSONArray.getJSONObject(i2);
                    Promotions promotions2 = new Promotions();
                    promotions2.type = Orders.tAQ;
                    promotions2.pia = jSONObject2.optString("icon");
                    promotions2.name = jSONObject2.optString("wording");
                    promotions2.url = jSONObject2.optString("url");
                    promotions2.tzS = jSONObject2.optString("btn_text");
                    promotions2.tBn = jSONObject2.optInt("type");
                    promotions2.title = jSONObject2.optString("title");
                    promotions2.ttW = jSONObject2.optLong("activity_id");
                    promotions2.uZM = jSONObject2.optInt("activity_type", 0);
                    promotions2.uZN = jSONObject2.optInt("award_id");
                    promotions2.tzP = jSONObject2.optInt("send_record_id");
                    promotions2.tzQ = jSONObject2.optInt("user_record_id");
                    promotions2.uZP = jSONObject2.optString("activity_tinyapp_username");
                    promotions2.uZQ = jSONObject2.optString("activity_tinyapp_path");
                    promotions2.tzR = jSONObject2.optLong("activity_mch_id");
                    promotions2.uZR = jSONObject2.optInt("activity_tinyapp_version");
                    promotions2.uZS = jSONObject2.optString("get_award_params");
                    promotions2.uZT = jSONObject2.optString("query_award_status_params");
                    Orders.a(promotions2, jSONObject2.optJSONObject("exposure_info"));
                    commodity.tBa.add(promotions2);
                }
                jSONArray = jSONObject.optJSONArray("discount_array");
                if (jSONArray != null && jSONArray.length() > 0) {
                    length = jSONArray.length();
                    commodity.tAU = new ArrayList();
                    for (i2 = 0; i2 < length; i2++) {
                        jSONObject2 = jSONArray.optJSONObject(i2);
                        DiscountInfo discountInfo = new DiscountInfo();
                        discountInfo.tBm = jSONObject2.optDouble("payment_amount");
                        discountInfo.pOz = jSONObject2.optString("favor_desc");
                        commodity.tAU.add(discountInfo);
                    }
                }
                commodity.tAV = jSONObject.optString("rateinfo");
                commodity.tAW = jSONObject.optString("discount_rateinfo");
                commodity.tAX = jSONObject.optString("original_feeinfo");
                this.tux.tAq = new ArrayList();
                this.tux.tAq.add(commodity);
                this.tux.tAj = jSONObject.optString("trade_state_name");
                this.tux.tAh = i3;
                AppMethodBeat.o(46551);
                return;
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.NetSceneTenpayQueryOrderInfo", e, "", new Object[0]);
                AppMethodBeat.o(46551);
                return;
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.NetSceneTenpayQueryOrderInfo", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(46551);
    }
}
