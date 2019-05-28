package com.tencent.p177mm.plugin.appbrand.p329s;

import android.annotation.SuppressLint;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p297h.C6747i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.net.MalformedURLException;
import java.net.URL;

/* renamed from: com.tencent.mm.plugin.appbrand.s.n */
public final class C42682n {

    /* renamed from: com.tencent.mm.plugin.appbrand.s.n$a */
    public interface C42683a {
        /* renamed from: lo */
        void mo5987lo(String str);

        void onSuccess(String str);
    }

    /* renamed from: a */
    public static void m75589a(C6747i c6747i, String str, final C42683a c42683a) {
        AppMethodBeat.m2504i(87428);
        if (C5046bo.isNullOrNil(str)) {
            if (c42683a != null) {
                c42683a.mo5987lo("isNullOrNil script");
            }
            AppMethodBeat.m2505o(87428);
            return;
        }
        c6747i.evaluateJavascript(str + String.format(";(function(){return %d;})();", new Object[]{Integer.valueOf(11111)}), new ValueCallback<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                AppMethodBeat.m2504i(87425);
                String str = (String) obj;
                if (str == null || !str.contains("11111")) {
                    if (c42683a != null) {
                        c42683a.mo5987lo(str);
                        AppMethodBeat.m2505o(87425);
                        return;
                    }
                } else if (c42683a != null) {
                    c42683a.onSuccess(str);
                }
                AppMethodBeat.m2505o(87425);
            }
        });
        AppMethodBeat.m2505o(87428);
    }

    @SuppressLint({"DefaultLocale"})
    /* renamed from: a */
    public static void m75590a(C6747i c6747i, final String str, String str2, String str3, String str4, String str5, final C42683a c42683a) {
        AppMethodBeat.m2504i(87429);
        C4990ab.m7417i("MicroMsg.JsValidationInjector", "hy: injecting file %s", str);
        if (C5046bo.isNullOrNil(str4)) {
            C4990ab.m7412e("MicroMsg.JsValidationInjector", "hy: empty script!");
            if (c42683a != null) {
                c42683a.mo5987lo("isNullOrNil script");
            }
            AppMethodBeat.m2505o(87429);
            return;
        }
        String str6 = (str4 + String.format(";(function(){return %d;})();", new Object[]{Integer.valueOf(11111)})) + C5046bo.nullAsNil(str5);
        URL url = null;
        if (str != null) {
            try {
                if (str.length() > 0) {
                    url = new URL(str);
                }
            } catch (MalformedURLException e) {
                C4990ab.m7412e("MicroMsg.JsValidationInjector", "hy: MalformedURLException");
                c42683a.mo5987lo("MalformedURLException");
                AppMethodBeat.m2505o(87429);
                return;
            }
        }
        if (C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3)) {
            c6747i.mo14967a(url, str6, new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    AppMethodBeat.m2504i(87426);
                    C42682n.m75591a(str, c42683a, (String) obj);
                    AppMethodBeat.m2505o(87426);
                }
            });
            AppMethodBeat.m2505o(87429);
            return;
        }
        c6747i.mo14968a(url, str2, str3, str6, new ValueCallback<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                AppMethodBeat.m2504i(87427);
                C42682n.m75591a(str, c42683a, (String) obj);
                AppMethodBeat.m2505o(87427);
            }
        });
        AppMethodBeat.m2505o(87429);
    }
}
