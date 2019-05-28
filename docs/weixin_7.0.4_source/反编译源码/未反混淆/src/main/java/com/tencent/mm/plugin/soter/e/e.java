package com.tencent.mm.plugin.soter.e;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.a.c.a;
import com.tencent.soter.a.g.j;

public final class e extends j {
    public e(Context context, com.tencent.soter.a.g.e eVar) {
        super(context, eVar);
    }

    @SuppressLint({"DefaultLocale"})
    public final void b(String str, int[] iArr) {
        AppMethodBeat.i(59361);
        ab.v("MicroMsg.SoterTaskInitForWX", "alvinluo generateAuthKeyNames");
        for (int i : iArr) {
            Object cvT;
            if (i == 1 && g.RN().QY()) {
                cvT = m.cvT();
            } else {
                cvT = String.format("SoterAuthKey_salt%s_scene%d", new Object[]{com.tencent.soter.core.c.g.nullAsNil(str), Integer.valueOf(i)});
            }
            ab.i("MicroMsg.SoterTaskInitForWX", "alvinluo scene: %d, authKeyName: %s", Integer.valueOf(i), cvT);
            a.dRe().dRg().put(i, cvT);
        }
        AppMethodBeat.o(59361);
    }
}
