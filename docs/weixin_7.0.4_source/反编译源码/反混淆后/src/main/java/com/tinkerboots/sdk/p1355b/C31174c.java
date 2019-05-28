package com.tinkerboots.sdk.p1355b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tinkerboots.sdk.b.c */
public final class C31174c {
    public static Context context;

    public static Context getContext() {
        AppMethodBeat.m2504i(65555);
        if (context == null) {
            RuntimeException runtimeException = new RuntimeException("TinkerClientContext, context is null, please init first");
            AppMethodBeat.m2505o(65555);
            throw runtimeException;
        }
        Context context = context;
        AppMethodBeat.m2505o(65555);
        return context;
    }
}
