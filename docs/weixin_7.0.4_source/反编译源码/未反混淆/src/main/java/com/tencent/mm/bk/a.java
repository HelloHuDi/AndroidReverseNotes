package com.tencent.mm.bk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class a {
    public static float fY(long j) {
        float f = 1.0f;
        AppMethodBeat.i(16633);
        float f2 = ((float) j) / 1000.0f;
        if (f2 >= 1.0f) {
            f = f2;
        }
        f = (float) Math.round(f);
        AppMethodBeat.o(16633);
        return f;
    }

    public static CharSequence B(Context context, int i) {
        AppMethodBeat.i(16634);
        if (i <= 0) {
            String string = context.getString(R.string.brd, new Object[]{Integer.valueOf(0), Integer.valueOf(0)});
            AppMethodBeat.o(16634);
            return string;
        }
        int i2 = i % 60;
        CharSequence string2 = context.getString(R.string.brd, new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i2)});
        AppMethodBeat.o(16634);
        return string2;
    }
}
