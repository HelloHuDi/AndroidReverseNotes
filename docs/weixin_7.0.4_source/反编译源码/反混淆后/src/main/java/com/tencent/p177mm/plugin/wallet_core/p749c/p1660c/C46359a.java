package com.tencent.p177mm.plugin.wallet_core.p749c.p1660c;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.c.a */
public final class C46359a extends C5749m {
    private int tuK;
    public Orders tuL;

    public C46359a(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7) {
        Object str8;
        Object str22;
        Object str32;
        Object str42;
        Object str52;
        Object str62;
        Object str72;
        AppMethodBeat.m2504i(46572);
        this.tuK = i;
        HashMap hashMap = new HashMap();
        String str9 = "appId";
        if (!C5046bo.isNullOrNil(str8)) {
            str8 = C18178q.encode(str8);
        }
        hashMap.put(str9, str8);
        str9 = "timeStamp";
        if (!C5046bo.isNullOrNil(str22)) {
            str22 = C18178q.encode(str22);
        }
        hashMap.put(str9, str22);
        str9 = "nonceStr";
        if (!C5046bo.isNullOrNil(str32)) {
            str32 = C18178q.encode(str32);
        }
        hashMap.put(str9, str32);
        str9 = "package";
        if (!C5046bo.isNullOrNil(str42)) {
            str42 = C18178q.encode(str42);
        }
        hashMap.put(str9, str42);
        str9 = "reqKey";
        if (!C5046bo.isNullOrNil(str52)) {
            str52 = C18178q.encode(str52);
        }
        hashMap.put(str9, str52);
        hashMap.put("payScene", C18178q.encode(String.valueOf(i)));
        str9 = "signType";
        if (!C5046bo.isNullOrNil(str62)) {
            str62 = C18178q.encode(str62);
        }
        hashMap.put(str9, str62);
        str9 = "paySign";
        if (!C5046bo.isNullOrNil(str72)) {
            str72 = C18178q.encode(str72);
        }
        hashMap.put(str9, str72);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(46572);
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

    /* renamed from: ZU */
    public final int mo9382ZU() {
        if (this.tuK == 2) {
            return 2516;
        }
        return 2570;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46573);
        Log.m81049i("MicroMsg.NetSceneGetPaidOrderDetail", "errCode: " + i + " errMsg: " + str);
        if (jSONObject != null && dNO()) {
            this.tuL = m87133ap(jSONObject);
            this.tuL = Orders.m68757a(jSONObject, this.tuL);
        }
        AppMethodBeat.m2505o(46573);
    }

    /* renamed from: ap */
    private Orders m87133ap(JSONObject jSONObject) {
        AppMethodBeat.m2504i(46574);
        if (this.tuL == null) {
            this.tuL = new Orders();
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("payresult");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                Commodity commodity = new Commodity();
                commodity.cAa = jSONObject2.getString(C8741b.TRANSACTION_ID);
                commodity.pca = jSONObject2.optString("sp_name");
                if (C5046bo.isNullOrNil(this.tuL.pcl)) {
                    this.tuL.pcl = jSONObject2.optString("fee_type");
                }
                this.tuL.tAq.add(commodity);
            }
        } catch (JSONException e) {
        }
        Orders orders = this.tuL;
        AppMethodBeat.m2505o(46574);
        return orders;
    }
}
