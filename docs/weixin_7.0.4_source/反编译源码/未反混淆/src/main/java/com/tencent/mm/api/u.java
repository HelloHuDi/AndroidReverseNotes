package com.tencent.mm.api;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u {
    public static a cda;

    public interface a {
        t AI();

        SmileyPanel aS(Context context);

        SmileyPanel j(Context context, boolean z);
    }

    public static SmileyPanel aR(Context context) {
        AppMethodBeat.i(123958);
        SmileyPanel aS = cda.aS(context);
        AppMethodBeat.o(123958);
        return aS;
    }

    public static SmileyPanel i(Context context, boolean z) {
        AppMethodBeat.i(123959);
        SmileyPanel j = cda.j(context, z);
        AppMethodBeat.o(123959);
        return j;
    }

    public static t AH() {
        AppMethodBeat.i(123960);
        t AI = cda.AI();
        AppMethodBeat.o(123960);
        return AI;
    }
}
