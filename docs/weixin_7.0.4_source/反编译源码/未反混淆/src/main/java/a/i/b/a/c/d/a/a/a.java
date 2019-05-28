package a.i.b.a.c.d.a.a;

import a.i.b.a.c.b.au;
import a.i.b.a.c.b.b;
import a.i.b.a.c.b.d;
import a.i.b.a.c.b.e;
import a.i.b.a.c.f.f;
import a.i.b.a.c.i.h;
import a.i.b.a.c.i.j;
import a.i.b.a.c.j.a.m;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.LinkedHashSet;

public final class a {
    public static <D extends b> Collection<D> a(Collection<D> collection, Collection<D> collection2, e eVar, m mVar) {
        AppMethodBeat.i(119747);
        Collection a = a(collection, collection2, eVar, mVar, false);
        AppMethodBeat.o(119747);
        return a;
    }

    public static <D extends b> Collection<D> b(Collection<D> collection, Collection<D> collection2, e eVar, m mVar) {
        AppMethodBeat.i(119748);
        Collection a = a(collection, collection2, eVar, mVar, true);
        AppMethodBeat.o(119748);
        return a;
    }

    private static <D extends b> Collection<D> a(Collection<D> collection, Collection<D> collection2, e eVar, final m mVar, final boolean z) {
        AppMethodBeat.i(119749);
        final LinkedHashSet linkedHashSet = new LinkedHashSet();
        j.a((Collection) collection, (Collection) collection2, eVar, new h() {
            public final void g(b bVar) {
                AppMethodBeat.i(119745);
                j.a(bVar, new a.f.a.b<b, y>() {
                    public final /* synthetic */ Object am(Object obj) {
                        AppMethodBeat.i(119744);
                        mVar.d((b) obj);
                        y yVar = y.AUy;
                        AppMethodBeat.o(119744);
                        return yVar;
                    }
                });
                linkedHashSet.add(bVar);
                AppMethodBeat.o(119745);
            }

            public final void a(b bVar, b bVar2) {
            }

            public final void a(b bVar, Collection<? extends b> collection) {
                AppMethodBeat.i(119746);
                if (!z || bVar.dYZ() == a.i.b.a.c.b.b.a.FAKE_OVERRIDE) {
                    super.a(bVar, collection);
                    AppMethodBeat.o(119746);
                    return;
                }
                AppMethodBeat.o(119746);
            }
        });
        AppMethodBeat.o(119749);
        return linkedHashSet;
    }

    public static au b(f fVar, e eVar) {
        AppMethodBeat.i(119750);
        Collection dYb = eVar.dYb();
        if (dYb.size() != 1) {
            AppMethodBeat.o(119750);
            return null;
        }
        for (au auVar : ((d) dYb.iterator().next()).dYV()) {
            if (auVar.dZg().equals(fVar)) {
                AppMethodBeat.o(119750);
                return auVar;
            }
        }
        AppMethodBeat.o(119750);
        return null;
    }
}
