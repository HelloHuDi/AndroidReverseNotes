package com.tinkerboots.sdk.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    public static Context context;

    public static Context getContext() {
        AppMethodBeat.i(65555);
        if (context == null) {
            RuntimeException runtimeException = new RuntimeException("TinkerClientContext, context is null, please init first");
            AppMethodBeat.o(65555);
            throw runtimeException;
        }
        Context context = context;
        AppMethodBeat.o(65555);
        return context;
    }
}
