package com.tencent.p177mm.plugin.webview.luggage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.p177mm.plugin.webview.luggage.p1141a.C29775a;
import com.tencent.p177mm.plugin.webview.model.C22888d.C22889a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.a */
public final class C29776a implements C22889a {
    /* renamed from: a */
    public final void mo9642a(boolean z, int i, int i2, String str, String str2) {
        AppMethodBeat.m2504i(5972);
        C4990ab.m7417i("MicroMsg.CdnProgressCallback", "onWebView cdn callback progress, upload : %b, mediaType : %d, percent : %d, localid : %s, mediaId : %s", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), str, str2);
        if (z) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("localId", str);
                jSONObject.put("percent", i2);
                Bundle bundle = new Bundle();
                bundle.putString("name", "onMediaFileUploadProgress");
                bundle.putString("data", jSONObject.toString());
                ToolsProcessIPCService.m63912a(bundle, C29775a.class);
                AppMethodBeat.m2505o(5972);
                return;
            } catch (JSONException e) {
            }
        }
        AppMethodBeat.m2505o(5972);
    }
}
