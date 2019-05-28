package a.i.b.a.c.i;

import a.a.t;
import a.f.b.j;
import a.i.b.a.c.n.i;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.LinkedList;

public final class k {

    public static final class a extends a.f.b.k implements a.f.a.b<D, D> {
        public static final a BEE = new a();

        static {
            AppMethodBeat.i(122038);
            AppMethodBeat.o(122038);
        }

        a() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(122037);
            a.i.b.a.c.b.a aVar = (a.i.b.a.c.b.a) obj;
            j.p(aVar, "receiver$0");
            AppMethodBeat.o(122037);
            return aVar;
        }
    }

    static final class b extends a.f.b.k implements a.f.a.b<H, y> {
        final /* synthetic */ i BEF;

        b(i iVar) {
            this.BEF = iVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(122039);
            i iVar = this.BEF;
            j.o(obj, "it");
            iVar.add(obj);
            y yVar = y.AUy;
            AppMethodBeat.o(122039);
            return yVar;
        }
    }

    public static final <H> Collection<H> b(Collection<? extends H> collection, a.f.a.b<? super H, ? extends a.i.b.a.c.b.a> bVar) {
        AppMethodBeat.i(122040);
        j.p(collection, "receiver$0");
        j.p(bVar, "descriptorByHandle");
        if (collection.size() <= 1) {
            AppMethodBeat.o(122040);
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        a.i.b.a.c.n.i.b bVar2 = i.BNv;
        i ekD = a.i.b.a.c.n.i.b.ekD();
        while (true) {
            if ((!((Collection) linkedList).isEmpty() ? 1 : null) != null) {
                Object fJ = t.fJ(linkedList);
                bVar2 = i.BNv;
                i ekD2 = a.i.b.a.c.n.i.b.ekD();
                Collection a = j.a(fJ, (Collection) linkedList, (a.f.a.b) bVar, (a.f.a.b) new b(ekD2));
                j.o(a, "OverridingUtil.extractMe…nflictedHandles.add(it) }");
                Object h;
                if (a.size() == 1 && ekD2.isEmpty()) {
                    h = t.h((Iterable) a);
                    j.o(h, "overridableGroup.single()");
                    ekD.add(h);
                } else {
                    fJ = j.a(a, (a.f.a.b) bVar);
                    j.o(fJ, "OverridingUtil.selectMos…roup, descriptorByHandle)");
                    a.i.b.a.c.b.a aVar = (a.i.b.a.c.b.a) bVar.am(fJ);
                    for (Object next : a) {
                        j.o(next, "it");
                        if (!j.f(aVar, (a.i.b.a.c.b.a) bVar.am(next))) {
                            ekD2.add(next);
                        }
                    }
                    if (ekD2.isEmpty()) {
                        h = null;
                    } else {
                        h = 1;
                    }
                    if (h != null) {
                        ekD.addAll(ekD2);
                    }
                    ekD.add(fJ);
                }
            } else {
                Collection<H> collection2 = ekD;
                AppMethodBeat.o(122040);
                return collection2;
            }
        }
    }
}
