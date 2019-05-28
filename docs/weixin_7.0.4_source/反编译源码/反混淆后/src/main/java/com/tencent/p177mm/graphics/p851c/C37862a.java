package com.tencent.p177mm.graphics.p851c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.graphics.p234b.C45408b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.graphics.c.a */
public enum C37862a {
    ;

    /* renamed from: com.tencent.mm.graphics.c.a$a */
    public static class C9543a {
        public int aIY;
        public String cKf;
        public int eCW;
        public int eCX;
        public int eCY;
        public int eCZ;
        public int fileSize;
        public int height;
        public String imagePath;
        public int orientation;
        public int width;
    }

    private C37862a(String str) {
    }

    static {
        AppMethodBeat.m2505o(57098);
    }

    /* renamed from: a */
    public static void m63893a(C9543a c9543a, C9543a c9543a2) {
        AppMethodBeat.m2504i(57095);
        long currentTimeMillis = System.currentTimeMillis();
        if (c9543a != null) {
            C37862a.m63891a(currentTimeMillis, c9543a);
        }
        if (c9543a2 != null) {
            C37862a.m63891a(currentTimeMillis, c9543a2);
        }
        AppMethodBeat.m2505o(57095);
    }

    /* renamed from: a */
    private static void m63891a(long j, C9543a c9543a) {
        AppMethodBeat.m2504i(57096);
        if (c9543a == null) {
            AppMethodBeat.m2505o(57096);
            return;
        }
        C4990ab.m7417i("MicroMsg.ImageReporter", "alvinluo reportImageDecodeInfo sessionId: %d, from: %s, imageType: %d, w: %d, h: %d, fileSize: %d, orientation: %d, decodeResult: %d, decodeTime: %d, fullSampleSzie: %d, onlyDecodeTime: %d", Long.valueOf(j), c9543a.cKf, Integer.valueOf(c9543a.eCW), Integer.valueOf(c9543a.width), Integer.valueOf(c9543a.height), Integer.valueOf(c9543a.fileSize), Integer.valueOf(c9543a.orientation), Integer.valueOf(c9543a.eCX), Integer.valueOf(c9543a.eCY), Integer.valueOf(c9543a.aIY), Integer.valueOf(c9543a.eCZ));
        C7060h.pYm.mo8381e(15467, Long.valueOf(j), c9543a.cKf, Integer.valueOf(c9543a.eCW), Integer.valueOf(c9543a.width), Integer.valueOf(c9543a.height), Integer.valueOf(c9543a.fileSize), Integer.valueOf(c9543a.orientation), Integer.valueOf(c9543a.eCX), Integer.valueOf(c9543a.eCY), Integer.valueOf(c9543a.aIY), Integer.valueOf(c9543a.eCZ));
        AppMethodBeat.m2505o(57096);
    }

    /* renamed from: a */
    public static void m63892a(C45408b c45408b) {
        AppMethodBeat.m2504i(57097);
        long currentTimeMillis = System.currentTimeMillis();
        if (c45408b != null) {
            C4990ab.m7417i("MicroMsg.ImageReporter", "alvinluo reportPerformance sessionId: %d, fps.maxFps: %f, fps.minFps: %f, fps.averageFps: %f, memory.memoryUsedWhenInit: %f, memory.currentMaxUsedMemory: %f, memory.currentMinUsedMemory: %f, memory.averUsed: %f, memory.currentVarianceSum: %f", Long.valueOf(currentTimeMillis), Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(c45408b.eCD), Double.valueOf(c45408b.eCE), Double.valueOf(c45408b.eCF), Double.valueOf(c45408b.eCH), Double.valueOf(c45408b.eCG));
            C7060h.pYm.mo8381e(15471, Long.valueOf(currentTimeMillis), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf((int) c45408b.eCD), Integer.valueOf((int) c45408b.eCE), Integer.valueOf((int) c45408b.eCH), Integer.valueOf((int) c45408b.eCG), Integer.valueOf(1));
        }
        AppMethodBeat.m2505o(57097);
    }
}
