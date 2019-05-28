package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.widget.input.aa;
import com.tencent.mm.plugin.appbrand.widget.input.o;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bj;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends u<com.tencent.mm.plugin.appbrand.page.u> {
    private static final int CTRL_INDEX = 583;
    private static final String NAME = "getSelectedTextRange";

    public final /* synthetic */ String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(123525);
        final com.tencent.mm.plugin.appbrand.page.u uVar = (com.tencent.mm.plugin.appbrand.page.u) cVar;
        int[] iArr = (int[]) new bj<int[]>() {
            public final /* synthetic */ Object run() {
                AppMethodBeat.i(123524);
                aa x = o.x(uVar);
                if (x == null) {
                    AppMethodBeat.o(123524);
                    return null;
                }
                int selectionStart = x.aQo().getSelectionStart();
                int selectionEnd = x.aQo().getSelectionEnd();
                Object obj = new int[]{selectionStart, selectionEnd};
                AppMethodBeat.o(123524);
                return obj;
            }
        }.b(new ak(Looper.getMainLooper()));
        String j;
        if (iArr == null) {
            j = j("fail:no focused input", null);
            AppMethodBeat.o(123525);
            return j;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("start", Integer.valueOf(iArr[0]));
        hashMap.put("end", Integer.valueOf(iArr[1]));
        j = j("ok", hashMap);
        AppMethodBeat.o(123525);
        return j;
    }
}
