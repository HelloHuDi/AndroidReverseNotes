package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class au extends a {
    private long cYQ = 0;
    private long cYZ = 0;
    private long cZK = 0;
    private String daj = "";
    private String dak = "";

    public final int getId() {
        return 16763;
    }

    public final au ce(long j) {
        this.cYQ = j;
        return this;
    }

    public final au cf(long j) {
        this.cZK = j;
        return this;
    }

    public final au cg(long j) {
        this.cYZ = j;
        return this;
    }

    public final long FH() {
        return this.cYZ;
    }

    public final au fF(String str) {
        AppMethodBeat.i(108873);
        this.daj = t("StoryOwnerUserName", str, true);
        AppMethodBeat.o(108873);
        return this;
    }

    public final au fG(String str) {
        AppMethodBeat.i(108874);
        this.dak = t("StoryTid", str, true);
        AppMethodBeat.o(108874);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(108875);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cYQ);
        stringBuffer.append(str);
        stringBuffer.append(this.cZK);
        stringBuffer.append(str);
        stringBuffer.append(this.cYZ);
        stringBuffer.append(str);
        stringBuffer.append(this.daj);
        stringBuffer.append(str);
        stringBuffer.append(this.dak);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(108875);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(108876);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PreviewEnterScene:").append(this.cYQ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ProfileSource:").append(this.cZK);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EnterTime:").append(this.cYZ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("StoryOwnerUserName:").append(this.daj);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("StoryTid:").append(this.dak);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(108876);
        return stringBuffer2;
    }
}
