package a.i.b.a.c.e;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.wcdb.FileUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a {

    public interface p extends a.i.b.a.c.g.i.d {
    }

    public enum q implements a.i.b.a.c.g.j.a {
        DECLARATION(0),
        FAKE_OVERRIDE(1),
        DELEGATION(2),
        SYNTHESIZED(3);
        
        private static a.i.b.a.c.g.j.b<q> Btk;
        private final int value;

        static {
            Btk = new a.i.b.a.c.g.j.b<q>() {
                public final /* synthetic */ a.i.b.a.c.g.j.a SW(int i) {
                    AppMethodBeat.i(120669);
                    q Tp = q.Tp(i);
                    AppMethodBeat.o(120669);
                    return Tp;
                }
            };
            AppMethodBeat.o(120672);
        }

        public final int edd() {
            return this.value;
        }

        public static q Tp(int i) {
            switch (i) {
                case 0:
                    return DECLARATION;
                case 1:
                    return FAKE_OVERRIDE;
                case 2:
                    return DELEGATION;
                case 3:
                    return SYNTHESIZED;
                default:
                    return null;
            }
        }

        private q(int i) {
            this.value = i;
        }
    }

    public enum r implements a.i.b.a.c.g.j.a {
        FINAL(0),
        OPEN(1),
        ABSTRACT(2),
        SEALED(3);
        
        private static a.i.b.a.c.g.j.b<r> Btk;
        private final int value;

        static {
            Btk = new a.i.b.a.c.g.j.b<r>() {
                public final /* synthetic */ a.i.b.a.c.g.j.a SW(int i) {
                    AppMethodBeat.i(120673);
                    r Tq = r.Tq(i);
                    AppMethodBeat.o(120673);
                    return Tq;
                }
            };
            AppMethodBeat.o(120676);
        }

        public final int edd() {
            return this.value;
        }

        public static r Tq(int i) {
            switch (i) {
                case 0:
                    return FINAL;
                case 1:
                    return OPEN;
                case 2:
                    return ABSTRACT;
                case 3:
                    return SEALED;
                default:
                    return null;
            }
        }

        private r(int i) {
            this.value = i;
        }
    }

    public interface t extends a.i.b.a.c.g.i.d {
    }

    public static final class s extends a.i.b.a.c.g.i.c<s> implements t {
        public static a.i.b.a.c.g.s<s> BsC = new a.i.b.a.c.g.b<s>() {
            public final /* synthetic */ Object a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120677);
                s sVar = new s(eVar, gVar, (byte) 0);
                AppMethodBeat.o(120677);
                return sVar;
            }
        };
        private static final s BuI;
        private final a.i.b.a.c.g.d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        public ag BtC;
        public am BtE;
        public List<o> Btw;
        public List<u> Btx;
        public List<ab> Bty;

        public static final class a extends a.i.b.a.c.g.i.b<s, a> implements t {
            private int BsD;
            private ag BtC = ag.efM();
            private am BtE = am.egi();
            private List<o> Btw = Collections.emptyList();
            private List<u> Btx = Collections.emptyList();
            private List<ab> Bty = Collections.emptyList();

            public final /* synthetic */ a.i.b.a.c.g.i.a a(a.i.b.a.c.g.i iVar) {
                AppMethodBeat.i(120692);
                a e = e((s) iVar);
                AppMethodBeat.o(120692);
                return e;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a c(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120694);
                a n = n(eVar, gVar);
                AppMethodBeat.o(120694);
                return n;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(120698);
                a eev = eev();
                AppMethodBeat.o(120698);
                return eev;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a d(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120696);
                a n = n(eVar, gVar);
                AppMethodBeat.o(120696);
                return n;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.a ecK() {
                AppMethodBeat.i(120693);
                a eev = eev();
                AppMethodBeat.o(120693);
                return eev;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a ecL() {
                AppMethodBeat.i(120695);
                a eev = eev();
                AppMethodBeat.o(120695);
                return eev;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.b edA() {
                AppMethodBeat.i(120689);
                a eev = eev();
                AppMethodBeat.o(120689);
                return eev;
            }

            private a() {
                AppMethodBeat.i(120678);
                AppMethodBeat.o(120678);
            }

            private s eew() {
                int i = 1;
                AppMethodBeat.i(120680);
                s sVar = new s((a.i.b.a.c.g.i.b) this, (byte) 0);
                int i2 = this.BsD;
                if ((this.BsD & 1) == 1) {
                    this.Btw = Collections.unmodifiableList(this.Btw);
                    this.BsD &= -2;
                }
                sVar.Btw = this.Btw;
                if ((this.BsD & 2) == 2) {
                    this.Btx = Collections.unmodifiableList(this.Btx);
                    this.BsD &= -3;
                }
                sVar.Btx = this.Btx;
                if ((this.BsD & 4) == 4) {
                    this.Bty = Collections.unmodifiableList(this.Bty);
                    this.BsD &= -5;
                }
                sVar.Bty = this.Bty;
                if ((i2 & 8) != 8) {
                    i = 0;
                }
                sVar.BtC = this.BtC;
                if ((i2 & 16) == 16) {
                    i |= 2;
                }
                sVar.BtE = this.BtE;
                sVar.BsD = i;
                AppMethodBeat.o(120680);
                return sVar;
            }

            public final a e(s sVar) {
                AppMethodBeat.i(120681);
                if (sVar == s.eeu()) {
                    AppMethodBeat.o(120681);
                } else {
                    if (!sVar.Btw.isEmpty()) {
                        if (this.Btw.isEmpty()) {
                            this.Btw = sVar.Btw;
                            this.BsD &= -2;
                        } else {
                            edu();
                            this.Btw.addAll(sVar.Btw);
                        }
                    }
                    if (!sVar.Btx.isEmpty()) {
                        if (this.Btx.isEmpty()) {
                            this.Btx = sVar.Btx;
                            this.BsD &= -3;
                        } else {
                            edv();
                            this.Btx.addAll(sVar.Btx);
                        }
                    }
                    if (!sVar.Bty.isEmpty()) {
                        if (this.Bty.isEmpty()) {
                            this.Bty = sVar.Bty;
                            this.BsD &= -5;
                        } else {
                            edw();
                            this.Bty.addAll(sVar.Bty);
                        }
                    }
                    if (sVar.edl()) {
                        c(sVar.BtC);
                    }
                    if (sVar.edm()) {
                        b(sVar.BtE);
                    }
                    a((a.i.b.a.c.g.i.c) sVar);
                    this.BsB = this.BsB.a(sVar.BsB);
                    AppMethodBeat.o(120681);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private a n(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                s sVar;
                Throwable th;
                AppMethodBeat.i(120683);
                s sVar2 = null;
                try {
                    e((s) s.BsC.a(eVar, gVar));
                    AppMethodBeat.o(120683);
                    return this;
                } catch (a.i.b.a.c.g.k e) {
                    a.i.b.a.c.g.k kVar = e;
                    sVar = (s) kVar.BzY;
                    AppMethodBeat.o(120683);
                    throw kVar;
                } catch (Throwable th2) {
                    th = th2;
                    sVar2 = sVar;
                    if (sVar2 != null) {
                    }
                    AppMethodBeat.o(120683);
                    throw th;
                }
            }

            private void edu() {
                AppMethodBeat.i(120684);
                if ((this.BsD & 1) != 1) {
                    this.Btw = new ArrayList(this.Btw);
                    this.BsD |= 1;
                }
                AppMethodBeat.o(120684);
            }

            private void edv() {
                AppMethodBeat.i(120685);
                if ((this.BsD & 2) != 2) {
                    this.Btx = new ArrayList(this.Btx);
                    this.BsD |= 2;
                }
                AppMethodBeat.o(120685);
            }

            private void edw() {
                AppMethodBeat.i(120686);
                if ((this.BsD & 4) != 4) {
                    this.Bty = new ArrayList(this.Bty);
                    this.BsD |= 4;
                }
                AppMethodBeat.o(120686);
            }

            private a c(ag agVar) {
                AppMethodBeat.i(120687);
                if ((this.BsD & 8) != 8 || this.BtC == ag.efM()) {
                    this.BtC = agVar;
                } else {
                    this.BtC = ag.d(this.BtC).g(agVar).efP();
                }
                this.BsD |= 8;
                AppMethodBeat.o(120687);
                return this;
            }

            private a b(am amVar) {
                AppMethodBeat.i(120688);
                if ((this.BsD & 16) != 16 || this.BtE == am.egi()) {
                    this.BtE = amVar;
                } else {
                    this.BtE = am.c(this.BtE).f(amVar).egk();
                }
                this.BsD |= 16;
                AppMethodBeat.o(120688);
                return this;
            }

            private a eev() {
                AppMethodBeat.i(120679);
                a e = new a().e(eew());
                AppMethodBeat.o(120679);
                return e;
            }

            public final boolean isInitialized() {
                boolean z;
                AppMethodBeat.i(120682);
                int i = 0;
                while (i < this.Btw.size()) {
                    if (((o) this.Btw.get(i)).isInitialized()) {
                        i++;
                    } else {
                        AppMethodBeat.o(120682);
                        return false;
                    }
                }
                i = 0;
                while (i < this.Btx.size()) {
                    if (((u) this.Btx.get(i)).isInitialized()) {
                        i++;
                    } else {
                        AppMethodBeat.o(120682);
                        return false;
                    }
                }
                i = 0;
                while (i < this.Bty.size()) {
                    if (((ab) this.Bty.get(i)).isInitialized()) {
                        i++;
                    } else {
                        AppMethodBeat.o(120682);
                        return false;
                    }
                }
                if ((this.BsD & 8) == 8) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && !this.BtC.isInitialized()) {
                    AppMethodBeat.o(120682);
                    return false;
                } else if (this.BzI.isInitialized()) {
                    AppMethodBeat.o(120682);
                    return true;
                } else {
                    AppMethodBeat.o(120682);
                    return false;
                }
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecE() {
                AppMethodBeat.i(120690);
                s eeu = s.eeu();
                AppMethodBeat.o(120690);
                return eeu;
            }

            public final /* synthetic */ a.i.b.a.c.g.i ecJ() {
                AppMethodBeat.i(120691);
                s eeu = s.eeu();
                AppMethodBeat.o(120691);
                return eeu;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecM() {
                AppMethodBeat.i(120697);
                s eew = eew();
                if (eew.isInitialized()) {
                    AppMethodBeat.o(120697);
                    return eew;
                }
                a.i.b.a.c.g.w wVar = new a.i.b.a.c.g.w();
                AppMethodBeat.o(120697);
                throw wVar;
            }

            static /* synthetic */ a eex() {
                AppMethodBeat.i(120699);
                a aVar = new a();
                AppMethodBeat.o(120699);
                return aVar;
            }
        }

        /* synthetic */ s(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar, byte b) {
            this(eVar, gVar);
        }

        private s(a.i.b.a.c.g.i.b<s, ?> bVar) {
            super(bVar);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = bVar.BsB;
        }

        private s() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = a.i.b.a.c.g.d.Bzq;
        }

        public static s eeu() {
            return BuI;
        }

        private s(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
            AppMethodBeat.i(120700);
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            int i = 0;
            a.i.b.a.c.g.d.b ehS = a.i.b.a.c.g.d.ehS();
            a.i.b.a.c.g.f e = a.i.b.a.c.g.f.e(ehS, 1);
            int i2 = 0;
            while (i2 == 0) {
                try {
                    int vc = eVar.vc();
                    switch (vc) {
                        case 0:
                            i2 = 1;
                            break;
                        case 26:
                            if ((i & 1) != 1) {
                                this.Btw = new ArrayList();
                                i |= 1;
                            }
                            this.Btw.add(eVar.a(o.BsC, gVar));
                            break;
                        case 34:
                            if ((i & 2) != 2) {
                                this.Btx = new ArrayList();
                                i |= 2;
                            }
                            this.Btx.add(eVar.a(u.BsC, gVar));
                            break;
                        case 42:
                            if ((i & 4) != 4) {
                                this.Bty = new ArrayList();
                                i |= 4;
                            }
                            this.Bty.add(eVar.a(ab.BsC, gVar));
                            break;
                        case 242:
                            a d;
                            if ((this.BsD & 1) == 1) {
                                d = ag.d(this.BtC);
                            } else {
                                d = null;
                            }
                            this.BtC = (ag) eVar.a(ag.BsC, gVar);
                            if (d != null) {
                                d.g(this.BtC);
                                this.BtC = d.efP();
                            }
                            this.BsD |= 1;
                            break;
                        case com.tencent.view.d.MIC_PTU_ZIPAI_SAPPORO /*258*/:
                            a c;
                            if ((this.BsD & 2) == 2) {
                                c = am.c(this.BtE);
                            } else {
                                c = null;
                            }
                            this.BtE = (am) eVar.a(am.BsC, gVar);
                            if (c != null) {
                                c.f(this.BtE);
                                this.BtE = c.egk();
                            }
                            this.BsD |= 2;
                            break;
                        default:
                            if (!a(eVar, e, gVar, vc)) {
                                i2 = 1;
                                break;
                            }
                            break;
                    }
                } catch (a.i.b.a.c.g.k e2) {
                    e2.BzY = this;
                    AppMethodBeat.o(120700);
                    throw e2;
                } catch (IOException e3) {
                    a.i.b.a.c.g.k kVar = new a.i.b.a.c.g.k(e3.getMessage());
                    kVar.BzY = this;
                    AppMethodBeat.o(120700);
                    throw kVar;
                } catch (Throwable th) {
                    if ((i & 1) == 1) {
                        this.Btw = Collections.unmodifiableList(this.Btw);
                    }
                    if ((i & 2) == 2) {
                        this.Btx = Collections.unmodifiableList(this.Btx);
                    }
                    if ((i & 4) == 4) {
                        this.Bty = Collections.unmodifiableList(this.Bty);
                    }
                    try {
                        e.flush();
                        this.BsB = ehS.ehW();
                    } catch (IOException e4) {
                        this.BsB = ehS.ehW();
                    } catch (Throwable th2) {
                        this.BsB = ehS.ehW();
                        AppMethodBeat.o(120700);
                    }
                    this.BzI.eii();
                    AppMethodBeat.o(120700);
                }
            }
            if ((i & 1) == 1) {
                this.Btw = Collections.unmodifiableList(this.Btw);
            }
            if ((i & 2) == 2) {
                this.Btx = Collections.unmodifiableList(this.Btx);
            }
            if ((i & 4) == 4) {
                this.Bty = Collections.unmodifiableList(this.Bty);
            }
            try {
                e.flush();
                this.BsB = ehS.ehW();
            } catch (IOException e5) {
                this.BsB = ehS.ehW();
            } catch (Throwable th3) {
                this.BsB = ehS.ehW();
                AppMethodBeat.o(120700);
            }
            this.BzI.eii();
            AppMethodBeat.o(120700);
        }

        static {
            AppMethodBeat.i(120708);
            s sVar = new s();
            BuI = sVar;
            sVar.ecA();
            AppMethodBeat.o(120708);
        }

        public final a.i.b.a.c.g.s<s> ecy() {
            return BsC;
        }

        public final boolean edl() {
            return (this.BsD & 1) == 1;
        }

        public final boolean edm() {
            return (this.BsD & 2) == 2;
        }

        private void ecA() {
            AppMethodBeat.i(120701);
            this.Btw = Collections.emptyList();
            this.Btx = Collections.emptyList();
            this.Bty = Collections.emptyList();
            this.BtC = ag.efM();
            this.BtE = am.egi();
            AppMethodBeat.o(120701);
        }

        public final boolean isInitialized() {
            AppMethodBeat.i(120702);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.o(120702);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.o(120702);
                return false;
            } else {
                int i = 0;
                while (i < this.Btw.size()) {
                    if (((o) this.Btw.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120702);
                        return false;
                    }
                }
                i = 0;
                while (i < this.Btx.size()) {
                    if (((u) this.Btx.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120702);
                        return false;
                    }
                }
                i = 0;
                while (i < this.Bty.size()) {
                    if (((ab) this.Bty.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120702);
                        return false;
                    }
                }
                if (edl() && !this.BtC.isInitialized()) {
                    this.BsG = (byte) 0;
                    AppMethodBeat.o(120702);
                    return false;
                } else if (this.BzI.isInitialized()) {
                    this.BsG = (byte) 1;
                    AppMethodBeat.o(120702);
                    return true;
                } else {
                    this.BsG = (byte) 0;
                    AppMethodBeat.o(120702);
                    return false;
                }
            }
        }

        public final void a(a.i.b.a.c.g.f fVar) {
            int i;
            int i2 = 0;
            AppMethodBeat.i(120703);
            vq();
            a.i.b.a.c.g.i.c.a eip = eip();
            for (i = 0; i < this.Btw.size(); i++) {
                fVar.a(3, (a.i.b.a.c.g.q) this.Btw.get(i));
            }
            for (i = 0; i < this.Btx.size(); i++) {
                fVar.a(4, (a.i.b.a.c.g.q) this.Btx.get(i));
            }
            while (i2 < this.Bty.size()) {
                fVar.a(5, (a.i.b.a.c.g.q) this.Bty.get(i2));
                i2++;
            }
            if ((this.BsD & 1) == 1) {
                fVar.a(30, this.BtC);
            }
            if ((this.BsD & 2) == 2) {
                fVar.a(32, this.BtE);
            }
            eip.b(200, fVar);
            fVar.d(this.BsB);
            AppMethodBeat.o(120703);
        }

        public final int vq() {
            int i = 0;
            AppMethodBeat.i(120704);
            int i2 = this.BsH;
            if (i2 != -1) {
                AppMethodBeat.o(120704);
                return i2;
            }
            int i3;
            int i4 = 0;
            for (i3 = 0; i3 < this.Btw.size(); i3++) {
                i4 += a.i.b.a.c.g.f.c(3, (a.i.b.a.c.g.q) this.Btw.get(i3));
            }
            for (i3 = 0; i3 < this.Btx.size(); i3++) {
                i4 += a.i.b.a.c.g.f.c(4, (a.i.b.a.c.g.q) this.Btx.get(i3));
            }
            while (i < this.Bty.size()) {
                i4 += a.i.b.a.c.g.f.c(5, (a.i.b.a.c.g.q) this.Bty.get(i));
                i++;
            }
            if ((this.BsD & 1) == 1) {
                i4 += a.i.b.a.c.g.f.c(30, this.BtC);
            }
            if ((this.BsD & 2) == 2) {
                i4 += a.i.b.a.c.g.f.c(32, this.BtE);
            }
            i2 = (this.BzI.vq() + i4) + this.BsB.size();
            this.BsH = i2;
            AppMethodBeat.o(120704);
            return i2;
        }

        public static s c(InputStream inputStream, a.i.b.a.c.g.g gVar) {
            AppMethodBeat.i(120705);
            s sVar = (s) BsC.j(inputStream, gVar);
            AppMethodBeat.o(120705);
            return sVar;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.g.q ecE() {
            return BuI;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecC() {
            AppMethodBeat.i(120706);
            a e = a.eex().e(this);
            AppMethodBeat.o(120706);
            return e;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecD() {
            AppMethodBeat.i(120707);
            a eex = a.eex();
            AppMethodBeat.o(120707);
            return eex;
        }
    }

    public static final class ai extends a.i.b.a.c.g.i.c<ai> implements aj {
        public static a.i.b.a.c.g.s<ai> BsC = new a.i.b.a.c.g.b<ai>() {
            public final /* synthetic */ Object a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120977);
                ai aiVar = new ai(eVar, gVar, (byte) 0);
                AppMethodBeat.o(120977);
                return aiVar;
            }
        };
        private static final ai BvO;
        private final a.i.b.a.c.g.d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        public int BsW;
        public int Buf;
        public aa BvP;
        public int BvQ;
        public aa Bvo;
        public int Bvp;

        public static final class a extends a.i.b.a.c.g.i.b<ai, a> implements aj {
            private int BsD;
            private int BsW;
            private int Buf;
            private aa BvP = aa.eeX();
            private int BvQ;
            private aa Bvo = aa.eeX();
            private int Bvp;

            public final /* synthetic */ a.i.b.a.c.g.i.a a(a.i.b.a.c.g.i iVar) {
                AppMethodBeat.i(120989);
                a d = d((ai) iVar);
                AppMethodBeat.o(120989);
                return d;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a c(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120991);
                a x = x(eVar, gVar);
                AppMethodBeat.o(120991);
                return x;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(120995);
                a efV = efV();
                AppMethodBeat.o(120995);
                return efV;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a d(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120993);
                a x = x(eVar, gVar);
                AppMethodBeat.o(120993);
                return x;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.a ecK() {
                AppMethodBeat.i(120990);
                a efV = efV();
                AppMethodBeat.o(120990);
                return efV;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a ecL() {
                AppMethodBeat.i(120992);
                a efV = efV();
                AppMethodBeat.o(120992);
                return efV;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.b edA() {
                AppMethodBeat.i(120986);
                a efV = efV();
                AppMethodBeat.o(120986);
                return efV;
            }

            private a() {
                AppMethodBeat.i(120978);
                AppMethodBeat.o(120978);
            }

            public final ai efW() {
                int i = 1;
                AppMethodBeat.i(120980);
                ai aiVar = new ai((a.i.b.a.c.g.i.b) this, (byte) 0);
                int i2 = this.BsD;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                aiVar.BsW = this.BsW;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                aiVar.Buf = this.Buf;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                aiVar.Bvo = this.Bvo;
                if ((i2 & 8) == 8) {
                    i |= 8;
                }
                aiVar.Bvp = this.Bvp;
                if ((i2 & 16) == 16) {
                    i |= 16;
                }
                aiVar.BvP = this.BvP;
                if ((i2 & 32) == 32) {
                    i |= 32;
                }
                aiVar.BvQ = this.BvQ;
                aiVar.BsD = i;
                AppMethodBeat.o(120980);
                return aiVar;
            }

            public final a d(ai aiVar) {
                AppMethodBeat.i(120981);
                if (aiVar == ai.efS()) {
                    AppMethodBeat.o(120981);
                } else {
                    if (aiVar.ecY()) {
                        TV(aiVar.BsW);
                    }
                    if (aiVar.edW()) {
                        TW(aiVar.Buf);
                    }
                    if (aiVar.ecP()) {
                        p(aiVar.Bvo);
                    }
                    if (aiVar.efn()) {
                        TX(aiVar.Bvp);
                    }
                    if (aiVar.efT()) {
                        q(aiVar.BvP);
                    }
                    if (aiVar.efU()) {
                        TY(aiVar.BvQ);
                    }
                    a((a.i.b.a.c.g.i.c) aiVar);
                    this.BsB = this.BsB.a(aiVar.BsB);
                    AppMethodBeat.o(120981);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private a x(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                ai aiVar;
                Throwable th;
                AppMethodBeat.i(120983);
                ai aiVar2 = null;
                try {
                    d((ai) ai.BsC.a(eVar, gVar));
                    AppMethodBeat.o(120983);
                    return this;
                } catch (a.i.b.a.c.g.k e) {
                    a.i.b.a.c.g.k kVar = e;
                    aiVar = (ai) kVar.BzY;
                    AppMethodBeat.o(120983);
                    throw kVar;
                } catch (Throwable th2) {
                    th = th2;
                    aiVar2 = aiVar;
                    if (aiVar2 != null) {
                    }
                    AppMethodBeat.o(120983);
                    throw th;
                }
            }

            private a TV(int i) {
                this.BsD |= 1;
                this.BsW = i;
                return this;
            }

            private a TW(int i) {
                this.BsD |= 2;
                this.Buf = i;
                return this;
            }

            private a p(aa aaVar) {
                AppMethodBeat.i(120984);
                if ((this.BsD & 4) != 4 || this.Bvo == aa.eeX()) {
                    this.Bvo = aaVar;
                } else {
                    this.Bvo = aa.f(this.Bvo).j(aaVar).eft();
                }
                this.BsD |= 4;
                AppMethodBeat.o(120984);
                return this;
            }

            private a TX(int i) {
                this.BsD |= 8;
                this.Bvp = i;
                return this;
            }

            private a q(aa aaVar) {
                AppMethodBeat.i(120985);
                if ((this.BsD & 16) != 16 || this.BvP == aa.eeX()) {
                    this.BvP = aaVar;
                } else {
                    this.BvP = aa.f(this.BvP).j(aaVar).eft();
                }
                this.BsD |= 16;
                AppMethodBeat.o(120985);
                return this;
            }

            private a TY(int i) {
                this.BsD |= 32;
                this.BvQ = i;
                return this;
            }

            private a efV() {
                AppMethodBeat.i(120979);
                a d = new a().d(efW());
                AppMethodBeat.o(120979);
                return d;
            }

            public final boolean isInitialized() {
                boolean z;
                AppMethodBeat.i(120982);
                if ((this.BsD & 2) == 2) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if ((this.BsD & 4) == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z || this.Bvo.isInitialized()) {
                        if ((this.BsD & 16) == 16) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z && !this.BvP.isInitialized()) {
                            AppMethodBeat.o(120982);
                            return false;
                        } else if (this.BzI.isInitialized()) {
                            AppMethodBeat.o(120982);
                            return true;
                        } else {
                            AppMethodBeat.o(120982);
                            return false;
                        }
                    }
                    AppMethodBeat.o(120982);
                    return false;
                }
                AppMethodBeat.o(120982);
                return false;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecE() {
                AppMethodBeat.i(120987);
                ai efS = ai.efS();
                AppMethodBeat.o(120987);
                return efS;
            }

            public final /* synthetic */ a.i.b.a.c.g.i ecJ() {
                AppMethodBeat.i(120988);
                ai efS = ai.efS();
                AppMethodBeat.o(120988);
                return efS;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecM() {
                AppMethodBeat.i(120994);
                ai efW = efW();
                if (efW.isInitialized()) {
                    AppMethodBeat.o(120994);
                    return efW;
                }
                a.i.b.a.c.g.w wVar = new a.i.b.a.c.g.w();
                AppMethodBeat.o(120994);
                throw wVar;
            }

            static /* synthetic */ a efX() {
                AppMethodBeat.i(120996);
                a aVar = new a();
                AppMethodBeat.o(120996);
                return aVar;
            }
        }

        /* synthetic */ ai(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar, byte b) {
            this(eVar, gVar);
        }

        private ai(a.i.b.a.c.g.i.b<ai, ?> bVar) {
            super(bVar);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = bVar.BsB;
        }

        private ai() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = a.i.b.a.c.g.d.Bzq;
        }

        public static ai efS() {
            return BvO;
        }

        private ai(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
            AppMethodBeat.i(120997);
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            a.i.b.a.c.g.d.b ehS = a.i.b.a.c.g.d.ehS();
            a.i.b.a.c.g.f e = a.i.b.a.c.g.f.e(ehS, 1);
            int i = 0;
            while (i == 0) {
                try {
                    int vc = eVar.vc();
                    c efk;
                    switch (vc) {
                        case 0:
                            i = 1;
                            break;
                        case 8:
                            this.BsD |= 1;
                            this.BsW = eVar.vd();
                            break;
                        case 16:
                            this.BsD |= 2;
                            this.Buf = eVar.vd();
                            break;
                        case 26:
                            if ((this.BsD & 4) == 4) {
                                efk = this.Bvo.efk();
                            } else {
                                efk = null;
                            }
                            this.Bvo = (aa) eVar.a(aa.BsC, gVar);
                            if (efk != null) {
                                efk.j(this.Bvo);
                                this.Bvo = efk.eft();
                            }
                            this.BsD |= 4;
                            break;
                        case 34:
                            if ((this.BsD & 16) == 16) {
                                efk = this.BvP.efk();
                            } else {
                                efk = null;
                            }
                            this.BvP = (aa) eVar.a(aa.BsC, gVar);
                            if (efk != null) {
                                efk.j(this.BvP);
                                this.BvP = efk.eft();
                            }
                            this.BsD |= 16;
                            break;
                        case 40:
                            this.BsD |= 8;
                            this.Bvp = eVar.vd();
                            break;
                        case 48:
                            this.BsD |= 32;
                            this.BvQ = eVar.vd();
                            break;
                        default:
                            if (!a(eVar, e, gVar, vc)) {
                                i = 1;
                                break;
                            }
                            break;
                    }
                } catch (a.i.b.a.c.g.k e2) {
                    e2.BzY = this;
                    AppMethodBeat.o(120997);
                    throw e2;
                } catch (IOException e3) {
                    a.i.b.a.c.g.k kVar = new a.i.b.a.c.g.k(e3.getMessage());
                    kVar.BzY = this;
                    AppMethodBeat.o(120997);
                    throw kVar;
                } catch (Throwable th) {
                    try {
                        e.flush();
                        this.BsB = ehS.ehW();
                    } catch (IOException e4) {
                        this.BsB = ehS.ehW();
                    } catch (Throwable th2) {
                        this.BsB = ehS.ehW();
                        AppMethodBeat.o(120997);
                    }
                    this.BzI.eii();
                    AppMethodBeat.o(120997);
                }
            }
            try {
                e.flush();
                this.BsB = ehS.ehW();
            } catch (IOException e5) {
                this.BsB = ehS.ehW();
            } catch (Throwable th3) {
                this.BsB = ehS.ehW();
                AppMethodBeat.o(120997);
            }
            this.BzI.eii();
            AppMethodBeat.o(120997);
        }

        static {
            AppMethodBeat.i(121005);
            ai aiVar = new ai();
            BvO = aiVar;
            aiVar.ecA();
            AppMethodBeat.o(121005);
        }

        public final a.i.b.a.c.g.s<ai> ecy() {
            return BsC;
        }

        public final boolean ecY() {
            return (this.BsD & 1) == 1;
        }

        public final boolean edW() {
            return (this.BsD & 2) == 2;
        }

        public final boolean ecP() {
            return (this.BsD & 4) == 4;
        }

        public final boolean efn() {
            return (this.BsD & 8) == 8;
        }

        public final boolean efT() {
            return (this.BsD & 16) == 16;
        }

        public final boolean efU() {
            return (this.BsD & 32) == 32;
        }

        private void ecA() {
            AppMethodBeat.i(120998);
            this.BsW = 0;
            this.Buf = 0;
            this.Bvo = aa.eeX();
            this.Bvp = 0;
            this.BvP = aa.eeX();
            this.BvQ = 0;
            AppMethodBeat.o(120998);
        }

        public final boolean isInitialized() {
            AppMethodBeat.i(120999);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.o(120999);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.o(120999);
                return false;
            } else if (!edW()) {
                this.BsG = (byte) 0;
                AppMethodBeat.o(120999);
                return false;
            } else if (ecP() && !this.Bvo.isInitialized()) {
                this.BsG = (byte) 0;
                AppMethodBeat.o(120999);
                return false;
            } else if (efT() && !this.BvP.isInitialized()) {
                this.BsG = (byte) 0;
                AppMethodBeat.o(120999);
                return false;
            } else if (this.BzI.isInitialized()) {
                this.BsG = (byte) 1;
                AppMethodBeat.o(120999);
                return true;
            } else {
                this.BsG = (byte) 0;
                AppMethodBeat.o(120999);
                return false;
            }
        }

        public final void a(a.i.b.a.c.g.f fVar) {
            AppMethodBeat.i(121000);
            vq();
            a.i.b.a.c.g.i.c.a eip = eip();
            if ((this.BsD & 1) == 1) {
                fVar.bq(1, this.BsW);
            }
            if ((this.BsD & 2) == 2) {
                fVar.bq(2, this.Buf);
            }
            if ((this.BsD & 4) == 4) {
                fVar.a(3, this.Bvo);
            }
            if ((this.BsD & 16) == 16) {
                fVar.a(4, this.BvP);
            }
            if ((this.BsD & 8) == 8) {
                fVar.bq(5, this.Bvp);
            }
            if ((this.BsD & 32) == 32) {
                fVar.bq(6, this.BvQ);
            }
            eip.b(200, fVar);
            fVar.d(this.BsB);
            AppMethodBeat.o(121000);
        }

        public final int vq() {
            AppMethodBeat.i(121001);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.o(121001);
                return i;
            }
            i = 0;
            if ((this.BsD & 1) == 1) {
                i = a.i.b.a.c.g.f.bs(1, this.BsW) + 0;
            }
            if ((this.BsD & 2) == 2) {
                i += a.i.b.a.c.g.f.bs(2, this.Buf);
            }
            if ((this.BsD & 4) == 4) {
                i += a.i.b.a.c.g.f.c(3, this.Bvo);
            }
            if ((this.BsD & 16) == 16) {
                i += a.i.b.a.c.g.f.c(4, this.BvP);
            }
            if ((this.BsD & 8) == 8) {
                i += a.i.b.a.c.g.f.bs(5, this.Bvp);
            }
            if ((this.BsD & 32) == 32) {
                i += a.i.b.a.c.g.f.bs(6, this.BvQ);
            }
            i = (i + this.BzI.vq()) + this.BsB.size();
            this.BsH = i;
            AppMethodBeat.o(121001);
            return i;
        }

        public static a b(ai aiVar) {
            AppMethodBeat.i(121002);
            a d = a.efX().d(aiVar);
            AppMethodBeat.o(121002);
            return d;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.g.q ecE() {
            return BvO;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecC() {
            AppMethodBeat.i(121003);
            a d = a.efX().d(this);
            AppMethodBeat.o(121003);
            return d;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecD() {
            AppMethodBeat.i(121004);
            a efX = a.efX();
            AppMethodBeat.o(121004);
            return efX;
        }
    }

    public interface al extends a.i.b.a.c.g.r {
    }

    public interface h extends a.i.b.a.c.g.r {
    }

    public interface z extends a.i.b.a.c.g.r {
    }

    public static final class ak extends a.i.b.a.c.g.i implements al {
        public static a.i.b.a.c.g.s<ak> BsC = new a.i.b.a.c.g.b<ak>() {
            public final /* synthetic */ Object a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(121006);
                ak akVar = new ak(eVar, gVar, (byte) 0);
                AppMethodBeat.o(121006);
                return akVar;
            }
        };
        private static final ak BvR;
        private final a.i.b.a.c.g.d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        public int BvS;
        public int BvT;
        public b BvU;
        public int BvV;
        public int BvW;
        public c BvX;

        public enum b implements a.i.b.a.c.g.j.a {
            WARNING(0),
            ERROR(1),
            HIDDEN(2);
            
            private static a.i.b.a.c.g.j.b<b> Btk;
            final int value;

            static {
                Btk = new a.i.b.a.c.g.j.b<b>() {
                    public final /* synthetic */ a.i.b.a.c.g.j.a SW(int i) {
                        AppMethodBeat.i(121023);
                        b Ud = b.Ud(i);
                        AppMethodBeat.o(121023);
                        return Ud;
                    }
                };
                AppMethodBeat.o(121026);
            }

            public final int edd() {
                return this.value;
            }

            public static b Ud(int i) {
                switch (i) {
                    case 0:
                        return WARNING;
                    case 1:
                        return ERROR;
                    case 2:
                        return HIDDEN;
                    default:
                        return null;
                }
            }

            private b(int i) {
                this.value = i;
            }
        }

        public enum c implements a.i.b.a.c.g.j.a {
            LANGUAGE_VERSION(0),
            COMPILER_VERSION(1),
            API_VERSION(2);
            
            private static a.i.b.a.c.g.j.b<c> Btk;
            final int value;

            static {
                Btk = new a.i.b.a.c.g.j.b<c>() {
                    public final /* synthetic */ a.i.b.a.c.g.j.a SW(int i) {
                        AppMethodBeat.i(121027);
                        c Ue = c.Ue(i);
                        AppMethodBeat.o(121027);
                        return Ue;
                    }
                };
                AppMethodBeat.o(121030);
            }

            public final int edd() {
                return this.value;
            }

            public static c Ue(int i) {
                switch (i) {
                    case 0:
                        return LANGUAGE_VERSION;
                    case 1:
                        return COMPILER_VERSION;
                    case 2:
                        return API_VERSION;
                    default:
                        return null;
                }
            }

            private c(int i) {
                this.value = i;
            }
        }

        public static final class a extends a.i.b.a.c.g.i.a<ak, a> implements al {
            private int BsD;
            private int BvS;
            private int BvT;
            private b BvU = b.ERROR;
            private int BvV;
            private int BvW;
            private c BvX = c.LANGUAGE_VERSION;

            public final /* synthetic */ a.i.b.a.c.g.a.a c(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(121016);
                a y = y(eVar, gVar);
                AppMethodBeat.o(121016);
                return y;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(121021);
                a egf = egf();
                AppMethodBeat.o(121021);
                return egf;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a d(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(121018);
                a y = y(eVar, gVar);
                AppMethodBeat.o(121018);
                return y;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.a ecK() {
                AppMethodBeat.i(121015);
                a egf = egf();
                AppMethodBeat.o(121015);
                return egf;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a ecL() {
                AppMethodBeat.i(121017);
                a egf = egf();
                AppMethodBeat.o(121017);
                return egf;
            }

            private a() {
            }

            private ak egg() {
                int i = 1;
                AppMethodBeat.i(121008);
                ak akVar = new ak((a.i.b.a.c.g.i.a) this, (byte) 0);
                int i2 = this.BsD;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                akVar.BvS = this.BvS;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                akVar.BvT = this.BvT;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                akVar.BvU = this.BvU;
                if ((i2 & 8) == 8) {
                    i |= 8;
                }
                akVar.BvV = this.BvV;
                if ((i2 & 16) == 16) {
                    i |= 16;
                }
                akVar.BvW = this.BvW;
                if ((i2 & 32) == 32) {
                    i |= 32;
                }
                akVar.BvX = this.BvX;
                akVar.BsD = i;
                AppMethodBeat.o(121008);
                return akVar;
            }

            public final a b(ak akVar) {
                AppMethodBeat.i(121009);
                if (akVar == ak.efY()) {
                    AppMethodBeat.o(121009);
                } else {
                    if (akVar.efZ()) {
                        TZ(akVar.BvS);
                    }
                    if (akVar.ega()) {
                        Ua(akVar.BvT);
                    }
                    if (akVar.egb()) {
                        a(akVar.BvU);
                    }
                    if (akVar.egc()) {
                        Ub(akVar.BvV);
                    }
                    if (akVar.egd()) {
                        Uc(akVar.BvW);
                    }
                    if (akVar.ege()) {
                        a(akVar.BvX);
                    }
                    this.BsB = this.BsB.a(akVar.BsB);
                    AppMethodBeat.o(121009);
                }
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private a y(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                ak akVar;
                Throwable th;
                AppMethodBeat.i(121010);
                ak akVar2 = null;
                try {
                    b((ak) ak.BsC.a(eVar, gVar));
                    AppMethodBeat.o(121010);
                    return this;
                } catch (a.i.b.a.c.g.k e) {
                    a.i.b.a.c.g.k kVar = e;
                    akVar = (ak) kVar.BzY;
                    AppMethodBeat.o(121010);
                    throw kVar;
                } catch (Throwable th2) {
                    th = th2;
                    akVar2 = akVar;
                    if (akVar2 != null) {
                    }
                    AppMethodBeat.o(121010);
                    throw th;
                }
            }

            private a TZ(int i) {
                this.BsD |= 1;
                this.BvS = i;
                return this;
            }

            private a Ua(int i) {
                this.BsD |= 2;
                this.BvT = i;
                return this;
            }

            private a a(b bVar) {
                AppMethodBeat.i(121011);
                if (bVar == null) {
                    NullPointerException nullPointerException = new NullPointerException();
                    AppMethodBeat.o(121011);
                    throw nullPointerException;
                }
                this.BsD |= 4;
                this.BvU = bVar;
                AppMethodBeat.o(121011);
                return this;
            }

            private a Ub(int i) {
                this.BsD |= 8;
                this.BvV = i;
                return this;
            }

            private a Uc(int i) {
                this.BsD |= 16;
                this.BvW = i;
                return this;
            }

            private a a(c cVar) {
                AppMethodBeat.i(121012);
                if (cVar == null) {
                    NullPointerException nullPointerException = new NullPointerException();
                    AppMethodBeat.o(121012);
                    throw nullPointerException;
                }
                this.BsD |= 32;
                this.BvX = cVar;
                AppMethodBeat.o(121012);
                return this;
            }

            private a egf() {
                AppMethodBeat.i(121007);
                a b = new a().b(egg());
                AppMethodBeat.o(121007);
                return b;
            }

            public final /* synthetic */ a.i.b.a.c.g.i ecJ() {
                AppMethodBeat.i(121013);
                ak efY = ak.efY();
                AppMethodBeat.o(121013);
                return efY;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecM() {
                AppMethodBeat.i(121019);
                ak egg = egg();
                if (egg.isInitialized()) {
                    AppMethodBeat.o(121019);
                    return egg;
                }
                a.i.b.a.c.g.w wVar = new a.i.b.a.c.g.w();
                AppMethodBeat.o(121019);
                throw wVar;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecE() {
                AppMethodBeat.i(121020);
                ak efY = ak.efY();
                AppMethodBeat.o(121020);
                return efY;
            }

            static /* synthetic */ a egh() {
                AppMethodBeat.i(121022);
                a aVar = new a();
                AppMethodBeat.o(121022);
                return aVar;
            }
        }

        /* synthetic */ ak(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar, byte b) {
            this(eVar, gVar);
        }

        private ak(a.i.b.a.c.g.i.a aVar) {
            super((byte) 0);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = aVar.BsB;
        }

        private ak() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = a.i.b.a.c.g.d.Bzq;
        }

        public static ak efY() {
            return BvR;
        }

        private ak(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
            AppMethodBeat.i(121031);
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            a.i.b.a.c.g.d.b ehS = a.i.b.a.c.g.d.ehS();
            a.i.b.a.c.g.f e = a.i.b.a.c.g.f.e(ehS, 1);
            int i = 0;
            while (i == 0) {
                try {
                    int vc = eVar.vc();
                    int vd;
                    switch (vc) {
                        case 0:
                            i = 1;
                            break;
                        case 8:
                            this.BsD |= 1;
                            this.BvS = eVar.vd();
                            break;
                        case 16:
                            this.BsD |= 2;
                            this.BvT = eVar.vd();
                            break;
                        case 24:
                            vd = eVar.vd();
                            b Ud = b.Ud(vd);
                            if (Ud != null) {
                                this.BsD |= 4;
                                this.BvU = Ud;
                                break;
                            }
                            e.fw(vc);
                            e.fw(vd);
                            break;
                        case 32:
                            this.BsD |= 8;
                            this.BvV = eVar.vd();
                            break;
                        case 40:
                            this.BsD |= 16;
                            this.BvW = eVar.vd();
                            break;
                        case 48:
                            vd = eVar.vd();
                            c Ue = c.Ue(vd);
                            if (Ue != null) {
                                this.BsD |= 32;
                                this.BvX = Ue;
                                break;
                            }
                            e.fw(vc);
                            e.fw(vd);
                            break;
                        default:
                            if (!a(eVar, e, gVar, vc)) {
                                i = 1;
                                break;
                            }
                            break;
                    }
                } catch (a.i.b.a.c.g.k e2) {
                    e2.BzY = this;
                    AppMethodBeat.o(121031);
                    throw e2;
                } catch (IOException e3) {
                    a.i.b.a.c.g.k kVar = new a.i.b.a.c.g.k(e3.getMessage());
                    kVar.BzY = this;
                    AppMethodBeat.o(121031);
                    throw kVar;
                } catch (Throwable th) {
                    try {
                        e.flush();
                        this.BsB = ehS.ehW();
                    } catch (IOException e4) {
                        this.BsB = ehS.ehW();
                    } catch (Throwable th2) {
                        this.BsB = ehS.ehW();
                        AppMethodBeat.o(121031);
                    }
                    eio();
                    AppMethodBeat.o(121031);
                }
            }
            try {
                e.flush();
                this.BsB = ehS.ehW();
            } catch (IOException e5) {
                this.BsB = ehS.ehW();
            } catch (Throwable th3) {
                this.BsB = ehS.ehW();
                AppMethodBeat.o(121031);
            }
            eio();
            AppMethodBeat.o(121031);
        }

        static {
            AppMethodBeat.i(121036);
            ak akVar = new ak();
            BvR = akVar;
            akVar.ecA();
            AppMethodBeat.o(121036);
        }

        public final a.i.b.a.c.g.s<ak> ecy() {
            return BsC;
        }

        public final boolean efZ() {
            return (this.BsD & 1) == 1;
        }

        public final boolean ega() {
            return (this.BsD & 2) == 2;
        }

        public final boolean egb() {
            return (this.BsD & 4) == 4;
        }

        public final boolean egc() {
            return (this.BsD & 8) == 8;
        }

        public final boolean egd() {
            return (this.BsD & 16) == 16;
        }

        public final boolean ege() {
            return (this.BsD & 32) == 32;
        }

        private void ecA() {
            this.BvS = 0;
            this.BvT = 0;
            this.BvU = b.ERROR;
            this.BvV = 0;
            this.BvW = 0;
            this.BvX = c.LANGUAGE_VERSION;
        }

        public final boolean isInitialized() {
            byte b = this.BsG;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            this.BsG = (byte) 1;
            return true;
        }

        public final void a(a.i.b.a.c.g.f fVar) {
            AppMethodBeat.i(121032);
            vq();
            if ((this.BsD & 1) == 1) {
                fVar.bq(1, this.BvS);
            }
            if ((this.BsD & 2) == 2) {
                fVar.bq(2, this.BvT);
            }
            if ((this.BsD & 4) == 4) {
                fVar.io(3, this.BvU.value);
            }
            if ((this.BsD & 8) == 8) {
                fVar.bq(4, this.BvV);
            }
            if ((this.BsD & 16) == 16) {
                fVar.bq(5, this.BvW);
            }
            if ((this.BsD & 32) == 32) {
                fVar.io(6, this.BvX.value);
            }
            fVar.d(this.BsB);
            AppMethodBeat.o(121032);
        }

        public final int vq() {
            AppMethodBeat.i(121033);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.o(121033);
                return i;
            }
            i = 0;
            if ((this.BsD & 1) == 1) {
                i = a.i.b.a.c.g.f.bs(1, this.BvS) + 0;
            }
            if ((this.BsD & 2) == 2) {
                i += a.i.b.a.c.g.f.bs(2, this.BvT);
            }
            if ((this.BsD & 4) == 4) {
                i += a.i.b.a.c.g.f.ip(3, this.BvU.value);
            }
            if ((this.BsD & 8) == 8) {
                i += a.i.b.a.c.g.f.bs(4, this.BvV);
            }
            if ((this.BsD & 16) == 16) {
                i += a.i.b.a.c.g.f.bs(5, this.BvW);
            }
            if ((this.BsD & 32) == 32) {
                i += a.i.b.a.c.g.f.ip(6, this.BvX.value);
            }
            i += this.BsB.size();
            this.BsH = i;
            AppMethodBeat.o(121033);
            return i;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecC() {
            AppMethodBeat.i(121034);
            a b = a.egh().b(this);
            AppMethodBeat.o(121034);
            return b;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecD() {
            AppMethodBeat.i(121035);
            a egh = a.egh();
            AppMethodBeat.o(121035);
            return egh;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.g.q ecE() {
            return BvR;
        }
    }

    public static final class a extends a.i.b.a.c.g.i implements b {
        private static final a BsA;
        public static a.i.b.a.c.g.s<a> BsC = new a.i.b.a.c.g.b<a>() {
            public final /* synthetic */ Object a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120353);
                a aVar = new a(eVar, gVar, (byte) 0);
                AppMethodBeat.o(120353);
                return aVar;
            }
        };
        private final a.i.b.a.c.g.d BsB;
        private int BsD;
        public int BsE;
        public List<a> BsF;
        private byte BsG;
        private int BsH;

        public interface b extends a.i.b.a.c.g.r {
        }

        public static final class a extends a.i.b.a.c.g.i implements b {
            public static a.i.b.a.c.g.s<a> BsC = new a.i.b.a.c.g.b<a>() {
                public final /* synthetic */ Object a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                    AppMethodBeat.i(120354);
                    a aVar = new a(eVar, gVar, (byte) 0);
                    AppMethodBeat.o(120354);
                    return aVar;
                }
            };
            private static final a BsI;
            private final a.i.b.a.c.g.d BsB;
            private int BsD;
            private byte BsG;
            private int BsH;
            public int BsJ;
            public b BsK;

            public static final class b extends a.i.b.a.c.g.i implements c {
                public static a.i.b.a.c.g.s<b> BsC = new a.i.b.a.c.g.b<b>() {
                    public final /* synthetic */ Object a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                        AppMethodBeat.i(120372);
                        b bVar = new b(eVar, gVar, (byte) 0);
                        AppMethodBeat.o(120372);
                        return bVar;
                    }
                };
                private static final b BsL;
                private final a.i.b.a.c.g.d BsB;
                private int BsD;
                private byte BsG;
                private int BsH;
                public b BsM;
                public long BsN;
                public float BsO;
                public double BsP;
                public int BsQ;
                public int BsR;
                public int BsS;
                public a BsT;
                public List<b> BsU;
                public int BsV;
                public int BsW;

                public enum b implements a.i.b.a.c.g.j.a {
                    BYTE(0),
                    CHAR(1),
                    SHORT(2),
                    INT(3),
                    LONG(4),
                    FLOAT(5),
                    DOUBLE(6),
                    BOOLEAN(7),
                    STRING(8),
                    CLASS(9),
                    ENUM(10),
                    ANNOTATION(11),
                    ARRAY(12);
                    
                    private static a.i.b.a.c.g.j.b<b> Btk;
                    final int value;

                    static {
                        Btk = new a.i.b.a.c.g.j.b<b>() {
                            public final /* synthetic */ a.i.b.a.c.g.j.a SW(int i) {
                                AppMethodBeat.i(120392);
                                b SV = b.SV(i);
                                AppMethodBeat.o(120392);
                                return SV;
                            }
                        };
                        AppMethodBeat.o(120395);
                    }

                    public final int edd() {
                        return this.value;
                    }

                    public static b SV(int i) {
                        switch (i) {
                            case 0:
                                return BYTE;
                            case 1:
                                return CHAR;
                            case 2:
                                return SHORT;
                            case 3:
                                return INT;
                            case 4:
                                return LONG;
                            case 5:
                                return FLOAT;
                            case 6:
                                return DOUBLE;
                            case 7:
                                return BOOLEAN;
                            case 8:
                                return STRING;
                            case 9:
                                return CLASS;
                            case 10:
                                return ENUM;
                            case 11:
                                return ANNOTATION;
                            case 12:
                                return ARRAY;
                            default:
                                return null;
                        }
                    }

                    private b(int i) {
                        this.value = i;
                    }
                }

                public static final class a extends a.i.b.a.c.g.i.a<b, a> implements c {
                    private int BsD;
                    private b BsM = b.BYTE;
                    private long BsN;
                    private float BsO;
                    private double BsP;
                    private int BsQ;
                    private int BsR;
                    private int BsS;
                    private a BsT = a.ecx();
                    private List<b> BsU = Collections.emptyList();
                    private int BsV;
                    private int BsW;

                    public final /* synthetic */ a.i.b.a.c.g.a.a c(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                        AppMethodBeat.i(120385);
                        a e = e(eVar, gVar);
                        AppMethodBeat.o(120385);
                        return e;
                    }

                    public final /* synthetic */ Object clone() {
                        AppMethodBeat.i(120390);
                        a ecZ = ecZ();
                        AppMethodBeat.o(120390);
                        return ecZ;
                    }

                    public final /* synthetic */ a.i.b.a.c.g.q.a d(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                        AppMethodBeat.i(120387);
                        a e = e(eVar, gVar);
                        AppMethodBeat.o(120387);
                        return e;
                    }

                    public final /* synthetic */ a.i.b.a.c.g.i.a ecK() {
                        AppMethodBeat.i(120384);
                        a ecZ = ecZ();
                        AppMethodBeat.o(120384);
                        return ecZ;
                    }

                    public final /* synthetic */ a.i.b.a.c.g.a.a ecL() {
                        AppMethodBeat.i(120386);
                        a ecZ = ecZ();
                        AppMethodBeat.o(120386);
                        return ecZ;
                    }

                    private a() {
                        AppMethodBeat.i(120373);
                        AppMethodBeat.o(120373);
                    }

                    public final b eda() {
                        int i = 1;
                        AppMethodBeat.i(120375);
                        b bVar = new b((a.i.b.a.c.g.i.a) this, (byte) 0);
                        int i2 = this.BsD;
                        if ((i2 & 1) != 1) {
                            i = 0;
                        }
                        bVar.BsM = this.BsM;
                        if ((i2 & 2) == 2) {
                            i |= 2;
                        }
                        bVar.BsN = this.BsN;
                        if ((i2 & 4) == 4) {
                            i |= 4;
                        }
                        bVar.BsO = this.BsO;
                        if ((i2 & 8) == 8) {
                            i |= 8;
                        }
                        bVar.BsP = this.BsP;
                        if ((i2 & 16) == 16) {
                            i |= 16;
                        }
                        bVar.BsQ = this.BsQ;
                        if ((i2 & 32) == 32) {
                            i |= 32;
                        }
                        bVar.BsR = this.BsR;
                        if ((i2 & 64) == 64) {
                            i |= 64;
                        }
                        bVar.BsS = this.BsS;
                        if ((i2 & 128) == 128) {
                            i |= 128;
                        }
                        bVar.BsT = this.BsT;
                        if ((this.BsD & 256) == 256) {
                            this.BsU = Collections.unmodifiableList(this.BsU);
                            this.BsD &= -257;
                        }
                        bVar.BsU = this.BsU;
                        if ((i2 & 512) == 512) {
                            i |= 256;
                        }
                        bVar.BsV = this.BsV;
                        if ((i2 & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                            i |= 512;
                        }
                        bVar.BsW = this.BsW;
                        bVar.BsD = i;
                        AppMethodBeat.o(120375);
                        return bVar;
                    }

                    public final a e(b bVar) {
                        AppMethodBeat.i(120376);
                        if (bVar == b.ecO()) {
                            AppMethodBeat.o(120376);
                        } else {
                            if (bVar.ecP()) {
                                a(bVar.BsM);
                            }
                            if (bVar.ecQ()) {
                                nR(bVar.BsN);
                            }
                            if (bVar.ecR()) {
                                by(bVar.BsO);
                            }
                            if (bVar.ecS()) {
                                I(bVar.BsP);
                            }
                            if (bVar.ecT()) {
                                SQ(bVar.BsQ);
                            }
                            if (bVar.ecU()) {
                                SR(bVar.BsR);
                            }
                            if (bVar.ecV()) {
                                SS(bVar.BsS);
                            }
                            if (bVar.ecW()) {
                                d(bVar.BsT);
                            }
                            if (!bVar.BsU.isEmpty()) {
                                if (this.BsU.isEmpty()) {
                                    this.BsU = bVar.BsU;
                                    this.BsD &= -257;
                                } else {
                                    edb();
                                    this.BsU.addAll(bVar.BsU);
                                }
                            }
                            if (bVar.ecX()) {
                                ST(bVar.BsV);
                            }
                            if (bVar.ecY()) {
                                SU(bVar.BsW);
                            }
                            this.BsB = this.BsB.a(bVar.BsB);
                            AppMethodBeat.o(120376);
                        }
                        return this;
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    private a e(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                        b bVar;
                        Throwable th;
                        AppMethodBeat.i(120378);
                        b bVar2 = null;
                        try {
                            e((b) b.BsC.a(eVar, gVar));
                            AppMethodBeat.o(120378);
                            return this;
                        } catch (a.i.b.a.c.g.k e) {
                            a.i.b.a.c.g.k kVar = e;
                            bVar = (b) kVar.BzY;
                            AppMethodBeat.o(120378);
                            throw kVar;
                        } catch (Throwable th2) {
                            th = th2;
                            bVar2 = bVar;
                            if (bVar2 != null) {
                            }
                            AppMethodBeat.o(120378);
                            throw th;
                        }
                    }

                    private a a(b bVar) {
                        AppMethodBeat.i(120379);
                        if (bVar == null) {
                            NullPointerException nullPointerException = new NullPointerException();
                            AppMethodBeat.o(120379);
                            throw nullPointerException;
                        }
                        this.BsD |= 1;
                        this.BsM = bVar;
                        AppMethodBeat.o(120379);
                        return this;
                    }

                    private a nR(long j) {
                        this.BsD |= 2;
                        this.BsN = j;
                        return this;
                    }

                    private a by(float f) {
                        this.BsD |= 4;
                        this.BsO = f;
                        return this;
                    }

                    private a I(double d) {
                        this.BsD |= 8;
                        this.BsP = d;
                        return this;
                    }

                    private a SQ(int i) {
                        this.BsD |= 16;
                        this.BsQ = i;
                        return this;
                    }

                    private a SR(int i) {
                        this.BsD |= 32;
                        this.BsR = i;
                        return this;
                    }

                    private a SS(int i) {
                        this.BsD |= 64;
                        this.BsS = i;
                        return this;
                    }

                    private a d(a aVar) {
                        AppMethodBeat.i(120380);
                        if ((this.BsD & 128) != 128 || this.BsT == a.ecx()) {
                            this.BsT = aVar;
                        } else {
                            this.BsT = a.a(this.BsT).e(aVar).edf();
                        }
                        this.BsD |= 128;
                        AppMethodBeat.o(120380);
                        return this;
                    }

                    private void edb() {
                        AppMethodBeat.i(120381);
                        if ((this.BsD & 256) != 256) {
                            this.BsU = new ArrayList(this.BsU);
                            this.BsD |= 256;
                        }
                        AppMethodBeat.o(120381);
                    }

                    private a ST(int i) {
                        this.BsD |= 512;
                        this.BsV = i;
                        return this;
                    }

                    private a SU(int i) {
                        this.BsD |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                        this.BsW = i;
                        return this;
                    }

                    private a ecZ() {
                        AppMethodBeat.i(120374);
                        a e = new a().e(eda());
                        AppMethodBeat.o(120374);
                        return e;
                    }

                    public final boolean isInitialized() {
                        boolean z;
                        AppMethodBeat.i(120377);
                        if ((this.BsD & 128) == 128) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z || this.BsT.isInitialized()) {
                            int i = 0;
                            while (i < this.BsU.size()) {
                                if (((b) this.BsU.get(i)).isInitialized()) {
                                    i++;
                                } else {
                                    AppMethodBeat.o(120377);
                                    return false;
                                }
                            }
                            AppMethodBeat.o(120377);
                            return true;
                        }
                        AppMethodBeat.o(120377);
                        return false;
                    }

                    public final /* synthetic */ a.i.b.a.c.g.i ecJ() {
                        AppMethodBeat.i(120382);
                        b ecO = b.ecO();
                        AppMethodBeat.o(120382);
                        return ecO;
                    }

                    public final /* synthetic */ a.i.b.a.c.g.q ecM() {
                        AppMethodBeat.i(120388);
                        b eda = eda();
                        if (eda.isInitialized()) {
                            AppMethodBeat.o(120388);
                            return eda;
                        }
                        a.i.b.a.c.g.w wVar = new a.i.b.a.c.g.w();
                        AppMethodBeat.o(120388);
                        throw wVar;
                    }

                    public final /* synthetic */ a.i.b.a.c.g.q ecE() {
                        AppMethodBeat.i(120389);
                        b ecO = b.ecO();
                        AppMethodBeat.o(120389);
                        return ecO;
                    }

                    static /* synthetic */ a edc() {
                        AppMethodBeat.i(120391);
                        a aVar = new a();
                        AppMethodBeat.o(120391);
                        return aVar;
                    }
                }

                /* synthetic */ b(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar, byte b) {
                    this(eVar, gVar);
                }

                private b(a.i.b.a.c.g.i.a aVar) {
                    super((byte) 0);
                    this.BsG = (byte) -1;
                    this.BsH = -1;
                    this.BsB = aVar.BsB;
                }

                private b() {
                    this.BsG = (byte) -1;
                    this.BsH = -1;
                    this.BsB = a.i.b.a.c.g.d.Bzq;
                }

                public static b ecO() {
                    return BsL;
                }

                private b(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                    AppMethodBeat.i(120396);
                    this.BsG = (byte) -1;
                    this.BsH = -1;
                    ecA();
                    a.i.b.a.c.g.d.b ehS = a.i.b.a.c.g.d.ehS();
                    a.i.b.a.c.g.f e = a.i.b.a.c.g.f.e(ehS, 1);
                    int i = 0;
                    int i2 = 0;
                    while (i == 0) {
                        try {
                            int vc = eVar.vc();
                            switch (vc) {
                                case 0:
                                    i = 1;
                                    break;
                                case 8:
                                    int vd = eVar.vd();
                                    b SV = b.SV(vd);
                                    if (SV != null) {
                                        this.BsD |= 1;
                                        this.BsM = SV;
                                        break;
                                    }
                                    e.fw(vc);
                                    e.fw(vd);
                                    break;
                                case 16:
                                    this.BsD |= 2;
                                    this.BsN = a.i.b.a.c.g.e.nS(eVar.ve());
                                    break;
                                case 29:
                                    this.BsD |= 4;
                                    this.BsO = Float.intBitsToFloat(eVar.eia());
                                    break;
                                case 33:
                                    this.BsD |= 8;
                                    this.BsP = Double.longBitsToDouble(eVar.eib());
                                    break;
                                case 40:
                                    this.BsD |= 16;
                                    this.BsQ = eVar.vd();
                                    break;
                                case 48:
                                    this.BsD |= 32;
                                    this.BsR = eVar.vd();
                                    break;
                                case FileUtils.S_IRWXG /*56*/:
                                    this.BsD |= 64;
                                    this.BsS = eVar.vd();
                                    break;
                                case 66:
                                    c ecB;
                                    if ((this.BsD & 128) == 128) {
                                        ecB = this.BsT.ecB();
                                    } else {
                                        ecB = null;
                                    }
                                    this.BsT = (a) eVar.a(a.BsC, gVar);
                                    if (ecB != null) {
                                        ecB.e(this.BsT);
                                        this.BsT = ecB.edf();
                                    }
                                    this.BsD |= 128;
                                    break;
                                case 74:
                                    if ((i2 & 256) != 256) {
                                        this.BsU = new ArrayList();
                                        i2 |= 256;
                                    }
                                    this.BsU.add(eVar.a(BsC, gVar));
                                    break;
                                case 80:
                                    this.BsD |= 512;
                                    this.BsW = eVar.vd();
                                    break;
                                case 88:
                                    this.BsD |= 256;
                                    this.BsV = eVar.vd();
                                    break;
                                default:
                                    if (!a(eVar, e, gVar, vc)) {
                                        i = 1;
                                        break;
                                    }
                                    break;
                            }
                        } catch (a.i.b.a.c.g.k e2) {
                            e2.BzY = this;
                            AppMethodBeat.o(120396);
                            throw e2;
                        } catch (IOException e3) {
                            a.i.b.a.c.g.k kVar = new a.i.b.a.c.g.k(e3.getMessage());
                            kVar.BzY = this;
                            AppMethodBeat.o(120396);
                            throw kVar;
                        } catch (Throwable th) {
                            if ((i2 & 256) == 256) {
                                this.BsU = Collections.unmodifiableList(this.BsU);
                            }
                            try {
                                e.flush();
                                this.BsB = ehS.ehW();
                            } catch (IOException e4) {
                                this.BsB = ehS.ehW();
                            } catch (Throwable th2) {
                                this.BsB = ehS.ehW();
                                AppMethodBeat.o(120396);
                            }
                            eio();
                            AppMethodBeat.o(120396);
                        }
                    }
                    if ((i2 & 256) == 256) {
                        this.BsU = Collections.unmodifiableList(this.BsU);
                    }
                    try {
                        e.flush();
                        this.BsB = ehS.ehW();
                    } catch (IOException e5) {
                        this.BsB = ehS.ehW();
                    } catch (Throwable th3) {
                        this.BsB = ehS.ehW();
                        AppMethodBeat.o(120396);
                    }
                    eio();
                    AppMethodBeat.o(120396);
                }

                static {
                    AppMethodBeat.i(120404);
                    b bVar = new b();
                    BsL = bVar;
                    bVar.ecA();
                    AppMethodBeat.o(120404);
                }

                public final a.i.b.a.c.g.s<b> ecy() {
                    return BsC;
                }

                public final boolean ecP() {
                    return (this.BsD & 1) == 1;
                }

                public final boolean ecQ() {
                    return (this.BsD & 2) == 2;
                }

                public final boolean ecR() {
                    return (this.BsD & 4) == 4;
                }

                public final boolean ecS() {
                    return (this.BsD & 8) == 8;
                }

                public final boolean ecT() {
                    return (this.BsD & 16) == 16;
                }

                public final boolean ecU() {
                    return (this.BsD & 32) == 32;
                }

                public final boolean ecV() {
                    return (this.BsD & 64) == 64;
                }

                public final boolean ecW() {
                    return (this.BsD & 128) == 128;
                }

                public final boolean ecX() {
                    return (this.BsD & 256) == 256;
                }

                public final boolean ecY() {
                    return (this.BsD & 512) == 512;
                }

                private void ecA() {
                    AppMethodBeat.i(120397);
                    this.BsM = b.BYTE;
                    this.BsN = 0;
                    this.BsO = 0.0f;
                    this.BsP = 0.0d;
                    this.BsQ = 0;
                    this.BsR = 0;
                    this.BsS = 0;
                    this.BsT = a.ecx();
                    this.BsU = Collections.emptyList();
                    this.BsV = 0;
                    this.BsW = 0;
                    AppMethodBeat.o(120397);
                }

                public final boolean isInitialized() {
                    AppMethodBeat.i(120398);
                    byte b = this.BsG;
                    if (b == (byte) 1) {
                        AppMethodBeat.o(120398);
                        return true;
                    } else if (b == (byte) 0) {
                        AppMethodBeat.o(120398);
                        return false;
                    } else if (!ecW() || this.BsT.isInitialized()) {
                        int i = 0;
                        while (i < this.BsU.size()) {
                            if (((b) this.BsU.get(i)).isInitialized()) {
                                i++;
                            } else {
                                this.BsG = (byte) 0;
                                AppMethodBeat.o(120398);
                                return false;
                            }
                        }
                        this.BsG = (byte) 1;
                        AppMethodBeat.o(120398);
                        return true;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120398);
                        return false;
                    }
                }

                public final void a(a.i.b.a.c.g.f fVar) {
                    int i = 0;
                    AppMethodBeat.i(120399);
                    vq();
                    if ((this.BsD & 1) == 1) {
                        fVar.io(1, this.BsM.value);
                    }
                    if ((this.BsD & 2) == 2) {
                        long j = this.BsN;
                        fVar.bu(2, 0);
                        fVar.nT(j);
                    }
                    if ((this.BsD & 4) == 4) {
                        float f = this.BsO;
                        fVar.bu(3, 5);
                        fVar.bz(f);
                    }
                    if ((this.BsD & 8) == 8) {
                        double d = this.BsP;
                        fVar.bu(4, 1);
                        fVar.J(d);
                    }
                    if ((this.BsD & 16) == 16) {
                        fVar.bq(5, this.BsQ);
                    }
                    if ((this.BsD & 32) == 32) {
                        fVar.bq(6, this.BsR);
                    }
                    if ((this.BsD & 64) == 64) {
                        fVar.bq(7, this.BsS);
                    }
                    if ((this.BsD & 128) == 128) {
                        fVar.a(8, this.BsT);
                    }
                    while (true) {
                        int i2 = i;
                        if (i2 >= this.BsU.size()) {
                            break;
                        }
                        fVar.a(9, (a.i.b.a.c.g.q) this.BsU.get(i2));
                        i = i2 + 1;
                    }
                    if ((this.BsD & 512) == 512) {
                        fVar.bq(10, this.BsW);
                    }
                    if ((this.BsD & 256) == 256) {
                        fVar.bq(11, this.BsV);
                    }
                    fVar.d(this.BsB);
                    AppMethodBeat.o(120399);
                }

                public final int vq() {
                    int i = 0;
                    AppMethodBeat.i(120400);
                    int i2 = this.BsH;
                    if (i2 != -1) {
                        AppMethodBeat.o(120400);
                        return i2;
                    }
                    int i3;
                    if ((this.BsD & 1) == 1) {
                        i2 = a.i.b.a.c.g.f.ip(1, this.BsM.value) + 0;
                    } else {
                        i2 = 0;
                    }
                    if ((this.BsD & 2) == 2) {
                        i2 += a.i.b.a.c.g.f.nU(this.BsN);
                    }
                    if ((this.BsD & 4) == 4) {
                        i2 += a.i.b.a.c.g.f.fv(3) + 4;
                    }
                    if ((this.BsD & 8) == 8) {
                        i2 += a.i.b.a.c.g.f.fv(4) + 8;
                    }
                    if ((this.BsD & 16) == 16) {
                        i2 += a.i.b.a.c.g.f.bs(5, this.BsQ);
                    }
                    if ((this.BsD & 32) == 32) {
                        i2 += a.i.b.a.c.g.f.bs(6, this.BsR);
                    }
                    if ((this.BsD & 64) == 64) {
                        i2 += a.i.b.a.c.g.f.bs(7, this.BsS);
                    }
                    if ((this.BsD & 128) == 128) {
                        i2 += a.i.b.a.c.g.f.c(8, this.BsT);
                    }
                    while (true) {
                        i3 = i2;
                        if (i >= this.BsU.size()) {
                            break;
                        }
                        i2 = a.i.b.a.c.g.f.c(9, (a.i.b.a.c.g.q) this.BsU.get(i)) + i3;
                        i++;
                    }
                    if ((this.BsD & 512) == 512) {
                        i3 += a.i.b.a.c.g.f.bs(10, this.BsW);
                    }
                    if ((this.BsD & 256) == 256) {
                        i3 += a.i.b.a.c.g.f.bs(11, this.BsV);
                    }
                    i2 = this.BsB.size() + i3;
                    this.BsH = i2;
                    AppMethodBeat.o(120400);
                    return i2;
                }

                public static a b(b bVar) {
                    AppMethodBeat.i(120401);
                    a e = a.edc().e(bVar);
                    AppMethodBeat.o(120401);
                    return e;
                }

                public final /* synthetic */ a.i.b.a.c.g.q.a ecC() {
                    AppMethodBeat.i(120402);
                    a e = a.edc().e(this);
                    AppMethodBeat.o(120402);
                    return e;
                }

                public final /* synthetic */ a.i.b.a.c.g.q.a ecD() {
                    AppMethodBeat.i(120403);
                    a edc = a.edc();
                    AppMethodBeat.o(120403);
                    return edc;
                }

                public final /* bridge */ /* synthetic */ a.i.b.a.c.g.q ecE() {
                    return BsL;
                }
            }

            public static final class a extends a.i.b.a.c.g.i.a<a, a> implements b {
                private int BsD;
                private int BsJ;
                private b BsK = b.ecO();

                public final /* synthetic */ a.i.b.a.c.g.a.a c(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                    AppMethodBeat.i(120365);
                    a b = b(eVar, gVar);
                    AppMethodBeat.o(120365);
                    return b;
                }

                public final /* synthetic */ Object clone() {
                    AppMethodBeat.i(120370);
                    a ecH = ecH();
                    AppMethodBeat.o(120370);
                    return ecH;
                }

                public final /* synthetic */ a.i.b.a.c.g.q.a d(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                    AppMethodBeat.i(120367);
                    a b = b(eVar, gVar);
                    AppMethodBeat.o(120367);
                    return b;
                }

                public final /* synthetic */ a.i.b.a.c.g.i.a ecK() {
                    AppMethodBeat.i(120364);
                    a ecH = ecH();
                    AppMethodBeat.o(120364);
                    return ecH;
                }

                public final /* synthetic */ a.i.b.a.c.g.a.a ecL() {
                    AppMethodBeat.i(120366);
                    a ecH = ecH();
                    AppMethodBeat.o(120366);
                    return ecH;
                }

                private a() {
                    AppMethodBeat.i(120355);
                    AppMethodBeat.o(120355);
                }

                private a ecI() {
                    int i = 1;
                    AppMethodBeat.i(120357);
                    a aVar = new a((a.i.b.a.c.g.i.a) this, (byte) 0);
                    int i2 = this.BsD;
                    if ((i2 & 1) != 1) {
                        i = 0;
                    }
                    aVar.BsJ = this.BsJ;
                    if ((i2 & 2) == 2) {
                        i |= 2;
                    }
                    aVar.BsK = this.BsK;
                    aVar.BsD = i;
                    AppMethodBeat.o(120357);
                    return aVar;
                }

                public final a b(a aVar) {
                    AppMethodBeat.i(120358);
                    if (aVar == a.ecF()) {
                        AppMethodBeat.o(120358);
                    } else {
                        if (aVar.ecG()) {
                            SP(aVar.BsJ);
                        }
                        if (aVar.hasValue()) {
                            a(aVar.BsK);
                        }
                        this.BsB = this.BsB.a(aVar.BsB);
                        AppMethodBeat.o(120358);
                    }
                    return this;
                }

                /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                private a b(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                    a aVar;
                    Throwable th;
                    AppMethodBeat.i(120360);
                    a aVar2 = null;
                    try {
                        b((a) a.BsC.a(eVar, gVar));
                        AppMethodBeat.o(120360);
                        return this;
                    } catch (a.i.b.a.c.g.k e) {
                        a.i.b.a.c.g.k kVar = e;
                        aVar = (a) kVar.BzY;
                        AppMethodBeat.o(120360);
                        throw kVar;
                    } catch (Throwable th2) {
                        th = th2;
                        aVar2 = aVar;
                        if (aVar2 != null) {
                        }
                        AppMethodBeat.o(120360);
                        throw th;
                    }
                }

                private a SP(int i) {
                    this.BsD |= 1;
                    this.BsJ = i;
                    return this;
                }

                private a a(b bVar) {
                    AppMethodBeat.i(120361);
                    if ((this.BsD & 2) != 2 || this.BsK == b.ecO()) {
                        this.BsK = bVar;
                    } else {
                        this.BsK = b.b(this.BsK).e(bVar).eda();
                    }
                    this.BsD |= 2;
                    AppMethodBeat.o(120361);
                    return this;
                }

                private a ecH() {
                    AppMethodBeat.i(120356);
                    a b = new a().b(ecI());
                    AppMethodBeat.o(120356);
                    return b;
                }

                public final boolean isInitialized() {
                    boolean z;
                    AppMethodBeat.i(120359);
                    if ((this.BsD & 1) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if ((this.BsD & 2) == 2) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            AppMethodBeat.o(120359);
                            return false;
                        } else if (this.BsK.isInitialized()) {
                            AppMethodBeat.o(120359);
                            return true;
                        } else {
                            AppMethodBeat.o(120359);
                            return false;
                        }
                    }
                    AppMethodBeat.o(120359);
                    return false;
                }

                public final /* synthetic */ a.i.b.a.c.g.i ecJ() {
                    AppMethodBeat.i(120362);
                    a ecF = a.ecF();
                    AppMethodBeat.o(120362);
                    return ecF;
                }

                public final /* synthetic */ a.i.b.a.c.g.q ecM() {
                    AppMethodBeat.i(120368);
                    a ecI = ecI();
                    if (ecI.isInitialized()) {
                        AppMethodBeat.o(120368);
                        return ecI;
                    }
                    a.i.b.a.c.g.w wVar = new a.i.b.a.c.g.w();
                    AppMethodBeat.o(120368);
                    throw wVar;
                }

                public final /* synthetic */ a.i.b.a.c.g.q ecE() {
                    AppMethodBeat.i(120369);
                    a ecF = a.ecF();
                    AppMethodBeat.o(120369);
                    return ecF;
                }

                static /* synthetic */ a ecN() {
                    AppMethodBeat.i(120371);
                    a aVar = new a();
                    AppMethodBeat.o(120371);
                    return aVar;
                }
            }

            public interface c extends a.i.b.a.c.g.r {
            }

            /* synthetic */ a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar, byte b) {
                this(eVar, gVar);
            }

            private a(a.i.b.a.c.g.i.a aVar) {
                super((byte) 0);
                this.BsG = (byte) -1;
                this.BsH = -1;
                this.BsB = aVar.BsB;
            }

            private a() {
                this.BsG = (byte) -1;
                this.BsH = -1;
                this.BsB = a.i.b.a.c.g.d.Bzq;
            }

            public static a ecF() {
                return BsI;
            }

            private a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120405);
                this.BsG = (byte) -1;
                this.BsH = -1;
                ecA();
                a.i.b.a.c.g.d.b ehS = a.i.b.a.c.g.d.ehS();
                a.i.b.a.c.g.f e = a.i.b.a.c.g.f.e(ehS, 1);
                int i = 0;
                while (i == 0) {
                    try {
                        int vc = eVar.vc();
                        switch (vc) {
                            case 0:
                                i = 1;
                                break;
                            case 8:
                                this.BsD |= 1;
                                this.BsJ = eVar.vd();
                                break;
                            case 18:
                                a b;
                                if ((this.BsD & 2) == 2) {
                                    b = b.b(this.BsK);
                                } else {
                                    b = null;
                                }
                                this.BsK = (b) eVar.a(b.BsC, gVar);
                                if (b != null) {
                                    b.e(this.BsK);
                                    this.BsK = b.eda();
                                }
                                this.BsD |= 2;
                                break;
                            default:
                                if (!a(eVar, e, gVar, vc)) {
                                    i = 1;
                                    break;
                                }
                                break;
                        }
                    } catch (a.i.b.a.c.g.k e2) {
                        e2.BzY = this;
                        AppMethodBeat.o(120405);
                        throw e2;
                    } catch (IOException e3) {
                        a.i.b.a.c.g.k kVar = new a.i.b.a.c.g.k(e3.getMessage());
                        kVar.BzY = this;
                        AppMethodBeat.o(120405);
                        throw kVar;
                    } catch (Throwable th) {
                        try {
                            e.flush();
                            this.BsB = ehS.ehW();
                        } catch (IOException e4) {
                            this.BsB = ehS.ehW();
                        } catch (Throwable th2) {
                            this.BsB = ehS.ehW();
                            AppMethodBeat.o(120405);
                        }
                        eio();
                        AppMethodBeat.o(120405);
                    }
                }
                try {
                    e.flush();
                    this.BsB = ehS.ehW();
                } catch (IOException e5) {
                    this.BsB = ehS.ehW();
                } catch (Throwable th3) {
                    this.BsB = ehS.ehW();
                    AppMethodBeat.o(120405);
                }
                eio();
                AppMethodBeat.o(120405);
            }

            static {
                AppMethodBeat.i(120412);
                a aVar = new a();
                BsI = aVar;
                aVar.ecA();
                AppMethodBeat.o(120412);
            }

            public final a.i.b.a.c.g.s<a> ecy() {
                return BsC;
            }

            public final boolean ecG() {
                return (this.BsD & 1) == 1;
            }

            public final boolean hasValue() {
                return (this.BsD & 2) == 2;
            }

            private void ecA() {
                AppMethodBeat.i(120406);
                this.BsJ = 0;
                this.BsK = b.ecO();
                AppMethodBeat.o(120406);
            }

            public final boolean isInitialized() {
                AppMethodBeat.i(120407);
                byte b = this.BsG;
                if (b == (byte) 1) {
                    AppMethodBeat.o(120407);
                    return true;
                } else if (b == (byte) 0) {
                    AppMethodBeat.o(120407);
                    return false;
                } else if (!ecG()) {
                    this.BsG = (byte) 0;
                    AppMethodBeat.o(120407);
                    return false;
                } else if (!hasValue()) {
                    this.BsG = (byte) 0;
                    AppMethodBeat.o(120407);
                    return false;
                } else if (this.BsK.isInitialized()) {
                    this.BsG = (byte) 1;
                    AppMethodBeat.o(120407);
                    return true;
                } else {
                    this.BsG = (byte) 0;
                    AppMethodBeat.o(120407);
                    return false;
                }
            }

            public final void a(a.i.b.a.c.g.f fVar) {
                AppMethodBeat.i(120408);
                vq();
                if ((this.BsD & 1) == 1) {
                    fVar.bq(1, this.BsJ);
                }
                if ((this.BsD & 2) == 2) {
                    fVar.a(2, this.BsK);
                }
                fVar.d(this.BsB);
                AppMethodBeat.o(120408);
            }

            public final int vq() {
                AppMethodBeat.i(120409);
                int i = this.BsH;
                if (i != -1) {
                    AppMethodBeat.o(120409);
                    return i;
                }
                i = 0;
                if ((this.BsD & 1) == 1) {
                    i = a.i.b.a.c.g.f.bs(1, this.BsJ) + 0;
                }
                if ((this.BsD & 2) == 2) {
                    i += a.i.b.a.c.g.f.c(2, this.BsK);
                }
                i += this.BsB.size();
                this.BsH = i;
                AppMethodBeat.o(120409);
                return i;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a ecC() {
                AppMethodBeat.i(120410);
                a b = a.ecN().b(this);
                AppMethodBeat.o(120410);
                return b;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a ecD() {
                AppMethodBeat.i(120411);
                a ecN = a.ecN();
                AppMethodBeat.o(120411);
                return ecN;
            }

            public final /* bridge */ /* synthetic */ a.i.b.a.c.g.q ecE() {
                return BsI;
            }
        }

        public static final class c extends a.i.b.a.c.g.i.a<a, c> implements b {
            private int BsD;
            private int BsE;
            private List<a> BsF = Collections.emptyList();

            public final /* synthetic */ a.i.b.a.c.g.i.a a(a.i.b.a.c.g.i iVar) {
                AppMethodBeat.i(120421);
                c e = e((a) iVar);
                AppMethodBeat.o(120421);
                return e;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a c(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120423);
                c f = f(eVar, gVar);
                AppMethodBeat.o(120423);
                return f;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(120428);
                c ede = ede();
                AppMethodBeat.o(120428);
                return ede;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a d(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120425);
                c f = f(eVar, gVar);
                AppMethodBeat.o(120425);
                return f;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.a ecK() {
                AppMethodBeat.i(120422);
                c ede = ede();
                AppMethodBeat.o(120422);
                return ede;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a ecL() {
                AppMethodBeat.i(120424);
                c ede = ede();
                AppMethodBeat.o(120424);
                return ede;
            }

            private c() {
                AppMethodBeat.i(120413);
                AppMethodBeat.o(120413);
            }

            public final a edf() {
                int i = 1;
                AppMethodBeat.i(120415);
                a aVar = new a((a.i.b.a.c.g.i.a) this, (byte) 0);
                if ((this.BsD & 1) != 1) {
                    i = 0;
                }
                aVar.BsE = this.BsE;
                if ((this.BsD & 2) == 2) {
                    this.BsF = Collections.unmodifiableList(this.BsF);
                    this.BsD &= -3;
                }
                aVar.BsF = this.BsF;
                aVar.BsD = i;
                AppMethodBeat.o(120415);
                return aVar;
            }

            public final c e(a aVar) {
                AppMethodBeat.i(120416);
                if (aVar == a.ecx()) {
                    AppMethodBeat.o(120416);
                } else {
                    if (aVar.ecz()) {
                        SX(aVar.BsE);
                    }
                    if (!aVar.BsF.isEmpty()) {
                        if (this.BsF.isEmpty()) {
                            this.BsF = aVar.BsF;
                            this.BsD &= -3;
                        } else {
                            edg();
                            this.BsF.addAll(aVar.BsF);
                        }
                    }
                    this.BsB = this.BsB.a(aVar.BsB);
                    AppMethodBeat.o(120416);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private c f(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                a aVar;
                Throwable th;
                AppMethodBeat.i(120418);
                a aVar2 = null;
                try {
                    e((a) a.BsC.a(eVar, gVar));
                    AppMethodBeat.o(120418);
                    return this;
                } catch (a.i.b.a.c.g.k e) {
                    a.i.b.a.c.g.k kVar = e;
                    aVar = (a) kVar.BzY;
                    AppMethodBeat.o(120418);
                    throw kVar;
                } catch (Throwable th2) {
                    th = th2;
                    aVar2 = aVar;
                    if (aVar2 != null) {
                    }
                    AppMethodBeat.o(120418);
                    throw th;
                }
            }

            private c SX(int i) {
                this.BsD |= 1;
                this.BsE = i;
                return this;
            }

            private void edg() {
                AppMethodBeat.i(120419);
                if ((this.BsD & 2) != 2) {
                    this.BsF = new ArrayList(this.BsF);
                    this.BsD |= 2;
                }
                AppMethodBeat.o(120419);
            }

            private c ede() {
                AppMethodBeat.i(120414);
                c e = new c().e(edf());
                AppMethodBeat.o(120414);
                return e;
            }

            public final boolean isInitialized() {
                boolean z;
                AppMethodBeat.i(120417);
                if ((this.BsD & 1) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    int i = 0;
                    while (i < this.BsF.size()) {
                        if (((a) this.BsF.get(i)).isInitialized()) {
                            i++;
                        } else {
                            AppMethodBeat.o(120417);
                            return false;
                        }
                    }
                    AppMethodBeat.o(120417);
                    return true;
                }
                AppMethodBeat.o(120417);
                return false;
            }

            public final /* synthetic */ a.i.b.a.c.g.i ecJ() {
                AppMethodBeat.i(120420);
                a ecx = a.ecx();
                AppMethodBeat.o(120420);
                return ecx;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecM() {
                AppMethodBeat.i(120426);
                a edf = edf();
                if (edf.isInitialized()) {
                    AppMethodBeat.o(120426);
                    return edf;
                }
                a.i.b.a.c.g.w wVar = new a.i.b.a.c.g.w();
                AppMethodBeat.o(120426);
                throw wVar;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecE() {
                AppMethodBeat.i(120427);
                a ecx = a.ecx();
                AppMethodBeat.o(120427);
                return ecx;
            }

            static /* synthetic */ c edh() {
                AppMethodBeat.i(120429);
                c cVar = new c();
                AppMethodBeat.o(120429);
                return cVar;
            }
        }

        /* synthetic */ a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar, byte b) {
            this(eVar, gVar);
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecC() {
            AppMethodBeat.i(120438);
            c ecB = ecB();
            AppMethodBeat.o(120438);
            return ecB;
        }

        private a(a.i.b.a.c.g.i.a aVar) {
            super((byte) 0);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = aVar.BsB;
        }

        private a() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = a.i.b.a.c.g.d.Bzq;
        }

        public static a ecx() {
            return BsA;
        }

        private a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
            AppMethodBeat.i(120430);
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            a.i.b.a.c.g.d.b ehS = a.i.b.a.c.g.d.ehS();
            a.i.b.a.c.g.f e = a.i.b.a.c.g.f.e(ehS, 1);
            int i = 0;
            int i2 = 0;
            while (i == 0) {
                try {
                    int vc = eVar.vc();
                    switch (vc) {
                        case 0:
                            i = 1;
                            break;
                        case 8:
                            this.BsD |= 1;
                            this.BsE = eVar.vd();
                            break;
                        case 18:
                            if ((i2 & 2) != 2) {
                                this.BsF = new ArrayList();
                                i2 |= 2;
                            }
                            this.BsF.add(eVar.a(a.BsC, gVar));
                            break;
                        default:
                            if (!a(eVar, e, gVar, vc)) {
                                i = 1;
                                break;
                            }
                            break;
                    }
                } catch (a.i.b.a.c.g.k e2) {
                    e2.BzY = this;
                    AppMethodBeat.o(120430);
                    throw e2;
                } catch (IOException e3) {
                    a.i.b.a.c.g.k kVar = new a.i.b.a.c.g.k(e3.getMessage());
                    kVar.BzY = this;
                    AppMethodBeat.o(120430);
                    throw kVar;
                } catch (Throwable th) {
                    if ((i2 & 2) == 2) {
                        this.BsF = Collections.unmodifiableList(this.BsF);
                    }
                    try {
                        e.flush();
                        this.BsB = ehS.ehW();
                    } catch (IOException e4) {
                        this.BsB = ehS.ehW();
                    } catch (Throwable th2) {
                        this.BsB = ehS.ehW();
                        AppMethodBeat.o(120430);
                    }
                    eio();
                    AppMethodBeat.o(120430);
                }
            }
            if ((i2 & 2) == 2) {
                this.BsF = Collections.unmodifiableList(this.BsF);
            }
            try {
                e.flush();
                this.BsB = ehS.ehW();
            } catch (IOException e5) {
                this.BsB = ehS.ehW();
            } catch (Throwable th3) {
                this.BsB = ehS.ehW();
                AppMethodBeat.o(120430);
            }
            eio();
            AppMethodBeat.o(120430);
        }

        static {
            AppMethodBeat.i(120440);
            a aVar = new a();
            BsA = aVar;
            aVar.ecA();
            AppMethodBeat.o(120440);
        }

        public final a.i.b.a.c.g.s<a> ecy() {
            return BsC;
        }

        public final boolean ecz() {
            return (this.BsD & 1) == 1;
        }

        public final int getArgumentCount() {
            AppMethodBeat.i(120431);
            int size = this.BsF.size();
            AppMethodBeat.o(120431);
            return size;
        }

        private void ecA() {
            AppMethodBeat.i(120432);
            this.BsE = 0;
            this.BsF = Collections.emptyList();
            AppMethodBeat.o(120432);
        }

        public final boolean isInitialized() {
            AppMethodBeat.i(120433);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.o(120433);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.o(120433);
                return false;
            } else if (ecz()) {
                int i = 0;
                while (i < getArgumentCount()) {
                    if (((a) this.BsF.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120433);
                        return false;
                    }
                }
                this.BsG = (byte) 1;
                AppMethodBeat.o(120433);
                return true;
            } else {
                this.BsG = (byte) 0;
                AppMethodBeat.o(120433);
                return false;
            }
        }

        public final void a(a.i.b.a.c.g.f fVar) {
            AppMethodBeat.i(120434);
            vq();
            if ((this.BsD & 1) == 1) {
                fVar.bq(1, this.BsE);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.BsF.size()) {
                    fVar.a(2, (a.i.b.a.c.g.q) this.BsF.get(i2));
                    i = i2 + 1;
                } else {
                    fVar.d(this.BsB);
                    AppMethodBeat.o(120434);
                    return;
                }
            }
        }

        public final int vq() {
            int i = 0;
            AppMethodBeat.i(120435);
            int i2 = this.BsH;
            if (i2 != -1) {
                AppMethodBeat.o(120435);
                return i2;
            }
            if ((this.BsD & 1) == 1) {
                i2 = a.i.b.a.c.g.f.bs(1, this.BsE) + 0;
            } else {
                i2 = 0;
            }
            while (true) {
                int i3 = i2;
                if (i < this.BsF.size()) {
                    i2 = a.i.b.a.c.g.f.c(2, (a.i.b.a.c.g.q) this.BsF.get(i)) + i3;
                    i++;
                } else {
                    i2 = this.BsB.size() + i3;
                    this.BsH = i2;
                    AppMethodBeat.o(120435);
                    return i2;
                }
            }
        }

        public static c a(a aVar) {
            AppMethodBeat.i(120436);
            c e = c.edh().e(aVar);
            AppMethodBeat.o(120436);
            return e;
        }

        public final c ecB() {
            AppMethodBeat.i(120437);
            c e = c.edh().e(this);
            AppMethodBeat.o(120437);
            return e;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecD() {
            AppMethodBeat.i(120439);
            c edh = c.edh();
            AppMethodBeat.o(120439);
            return edh;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.g.q ecE() {
            return BsA;
        }
    }

    public static final class ab extends a.i.b.a.c.g.i.c<ab> implements ac {
        public static a.i.b.a.c.g.s<ab> BsC = new a.i.b.a.c.g.b<ab>() {
            public final /* synthetic */ Object a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120885);
                ab abVar = new ab(eVar, gVar, (byte) 0);
                AppMethodBeat.o(120885);
                return abVar;
            }
        };
        private static final ab Bvv;
        private final a.i.b.a.c.g.d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        public int BsW;
        public List<Integer> BtD;
        public List<ae> Btp;
        public int Buf;
        public List<a> BvA;
        public aa Bvw;
        public int Bvx;
        public aa Bvy;
        public int Bvz;

        public static final class a extends a.i.b.a.c.g.i.b<ab, a> implements ac {
            private int BsD;
            private int BsW = 6;
            private List<Integer> BtD = Collections.emptyList();
            private List<ae> Btp = Collections.emptyList();
            private int Buf;
            private List<a> BvA = Collections.emptyList();
            private aa Bvw = aa.eeX();
            private int Bvx;
            private aa Bvy = aa.eeX();
            private int Bvz;

            public final /* synthetic */ a.i.b.a.c.g.i.a a(a.i.b.a.c.g.i iVar) {
                AppMethodBeat.i(120900);
                a e = e((ab) iVar);
                AppMethodBeat.o(120900);
                return e;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a c(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120902);
                a u = u(eVar, gVar);
                AppMethodBeat.o(120902);
                return u;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(120906);
                a efA = efA();
                AppMethodBeat.o(120906);
                return efA;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a d(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120904);
                a u = u(eVar, gVar);
                AppMethodBeat.o(120904);
                return u;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.a ecK() {
                AppMethodBeat.i(120901);
                a efA = efA();
                AppMethodBeat.o(120901);
                return efA;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a ecL() {
                AppMethodBeat.i(120903);
                a efA = efA();
                AppMethodBeat.o(120903);
                return efA;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.b edA() {
                AppMethodBeat.i(120897);
                a efA = efA();
                AppMethodBeat.o(120897);
                return efA;
            }

            private a() {
                AppMethodBeat.i(120886);
                AppMethodBeat.o(120886);
            }

            private ab efB() {
                int i = 1;
                AppMethodBeat.i(120888);
                ab abVar = new ab((a.i.b.a.c.g.i.b) this, (byte) 0);
                int i2 = this.BsD;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                abVar.BsW = this.BsW;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                abVar.Buf = this.Buf;
                if ((this.BsD & 4) == 4) {
                    this.Btp = Collections.unmodifiableList(this.Btp);
                    this.BsD &= -5;
                }
                abVar.Btp = this.Btp;
                if ((i2 & 8) == 8) {
                    i |= 4;
                }
                abVar.Bvw = this.Bvw;
                if ((i2 & 16) == 16) {
                    i |= 8;
                }
                abVar.Bvx = this.Bvx;
                if ((i2 & 32) == 32) {
                    i |= 16;
                }
                abVar.Bvy = this.Bvy;
                if ((i2 & 64) == 64) {
                    i |= 32;
                }
                abVar.Bvz = this.Bvz;
                if ((this.BsD & 128) == 128) {
                    this.BvA = Collections.unmodifiableList(this.BvA);
                    this.BsD &= -129;
                }
                abVar.BvA = this.BvA;
                if ((this.BsD & 256) == 256) {
                    this.BtD = Collections.unmodifiableList(this.BtD);
                    this.BsD &= -257;
                }
                abVar.BtD = this.BtD;
                abVar.BsD = i;
                AppMethodBeat.o(120888);
                return abVar;
            }

            public final a e(ab abVar) {
                AppMethodBeat.i(120889);
                if (abVar == ab.efv()) {
                    AppMethodBeat.o(120889);
                } else {
                    if (abVar.ecY()) {
                        TN(abVar.BsW);
                    }
                    if (abVar.edW()) {
                        TO(abVar.Buf);
                    }
                    if (!abVar.Btp.isEmpty()) {
                        if (this.Btp.isEmpty()) {
                            this.Btp = abVar.Btp;
                            this.BsD &= -5;
                        } else {
                            edp();
                            this.Btp.addAll(abVar.Btp);
                        }
                    }
                    if (abVar.efw()) {
                        n(abVar.Bvw);
                    }
                    if (abVar.efx()) {
                        TP(abVar.Bvx);
                    }
                    if (abVar.efy()) {
                        o(abVar.Bvy);
                    }
                    if (abVar.efz()) {
                        TQ(abVar.Bvz);
                    }
                    if (!abVar.BvA.isEmpty()) {
                        if (this.BvA.isEmpty()) {
                            this.BvA = abVar.BvA;
                            this.BsD &= -129;
                        } else {
                            efC();
                            this.BvA.addAll(abVar.BvA);
                        }
                    }
                    if (!abVar.BtD.isEmpty()) {
                        if (this.BtD.isEmpty()) {
                            this.BtD = abVar.BtD;
                            this.BsD &= -257;
                        } else {
                            edz();
                            this.BtD.addAll(abVar.BtD);
                        }
                    }
                    a((a.i.b.a.c.g.i.c) abVar);
                    this.BsB = this.BsB.a(abVar.BsB);
                    AppMethodBeat.o(120889);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private a u(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                ab abVar;
                Throwable th;
                AppMethodBeat.i(120891);
                ab abVar2 = null;
                try {
                    e((ab) ab.BsC.a(eVar, gVar));
                    AppMethodBeat.o(120891);
                    return this;
                } catch (a.i.b.a.c.g.k e) {
                    a.i.b.a.c.g.k kVar = e;
                    abVar = (ab) kVar.BzY;
                    AppMethodBeat.o(120891);
                    throw kVar;
                } catch (Throwable th2) {
                    th = th2;
                    abVar2 = abVar;
                    if (abVar2 != null) {
                    }
                    AppMethodBeat.o(120891);
                    throw th;
                }
            }

            private a TN(int i) {
                this.BsD |= 1;
                this.BsW = i;
                return this;
            }

            private a TO(int i) {
                this.BsD |= 2;
                this.Buf = i;
                return this;
            }

            private void edp() {
                AppMethodBeat.i(120892);
                if ((this.BsD & 4) != 4) {
                    this.Btp = new ArrayList(this.Btp);
                    this.BsD |= 4;
                }
                AppMethodBeat.o(120892);
            }

            private a n(aa aaVar) {
                AppMethodBeat.i(120893);
                if ((this.BsD & 8) != 8 || this.Bvw == aa.eeX()) {
                    this.Bvw = aaVar;
                } else {
                    this.Bvw = aa.f(this.Bvw).j(aaVar).eft();
                }
                this.BsD |= 8;
                AppMethodBeat.o(120893);
                return this;
            }

            private a TP(int i) {
                this.BsD |= 16;
                this.Bvx = i;
                return this;
            }

            private a o(aa aaVar) {
                AppMethodBeat.i(120894);
                if ((this.BsD & 32) != 32 || this.Bvy == aa.eeX()) {
                    this.Bvy = aaVar;
                } else {
                    this.Bvy = aa.f(this.Bvy).j(aaVar).eft();
                }
                this.BsD |= 32;
                AppMethodBeat.o(120894);
                return this;
            }

            private a TQ(int i) {
                this.BsD |= 64;
                this.Bvz = i;
                return this;
            }

            private void efC() {
                AppMethodBeat.i(120895);
                if ((this.BsD & 128) != 128) {
                    this.BvA = new ArrayList(this.BvA);
                    this.BsD |= 128;
                }
                AppMethodBeat.o(120895);
            }

            private void edz() {
                AppMethodBeat.i(120896);
                if ((this.BsD & 256) != 256) {
                    this.BtD = new ArrayList(this.BtD);
                    this.BsD |= 256;
                }
                AppMethodBeat.o(120896);
            }

            private a efA() {
                AppMethodBeat.i(120887);
                a e = new a().e(efB());
                AppMethodBeat.o(120887);
                return e;
            }

            public final boolean isInitialized() {
                boolean z;
                AppMethodBeat.i(120890);
                if ((this.BsD & 2) == 2) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    int i = 0;
                    while (i < this.Btp.size()) {
                        if (((ae) this.Btp.get(i)).isInitialized()) {
                            i++;
                        } else {
                            AppMethodBeat.o(120890);
                            return false;
                        }
                    }
                    if ((this.BsD & 8) == 8) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z || this.Bvw.isInitialized()) {
                        if ((this.BsD & 32) == 32) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z || this.Bvy.isInitialized()) {
                            i = 0;
                            while (i < this.BvA.size()) {
                                if (((a) this.BvA.get(i)).isInitialized()) {
                                    i++;
                                } else {
                                    AppMethodBeat.o(120890);
                                    return false;
                                }
                            }
                            if (this.BzI.isInitialized()) {
                                AppMethodBeat.o(120890);
                                return true;
                            }
                            AppMethodBeat.o(120890);
                            return false;
                        }
                        AppMethodBeat.o(120890);
                        return false;
                    }
                    AppMethodBeat.o(120890);
                    return false;
                }
                AppMethodBeat.o(120890);
                return false;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecE() {
                AppMethodBeat.i(120898);
                ab efv = ab.efv();
                AppMethodBeat.o(120898);
                return efv;
            }

            public final /* synthetic */ a.i.b.a.c.g.i ecJ() {
                AppMethodBeat.i(120899);
                ab efv = ab.efv();
                AppMethodBeat.o(120899);
                return efv;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecM() {
                AppMethodBeat.i(120905);
                ab efB = efB();
                if (efB.isInitialized()) {
                    AppMethodBeat.o(120905);
                    return efB;
                }
                a.i.b.a.c.g.w wVar = new a.i.b.a.c.g.w();
                AppMethodBeat.o(120905);
                throw wVar;
            }

            static /* synthetic */ a efD() {
                AppMethodBeat.i(120907);
                a aVar = new a();
                AppMethodBeat.o(120907);
                return aVar;
            }
        }

        /* synthetic */ ab(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar, byte b) {
            this(eVar, gVar);
        }

        private ab(a.i.b.a.c.g.i.b<ab, ?> bVar) {
            super(bVar);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = bVar.BsB;
        }

        private ab() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = a.i.b.a.c.g.d.Bzq;
        }

        public static ab efv() {
            return Bvv;
        }

        /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0046=Splitter:B:13:0x0046, B:37:0x0097=Splitter:B:37:0x0097} */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0055  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0061  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x006d  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0055  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0061  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x006d  */
        /* JADX WARNING: Missing block: B:84:0x01ac, code skipped:
            r1 = r0;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private ab(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
            a.i.b.a.c.g.k kVar;
            Throwable th;
            IOException iOException;
            a.i.b.a.c.g.k kVar2;
            AppMethodBeat.i(120908);
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            int i = 0;
            a.i.b.a.c.g.d.b ehS = a.i.b.a.c.g.d.ehS();
            a.i.b.a.c.g.f e = a.i.b.a.c.g.f.e(ehS, 1);
            int i2 = 0;
            while (i2 == 0) {
                try {
                    int vc = eVar.vc();
                    c efk;
                    switch (vc) {
                        case 0:
                            i2 = 1;
                            break;
                        case 8:
                            this.BsD |= 1;
                            this.BsW = eVar.vd();
                            break;
                        case 16:
                            this.BsD |= 2;
                            this.Buf = eVar.vd();
                            break;
                        case 26:
                            if ((i & 4) != 4) {
                                this.Btp = new ArrayList();
                                i |= 4;
                            }
                            this.Btp.add(eVar.a(ae.BsC, gVar));
                            break;
                        case 34:
                            if ((this.BsD & 4) == 4) {
                                efk = this.Bvw.efk();
                            } else {
                                efk = null;
                            }
                            this.Bvw = (aa) eVar.a(aa.BsC, gVar);
                            if (efk != null) {
                                efk.j(this.Bvw);
                                this.Bvw = efk.eft();
                            }
                            this.BsD |= 4;
                            break;
                        case 40:
                            this.BsD |= 8;
                            this.Bvx = eVar.vd();
                            break;
                        case 50:
                            if ((this.BsD & 16) == 16) {
                                efk = this.Bvy.efk();
                            } else {
                                efk = null;
                            }
                            this.Bvy = (aa) eVar.a(aa.BsC, gVar);
                            if (efk != null) {
                                efk.j(this.Bvy);
                                this.Bvy = efk.eft();
                            }
                            this.BsD |= 16;
                            break;
                        case FileUtils.S_IRWXG /*56*/:
                            this.BsD |= 32;
                            this.Bvz = eVar.vd();
                            break;
                        case 66:
                            if ((i & 128) != 128) {
                                this.BvA = new ArrayList();
                                i |= 128;
                            }
                            this.BvA.add(eVar.a(a.BsC, gVar));
                            break;
                        case com.tencent.view.d.MIC_PTU_ZIPAI_THURSDAY /*248*/:
                            if ((i & 256) != 256) {
                                this.BtD = new ArrayList();
                                i |= 256;
                            }
                            this.BtD.add(Integer.valueOf(eVar.vd()));
                            break;
                        case 250:
                            int fo = eVar.fo(eVar.vd());
                            if ((i & 256) == 256 || eVar.vg() <= 0) {
                                vc = i;
                            } else {
                                this.BtD = new ArrayList();
                                vc = i | 256;
                            }
                            while (eVar.vg() > 0) {
                                try {
                                    this.BtD.add(Integer.valueOf(eVar.vd()));
                                } catch (a.i.b.a.c.g.k e2) {
                                    kVar = e2;
                                    i2 = vc;
                                    try {
                                        kVar.BzY = this;
                                        AppMethodBeat.o(120908);
                                        throw kVar;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if ((i2 & 4) == 4) {
                                        }
                                        if ((i2 & 128) == 128) {
                                        }
                                        if ((i2 & 256) == 256) {
                                        }
                                        try {
                                            e.flush();
                                            this.BsB = ehS.ehW();
                                        } catch (IOException e3) {
                                            this.BsB = ehS.ehW();
                                        } catch (Throwable th3) {
                                            this.BsB = ehS.ehW();
                                            AppMethodBeat.o(120908);
                                        }
                                        this.BzI.eii();
                                        AppMethodBeat.o(120908);
                                        throw th;
                                    }
                                } catch (IOException e4) {
                                    iOException = e4;
                                    i2 = vc;
                                    kVar2 = new a.i.b.a.c.g.k(iOException.getMessage());
                                    kVar2.BzY = this;
                                    AppMethodBeat.o(120908);
                                    throw kVar2;
                                } catch (Throwable th4) {
                                    th = th4;
                                    i2 = vc;
                                    if ((i2 & 4) == 4) {
                                    }
                                    if ((i2 & 128) == 128) {
                                    }
                                    if ((i2 & 256) == 256) {
                                    }
                                    e.flush();
                                    this.BsB = ehS.ehW();
                                    this.BzI.eii();
                                    AppMethodBeat.o(120908);
                                    throw th;
                                }
                            }
                            eVar.fp(fo);
                            break;
                        default:
                            if (!a(eVar, e, gVar, vc)) {
                                i2 = 1;
                                break;
                            } else {
                                vc = i;
                                break;
                            }
                    }
                } catch (a.i.b.a.c.g.k kVar22) {
                    kVar = kVar22;
                    i2 = i;
                    kVar.BzY = this;
                    AppMethodBeat.o(120908);
                    throw kVar;
                } catch (IOException e5) {
                    iOException = e5;
                    i2 = i;
                    kVar22 = new a.i.b.a.c.g.k(iOException.getMessage());
                    kVar22.BzY = this;
                    AppMethodBeat.o(120908);
                    throw kVar22;
                } catch (Throwable th22) {
                    th = th22;
                    i2 = i;
                    if ((i2 & 4) == 4) {
                        this.Btp = Collections.unmodifiableList(this.Btp);
                    }
                    if ((i2 & 128) == 128) {
                        this.BvA = Collections.unmodifiableList(this.BvA);
                    }
                    if ((i2 & 256) == 256) {
                        this.BtD = Collections.unmodifiableList(this.BtD);
                    }
                    e.flush();
                    this.BsB = ehS.ehW();
                    this.BzI.eii();
                    AppMethodBeat.o(120908);
                    throw th;
                }
            }
            if ((i & 4) == 4) {
                this.Btp = Collections.unmodifiableList(this.Btp);
            }
            if ((i & 128) == 128) {
                this.BvA = Collections.unmodifiableList(this.BvA);
            }
            if ((i & 256) == 256) {
                this.BtD = Collections.unmodifiableList(this.BtD);
            }
            try {
                e.flush();
                this.BsB = ehS.ehW();
            } catch (IOException e6) {
                this.BsB = ehS.ehW();
            } catch (Throwable th5) {
                this.BsB = ehS.ehW();
                AppMethodBeat.o(120908);
            }
            this.BzI.eii();
            AppMethodBeat.o(120908);
        }

        static {
            AppMethodBeat.i(120916);
            ab abVar = new ab();
            Bvv = abVar;
            abVar.ecA();
            AppMethodBeat.o(120916);
        }

        public final a.i.b.a.c.g.s<ab> ecy() {
            return BsC;
        }

        public final boolean ecY() {
            return (this.BsD & 1) == 1;
        }

        public final boolean edW() {
            return (this.BsD & 2) == 2;
        }

        public final boolean efw() {
            return (this.BsD & 4) == 4;
        }

        public final boolean efx() {
            return (this.BsD & 8) == 8;
        }

        public final boolean efy() {
            return (this.BsD & 16) == 16;
        }

        public final boolean efz() {
            return (this.BsD & 32) == 32;
        }

        private void ecA() {
            AppMethodBeat.i(120909);
            this.BsW = 6;
            this.Buf = 0;
            this.Btp = Collections.emptyList();
            this.Bvw = aa.eeX();
            this.Bvx = 0;
            this.Bvy = aa.eeX();
            this.Bvz = 0;
            this.BvA = Collections.emptyList();
            this.BtD = Collections.emptyList();
            AppMethodBeat.o(120909);
        }

        public final boolean isInitialized() {
            AppMethodBeat.i(120910);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.o(120910);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.o(120910);
                return false;
            } else if (edW()) {
                int i = 0;
                while (i < this.Btp.size()) {
                    if (((ae) this.Btp.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120910);
                        return false;
                    }
                }
                if (efw() && !this.Bvw.isInitialized()) {
                    this.BsG = (byte) 0;
                    AppMethodBeat.o(120910);
                    return false;
                } else if (!efy() || this.Bvy.isInitialized()) {
                    i = 0;
                    while (i < this.BvA.size()) {
                        if (((a) this.BvA.get(i)).isInitialized()) {
                            i++;
                        } else {
                            this.BsG = (byte) 0;
                            AppMethodBeat.o(120910);
                            return false;
                        }
                    }
                    if (this.BzI.isInitialized()) {
                        this.BsG = (byte) 1;
                        AppMethodBeat.o(120910);
                        return true;
                    }
                    this.BsG = (byte) 0;
                    AppMethodBeat.o(120910);
                    return false;
                } else {
                    this.BsG = (byte) 0;
                    AppMethodBeat.o(120910);
                    return false;
                }
            } else {
                this.BsG = (byte) 0;
                AppMethodBeat.o(120910);
                return false;
            }
        }

        public final void a(a.i.b.a.c.g.f fVar) {
            int i;
            int i2 = 0;
            AppMethodBeat.i(120911);
            vq();
            a.i.b.a.c.g.i.c.a eip = eip();
            if ((this.BsD & 1) == 1) {
                fVar.bq(1, this.BsW);
            }
            if ((this.BsD & 2) == 2) {
                fVar.bq(2, this.Buf);
            }
            for (i = 0; i < this.Btp.size(); i++) {
                fVar.a(3, (a.i.b.a.c.g.q) this.Btp.get(i));
            }
            if ((this.BsD & 4) == 4) {
                fVar.a(4, this.Bvw);
            }
            if ((this.BsD & 8) == 8) {
                fVar.bq(5, this.Bvx);
            }
            if ((this.BsD & 16) == 16) {
                fVar.a(6, this.Bvy);
            }
            if ((this.BsD & 32) == 32) {
                fVar.bq(7, this.Bvz);
            }
            for (i = 0; i < this.BvA.size(); i++) {
                fVar.a(8, (a.i.b.a.c.g.q) this.BvA.get(i));
            }
            while (i2 < this.BtD.size()) {
                fVar.bq(31, ((Integer) this.BtD.get(i2)).intValue());
                i2++;
            }
            eip.b(200, fVar);
            fVar.d(this.BsB);
            AppMethodBeat.o(120911);
        }

        public final int vq() {
            AppMethodBeat.i(120912);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.o(120912);
                return i;
            }
            int i2;
            if ((this.BsD & 1) == 1) {
                i = a.i.b.a.c.g.f.bs(1, this.BsW) + 0;
            } else {
                i = 0;
            }
            if ((this.BsD & 2) == 2) {
                i += a.i.b.a.c.g.f.bs(2, this.Buf);
            }
            int i3 = i;
            for (i2 = 0; i2 < this.Btp.size(); i2++) {
                i3 += a.i.b.a.c.g.f.c(3, (a.i.b.a.c.g.q) this.Btp.get(i2));
            }
            if ((this.BsD & 4) == 4) {
                i3 += a.i.b.a.c.g.f.c(4, this.Bvw);
            }
            if ((this.BsD & 8) == 8) {
                i3 += a.i.b.a.c.g.f.bs(5, this.Bvx);
            }
            if ((this.BsD & 16) == 16) {
                i3 += a.i.b.a.c.g.f.c(6, this.Bvy);
            }
            if ((this.BsD & 32) == 32) {
                i3 += a.i.b.a.c.g.f.bs(7, this.Bvz);
            }
            for (i2 = 0; i2 < this.BvA.size(); i2++) {
                i3 += a.i.b.a.c.g.f.c(8, (a.i.b.a.c.g.q) this.BvA.get(i2));
            }
            i2 = 0;
            int i4 = 0;
            while (i2 < this.BtD.size()) {
                i2++;
                i4 = a.i.b.a.c.g.f.ft(((Integer) this.BtD.get(i2)).intValue()) + i4;
            }
            i = (((i3 + i4) + (this.BtD.size() * 2)) + this.BzI.vq()) + this.BsB.size();
            this.BsH = i;
            AppMethodBeat.o(120912);
            return i;
        }

        public static ab d(InputStream inputStream, a.i.b.a.c.g.g gVar) {
            AppMethodBeat.i(120913);
            ab abVar = (ab) BsC.i(inputStream, gVar);
            AppMethodBeat.o(120913);
            return abVar;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.g.q ecE() {
            return Bvv;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecC() {
            AppMethodBeat.i(120914);
            a e = a.efD().e(this);
            AppMethodBeat.o(120914);
            return e;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecD() {
            AppMethodBeat.i(120915);
            a efD = a.efD();
            AppMethodBeat.o(120915);
            return efD;
        }
    }

    public interface ad extends a.i.b.a.c.g.i.d {
    }

    public interface j extends a.i.b.a.c.g.r {
    }

    public static final class aa extends a.i.b.a.c.g.i.c<aa> implements ad {
        public static a.i.b.a.c.g.s<aa> BsC = new a.i.b.a.c.g.b<aa>() {
            public final /* synthetic */ Object a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120820);
                aa aaVar = new aa(eVar, gVar, (byte) 0);
                AppMethodBeat.o(120820);
                return aaVar;
            }
        };
        private static final aa BuZ;
        private final a.i.b.a.c.g.d BsB;
        private int BsD;
        public List<a> BsF;
        private byte BsG;
        private int BsH;
        public int BsW;
        public boolean Bva;
        public int Bvb;
        public aa Bvc;
        public int Bvd;
        public int Bve;
        public int Bvf;
        public int Bvg;
        public int Bvh;
        public aa Bvi;
        public int Bvj;
        public aa Bvk;
        public int Bvl;

        public interface b extends a.i.b.a.c.g.r {
        }

        public static final class c extends a.i.b.a.c.g.i.b<aa, c> implements ad {
            private int BsD;
            private List<a> BsF = Collections.emptyList();
            private int BsW;
            private boolean Bva;
            private int Bvb;
            private aa Bvc = aa.eeX();
            private int Bvd;
            private int Bve;
            private int Bvf;
            private int Bvg;
            private int Bvh;
            private aa Bvi = aa.eeX();
            private int Bvj;
            private aa Bvk = aa.eeX();
            private int Bvl;

            public final /* synthetic */ a.i.b.a.c.g.i.a a(a.i.b.a.c.g.i iVar) {
                AppMethodBeat.i(120866);
                c j = j((aa) iVar);
                AppMethodBeat.o(120866);
                return j;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a c(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120868);
                c t = t(eVar, gVar);
                AppMethodBeat.o(120868);
                return t;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(120872);
                c efr = efr();
                AppMethodBeat.o(120872);
                return efr;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a d(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120870);
                c t = t(eVar, gVar);
                AppMethodBeat.o(120870);
                return t;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.a ecK() {
                AppMethodBeat.i(120867);
                c efr = efr();
                AppMethodBeat.o(120867);
                return efr;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a ecL() {
                AppMethodBeat.i(120869);
                c efr = efr();
                AppMethodBeat.o(120869);
                return efr;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecM() {
                AppMethodBeat.i(120871);
                aa efs = efs();
                AppMethodBeat.o(120871);
                return efs;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.b edA() {
                AppMethodBeat.i(120863);
                c efr = efr();
                AppMethodBeat.o(120863);
                return efr;
            }

            private c() {
                AppMethodBeat.i(120852);
                AppMethodBeat.o(120852);
            }

            public final aa efs() {
                AppMethodBeat.i(120854);
                aa eft = eft();
                if (eft.isInitialized()) {
                    AppMethodBeat.o(120854);
                    return eft;
                }
                a.i.b.a.c.g.w wVar = new a.i.b.a.c.g.w();
                AppMethodBeat.o(120854);
                throw wVar;
            }

            public final aa eft() {
                int i = 1;
                AppMethodBeat.i(120855);
                aa aaVar = new aa((a.i.b.a.c.g.i.b) this, (byte) 0);
                int i2 = this.BsD;
                if ((this.BsD & 1) == 1) {
                    this.BsF = Collections.unmodifiableList(this.BsF);
                    this.BsD &= -2;
                }
                aaVar.BsF = this.BsF;
                if ((i2 & 2) != 2) {
                    i = 0;
                }
                aaVar.Bva = this.Bva;
                if ((i2 & 4) == 4) {
                    i |= 2;
                }
                aaVar.Bvb = this.Bvb;
                if ((i2 & 8) == 8) {
                    i |= 4;
                }
                aaVar.Bvc = this.Bvc;
                if ((i2 & 16) == 16) {
                    i |= 8;
                }
                aaVar.Bvd = this.Bvd;
                if ((i2 & 32) == 32) {
                    i |= 16;
                }
                aaVar.Bve = this.Bve;
                if ((i2 & 64) == 64) {
                    i |= 32;
                }
                aaVar.Bvf = this.Bvf;
                if ((i2 & 128) == 128) {
                    i |= 64;
                }
                aaVar.Bvg = this.Bvg;
                if ((i2 & 256) == 256) {
                    i |= 128;
                }
                aaVar.Bvh = this.Bvh;
                if ((i2 & 512) == 512) {
                    i |= 256;
                }
                aaVar.Bvi = this.Bvi;
                if ((i2 & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                    i |= 512;
                }
                aaVar.Bvj = this.Bvj;
                if ((i2 & 2048) == 2048) {
                    i |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                }
                aaVar.Bvk = this.Bvk;
                if ((i2 & 4096) == 4096) {
                    i |= 2048;
                }
                aaVar.Bvl = this.Bvl;
                if ((i2 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == Utility.DEFAULT_STREAM_BUFFER_SIZE) {
                    i |= 4096;
                }
                aaVar.BsW = this.BsW;
                aaVar.BsD = i;
                AppMethodBeat.o(120855);
                return aaVar;
            }

            public final c j(aa aaVar) {
                AppMethodBeat.i(120856);
                if (aaVar == aa.eeX()) {
                    AppMethodBeat.o(120856);
                } else {
                    if (!aaVar.BsF.isEmpty()) {
                        if (this.BsF.isEmpty()) {
                            this.BsF = aaVar.BsF;
                            this.BsD &= -2;
                        } else {
                            edg();
                            this.BsF.addAll(aaVar.BsF);
                        }
                    }
                    if (aaVar.eeY()) {
                        rN(aaVar.Bva);
                    }
                    if (aaVar.eeZ()) {
                        TE(aaVar.Bvb);
                    }
                    if (aaVar.efa()) {
                        k(aaVar.Bvc);
                    }
                    if (aaVar.efb()) {
                        TF(aaVar.Bvd);
                    }
                    if (aaVar.efc()) {
                        TG(aaVar.Bve);
                    }
                    if (aaVar.efd()) {
                        TH(aaVar.Bvf);
                    }
                    if (aaVar.efe()) {
                        TI(aaVar.Bvg);
                    }
                    if (aaVar.eff()) {
                        TJ(aaVar.Bvh);
                    }
                    if (aaVar.efg()) {
                        l(aaVar.Bvi);
                    }
                    if (aaVar.efh()) {
                        TK(aaVar.Bvj);
                    }
                    if (aaVar.efi()) {
                        m(aaVar.Bvk);
                    }
                    if (aaVar.efj()) {
                        TL(aaVar.Bvl);
                    }
                    if (aaVar.ecY()) {
                        TM(aaVar.BsW);
                    }
                    a((a.i.b.a.c.g.i.c) aaVar);
                    this.BsB = this.BsB.a(aaVar.BsB);
                    AppMethodBeat.o(120856);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private c t(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                aa aaVar;
                Throwable th;
                AppMethodBeat.i(120858);
                aa aaVar2 = null;
                try {
                    j((aa) aa.BsC.a(eVar, gVar));
                    AppMethodBeat.o(120858);
                    return this;
                } catch (a.i.b.a.c.g.k e) {
                    a.i.b.a.c.g.k kVar = e;
                    aaVar = (aa) kVar.BzY;
                    AppMethodBeat.o(120858);
                    throw kVar;
                } catch (Throwable th2) {
                    th = th2;
                    aaVar2 = aaVar;
                    if (aaVar2 != null) {
                    }
                    AppMethodBeat.o(120858);
                    throw th;
                }
            }

            private void edg() {
                AppMethodBeat.i(120859);
                if ((this.BsD & 1) != 1) {
                    this.BsF = new ArrayList(this.BsF);
                    this.BsD |= 1;
                }
                AppMethodBeat.o(120859);
            }

            public final c rN(boolean z) {
                this.BsD |= 2;
                this.Bva = z;
                return this;
            }

            private c TE(int i) {
                this.BsD |= 4;
                this.Bvb = i;
                return this;
            }

            private c k(aa aaVar) {
                AppMethodBeat.i(120860);
                if ((this.BsD & 8) != 8 || this.Bvc == aa.eeX()) {
                    this.Bvc = aaVar;
                } else {
                    this.Bvc = aa.f(this.Bvc).j(aaVar).eft();
                }
                this.BsD |= 8;
                AppMethodBeat.o(120860);
                return this;
            }

            private c TF(int i) {
                this.BsD |= 16;
                this.Bvd = i;
                return this;
            }

            private c TG(int i) {
                this.BsD |= 32;
                this.Bve = i;
                return this;
            }

            private c TH(int i) {
                this.BsD |= 64;
                this.Bvf = i;
                return this;
            }

            private c TI(int i) {
                this.BsD |= 128;
                this.Bvg = i;
                return this;
            }

            private c TJ(int i) {
                this.BsD |= 256;
                this.Bvh = i;
                return this;
            }

            private c l(aa aaVar) {
                AppMethodBeat.i(120861);
                if ((this.BsD & 512) != 512 || this.Bvi == aa.eeX()) {
                    this.Bvi = aaVar;
                } else {
                    this.Bvi = aa.f(this.Bvi).j(aaVar).eft();
                }
                this.BsD |= 512;
                AppMethodBeat.o(120861);
                return this;
            }

            private c TK(int i) {
                this.BsD |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                this.Bvj = i;
                return this;
            }

            private c m(aa aaVar) {
                AppMethodBeat.i(120862);
                if ((this.BsD & 2048) != 2048 || this.Bvk == aa.eeX()) {
                    this.Bvk = aaVar;
                } else {
                    this.Bvk = aa.f(this.Bvk).j(aaVar).eft();
                }
                this.BsD |= 2048;
                AppMethodBeat.o(120862);
                return this;
            }

            private c TL(int i) {
                this.BsD |= 4096;
                this.Bvl = i;
                return this;
            }

            private c TM(int i) {
                this.BsD |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                this.BsW = i;
                return this;
            }

            private c efr() {
                AppMethodBeat.i(120853);
                c j = new c().j(eft());
                AppMethodBeat.o(120853);
                return j;
            }

            public final boolean isInitialized() {
                boolean z;
                AppMethodBeat.i(120857);
                int i = 0;
                while (i < this.BsF.size()) {
                    if (((a) this.BsF.get(i)).isInitialized()) {
                        i++;
                    } else {
                        AppMethodBeat.o(120857);
                        return false;
                    }
                }
                if ((this.BsD & 8) == 8) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z || this.Bvc.isInitialized()) {
                    if ((this.BsD & 512) == 512) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z || this.Bvi.isInitialized()) {
                        if ((this.BsD & 2048) == 2048) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z && !this.Bvk.isInitialized()) {
                            AppMethodBeat.o(120857);
                            return false;
                        } else if (this.BzI.isInitialized()) {
                            AppMethodBeat.o(120857);
                            return true;
                        } else {
                            AppMethodBeat.o(120857);
                            return false;
                        }
                    }
                    AppMethodBeat.o(120857);
                    return false;
                }
                AppMethodBeat.o(120857);
                return false;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecE() {
                AppMethodBeat.i(120864);
                aa eeX = aa.eeX();
                AppMethodBeat.o(120864);
                return eeX;
            }

            public final /* synthetic */ a.i.b.a.c.g.i ecJ() {
                AppMethodBeat.i(120865);
                aa eeX = aa.eeX();
                AppMethodBeat.o(120865);
                return eeX;
            }

            static /* synthetic */ c efu() {
                AppMethodBeat.i(120873);
                c cVar = new c();
                AppMethodBeat.o(120873);
                return cVar;
            }
        }

        public static final class a extends a.i.b.a.c.g.i implements b {
            public static a.i.b.a.c.g.s<a> BsC = new a.i.b.a.c.g.b<a>() {
                public final /* synthetic */ Object a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                    AppMethodBeat.i(120821);
                    a aVar = new a(eVar, gVar, (byte) 0);
                    AppMethodBeat.o(120821);
                    return aVar;
                }
            };
            private static final a Bvm;
            private final a.i.b.a.c.g.d BsB;
            private int BsD;
            private byte BsG;
            private int BsH;
            public b Bvn;
            public aa Bvo;
            public int Bvp;

            public enum b implements a.i.b.a.c.g.j.a {
                IN(0),
                OUT(1),
                INV(2),
                STAR(3);
                
                private static a.i.b.a.c.g.j.b<b> Btk;
                final int value;

                static {
                    Btk = new a.i.b.a.c.g.j.b<b>() {
                        public final /* synthetic */ a.i.b.a.c.g.j.a SW(int i) {
                            AppMethodBeat.i(120840);
                            b TD = b.TD(i);
                            AppMethodBeat.o(120840);
                            return TD;
                        }
                    };
                    AppMethodBeat.o(120843);
                }

                public final int edd() {
                    return this.value;
                }

                public static b TD(int i) {
                    switch (i) {
                        case 0:
                            return IN;
                        case 1:
                            return OUT;
                        case 2:
                            return INV;
                        case 3:
                            return STAR;
                        default:
                            return null;
                    }
                }

                private b(int i) {
                    this.value = i;
                }
            }

            public static final class a extends a.i.b.a.c.g.i.a<a, a> implements b {
                private int BsD;
                private b Bvn = b.INV;
                private aa Bvo = aa.eeX();
                private int Bvp;

                public final /* synthetic */ a.i.b.a.c.g.a.a c(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                    AppMethodBeat.i(120833);
                    a s = s(eVar, gVar);
                    AppMethodBeat.o(120833);
                    return s;
                }

                public final /* synthetic */ Object clone() {
                    AppMethodBeat.i(120838);
                    a efo = efo();
                    AppMethodBeat.o(120838);
                    return efo;
                }

                public final /* synthetic */ a.i.b.a.c.g.q.a d(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                    AppMethodBeat.i(120835);
                    a s = s(eVar, gVar);
                    AppMethodBeat.o(120835);
                    return s;
                }

                public final /* synthetic */ a.i.b.a.c.g.i.a ecK() {
                    AppMethodBeat.i(120832);
                    a efo = efo();
                    AppMethodBeat.o(120832);
                    return efo;
                }

                public final /* synthetic */ a.i.b.a.c.g.a.a ecL() {
                    AppMethodBeat.i(120834);
                    a efo = efo();
                    AppMethodBeat.o(120834);
                    return efo;
                }

                private a() {
                    AppMethodBeat.i(120822);
                    AppMethodBeat.o(120822);
                }

                private a efp() {
                    int i = 1;
                    AppMethodBeat.i(120824);
                    a aVar = new a((a.i.b.a.c.g.i.a) this, (byte) 0);
                    int i2 = this.BsD;
                    if ((i2 & 1) != 1) {
                        i = 0;
                    }
                    aVar.Bvn = this.Bvn;
                    if ((i2 & 2) == 2) {
                        i |= 2;
                    }
                    aVar.Bvo = this.Bvo;
                    if ((i2 & 4) == 4) {
                        i |= 4;
                    }
                    aVar.Bvp = this.Bvp;
                    aVar.BsD = i;
                    AppMethodBeat.o(120824);
                    return aVar;
                }

                public final a b(a aVar) {
                    AppMethodBeat.i(120825);
                    if (aVar == a.efl()) {
                        AppMethodBeat.o(120825);
                    } else {
                        if (aVar.efm()) {
                            a(aVar.Bvn);
                        }
                        if (aVar.ecP()) {
                            i(aVar.Bvo);
                        }
                        if (aVar.efn()) {
                            TC(aVar.Bvp);
                        }
                        this.BsB = this.BsB.a(aVar.BsB);
                        AppMethodBeat.o(120825);
                    }
                    return this;
                }

                /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                private a s(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                    a aVar;
                    Throwable th;
                    AppMethodBeat.i(120827);
                    a aVar2 = null;
                    try {
                        b((a) a.BsC.a(eVar, gVar));
                        AppMethodBeat.o(120827);
                        return this;
                    } catch (a.i.b.a.c.g.k e) {
                        a.i.b.a.c.g.k kVar = e;
                        aVar = (a) kVar.BzY;
                        AppMethodBeat.o(120827);
                        throw kVar;
                    } catch (Throwable th2) {
                        th = th2;
                        aVar2 = aVar;
                        if (aVar2 != null) {
                        }
                        AppMethodBeat.o(120827);
                        throw th;
                    }
                }

                private a a(b bVar) {
                    AppMethodBeat.i(120828);
                    if (bVar == null) {
                        NullPointerException nullPointerException = new NullPointerException();
                        AppMethodBeat.o(120828);
                        throw nullPointerException;
                    }
                    this.BsD |= 1;
                    this.Bvn = bVar;
                    AppMethodBeat.o(120828);
                    return this;
                }

                private a i(aa aaVar) {
                    AppMethodBeat.i(120829);
                    if ((this.BsD & 2) != 2 || this.Bvo == aa.eeX()) {
                        this.Bvo = aaVar;
                    } else {
                        this.Bvo = aa.f(this.Bvo).j(aaVar).eft();
                    }
                    this.BsD |= 2;
                    AppMethodBeat.o(120829);
                    return this;
                }

                private a TC(int i) {
                    this.BsD |= 4;
                    this.Bvp = i;
                    return this;
                }

                private a efo() {
                    AppMethodBeat.i(120823);
                    a b = new a().b(efp());
                    AppMethodBeat.o(120823);
                    return b;
                }

                public final boolean isInitialized() {
                    boolean z;
                    AppMethodBeat.i(120826);
                    if ((this.BsD & 2) == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z || this.Bvo.isInitialized()) {
                        AppMethodBeat.o(120826);
                        return true;
                    }
                    AppMethodBeat.o(120826);
                    return false;
                }

                public final /* synthetic */ a.i.b.a.c.g.i ecJ() {
                    AppMethodBeat.i(120830);
                    a efl = a.efl();
                    AppMethodBeat.o(120830);
                    return efl;
                }

                public final /* synthetic */ a.i.b.a.c.g.q ecM() {
                    AppMethodBeat.i(120836);
                    a efp = efp();
                    if (efp.isInitialized()) {
                        AppMethodBeat.o(120836);
                        return efp;
                    }
                    a.i.b.a.c.g.w wVar = new a.i.b.a.c.g.w();
                    AppMethodBeat.o(120836);
                    throw wVar;
                }

                public final /* synthetic */ a.i.b.a.c.g.q ecE() {
                    AppMethodBeat.i(120837);
                    a efl = a.efl();
                    AppMethodBeat.o(120837);
                    return efl;
                }

                static /* synthetic */ a efq() {
                    AppMethodBeat.i(120839);
                    a aVar = new a();
                    AppMethodBeat.o(120839);
                    return aVar;
                }
            }

            /* synthetic */ a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar, byte b) {
                this(eVar, gVar);
            }

            private a(a.i.b.a.c.g.i.a aVar) {
                super((byte) 0);
                this.BsG = (byte) -1;
                this.BsH = -1;
                this.BsB = aVar.BsB;
            }

            private a() {
                this.BsG = (byte) -1;
                this.BsH = -1;
                this.BsB = a.i.b.a.c.g.d.Bzq;
            }

            public static a efl() {
                return Bvm;
            }

            private a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120844);
                this.BsG = (byte) -1;
                this.BsH = -1;
                ecA();
                a.i.b.a.c.g.d.b ehS = a.i.b.a.c.g.d.ehS();
                a.i.b.a.c.g.f e = a.i.b.a.c.g.f.e(ehS, 1);
                int i = 0;
                while (i == 0) {
                    try {
                        int vc = eVar.vc();
                        switch (vc) {
                            case 0:
                                i = 1;
                                break;
                            case 8:
                                int vd = eVar.vd();
                                b TD = b.TD(vd);
                                if (TD != null) {
                                    this.BsD |= 1;
                                    this.Bvn = TD;
                                    break;
                                }
                                e.fw(vc);
                                e.fw(vd);
                                break;
                            case 18:
                                c efk;
                                if ((this.BsD & 2) == 2) {
                                    efk = this.Bvo.efk();
                                } else {
                                    efk = null;
                                }
                                this.Bvo = (aa) eVar.a(aa.BsC, gVar);
                                if (efk != null) {
                                    efk.j(this.Bvo);
                                    this.Bvo = efk.eft();
                                }
                                this.BsD |= 2;
                                break;
                            case 24:
                                this.BsD |= 4;
                                this.Bvp = eVar.vd();
                                break;
                            default:
                                if (!a(eVar, e, gVar, vc)) {
                                    i = 1;
                                    break;
                                }
                                break;
                        }
                    } catch (a.i.b.a.c.g.k e2) {
                        e2.BzY = this;
                        AppMethodBeat.o(120844);
                        throw e2;
                    } catch (IOException e3) {
                        a.i.b.a.c.g.k kVar = new a.i.b.a.c.g.k(e3.getMessage());
                        kVar.BzY = this;
                        AppMethodBeat.o(120844);
                        throw kVar;
                    } catch (Throwable th) {
                        try {
                            e.flush();
                            this.BsB = ehS.ehW();
                        } catch (IOException e4) {
                            this.BsB = ehS.ehW();
                        } catch (Throwable th2) {
                            this.BsB = ehS.ehW();
                            AppMethodBeat.o(120844);
                        }
                        eio();
                        AppMethodBeat.o(120844);
                    }
                }
                try {
                    e.flush();
                    this.BsB = ehS.ehW();
                } catch (IOException e5) {
                    this.BsB = ehS.ehW();
                } catch (Throwable th3) {
                    this.BsB = ehS.ehW();
                    AppMethodBeat.o(120844);
                }
                eio();
                AppMethodBeat.o(120844);
            }

            static {
                AppMethodBeat.i(120851);
                a aVar = new a();
                Bvm = aVar;
                aVar.ecA();
                AppMethodBeat.o(120851);
            }

            public final a.i.b.a.c.g.s<a> ecy() {
                return BsC;
            }

            public final boolean efm() {
                return (this.BsD & 1) == 1;
            }

            public final boolean ecP() {
                return (this.BsD & 2) == 2;
            }

            public final boolean efn() {
                return (this.BsD & 4) == 4;
            }

            private void ecA() {
                AppMethodBeat.i(120845);
                this.Bvn = b.INV;
                this.Bvo = aa.eeX();
                this.Bvp = 0;
                AppMethodBeat.o(120845);
            }

            public final boolean isInitialized() {
                AppMethodBeat.i(120846);
                byte b = this.BsG;
                if (b == (byte) 1) {
                    AppMethodBeat.o(120846);
                    return true;
                } else if (b == (byte) 0) {
                    AppMethodBeat.o(120846);
                    return false;
                } else if (!ecP() || this.Bvo.isInitialized()) {
                    this.BsG = (byte) 1;
                    AppMethodBeat.o(120846);
                    return true;
                } else {
                    this.BsG = (byte) 0;
                    AppMethodBeat.o(120846);
                    return false;
                }
            }

            public final void a(a.i.b.a.c.g.f fVar) {
                AppMethodBeat.i(120847);
                vq();
                if ((this.BsD & 1) == 1) {
                    fVar.io(1, this.Bvn.value);
                }
                if ((this.BsD & 2) == 2) {
                    fVar.a(2, this.Bvo);
                }
                if ((this.BsD & 4) == 4) {
                    fVar.bq(3, this.Bvp);
                }
                fVar.d(this.BsB);
                AppMethodBeat.o(120847);
            }

            public final int vq() {
                AppMethodBeat.i(120848);
                int i = this.BsH;
                if (i != -1) {
                    AppMethodBeat.o(120848);
                    return i;
                }
                i = 0;
                if ((this.BsD & 1) == 1) {
                    i = a.i.b.a.c.g.f.ip(1, this.Bvn.value) + 0;
                }
                if ((this.BsD & 2) == 2) {
                    i += a.i.b.a.c.g.f.c(2, this.Bvo);
                }
                if ((this.BsD & 4) == 4) {
                    i += a.i.b.a.c.g.f.bs(3, this.Bvp);
                }
                i += this.BsB.size();
                this.BsH = i;
                AppMethodBeat.o(120848);
                return i;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a ecC() {
                AppMethodBeat.i(120849);
                a b = a.efq().b(this);
                AppMethodBeat.o(120849);
                return b;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a ecD() {
                AppMethodBeat.i(120850);
                a efq = a.efq();
                AppMethodBeat.o(120850);
                return efq;
            }

            public final /* bridge */ /* synthetic */ a.i.b.a.c.g.q ecE() {
                return Bvm;
            }
        }

        /* synthetic */ aa(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar, byte b) {
            this(eVar, gVar);
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecC() {
            AppMethodBeat.i(120882);
            c efk = efk();
            AppMethodBeat.o(120882);
            return efk;
        }

        private aa(a.i.b.a.c.g.i.b<aa, ?> bVar) {
            super(bVar);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = bVar.BsB;
        }

        private aa() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = a.i.b.a.c.g.d.Bzq;
        }

        public static aa eeX() {
            return BuZ;
        }

        private aa(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
            AppMethodBeat.i(120874);
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            a.i.b.a.c.g.d.b ehS = a.i.b.a.c.g.d.ehS();
            a.i.b.a.c.g.f e = a.i.b.a.c.g.f.e(ehS, 1);
            int i = 0;
            int i2 = 0;
            while (i == 0) {
                try {
                    int vc = eVar.vc();
                    c j;
                    switch (vc) {
                        case 0:
                            i = 1;
                            break;
                        case 8:
                            this.BsD |= 4096;
                            this.BsW = eVar.vd();
                            break;
                        case 18:
                            if ((i2 & 1) != 1) {
                                this.BsF = new ArrayList();
                                i2 |= 1;
                            }
                            this.BsF.add(eVar.a(a.BsC, gVar));
                            break;
                        case 24:
                            this.BsD |= 1;
                            this.Bva = eVar.ehX();
                            break;
                        case 32:
                            this.BsD |= 2;
                            this.Bvb = eVar.vd();
                            break;
                        case 42:
                            if ((this.BsD & 4) == 4) {
                                j = c.efu().j(this.Bvc);
                            } else {
                                j = null;
                            }
                            this.Bvc = (aa) eVar.a(BsC, gVar);
                            if (j != null) {
                                j.j(this.Bvc);
                                this.Bvc = j.eft();
                            }
                            this.BsD |= 4;
                            break;
                        case 48:
                            this.BsD |= 16;
                            this.Bve = eVar.vd();
                            break;
                        case FileUtils.S_IRWXG /*56*/:
                            this.BsD |= 32;
                            this.Bvf = eVar.vd();
                            break;
                        case 64:
                            this.BsD |= 8;
                            this.Bvd = eVar.vd();
                            break;
                        case com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX /*72*/:
                            this.BsD |= 64;
                            this.Bvg = eVar.vd();
                            break;
                        case 82:
                            if ((this.BsD & 256) == 256) {
                                j = c.efu().j(this.Bvi);
                            } else {
                                j = null;
                            }
                            this.Bvi = (aa) eVar.a(BsC, gVar);
                            if (j != null) {
                                j.j(this.Bvi);
                                this.Bvi = j.eft();
                            }
                            this.BsD |= 256;
                            break;
                        case 88:
                            this.BsD |= 512;
                            this.Bvj = eVar.vd();
                            break;
                        case 96:
                            this.BsD |= 128;
                            this.Bvh = eVar.vd();
                            break;
                        case 106:
                            if ((this.BsD & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                                j = c.efu().j(this.Bvk);
                            } else {
                                j = null;
                            }
                            this.Bvk = (aa) eVar.a(BsC, gVar);
                            if (j != null) {
                                j.j(this.Bvk);
                                this.Bvk = j.eft();
                            }
                            this.BsD |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                            break;
                        case 112:
                            this.BsD |= 2048;
                            this.Bvl = eVar.vd();
                            break;
                        default:
                            if (!a(eVar, e, gVar, vc)) {
                                i = 1;
                                break;
                            }
                            break;
                    }
                } catch (a.i.b.a.c.g.k e2) {
                    e2.BzY = this;
                    AppMethodBeat.o(120874);
                    throw e2;
                } catch (IOException e3) {
                    a.i.b.a.c.g.k kVar = new a.i.b.a.c.g.k(e3.getMessage());
                    kVar.BzY = this;
                    AppMethodBeat.o(120874);
                    throw kVar;
                } catch (Throwable th) {
                    if ((i2 & 1) == 1) {
                        this.BsF = Collections.unmodifiableList(this.BsF);
                    }
                    try {
                        e.flush();
                        this.BsB = ehS.ehW();
                    } catch (IOException e4) {
                        this.BsB = ehS.ehW();
                    } catch (Throwable th2) {
                        this.BsB = ehS.ehW();
                        AppMethodBeat.o(120874);
                    }
                    this.BzI.eii();
                    AppMethodBeat.o(120874);
                }
            }
            if ((i2 & 1) == 1) {
                this.BsF = Collections.unmodifiableList(this.BsF);
            }
            try {
                e.flush();
                this.BsB = ehS.ehW();
            } catch (IOException e5) {
                this.BsB = ehS.ehW();
            } catch (Throwable th3) {
                this.BsB = ehS.ehW();
                AppMethodBeat.o(120874);
            }
            this.BzI.eii();
            AppMethodBeat.o(120874);
        }

        static {
            AppMethodBeat.i(120884);
            aa aaVar = new aa();
            BuZ = aaVar;
            aaVar.ecA();
            AppMethodBeat.o(120884);
        }

        public final a.i.b.a.c.g.s<aa> ecy() {
            return BsC;
        }

        public final int getArgumentCount() {
            AppMethodBeat.i(120875);
            int size = this.BsF.size();
            AppMethodBeat.o(120875);
            return size;
        }

        public final boolean eeY() {
            return (this.BsD & 1) == 1;
        }

        public final boolean eeZ() {
            return (this.BsD & 2) == 2;
        }

        public final boolean efa() {
            return (this.BsD & 4) == 4;
        }

        public final boolean efb() {
            return (this.BsD & 8) == 8;
        }

        public final boolean efc() {
            return (this.BsD & 16) == 16;
        }

        public final boolean efd() {
            return (this.BsD & 32) == 32;
        }

        public final boolean efe() {
            return (this.BsD & 64) == 64;
        }

        public final boolean eff() {
            return (this.BsD & 128) == 128;
        }

        public final boolean efg() {
            return (this.BsD & 256) == 256;
        }

        public final boolean efh() {
            return (this.BsD & 512) == 512;
        }

        public final boolean efi() {
            return (this.BsD & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        }

        public final boolean efj() {
            return (this.BsD & 2048) == 2048;
        }

        public final boolean ecY() {
            return (this.BsD & 4096) == 4096;
        }

        private void ecA() {
            AppMethodBeat.i(120876);
            this.BsF = Collections.emptyList();
            this.Bva = false;
            this.Bvb = 0;
            this.Bvc = BuZ;
            this.Bvd = 0;
            this.Bve = 0;
            this.Bvf = 0;
            this.Bvg = 0;
            this.Bvh = 0;
            this.Bvi = BuZ;
            this.Bvj = 0;
            this.Bvk = BuZ;
            this.Bvl = 0;
            this.BsW = 0;
            AppMethodBeat.o(120876);
        }

        public final boolean isInitialized() {
            AppMethodBeat.i(120877);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.o(120877);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.o(120877);
                return false;
            } else {
                int i = 0;
                while (i < getArgumentCount()) {
                    if (((a) this.BsF.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120877);
                        return false;
                    }
                }
                if (efa() && !this.Bvc.isInitialized()) {
                    this.BsG = (byte) 0;
                    AppMethodBeat.o(120877);
                    return false;
                } else if (efg() && !this.Bvi.isInitialized()) {
                    this.BsG = (byte) 0;
                    AppMethodBeat.o(120877);
                    return false;
                } else if (efi() && !this.Bvk.isInitialized()) {
                    this.BsG = (byte) 0;
                    AppMethodBeat.o(120877);
                    return false;
                } else if (this.BzI.isInitialized()) {
                    this.BsG = (byte) 1;
                    AppMethodBeat.o(120877);
                    return true;
                } else {
                    this.BsG = (byte) 0;
                    AppMethodBeat.o(120877);
                    return false;
                }
            }
        }

        public final void a(a.i.b.a.c.g.f fVar) {
            AppMethodBeat.i(120878);
            vq();
            a.i.b.a.c.g.i.c.a eip = eip();
            if ((this.BsD & 4096) == 4096) {
                fVar.bq(1, this.BsW);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.BsF.size()) {
                    break;
                }
                fVar.a(2, (a.i.b.a.c.g.q) this.BsF.get(i2));
                i = i2 + 1;
            }
            if ((this.BsD & 1) == 1) {
                fVar.rP(this.Bva);
            }
            if ((this.BsD & 2) == 2) {
                fVar.bq(4, this.Bvb);
            }
            if ((this.BsD & 4) == 4) {
                fVar.a(5, this.Bvc);
            }
            if ((this.BsD & 16) == 16) {
                fVar.bq(6, this.Bve);
            }
            if ((this.BsD & 32) == 32) {
                fVar.bq(7, this.Bvf);
            }
            if ((this.BsD & 8) == 8) {
                fVar.bq(8, this.Bvd);
            }
            if ((this.BsD & 64) == 64) {
                fVar.bq(9, this.Bvg);
            }
            if ((this.BsD & 256) == 256) {
                fVar.a(10, this.Bvi);
            }
            if ((this.BsD & 512) == 512) {
                fVar.bq(11, this.Bvj);
            }
            if ((this.BsD & 128) == 128) {
                fVar.bq(12, this.Bvh);
            }
            if ((this.BsD & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                fVar.a(13, this.Bvk);
            }
            if ((this.BsD & 2048) == 2048) {
                fVar.bq(14, this.Bvl);
            }
            eip.b(200, fVar);
            fVar.d(this.BsB);
            AppMethodBeat.o(120878);
        }

        public final int vq() {
            int i = 0;
            AppMethodBeat.i(120879);
            int i2 = this.BsH;
            if (i2 != -1) {
                AppMethodBeat.o(120879);
                return i2;
            }
            int i3;
            if ((this.BsD & 4096) == 4096) {
                i2 = a.i.b.a.c.g.f.bs(1, this.BsW) + 0;
            } else {
                i2 = 0;
            }
            while (true) {
                i3 = i2;
                if (i >= this.BsF.size()) {
                    break;
                }
                i2 = a.i.b.a.c.g.f.c(2, (a.i.b.a.c.g.q) this.BsF.get(i)) + i3;
                i++;
            }
            if ((this.BsD & 1) == 1) {
                i3 += a.i.b.a.c.g.f.fv(3) + 1;
            }
            if ((this.BsD & 2) == 2) {
                i3 += a.i.b.a.c.g.f.bs(4, this.Bvb);
            }
            if ((this.BsD & 4) == 4) {
                i3 += a.i.b.a.c.g.f.c(5, this.Bvc);
            }
            if ((this.BsD & 16) == 16) {
                i3 += a.i.b.a.c.g.f.bs(6, this.Bve);
            }
            if ((this.BsD & 32) == 32) {
                i3 += a.i.b.a.c.g.f.bs(7, this.Bvf);
            }
            if ((this.BsD & 8) == 8) {
                i3 += a.i.b.a.c.g.f.bs(8, this.Bvd);
            }
            if ((this.BsD & 64) == 64) {
                i3 += a.i.b.a.c.g.f.bs(9, this.Bvg);
            }
            if ((this.BsD & 256) == 256) {
                i3 += a.i.b.a.c.g.f.c(10, this.Bvi);
            }
            if ((this.BsD & 512) == 512) {
                i3 += a.i.b.a.c.g.f.bs(11, this.Bvj);
            }
            if ((this.BsD & 128) == 128) {
                i3 += a.i.b.a.c.g.f.bs(12, this.Bvh);
            }
            if ((this.BsD & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                i3 += a.i.b.a.c.g.f.c(13, this.Bvk);
            }
            if ((this.BsD & 2048) == 2048) {
                i3 += a.i.b.a.c.g.f.bs(14, this.Bvl);
            }
            i2 = (this.BzI.vq() + i3) + this.BsB.size();
            this.BsH = i2;
            AppMethodBeat.o(120879);
            return i2;
        }

        public static c f(aa aaVar) {
            AppMethodBeat.i(139059);
            c j = c.efu().j(aaVar);
            AppMethodBeat.o(139059);
            return j;
        }

        public final c efk() {
            AppMethodBeat.i(139060);
            c j = c.efu().j(this);
            AppMethodBeat.o(139060);
            return j;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.g.q ecE() {
            return BuZ;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecD() {
            AppMethodBeat.i(120883);
            c efu = c.efu();
            AppMethodBeat.o(120883);
            return efu;
        }
    }

    public interface ac extends a.i.b.a.c.g.i.d {
    }

    public interface b extends a.i.b.a.c.g.r {
    }

    public static final class k extends a.i.b.a.c.g.i.c<k> implements l {
        public static a.i.b.a.c.g.s<k> BsC = new a.i.b.a.c.g.b<k>() {
            public final /* synthetic */ Object a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120577);
                k kVar = new k(eVar, gVar, (byte) 0);
                AppMethodBeat.o(120577);
                return kVar;
            }
        };
        private static final k Bue;
        private final a.i.b.a.c.g.d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        public int Buf;

        public static final class a extends a.i.b.a.c.g.i.b<k, a> implements l {
            private int BsD;
            private int Buf;

            public final /* synthetic */ a.i.b.a.c.g.i.a a(a.i.b.a.c.g.i iVar) {
                AppMethodBeat.i(120586);
                a b = b((k) iVar);
                AppMethodBeat.o(120586);
                return b;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a c(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120588);
                a k = k(eVar, gVar);
                AppMethodBeat.o(120588);
                return k;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(120592);
                a edX = edX();
                AppMethodBeat.o(120592);
                return edX;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a d(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120590);
                a k = k(eVar, gVar);
                AppMethodBeat.o(120590);
                return k;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.a ecK() {
                AppMethodBeat.i(120587);
                a edX = edX();
                AppMethodBeat.o(120587);
                return edX;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a ecL() {
                AppMethodBeat.i(120589);
                a edX = edX();
                AppMethodBeat.o(120589);
                return edX;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.b edA() {
                AppMethodBeat.i(120583);
                a edX = edX();
                AppMethodBeat.o(120583);
                return edX;
            }

            private a() {
            }

            private k edY() {
                int i = 1;
                AppMethodBeat.i(120579);
                k kVar = new k((a.i.b.a.c.g.i.b) this, (byte) 0);
                if ((this.BsD & 1) != 1) {
                    i = 0;
                }
                kVar.Buf = this.Buf;
                kVar.BsD = i;
                AppMethodBeat.o(120579);
                return kVar;
            }

            public final a b(k kVar) {
                AppMethodBeat.i(120580);
                if (kVar == k.edV()) {
                    AppMethodBeat.o(120580);
                } else {
                    if (kVar.edW()) {
                        Tf(kVar.Buf);
                    }
                    a((a.i.b.a.c.g.i.c) kVar);
                    this.BsB = this.BsB.a(kVar.BsB);
                    AppMethodBeat.o(120580);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private a k(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                k kVar;
                Throwable th;
                AppMethodBeat.i(120582);
                k kVar2 = null;
                try {
                    b((k) k.BsC.a(eVar, gVar));
                    AppMethodBeat.o(120582);
                    return this;
                } catch (a.i.b.a.c.g.k e) {
                    a.i.b.a.c.g.k kVar3 = e;
                    kVar = (k) kVar3.BzY;
                    AppMethodBeat.o(120582);
                    throw kVar3;
                } catch (Throwable th2) {
                    th = th2;
                    kVar2 = kVar;
                    if (kVar2 != null) {
                    }
                    AppMethodBeat.o(120582);
                    throw th;
                }
            }

            private a Tf(int i) {
                this.BsD |= 1;
                this.Buf = i;
                return this;
            }

            private a edX() {
                AppMethodBeat.i(120578);
                a b = new a().b(edY());
                AppMethodBeat.o(120578);
                return b;
            }

            public final boolean isInitialized() {
                AppMethodBeat.i(120581);
                if (this.BzI.isInitialized()) {
                    AppMethodBeat.o(120581);
                    return true;
                }
                AppMethodBeat.o(120581);
                return false;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecE() {
                AppMethodBeat.i(120584);
                k edV = k.edV();
                AppMethodBeat.o(120584);
                return edV;
            }

            public final /* synthetic */ a.i.b.a.c.g.i ecJ() {
                AppMethodBeat.i(120585);
                k edV = k.edV();
                AppMethodBeat.o(120585);
                return edV;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecM() {
                AppMethodBeat.i(120591);
                k edY = edY();
                if (edY.isInitialized()) {
                    AppMethodBeat.o(120591);
                    return edY;
                }
                a.i.b.a.c.g.w wVar = new a.i.b.a.c.g.w();
                AppMethodBeat.o(120591);
                throw wVar;
            }

            static /* synthetic */ a edZ() {
                AppMethodBeat.i(120593);
                a aVar = new a();
                AppMethodBeat.o(120593);
                return aVar;
            }
        }

        /* synthetic */ k(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar, byte b) {
            this(eVar, gVar);
        }

        private k(a.i.b.a.c.g.i.b<k, ?> bVar) {
            super(bVar);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = bVar.BsB;
        }

        private k() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = a.i.b.a.c.g.d.Bzq;
        }

        public static k edV() {
            return Bue;
        }

        private k(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
            int i = 0;
            AppMethodBeat.i(120594);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.Buf = 0;
            a.i.b.a.c.g.d.b ehS = a.i.b.a.c.g.d.ehS();
            a.i.b.a.c.g.f e = a.i.b.a.c.g.f.e(ehS, 1);
            while (i == 0) {
                try {
                    int vc = eVar.vc();
                    switch (vc) {
                        case 0:
                            i = 1;
                            break;
                        case 8:
                            this.BsD |= 1;
                            this.Buf = eVar.vd();
                            break;
                        default:
                            if (!a(eVar, e, gVar, vc)) {
                                i = 1;
                                break;
                            }
                            break;
                    }
                } catch (a.i.b.a.c.g.k e2) {
                    e2.BzY = this;
                    AppMethodBeat.o(120594);
                    throw e2;
                } catch (IOException e3) {
                    a.i.b.a.c.g.k kVar = new a.i.b.a.c.g.k(e3.getMessage());
                    kVar.BzY = this;
                    AppMethodBeat.o(120594);
                    throw kVar;
                } catch (Throwable th) {
                    try {
                        e.flush();
                        this.BsB = ehS.ehW();
                    } catch (IOException e4) {
                        this.BsB = ehS.ehW();
                    } catch (Throwable th2) {
                        this.BsB = ehS.ehW();
                        AppMethodBeat.o(120594);
                    }
                    this.BzI.eii();
                    AppMethodBeat.o(120594);
                }
            }
            try {
                e.flush();
                this.BsB = ehS.ehW();
            } catch (IOException e5) {
                this.BsB = ehS.ehW();
            } catch (Throwable th3) {
                this.BsB = ehS.ehW();
                AppMethodBeat.o(120594);
            }
            this.BzI.eii();
            AppMethodBeat.o(120594);
        }

        static {
            AppMethodBeat.i(120600);
            k kVar = new k();
            Bue = kVar;
            kVar.Buf = 0;
            AppMethodBeat.o(120600);
        }

        public final a.i.b.a.c.g.s<k> ecy() {
            return BsC;
        }

        public final boolean edW() {
            return (this.BsD & 1) == 1;
        }

        public final boolean isInitialized() {
            AppMethodBeat.i(120595);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.o(120595);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.o(120595);
                return false;
            } else if (this.BzI.isInitialized()) {
                this.BsG = (byte) 1;
                AppMethodBeat.o(120595);
                return true;
            } else {
                this.BsG = (byte) 0;
                AppMethodBeat.o(120595);
                return false;
            }
        }

        public final void a(a.i.b.a.c.g.f fVar) {
            AppMethodBeat.i(120596);
            vq();
            a.i.b.a.c.g.i.c.a eip = eip();
            if ((this.BsD & 1) == 1) {
                fVar.bq(1, this.Buf);
            }
            eip.b(200, fVar);
            fVar.d(this.BsB);
            AppMethodBeat.o(120596);
        }

        public final int vq() {
            AppMethodBeat.i(120597);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.o(120597);
                return i;
            }
            i = 0;
            if ((this.BsD & 1) == 1) {
                i = a.i.b.a.c.g.f.bs(1, this.Buf) + 0;
            }
            i = (i + this.BzI.vq()) + this.BsB.size();
            this.BsH = i;
            AppMethodBeat.o(120597);
            return i;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.g.q ecE() {
            return Bue;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecC() {
            AppMethodBeat.i(120598);
            a b = a.edZ().b(this);
            AppMethodBeat.o(120598);
            return b;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecD() {
            AppMethodBeat.i(120599);
            a edZ = a.edZ();
            AppMethodBeat.o(120599);
            return edZ;
        }
    }

    public static final class i extends a.i.b.a.c.g.i implements j {
        public static a.i.b.a.c.g.s<i> BsC = new a.i.b.a.c.g.b<i>() {
            public final /* synthetic */ Object a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120540);
                i iVar = new i(eVar, gVar, (byte) 0);
                AppMethodBeat.o(120540);
                return iVar;
            }
        };
        private static final i BtR;
        private final a.i.b.a.c.g.d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        b BtS;
        private List<m> BtT;
        m BtU;
        c BtV;

        public enum c implements a.i.b.a.c.g.j.a {
            AT_MOST_ONCE(0),
            EXACTLY_ONCE(1),
            AT_LEAST_ONCE(2);
            
            private static a.i.b.a.c.g.j.b<c> Btk;
            final int value;

            static {
                Btk = new a.i.b.a.c.g.j.b<c>() {
                    public final /* synthetic */ a.i.b.a.c.g.j.a SW(int i) {
                        AppMethodBeat.i(120565);
                        c Te = c.Te(i);
                        AppMethodBeat.o(120565);
                        return Te;
                    }
                };
                AppMethodBeat.o(120568);
            }

            public final int edd() {
                return this.value;
            }

            public static c Te(int i) {
                switch (i) {
                    case 0:
                        return AT_MOST_ONCE;
                    case 1:
                        return EXACTLY_ONCE;
                    case 2:
                        return AT_LEAST_ONCE;
                    default:
                        return null;
                }
            }

            private c(int i) {
                this.value = i;
            }
        }

        public static final class a extends a.i.b.a.c.g.i.a<i, a> implements j {
            private int BsD;
            private b BtS = b.RETURNS_CONSTANT;
            private List<m> BtT = Collections.emptyList();
            private m BtU = m.eea();
            private c BtV = c.AT_MOST_ONCE;

            public final /* synthetic */ a.i.b.a.c.g.a.a c(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120554);
                a j = j(eVar, gVar);
                AppMethodBeat.o(120554);
                return j;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(120559);
                a edR = edR();
                AppMethodBeat.o(120559);
                return edR;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a d(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120556);
                a j = j(eVar, gVar);
                AppMethodBeat.o(120556);
                return j;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.a ecK() {
                AppMethodBeat.i(120553);
                a edR = edR();
                AppMethodBeat.o(120553);
                return edR;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a ecL() {
                AppMethodBeat.i(120555);
                a edR = edR();
                AppMethodBeat.o(120555);
                return edR;
            }

            private a() {
                AppMethodBeat.i(120541);
                AppMethodBeat.o(120541);
            }

            private i edS() {
                int i = 1;
                AppMethodBeat.i(120543);
                i iVar = new i((a.i.b.a.c.g.i.a) this, (byte) 0);
                int i2 = this.BsD;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                iVar.BtS = this.BtS;
                if ((this.BsD & 2) == 2) {
                    this.BtT = Collections.unmodifiableList(this.BtT);
                    this.BsD &= -3;
                }
                iVar.BtT = this.BtT;
                if ((i2 & 4) == 4) {
                    i |= 2;
                }
                iVar.BtU = this.BtU;
                if ((i2 & 8) == 8) {
                    i |= 4;
                }
                iVar.BtV = this.BtV;
                iVar.BsD = i;
                AppMethodBeat.o(120543);
                return iVar;
            }

            public final a c(i iVar) {
                AppMethodBeat.i(120544);
                if (iVar == i.edN()) {
                    AppMethodBeat.o(120544);
                } else {
                    if (iVar.edO()) {
                        a(iVar.BtS);
                    }
                    if (!iVar.BtT.isEmpty()) {
                        if (this.BtT.isEmpty()) {
                            this.BtT = iVar.BtT;
                            this.BsD &= -3;
                        } else {
                            edT();
                            this.BtT.addAll(iVar.BtT);
                        }
                    }
                    if (iVar.edP()) {
                        a(iVar.BtU);
                    }
                    if (iVar.edQ()) {
                        a(iVar.BtV);
                    }
                    this.BsB = this.BsB.a(iVar.BsB);
                    AppMethodBeat.o(120544);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private a j(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                i iVar;
                Throwable th;
                AppMethodBeat.i(120546);
                i iVar2 = null;
                try {
                    c((i) i.BsC.a(eVar, gVar));
                    AppMethodBeat.o(120546);
                    return this;
                } catch (a.i.b.a.c.g.k e) {
                    a.i.b.a.c.g.k kVar = e;
                    iVar = (i) kVar.BzY;
                    AppMethodBeat.o(120546);
                    throw kVar;
                } catch (Throwable th2) {
                    th = th2;
                    iVar2 = iVar;
                    if (iVar2 != null) {
                    }
                    AppMethodBeat.o(120546);
                    throw th;
                }
            }

            private a a(b bVar) {
                AppMethodBeat.i(120547);
                if (bVar == null) {
                    NullPointerException nullPointerException = new NullPointerException();
                    AppMethodBeat.o(120547);
                    throw nullPointerException;
                }
                this.BsD |= 1;
                this.BtS = bVar;
                AppMethodBeat.o(120547);
                return this;
            }

            private void edT() {
                AppMethodBeat.i(120548);
                if ((this.BsD & 2) != 2) {
                    this.BtT = new ArrayList(this.BtT);
                    this.BsD |= 2;
                }
                AppMethodBeat.o(120548);
            }

            private a a(m mVar) {
                AppMethodBeat.i(120549);
                if ((this.BsD & 4) != 4 || this.BtU == m.eea()) {
                    this.BtU = mVar;
                } else {
                    this.BtU = m.b(this.BtU).f(mVar).eeg();
                }
                this.BsD |= 4;
                AppMethodBeat.o(120549);
                return this;
            }

            private a a(c cVar) {
                AppMethodBeat.i(120550);
                if (cVar == null) {
                    NullPointerException nullPointerException = new NullPointerException();
                    AppMethodBeat.o(120550);
                    throw nullPointerException;
                }
                this.BsD |= 8;
                this.BtV = cVar;
                AppMethodBeat.o(120550);
                return this;
            }

            private a edR() {
                AppMethodBeat.i(120542);
                a c = new a().c(edS());
                AppMethodBeat.o(120542);
                return c;
            }

            public final boolean isInitialized() {
                boolean z;
                AppMethodBeat.i(120545);
                int i = 0;
                while (i < this.BtT.size()) {
                    if (((m) this.BtT.get(i)).isInitialized()) {
                        i++;
                    } else {
                        AppMethodBeat.o(120545);
                        return false;
                    }
                }
                if ((this.BsD & 4) == 4) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z || this.BtU.isInitialized()) {
                    AppMethodBeat.o(120545);
                    return true;
                }
                AppMethodBeat.o(120545);
                return false;
            }

            public final /* synthetic */ a.i.b.a.c.g.i ecJ() {
                AppMethodBeat.i(120551);
                i edN = i.edN();
                AppMethodBeat.o(120551);
                return edN;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecM() {
                AppMethodBeat.i(120557);
                i edS = edS();
                if (edS.isInitialized()) {
                    AppMethodBeat.o(120557);
                    return edS;
                }
                a.i.b.a.c.g.w wVar = new a.i.b.a.c.g.w();
                AppMethodBeat.o(120557);
                throw wVar;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecE() {
                AppMethodBeat.i(120558);
                i edN = i.edN();
                AppMethodBeat.o(120558);
                return edN;
            }

            static /* synthetic */ a edU() {
                AppMethodBeat.i(120560);
                a aVar = new a();
                AppMethodBeat.o(120560);
                return aVar;
            }
        }

        public enum b implements a.i.b.a.c.g.j.a {
            RETURNS_CONSTANT(0),
            CALLS(1),
            RETURNS_NOT_NULL(2);
            
            private static a.i.b.a.c.g.j.b<b> Btk;
            final int value;

            static {
                Btk = new a.i.b.a.c.g.j.b<b>() {
                    public final /* synthetic */ a.i.b.a.c.g.j.a SW(int i) {
                        AppMethodBeat.i(120561);
                        b Td = b.Td(i);
                        AppMethodBeat.o(120561);
                        return Td;
                    }
                };
                AppMethodBeat.o(120564);
            }

            public final int edd() {
                return this.value;
            }

            public static b Td(int i) {
                switch (i) {
                    case 0:
                        return RETURNS_CONSTANT;
                    case 1:
                        return CALLS;
                    case 2:
                        return RETURNS_NOT_NULL;
                    default:
                        return null;
                }
            }

            private b(int i) {
                this.value = i;
            }
        }

        /* synthetic */ i(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar, byte b) {
            this(eVar, gVar);
        }

        private i(a.i.b.a.c.g.i.a aVar) {
            super((byte) 0);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = aVar.BsB;
        }

        private i() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = a.i.b.a.c.g.d.Bzq;
        }

        public static i edN() {
            return BtR;
        }

        private i(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
            AppMethodBeat.i(120569);
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            a.i.b.a.c.g.d.b ehS = a.i.b.a.c.g.d.ehS();
            a.i.b.a.c.g.f e = a.i.b.a.c.g.f.e(ehS, 1);
            int i = 0;
            int i2 = 0;
            while (i == 0) {
                try {
                    int vc = eVar.vc();
                    int vd;
                    switch (vc) {
                        case 0:
                            i = 1;
                            break;
                        case 8:
                            vd = eVar.vd();
                            b Td = b.Td(vd);
                            if (Td != null) {
                                this.BsD |= 1;
                                this.BtS = Td;
                                break;
                            }
                            e.fw(vc);
                            e.fw(vd);
                            break;
                        case 18:
                            if ((i2 & 2) != 2) {
                                this.BtT = new ArrayList();
                                i2 |= 2;
                            }
                            this.BtT.add(eVar.a(m.BsC, gVar));
                            break;
                        case 26:
                            a b;
                            if ((this.BsD & 2) == 2) {
                                b = m.b(this.BtU);
                            } else {
                                b = null;
                            }
                            this.BtU = (m) eVar.a(m.BsC, gVar);
                            if (b != null) {
                                b.f(this.BtU);
                                this.BtU = b.eeg();
                            }
                            this.BsD |= 2;
                            break;
                        case 32:
                            vd = eVar.vd();
                            c Te = c.Te(vd);
                            if (Te != null) {
                                this.BsD |= 4;
                                this.BtV = Te;
                                break;
                            }
                            e.fw(vc);
                            e.fw(vd);
                            break;
                        default:
                            if (!a(eVar, e, gVar, vc)) {
                                i = 1;
                                break;
                            }
                            break;
                    }
                } catch (a.i.b.a.c.g.k e2) {
                    e2.BzY = this;
                    AppMethodBeat.o(120569);
                    throw e2;
                } catch (IOException e3) {
                    a.i.b.a.c.g.k kVar = new a.i.b.a.c.g.k(e3.getMessage());
                    kVar.BzY = this;
                    AppMethodBeat.o(120569);
                    throw kVar;
                } catch (Throwable th) {
                    if ((i2 & 2) == 2) {
                        this.BtT = Collections.unmodifiableList(this.BtT);
                    }
                    try {
                        e.flush();
                        this.BsB = ehS.ehW();
                    } catch (IOException e4) {
                        this.BsB = ehS.ehW();
                    } catch (Throwable th2) {
                        this.BsB = ehS.ehW();
                        AppMethodBeat.o(120569);
                    }
                    eio();
                    AppMethodBeat.o(120569);
                }
            }
            if ((i2 & 2) == 2) {
                this.BtT = Collections.unmodifiableList(this.BtT);
            }
            try {
                e.flush();
                this.BsB = ehS.ehW();
            } catch (IOException e5) {
                this.BsB = ehS.ehW();
            } catch (Throwable th3) {
                this.BsB = ehS.ehW();
                AppMethodBeat.o(120569);
            }
            eio();
            AppMethodBeat.o(120569);
        }

        static {
            AppMethodBeat.i(120576);
            i iVar = new i();
            BtR = iVar;
            iVar.ecA();
            AppMethodBeat.o(120576);
        }

        public final a.i.b.a.c.g.s<i> ecy() {
            return BsC;
        }

        public final boolean edO() {
            return (this.BsD & 1) == 1;
        }

        public final boolean edP() {
            return (this.BsD & 2) == 2;
        }

        public final boolean edQ() {
            return (this.BsD & 4) == 4;
        }

        private void ecA() {
            AppMethodBeat.i(120570);
            this.BtS = b.RETURNS_CONSTANT;
            this.BtT = Collections.emptyList();
            this.BtU = m.eea();
            this.BtV = c.AT_MOST_ONCE;
            AppMethodBeat.o(120570);
        }

        public final boolean isInitialized() {
            AppMethodBeat.i(120571);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.o(120571);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.o(120571);
                return false;
            } else {
                int i = 0;
                while (i < this.BtT.size()) {
                    if (((m) this.BtT.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120571);
                        return false;
                    }
                }
                if (!edP() || this.BtU.isInitialized()) {
                    this.BsG = (byte) 1;
                    AppMethodBeat.o(120571);
                    return true;
                }
                this.BsG = (byte) 0;
                AppMethodBeat.o(120571);
                return false;
            }
        }

        public final void a(a.i.b.a.c.g.f fVar) {
            AppMethodBeat.i(120572);
            vq();
            if ((this.BsD & 1) == 1) {
                fVar.io(1, this.BtS.value);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.BtT.size()) {
                    break;
                }
                fVar.a(2, (a.i.b.a.c.g.q) this.BtT.get(i2));
                i = i2 + 1;
            }
            if ((this.BsD & 2) == 2) {
                fVar.a(3, this.BtU);
            }
            if ((this.BsD & 4) == 4) {
                fVar.io(4, this.BtV.value);
            }
            fVar.d(this.BsB);
            AppMethodBeat.o(120572);
        }

        public final int vq() {
            int i = 0;
            AppMethodBeat.i(120573);
            int i2 = this.BsH;
            if (i2 != -1) {
                AppMethodBeat.o(120573);
                return i2;
            }
            int i3;
            if ((this.BsD & 1) == 1) {
                i2 = a.i.b.a.c.g.f.ip(1, this.BtS.value) + 0;
            } else {
                i2 = 0;
            }
            while (true) {
                i3 = i2;
                if (i >= this.BtT.size()) {
                    break;
                }
                i2 = a.i.b.a.c.g.f.c(2, (a.i.b.a.c.g.q) this.BtT.get(i)) + i3;
                i++;
            }
            if ((this.BsD & 2) == 2) {
                i3 += a.i.b.a.c.g.f.c(3, this.BtU);
            }
            if ((this.BsD & 4) == 4) {
                i3 += a.i.b.a.c.g.f.ip(4, this.BtV.value);
            }
            i2 = this.BsB.size() + i3;
            this.BsH = i2;
            AppMethodBeat.o(120573);
            return i2;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecC() {
            AppMethodBeat.i(120574);
            a c = a.edU().c(this);
            AppMethodBeat.o(120574);
            return c;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecD() {
            AppMethodBeat.i(120575);
            a edU = a.edU();
            AppMethodBeat.o(120575);
            return edU;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.g.q ecE() {
            return BtR;
        }
    }

    public interface aj extends a.i.b.a.c.g.i.d {
    }

    public interface an extends a.i.b.a.c.g.r {
    }

    public enum ao implements a.i.b.a.c.g.j.a {
        INTERNAL(0),
        PRIVATE(1),
        PROTECTED(2),
        PUBLIC(3),
        PRIVATE_TO_THIS(4),
        LOCAL(5);
        
        private static a.i.b.a.c.g.j.b<ao> Btk;
        private final int value;

        static {
            Btk = new a.i.b.a.c.g.j.b<ao>() {
                public final /* synthetic */ a.i.b.a.c.g.j.a SW(int i) {
                    AppMethodBeat.i(121061);
                    ao Uf = ao.Uf(i);
                    AppMethodBeat.o(121061);
                    return Uf;
                }
            };
            AppMethodBeat.o(121064);
        }

        public final int edd() {
            return this.value;
        }

        public static ao Uf(int i) {
            switch (i) {
                case 0:
                    return INTERNAL;
                case 1:
                    return PRIVATE;
                case 2:
                    return PROTECTED;
                case 3:
                    return PUBLIC;
                case 4:
                    return PRIVATE_TO_THIS;
                case 5:
                    return LOCAL;
                default:
                    return null;
            }
        }

        private ao(int i) {
            this.value = i;
        }
    }

    public interface l extends a.i.b.a.c.g.i.d {
    }

    public interface n extends a.i.b.a.c.g.r {
    }

    public static final class o extends a.i.b.a.c.g.i.c<o> implements p {
        public static a.i.b.a.c.g.s<o> BsC = new a.i.b.a.c.g.b<o>() {
            public final /* synthetic */ Object a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120635);
                o oVar = new o(eVar, gVar, (byte) 0);
                AppMethodBeat.o(120635);
                return oVar;
            }
        };
        private static final o Bur;
        private final a.i.b.a.c.g.d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        public int BsW;
        public ag BtC;
        public List<Integer> BtD;
        public List<ai> BtO;
        public List<ae> Btp;
        public int Buf;
        public int Bus;
        public aa But;
        public int Buu;
        public aa Buv;
        public int Buw;
        g Bux;

        public static final class a extends a.i.b.a.c.g.i.b<o, a> implements p {
            private int BsD;
            private int BsW = 6;
            private ag BtC = ag.efM();
            private List<Integer> BtD = Collections.emptyList();
            private List<ai> BtO = Collections.emptyList();
            private List<ae> Btp = Collections.emptyList();
            private int Buf;
            private int Bus = 6;
            private aa But = aa.eeX();
            private int Buu;
            private aa Buv = aa.eeX();
            private int Buw;
            private g Bux = g.edH();

            public final /* synthetic */ a.i.b.a.c.g.i.a a(a.i.b.a.c.g.i iVar) {
                AppMethodBeat.i(120652);
                a e = e((o) iVar);
                AppMethodBeat.o(120652);
                return e;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a c(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120654);
                a m = m(eVar, gVar);
                AppMethodBeat.o(120654);
                return m;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(120658);
                a eer = eer();
                AppMethodBeat.o(120658);
                return eer;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a d(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120656);
                a m = m(eVar, gVar);
                AppMethodBeat.o(120656);
                return m;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.a ecK() {
                AppMethodBeat.i(120653);
                a eer = eer();
                AppMethodBeat.o(120653);
                return eer;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a ecL() {
                AppMethodBeat.i(120655);
                a eer = eer();
                AppMethodBeat.o(120655);
                return eer;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.b edA() {
                AppMethodBeat.i(120649);
                a eer = eer();
                AppMethodBeat.o(120649);
                return eer;
            }

            private a() {
                AppMethodBeat.i(120636);
                AppMethodBeat.o(120636);
            }

            private o ees() {
                int i = 1;
                AppMethodBeat.i(120638);
                o oVar = new o((a.i.b.a.c.g.i.b) this, (byte) 0);
                int i2 = this.BsD;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                oVar.BsW = this.BsW;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                oVar.Bus = this.Bus;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                oVar.Buf = this.Buf;
                if ((i2 & 8) == 8) {
                    i |= 8;
                }
                oVar.But = this.But;
                if ((i2 & 16) == 16) {
                    i |= 16;
                }
                oVar.Buu = this.Buu;
                if ((this.BsD & 32) == 32) {
                    this.Btp = Collections.unmodifiableList(this.Btp);
                    this.BsD &= -33;
                }
                oVar.Btp = this.Btp;
                if ((i2 & 64) == 64) {
                    i |= 32;
                }
                oVar.Buv = this.Buv;
                if ((i2 & 128) == 128) {
                    i |= 64;
                }
                oVar.Buw = this.Buw;
                if ((this.BsD & 256) == 256) {
                    this.BtO = Collections.unmodifiableList(this.BtO);
                    this.BsD &= -257;
                }
                oVar.BtO = this.BtO;
                if ((i2 & 512) == 512) {
                    i |= 128;
                }
                oVar.BtC = this.BtC;
                if ((this.BsD & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                    this.BtD = Collections.unmodifiableList(this.BtD);
                    this.BsD &= -1025;
                }
                oVar.BtD = this.BtD;
                if ((i2 & 2048) == 2048) {
                    i |= 256;
                }
                oVar.Bux = this.Bux;
                oVar.BsD = i;
                AppMethodBeat.o(120638);
                return oVar;
            }

            public final a e(o oVar) {
                AppMethodBeat.i(120639);
                if (oVar == o.eek()) {
                    AppMethodBeat.o(120639);
                } else {
                    if (oVar.ecY()) {
                        Tk(oVar.BsW);
                    }
                    if (oVar.eel()) {
                        Tl(oVar.Bus);
                    }
                    if (oVar.edW()) {
                        Tm(oVar.Buf);
                    }
                    if (oVar.eem()) {
                        b(oVar.But);
                    }
                    if (oVar.een()) {
                        Tn(oVar.Buu);
                    }
                    if (!oVar.Btp.isEmpty()) {
                        if (this.Btp.isEmpty()) {
                            this.Btp = oVar.Btp;
                            this.BsD &= -33;
                        } else {
                            edp();
                            this.Btp.addAll(oVar.Btp);
                        }
                    }
                    if (oVar.eeo()) {
                        c(oVar.Buv);
                    }
                    if (oVar.eep()) {
                        To(oVar.Buw);
                    }
                    if (!oVar.BtO.isEmpty()) {
                        if (this.BtO.isEmpty()) {
                            this.BtO = oVar.BtO;
                            this.BsD &= -257;
                        } else {
                            edF();
                            this.BtO.addAll(oVar.BtO);
                        }
                    }
                    if (oVar.edl()) {
                        b(oVar.BtC);
                    }
                    if (!oVar.BtD.isEmpty()) {
                        if (this.BtD.isEmpty()) {
                            this.BtD = oVar.BtD;
                            this.BsD &= -1025;
                        } else {
                            edz();
                            this.BtD.addAll(oVar.BtD);
                        }
                    }
                    if (oVar.eeq()) {
                        e(oVar.Bux);
                    }
                    a((a.i.b.a.c.g.i.c) oVar);
                    this.BsB = this.BsB.a(oVar.BsB);
                    AppMethodBeat.o(120639);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private a m(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                o oVar;
                Throwable th;
                AppMethodBeat.i(120641);
                o oVar2 = null;
                try {
                    e((o) o.BsC.a(eVar, gVar));
                    AppMethodBeat.o(120641);
                    return this;
                } catch (a.i.b.a.c.g.k e) {
                    a.i.b.a.c.g.k kVar = e;
                    oVar = (o) kVar.BzY;
                    AppMethodBeat.o(120641);
                    throw kVar;
                } catch (Throwable th2) {
                    th = th2;
                    oVar2 = oVar;
                    if (oVar2 != null) {
                    }
                    AppMethodBeat.o(120641);
                    throw th;
                }
            }

            private a Tk(int i) {
                this.BsD |= 1;
                this.BsW = i;
                return this;
            }

            private a Tl(int i) {
                this.BsD |= 2;
                this.Bus = i;
                return this;
            }

            private a Tm(int i) {
                this.BsD |= 4;
                this.Buf = i;
                return this;
            }

            private a b(aa aaVar) {
                AppMethodBeat.i(120642);
                if ((this.BsD & 8) != 8 || this.But == aa.eeX()) {
                    this.But = aaVar;
                } else {
                    this.But = aa.f(this.But).j(aaVar).eft();
                }
                this.BsD |= 8;
                AppMethodBeat.o(120642);
                return this;
            }

            private a Tn(int i) {
                this.BsD |= 16;
                this.Buu = i;
                return this;
            }

            private void edp() {
                AppMethodBeat.i(120643);
                if ((this.BsD & 32) != 32) {
                    this.Btp = new ArrayList(this.Btp);
                    this.BsD |= 32;
                }
                AppMethodBeat.o(120643);
            }

            private a c(aa aaVar) {
                AppMethodBeat.i(120644);
                if ((this.BsD & 64) != 64 || this.Buv == aa.eeX()) {
                    this.Buv = aaVar;
                } else {
                    this.Buv = aa.f(this.Buv).j(aaVar).eft();
                }
                this.BsD |= 64;
                AppMethodBeat.o(120644);
                return this;
            }

            private a To(int i) {
                this.BsD |= 128;
                this.Buw = i;
                return this;
            }

            private void edF() {
                AppMethodBeat.i(120645);
                if ((this.BsD & 256) != 256) {
                    this.BtO = new ArrayList(this.BtO);
                    this.BsD |= 256;
                }
                AppMethodBeat.o(120645);
            }

            private a b(ag agVar) {
                AppMethodBeat.i(120646);
                if ((this.BsD & 512) != 512 || this.BtC == ag.efM()) {
                    this.BtC = agVar;
                } else {
                    this.BtC = ag.d(this.BtC).g(agVar).efP();
                }
                this.BsD |= 512;
                AppMethodBeat.o(120646);
                return this;
            }

            private void edz() {
                AppMethodBeat.i(120647);
                if ((this.BsD & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                    this.BtD = new ArrayList(this.BtD);
                    this.BsD |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                }
                AppMethodBeat.o(120647);
            }

            private a e(g gVar) {
                AppMethodBeat.i(120648);
                if ((this.BsD & 2048) != 2048 || this.Bux == g.edH()) {
                    this.Bux = gVar;
                } else {
                    this.Bux = g.a(this.Bux).d(gVar).edK();
                }
                this.BsD |= 2048;
                AppMethodBeat.o(120648);
                return this;
            }

            private a eer() {
                AppMethodBeat.i(120637);
                a e = new a().e(ees());
                AppMethodBeat.o(120637);
                return e;
            }

            public final boolean isInitialized() {
                boolean z;
                AppMethodBeat.i(120640);
                if ((this.BsD & 4) == 4) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if ((this.BsD & 8) == 8) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z || this.But.isInitialized()) {
                        int i = 0;
                        while (i < this.Btp.size()) {
                            if (((ae) this.Btp.get(i)).isInitialized()) {
                                i++;
                            } else {
                                AppMethodBeat.o(120640);
                                return false;
                            }
                        }
                        if ((this.BsD & 64) == 64) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z || this.Buv.isInitialized()) {
                            i = 0;
                            while (i < this.BtO.size()) {
                                if (((ai) this.BtO.get(i)).isInitialized()) {
                                    i++;
                                } else {
                                    AppMethodBeat.o(120640);
                                    return false;
                                }
                            }
                            if ((this.BsD & 512) == 512) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z || this.BtC.isInitialized()) {
                                if ((this.BsD & 2048) == 2048) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z && !this.Bux.isInitialized()) {
                                    AppMethodBeat.o(120640);
                                    return false;
                                } else if (this.BzI.isInitialized()) {
                                    AppMethodBeat.o(120640);
                                    return true;
                                } else {
                                    AppMethodBeat.o(120640);
                                    return false;
                                }
                            }
                            AppMethodBeat.o(120640);
                            return false;
                        }
                        AppMethodBeat.o(120640);
                        return false;
                    }
                    AppMethodBeat.o(120640);
                    return false;
                }
                AppMethodBeat.o(120640);
                return false;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecE() {
                AppMethodBeat.i(120650);
                o eek = o.eek();
                AppMethodBeat.o(120650);
                return eek;
            }

            public final /* synthetic */ a.i.b.a.c.g.i ecJ() {
                AppMethodBeat.i(120651);
                o eek = o.eek();
                AppMethodBeat.o(120651);
                return eek;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecM() {
                AppMethodBeat.i(120657);
                o ees = ees();
                if (ees.isInitialized()) {
                    AppMethodBeat.o(120657);
                    return ees;
                }
                a.i.b.a.c.g.w wVar = new a.i.b.a.c.g.w();
                AppMethodBeat.o(120657);
                throw wVar;
            }

            static /* synthetic */ a eet() {
                AppMethodBeat.i(120659);
                a aVar = new a();
                AppMethodBeat.o(120659);
                return aVar;
            }
        }

        /* synthetic */ o(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar, byte b) {
            this(eVar, gVar);
        }

        private o(a.i.b.a.c.g.i.b<o, ?> bVar) {
            super(bVar);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = bVar.BsB;
        }

        private o() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = a.i.b.a.c.g.d.Bzq;
        }

        public static o eek() {
            return Bur;
        }

        private o(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
            AppMethodBeat.i(120660);
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            int i = 0;
            a.i.b.a.c.g.d.b ehS = a.i.b.a.c.g.d.ehS();
            a.i.b.a.c.g.f e = a.i.b.a.c.g.f.e(ehS, 1);
            Object obj = null;
            while (obj == null) {
                try {
                    int vc = eVar.vc();
                    c f;
                    switch (vc) {
                        case 0:
                            obj = 1;
                            break;
                        case 8:
                            this.BsD |= 2;
                            this.Bus = eVar.vd();
                            break;
                        case 16:
                            this.BsD |= 4;
                            this.Buf = eVar.vd();
                            break;
                        case 26:
                            if ((this.BsD & 8) == 8) {
                                f = aa.f(this.But);
                            } else {
                                f = null;
                            }
                            this.But = (aa) eVar.a(aa.BsC, gVar);
                            if (f != null) {
                                f.j(this.But);
                                this.But = f.eft();
                            }
                            this.BsD |= 8;
                            break;
                        case 34:
                            if ((i & 32) != 32) {
                                this.Btp = new ArrayList();
                                i |= 32;
                            }
                            this.Btp.add(eVar.a(ae.BsC, gVar));
                            break;
                        case 42:
                            if ((this.BsD & 32) == 32) {
                                f = aa.f(this.Buv);
                            } else {
                                f = null;
                            }
                            this.Buv = (aa) eVar.a(aa.BsC, gVar);
                            if (f != null) {
                                f.j(this.Buv);
                                this.Buv = f.eft();
                            }
                            this.BsD |= 32;
                            break;
                        case 50:
                            if ((i & 256) != 256) {
                                this.BtO = new ArrayList();
                                i |= 256;
                            }
                            this.BtO.add(eVar.a(ai.BsC, gVar));
                            break;
                        case FileUtils.S_IRWXG /*56*/:
                            this.BsD |= 16;
                            this.Buu = eVar.vd();
                            break;
                        case 64:
                            this.BsD |= 64;
                            this.Buw = eVar.vd();
                            break;
                        case com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX /*72*/:
                            this.BsD |= 1;
                            this.BsW = eVar.vd();
                            break;
                        case 242:
                            a d;
                            if ((this.BsD & 128) == 128) {
                                d = ag.d(this.BtC);
                            } else {
                                d = null;
                            }
                            this.BtC = (ag) eVar.a(ag.BsC, gVar);
                            if (d != null) {
                                d.g(this.BtC);
                                this.BtC = d.efP();
                            }
                            this.BsD |= 128;
                            break;
                        case com.tencent.view.d.MIC_PTU_ZIPAI_THURSDAY /*248*/:
                            if ((i & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                                this.BtD = new ArrayList();
                                i |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                            }
                            this.BtD.add(Integer.valueOf(eVar.vd()));
                            break;
                        case 250:
                            vc = eVar.fo(eVar.vd());
                            if ((i & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && eVar.vg() > 0) {
                                this.BtD = new ArrayList();
                                i |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                            }
                            while (eVar.vg() > 0) {
                                this.BtD.add(Integer.valueOf(eVar.vd()));
                            }
                            eVar.fp(vc);
                            break;
                        case com.tencent.view.d.MIC_PTU_ZIPAI_SAPPORO /*258*/:
                            a edI;
                            if ((this.BsD & 256) == 256) {
                                edI = this.Bux.edI();
                            } else {
                                edI = null;
                            }
                            this.Bux = (g) eVar.a(g.BsC, gVar);
                            if (edI != null) {
                                edI.d(this.Bux);
                                this.Bux = edI.edK();
                            }
                            this.BsD |= 256;
                            break;
                        default:
                            if (!a(eVar, e, gVar, vc)) {
                                obj = 1;
                                break;
                            }
                            break;
                    }
                } catch (a.i.b.a.c.g.k e2) {
                    e2.BzY = this;
                    AppMethodBeat.o(120660);
                    throw e2;
                } catch (IOException e3) {
                    a.i.b.a.c.g.k kVar = new a.i.b.a.c.g.k(e3.getMessage());
                    kVar.BzY = this;
                    AppMethodBeat.o(120660);
                    throw kVar;
                } catch (Throwable th) {
                    if ((i & 32) == 32) {
                        this.Btp = Collections.unmodifiableList(this.Btp);
                    }
                    if ((i & 256) == 256) {
                        this.BtO = Collections.unmodifiableList(this.BtO);
                    }
                    if ((i & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                        this.BtD = Collections.unmodifiableList(this.BtD);
                    }
                    try {
                        e.flush();
                        this.BsB = ehS.ehW();
                    } catch (IOException e4) {
                        this.BsB = ehS.ehW();
                    } catch (Throwable th2) {
                        this.BsB = ehS.ehW();
                        AppMethodBeat.o(120660);
                    }
                    this.BzI.eii();
                    AppMethodBeat.o(120660);
                }
            }
            if ((i & 32) == 32) {
                this.Btp = Collections.unmodifiableList(this.Btp);
            }
            if ((i & 256) == 256) {
                this.BtO = Collections.unmodifiableList(this.BtO);
            }
            if ((i & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                this.BtD = Collections.unmodifiableList(this.BtD);
            }
            try {
                e.flush();
                this.BsB = ehS.ehW();
            } catch (IOException e5) {
                this.BsB = ehS.ehW();
            } catch (Throwable th3) {
                this.BsB = ehS.ehW();
                AppMethodBeat.o(120660);
            }
            this.BzI.eii();
            AppMethodBeat.o(120660);
        }

        static {
            AppMethodBeat.i(120668);
            o oVar = new o();
            Bur = oVar;
            oVar.ecA();
            AppMethodBeat.o(120668);
        }

        public final a.i.b.a.c.g.s<o> ecy() {
            return BsC;
        }

        public final boolean ecY() {
            return (this.BsD & 1) == 1;
        }

        public final boolean eel() {
            return (this.BsD & 2) == 2;
        }

        public final boolean edW() {
            return (this.BsD & 4) == 4;
        }

        public final boolean eem() {
            return (this.BsD & 8) == 8;
        }

        public final boolean een() {
            return (this.BsD & 16) == 16;
        }

        public final boolean eeo() {
            return (this.BsD & 32) == 32;
        }

        public final boolean eep() {
            return (this.BsD & 64) == 64;
        }

        public final boolean edl() {
            return (this.BsD & 128) == 128;
        }

        public final boolean eeq() {
            return (this.BsD & 256) == 256;
        }

        private void ecA() {
            AppMethodBeat.i(120661);
            this.BsW = 6;
            this.Bus = 6;
            this.Buf = 0;
            this.But = aa.eeX();
            this.Buu = 0;
            this.Btp = Collections.emptyList();
            this.Buv = aa.eeX();
            this.Buw = 0;
            this.BtO = Collections.emptyList();
            this.BtC = ag.efM();
            this.BtD = Collections.emptyList();
            this.Bux = g.edH();
            AppMethodBeat.o(120661);
        }

        public final boolean isInitialized() {
            AppMethodBeat.i(120662);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.o(120662);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.o(120662);
                return false;
            } else if (!edW()) {
                this.BsG = (byte) 0;
                AppMethodBeat.o(120662);
                return false;
            } else if (!eem() || this.But.isInitialized()) {
                int i = 0;
                while (i < this.Btp.size()) {
                    if (((ae) this.Btp.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120662);
                        return false;
                    }
                }
                if (!eeo() || this.Buv.isInitialized()) {
                    i = 0;
                    while (i < this.BtO.size()) {
                        if (((ai) this.BtO.get(i)).isInitialized()) {
                            i++;
                        } else {
                            this.BsG = (byte) 0;
                            AppMethodBeat.o(120662);
                            return false;
                        }
                    }
                    if (edl() && !this.BtC.isInitialized()) {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120662);
                        return false;
                    } else if (eeq() && !this.Bux.isInitialized()) {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120662);
                        return false;
                    } else if (this.BzI.isInitialized()) {
                        this.BsG = (byte) 1;
                        AppMethodBeat.o(120662);
                        return true;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120662);
                        return false;
                    }
                }
                this.BsG = (byte) 0;
                AppMethodBeat.o(120662);
                return false;
            } else {
                this.BsG = (byte) 0;
                AppMethodBeat.o(120662);
                return false;
            }
        }

        public final void a(a.i.b.a.c.g.f fVar) {
            int i;
            int i2 = 0;
            AppMethodBeat.i(120663);
            vq();
            a.i.b.a.c.g.i.c.a eip = eip();
            if ((this.BsD & 2) == 2) {
                fVar.bq(1, this.Bus);
            }
            if ((this.BsD & 4) == 4) {
                fVar.bq(2, this.Buf);
            }
            if ((this.BsD & 8) == 8) {
                fVar.a(3, this.But);
            }
            for (i = 0; i < this.Btp.size(); i++) {
                fVar.a(4, (a.i.b.a.c.g.q) this.Btp.get(i));
            }
            if ((this.BsD & 32) == 32) {
                fVar.a(5, this.Buv);
            }
            for (i = 0; i < this.BtO.size(); i++) {
                fVar.a(6, (a.i.b.a.c.g.q) this.BtO.get(i));
            }
            if ((this.BsD & 16) == 16) {
                fVar.bq(7, this.Buu);
            }
            if ((this.BsD & 64) == 64) {
                fVar.bq(8, this.Buw);
            }
            if ((this.BsD & 1) == 1) {
                fVar.bq(9, this.BsW);
            }
            if ((this.BsD & 128) == 128) {
                fVar.a(30, this.BtC);
            }
            while (i2 < this.BtD.size()) {
                fVar.bq(31, ((Integer) this.BtD.get(i2)).intValue());
                i2++;
            }
            if ((this.BsD & 256) == 256) {
                fVar.a(32, this.Bux);
            }
            eip.b(19000, fVar);
            fVar.d(this.BsB);
            AppMethodBeat.o(120663);
        }

        public final int vq() {
            AppMethodBeat.i(120664);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.o(120664);
                return i;
            }
            int i2;
            if ((this.BsD & 2) == 2) {
                i = a.i.b.a.c.g.f.bs(1, this.Bus) + 0;
            } else {
                i = 0;
            }
            if ((this.BsD & 4) == 4) {
                i += a.i.b.a.c.g.f.bs(2, this.Buf);
            }
            if ((this.BsD & 8) == 8) {
                i += a.i.b.a.c.g.f.c(3, this.But);
            }
            int i3 = i;
            for (i2 = 0; i2 < this.Btp.size(); i2++) {
                i3 += a.i.b.a.c.g.f.c(4, (a.i.b.a.c.g.q) this.Btp.get(i2));
            }
            if ((this.BsD & 32) == 32) {
                i3 += a.i.b.a.c.g.f.c(5, this.Buv);
            }
            for (i2 = 0; i2 < this.BtO.size(); i2++) {
                i3 += a.i.b.a.c.g.f.c(6, (a.i.b.a.c.g.q) this.BtO.get(i2));
            }
            if ((this.BsD & 16) == 16) {
                i3 += a.i.b.a.c.g.f.bs(7, this.Buu);
            }
            if ((this.BsD & 64) == 64) {
                i3 += a.i.b.a.c.g.f.bs(8, this.Buw);
            }
            if ((this.BsD & 1) == 1) {
                i3 += a.i.b.a.c.g.f.bs(9, this.BsW);
            }
            if ((this.BsD & 128) == 128) {
                i3 += a.i.b.a.c.g.f.c(30, this.BtC);
            }
            i2 = 0;
            int i4 = 0;
            while (i2 < this.BtD.size()) {
                i2++;
                i4 = a.i.b.a.c.g.f.ft(((Integer) this.BtD.get(i2)).intValue()) + i4;
            }
            i = (i3 + i4) + (this.BtD.size() * 2);
            if ((this.BsD & 256) == 256) {
                i += a.i.b.a.c.g.f.c(32, this.Bux);
            }
            i = (i + this.BzI.vq()) + this.BsB.size();
            this.BsH = i;
            AppMethodBeat.o(120664);
            return i;
        }

        public static o b(InputStream inputStream, a.i.b.a.c.g.g gVar) {
            AppMethodBeat.i(120665);
            o oVar = (o) BsC.j(inputStream, gVar);
            AppMethodBeat.o(120665);
            return oVar;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.g.q ecE() {
            return Bur;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecC() {
            AppMethodBeat.i(120666);
            a e = a.eet().e(this);
            AppMethodBeat.o(120666);
            return e;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecD() {
            AppMethodBeat.i(120667);
            a eet = a.eet();
            AppMethodBeat.o(120667);
            return eet;
        }
    }

    public interface v extends a.i.b.a.c.g.i.d {
    }

    public static final class y extends a.i.b.a.c.g.i implements z {
        public static a.i.b.a.c.g.s<y> BsC = new a.i.b.a.c.g.b<y>() {
            public final /* synthetic */ Object a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120795);
                y yVar = new y(eVar, gVar, (byte) 0);
                AppMethodBeat.o(120795);
                return yVar;
            }
        };
        private static final y BuX;
        private final a.i.b.a.c.g.d BsB;
        private byte BsG;
        private int BsH;
        private a.i.b.a.c.g.o BuY;

        public static final class a extends a.i.b.a.c.g.i.a<y, a> implements z {
            private int BsD;
            private a.i.b.a.c.g.o BuY = a.i.b.a.c.g.n.BAf;

            public final /* synthetic */ a.i.b.a.c.g.i.a a(a.i.b.a.c.g.i iVar) {
                AppMethodBeat.i(120802);
                a d = d((y) iVar);
                AppMethodBeat.o(120802);
                return d;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a c(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120804);
                a r = r(eVar, gVar);
                AppMethodBeat.o(120804);
                return r;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(120809);
                a eeT = eeT();
                AppMethodBeat.o(120809);
                return eeT;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a d(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120806);
                a r = r(eVar, gVar);
                AppMethodBeat.o(120806);
                return r;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.a ecK() {
                AppMethodBeat.i(120803);
                a eeT = eeT();
                AppMethodBeat.o(120803);
                return eeT;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a ecL() {
                AppMethodBeat.i(120805);
                a eeT = eeT();
                AppMethodBeat.o(120805);
                return eeT;
            }

            private a() {
            }

            public final y eeU() {
                AppMethodBeat.i(120797);
                y yVar = new y((a.i.b.a.c.g.i.a) this, (byte) 0);
                if ((this.BsD & 1) == 1) {
                    this.BuY = this.BuY.eiA();
                    this.BsD &= -2;
                }
                yVar.BuY = this.BuY;
                AppMethodBeat.o(120797);
                return yVar;
            }

            public final a d(y yVar) {
                AppMethodBeat.i(120798);
                if (yVar == y.eeR()) {
                    AppMethodBeat.o(120798);
                } else {
                    if (!yVar.BuY.isEmpty()) {
                        if (this.BuY.isEmpty()) {
                            this.BuY = yVar.BuY;
                            this.BsD &= -2;
                        } else {
                            eeV();
                            this.BuY.addAll(yVar.BuY);
                        }
                    }
                    this.BsB = this.BsB.a(yVar.BsB);
                    AppMethodBeat.o(120798);
                }
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private a r(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                y yVar;
                Throwable th;
                AppMethodBeat.i(120799);
                y yVar2 = null;
                try {
                    d((y) y.BsC.a(eVar, gVar));
                    AppMethodBeat.o(120799);
                    return this;
                } catch (a.i.b.a.c.g.k e) {
                    a.i.b.a.c.g.k kVar = e;
                    yVar = (y) kVar.BzY;
                    AppMethodBeat.o(120799);
                    throw kVar;
                } catch (Throwable th2) {
                    th = th2;
                    yVar2 = yVar;
                    if (yVar2 != null) {
                    }
                    AppMethodBeat.o(120799);
                    throw th;
                }
            }

            private void eeV() {
                AppMethodBeat.i(120800);
                if ((this.BsD & 1) != 1) {
                    this.BuY = new a.i.b.a.c.g.n(this.BuY);
                    this.BsD |= 1;
                }
                AppMethodBeat.o(120800);
            }

            private a eeT() {
                AppMethodBeat.i(120796);
                a d = new a().d(eeU());
                AppMethodBeat.o(120796);
                return d;
            }

            public final /* synthetic */ a.i.b.a.c.g.i ecJ() {
                AppMethodBeat.i(120801);
                y eeR = y.eeR();
                AppMethodBeat.o(120801);
                return eeR;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecM() {
                AppMethodBeat.i(120807);
                y eeU = eeU();
                if (eeU.isInitialized()) {
                    AppMethodBeat.o(120807);
                    return eeU;
                }
                a.i.b.a.c.g.w wVar = new a.i.b.a.c.g.w();
                AppMethodBeat.o(120807);
                throw wVar;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecE() {
                AppMethodBeat.i(120808);
                y eeR = y.eeR();
                AppMethodBeat.o(120808);
                return eeR;
            }

            static /* synthetic */ a eeW() {
                AppMethodBeat.i(120810);
                a aVar = new a();
                AppMethodBeat.o(120810);
                return aVar;
            }
        }

        /* synthetic */ y(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar, byte b) {
            this(eVar, gVar);
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecC() {
            AppMethodBeat.i(120817);
            a eeS = eeS();
            AppMethodBeat.o(120817);
            return eeS;
        }

        private y(a.i.b.a.c.g.i.a aVar) {
            super((byte) 0);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = aVar.BsB;
        }

        private y() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = a.i.b.a.c.g.d.Bzq;
        }

        public static y eeR() {
            return BuX;
        }

        private y(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
            AppMethodBeat.i(120811);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BuY = a.i.b.a.c.g.n.BAf;
            a.i.b.a.c.g.d.b ehS = a.i.b.a.c.g.d.ehS();
            a.i.b.a.c.g.f e = a.i.b.a.c.g.f.e(ehS, 1);
            int i = 0;
            int i2 = 0;
            while (i == 0) {
                try {
                    int vc = eVar.vc();
                    switch (vc) {
                        case 0:
                            i = 1;
                            break;
                        case 10:
                            a.i.b.a.c.g.d ehY = eVar.ehY();
                            if ((i2 & 1) != 1) {
                                this.BuY = new a.i.b.a.c.g.n();
                                i2 |= 1;
                            }
                            this.BuY.e(ehY);
                            break;
                        default:
                            if (!a(eVar, e, gVar, vc)) {
                                i = 1;
                                break;
                            }
                            break;
                    }
                } catch (a.i.b.a.c.g.k e2) {
                    e2.BzY = this;
                    AppMethodBeat.o(120811);
                    throw e2;
                } catch (IOException e3) {
                    a.i.b.a.c.g.k kVar = new a.i.b.a.c.g.k(e3.getMessage());
                    kVar.BzY = this;
                    AppMethodBeat.o(120811);
                    throw kVar;
                } catch (Throwable th) {
                    if ((i2 & 1) == 1) {
                        this.BuY = this.BuY.eiA();
                    }
                    try {
                        e.flush();
                        this.BsB = ehS.ehW();
                    } catch (IOException e4) {
                        this.BsB = ehS.ehW();
                    } catch (Throwable th2) {
                        this.BsB = ehS.ehW();
                        AppMethodBeat.o(120811);
                    }
                    eio();
                    AppMethodBeat.o(120811);
                }
            }
            if ((i2 & 1) == 1) {
                this.BuY = this.BuY.eiA();
            }
            try {
                e.flush();
                this.BsB = ehS.ehW();
            } catch (IOException e5) {
                this.BsB = ehS.ehW();
            } catch (Throwable th3) {
                this.BsB = ehS.ehW();
                AppMethodBeat.o(120811);
            }
            eio();
            AppMethodBeat.o(120811);
        }

        static {
            AppMethodBeat.i(120819);
            y yVar = new y();
            BuX = yVar;
            yVar.BuY = a.i.b.a.c.g.n.BAf;
            AppMethodBeat.o(120819);
        }

        public final a.i.b.a.c.g.s<y> ecy() {
            return BsC;
        }

        public final String getString(int i) {
            AppMethodBeat.i(120812);
            String str = (String) this.BuY.get(i);
            AppMethodBeat.o(120812);
            return str;
        }

        public final boolean isInitialized() {
            byte b = this.BsG;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            this.BsG = (byte) 1;
            return true;
        }

        public final void a(a.i.b.a.c.g.f fVar) {
            AppMethodBeat.i(120813);
            vq();
            for (int i = 0; i < this.BuY.size(); i++) {
                fVar.a(1, this.BuY.UC(i));
            }
            fVar.d(this.BsB);
            AppMethodBeat.o(120813);
        }

        public final int vq() {
            int i = 0;
            AppMethodBeat.i(120814);
            int i2 = this.BsH;
            if (i2 != -1) {
                AppMethodBeat.o(120814);
                return i2;
            }
            i2 = 0;
            while (true) {
                int i3 = i;
                if (i2 < this.BuY.size()) {
                    i = a.i.b.a.c.g.f.c(this.BuY.UC(i2)) + i3;
                    i2++;
                } else {
                    i2 = ((i3 + 0) + (this.BuY.size() * 1)) + this.BsB.size();
                    this.BsH = i2;
                    AppMethodBeat.o(120814);
                    return i2;
                }
            }
        }

        public static a a(y yVar) {
            AppMethodBeat.i(120815);
            a d = a.eeW().d(yVar);
            AppMethodBeat.o(120815);
            return d;
        }

        public final a eeS() {
            AppMethodBeat.i(120816);
            a d = a.eeW().d(this);
            AppMethodBeat.o(120816);
            return d;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecD() {
            AppMethodBeat.i(120818);
            a eeW = a.eeW();
            AppMethodBeat.o(120818);
            return eeW;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.g.q ecE() {
            return BuX;
        }
    }

    public static final class am extends a.i.b.a.c.g.i implements an {
        public static a.i.b.a.c.g.s<am> BsC = new a.i.b.a.c.g.b<am>() {
            public final /* synthetic */ Object a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(121037);
                am amVar = new am(eVar, gVar, (byte) 0);
                AppMethodBeat.o(121037);
                return amVar;
            }
        };
        private static final am Bwg;
        private final a.i.b.a.c.g.d BsB;
        private byte BsG;
        private int BsH;
        public List<ak> Bwh;

        public static final class a extends a.i.b.a.c.g.i.a<am, a> implements an {
            private int BsD;
            private List<ak> Bwh = Collections.emptyList();

            public final /* synthetic */ a.i.b.a.c.g.i.a a(a.i.b.a.c.g.i iVar) {
                AppMethodBeat.i(121045);
                a f = f((am) iVar);
                AppMethodBeat.o(121045);
                return f;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a c(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(121047);
                a z = z(eVar, gVar);
                AppMethodBeat.o(121047);
                return z;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(121052);
                a egj = egj();
                AppMethodBeat.o(121052);
                return egj;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a d(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(121049);
                a z = z(eVar, gVar);
                AppMethodBeat.o(121049);
                return z;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.a ecK() {
                AppMethodBeat.i(121046);
                a egj = egj();
                AppMethodBeat.o(121046);
                return egj;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a ecL() {
                AppMethodBeat.i(121048);
                a egj = egj();
                AppMethodBeat.o(121048);
                return egj;
            }

            private a() {
                AppMethodBeat.i(121038);
                AppMethodBeat.o(121038);
            }

            public final am egk() {
                AppMethodBeat.i(121040);
                am amVar = new am((a.i.b.a.c.g.i.a) this, (byte) 0);
                if ((this.BsD & 1) == 1) {
                    this.Bwh = Collections.unmodifiableList(this.Bwh);
                    this.BsD &= -2;
                }
                amVar.Bwh = this.Bwh;
                AppMethodBeat.o(121040);
                return amVar;
            }

            public final a f(am amVar) {
                AppMethodBeat.i(121041);
                if (amVar == am.egi()) {
                    AppMethodBeat.o(121041);
                } else {
                    if (!amVar.Bwh.isEmpty()) {
                        if (this.Bwh.isEmpty()) {
                            this.Bwh = amVar.Bwh;
                            this.BsD &= -2;
                        } else {
                            egl();
                            this.Bwh.addAll(amVar.Bwh);
                        }
                    }
                    this.BsB = this.BsB.a(amVar.BsB);
                    AppMethodBeat.o(121041);
                }
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private a z(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                am amVar;
                Throwable th;
                AppMethodBeat.i(121042);
                am amVar2 = null;
                try {
                    f((am) am.BsC.a(eVar, gVar));
                    AppMethodBeat.o(121042);
                    return this;
                } catch (a.i.b.a.c.g.k e) {
                    a.i.b.a.c.g.k kVar = e;
                    amVar = (am) kVar.BzY;
                    AppMethodBeat.o(121042);
                    throw kVar;
                } catch (Throwable th2) {
                    th = th2;
                    amVar2 = amVar;
                    if (amVar2 != null) {
                    }
                    AppMethodBeat.o(121042);
                    throw th;
                }
            }

            private void egl() {
                AppMethodBeat.i(121043);
                if ((this.BsD & 1) != 1) {
                    this.Bwh = new ArrayList(this.Bwh);
                    this.BsD |= 1;
                }
                AppMethodBeat.o(121043);
            }

            private a egj() {
                AppMethodBeat.i(121039);
                a f = new a().f(egk());
                AppMethodBeat.o(121039);
                return f;
            }

            public final /* synthetic */ a.i.b.a.c.g.i ecJ() {
                AppMethodBeat.i(121044);
                am egi = am.egi();
                AppMethodBeat.o(121044);
                return egi;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecM() {
                AppMethodBeat.i(121050);
                am egk = egk();
                if (egk.isInitialized()) {
                    AppMethodBeat.o(121050);
                    return egk;
                }
                a.i.b.a.c.g.w wVar = new a.i.b.a.c.g.w();
                AppMethodBeat.o(121050);
                throw wVar;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecE() {
                AppMethodBeat.i(121051);
                am egi = am.egi();
                AppMethodBeat.o(121051);
                return egi;
            }

            static /* synthetic */ a egm() {
                AppMethodBeat.i(121053);
                a aVar = new a();
                AppMethodBeat.o(121053);
                return aVar;
            }
        }

        /* synthetic */ am(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar, byte b) {
            this(eVar, gVar);
        }

        private am(a.i.b.a.c.g.i.a aVar) {
            super((byte) 0);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = aVar.BsB;
        }

        private am() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = a.i.b.a.c.g.d.Bzq;
        }

        public static am egi() {
            return Bwg;
        }

        private am(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
            AppMethodBeat.i(121054);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.Bwh = Collections.emptyList();
            a.i.b.a.c.g.d.b ehS = a.i.b.a.c.g.d.ehS();
            a.i.b.a.c.g.f e = a.i.b.a.c.g.f.e(ehS, 1);
            int i = 0;
            int i2 = 0;
            while (i == 0) {
                try {
                    int vc = eVar.vc();
                    switch (vc) {
                        case 0:
                            i = 1;
                            break;
                        case 10:
                            if ((i2 & 1) != 1) {
                                this.Bwh = new ArrayList();
                                i2 |= 1;
                            }
                            this.Bwh.add(eVar.a(ak.BsC, gVar));
                            break;
                        default:
                            if (!a(eVar, e, gVar, vc)) {
                                i = 1;
                                break;
                            }
                            break;
                    }
                } catch (a.i.b.a.c.g.k e2) {
                    e2.BzY = this;
                    AppMethodBeat.o(121054);
                    throw e2;
                } catch (IOException e3) {
                    a.i.b.a.c.g.k kVar = new a.i.b.a.c.g.k(e3.getMessage());
                    kVar.BzY = this;
                    AppMethodBeat.o(121054);
                    throw kVar;
                } catch (Throwable th) {
                    if ((i2 & 1) == 1) {
                        this.Bwh = Collections.unmodifiableList(this.Bwh);
                    }
                    try {
                        e.flush();
                        this.BsB = ehS.ehW();
                    } catch (IOException e4) {
                        this.BsB = ehS.ehW();
                    } catch (Throwable th2) {
                        this.BsB = ehS.ehW();
                        AppMethodBeat.o(121054);
                    }
                    eio();
                    AppMethodBeat.o(121054);
                }
            }
            if ((i2 & 1) == 1) {
                this.Bwh = Collections.unmodifiableList(this.Bwh);
            }
            try {
                e.flush();
                this.BsB = ehS.ehW();
            } catch (IOException e5) {
                this.BsB = ehS.ehW();
            } catch (Throwable th3) {
                this.BsB = ehS.ehW();
                AppMethodBeat.o(121054);
            }
            eio();
            AppMethodBeat.o(121054);
        }

        static {
            AppMethodBeat.i(121060);
            am amVar = new am();
            Bwg = amVar;
            amVar.Bwh = Collections.emptyList();
            AppMethodBeat.o(121060);
        }

        public final a.i.b.a.c.g.s<am> ecy() {
            return BsC;
        }

        public final boolean isInitialized() {
            byte b = this.BsG;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            this.BsG = (byte) 1;
            return true;
        }

        public final void a(a.i.b.a.c.g.f fVar) {
            AppMethodBeat.i(121055);
            vq();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.Bwh.size()) {
                    fVar.a(1, (a.i.b.a.c.g.q) this.Bwh.get(i2));
                    i = i2 + 1;
                } else {
                    fVar.d(this.BsB);
                    AppMethodBeat.o(121055);
                    return;
                }
            }
        }

        public final int vq() {
            AppMethodBeat.i(121056);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.o(121056);
                return i;
            }
            int i2 = 0;
            for (i = 0; i < this.Bwh.size(); i++) {
                i2 += a.i.b.a.c.g.f.c(1, (a.i.b.a.c.g.q) this.Bwh.get(i));
            }
            int size = this.BsB.size() + i2;
            this.BsH = size;
            AppMethodBeat.o(121056);
            return size;
        }

        public static a c(am amVar) {
            AppMethodBeat.i(121057);
            a f = a.egm().f(amVar);
            AppMethodBeat.o(121057);
            return f;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecC() {
            AppMethodBeat.i(121058);
            a f = a.egm().f(this);
            AppMethodBeat.o(121058);
            return f;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecD() {
            AppMethodBeat.i(121059);
            a egm = a.egm();
            AppMethodBeat.o(121059);
            return egm;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.g.q ecE() {
            return Bwg;
        }
    }

    public static final class u extends a.i.b.a.c.g.i.c<u> implements v {
        public static a.i.b.a.c.g.s<u> BsC = new a.i.b.a.c.g.b<u>() {
            public final /* synthetic */ Object a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120709);
                u uVar = new u(eVar, gVar, (byte) 0);
                AppMethodBeat.o(120709);
                return uVar;
            }
        };
        private static final u BuJ;
        private final a.i.b.a.c.g.d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        public int BsW;
        public List<Integer> BtD;
        public List<ae> Btp;
        public ai BuK;
        public int BuL;
        public int BuM;
        public int Buf;
        public int Bus;
        public aa But;
        public int Buu;
        public aa Buv;
        public int Buw;

        public static final class a extends a.i.b.a.c.g.i.b<u, a> implements v {
            private int BsD;
            private int BsW = com.tencent.mm.plugin.appbrand.jsapi.j.f.CTRL_INDEX;
            private List<Integer> BtD = Collections.emptyList();
            private List<ae> Btp = Collections.emptyList();
            private ai BuK = ai.efS();
            private int BuL;
            private int BuM;
            private int Buf;
            private int Bus = 2054;
            private aa But = aa.eeX();
            private int Buu;
            private aa Buv = aa.eeX();
            private int Buw;

            public final /* synthetic */ a.i.b.a.c.g.a.a c(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120726);
                a o = o(eVar, gVar);
                AppMethodBeat.o(120726);
                return o;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(120730);
                a eeC = eeC();
                AppMethodBeat.o(120730);
                return eeC;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a d(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120728);
                a o = o(eVar, gVar);
                AppMethodBeat.o(120728);
                return o;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.a ecK() {
                AppMethodBeat.i(120725);
                a eeC = eeC();
                AppMethodBeat.o(120725);
                return eeC;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a ecL() {
                AppMethodBeat.i(120727);
                a eeC = eeC();
                AppMethodBeat.o(120727);
                return eeC;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.b edA() {
                AppMethodBeat.i(120721);
                a eeC = eeC();
                AppMethodBeat.o(120721);
                return eeC;
            }

            private a() {
                AppMethodBeat.i(120710);
                AppMethodBeat.o(120710);
            }

            private u eeD() {
                int i = 1;
                AppMethodBeat.i(120712);
                u uVar = new u((a.i.b.a.c.g.i.b) this, (byte) 0);
                int i2 = this.BsD;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                uVar.BsW = this.BsW;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                uVar.Bus = this.Bus;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                uVar.Buf = this.Buf;
                if ((i2 & 8) == 8) {
                    i |= 8;
                }
                uVar.But = this.But;
                if ((i2 & 16) == 16) {
                    i |= 16;
                }
                uVar.Buu = this.Buu;
                if ((this.BsD & 32) == 32) {
                    this.Btp = Collections.unmodifiableList(this.Btp);
                    this.BsD &= -33;
                }
                uVar.Btp = this.Btp;
                if ((i2 & 64) == 64) {
                    i |= 32;
                }
                uVar.Buv = this.Buv;
                if ((i2 & 128) == 128) {
                    i |= 64;
                }
                uVar.Buw = this.Buw;
                if ((i2 & 256) == 256) {
                    i |= 128;
                }
                uVar.BuK = this.BuK;
                if ((i2 & 512) == 512) {
                    i |= 256;
                }
                uVar.BuL = this.BuL;
                if ((i2 & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                    i |= 512;
                }
                uVar.BuM = this.BuM;
                if ((this.BsD & 2048) == 2048) {
                    this.BtD = Collections.unmodifiableList(this.BtD);
                    this.BsD &= -2049;
                }
                uVar.BtD = this.BtD;
                uVar.BsD = i;
                AppMethodBeat.o(120712);
                return uVar;
            }

            public final a d(u uVar) {
                AppMethodBeat.i(120713);
                if (uVar == u.eey()) {
                    AppMethodBeat.o(120713);
                } else {
                    if (uVar.ecY()) {
                        Tr(uVar.BsW);
                    }
                    if (uVar.eel()) {
                        Ts(uVar.Bus);
                    }
                    if (uVar.edW()) {
                        Tt(uVar.Buf);
                    }
                    if (uVar.eem()) {
                        d(uVar.But);
                    }
                    if (uVar.een()) {
                        Tu(uVar.Buu);
                    }
                    if (!uVar.Btp.isEmpty()) {
                        if (this.Btp.isEmpty()) {
                            this.Btp = uVar.Btp;
                            this.BsD &= -33;
                        } else {
                            edp();
                            this.Btp.addAll(uVar.Btp);
                        }
                    }
                    if (uVar.eeo()) {
                        e(uVar.Buv);
                    }
                    if (uVar.eep()) {
                        Tv(uVar.Buw);
                    }
                    if (uVar.eez()) {
                        a(uVar.BuK);
                    }
                    if (uVar.eeA()) {
                        Tw(uVar.BuL);
                    }
                    if (uVar.eeB()) {
                        Tx(uVar.BuM);
                    }
                    if (!uVar.BtD.isEmpty()) {
                        if (this.BtD.isEmpty()) {
                            this.BtD = uVar.BtD;
                            this.BsD &= -2049;
                        } else {
                            edz();
                            this.BtD.addAll(uVar.BtD);
                        }
                    }
                    a((a.i.b.a.c.g.i.c) uVar);
                    this.BsB = this.BsB.a(uVar.BsB);
                    AppMethodBeat.o(120713);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private a o(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                u uVar;
                Throwable th;
                AppMethodBeat.i(120715);
                u uVar2 = null;
                try {
                    d((u) u.BsC.a(eVar, gVar));
                    AppMethodBeat.o(120715);
                    return this;
                } catch (a.i.b.a.c.g.k e) {
                    a.i.b.a.c.g.k kVar = e;
                    uVar = (u) kVar.BzY;
                    AppMethodBeat.o(120715);
                    throw kVar;
                } catch (Throwable th2) {
                    th = th2;
                    uVar2 = uVar;
                    if (uVar2 != null) {
                    }
                    AppMethodBeat.o(120715);
                    throw th;
                }
            }

            private a Tr(int i) {
                this.BsD |= 1;
                this.BsW = i;
                return this;
            }

            private a Ts(int i) {
                this.BsD |= 2;
                this.Bus = i;
                return this;
            }

            private a Tt(int i) {
                this.BsD |= 4;
                this.Buf = i;
                return this;
            }

            private a d(aa aaVar) {
                AppMethodBeat.i(120716);
                if ((this.BsD & 8) != 8 || this.But == aa.eeX()) {
                    this.But = aaVar;
                } else {
                    this.But = aa.f(this.But).j(aaVar).eft();
                }
                this.BsD |= 8;
                AppMethodBeat.o(120716);
                return this;
            }

            private a Tu(int i) {
                this.BsD |= 16;
                this.Buu = i;
                return this;
            }

            private void edp() {
                AppMethodBeat.i(120717);
                if ((this.BsD & 32) != 32) {
                    this.Btp = new ArrayList(this.Btp);
                    this.BsD |= 32;
                }
                AppMethodBeat.o(120717);
            }

            private a e(aa aaVar) {
                AppMethodBeat.i(120718);
                if ((this.BsD & 64) != 64 || this.Buv == aa.eeX()) {
                    this.Buv = aaVar;
                } else {
                    this.Buv = aa.f(this.Buv).j(aaVar).eft();
                }
                this.BsD |= 64;
                AppMethodBeat.o(120718);
                return this;
            }

            private a Tv(int i) {
                this.BsD |= 128;
                this.Buw = i;
                return this;
            }

            private a a(ai aiVar) {
                AppMethodBeat.i(120719);
                if ((this.BsD & 256) != 256 || this.BuK == ai.efS()) {
                    this.BuK = aiVar;
                } else {
                    this.BuK = ai.b(this.BuK).d(aiVar).efW();
                }
                this.BsD |= 256;
                AppMethodBeat.o(120719);
                return this;
            }

            private a Tw(int i) {
                this.BsD |= 512;
                this.BuL = i;
                return this;
            }

            private a Tx(int i) {
                this.BsD |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                this.BuM = i;
                return this;
            }

            private void edz() {
                AppMethodBeat.i(120720);
                if ((this.BsD & 2048) != 2048) {
                    this.BtD = new ArrayList(this.BtD);
                    this.BsD |= 2048;
                }
                AppMethodBeat.o(120720);
            }

            private a eeC() {
                AppMethodBeat.i(120711);
                a d = new a().d(eeD());
                AppMethodBeat.o(120711);
                return d;
            }

            public final boolean isInitialized() {
                boolean z;
                AppMethodBeat.i(120714);
                if ((this.BsD & 4) == 4) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if ((this.BsD & 8) == 8) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z || this.But.isInitialized()) {
                        int i = 0;
                        while (i < this.Btp.size()) {
                            if (((ae) this.Btp.get(i)).isInitialized()) {
                                i++;
                            } else {
                                AppMethodBeat.o(120714);
                                return false;
                            }
                        }
                        if ((this.BsD & 64) == 64) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z || this.Buv.isInitialized()) {
                            if ((this.BsD & 256) == 256) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z && !this.BuK.isInitialized()) {
                                AppMethodBeat.o(120714);
                                return false;
                            } else if (this.BzI.isInitialized()) {
                                AppMethodBeat.o(120714);
                                return true;
                            } else {
                                AppMethodBeat.o(120714);
                                return false;
                            }
                        }
                        AppMethodBeat.o(120714);
                        return false;
                    }
                    AppMethodBeat.o(120714);
                    return false;
                }
                AppMethodBeat.o(120714);
                return false;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecE() {
                AppMethodBeat.i(120722);
                u eey = u.eey();
                AppMethodBeat.o(120722);
                return eey;
            }

            public final /* synthetic */ a.i.b.a.c.g.i ecJ() {
                AppMethodBeat.i(120723);
                u eey = u.eey();
                AppMethodBeat.o(120723);
                return eey;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecM() {
                AppMethodBeat.i(120729);
                u eeD = eeD();
                if (eeD.isInitialized()) {
                    AppMethodBeat.o(120729);
                    return eeD;
                }
                a.i.b.a.c.g.w wVar = new a.i.b.a.c.g.w();
                AppMethodBeat.o(120729);
                throw wVar;
            }

            static /* synthetic */ a eeE() {
                AppMethodBeat.i(120731);
                a aVar = new a();
                AppMethodBeat.o(120731);
                return aVar;
            }
        }

        /* synthetic */ u(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar, byte b) {
            this(eVar, gVar);
        }

        private u(a.i.b.a.c.g.i.b<u, ?> bVar) {
            super(bVar);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = bVar.BsB;
        }

        private u() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = a.i.b.a.c.g.d.Bzq;
        }

        public static u eey() {
            return BuJ;
        }

        /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0046=Splitter:B:13:0x0046, B:34:0x008b=Splitter:B:34:0x008b} */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0055  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0061  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0055  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0061  */
        /* JADX WARNING: Missing block: B:87:0x01dc, code skipped:
            r1 = r0;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private u(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
            a.i.b.a.c.g.k kVar;
            int i;
            Throwable th;
            IOException iOException;
            a.i.b.a.c.g.k kVar2;
            AppMethodBeat.i(120732);
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            int i2 = 0;
            a.i.b.a.c.g.d.b ehS = a.i.b.a.c.g.d.ehS();
            a.i.b.a.c.g.f e = a.i.b.a.c.g.f.e(ehS, 1);
            int i3 = 0;
            while (i3 == 0) {
                try {
                    int vc = eVar.vc();
                    c f;
                    switch (vc) {
                        case 0:
                            i3 = 1;
                            break;
                        case 8:
                            this.BsD |= 2;
                            this.Bus = eVar.vd();
                            break;
                        case 16:
                            this.BsD |= 4;
                            this.Buf = eVar.vd();
                            break;
                        case 26:
                            if ((this.BsD & 8) == 8) {
                                f = aa.f(this.But);
                            } else {
                                f = null;
                            }
                            this.But = (aa) eVar.a(aa.BsC, gVar);
                            if (f != null) {
                                f.j(this.But);
                                this.But = f.eft();
                            }
                            this.BsD |= 8;
                            break;
                        case 34:
                            if ((i2 & 32) != 32) {
                                this.Btp = new ArrayList();
                                i2 |= 32;
                            }
                            this.Btp.add(eVar.a(ae.BsC, gVar));
                            break;
                        case 42:
                            if ((this.BsD & 32) == 32) {
                                f = aa.f(this.Buv);
                            } else {
                                f = null;
                            }
                            this.Buv = (aa) eVar.a(aa.BsC, gVar);
                            if (f != null) {
                                f.j(this.Buv);
                                this.Buv = f.eft();
                            }
                            this.BsD |= 32;
                            break;
                        case 50:
                            a b;
                            if ((this.BsD & 128) == 128) {
                                b = ai.b(this.BuK);
                            } else {
                                b = null;
                            }
                            this.BuK = (ai) eVar.a(ai.BsC, gVar);
                            if (b != null) {
                                b.d(this.BuK);
                                this.BuK = b.efW();
                            }
                            this.BsD |= 128;
                            break;
                        case FileUtils.S_IRWXG /*56*/:
                            this.BsD |= 256;
                            this.BuL = eVar.vd();
                            break;
                        case 64:
                            this.BsD |= 512;
                            this.BuM = eVar.vd();
                            break;
                        case com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX /*72*/:
                            this.BsD |= 16;
                            this.Buu = eVar.vd();
                            break;
                        case 80:
                            this.BsD |= 64;
                            this.Buw = eVar.vd();
                            break;
                        case 88:
                            this.BsD |= 1;
                            this.BsW = eVar.vd();
                            break;
                        case com.tencent.view.d.MIC_PTU_ZIPAI_THURSDAY /*248*/:
                            if ((i2 & 2048) != 2048) {
                                this.BtD = new ArrayList();
                                i2 |= 2048;
                            }
                            this.BtD.add(Integer.valueOf(eVar.vd()));
                            break;
                        case 250:
                            int fo = eVar.fo(eVar.vd());
                            if ((i2 & 2048) == 2048 || eVar.vg() <= 0) {
                                vc = i2;
                            } else {
                                this.BtD = new ArrayList();
                                vc = i2 | 2048;
                            }
                            while (eVar.vg() > 0) {
                                try {
                                    this.BtD.add(Integer.valueOf(eVar.vd()));
                                } catch (a.i.b.a.c.g.k e2) {
                                    kVar = e2;
                                    i = vc;
                                    try {
                                        kVar.BzY = this;
                                        AppMethodBeat.o(120732);
                                        throw kVar;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if ((i & 32) == 32) {
                                        }
                                        if ((i & 2048) == 2048) {
                                        }
                                        try {
                                            e.flush();
                                            this.BsB = ehS.ehW();
                                        } catch (IOException e3) {
                                            this.BsB = ehS.ehW();
                                        } catch (Throwable th3) {
                                            this.BsB = ehS.ehW();
                                            AppMethodBeat.o(120732);
                                        }
                                        this.BzI.eii();
                                        AppMethodBeat.o(120732);
                                        throw th;
                                    }
                                } catch (IOException e4) {
                                    iOException = e4;
                                    i = vc;
                                    kVar2 = new a.i.b.a.c.g.k(iOException.getMessage());
                                    kVar2.BzY = this;
                                    AppMethodBeat.o(120732);
                                    throw kVar2;
                                } catch (Throwable th4) {
                                    th = th4;
                                    i = vc;
                                    if ((i & 32) == 32) {
                                    }
                                    if ((i & 2048) == 2048) {
                                    }
                                    e.flush();
                                    this.BsB = ehS.ehW();
                                    this.BzI.eii();
                                    AppMethodBeat.o(120732);
                                    throw th;
                                }
                            }
                            eVar.fp(fo);
                            break;
                        default:
                            if (!a(eVar, e, gVar, vc)) {
                                i3 = 1;
                                break;
                            } else {
                                vc = i2;
                                break;
                            }
                    }
                } catch (a.i.b.a.c.g.k kVar22) {
                    kVar = kVar22;
                    i = i2;
                    kVar.BzY = this;
                    AppMethodBeat.o(120732);
                    throw kVar;
                } catch (IOException e5) {
                    iOException = e5;
                    i = i2;
                    kVar22 = new a.i.b.a.c.g.k(iOException.getMessage());
                    kVar22.BzY = this;
                    AppMethodBeat.o(120732);
                    throw kVar22;
                } catch (Throwable th22) {
                    th = th22;
                    i = i2;
                    if ((i & 32) == 32) {
                        this.Btp = Collections.unmodifiableList(this.Btp);
                    }
                    if ((i & 2048) == 2048) {
                        this.BtD = Collections.unmodifiableList(this.BtD);
                    }
                    e.flush();
                    this.BsB = ehS.ehW();
                    this.BzI.eii();
                    AppMethodBeat.o(120732);
                    throw th;
                }
            }
            if ((i2 & 32) == 32) {
                this.Btp = Collections.unmodifiableList(this.Btp);
            }
            if ((i2 & 2048) == 2048) {
                this.BtD = Collections.unmodifiableList(this.BtD);
            }
            try {
                e.flush();
                this.BsB = ehS.ehW();
            } catch (IOException e6) {
                this.BsB = ehS.ehW();
            } catch (Throwable th5) {
                this.BsB = ehS.ehW();
                AppMethodBeat.o(120732);
            }
            this.BzI.eii();
            AppMethodBeat.o(120732);
        }

        static {
            AppMethodBeat.i(120739);
            u uVar = new u();
            BuJ = uVar;
            uVar.ecA();
            AppMethodBeat.o(120739);
        }

        public final a.i.b.a.c.g.s<u> ecy() {
            return BsC;
        }

        public final boolean ecY() {
            return (this.BsD & 1) == 1;
        }

        public final boolean eel() {
            return (this.BsD & 2) == 2;
        }

        public final boolean edW() {
            return (this.BsD & 4) == 4;
        }

        public final boolean eem() {
            return (this.BsD & 8) == 8;
        }

        public final boolean een() {
            return (this.BsD & 16) == 16;
        }

        public final boolean eeo() {
            return (this.BsD & 32) == 32;
        }

        public final boolean eep() {
            return (this.BsD & 64) == 64;
        }

        public final boolean eez() {
            return (this.BsD & 128) == 128;
        }

        public final boolean eeA() {
            return (this.BsD & 256) == 256;
        }

        public final boolean eeB() {
            return (this.BsD & 512) == 512;
        }

        private void ecA() {
            AppMethodBeat.i(120733);
            this.BsW = com.tencent.mm.plugin.appbrand.jsapi.j.f.CTRL_INDEX;
            this.Bus = 2054;
            this.Buf = 0;
            this.But = aa.eeX();
            this.Buu = 0;
            this.Btp = Collections.emptyList();
            this.Buv = aa.eeX();
            this.Buw = 0;
            this.BuK = ai.efS();
            this.BuL = 0;
            this.BuM = 0;
            this.BtD = Collections.emptyList();
            AppMethodBeat.o(120733);
        }

        public final boolean isInitialized() {
            AppMethodBeat.i(120734);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.o(120734);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.o(120734);
                return false;
            } else if (!edW()) {
                this.BsG = (byte) 0;
                AppMethodBeat.o(120734);
                return false;
            } else if (!eem() || this.But.isInitialized()) {
                int i = 0;
                while (i < this.Btp.size()) {
                    if (((ae) this.Btp.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120734);
                        return false;
                    }
                }
                if (eeo() && !this.Buv.isInitialized()) {
                    this.BsG = (byte) 0;
                    AppMethodBeat.o(120734);
                    return false;
                } else if (eez() && !this.BuK.isInitialized()) {
                    this.BsG = (byte) 0;
                    AppMethodBeat.o(120734);
                    return false;
                } else if (this.BzI.isInitialized()) {
                    this.BsG = (byte) 1;
                    AppMethodBeat.o(120734);
                    return true;
                } else {
                    this.BsG = (byte) 0;
                    AppMethodBeat.o(120734);
                    return false;
                }
            } else {
                this.BsG = (byte) 0;
                AppMethodBeat.o(120734);
                return false;
            }
        }

        public final void a(a.i.b.a.c.g.f fVar) {
            int i = 0;
            AppMethodBeat.i(120735);
            vq();
            a.i.b.a.c.g.i.c.a eip = eip();
            if ((this.BsD & 2) == 2) {
                fVar.bq(1, this.Bus);
            }
            if ((this.BsD & 4) == 4) {
                fVar.bq(2, this.Buf);
            }
            if ((this.BsD & 8) == 8) {
                fVar.a(3, this.But);
            }
            for (int i2 = 0; i2 < this.Btp.size(); i2++) {
                fVar.a(4, (a.i.b.a.c.g.q) this.Btp.get(i2));
            }
            if ((this.BsD & 32) == 32) {
                fVar.a(5, this.Buv);
            }
            if ((this.BsD & 128) == 128) {
                fVar.a(6, this.BuK);
            }
            if ((this.BsD & 256) == 256) {
                fVar.bq(7, this.BuL);
            }
            if ((this.BsD & 512) == 512) {
                fVar.bq(8, this.BuM);
            }
            if ((this.BsD & 16) == 16) {
                fVar.bq(9, this.Buu);
            }
            if ((this.BsD & 64) == 64) {
                fVar.bq(10, this.Buw);
            }
            if ((this.BsD & 1) == 1) {
                fVar.bq(11, this.BsW);
            }
            while (i < this.BtD.size()) {
                fVar.bq(31, ((Integer) this.BtD.get(i)).intValue());
                i++;
            }
            eip.b(19000, fVar);
            fVar.d(this.BsB);
            AppMethodBeat.o(120735);
        }

        public final int vq() {
            AppMethodBeat.i(120736);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.o(120736);
                return i;
            }
            int i2;
            if ((this.BsD & 2) == 2) {
                i = a.i.b.a.c.g.f.bs(1, this.Bus) + 0;
            } else {
                i = 0;
            }
            if ((this.BsD & 4) == 4) {
                i += a.i.b.a.c.g.f.bs(2, this.Buf);
            }
            if ((this.BsD & 8) == 8) {
                i += a.i.b.a.c.g.f.c(3, this.But);
            }
            int i3 = i;
            for (i2 = 0; i2 < this.Btp.size(); i2++) {
                i3 += a.i.b.a.c.g.f.c(4, (a.i.b.a.c.g.q) this.Btp.get(i2));
            }
            if ((this.BsD & 32) == 32) {
                i3 += a.i.b.a.c.g.f.c(5, this.Buv);
            }
            if ((this.BsD & 128) == 128) {
                i3 += a.i.b.a.c.g.f.c(6, this.BuK);
            }
            if ((this.BsD & 256) == 256) {
                i3 += a.i.b.a.c.g.f.bs(7, this.BuL);
            }
            if ((this.BsD & 512) == 512) {
                i3 += a.i.b.a.c.g.f.bs(8, this.BuM);
            }
            if ((this.BsD & 16) == 16) {
                i3 += a.i.b.a.c.g.f.bs(9, this.Buu);
            }
            if ((this.BsD & 64) == 64) {
                i3 += a.i.b.a.c.g.f.bs(10, this.Buw);
            }
            if ((this.BsD & 1) == 1) {
                i3 += a.i.b.a.c.g.f.bs(11, this.BsW);
            }
            i2 = 0;
            int i4 = 0;
            while (i2 < this.BtD.size()) {
                i2++;
                i4 = a.i.b.a.c.g.f.ft(((Integer) this.BtD.get(i2)).intValue()) + i4;
            }
            i = (((i3 + i4) + (this.BtD.size() * 2)) + this.BzI.vq()) + this.BsB.size();
            this.BsH = i;
            AppMethodBeat.o(120736);
            return i;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.g.q ecE() {
            return BuJ;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecC() {
            AppMethodBeat.i(120737);
            a d = a.eeE().d(this);
            AppMethodBeat.o(120737);
            return d;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecD() {
            AppMethodBeat.i(120738);
            a eeE = a.eeE();
            AppMethodBeat.o(120738);
            return eeE;
        }
    }

    public static final class ag extends a.i.b.a.c.g.i implements ah {
        public static a.i.b.a.c.g.s<ag> BsC = new a.i.b.a.c.g.b<ag>() {
            public final /* synthetic */ Object a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120950);
                ag agVar = new ag(eVar, gVar, (byte) 0);
                AppMethodBeat.o(120950);
                return agVar;
            }
        };
        private static final ag BvL;
        private final a.i.b.a.c.g.d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        public List<aa> BvM;
        public int BvN;

        public static final class a extends a.i.b.a.c.g.i.a<ag, a> implements ah {
            private int BsD;
            private List<aa> BvM = Collections.emptyList();
            private int BvN = -1;

            public final /* synthetic */ a.i.b.a.c.g.i.a a(a.i.b.a.c.g.i iVar) {
                AppMethodBeat.i(120959);
                a g = g((ag) iVar);
                AppMethodBeat.o(120959);
                return g;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a c(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120961);
                a w = w(eVar, gVar);
                AppMethodBeat.o(120961);
                return w;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(120966);
                a efO = efO();
                AppMethodBeat.o(120966);
                return efO;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a d(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120963);
                a w = w(eVar, gVar);
                AppMethodBeat.o(120963);
                return w;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.a ecK() {
                AppMethodBeat.i(120960);
                a efO = efO();
                AppMethodBeat.o(120960);
                return efO;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a ecL() {
                AppMethodBeat.i(120962);
                a efO = efO();
                AppMethodBeat.o(120962);
                return efO;
            }

            private a() {
                AppMethodBeat.i(120951);
                AppMethodBeat.o(120951);
            }

            public final ag efP() {
                int i = 1;
                AppMethodBeat.i(120953);
                ag agVar = new ag((a.i.b.a.c.g.i.a) this, (byte) 0);
                int i2 = this.BsD;
                if ((this.BsD & 1) == 1) {
                    this.BvM = Collections.unmodifiableList(this.BvM);
                    this.BsD &= -2;
                }
                agVar.BvM = this.BvM;
                if ((i2 & 2) != 2) {
                    i = 0;
                }
                agVar.BvN = this.BvN;
                agVar.BsD = i;
                AppMethodBeat.o(120953);
                return agVar;
            }

            public final a g(ag agVar) {
                AppMethodBeat.i(120954);
                if (agVar == ag.efM()) {
                    AppMethodBeat.o(120954);
                } else {
                    if (!agVar.BvM.isEmpty()) {
                        if (this.BvM.isEmpty()) {
                            this.BvM = agVar.BvM;
                            this.BsD &= -2;
                        } else {
                            efQ();
                            this.BvM.addAll(agVar.BvM);
                        }
                    }
                    if (agVar.efN()) {
                        TU(agVar.BvN);
                    }
                    this.BsB = this.BsB.a(agVar.BsB);
                    AppMethodBeat.o(120954);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private a w(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                ag agVar;
                Throwable th;
                AppMethodBeat.i(120956);
                ag agVar2 = null;
                try {
                    g((ag) ag.BsC.a(eVar, gVar));
                    AppMethodBeat.o(120956);
                    return this;
                } catch (a.i.b.a.c.g.k e) {
                    a.i.b.a.c.g.k kVar = e;
                    agVar = (ag) kVar.BzY;
                    AppMethodBeat.o(120956);
                    throw kVar;
                } catch (Throwable th2) {
                    th = th2;
                    agVar2 = agVar;
                    if (agVar2 != null) {
                    }
                    AppMethodBeat.o(120956);
                    throw th;
                }
            }

            private void efQ() {
                AppMethodBeat.i(120957);
                if ((this.BsD & 1) != 1) {
                    this.BvM = new ArrayList(this.BvM);
                    this.BsD |= 1;
                }
                AppMethodBeat.o(120957);
            }

            private a TU(int i) {
                this.BsD |= 2;
                this.BvN = i;
                return this;
            }

            private a efO() {
                AppMethodBeat.i(120952);
                a g = new a().g(efP());
                AppMethodBeat.o(120952);
                return g;
            }

            public final boolean isInitialized() {
                AppMethodBeat.i(120955);
                int i = 0;
                while (i < this.BvM.size()) {
                    if (((aa) this.BvM.get(i)).isInitialized()) {
                        i++;
                    } else {
                        AppMethodBeat.o(120955);
                        return false;
                    }
                }
                AppMethodBeat.o(120955);
                return true;
            }

            public final /* synthetic */ a.i.b.a.c.g.i ecJ() {
                AppMethodBeat.i(120958);
                ag efM = ag.efM();
                AppMethodBeat.o(120958);
                return efM;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecM() {
                AppMethodBeat.i(120964);
                ag efP = efP();
                if (efP.isInitialized()) {
                    AppMethodBeat.o(120964);
                    return efP;
                }
                a.i.b.a.c.g.w wVar = new a.i.b.a.c.g.w();
                AppMethodBeat.o(120964);
                throw wVar;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecE() {
                AppMethodBeat.i(120965);
                ag efM = ag.efM();
                AppMethodBeat.o(120965);
                return efM;
            }

            static /* synthetic */ a efR() {
                AppMethodBeat.i(120967);
                a aVar = new a();
                AppMethodBeat.o(120967);
                return aVar;
            }
        }

        /* synthetic */ ag(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar, byte b) {
            this(eVar, gVar);
        }

        private ag(a.i.b.a.c.g.i.a aVar) {
            super((byte) 0);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = aVar.BsB;
        }

        private ag() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = a.i.b.a.c.g.d.Bzq;
        }

        public static ag efM() {
            return BvL;
        }

        private ag(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
            AppMethodBeat.i(120968);
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            a.i.b.a.c.g.d.b ehS = a.i.b.a.c.g.d.ehS();
            a.i.b.a.c.g.f e = a.i.b.a.c.g.f.e(ehS, 1);
            int i = 0;
            int i2 = 0;
            while (i == 0) {
                try {
                    int vc = eVar.vc();
                    switch (vc) {
                        case 0:
                            i = 1;
                            break;
                        case 10:
                            if ((i2 & 1) != 1) {
                                this.BvM = new ArrayList();
                                i2 |= 1;
                            }
                            this.BvM.add(eVar.a(aa.BsC, gVar));
                            break;
                        case 16:
                            this.BsD |= 1;
                            this.BvN = eVar.vd();
                            break;
                        default:
                            if (!a(eVar, e, gVar, vc)) {
                                i = 1;
                                break;
                            }
                            break;
                    }
                } catch (a.i.b.a.c.g.k e2) {
                    e2.BzY = this;
                    AppMethodBeat.o(120968);
                    throw e2;
                } catch (IOException e3) {
                    a.i.b.a.c.g.k kVar = new a.i.b.a.c.g.k(e3.getMessage());
                    kVar.BzY = this;
                    AppMethodBeat.o(120968);
                    throw kVar;
                } catch (Throwable th) {
                    if ((i2 & 1) == 1) {
                        this.BvM = Collections.unmodifiableList(this.BvM);
                    }
                    try {
                        e.flush();
                        this.BsB = ehS.ehW();
                    } catch (IOException e4) {
                        this.BsB = ehS.ehW();
                    } catch (Throwable th2) {
                        this.BsB = ehS.ehW();
                        AppMethodBeat.o(120968);
                    }
                    eio();
                    AppMethodBeat.o(120968);
                }
            }
            if ((i2 & 1) == 1) {
                this.BvM = Collections.unmodifiableList(this.BvM);
            }
            try {
                e.flush();
                this.BsB = ehS.ehW();
            } catch (IOException e5) {
                this.BsB = ehS.ehW();
            } catch (Throwable th3) {
                this.BsB = ehS.ehW();
                AppMethodBeat.o(120968);
            }
            eio();
            AppMethodBeat.o(120968);
        }

        static {
            AppMethodBeat.i(120976);
            ag agVar = new ag();
            BvL = agVar;
            agVar.ecA();
            AppMethodBeat.o(120976);
        }

        public final a.i.b.a.c.g.s<ag> ecy() {
            return BsC;
        }

        public final boolean efN() {
            return (this.BsD & 1) == 1;
        }

        private void ecA() {
            AppMethodBeat.i(120969);
            this.BvM = Collections.emptyList();
            this.BvN = -1;
            AppMethodBeat.o(120969);
        }

        public final boolean isInitialized() {
            AppMethodBeat.i(120970);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.o(120970);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.o(120970);
                return false;
            } else {
                int i = 0;
                while (i < this.BvM.size()) {
                    if (((aa) this.BvM.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120970);
                        return false;
                    }
                }
                this.BsG = (byte) 1;
                AppMethodBeat.o(120970);
                return true;
            }
        }

        public final void a(a.i.b.a.c.g.f fVar) {
            AppMethodBeat.i(120971);
            vq();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.BvM.size()) {
                    break;
                }
                fVar.a(1, (a.i.b.a.c.g.q) this.BvM.get(i2));
                i = i2 + 1;
            }
            if ((this.BsD & 1) == 1) {
                fVar.bq(2, this.BvN);
            }
            fVar.d(this.BsB);
            AppMethodBeat.o(120971);
        }

        public final int vq() {
            AppMethodBeat.i(120972);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.o(120972);
                return i;
            }
            int i2 = 0;
            for (i = 0; i < this.BvM.size(); i++) {
                i2 += a.i.b.a.c.g.f.c(1, (a.i.b.a.c.g.q) this.BvM.get(i));
            }
            if ((this.BsD & 1) == 1) {
                i2 += a.i.b.a.c.g.f.bs(2, this.BvN);
            }
            int size = this.BsB.size() + i2;
            this.BsH = size;
            AppMethodBeat.o(120972);
            return size;
        }

        public static a d(ag agVar) {
            AppMethodBeat.i(120973);
            a g = a.efR().g(agVar);
            AppMethodBeat.o(120973);
            return g;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecC() {
            AppMethodBeat.i(120974);
            a g = a.efR().g(this);
            AppMethodBeat.o(120974);
            return g;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecD() {
            AppMethodBeat.i(120975);
            a efR = a.efR();
            AppMethodBeat.o(120975);
            return efR;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.g.q ecE() {
            return BvL;
        }
    }

    public static final class c extends a.i.b.a.c.g.i.c<c> implements d {
        public static a.i.b.a.c.g.s<c> BsC = new a.i.b.a.c.g.b<c>() {
            public final /* synthetic */ Object a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120441);
                c cVar = new c(eVar, gVar, (byte) 0);
                AppMethodBeat.o(120441);
                return cVar;
            }
        };
        private static final c Btm;
        private final a.i.b.a.c.g.d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        public int BsW;
        public List<Integer> BtA;
        private int BtB;
        public ag BtC;
        public List<Integer> BtD;
        public am BtE;
        public int Btn;
        public int Bto;
        public List<ae> Btp;
        public List<aa> Btq;
        public List<Integer> Btr;
        private int Bts;
        public List<Integer> Btt;
        private int Btu;
        public List<e> Btv;
        public List<o> Btw;
        public List<u> Btx;
        public List<ab> Bty;
        public List<k> Btz;

        public static final class a extends a.i.b.a.c.g.i.b<c, a> implements d {
            private int BsD;
            private int BsW = 6;
            private List<Integer> BtA = Collections.emptyList();
            private ag BtC = ag.efM();
            private List<Integer> BtD = Collections.emptyList();
            private am BtE = am.egi();
            private int Btn;
            private int Bto;
            private List<ae> Btp = Collections.emptyList();
            private List<aa> Btq = Collections.emptyList();
            private List<Integer> Btr = Collections.emptyList();
            private List<Integer> Btt = Collections.emptyList();
            private List<e> Btv = Collections.emptyList();
            private List<o> Btw = Collections.emptyList();
            private List<u> Btx = Collections.emptyList();
            private List<ab> Bty = Collections.emptyList();
            private List<k> Btz = Collections.emptyList();

            public final /* synthetic */ a.i.b.a.c.g.a.a c(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120466);
                a g = g(eVar, gVar);
                AppMethodBeat.o(120466);
                return g;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(120470);
                a edn = edn();
                AppMethodBeat.o(120470);
                return edn;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a d(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120468);
                a g = g(eVar, gVar);
                AppMethodBeat.o(120468);
                return g;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.a ecK() {
                AppMethodBeat.i(120465);
                a edn = edn();
                AppMethodBeat.o(120465);
                return edn;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a ecL() {
                AppMethodBeat.i(120467);
                a edn = edn();
                AppMethodBeat.o(120467);
                return edn;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.b edA() {
                AppMethodBeat.i(120461);
                a edn = edn();
                AppMethodBeat.o(120461);
                return edn;
            }

            private a() {
                AppMethodBeat.i(120442);
                AppMethodBeat.o(120442);
            }

            private c edo() {
                int i = 1;
                AppMethodBeat.i(120444);
                c cVar = new c((a.i.b.a.c.g.i.b) this, (byte) 0);
                int i2 = this.BsD;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                cVar.BsW = this.BsW;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                cVar.Btn = this.Btn;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                cVar.Bto = this.Bto;
                if ((this.BsD & 8) == 8) {
                    this.Btp = Collections.unmodifiableList(this.Btp);
                    this.BsD &= -9;
                }
                cVar.Btp = this.Btp;
                if ((this.BsD & 16) == 16) {
                    this.Btq = Collections.unmodifiableList(this.Btq);
                    this.BsD &= -17;
                }
                cVar.Btq = this.Btq;
                if ((this.BsD & 32) == 32) {
                    this.Btr = Collections.unmodifiableList(this.Btr);
                    this.BsD &= -33;
                }
                cVar.Btr = this.Btr;
                if ((this.BsD & 64) == 64) {
                    this.Btt = Collections.unmodifiableList(this.Btt);
                    this.BsD &= -65;
                }
                cVar.Btt = this.Btt;
                if ((this.BsD & 128) == 128) {
                    this.Btv = Collections.unmodifiableList(this.Btv);
                    this.BsD &= -129;
                }
                cVar.Btv = this.Btv;
                if ((this.BsD & 256) == 256) {
                    this.Btw = Collections.unmodifiableList(this.Btw);
                    this.BsD &= -257;
                }
                cVar.Btw = this.Btw;
                if ((this.BsD & 512) == 512) {
                    this.Btx = Collections.unmodifiableList(this.Btx);
                    this.BsD &= -513;
                }
                cVar.Btx = this.Btx;
                if ((this.BsD & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                    this.Bty = Collections.unmodifiableList(this.Bty);
                    this.BsD &= -1025;
                }
                cVar.Bty = this.Bty;
                if ((this.BsD & 2048) == 2048) {
                    this.Btz = Collections.unmodifiableList(this.Btz);
                    this.BsD &= -2049;
                }
                cVar.Btz = this.Btz;
                if ((this.BsD & 4096) == 4096) {
                    this.BtA = Collections.unmodifiableList(this.BtA);
                    this.BsD &= -4097;
                }
                cVar.BtA = this.BtA;
                if ((i2 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == Utility.DEFAULT_STREAM_BUFFER_SIZE) {
                    i |= 8;
                }
                cVar.BtC = this.BtC;
                if ((this.BsD & 16384) == 16384) {
                    this.BtD = Collections.unmodifiableList(this.BtD);
                    this.BsD &= -16385;
                }
                cVar.BtD = this.BtD;
                if ((i2 & 32768) == 32768) {
                    i |= 16;
                }
                cVar.BtE = this.BtE;
                cVar.BsD = i;
                AppMethodBeat.o(120444);
                return cVar;
            }

            public final a m(c cVar) {
                AppMethodBeat.i(120445);
                if (cVar == c.edi()) {
                    AppMethodBeat.o(120445);
                } else {
                    if (cVar.ecY()) {
                        SY(cVar.BsW);
                    }
                    if (cVar.edj()) {
                        SZ(cVar.Btn);
                    }
                    if (cVar.edk()) {
                        Ta(cVar.Bto);
                    }
                    if (!cVar.Btp.isEmpty()) {
                        if (this.Btp.isEmpty()) {
                            this.Btp = cVar.Btp;
                            this.BsD &= -9;
                        } else {
                            edp();
                            this.Btp.addAll(cVar.Btp);
                        }
                    }
                    if (!cVar.Btq.isEmpty()) {
                        if (this.Btq.isEmpty()) {
                            this.Btq = cVar.Btq;
                            this.BsD &= -17;
                        } else {
                            edq();
                            this.Btq.addAll(cVar.Btq);
                        }
                    }
                    if (!cVar.Btr.isEmpty()) {
                        if (this.Btr.isEmpty()) {
                            this.Btr = cVar.Btr;
                            this.BsD &= -33;
                        } else {
                            edr();
                            this.Btr.addAll(cVar.Btr);
                        }
                    }
                    if (!cVar.Btt.isEmpty()) {
                        if (this.Btt.isEmpty()) {
                            this.Btt = cVar.Btt;
                            this.BsD &= -65;
                        } else {
                            eds();
                            this.Btt.addAll(cVar.Btt);
                        }
                    }
                    if (!cVar.Btv.isEmpty()) {
                        if (this.Btv.isEmpty()) {
                            this.Btv = cVar.Btv;
                            this.BsD &= -129;
                        } else {
                            edt();
                            this.Btv.addAll(cVar.Btv);
                        }
                    }
                    if (!cVar.Btw.isEmpty()) {
                        if (this.Btw.isEmpty()) {
                            this.Btw = cVar.Btw;
                            this.BsD &= -257;
                        } else {
                            edu();
                            this.Btw.addAll(cVar.Btw);
                        }
                    }
                    if (!cVar.Btx.isEmpty()) {
                        if (this.Btx.isEmpty()) {
                            this.Btx = cVar.Btx;
                            this.BsD &= -513;
                        } else {
                            edv();
                            this.Btx.addAll(cVar.Btx);
                        }
                    }
                    if (!cVar.Bty.isEmpty()) {
                        if (this.Bty.isEmpty()) {
                            this.Bty = cVar.Bty;
                            this.BsD &= -1025;
                        } else {
                            edw();
                            this.Bty.addAll(cVar.Bty);
                        }
                    }
                    if (!cVar.Btz.isEmpty()) {
                        if (this.Btz.isEmpty()) {
                            this.Btz = cVar.Btz;
                            this.BsD &= -2049;
                        } else {
                            edx();
                            this.Btz.addAll(cVar.Btz);
                        }
                    }
                    if (!cVar.BtA.isEmpty()) {
                        if (this.BtA.isEmpty()) {
                            this.BtA = cVar.BtA;
                            this.BsD &= -4097;
                        } else {
                            edy();
                            this.BtA.addAll(cVar.BtA);
                        }
                    }
                    if (cVar.edl()) {
                        a(cVar.BtC);
                    }
                    if (!cVar.BtD.isEmpty()) {
                        if (this.BtD.isEmpty()) {
                            this.BtD = cVar.BtD;
                            this.BsD &= -16385;
                        } else {
                            edz();
                            this.BtD.addAll(cVar.BtD);
                        }
                    }
                    if (cVar.edm()) {
                        a(cVar.BtE);
                    }
                    a((a.i.b.a.c.g.i.c) cVar);
                    this.BsB = this.BsB.a(cVar.BsB);
                    AppMethodBeat.o(120445);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private a g(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                c cVar;
                Throwable th;
                AppMethodBeat.i(120447);
                c cVar2 = null;
                try {
                    m((c) c.BsC.a(eVar, gVar));
                    AppMethodBeat.o(120447);
                    return this;
                } catch (a.i.b.a.c.g.k e) {
                    a.i.b.a.c.g.k kVar = e;
                    cVar = (c) kVar.BzY;
                    AppMethodBeat.o(120447);
                    throw kVar;
                } catch (Throwable th2) {
                    th = th2;
                    cVar2 = cVar;
                    if (cVar2 != null) {
                    }
                    AppMethodBeat.o(120447);
                    throw th;
                }
            }

            private a SY(int i) {
                this.BsD |= 1;
                this.BsW = i;
                return this;
            }

            private a SZ(int i) {
                this.BsD |= 2;
                this.Btn = i;
                return this;
            }

            private a Ta(int i) {
                this.BsD |= 4;
                this.Bto = i;
                return this;
            }

            private void edp() {
                AppMethodBeat.i(120448);
                if ((this.BsD & 8) != 8) {
                    this.Btp = new ArrayList(this.Btp);
                    this.BsD |= 8;
                }
                AppMethodBeat.o(120448);
            }

            private void edq() {
                AppMethodBeat.i(120449);
                if ((this.BsD & 16) != 16) {
                    this.Btq = new ArrayList(this.Btq);
                    this.BsD |= 16;
                }
                AppMethodBeat.o(120449);
            }

            private void edr() {
                AppMethodBeat.i(120450);
                if ((this.BsD & 32) != 32) {
                    this.Btr = new ArrayList(this.Btr);
                    this.BsD |= 32;
                }
                AppMethodBeat.o(120450);
            }

            private void eds() {
                AppMethodBeat.i(120451);
                if ((this.BsD & 64) != 64) {
                    this.Btt = new ArrayList(this.Btt);
                    this.BsD |= 64;
                }
                AppMethodBeat.o(120451);
            }

            private void edt() {
                AppMethodBeat.i(120452);
                if ((this.BsD & 128) != 128) {
                    this.Btv = new ArrayList(this.Btv);
                    this.BsD |= 128;
                }
                AppMethodBeat.o(120452);
            }

            private void edu() {
                AppMethodBeat.i(120453);
                if ((this.BsD & 256) != 256) {
                    this.Btw = new ArrayList(this.Btw);
                    this.BsD |= 256;
                }
                AppMethodBeat.o(120453);
            }

            private void edv() {
                AppMethodBeat.i(120454);
                if ((this.BsD & 512) != 512) {
                    this.Btx = new ArrayList(this.Btx);
                    this.BsD |= 512;
                }
                AppMethodBeat.o(120454);
            }

            private void edw() {
                AppMethodBeat.i(120455);
                if ((this.BsD & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                    this.Bty = new ArrayList(this.Bty);
                    this.BsD |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                }
                AppMethodBeat.o(120455);
            }

            private void edx() {
                AppMethodBeat.i(120456);
                if ((this.BsD & 2048) != 2048) {
                    this.Btz = new ArrayList(this.Btz);
                    this.BsD |= 2048;
                }
                AppMethodBeat.o(120456);
            }

            private void edy() {
                AppMethodBeat.i(120457);
                if ((this.BsD & 4096) != 4096) {
                    this.BtA = new ArrayList(this.BtA);
                    this.BsD |= 4096;
                }
                AppMethodBeat.o(120457);
            }

            private a a(ag agVar) {
                AppMethodBeat.i(120458);
                if ((this.BsD & Utility.DEFAULT_STREAM_BUFFER_SIZE) != Utility.DEFAULT_STREAM_BUFFER_SIZE || this.BtC == ag.efM()) {
                    this.BtC = agVar;
                } else {
                    this.BtC = ag.d(this.BtC).g(agVar).efP();
                }
                this.BsD |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                AppMethodBeat.o(120458);
                return this;
            }

            private void edz() {
                AppMethodBeat.i(120459);
                if ((this.BsD & 16384) != 16384) {
                    this.BtD = new ArrayList(this.BtD);
                    this.BsD |= 16384;
                }
                AppMethodBeat.o(120459);
            }

            private a a(am amVar) {
                AppMethodBeat.i(120460);
                if ((this.BsD & 32768) != 32768 || this.BtE == am.egi()) {
                    this.BtE = amVar;
                } else {
                    this.BtE = am.c(this.BtE).f(amVar).egk();
                }
                this.BsD |= 32768;
                AppMethodBeat.o(120460);
                return this;
            }

            private a edn() {
                AppMethodBeat.i(120443);
                a m = new a().m(edo());
                AppMethodBeat.o(120443);
                return m;
            }

            public final boolean isInitialized() {
                boolean z;
                AppMethodBeat.i(120446);
                if ((this.BsD & 2) == 2) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    int i = 0;
                    while (i < this.Btp.size()) {
                        if (((ae) this.Btp.get(i)).isInitialized()) {
                            i++;
                        } else {
                            AppMethodBeat.o(120446);
                            return false;
                        }
                    }
                    i = 0;
                    while (i < this.Btq.size()) {
                        if (((aa) this.Btq.get(i)).isInitialized()) {
                            i++;
                        } else {
                            AppMethodBeat.o(120446);
                            return false;
                        }
                    }
                    i = 0;
                    while (i < this.Btv.size()) {
                        if (((e) this.Btv.get(i)).isInitialized()) {
                            i++;
                        } else {
                            AppMethodBeat.o(120446);
                            return false;
                        }
                    }
                    i = 0;
                    while (i < this.Btw.size()) {
                        if (((o) this.Btw.get(i)).isInitialized()) {
                            i++;
                        } else {
                            AppMethodBeat.o(120446);
                            return false;
                        }
                    }
                    i = 0;
                    while (i < this.Btx.size()) {
                        if (((u) this.Btx.get(i)).isInitialized()) {
                            i++;
                        } else {
                            AppMethodBeat.o(120446);
                            return false;
                        }
                    }
                    i = 0;
                    while (i < this.Bty.size()) {
                        if (((ab) this.Bty.get(i)).isInitialized()) {
                            i++;
                        } else {
                            AppMethodBeat.o(120446);
                            return false;
                        }
                    }
                    i = 0;
                    while (i < this.Btz.size()) {
                        if (((k) this.Btz.get(i)).isInitialized()) {
                            i++;
                        } else {
                            AppMethodBeat.o(120446);
                            return false;
                        }
                    }
                    if ((this.BsD & Utility.DEFAULT_STREAM_BUFFER_SIZE) == Utility.DEFAULT_STREAM_BUFFER_SIZE) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z && !this.BtC.isInitialized()) {
                        AppMethodBeat.o(120446);
                        return false;
                    } else if (this.BzI.isInitialized()) {
                        AppMethodBeat.o(120446);
                        return true;
                    } else {
                        AppMethodBeat.o(120446);
                        return false;
                    }
                }
                AppMethodBeat.o(120446);
                return false;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecE() {
                AppMethodBeat.i(120462);
                c edi = c.edi();
                AppMethodBeat.o(120462);
                return edi;
            }

            public final /* synthetic */ a.i.b.a.c.g.i ecJ() {
                AppMethodBeat.i(120463);
                c edi = c.edi();
                AppMethodBeat.o(120463);
                return edi;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecM() {
                AppMethodBeat.i(120469);
                c edo = edo();
                if (edo.isInitialized()) {
                    AppMethodBeat.o(120469);
                    return edo;
                }
                a.i.b.a.c.g.w wVar = new a.i.b.a.c.g.w();
                AppMethodBeat.o(120469);
                throw wVar;
            }

            static /* synthetic */ a edB() {
                AppMethodBeat.i(120471);
                a aVar = new a();
                AppMethodBeat.o(120471);
                return aVar;
            }
        }

        public enum b implements a.i.b.a.c.g.j.a {
            CLASS(0),
            INTERFACE(1),
            ENUM_CLASS(2),
            ENUM_ENTRY(3),
            ANNOTATION_CLASS(4),
            OBJECT(5),
            COMPANION_OBJECT(6);
            
            private static a.i.b.a.c.g.j.b<b> Btk;
            private final int value;

            static {
                Btk = new a.i.b.a.c.g.j.b<b>() {
                    public final /* synthetic */ a.i.b.a.c.g.j.a SW(int i) {
                        AppMethodBeat.i(120472);
                        b Tb = b.Tb(i);
                        AppMethodBeat.o(120472);
                        return Tb;
                    }
                };
                AppMethodBeat.o(120475);
            }

            public final int edd() {
                return this.value;
            }

            public static b Tb(int i) {
                switch (i) {
                    case 0:
                        return CLASS;
                    case 1:
                        return INTERFACE;
                    case 2:
                        return ENUM_CLASS;
                    case 3:
                        return ENUM_ENTRY;
                    case 4:
                        return ANNOTATION_CLASS;
                    case 5:
                        return OBJECT;
                    case 6:
                        return COMPANION_OBJECT;
                    default:
                        return null;
                }
            }

            private b(int i) {
                this.value = i;
            }
        }

        /* synthetic */ c(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar, byte b) {
            this(eVar, gVar);
        }

        private c(a.i.b.a.c.g.i.b<c, ?> bVar) {
            super(bVar);
            this.Bts = -1;
            this.Btu = -1;
            this.BtB = -1;
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = bVar.BsB;
        }

        private c() {
            this.Bts = -1;
            this.Btu = -1;
            this.BtB = -1;
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = a.i.b.a.c.g.d.Bzq;
        }

        public static c edi() {
            return Btm;
        }

        private c(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
            AppMethodBeat.i(120476);
            this.Bts = -1;
            this.Btu = -1;
            this.BtB = -1;
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            int i = 0;
            a.i.b.a.c.g.d.b ehS = a.i.b.a.c.g.d.ehS();
            a.i.b.a.c.g.f e = a.i.b.a.c.g.f.e(ehS, 1);
            Object obj = null;
            while (obj == null) {
                try {
                    int vc = eVar.vc();
                    switch (vc) {
                        case 0:
                            obj = 1;
                            break;
                        case 8:
                            this.BsD |= 1;
                            this.BsW = eVar.vd();
                            break;
                        case 16:
                            if ((i & 32) != 32) {
                                this.Btr = new ArrayList();
                                i |= 32;
                            }
                            this.Btr.add(Integer.valueOf(eVar.vd()));
                            break;
                        case 18:
                            vc = eVar.fo(eVar.vd());
                            if ((i & 32) != 32 && eVar.vg() > 0) {
                                this.Btr = new ArrayList();
                                i |= 32;
                            }
                            while (eVar.vg() > 0) {
                                this.Btr.add(Integer.valueOf(eVar.vd()));
                            }
                            eVar.fp(vc);
                            break;
                        case 24:
                            this.BsD |= 2;
                            this.Btn = eVar.vd();
                            break;
                        case 32:
                            this.BsD |= 4;
                            this.Bto = eVar.vd();
                            break;
                        case 42:
                            if ((i & 8) != 8) {
                                this.Btp = new ArrayList();
                                i |= 8;
                            }
                            this.Btp.add(eVar.a(ae.BsC, gVar));
                            break;
                        case 50:
                            if ((i & 16) != 16) {
                                this.Btq = new ArrayList();
                                i |= 16;
                            }
                            this.Btq.add(eVar.a(aa.BsC, gVar));
                            break;
                        case FileUtils.S_IRWXG /*56*/:
                            if ((i & 64) != 64) {
                                this.Btt = new ArrayList();
                                i |= 64;
                            }
                            this.Btt.add(Integer.valueOf(eVar.vd()));
                            break;
                        case com.tencent.mm.plugin.appbrand.jsapi.aa.CTRL_INDEX /*58*/:
                            vc = eVar.fo(eVar.vd());
                            if ((i & 64) != 64 && eVar.vg() > 0) {
                                this.Btt = new ArrayList();
                                i |= 64;
                            }
                            while (eVar.vg() > 0) {
                                this.Btt.add(Integer.valueOf(eVar.vd()));
                            }
                            eVar.fp(vc);
                            break;
                        case 66:
                            if ((i & 128) != 128) {
                                this.Btv = new ArrayList();
                                i |= 128;
                            }
                            this.Btv.add(eVar.a(e.BsC, gVar));
                            break;
                        case 74:
                            if ((i & 256) != 256) {
                                this.Btw = new ArrayList();
                                i |= 256;
                            }
                            this.Btw.add(eVar.a(o.BsC, gVar));
                            break;
                        case 82:
                            if ((i & 512) != 512) {
                                this.Btx = new ArrayList();
                                i |= 512;
                            }
                            this.Btx.add(eVar.a(u.BsC, gVar));
                            break;
                        case 90:
                            if ((i & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                                this.Bty = new ArrayList();
                                i |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                            }
                            this.Bty.add(eVar.a(ab.BsC, gVar));
                            break;
                        case 106:
                            if ((i & 2048) != 2048) {
                                this.Btz = new ArrayList();
                                i |= 2048;
                            }
                            this.Btz.add(eVar.a(k.BsC, gVar));
                            break;
                        case 128:
                            if ((i & 4096) != 4096) {
                                this.BtA = new ArrayList();
                                i |= 4096;
                            }
                            this.BtA.add(Integer.valueOf(eVar.vd()));
                            break;
                        case 130:
                            vc = eVar.fo(eVar.vd());
                            if ((i & 4096) != 4096 && eVar.vg() > 0) {
                                this.BtA = new ArrayList();
                                i |= 4096;
                            }
                            while (eVar.vg() > 0) {
                                this.BtA.add(Integer.valueOf(eVar.vd()));
                            }
                            eVar.fp(vc);
                            break;
                        case 242:
                            a d;
                            if ((this.BsD & 8) == 8) {
                                d = ag.d(this.BtC);
                            } else {
                                d = null;
                            }
                            this.BtC = (ag) eVar.a(ag.BsC, gVar);
                            if (d != null) {
                                d.g(this.BtC);
                                this.BtC = d.efP();
                            }
                            this.BsD |= 8;
                            break;
                        case com.tencent.view.d.MIC_PTU_ZIPAI_THURSDAY /*248*/:
                            if ((i & 16384) != 16384) {
                                this.BtD = new ArrayList();
                                i |= 16384;
                            }
                            this.BtD.add(Integer.valueOf(eVar.vd()));
                            break;
                        case 250:
                            vc = eVar.fo(eVar.vd());
                            if ((i & 16384) != 16384 && eVar.vg() > 0) {
                                this.BtD = new ArrayList();
                                i |= 16384;
                            }
                            while (eVar.vg() > 0) {
                                this.BtD.add(Integer.valueOf(eVar.vd()));
                            }
                            eVar.fp(vc);
                            break;
                        case com.tencent.view.d.MIC_PTU_ZIPAI_SAPPORO /*258*/:
                            a c;
                            if ((this.BsD & 16) == 16) {
                                c = am.c(this.BtE);
                            } else {
                                c = null;
                            }
                            this.BtE = (am) eVar.a(am.BsC, gVar);
                            if (c != null) {
                                c.f(this.BtE);
                                this.BtE = c.egk();
                            }
                            this.BsD |= 16;
                            break;
                        default:
                            if (!a(eVar, e, gVar, vc)) {
                                obj = 1;
                                break;
                            }
                            break;
                    }
                } catch (a.i.b.a.c.g.k e2) {
                    e2.BzY = this;
                    AppMethodBeat.o(120476);
                    throw e2;
                } catch (IOException e3) {
                    a.i.b.a.c.g.k kVar = new a.i.b.a.c.g.k(e3.getMessage());
                    kVar.BzY = this;
                    AppMethodBeat.o(120476);
                    throw kVar;
                } catch (Throwable th) {
                    if ((i & 32) == 32) {
                        this.Btr = Collections.unmodifiableList(this.Btr);
                    }
                    if ((i & 8) == 8) {
                        this.Btp = Collections.unmodifiableList(this.Btp);
                    }
                    if ((i & 16) == 16) {
                        this.Btq = Collections.unmodifiableList(this.Btq);
                    }
                    if ((i & 64) == 64) {
                        this.Btt = Collections.unmodifiableList(this.Btt);
                    }
                    if ((i & 128) == 128) {
                        this.Btv = Collections.unmodifiableList(this.Btv);
                    }
                    if ((i & 256) == 256) {
                        this.Btw = Collections.unmodifiableList(this.Btw);
                    }
                    if ((i & 512) == 512) {
                        this.Btx = Collections.unmodifiableList(this.Btx);
                    }
                    if ((i & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                        this.Bty = Collections.unmodifiableList(this.Bty);
                    }
                    if ((i & 2048) == 2048) {
                        this.Btz = Collections.unmodifiableList(this.Btz);
                    }
                    if ((i & 4096) == 4096) {
                        this.BtA = Collections.unmodifiableList(this.BtA);
                    }
                    if ((i & 16384) == 16384) {
                        this.BtD = Collections.unmodifiableList(this.BtD);
                    }
                    try {
                        e.flush();
                        this.BsB = ehS.ehW();
                    } catch (IOException e4) {
                        this.BsB = ehS.ehW();
                    } catch (Throwable th2) {
                        this.BsB = ehS.ehW();
                        AppMethodBeat.o(120476);
                    }
                    this.BzI.eii();
                    AppMethodBeat.o(120476);
                }
            }
            if ((i & 32) == 32) {
                this.Btr = Collections.unmodifiableList(this.Btr);
            }
            if ((i & 8) == 8) {
                this.Btp = Collections.unmodifiableList(this.Btp);
            }
            if ((i & 16) == 16) {
                this.Btq = Collections.unmodifiableList(this.Btq);
            }
            if ((i & 64) == 64) {
                this.Btt = Collections.unmodifiableList(this.Btt);
            }
            if ((i & 128) == 128) {
                this.Btv = Collections.unmodifiableList(this.Btv);
            }
            if ((i & 256) == 256) {
                this.Btw = Collections.unmodifiableList(this.Btw);
            }
            if ((i & 512) == 512) {
                this.Btx = Collections.unmodifiableList(this.Btx);
            }
            if ((i & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                this.Bty = Collections.unmodifiableList(this.Bty);
            }
            if ((i & 2048) == 2048) {
                this.Btz = Collections.unmodifiableList(this.Btz);
            }
            if ((i & 4096) == 4096) {
                this.BtA = Collections.unmodifiableList(this.BtA);
            }
            if ((i & 16384) == 16384) {
                this.BtD = Collections.unmodifiableList(this.BtD);
            }
            try {
                e.flush();
                this.BsB = ehS.ehW();
            } catch (IOException e5) {
                this.BsB = ehS.ehW();
            } catch (Throwable th3) {
                this.BsB = ehS.ehW();
                AppMethodBeat.o(120476);
            }
            this.BzI.eii();
            AppMethodBeat.o(120476);
        }

        static {
            AppMethodBeat.i(120484);
            c cVar = new c();
            Btm = cVar;
            cVar.ecA();
            AppMethodBeat.o(120484);
        }

        public final a.i.b.a.c.g.s<c> ecy() {
            return BsC;
        }

        public final boolean ecY() {
            return (this.BsD & 1) == 1;
        }

        public final boolean edj() {
            return (this.BsD & 2) == 2;
        }

        public final boolean edk() {
            return (this.BsD & 4) == 4;
        }

        public final boolean edl() {
            return (this.BsD & 8) == 8;
        }

        public final boolean edm() {
            return (this.BsD & 16) == 16;
        }

        private void ecA() {
            AppMethodBeat.i(120477);
            this.BsW = 6;
            this.Btn = 0;
            this.Bto = 0;
            this.Btp = Collections.emptyList();
            this.Btq = Collections.emptyList();
            this.Btr = Collections.emptyList();
            this.Btt = Collections.emptyList();
            this.Btv = Collections.emptyList();
            this.Btw = Collections.emptyList();
            this.Btx = Collections.emptyList();
            this.Bty = Collections.emptyList();
            this.Btz = Collections.emptyList();
            this.BtA = Collections.emptyList();
            this.BtC = ag.efM();
            this.BtD = Collections.emptyList();
            this.BtE = am.egi();
            AppMethodBeat.o(120477);
        }

        public final boolean isInitialized() {
            AppMethodBeat.i(120478);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.o(120478);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.o(120478);
                return false;
            } else if (edj()) {
                int i = 0;
                while (i < this.Btp.size()) {
                    if (((ae) this.Btp.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120478);
                        return false;
                    }
                }
                i = 0;
                while (i < this.Btq.size()) {
                    if (((aa) this.Btq.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120478);
                        return false;
                    }
                }
                i = 0;
                while (i < this.Btv.size()) {
                    if (((e) this.Btv.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120478);
                        return false;
                    }
                }
                i = 0;
                while (i < this.Btw.size()) {
                    if (((o) this.Btw.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120478);
                        return false;
                    }
                }
                i = 0;
                while (i < this.Btx.size()) {
                    if (((u) this.Btx.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120478);
                        return false;
                    }
                }
                i = 0;
                while (i < this.Bty.size()) {
                    if (((ab) this.Bty.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120478);
                        return false;
                    }
                }
                i = 0;
                while (i < this.Btz.size()) {
                    if (((k) this.Btz.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120478);
                        return false;
                    }
                }
                if (edl() && !this.BtC.isInitialized()) {
                    this.BsG = (byte) 0;
                    AppMethodBeat.o(120478);
                    return false;
                } else if (this.BzI.isInitialized()) {
                    this.BsG = (byte) 1;
                    AppMethodBeat.o(120478);
                    return true;
                } else {
                    this.BsG = (byte) 0;
                    AppMethodBeat.o(120478);
                    return false;
                }
            } else {
                this.BsG = (byte) 0;
                AppMethodBeat.o(120478);
                return false;
            }
        }

        public final void a(a.i.b.a.c.g.f fVar) {
            int i;
            int i2 = 0;
            AppMethodBeat.i(120479);
            vq();
            a.i.b.a.c.g.i.c.a eip = eip();
            if ((this.BsD & 1) == 1) {
                fVar.bq(1, this.BsW);
            }
            if (this.Btr.size() > 0) {
                fVar.fw(18);
                fVar.fw(this.Bts);
            }
            for (i = 0; i < this.Btr.size(); i++) {
                fVar.Uy(((Integer) this.Btr.get(i)).intValue());
            }
            if ((this.BsD & 2) == 2) {
                fVar.bq(3, this.Btn);
            }
            if ((this.BsD & 4) == 4) {
                fVar.bq(4, this.Bto);
            }
            for (i = 0; i < this.Btp.size(); i++) {
                fVar.a(5, (a.i.b.a.c.g.q) this.Btp.get(i));
            }
            for (i = 0; i < this.Btq.size(); i++) {
                fVar.a(6, (a.i.b.a.c.g.q) this.Btq.get(i));
            }
            if (this.Btt.size() > 0) {
                fVar.fw(58);
                fVar.fw(this.Btu);
            }
            for (i = 0; i < this.Btt.size(); i++) {
                fVar.Uy(((Integer) this.Btt.get(i)).intValue());
            }
            for (i = 0; i < this.Btv.size(); i++) {
                fVar.a(8, (a.i.b.a.c.g.q) this.Btv.get(i));
            }
            for (i = 0; i < this.Btw.size(); i++) {
                fVar.a(9, (a.i.b.a.c.g.q) this.Btw.get(i));
            }
            for (i = 0; i < this.Btx.size(); i++) {
                fVar.a(10, (a.i.b.a.c.g.q) this.Btx.get(i));
            }
            for (i = 0; i < this.Bty.size(); i++) {
                fVar.a(11, (a.i.b.a.c.g.q) this.Bty.get(i));
            }
            for (i = 0; i < this.Btz.size(); i++) {
                fVar.a(13, (a.i.b.a.c.g.q) this.Btz.get(i));
            }
            if (this.BtA.size() > 0) {
                fVar.fw(130);
                fVar.fw(this.BtB);
            }
            for (i = 0; i < this.BtA.size(); i++) {
                fVar.Uy(((Integer) this.BtA.get(i)).intValue());
            }
            if ((this.BsD & 8) == 8) {
                fVar.a(30, this.BtC);
            }
            while (i2 < this.BtD.size()) {
                fVar.bq(31, ((Integer) this.BtD.get(i2)).intValue());
                i2++;
            }
            if ((this.BsD & 16) == 16) {
                fVar.a(32, this.BtE);
            }
            eip.b(19000, fVar);
            fVar.d(this.BsB);
            AppMethodBeat.o(120479);
        }

        public final int vq() {
            AppMethodBeat.i(120480);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.o(120480);
                return i;
            }
            int bs;
            int i2;
            if ((this.BsD & 1) == 1) {
                bs = a.i.b.a.c.g.f.bs(1, this.BsW) + 0;
            } else {
                bs = 0;
            }
            int i3 = 0;
            for (i2 = 0; i2 < this.Btr.size(); i2++) {
                i3 += a.i.b.a.c.g.f.ft(((Integer) this.Btr.get(i2)).intValue());
            }
            i = bs + i3;
            if (!this.Btr.isEmpty()) {
                i = (i + 1) + a.i.b.a.c.g.f.ft(i3);
            }
            this.Bts = i3;
            if ((this.BsD & 2) == 2) {
                i += a.i.b.a.c.g.f.bs(3, this.Btn);
            }
            if ((this.BsD & 4) == 4) {
                i += a.i.b.a.c.g.f.bs(4, this.Bto);
            }
            i2 = i;
            for (bs = 0; bs < this.Btp.size(); bs++) {
                i2 += a.i.b.a.c.g.f.c(5, (a.i.b.a.c.g.q) this.Btp.get(bs));
            }
            for (bs = 0; bs < this.Btq.size(); bs++) {
                i2 += a.i.b.a.c.g.f.c(6, (a.i.b.a.c.g.q) this.Btq.get(bs));
            }
            i3 = 0;
            for (bs = 0; bs < this.Btt.size(); bs++) {
                i3 += a.i.b.a.c.g.f.ft(((Integer) this.Btt.get(bs)).intValue());
            }
            i = i2 + i3;
            if (!this.Btt.isEmpty()) {
                i = (i + 1) + a.i.b.a.c.g.f.ft(i3);
            }
            this.Btu = i3;
            i2 = i;
            for (bs = 0; bs < this.Btv.size(); bs++) {
                i2 += a.i.b.a.c.g.f.c(8, (a.i.b.a.c.g.q) this.Btv.get(bs));
            }
            for (bs = 0; bs < this.Btw.size(); bs++) {
                i2 += a.i.b.a.c.g.f.c(9, (a.i.b.a.c.g.q) this.Btw.get(bs));
            }
            for (bs = 0; bs < this.Btx.size(); bs++) {
                i2 += a.i.b.a.c.g.f.c(10, (a.i.b.a.c.g.q) this.Btx.get(bs));
            }
            for (bs = 0; bs < this.Bty.size(); bs++) {
                i2 += a.i.b.a.c.g.f.c(11, (a.i.b.a.c.g.q) this.Bty.get(bs));
            }
            for (bs = 0; bs < this.Btz.size(); bs++) {
                i2 += a.i.b.a.c.g.f.c(13, (a.i.b.a.c.g.q) this.Btz.get(bs));
            }
            i3 = 0;
            for (bs = 0; bs < this.BtA.size(); bs++) {
                i3 += a.i.b.a.c.g.f.ft(((Integer) this.BtA.get(bs)).intValue());
            }
            i = i2 + i3;
            if (!this.BtA.isEmpty()) {
                i = (i + 2) + a.i.b.a.c.g.f.ft(i3);
            }
            this.BtB = i3;
            if ((this.BsD & 8) == 8) {
                bs = i + a.i.b.a.c.g.f.c(30, this.BtC);
            } else {
                bs = i;
            }
            i2 = 0;
            i3 = 0;
            while (i2 < this.BtD.size()) {
                i2++;
                i3 = a.i.b.a.c.g.f.ft(((Integer) this.BtD.get(i2)).intValue()) + i3;
            }
            i = (bs + i3) + (this.BtD.size() * 2);
            if ((this.BsD & 16) == 16) {
                i += a.i.b.a.c.g.f.c(32, this.BtE);
            }
            i = (i + this.BzI.vq()) + this.BsB.size();
            this.BsH = i;
            AppMethodBeat.o(120480);
            return i;
        }

        public static c a(InputStream inputStream, a.i.b.a.c.g.g gVar) {
            AppMethodBeat.i(120481);
            c cVar = (c) BsC.j(inputStream, gVar);
            AppMethodBeat.o(120481);
            return cVar;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.g.q ecE() {
            return Btm;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecC() {
            AppMethodBeat.i(120482);
            a m = a.edB().m(this);
            AppMethodBeat.o(120482);
            return m;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecD() {
            AppMethodBeat.i(120483);
            a edB = a.edB();
            AppMethodBeat.o(120483);
            return edB;
        }
    }

    public interface f extends a.i.b.a.c.g.i.d {
    }

    public static final class m extends a.i.b.a.c.g.i implements n {
        public static a.i.b.a.c.g.s<m> BsC = new a.i.b.a.c.g.b<m>() {
            public final /* synthetic */ Object a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120601);
                m mVar = new m(eVar, gVar, (byte) 0);
                AppMethodBeat.o(120601);
                return mVar;
            }
        };
        private static final m Bug;
        private final a.i.b.a.c.g.d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        int BsW;
        int Buh;
        b Bui;
        aa Buj;
        int Buk;
        private List<m> Bul;
        private List<m> Bum;

        public static final class a extends a.i.b.a.c.g.i.a<m, a> implements n {
            private int BsD;
            private int BsW;
            private int Buh;
            private b Bui = b.TRUE;
            private aa Buj = aa.eeX();
            private int Buk;
            private List<m> Bul = Collections.emptyList();
            private List<m> Bum = Collections.emptyList();

            public final /* synthetic */ a.i.b.a.c.g.a.a c(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120615);
                a l = l(eVar, gVar);
                AppMethodBeat.o(120615);
                return l;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(120620);
                a eef = eef();
                AppMethodBeat.o(120620);
                return eef;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a d(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120617);
                a l = l(eVar, gVar);
                AppMethodBeat.o(120617);
                return l;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.a ecK() {
                AppMethodBeat.i(120614);
                a eef = eef();
                AppMethodBeat.o(120614);
                return eef;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a ecL() {
                AppMethodBeat.i(120616);
                a eef = eef();
                AppMethodBeat.o(120616);
                return eef;
            }

            private a() {
                AppMethodBeat.i(120602);
                AppMethodBeat.o(120602);
            }

            public final m eeg() {
                int i = 1;
                AppMethodBeat.i(120604);
                m mVar = new m((a.i.b.a.c.g.i.a) this, (byte) 0);
                int i2 = this.BsD;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                mVar.BsW = this.BsW;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                mVar.Buh = this.Buh;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                mVar.Bui = this.Bui;
                if ((i2 & 8) == 8) {
                    i |= 8;
                }
                mVar.Buj = this.Buj;
                if ((i2 & 16) == 16) {
                    i |= 16;
                }
                mVar.Buk = this.Buk;
                if ((this.BsD & 32) == 32) {
                    this.Bul = Collections.unmodifiableList(this.Bul);
                    this.BsD &= -33;
                }
                mVar.Bul = this.Bul;
                if ((this.BsD & 64) == 64) {
                    this.Bum = Collections.unmodifiableList(this.Bum);
                    this.BsD &= -65;
                }
                mVar.Bum = this.Bum;
                mVar.BsD = i;
                AppMethodBeat.o(120604);
                return mVar;
            }

            public final a f(m mVar) {
                AppMethodBeat.i(120605);
                if (mVar == m.eea()) {
                    AppMethodBeat.o(120605);
                } else {
                    if (mVar.ecY()) {
                        Tg(mVar.BsW);
                    }
                    if (mVar.eeb()) {
                        Th(mVar.Buh);
                    }
                    if (mVar.eec()) {
                        a(mVar.Bui);
                    }
                    if (mVar.eed()) {
                        a(mVar.Buj);
                    }
                    if (mVar.eee()) {
                        Ti(mVar.Buk);
                    }
                    if (!mVar.Bul.isEmpty()) {
                        if (this.Bul.isEmpty()) {
                            this.Bul = mVar.Bul;
                            this.BsD &= -33;
                        } else {
                            eeh();
                            this.Bul.addAll(mVar.Bul);
                        }
                    }
                    if (!mVar.Bum.isEmpty()) {
                        if (this.Bum.isEmpty()) {
                            this.Bum = mVar.Bum;
                            this.BsD &= -65;
                        } else {
                            eei();
                            this.Bum.addAll(mVar.Bum);
                        }
                    }
                    this.BsB = this.BsB.a(mVar.BsB);
                    AppMethodBeat.o(120605);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private a l(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                m mVar;
                Throwable th;
                AppMethodBeat.i(120607);
                m mVar2 = null;
                try {
                    f((m) m.BsC.a(eVar, gVar));
                    AppMethodBeat.o(120607);
                    return this;
                } catch (a.i.b.a.c.g.k e) {
                    a.i.b.a.c.g.k kVar = e;
                    mVar = (m) kVar.BzY;
                    AppMethodBeat.o(120607);
                    throw kVar;
                } catch (Throwable th2) {
                    th = th2;
                    mVar2 = mVar;
                    if (mVar2 != null) {
                    }
                    AppMethodBeat.o(120607);
                    throw th;
                }
            }

            private a Tg(int i) {
                this.BsD |= 1;
                this.BsW = i;
                return this;
            }

            private a Th(int i) {
                this.BsD |= 2;
                this.Buh = i;
                return this;
            }

            private a a(b bVar) {
                AppMethodBeat.i(120608);
                if (bVar == null) {
                    NullPointerException nullPointerException = new NullPointerException();
                    AppMethodBeat.o(120608);
                    throw nullPointerException;
                }
                this.BsD |= 4;
                this.Bui = bVar;
                AppMethodBeat.o(120608);
                return this;
            }

            private a a(aa aaVar) {
                AppMethodBeat.i(120609);
                if ((this.BsD & 8) != 8 || this.Buj == aa.eeX()) {
                    this.Buj = aaVar;
                } else {
                    this.Buj = aa.f(this.Buj).j(aaVar).eft();
                }
                this.BsD |= 8;
                AppMethodBeat.o(120609);
                return this;
            }

            private a Ti(int i) {
                this.BsD |= 16;
                this.Buk = i;
                return this;
            }

            private void eeh() {
                AppMethodBeat.i(120610);
                if ((this.BsD & 32) != 32) {
                    this.Bul = new ArrayList(this.Bul);
                    this.BsD |= 32;
                }
                AppMethodBeat.o(120610);
            }

            private void eei() {
                AppMethodBeat.i(120611);
                if ((this.BsD & 64) != 64) {
                    this.Bum = new ArrayList(this.Bum);
                    this.BsD |= 64;
                }
                AppMethodBeat.o(120611);
            }

            private a eef() {
                AppMethodBeat.i(120603);
                a f = new a().f(eeg());
                AppMethodBeat.o(120603);
                return f;
            }

            public final boolean isInitialized() {
                boolean z;
                AppMethodBeat.i(120606);
                if ((this.BsD & 8) == 8) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z || this.Buj.isInitialized()) {
                    int i = 0;
                    while (i < this.Bul.size()) {
                        if (((m) this.Bul.get(i)).isInitialized()) {
                            i++;
                        } else {
                            AppMethodBeat.o(120606);
                            return false;
                        }
                    }
                    i = 0;
                    while (i < this.Bum.size()) {
                        if (((m) this.Bum.get(i)).isInitialized()) {
                            i++;
                        } else {
                            AppMethodBeat.o(120606);
                            return false;
                        }
                    }
                    AppMethodBeat.o(120606);
                    return true;
                }
                AppMethodBeat.o(120606);
                return false;
            }

            public final /* synthetic */ a.i.b.a.c.g.i ecJ() {
                AppMethodBeat.i(120612);
                m eea = m.eea();
                AppMethodBeat.o(120612);
                return eea;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecM() {
                AppMethodBeat.i(120618);
                m eeg = eeg();
                if (eeg.isInitialized()) {
                    AppMethodBeat.o(120618);
                    return eeg;
                }
                a.i.b.a.c.g.w wVar = new a.i.b.a.c.g.w();
                AppMethodBeat.o(120618);
                throw wVar;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecE() {
                AppMethodBeat.i(120619);
                m eea = m.eea();
                AppMethodBeat.o(120619);
                return eea;
            }

            static /* synthetic */ a eej() {
                AppMethodBeat.i(120621);
                a aVar = new a();
                AppMethodBeat.o(120621);
                return aVar;
            }
        }

        public enum b implements a.i.b.a.c.g.j.a {
            TRUE(0),
            FALSE(1),
            NULL(2);
            
            private static a.i.b.a.c.g.j.b<b> Btk;
            final int value;

            static {
                Btk = new a.i.b.a.c.g.j.b<b>() {
                    public final /* synthetic */ a.i.b.a.c.g.j.a SW(int i) {
                        AppMethodBeat.i(120622);
                        b Tj = b.Tj(i);
                        AppMethodBeat.o(120622);
                        return Tj;
                    }
                };
                AppMethodBeat.o(120625);
            }

            public final int edd() {
                return this.value;
            }

            public static b Tj(int i) {
                switch (i) {
                    case 0:
                        return TRUE;
                    case 1:
                        return FALSE;
                    case 2:
                        return NULL;
                    default:
                        return null;
                }
            }

            private b(int i) {
                this.value = i;
            }
        }

        /* synthetic */ m(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar, byte b) {
            this(eVar, gVar);
        }

        private m(a.i.b.a.c.g.i.a aVar) {
            super((byte) 0);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = aVar.BsB;
        }

        private m() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = a.i.b.a.c.g.d.Bzq;
        }

        public static m eea() {
            return Bug;
        }

        /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0044=Splitter:B:13:0x0044, B:34:0x0087=Splitter:B:34:0x0087} */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x005f  */
        /* JADX WARNING: Missing block: B:62:0x0128, code skipped:
            r1 = r0;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private m(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
            a.i.b.a.c.g.k kVar;
            Throwable th;
            IOException iOException;
            a.i.b.a.c.g.k kVar2;
            AppMethodBeat.i(120626);
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            int i = 0;
            a.i.b.a.c.g.d.b ehS = a.i.b.a.c.g.d.ehS();
            a.i.b.a.c.g.f e = a.i.b.a.c.g.f.e(ehS, 1);
            int i2 = 0;
            while (i2 == 0) {
                try {
                    int vc = eVar.vc();
                    switch (vc) {
                        case 0:
                            i2 = 1;
                            break;
                        case 8:
                            this.BsD |= 1;
                            this.BsW = eVar.vd();
                            break;
                        case 16:
                            this.BsD |= 2;
                            this.Buh = eVar.vd();
                            break;
                        case 24:
                            int vd = eVar.vd();
                            b Tj = b.Tj(vd);
                            if (Tj != null) {
                                this.BsD |= 4;
                                this.Bui = Tj;
                                break;
                            }
                            e.fw(vc);
                            e.fw(vd);
                            break;
                        case 34:
                            c f;
                            if ((this.BsD & 8) == 8) {
                                f = aa.f(this.Buj);
                            } else {
                                f = null;
                            }
                            this.Buj = (aa) eVar.a(aa.BsC, gVar);
                            if (f != null) {
                                f.j(this.Buj);
                                this.Buj = f.eft();
                            }
                            this.BsD |= 8;
                            break;
                        case 40:
                            this.BsD |= 16;
                            this.Buk = eVar.vd();
                            break;
                        case 50:
                            if ((i & 32) != 32) {
                                this.Bul = new ArrayList();
                                i |= 32;
                            }
                            this.Bul.add(eVar.a(BsC, gVar));
                            break;
                        case com.tencent.mm.plugin.appbrand.jsapi.aa.CTRL_INDEX /*58*/:
                            if ((i & 64) != 64) {
                                this.Bum = new ArrayList();
                                vc = i | 64;
                            } else {
                                vc = i;
                            }
                            try {
                                this.Bum.add(eVar.a(BsC, gVar));
                                break;
                            } catch (a.i.b.a.c.g.k e2) {
                                kVar = e2;
                                i2 = vc;
                                try {
                                    kVar.BzY = this;
                                    AppMethodBeat.o(120626);
                                    throw kVar;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if ((i2 & 32) == 32) {
                                    }
                                    if ((i2 & 64) == 64) {
                                    }
                                    try {
                                        e.flush();
                                        this.BsB = ehS.ehW();
                                    } catch (IOException e3) {
                                        this.BsB = ehS.ehW();
                                    } catch (Throwable th3) {
                                        this.BsB = ehS.ehW();
                                        AppMethodBeat.o(120626);
                                    }
                                    eio();
                                    AppMethodBeat.o(120626);
                                    throw th;
                                }
                            } catch (IOException e4) {
                                iOException = e4;
                                i2 = vc;
                                kVar2 = new a.i.b.a.c.g.k(iOException.getMessage());
                                kVar2.BzY = this;
                                AppMethodBeat.o(120626);
                                throw kVar2;
                            } catch (Throwable th4) {
                                th = th4;
                                i2 = vc;
                                if ((i2 & 32) == 32) {
                                }
                                if ((i2 & 64) == 64) {
                                }
                                e.flush();
                                this.BsB = ehS.ehW();
                                eio();
                                AppMethodBeat.o(120626);
                                throw th;
                            }
                        default:
                            if (!a(eVar, e, gVar, vc)) {
                                i2 = 1;
                                break;
                            } else {
                                vc = i;
                                break;
                            }
                    }
                } catch (a.i.b.a.c.g.k kVar22) {
                    kVar = kVar22;
                    i2 = i;
                    kVar.BzY = this;
                    AppMethodBeat.o(120626);
                    throw kVar;
                } catch (IOException e5) {
                    iOException = e5;
                    i2 = i;
                    kVar22 = new a.i.b.a.c.g.k(iOException.getMessage());
                    kVar22.BzY = this;
                    AppMethodBeat.o(120626);
                    throw kVar22;
                } catch (Throwable th22) {
                    th = th22;
                    i2 = i;
                    if ((i2 & 32) == 32) {
                        this.Bul = Collections.unmodifiableList(this.Bul);
                    }
                    if ((i2 & 64) == 64) {
                        this.Bum = Collections.unmodifiableList(this.Bum);
                    }
                    e.flush();
                    this.BsB = ehS.ehW();
                    eio();
                    AppMethodBeat.o(120626);
                    throw th;
                }
            }
            if ((i & 32) == 32) {
                this.Bul = Collections.unmodifiableList(this.Bul);
            }
            if ((i & 64) == 64) {
                this.Bum = Collections.unmodifiableList(this.Bum);
            }
            try {
                e.flush();
                this.BsB = ehS.ehW();
            } catch (IOException e6) {
                this.BsB = ehS.ehW();
            } catch (Throwable th5) {
                this.BsB = ehS.ehW();
                AppMethodBeat.o(120626);
            }
            eio();
            AppMethodBeat.o(120626);
        }

        static {
            AppMethodBeat.i(120634);
            m mVar = new m();
            Bug = mVar;
            mVar.ecA();
            AppMethodBeat.o(120634);
        }

        public final a.i.b.a.c.g.s<m> ecy() {
            return BsC;
        }

        public final boolean ecY() {
            return (this.BsD & 1) == 1;
        }

        public final boolean eeb() {
            return (this.BsD & 2) == 2;
        }

        public final boolean eec() {
            return (this.BsD & 4) == 4;
        }

        public final boolean eed() {
            return (this.BsD & 8) == 8;
        }

        public final boolean eee() {
            return (this.BsD & 16) == 16;
        }

        private void ecA() {
            AppMethodBeat.i(120627);
            this.BsW = 0;
            this.Buh = 0;
            this.Bui = b.TRUE;
            this.Buj = aa.eeX();
            this.Buk = 0;
            this.Bul = Collections.emptyList();
            this.Bum = Collections.emptyList();
            AppMethodBeat.o(120627);
        }

        public final boolean isInitialized() {
            AppMethodBeat.i(120628);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.o(120628);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.o(120628);
                return false;
            } else if (!eed() || this.Buj.isInitialized()) {
                int i = 0;
                while (i < this.Bul.size()) {
                    if (((m) this.Bul.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120628);
                        return false;
                    }
                }
                i = 0;
                while (i < this.Bum.size()) {
                    if (((m) this.Bum.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120628);
                        return false;
                    }
                }
                this.BsG = (byte) 1;
                AppMethodBeat.o(120628);
                return true;
            } else {
                this.BsG = (byte) 0;
                AppMethodBeat.o(120628);
                return false;
            }
        }

        public final void a(a.i.b.a.c.g.f fVar) {
            int i = 0;
            AppMethodBeat.i(120629);
            vq();
            if ((this.BsD & 1) == 1) {
                fVar.bq(1, this.BsW);
            }
            if ((this.BsD & 2) == 2) {
                fVar.bq(2, this.Buh);
            }
            if ((this.BsD & 4) == 4) {
                fVar.io(3, this.Bui.value);
            }
            if ((this.BsD & 8) == 8) {
                fVar.a(4, this.Buj);
            }
            if ((this.BsD & 16) == 16) {
                fVar.bq(5, this.Buk);
            }
            for (int i2 = 0; i2 < this.Bul.size(); i2++) {
                fVar.a(6, (a.i.b.a.c.g.q) this.Bul.get(i2));
            }
            while (i < this.Bum.size()) {
                fVar.a(7, (a.i.b.a.c.g.q) this.Bum.get(i));
                i++;
            }
            fVar.d(this.BsB);
            AppMethodBeat.o(120629);
        }

        public final int vq() {
            int i = 0;
            AppMethodBeat.i(120630);
            int i2 = this.BsH;
            if (i2 != -1) {
                AppMethodBeat.o(120630);
                return i2;
            }
            if ((this.BsD & 1) == 1) {
                i2 = a.i.b.a.c.g.f.bs(1, this.BsW) + 0;
            } else {
                i2 = 0;
            }
            if ((this.BsD & 2) == 2) {
                i2 += a.i.b.a.c.g.f.bs(2, this.Buh);
            }
            if ((this.BsD & 4) == 4) {
                i2 += a.i.b.a.c.g.f.ip(3, this.Bui.value);
            }
            if ((this.BsD & 8) == 8) {
                i2 += a.i.b.a.c.g.f.c(4, this.Buj);
            }
            if ((this.BsD & 16) == 16) {
                i2 += a.i.b.a.c.g.f.bs(5, this.Buk);
            }
            int i3 = i2;
            for (int i4 = 0; i4 < this.Bul.size(); i4++) {
                i3 += a.i.b.a.c.g.f.c(6, (a.i.b.a.c.g.q) this.Bul.get(i4));
            }
            while (i < this.Bum.size()) {
                i3 += a.i.b.a.c.g.f.c(7, (a.i.b.a.c.g.q) this.Bum.get(i));
                i++;
            }
            i2 = this.BsB.size() + i3;
            this.BsH = i2;
            AppMethodBeat.o(120630);
            return i2;
        }

        public static a b(m mVar) {
            AppMethodBeat.i(120631);
            a f = a.eej().f(mVar);
            AppMethodBeat.o(120631);
            return f;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecC() {
            AppMethodBeat.i(120632);
            a f = a.eej().f(this);
            AppMethodBeat.o(120632);
            return f;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecD() {
            AppMethodBeat.i(120633);
            a eej = a.eej();
            AppMethodBeat.o(120633);
            return eej;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.g.q ecE() {
            return Bug;
        }
    }

    public interface x extends a.i.b.a.c.g.r {
    }

    public interface af extends a.i.b.a.c.g.i.d {
    }

    public static final class e extends a.i.b.a.c.g.i.c<e> implements f {
        public static a.i.b.a.c.g.s<e> BsC = new a.i.b.a.c.g.b<e>() {
            public final /* synthetic */ Object a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120485);
                e eVar2 = new e(eVar, gVar, (byte) 0);
                AppMethodBeat.o(120485);
                return eVar2;
            }
        };
        private static final e BtN;
        private final a.i.b.a.c.g.d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        public int BsW;
        public List<Integer> BtD;
        public List<ai> BtO;

        public static final class a extends a.i.b.a.c.g.i.b<e, a> implements f {
            private int BsD;
            private int BsW = 6;
            private List<Integer> BtD = Collections.emptyList();
            private List<ai> BtO = Collections.emptyList();

            public final /* synthetic */ a.i.b.a.c.g.i.a a(a.i.b.a.c.g.i iVar) {
                AppMethodBeat.i(120497);
                a d = d((e) iVar);
                AppMethodBeat.o(120497);
                return d;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a c(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120499);
                a h = h(eVar, gVar);
                AppMethodBeat.o(120499);
                return h;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(120503);
                a edD = edD();
                AppMethodBeat.o(120503);
                return edD;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a d(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120501);
                a h = h(eVar, gVar);
                AppMethodBeat.o(120501);
                return h;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.a ecK() {
                AppMethodBeat.i(120498);
                a edD = edD();
                AppMethodBeat.o(120498);
                return edD;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a ecL() {
                AppMethodBeat.i(120500);
                a edD = edD();
                AppMethodBeat.o(120500);
                return edD;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.b edA() {
                AppMethodBeat.i(120494);
                a edD = edD();
                AppMethodBeat.o(120494);
                return edD;
            }

            private a() {
                AppMethodBeat.i(120486);
                AppMethodBeat.o(120486);
            }

            private e edE() {
                int i = 1;
                AppMethodBeat.i(120488);
                e eVar = new e((a.i.b.a.c.g.i.b) this, (byte) 0);
                if ((this.BsD & 1) != 1) {
                    i = 0;
                }
                eVar.BsW = this.BsW;
                if ((this.BsD & 2) == 2) {
                    this.BtO = Collections.unmodifiableList(this.BtO);
                    this.BsD &= -3;
                }
                eVar.BtO = this.BtO;
                if ((this.BsD & 4) == 4) {
                    this.BtD = Collections.unmodifiableList(this.BtD);
                    this.BsD &= -5;
                }
                eVar.BtD = this.BtD;
                eVar.BsD = i;
                AppMethodBeat.o(120488);
                return eVar;
            }

            public final a d(e eVar) {
                AppMethodBeat.i(120489);
                if (eVar == e.edC()) {
                    AppMethodBeat.o(120489);
                } else {
                    if (eVar.ecY()) {
                        Tc(eVar.BsW);
                    }
                    if (!eVar.BtO.isEmpty()) {
                        if (this.BtO.isEmpty()) {
                            this.BtO = eVar.BtO;
                            this.BsD &= -3;
                        } else {
                            edF();
                            this.BtO.addAll(eVar.BtO);
                        }
                    }
                    if (!eVar.BtD.isEmpty()) {
                        if (this.BtD.isEmpty()) {
                            this.BtD = eVar.BtD;
                            this.BsD &= -5;
                        } else {
                            edz();
                            this.BtD.addAll(eVar.BtD);
                        }
                    }
                    a((a.i.b.a.c.g.i.c) eVar);
                    this.BsB = this.BsB.a(eVar.BsB);
                    AppMethodBeat.o(120489);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private a h(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                e eVar2;
                Throwable th;
                AppMethodBeat.i(120491);
                e eVar3 = null;
                try {
                    d((e) e.BsC.a(eVar, gVar));
                    AppMethodBeat.o(120491);
                    return this;
                } catch (a.i.b.a.c.g.k e) {
                    a.i.b.a.c.g.k kVar = e;
                    eVar2 = (e) kVar.BzY;
                    AppMethodBeat.o(120491);
                    throw kVar;
                } catch (Throwable th2) {
                    th = th2;
                    eVar3 = eVar2;
                    if (eVar3 != null) {
                    }
                    AppMethodBeat.o(120491);
                    throw th;
                }
            }

            private a Tc(int i) {
                this.BsD |= 1;
                this.BsW = i;
                return this;
            }

            private void edF() {
                AppMethodBeat.i(120492);
                if ((this.BsD & 2) != 2) {
                    this.BtO = new ArrayList(this.BtO);
                    this.BsD |= 2;
                }
                AppMethodBeat.o(120492);
            }

            private void edz() {
                AppMethodBeat.i(120493);
                if ((this.BsD & 4) != 4) {
                    this.BtD = new ArrayList(this.BtD);
                    this.BsD |= 4;
                }
                AppMethodBeat.o(120493);
            }

            private a edD() {
                AppMethodBeat.i(120487);
                a d = new a().d(edE());
                AppMethodBeat.o(120487);
                return d;
            }

            public final boolean isInitialized() {
                AppMethodBeat.i(120490);
                int i = 0;
                while (i < this.BtO.size()) {
                    if (((ai) this.BtO.get(i)).isInitialized()) {
                        i++;
                    } else {
                        AppMethodBeat.o(120490);
                        return false;
                    }
                }
                if (this.BzI.isInitialized()) {
                    AppMethodBeat.o(120490);
                    return true;
                }
                AppMethodBeat.o(120490);
                return false;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecE() {
                AppMethodBeat.i(120495);
                e edC = e.edC();
                AppMethodBeat.o(120495);
                return edC;
            }

            public final /* synthetic */ a.i.b.a.c.g.i ecJ() {
                AppMethodBeat.i(120496);
                e edC = e.edC();
                AppMethodBeat.o(120496);
                return edC;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecM() {
                AppMethodBeat.i(120502);
                e edE = edE();
                if (edE.isInitialized()) {
                    AppMethodBeat.o(120502);
                    return edE;
                }
                a.i.b.a.c.g.w wVar = new a.i.b.a.c.g.w();
                AppMethodBeat.o(120502);
                throw wVar;
            }

            static /* synthetic */ a edG() {
                AppMethodBeat.i(120504);
                a aVar = new a();
                AppMethodBeat.o(120504);
                return aVar;
            }
        }

        /* synthetic */ e(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar, byte b) {
            this(eVar, gVar);
        }

        private e(a.i.b.a.c.g.i.b<e, ?> bVar) {
            super(bVar);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = bVar.BsB;
        }

        private e() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = a.i.b.a.c.g.d.Bzq;
        }

        public static e edC() {
            return BtN;
        }

        /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0040=Splitter:B:13:0x0040, B:57:0x00dd=Splitter:B:57:0x00dd} */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x004f  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x005b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private e(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
            a.i.b.a.c.g.k e;
            a.i.b.a.c.g.k e2;
            Throwable th;
            IOException e3;
            AppMethodBeat.i(120505);
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            int i = 0;
            a.i.b.a.c.g.d.b ehS = a.i.b.a.c.g.d.ehS();
            a.i.b.a.c.g.f e4 = a.i.b.a.c.g.f.e(ehS, 1);
            int i2 = 0;
            while (i2 == 0) {
                int vc;
                try {
                    vc = eVar.vc();
                    switch (vc) {
                        case 0:
                            i2 = 1;
                            break;
                        case 8:
                            this.BsD |= 1;
                            this.BsW = eVar.vd();
                            break;
                        case 18:
                            if ((i & 2) != 2) {
                                this.BtO = new ArrayList();
                                vc = i | 2;
                            } else {
                                vc = i;
                            }
                            try {
                                this.BtO.add(eVar.a(ai.BsC, gVar));
                                i = vc;
                                break;
                            } catch (a.i.b.a.c.g.k e22) {
                                e = e22;
                                try {
                                    e.BzY = this;
                                    AppMethodBeat.o(120505);
                                    throw e;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if ((vc & 2) == 2) {
                                    }
                                    if ((vc & 4) == 4) {
                                    }
                                    try {
                                        e4.flush();
                                        this.BsB = ehS.ehW();
                                    } catch (IOException e5) {
                                        this.BsB = ehS.ehW();
                                    } catch (Throwable th3) {
                                        this.BsB = ehS.ehW();
                                        AppMethodBeat.o(120505);
                                    }
                                    this.BzI.eii();
                                    AppMethodBeat.o(120505);
                                    throw th;
                                }
                            } catch (IOException e6) {
                                e3 = e6;
                                e22 = new a.i.b.a.c.g.k(e3.getMessage());
                                e22.BzY = this;
                                AppMethodBeat.o(120505);
                                throw e22;
                            }
                            break;
                        case com.tencent.view.d.MIC_PTU_ZIPAI_THURSDAY /*248*/:
                            if ((i & 4) != 4) {
                                this.BtD = new ArrayList();
                                vc = i | 4;
                            } else {
                                vc = i;
                            }
                            this.BtD.add(Integer.valueOf(eVar.vd()));
                            i = vc;
                            break;
                        case 250:
                            vc = eVar.fo(eVar.vd());
                            if ((i & 4) != 4 && eVar.vg() > 0) {
                                this.BtD = new ArrayList();
                                i |= 4;
                            }
                            while (eVar.vg() > 0) {
                                this.BtD.add(Integer.valueOf(eVar.vd()));
                            }
                            eVar.fp(vc);
                            break;
                        default:
                            if (!a(eVar, e4, gVar, vc)) {
                                i2 = 1;
                                break;
                            }
                            break;
                    }
                } catch (a.i.b.a.c.g.k e7) {
                    e = e7;
                    vc = i;
                    e.BzY = this;
                    AppMethodBeat.o(120505);
                    throw e;
                } catch (IOException e8) {
                    e3 = e8;
                    vc = i;
                    e22 = new a.i.b.a.c.g.k(e3.getMessage());
                    e22.BzY = this;
                    AppMethodBeat.o(120505);
                    throw e22;
                } catch (Throwable th4) {
                    th = th4;
                    vc = i;
                    if ((vc & 2) == 2) {
                        this.BtO = Collections.unmodifiableList(this.BtO);
                    }
                    if ((vc & 4) == 4) {
                        this.BtD = Collections.unmodifiableList(this.BtD);
                    }
                    e4.flush();
                    this.BsB = ehS.ehW();
                    this.BzI.eii();
                    AppMethodBeat.o(120505);
                    throw th;
                }
            }
            if ((i & 2) == 2) {
                this.BtO = Collections.unmodifiableList(this.BtO);
            }
            if ((i & 4) == 4) {
                this.BtD = Collections.unmodifiableList(this.BtD);
            }
            try {
                e4.flush();
                this.BsB = ehS.ehW();
            } catch (IOException e9) {
                this.BsB = ehS.ehW();
            } catch (Throwable th5) {
                this.BsB = ehS.ehW();
                AppMethodBeat.o(120505);
            }
            this.BzI.eii();
            AppMethodBeat.o(120505);
        }

        static {
            AppMethodBeat.i(120512);
            e eVar = new e();
            BtN = eVar;
            eVar.ecA();
            AppMethodBeat.o(120512);
        }

        public final a.i.b.a.c.g.s<e> ecy() {
            return BsC;
        }

        public final boolean ecY() {
            return (this.BsD & 1) == 1;
        }

        private void ecA() {
            AppMethodBeat.i(120506);
            this.BsW = 6;
            this.BtO = Collections.emptyList();
            this.BtD = Collections.emptyList();
            AppMethodBeat.o(120506);
        }

        public final boolean isInitialized() {
            AppMethodBeat.i(120507);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.o(120507);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.o(120507);
                return false;
            } else {
                int i = 0;
                while (i < this.BtO.size()) {
                    if (((ai) this.BtO.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120507);
                        return false;
                    }
                }
                if (this.BzI.isInitialized()) {
                    this.BsG = (byte) 1;
                    AppMethodBeat.o(120507);
                    return true;
                }
                this.BsG = (byte) 0;
                AppMethodBeat.o(120507);
                return false;
            }
        }

        public final void a(a.i.b.a.c.g.f fVar) {
            int i = 0;
            AppMethodBeat.i(120508);
            vq();
            a.i.b.a.c.g.i.c.a eip = eip();
            if ((this.BsD & 1) == 1) {
                fVar.bq(1, this.BsW);
            }
            for (int i2 = 0; i2 < this.BtO.size(); i2++) {
                fVar.a(2, (a.i.b.a.c.g.q) this.BtO.get(i2));
            }
            while (i < this.BtD.size()) {
                fVar.bq(31, ((Integer) this.BtD.get(i)).intValue());
                i++;
            }
            eip.b(19000, fVar);
            fVar.d(this.BsB);
            AppMethodBeat.o(120508);
        }

        public final int vq() {
            AppMethodBeat.i(120509);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.o(120509);
                return i;
            }
            int i2;
            if ((this.BsD & 1) == 1) {
                i = a.i.b.a.c.g.f.bs(1, this.BsW) + 0;
            } else {
                i = 0;
            }
            int i3 = i;
            for (i2 = 0; i2 < this.BtO.size(); i2++) {
                i3 += a.i.b.a.c.g.f.c(2, (a.i.b.a.c.g.q) this.BtO.get(i2));
            }
            i2 = 0;
            int i4 = 0;
            while (i2 < this.BtD.size()) {
                i2++;
                i4 = a.i.b.a.c.g.f.ft(((Integer) this.BtD.get(i2)).intValue()) + i4;
            }
            i = (((i3 + i4) + (this.BtD.size() * 2)) + this.BzI.vq()) + this.BsB.size();
            this.BsH = i;
            AppMethodBeat.o(120509);
            return i;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.g.q ecE() {
            return BtN;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecC() {
            AppMethodBeat.i(120510);
            a d = a.edG().d(this);
            AppMethodBeat.o(120510);
            return d;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecD() {
            AppMethodBeat.i(120511);
            a edG = a.edG();
            AppMethodBeat.o(120511);
            return edG;
        }
    }

    public static final class g extends a.i.b.a.c.g.i implements h {
        public static a.i.b.a.c.g.s<g> BsC = new a.i.b.a.c.g.b<g>() {
            public final /* synthetic */ Object a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120513);
                g gVar2 = new g(eVar, gVar, (byte) 0);
                AppMethodBeat.o(120513);
                return gVar2;
            }
        };
        private static final g BtP;
        private final a.i.b.a.c.g.d BsB;
        private byte BsG;
        private int BsH;
        private List<i> BtQ;

        public static final class a extends a.i.b.a.c.g.i.a<g, a> implements h {
            private int BsD;
            private List<i> BtQ = Collections.emptyList();

            public final /* synthetic */ a.i.b.a.c.g.i.a a(a.i.b.a.c.g.i iVar) {
                AppMethodBeat.i(120522);
                a d = d((g) iVar);
                AppMethodBeat.o(120522);
                return d;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a c(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120524);
                a i = i(eVar, gVar);
                AppMethodBeat.o(120524);
                return i;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(120529);
                a edJ = edJ();
                AppMethodBeat.o(120529);
                return edJ;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a d(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120526);
                a i = i(eVar, gVar);
                AppMethodBeat.o(120526);
                return i;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.a ecK() {
                AppMethodBeat.i(120523);
                a edJ = edJ();
                AppMethodBeat.o(120523);
                return edJ;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a ecL() {
                AppMethodBeat.i(120525);
                a edJ = edJ();
                AppMethodBeat.o(120525);
                return edJ;
            }

            private a() {
                AppMethodBeat.i(120514);
                AppMethodBeat.o(120514);
            }

            public final g edK() {
                AppMethodBeat.i(120516);
                g gVar = new g((a.i.b.a.c.g.i.a) this, (byte) 0);
                if ((this.BsD & 1) == 1) {
                    this.BtQ = Collections.unmodifiableList(this.BtQ);
                    this.BsD &= -2;
                }
                gVar.BtQ = this.BtQ;
                AppMethodBeat.o(120516);
                return gVar;
            }

            public final a d(g gVar) {
                AppMethodBeat.i(120517);
                if (gVar == g.edH()) {
                    AppMethodBeat.o(120517);
                } else {
                    if (!gVar.BtQ.isEmpty()) {
                        if (this.BtQ.isEmpty()) {
                            this.BtQ = gVar.BtQ;
                            this.BsD &= -2;
                        } else {
                            edL();
                            this.BtQ.addAll(gVar.BtQ);
                        }
                    }
                    this.BsB = this.BsB.a(gVar.BsB);
                    AppMethodBeat.o(120517);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private a i(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                g gVar2;
                Throwable th;
                AppMethodBeat.i(120519);
                g gVar3 = null;
                try {
                    d((g) g.BsC.a(eVar, gVar));
                    AppMethodBeat.o(120519);
                    return this;
                } catch (a.i.b.a.c.g.k e) {
                    a.i.b.a.c.g.k kVar = e;
                    gVar2 = (g) kVar.BzY;
                    AppMethodBeat.o(120519);
                    throw kVar;
                } catch (Throwable th2) {
                    th = th2;
                    gVar3 = gVar2;
                    if (gVar3 != null) {
                    }
                    AppMethodBeat.o(120519);
                    throw th;
                }
            }

            private void edL() {
                AppMethodBeat.i(120520);
                if ((this.BsD & 1) != 1) {
                    this.BtQ = new ArrayList(this.BtQ);
                    this.BsD |= 1;
                }
                AppMethodBeat.o(120520);
            }

            private a edJ() {
                AppMethodBeat.i(120515);
                a d = new a().d(edK());
                AppMethodBeat.o(120515);
                return d;
            }

            public final boolean isInitialized() {
                AppMethodBeat.i(120518);
                int i = 0;
                while (i < this.BtQ.size()) {
                    if (((i) this.BtQ.get(i)).isInitialized()) {
                        i++;
                    } else {
                        AppMethodBeat.o(120518);
                        return false;
                    }
                }
                AppMethodBeat.o(120518);
                return true;
            }

            public final /* synthetic */ a.i.b.a.c.g.i ecJ() {
                AppMethodBeat.i(120521);
                g edH = g.edH();
                AppMethodBeat.o(120521);
                return edH;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecM() {
                AppMethodBeat.i(120527);
                g edK = edK();
                if (edK.isInitialized()) {
                    AppMethodBeat.o(120527);
                    return edK;
                }
                a.i.b.a.c.g.w wVar = new a.i.b.a.c.g.w();
                AppMethodBeat.o(120527);
                throw wVar;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecE() {
                AppMethodBeat.i(120528);
                g edH = g.edH();
                AppMethodBeat.o(120528);
                return edH;
            }

            static /* synthetic */ a edM() {
                AppMethodBeat.i(120530);
                a aVar = new a();
                AppMethodBeat.o(120530);
                return aVar;
            }
        }

        /* synthetic */ g(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar, byte b) {
            this(eVar, gVar);
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecC() {
            AppMethodBeat.i(120537);
            a edI = edI();
            AppMethodBeat.o(120537);
            return edI;
        }

        private g(a.i.b.a.c.g.i.a aVar) {
            super((byte) 0);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = aVar.BsB;
        }

        private g() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = a.i.b.a.c.g.d.Bzq;
        }

        public static g edH() {
            return BtP;
        }

        private g(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
            AppMethodBeat.i(120531);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BtQ = Collections.emptyList();
            a.i.b.a.c.g.d.b ehS = a.i.b.a.c.g.d.ehS();
            a.i.b.a.c.g.f e = a.i.b.a.c.g.f.e(ehS, 1);
            int i = 0;
            int i2 = 0;
            while (i == 0) {
                try {
                    int vc = eVar.vc();
                    switch (vc) {
                        case 0:
                            i = 1;
                            break;
                        case 10:
                            if ((i2 & 1) != 1) {
                                this.BtQ = new ArrayList();
                                i2 |= 1;
                            }
                            this.BtQ.add(eVar.a(i.BsC, gVar));
                            break;
                        default:
                            if (!a(eVar, e, gVar, vc)) {
                                i = 1;
                                break;
                            }
                            break;
                    }
                } catch (a.i.b.a.c.g.k e2) {
                    e2.BzY = this;
                    AppMethodBeat.o(120531);
                    throw e2;
                } catch (IOException e3) {
                    a.i.b.a.c.g.k kVar = new a.i.b.a.c.g.k(e3.getMessage());
                    kVar.BzY = this;
                    AppMethodBeat.o(120531);
                    throw kVar;
                } catch (Throwable th) {
                    if ((i2 & 1) == 1) {
                        this.BtQ = Collections.unmodifiableList(this.BtQ);
                    }
                    try {
                        e.flush();
                        this.BsB = ehS.ehW();
                    } catch (IOException e4) {
                        this.BsB = ehS.ehW();
                    } catch (Throwable th2) {
                        this.BsB = ehS.ehW();
                        AppMethodBeat.o(120531);
                    }
                    eio();
                    AppMethodBeat.o(120531);
                }
            }
            if ((i2 & 1) == 1) {
                this.BtQ = Collections.unmodifiableList(this.BtQ);
            }
            try {
                e.flush();
                this.BsB = ehS.ehW();
            } catch (IOException e5) {
                this.BsB = ehS.ehW();
            } catch (Throwable th3) {
                this.BsB = ehS.ehW();
                AppMethodBeat.o(120531);
            }
            eio();
            AppMethodBeat.o(120531);
        }

        static {
            AppMethodBeat.i(120539);
            g gVar = new g();
            BtP = gVar;
            gVar.BtQ = Collections.emptyList();
            AppMethodBeat.o(120539);
        }

        public final a.i.b.a.c.g.s<g> ecy() {
            return BsC;
        }

        public final boolean isInitialized() {
            AppMethodBeat.i(120532);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.o(120532);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.o(120532);
                return false;
            } else {
                int i = 0;
                while (i < this.BtQ.size()) {
                    if (((i) this.BtQ.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120532);
                        return false;
                    }
                }
                this.BsG = (byte) 1;
                AppMethodBeat.o(120532);
                return true;
            }
        }

        public final void a(a.i.b.a.c.g.f fVar) {
            AppMethodBeat.i(120533);
            vq();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.BtQ.size()) {
                    fVar.a(1, (a.i.b.a.c.g.q) this.BtQ.get(i2));
                    i = i2 + 1;
                } else {
                    fVar.d(this.BsB);
                    AppMethodBeat.o(120533);
                    return;
                }
            }
        }

        public final int vq() {
            AppMethodBeat.i(120534);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.o(120534);
                return i;
            }
            int i2 = 0;
            for (i = 0; i < this.BtQ.size(); i++) {
                i2 += a.i.b.a.c.g.f.c(1, (a.i.b.a.c.g.q) this.BtQ.get(i));
            }
            int size = this.BsB.size() + i2;
            this.BsH = size;
            AppMethodBeat.o(120534);
            return size;
        }

        public static a a(g gVar) {
            AppMethodBeat.i(120535);
            a d = a.edM().d(gVar);
            AppMethodBeat.o(120535);
            return d;
        }

        public final a edI() {
            AppMethodBeat.i(120536);
            a d = a.edM().d(this);
            AppMethodBeat.o(120536);
            return d;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecD() {
            AppMethodBeat.i(120538);
            a edM = a.edM();
            AppMethodBeat.o(120538);
            return edM;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.g.q ecE() {
            return BtP;
        }
    }

    public static final class ae extends a.i.b.a.c.g.i.c<ae> implements af {
        public static a.i.b.a.c.g.s<ae> BsC = new a.i.b.a.c.g.b<ae>() {
            public final /* synthetic */ Object a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120917);
                ae aeVar = new ae(eVar, gVar, (byte) 0);
                AppMethodBeat.o(120917);
                return aeVar;
            }
        };
        private static final ae BvB;
        private final a.i.b.a.c.g.d BsB;
        private int BsD;
        public int BsE;
        private byte BsG;
        private int BsH;
        public int Buf;
        public boolean BvC;
        public b BvD;
        public List<aa> BvE;
        public List<Integer> BvF;
        private int BvG;

        public enum b implements a.i.b.a.c.g.j.a {
            IN(0),
            OUT(1),
            INV(2);
            
            private static a.i.b.a.c.g.j.b<b> Btk;
            final int value;

            static {
                Btk = new a.i.b.a.c.g.j.b<b>() {
                    public final /* synthetic */ a.i.b.a.c.g.j.a SW(int i) {
                        AppMethodBeat.i(120938);
                        b TT = b.TT(i);
                        AppMethodBeat.o(120938);
                        return TT;
                    }
                };
                AppMethodBeat.o(120941);
            }

            public final int edd() {
                return this.value;
            }

            public static b TT(int i) {
                switch (i) {
                    case 0:
                        return IN;
                    case 1:
                        return OUT;
                    case 2:
                        return INV;
                    default:
                        return null;
                }
            }

            private b(int i) {
                this.value = i;
            }
        }

        public static final class a extends a.i.b.a.c.g.i.b<ae, a> implements af {
            private int BsD;
            private int BsE;
            private int Buf;
            private boolean BvC;
            private b BvD = b.INV;
            private List<aa> BvE = Collections.emptyList();
            private List<Integer> BvF = Collections.emptyList();

            public final /* synthetic */ a.i.b.a.c.g.a.a c(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120932);
                a v = v(eVar, gVar);
                AppMethodBeat.o(120932);
                return v;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(120936);
                a efH = efH();
                AppMethodBeat.o(120936);
                return efH;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a d(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120934);
                a v = v(eVar, gVar);
                AppMethodBeat.o(120934);
                return v;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.a ecK() {
                AppMethodBeat.i(120931);
                a efH = efH();
                AppMethodBeat.o(120931);
                return efH;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a ecL() {
                AppMethodBeat.i(120933);
                a efH = efH();
                AppMethodBeat.o(120933);
                return efH;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.b edA() {
                AppMethodBeat.i(120927);
                a efH = efH();
                AppMethodBeat.o(120927);
                return efH;
            }

            private a() {
                AppMethodBeat.i(120918);
                AppMethodBeat.o(120918);
            }

            private ae efI() {
                int i = 1;
                AppMethodBeat.i(120920);
                ae aeVar = new ae((a.i.b.a.c.g.i.b) this, (byte) 0);
                int i2 = this.BsD;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                aeVar.BsE = this.BsE;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                aeVar.Buf = this.Buf;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                aeVar.BvC = this.BvC;
                if ((i2 & 8) == 8) {
                    i |= 8;
                }
                aeVar.BvD = this.BvD;
                if ((this.BsD & 16) == 16) {
                    this.BvE = Collections.unmodifiableList(this.BvE);
                    this.BsD &= -17;
                }
                aeVar.BvE = this.BvE;
                if ((this.BsD & 32) == 32) {
                    this.BvF = Collections.unmodifiableList(this.BvF);
                    this.BsD &= -33;
                }
                aeVar.BvF = this.BvF;
                aeVar.BsD = i;
                AppMethodBeat.o(120920);
                return aeVar;
            }

            public final a d(ae aeVar) {
                AppMethodBeat.i(120921);
                if (aeVar == ae.efE()) {
                    AppMethodBeat.o(120921);
                } else {
                    if (aeVar.ecz()) {
                        TR(aeVar.BsE);
                    }
                    if (aeVar.edW()) {
                        TS(aeVar.Buf);
                    }
                    if (aeVar.efF()) {
                        rO(aeVar.BvC);
                    }
                    if (aeVar.efG()) {
                        a(aeVar.BvD);
                    }
                    if (!aeVar.BvE.isEmpty()) {
                        if (this.BvE.isEmpty()) {
                            this.BvE = aeVar.BvE;
                            this.BsD &= -17;
                        } else {
                            efJ();
                            this.BvE.addAll(aeVar.BvE);
                        }
                    }
                    if (!aeVar.BvF.isEmpty()) {
                        if (this.BvF.isEmpty()) {
                            this.BvF = aeVar.BvF;
                            this.BsD &= -33;
                        } else {
                            efK();
                            this.BvF.addAll(aeVar.BvF);
                        }
                    }
                    a((a.i.b.a.c.g.i.c) aeVar);
                    this.BsB = this.BsB.a(aeVar.BsB);
                    AppMethodBeat.o(120921);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private a v(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                ae aeVar;
                Throwable th;
                AppMethodBeat.i(120923);
                ae aeVar2 = null;
                try {
                    d((ae) ae.BsC.a(eVar, gVar));
                    AppMethodBeat.o(120923);
                    return this;
                } catch (a.i.b.a.c.g.k e) {
                    a.i.b.a.c.g.k kVar = e;
                    aeVar = (ae) kVar.BzY;
                    AppMethodBeat.o(120923);
                    throw kVar;
                } catch (Throwable th2) {
                    th = th2;
                    aeVar2 = aeVar;
                    if (aeVar2 != null) {
                    }
                    AppMethodBeat.o(120923);
                    throw th;
                }
            }

            private a TR(int i) {
                this.BsD |= 1;
                this.BsE = i;
                return this;
            }

            private a TS(int i) {
                this.BsD |= 2;
                this.Buf = i;
                return this;
            }

            private a rO(boolean z) {
                this.BsD |= 4;
                this.BvC = z;
                return this;
            }

            private a a(b bVar) {
                AppMethodBeat.i(120924);
                if (bVar == null) {
                    NullPointerException nullPointerException = new NullPointerException();
                    AppMethodBeat.o(120924);
                    throw nullPointerException;
                }
                this.BsD |= 8;
                this.BvD = bVar;
                AppMethodBeat.o(120924);
                return this;
            }

            private void efJ() {
                AppMethodBeat.i(120925);
                if ((this.BsD & 16) != 16) {
                    this.BvE = new ArrayList(this.BvE);
                    this.BsD |= 16;
                }
                AppMethodBeat.o(120925);
            }

            private void efK() {
                AppMethodBeat.i(120926);
                if ((this.BsD & 32) != 32) {
                    this.BvF = new ArrayList(this.BvF);
                    this.BsD |= 32;
                }
                AppMethodBeat.o(120926);
            }

            private a efH() {
                AppMethodBeat.i(120919);
                a d = new a().d(efI());
                AppMethodBeat.o(120919);
                return d;
            }

            public final boolean isInitialized() {
                boolean z;
                AppMethodBeat.i(120922);
                if ((this.BsD & 1) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if ((this.BsD & 2) == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        int i = 0;
                        while (i < this.BvE.size()) {
                            if (((aa) this.BvE.get(i)).isInitialized()) {
                                i++;
                            } else {
                                AppMethodBeat.o(120922);
                                return false;
                            }
                        }
                        if (this.BzI.isInitialized()) {
                            AppMethodBeat.o(120922);
                            return true;
                        }
                        AppMethodBeat.o(120922);
                        return false;
                    }
                    AppMethodBeat.o(120922);
                    return false;
                }
                AppMethodBeat.o(120922);
                return false;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecE() {
                AppMethodBeat.i(120928);
                ae efE = ae.efE();
                AppMethodBeat.o(120928);
                return efE;
            }

            public final /* synthetic */ a.i.b.a.c.g.i ecJ() {
                AppMethodBeat.i(120929);
                ae efE = ae.efE();
                AppMethodBeat.o(120929);
                return efE;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecM() {
                AppMethodBeat.i(120935);
                ae efI = efI();
                if (efI.isInitialized()) {
                    AppMethodBeat.o(120935);
                    return efI;
                }
                a.i.b.a.c.g.w wVar = new a.i.b.a.c.g.w();
                AppMethodBeat.o(120935);
                throw wVar;
            }

            static /* synthetic */ a efL() {
                AppMethodBeat.i(120937);
                a aVar = new a();
                AppMethodBeat.o(120937);
                return aVar;
            }
        }

        /* synthetic */ ae(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar, byte b) {
            this(eVar, gVar);
        }

        private ae(a.i.b.a.c.g.i.b<ae, ?> bVar) {
            super(bVar);
            this.BvG = -1;
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = bVar.BsB;
        }

        private ae() {
            this.BvG = -1;
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = a.i.b.a.c.g.d.Bzq;
        }

        public static ae efE() {
            return BvB;
        }

        /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0044=Splitter:B:13:0x0044, B:34:0x0088=Splitter:B:34:0x0088} */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x005f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private ae(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
            a.i.b.a.c.g.k e;
            a.i.b.a.c.g.k e2;
            Throwable th;
            IOException e3;
            AppMethodBeat.i(120942);
            this.BvG = -1;
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            int i = 0;
            a.i.b.a.c.g.d.b ehS = a.i.b.a.c.g.d.ehS();
            a.i.b.a.c.g.f e4 = a.i.b.a.c.g.f.e(ehS, 1);
            int i2 = 0;
            while (i2 == 0) {
                int vc;
                try {
                    vc = eVar.vc();
                    switch (vc) {
                        case 0:
                            i2 = 1;
                            break;
                        case 8:
                            this.BsD |= 1;
                            this.BsE = eVar.vd();
                            break;
                        case 16:
                            this.BsD |= 2;
                            this.Buf = eVar.vd();
                            break;
                        case 24:
                            this.BsD |= 4;
                            this.BvC = eVar.ehX();
                            break;
                        case 32:
                            int vd = eVar.vd();
                            b TT = b.TT(vd);
                            if (TT != null) {
                                this.BsD |= 8;
                                this.BvD = TT;
                                break;
                            }
                            e4.fw(vc);
                            e4.fw(vd);
                            break;
                        case 42:
                            if ((i & 16) != 16) {
                                this.BvE = new ArrayList();
                                vc = i | 16;
                            } else {
                                vc = i;
                            }
                            try {
                                this.BvE.add(eVar.a(aa.BsC, gVar));
                                i = vc;
                                break;
                            } catch (a.i.b.a.c.g.k e22) {
                                e = e22;
                                try {
                                    e.BzY = this;
                                    AppMethodBeat.o(120942);
                                    throw e;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if ((vc & 16) == 16) {
                                    }
                                    if ((vc & 32) == 32) {
                                    }
                                    try {
                                        e4.flush();
                                        this.BsB = ehS.ehW();
                                    } catch (IOException e5) {
                                        this.BsB = ehS.ehW();
                                    } catch (Throwable th3) {
                                        this.BsB = ehS.ehW();
                                        AppMethodBeat.o(120942);
                                    }
                                    this.BzI.eii();
                                    AppMethodBeat.o(120942);
                                    throw th;
                                }
                            } catch (IOException e6) {
                                e3 = e6;
                                e22 = new a.i.b.a.c.g.k(e3.getMessage());
                                e22.BzY = this;
                                AppMethodBeat.o(120942);
                                throw e22;
                            }
                            break;
                        case 48:
                            if ((i & 32) != 32) {
                                this.BvF = new ArrayList();
                                vc = i | 32;
                            } else {
                                vc = i;
                            }
                            this.BvF.add(Integer.valueOf(eVar.vd()));
                            i = vc;
                            break;
                        case 50:
                            vc = eVar.fo(eVar.vd());
                            if ((i & 32) != 32 && eVar.vg() > 0) {
                                this.BvF = new ArrayList();
                                i |= 32;
                            }
                            while (eVar.vg() > 0) {
                                this.BvF.add(Integer.valueOf(eVar.vd()));
                            }
                            eVar.fp(vc);
                            break;
                        default:
                            if (!a(eVar, e4, gVar, vc)) {
                                i2 = 1;
                                break;
                            }
                            break;
                    }
                } catch (a.i.b.a.c.g.k e7) {
                    e = e7;
                    vc = i;
                    e.BzY = this;
                    AppMethodBeat.o(120942);
                    throw e;
                } catch (IOException e8) {
                    e3 = e8;
                    vc = i;
                    e22 = new a.i.b.a.c.g.k(e3.getMessage());
                    e22.BzY = this;
                    AppMethodBeat.o(120942);
                    throw e22;
                } catch (Throwable th4) {
                    th = th4;
                    vc = i;
                    if ((vc & 16) == 16) {
                        this.BvE = Collections.unmodifiableList(this.BvE);
                    }
                    if ((vc & 32) == 32) {
                        this.BvF = Collections.unmodifiableList(this.BvF);
                    }
                    e4.flush();
                    this.BsB = ehS.ehW();
                    this.BzI.eii();
                    AppMethodBeat.o(120942);
                    throw th;
                }
            }
            if ((i & 16) == 16) {
                this.BvE = Collections.unmodifiableList(this.BvE);
            }
            if ((i & 32) == 32) {
                this.BvF = Collections.unmodifiableList(this.BvF);
            }
            try {
                e4.flush();
                this.BsB = ehS.ehW();
            } catch (IOException e9) {
                this.BsB = ehS.ehW();
            } catch (Throwable th5) {
                this.BsB = ehS.ehW();
                AppMethodBeat.o(120942);
            }
            this.BzI.eii();
            AppMethodBeat.o(120942);
        }

        static {
            AppMethodBeat.i(120949);
            ae aeVar = new ae();
            BvB = aeVar;
            aeVar.ecA();
            AppMethodBeat.o(120949);
        }

        public final a.i.b.a.c.g.s<ae> ecy() {
            return BsC;
        }

        public final boolean ecz() {
            return (this.BsD & 1) == 1;
        }

        public final boolean edW() {
            return (this.BsD & 2) == 2;
        }

        public final boolean efF() {
            return (this.BsD & 4) == 4;
        }

        public final boolean efG() {
            return (this.BsD & 8) == 8;
        }

        private void ecA() {
            AppMethodBeat.i(120943);
            this.BsE = 0;
            this.Buf = 0;
            this.BvC = false;
            this.BvD = b.INV;
            this.BvE = Collections.emptyList();
            this.BvF = Collections.emptyList();
            AppMethodBeat.o(120943);
        }

        public final boolean isInitialized() {
            AppMethodBeat.i(120944);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.o(120944);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.o(120944);
                return false;
            } else if (!ecz()) {
                this.BsG = (byte) 0;
                AppMethodBeat.o(120944);
                return false;
            } else if (edW()) {
                int i = 0;
                while (i < this.BvE.size()) {
                    if (((aa) this.BvE.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120944);
                        return false;
                    }
                }
                if (this.BzI.isInitialized()) {
                    this.BsG = (byte) 1;
                    AppMethodBeat.o(120944);
                    return true;
                }
                this.BsG = (byte) 0;
                AppMethodBeat.o(120944);
                return false;
            } else {
                this.BsG = (byte) 0;
                AppMethodBeat.o(120944);
                return false;
            }
        }

        public final void a(a.i.b.a.c.g.f fVar) {
            int i = 0;
            AppMethodBeat.i(120945);
            vq();
            a.i.b.a.c.g.i.c.a eip = eip();
            if ((this.BsD & 1) == 1) {
                fVar.bq(1, this.BsE);
            }
            if ((this.BsD & 2) == 2) {
                fVar.bq(2, this.Buf);
            }
            if ((this.BsD & 4) == 4) {
                fVar.rP(this.BvC);
            }
            if ((this.BsD & 8) == 8) {
                fVar.io(4, this.BvD.value);
            }
            for (int i2 = 0; i2 < this.BvE.size(); i2++) {
                fVar.a(5, (a.i.b.a.c.g.q) this.BvE.get(i2));
            }
            if (this.BvF.size() > 0) {
                fVar.fw(50);
                fVar.fw(this.BvG);
            }
            while (i < this.BvF.size()) {
                fVar.Uy(((Integer) this.BvF.get(i)).intValue());
                i++;
            }
            eip.b(1000, fVar);
            fVar.d(this.BsB);
            AppMethodBeat.o(120945);
        }

        public final int vq() {
            AppMethodBeat.i(120946);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.o(120946);
                return i;
            }
            int i2;
            if ((this.BsD & 1) == 1) {
                i = a.i.b.a.c.g.f.bs(1, this.BsE) + 0;
            } else {
                i = 0;
            }
            if ((this.BsD & 2) == 2) {
                i += a.i.b.a.c.g.f.bs(2, this.Buf);
            }
            if ((this.BsD & 4) == 4) {
                i += a.i.b.a.c.g.f.fv(3) + 1;
            }
            if ((this.BsD & 8) == 8) {
                i += a.i.b.a.c.g.f.ip(4, this.BvD.value);
            }
            int i3 = i;
            for (i2 = 0; i2 < this.BvE.size(); i2++) {
                i3 += a.i.b.a.c.g.f.c(5, (a.i.b.a.c.g.q) this.BvE.get(i2));
            }
            i2 = 0;
            int i4 = 0;
            while (i2 < this.BvF.size()) {
                i2++;
                i4 = a.i.b.a.c.g.f.ft(((Integer) this.BvF.get(i2)).intValue()) + i4;
            }
            i = i3 + i4;
            if (!this.BvF.isEmpty()) {
                i = (i + 1) + a.i.b.a.c.g.f.ft(i4);
            }
            this.BvG = i4;
            i = (i + this.BzI.vq()) + this.BsB.size();
            this.BsH = i;
            AppMethodBeat.o(120946);
            return i;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.g.q ecE() {
            return BvB;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecC() {
            AppMethodBeat.i(120947);
            a d = a.efL().d(this);
            AppMethodBeat.o(120947);
            return d;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecD() {
            AppMethodBeat.i(120948);
            a efL = a.efL();
            AppMethodBeat.o(120948);
            return efL;
        }
    }

    public interface ah extends a.i.b.a.c.g.r {
    }

    public interface d extends a.i.b.a.c.g.i.d {
    }

    public static final class w extends a.i.b.a.c.g.i implements x {
        public static a.i.b.a.c.g.s<w> BsC = new a.i.b.a.c.g.b<w>() {
            public final /* synthetic */ Object a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120740);
                w wVar = new w(eVar, gVar, (byte) 0);
                AppMethodBeat.o(120740);
                return wVar;
            }
        };
        private static final w BuN;
        private final a.i.b.a.c.g.d BsB;
        private byte BsG;
        private int BsH;
        private List<b> BuO;

        public interface c extends a.i.b.a.c.g.r {
        }

        public static final class b extends a.i.b.a.c.g.i implements c {
            public static a.i.b.a.c.g.s<b> BsC = new a.i.b.a.c.g.b<b>() {
                public final /* synthetic */ Object a(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                    AppMethodBeat.i(120758);
                    b bVar = new b(eVar, gVar, (byte) 0);
                    AppMethodBeat.o(120758);
                    return bVar;
                }
            };
            private static final b BuP;
            private final a.i.b.a.c.g.d BsB;
            private int BsD;
            private byte BsG;
            private int BsH;
            public int BuQ;
            public int BuR;
            public b BuS;

            public static final class a extends a.i.b.a.c.g.i.a<b, a> implements c {
                private int BsD;
                private int BuQ = -1;
                private int BuR;
                private b BuS = b.PACKAGE;

                public final /* synthetic */ a.i.b.a.c.g.a.a c(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                    AppMethodBeat.i(120767);
                    a q = q(eVar, gVar);
                    AppMethodBeat.o(120767);
                    return q;
                }

                public final /* synthetic */ Object clone() {
                    AppMethodBeat.i(120772);
                    a eeO = eeO();
                    AppMethodBeat.o(120772);
                    return eeO;
                }

                public final /* synthetic */ a.i.b.a.c.g.q.a d(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                    AppMethodBeat.i(120769);
                    a q = q(eVar, gVar);
                    AppMethodBeat.o(120769);
                    return q;
                }

                public final /* synthetic */ a.i.b.a.c.g.i.a ecK() {
                    AppMethodBeat.i(120766);
                    a eeO = eeO();
                    AppMethodBeat.o(120766);
                    return eeO;
                }

                public final /* synthetic */ a.i.b.a.c.g.a.a ecL() {
                    AppMethodBeat.i(120768);
                    a eeO = eeO();
                    AppMethodBeat.o(120768);
                    return eeO;
                }

                private a() {
                }

                private b eeP() {
                    int i = 1;
                    AppMethodBeat.i(120760);
                    b bVar = new b((a.i.b.a.c.g.i.a) this, (byte) 0);
                    int i2 = this.BsD;
                    if ((i2 & 1) != 1) {
                        i = 0;
                    }
                    bVar.BuQ = this.BuQ;
                    if ((i2 & 2) == 2) {
                        i |= 2;
                    }
                    bVar.BuR = this.BuR;
                    if ((i2 & 4) == 4) {
                        i |= 4;
                    }
                    bVar.BuS = this.BuS;
                    bVar.BsD = i;
                    AppMethodBeat.o(120760);
                    return bVar;
                }

                public final a b(b bVar) {
                    AppMethodBeat.i(120761);
                    if (bVar == b.eeL()) {
                        AppMethodBeat.o(120761);
                    } else {
                        if (bVar.eeM()) {
                            Tz(bVar.BuQ);
                        }
                        if (bVar.eeN()) {
                            TA(bVar.BuR);
                        }
                        if (bVar.edQ()) {
                            a(bVar.BuS);
                        }
                        this.BsB = this.BsB.a(bVar.BsB);
                        AppMethodBeat.o(120761);
                    }
                    return this;
                }

                public final boolean isInitialized() {
                    boolean z;
                    if ((this.BsD & 2) == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        return true;
                    }
                    return false;
                }

                /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                private a q(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                    b bVar;
                    Throwable th;
                    AppMethodBeat.i(120762);
                    b bVar2 = null;
                    try {
                        b((b) b.BsC.a(eVar, gVar));
                        AppMethodBeat.o(120762);
                        return this;
                    } catch (a.i.b.a.c.g.k e) {
                        a.i.b.a.c.g.k kVar = e;
                        bVar = (b) kVar.BzY;
                        AppMethodBeat.o(120762);
                        throw kVar;
                    } catch (Throwable th2) {
                        th = th2;
                        bVar2 = bVar;
                        if (bVar2 != null) {
                        }
                        AppMethodBeat.o(120762);
                        throw th;
                    }
                }

                private a Tz(int i) {
                    this.BsD |= 1;
                    this.BuQ = i;
                    return this;
                }

                private a TA(int i) {
                    this.BsD |= 2;
                    this.BuR = i;
                    return this;
                }

                private a a(b bVar) {
                    AppMethodBeat.i(120763);
                    if (bVar == null) {
                        NullPointerException nullPointerException = new NullPointerException();
                        AppMethodBeat.o(120763);
                        throw nullPointerException;
                    }
                    this.BsD |= 4;
                    this.BuS = bVar;
                    AppMethodBeat.o(120763);
                    return this;
                }

                private a eeO() {
                    AppMethodBeat.i(120759);
                    a b = new a().b(eeP());
                    AppMethodBeat.o(120759);
                    return b;
                }

                public final /* synthetic */ a.i.b.a.c.g.i ecJ() {
                    AppMethodBeat.i(120764);
                    b eeL = b.eeL();
                    AppMethodBeat.o(120764);
                    return eeL;
                }

                public final /* synthetic */ a.i.b.a.c.g.q ecM() {
                    AppMethodBeat.i(120770);
                    b eeP = eeP();
                    if (eeP.isInitialized()) {
                        AppMethodBeat.o(120770);
                        return eeP;
                    }
                    a.i.b.a.c.g.w wVar = new a.i.b.a.c.g.w();
                    AppMethodBeat.o(120770);
                    throw wVar;
                }

                public final /* synthetic */ a.i.b.a.c.g.q ecE() {
                    AppMethodBeat.i(120771);
                    b eeL = b.eeL();
                    AppMethodBeat.o(120771);
                    return eeL;
                }

                static /* synthetic */ a eeQ() {
                    AppMethodBeat.i(120773);
                    a aVar = new a();
                    AppMethodBeat.o(120773);
                    return aVar;
                }
            }

            public enum b implements a.i.b.a.c.g.j.a {
                CLASS(0),
                PACKAGE(1),
                LOCAL(2);
                
                private static a.i.b.a.c.g.j.b<b> Btk;
                final int value;

                static {
                    Btk = new a.i.b.a.c.g.j.b<b>() {
                        public final /* synthetic */ a.i.b.a.c.g.j.a SW(int i) {
                            AppMethodBeat.i(120774);
                            b TB = b.TB(i);
                            AppMethodBeat.o(120774);
                            return TB;
                        }
                    };
                    AppMethodBeat.o(120777);
                }

                public final int edd() {
                    return this.value;
                }

                public static b TB(int i) {
                    switch (i) {
                        case 0:
                            return CLASS;
                        case 1:
                            return PACKAGE;
                        case 2:
                            return LOCAL;
                        default:
                            return null;
                    }
                }

                private b(int i) {
                    this.value = i;
                }
            }

            /* synthetic */ b(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar, byte b) {
                this(eVar, gVar);
            }

            private b(a.i.b.a.c.g.i.a aVar) {
                super((byte) 0);
                this.BsG = (byte) -1;
                this.BsH = -1;
                this.BsB = aVar.BsB;
            }

            private b() {
                this.BsG = (byte) -1;
                this.BsH = -1;
                this.BsB = a.i.b.a.c.g.d.Bzq;
            }

            public static b eeL() {
                return BuP;
            }

            private b(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120778);
                this.BsG = (byte) -1;
                this.BsH = -1;
                ecA();
                a.i.b.a.c.g.d.b ehS = a.i.b.a.c.g.d.ehS();
                a.i.b.a.c.g.f e = a.i.b.a.c.g.f.e(ehS, 1);
                int i = 0;
                while (i == 0) {
                    try {
                        int vc = eVar.vc();
                        switch (vc) {
                            case 0:
                                i = 1;
                                break;
                            case 8:
                                this.BsD |= 1;
                                this.BuQ = eVar.vd();
                                break;
                            case 16:
                                this.BsD |= 2;
                                this.BuR = eVar.vd();
                                break;
                            case 24:
                                int vd = eVar.vd();
                                b TB = b.TB(vd);
                                if (TB != null) {
                                    this.BsD |= 4;
                                    this.BuS = TB;
                                    break;
                                }
                                e.fw(vc);
                                e.fw(vd);
                                break;
                            default:
                                if (!a(eVar, e, gVar, vc)) {
                                    i = 1;
                                    break;
                                }
                                break;
                        }
                    } catch (a.i.b.a.c.g.k e2) {
                        e2.BzY = this;
                        AppMethodBeat.o(120778);
                        throw e2;
                    } catch (IOException e3) {
                        a.i.b.a.c.g.k kVar = new a.i.b.a.c.g.k(e3.getMessage());
                        kVar.BzY = this;
                        AppMethodBeat.o(120778);
                        throw kVar;
                    } catch (Throwable th) {
                        try {
                            e.flush();
                            this.BsB = ehS.ehW();
                        } catch (IOException e4) {
                            this.BsB = ehS.ehW();
                        } catch (Throwable th2) {
                            this.BsB = ehS.ehW();
                            AppMethodBeat.o(120778);
                        }
                        eio();
                        AppMethodBeat.o(120778);
                    }
                }
                try {
                    e.flush();
                    this.BsB = ehS.ehW();
                } catch (IOException e5) {
                    this.BsB = ehS.ehW();
                } catch (Throwable th3) {
                    this.BsB = ehS.ehW();
                    AppMethodBeat.o(120778);
                }
                eio();
                AppMethodBeat.o(120778);
            }

            static {
                AppMethodBeat.i(120784);
                b bVar = new b();
                BuP = bVar;
                bVar.ecA();
                AppMethodBeat.o(120784);
            }

            public final a.i.b.a.c.g.s<b> ecy() {
                return BsC;
            }

            public final boolean eeM() {
                return (this.BsD & 1) == 1;
            }

            public final boolean eeN() {
                return (this.BsD & 2) == 2;
            }

            public final boolean edQ() {
                return (this.BsD & 4) == 4;
            }

            private void ecA() {
                this.BuQ = -1;
                this.BuR = 0;
                this.BuS = b.PACKAGE;
            }

            public final boolean isInitialized() {
                AppMethodBeat.i(120779);
                byte b = this.BsG;
                if (b == (byte) 1) {
                    AppMethodBeat.o(120779);
                    return true;
                } else if (b == (byte) 0) {
                    AppMethodBeat.o(120779);
                    return false;
                } else if (eeN()) {
                    this.BsG = (byte) 1;
                    AppMethodBeat.o(120779);
                    return true;
                } else {
                    this.BsG = (byte) 0;
                    AppMethodBeat.o(120779);
                    return false;
                }
            }

            public final void a(a.i.b.a.c.g.f fVar) {
                AppMethodBeat.i(120780);
                vq();
                if ((this.BsD & 1) == 1) {
                    fVar.bq(1, this.BuQ);
                }
                if ((this.BsD & 2) == 2) {
                    fVar.bq(2, this.BuR);
                }
                if ((this.BsD & 4) == 4) {
                    fVar.io(3, this.BuS.value);
                }
                fVar.d(this.BsB);
                AppMethodBeat.o(120780);
            }

            public final int vq() {
                AppMethodBeat.i(120781);
                int i = this.BsH;
                if (i != -1) {
                    AppMethodBeat.o(120781);
                    return i;
                }
                i = 0;
                if ((this.BsD & 1) == 1) {
                    i = a.i.b.a.c.g.f.bs(1, this.BuQ) + 0;
                }
                if ((this.BsD & 2) == 2) {
                    i += a.i.b.a.c.g.f.bs(2, this.BuR);
                }
                if ((this.BsD & 4) == 4) {
                    i += a.i.b.a.c.g.f.ip(3, this.BuS.value);
                }
                i += this.BsB.size();
                this.BsH = i;
                AppMethodBeat.o(120781);
                return i;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a ecC() {
                AppMethodBeat.i(120782);
                a b = a.eeQ().b(this);
                AppMethodBeat.o(120782);
                return b;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a ecD() {
                AppMethodBeat.i(120783);
                a eeQ = a.eeQ();
                AppMethodBeat.o(120783);
                return eeQ;
            }

            public final /* bridge */ /* synthetic */ a.i.b.a.c.g.q ecE() {
                return BuP;
            }
        }

        public static final class a extends a.i.b.a.c.g.i.a<w, a> implements x {
            private int BsD;
            private List<b> BuO = Collections.emptyList();

            public final /* synthetic */ a.i.b.a.c.g.i.a a(a.i.b.a.c.g.i iVar) {
                AppMethodBeat.i(120749);
                a d = d((w) iVar);
                AppMethodBeat.o(120749);
                return d;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a c(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120751);
                a p = p(eVar, gVar);
                AppMethodBeat.o(120751);
                return p;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(120756);
                a eeH = eeH();
                AppMethodBeat.o(120756);
                return eeH;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a d(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                AppMethodBeat.i(120753);
                a p = p(eVar, gVar);
                AppMethodBeat.o(120753);
                return p;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.a ecK() {
                AppMethodBeat.i(120750);
                a eeH = eeH();
                AppMethodBeat.o(120750);
                return eeH;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a ecL() {
                AppMethodBeat.i(120752);
                a eeH = eeH();
                AppMethodBeat.o(120752);
                return eeH;
            }

            private a() {
                AppMethodBeat.i(120741);
                AppMethodBeat.o(120741);
            }

            public final w eeI() {
                AppMethodBeat.i(120743);
                w wVar = new w((a.i.b.a.c.g.i.a) this, (byte) 0);
                if ((this.BsD & 1) == 1) {
                    this.BuO = Collections.unmodifiableList(this.BuO);
                    this.BsD &= -2;
                }
                wVar.BuO = this.BuO;
                AppMethodBeat.o(120743);
                return wVar;
            }

            public final a d(w wVar) {
                AppMethodBeat.i(120744);
                if (wVar == w.eeF()) {
                    AppMethodBeat.o(120744);
                } else {
                    if (!wVar.BuO.isEmpty()) {
                        if (this.BuO.isEmpty()) {
                            this.BuO = wVar.BuO;
                            this.BsD &= -2;
                        } else {
                            eeJ();
                            this.BuO.addAll(wVar.BuO);
                        }
                    }
                    this.BsB = this.BsB.a(wVar.BsB);
                    AppMethodBeat.o(120744);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private a p(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
                w wVar;
                Throwable th;
                AppMethodBeat.i(120746);
                w wVar2 = null;
                try {
                    d((w) w.BsC.a(eVar, gVar));
                    AppMethodBeat.o(120746);
                    return this;
                } catch (a.i.b.a.c.g.k e) {
                    a.i.b.a.c.g.k kVar = e;
                    wVar = (w) kVar.BzY;
                    AppMethodBeat.o(120746);
                    throw kVar;
                } catch (Throwable th2) {
                    th = th2;
                    wVar2 = wVar;
                    if (wVar2 != null) {
                    }
                    AppMethodBeat.o(120746);
                    throw th;
                }
            }

            private void eeJ() {
                AppMethodBeat.i(120747);
                if ((this.BsD & 1) != 1) {
                    this.BuO = new ArrayList(this.BuO);
                    this.BsD |= 1;
                }
                AppMethodBeat.o(120747);
            }

            private a eeH() {
                AppMethodBeat.i(120742);
                a d = new a().d(eeI());
                AppMethodBeat.o(120742);
                return d;
            }

            public final boolean isInitialized() {
                AppMethodBeat.i(120745);
                int i = 0;
                while (i < this.BuO.size()) {
                    if (((b) this.BuO.get(i)).isInitialized()) {
                        i++;
                    } else {
                        AppMethodBeat.o(120745);
                        return false;
                    }
                }
                AppMethodBeat.o(120745);
                return true;
            }

            public final /* synthetic */ a.i.b.a.c.g.i ecJ() {
                AppMethodBeat.i(120748);
                w eeF = w.eeF();
                AppMethodBeat.o(120748);
                return eeF;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecM() {
                AppMethodBeat.i(120754);
                w eeI = eeI();
                if (eeI.isInitialized()) {
                    AppMethodBeat.o(120754);
                    return eeI;
                }
                a.i.b.a.c.g.w wVar = new a.i.b.a.c.g.w();
                AppMethodBeat.o(120754);
                throw wVar;
            }

            public final /* synthetic */ a.i.b.a.c.g.q ecE() {
                AppMethodBeat.i(120755);
                w eeF = w.eeF();
                AppMethodBeat.o(120755);
                return eeF;
            }

            static /* synthetic */ a eeK() {
                AppMethodBeat.i(120757);
                a aVar = new a();
                AppMethodBeat.o(120757);
                return aVar;
            }
        }

        /* synthetic */ w(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar, byte b) {
            this(eVar, gVar);
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecC() {
            AppMethodBeat.i(120792);
            a eeG = eeG();
            AppMethodBeat.o(120792);
            return eeG;
        }

        private w(a.i.b.a.c.g.i.a aVar) {
            super((byte) 0);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = aVar.BsB;
        }

        private w() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = a.i.b.a.c.g.d.Bzq;
        }

        public static w eeF() {
            return BuN;
        }

        private w(a.i.b.a.c.g.e eVar, a.i.b.a.c.g.g gVar) {
            AppMethodBeat.i(120785);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BuO = Collections.emptyList();
            a.i.b.a.c.g.d.b ehS = a.i.b.a.c.g.d.ehS();
            a.i.b.a.c.g.f e = a.i.b.a.c.g.f.e(ehS, 1);
            int i = 0;
            int i2 = 0;
            while (i == 0) {
                try {
                    int vc = eVar.vc();
                    switch (vc) {
                        case 0:
                            i = 1;
                            break;
                        case 10:
                            if ((i2 & 1) != 1) {
                                this.BuO = new ArrayList();
                                i2 |= 1;
                            }
                            this.BuO.add(eVar.a(b.BsC, gVar));
                            break;
                        default:
                            if (!a(eVar, e, gVar, vc)) {
                                i = 1;
                                break;
                            }
                            break;
                    }
                } catch (a.i.b.a.c.g.k e2) {
                    e2.BzY = this;
                    AppMethodBeat.o(120785);
                    throw e2;
                } catch (IOException e3) {
                    a.i.b.a.c.g.k kVar = new a.i.b.a.c.g.k(e3.getMessage());
                    kVar.BzY = this;
                    AppMethodBeat.o(120785);
                    throw kVar;
                } catch (Throwable th) {
                    if ((i2 & 1) == 1) {
                        this.BuO = Collections.unmodifiableList(this.BuO);
                    }
                    try {
                        e.flush();
                        this.BsB = ehS.ehW();
                    } catch (IOException e4) {
                        this.BsB = ehS.ehW();
                    } catch (Throwable th2) {
                        this.BsB = ehS.ehW();
                        AppMethodBeat.o(120785);
                    }
                    eio();
                    AppMethodBeat.o(120785);
                }
            }
            if ((i2 & 1) == 1) {
                this.BuO = Collections.unmodifiableList(this.BuO);
            }
            try {
                e.flush();
                this.BsB = ehS.ehW();
            } catch (IOException e5) {
                this.BsB = ehS.ehW();
            } catch (Throwable th3) {
                this.BsB = ehS.ehW();
                AppMethodBeat.o(120785);
            }
            eio();
            AppMethodBeat.o(120785);
        }

        static {
            AppMethodBeat.i(120794);
            w wVar = new w();
            BuN = wVar;
            wVar.BuO = Collections.emptyList();
            AppMethodBeat.o(120794);
        }

        public final a.i.b.a.c.g.s<w> ecy() {
            return BsC;
        }

        public final b Ty(int i) {
            AppMethodBeat.i(120786);
            b bVar = (b) this.BuO.get(i);
            AppMethodBeat.o(120786);
            return bVar;
        }

        public final boolean isInitialized() {
            AppMethodBeat.i(120787);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.o(120787);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.o(120787);
                return false;
            } else {
                int i = 0;
                while (i < this.BuO.size()) {
                    if (Ty(i).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(120787);
                        return false;
                    }
                }
                this.BsG = (byte) 1;
                AppMethodBeat.o(120787);
                return true;
            }
        }

        public final void a(a.i.b.a.c.g.f fVar) {
            AppMethodBeat.i(120788);
            vq();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.BuO.size()) {
                    fVar.a(1, (a.i.b.a.c.g.q) this.BuO.get(i2));
                    i = i2 + 1;
                } else {
                    fVar.d(this.BsB);
                    AppMethodBeat.o(120788);
                    return;
                }
            }
        }

        public final int vq() {
            AppMethodBeat.i(120789);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.o(120789);
                return i;
            }
            int i2 = 0;
            for (i = 0; i < this.BuO.size(); i++) {
                i2 += a.i.b.a.c.g.f.c(1, (a.i.b.a.c.g.q) this.BuO.get(i));
            }
            int size = this.BsB.size() + i2;
            this.BsH = size;
            AppMethodBeat.o(120789);
            return size;
        }

        public static a a(w wVar) {
            AppMethodBeat.i(120790);
            a d = a.eeK().d(wVar);
            AppMethodBeat.o(120790);
            return d;
        }

        public final a eeG() {
            AppMethodBeat.i(120791);
            a d = a.eeK().d(this);
            AppMethodBeat.o(120791);
            return d;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecD() {
            AppMethodBeat.i(120793);
            a eeK = a.eeK();
            AppMethodBeat.o(120793);
            return eeK;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.g.q ecE() {
            return BuN;
        }
    }
}
