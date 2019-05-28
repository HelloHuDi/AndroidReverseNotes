package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q {
    public static int b(Bitmap bitmap, int i, String str) {
        AppMethodBeat.i(93393);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(93393);
            return -1;
        }
        int compressByQualityOptim = MMJpegOptim.compressByQualityOptim(bitmap, i, false, str);
        AppMethodBeat.o(93393);
        return compressByQualityOptim;
    }
}
