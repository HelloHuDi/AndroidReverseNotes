package com.tencent.filter;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PaintSelection {
    private final long bCj;
    private boolean bCk;
    private QImage bMP;

    public static native void FormatAlphaBitmap(Bitmap bitmap);

    public static native boolean HasAlphaBitmap(Bitmap bitmap);

    public static native void ProcessBitmap(Bitmap bitmap, Bitmap bitmap2);

    private native void nativeAddRound(long j, int i, int i2, double d);

    private native void nativeDispose(long j);

    private native byte[] nativeGetResult(long j, int i);

    private native int[] nativeGetSelectRect(long j);

    private native int nativeGetcurrentUndoMark(long j);

    private native void nativeInpaint(long j);

    private native long nativePaintSection(QImage qImage);

    private native void nativeRedo(long j);

    private native void nativeReverseSelected(long j);

    private native void nativeRmRound(long j, int i, int i2, int i3, int i4, double d);

    private native void nativeSetSelectionMode(long j, int i);

    private native void nativeTouchBegin(long j, int i, int i2);

    private native void nativeTouchMove(long j, int i, int i2, double d, double d2);

    private native void nativeUndo(long j);

    private native void nativeUpdateUndoMark(long j);

    public static native void reverseBitmapAlpha(Bitmap bitmap);

    private native void touchBegin1(int i, int i2);

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(86386);
        if (this.bCk) {
            nativeDispose(this.bCj);
            this.bMP.Dispose();
            this.bMP = null;
            this.bCk = false;
        }
        super.finalize();
        AppMethodBeat.o(86386);
    }
}
