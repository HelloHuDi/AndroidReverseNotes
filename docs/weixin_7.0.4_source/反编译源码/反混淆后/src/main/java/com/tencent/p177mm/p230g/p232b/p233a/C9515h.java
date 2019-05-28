package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.h */
public final class C9515h extends C46180a {
    private String cVb = "";
    public int cVe = 0;
    public long cVf = 0;
    public long cVg = 0;
    public long cVh = 0;
    private long cVi = 0;
    public long cVj = 0;
    private String cVk = "";

    public final int getId() {
        return 15460;
    }

    /* renamed from: eu */
    public final C9515h mo20803eu(String str) {
        AppMethodBeat.m2504i(73282);
        this.cVb = mo74169t("ChatroomName", str, true);
        AppMethodBeat.m2505o(73282);
        return this;
    }

    /* renamed from: aO */
    public final C9515h mo20802aO(long j) {
        AppMethodBeat.m2504i(73283);
        this.cVi = j;
        super.mo74165ai("StayTimeMs", this.cVi);
        AppMethodBeat.m2505o(73283);
        return this;
    }

    /* renamed from: ev */
    public final C9515h mo20804ev(String str) {
        AppMethodBeat.m2504i(73284);
        this.cVk = mo74169t("Score", str, true);
        AppMethodBeat.m2505o(73284);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(73285);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cVb);
        stringBuffer.append(str);
        stringBuffer.append(this.cVe);
        stringBuffer.append(str);
        stringBuffer.append(this.cVf);
        stringBuffer.append(str);
        stringBuffer.append(this.cVg);
        stringBuffer.append(str);
        stringBuffer.append(this.cVh);
        stringBuffer.append(str);
        stringBuffer.append(this.cVi);
        stringBuffer.append(str);
        stringBuffer.append(this.cVj);
        stringBuffer.append(str);
        stringBuffer.append(this.cVk);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(73285);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(73286);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ChatroomName:").append(this.cVb);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ChatroomMute:").append(this.cVe);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("UnreadCount:").append(this.cVf);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("DisRedDotCount:").append(this.cVg);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EnterCount:").append(this.cVh);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("StayTimeMs:").append(this.cVi);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SendCount:").append(this.cVj);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Score:").append(this.cVk);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(73286);
        return stringBuffer2;
    }
}
