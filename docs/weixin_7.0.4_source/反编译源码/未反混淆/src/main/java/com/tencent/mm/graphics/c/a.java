package com.tencent.mm.graphics.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public enum a {
    ;

    public static class a {
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

    private a(String str) {
    }

    static {
        AppMethodBeat.o(57098);
    }

    public static void a(a aVar, a aVar2) {
        AppMethodBeat.i(57095);
        long currentTimeMillis = System.currentTimeMillis();
        if (aVar != null) {
            a(currentTimeMillis, aVar);
        }
        if (aVar2 != null) {
            a(currentTimeMillis, aVar2);
        }
        AppMethodBeat.o(57095);
    }

    private static void a(long j, a aVar) {
        AppMethodBeat.i(57096);
        if (aVar == null) {
            AppMethodBeat.o(57096);
            return;
        }
        ab.i("MicroMsg.ImageReporter", "alvinluo reportImageDecodeInfo sessionId: %d, from: %s, imageType: %d, w: %d, h: %d, fileSize: %d, orientation: %d, decodeResult: %d, decodeTime: %d, fullSampleSzie: %d, onlyDecodeTime: %d", Long.valueOf(j), aVar.cKf, Integer.valueOf(aVar.eCW), Integer.valueOf(aVar.width), Integer.valueOf(aVar.height), Integer.valueOf(aVar.fileSize), Integer.valueOf(aVar.orientation), Integer.valueOf(aVar.eCX), Integer.valueOf(aVar.eCY), Integer.valueOf(aVar.aIY), Integer.valueOf(aVar.eCZ));
        h.pYm.e(15467, Long.valueOf(j), aVar.cKf, Integer.valueOf(aVar.eCW), Integer.valueOf(aVar.width), Integer.valueOf(aVar.height), Integer.valueOf(aVar.fileSize), Integer.valueOf(aVar.orientation), Integer.valueOf(aVar.eCX), Integer.valueOf(aVar.eCY), Integer.valueOf(aVar.aIY), Integer.valueOf(aVar.eCZ));
        AppMethodBeat.o(57096);
    }

    public static void a(b bVar) {
        AppMethodBeat.i(57097);
        long currentTimeMillis = System.currentTimeMillis();
        if (bVar != null) {
            ab.i("MicroMsg.ImageReporter", "alvinluo reportPerformance sessionId: %d, fps.maxFps: %f, fps.minFps: %f, fps.averageFps: %f, memory.memoryUsedWhenInit: %f, memory.currentMaxUsedMemory: %f, memory.currentMinUsedMemory: %f, memory.averUsed: %f, memory.currentVarianceSum: %f", Long.valueOf(currentTimeMillis), Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(bVar.eCD), Double.valueOf(bVar.eCE), Double.valueOf(bVar.eCF), Double.valueOf(bVar.eCH), Double.valueOf(bVar.eCG));
            h.pYm.e(15471, Long.valueOf(currentTimeMillis), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf((int) bVar.eCD), Integer.valueOf((int) bVar.eCE), Integer.valueOf((int) bVar.eCH), Integer.valueOf((int) bVar.eCG), Integer.valueOf(1));
        }
        AppMethodBeat.o(57097);
    }
}
