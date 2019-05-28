package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l {
    private static l qis;
    byte[] qit = null;
    private byte[] qiu = null;

    private l() {
    }

    public static l cij() {
        AppMethodBeat.i(81461);
        if (qis == null) {
            qis = new l();
        }
        l lVar = qis;
        AppMethodBeat.o(81461);
        return lVar;
    }

    public final void cik() {
        if (this.qit != null) {
            this.qit = null;
        }
        if (this.qiu != null) {
            this.qiu = null;
        }
    }
}
