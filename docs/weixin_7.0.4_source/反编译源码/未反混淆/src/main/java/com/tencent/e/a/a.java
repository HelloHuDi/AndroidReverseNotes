package com.tencent.e.a;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a implements com.tencent.e.a.b.a {
    a() {
    }

    public final void println(int i, String str, String str2) {
        AppMethodBeat.i(63703);
        Log.println(i, str, str2);
        AppMethodBeat.o(63703);
    }

    public final boolean isLoggable(String str, int i) {
        AppMethodBeat.i(63704);
        boolean isLoggable = Log.isLoggable(str, i);
        AppMethodBeat.o(63704);
        return isLoggable;
    }
}
