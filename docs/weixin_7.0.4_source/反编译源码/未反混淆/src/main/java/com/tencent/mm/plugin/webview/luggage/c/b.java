package com.tencent.mm.plugin.webview.luggage.c;

import android.content.Context;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.q.a;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class b {
    private static a ulv = null;

    public static String bh(Context context, String str) {
        AppMethodBeat.i(6499);
        String bh = u.bh(context, str);
        AppMethodBeat.o(6499);
        return bh;
    }

    public static JSONObject AI(String str) {
        AppMethodBeat.i(6500);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(6500);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            AppMethodBeat.o(6500);
            return jSONObject;
        } catch (Exception e) {
            AppMethodBeat.o(6500);
            return null;
        }
    }

    public static boolean Ed(String str) {
        AppMethodBeat.i(6501);
        if (bo.isNullOrNil(str) || !(URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str))) {
            AppMethodBeat.o(6501);
            return false;
        }
        AppMethodBeat.o(6501);
        return true;
    }
}
