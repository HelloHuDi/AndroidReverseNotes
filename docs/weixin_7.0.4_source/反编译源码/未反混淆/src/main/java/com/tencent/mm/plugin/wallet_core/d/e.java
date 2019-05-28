package com.tencent.mm.plugin.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.sdk.e.j;

public final class e extends j<w> {
    public static final String[] fnj = new String[]{j.a(w.ccO, "WalletFunciontList")};
    public com.tencent.mm.sdk.e.e bSd;

    static {
        AppMethodBeat.i(47074);
        AppMethodBeat.o(47074);
    }

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, w.ccO, "WalletFunciontList", null);
        this.bSd = eVar;
    }

    public final void b(int i, String str, String str2, String str3, String str4, int i2) {
        AppMethodBeat.i(47073);
        w wVar = new w();
        wVar.field_wallet_region = i;
        wVar.field_function_list = str;
        wVar.field_new_list = str2;
        wVar.field_banner_list = str3;
        wVar.field_type_name_list = str4;
        wVar.field_isShowSetting = i2;
        super.a(wVar);
        AppMethodBeat.o(47073);
    }
}
