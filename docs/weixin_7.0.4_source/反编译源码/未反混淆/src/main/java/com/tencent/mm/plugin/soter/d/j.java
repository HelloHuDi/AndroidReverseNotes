package com.tencent.mm.plugin.soter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j {
    public String content = null;
    public String msn = "";
    public byte rOi = (byte) 1;

    public final String toString() {
        AppMethodBeat.i(73893);
        String str = "SoterMpReqModel{reqAuthenMode=" + this.rOi + ", challenge='" + this.msn + '\'' + ", content='" + this.content + '\'' + '}';
        AppMethodBeat.o(73893);
        return str;
    }
}
