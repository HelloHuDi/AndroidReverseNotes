package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

public final class bt extends com.tencent.mm.plugin.report.a {
    public long cVR = 0;
    private long ddA = 0;
    public long ddB = 0;
    public long ddC = 0;
    public a ddS;
    public long ddT = 0;
    private String ddc = "";
    public long ddd = 0;
    private String ddx = "";
    public long ddz = 0;

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.o(128688);
        }

        private a(int i) {
            this.value = i;
        }

        public static a gU(int i) {
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
        return 16898;
    }

    public final bt gt(String str) {
        AppMethodBeat.i(128689);
        this.ddx = t("InstanceId", str, true);
        AppMethodBeat.o(128689);
        return this;
    }

    public final bt gu(String str) {
        AppMethodBeat.i(128690);
        this.ddc = t("AppId", str, true);
        AppMethodBeat.o(128690);
        return this;
    }

    public final bt dE(long j) {
        AppMethodBeat.i(128691);
        this.ddA = j;
        super.ai("CostTimeMs", this.ddA);
        AppMethodBeat.o(128691);
        return this;
    }

    public final bt dF(long j) {
        AppMethodBeat.i(128692);
        this.ddB = j;
        super.aj("StartTimeStampMs", this.ddB);
        AppMethodBeat.o(128692);
        return this;
    }

    public final bt dG(long j) {
        AppMethodBeat.i(128693);
        this.ddC = j;
        super.aj("EndTimeStampMs", this.ddC);
        AppMethodBeat.o(128693);
        return this;
    }

    public final String Fj() {
        int i;
        AppMethodBeat.i(128694);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddx);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.ddS != null) {
            i = this.ddS.value;
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
        stringBuffer.append(this.ddT);
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(128694);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(128695);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.ddx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.ddS);
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
        stringBuffer.append("isFromAndroidRecents:").append(this.ddT);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(128695);
        return stringBuffer2;
    }
}
