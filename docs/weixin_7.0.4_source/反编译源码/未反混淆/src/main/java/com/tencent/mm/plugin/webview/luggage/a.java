package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements com.tencent.mm.plugin.webview.model.d.a {
    public final void a(boolean z, int i, int i2, String str, String str2) {
        AppMethodBeat.i(5972);
        ab.i("MicroMsg.CdnProgressCallback", "onWebView cdn callback progress, upload : %b, mediaType : %d, percent : %d, localid : %s, mediaId : %s", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), str, str2);
        if (z) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("localId", str);
                jSONObject.put("percent", i2);
                Bundle bundle = new Bundle();
                bundle.putString("name", "onMediaFileUploadProgress");
                bundle.putString("data", jSONObject.toString());
                ToolsProcessIPCService.a(bundle, com.tencent.mm.plugin.webview.luggage.a.a.class);
                AppMethodBeat.o(5972);
                return;
            } catch (JSONException e) {
            }
        }
        AppMethodBeat.o(5972);
    }
}
