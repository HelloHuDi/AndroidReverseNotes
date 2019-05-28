package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.bi */
public final class C46880bi extends C46180a {
    public long dck = 0;
    public long dcl = 0;

    public final int getId() {
        return 15522;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(56602);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.dck);
        stringBuffer.append(",");
        stringBuffer.append(this.dcl);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(56602);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(56603);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ReportScene:").append(this.dck);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ResetScece:").append(this.dcl);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(56603);
        return stringBuffer2;
    }
}
