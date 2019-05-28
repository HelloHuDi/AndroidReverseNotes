package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.d;
import com.tencent.mm.booter.s;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class SandBoxProfile extends e {
    public static final String ceo = (ah.getPackageName() + ":sandbox");

    static {
        AppMethodBeat.i(15399);
        AppMethodBeat.o(15399);
    }

    public final void onCreate() {
        AppMethodBeat.i(15398);
        d bo = d.bo(ah.getContext());
        k.a("MMProtocalJni", SandBoxProfile.class.getClassLoader());
        k.a(a.xxo, SandBoxProfile.class.getClassLoader());
        MMProtocalJni.setClientPackVersion(com.tencent.mm.protocal.d.vxo);
        s sVar = new s(bo);
        try {
            sVar.jE("SANDBOX");
            ae.gio = bo.a(sVar.jF(".com.tencent.mm.debug.test.network.simulate_down_fault"), false);
            ab.i("MicroMsg.SandboxDebugger", "Test.simulateDownFault = " + ae.gio);
        } catch (Error e) {
        }
        com.tencent.mm.sandbox.updater.k kVar = com.tencent.mm.sandbox.updater.k.a.xxn;
        q.Bz();
        AppMethodBeat.o(15398);
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final String toString() {
        return ceo;
    }
}
