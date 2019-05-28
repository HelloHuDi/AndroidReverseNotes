package p000a.p010i.p011b.p012a.p015c.p037i.p039e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C44941v;
import p000a.p001a.C17115v;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;

/* renamed from: a.i.b.a.c.i.e.d */
public final class C0136d {
    private static int BFA = 1;
    private static final int BFB = C0137a.ejL();
    private static final int BFC = C0137a.ejL();
    private static final int BFD = C0137a.ejL();
    private static final int BFE = C0137a.ejL();
    private static final int BFF = C0137a.ejL();
    private static final int BFG = C0137a.ejL();
    private static final int BFH = (C0137a.ejL() - 1);
    private static final int BFI = ((BFB | BFC) | BFD);
    private static final int BFJ = ((BFC | BFF) | BFG);
    private static final int BFK = (BFF | BFG);
    public static final C0136d BFL = new C0136d(BFH);
    public static final C0136d BFM = new C0136d(BFK);
    public static final C0136d BFN = new C0136d(BFB);
    public static final C0136d BFO = new C0136d(BFC);
    public static final C0136d BFP = new C0136d(BFD);
    public static final C0136d BFQ = new C0136d(BFI);
    public static final C0136d BFR = new C0136d(BFE);
    public static final C0136d BFS = new C0136d(BFF);
    public static final C0136d BFT = new C0136d(BFG);
    public static final C0136d BFU = new C0136d(BFJ);
    private static final List<C0138a> BFV;
    private static final List<C0138a> BFW;
    public static final C0137a BFX = new C0137a();
    final int BFy;
    public final List<C0133c> BFz;

    /* renamed from: a.i.b.a.c.i.e.d$a */
    public static final class C0137a {

        /* renamed from: a.i.b.a.c.i.e.d$a$a */
        static final class C0138a {
            final int mask;
            final String name;

            public C0138a(int i, String str) {
                C25052j.m39376p(str, "name");
                AppMethodBeat.m2504i(122178);
                this.mask = i;
                this.name = str;
                AppMethodBeat.m2505o(122178);
            }
        }

        private C0137a() {
        }

        public /* synthetic */ C0137a(byte b) {
            this();
        }

        static int ejL() {
            AppMethodBeat.m2504i(122179);
            int ejC = C0136d.BFA;
            C0136d.BFA = C0136d.BFA << 1;
            AppMethodBeat.m2505o(122179);
            return ejC;
        }
    }

    public C0136d(int i, List<? extends C0133c> list) {
        C25052j.m39376p(list, "excludes");
        AppMethodBeat.m2504i(122181);
        this.BFz = list;
        for (C0133c ejB : this.BFz) {
            i &= ejB.ejB() ^ -1;
        }
        this.BFy = i;
        AppMethodBeat.m2505o(122181);
    }

    /* renamed from: UI */
    public final boolean mo228UI(int i) {
        return (this.BFy & i) != 0;
    }

    public final String toString() {
        Object obj;
        String str;
        AppMethodBeat.m2504i(122180);
        for (Object next : BFV) {
            int i;
            if (((C0138a) next).mask == this.BFy) {
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
        C0138a c0138a = (C0138a) obj2;
        if (c0138a != null) {
            str = c0138a.name;
        } else {
            str = null;
        }
        if (str == null) {
            Collection arrayList = new ArrayList();
            for (C0138a c0138a2 : BFW) {
                if (mo228UI(c0138a2.mask)) {
                    obj2 = c0138a2.name;
                } else {
                    obj2 = null;
                }
                if (obj2 != null) {
                    arrayList.add(obj2);
                }
            }
            str = C25035t.m39322a((Iterable) (List) arrayList, (CharSequence) " | ", null, null, 0, null, null, 62);
        }
        str = "DescriptorKindFilter(" + str + ", " + this.BFz + ')';
        AppMethodBeat.m2505o(122180);
        return str;
    }

    static {
        Object obj;
        Field field;
        int i;
        AppMethodBeat.m2504i(122183);
        Field[] fields = C0136d.class.getFields();
        C25052j.m39375o(fields, "T::class.java.fields");
        Collection arrayList = new ArrayList();
        for (Object obj2 : fields) {
            C25052j.m39375o(obj2, "it");
            if (Modifier.isStatic(obj2.getModifiers())) {
                arrayList.add(obj2);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (Field field2 : (List) arrayList) {
            Object c0138a;
            obj = field2.get(null);
            if (!(obj instanceof C0136d)) {
                obj = null;
            }
            C0136d c0136d = (C0136d) obj;
            if (c0136d != null) {
                i = c0136d.BFy;
                C25052j.m39375o(field2, "field");
                String name = field2.getName();
                C25052j.m39375o(name, "field.name");
                c0138a = new C0138a(i, name);
            } else {
                c0138a = null;
            }
            if (c0138a != null) {
                arrayList2.add(c0138a);
            }
        }
        BFV = C25035t.m39352m((List) arrayList2);
        fields = C0136d.class.getFields();
        C25052j.m39375o(fields, "T::class.java.fields");
        arrayList = new ArrayList();
        for (Object obj22 : fields) {
            C25052j.m39375o(obj22, "it");
            if (Modifier.isStatic(obj22.getModifiers())) {
                arrayList.add(obj22);
            }
        }
        arrayList2 = new ArrayList();
        for (Object obj3 : (List) arrayList) {
            field2 = (Field) obj3;
            C25052j.m39375o(field2, "it");
            if (C25052j.m39373j(field2.getType(), Integer.TYPE)) {
                arrayList2.add(obj3);
            }
        }
        arrayList = new ArrayList();
        for (Field field3 : (List) arrayList2) {
            obj3 = field3.get(null);
            if (obj3 == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.m2505o(122183);
                throw c44941v;
            }
            Object c0138a2;
            int intValue = ((Integer) obj3).intValue();
            if (intValue == ((-intValue) & intValue)) {
                i = 1;
            } else {
                byte b = (byte) 0;
            }
            if (i != 0) {
                C25052j.m39375o(field3, "field");
                String name2 = field3.getName();
                C25052j.m39375o(name2, "field.name");
                c0138a2 = new C0138a(intValue, name2);
            } else {
                c0138a2 = null;
            }
            if (c0138a2 != null) {
                arrayList.add(c0138a2);
            }
        }
        BFW = C25035t.m39352m((List) arrayList);
        AppMethodBeat.m2505o(122183);
    }

    private /* synthetic */ C0136d(int i) {
        this(i, C17115v.AUP);
        AppMethodBeat.m2504i(122182);
        AppMethodBeat.m2505o(122182);
    }
}
