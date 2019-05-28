package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class av extends bd<d> {
    public final String name() {
        return "setScreenOrientation";
    }

    public final int biG() {
        return 0;
    }

    public final void b(a aVar) {
        int i = 1;
        AppMethodBeat.i(6376);
        ab.i("MicroMsg.JsApiSetScreenOrientation", "invoke");
        String optString = aVar.bPa.bOf.optString("orientation");
        if (bo.isNullOrNil(optString)) {
            ab.e("MicroMsg.JsApiSetScreenOrientation", "data is null");
            aVar.a("invalid_data", null);
            AppMethodBeat.o(6376);
            return;
        }
        if (optString.equals(MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL)) {
            i = 0;
        } else if (!optString.equals("vertical")) {
            if (optString.equals("sensor")) {
                i = 4;
            } else if (optString.equals("horizontal_unforced")) {
                i = 0;
            } else if (!optString.equals("vertical_unforced")) {
                i = -1;
            }
        }
        ((d) aVar.bOZ).setPageOrientation(i);
        aVar.a("", null);
        AppMethodBeat.o(6376);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
