package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import org.json.JSONObject;

public final class e extends a<u> {
    public static final int CTRL_INDEX = 402;
    public static final String NAME = "openRealnameAuth";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(130900);
        final u uVar = (u) cVar;
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiOpenRealnameAuth", "getIDCardInfo data is null");
            uVar.M(i, j("fail:data is null", null));
            AppMethodBeat.o(130900);
            return;
        }
        MMActivity mMActivity = (MMActivity) uVar.mContext;
        if (mMActivity == null) {
            uVar.M(i, j("fail", null));
            ab.e("MicroMsg.JsApiOpenRealnameAuth", "mmActivity is null, invoke fail!");
            AppMethodBeat.o(130900);
            return;
        }
        String optString = jSONObject.optString("categoryId", "");
        if (bo.isNullOrNil(optString)) {
            ab.e("MicroMsg.JsApiOpenRealnameAuth", "category_id is null");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(40003));
            uVar.M(i, j("fail:category_id is empty", hashMap));
            AppMethodBeat.o(130900);
            return;
        }
        ab.i("MicroMsg.JsApiOpenRealnameAuth", "getIDCardInfo category_id:%s, appId:%s, authType:%d", optString, uVar.getAppId(), Integer.valueOf(jSONObject.optInt("authType", 1)));
        Intent intent = new Intent(mMActivity, AppBrandIDCardUI.class);
        intent.putExtra("intent_appid", r2);
        intent.putExtra("intent_category_id", optString);
        intent.putExtra("intent_auth_type", r3);
        mMActivity.ifE = new MMActivity.a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(130899);
                ab.i("MicroMsg.JsApiOpenRealnameAuth", "mmOnActivityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
                if (i == 1) {
                    HashMap hashMap = new HashMap();
                    if (i2 == -1) {
                        ab.i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth ok");
                        String stringExtra = intent.getStringExtra("intent_auth_token");
                        if (bo.isNullOrNil(stringExtra)) {
                            uVar.M(i, e.this.j("fail", hashMap));
                            AppMethodBeat.o(130899);
                            return;
                        }
                        hashMap.put("errCode", Integer.valueOf(0));
                        hashMap.put("auth_token", stringExtra);
                        uVar.M(i, e.this.j("ok", hashMap));
                        ab.d("MicroMsg.JsApiOpenRealnameAuth", "authToken:%s", stringExtra);
                        AppMethodBeat.o(130899);
                        return;
                    } else if (i2 == 0) {
                        ab.i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth cancel");
                        uVar.M(i, e.this.j("cancel", null));
                        AppMethodBeat.o(130899);
                        return;
                    } else if (i2 == 1) {
                        ab.i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth fail");
                        if (intent != null) {
                            int intExtra = intent.getIntExtra("intent_err_code", -1);
                            String stringExtra2 = intent.getStringExtra("intent_err_msg");
                            hashMap.put("errCode", Integer.valueOf(intExtra));
                            uVar.M(i, e.this.j("fail:" + bo.nullAsNil(stringExtra2), hashMap));
                            ab.i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth errCode:%d, errMsg:%s", Integer.valueOf(intExtra), stringExtra2);
                            AppMethodBeat.o(130899);
                            return;
                        }
                        uVar.M(i, e.this.j("fail", hashMap));
                    }
                }
                AppMethodBeat.o(130899);
            }
        };
        mMActivity.startActivityForResult(intent, 1);
        h.pYm.e(14943, r2, Integer.valueOf(1), "");
        AppMethodBeat.o(130900);
    }
}
