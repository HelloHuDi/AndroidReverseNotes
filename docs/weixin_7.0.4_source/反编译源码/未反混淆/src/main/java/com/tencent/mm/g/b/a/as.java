package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class as extends a {
    public long cZW = 0;
    public long cZX = 0;
    public long cZY = 0;
    private long cZZ = 0;
    public long cZm = 0;
    private long daa = 0;
    private long dab = 0;

    public final int getId() {
        return 16844;
    }

    public final as FQ() {
        this.cZW = 0;
        return this;
    }

    public final as FR() {
        this.cZX = 0;
        return this;
    }

    public final as FS() {
        this.cZY = 0;
        return this;
    }

    public final as bS(long j) {
        this.cZZ = j;
        return this;
    }

    public final as bT(long j) {
        this.daa = j;
        return this;
    }

    public final as FT() {
        this.cZm = 0;
        return this;
    }

    public final long FU() {
        return this.cZm;
    }

    public final as bU(long j) {
        this.dab = j;
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(108867);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cZW);
        stringBuffer.append(str);
        stringBuffer.append(this.cZX);
        stringBuffer.append(str);
        stringBuffer.append(this.cZY);
        stringBuffer.append(str);
        stringBuffer.append(this.cZZ);
        stringBuffer.append(str);
        stringBuffer.append(this.daa);
        stringBuffer.append(str);
        stringBuffer.append(this.cZm);
        stringBuffer.append(str);
        stringBuffer.append(this.dab);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(108867);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(108868);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ClickMyProfileTime:").append(this.cZW);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ClickCameraTime:").append(this.cZX);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ClickGuidePageTime:").append(this.cZY);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("isProfileRedPoint:").append(this.cZZ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("isCameraRedPoint:").append(this.daa);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("VideoObjectId:").append(this.cZm);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("isStoryCommentRedDot:").append(this.dab);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(108868);
        return stringBuffer2;
    }
}
