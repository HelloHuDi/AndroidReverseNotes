package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.as */
public final class C9503as extends C46180a {
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

    /* renamed from: FQ */
    public final C9503as mo20760FQ() {
        this.cZW = 0;
        return this;
    }

    /* renamed from: FR */
    public final C9503as mo20761FR() {
        this.cZX = 0;
        return this;
    }

    /* renamed from: FS */
    public final C9503as mo20762FS() {
        this.cZY = 0;
        return this;
    }

    /* renamed from: bS */
    public final C9503as mo20765bS(long j) {
        this.cZZ = j;
        return this;
    }

    /* renamed from: bT */
    public final C9503as mo20766bT(long j) {
        this.daa = j;
        return this;
    }

    /* renamed from: FT */
    public final C9503as mo20763FT() {
        this.cZm = 0;
        return this;
    }

    /* renamed from: FU */
    public final long mo20764FU() {
        return this.cZm;
    }

    /* renamed from: bU */
    public final C9503as mo20767bU(long j) {
        this.dab = j;
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(108867);
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
        mo74164VX(str);
        AppMethodBeat.m2505o(108867);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(108868);
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
        AppMethodBeat.m2505o(108868);
        return stringBuffer2;
    }
}
