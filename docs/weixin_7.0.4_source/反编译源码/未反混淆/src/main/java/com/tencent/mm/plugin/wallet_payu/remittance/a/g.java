package com.tencent.mm.plugin.wallet_payu.remittance.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.a.a;
import com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceAdapterUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c;

public class g extends a {
    public final c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48537);
        ab.d("MicroMsg.PayURemittanceProcess", "start Process : PayURemittanceProcess");
        b(activity, PayURemittanceAdapterUI.class, bundle);
        AppMethodBeat.o(48537);
        return this;
    }
}
