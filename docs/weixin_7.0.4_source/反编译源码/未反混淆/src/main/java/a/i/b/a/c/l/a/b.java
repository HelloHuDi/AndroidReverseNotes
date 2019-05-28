package a.i.b.a.c.l.a;

import a.a.m;
import a.a.t;
import a.f.b.j;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.az;
import a.i.b.a.c.l.n;
import a.i.b.a.c.l.p;
import a.i.b.a.c.l.q;
import a.i.b.a.c.l.x;
import a.i.b.a.c.l.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class b {
    public static final az gb(List<? extends az> list) {
        AppMethodBeat.i(122714);
        j.p(list, "types");
        az azVar;
        switch (list.size()) {
            case 0:
                Throwable illegalStateException = new IllegalStateException("Expected some types".toString());
                AppMethodBeat.o(122714);
                throw illegalStateException;
            case 1:
                azVar = (az) t.fN(list);
                AppMethodBeat.o(122714);
                return azVar;
            default:
                Iterable<az> iterable = list;
                Collection arrayList = new ArrayList(m.d(iterable));
                Object obj = null;
                Object obj2 = null;
                for (az azVar2 : iterable) {
                    Object obj3;
                    Object obj4 = (obj != null || y.an(azVar2)) ? 1 : null;
                    if (azVar2 instanceof ad) {
                        obj3 = (ad) azVar2;
                    } else if (!(azVar2 instanceof q)) {
                        a.m mVar = new a.m();
                        AppMethodBeat.o(122714);
                        throw mVar;
                    } else if (n.ag(azVar2)) {
                        AppMethodBeat.o(122714);
                        return azVar2;
                    } else {
                        obj3 = ((q) azVar2).BJx;
                        int obj22 = 1;
                    }
                    arrayList.add(obj3);
                    obj = obj4;
                }
                List list2 = (List) arrayList;
                if (obj != null) {
                    ad awn = p.awn("Intersection of error types: ".concat(String.valueOf(list)));
                    j.o(awn, "ErrorUtils.createErrorTy… of error types: $types\")");
                    azVar2 = awn;
                    AppMethodBeat.o(122714);
                    return azVar2;
                } else if (obj22 == null) {
                    s sVar = s.BLd;
                    azVar2 = s.gc(list2);
                    AppMethodBeat.o(122714);
                    return azVar2;
                } else {
                    Iterable<az> iterable2 = list;
                    Collection arrayList2 = new ArrayList(m.d(iterable2));
                    for (az al : iterable2) {
                        arrayList2.add(a.i.b.a.c.l.t.al(al));
                    }
                    List list3 = (List) arrayList2;
                    s sVar2 = s.BLd;
                    ad gc = s.gc(list2);
                    sVar2 = s.BLd;
                    azVar2 = x.a(gc, s.gc(list3));
                    AppMethodBeat.o(122714);
                    return azVar2;
                }
        }
    }
}
