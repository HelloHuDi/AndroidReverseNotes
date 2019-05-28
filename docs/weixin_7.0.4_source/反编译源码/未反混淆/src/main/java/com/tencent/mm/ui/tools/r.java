package com.tencent.mm.ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;

public final class r {
    public static int ik(Context context) {
        AppMethodBeat.i(107812);
        if (Float.compare(a.dm(context), 1.25f) > 0) {
            AppMethodBeat.o(107812);
            return R.drawable.a4g;
        }
        AppMethodBeat.o(107812);
        return R.drawable.a4f;
    }
}
