package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {
    public String cEh;
    public String kCs;
    public String nZb;
    public String nZc;

    public final boolean cPa() {
        AppMethodBeat.i(46694);
        if (bo.isNullOrNil(this.cEh) || bo.isNullOrNil(this.nZb) || bo.isNullOrNil(this.nZc) || bo.isNullOrNil(this.kCs)) {
            AppMethodBeat.o(46694);
            return false;
        }
        AppMethodBeat.o(46694);
        return true;
    }
}
