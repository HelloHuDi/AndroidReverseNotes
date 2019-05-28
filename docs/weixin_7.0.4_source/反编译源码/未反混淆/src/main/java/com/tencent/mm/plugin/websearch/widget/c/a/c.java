package com.tencent.mm.plugin.websearch.widget.c.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.ce.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class c implements a {
    public final boolean lO(long j) {
        AppMethodBeat.i(91466);
        boolean H = com.tencent.mm.plugin.websearch.widget.c.c.H(j, 1);
        AppMethodBeat.o(91466);
        return H;
    }

    public final boolean adV(String str) {
        AppMethodBeat.i(91467);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(91467);
            return false;
        }
        boolean startsWith = str.startsWith("app://");
        AppMethodBeat.o(91467);
        return startsWith;
    }

    public final boolean adW(String str) {
        AppMethodBeat.i(91468);
        if (adV(str)) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("pkgName");
            String queryParameter2 = parse.getQueryParameter("extra");
            String queryParameter3 = parse.getQueryParameter("extraIntentKey");
            String queryParameter4 = parse.getQueryParameter("fallbackUrl");
            HashMap hashMap = new HashMap();
            if (!(TextUtils.isEmpty(queryParameter2) || TextUtils.isEmpty(queryParameter3))) {
                hashMap.put(queryParameter3, queryParameter2);
            }
            if (!b(ah.getContext(), queryParameter, hashMap)) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", queryParameter4);
                intent.putExtra("useJs", true);
                d.b(ah.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.o(91468);
            return true;
        }
        AppMethodBeat.o(91468);
        return false;
    }

    private boolean b(final Context context, String str, Map<String, String> map) {
        AppMethodBeat.i(91469);
        if (context == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(91469);
            return false;
        }
        try {
            final Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                for (Entry entry : map.entrySet()) {
                    launchIntentForPackage.putExtra((String) entry.getKey(), (String) entry.getValue());
                }
                a.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(91465);
                        g.b(context, launchIntentForPackage, "");
                        AppMethodBeat.o(91465);
                    }
                });
                AppMethodBeat.o(91469);
                return true;
            }
        } catch (Exception e) {
            ab.e("OpenAppNativeApp", bo.l(e));
        }
        AppMethodBeat.o(91469);
        return false;
    }
}
