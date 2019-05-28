package a.i.b.a.c.d.a;

import a.a.ag;
import a.a.m;
import a.f.a.b;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.a.g;
import a.i.b.a.c.b.al;
import a.i.b.a.c.b.l;
import a.i.b.a.c.d.b.r;
import a.i.b.a.c.d.b.t;
import a.i.b.a.c.f.f;
import a.o;
import a.u;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class c {
    private static final r Bkt;
    private static final Map<r, f> Bku;
    private static final Map<String, f> Bkv;
    private static final List<f> Bkw;
    private static final Map<f, List<f>> Bkx;
    public static final c Bky = new c();

    static final class a extends k implements b<a.i.b.a.c.b.b, Boolean> {
        final /* synthetic */ al Bkz;

        a(al alVar) {
            this.Bkz = alVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119659);
            j.p((a.i.b.a.c.b.b) obj, "it");
            c cVar = c.Bky;
            Map eaV = c.Bkv;
            String c = r.c(this.Bkz);
            if (eaV == null) {
                v vVar = new v("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                AppMethodBeat.o(119659);
                throw vVar;
            }
            Boolean valueOf = Boolean.valueOf(eaV.containsKey(c));
            AppMethodBeat.o(119659);
            return valueOf;
        }
    }

    static {
        AppMethodBeat.i(119665);
        String str = a.i.b.a.c.i.d.c.INT.desc;
        j.o(str, "JvmPrimitiveType.INT.desc");
        Bkt = t.v("java/util/List", "removeAt", str, "Ljava/lang/Object;");
        t tVar = t.BrJ;
        o[] oVarArr = new o[8];
        String str2 = a.i.b.a.c.i.d.c.BYTE.desc;
        j.o(str2, "JvmPrimitiveType.BYTE.desc");
        oVarArr[0] = u.I(t.v(t.avQ("Number"), "toByte", "", str2), f.avX("byteValue"));
        str2 = a.i.b.a.c.i.d.c.SHORT.desc;
        j.o(str2, "JvmPrimitiveType.SHORT.desc");
        oVarArr[1] = u.I(t.v(t.avQ("Number"), "toShort", "", str2), f.avX("shortValue"));
        str2 = a.i.b.a.c.i.d.c.INT.desc;
        j.o(str2, "JvmPrimitiveType.INT.desc");
        oVarArr[2] = u.I(t.v(t.avQ("Number"), "toInt", "", str2), f.avX("intValue"));
        str2 = a.i.b.a.c.i.d.c.LONG.desc;
        j.o(str2, "JvmPrimitiveType.LONG.desc");
        oVarArr[3] = u.I(t.v(t.avQ("Number"), "toLong", "", str2), f.avX("longValue"));
        str2 = a.i.b.a.c.i.d.c.FLOAT.desc;
        j.o(str2, "JvmPrimitiveType.FLOAT.desc");
        oVarArr[4] = u.I(t.v(t.avQ("Number"), "toFloat", "", str2), f.avX("floatValue"));
        str2 = a.i.b.a.c.i.d.c.DOUBLE.desc;
        j.o(str2, "JvmPrimitiveType.DOUBLE.desc");
        oVarArr[5] = u.I(t.v(t.avQ("Number"), "toDouble", "", str2), f.avX("doubleValue"));
        oVarArr[6] = u.I(Bkt, f.avX("remove"));
        String str3 = a.i.b.a.c.i.d.c.INT.desc;
        j.o(str3, "JvmPrimitiveType.INT.desc");
        str2 = a.i.b.a.c.i.d.c.CHAR.desc;
        j.o(str2, "JvmPrimitiveType.CHAR.desc");
        oVarArr[7] = u.I(t.v(t.avQ("CharSequence"), "get", str3, str2), f.avX("charAt"));
        Map a = ag.a(oVarArr);
        Bku = a;
        Map linkedHashMap = new LinkedHashMap(ag.SI(a.size()));
        for (Object next : a.entrySet()) {
            linkedHashMap.put(((r) ((Entry) next).getKey()).signature, ((Entry) next).getValue());
        }
        Bkv = linkedHashMap;
        Iterable<r> keySet = Bku.keySet();
        Collection arrayList = new ArrayList(m.d(keySet));
        for (r rVar : keySet) {
            arrayList.add(rVar.BgZ);
        }
        Bkw = (List) arrayList;
        Iterable<Entry> entrySet = Bku.entrySet();
        arrayList = new ArrayList(m.d(entrySet));
        for (Entry entry : entrySet) {
            arrayList.add(new o(((r) entry.getKey()).BgZ, entry.getValue()));
        }
        linkedHashMap = new LinkedHashMap();
        for (Object next2 : (List) arrayList) {
            f fVar = (f) ((o) next2).second;
            ArrayList arrayList2 = linkedHashMap.get(fVar);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(fVar, arrayList2);
            }
            arrayList2.add((f) ((o) next2).first);
        }
        Bkx = linkedHashMap;
        AppMethodBeat.o(119665);
    }

    private c() {
    }

    public static List<f> eaU() {
        return Bkw;
    }

    public static boolean f(f fVar) {
        AppMethodBeat.i(119660);
        j.p(fVar, "receiver$0");
        boolean contains = Bkw.contains(fVar);
        AppMethodBeat.o(119660);
        return contains;
    }

    public static f a(al alVar) {
        AppMethodBeat.i(119661);
        j.p(alVar, "functionDescriptor");
        Map map = Bkv;
        String c = r.c(alVar);
        if (c == null) {
            AppMethodBeat.o(119661);
            return null;
        }
        f fVar = (f) map.get(c);
        AppMethodBeat.o(119661);
        return fVar;
    }

    public static boolean b(al alVar) {
        AppMethodBeat.i(119662);
        j.p(alVar, "functionDescriptor");
        if (!g.b((l) alVar) || a.i.b.a.c.i.c.a.b(alVar, new a(alVar)) == null) {
            AppMethodBeat.o(119662);
            return false;
        }
        AppMethodBeat.o(119662);
        return true;
    }

    public static List<f> g(f fVar) {
        AppMethodBeat.i(119663);
        j.p(fVar, "name");
        List<f> list = (List) Bkx.get(fVar);
        if (list == null) {
            list = a.a.v.AUP;
        }
        AppMethodBeat.o(119663);
        return list;
    }

    public static boolean c(al alVar) {
        AppMethodBeat.i(119664);
        j.p(alVar, "receiver$0");
        if (j.j(alVar.dZg().name, "removeAt") && j.j(r.c(alVar), Bkt.signature)) {
            AppMethodBeat.o(119664);
            return true;
        }
        AppMethodBeat.o(119664);
        return false;
    }
}
