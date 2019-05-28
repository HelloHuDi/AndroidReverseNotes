package com.tencent.p177mm.plugin.backup.p1394h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.backup.p342b.C33660a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.backup.h.d */
public final class C38658d extends C33660a {
    private static String TAG = "MicroMsg.BackupStorageModel";
    private static C38658d jyz;
    private C38657b jyA;
    private C45747a jyB;

    public static C38658d aUr() {
        C38658d c38658d;
        AppMethodBeat.m2504i(17706);
        if (jyz == null) {
            c38658d = new C38658d();
            jyz = c38658d;
            C33660a.m54968a(c38658d);
        }
        c38658d = jyz;
        AppMethodBeat.m2505o(17706);
        return c38658d;
    }

    public final void aSp() {
        jyz = null;
    }

    public final C38657b aUs() {
        AppMethodBeat.m2504i(17707);
        if (this.jyA == null) {
            this.jyA = new C38657b();
        }
        C38657b c38657b = this.jyA;
        AppMethodBeat.m2505o(17707);
        return c38657b;
    }

    public final C45747a aUt() {
        AppMethodBeat.m2504i(17708);
        if (this.jyB == null) {
            this.jyB = new C45747a();
        }
        C45747a c45747a = this.jyB;
        AppMethodBeat.m2505o(17708);
        return c45747a;
    }

    public final void aUu() {
        AppMethodBeat.m2504i(17709);
        C4990ab.m7416i(TAG, "backupInitStorage");
        C38657b aUs = aUs();
        C9638aw.m17190ZK();
        String accPath = C18628c.getAccPath();
        C9638aw.m17190ZK();
        aUs.mo61508bF(accPath, C18628c.m29064QF());
        AppMethodBeat.m2505o(17709);
    }
}
