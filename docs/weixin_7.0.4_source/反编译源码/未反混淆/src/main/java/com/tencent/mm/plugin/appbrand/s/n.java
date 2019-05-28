package com.tencent.mm.plugin.appbrand.s;

import android.annotation.SuppressLint;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.MalformedURLException;
import java.net.URL;

public final class n {

    public interface a {
        void lo(String str);

        void onSuccess(String str);
    }

    public static void a(i iVar, String str, final a aVar) {
        AppMethodBeat.i(87428);
        if (bo.isNullOrNil(str)) {
            if (aVar != null) {
                aVar.lo("isNullOrNil script");
            }
            AppMethodBeat.o(87428);
            return;
        }
        iVar.evaluateJavascript(str + String.format(";(function(){return %d;})();", new Object[]{Integer.valueOf(11111)}), new ValueCallback<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                AppMethodBeat.i(87425);
                String str = (String) obj;
                if (str == null || !str.contains("11111")) {
                    if (aVar != null) {
                        aVar.lo(str);
                        AppMethodBeat.o(87425);
                        return;
                    }
                } else if (aVar != null) {
                    aVar.onSuccess(str);
                }
                AppMethodBeat.o(87425);
            }
        });
        AppMethodBeat.o(87428);
    }

    @SuppressLint({"DefaultLocale"})
    public static void a(i iVar, final String str, String str2, String str3, String str4, String str5, final a aVar) {
        AppMethodBeat.i(87429);
        ab.i("MicroMsg.JsValidationInjector", "hy: injecting file %s", str);
        if (bo.isNullOrNil(str4)) {
            ab.e("MicroMsg.JsValidationInjector", "hy: empty script!");
            if (aVar != null) {
                aVar.lo("isNullOrNil script");
            }
            AppMethodBeat.o(87429);
            return;
        }
        String str6 = (str4 + String.format(";(function(){return %d;})();", new Object[]{Integer.valueOf(11111)})) + bo.nullAsNil(str5);
        URL url = null;
        if (str != null) {
            try {
                if (str.length() > 0) {
                    url = new URL(str);
                }
            } catch (MalformedURLException e) {
                ab.e("MicroMsg.JsValidationInjector", "hy: MalformedURLException");
                aVar.lo("MalformedURLException");
                AppMethodBeat.o(87429);
                return;
            }
        }
        if (bo.isNullOrNil(str2) || bo.isNullOrNil(str3)) {
            iVar.a(url, str6, new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    AppMethodBeat.i(87426);
                    n.a(str, aVar, (String) obj);
                    AppMethodBeat.o(87426);
                }
            });
            AppMethodBeat.o(87429);
            return;
        }
        iVar.a(url, str2, str3, str6, new ValueCallback<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                AppMethodBeat.i(87427);
                n.a(str, aVar, (String) obj);
                AppMethodBeat.o(87427);
            }
        });
        AppMethodBeat.o(87429);
    }
}
