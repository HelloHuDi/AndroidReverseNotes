package p000a.p010i.p011b.p012a.p015c.p018b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p000a.p001a.C17115v;
import p000a.p001a.C25031ak;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p001a.C31585ab;
import p000a.p001a.C44629x;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p009h.C0016h;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0027a;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C31634ah;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C36959m;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C41405g;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h.C17288b;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p044k.C24619c;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;
import p000a.p010i.p011b.p012a.p015c.p045l.C17313an;
import p000a.p010i.p011b.p012a.p015c.p045l.C41453e;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.b.aa */
public final class C44870aa {
    final C25212i Baf;
    final C25093y BcH;
    final C24619c<C8174b, C36953ab> BeH = this.Baf.mo31371f(new C0031d(this));
    private final C24619c<C8046a, C46865e> BeI = this.Baf.mo31371f(new C8048c(this));

    /* renamed from: a.i.b.a.c.b.aa$d */
    static final class C0031d extends C25053k implements C17126b<C8174b, C36959m> {
        final /* synthetic */ C44870aa BeN;

        C0031d(C44870aa c44870aa) {
            this.BeN = c44870aa;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(119289);
            C8174b c8174b = (C8174b) obj;
            C25052j.m39376p(c8174b, "fqName");
            C36959m c36959m = new C36959m(this.BeN.BcH, c8174b);
            AppMethodBeat.m2505o(119289);
            return c36959m;
        }
    }

    /* renamed from: a.i.b.a.c.b.aa$a */
    static final class C8046a {
        final C8173a BcB;
        final List<Integer> BeJ;

        /* JADX WARNING: Missing block: B:7:0x0020, code skipped:
            if (p000a.p005f.p007b.C25052j.m39373j(r3.BeJ, r4.BeJ) != false) goto L_0x0022;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(119283);
            if (this != obj) {
                if (obj instanceof C8046a) {
                    C8046a c8046a = (C8046a) obj;
                    if (C25052j.m39373j(this.BcB, c8046a.BcB)) {
                    }
                }
                AppMethodBeat.m2505o(119283);
                return false;
            }
            AppMethodBeat.m2505o(119283);
            return true;
        }

        public final int hashCode() {
            int i = 0;
            AppMethodBeat.m2504i(119282);
            C8173a c8173a = this.BcB;
            int hashCode = (c8173a != null ? c8173a.hashCode() : 0) * 31;
            List list = this.BeJ;
            if (list != null) {
                i = list.hashCode();
            }
            hashCode += i;
            AppMethodBeat.m2505o(119282);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.m2504i(119281);
            String str = "ClassRequest(classId=" + this.BcB + ", typeParametersCount=" + this.BeJ + ")";
            AppMethodBeat.m2505o(119281);
            return str;
        }

        public C8046a(C8173a c8173a, List<Integer> list) {
            C25052j.m39376p(c8173a, "classId");
            C25052j.m39376p(list, "typeParametersCount");
            AppMethodBeat.m2504i(119280);
            this.BcB = c8173a;
            this.BeJ = list;
            AppMethodBeat.m2505o(119280);
        }
    }

    /* renamed from: a.i.b.a.c.b.aa$b */
    public static final class C8047b extends C41405g {
        private final List<C36955ar> BeK;
        private final C41453e BeL;
        private final boolean BeM;

        public C8047b(C25212i c25212i, C31642l c31642l, C37022f c37022f, boolean z, int i) {
            C25052j.m39376p(c25212i, "storageManager");
            C25052j.m39376p(c31642l, "container");
            C25052j.m39376p(c37022f, "name");
            super(c25212i, c31642l, c37022f, C41398am.BeR);
            AppMethodBeat.m2504i(119287);
            this.BeM = z;
            Iterable il = C0016h.m18il(0, i);
            Collection arrayList = new ArrayList(C25034m.m39318d(il));
            Iterator it = il.iterator();
            while (it.hasNext()) {
                int nextInt = ((C31585ab) it).nextInt();
                C31642l c31642l2 = this;
                C0027a c0027a = C0026g.BfJ;
                arrayList.add(C31634ah.m51154a(c31642l2, C0027a.eai(), C0163ba.INVARIANT, C37022f.avX("T".concat(String.valueOf(nextInt))), nextInt));
            }
            this.BeK = (List) arrayList;
            this.BeL = new C41453e(this, this.BeK, C25031ak.setOf(C41434a.m72274F(this).dZD().dXM()), c25212i);
            AppMethodBeat.m2505o(119287);
        }

        public final C36964f dYc() {
            return C36964f.CLASS;
        }

        public final C44879w dYd() {
            return C44879w.FINAL;
        }

        public final C25082az dYf() {
            AppMethodBeat.m2504i(119284);
            C25082az c25082az = C8051ay.Bfa;
            C25052j.m39375o(c25082az, "Visibilities.PUBLIC");
            AppMethodBeat.m2505o(119284);
            return c25082az;
        }

        public final List<C36955ar> dYq() {
            return this.BeK;
        }

        public final boolean dYh() {
            return this.BeM;
        }

        public final boolean dYg() {
            return false;
        }

        public final boolean dYi() {
            return false;
        }

        public final boolean dYj() {
            return false;
        }

        public final boolean dYk() {
            return false;
        }

        public final boolean dYl() {
            return false;
        }

        public final boolean dYm() {
            return false;
        }

        public final C0026g dYn() {
            AppMethodBeat.m2504i(119285);
            C0027a c0027a = C0026g.BfJ;
            C0026g eai = C0027a.eai();
            AppMethodBeat.m2505o(119285);
            return eai;
        }

        public final C36963d dYe() {
            return null;
        }

        public final C46865e dYa() {
            return null;
        }

        public final String toString() {
            AppMethodBeat.m2504i(119286);
            String str = "class " + this.BgZ + " (not found)";
            AppMethodBeat.m2505o(119286);
            return str;
        }

        public final /* bridge */ /* synthetic */ C17313an dXY() {
            return this.BeL;
        }

        public final /* bridge */ /* synthetic */ C31746h dXZ() {
            return C17288b.BGh;
        }

        public final /* bridge */ /* synthetic */ C31746h dXX() {
            return C17288b.BGh;
        }

        public final Collection<C36963d> dYb() {
            return C44629x.AUR;
        }

        public final Collection<C46865e> dYp() {
            return C17115v.AUP;
        }
    }

    /* renamed from: a.i.b.a.c.b.aa$c */
    static final class C8048c extends C25053k implements C17126b<C8046a, C8047b> {
        final /* synthetic */ C44870aa BeN;

        C8048c(C44870aa c44870aa) {
            this.BeN = c44870aa;
            super(1);
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x008b  */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x006c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(119288);
            C8046a c8046a = (C8046a) obj;
            C25052j.m39376p(c8046a, "<name for destructuring parameter 0>");
            C8173a c8173a = c8046a.BcB;
            List list = c8046a.BeJ;
            if (c8173a.ByO) {
                Throwable unsupportedOperationException = new UnsupportedOperationException("Unresolved local class: ".concat(String.valueOf(c8173a)));
                AppMethodBeat.m2505o(119288);
                throw unsupportedOperationException;
            }
            C44876g c44876g;
            boolean ehD;
            C25212i c25212i;
            C31642l c31642l;
            C37022f ehK;
            Integer num;
            int intValue;
            C8047b c8047b;
            C8173a ehC = c8173a.ehC();
            if (ehC != null) {
                C44870aa c44870aa = this.BeN;
                C25052j.m39375o(ehC, "outerClassId");
                C46865e a = c44870aa.mo72087a(ehC, C25035t.m39349j(list));
                if (a != null) {
                    c44876g = a;
                    ehD = c8173a.ehD();
                    c25212i = this.BeN.Baf;
                    c31642l = c44876g;
                    ehK = c8173a.ByN.ByQ.ehK();
                    C25052j.m39375o(ehK, "classId.shortClassName");
                    num = (Integer) C25035t.m39338fK(list);
                    if (num == null) {
                        intValue = num.intValue();
                    } else {
                        intValue = 0;
                    }
                    c8047b = new C8047b(c25212i, c31642l, ehK, ehD, intValue);
                    AppMethodBeat.m2505o(119288);
                    return c8047b;
                }
            }
            C24619c c24619c = this.BeN.BeH;
            C8174b c8174b = c8173a.BcW;
            C25052j.m39375o(c8174b, "classId.packageFqName");
            c44876g = (C44876g) c24619c.mo50am(c8174b);
            ehD = c8173a.ehD();
            c25212i = this.BeN.Baf;
            c31642l = c44876g;
            ehK = c8173a.ByN.ByQ.ehK();
            C25052j.m39375o(ehK, "classId.shortClassName");
            num = (Integer) C25035t.m39338fK(list);
            if (num == null) {
            }
            c8047b = new C8047b(c25212i, c31642l, ehK, ehD, intValue);
            AppMethodBeat.m2505o(119288);
            return c8047b;
        }
    }

    public C44870aa(C25212i c25212i, C25093y c25093y) {
        C25052j.m39376p(c25212i, "storageManager");
        C25052j.m39376p(c25093y, "module");
        AppMethodBeat.m2504i(119291);
        this.Baf = c25212i;
        this.BcH = c25093y;
        AppMethodBeat.m2505o(119291);
    }

    /* renamed from: a */
    public final C46865e mo72087a(C8173a c8173a, List<Integer> list) {
        AppMethodBeat.m2504i(119290);
        C25052j.m39376p(c8173a, "classId");
        C25052j.m39376p(list, "typeParametersCount");
        C46865e c46865e = (C46865e) this.BeI.mo50am(new C8046a(c8173a, list));
        AppMethodBeat.m2505o(119290);
        return c46865e;
    }
}
