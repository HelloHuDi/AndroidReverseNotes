package com.tencent.mm.plugin.appbrand.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.j.a.c;
import com.tencent.mm.plugin.appbrand.o;

public final class b {

    public static final class a extends c {
        private final o gOq;

        public /* synthetic */ a(o oVar, byte b) {
            this(oVar);
        }

        private a(o oVar) {
            this.gOq = oVar;
        }

        public final void a(String str, boolean z, com.tencent.mm.plugin.appbrand.j.a.b bVar, com.tencent.mm.plugin.appbrand.j.a.a aVar) {
            AppMethodBeat.i(132306);
            this.gOq.atK().xd("__APP__");
            super.a(str, z, bVar, aVar);
            AppMethodBeat.o(132306);
        }
    }
}
