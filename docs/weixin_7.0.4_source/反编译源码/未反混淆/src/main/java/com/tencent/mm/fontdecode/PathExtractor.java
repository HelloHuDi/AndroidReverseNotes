package com.tencent.mm.fontdecode;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class PathExtractor {
    private long eAW;
    private String filePath;

    @Keep
    public static class Metrics {
        public float ascender;
        public float descender;
        public float height;
    }

    private static native boolean nExtractPath(long j, char c, Path path, int[] iArr);

    private static native void nFinalize(long j);

    private static native void nGetMetrics(long j, Metrics metrics);

    private static native long nInit(String str);

    private static native void nSetTextSize(long j, int i);

    public PathExtractor(String str) {
        AppMethodBeat.i(114788);
        this.filePath = str;
        this.eAW = nInit(str);
        if (this.eAW != 0) {
            ab.i("MicroMsg.PathExtractor", "create for %s, %d", str, Long.valueOf(this.eAW));
            AppMethodBeat.o(114788);
            return;
        }
        ab.e("MicroMsg.PathExtractor", "create for %s failed", str);
        AppMethodBeat.o(114788);
    }

    public final boolean isValid() {
        return this.eAW != 0;
    }

    public final void setTextSize(int i) {
        AppMethodBeat.i(114789);
        ab.i("MicroMsg.PathExtractor", "set text size %d, %d", Long.valueOf(this.eAW), Integer.valueOf(i));
        nSetTextSize(this.eAW, i);
        AppMethodBeat.o(114789);
    }

    public final void a(Metrics metrics) {
        AppMethodBeat.i(114790);
        if (metrics == null) {
            ab.w("MicroMsg.PathExtractor", "metrics is null");
            AppMethodBeat.o(114790);
            return;
        }
        nGetMetrics(this.eAW, metrics);
        metrics.height *= 0.015625f;
        metrics.ascender *= 0.015625f;
        metrics.descender *= 0.015625f;
        AppMethodBeat.o(114790);
    }

    public final boolean a(char c, Path path, RectF rectF) {
        boolean nExtractPath;
        AppMethodBeat.i(114791);
        int[] iArr = new int[4];
        try {
            nExtractPath = nExtractPath(this.eAW, c, path, iArr);
        } catch (Exception e) {
            ab.e("MicroMsg.PathExtractor", "extract path error %c", Character.valueOf(c));
            nExtractPath = false;
        }
        if (nExtractPath) {
            Matrix matrix = new Matrix();
            matrix.setScale(0.015625f, 0.015625f);
            path.transform(matrix);
            rectF.set(((float) iArr[0]) * 0.015625f, ((float) iArr[3]) * 0.015625f, ((float) iArr[2]) * 0.015625f, ((float) iArr[1]) * 0.015625f);
            ab.i("MicroMsg.PathExtractor", "load path for ".concat(String.valueOf(c)));
            AppMethodBeat.o(114791);
            return true;
        }
        ab.w("MicroMsg.PathExtractor", "not such char ".concat(String.valueOf(c)));
        AppMethodBeat.o(114791);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(114792);
        try {
            nFinalize(this.eAW);
        } finally {
            super.finalize();
            AppMethodBeat.o(114792);
        }
    }

    static {
        AppMethodBeat.i(114793);
        System.loadLibrary("fontdecode");
        AppMethodBeat.o(114793);
    }
}
