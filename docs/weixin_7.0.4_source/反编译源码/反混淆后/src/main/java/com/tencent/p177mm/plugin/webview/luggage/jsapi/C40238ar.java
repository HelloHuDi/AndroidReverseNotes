package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.luggage.C22857k;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.ar */
public class C40238ar extends C46419bd<C24905d> {
    public final String name() {
        return "setCloseWindowConfirmDialogInfo";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        AppMethodBeat.m2504i(6372);
        C4990ab.m7416i("MicroMsg.JsApiSetCloseWindowConfirmDialogInfo", "invoke");
        Boolean valueOf = Boolean.valueOf(c32183a.bPa.bOf.optBoolean("switch"));
        String optString = c32183a.bPa.bOf.optString("title_cn");
        String optString2 = c32183a.bPa.bOf.optString("title_eng");
        String optString3 = c32183a.bPa.bOf.optString("ok_cn");
        String optString4 = c32183a.bPa.bOf.optString("ok_eng");
        String optString5 = c32183a.bPa.bOf.optString("cancel_cn");
        String optString6 = c32183a.bPa.bOf.optString("cancel_eng");
        C22857k cWH = ((C24905d) c32183a.bOZ).cWH();
        if (cWH == null) {
            AppMethodBeat.m2505o(6372);
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
        c32183a.mo52824a("", null);
        AppMethodBeat.m2505o(6372);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
