package a.i.b.a.c.i;

import a.aa;
import a.f.b.j;
import a.i.b.a.c.b.ay;
import a.i.b.a.c.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;

public final class l {
    public static final b n(Collection<? extends b> collection) {
        AppMethodBeat.i(122041);
        j.p(collection, "descriptors");
        Object obj = !collection.isEmpty() ? 1 : null;
        if (aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError("Assertion failed");
            AppMethodBeat.o(122041);
            throw assertionError;
        }
        b bVar;
        b bVar2 = null;
        Iterator it = collection.iterator();
        while (true) {
            bVar = bVar2;
            if (!it.hasNext()) {
                break;
            }
            bVar2 = (b) it.next();
            if (bVar != null) {
                Integer b = ay.b(bVar.dYf(), bVar2.dYf());
                if (b == null || b.intValue() >= 0) {
                    bVar2 = bVar;
                }
            }
        }
        if (bVar == null) {
            j.dWJ();
        }
        AppMethodBeat.o(122041);
        return bVar;
    }
}
