package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.ak */
public final class C1584ak extends C46180a {
    private long cWY = 0;
    private long cYS = 0;
    private long cYT = 0;
    private long cYU = 0;
    private String cYV;
    private String cYW;

    public final int getId() {
        return 16688;
    }

    /* renamed from: aT */
    public final C1584ak mo4989aT(long j) {
        this.cYS = j;
        return this;
    }

    /* renamed from: Ft */
    public final long mo4987Ft() {
        return this.cYS;
    }

    /* renamed from: aU */
    public final C1584ak mo4990aU(long j) {
        this.cYT = j;
        return this;
    }

    /* renamed from: aV */
    public final C1584ak mo4991aV(long j) {
        this.cWY = j;
        return this;
    }

    /* renamed from: Fu */
    public final long mo4988Fu() {
        return this.cWY;
    }

    /* renamed from: aW */
    public final C1584ak mo4992aW(long j) {
        this.cYU = j;
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(108839);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cYS);
        stringBuffer.append(str);
        stringBuffer.append(this.cYT);
        stringBuffer.append(str);
        stringBuffer.append(this.cWY);
        stringBuffer.append(str);
        stringBuffer.append(this.cYU);
        stringBuffer.append(str);
        stringBuffer.append(this.cYV);
        stringBuffer.append(str);
        stringBuffer.append(this.cYW);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(108839);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(108840);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ComposeTime:").append(this.cYS);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ComposeErrorType:").append(this.cYT);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("UploadTime:").append(this.cWY);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("UploadErrorType:").append(this.cYU);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ComposeErrorTypeStr:").append(this.cYV);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("UploadErrorTypeStr:").append(this.cYW);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(108840);
        return stringBuffer2;
    }
}
