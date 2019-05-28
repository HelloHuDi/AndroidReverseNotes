package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

public final class ci extends com.tencent.mm.plugin.report.a {
    private long ddA = 0;
    private String ddc = "";
    public long ddd = 0;
    private String ddx = "";
    public long ddz = 0;
    public a dgp;
    private long dgq = 0;

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.o(128850);
        }

        private a(int i) {
            this.value = i;
        }

        public static a hj(int i) {
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
        return 15853;
    }

    public final ci hf(String str) {
        AppMethodBeat.i(128851);
        this.ddx = t("InstanceId", str, true);
        AppMethodBeat.o(128851);
        return this;
    }

    public final ci hg(String str) {
        AppMethodBeat.i(128852);
        this.ddc = t("AppId", str, true);
        AppMethodBeat.o(128852);
        return this;
    }

    public final ci en(long j) {
        AppMethodBeat.i(128853);
        this.ddA = j;
        super.ai("CostTimeMs", this.ddA);
        AppMethodBeat.o(128853);
        return this;
    }

    public final ci eo(long j) {
        AppMethodBeat.i(128854);
        this.dgq = j;
        super.ai("WaitingTimeMs", this.dgq);
        AppMethodBeat.o(128854);
        return this;
    }

    public final String Fj() {
        int i;
        AppMethodBeat.i(128855);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddx);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.dgp != null) {
            i = this.dgp.value;
        } else {
            i = -1;
        }
        stringBuffer.append(i);
        stringBuffer.append(str);
        stringBuffer.append(this.ddz);
        stringBuffer.append(str);
        stringBuffer.append(this.ddA);
        stringBuffer.append(str);
        stringBuffer.append(this.dgq);
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(128855);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(128856);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.ddx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.dgp);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppType:").append(this.ddz);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("CostTimeMs:").append(this.ddA);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("WaitingTimeMs:").append(this.dgq);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(128856);
        return stringBuffer2;
    }
}
