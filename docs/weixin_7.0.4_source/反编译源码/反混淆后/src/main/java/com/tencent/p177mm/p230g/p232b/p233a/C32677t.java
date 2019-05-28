package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.t */
public final class C32677t extends C46180a {
    private String cXO = "";
    public long cXP = 0;

    public final int getId() {
        return 15848;
    }

    /* renamed from: eO */
    public final C32677t mo53208eO(String str) {
        AppMethodBeat.m2504i(77587);
        this.cXO = mo74169t("chatRoomUserName", str, true);
        AppMethodBeat.m2505o(77587);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(77588);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cXO);
        stringBuffer.append(",");
        stringBuffer.append(this.cXP);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(77588);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(77589);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("chatRoomUserName:").append(this.cXO);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("scene:").append(this.cXP);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(77589);
        return stringBuffer2;
    }
}
