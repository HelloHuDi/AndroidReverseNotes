package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.ba */
public final class C42085ba extends C46180a {
    public long cVS = 0;
    public long daR = 0;

    public final int getId() {
        return 16996;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(73676);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.daR);
        stringBuffer.append(",");
        stringBuffer.append(this.cVS);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(73676);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(73677);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ThirdAppType:").append(this.daR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Action:").append(this.cVS);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(73677);
        return stringBuffer2;
    }
}
