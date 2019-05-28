package com.tencent.p177mm.fontdecode;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.fontdecode.PathExtractor */
public class PathExtractor {
    private long eAW;
    private String filePath;

    @Keep
    /* renamed from: com.tencent.mm.fontdecode.PathExtractor$Metrics */
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
        AppMethodBeat.m2504i(114788);
        this.filePath = str;
        this.eAW = PathExtractor.nInit(str);
        if (this.eAW != 0) {
            C4990ab.m7417i("MicroMsg.PathExtractor", "create for %s, %d", str, Long.valueOf(this.eAW));
            AppMethodBeat.m2505o(114788);
            return;
        }
        C4990ab.m7413e("MicroMsg.PathExtractor", "create for %s failed", str);
        AppMethodBeat.m2505o(114788);
    }

    public final boolean isValid() {
        return this.eAW != 0;
    }

    public final void setTextSize(int i) {
        AppMethodBeat.m2504i(114789);
        C4990ab.m7417i("MicroMsg.PathExtractor", "set text size %d, %d", Long.valueOf(this.eAW), Integer.valueOf(i));
        PathExtractor.nSetTextSize(this.eAW, i);
        AppMethodBeat.m2505o(114789);
    }

    /* renamed from: a */
    public final void mo33686a(Metrics metrics) {
        AppMethodBeat.m2504i(114790);
        if (metrics == null) {
            C4990ab.m7420w("MicroMsg.PathExtractor", "metrics is null");
            AppMethodBeat.m2505o(114790);
            return;
        }
        PathExtractor.nGetMetrics(this.eAW, metrics);
        metrics.height *= 0.015625f;
        metrics.ascender *= 0.015625f;
        metrics.descender *= 0.015625f;
        AppMethodBeat.m2505o(114790);
    }

    /* renamed from: a */
    public final boolean mo33687a(char c, Path path, RectF rectF) {
        boolean nExtractPath;
        AppMethodBeat.m2504i(114791);
        int[] iArr = new int[4];
        try {
            nExtractPath = PathExtractor.nExtractPath(this.eAW, c, path, iArr);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.PathExtractor", "extract path error %c", Character.valueOf(c));
            nExtractPath = false;
        }
        if (nExtractPath) {
            Matrix matrix = new Matrix();
            matrix.setScale(0.015625f, 0.015625f);
            path.transform(matrix);
            rectF.set(((float) iArr[0]) * 0.015625f, ((float) iArr[3]) * 0.015625f, ((float) iArr[2]) * 0.015625f, ((float) iArr[1]) * 0.015625f);
            C4990ab.m7416i("MicroMsg.PathExtractor", "load path for ".concat(String.valueOf(c)));
            AppMethodBeat.m2505o(114791);
            return true;
        }
        C4990ab.m7420w("MicroMsg.PathExtractor", "not such char ".concat(String.valueOf(c)));
        AppMethodBeat.m2505o(114791);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(114792);
        try {
            PathExtractor.nFinalize(this.eAW);
        } finally {
            super.finalize();
            AppMethodBeat.m2505o(114792);
        }
    }

    static {
        AppMethodBeat.m2504i(114793);
        System.loadLibrary("fontdecode");
        AppMethodBeat.m2505o(114793);
    }
}
