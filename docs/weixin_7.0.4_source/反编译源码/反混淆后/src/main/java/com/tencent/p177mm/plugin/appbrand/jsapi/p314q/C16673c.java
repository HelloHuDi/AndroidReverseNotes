package com.tencent.p177mm.plugin.appbrand.jsapi.p314q;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.q.c */
public final class C16673c extends C10296a {
    public static final int CTRL_INDEX = 169;
    public static final String NAME = "getClipboardData";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(126406);
        ClipboardManager clipboardManager = (ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
        if (clipboardManager == null) {
            C4990ab.m7416i("MicroMsg.JsApiGetClipboardData", "getSystemService(CLIPBOARD_SERVICE) failed.");
            c2241c.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(126406);
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
        c2241c.mo6107M(i, mo73394j("ok", hashMap));
        AppMethodBeat.m2505o(126406);
    }
}
