package com.microrapid.face;

import com.tencent.filter.MRect;
import com.tencent.filter.QImage;

public class ManuFaceAlgo {
    public static native long nativeEnalrgeEyeInit(QImage qImage);

    public static native void nativeEnalrgeEyeTouchEnd(long j, int i, int i2, int i3);

    public static native boolean nativeHandleCanRedo(long j);

    public static native boolean nativeHandleCanUndo(long j);

    public static native void nativeHandleDispose(long j);

    public static native boolean nativeHandleIsRawImage(long j);

    public static native void nativeHandleRedoProcess(long j);

    public static native void nativeHandleReset(long j);

    public static native void nativeHandleUndoProcess(long j);

    public static native long nativeLightEyeInit(QImage qImage);

    public static native void nativeLightEyeTouchEnd(long j, QImage qImage, int i, MRect mRect);

    public static native long nativeManualSmoothInit(QImage qImage);

    public static native void nativeManualSmoothTouchEnd(long j, QImage qImage, QImage qImage2, int i, MRect mRect);

    public static native long nativeRepairMoleInit(QImage qImage);

    public static native void nativeRepairMoleTouchEnd(long j, int i, int i2, int i3);

    public static native long nativeReshapeInit(QImage qImage);

    public static native void nativeReshapeTouchBegin(long j);

    public static native void nativeReshapeTouchEnd(long j);

    public static native void nativeReshapeTouchMove(long j, int i, int i2, int i3, int i4, int i5);

    public static native long nativeSlimNoseInit(QImage qImage);

    public static native void nativeSlimNoseSetStrength(long j, float f);

    public static native void nativeSlimNoseTouchEndAt(long j, int i, int i2, int i3);

    public static native void nativeSpringMorphGetRange(long j, int[] iArr);

    public static native long nativeSpringMorphInit(QImage qImage);

    public static native void nativeSpringMorphSetMag(long j, float f);

    public static native void nativeSpringMorphSetRange(long j, int i, int i2);

    public static native long nativeWhitenPouchInit(QImage qImage);

    public static native void nativeWhitenPouchTouchEnd(long j, QImage qImage, int i, MRect mRect);

    public static native long nativeWhitenToothInit(QImage qImage);

    public static native void nativeWhitenToothSetLipsRect(long j, MRect mRect);

    public static native void nativeWhitenToothTouchEnd(long j, QImage qImage, int i, MRect mRect);
}
