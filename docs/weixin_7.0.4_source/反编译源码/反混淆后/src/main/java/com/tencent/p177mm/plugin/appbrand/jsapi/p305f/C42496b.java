package com.tencent.p177mm.plugin.appbrand.jsapi.p305f;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38359n;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.luckymoney.appbrand.C6963a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.f.b */
public final class C42496b extends C10296a<C19722s> {
    private static final int CTRL_INDEX = 423;
    private static final String NAME = "sendRedPacket";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.f.b$a */
    public static class C2279a extends C38359n {
        public C2279a(C45608m c45608m, C38492q c38492q, C44709u c44709u, JSONObject jSONObject, int i) {
            super(c45608m, c38492q, c44709u, jSONObject, i);
        }

        /* renamed from: a */
        public final boolean mo6155a(MMActivity mMActivity, JSONObject jSONObject, int i) {
            int i2 = 0;
            AppMethodBeat.m2504i(131119);
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
                C4990ab.m7416i("MicroMsg.JsApiSendRedPacket", "launch scope is nil");
            }
            ((C6963a) C1720g.m3528K(C6963a.class)).mo15200a(mMActivity, mo73400xT().getAppId(), i2, optString, i);
            AppMethodBeat.m2505o(131119);
            return true;
        }

        /* renamed from: C */
        public final void mo6154C(Intent intent) {
            AppMethodBeat.m2504i(131120);
            C4990ab.m7416i("MicroMsg.JsApiSendRedPacket", "PrepareLuckyMoneyRequest.onResult ");
            if (intent == null || intent.getStringExtra("sendId") == null) {
                C4990ab.m7413e("MicroMsg.JsApiSendRedPacket", "onResult data = [%s]", intent);
                onError(-1, "fail:system error {{result data error or sendId is null}}");
                AppMethodBeat.m2505o(131120);
                return;
            }
            String stringExtra = intent.getStringExtra("sendId");
            boolean booleanExtra = intent.getBooleanExtra("result_share_msg", false);
            C4990ab.m7417i("MicroMsg.JsApiSendRedPacket", "PrepareLuckyMoneyRequest.onResult sendId = %s,share = %b", stringExtra, Boolean.valueOf(booleanExtra));
            C4990ab.m7416i("MicroMsg.JsApiSendRedPacket", "GetLuckMoneyRequest.onResult");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(0));
            hashMap.put("redPacketId", stringExtra);
            mo73399w(hashMap);
            AppMethodBeat.m2505o(131120);
        }

        public final void onError(int i, String str) {
            AppMethodBeat.m2504i(131121);
            C4990ab.m7417i("MicroMsg.JsApiSendRedPacket", "onError errCode: %d,errMsg: %s", Integer.valueOf(i), str);
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(i));
            mo73398k(str, hashMap);
            AppMethodBeat.m2505o(131121);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(131122);
        C19722s c19722s = (C19722s) c2241c;
        HashMap hashMap;
        if (jSONObject == null) {
            C4990ab.m7416i("MicroMsg.JsApiSendRedPacket", "data is null");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(-1));
            c19722s.mo6107M(i, mo73394j("fail:system error {{data is null}}", hashMap));
            AppMethodBeat.m2505o(131122);
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("scope");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            C4990ab.m7416i("MicroMsg.JsApiSendRedPacket", "scope is nil");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(-1));
            c19722s.mo6107M(i, mo73394j("fail:system error {{scope is nil}}", hashMap));
            AppMethodBeat.m2505o(131122);
            return;
        }
        new C2279a(this, c19722s, c19722s.mo61196ac(C27242w.class), jSONObject, i).run();
        AppMethodBeat.m2505o(131122);
    }
}
