package com.tencent.mm.plugin.u.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    public int cvn = 0;
    public int cvo = 0;
    public String pAE = "";
    public byte[] rawData = new byte[0];
    public String result = "";

    public d() {
        AppMethodBeat.i(80770);
        AppMethodBeat.o(80770);
    }

    public final String toString() {
        AppMethodBeat.i(80771);
        String format = String.format("result: %s, codeType: %s, codeTypeName %s, codeVersion: %s", new Object[]{this.result, Integer.valueOf(this.cvn), this.pAE, Integer.valueOf(this.cvo)});
        AppMethodBeat.o(80771);
        return format;
    }
}
