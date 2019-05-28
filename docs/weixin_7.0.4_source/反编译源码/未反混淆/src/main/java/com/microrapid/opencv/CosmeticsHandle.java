package com.microrapid.opencv;

import android.graphics.Bitmap;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CosmeticsHandle {
    private final long bCj;
    private boolean bCk;
    private QImage bCn;

    private static native boolean nativeCanManualRedo(long j, int i);

    private static native boolean nativeCanManualUndo(long j, int i);

    private static native boolean nativeCheckIsAllDisable(long j);

    private static native void nativeClearComseticCache(long j, int i);

    private static native void nativeClearCosmeticMask(long j, int i);

    private static native void nativeCosmetic(long j, Bitmap bitmap, int i);

    private static native long nativeCosmeticsProcess();

    private static native void nativeDisableAllCosmetic(long j);

    private static native void nativeDisableCosmetic(long j, int i);

    private static native void nativeDispose(long j);

    private static native void nativeFineTuneFeatures(long j, int i, int i2, int i3, int i4, int i5, int i6);

    private static native double nativeGetCosAlpha(long j, int i);

    private static native int nativeGetCosParamWithIndex(long j, int i, int i2);

    private static native int[][] nativeGetFaceFeatures(long j);

    private static native int nativeGetHairType(long j);

    private static native double nativeGetLastSmoothMag(long j);

    private static native void nativeGetSkinMaskBitmap(long j, Bitmap bitmap);

    private static native void nativeInitCosModel(long j, int i, Bitmap[] bitmapArr);

    private static native int nativeIsNeedRestModel(long j);

    private static native void nativeLanderBitmap(long j, Bitmap bitmap);

    private static native void nativeLocateIrisFast(byte[] bArr, int[][] iArr, int i, int i2, int[] iArr2);

    private static native void nativeManualAcceptAdjust(long j, int i);

    private static native void nativeManualCancelAdjust(long j, int i);

    private static native void nativeManualRedo(long j, int i);

    private static native void nativeManualUndo(long j, int i);

    private static native boolean nativePreProcessImage(long j, int i);

    private static native void nativeRSSColor(long j, int i, int i2, int i3, int i4);

    private static native void nativeResetALLCosAlpha(long j);

    private static native void nativeSegmentLipsFast(byte[] bArr, int[][] iArr, int i, int i2);

    private static native void nativeSetAutoBodyMask(long j, Bitmap bitmap);

    private static native void nativeSetAutoHairMask(long j, Bitmap bitmap);

    private static native void nativeSetBitmap(long j, QImage qImage);

    private static native void nativeSetCosAlpha(long j, double d, int i);

    private static native int nativeSetCosParamWithIndex(long j, int i, int i2, int i3);

    private static native void nativeSetFaceCount(long j, int i);

    private static native void nativeSetFaceFeatures(long j, int[][] iArr);

    private static native void nativeSetHairMask(long j, Bitmap bitmap, int i);

    private static native void nativeSetHairRecolorType(long j, int i);

    private static native void nativeSetLastSmoothMag(long j, double d);

    private static native void nativeSetMaxBasicMag(long j, double d);

    private static native void nativeSetMaxSmoothMag(long j, double d);

    private static native void nativeSetRss(long j, Bitmap bitmap, int i, int i2);

    private static native void nativeSetUseGpuSmooth(long j, boolean z);

    public CosmeticsHandle() {
        AppMethodBeat.i(86257);
        this.bCk = false;
        this.bCn = null;
        this.bCj = nativeCosmeticsProcess();
        this.bCk = true;
        AppMethodBeat.o(86257);
    }

    public static void a(byte[] bArr, int[][] iArr, int i, int i2) {
        AppMethodBeat.i(86258);
        nativeSegmentLipsFast(bArr, iArr, i, i2);
        AppMethodBeat.o(86258);
    }
}
