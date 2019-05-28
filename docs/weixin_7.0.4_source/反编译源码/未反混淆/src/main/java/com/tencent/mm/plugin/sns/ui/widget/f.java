package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.ui.e.k;

public final class f {
    public static k a(Context context, String str, float f, boolean z) {
        AppMethodBeat.i(40523);
        k kVar = new k(j.a(context, (CharSequence) str, (int) f, 2, z));
        AppMethodBeat.o(40523);
        return kVar;
    }
}
