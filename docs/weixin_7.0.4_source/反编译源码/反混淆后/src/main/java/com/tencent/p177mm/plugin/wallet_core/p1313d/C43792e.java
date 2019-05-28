package com.tencent.p177mm.plugin.wallet_core.p1313d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.model.C35482w;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;

/* renamed from: com.tencent.mm.plugin.wallet_core.d.e */
public final class C43792e extends C7563j<C35482w> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C35482w.ccO, "WalletFunciontList")};
    public C4927e bSd;

    static {
        AppMethodBeat.m2504i(47074);
        AppMethodBeat.m2505o(47074);
    }

    public C43792e(C4927e c4927e) {
        super(c4927e, C35482w.ccO, "WalletFunciontList", null);
        this.bSd = c4927e;
    }

    /* renamed from: b */
    public final void mo69473b(int i, String str, String str2, String str3, String str4, int i2) {
        AppMethodBeat.m2504i(47073);
        C35482w c35482w = new C35482w();
        c35482w.field_wallet_region = i;
        c35482w.field_function_list = str;
        c35482w.field_new_list = str2;
        c35482w.field_banner_list = str3;
        c35482w.field_type_name_list = str4;
        c35482w.field_isShowSetting = i2;
        super.mo10099a(c35482w);
        AppMethodBeat.m2505o(47073);
    }
}
