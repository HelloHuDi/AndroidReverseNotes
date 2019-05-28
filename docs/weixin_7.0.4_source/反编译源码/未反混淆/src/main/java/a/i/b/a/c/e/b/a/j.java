package a.i.b.a.c.e.b.a;

import a.a.l;
import a.a.m;
import a.a.t;
import a.i.b.a.c.e.a;
import a.i.b.a.c.e.a.aa;
import a.i.b.a.c.e.a.ai;
import a.i.b.a.c.e.a.c;
import a.i.b.a.c.e.a.e;
import a.i.b.a.c.e.a.h;
import a.i.b.a.c.e.a.s;
import a.i.b.a.c.e.a.u;
import a.i.b.a.c.e.b.b;
import a.i.b.a.c.g.g;
import a.i.b.a.c.g.i;
import a.i.b.a.c.g.i.f;
import a.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class j {
    private static final g ByC;
    public static final j ByD = new j();

    static {
        AppMethodBeat.i(121338);
        g eie = g.eie();
        b.a(eie);
        a.f.b.j.o(eie, "ExtensionRegistryLite.ne…f::registerAllExtensions)");
        ByC = eie;
        AppMethodBeat.o(121338);
    }

    private j() {
    }

    public static g ehz() {
        return ByC;
    }

    public static final o<h, c> d(String[] strArr, String[] strArr2) {
        AppMethodBeat.i(121328);
        a.f.b.j.p(strArr, "data");
        a.f.b.j.p(strArr2, "strings");
        byte[] af = b.af(strArr);
        a.f.b.j.o(af, "BitEncoding.decodeBytes(data)");
        a.f.b.j.p(af, "bytes");
        a.f.b.j.p(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(af);
        o oVar = new o(a(byteArrayInputStream, strArr2), c.a((InputStream) byteArrayInputStream, ByC));
        AppMethodBeat.o(121328);
        return oVar;
    }

    public static final o<h, s> e(String[] strArr, String[] strArr2) {
        AppMethodBeat.i(121329);
        a.f.b.j.p(strArr, "data");
        a.f.b.j.p(strArr2, "strings");
        byte[] af = b.af(strArr);
        a.f.b.j.o(af, "BitEncoding.decodeBytes(data)");
        a.f.b.j.p(af, "bytes");
        a.f.b.j.p(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(af);
        o oVar = new o(a(byteArrayInputStream, strArr2), s.c((InputStream) byteArrayInputStream, ByC));
        AppMethodBeat.o(121329);
        return oVar;
    }

    public static final o<h, a.o> f(String[] strArr, String[] strArr2) {
        AppMethodBeat.i(121330);
        a.f.b.j.p(strArr, "data");
        a.f.b.j.p(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(b.af(strArr));
        o oVar = new o(a(byteArrayInputStream, strArr2), a.o.b((InputStream) byteArrayInputStream, ByC));
        AppMethodBeat.o(121330);
        return oVar;
    }

    private static h a(InputStream inputStream, String[] strArr) {
        AppMethodBeat.i(121331);
        b.g e = b.g.e(inputStream, ByC);
        a.f.b.j.o(e, "JvmProtoBuf.StringTableT…this, EXTENSION_REGISTRY)");
        h hVar = new h(e, strArr);
        AppMethodBeat.o(121331);
        return hVar;
    }

    public static f.b a(a.o oVar, a.i.b.a.c.e.a.c cVar, h hVar) {
        int i;
        String b;
        AppMethodBeat.i(121332);
        a.f.b.j.p(oVar, "proto");
        a.f.b.j.p(cVar, "nameResolver");
        a.f.b.j.p(hVar, "typeTable");
        i.c cVar2 = oVar;
        f fVar = b.BxA;
        a.f.b.j.o(fVar, "JvmProtoBuf.methodSignature");
        b.c cVar3 = (b.c) a.i.b.a.c.e.a.f.a(cVar2, fVar);
        if (cVar3 == null || !cVar3.edW()) {
            i = oVar.Buf;
        } else {
            i = cVar3.Buf;
        }
        if (cVar3 == null || !cVar3.egL()) {
            Collection dm = l.dm(a.i.b.a.c.e.a.g.b(oVar, hVar));
            List list = oVar.BtO;
            a.f.b.j.o(list, "proto.valueParameterList");
            Iterable<ai> iterable = list;
            Collection arrayList = new ArrayList(m.d(iterable));
            for (ai aiVar : iterable) {
                a.f.b.j.o(aiVar, "it");
                arrayList.add(a.i.b.a.c.e.a.g.a(aiVar, hVar));
            }
            Iterable<aa> b2 = t.b(dm, (Iterable) (List) arrayList);
            Collection arrayList2 = new ArrayList(m.d(b2));
            for (aa b3 : b2) {
                b = b(b3, cVar);
                if (b == null) {
                    AppMethodBeat.o(121332);
                    return null;
                }
                arrayList2.add(b);
            }
            list = (List) arrayList2;
            String b4 = b(a.i.b.a.c.e.a.g.a(oVar, hVar), cVar);
            if (b4 == null) {
                AppMethodBeat.o(121332);
                return null;
            }
            b = t.a((Iterable) list, (CharSequence) "", (CharSequence) "(", (CharSequence) ")", 0, null, null, 56) + b4;
        } else {
            b = cVar.getString(cVar3.BxN);
        }
        f.b bVar = new f.b(cVar.getString(i), b);
        AppMethodBeat.o(121332);
        return bVar;
    }

    public static f.b a(e eVar, a.i.b.a.c.e.a.c cVar, h hVar) {
        String str;
        String b;
        AppMethodBeat.i(121333);
        a.f.b.j.p(eVar, "proto");
        a.f.b.j.p(cVar, "nameResolver");
        a.f.b.j.p(hVar, "typeTable");
        i.c cVar2 = eVar;
        f fVar = b.Bxz;
        a.f.b.j.o(fVar, "JvmProtoBuf.constructorSignature");
        b.c cVar3 = (b.c) a.i.b.a.c.e.a.f.a(cVar2, fVar);
        if (cVar3 == null || !cVar3.edW()) {
            str = "<init>";
        } else {
            str = cVar.getString(cVar3.Buf);
        }
        if (cVar3 == null || !cVar3.egL()) {
            List list = eVar.BtO;
            a.f.b.j.o(list, "proto.valueParameterList");
            Iterable<ai> iterable = list;
            Collection arrayList = new ArrayList(m.d(iterable));
            for (ai aiVar : iterable) {
                a.f.b.j.o(aiVar, "it");
                b = b(a.i.b.a.c.e.a.g.a(aiVar, hVar), cVar);
                if (b == null) {
                    AppMethodBeat.o(121333);
                    return null;
                }
                arrayList.add(b);
            }
            b = t.a((Iterable) (List) arrayList, (CharSequence) "", (CharSequence) "(", (CharSequence) ")V", 0, null, null, 56);
        } else {
            b = cVar.getString(cVar3.BxN);
        }
        f.b bVar = new f.b(str, b);
        AppMethodBeat.o(121333);
        return bVar;
    }

    public static f.a a(u uVar, a.i.b.a.c.e.a.c cVar, h hVar, boolean z) {
        AppMethodBeat.i(121334);
        a.f.b.j.p(uVar, "proto");
        a.f.b.j.p(cVar, "nameResolver");
        a.f.b.j.p(hVar, "typeTable");
        i.c cVar2 = uVar;
        f fVar = b.BxC;
        a.f.b.j.o(fVar, "JvmProtoBuf.propertySignature");
        b.e eVar = (b.e) a.i.b.a.c.e.a.f.a(cVar2, fVar);
        if (eVar == null) {
            AppMethodBeat.o(121334);
            return null;
        }
        b.a aVar;
        if (eVar.egW()) {
            aVar = eVar.BxQ;
        } else {
            aVar = null;
        }
        if (aVar == null && z) {
            AppMethodBeat.o(121334);
            return null;
        }
        int i;
        String b;
        if (aVar == null || !aVar.edW()) {
            i = uVar.Buf;
        } else {
            i = aVar.Buf;
        }
        if (aVar == null || !aVar.egL()) {
            b = b(a.i.b.a.c.e.a.g.a(uVar, hVar), cVar);
            if (b == null) {
                AppMethodBeat.o(121334);
                return null;
            }
        }
        b = cVar.getString(aVar.BxN);
        f.a aVar2 = new f.a(cVar.getString(i), b);
        AppMethodBeat.o(121334);
        return aVar2;
    }

    private static String b(aa aaVar, a.i.b.a.c.e.a.c cVar) {
        AppMethodBeat.i(121336);
        if (aaVar.efc()) {
            String avV = c.avV(cVar.Uh(aaVar.Bve));
            AppMethodBeat.o(121336);
            return avV;
        }
        AppMethodBeat.o(121336);
        return null;
    }

    public static final boolean f(u uVar) {
        AppMethodBeat.i(121337);
        a.f.b.j.p(uVar, "proto");
        e eVar = e.Bys;
        a.i.b.a.c.e.a.b.a ehw = e.ehw();
        Object e = uVar.e(b.BxD);
        a.f.b.j.o(e, "proto.getExtension(JvmProtoBuf.flags)");
        Boolean Ug = ehw.Ug(((Number) e).intValue());
        a.f.b.j.o(Ug, "JvmFlags.IS_MOVED_FROM_I…nsion(JvmProtoBuf.flags))");
        boolean booleanValue = Ug.booleanValue();
        AppMethodBeat.o(121337);
        return booleanValue;
    }
}
