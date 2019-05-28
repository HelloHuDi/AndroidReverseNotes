package com.tencent.mm.plugin.sns.ui.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.k.c.a;
import com.tencent.mm.vending.g.f;

public final class b {
    public boolean hasInit = false;
    public a rEQ = new a();
    public a rER = null;
    public int rzl = 0;

    public b() {
        AppMethodBeat.i(39948);
        AppMethodBeat.o(39948);
    }

    private void b(String str, boolean z, boolean z2, int i) {
        AppMethodBeat.i(39949);
        a aVar = this.rEQ;
        if (aVar.ryk != null) {
            f.b(str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)).c(aVar.ryk.rNp);
        }
        AppMethodBeat.o(39949);
    }

    private void c(String str, boolean z, boolean z2, int i) {
        AppMethodBeat.i(39950);
        a aVar = this.rEQ;
        if (aVar.ryk != null) {
            f.b(str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)).c(aVar.ryk.rNq);
        }
        AppMethodBeat.o(39950);
    }

    public final void d(String str, boolean z, boolean z2, int i) {
        AppMethodBeat.i(39951);
        if (this.hasInit) {
            if (this.rzl == 0) {
                b(str, z, z2, i);
            }
            AppMethodBeat.o(39951);
            return;
        }
        AppMethodBeat.o(39951);
    }

    public final void e(String str, boolean z, boolean z2, int i) {
        AppMethodBeat.i(39952);
        if (this.hasInit) {
            if (this.rzl == 0) {
                c(str, z, z2, i);
            }
            AppMethodBeat.o(39952);
            return;
        }
        AppMethodBeat.o(39952);
    }
}
