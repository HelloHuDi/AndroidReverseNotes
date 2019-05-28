package com.tencent.mm.plugin.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.o;
import java.util.HashMap;

public class Plugin implements c {
    public o createApplication() {
        AppMethodBeat.i(21216);
        AnonymousClass1 anonymousClass1 = new o() {
            public final void a(n nVar) {
            }

            public final void a(m mVar) {
            }
        };
        AppMethodBeat.o(21216);
        return anonymousClass1;
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public at createSubCore() {
        AppMethodBeat.i(21217);
        AnonymousClass2 anonymousClass2 = new at() {
            public final HashMap<Integer, d> Jx() {
                return null;
            }

            public final void iy(int i) {
            }

            public final void bz(boolean z) {
            }

            public final void bA(boolean z) {
            }

            public final void onAccountRelease() {
            }
        };
        AppMethodBeat.o(21217);
        return anonymousClass2;
    }
}
