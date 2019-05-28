package com.tencent.p177mm.plugin.webview.luggage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.luggage.r */
public final class C43906r {
    private String lang = C4988aa.m7403gw(C4996ah.getContext());
    private String ujA;
    private String ujB;
    private String ujC;
    private String ujD;
    private String ujE;
    private boolean ujy;
    private String ujz;

    public C43906r(Bundle bundle) {
        AppMethodBeat.m2504i(6233);
        this.ujy = bundle.getBoolean("close_window_confirm_dialog_switch");
        this.ujz = bundle.getString("close_window_confirm_dialog_title_cn");
        this.ujA = bundle.getString("close_window_confirm_dialog_title_eng");
        this.ujB = bundle.getString("close_window_confirm_dialog_ok_cn");
        this.ujC = bundle.getString("close_window_confirm_dialog_ok_eng");
        this.ujD = bundle.getString("close_window_confirm_dialog_cancel_cn");
        this.ujE = bundle.getString("close_window_confirm_dialog_cancel_eng");
        AppMethodBeat.m2505o(6233);
    }

    public final boolean cXi() {
        AppMethodBeat.m2504i(6234);
        if (!this.ujy || C5046bo.isNullOrNil(cXj()) || C5046bo.isNullOrNil(cXk()) || C5046bo.isNullOrNil(cXl())) {
            AppMethodBeat.m2505o(6234);
            return false;
        }
        AppMethodBeat.m2505o(6234);
        return true;
    }

    public final String cXj() {
        AppMethodBeat.m2504i(6235);
        String str;
        if ("zh_CN".equals(this.lang)) {
            str = this.ujz;
            AppMethodBeat.m2505o(6235);
            return str;
        }
        str = this.ujA;
        AppMethodBeat.m2505o(6235);
        return str;
    }

    public final String cXk() {
        AppMethodBeat.m2504i(6236);
        String str;
        if ("zh_CN".equals(this.lang)) {
            str = this.ujB;
            AppMethodBeat.m2505o(6236);
            return str;
        }
        str = this.ujC;
        AppMethodBeat.m2505o(6236);
        return str;
    }

    public final String cXl() {
        AppMethodBeat.m2504i(6237);
        String str;
        if ("zh_CN".equals(this.lang)) {
            str = this.ujD;
            AppMethodBeat.m2505o(6237);
            return str;
        }
        str = this.ujE;
        AppMethodBeat.m2505o(6237);
        return str;
    }
}
