package p000a.p010i.p011b.p012a.p015c.p016a.p774a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C44941v;
import p000a.p001a.C25035t;
import p000a.p001a.C44629x;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p016a.C8033c;
import p000a.p010i.p011b.p012a.p015c.p016a.p774a.C24607b.C8027b;
import p000a.p010i.p011b.p012a.p015c.p016a.p774a.C24607b.C8027b.C8028a;
import p000a.p010i.p011b.p012a.p015c.p018b.C25093y;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.p775b.C17160b;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;
import p000a.p051k.C31820v;
import p000a.p051k.C6163u;

/* renamed from: a.i.b.a.c.a.a.a */
public final class C24604a implements C17160b {
    public static final C24605a BcI = new C24605a();
    private final C25212i Baf;
    private final C25093y BcH;

    /* renamed from: a.i.b.a.c.a.a.a$a */
    public static final class C24605a {
        private C24605a() {
        }

        public /* synthetic */ C24605a(byte b) {
            this();
        }

        /* renamed from: a */
        static C24606b m38270a(String str, C8174b c8174b) {
            C8027b c8027b;
            AppMethodBeat.m2504i(119124);
            C8028a c8028a = C8027b.BcY;
            C25052j.m39376p(c8174b, "packageFqName");
            C25052j.m39376p(str, "className");
            for (C8027b c8027b2 : C8027b.values()) {
                Object obj;
                if (C25052j.m39373j(c8027b2.BcW, c8174b) && C6163u.m9839jb(str, c8027b2.BcX)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    c8027b = c8027b2;
                    break;
                }
            }
            c8027b = null;
            if (c8027b == null) {
                AppMethodBeat.m2505o(119124);
                return null;
            }
            int length = c8027b.BcX.length();
            if (str == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.m2505o(119124);
                throw c44941v;
            }
            Object obj2;
            Integer num;
            String substring = str.substring(length);
            C25052j.m39375o(substring, "(this as java.lang.String).substring(startIndex)");
            if (substring.length() == 0) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 != null) {
                num = null;
            } else {
                int length2 = substring.length();
                length = 0;
                int i = 0;
                while (length < length2) {
                    int charAt = substring.charAt(length) - 48;
                    if (charAt < 0 || 9 < charAt) {
                        num = null;
                        break;
                    }
                    length++;
                    i = charAt + (i * 10);
                }
                num = Integer.valueOf(i);
            }
            if (num != null) {
                C24606b c24606b = new C24606b(c8027b, num.intValue());
                AppMethodBeat.m2505o(119124);
                return c24606b;
            }
            AppMethodBeat.m2505o(119124);
            return null;
        }

        /* renamed from: b */
        public static C8027b m38271b(String str, C8174b c8174b) {
            AppMethodBeat.m2504i(119125);
            C25052j.m39376p(str, "className");
            C25052j.m39376p(c8174b, "packageFqName");
            C24606b a = C24605a.m38270a(str, c8174b);
            if (a != null) {
                C8027b c8027b = a.BcJ;
                AppMethodBeat.m2505o(119125);
                return c8027b;
            }
            AppMethodBeat.m2505o(119125);
            return null;
        }
    }

    /* renamed from: a.i.b.a.c.a.a.a$b */
    static final class C24606b {
        final int AVt;
        final C8027b BcJ;

        /* JADX WARNING: Missing block: B:9:0x0021, code skipped:
            if ((r5.AVt == r6.AVt) != false) goto L_0x0023;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(119129);
            if (this != obj) {
                if (obj instanceof C24606b) {
                    C24606b c24606b = (C24606b) obj;
                    if (C25052j.m39373j(this.BcJ, c24606b.BcJ)) {
                    }
                }
                AppMethodBeat.m2505o(119129);
                return false;
            }
            AppMethodBeat.m2505o(119129);
            return true;
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(119128);
            C8027b c8027b = this.BcJ;
            int hashCode = ((c8027b != null ? c8027b.hashCode() : 0) * 31) + this.AVt;
            AppMethodBeat.m2505o(119128);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.m2504i(119127);
            String str = "KindWithArity(kind=" + this.BcJ + ", arity=" + this.AVt + ")";
            AppMethodBeat.m2505o(119127);
            return str;
        }

        public C24606b(C8027b c8027b, int i) {
            C25052j.m39376p(c8027b, "kind");
            AppMethodBeat.m2504i(119126);
            this.BcJ = c8027b;
            this.AVt = i;
            AppMethodBeat.m2505o(119126);
        }
    }

    static {
        AppMethodBeat.m2504i(119134);
        AppMethodBeat.m2505o(119134);
    }

    public C24604a(C25212i c25212i, C25093y c25093y) {
        C25052j.m39376p(c25212i, "storageManager");
        C25052j.m39376p(c25093y, "module");
        AppMethodBeat.m2504i(119133);
        this.Baf = c25212i;
        this.BcH = c25093y;
        AppMethodBeat.m2505o(119133);
    }

    /* renamed from: a */
    public final boolean mo31259a(C8174b c8174b, C37022f c37022f) {
        AppMethodBeat.m2504i(119130);
        C25052j.m39376p(c8174b, "packageFqName");
        C25052j.m39376p(c37022f, "name");
        String str = c37022f.name;
        C25052j.m39375o(str, "name.asString()");
        if ((C6163u.m9839jb(str, "Function") || C6163u.m9839jb(str, "KFunction") || C6163u.m9839jb(str, "SuspendFunction") || C6163u.m9839jb(str, "KSuspendFunction")) && C24605a.m38270a(str, c8174b) != null) {
            AppMethodBeat.m2505o(119130);
            return true;
        }
        AppMethodBeat.m2505o(119130);
        return false;
    }

    /* renamed from: e */
    public final C46865e mo31261e(C8173a c8173a) {
        AppMethodBeat.m2504i(119131);
        C25052j.m39376p(c8173a, "classId");
        if (c8173a.ByO || c8173a.ehD()) {
            AppMethodBeat.m2505o(119131);
            return null;
        }
        String str = c8173a.ByN.ByQ.ByV;
        C25052j.m39375o(str, "classId.relativeClassName.asString()");
        if (C31820v.m51526a((CharSequence) str, (CharSequence) "Function", false)) {
            C8174b c8174b = c8173a.BcW;
            C25052j.m39375o(c8174b, "classId.packageFqName");
            C24606b a = C24605a.m38270a(str, c8174b);
            if (a == null) {
                AppMethodBeat.m2505o(119131);
                return null;
            }
            C8027b c8027b = a.BcJ;
            int i = a.AVt;
            Collection arrayList = new ArrayList();
            for (Object next : this.BcH.mo252g(c8174b).getFragments()) {
                if (next instanceof C8033c) {
                    arrayList.add(next);
                }
            }
            C46865e c24607b = new C24607b(this.Baf, (C8033c) C25035t.m39337fJ((List) arrayList), c8027b, i);
            AppMethodBeat.m2505o(119131);
            return c24607b;
        }
        AppMethodBeat.m2505o(119131);
        return null;
    }

    /* renamed from: d */
    public final Collection<C46865e> mo31260d(C8174b c8174b) {
        AppMethodBeat.m2504i(119132);
        C25052j.m39376p(c8174b, "packageFqName");
        Collection collection = C44629x.AUR;
        AppMethodBeat.m2505o(119132);
        return collection;
    }
}
