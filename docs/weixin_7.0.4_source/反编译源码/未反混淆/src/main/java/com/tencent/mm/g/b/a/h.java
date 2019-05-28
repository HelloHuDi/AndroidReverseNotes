package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class h extends a {
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

    public final h eu(String str) {
        AppMethodBeat.i(73282);
        this.cVb = t("ChatroomName", str, true);
        AppMethodBeat.o(73282);
        return this;
    }

    public final h aO(long j) {
        AppMethodBeat.i(73283);
        this.cVi = j;
        super.ai("StayTimeMs", this.cVi);
        AppMethodBeat.o(73283);
        return this;
    }

    public final h ev(String str) {
        AppMethodBeat.i(73284);
        this.cVk = t("Score", str, true);
        AppMethodBeat.o(73284);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(73285);
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
        VX(str);
        AppMethodBeat.o(73285);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(73286);
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
        AppMethodBeat.o(73286);
        return stringBuffer2;
    }
}
