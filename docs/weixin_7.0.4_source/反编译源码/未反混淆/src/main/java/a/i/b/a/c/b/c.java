package a.i.b.a.c.b;

import a.f.b.j;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.f.f;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class c implements ar {
    private final ar Beo;
    private final l Bep;
    private final int Beq;

    public final <R, D> R a(n<R, D> nVar, D d) {
        AppMethodBeat.i(119254);
        Object a = this.Beo.a(nVar, d);
        AppMethodBeat.o(119254);
        return a;
    }

    public final List<w> dWP() {
        AppMethodBeat.i(119259);
        List dWP = this.Beo.dWP();
        AppMethodBeat.o(119259);
        return dWP;
    }

    public final an dXY() {
        AppMethodBeat.i(119258);
        an dXY = this.Beo.dXY();
        AppMethodBeat.o(119258);
        return dXY;
    }

    public final g dYn() {
        AppMethodBeat.i(119253);
        g dYn = this.Beo.dYn();
        AppMethodBeat.o(119253);
        return dYn;
    }

    public final am dYo() {
        AppMethodBeat.i(119257);
        am dYo = this.Beo.dYo();
        AppMethodBeat.o(119257);
        return dYo;
    }

    public final ad dZf() {
        AppMethodBeat.i(119255);
        ad dZf = this.Beo.dZf();
        AppMethodBeat.o(119255);
        return dZf;
    }

    public final f dZg() {
        AppMethodBeat.i(119256);
        f dZg = this.Beo.dZg();
        AppMethodBeat.o(119256);
        return dZg;
    }

    public final ba dZh() {
        AppMethodBeat.i(119260);
        ba dZh = this.Beo.dZh();
        AppMethodBeat.o(119260);
        return dZh;
    }

    public final boolean dZi() {
        AppMethodBeat.i(119261);
        boolean dZi = this.Beo.dZi();
        AppMethodBeat.o(119261);
        return dZi;
    }

    public c(ar arVar, l lVar, int i) {
        j.p(arVar, "originalDescriptor");
        j.p(lVar, "declarationDescriptor");
        AppMethodBeat.i(119252);
        this.Beo = arVar;
        this.Bep = lVar;
        this.Beq = i;
        AppMethodBeat.o(119252);
    }

    public final /* synthetic */ l dZd() {
        AppMethodBeat.i(119248);
        l dZc = dZc();
        AppMethodBeat.o(119248);
        return dZc;
    }

    public final /* synthetic */ h dZe() {
        AppMethodBeat.i(119249);
        h dZc = dZc();
        AppMethodBeat.o(119249);
        return dZc;
    }

    public final boolean dZb() {
        return true;
    }

    public final ar dZc() {
        AppMethodBeat.i(119247);
        ar dZc = this.Beo.dZc();
        j.o(dZc, "originalDescriptor.original");
        AppMethodBeat.o(119247);
        return dZc;
    }

    public final l dXW() {
        return this.Bep;
    }

    public final int getIndex() {
        AppMethodBeat.i(119250);
        int index = this.Beq + this.Beo.getIndex();
        AppMethodBeat.o(119250);
        return index;
    }

    public final String toString() {
        AppMethodBeat.i(119251);
        String str = this.Beo.toString() + "[inner-copy]";
        AppMethodBeat.o(119251);
        return str;
    }
}
