package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.bb */
public final class C42086bb extends C46180a {
    public long cVR = 0;
    public long cVS = 0;
    public long daS = 0;

    public final int getId() {
        return 16440;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(77607);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cVR);
        stringBuffer.append(str);
        stringBuffer.append(this.cVS);
        stringBuffer.append(str);
        stringBuffer.append(this.daS);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(77607);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(77608);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.cVR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Action:").append(this.cVS);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Status:").append(this.daS);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(77608);
        return stringBuffer2;
    }
}
