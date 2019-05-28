package com.tencent.p177mm.plugin.appbrand.jsapi.bio.face;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.facedetect.p403ui.FaceTransparentStubUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bio.face.a */
public abstract class C19328a extends C10296a {
    public abstract boolean aCJ();

    public abstract String aCK();

    /* Access modifiers changed, original: protected */
    public boolean aCL() {
        return true;
    }

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, final int i) {
        Context context = c2241c.getContext() instanceof MMActivity ? (MMActivity) c2241c.getContext() : null;
        if (context == null) {
            C4990ab.m7413e("MicroMsg.JsApiFaceAsyncBase", "JsApiFaceAsyncBase context is null, appId is %s", c2241c.getAppId());
            c2241c.mo6107M(i, mo73394j("fail", null));
            return;
        }
        String optString = jSONObject.optString("requestVerifyPreInfo");
        int optInt = jSONObject.optInt("checkAliveType");
        String appId = c2241c.getAppId();
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
        context.ifE = new C5186a() {
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                int intExtra;
                Bundle bundle = null;
                AppMethodBeat.m2504i(3201);
                if (intent != null) {
                    intExtra = intent.getIntExtra("err_code", 90199);
                } else {
                    intExtra = 90199;
                }
                C19328a c19328a;
                C2241c c2241c;
                int i3;
                if (i == 1000) {
                    C4990ab.m7417i("MicroMsg.JsApiFaceAsyncBase", "alvinluo: requestWxFacePictureVerify errCode: %d", Integer.valueOf(intExtra));
                    if (intExtra == 0) {
                        c19328a = C19328a.this;
                        c2241c = c2241c;
                        i3 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        C19328a.m30004a(c19328a, c2241c, i3, bundle, "ok");
                        AppMethodBeat.m2505o(3201);
                        return;
                    } else if (intExtra == 90100) {
                        c19328a = C19328a.this;
                        c2241c = c2241c;
                        i3 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        C19328a.m30004a(c19328a, c2241c, i3, bundle, "cancel");
                        AppMethodBeat.m2505o(3201);
                        return;
                    } else {
                        c19328a = C19328a.this;
                        c2241c = c2241c;
                        i3 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        C19328a.m30004a(c19328a, c2241c, i3, bundle, "fail");
                        AppMethodBeat.m2505o(3201);
                        return;
                    }
                }
                if (i == 1001) {
                    C4990ab.m7417i("MicroMsg.JsApiFaceAsyncBase", "hy: REQUEST_FACE_DETECT_WITH_VIDEO errCode: %d", Integer.valueOf(intExtra));
                    if (intExtra == 0) {
                        c19328a = C19328a.this;
                        c2241c = c2241c;
                        i3 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        C19328a.m30004a(c19328a, c2241c, i3, bundle, "ok");
                        AppMethodBeat.m2505o(3201);
                        return;
                    } else if (intExtra == 90100) {
                        c19328a = C19328a.this;
                        c2241c = c2241c;
                        i3 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        C19328a.m30004a(c19328a, c2241c, i3, bundle, "cancel");
                        AppMethodBeat.m2505o(3201);
                        return;
                    } else {
                        c19328a = C19328a.this;
                        c2241c = c2241c;
                        i3 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        C19328a.m30004a(c19328a, c2241c, i3, bundle, "fail");
                    }
                }
                AppMethodBeat.m2505o(3201);
            }
        };
        context.startActivityForResult(intent, i2);
    }

    /* renamed from: a */
    static /* synthetic */ void m30004a(C19328a c19328a, C2241c c2241c, int i, Bundle bundle, String str) {
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
        c2241c.mo6107M(i, c19328a.mo73394j(str, hashMap));
    }
}
