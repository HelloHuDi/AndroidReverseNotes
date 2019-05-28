package com.tencent.p177mm.plugin.soter.p528d;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.soter.d.j */
public final class C46263j {
    public String content = null;
    public String msn = "";
    public byte rOi = (byte) 1;

    public final String toString() {
        AppMethodBeat.m2504i(73893);
        String str = "SoterMpReqModel{reqAuthenMode=" + this.rOi + ", challenge='" + this.msn + '\'' + ", content='" + this.content + '\'' + '}';
        AppMethodBeat.m2505o(73893);
        return str;
    }
}
