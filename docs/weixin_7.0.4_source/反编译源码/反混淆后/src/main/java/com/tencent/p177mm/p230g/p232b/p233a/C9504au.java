package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.au */
public final class C9504au extends C46180a {
    private long cYQ = 0;
    private long cYZ = 0;
    private long cZK = 0;
    private String daj = "";
    private String dak = "";

    public final int getId() {
        return 16763;
    }

    /* renamed from: ce */
    public final C9504au mo20769ce(long j) {
        this.cYQ = j;
        return this;
    }

    /* renamed from: cf */
    public final C9504au mo20770cf(long j) {
        this.cZK = j;
        return this;
    }

    /* renamed from: cg */
    public final C9504au mo20771cg(long j) {
        this.cYZ = j;
        return this;
    }

    /* renamed from: FH */
    public final long mo20768FH() {
        return this.cYZ;
    }

    /* renamed from: fF */
    public final C9504au mo20772fF(String str) {
        AppMethodBeat.m2504i(108873);
        this.daj = mo74169t("StoryOwnerUserName", str, true);
        AppMethodBeat.m2505o(108873);
        return this;
    }

    /* renamed from: fG */
    public final C9504au mo20773fG(String str) {
        AppMethodBeat.m2504i(108874);
        this.dak = mo74169t("StoryTid", str, true);
        AppMethodBeat.m2505o(108874);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(108875);
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
        mo74164VX(str);
        AppMethodBeat.m2505o(108875);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(108876);
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
        AppMethodBeat.m2505o(108876);
        return stringBuffer2;
    }
}
