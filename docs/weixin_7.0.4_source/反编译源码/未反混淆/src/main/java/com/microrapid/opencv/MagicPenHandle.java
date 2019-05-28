package com.microrapid.opencv;

import android.graphics.Bitmap;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MagicPenHandle {
    private final long bCj;
    private boolean bCk;

    private native void nativeAddCenterToList(long j, float f, float f2);

    private native boolean nativeCanRedo(long j);

    private native boolean nativeCanUndo(long j);

    private native void nativeCleanCenterList(long j);

    private native void nativeDispose(long j);

    private native void nativeEnablePatternColor(long j, boolean z);

    private native int[] nativeGetSelectRect(long j);

    private native void nativeIsFollowDirection(long j, boolean z);

    private native long nativeMagicPen();

    private native void nativeProcessImage(long j);

    private native void nativeRSSColor(long j, int i, int i2, int i3);

    private native void nativeRedo(long j);

    private native void nativeResetPoints(long j);

    private native void nativeSetOptMode(long j, int i);

    private native void nativeSetPaintAlpha(long j, float f);

    private native void nativeSetPaintMode(long j, int i);

    private native void nativeSetPaintSubMode(long j, int i);

    private native void nativeSetPatternImageList(long j, Bitmap[] bitmapArr);

    private native void nativeSetRadius(long j, float f);

    private native void nativeSetTileRatio(long j, float f);

    private native void nativeTouchBegin(long j, int i, int i2);

    private native void nativeTouchCancel(long j);

    private native void nativeTouchEnd(long j, int i, int i2);

    private native void nativeTouchMove(long j, int i, int i2);

    private native void nativeUndo(long j);

    private native long nativeUpdateAlphaBitmap(long j, Bitmap bitmap);

    private native void nativeUpdateMosaicAlignType(long j, int i);

    private native void nativeUpdateMosaicHorizontalSpace(long j, float f);

    private native void nativeUpdateMosaicVerticalSpace(long j, float f);

    private native void nativeUpdatePatternIntervalRatioWidth(long j, float f);

    private native long nativeUpdateSrcImage(long j, QImage qImage);

    public MagicPenHandle() {
        AppMethodBeat.i(86267);
        this.bCk = false;
        this.bCj = nativeMagicPen();
        this.bCk = true;
        AppMethodBeat.o(86267);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(86266);
        if (this.bCk) {
            nativeDispose(this.bCj);
            this.bCk = false;
        }
        super.finalize();
        AppMethodBeat.o(86266);
    }
}
