package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

public final class d {
    StringBuffer fQt = new StringBuffer();
    StringBuffer fQu = new StringBuffer();
    private int index = 0;

    public d() {
        AppMethodBeat.i(78618);
        AppMethodBeat.o(78618);
    }

    public final void k(String str, Object obj) {
        AppMethodBeat.i(78619);
        this.fQt.append(this.index + " " + str + "->" + obj + IOUtils.LINE_SEPARATOR_UNIX);
        this.fQu.append(obj);
        this.index++;
        AppMethodBeat.o(78619);
    }

    public final void l(String str, Object obj) {
        AppMethodBeat.i(78620);
        this.fQt.append(str + "->" + obj + IOUtils.LINE_SEPARATOR_UNIX);
        this.fQu.append(obj);
        AppMethodBeat.o(78620);
    }

    public final String toString() {
        AppMethodBeat.i(78621);
        String stringBuffer = this.fQu.toString();
        AppMethodBeat.o(78621);
        return stringBuffer;
    }

    public final String Fk() {
        AppMethodBeat.i(78622);
        this.index = 0;
        this.fQt.append("--end--\n\n");
        String stringBuffer = this.fQt.toString();
        AppMethodBeat.o(78622);
        return stringBuffer;
    }
}
