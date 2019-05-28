package com.tencent.mm.plugin.wallet_core.c.c;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public final class a extends m {
    private int tuK;
    public Orders tuL;

    public a(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7) {
        Object str8;
        Object str22;
        Object str32;
        Object str42;
        Object str52;
        Object str62;
        Object str72;
        AppMethodBeat.i(46572);
        this.tuK = i;
        HashMap hashMap = new HashMap();
        String str9 = "appId";
        if (!bo.isNullOrNil(str8)) {
            str8 = q.encode(str8);
        }
        hashMap.put(str9, str8);
        str9 = "timeStamp";
        if (!bo.isNullOrNil(str22)) {
            str22 = q.encode(str22);
        }
        hashMap.put(str9, str22);
        str9 = "nonceStr";
        if (!bo.isNullOrNil(str32)) {
            str32 = q.encode(str32);
        }
        hashMap.put(str9, str32);
        str9 = "package";
        if (!bo.isNullOrNil(str42)) {
            str42 = q.encode(str42);
        }
        hashMap.put(str9, str42);
        str9 = "reqKey";
        if (!bo.isNullOrNil(str52)) {
            str52 = q.encode(str52);
        }
        hashMap.put(str9, str52);
        hashMap.put("payScene", q.encode(String.valueOf(i)));
        str9 = "signType";
        if (!bo.isNullOrNil(str62)) {
            str62 = q.encode(str62);
        }
        hashMap.put(str9, str62);
        str9 = "paySign";
        if (!bo.isNullOrNil(str72)) {
            str72 = q.encode(str72);
        }
        hashMap.put(str9, str72);
        M(hashMap);
        AppMethodBeat.o(46572);
    }

    public final String getUri() {
        String str = "/cgi-bin/mmpay-bin/tenpay/getpaidorderdetail";
        if (this.tuK == 2) {
            return "/cgi-bin/mmpay-bin/tenpay/offlinegetpaidorderdetail";
        }
        return str;
    }

    public final int bgI() {
        if (this.tuK == 2) {
            return 2516;
        }
        return 2570;
    }

    public final int ZU() {
        if (this.tuK == 2) {
            return 2516;
        }
        return 2570;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46573);
        Log.i("MicroMsg.NetSceneGetPaidOrderDetail", "errCode: " + i + " errMsg: " + str);
        if (jSONObject != null && dNO()) {
            this.tuL = ap(jSONObject);
            this.tuL = Orders.a(jSONObject, this.tuL);
        }
        AppMethodBeat.o(46573);
    }

    private Orders ap(JSONObject jSONObject) {
        AppMethodBeat.i(46574);
        if (this.tuL == null) {
            this.tuL = new Orders();
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("payresult");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                Commodity commodity = new Commodity();
                commodity.cAa = jSONObject2.getString(b.TRANSACTION_ID);
                commodity.pca = jSONObject2.optString("sp_name");
                if (bo.isNullOrNil(this.tuL.pcl)) {
                    this.tuL.pcl = jSONObject2.optString("fee_type");
                }
                this.tuL.tAq.add(commodity);
            }
        } catch (JSONException e) {
        }
        Orders orders = this.tuL;
        AppMethodBeat.o(46574);
        return orders;
    }
}
