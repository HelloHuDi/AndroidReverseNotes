package com.tencent.mm.ui.e.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    private static a zxq = null;

    public static void a(a aVar) {
        zxq = aVar;
    }

    public static CharSequence h(Context context, CharSequence charSequence, int i) {
        AppMethodBeat.i(112571);
        if (zxq != null) {
            charSequence = zxq.h(charSequence, i);
            AppMethodBeat.o(112571);
            return charSequence;
        }
        AppMethodBeat.o(112571);
        return charSequence;
    }

    public static CharSequence c(Context context, CharSequence charSequence, float f) {
        AppMethodBeat.i(112572);
        if (zxq != null) {
            charSequence = zxq.c(context, charSequence, f);
            AppMethodBeat.o(112572);
            return charSequence;
        }
        AppMethodBeat.o(112572);
        return charSequence;
    }

    public static int bV(String str, int i) {
        AppMethodBeat.i(112573);
        if (zxq != null) {
            i = zxq.bV(str, i);
            AppMethodBeat.o(112573);
            return i;
        }
        AppMethodBeat.o(112573);
        return i;
    }
}
