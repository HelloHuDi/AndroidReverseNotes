package com.tencent.p177mm.plugin.game.luggage.p429b;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C20334a.C20333c;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C38855d;
import com.tencent.p177mm.plugin.game.luggage.p432d.C12140e;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.luggage.b.j */
public class C24774j extends C22840bc<C12140e> {
    public final int biG() {
        return 2;
    }

    public final String name() {
        return "jumpDownloaderWidget";
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, final C22841a c22841a) {
        JSONObject jSONObject;
        String optString;
        AppMethodBeat.m2504i(135878);
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.JsApiJumpDownloaderWidget", e, "", new Object[0]);
            jSONObject = null;
        }
        String str2 = "";
        if (jSONObject != null) {
            optString = jSONObject.optString("appId");
        } else {
            optString = str2;
        }
        Intent intent = new Intent();
        intent.putExtra("appId", optString);
        intent.putExtra("view_task", true);
        ((C38855d) C1720g.m3528K(C38855d.class)).mo61727a(context, intent, new C20333c() {
            public final void biB() {
                AppMethodBeat.m2504i(135877);
                c22841a.mo26722d(null, null);
                AppMethodBeat.m2505o(135877);
            }
        });
        AppMethodBeat.m2505o(135878);
    }
}
