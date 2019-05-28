package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.ah */
public final class C32661ah extends C46180a {
    private String cWo = "";
    private long cYI = 0;

    public final int getId() {
        return 15988;
    }

    /* renamed from: fk */
    public final C32661ah mo53151fk(String str) {
        AppMethodBeat.m2504i(35564);
        this.cWo = mo74169t("SessionId", str, true);
        AppMethodBeat.m2505o(35564);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(35566);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cWo);
        stringBuffer.append(",");
        stringBuffer.append(this.cYI);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(35566);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(35567);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.cWo);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ClickTimeStampMs:").append(this.cYI);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(35567);
        return stringBuffer2;
    }

    /* renamed from: Fs */
    public final C32661ah mo53150Fs() {
        AppMethodBeat.m2504i(35565);
        this.cYI = C5046bo.anU();
        super.mo74166aj("ClickTimeStampMs", this.cYI);
        AppMethodBeat.m2505o(35565);
        return this;
    }
}
