package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import org.json.JSONException;
import org.json.JSONObject;

public class ae extends bc {
    public final String name() {
        return "openBizChat";
    }

    public final int biG() {
        return 1;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, bc.a aVar) {
        AppMethodBeat.i(6338);
        try {
            String optString = new JSONObject(str).optString("username");
            if (bo.isNullOrNil(optString)) {
                aVar.d("param_err", null);
                AppMethodBeat.o(6338);
                return;
            }
            ad aoO = ((j) g.K(j.class)).XM().aoO(optString);
            if (aoO == null || !aoO.dsf()) {
                aVar.d("not biz username", null);
                AppMethodBeat.o(6338);
            } else if (com.tencent.mm.n.a.jh(aoO.field_type)) {
                Intent intent = new Intent();
                intent.putExtra("Chat_User", optString);
                intent.putExtra("finish_direct", true);
                d.f(context, ".ui.chatting.ChattingUI", intent);
                aVar.d(null, null);
                AppMethodBeat.o(6338);
            } else {
                aVar.d("open_biz_chat", null);
                AppMethodBeat.o(6338);
            }
        } catch (JSONException e) {
            ab.e("MicroMsg.JsApiOpenBizChat", "parase json fail");
            aVar.d("fail", null);
            AppMethodBeat.o(6338);
        }
    }
}
