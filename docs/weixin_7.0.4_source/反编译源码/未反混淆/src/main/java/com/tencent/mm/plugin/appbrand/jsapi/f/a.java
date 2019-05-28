package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a<q> {
    private static final int CTRL_INDEX = 424;
    private static final String NAME = "openRedPacket";

    public static class a extends n {
        public a(m mVar, q qVar, u uVar, JSONObject jSONObject, int i) {
            super(mVar, qVar, uVar, jSONObject, i);
        }

        public final boolean a(MMActivity mMActivity, JSONObject jSONObject, int i) {
            AppMethodBeat.i(131115);
            String appId = xT().getAppId();
            String optString = jSONObject.optString("redPacketId", null);
            if (bo.isNullOrNil(appId) || bo.isNullOrNil(optString)) {
                ab.i("MicroMsg.JsApiOpenRedPacket", "GetLuckMoneyRequest.launch appId = [%s] sendId = [%s]", appId, optString);
                AppMethodBeat.o(131115);
                return false;
            }
            ((com.tencent.mm.plugin.luckymoney.appbrand.a) g.K(com.tencent.mm.plugin.luckymoney.appbrand.a.class)).a(mMActivity, optString, appId, i);
            AppMethodBeat.o(131115);
            return true;
        }

        public final void C(Intent intent) {
            AppMethodBeat.i(131116);
            ab.i("MicroMsg.JsApiOpenRedPacket", "GetLuckMoneyRequest.onResult");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(0));
            w(hashMap);
            AppMethodBeat.o(131116);
        }

        public final void onError(int i, String str) {
            AppMethodBeat.i(131117);
            ab.i("MicroMsg.JsApiOpenRedPacket", "onError errCode: %d,errMsg: %s", Integer.valueOf(i), str);
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(i));
            k(str, hashMap);
            AppMethodBeat.o(131117);
        }
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(131118);
        q qVar = (q) cVar;
        HashMap hashMap;
        if (jSONObject == null) {
            ab.i("MicroMsg.JsApiOpenRedPacket", "data is null");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(-1));
            qVar.M(i, j("fail:system error {{data is null}}", hashMap));
            AppMethodBeat.o(131118);
        } else if (bo.isNullOrNil(jSONObject.optString("redPacketId", null))) {
            ab.i("MicroMsg.JsApiOpenRedPacket", "redPacketId is nil");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(-1));
            qVar.M(i, j("fail:system error {{redPacketId is nil}}", hashMap));
            AppMethodBeat.o(131118);
        } else {
            u currentPageView = qVar.getCurrentPageView();
            if (currentPageView != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("needPortraitSnapshot", true);
                currentPageView.a(2, bundle, new Object[0]);
                new a(this, qVar, currentPageView, jSONObject, i).run();
                AppMethodBeat.o(131118);
                return;
            }
            ab.i("MicroMsg.JsApiOpenRedPacket", "associated page view is null!!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(-1));
            qVar.M(i, j("fail:system error {{associated page view is null}}", hashMap));
            AppMethodBeat.o(131118);
        }
    }
}
