package com.tencent.mm.network;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.o.a;

public final class x extends a {
    public final void reportKV(long j, String str, boolean z, boolean z2) {
        AppMethodBeat.i(72652);
        final boolean z3 = z;
        final long j2 = j;
        final String str2 = str;
        final boolean z4 = z2;
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(72650);
                if (z3) {
                    SmcLogic.writeImportKvData(j2, str2, z4, false);
                    AppMethodBeat.o(72650);
                    return;
                }
                SmcLogic.writeKvData(j2, str2, z4, false);
                AppMethodBeat.o(72650);
            }

            public final String toString() {
                AppMethodBeat.i(72651);
                String str = super.toString() + "|reportKV";
                AppMethodBeat.o(72651);
                return str;
            }
        });
        AppMethodBeat.o(72652);
    }
}
