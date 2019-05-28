package com.tencent.p177mm.plugin.appbrand.game.p295e.p296a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.game.widget.input.C42449a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.game.e.a.d */
public final class C38221d extends C10296a<C19722s> {
    private static final int CTRL_INDEX = 70;
    private static final String NAME = "hideKeyboard";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130204);
        final C19722s c19722s = (C19722s) c2241c;
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(130203);
                C27242w aun = c19722s.aun();
                if (aun == null) {
                    AppMethodBeat.m2505o(130203);
                    return;
                }
                C42449a ck = C42449a.m75189ck(aun.getContentView());
                if (ck != null) {
                    ck.hide();
                }
                AppMethodBeat.m2505o(130203);
            }
        });
        c19722s.mo6107M(i, mo73394j("ok", null));
        AppMethodBeat.m2505o(130204);
    }
}
