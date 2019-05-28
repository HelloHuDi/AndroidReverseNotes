package a.i.b.a.c.e.a;

import a.i.b.a.c.e.a.ao;
import a.i.b.a.c.e.a.q;
import a.i.b.a.c.e.a.r;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public static final a BwA;
    public static final a BwB;
    public static final a BwC;
    public static final a BwD = c.a(Bwv);
    public static final c<q> BwE;
    public static final a BwF;
    public static final a BwG;
    public static final a BwH;
    public static final a BwI;
    public static final a BwJ;
    public static final a BwK;
    public static final a BwL;
    public static final a BwM;
    public static final a BwN;
    public static final a BwO;
    public static final a BwP;
    public static final a BwQ;
    public static final a BwR;
    public static final a BwS;
    public static final a BwT;
    public static final a BwU;
    public static final a BwV;
    public static final a BwW;
    public static final a BwX;
    public static final a BwY;
    public static final a BwZ;
    public static final a Bwt = c.egn();
    public static final a Bwu;
    public static final c<ao> Bwv;
    public static final c<r> Bww;
    public static final c<a.i.b.a.c.e.a.c.b> Bwx;
    public static final a Bwy;
    public static final a Bwz;
    public static final a Bxa;
    public static final a Bxb;
    public static final a Bxc;
    public static final a Bxd = c.egn();

    public static class a extends c<Boolean> {
        public final /* synthetic */ int dK(Object obj) {
            AppMethodBeat.i(121067);
            int n = n((Boolean) obj);
            AppMethodBeat.o(121067);
            return n;
        }

        public final /* synthetic */ Object get(int i) {
            AppMethodBeat.i(121068);
            Boolean Ug = Ug(i);
            AppMethodBeat.o(121068);
            return Ug;
        }

        public a(int i) {
            super(i, 1, (byte) 0);
        }

        public final Boolean Ug(int i) {
            boolean z = true;
            AppMethodBeat.i(121065);
            if (((1 << this.offset) & i) == 0) {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(121065);
            return valueOf;
        }

        public final int n(Boolean bool) {
            AppMethodBeat.i(121066);
            if (bool.booleanValue()) {
                int i = 1 << this.offset;
                AppMethodBeat.o(121066);
                return i;
            }
            AppMethodBeat.o(121066);
            return 0;
        }
    }

    static class b<E extends a.i.b.a.c.g.j.a> extends c<E> {
        private final E[] Bxe;

        public final /* synthetic */ int dK(Object obj) {
            AppMethodBeat.i(121071);
            int edd = ((a.i.b.a.c.g.j.a) obj).edd() << this.offset;
            AppMethodBeat.o(121071);
            return edd;
        }

        public b(int i, E[] eArr) {
            super(i, Y(eArr), (byte) 0);
            AppMethodBeat.i(121069);
            this.Bxe = eArr;
            AppMethodBeat.o(121069);
        }

        private static <E> int Y(E[] eArr) {
            AppMethodBeat.i(121070);
            int length = eArr.length - 1;
            if (length == 0) {
                AppMethodBeat.o(121070);
                return 1;
            }
            for (int i = 31; i >= 0; i--) {
                if (((1 << i) & length) != 0) {
                    int i2 = i + 1;
                    AppMethodBeat.o(121070);
                    return i2;
                }
            }
            IllegalStateException illegalStateException = new IllegalStateException("Empty enum: " + eArr.getClass());
            AppMethodBeat.o(121070);
            throw illegalStateException;
        }

        public final /* synthetic */ Object get(int i) {
            AppMethodBeat.i(121072);
            int i2 = ((((1 << this.Bxf) - 1) << this.offset) & i) >> this.offset;
            for (a.i.b.a.c.g.j.a aVar : this.Bxe) {
                if (aVar.edd() == i2) {
                    AppMethodBeat.o(121072);
                    return aVar;
                }
            }
            AppMethodBeat.o(121072);
            return null;
        }
    }

    public static abstract class c<E> {
        public final int Bxf;
        public final int offset;

        public abstract int dK(E e);

        public abstract E get(int i);

        /* synthetic */ c(int i, int i2, byte b) {
            this(i, i2);
        }

        public static <E extends a.i.b.a.c.g.j.a> c<E> a(c<?> cVar, E[] eArr) {
            return new b(cVar.offset + cVar.Bxf, eArr);
        }

        public static a egn() {
            return new a(0);
        }

        public static a a(c<?> cVar) {
            return new a(cVar.offset + cVar.Bxf);
        }

        private c(int i, int i2) {
            this.offset = i;
            this.Bxf = i2;
        }
    }

    static {
        AppMethodBeat.i(121074);
        a egn = c.egn();
        Bwu = egn;
        c a = c.a(egn, ao.values());
        Bwv = a;
        a = c.a(a, r.values());
        Bww = a;
        a = c.a(a, a.i.b.a.c.e.a.c.b.values());
        Bwx = a;
        egn = c.a(a);
        Bwy = egn;
        egn = c.a(egn);
        Bwz = egn;
        egn = c.a(egn);
        BwA = egn;
        egn = c.a(egn);
        BwB = egn;
        BwC = c.a(egn);
        a = c.a(Bww, q.values());
        BwE = a;
        egn = c.a(a);
        BwF = egn;
        egn = c.a(egn);
        BwG = egn;
        egn = c.a(egn);
        BwH = egn;
        egn = c.a(egn);
        BwI = egn;
        egn = c.a(egn);
        BwJ = egn;
        egn = c.a(egn);
        BwK = egn;
        BwL = c.a(egn);
        egn = c.a(BwE);
        BwM = egn;
        egn = c.a(egn);
        BwN = egn;
        egn = c.a(egn);
        BwO = egn;
        egn = c.a(egn);
        BwP = egn;
        egn = c.a(egn);
        BwQ = egn;
        egn = c.a(egn);
        BwR = egn;
        egn = c.a(egn);
        BwS = egn;
        egn = c.a(egn);
        BwT = egn;
        BwU = c.a(egn);
        egn = c.a(Bwu);
        BwV = egn;
        egn = c.a(egn);
        BwW = egn;
        BwX = c.a(egn);
        egn = c.a(Bww);
        BwY = egn;
        egn = c.a(egn);
        BwZ = egn;
        Bxa = c.a(egn);
        egn = c.egn();
        Bxb = egn;
        Bxc = c.a(egn);
        AppMethodBeat.o(121074);
    }

    public static int a(boolean z, ao aoVar, r rVar) {
        AppMethodBeat.i(121073);
        int n = ((((Bwu.n(Boolean.valueOf(z)) | Bww.dK(rVar)) | Bwv.dK(aoVar)) | BwY.n(Boolean.FALSE)) | BwZ.n(Boolean.FALSE)) | Bxa.n(Boolean.FALSE);
        AppMethodBeat.o(121073);
        return n;
    }
}
