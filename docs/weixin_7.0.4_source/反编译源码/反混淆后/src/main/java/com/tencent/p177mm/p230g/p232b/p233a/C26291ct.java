package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.ct */
public final class C26291ct extends C46180a {
    public long dig = 0;
    public long dih = 0;
    public long dii = 0;

    public final int getId() {
        return 16909;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(73309);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.dig);
        stringBuffer.append(str);
        stringBuffer.append(this.dih);
        stringBuffer.append(str);
        stringBuffer.append(this.dii);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(73309);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(73310);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ExptId:").append(this.dig);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("GroupId:").append(this.dih);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExptSeq:").append(this.dii);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(73310);
        return stringBuffer2;
    }
}
