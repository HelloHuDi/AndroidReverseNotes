package com.tencent.mm.z;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.z.b.d;

public final class a {

    public interface a {
        void Qp();

        void lo(String str);
    }

    public static void a(d dVar, String str, final a aVar) {
        AppMethodBeat.i(115298);
        if (bo.isNullOrNil(str)) {
            aVar.lo("");
            AppMethodBeat.o(115298);
            return;
        }
        dVar.evaluateJavascript(str + String.format(";var ___result_return = function(){return %d;};___result_return();", new Object[]{Integer.valueOf(11111)}), new ValueCallback<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                AppMethodBeat.i(115297);
                String str = (String) obj;
                if (str == null || !str.contains("11111")) {
                    if (aVar != null) {
                        aVar.lo(str);
                        AppMethodBeat.o(115297);
                        return;
                    }
                } else if (aVar != null) {
                    aVar.Qp();
                }
                AppMethodBeat.o(115297);
            }
        });
        AppMethodBeat.o(115298);
    }
}
