package com.tencent.matrix.trace.a;

import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Set;

public final class a {
    public com.tencent.mrs.b.a bWX;
    public boolean bYA;
    public boolean bYB;
    public boolean bYC;
    public boolean bYD;
    public boolean bYE;
    public String bYF;
    public Set<String> bYG;
    public boolean isDebug;

    public static class a {
        public a bYH = new a();
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(" \n");
        stringBuilder.append("# TraceConfig\n");
        stringBuilder.append("* isDebug:\t").append(this.isDebug).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("* isDevEnv:\t").append(this.bYE).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("* defaultFpsEnable:\t").append(this.bYA).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("* defaultMethodTraceEnable:\t").append(this.bYB).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("* defaultStartupEnable:\t").append(this.bYC).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("* defaultAnrEnable:\t").append(this.bYD).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("* splashActivities:\t").append(this.bYF).append(IOUtils.LINE_SEPARATOR_UNIX);
        return stringBuilder.toString();
    }
}
