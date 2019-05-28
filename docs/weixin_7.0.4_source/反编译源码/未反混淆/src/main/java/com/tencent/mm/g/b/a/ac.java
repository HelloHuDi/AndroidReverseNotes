package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Arrays;

public final class ac extends a {
    public long cYn = 0;
    public long cYo = 0;
    public String cYp = "";
    public boolean cYq;

    public ac(String str) {
        AppMethodBeat.i(73303);
        if (str != null) {
            String[] split = str.split(",");
            if (split != null) {
                String[] strArr;
                if (split.length < 4) {
                    strArr = new String[4];
                    Arrays.fill(strArr, 0, 4, "");
                    System.arraycopy(split, 0, strArr, 0, split.length);
                } else {
                    strArr = split;
                }
                this.cYn = bo.getLong(strArr[0], 0);
                aR(bo.getLong(strArr[1], 0));
                eX(strArr[2]);
                this.cYq = a.getBoolean(strArr[3]);
            }
        }
        AppMethodBeat.o(73303);
    }

    public final int getId() {
        return 0;
    }

    private ac aR(long j) {
        AppMethodBeat.i(73304);
        this.cYo = j;
        super.ak("StartTimeStampSec", this.cYo);
        AppMethodBeat.o(73304);
        return this;
    }

    public final ac eX(String str) {
        AppMethodBeat.i(73306);
        this.cYp = t("Roomname", str, true);
        AppMethodBeat.o(73306);
        return this;
    }

    public final String Fj() {
        int i;
        AppMethodBeat.i(73307);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cYn);
        stringBuffer.append(str);
        stringBuffer.append(this.cYo);
        stringBuffer.append(str);
        stringBuffer.append(this.cYp);
        stringBuffer.append(str);
        if (this.cYq) {
            i = 1;
        } else {
            i = 0;
        }
        stringBuffer.append(i);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(73307);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(73308);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ExptFlag:").append(this.cYn);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("StartTimeStampSec:").append(this.cYo);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Roomname:").append(this.cYp);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("hardcodeExptBool:").append(this.cYq);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(73308);
        return stringBuffer2;
    }

    public final ac Fq() {
        AppMethodBeat.i(73305);
        ac aR = aR(bo.anT());
        AppMethodBeat.o(73305);
        return aR;
    }
}
