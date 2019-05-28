package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class t extends a {
    private String cXO = "";
    public long cXP = 0;

    public final int getId() {
        return 15848;
    }

    public final t eO(String str) {
        AppMethodBeat.i(77587);
        this.cXO = t("chatRoomUserName", str, true);
        AppMethodBeat.o(77587);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(77588);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cXO);
        stringBuffer.append(",");
        stringBuffer.append(this.cXP);
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(77588);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(77589);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("chatRoomUserName:").append(this.cXO);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("scene:").append(this.cXP);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(77589);
        return stringBuffer2;
    }
}
