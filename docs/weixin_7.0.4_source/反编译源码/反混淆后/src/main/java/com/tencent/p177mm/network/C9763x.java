package com.tencent.p177mm.network;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1926o.C1927a;

/* renamed from: com.tencent.mm.network.x */
public final class C9763x extends C1927a {
    public final void reportKV(long j, String str, boolean z, boolean z2) {
        AppMethodBeat.m2504i(72652);
        final boolean z3 = z;
        final long j2 = j;
        final String str2 = str;
        final boolean z4 = z2;
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(72650);
                if (z3) {
                    SmcLogic.writeImportKvData(j2, str2, z4, false);
                    AppMethodBeat.m2505o(72650);
                    return;
                }
                SmcLogic.writeKvData(j2, str2, z4, false);
                AppMethodBeat.m2505o(72650);
            }

            public final String toString() {
                AppMethodBeat.m2504i(72651);
                String str = super.toString() + "|reportKV";
                AppMethodBeat.m2505o(72651);
                return str;
            }
        });
        AppMethodBeat.m2505o(72652);
    }
}
