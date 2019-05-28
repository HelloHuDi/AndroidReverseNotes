package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public class i<CONTEXT extends c> extends a<CONTEXT> {
    public static final int CTRL_INDEX = 168;
    public static final String NAME = "setClipboardData";

    public final void a(CONTEXT context, JSONObject jSONObject, int i) {
        AppMethodBeat.i(126418);
        String optString = jSONObject.optString("data");
        if (bo.isNullOrNil(optString)) {
            context.M(i, j("fail", null));
            AppMethodBeat.o(126418);
            return;
        }
        ab.d("MicroMsg.JsApiSetClipboardData", "stevyang dataStr %s", optString);
        ClipboardManager clipboardManager = (ClipboardManager) context.getContext().getSystemService("clipboard");
        if (clipboardManager == null) {
            ab.i("MicroMsg.JsApiSetClipboardData", "getSystemService(CLIPBOARD_SERVICE) failed.");
            context.M(i, j("fail", null));
            AppMethodBeat.o(126418);
            return;
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText("text", optString));
        context.M(i, j("ok", null));
        c(context, optString);
        AppMethodBeat.o(126418);
    }

    public void c(CONTEXT context, String str) {
    }
}
