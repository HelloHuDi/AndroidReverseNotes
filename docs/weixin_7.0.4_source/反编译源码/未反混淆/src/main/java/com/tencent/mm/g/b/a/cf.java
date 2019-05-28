package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

public final class cf extends com.tencent.mm.plugin.report.a {
    private long cVR = 0;
    public long cXm = 0;
    private long ddA = 0;
    private long ddB = 0;
    private long ddC = 0;
    private String ddc = "";
    private long ddd = 0;
    private String ddx = "";
    private long ddz = 0;
    private a dfD;
    public c dfE;
    public b dfF;

    public enum b {
        sync(0),
        async(1);
        
        final int value;

        static {
            AppMethodBeat.o(128807);
        }

        private b(int i) {
            this.value = i;
        }
    }

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.o(128804);
        }

        private a(int i) {
            this.value = i;
        }

        public static a hf(int i) {
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

    public enum c {
        ok(0),
        common_fail(1);
        
        final int value;

        static {
            AppMethodBeat.o(128810);
        }

        private c(int i) {
            this.value = i;
        }
    }

    public final int getId() {
        return 15764;
    }

    public final cf gZ(String str) {
        AppMethodBeat.i(128811);
        this.ddx = t("InstanceId", str, true);
        AppMethodBeat.o(128811);
        return this;
    }

    public final cf ha(String str) {
        AppMethodBeat.i(128812);
        this.ddc = t("AppId", str, true);
        AppMethodBeat.o(128812);
        return this;
    }

    public final cf dY(long j) {
        this.ddd = j;
        return this;
    }

    public final cf a(a aVar) {
        this.dfD = aVar;
        return this;
    }

    public final cf dZ(long j) {
        this.ddz = j;
        return this;
    }

    public final cf ea(long j) {
        AppMethodBeat.i(128813);
        this.ddA = j;
        super.ai("CostTimeMs", this.ddA);
        AppMethodBeat.o(128813);
        return this;
    }

    public final cf eb(long j) {
        this.cVR = j;
        return this;
    }

    public final cf ec(long j) {
        AppMethodBeat.i(128814);
        this.ddB = j;
        super.aj("StartTimeStampMs", this.ddB);
        AppMethodBeat.o(128814);
        return this;
    }

    public final cf ed(long j) {
        AppMethodBeat.i(128815);
        this.ddC = j;
        super.aj("EndTimeStampMs", this.ddC);
        AppMethodBeat.o(128815);
        return this;
    }

    public final String Fj() {
        int i;
        int i2 = -1;
        AppMethodBeat.i(128816);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddx);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.dfD != null) {
            i = this.dfD.value;
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
        if (this.dfE != null) {
            i = this.dfE.value;
        } else {
            i = -1;
        }
        stringBuffer.append(i);
        stringBuffer.append(str);
        if (this.dfF != null) {
            i2 = this.dfF.value;
        }
        stringBuffer.append(i2);
        stringBuffer.append(str);
        stringBuffer.append(this.cXm);
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(128816);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(128817);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.ddx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.dfD);
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
        stringBuffer.append("Ret:").append(this.dfE);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("IsSync:").append(this.dfF);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("NetworkType:").append(this.cXm);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(128817);
        return stringBuffer2;
    }
}
