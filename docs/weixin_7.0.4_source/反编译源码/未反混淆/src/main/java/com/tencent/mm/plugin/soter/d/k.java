package com.tencent.mm.plugin.soter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k {
    public String aIm = "OK";
    public String cLO = "";
    public int errCode = 0;
    public byte rOj = (byte) 1;
    public String rOk = "";

    public final String toString() {
        AppMethodBeat.i(73894);
        String str = "SoterMpRespModel{errCode=" + this.errCode + ", errMsg='" + this.aIm + '\'' + ", resultMode=" + this.rOj + ", resultJson='" + this.cLO + '\'' + ", resultJsonSignature='" + this.rOk + '\'' + '}';
        AppMethodBeat.o(73894);
        return str;
    }
}
