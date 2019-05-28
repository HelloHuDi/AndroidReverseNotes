package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.d.d;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public class ar extends a<q> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "logInJava";

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130481);
        try {
            int i2 = jSONObject.getInt("level");
            String string = jSONObject.getString("logs");
            switch (i2) {
                case 0:
                    ab.d("MicroMsg.JsApiLogInJava", string);
                    break;
                case 1:
                    ab.i("MicroMsg.JsApiLogInJava", string);
                    break;
                case 2:
                    ab.w("MicroMsg.JsApiLogInJava", string);
                    break;
                case 3:
                    ab.e("MicroMsg.JsApiLogInJava", string);
                    break;
                default:
                    ab.d("MicroMsg.JsApiLogInJava", string);
                    break;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiLogInJava", e.toString());
        }
        d.aAI().Ax(jSONObject.toString());
        AppMethodBeat.o(130481);
    }
}
