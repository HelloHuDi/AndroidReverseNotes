package com.tencent.mm.plugin.webview.e;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.regex.Pattern;

public final class e {
    public static void h(String str, Context context) {
        AppMethodBeat.i(10146);
        Editor edit = context.getSharedPreferences("webview_url_prefs", 4).edit();
        edit.putString("url", str);
        edit.apply();
        AppMethodBeat.o(10146);
    }

    public static boolean agF(String str) {
        AppMethodBeat.i(10147);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(10147);
            return false;
        }
        try {
            List pathSegments = Uri.parse(str).getPathSegments();
            if (pathSegments == null || pathSegments.size() <= 0) {
                AppMethodBeat.o(10147);
                return false;
            }
            String str2 = (String) pathSegments.get(pathSegments.size() - 1);
            if (str2 != null && str2.toLowerCase().trim().endsWith(".apk")) {
                AppMethodBeat.o(10147);
                return true;
            }
            AppMethodBeat.o(10147);
            return false;
        } catch (Exception e) {
        }
    }

    public static boolean agG(String str) {
        AppMethodBeat.i(10148);
        if (Pattern.compile("^(http|https)://mp.weixin.qq.com/(s|mp/author|mp/appmsg/show)", 2).matcher(str).find()) {
            AppMethodBeat.o(10148);
            return true;
        } else if (Pattern.compile("^(http|https)://(sh.|hk.|sz.)?open.weixin.qq.com/connect/(confirm|oauth2/(authorize|explorer_authorize))", 2).matcher(str).find()) {
            AppMethodBeat.o(10148);
            return true;
        } else {
            AppMethodBeat.o(10148);
            return false;
        }
    }
}
