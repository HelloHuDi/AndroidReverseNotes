package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

public final class co extends com.tencent.mm.plugin.report.a {
    private long cVR = 0;
    private long cVS = 0;
    private long ddA = 0;
    private String ddc = "";
    private long ddz = 0;
    private a dhg;
    private String dhh = "";

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.o(128904);
        }

        private a(int i) {
            this.value = i;
        }

        public static a ho(int i) {
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
        return 17147;
    }

    public final co hu(String str) {
        AppMethodBeat.i(128905);
        this.ddc = t("AppId", str, true);
        AppMethodBeat.o(128905);
        return this;
    }

    public final co a(a aVar) {
        this.dhg = aVar;
        return this;
    }

    public final co ev(long j) {
        this.ddz = j;
        return this;
    }

    public final co ew(long j) {
        AppMethodBeat.i(128906);
        this.ddA = j;
        super.ai("CostTimeMs", this.ddA);
        AppMethodBeat.o(128906);
        return this;
    }

    public final co ex(long j) {
        this.cVR = j;
        return this;
    }

    public final co ey(long j) {
        this.cVS = j;
        return this;
    }

    public final co hv(String str) {
        AppMethodBeat.i(128907);
        this.dhh = t("ErrMsg", str, true);
        AppMethodBeat.o(128907);
        return this;
    }

    public final String Fj() {
        int i;
        AppMethodBeat.i(128908);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        if (this.dhg != null) {
            i = this.dhg.value;
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
        stringBuffer.append(this.cVS);
        stringBuffer.append(str);
        stringBuffer.append(this.dhh);
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(128908);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(128909);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.dhg);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppType:").append(this.ddz);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("CostTimeMs:").append(this.ddA);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Scene:").append(this.cVR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Action:").append(this.cVS);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ErrMsg:").append(this.dhh);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(128909);
        return stringBuffer2;
    }
}
