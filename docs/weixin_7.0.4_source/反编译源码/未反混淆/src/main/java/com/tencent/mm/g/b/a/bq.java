package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

public final class bq extends com.tencent.mm.plugin.report.a {
    public long cVR = 0;
    private long ddA = 0;
    public long ddB = 0;
    public long ddC = 0;
    private String ddc = "";
    public long ddd = 0;
    private String ddx = "";
    public a ddy;
    public long ddz = 0;

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.o(128658);
        }

        private a(int i) {
            this.value = i;
        }

        public static a gR(int i) {
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

    public final int getId() {
        return 16900;
    }

    public final bq gn(String str) {
        AppMethodBeat.i(128659);
        this.ddx = t("InstanceId", str, true);
        AppMethodBeat.o(128659);
        return this;
    }

    public final bq go(String str) {
        AppMethodBeat.i(128660);
        this.ddc = t("AppId", str, true);
        AppMethodBeat.o(128660);
        return this;
    }

    public final bq dw(long j) {
        AppMethodBeat.i(128661);
        this.ddA = j;
        super.ai("CostTimeMs", this.ddA);
        AppMethodBeat.o(128661);
        return this;
    }

    public final bq dx(long j) {
        AppMethodBeat.i(128662);
        this.ddB = j;
        super.aj("StartTimeStampMs", this.ddB);
        AppMethodBeat.o(128662);
        return this;
    }

    public final bq dy(long j) {
        AppMethodBeat.i(128663);
        this.ddC = j;
        super.aj("EndTimeStampMs", this.ddC);
        AppMethodBeat.o(128663);
        return this;
    }

    public final String Fj() {
        int i;
        AppMethodBeat.i(128664);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddx);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.ddy != null) {
            i = this.ddy.value;
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
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(128664);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(128665);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.ddx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.ddy);
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
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(128665);
        return stringBuffer2;
    }
}
