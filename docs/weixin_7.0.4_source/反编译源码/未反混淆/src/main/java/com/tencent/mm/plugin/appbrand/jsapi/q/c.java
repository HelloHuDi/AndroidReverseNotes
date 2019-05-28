package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 169;
    public static final String NAME = "getClipboardData";

    public final void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(126406);
        ClipboardManager clipboardManager = (ClipboardManager) ah.getContext().getSystemService("clipboard");
        if (clipboardManager == null) {
            ab.i("MicroMsg.JsApiGetClipboardData", "getSystemService(CLIPBOARD_SERVICE) failed.");
            cVar.M(i, j("fail", null));
            AppMethodBeat.o(126406);
            return;
        }
        ClipData primaryClip = clipboardManager.getPrimaryClip();
        Object obj = "";
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            Item itemAt = primaryClip.getItemAt(0);
            if (itemAt.getText() != null) {
                obj = itemAt.getText().toString();
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data", obj);
        cVar.M(i, j("ok", hashMap));
        AppMethodBeat.o(126406);
    }
}
