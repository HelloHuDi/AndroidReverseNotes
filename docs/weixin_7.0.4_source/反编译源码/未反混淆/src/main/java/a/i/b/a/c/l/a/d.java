package a.i.b.a.c.l.a;

import a.i.b.a.c.l.a.c.a;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d implements c {
    private final q BKt;

    public static c b(final a aVar) {
        AppMethodBeat.i(122716);
        d dVar = new d(new q(new p() {
            public final boolean b(an anVar, an anVar2) {
                AppMethodBeat.i(122715);
                if (anVar.equals(anVar2) || aVar.a(anVar, anVar2)) {
                    AppMethodBeat.o(122715);
                    return true;
                }
                AppMethodBeat.o(122715);
                return false;
            }
        }));
        AppMethodBeat.o(122716);
        return dVar;
    }

    private d(q qVar) {
        this.BKt = qVar;
    }

    public final boolean c(w wVar, w wVar2) {
        AppMethodBeat.i(122717);
        boolean c = this.BKt.c(wVar, wVar2);
        AppMethodBeat.o(122717);
        return c;
    }

    public final boolean d(w wVar, w wVar2) {
        AppMethodBeat.i(122718);
        boolean d = this.BKt.d(wVar, wVar2);
        AppMethodBeat.o(122718);
        return d;
    }
}
