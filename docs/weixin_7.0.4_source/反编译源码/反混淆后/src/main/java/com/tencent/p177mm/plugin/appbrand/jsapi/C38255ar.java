package com.tencent.p177mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.game.p294d.C45558d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ar */
public class C38255ar extends C10296a<C38492q> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "logInJava";

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130481);
        try {
            int i2 = jSONObject.getInt("level");
            String string = jSONObject.getString("logs");
            switch (i2) {
                case 0:
                    C4990ab.m7410d("MicroMsg.JsApiLogInJava", string);
                    break;
                case 1:
                    C4990ab.m7416i("MicroMsg.JsApiLogInJava", string);
                    break;
                case 2:
                    C4990ab.m7420w("MicroMsg.JsApiLogInJava", string);
                    break;
                case 3:
                    C4990ab.m7412e("MicroMsg.JsApiLogInJava", string);
                    break;
                default:
                    C4990ab.m7410d("MicroMsg.JsApiLogInJava", string);
                    break;
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.JsApiLogInJava", e.toString());
        }
        C45558d.aAI().mo73366Ax(jSONObject.toString());
        AppMethodBeat.m2505o(130481);
    }
}
