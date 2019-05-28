package com.tencent.toybrick.b;

import android.support.v7.widget.RecyclerView.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.c.b;
import com.tencent.toybrick.c.c;
import com.tencent.toybrick.c.d;
import com.tencent.toybrick.c.e;

public final class a {
    private static n AFN;

    static {
        AppMethodBeat.i(113179);
        n nVar = new n();
        AFN = nVar;
        nVar.aF(d.AFW, 10);
        AFN.aF(e.AFW, 10);
        AFN.aF(com.tencent.toybrick.c.a.AFW, 10);
        AFN.aF(b.AFW, 10);
        AFN.aF(c.AFW, 10);
        AppMethodBeat.o(113179);
    }

    public static n dSx() {
        return AFN;
    }
}
