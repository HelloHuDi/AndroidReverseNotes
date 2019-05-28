package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.core.c.j;
import java.security.Signature;

public enum v {
    ;
    
    public String msn;
    public boolean mso;
    private Signature tCo;
    public j tCp;

    private v(String str) {
        this.msn = null;
        this.mso = false;
        this.tCo = null;
        this.tCp = null;
    }

    static {
        AppMethodBeat.o(46896);
    }

    public final void reset() {
        AppMethodBeat.i(46895);
        ab.i("MicroMsg.WalletFingerprintVerifyManager", "hy: start reset");
        this.tCo = null;
        this.msn = null;
        this.mso = false;
        AppMethodBeat.o(46895);
    }
}
