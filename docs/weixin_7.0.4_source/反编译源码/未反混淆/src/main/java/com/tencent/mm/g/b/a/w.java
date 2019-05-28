package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Arrays;

public final class w extends a {
    private String cWR = "";
    public long cWS = 0;
    public long cWT = 0;
    public long cWU = 0;
    public int cWc = 0;
    private String cWd = "";
    public long cYc = 0;
    private long cYd = 0;
    private boolean cYe;

    public w(String str) {
        AppMethodBeat.i(73296);
        if (str != null) {
            String[] split = str.split(",");
            if (split != null) {
                String[] strArr;
                if (split.length < 9) {
                    strArr = new String[9];
                    Arrays.fill(strArr, 0, 9, "");
                    System.arraycopy(split, 0, strArr, 0, split.length);
                } else {
                    strArr = split;
                }
                this.cWc = bo.getInt(strArr[0], 0);
                eS(strArr[1]);
                this.cYc = bo.getLong(strArr[2], 0);
                eT(strArr[3]);
                this.cWS = bo.getLong(strArr[4], 0);
                aQ(bo.getLong(strArr[5], 0));
                this.cYd = bo.getLong(strArr[6], 0);
                this.cYe = a.getBoolean(strArr[7]);
                this.cWU = bo.getLong(strArr[8], 0);
            }
        }
        AppMethodBeat.o(73296);
    }

    public final int getId() {
        return 15885;
    }

    public final w eS(String str) {
        AppMethodBeat.i(73297);
        this.cWd = t("PName", str, true);
        AppMethodBeat.o(73297);
        return this;
    }

    public final w eT(String str) {
        AppMethodBeat.i(73298);
        this.cWR = t("Name", str, true);
        AppMethodBeat.o(73298);
        return this;
    }

    public final w aQ(long j) {
        AppMethodBeat.i(73299);
        this.cWT = j;
        super.aj("TimeStampMs", this.cWT);
        AppMethodBeat.o(73299);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(73300);
        String eU = eU(",");
        AppMethodBeat.o(73300);
        return eU;
    }

    public final String eU(String str) {
        int i;
        AppMethodBeat.i(73301);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cWc);
        stringBuffer.append(str);
        stringBuffer.append(this.cWd);
        stringBuffer.append(str);
        stringBuffer.append(this.cYc);
        stringBuffer.append(str);
        stringBuffer.append(this.cWR);
        stringBuffer.append(str);
        stringBuffer.append(this.cWS);
        stringBuffer.append(str);
        stringBuffer.append(this.cWT);
        stringBuffer.append(str);
        stringBuffer.append(this.cYd);
        stringBuffer.append(str);
        if (this.cYe) {
            i = 1;
        } else {
            i = 0;
        }
        stringBuffer.append(i);
        stringBuffer.append(str);
        stringBuffer.append(this.cWU);
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(73301);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(73302);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PID:").append(this.cWc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("PName:").append(this.cWd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Seq:").append(this.cYc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Name:").append(this.cWR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Type:").append(this.cWS);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("TimeStampMs:").append(this.cWT);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("GreenManFg:").append(this.cYd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("QueueFgBool:").append(this.cYe);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("HashCode:").append(this.cWU);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(73302);
        return stringBuffer2;
    }
}
