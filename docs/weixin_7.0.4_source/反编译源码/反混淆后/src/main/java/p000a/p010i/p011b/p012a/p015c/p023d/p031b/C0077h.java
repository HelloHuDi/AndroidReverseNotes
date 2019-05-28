package p000a.p010i.p011b.p012a.p015c.p023d.p031b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C6163u;

/* renamed from: a.i.b.a.c.d.b.h */
public final class C0077h<T> {
    private int Bru;
    private T Brv;
    private final C44896k<T> Brw;

    public final void ecs() {
        if (this.Brv == null) {
            this.Bru++;
        }
    }

    /* renamed from: dH */
    public final void mo125dH(T t) {
        AppMethodBeat.m2504i(120265);
        C25052j.m39376p(t, "objectType");
        mo126dI(t);
        AppMethodBeat.m2505o(120265);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: dI */
    public final void mo126dI(T t) {
        AppMethodBeat.m2504i(120266);
        C25052j.m39376p(t, "type");
        if (this.Brv == null) {
            this.Brv = this.Brw.avM(C6163u.m9841s("[", this.Bru) + this.Brw.toString(t));
        }
        AppMethodBeat.m2505o(120266);
    }
}
