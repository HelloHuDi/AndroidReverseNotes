package com.tencent.mm.plugin.hardwareopt.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hardwareopt.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.e;

public final class a implements com.tencent.mm.plugin.hardwareopt.a.a.a {
    public final void hX(boolean z) {
        AppMethodBeat.i(59272);
        new e().C(ah.getContext()).e(new com.tencent.mm.plugin.hardwareopt.c.a()).d(new b(z)).a((com.tencent.mm.vending.g.d.a) new com.tencent.mm.vending.g.d.a() {
            public final void bi(Object obj) {
                AppMethodBeat.i(59271);
                ab.w("MicroMsg.HardwareProvider", "hy: on interrupt.");
                AppMethodBeat.o(59271);
            }
        }).a(new d.b<Boolean>() {
            public final /* synthetic */ void az(Object obj) {
                AppMethodBeat.i(59270);
                ab.i("MicroMsg.HardwareProvider", "hy: on terminate");
                AppMethodBeat.o(59270);
            }
        });
        AppMethodBeat.o(59272);
    }
}
