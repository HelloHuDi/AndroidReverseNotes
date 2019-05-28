package a.i.b.a.c.d.b;

import a.f.b.j;
import a.k.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h<T> {
    private int Bru;
    private T Brv;
    private final k<T> Brw;

    public final void ecs() {
        if (this.Brv == null) {
            this.Bru++;
        }
    }

    public final void dH(T t) {
        AppMethodBeat.i(120265);
        j.p(t, "objectType");
        dI(t);
        AppMethodBeat.o(120265);
    }

    /* Access modifiers changed, original: final */
    public final void dI(T t) {
        AppMethodBeat.i(120266);
        j.p(t, "type");
        if (this.Brv == null) {
            this.Brv = this.Brw.avM(u.s("[", this.Bru) + this.Brw.toString(t));
        }
        AppMethodBeat.o(120266);
    }
}
