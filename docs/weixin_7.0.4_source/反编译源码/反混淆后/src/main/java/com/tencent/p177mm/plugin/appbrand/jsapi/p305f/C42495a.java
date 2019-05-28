package com.tencent.p177mm.plugin.appbrand.jsapi.p305f;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38359n;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.luckymoney.appbrand.C6963a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.f.a */
public final class C42495a extends C10296a<C38492q> {
    private static final int CTRL_INDEX = 424;
    private static final String NAME = "openRedPacket";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.f.a$a */
    public static class C10382a extends C38359n {
        public C10382a(C45608m c45608m, C38492q c38492q, C44709u c44709u, JSONObject jSONObject, int i) {
            super(c45608m, c38492q, c44709u, jSONObject, i);
        }

        /* renamed from: a */
        public final boolean mo6155a(MMActivity mMActivity, JSONObject jSONObject, int i) {
            AppMethodBeat.m2504i(131115);
            String appId = mo73400xT().getAppId();
            String optString = jSONObject.optString("redPacketId", null);
            if (C5046bo.isNullOrNil(appId) || C5046bo.isNullOrNil(optString)) {
                C4990ab.m7417i("MicroMsg.JsApiOpenRedPacket", "GetLuckMoneyRequest.launch appId = [%s] sendId = [%s]", appId, optString);
                AppMethodBeat.m2505o(131115);
                return false;
            }
            ((C6963a) C1720g.m3528K(C6963a.class)).mo15201a(mMActivity, optString, appId, i);
            AppMethodBeat.m2505o(131115);
            return true;
        }

        /* renamed from: C */
        public final void mo6154C(Intent intent) {
            AppMethodBeat.m2504i(131116);
            C4990ab.m7416i("MicroMsg.JsApiOpenRedPacket", "GetLuckMoneyRequest.onResult");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(0));
            mo73399w(hashMap);
            AppMethodBeat.m2505o(131116);
        }

        public final void onError(int i, String str) {
            AppMethodBeat.m2504i(131117);
            C4990ab.m7417i("MicroMsg.JsApiOpenRedPacket", "onError errCode: %d,errMsg: %s", Integer.valueOf(i), str);
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(i));
            mo73398k(str, hashMap);
            AppMethodBeat.m2505o(131117);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(131118);
        C38492q c38492q = (C38492q) c2241c;
        HashMap hashMap;
        if (jSONObject == null) {
            C4990ab.m7416i("MicroMsg.JsApiOpenRedPacket", "data is null");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(-1));
            c38492q.mo6107M(i, mo73394j("fail:system error {{data is null}}", hashMap));
            AppMethodBeat.m2505o(131118);
        } else if (C5046bo.isNullOrNil(jSONObject.optString("redPacketId", null))) {
            C4990ab.m7416i("MicroMsg.JsApiOpenRedPacket", "redPacketId is nil");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(-1));
            c38492q.mo6107M(i, mo73394j("fail:system error {{redPacketId is nil}}", hashMap));
            AppMethodBeat.m2505o(131118);
        } else {
            C44709u currentPageView = c38492q.getCurrentPageView();
            if (currentPageView != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("needPortraitSnapshot", true);
                currentPageView.mo53736a(2, bundle, new Object[0]);
                new C10382a(this, c38492q, currentPageView, jSONObject, i).run();
                AppMethodBeat.m2505o(131118);
                return;
            }
            C4990ab.m7416i("MicroMsg.JsApiOpenRedPacket", "associated page view is null!!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(-1));
            c38492q.mo6107M(i, mo73394j("fail:system error {{associated page view is null}}", hashMap));
            AppMethodBeat.m2505o(131118);
        }
    }
}
