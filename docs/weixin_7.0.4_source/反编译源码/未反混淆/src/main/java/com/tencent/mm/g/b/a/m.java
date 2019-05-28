package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class m extends a {
    public long cVU = 0;
    public long cVV = 0;
    public long cVW = 0;
    public long cVX = 0;
    public long cVY = 0;
    public long cVZ = 0;
    private String cWa = "";
    public long cWb = 0;

    public final int getId() {
        return 16724;
    }

    public final m eE(String str) {
        AppMethodBeat.i(77584);
        this.cWa = t("EmoticonMd5", str, true);
        AppMethodBeat.o(77584);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(77585);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cVU);
        stringBuffer.append(str);
        stringBuffer.append(this.cVV);
        stringBuffer.append(str);
        stringBuffer.append(this.cVW);
        stringBuffer.append(str);
        stringBuffer.append(this.cVX);
        stringBuffer.append(str);
        stringBuffer.append(this.cVY);
        stringBuffer.append(str);
        stringBuffer.append(this.cVZ);
        stringBuffer.append(str);
        stringBuffer.append(this.cWa);
        stringBuffer.append(str);
        stringBuffer.append(this.cWb);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(77585);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(77586);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ActionType:").append(this.cVU);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Content:").append(this.cVV);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ChangeAmountTimes:").append(this.cVW);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AddSelfieEmoticonTimes:").append(this.cVX);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AddCustonEmoticonTimes:").append(this.cVY);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AddSelfieEmoticonFormBoardTimes:").append(this.cVZ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EmoticonMd5:").append(this.cWa);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AddShopEmoticonTimes:").append(this.cWb);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(77586);
        return stringBuffer2;
    }
}
