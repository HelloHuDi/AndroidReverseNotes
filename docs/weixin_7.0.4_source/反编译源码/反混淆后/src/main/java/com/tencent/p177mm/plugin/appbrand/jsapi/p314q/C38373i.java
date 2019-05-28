package com.tencent.p177mm.plugin.appbrand.jsapi.p314q;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.q.i */
public class C38373i<CONTEXT extends C2241c> extends C10296a<CONTEXT> {
    public static final int CTRL_INDEX = 168;
    public static final String NAME = "setClipboardData";

    /* renamed from: a */
    public final void mo5994a(CONTEXT context, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(126418);
        String optString = jSONObject.optString("data");
        if (C5046bo.isNullOrNil(optString)) {
            context.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(126418);
            return;
        }
        C4990ab.m7411d("MicroMsg.JsApiSetClipboardData", "stevyang dataStr %s", optString);
        ClipboardManager clipboardManager = (ClipboardManager) context.getContext().getSystemService("clipboard");
        if (clipboardManager == null) {
            C4990ab.m7416i("MicroMsg.JsApiSetClipboardData", "getSystemService(CLIPBOARD_SERVICE) failed.");
            context.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(126418);
            return;
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText("text", optString));
        context.mo6107M(i, mo73394j("ok", null));
        mo61034c(context, optString);
        AppMethodBeat.m2505o(126418);
    }

    /* renamed from: c */
    public void mo61034c(CONTEXT context, String str) {
    }
}
