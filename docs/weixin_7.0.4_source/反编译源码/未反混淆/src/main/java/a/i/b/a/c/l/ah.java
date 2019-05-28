package a.i.b.a.c.l;

import a.f;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i;
import a.i.b.a.c.b.ar;
import a.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ah extends aq {
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(ah.class), "_type", "get_type()Lorg/jetbrains/kotlin/types/KotlinType;"))};
    private final f BJK = i.a(a.k.PUBLICATION, new a(this));
    private final ar BJL;

    static final class a extends a.f.b.k implements a.f.a.a<w> {
        final /* synthetic */ ah BJM;

        a(ah ahVar) {
            this.BJM = ahVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(122631);
            w d = ai.d(this.BJM.BJL);
            AppMethodBeat.o(122631);
            return d;
        }
    }

    static {
        AppMethodBeat.i(122632);
        AppMethodBeat.o(122632);
    }

    public ah(ar arVar) {
        j.p(arVar, "typeParameter");
        AppMethodBeat.i(122634);
        this.BJL = arVar;
        AppMethodBeat.o(122634);
    }

    public final boolean ekp() {
        return true;
    }

    public final ba ekq() {
        return ba.OUT_VARIANCE;
    }

    public final w dZS() {
        AppMethodBeat.i(122633);
        w wVar = (w) this.BJK.getValue();
        AppMethodBeat.o(122633);
        return wVar;
    }
}
