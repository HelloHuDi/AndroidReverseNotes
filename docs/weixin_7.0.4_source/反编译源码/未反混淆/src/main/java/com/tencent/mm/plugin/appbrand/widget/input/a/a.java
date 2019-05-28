package com.tencent.mm.plugin.appbrand.widget.input.a;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static final b jij = new b() {
        public final com.tencent.mm.plugin.appbrand.widget.input.a.b.a pe(int i) {
            return null;
        }

        public final SpannableString a(Context context, CharSequence charSequence, float f) {
            return null;
        }
    };

    public static b aRx() {
        AppMethodBeat.i(123935);
        b bVar = (b) e.B(b.class);
        if (bVar == null) {
            bVar = jij;
            AppMethodBeat.o(123935);
            return bVar;
        }
        AppMethodBeat.o(123935);
        return bVar;
    }

    static {
        AppMethodBeat.i(123936);
        AppMethodBeat.o(123936);
    }
}
