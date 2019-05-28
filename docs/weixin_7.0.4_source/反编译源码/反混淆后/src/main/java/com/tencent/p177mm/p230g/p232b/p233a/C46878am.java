package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.am */
public final class C46878am extends C46180a {
    private long cTJ = 0;
    private long cYQ = 0;
    private long cYR = 0;
    private String cZq = "";
    public long cZr = 0;
    private long cZs = 0;

    public final int getId() {
        return 16659;
    }

    /* renamed from: bl */
    public final C46878am mo76054bl(long j) {
        this.cTJ = j;
        return this;
    }

    /* renamed from: bm */
    public final C46878am mo76055bm(long j) {
        this.cYQ = j;
        return this;
    }

    /* renamed from: fs */
    public final C46878am mo76056fs(String str) {
        AppMethodBeat.m2504i(108849);
        this.cZq = mo74169t("SourceUserName", str, true);
        AppMethodBeat.m2505o(108849);
        return this;
    }

    /* renamed from: Fx */
    public final C46878am mo76052Fx() {
        this.cYR = 1;
        return this;
    }

    /* renamed from: Fy */
    public final C46878am mo76053Fy() {
        this.cZs = 1;
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(108850);
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
        mo74164VX(str);
        AppMethodBeat.m2505o(108850);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(108851);
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
        AppMethodBeat.m2505o(108851);
        return stringBuffer2;
    }
}
