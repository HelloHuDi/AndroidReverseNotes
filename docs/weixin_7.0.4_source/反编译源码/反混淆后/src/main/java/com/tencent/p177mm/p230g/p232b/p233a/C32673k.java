package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.k */
public final class C32673k extends C46180a {
    public long cVR = 0;
    public long cVS = 0;

    public final int getId() {
        return 17055;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(138603);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cVR);
        stringBuffer.append(",");
        stringBuffer.append(this.cVS);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(138603);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(138604);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.cVR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Action:").append(this.cVS);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(138604);
        return stringBuffer2;
    }
}
