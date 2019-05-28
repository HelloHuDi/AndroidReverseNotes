package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.b */
public final class C42084b extends C46180a {
    public long cTr = 0;
    private long cTs = 0;
    public long cTt = 0;
    public long cTu = 0;
    public long cTv = 0;
    public long cTw = 0;

    public final int getId() {
        return 16113;
    }

    /* renamed from: aM */
    public final C42084b mo67643aM(long j) {
        AppMethodBeat.m2504i(15817);
        this.cTr = j;
        super.mo74166aj("FirstInputTimeStampMs", this.cTr);
        AppMethodBeat.m2505o(15817);
        return this;
    }

    /* renamed from: aN */
    public final C42084b mo67644aN(long j) {
        AppMethodBeat.m2504i(15819);
        this.cTs = j;
        super.mo74166aj("LastInputTimeStampMs", this.cTs);
        AppMethodBeat.m2505o(15819);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(15821);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cTr);
        stringBuffer.append(str);
        stringBuffer.append(this.cTs);
        stringBuffer.append(str);
        stringBuffer.append(this.cTt);
        stringBuffer.append(str);
        stringBuffer.append(this.cTu);
        stringBuffer.append(str);
        stringBuffer.append(this.cTv);
        stringBuffer.append(str);
        stringBuffer.append(this.cTw);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(15821);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(15822);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FirstInputTimeStampMs:").append(this.cTr);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("LastInputTimeStampMs:").append(this.cTs);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SendStampMs:").append(this.cTt);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ClickCount:").append(this.cTu);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("TextLength:").append(this.cTv);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EmojiCount:").append(this.cTw);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(15822);
        return stringBuffer2;
    }

    /* renamed from: Fl */
    public final C42084b mo67641Fl() {
        AppMethodBeat.m2504i(15818);
        C42084b aM = mo67643aM(C5046bo.anU());
        AppMethodBeat.m2505o(15818);
        return aM;
    }

    /* renamed from: Fm */
    public final C42084b mo67642Fm() {
        AppMethodBeat.m2504i(15820);
        C42084b aN = mo67644aN(C5046bo.anU());
        AppMethodBeat.m2505o(15820);
        return aN;
    }
}
