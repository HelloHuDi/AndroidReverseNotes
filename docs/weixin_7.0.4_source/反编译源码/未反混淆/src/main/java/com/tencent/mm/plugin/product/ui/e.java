package com.tencent.mm.plugin.product.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class e {
    int piG;
    private int piH;

    public e(int i, int i2) {
        this.piH = i;
        this.piG = i2;
    }

    public final boolean cab() {
        AppMethodBeat.i(44052);
        boolean z = (this.piH & 1) > 0;
        ab.d("MicroMsg.MallProductConfig", "isFreePost, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(44052);
        return z;
    }

    public final boolean cac() {
        AppMethodBeat.i(44053);
        boolean z = (this.piH & 2) > 0;
        ab.d("MicroMsg.MallProductConfig", "hasReceipt, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(44053);
        return z;
    }
}
