package a.i.b.a.c.d.a;

import a.a.ag;
import a.a.m;
import a.a.t;
import a.a.v;
import a.aa;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.a.g;
import a.i.b.a.c.b.l;
import a.i.b.a.c.f.b;
import a.i.b.a.c.f.c;
import a.i.b.a.c.f.f;
import a.o;
import a.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class e {
    private static final Map<b, f> BkV;
    private static final Map<f, List<f>> BkW;
    private static final Set<b> BkX;
    private static final Set<f> BkY;
    public static final e BkZ = new e();

    static final class a extends k implements a.f.a.b<a.i.b.a.c.b.b, Boolean> {
        public static final a Bla = new a();

        static {
            AppMethodBeat.i(119682);
            AppMethodBeat.o(119682);
        }

        a() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119681);
            a.i.b.a.c.b.b bVar = (a.i.b.a.c.b.b) obj;
            j.p(bVar, "it");
            e eVar = e.BkZ;
            Boolean valueOf = Boolean.valueOf(e.l(bVar));
            AppMethodBeat.o(119681);
            return valueOf;
        }
    }

    static {
        AppMethodBeat.i(119686);
        o[] oVarArr = new o[8];
        c cVar = g.Bag.BaD;
        j.o(cVar, "BUILTIN_NAMES._enum");
        oVarArr[0] = u.I(t.b(cVar, "name"), f.avX("name"));
        cVar = g.Bag.BaD;
        j.o(cVar, "BUILTIN_NAMES._enum");
        oVarArr[1] = u.I(t.b(cVar, "ordinal"), f.avX("ordinal"));
        b bVar = g.Bag.Bba;
        j.o(bVar, "BUILTIN_NAMES.collection");
        oVarArr[2] = u.I(t.a(bVar, "size"), f.avX("size"));
        bVar = g.Bag.Bbe;
        j.o(bVar, "BUILTIN_NAMES.map");
        oVarArr[3] = u.I(t.a(bVar, "size"), f.avX("size"));
        cVar = g.Bag.Bar;
        j.o(cVar, "BUILTIN_NAMES.charSequence");
        oVarArr[4] = u.I(t.b(cVar, "length"), f.avX("length"));
        bVar = g.Bag.Bbe;
        j.o(bVar, "BUILTIN_NAMES.map");
        oVarArr[5] = u.I(t.a(bVar, "keys"), f.avX("keySet"));
        bVar = g.Bag.Bbe;
        j.o(bVar, "BUILTIN_NAMES.map");
        oVarArr[6] = u.I(t.a(bVar, "values"), f.avX("values"));
        bVar = g.Bag.Bbe;
        j.o(bVar, "BUILTIN_NAMES.map");
        oVarArr[7] = u.I(t.a(bVar, "entries"), f.avX("entrySet"));
        Map a = ag.a(oVarArr);
        BkV = a;
        Iterable<Entry> entrySet = a.entrySet();
        Collection arrayList = new ArrayList(m.d(entrySet));
        for (Entry entry : entrySet) {
            arrayList.add(new o(((b) entry.getKey()).ByQ.ehK(), entry.getValue()));
        }
        a = new LinkedHashMap();
        for (Object next : (List) arrayList) {
            f fVar = (f) ((o) next).second;
            ArrayList arrayList2 = a.get(fVar);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                a.put(fVar, arrayList2);
            }
            arrayList2.add((f) ((o) next).first);
        }
        BkW = a;
        Set keySet = BkV.keySet();
        BkX = keySet;
        Iterable<b> iterable = keySet;
        arrayList = new ArrayList(m.d(iterable));
        for (b bVar2 : iterable) {
            arrayList.add(bVar2.ByQ.ehK());
        }
        BkY = t.o((List) arrayList);
        AppMethodBeat.o(119686);
    }

    private e() {
    }

    public static Set<f> eaW() {
        return BkY;
    }

    public static boolean l(a.i.b.a.c.b.b bVar) {
        AppMethodBeat.i(119683);
        j.p(bVar, "callableMemberDescriptor");
        if (!BkY.contains(bVar.dZg())) {
            AppMethodBeat.o(119683);
            return false;
        } else if (t.a((Iterable) BkX, (Object) a.i.b.a.c.i.c.a.I(bVar)) && bVar.dYV().isEmpty()) {
            AppMethodBeat.o(119683);
            return true;
        } else {
            if (g.b((l) bVar)) {
                Collection dYX = bVar.dYX();
                j.o(dYX, "overriddenDescriptors");
                Iterable<a.i.b.a.c.b.b> iterable = dYX;
                if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                    for (a.i.b.a.c.b.b bVar2 : iterable) {
                        j.o(bVar2, "it");
                        if (l(bVar2)) {
                            AppMethodBeat.o(119683);
                            return true;
                        }
                    }
                }
            }
            AppMethodBeat.o(119683);
            return false;
        }
    }

    public static List<f> i(f fVar) {
        AppMethodBeat.i(119684);
        j.p(fVar, "name1");
        List<f> list = (List) BkW.get(fVar);
        if (list == null) {
            list = v.AUP;
        }
        AppMethodBeat.o(119684);
        return list;
    }

    public static String m(a.i.b.a.c.b.b bVar) {
        AppMethodBeat.i(119685);
        j.p(bVar, "receiver$0");
        boolean b = g.b((l) bVar);
        if (!aa.AUz || b) {
            a.i.b.a.c.b.b b2 = a.i.b.a.c.i.c.a.b(a.i.b.a.c.i.c.a.x(bVar), a.Bla);
            if (b2 == null) {
                AppMethodBeat.o(119685);
                return null;
            }
            f fVar = (f) BkV.get(a.i.b.a.c.i.c.a.o(b2));
            if (fVar != null) {
                String str = fVar.name;
                AppMethodBeat.o(119685);
                return str;
            }
            AppMethodBeat.o(119685);
            return null;
        }
        Throwable assertionError = new AssertionError("This method is defined only for builtin members, but " + bVar + " found");
        AppMethodBeat.o(119685);
        throw assertionError;
    }
}
