package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

public final class bs extends com.tencent.mm.plugin.report.a {
    public long cVR = 0;
    public long dbX = 0;
    private long ddA = 0;
    public long ddB = 0;
    public long ddC = 0;
    public a ddN;
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
            AppMethodBeat.o(128678);
        }

        private a(int i) {
            this.value = i;
        }

        public static a gT(int i) {
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
        return 16895;
    }

    public final bs gr(String str) {
        AppMethodBeat.i(128679);
        this.ddx = t("InstanceId", str, true);
        AppMethodBeat.o(128679);
        return this;
    }

    public final bs gs(String str) {
        AppMethodBeat.i(128680);
        this.ddc = t("AppId", str, true);
        AppMethodBeat.o(128680);
        return this;
    }

    public final bs dB(long j) {
        AppMethodBeat.i(128681);
        this.ddA = j;
        super.ai("CostTimeMs", this.ddA);
        AppMethodBeat.o(128681);
        return this;
    }

    public final bs dC(long j) {
        AppMethodBeat.i(128682);
        this.ddB = j;
        super.aj("StartTimeStampMs", this.ddB);
        AppMethodBeat.o(128682);
        return this;
    }

    public final bs dD(long j) {
        AppMethodBeat.i(128683);
        this.ddC = j;
        super.aj("EndTimeStampMs", this.ddC);
        AppMethodBeat.o(128683);
        return this;
    }

    public final String Fj() {
        int i;
        AppMethodBeat.i(128684);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddx);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.ddN != null) {
            i = this.ddN.value;
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
        stringBuffer.append(this.dbX);
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(128684);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(128685);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.ddx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.ddN);
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
        stringBuffer.append("type:").append(this.dbX);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(128685);
        return stringBuffer2;
    }
}
