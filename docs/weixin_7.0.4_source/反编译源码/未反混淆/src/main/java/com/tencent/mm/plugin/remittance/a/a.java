package com.tencent.mm.plugin.remittance.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c;

public class a extends c {
    public c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(44422);
        ab.d("MicroMsg.RemittanceProcess", "start Process : RemittanceProcess");
        b(activity, RemittanceAdapterUI.class, bundle);
        AppMethodBeat.o(44422);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
    }

    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(44423);
        super.aG(activity);
        AppMethodBeat.o(44423);
    }

    public final void c(Activity activity, int i) {
        AppMethodBeat.i(44424);
        F(activity);
        AppMethodBeat.o(44424);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String bxP() {
        return "RemittanceProcess";
    }
}
