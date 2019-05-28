package com.tencent.p177mm.plugin.appbrand.jsapi.p897a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p336ui.autofill.AppBrandIDCardUI;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.a.e */
public final class C38251e extends C10296a<C44709u> {
    public static final int CTRL_INDEX = 402;
    public static final String NAME = "openRealnameAuth";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(130900);
        final C44709u c44709u = (C44709u) c2241c;
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiOpenRealnameAuth", "getIDCardInfo data is null");
            c44709u.mo6107M(i, mo73394j("fail:data is null", null));
            AppMethodBeat.m2505o(130900);
            return;
        }
        MMActivity mMActivity = (MMActivity) c44709u.mContext;
        if (mMActivity == null) {
            c44709u.mo6107M(i, mo73394j("fail", null));
            C4990ab.m7412e("MicroMsg.JsApiOpenRealnameAuth", "mmActivity is null, invoke fail!");
            AppMethodBeat.m2505o(130900);
            return;
        }
        String optString = jSONObject.optString("categoryId", "");
        if (C5046bo.isNullOrNil(optString)) {
            C4990ab.m7412e("MicroMsg.JsApiOpenRealnameAuth", "category_id is null");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(40003));
            c44709u.mo6107M(i, mo73394j("fail:category_id is empty", hashMap));
            AppMethodBeat.m2505o(130900);
            return;
        }
        C4990ab.m7417i("MicroMsg.JsApiOpenRealnameAuth", "getIDCardInfo category_id:%s, appId:%s, authType:%d", optString, c44709u.getAppId(), Integer.valueOf(jSONObject.optInt("authType", 1)));
        Intent intent = new Intent(mMActivity, AppBrandIDCardUI.class);
        intent.putExtra("intent_appid", r2);
        intent.putExtra("intent_category_id", optString);
        intent.putExtra("intent_auth_type", r3);
        mMActivity.ifE = new C5186a() {
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(130899);
                C4990ab.m7417i("MicroMsg.JsApiOpenRealnameAuth", "mmOnActivityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
                if (i == 1) {
                    HashMap hashMap = new HashMap();
                    if (i2 == -1) {
                        C4990ab.m7416i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth ok");
                        String stringExtra = intent.getStringExtra("intent_auth_token");
                        if (C5046bo.isNullOrNil(stringExtra)) {
                            c44709u.mo6107M(i, C38251e.this.mo73394j("fail", hashMap));
                            AppMethodBeat.m2505o(130899);
                            return;
                        }
                        hashMap.put("errCode", Integer.valueOf(0));
                        hashMap.put("auth_token", stringExtra);
                        c44709u.mo6107M(i, C38251e.this.mo73394j("ok", hashMap));
                        C4990ab.m7411d("MicroMsg.JsApiOpenRealnameAuth", "authToken:%s", stringExtra);
                        AppMethodBeat.m2505o(130899);
                        return;
                    } else if (i2 == 0) {
                        C4990ab.m7416i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth cancel");
                        c44709u.mo6107M(i, C38251e.this.mo73394j("cancel", null));
                        AppMethodBeat.m2505o(130899);
                        return;
                    } else if (i2 == 1) {
                        C4990ab.m7416i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth fail");
                        if (intent != null) {
                            int intExtra = intent.getIntExtra("intent_err_code", -1);
                            String stringExtra2 = intent.getStringExtra("intent_err_msg");
                            hashMap.put("errCode", Integer.valueOf(intExtra));
                            c44709u.mo6107M(i, C38251e.this.mo73394j("fail:" + C5046bo.nullAsNil(stringExtra2), hashMap));
                            C4990ab.m7417i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth errCode:%d, errMsg:%s", Integer.valueOf(intExtra), stringExtra2);
                            AppMethodBeat.m2505o(130899);
                            return;
                        }
                        c44709u.mo6107M(i, C38251e.this.mo73394j("fail", hashMap));
                    }
                }
                AppMethodBeat.m2505o(130899);
            }
        };
        mMActivity.startActivityForResult(intent, 1);
        C7060h.pYm.mo8381e(14943, r2, Integer.valueOf(1), "");
        AppMethodBeat.m2505o(130900);
    }
}
