package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.bl */
public final class C46881bl extends C46180a {
    public long dck = 0;
    private String dcp = "";
    public long dcq = 0;

    public final int getId() {
        return 16016;
    }

    /* renamed from: ge */
    public final C46881bl mo76060ge(String str) {
        AppMethodBeat.m2504i(56604);
        this.dcp = mo74169t("TransferUserName", str, true);
        AppMethodBeat.m2505o(56604);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(56605);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.dck);
        stringBuffer.append(str);
        stringBuffer.append(this.dcp);
        stringBuffer.append(str);
        stringBuffer.append(this.dcq);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(56605);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(56606);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ReportScene:").append(this.dck);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("TransferUserName:").append(this.dcp);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("TransferAmount:").append(this.dcq);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(56606);
        return stringBuffer2;
    }
}
