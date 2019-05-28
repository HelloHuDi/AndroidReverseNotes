package a.i.b.a.c.b.c;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Set;

public final class u implements t {
    private final List<v> BiL;
    private final Set<v> BiM;
    private final List<v> BiN;

    public u(List<v> list, Set<v> set, List<v> list2) {
        j.p(list, "allDependencies");
        j.p(set, "modulesWhoseInternalsAreVisible");
        j.p(list2, "expectedByDependencies");
        AppMethodBeat.i(119506);
        this.BiL = list;
        this.BiM = set;
        this.BiN = list2;
        AppMethodBeat.o(119506);
    }

    public final List<v> eaz() {
        return this.BiL;
    }

    public final Set<v> eaA() {
        return this.BiM;
    }

    public final List<v> eaB() {
        return this.BiN;
    }
}
