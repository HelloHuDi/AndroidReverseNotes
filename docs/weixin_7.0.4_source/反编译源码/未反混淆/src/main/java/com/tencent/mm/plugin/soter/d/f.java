package com.tencent.mm.plugin.soter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class f extends c<cq> {
    private static String TAG = "MicroMsg.SoterDynamicConfigUpdatedEventListener";

    public f() {
        AppMethodBeat.i(59335);
        this.xxI = cq.class.getName().hashCode();
        AppMethodBeat.o(59335);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(59336);
        ab.i(TAG, "alvinluo dynamic config updated.");
        m.cvR();
        AppMethodBeat.o(59336);
        return true;
    }
}
