package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.bh */
public final class C37823bh extends C46180a {
    public long cVR = 0;
    public long cVS = 0;
    private String dcj = "";

    public final int getId() {
        return 17072;
    }

    /* renamed from: gd */
    public final C37823bh mo60528gd(String str) {
        AppMethodBeat.m2504i(138575);
        this.dcj = mo74169t("OrderId", str, true);
        AppMethodBeat.m2505o(138575);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(77614);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cVR);
        stringBuffer.append(str);
        stringBuffer.append(this.cVS);
        stringBuffer.append(str);
        stringBuffer.append(this.dcj);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(77614);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(77615);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.cVR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Action:").append(this.cVS);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("OrderId:").append(this.dcj);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(77615);
        return stringBuffer2;
    }
}
