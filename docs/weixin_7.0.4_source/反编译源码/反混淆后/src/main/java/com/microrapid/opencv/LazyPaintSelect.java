package com.microrapid.opencv;

import android.graphics.Bitmap;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LazyPaintSelect {
    private final long bCj;
    private boolean bCk;

    public static native void FormatAlphaBitmap(Bitmap bitmap);

    public static native void ProcessBitmap(Bitmap bitmap, Bitmap bitmap2);

    public static native void SmoothBitmapForManga(Bitmap bitmap);

    public static native byte[] getSrcAlphaBytes(Bitmap bitmap, int i, int i2, int i3, int i4, float f, float f2, float f3, float f4);

    public static native void maskBitmapAlpha(Bitmap bitmap, Bitmap bitmap2);

    private native void nativeAddEraser(long j, int i, int i2, int i3, int i4, double d);

    private native void nativeAddPoints(long j, int i, int i2, int i3, int i4, double d);

    private native boolean nativeCanRedo(long j);

    private native boolean nativeCanUndo(long j);

    private native boolean nativeCheckRedBack(long j);

    private native void nativeDispose(long j);

    private native int nativeGetLabelMode(long j);

    private native int[] nativeGetSelectRect(long j);

    private native void nativeInitForegroundMask(long j, byte[] bArr, int i, int i2, float f, float f2, float f3, float f4);

    private native long nativeLazySnap(Bitmap bitmap);

    private native void nativeRedo(long j);

    private native void nativeResetForegroundMask(long j, QImage qImage);

    private native void nativeResetPoints(long j);

    private native void nativeSetLabelMode(long j, int i);

    private native void nativeUndo(long j);

    private native void nativeUpdateBitmap(long j, Bitmap bitmap);

    private native void nativeUpdateEraser(long j);

    private native void nativeUpdateForeBitmap(long j, Bitmap bitmap);

    private native void nativeUpdateLazy(long j);

    public static native void reverseBitmapAlpha(Bitmap bitmap);

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(86265);
        if (this.bCk) {
            nativeDispose(this.bCj);
            this.bCk = false;
        }
        super.finalize();
        AppMethodBeat.m2505o(86265);
    }
}
