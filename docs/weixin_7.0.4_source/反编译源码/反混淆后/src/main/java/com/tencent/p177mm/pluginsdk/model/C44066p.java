package com.tencent.p177mm.pluginsdk.model;

import android.content.Context;
import android.webkit.ValueCallback;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.ImagesContract;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.xweb.p685x5.sdk.C24544d;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.pluginsdk.model.p */
public final class C44066p {
    /* renamed from: a */
    public static int m79209a(Context context, String str, String str2, String str3, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(79225);
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
            C4990ab.printErrStackTrace("MicroMsg.QbReaderLogic", e, "openReadFile", new Object[0]);
        }
        int startMiniQBToLoadUrl = C24544d.startMiniQBToLoadUrl(context, str4, hashMap, valueCallback);
        AppMethodBeat.m2505o(79225);
        return startMiniQBToLoadUrl;
    }
}
