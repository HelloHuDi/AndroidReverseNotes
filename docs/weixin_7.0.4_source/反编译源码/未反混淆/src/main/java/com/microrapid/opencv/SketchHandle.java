package com.microrapid.opencv;

import android.graphics.Bitmap;
import com.tencent.filter.MRect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SketchHandle {
    private final long bCj;
    private boolean bCk;

    private static native void nativeAutobodyCut(long j, Bitmap bitmap, Bitmap bitmap2, int i, int i2, int i3, int i4);

    private static native void nativeAutobodyCut2(long j, Bitmap bitmap, Bitmap bitmap2, MRect mRect, MRect mRect2, MRect mRect3);

    private static native long nativeBokehProcess();

    private static native void nativeDispose(long j);

    public static native int nativeGetHandleWidth();

    private static native void nativeLanderBitmap(long j, Bitmap bitmap);

    private static native void nativeProcessBitmap(long j, Bitmap bitmap);

    private static native void nativeSetFaceFeatures(long j, int[][] iArr);

    private static native void nativeSetFemale(long j, boolean z);

    private static native void nativeTestProcessBitmap(long j, Bitmap bitmap, String str, String str2);

    public SketchHandle() {
        AppMethodBeat.i(86268);
        this.bCk = false;
        this.bCj = nativeBokehProcess();
        this.bCk = true;
        AppMethodBeat.o(86268);
    }
}
