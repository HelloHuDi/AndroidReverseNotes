package com.tencent.mm.sandbox.updater;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ty;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

public final class h extends c<ty> {
    public h() {
        AppMethodBeat.i(28910);
        this.xxI = ty.class.getName().hashCode();
        AppMethodBeat.o(28910);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(28911);
        ty tyVar = (ty) bVar;
        if (tyVar instanceof ty) {
            Updater e = Updater.e(tyVar.cQc.context, null);
            if (e == null) {
                AppMethodBeat.o(28911);
            } else {
                e.aA(tyVar.cQc.type, true);
                AppMethodBeat.o(28911);
            }
        } else {
            AppMethodBeat.o(28911);
        }
        return false;
    }
}
