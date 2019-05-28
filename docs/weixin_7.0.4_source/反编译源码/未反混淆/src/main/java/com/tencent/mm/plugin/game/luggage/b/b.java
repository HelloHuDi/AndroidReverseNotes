package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc;
import com.tencent.mm.plugin.webview.ui.tools.game.i;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends bc {
    public final String name() {
        return "addGameDownloadTask";
    }

    public final int biG() {
        return 2;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, final bc.a aVar) {
        AppMethodBeat.i(135867);
        try {
            i.a(context, com.tencent.mm.plugin.downloader_app.b.a.R(new JSONObject(str)), new i.a() {
                public final void d(String str, JSONObject jSONObject) {
                    AppMethodBeat.i(135866);
                    aVar.d(str, jSONObject);
                    AppMethodBeat.o(135866);
                }
            });
            AppMethodBeat.o(135867);
        } catch (JSONException e) {
            aVar.d("fail", null);
            AppMethodBeat.o(135867);
        }
    }
}
