package com.tencent.p177mm.plugin.appbrand.jsapi.bio.face;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.facedetectaction.p404ui.FaceTransStubUI;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bio.face.d */
public final class C33253d extends C10296a {
    public static final int CTRL_INDEX = 495;
    public static final String NAME = "faceVerifyForPay";

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(3203);
        C4990ab.m7416i("MicroMsg.JsApiStartFaceAction", "carson: start JsApiStartFaceAction（） ");
        C7060h.pYm.mo8378a(917, 35, 1, false);
        Context context = c2241c.getContext() instanceof MMActivity ? (MMActivity) c2241c.getContext() : null;
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
        context.ifE = new C5186a() {
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(3202);
                C4990ab.m7416i("MicroMsg.JsApiStartFaceAction", "carson: start mmOnActivityResult（） ");
                int intExtra = intent.getIntExtra("err_code", 0);
                int intExtra2 = intent.getIntExtra("scene", 0);
                int intExtra3 = intent.getIntExtra("countFace", 0);
                long longExtra = intent.getLongExtra("totalTime", 0);
                int intExtra4 = intent.getIntExtra("err_type", 6);
                C4990ab.m7416i("MicroMsg.JsApiStartFaceAction", "errCode： ".concat(String.valueOf(intExtra)));
                C4990ab.m7416i("MicroMsg.JsApiStartFaceAction", "scene： ".concat(String.valueOf(intExtra2)));
                C4990ab.m7416i("MicroMsg.JsApiStartFaceAction", "countFace： ".concat(String.valueOf(intExtra3)));
                C4990ab.m7416i("MicroMsg.JsApiStartFaceAction", "totalTime： ".concat(String.valueOf(longExtra)));
                C4990ab.m7416i("MicroMsg.JsApiStartFaceAction", "errorType： ".concat(String.valueOf(intExtra4)));
                if (i == 63) {
                    C4990ab.m7417i("MicroMsg.JsApiStartFaceAction", "REQUEST_FACE_VERIFY_FOR_PAY resultCode: %d", Integer.valueOf(i2));
                    if (i2 == -1) {
                        C7060h.pYm.mo8381e(15711, Integer.valueOf(intExtra2), Integer.valueOf(0), Integer.valueOf(intExtra3), Long.valueOf(longExtra), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(intExtra));
                        C33253d.m54406a(C33253d.this, c2241c, i, intent != null ? intent.getExtras() : null, "ok");
                        AppMethodBeat.m2505o(3202);
                        return;
                    } else if (i2 == 1) {
                        C7060h.pYm.mo8381e(15711, Integer.valueOf(intExtra2), Integer.valueOf(3), Integer.valueOf(intExtra3), Long.valueOf(longExtra), Integer.valueOf(3), Integer.valueOf(intExtra4), Integer.valueOf(intExtra));
                        C33253d.m54406a(C33253d.this, c2241c, i, intent != null ? intent.getExtras() : null, "fail");
                        AppMethodBeat.m2505o(3202);
                        return;
                    } else if (i2 == 0) {
                        C7060h.pYm.mo8381e(15711, Integer.valueOf(intExtra2), Integer.valueOf(2), Integer.valueOf(intExtra3), Long.valueOf(longExtra), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(intExtra));
                        C33253d.m54406a(C33253d.this, c2241c, i, intent != null ? intent.getExtras() : null, "cancel");
                    }
                }
                AppMethodBeat.m2505o(3202);
            }
        };
        context.startActivityForResult(intent, 63);
        AppMethodBeat.m2505o(3203);
    }

    /* renamed from: a */
    static /* synthetic */ void m54406a(C33253d c33253d, C2241c c2241c, int i, Bundle bundle, String str) {
        AppMethodBeat.m2504i(3204);
        C4990ab.m7416i("MicroMsg.JsApiStartFaceAction", "carson: start mmOnActivityResult（） ");
        C4990ab.m7416i("MicroMsg.JsApiStartFaceAction", "carson： generalErrMsg ：".concat(String.valueOf(str)));
        int i2 = -1;
        String str2 = "nothing return";
        Object obj = "";
        Object obj2 = Boolean.FALSE;
        if (bundle != null) {
            C4990ab.m7416i("MicroMsg.JsApiStartFaceAction", "carson: extras ≠ null  ");
            i2 = bundle.getInt("err_code");
            str2 = bundle.getString("err_msg");
            obj = bundle.getString("token");
            C4990ab.m7416i("MicroMsg.JsApiStartFaceAction", "carson：errCode：".concat(String.valueOf(i2)));
            C4990ab.m7416i("MicroMsg.JsApiStartFaceAction", "carson：errMsg ：".concat(String.valueOf(str2)));
            C4990ab.m7416i("MicroMsg.JsApiStartFaceAction", "carson：token：".concat(String.valueOf(obj)));
            if (bundle.getString("click_other_verify_btn") != null && "yes".equals(bundle.getString("click_other_verify_btn"))) {
                obj2 = Boolean.TRUE;
            }
        }
        HashMap hashMap = new HashMap(3);
        hashMap.put("err_code", Integer.valueOf(i2));
        hashMap.put("token", obj);
        hashMap.put("click_other_verify_btn", obj2);
        C4990ab.m7416i("MicroMsg.JsApiStartFaceAction", "carson: service back data");
        c2241c.mo6107M(i, c33253d.mo73394j(str2, hashMap));
        AppMethodBeat.m2505o(3204);
    }
}
