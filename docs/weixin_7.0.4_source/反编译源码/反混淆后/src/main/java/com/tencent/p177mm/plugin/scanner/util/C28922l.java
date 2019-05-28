package com.tencent.p177mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.scanner.util.l */
public final class C28922l {
    private static C28922l qis;
    byte[] qit = null;
    private byte[] qiu = null;

    private C28922l() {
    }

    public static C28922l cij() {
        AppMethodBeat.m2504i(81461);
        if (qis == null) {
            qis = new C28922l();
        }
        C28922l c28922l = qis;
        AppMethodBeat.m2505o(81461);
        return c28922l;
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
