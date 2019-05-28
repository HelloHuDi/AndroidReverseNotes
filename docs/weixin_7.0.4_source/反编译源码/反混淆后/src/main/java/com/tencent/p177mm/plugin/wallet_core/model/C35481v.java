package com.tencent.p177mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.soter.core.p1351c.C30973j;
import java.security.Signature;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.v */
public enum C35481v {
    ;
    
    public String msn;
    public boolean mso;
    private Signature tCo;
    public C30973j tCp;

    private C35481v(String str) {
        this.msn = null;
        this.mso = false;
        this.tCo = null;
        this.tCp = null;
    }

    static {
        AppMethodBeat.m2505o(46896);
    }

    public final void reset() {
        AppMethodBeat.m2504i(46895);
        C4990ab.m7416i("MicroMsg.WalletFingerprintVerifyManager", "hy: start reset");
        this.tCo = null;
        this.msn = null;
        this.mso = false;
        AppMethodBeat.m2505o(46895);
    }
}
