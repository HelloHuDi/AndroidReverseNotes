package com.tencent.p177mm.plugin.p543u.p544a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.u.a.d */
public final class C4264d {
    public int cvn = 0;
    public int cvo = 0;
    public String pAE = "";
    public byte[] rawData = new byte[0];
    public String result = "";

    public C4264d() {
        AppMethodBeat.m2504i(80770);
        AppMethodBeat.m2505o(80770);
    }

    public final String toString() {
        AppMethodBeat.m2504i(80771);
        String format = String.format("result: %s, codeType: %s, codeTypeName %s, codeVersion: %s", new Object[]{this.result, Integer.valueOf(this.cvn), this.pAE, Integer.valueOf(this.cvo)});
        AppMethodBeat.m2505o(80771);
        return format;
    }
}
