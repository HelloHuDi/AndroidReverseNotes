package com.tencent.p177mm.sdk.p609h;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.sdk.h.d */
public final class C4973d {
    /* renamed from: ha */
    public static boolean m7366ha(Context context) {
        AppMethodBeat.m2504i(65376);
        if (context == null) {
            AppMethodBeat.m2505o(65376);
            return false;
        }
        boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        AppMethodBeat.m2505o(65376);
        return hasSystemFeature;
    }
}
