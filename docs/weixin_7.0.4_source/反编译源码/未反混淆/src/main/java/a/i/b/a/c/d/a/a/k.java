package a.i.b.a.c.d.a.a;

import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.au;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public interface k {
    public static final k Bmr = new k() {
        public final a a(w wVar, List<au> list, List<ar> list2) {
            AppMethodBeat.i(119780);
            a aVar = new a(wVar, list, list2, Collections.emptyList());
            AppMethodBeat.o(119780);
            return aVar;
        }

        public final void ebl() {
            AppMethodBeat.i(119781);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Should not be called");
            AppMethodBeat.o(119781);
            throw unsupportedOperationException;
        }
    };

    public static class a {
        public final List<ar> BeK;
        public final boolean Bia;
        public final w Bji;
        public final w Bms = null;
        public final List<au> Bmt;
        public final List<String> Bmu;

        public a(w wVar, List<au> list, List<ar> list2, List<String> list3) {
            this.Bji = wVar;
            this.Bmt = list;
            this.BeK = list2;
            this.Bmu = list3;
            this.Bia = false;
        }
    }

    a a(w wVar, List<au> list, List<ar> list2);

    void ebl();
}
