package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;

public final class ck extends com.tencent.mm.plugin.report.a {
    public long cVR = 0;
    public long dbX = 0;
    private long ddA = 0;
    private long ddB = 0;
    public long ddC = 0;
    private String ddc = "";
    public long ddd = 0;
    public long ddg = 0;
    private String ddx = "";
    public long ddz = 0;
    public a dgL;

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.o(128875);
        }

        private a(int i) {
            this.value = i;
        }

        public static a hl(int i) {
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
        return 15813;
    }

    public final ck hj(String str) {
        AppMethodBeat.i(128876);
        this.ddx = t("InstanceId", str, true);
        AppMethodBeat.o(128876);
        return this;
    }

    public final ck hk(String str) {
        AppMethodBeat.i(128877);
        this.ddc = t("AppId", str, true);
        AppMethodBeat.o(128877);
        return this;
    }

    public final ck er(long j) {
        AppMethodBeat.i(128878);
        this.ddA = j;
        super.ai("CostTimeMs", this.ddA);
        AppMethodBeat.o(128878);
        return this;
    }

    public final ck es(long j) {
        AppMethodBeat.i(128879);
        this.ddB = j;
        super.aj("StartTimeStampMs", this.ddB);
        AppMethodBeat.o(128879);
        return this;
    }

    public final String Fj() {
        int i;
        AppMethodBeat.i(128881);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddx);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.dgL != null) {
            i = this.dgL.value;
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
        stringBuffer.append(this.ddg);
        stringBuffer.append(str);
        stringBuffer.append(this.dbX);
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(128881);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(128882);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.ddx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.dgL);
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
        stringBuffer.append("isPreload:").append(this.ddg);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("type:").append(this.dbX);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(128882);
        return stringBuffer2;
    }

    public final ck Hh() {
        AppMethodBeat.i(128880);
        this.ddC = bo.anU();
        super.aj("EndTimeStampMs", this.ddC);
        AppMethodBeat.o(128880);
        return this;
    }
}
