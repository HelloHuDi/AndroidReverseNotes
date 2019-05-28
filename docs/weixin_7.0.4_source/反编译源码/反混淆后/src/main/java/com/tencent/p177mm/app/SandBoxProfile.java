package com.tencent.p177mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.C1326d;
import com.tencent.p177mm.booter.C32425s;
import com.tencent.p177mm.compatible.loader.C1439e;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.MMProtocalJni;
import com.tencent.p177mm.sandbox.updater.C46612k;
import com.tencent.p177mm.sandbox.updater.C46612k.C40610a;
import com.tencent.p177mm.sdk.C15418a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.app.SandBoxProfile */
public final class SandBoxProfile extends C1439e {
    public static final String ceo = (C4996ah.getPackageName() + ":sandbox");

    static {
        AppMethodBeat.m2504i(15399);
        AppMethodBeat.m2505o(15399);
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(15398);
        C1326d bo = C1326d.m2839bo(C4996ah.getContext());
        C1449k.m3079a("MMProtocalJni", SandBoxProfile.class.getClassLoader());
        C1449k.m3079a(C15418a.xxo, SandBoxProfile.class.getClassLoader());
        MMProtocalJni.setClientPackVersion(C7243d.vxo);
        C32425s c32425s = new C32425s(bo);
        try {
            c32425s.mo33553jE("SANDBOX");
            C1947ae.gio = C5046bo.m7517a(c32425s.mo33554jF(".com.tencent.mm.debug.test.network.simulate_down_fault"), false);
            C4990ab.m7416i("MicroMsg.SandboxDebugger", "Test.simulateDownFault = " + C1947ae.gio);
        } catch (Error e) {
        }
        C46612k c46612k = C40610a.xxn;
        C1266q.m2719Bz();
        AppMethodBeat.m2505o(15398);
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final String toString() {
        return ceo;
    }
}
