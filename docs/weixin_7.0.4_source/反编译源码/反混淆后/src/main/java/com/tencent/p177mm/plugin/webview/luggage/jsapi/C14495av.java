package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.av */
public class C14495av extends C46419bd<C24905d> {
    public final String name() {
        return "setScreenOrientation";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        int i = 1;
        AppMethodBeat.m2504i(6376);
        C4990ab.m7416i("MicroMsg.JsApiSetScreenOrientation", "invoke");
        String optString = c32183a.bPa.bOf.optString("orientation");
        if (C5046bo.isNullOrNil(optString)) {
            C4990ab.m7412e("MicroMsg.JsApiSetScreenOrientation", "data is null");
            c32183a.mo52824a("invalid_data", null);
            AppMethodBeat.m2505o(6376);
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
        ((C24905d) c32183a.bOZ).setPageOrientation(i);
        c32183a.mo52824a("", null);
        AppMethodBeat.m2505o(6376);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
