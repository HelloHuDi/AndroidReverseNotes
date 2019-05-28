package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.webkit.ValueCallback;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.ImagesContract;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.x5.sdk.d;
import java.util.HashMap;
import org.json.JSONObject;

public final class p {
    public static int a(Context context, String str, String str2, String str3, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(79225);
        HashMap hashMap = new HashMap(2);
        hashMap.put(ImagesContract.LOCAL, "true");
        hashMap.put(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "1");
        String str4 = "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("path", str);
            jSONObject.put("ext", str2);
            jSONObject.put("token", str3);
            str4 = jSONObject.toString();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.QbReaderLogic", e, "openReadFile", new Object[0]);
        }
        int startMiniQBToLoadUrl = d.startMiniQBToLoadUrl(context, str4, hashMap, valueCallback);
        AppMethodBeat.o(79225);
        return startMiniQBToLoadUrl;
    }
}
