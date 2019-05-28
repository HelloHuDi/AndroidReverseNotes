package com.microrapid.opencv;

import android.graphics.Bitmap;
import com.tencent.filter.MRect;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GlossyRemoveHandle {
    private final long bCj;
    private boolean bCk;

    private static native void nativeDispose(long j);

    private static native long nativeHighLightRemoval();

    private static native void nativeProcess(long j, float f);

    private static native void nativeProcessNew(long j, QImage qImage, QImage qImage2, float f);

    private static native void nativeRest(long j);

    private static native void nativeSetFaceInfo(long j, MRect mRect, MRect mRect2, MRect mRect3, MRect mRect4);

    private static native void nativeSetImage(long j, QImage qImage);

    private static native void nativeSetNeedUpdate(long j);

    private static native void nativeSetSkinYCbCrModel(long j, Bitmap bitmap);

    public GlossyRemoveHandle() {
        AppMethodBeat.i(86259);
        this.bCk = false;
        this.bCj = nativeHighLightRemoval();
        this.bCk = true;
        AppMethodBeat.o(86259);
    }
}
