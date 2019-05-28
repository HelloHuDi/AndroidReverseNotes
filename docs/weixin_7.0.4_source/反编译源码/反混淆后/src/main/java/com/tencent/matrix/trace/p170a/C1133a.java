package com.tencent.matrix.trace.p170a;

import com.tencent.mrs.p656b.C5774a;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Set;

/* renamed from: com.tencent.matrix.trace.a.a */
public final class C1133a {
    public C5774a bWX;
    public boolean bYA;
    public boolean bYB;
    public boolean bYC;
    public boolean bYD;
    public boolean bYE;
    public String bYF;
    public Set<String> bYG;
    public boolean isDebug;

    /* renamed from: com.tencent.matrix.trace.a.a$a */
    public static class C1132a {
        public C1133a bYH = new C1133a();
    }

    /* synthetic */ C1133a(byte b) {
        this();
    }

    private C1133a() {
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
