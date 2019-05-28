package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.bo */
public final class C18440bo extends C46180a {
    public long dcW = 0;
    public long dcY = 0;
    private String dcZ = "";
    public long dda = 0;
    public long ddb = 0;

    public final int getId() {
        return 15402;
    }

    /* renamed from: gk */
    public final C18440bo mo33703gk(String str) {
        AppMethodBeat.m2504i(128643);
        this.dcZ = mo74169t("Appid", str, true);
        AppMethodBeat.m2505o(128643);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(128644);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.dcY);
        stringBuffer.append(str);
        stringBuffer.append(this.dcZ);
        stringBuffer.append(str);
        stringBuffer.append(this.dda);
        stringBuffer.append(str);
        stringBuffer.append(this.ddb);
        stringBuffer.append(str);
        stringBuffer.append(this.dcW);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(128644);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(128645);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DeleteReason:").append(this.dcY);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Appid:").append(this.dcZ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("DebugType:").append(this.dda);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("DeleteCount:").append(this.ddb);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AbtestStatus:").append(this.dcW);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(128645);
        return stringBuffer2;
    }
}
