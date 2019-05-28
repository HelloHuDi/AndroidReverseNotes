package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;

public final class br extends com.tencent.mm.plugin.report.a {
    public long cVR = 0;
    private long ddA = 0;
    public long ddB = 0;
    public long ddC = 0;
    public a ddH;
    public long ddI = 0;
    private String ddc = "";
    private String ddx = "";
    public long ddz = 0;

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.o(128668);
        }

        private a(int i) {
            this.value = i;
        }

        public static a gS(int i) {
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
        return 17111;
    }

    public final br gp(String str) {
        AppMethodBeat.i(128669);
        this.ddx = t("InstanceId", str, true);
        AppMethodBeat.o(128669);
        return this;
    }

    public final br gq(String str) {
        AppMethodBeat.i(128670);
        this.ddc = t("AppId", str, true);
        AppMethodBeat.o(128670);
        return this;
    }

    public final br dz(long j) {
        AppMethodBeat.i(128671);
        this.ddA = j;
        super.ai("CostTimeMs", this.ddA);
        AppMethodBeat.o(128671);
        return this;
    }

    public final br dA(long j) {
        AppMethodBeat.i(128672);
        this.ddB = j;
        super.aj("StartTimeStampMs", this.ddB);
        AppMethodBeat.o(128672);
        return this;
    }

    public final String Fj() {
        int i;
        AppMethodBeat.i(128674);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddx);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        if (this.ddH != null) {
            i = this.ddH.value;
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
        stringBuffer.append(this.ddI);
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(128674);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(128675);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.ddx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.ddH);
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
        stringBuffer.append("IsPreload:").append(this.ddI);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(128675);
        return stringBuffer2;
    }

    public final br GX() {
        AppMethodBeat.i(128673);
        this.ddC = bo.anU();
        super.aj("EndTimeStampMs", this.ddC);
        AppMethodBeat.o(128673);
        return this;
    }
}
