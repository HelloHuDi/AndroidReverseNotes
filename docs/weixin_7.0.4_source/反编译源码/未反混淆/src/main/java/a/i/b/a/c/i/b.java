package a.i.b.a.c.i;

import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.b.ab;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.h;
import a.i.b.a.c.b.l;
import a.i.b.a.c.l.an;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public static final b BDK = new b();

    static final class c extends k implements m<l, l, Boolean> {
        public static final c BDP = new c();

        static {
            AppMethodBeat.i(121922);
            AppMethodBeat.o(121922);
        }

        c() {
            super(2);
        }

        public final /* bridge */ /* synthetic */ Object m(Object obj, Object obj2) {
            return Boolean.FALSE;
        }
    }

    static final class b implements a.i.b.a.c.l.a.c.a {
        final /* synthetic */ a.i.b.a.c.b.a BDM;
        final /* synthetic */ a.i.b.a.c.b.a BDN;

        /* renamed from: a.i.b.a.c.i.b$b$1 */
        static final class AnonymousClass1 extends k implements m<l, l, Boolean> {
            final /* synthetic */ b BDO;

            AnonymousClass1(b bVar) {
                this.BDO = bVar;
                super(2);
            }

            public final /* synthetic */ Object m(Object obj, Object obj2) {
                boolean z;
                AppMethodBeat.i(121920);
                l lVar = (l) obj2;
                if (j.j((l) obj, this.BDO.BDM) && j.j(lVar, this.BDO.BDN)) {
                    z = true;
                } else {
                    z = false;
                }
                Boolean valueOf = Boolean.valueOf(z);
                AppMethodBeat.o(121920);
                return valueOf;
            }
        }

        b(a.i.b.a.c.b.a aVar, a.i.b.a.c.b.a aVar2) {
            this.BDM = aVar;
            this.BDN = aVar2;
        }

        public final /* synthetic */ boolean a(an anVar, an anVar2) {
            AppMethodBeat.i(121921);
            j.p(anVar, "c1");
            j.p(anVar2, "c2");
            if (j.j(anVar, anVar2)) {
                AppMethodBeat.o(121921);
                return true;
            }
            h dYs = anVar.dYs();
            h dYs2 = anVar2.dYs();
            if ((dYs instanceof ar) && (dYs2 instanceof ar)) {
                boolean a = b.a(b.BDK, (ar) dYs, (ar) dYs2, new AnonymousClass1(this));
                AppMethodBeat.o(121921);
                return a;
            }
            AppMethodBeat.o(121921);
            return false;
        }
    }

    static final class a extends k implements m<l, l, Boolean> {
        public static final a BDL = new a();

        static {
            AppMethodBeat.i(121919);
            AppMethodBeat.o(121919);
        }

        a() {
            super(2);
        }

        public final /* bridge */ /* synthetic */ Object m(Object obj, Object obj2) {
            return Boolean.FALSE;
        }
    }

    static {
        AppMethodBeat.i(121926);
        AppMethodBeat.o(121926);
    }

    private b() {
    }

    public static final /* synthetic */ boolean a(b bVar, ar arVar, ar arVar2, m mVar) {
        AppMethodBeat.i(121927);
        boolean a = bVar.a(arVar, arVar2, mVar);
        AppMethodBeat.o(121927);
        return a;
    }

    public final boolean d(l lVar, l lVar2) {
        AppMethodBeat.i(121923);
        boolean j;
        if ((lVar instanceof e) && (lVar2 instanceof e)) {
            j = j.j(((e) lVar).dXY(), ((e) lVar2).dXY());
            AppMethodBeat.o(121923);
            return j;
        } else if ((lVar instanceof ar) && (lVar2 instanceof ar)) {
            j = a((ar) lVar, (ar) lVar2, (m) c.BDP);
            AppMethodBeat.o(121923);
            return j;
        } else if ((lVar instanceof a.i.b.a.c.b.a) && (lVar2 instanceof a.i.b.a.c.b.a)) {
            a.i.b.a.c.b.a aVar = (a.i.b.a.c.b.a) lVar;
            a.i.b.a.c.b.a aVar2 = (a.i.b.a.c.b.a) lVar2;
            j.p(aVar, "a");
            j.p(aVar2, "b");
            if (j.j(aVar, aVar2)) {
                AppMethodBeat.o(121923);
                return true;
            }
            if ((j.j(aVar.dZg(), aVar2.dZg()) ^ 1) == 0 && !j.j(aVar.dXW(), aVar2.dXW())) {
                if (d.m(aVar) || d.m(aVar2)) {
                    AppMethodBeat.o(121923);
                    return false;
                } else if (a((l) aVar, (l) aVar2, (m) a.BDL)) {
                    j a = j.a((a.i.b.a.c.l.a.c.a) new b(aVar, aVar2));
                    j.o(a, "OverridingUtil.createWit…= a && y == b})\n        }");
                    a.i.b.a.c.i.j.a a2 = a.a(aVar, aVar2, null, true);
                    j.o(a2, "overridingUtil.isOverrid… null, !ignoreReturnType)");
                    if (a2.BEy == a.i.b.a.c.i.j.a.a.OVERRIDABLE) {
                        a.i.b.a.c.i.j.a a3 = a.a(aVar2, aVar, null, true);
                        j.o(a3, "overridingUtil.isOverrid… null, !ignoreReturnType)");
                        if (a3.BEy == a.i.b.a.c.i.j.a.a.OVERRIDABLE) {
                            AppMethodBeat.o(121923);
                            return true;
                        }
                    }
                }
            }
            AppMethodBeat.o(121923);
            return false;
        } else if ((lVar instanceof ab) && (lVar2 instanceof ab)) {
            j = j.j(((ab) lVar).dZF(), ((ab) lVar2).dZF());
            AppMethodBeat.o(121923);
            return j;
        } else {
            j = j.j(lVar, lVar2);
            AppMethodBeat.o(121923);
            return j;
        }
    }

    private final boolean a(ar arVar, ar arVar2, m<? super l, ? super l, Boolean> mVar) {
        AppMethodBeat.i(121924);
        if (j.j(arVar, arVar2)) {
            AppMethodBeat.o(121924);
            return true;
        } else if (j.j(arVar.dXW(), arVar2.dXW())) {
            AppMethodBeat.o(121924);
            return false;
        } else if (!a((l) arVar, (l) arVar2, (m) mVar)) {
            AppMethodBeat.o(121924);
            return false;
        } else if (arVar.getIndex() == arVar2.getIndex()) {
            AppMethodBeat.o(121924);
            return true;
        } else {
            AppMethodBeat.o(121924);
            return false;
        }
    }

    private final boolean a(l lVar, l lVar2, m<? super l, ? super l, Boolean> mVar) {
        AppMethodBeat.i(121925);
        l dXW = lVar.dXW();
        l dXW2 = lVar2.dXW();
        boolean booleanValue;
        if ((dXW instanceof a.i.b.a.c.b.b) || (dXW2 instanceof a.i.b.a.c.b.b)) {
            booleanValue = ((Boolean) mVar.m(dXW, dXW2)).booleanValue();
            AppMethodBeat.o(121925);
            return booleanValue;
        }
        booleanValue = d(dXW, dXW2);
        AppMethodBeat.o(121925);
        return booleanValue;
    }
}
