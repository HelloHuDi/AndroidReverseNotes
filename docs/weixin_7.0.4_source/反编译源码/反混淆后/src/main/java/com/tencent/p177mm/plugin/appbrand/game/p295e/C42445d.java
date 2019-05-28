package com.tencent.p177mm.plugin.appbrand.game.p295e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.game.C42439b;
import com.tencent.p177mm.plugin.appbrand.game.page.C33204f;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.file.C19377f.C10396a;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.game.e.d */
public final class C42445d extends C19497u<C42439b> {
    public static final int CTRL_INDEX = 401;
    public static final String NAME = "canvasToTempFilePathSync";

    /* renamed from: b */
    public final /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(130196);
        C27242w aun = ((C42439b) c2241c).aun();
        String j;
        if (aun instanceof C33204f) {
            C10396a a = C38224c.m64672a((C33204f) aun, jSONObject, true);
            j = mo73394j(a.aIm, a.values);
            AppMethodBeat.m2505o(130196);
            return j;
        }
        j = mo73394j("fail", null);
        AppMethodBeat.m2505o(130196);
        return j;
    }
}
