package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.facedetect.ui.FaceTransparentStubUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import org.json.JSONObject;

public abstract class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public abstract boolean aCJ();

    public abstract String aCK();

    /* Access modifiers changed, original: protected */
    public boolean aCL() {
        return true;
    }

    public final void a(final c cVar, JSONObject jSONObject, final int i) {
        Context context = cVar.getContext() instanceof MMActivity ? (MMActivity) cVar.getContext() : null;
        if (context == null) {
            ab.e("MicroMsg.JsApiFaceAsyncBase", "JsApiFaceAsyncBase context is null, appId is %s", cVar.getAppId());
            cVar.M(i, j("fail", null));
            return;
        }
        String optString = jSONObject.optString("requestVerifyPreInfo");
        int optInt = jSONObject.optInt("checkAliveType");
        String appId = cVar.getAppId();
        int i2 = aCJ() ? 1001 : 1000;
        Bundle bundle = new Bundle();
        bundle.putBoolean("k_need_signature", true);
        bundle.putInt("k_server_scene", 5);
        bundle.putBoolean("key_is_need_video", aCJ());
        bundle.putBoolean("is_check_dyncfg", false);
        bundle.putString("k_app_id", appId);
        bundle.putString("request_verify_pre_info", optString);
        bundle.putInt("key_business_type", 4);
        bundle.putString("key_function_name", aCK());
        bundle.putInt("check_alive_type", optInt);
        bundle.putBoolean("key_is_need_confirm_page", aCL());
        Intent intent = new Intent(context, FaceTransparentStubUI.class);
        intent.putExtra("KEY_EXTRAS", bundle);
        intent.putExtra("KEY_REQUEST_CODE", i2);
        context.ifE = new com.tencent.mm.ui.MMActivity.a() {
            public final void c(int i, int i2, Intent intent) {
                int intExtra;
                Bundle bundle = null;
                AppMethodBeat.i(3201);
                if (intent != null) {
                    intExtra = intent.getIntExtra("err_code", 90199);
                } else {
                    intExtra = 90199;
                }
                a aVar;
                c cVar;
                int i3;
                if (i == 1000) {
                    ab.i("MicroMsg.JsApiFaceAsyncBase", "alvinluo: requestWxFacePictureVerify errCode: %d", Integer.valueOf(intExtra));
                    if (intExtra == 0) {
                        aVar = a.this;
                        cVar = cVar;
                        i3 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        a.a(aVar, cVar, i3, bundle, "ok");
                        AppMethodBeat.o(3201);
                        return;
                    } else if (intExtra == 90100) {
                        aVar = a.this;
                        cVar = cVar;
                        i3 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        a.a(aVar, cVar, i3, bundle, "cancel");
                        AppMethodBeat.o(3201);
                        return;
                    } else {
                        aVar = a.this;
                        cVar = cVar;
                        i3 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        a.a(aVar, cVar, i3, bundle, "fail");
                        AppMethodBeat.o(3201);
                        return;
                    }
                }
                if (i == 1001) {
                    ab.i("MicroMsg.JsApiFaceAsyncBase", "hy: REQUEST_FACE_DETECT_WITH_VIDEO errCode: %d", Integer.valueOf(intExtra));
                    if (intExtra == 0) {
                        aVar = a.this;
                        cVar = cVar;
                        i3 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        a.a(aVar, cVar, i3, bundle, "ok");
                        AppMethodBeat.o(3201);
                        return;
                    } else if (intExtra == 90100) {
                        aVar = a.this;
                        cVar = cVar;
                        i3 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        a.a(aVar, cVar, i3, bundle, "cancel");
                        AppMethodBeat.o(3201);
                        return;
                    } else {
                        aVar = a.this;
                        cVar = cVar;
                        i3 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        a.a(aVar, cVar, i3, bundle, "fail");
                    }
                }
                AppMethodBeat.o(3201);
            }
        };
        context.startActivityForResult(intent, i2);
    }

    static /* synthetic */ void a(a aVar, c cVar, int i, Bundle bundle, String str) {
        int i2 = -1;
        String str2 = "not returned";
        Object obj = "";
        if (bundle != null) {
            i2 = bundle.getInt("err_code");
            str2 = bundle.getString("err_msg");
            obj = bundle.getString("verify_result");
        }
        HashMap hashMap = new HashMap(3);
        hashMap.put("errCode", Integer.valueOf(i2));
        hashMap.put("verifyResult", obj);
        if ("fail".equals(str)) {
            str = str + " " + str2;
        }
        cVar.M(i, aVar.j(str, hashMap));
    }
}
