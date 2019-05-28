package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends com.tencent.mm.plugin.appbrand.jsapi.a<s> {
    private static final int CTRL_INDEX = 423;
    private static final String NAME = "sendRedPacket";

    public static class a extends n {
        public a(m mVar, q qVar, u uVar, JSONObject jSONObject, int i) {
            super(mVar, qVar, uVar, jSONObject, i);
        }

        public final boolean a(MMActivity mMActivity, JSONObject jSONObject, int i) {
            int i2 = 0;
            AppMethodBeat.i(131119);
            String optString = jSONObject.optString("defaultWishingWord", null);
            JSONArray optJSONArray = jSONObject.optJSONArray("scope");
            if (optJSONArray != null) {
                boolean z;
                boolean contains = optJSONArray.toString().contains("friend");
                boolean contains2 = optJSONArray.toString().contains("public");
                if (contains) {
                }
                if (contains2) {
                    z = true;
                } else {
                    z = false;
                }
                if (contains2 && contains) {
                    z = true;
                }
                i2 = z;
            } else {
                ab.i("MicroMsg.JsApiSendRedPacket", "launch scope is nil");
            }
            ((com.tencent.mm.plugin.luckymoney.appbrand.a) g.K(com.tencent.mm.plugin.luckymoney.appbrand.a.class)).a(mMActivity, xT().getAppId(), i2, optString, i);
            AppMethodBeat.o(131119);
            return true;
        }

        public final void C(Intent intent) {
            AppMethodBeat.i(131120);
            ab.i("MicroMsg.JsApiSendRedPacket", "PrepareLuckyMoneyRequest.onResult ");
            if (intent == null || intent.getStringExtra("sendId") == null) {
                ab.e("MicroMsg.JsApiSendRedPacket", "onResult data = [%s]", intent);
                onError(-1, "fail:system error {{result data error or sendId is null}}");
                AppMethodBeat.o(131120);
                return;
            }
            String stringExtra = intent.getStringExtra("sendId");
            boolean booleanExtra = intent.getBooleanExtra("result_share_msg", false);
            ab.i("MicroMsg.JsApiSendRedPacket", "PrepareLuckyMoneyRequest.onResult sendId = %s,share = %b", stringExtra, Boolean.valueOf(booleanExtra));
            ab.i("MicroMsg.JsApiSendRedPacket", "GetLuckMoneyRequest.onResult");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(0));
            hashMap.put("redPacketId", stringExtra);
            w(hashMap);
            AppMethodBeat.o(131120);
        }

        public final void onError(int i, String str) {
            AppMethodBeat.i(131121);
            ab.i("MicroMsg.JsApiSendRedPacket", "onError errCode: %d,errMsg: %s", Integer.valueOf(i), str);
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(i));
            k(str, hashMap);
            AppMethodBeat.o(131121);
        }
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(131122);
        s sVar = (s) cVar;
        HashMap hashMap;
        if (jSONObject == null) {
            ab.i("MicroMsg.JsApiSendRedPacket", "data is null");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(-1));
            sVar.M(i, j("fail:system error {{data is null}}", hashMap));
            AppMethodBeat.o(131122);
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("scope");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            ab.i("MicroMsg.JsApiSendRedPacket", "scope is nil");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(-1));
            sVar.M(i, j("fail:system error {{scope is nil}}", hashMap));
            AppMethodBeat.o(131122);
            return;
        }
        new a(this, sVar, sVar.ac(w.class), jSONObject, i).run();
        AppMethodBeat.o(131122);
    }
}
