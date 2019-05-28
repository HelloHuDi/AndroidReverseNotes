package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.luggage.k;
import com.tencent.mm.sdk.platformtools.ab;

public class ar extends bd<d> {
    public final String name() {
        return "setCloseWindowConfirmDialogInfo";
    }

    public final int biG() {
        return 0;
    }

    public final void b(a aVar) {
        AppMethodBeat.i(6372);
        ab.i("MicroMsg.JsApiSetCloseWindowConfirmDialogInfo", "invoke");
        Boolean valueOf = Boolean.valueOf(aVar.bPa.bOf.optBoolean("switch"));
        String optString = aVar.bPa.bOf.optString("title_cn");
        String optString2 = aVar.bPa.bOf.optString("title_eng");
        String optString3 = aVar.bPa.bOf.optString("ok_cn");
        String optString4 = aVar.bPa.bOf.optString("ok_eng");
        String optString5 = aVar.bPa.bOf.optString("cancel_cn");
        String optString6 = aVar.bPa.bOf.optString("cancel_eng");
        k cWH = ((d) aVar.bOZ).cWH();
        if (cWH == null) {
            AppMethodBeat.o(6372);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("close_window_confirm_dialog_switch", valueOf.booleanValue());
        bundle.putString("close_window_confirm_dialog_title_cn", optString);
        bundle.putString("close_window_confirm_dialog_title_eng", optString2);
        bundle.putString("close_window_confirm_dialog_ok_cn", optString3);
        bundle.putString("close_window_confirm_dialog_ok_eng", optString4);
        bundle.putString("close_window_confirm_dialog_cancel_cn", optString5);
        bundle.putString("close_window_confirm_dialog_cancel_eng", optString6);
        cWH.setCloseWindowConfirmInfo(bundle);
        aVar.a("", null);
        AppMethodBeat.o(6372);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
