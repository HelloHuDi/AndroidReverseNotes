package com.tencent.p177mm.plugin.appbrand.jsapi.p303d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.widget.input.C42743o;
import com.tencent.p177mm.plugin.appbrand.widget.input.C45718aa;
import com.tencent.p177mm.sdk.platformtools.C5039bj;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.d.b */
public final class C2270b extends C19497u<C44709u> {
    private static final int CTRL_INDEX = 583;
    private static final String NAME = "getSelectedTextRange";

    /* renamed from: b */
    public final /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(123525);
        final C44709u c44709u = (C44709u) c2241c;
        int[] iArr = (int[]) new C5039bj<int[]>() {
            public final /* synthetic */ Object run() {
                AppMethodBeat.m2504i(123524);
                C45718aa x = C42743o.m75758x(c44709u);
                if (x == null) {
                    AppMethodBeat.m2505o(123524);
                    return null;
                }
                int selectionStart = x.aQo().getSelectionStart();
                int selectionEnd = x.aQo().getSelectionEnd();
                Object obj = new int[]{selectionStart, selectionEnd};
                AppMethodBeat.m2505o(123524);
                return obj;
            }
        }.mo10372b(new C7306ak(Looper.getMainLooper()));
        String j;
        if (iArr == null) {
            j = mo73394j("fail:no focused input", null);
            AppMethodBeat.m2505o(123525);
            return j;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("start", Integer.valueOf(iArr[0]));
        hashMap.put("end", Integer.valueOf(iArr[1]));
        j = mo73394j("ok", hashMap);
        AppMethodBeat.m2505o(123525);
        return j;
    }
}
