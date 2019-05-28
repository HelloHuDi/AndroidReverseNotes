package com.tencent.p177mm.plugin.websearch.widget.p1323c.p1324a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.websearch.widget.p1323c.C46407c;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.websearch.widget.c.a.c */
public final class C29758c implements C43854a {
    /* renamed from: lO */
    public final boolean mo38361lO(long j) {
        AppMethodBeat.m2504i(91466);
        boolean H = C46407c.m87352H(j, 1);
        AppMethodBeat.m2505o(91466);
        return H;
    }

    public final boolean adV(String str) {
        AppMethodBeat.m2504i(91467);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(91467);
            return false;
        }
        boolean startsWith = str.startsWith("app://");
        AppMethodBeat.m2505o(91467);
        return startsWith;
    }

    public final boolean adW(String str) {
        AppMethodBeat.m2504i(91468);
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
            if (!m47204b(C4996ah.getContext(), queryParameter, hashMap)) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", queryParameter4);
                intent.putExtra("useJs", true);
                C25985d.m41467b(C4996ah.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.m2505o(91468);
            return true;
        }
        AppMethodBeat.m2505o(91468);
        return false;
    }

    /* renamed from: b */
    private boolean m47204b(final Context context, String str, Map<String, String> map) {
        AppMethodBeat.m2504i(91469);
        if (context == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(91469);
            return false;
        }
        try {
            final Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                for (Entry entry : map.entrySet()) {
                    launchIntentForPackage.putExtra((String) entry.getKey(), (String) entry.getValue());
                }
                C26006a.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(91465);
                        C46494g.m87736b(context, launchIntentForPackage, "");
                        AppMethodBeat.m2505o(91465);
                    }
                });
                AppMethodBeat.m2505o(91469);
                return true;
            }
        } catch (Exception e) {
            C4990ab.m7412e("OpenAppNativeApp", C5046bo.m7574l(e));
        }
        AppMethodBeat.m2505o(91469);
        return false;
    }
}
