package com.tencent.mm.ipcinvoker.h;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements com.tencent.mm.ipcinvoker.h.a.a {
    public final void a(int i, String str, String str2, Object... objArr) {
        AppMethodBeat.i(114123);
        if (i < 4) {
            AppMethodBeat.o(114123);
            return;
        }
        Log.println(i, str, String.format(str2, objArr));
        AppMethodBeat.o(114123);
    }
}
