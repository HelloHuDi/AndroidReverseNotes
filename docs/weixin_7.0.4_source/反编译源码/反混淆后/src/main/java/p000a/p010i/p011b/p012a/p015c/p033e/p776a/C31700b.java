package p000a.p010i.p011b.p012a.p015c.p033e.p776a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C0086q;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C0088r;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C31687ao;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C37000c.C31689b;
import p000a.p010i.p011b.p012a.p015c.p035g.C8181j.C8183a;

/* renamed from: a.i.b.a.c.e.a.b */
public final class C31700b {
    public static final C17254a BwA;
    public static final C17254a BwB;
    public static final C17254a BwC;
    public static final C17254a BwD = C31701c.m51286a(Bwv);
    public static final C31701c<C0086q> BwE;
    public static final C17254a BwF;
    public static final C17254a BwG;
    public static final C17254a BwH;
    public static final C17254a BwI;
    public static final C17254a BwJ;
    public static final C17254a BwK;
    public static final C17254a BwL;
    public static final C17254a BwM;
    public static final C17254a BwN;
    public static final C17254a BwO;
    public static final C17254a BwP;
    public static final C17254a BwQ;
    public static final C17254a BwR;
    public static final C17254a BwS;
    public static final C17254a BwT;
    public static final C17254a BwU;
    public static final C17254a BwV;
    public static final C17254a BwW;
    public static final C17254a BwX;
    public static final C17254a BwY;
    public static final C17254a BwZ;
    public static final C17254a Bwt = C31701c.egn();
    public static final C17254a Bwu;
    public static final C31701c<C31687ao> Bwv;
    public static final C31701c<C0088r> Bww;
    public static final C31701c<C31689b> Bwx;
    public static final C17254a Bwy;
    public static final C17254a Bwz;
    public static final C17254a Bxa;
    public static final C17254a Bxb;
    public static final C17254a Bxc;
    public static final C17254a Bxd = C31701c.egn();

    /* renamed from: a.i.b.a.c.e.a.b$a */
    public static class C17254a extends C31701c<Boolean> {
        /* renamed from: dK */
        public final /* synthetic */ int mo31315dK(Object obj) {
            AppMethodBeat.m2504i(121067);
            int n = mo31317n((Boolean) obj);
            AppMethodBeat.m2505o(121067);
            return n;
        }

        public final /* synthetic */ Object get(int i) {
            AppMethodBeat.m2504i(121068);
            Boolean Ug = mo31314Ug(i);
            AppMethodBeat.m2505o(121068);
            return Ug;
        }

        public C17254a(int i) {
            super(i, 1, (byte) 0);
        }

        /* renamed from: Ug */
        public final Boolean mo31314Ug(int i) {
            boolean z = true;
            AppMethodBeat.m2504i(121065);
            if (((1 << this.offset) & i) == 0) {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.m2505o(121065);
            return valueOf;
        }

        /* renamed from: n */
        public final int mo31317n(Boolean bool) {
            AppMethodBeat.m2504i(121066);
            if (bool.booleanValue()) {
                int i = 1 << this.offset;
                AppMethodBeat.m2505o(121066);
                return i;
            }
            AppMethodBeat.m2505o(121066);
            return 0;
        }
    }

    /* renamed from: a.i.b.a.c.e.a.b$b */
    static class C31699b<E extends C8183a> extends C31701c<E> {
        private final E[] Bxe;

        /* renamed from: dK */
        public final /* synthetic */ int mo31315dK(Object obj) {
            AppMethodBeat.m2504i(121071);
            int edd = ((C8183a) obj).edd() << this.offset;
            AppMethodBeat.m2505o(121071);
            return edd;
        }

        public C31699b(int i, E[] eArr) {
            super(i, C31699b.m51283Y(eArr), (byte) 0);
            AppMethodBeat.m2504i(121069);
            this.Bxe = eArr;
            AppMethodBeat.m2505o(121069);
        }

        /* renamed from: Y */
        private static <E> int m51283Y(E[] eArr) {
            AppMethodBeat.m2504i(121070);
            int length = eArr.length - 1;
            if (length == 0) {
                AppMethodBeat.m2505o(121070);
                return 1;
            }
            for (int i = 31; i >= 0; i--) {
                if (((1 << i) & length) != 0) {
                    int i2 = i + 1;
                    AppMethodBeat.m2505o(121070);
                    return i2;
                }
            }
            IllegalStateException illegalStateException = new IllegalStateException("Empty enum: " + eArr.getClass());
            AppMethodBeat.m2505o(121070);
            throw illegalStateException;
        }

        public final /* synthetic */ Object get(int i) {
            AppMethodBeat.m2504i(121072);
            int i2 = ((((1 << this.Bxf) - 1) << this.offset) & i) >> this.offset;
            for (C8183a c8183a : this.Bxe) {
                if (c8183a.edd() == i2) {
                    AppMethodBeat.m2505o(121072);
                    return c8183a;
                }
            }
            AppMethodBeat.m2505o(121072);
            return null;
        }
    }

    /* renamed from: a.i.b.a.c.e.a.b$c */
    public static abstract class C31701c<E> {
        public final int Bxf;
        public final int offset;

        /* renamed from: dK */
        public abstract int mo31315dK(E e);

        public abstract E get(int i);

        /* synthetic */ C31701c(int i, int i2, byte b) {
            this(i, i2);
        }

        /* renamed from: a */
        public static <E extends C8183a> C31701c<E> m51287a(C31701c<?> c31701c, E[] eArr) {
            return new C31699b(c31701c.offset + c31701c.Bxf, eArr);
        }

        public static C17254a egn() {
            return new C17254a(0);
        }

        /* renamed from: a */
        public static C17254a m51286a(C31701c<?> c31701c) {
            return new C17254a(c31701c.offset + c31701c.Bxf);
        }

        private C31701c(int i, int i2) {
            this.offset = i;
            this.Bxf = i2;
        }
    }

    static {
        AppMethodBeat.m2504i(121074);
        C17254a egn = C31701c.egn();
        Bwu = egn;
        C31701c a = C31701c.m51287a(egn, C31687ao.values());
        Bwv = a;
        a = C31701c.m51287a(a, C0088r.values());
        Bww = a;
        a = C31701c.m51287a(a, C31689b.values());
        Bwx = a;
        egn = C31701c.m51286a(a);
        Bwy = egn;
        egn = C31701c.m51286a(egn);
        Bwz = egn;
        egn = C31701c.m51286a(egn);
        BwA = egn;
        egn = C31701c.m51286a(egn);
        BwB = egn;
        BwC = C31701c.m51286a(egn);
        a = C31701c.m51287a(Bww, C0086q.values());
        BwE = a;
        egn = C31701c.m51286a(a);
        BwF = egn;
        egn = C31701c.m51286a(egn);
        BwG = egn;
        egn = C31701c.m51286a(egn);
        BwH = egn;
        egn = C31701c.m51286a(egn);
        BwI = egn;
        egn = C31701c.m51286a(egn);
        BwJ = egn;
        egn = C31701c.m51286a(egn);
        BwK = egn;
        BwL = C31701c.m51286a(egn);
        egn = C31701c.m51286a(BwE);
        BwM = egn;
        egn = C31701c.m51286a(egn);
        BwN = egn;
        egn = C31701c.m51286a(egn);
        BwO = egn;
        egn = C31701c.m51286a(egn);
        BwP = egn;
        egn = C31701c.m51286a(egn);
        BwQ = egn;
        egn = C31701c.m51286a(egn);
        BwR = egn;
        egn = C31701c.m51286a(egn);
        BwS = egn;
        egn = C31701c.m51286a(egn);
        BwT = egn;
        BwU = C31701c.m51286a(egn);
        egn = C31701c.m51286a(Bwu);
        BwV = egn;
        egn = C31701c.m51286a(egn);
        BwW = egn;
        BwX = C31701c.m51286a(egn);
        egn = C31701c.m51286a(Bww);
        BwY = egn;
        egn = C31701c.m51286a(egn);
        BwZ = egn;
        Bxa = C31701c.m51286a(egn);
        egn = C31701c.egn();
        Bxb = egn;
        Bxc = C31701c.m51286a(egn);
        AppMethodBeat.m2505o(121074);
    }

    /* renamed from: a */
    public static int m51285a(boolean z, C31687ao c31687ao, C0088r c0088r) {
        AppMethodBeat.m2504i(121073);
        int n = ((((Bwu.mo31317n(Boolean.valueOf(z)) | Bww.mo31315dK(c0088r)) | Bwv.mo31315dK(c31687ao)) | BwY.mo31317n(Boolean.FALSE)) | BwZ.mo31317n(Boolean.FALSE)) | Bxa.mo31317n(Boolean.FALSE);
        AppMethodBeat.m2505o(121073);
        return n;
    }
}
