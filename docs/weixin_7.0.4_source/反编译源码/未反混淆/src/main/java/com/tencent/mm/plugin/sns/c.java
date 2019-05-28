package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends com.tencent.mm.sdk.b.c<fo> {
    public c() {
        AppMethodBeat.i(35600);
        this.xxI = fo.class.getName().hashCode();
        AppMethodBeat.o(35600);
    }

    private boolean a(final fo foVar) {
        AppMethodBeat.i(35601);
        if (foVar instanceof fo) {
            a cnv = af.cnv();
            cnv.a(foVar.czp.type, foVar.czp.username, new h.a() {
                public final void a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j, String str2) {
                    AppMethodBeat.i(35599);
                    if (foVar.czp != null) {
                        foVar.czp.czt.a(null);
                    }
                    AppMethodBeat.o(35599);
                }

                public final void a(boolean z, String str, boolean z2, boolean z3, int i, long j, String str2) {
                }
            });
            cnv.a(1, foVar.czp.username, foVar.czp.czr, foVar.czp.czs);
            AppMethodBeat.o(35601);
            return true;
        }
        ab.f("MicroMsg.ExtStartSnsServerAndCallbackOnFpSetSizeEventListener", "mismatched event");
        AppMethodBeat.o(35601);
        return false;
    }
}
