package com.tencent.p177mm.plugin.game.luggage.p429b;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.downloader_app.p377b.C45833a;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.C35675i;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.C35675i.C4624a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.luggage.b.b */
public class C46002b extends C22840bc {
    public final String name() {
        return "addGameDownloadTask";
    }

    public final int biG() {
        return 2;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, final C22841a c22841a) {
        AppMethodBeat.m2504i(135867);
        try {
            C35675i.m58527a(context, C45833a.m84829R(new JSONObject(str)), new C4624a() {
                /* renamed from: d */
                public final void mo9715d(String str, JSONObject jSONObject) {
                    AppMethodBeat.m2504i(135866);
                    c22841a.mo26722d(str, jSONObject);
                    AppMethodBeat.m2505o(135866);
                }
            });
            AppMethodBeat.m2505o(135867);
        } catch (JSONException e) {
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(135867);
        }
    }
}
