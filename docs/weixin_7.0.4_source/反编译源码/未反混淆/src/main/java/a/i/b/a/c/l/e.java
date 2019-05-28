package a.i.b.a.c.l;

import a.i.b.a.c.b.ap;
import a.i.b.a.c.b.ap.a;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.h;
import a.i.b.a.c.i.d;
import a.i.b.a.c.k.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class e extends b implements an {
    private final a.i.b.a.c.b.e BGx;
    private final Collection<w> BiV;
    private final List<ar> parameters;

    public e(a.i.b.a.c.b.e eVar, List<? extends ar> list, Collection<w> collection, i iVar) {
        super(iVar);
        AppMethodBeat.i(122497);
        this.BGx = eVar;
        this.parameters = Collections.unmodifiableList(new ArrayList(list));
        this.BiV = Collections.unmodifiableCollection(collection);
        AppMethodBeat.o(122497);
    }

    public final List<ar> getParameters() {
        return this.parameters;
    }

    public final String toString() {
        AppMethodBeat.i(122498);
        String str = d.n(this.BGx).ByV;
        AppMethodBeat.o(122498);
        return str;
    }

    public final boolean dYu() {
        return true;
    }

    public final a.i.b.a.c.b.e dYt() {
        return this.BGx;
    }

    /* Access modifiers changed, original: protected|final */
    public final Collection<w> dYr() {
        return this.BiV;
    }

    /* Access modifiers changed, original: protected|final */
    public final ap dYv() {
        return a.BeT;
    }

    public final /* bridge */ /* synthetic */ h dYs() {
        return this.BGx;
    }
}
