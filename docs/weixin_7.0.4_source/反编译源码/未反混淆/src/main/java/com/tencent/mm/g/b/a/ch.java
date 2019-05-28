package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

public final class ch extends com.tencent.mm.plugin.report.a {
    private long cVR = 0;
    public long cXm = 0;
    private long ddA = 0;
    public long ddB = 0;
    private long ddC = 0;
    private String ddc = "";
    private long ddd = 0;
    private String ddx = "";
    private long ddz = 0;
    private a dfZ;
    public c dga;
    public b dgb;
    public long dgc = 0;

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.o(128834);
        }

        private a(int i) {
            this.value = i;
        }

        public static a hi(int i) {
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

    public enum b {
        sync(0),
        async(1);
        
        final int value;

        static {
            AppMethodBeat.o(128837);
        }

        private b(int i) {
            this.value = i;
        }
    }

    public enum c {
        ok(0),
        common_fail(1),
        bundle_null(2),
        jsapi_control_bytes_null(3);
        
        final int value;

        static {
            AppMethodBeat.o(128840);
        }

        private c(int i) {
            this.value = i;
        }
    }

    public final int getId() {
        return 15765;
    }

    public final ch hd(String str) {
        AppMethodBeat.i(128841);
        this.ddx = t("InstanceId", str, true);
        AppMethodBeat.o(128841);
        return this;
    }

    public final ch he(String str) {
        AppMethodBeat.i(128842);
        this.ddc = t("AppId", str, true);
        AppMethodBeat.o(128842);
        return this;
    }

    public final ch eh(long j) {
        this.ddd = j;
        return this;
    }

    public final ch a(a aVar) {
        this.dfZ = aVar;
        return this;
    }

    public final ch ei(long j) {
        this.ddz = j;
        return this;
    }

    public final ch ej(long j) {
        AppMethodBeat.i(128843);
        this.ddA = j;
        super.ai("CostTimeMs", this.ddA);
        AppMethodBeat.o(128843);
        return this;
    }

    public final ch ek(long j) {
        this.cVR = j;
        return this;
    }

    public final ch el(long j) {
        AppMethodBeat.i(128844);
        this.ddB = j;
        super.aj("StartTimeStampMs", this.ddB);
        AppMethodBeat.o(128844);
        return this;
    }

    public final ch em(long j) {
        AppMethodBeat.i(128845);
        this.ddC = j;
        super.aj("EndTimeStampMs", this.ddC);
        AppMethodBeat.o(128845);
        return this;
    }

    public final String Fj() {
        int i;
        int i2 = -1;
        AppMethodBeat.i(128846);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddx);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.dfZ != null) {
            i = this.dfZ.value;
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
        if (this.dga != null) {
            i = this.dga.value;
        } else {
            i = -1;
        }
        stringBuffer.append(i);
        stringBuffer.append(str);
        if (this.dgb != null) {
            i2 = this.dgb.value;
        }
        stringBuffer.append(i2);
        stringBuffer.append(str);
        stringBuffer.append(this.cXm);
        stringBuffer.append(str);
        stringBuffer.append(this.dgc);
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(128846);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(128847);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.ddx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.dfZ);
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
        stringBuffer.append("Ret:").append(this.dga);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("IsSync:").append(this.dgb);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("NetworkType:").append(this.cXm);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("IsNormalOpen:").append(this.dgc);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(128847);
        return stringBuffer2;
    }
}
