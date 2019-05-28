package com.microrapid.opencv;

import android.graphics.Bitmap;

public class SwitchFaceHandle {
    private static native void nativeSwitchFace(Bitmap bitmap, int[][] iArr, Bitmap bitmap2, int[][] iArr2, Bitmap bitmap3);
}
