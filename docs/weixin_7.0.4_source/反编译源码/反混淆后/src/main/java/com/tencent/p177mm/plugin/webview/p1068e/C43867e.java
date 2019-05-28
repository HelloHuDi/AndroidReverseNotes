package com.tencent.p177mm.plugin.webview.p1068e;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.webview.e.e */
public final class C43867e {
    /* renamed from: h */
    public static void m78659h(String str, Context context) {
        AppMethodBeat.m2504i(10146);
        Editor edit = context.getSharedPreferences("webview_url_prefs", 4).edit();
        edit.putString("url", str);
        edit.apply();
        AppMethodBeat.m2505o(10146);
    }

    public static boolean agF(String str) {
        AppMethodBeat.m2504i(10147);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(10147);
            return false;
        }
        try {
            List pathSegments = Uri.parse(str).getPathSegments();
            if (pathSegments == null || pathSegments.size() <= 0) {
                AppMethodBeat.m2505o(10147);
                return false;
            }
            String str2 = (String) pathSegments.get(pathSegments.size() - 1);
            if (str2 != null && str2.toLowerCase().trim().endsWith(".apk")) {
                AppMethodBeat.m2505o(10147);
                return true;
            }
            AppMethodBeat.m2505o(10147);
            return false;
        } catch (Exception e) {
        }
    }

    public static boolean agG(String str) {
        AppMethodBeat.m2504i(10148);
        if (Pattern.compile("^(http|https)://mp.weixin.qq.com/(s|mp/author|mp/appmsg/show)", 2).matcher(str).find()) {
            AppMethodBeat.m2505o(10148);
            return true;
        } else if (Pattern.compile("^(http|https)://(sh.|hk.|sz.)?open.weixin.qq.com/connect/(confirm|oauth2/(authorize|explorer_authorize))", 2).matcher(str).find()) {
            AppMethodBeat.m2505o(10148);
            return true;
        } else {
            AppMethodBeat.m2505o(10148);
            return false;
        }
    }
}
