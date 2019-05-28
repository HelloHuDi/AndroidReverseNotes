package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.facedetectaction.ui.FaceTransStubUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_INDEX = 495;
    public static final String NAME = "faceVerifyForPay";

    public final void a(final c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(3203);
        ab.i("MicroMsg.JsApiStartFaceAction", "carson: start JsApiStartFaceAction（） ");
        h.pYm.a(917, 35, 1, false);
        Context context = cVar.getContext() instanceof MMActivity ? (MMActivity) cVar.getContext() : null;
        int optInt = jSONObject.optInt("scene");
        String optString = jSONObject.optString("package");
        String optString2 = jSONObject.optString("packageSign");
        String optString3 = jSONObject.optString("otherVerifyTitle");
        Intent intent = new Intent(context, FaceTransStubUI.class);
        Bundle bundle = new Bundle();
        bundle.putInt("scene", optInt);
        bundle.putString("package", optString);
        bundle.putString("packageSign", optString2);
        bundle.putString("otherVerifyTitle", optString3);
        intent.putExtras(bundle);
        context.ifE = new MMActivity.a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(3202);
                ab.i("MicroMsg.JsApiStartFaceAction", "carson: start mmOnActivityResult（） ");
                int intExtra = intent.getIntExtra("err_code", 0);
                int intExtra2 = intent.getIntExtra("scene", 0);
                int intExtra3 = intent.getIntExtra("countFace", 0);
                long longExtra = intent.getLongExtra("totalTime", 0);
                int intExtra4 = intent.getIntExtra("err_type", 6);
                ab.i("MicroMsg.JsApiStartFaceAction", "errCode： ".concat(String.valueOf(intExtra)));
                ab.i("MicroMsg.JsApiStartFaceAction", "scene： ".concat(String.valueOf(intExtra2)));
                ab.i("MicroMsg.JsApiStartFaceAction", "countFace： ".concat(String.valueOf(intExtra3)));
                ab.i("MicroMsg.JsApiStartFaceAction", "totalTime： ".concat(String.valueOf(longExtra)));
                ab.i("MicroMsg.JsApiStartFaceAction", "errorType： ".concat(String.valueOf(intExtra4)));
                if (i == 63) {
                    ab.i("MicroMsg.JsApiStartFaceAction", "REQUEST_FACE_VERIFY_FOR_PAY resultCode: %d", Integer.valueOf(i2));
                    if (i2 == -1) {
                        h.pYm.e(15711, Integer.valueOf(intExtra2), Integer.valueOf(0), Integer.valueOf(intExtra3), Long.valueOf(longExtra), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(intExtra));
                        d.a(d.this, cVar, i, intent != null ? intent.getExtras() : null, "ok");
                        AppMethodBeat.o(3202);
                        return;
                    } else if (i2 == 1) {
                        h.pYm.e(15711, Integer.valueOf(intExtra2), Integer.valueOf(3), Integer.valueOf(intExtra3), Long.valueOf(longExtra), Integer.valueOf(3), Integer.valueOf(intExtra4), Integer.valueOf(intExtra));
                        d.a(d.this, cVar, i, intent != null ? intent.getExtras() : null, "fail");
                        AppMethodBeat.o(3202);
                        return;
                    } else if (i2 == 0) {
                        h.pYm.e(15711, Integer.valueOf(intExtra2), Integer.valueOf(2), Integer.valueOf(intExtra3), Long.valueOf(longExtra), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(intExtra));
                        d.a(d.this, cVar, i, intent != null ? intent.getExtras() : null, "cancel");
                    }
                }
                AppMethodBeat.o(3202);
            }
        };
        context.startActivityForResult(intent, 63);
        AppMethodBeat.o(3203);
    }

    static /* synthetic */ void a(d dVar, c cVar, int i, Bundle bundle, String str) {
        AppMethodBeat.i(3204);
        ab.i("MicroMsg.JsApiStartFaceAction", "carson: start mmOnActivityResult（） ");
        ab.i("MicroMsg.JsApiStartFaceAction", "carson： generalErrMsg ：".concat(String.valueOf(str)));
        int i2 = -1;
        String str2 = "nothing return";
        Object obj = "";
        Object obj2 = Boolean.FALSE;
        if (bundle != null) {
            ab.i("MicroMsg.JsApiStartFaceAction", "carson: extras ≠ null  ");
            i2 = bundle.getInt("err_code");
            str2 = bundle.getString("err_msg");
            obj = bundle.getString("token");
            ab.i("MicroMsg.JsApiStartFaceAction", "carson：errCode：".concat(String.valueOf(i2)));
            ab.i("MicroMsg.JsApiStartFaceAction", "carson：errMsg ：".concat(String.valueOf(str2)));
            ab.i("MicroMsg.JsApiStartFaceAction", "carson：token：".concat(String.valueOf(obj)));
            if (bundle.getString("click_other_verify_btn") != null && "yes".equals(bundle.getString("click_other_verify_btn"))) {
                obj2 = Boolean.TRUE;
            }
        }
        HashMap hashMap = new HashMap(3);
        hashMap.put("err_code", Integer.valueOf(i2));
        hashMap.put("token", obj);
        hashMap.put("click_other_verify_btn", obj2);
        ab.i("MicroMsg.JsApiStartFaceAction", "carson: service back data");
        cVar.M(i, dVar.j(str2, hashMap));
        AppMethodBeat.o(3204);
    }
}
