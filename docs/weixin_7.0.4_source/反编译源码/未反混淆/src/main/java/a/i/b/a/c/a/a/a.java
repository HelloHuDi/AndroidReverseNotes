package a.i.b.a.c.a.a;

import a.a.t;
import a.a.x;
import a.f.b.j;
import a.i.b.a.c.a.c;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.y;
import a.i.b.a.c.f.f;
import a.i.b.a.c.k.i;
import a.k.u;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class a implements a.i.b.a.c.b.b.b {
    public static final a BcI = new a();
    private final i Baf;
    private final y BcH;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        static b a(String str, a.i.b.a.c.f.b bVar) {
            a.i.b.a.c.a.a.b.b bVar2;
            AppMethodBeat.i(119124);
            a.i.b.a.c.a.a.b.b.a aVar = a.i.b.a.c.a.a.b.b.BcY;
            j.p(bVar, "packageFqName");
            j.p(str, "className");
            for (a.i.b.a.c.a.a.b.b bVar3 : a.i.b.a.c.a.a.b.b.values()) {
                Object obj;
                if (j.j(bVar3.BcW, bVar) && u.jb(str, bVar3.BcX)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    bVar2 = bVar3;
                    break;
                }
            }
            bVar2 = null;
            if (bVar2 == null) {
                AppMethodBeat.o(119124);
                return null;
            }
            int length = bVar2.BcX.length();
            if (str == null) {
                v vVar = new v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(119124);
                throw vVar;
            }
            Object obj2;
            Integer num;
            String substring = str.substring(length);
            j.o(substring, "(this as java.lang.String).substring(startIndex)");
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
                b bVar4 = new b(bVar2, num.intValue());
                AppMethodBeat.o(119124);
                return bVar4;
            }
            AppMethodBeat.o(119124);
            return null;
        }

        public static a.i.b.a.c.a.a.b.b b(String str, a.i.b.a.c.f.b bVar) {
            AppMethodBeat.i(119125);
            j.p(str, "className");
            j.p(bVar, "packageFqName");
            b a = a(str, bVar);
            if (a != null) {
                a.i.b.a.c.a.a.b.b bVar2 = a.BcJ;
                AppMethodBeat.o(119125);
                return bVar2;
            }
            AppMethodBeat.o(119125);
            return null;
        }
    }

    static final class b {
        final int AVt;
        final a.i.b.a.c.a.a.b.b BcJ;

        /* JADX WARNING: Missing block: B:9:0x0021, code skipped:
            if ((r5.AVt == r6.AVt) != false) goto L_0x0023;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(Object obj) {
            AppMethodBeat.i(119129);
            if (this != obj) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (j.j(this.BcJ, bVar.BcJ)) {
                    }
                }
                AppMethodBeat.o(119129);
                return false;
            }
            AppMethodBeat.o(119129);
            return true;
        }

        public final int hashCode() {
            AppMethodBeat.i(119128);
            a.i.b.a.c.a.a.b.b bVar = this.BcJ;
            int hashCode = ((bVar != null ? bVar.hashCode() : 0) * 31) + this.AVt;
            AppMethodBeat.o(119128);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(119127);
            String str = "KindWithArity(kind=" + this.BcJ + ", arity=" + this.AVt + ")";
            AppMethodBeat.o(119127);
            return str;
        }

        public b(a.i.b.a.c.a.a.b.b bVar, int i) {
            j.p(bVar, "kind");
            AppMethodBeat.i(119126);
            this.BcJ = bVar;
            this.AVt = i;
            AppMethodBeat.o(119126);
        }
    }

    static {
        AppMethodBeat.i(119134);
        AppMethodBeat.o(119134);
    }

    public a(i iVar, y yVar) {
        j.p(iVar, "storageManager");
        j.p(yVar, "module");
        AppMethodBeat.i(119133);
        this.Baf = iVar;
        this.BcH = yVar;
        AppMethodBeat.o(119133);
    }

    public final boolean a(a.i.b.a.c.f.b bVar, f fVar) {
        AppMethodBeat.i(119130);
        j.p(bVar, "packageFqName");
        j.p(fVar, "name");
        String str = fVar.name;
        j.o(str, "name.asString()");
        if ((u.jb(str, "Function") || u.jb(str, "KFunction") || u.jb(str, "SuspendFunction") || u.jb(str, "KSuspendFunction")) && a.a(str, bVar) != null) {
            AppMethodBeat.o(119130);
            return true;
        }
        AppMethodBeat.o(119130);
        return false;
    }

    public final e e(a.i.b.a.c.f.a aVar) {
        AppMethodBeat.i(119131);
        j.p(aVar, "classId");
        if (aVar.ByO || aVar.ehD()) {
            AppMethodBeat.o(119131);
            return null;
        }
        String str = aVar.ByN.ByQ.ByV;
        j.o(str, "classId.relativeClassName.asString()");
        if (a.k.v.a((CharSequence) str, (CharSequence) "Function", false)) {
            a.i.b.a.c.f.b bVar = aVar.BcW;
            j.o(bVar, "classId.packageFqName");
            b a = a.a(str, bVar);
            if (a == null) {
                AppMethodBeat.o(119131);
                return null;
            }
            a.i.b.a.c.a.a.b.b bVar2 = a.BcJ;
            int i = a.AVt;
            Collection arrayList = new ArrayList();
            for (Object next : this.BcH.g(bVar).getFragments()) {
                if (next instanceof c) {
                    arrayList.add(next);
                }
            }
            e bVar3 = new b(this.Baf, (c) t.fJ((List) arrayList), bVar2, i);
            AppMethodBeat.o(119131);
            return bVar3;
        }
        AppMethodBeat.o(119131);
        return null;
    }

    public final Collection<e> d(a.i.b.a.c.f.b bVar) {
        AppMethodBeat.i(119132);
        j.p(bVar, "packageFqName");
        Collection collection = x.AUR;
        AppMethodBeat.o(119132);
        return collection;
    }
}
