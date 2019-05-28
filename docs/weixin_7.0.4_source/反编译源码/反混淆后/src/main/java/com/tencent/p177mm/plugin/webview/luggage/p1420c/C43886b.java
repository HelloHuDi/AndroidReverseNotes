package com.tencent.p177mm.plugin.webview.luggage.p1420c;

import android.content.Context;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C10707q.C10708a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.c.b */
public final class C43886b {
    private static C10708a ulv = null;

    /* renamed from: bh */
    public static String m78712bh(Context context, String str) {
        AppMethodBeat.m2504i(6499);
        String bh = C30152u.m47747bh(context, str);
        AppMethodBeat.m2505o(6499);
        return bh;
    }

    /* renamed from: AI */
    public static JSONObject m78710AI(String str) {
        AppMethodBeat.m2504i(6500);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(6500);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            AppMethodBeat.m2505o(6500);
            return jSONObject;
        } catch (Exception e) {
            AppMethodBeat.m2505o(6500);
            return null;
        }
    }

    /* renamed from: Ed */
    public static boolean m78711Ed(String str) {
        AppMethodBeat.m2504i(6501);
        if (C5046bo.isNullOrNil(str) || !(URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str))) {
            AppMethodBeat.m2505o(6501);
            return false;
        }
        AppMethodBeat.m2505o(6501);
        return true;
    }
}
