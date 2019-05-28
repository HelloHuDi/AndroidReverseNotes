package com.tencent.p177mm.plugin.soter.p528d;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.soter.d.k */
public final class C39856k {
    public String aIm = "OK";
    public String cLO = "";
    public int errCode = 0;
    public byte rOj = (byte) 1;
    public String rOk = "";

    public final String toString() {
        AppMethodBeat.m2504i(73894);
        String str = "SoterMpRespModel{errCode=" + this.errCode + ", errMsg='" + this.aIm + '\'' + ", resultMode=" + this.rOj + ", resultJson='" + this.cLO + '\'' + ", resultJsonSignature='" + this.rOk + '\'' + '}';
        AppMethodBeat.m2505o(73894);
        return str;
    }
}
