package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.bj */
public final class C42088bj extends C46180a {
    public long cVT = 0;
    public long dcm = 0;
    public long dcn = 0;

    public final int getId() {
        return 15661;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(77616);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cVT);
        stringBuffer.append(str);
        stringBuffer.append(this.dcm);
        stringBuffer.append(str);
        stringBuffer.append(this.dcn);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(77616);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(77617);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ClickScene:").append(this.cVT);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ReportValue:").append(this.dcm);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EntryScene:").append(this.dcn);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(77617);
        return stringBuffer2;
    }
}
