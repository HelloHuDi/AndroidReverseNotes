package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Arrays;

public final class cg extends com.tencent.mm.plugin.report.a {
    public long cVR = 0;
    public long cXm = 0;
    private long ddA = 0;
    private long ddB = 0;
    private long ddC = 0;
    private String ddc = "";
    public long ddd = 0;
    private String ddx = "";
    public long ddz = 0;
    public a dfQ;
    public b dfR;

    public enum b {
        ok(0),
        common_fail(1);
        
        final int value;

        static {
            AppMethodBeat.o(128823);
        }

        private b(int i) {
            this.value = i;
        }

        public static b hh(int i) {
            switch (i) {
                case 0:
                    return ok;
                case 1:
                    return common_fail;
                default:
                    return null;
            }
        }
    }

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.o(128820);
        }

        private a(int i) {
            this.value = i;
        }

        public static a hg(int i) {
            switch (i) {
                case 1:
                    return release;
                case 2:
                    return debug;
                case 3:
                    return demo;
                default:
                    return null;
            }
        }
    }

    public cg(String str) {
        AppMethodBeat.i(128824);
        if (str != null) {
            String[] split = str.split(",");
            if (split != null) {
                String[] strArr;
                if (split.length < 11) {
                    strArr = new String[11];
                    Arrays.fill(strArr, 0, 11, "");
                    System.arraycopy(split, 0, strArr, 0, split.length);
                } else {
                    strArr = split;
                }
                hb(strArr[0]);
                hc(strArr[1]);
                this.ddd = bo.getLong(strArr[2], 0);
                this.dfQ = a.hg(bo.getInt(strArr[3], 0));
                this.ddz = bo.getLong(strArr[4], 0);
                ee(bo.getLong(strArr[5], 0));
                this.cVR = bo.getLong(strArr[6], 0);
                ef(bo.getLong(strArr[7], 0));
                eg(bo.getLong(strArr[8], 0));
                this.dfR = b.hh(bo.getInt(strArr[9], 0));
                this.cXm = bo.getLong(strArr[10], 0);
            }
        }
        AppMethodBeat.o(128824);
    }

    public final int getId() {
        return 15798;
    }

    public final cg hb(String str) {
        AppMethodBeat.i(128825);
        this.ddx = t("InstanceId", str, true);
        AppMethodBeat.o(128825);
        return this;
    }

    public final cg hc(String str) {
        AppMethodBeat.i(128826);
        this.ddc = t("AppId", str, true);
        AppMethodBeat.o(128826);
        return this;
    }

    public final cg ee(long j) {
        AppMethodBeat.i(128827);
        this.ddA = j;
        super.ai("CostTimeMs", this.ddA);
        AppMethodBeat.o(128827);
        return this;
    }

    public final cg ef(long j) {
        AppMethodBeat.i(128828);
        this.ddB = j;
        super.aj("StartTimeStampMs", this.ddB);
        AppMethodBeat.o(128828);
        return this;
    }

    public final cg eg(long j) {
        AppMethodBeat.i(128829);
        this.ddC = j;
        super.aj("EndTimeStampMs", this.ddC);
        AppMethodBeat.o(128829);
        return this;
    }

    public final String Fj() {
        int i;
        int i2 = -1;
        AppMethodBeat.i(128830);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddx);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.dfQ != null) {
            i = this.dfQ.value;
        } else {
            i = -1;
        }
        stringBuffer.append(i);
        stringBuffer.append(str);
        stringBuffer.append(this.ddz);
        stringBuffer.append(str);
        stringBuffer.append(this.ddA);
        stringBuffer.append(str);
        stringBuffer.append(this.cVR);
        stringBuffer.append(str);
        stringBuffer.append(this.ddB);
        stringBuffer.append(str);
        stringBuffer.append(this.ddC);
        stringBuffer.append(str);
        if (this.dfR != null) {
            i2 = this.dfR.value;
        }
        stringBuffer.append(i2);
        stringBuffer.append(str);
        stringBuffer.append(this.cXm);
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(128830);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(128831);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.ddx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.dfQ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppType:").append(this.ddz);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("CostTimeMs:").append(this.ddA);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Scene:").append(this.cVR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("StartTimeStampMs:").append(this.ddB);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EndTimeStampMs:").append(this.ddC);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Ret:").append(this.dfR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("NetworkType:").append(this.cXm);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(128831);
        return stringBuffer2;
    }
}
