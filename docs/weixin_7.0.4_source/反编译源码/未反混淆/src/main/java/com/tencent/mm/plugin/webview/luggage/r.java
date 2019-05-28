package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class r {
    private String lang = aa.gw(ah.getContext());
    private String ujA;
    private String ujB;
    private String ujC;
    private String ujD;
    private String ujE;
    private boolean ujy;
    private String ujz;

    public r(Bundle bundle) {
        AppMethodBeat.i(6233);
        this.ujy = bundle.getBoolean("close_window_confirm_dialog_switch");
        this.ujz = bundle.getString("close_window_confirm_dialog_title_cn");
        this.ujA = bundle.getString("close_window_confirm_dialog_title_eng");
        this.ujB = bundle.getString("close_window_confirm_dialog_ok_cn");
        this.ujC = bundle.getString("close_window_confirm_dialog_ok_eng");
        this.ujD = bundle.getString("close_window_confirm_dialog_cancel_cn");
        this.ujE = bundle.getString("close_window_confirm_dialog_cancel_eng");
        AppMethodBeat.o(6233);
    }

    public final boolean cXi() {
        AppMethodBeat.i(6234);
        if (!this.ujy || bo.isNullOrNil(cXj()) || bo.isNullOrNil(cXk()) || bo.isNullOrNil(cXl())) {
            AppMethodBeat.o(6234);
            return false;
        }
        AppMethodBeat.o(6234);
        return true;
    }

    public final String cXj() {
        AppMethodBeat.i(6235);
        String str;
        if ("zh_CN".equals(this.lang)) {
            str = this.ujz;
            AppMethodBeat.o(6235);
            return str;
        }
        str = this.ujA;
        AppMethodBeat.o(6235);
        return str;
    }

    public final String cXk() {
        AppMethodBeat.i(6236);
        String str;
        if ("zh_CN".equals(this.lang)) {
            str = this.ujB;
            AppMethodBeat.o(6236);
            return str;
        }
        str = this.ujC;
        AppMethodBeat.o(6236);
        return str;
    }

    public final String cXl() {
        AppMethodBeat.i(6237);
        String str;
        if ("zh_CN".equals(this.lang)) {
            str = this.ujD;
            AppMethodBeat.o(6237);
            return str;
        }
        str = this.ujE;
        AppMethodBeat.o(6237);
        return str;
    }
}
