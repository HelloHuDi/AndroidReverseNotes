package com.tencent.p177mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.a */
public final class C29628a {
    public String cEh;
    public String kCs;
    public String nZb;
    public String nZc;

    public final boolean cPa() {
        AppMethodBeat.m2504i(46694);
        if (C5046bo.isNullOrNil(this.cEh) || C5046bo.isNullOrNil(this.nZb) || C5046bo.isNullOrNil(this.nZc) || C5046bo.isNullOrNil(this.kCs)) {
            AppMethodBeat.m2505o(46694);
            return false;
        }
        AppMethodBeat.m2505o(46694);
        return true;
    }
}
