package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Arrays;

public final class q extends a {
    public String cWR = "";
    public long cWS = 0;
    public long cWT = 0;
    public long cWU = 0;

    public q(String str) {
        AppMethodBeat.i(73291);
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
                eN(strArr[0]);
                this.cWS = bo.getLong(strArr[1], 0);
                aP(bo.getLong(strArr[2], 0));
                this.cWU = bo.getLong(strArr[3], 0);
            }
        }
        AppMethodBeat.o(73291);
    }

    public final int getId() {
        return 0;
    }

    public final q eN(String str) {
        AppMethodBeat.i(73292);
        this.cWR = t("Name", str, true);
        AppMethodBeat.o(73292);
        return this;
    }

    public final q aP(long j) {
        AppMethodBeat.i(73293);
        this.cWT = j;
        super.aj("TimeStampMs", this.cWT);
        AppMethodBeat.o(73293);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(73294);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cWR);
        stringBuffer.append(str);
        stringBuffer.append(this.cWS);
        stringBuffer.append(str);
        stringBuffer.append(this.cWT);
        stringBuffer.append(str);
        stringBuffer.append(this.cWU);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(73294);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(73295);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Name:").append(this.cWR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Type:").append(this.cWS);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("TimeStampMs:").append(this.cWT);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("HashCode:").append(this.cWU);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(73295);
        return stringBuffer2;
    }
}
