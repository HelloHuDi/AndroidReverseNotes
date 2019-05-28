package com.tencent.mm.plugin.welab.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.welab.e.b;
import com.tencent.mm.plugin.welab.ui.WelabMainUI;

public final class c implements com.tencent.mm.plugin.welab.a.a.c {
    public final void D(Context context, Intent intent) {
        AppMethodBeat.i(80572);
        intent.setClass(context, WelabMainUI.class);
        String str = "para_from_with_red_point";
        int i = (ddn() || ddo()) ? 1 : 0;
        intent.putExtra(str, i);
        context.startActivity(intent);
        AppMethodBeat.o(80572);
    }

    public final boolean ddn() {
        AppMethodBeat.i(80573);
        b.ddC();
        if (!b.ddE() || ddo()) {
            AppMethodBeat.o(80573);
            return false;
        }
        AppMethodBeat.o(80573);
        return true;
    }

    public final boolean ddo() {
        AppMethodBeat.i(80574);
        b.ddC();
        if (!b.ddF()) {
            b.ddC();
            if (b.ddE()) {
                AppMethodBeat.o(80574);
                return true;
            }
        }
        AppMethodBeat.o(80574);
        return false;
    }

    public final boolean ddp() {
        AppMethodBeat.i(80575);
        if (ddo()) {
            AppMethodBeat.o(80575);
            return false;
        }
        AppMethodBeat.o(80575);
        return true;
    }
}
