package com.tencent.mm.g.b.a;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class bf extends a {
    public long cVR = 0;
    private String dbU = "";
    public long dbV = 0;
    private long dbW = 0;
    public long dbX = 0;
    private long dbY = 0;
    private String dbZ = "";
    public long dca = 0;
    private String dcb = "";

    public final int getId() {
        return 14404;
    }

    public final bf fV(String str) {
        AppMethodBeat.i(77609);
        this.dbU = t("BiilNo", str, true);
        AppMethodBeat.o(77609);
        return this;
    }

    public final bf fW(String str) {
        AppMethodBeat.i(77610);
        this.dbZ = t(b.CONTENT, str, true);
        AppMethodBeat.o(77610);
        return this;
    }

    public final bf fX(String str) {
        AppMethodBeat.i(77611);
        this.dcb = t("packId", str, true);
        AppMethodBeat.o(77611);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(77612);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cVR);
        stringBuffer.append(str);
        stringBuffer.append(this.dbU);
        stringBuffer.append(str);
        stringBuffer.append(this.dbV);
        stringBuffer.append(str);
        stringBuffer.append(this.dbW);
        stringBuffer.append(str);
        stringBuffer.append(this.dbX);
        stringBuffer.append(str);
        stringBuffer.append(this.dbY);
        stringBuffer.append(str);
        stringBuffer.append(this.dbZ);
        stringBuffer.append(str);
        stringBuffer.append(this.dca);
        stringBuffer.append(str);
        stringBuffer.append(this.dcb);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(77612);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(77613);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.cVR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("BiilNo:").append(this.dbU);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("failReason:").append(this.dbV);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("playerErrCode:").append(this.dbW);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("type:").append(this.dbX);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("retCode:").append(this.dbY);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("content:").append(this.dbZ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("amount:").append(this.dca);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("packId:").append(this.dcb);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(77613);
        return stringBuffer2;
    }
}
