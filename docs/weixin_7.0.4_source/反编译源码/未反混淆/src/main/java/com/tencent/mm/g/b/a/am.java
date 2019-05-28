package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class am extends a {
    private long cTJ = 0;
    private long cYQ = 0;
    private long cYR = 0;
    private String cZq = "";
    public long cZr = 0;
    private long cZs = 0;

    public final int getId() {
        return 16659;
    }

    public final am bl(long j) {
        this.cTJ = j;
        return this;
    }

    public final am bm(long j) {
        this.cYQ = j;
        return this;
    }

    public final am fs(String str) {
        AppMethodBeat.i(108849);
        this.cZq = t("SourceUserName", str, true);
        AppMethodBeat.o(108849);
        return this;
    }

    public final am Fx() {
        this.cYR = 1;
        return this;
    }

    public final am Fy() {
        this.cZs = 1;
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(108850);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cTJ);
        stringBuffer.append(str);
        stringBuffer.append(this.cYQ);
        stringBuffer.append(str);
        stringBuffer.append(this.cZq);
        stringBuffer.append(str);
        stringBuffer.append(this.cZr);
        stringBuffer.append(str);
        stringBuffer.append(this.cYR);
        stringBuffer.append(str);
        stringBuffer.append(this.cZs);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(108850);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(108851);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("NetType:").append(this.cTJ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("PreviewEnterScene:").append(this.cYQ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SourceUserName:").append(this.cZq);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SourceContactType:").append(this.cZr);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("HasUnreadStoryTips:").append(this.cYR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("HasEnterPreview:").append(this.cZs);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(108851);
        return stringBuffer2;
    }
}
