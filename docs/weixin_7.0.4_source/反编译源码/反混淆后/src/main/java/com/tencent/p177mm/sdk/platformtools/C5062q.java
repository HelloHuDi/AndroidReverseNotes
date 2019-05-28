package com.tencent.p177mm.sdk.platformtools;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.sdk.platformtools.q */
public final class C5062q {
    /* renamed from: b */
    public static int m7676b(Bitmap bitmap, int i, String str) {
        AppMethodBeat.m2504i(93393);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(93393);
            return -1;
        }
        int compressByQualityOptim = MMJpegOptim.compressByQualityOptim(bitmap, i, false, str);
        AppMethodBeat.m2505o(93393);
        return compressByQualityOptim;
    }
}
