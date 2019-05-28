package com.tencent.p177mm.plugin.product.p482ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.product.ui.e */
public final class C46135e {
    int piG;
    private int piH;

    public C46135e(int i, int i2) {
        this.piH = i;
        this.piG = i2;
    }

    public final boolean cab() {
        AppMethodBeat.m2504i(44052);
        boolean z = (this.piH & 1) > 0;
        C4990ab.m7410d("MicroMsg.MallProductConfig", "isFreePost, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(44052);
        return z;
    }

    public final boolean cac() {
        AppMethodBeat.m2504i(44053);
        boolean z = (this.piH & 2) > 0;
        C4990ab.m7410d("MicroMsg.MallProductConfig", "hasReceipt, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(44053);
        return z;
    }
}
