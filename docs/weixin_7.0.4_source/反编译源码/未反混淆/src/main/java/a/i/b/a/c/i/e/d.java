package a.i.b.a.c.i.e;

import a.a.t;
import a.f.b.j;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class d {
    private static int BFA = 1;
    private static final int BFB = a.ejL();
    private static final int BFC = a.ejL();
    private static final int BFD = a.ejL();
    private static final int BFE = a.ejL();
    private static final int BFF = a.ejL();
    private static final int BFG = a.ejL();
    private static final int BFH = (a.ejL() - 1);
    private static final int BFI = ((BFB | BFC) | BFD);
    private static final int BFJ = ((BFC | BFF) | BFG);
    private static final int BFK = (BFF | BFG);
    public static final d BFL = new d(BFH);
    public static final d BFM = new d(BFK);
    public static final d BFN = new d(BFB);
    public static final d BFO = new d(BFC);
    public static final d BFP = new d(BFD);
    public static final d BFQ = new d(BFI);
    public static final d BFR = new d(BFE);
    public static final d BFS = new d(BFF);
    public static final d BFT = new d(BFG);
    public static final d BFU = new d(BFJ);
    private static final List<a> BFV;
    private static final List<a> BFW;
    public static final a BFX = new a();
    final int BFy;
    public final List<c> BFz;

    public static final class a {

        static final class a {
            final int mask;
            final String name;

            public a(int i, String str) {
                j.p(str, "name");
                AppMethodBeat.i(122178);
                this.mask = i;
                this.name = str;
                AppMethodBeat.o(122178);
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        static int ejL() {
            AppMethodBeat.i(122179);
            int ejC = d.BFA;
            d.BFA = d.BFA << 1;
            AppMethodBeat.o(122179);
            return ejC;
        }
    }

    public d(int i, List<? extends c> list) {
        j.p(list, "excludes");
        AppMethodBeat.i(122181);
        this.BFz = list;
        for (c ejB : this.BFz) {
            i &= ejB.ejB() ^ -1;
        }
        this.BFy = i;
        AppMethodBeat.o(122181);
    }

    public final boolean UI(int i) {
        return (this.BFy & i) != 0;
    }

    public final String toString() {
        Object obj;
        String str;
        AppMethodBeat.i(122180);
        for (Object next : BFV) {
            int i;
            if (((a) next).mask == this.BFy) {
                i = 1;
                continue;
            } else {
                i = 0;
                continue;
            }
            if (i != 0) {
                obj = next;
                break;
            }
        }
        CharSequence obj2 = null;
        a aVar = (a) obj2;
        if (aVar != null) {
            str = aVar.name;
        } else {
            str = null;
        }
        if (str == null) {
            Collection arrayList = new ArrayList();
            for (a aVar2 : BFW) {
                if (UI(aVar2.mask)) {
                    obj2 = aVar2.name;
                } else {
                    obj2 = null;
                }
                if (obj2 != null) {
                    arrayList.add(obj2);
                }
            }
            str = t.a((Iterable) (List) arrayList, (CharSequence) " | ", null, null, 0, null, null, 62);
        }
        str = "DescriptorKindFilter(" + str + ", " + this.BFz + ')';
        AppMethodBeat.o(122180);
        return str;
    }

    static {
        Object obj;
        Field field;
        int i;
        AppMethodBeat.i(122183);
        Field[] fields = d.class.getFields();
        j.o(fields, "T::class.java.fields");
        Collection arrayList = new ArrayList();
        for (Object obj2 : fields) {
            j.o(obj2, "it");
            if (Modifier.isStatic(obj2.getModifiers())) {
                arrayList.add(obj2);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (Field field2 : (List) arrayList) {
            Object aVar;
            obj = field2.get(null);
            if (!(obj instanceof d)) {
                obj = null;
            }
            d dVar = (d) obj;
            if (dVar != null) {
                i = dVar.BFy;
                j.o(field2, "field");
                String name = field2.getName();
                j.o(name, "field.name");
                aVar = new a(i, name);
            } else {
                aVar = null;
            }
            if (aVar != null) {
                arrayList2.add(aVar);
            }
        }
        BFV = t.m((List) arrayList2);
        fields = d.class.getFields();
        j.o(fields, "T::class.java.fields");
        arrayList = new ArrayList();
        for (Object obj22 : fields) {
            j.o(obj22, "it");
            if (Modifier.isStatic(obj22.getModifiers())) {
                arrayList.add(obj22);
            }
        }
        arrayList2 = new ArrayList();
        for (Object obj3 : (List) arrayList) {
            field2 = (Field) obj3;
            j.o(field2, "it");
            if (j.j(field2.getType(), Integer.TYPE)) {
                arrayList2.add(obj3);
            }
        }
        arrayList = new ArrayList();
        for (Field field3 : (List) arrayList2) {
            obj3 = field3.get(null);
            if (obj3 == null) {
                v vVar = new v("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(122183);
                throw vVar;
            }
            Object aVar2;
            int intValue = ((Integer) obj3).intValue();
            if (intValue == ((-intValue) & intValue)) {
                i = 1;
            } else {
                byte b = (byte) 0;
            }
            if (i != 0) {
                j.o(field3, "field");
                String name2 = field3.getName();
                j.o(name2, "field.name");
                aVar2 = new a(intValue, name2);
            } else {
                aVar2 = null;
            }
            if (aVar2 != null) {
                arrayList.add(aVar2);
            }
        }
        BFW = t.m((List) arrayList);
        AppMethodBeat.o(122183);
    }

    private /* synthetic */ d(int i) {
        this(i, a.a.v.AUP);
        AppMethodBeat.i(122182);
        AppMethodBeat.o(122182);
    }
}
