package com.tencent.p177mm.plugin.game.luggage.p429b;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.luggage.p432d.C12140e;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.wepkg.model.C46476g;
import com.tencent.p177mm.plugin.wepkg.model.C46476g.C4700a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.luggage.b.h */
public class C12131h extends C22840bc<C12140e> {
    public final String name() {
        return "getLocalWePkgInfo";
    }

    public final int biG() {
        return 1;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, final C22841a c22841a) {
        AppMethodBeat.m2504i(135875);
        C4990ab.m7416i("MicroMsg.JsApiGetLocalWePkgInfo", "invokeInMM");
        C5004al.m7441d(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.game.luggage.b.h$1$1 */
            class C121301 implements C4700a {
                C121301() {
                }

                /* renamed from: U */
                public final void mo9823U(JSONObject jSONObject) {
                    AppMethodBeat.m2504i(135873);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("wepkg_info", jSONObject);
                    } catch (JSONException e) {
                    }
                    c22841a.mo26722d(null, jSONObject2);
                    AppMethodBeat.m2505o(135873);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(135874);
                C46476g.m87672a(new C121301());
                AppMethodBeat.m2505o(135874);
            }
        });
        AppMethodBeat.m2505o(135875);
    }
}
