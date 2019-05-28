package a.i.b.a.c.e.b;

import a.i.b.a.c.e.a.w;
import a.i.b.a.c.e.a.y;
import a.i.b.a.c.g.e;
import a.i.b.a.c.g.f;
import a.i.b.a.c.g.g;
import a.i.b.a.c.g.i;
import a.i.b.a.c.g.k;
import a.i.b.a.c.g.n;
import a.i.b.a.c.g.o;
import a.i.b.a.c.g.q;
import a.i.b.a.c.g.r;
import a.i.b.a.c.g.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a {

    public static final class a extends i implements b {
        public static s<a> BsC = new a.i.b.a.c.g.b<a>() {
            public final /* synthetic */ Object a(e eVar, g gVar) {
                AppMethodBeat.i(121100);
                a aVar = new a(eVar, gVar, (byte) 0);
                AppMethodBeat.o(121100);
                return aVar;
            }
        };
        private static final a Bxk;
        private final a.i.b.a.c.g.d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        public List<a.i.b.a.c.e.a.a> BvA;
        public List<c> Bxl;
        public List<c> Bxm;
        public o Bxn;
        public y Bxo;
        public w Bxp;

        public static final class a extends a.i.b.a.c.g.i.a<a, a> implements b {
            private int BsD;
            private List<a.i.b.a.c.e.a.a> BvA = Collections.emptyList();
            private List<c> Bxl = Collections.emptyList();
            private List<c> Bxm = Collections.emptyList();
            private o Bxn = n.BAf;
            private y Bxo = y.eeR();
            private w Bxp = w.eeF();

            public final /* synthetic */ a.i.b.a.c.g.i.a a(i iVar) {
                AppMethodBeat.i(121114);
                a f = f((a) iVar);
                AppMethodBeat.o(121114);
                return f;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a c(e eVar, g gVar) {
                AppMethodBeat.i(121116);
                a A = A(eVar, gVar);
                AppMethodBeat.o(121116);
                return A;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(121121);
                a egs = egs();
                AppMethodBeat.o(121121);
                return egs;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a d(e eVar, g gVar) {
                AppMethodBeat.i(121118);
                a A = A(eVar, gVar);
                AppMethodBeat.o(121118);
                return A;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.a ecK() {
                AppMethodBeat.i(121115);
                a egs = egs();
                AppMethodBeat.o(121115);
                return egs;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a ecL() {
                AppMethodBeat.i(121117);
                a egs = egs();
                AppMethodBeat.o(121117);
                return egs;
            }

            private a() {
                AppMethodBeat.i(121101);
                AppMethodBeat.o(121101);
            }

            private a egt() {
                int i = 1;
                AppMethodBeat.i(121103);
                a aVar = new a((a.i.b.a.c.g.i.a) this, (byte) 0);
                int i2 = this.BsD;
                if ((this.BsD & 1) == 1) {
                    this.Bxl = Collections.unmodifiableList(this.Bxl);
                    this.BsD &= -2;
                }
                aVar.Bxl = this.Bxl;
                if ((this.BsD & 2) == 2) {
                    this.Bxm = Collections.unmodifiableList(this.Bxm);
                    this.BsD &= -3;
                }
                aVar.Bxm = this.Bxm;
                if ((this.BsD & 4) == 4) {
                    this.Bxn = this.Bxn.eiA();
                    this.BsD &= -5;
                }
                aVar.Bxn = this.Bxn;
                if ((i2 & 8) != 8) {
                    i = 0;
                }
                aVar.Bxo = this.Bxo;
                if ((i2 & 16) == 16) {
                    i |= 2;
                }
                aVar.Bxp = this.Bxp;
                if ((this.BsD & 32) == 32) {
                    this.BvA = Collections.unmodifiableList(this.BvA);
                    this.BsD &= -33;
                }
                aVar.BvA = this.BvA;
                aVar.BsD = i;
                AppMethodBeat.o(121103);
                return aVar;
            }

            public final a f(a aVar) {
                AppMethodBeat.i(121104);
                if (aVar == a.egp()) {
                    AppMethodBeat.o(121104);
                } else {
                    if (!aVar.Bxl.isEmpty()) {
                        if (this.Bxl.isEmpty()) {
                            this.Bxl = aVar.Bxl;
                            this.BsD &= -2;
                        } else {
                            egu();
                            this.Bxl.addAll(aVar.Bxl);
                        }
                    }
                    if (!aVar.Bxm.isEmpty()) {
                        if (this.Bxm.isEmpty()) {
                            this.Bxm = aVar.Bxm;
                            this.BsD &= -3;
                        } else {
                            egv();
                            this.Bxm.addAll(aVar.Bxm);
                        }
                    }
                    if (!aVar.Bxn.isEmpty()) {
                        if (this.Bxn.isEmpty()) {
                            this.Bxn = aVar.Bxn;
                            this.BsD &= -5;
                        } else {
                            egw();
                            this.Bxn.addAll(aVar.Bxn);
                        }
                    }
                    if (aVar.egq()) {
                        e(aVar.Bxo);
                    }
                    if (aVar.egr()) {
                        e(aVar.Bxp);
                    }
                    if (!aVar.BvA.isEmpty()) {
                        if (this.BvA.isEmpty()) {
                            this.BvA = aVar.BvA;
                            this.BsD &= -33;
                        } else {
                            efC();
                            this.BvA.addAll(aVar.BvA);
                        }
                    }
                    this.BsB = this.BsB.a(aVar.BsB);
                    AppMethodBeat.o(121104);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private a A(e eVar, g gVar) {
                a aVar;
                Throwable th;
                AppMethodBeat.i(121106);
                a aVar2 = null;
                try {
                    f((a) a.BsC.a(eVar, gVar));
                    AppMethodBeat.o(121106);
                    return this;
                } catch (k e) {
                    k kVar = e;
                    aVar = (a) kVar.BzY;
                    AppMethodBeat.o(121106);
                    throw kVar;
                } catch (Throwable th2) {
                    th = th2;
                    aVar2 = aVar;
                    if (aVar2 != null) {
                    }
                    AppMethodBeat.o(121106);
                    throw th;
                }
            }

            private void egu() {
                AppMethodBeat.i(121107);
                if ((this.BsD & 1) != 1) {
                    this.Bxl = new ArrayList(this.Bxl);
                    this.BsD |= 1;
                }
                AppMethodBeat.o(121107);
            }

            private void egv() {
                AppMethodBeat.i(121108);
                if ((this.BsD & 2) != 2) {
                    this.Bxm = new ArrayList(this.Bxm);
                    this.BsD |= 2;
                }
                AppMethodBeat.o(121108);
            }

            private void egw() {
                AppMethodBeat.i(121109);
                if ((this.BsD & 4) != 4) {
                    this.Bxn = new n(this.Bxn);
                    this.BsD |= 4;
                }
                AppMethodBeat.o(121109);
            }

            private a e(y yVar) {
                AppMethodBeat.i(121110);
                if ((this.BsD & 8) != 8 || this.Bxo == y.eeR()) {
                    this.Bxo = yVar;
                } else {
                    this.Bxo = y.a(this.Bxo).d(yVar).eeU();
                }
                this.BsD |= 8;
                AppMethodBeat.o(121110);
                return this;
            }

            private a e(w wVar) {
                AppMethodBeat.i(121111);
                if ((this.BsD & 16) != 16 || this.Bxp == w.eeF()) {
                    this.Bxp = wVar;
                } else {
                    this.Bxp = w.a(this.Bxp).d(wVar).eeI();
                }
                this.BsD |= 16;
                AppMethodBeat.o(121111);
                return this;
            }

            private void efC() {
                AppMethodBeat.i(121112);
                if ((this.BsD & 32) != 32) {
                    this.BvA = new ArrayList(this.BvA);
                    this.BsD |= 32;
                }
                AppMethodBeat.o(121112);
            }

            private a egs() {
                AppMethodBeat.i(121102);
                a f = new a().f(egt());
                AppMethodBeat.o(121102);
                return f;
            }

            public final boolean isInitialized() {
                boolean z;
                AppMethodBeat.i(121105);
                int i = 0;
                while (i < this.Bxl.size()) {
                    if (((c) this.Bxl.get(i)).isInitialized()) {
                        i++;
                    } else {
                        AppMethodBeat.o(121105);
                        return false;
                    }
                }
                i = 0;
                while (i < this.Bxm.size()) {
                    if (((c) this.Bxm.get(i)).isInitialized()) {
                        i++;
                    } else {
                        AppMethodBeat.o(121105);
                        return false;
                    }
                }
                if ((this.BsD & 16) == 16) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z || this.Bxp.isInitialized()) {
                    i = 0;
                    while (i < this.BvA.size()) {
                        if (((a.i.b.a.c.e.a.a) this.BvA.get(i)).isInitialized()) {
                            i++;
                        } else {
                            AppMethodBeat.o(121105);
                            return false;
                        }
                    }
                    AppMethodBeat.o(121105);
                    return true;
                }
                AppMethodBeat.o(121105);
                return false;
            }

            public final /* synthetic */ i ecJ() {
                AppMethodBeat.i(121113);
                a egp = a.egp();
                AppMethodBeat.o(121113);
                return egp;
            }

            public final /* synthetic */ q ecM() {
                AppMethodBeat.i(121119);
                a egt = egt();
                if (egt.isInitialized()) {
                    AppMethodBeat.o(121119);
                    return egt;
                }
                a.i.b.a.c.g.w wVar = new a.i.b.a.c.g.w();
                AppMethodBeat.o(121119);
                throw wVar;
            }

            public final /* synthetic */ q ecE() {
                AppMethodBeat.i(121120);
                a egp = a.egp();
                AppMethodBeat.o(121120);
                return egp;
            }

            static /* synthetic */ a egx() {
                AppMethodBeat.i(121122);
                a aVar = new a();
                AppMethodBeat.o(121122);
                return aVar;
            }
        }

        /* synthetic */ a(e eVar, g gVar, byte b) {
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

        public static a egp() {
            return Bxk;
        }

        /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x0051=Splitter:B:16:0x0051, B:46:0x00b9=Splitter:B:46:0x00b9} */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x006c  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0078  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0084  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x006c  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0078  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0084  */
        /* JADX WARNING: Missing block: B:76:0x015a, code skipped:
            r1 = r0;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private a(e eVar, g gVar) {
            k kVar;
            Throwable th;
            IOException iOException;
            k kVar2;
            AppMethodBeat.i(121123);
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            int i = 0;
            a.i.b.a.c.g.d.b ehS = a.i.b.a.c.g.d.ehS();
            f e = f.e(ehS, 1);
            int i2 = 0;
            while (i2 == 0) {
                try {
                    int vc = eVar.vc();
                    switch (vc) {
                        case 0:
                            i2 = 1;
                            break;
                        case 10:
                            if ((i & 1) != 1) {
                                this.Bxl = new ArrayList();
                                i |= 1;
                            }
                            this.Bxl.add(eVar.a(c.BsC, gVar));
                            break;
                        case 18:
                            if ((i & 2) != 2) {
                                this.Bxm = new ArrayList();
                                i |= 2;
                            }
                            this.Bxm.add(eVar.a(c.BsC, gVar));
                            break;
                        case 26:
                            a.i.b.a.c.g.d ehY = eVar.ehY();
                            if ((i & 4) != 4) {
                                this.Bxn = new n();
                                i |= 4;
                            }
                            this.Bxn.e(ehY);
                            break;
                        case 34:
                            a.i.b.a.c.e.a.y.a eeS;
                            if ((this.BsD & 1) == 1) {
                                eeS = this.Bxo.eeS();
                            } else {
                                eeS = null;
                            }
                            this.Bxo = (y) eVar.a(y.BsC, gVar);
                            if (eeS != null) {
                                eeS.d(this.Bxo);
                                this.Bxo = eeS.eeU();
                            }
                            this.BsD |= 1;
                            break;
                        case 42:
                            a.i.b.a.c.e.a.w.a eeG;
                            if ((this.BsD & 2) == 2) {
                                eeG = this.Bxp.eeG();
                            } else {
                                eeG = null;
                            }
                            this.Bxp = (w) eVar.a(w.BsC, gVar);
                            if (eeG != null) {
                                eeG.d(this.Bxp);
                                this.Bxp = eeG.eeI();
                            }
                            this.BsD |= 2;
                            break;
                        case 50:
                            if ((i & 32) != 32) {
                                this.BvA = new ArrayList();
                                vc = i | 32;
                            } else {
                                vc = i;
                            }
                            try {
                                this.BvA.add(eVar.a(a.i.b.a.c.e.a.a.BsC, gVar));
                                break;
                            } catch (k e2) {
                                kVar = e2;
                                i2 = vc;
                                try {
                                    kVar.BzY = this;
                                    AppMethodBeat.o(121123);
                                    throw kVar;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if ((i2 & 1) == 1) {
                                        this.Bxl = Collections.unmodifiableList(this.Bxl);
                                    }
                                    if ((i2 & 2) == 2) {
                                        this.Bxm = Collections.unmodifiableList(this.Bxm);
                                    }
                                    if ((i2 & 4) == 4) {
                                        this.Bxn = this.Bxn.eiA();
                                    }
                                    if ((i2 & 32) == 32) {
                                        this.BvA = Collections.unmodifiableList(this.BvA);
                                    }
                                    try {
                                        e.flush();
                                        this.BsB = ehS.ehW();
                                    } catch (IOException e3) {
                                        this.BsB = ehS.ehW();
                                    } catch (Throwable th3) {
                                        this.BsB = ehS.ehW();
                                        AppMethodBeat.o(121123);
                                    }
                                    eio();
                                    AppMethodBeat.o(121123);
                                    throw th;
                                }
                            } catch (IOException e4) {
                                iOException = e4;
                                i2 = vc;
                                kVar2 = new k(iOException.getMessage());
                                kVar2.BzY = this;
                                AppMethodBeat.o(121123);
                                throw kVar2;
                            } catch (Throwable th4) {
                                th = th4;
                                i2 = vc;
                                if ((i2 & 1) == 1) {
                                }
                                if ((i2 & 2) == 2) {
                                }
                                if ((i2 & 4) == 4) {
                                }
                                if ((i2 & 32) == 32) {
                                }
                                e.flush();
                                this.BsB = ehS.ehW();
                                eio();
                                AppMethodBeat.o(121123);
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
                } catch (k kVar22) {
                    kVar = kVar22;
                    i2 = i;
                    kVar.BzY = this;
                    AppMethodBeat.o(121123);
                    throw kVar;
                } catch (IOException e5) {
                    iOException = e5;
                    i2 = i;
                    kVar22 = new k(iOException.getMessage());
                    kVar22.BzY = this;
                    AppMethodBeat.o(121123);
                    throw kVar22;
                } catch (Throwable th22) {
                    th = th22;
                    i2 = i;
                    if ((i2 & 1) == 1) {
                    }
                    if ((i2 & 2) == 2) {
                    }
                    if ((i2 & 4) == 4) {
                    }
                    if ((i2 & 32) == 32) {
                    }
                    e.flush();
                    this.BsB = ehS.ehW();
                    eio();
                    AppMethodBeat.o(121123);
                    throw th;
                }
            }
            if ((i & 1) == 1) {
                this.Bxl = Collections.unmodifiableList(this.Bxl);
            }
            if ((i & 2) == 2) {
                this.Bxm = Collections.unmodifiableList(this.Bxm);
            }
            if ((i & 4) == 4) {
                this.Bxn = this.Bxn.eiA();
            }
            if ((i & 32) == 32) {
                this.BvA = Collections.unmodifiableList(this.BvA);
            }
            try {
                e.flush();
                this.BsB = ehS.ehW();
            } catch (IOException e6) {
                this.BsB = ehS.ehW();
            } catch (Throwable th5) {
                this.BsB = ehS.ehW();
                AppMethodBeat.o(121123);
            }
            eio();
            AppMethodBeat.o(121123);
        }

        static {
            AppMethodBeat.i(121131);
            a aVar = new a();
            Bxk = aVar;
            aVar.ecA();
            AppMethodBeat.o(121131);
        }

        public final s<a> ecy() {
            return BsC;
        }

        public final boolean egq() {
            return (this.BsD & 1) == 1;
        }

        public final boolean egr() {
            return (this.BsD & 2) == 2;
        }

        private void ecA() {
            AppMethodBeat.i(121124);
            this.Bxl = Collections.emptyList();
            this.Bxm = Collections.emptyList();
            this.Bxn = n.BAf;
            this.Bxo = y.eeR();
            this.Bxp = w.eeF();
            this.BvA = Collections.emptyList();
            AppMethodBeat.o(121124);
        }

        public final boolean isInitialized() {
            AppMethodBeat.i(121125);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.o(121125);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.o(121125);
                return false;
            } else {
                int i = 0;
                while (i < this.Bxl.size()) {
                    if (((c) this.Bxl.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(121125);
                        return false;
                    }
                }
                i = 0;
                while (i < this.Bxm.size()) {
                    if (((c) this.Bxm.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.o(121125);
                        return false;
                    }
                }
                if (!egr() || this.Bxp.isInitialized()) {
                    i = 0;
                    while (i < this.BvA.size()) {
                        if (((a.i.b.a.c.e.a.a) this.BvA.get(i)).isInitialized()) {
                            i++;
                        } else {
                            this.BsG = (byte) 0;
                            AppMethodBeat.o(121125);
                            return false;
                        }
                    }
                    this.BsG = (byte) 1;
                    AppMethodBeat.o(121125);
                    return true;
                }
                this.BsG = (byte) 0;
                AppMethodBeat.o(121125);
                return false;
            }
        }

        public final void a(f fVar) {
            int i;
            int i2 = 0;
            AppMethodBeat.i(121126);
            vq();
            for (i = 0; i < this.Bxl.size(); i++) {
                fVar.a(1, (q) this.Bxl.get(i));
            }
            for (i = 0; i < this.Bxm.size(); i++) {
                fVar.a(2, (q) this.Bxm.get(i));
            }
            for (int i3 = 0; i3 < this.Bxn.size(); i3++) {
                fVar.a(3, this.Bxn.UC(i3));
            }
            if ((this.BsD & 1) == 1) {
                fVar.a(4, this.Bxo);
            }
            if ((this.BsD & 2) == 2) {
                fVar.a(5, this.Bxp);
            }
            while (i2 < this.BvA.size()) {
                fVar.a(6, (q) this.BvA.get(i2));
                i2++;
            }
            fVar.d(this.BsB);
            AppMethodBeat.o(121126);
        }

        public final int vq() {
            int i = 0;
            AppMethodBeat.i(121127);
            int i2 = this.BsH;
            if (i2 != -1) {
                AppMethodBeat.o(121127);
                return i2;
            }
            int i3;
            int i4 = 0;
            for (i3 = 0; i3 < this.Bxl.size(); i3++) {
                i4 += f.c(1, (q) this.Bxl.get(i3));
            }
            for (i3 = 0; i3 < this.Bxm.size(); i3++) {
                i4 += f.c(2, (q) this.Bxm.get(i3));
            }
            i3 = 0;
            for (i2 = 0; i2 < this.Bxn.size(); i2++) {
                i3 += f.c(this.Bxn.UC(i2));
            }
            i2 = (i4 + i3) + (this.Bxn.size() * 1);
            if ((this.BsD & 1) == 1) {
                i2 += f.c(4, this.Bxo);
            }
            if ((this.BsD & 2) == 2) {
                i2 += f.c(5, this.Bxp);
            }
            while (true) {
                i3 = i2;
                if (i < this.BvA.size()) {
                    i2 = f.c(6, (q) this.BvA.get(i)) + i3;
                    i++;
                } else {
                    i2 = this.BsB.size() + i3;
                    this.BsH = i2;
                    AppMethodBeat.o(121127);
                    return i2;
                }
            }
        }

        public static a Q(InputStream inputStream) {
            AppMethodBeat.i(121128);
            a aVar = (a) BsC.R(inputStream);
            AppMethodBeat.o(121128);
            return aVar;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecC() {
            AppMethodBeat.i(121129);
            a f = a.egx().f(this);
            AppMethodBeat.o(121129);
            return f;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecD() {
            AppMethodBeat.i(121130);
            a egx = a.egx();
            AppMethodBeat.o(121130);
            return egx;
        }

        public final /* bridge */ /* synthetic */ q ecE() {
            return Bxk;
        }
    }

    public interface b extends r {
    }

    public interface d extends r {
    }

    public static final class c extends i implements d {
        public static s<c> BsC = new a.i.b.a.c.g.b<c>() {
            public final /* synthetic */ Object a(e eVar, g gVar) {
                AppMethodBeat.i(121132);
                c cVar = new c(eVar, gVar, (byte) 0);
                AppMethodBeat.o(121132);
                return cVar;
            }
        };
        private static final c Bxq;
        private final a.i.b.a.c.g.d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        private Object Bxr;
        public o Bxs;
        public List<Integer> Bxt;
        private int Bxu;
        public o Bxv;
        public o Bxw;
        public List<Integer> Bxx;
        private int Bxy;

        public static final class a extends a.i.b.a.c.g.i.a<c, a> implements d {
            private int BsD;
            private Object Bxr = "";
            private o Bxs = n.BAf;
            private List<Integer> Bxt = Collections.emptyList();
            private o Bxv = n.BAf;
            private o Bxw = n.BAf;
            private List<Integer> Bxx = Collections.emptyList();

            public final /* synthetic */ a.i.b.a.c.g.i.a a(i iVar) {
                AppMethodBeat.i(121144);
                a h = h((c) iVar);
                AppMethodBeat.o(121144);
                return h;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a c(e eVar, g gVar) {
                AppMethodBeat.i(121146);
                a B = B(eVar, gVar);
                AppMethodBeat.o(121146);
                return B;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(121151);
                a egC = egC();
                AppMethodBeat.o(121151);
                return egC;
            }

            public final /* synthetic */ a.i.b.a.c.g.q.a d(e eVar, g gVar) {
                AppMethodBeat.i(121148);
                a B = B(eVar, gVar);
                AppMethodBeat.o(121148);
                return B;
            }

            public final /* synthetic */ a.i.b.a.c.g.i.a ecK() {
                AppMethodBeat.i(121145);
                a egC = egC();
                AppMethodBeat.o(121145);
                return egC;
            }

            public final /* synthetic */ a.i.b.a.c.g.a.a ecL() {
                AppMethodBeat.i(121147);
                a egC = egC();
                AppMethodBeat.o(121147);
                return egC;
            }

            private a() {
                AppMethodBeat.i(121133);
                AppMethodBeat.o(121133);
            }

            private c egD() {
                int i = 1;
                AppMethodBeat.i(121135);
                c cVar = new c((a.i.b.a.c.g.i.a) this, (byte) 0);
                if ((this.BsD & 1) != 1) {
                    i = 0;
                }
                cVar.Bxr = this.Bxr;
                if ((this.BsD & 2) == 2) {
                    this.Bxs = this.Bxs.eiA();
                    this.BsD &= -3;
                }
                cVar.Bxs = this.Bxs;
                if ((this.BsD & 4) == 4) {
                    this.Bxt = Collections.unmodifiableList(this.Bxt);
                    this.BsD &= -5;
                }
                cVar.Bxt = this.Bxt;
                if ((this.BsD & 8) == 8) {
                    this.Bxv = this.Bxv.eiA();
                    this.BsD &= -9;
                }
                cVar.Bxv = this.Bxv;
                if ((this.BsD & 16) == 16) {
                    this.Bxw = this.Bxw.eiA();
                    this.BsD &= -17;
                }
                cVar.Bxw = this.Bxw;
                if ((this.BsD & 32) == 32) {
                    this.Bxx = Collections.unmodifiableList(this.Bxx);
                    this.BsD &= -33;
                }
                cVar.Bxx = this.Bxx;
                cVar.BsD = i;
                AppMethodBeat.o(121135);
                return cVar;
            }

            public final a h(c cVar) {
                AppMethodBeat.i(121136);
                if (cVar == c.egy()) {
                    AppMethodBeat.o(121136);
                } else {
                    if (cVar.egz()) {
                        this.BsD |= 1;
                        this.Bxr = cVar.Bxr;
                    }
                    if (!cVar.Bxs.isEmpty()) {
                        if (this.Bxs.isEmpty()) {
                            this.Bxs = cVar.Bxs;
                            this.BsD &= -3;
                        } else {
                            egE();
                            this.Bxs.addAll(cVar.Bxs);
                        }
                    }
                    if (!cVar.Bxt.isEmpty()) {
                        if (this.Bxt.isEmpty()) {
                            this.Bxt = cVar.Bxt;
                            this.BsD &= -5;
                        } else {
                            egF();
                            this.Bxt.addAll(cVar.Bxt);
                        }
                    }
                    if (!cVar.Bxv.isEmpty()) {
                        if (this.Bxv.isEmpty()) {
                            this.Bxv = cVar.Bxv;
                            this.BsD &= -9;
                        } else {
                            egG();
                            this.Bxv.addAll(cVar.Bxv);
                        }
                    }
                    if (!cVar.Bxw.isEmpty()) {
                        if (this.Bxw.isEmpty()) {
                            this.Bxw = cVar.Bxw;
                            this.BsD &= -17;
                        } else {
                            egH();
                            this.Bxw.addAll(cVar.Bxw);
                        }
                    }
                    if (!cVar.Bxx.isEmpty()) {
                        if (this.Bxx.isEmpty()) {
                            this.Bxx = cVar.Bxx;
                            this.BsD &= -33;
                        } else {
                            egI();
                            this.Bxx.addAll(cVar.Bxx);
                        }
                    }
                    this.BsB = this.BsB.a(cVar.BsB);
                    AppMethodBeat.o(121136);
                }
                return this;
            }

            public final boolean isInitialized() {
                boolean z;
                if ((this.BsD & 1) == 1) {
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
            private a B(e eVar, g gVar) {
                c cVar;
                Throwable th;
                AppMethodBeat.i(121137);
                c cVar2 = null;
                try {
                    h((c) c.BsC.a(eVar, gVar));
                    AppMethodBeat.o(121137);
                    return this;
                } catch (k e) {
                    k kVar = e;
                    cVar = (c) kVar.BzY;
                    AppMethodBeat.o(121137);
                    throw kVar;
                } catch (Throwable th2) {
                    th = th2;
                    cVar2 = cVar;
                    if (cVar2 != null) {
                    }
                    AppMethodBeat.o(121137);
                    throw th;
                }
            }

            private void egE() {
                AppMethodBeat.i(121138);
                if ((this.BsD & 2) != 2) {
                    this.Bxs = new n(this.Bxs);
                    this.BsD |= 2;
                }
                AppMethodBeat.o(121138);
            }

            private void egF() {
                AppMethodBeat.i(121139);
                if ((this.BsD & 4) != 4) {
                    this.Bxt = new ArrayList(this.Bxt);
                    this.BsD |= 4;
                }
                AppMethodBeat.o(121139);
            }

            private void egG() {
                AppMethodBeat.i(121140);
                if ((this.BsD & 8) != 8) {
                    this.Bxv = new n(this.Bxv);
                    this.BsD |= 8;
                }
                AppMethodBeat.o(121140);
            }

            private void egH() {
                AppMethodBeat.i(121141);
                if ((this.BsD & 16) != 16) {
                    this.Bxw = new n(this.Bxw);
                    this.BsD |= 16;
                }
                AppMethodBeat.o(121141);
            }

            private void egI() {
                AppMethodBeat.i(121142);
                if ((this.BsD & 32) != 32) {
                    this.Bxx = new ArrayList(this.Bxx);
                    this.BsD |= 32;
                }
                AppMethodBeat.o(121142);
            }

            private a egC() {
                AppMethodBeat.i(121134);
                a h = new a().h(egD());
                AppMethodBeat.o(121134);
                return h;
            }

            public final /* synthetic */ i ecJ() {
                AppMethodBeat.i(121143);
                c egy = c.egy();
                AppMethodBeat.o(121143);
                return egy;
            }

            public final /* synthetic */ q ecM() {
                AppMethodBeat.i(121149);
                c egD = egD();
                if (egD.isInitialized()) {
                    AppMethodBeat.o(121149);
                    return egD;
                }
                a.i.b.a.c.g.w wVar = new a.i.b.a.c.g.w();
                AppMethodBeat.o(121149);
                throw wVar;
            }

            public final /* synthetic */ q ecE() {
                AppMethodBeat.i(121150);
                c egy = c.egy();
                AppMethodBeat.o(121150);
                return egy;
            }

            static /* synthetic */ a egJ() {
                AppMethodBeat.i(121152);
                a aVar = new a();
                AppMethodBeat.o(121152);
                return aVar;
            }
        }

        /* synthetic */ c(e eVar, g gVar, byte b) {
            this(eVar, gVar);
        }

        private c(a.i.b.a.c.g.i.a aVar) {
            super((byte) 0);
            this.Bxu = -1;
            this.Bxy = -1;
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = aVar.BsB;
        }

        private c() {
            this.Bxu = -1;
            this.Bxy = -1;
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = a.i.b.a.c.g.d.Bzq;
        }

        public static c egy() {
            return Bxq;
        }

        /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0046=Splitter:B:13:0x0046, B:105:0x0196=Splitter:B:105:0x0196} */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0056  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0062  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x007e  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x008a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private c(e eVar, g gVar) {
            k e;
            k e2;
            Throwable th;
            IOException e3;
            AppMethodBeat.i(121153);
            this.Bxu = -1;
            this.Bxy = -1;
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            a.i.b.a.c.g.d.b ehS = a.i.b.a.c.g.d.ehS();
            f e4 = f.e(ehS, 1);
            int i = 0;
            int i2 = 0;
            while (i == 0) {
                int vc;
                try {
                    vc = eVar.vc();
                    a.i.b.a.c.g.d ehY;
                    switch (vc) {
                        case 0:
                            i = 1;
                            break;
                        case 10:
                            a.i.b.a.c.g.d ehY2 = eVar.ehY();
                            this.BsD |= 1;
                            this.Bxr = ehY2;
                            break;
                        case 18:
                            ehY = eVar.ehY();
                            if ((i2 & 2) != 2) {
                                this.Bxs = new n();
                                vc = i2 | 2;
                            } else {
                                vc = i2;
                            }
                            try {
                                this.Bxs.e(ehY);
                                i2 = vc;
                                break;
                            } catch (k e22) {
                                e = e22;
                                try {
                                    e.BzY = this;
                                    AppMethodBeat.o(121153);
                                    throw e;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if ((vc & 2) == 2) {
                                    }
                                    if ((vc & 4) == 4) {
                                    }
                                    if ((vc & 8) == 8) {
                                    }
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
                                        AppMethodBeat.o(121153);
                                    }
                                    eio();
                                    AppMethodBeat.o(121153);
                                    throw th;
                                }
                            } catch (IOException e6) {
                                e3 = e6;
                                e22 = new k(e3.getMessage());
                                e22.BzY = this;
                                AppMethodBeat.o(121153);
                                throw e22;
                            }
                            break;
                        case 24:
                            if ((i2 & 4) != 4) {
                                this.Bxt = new ArrayList();
                                vc = i2 | 4;
                            } else {
                                vc = i2;
                            }
                            this.Bxt.add(Integer.valueOf(eVar.vd()));
                            i2 = vc;
                            break;
                        case 26:
                            int fo = eVar.fo(eVar.vd());
                            if ((i2 & 4) == 4 || eVar.vg() <= 0) {
                                vc = i2;
                            } else {
                                this.Bxt = new ArrayList();
                                vc = i2 | 4;
                            }
                            while (eVar.vg() > 0) {
                                this.Bxt.add(Integer.valueOf(eVar.vd()));
                            }
                            eVar.fp(fo);
                            i2 = vc;
                            break;
                        case 34:
                            ehY = eVar.ehY();
                            if ((i2 & 8) != 8) {
                                this.Bxv = new n();
                                vc = i2 | 8;
                            } else {
                                vc = i2;
                            }
                            this.Bxv.e(ehY);
                            i2 = vc;
                            break;
                        case 42:
                            ehY = eVar.ehY();
                            if ((i2 & 16) != 16) {
                                this.Bxw = new n();
                                vc = i2 | 16;
                            } else {
                                vc = i2;
                            }
                            this.Bxw.e(ehY);
                            i2 = vc;
                            break;
                        case 48:
                            if ((i2 & 32) != 32) {
                                this.Bxx = new ArrayList();
                                vc = i2 | 32;
                            } else {
                                vc = i2;
                            }
                            this.Bxx.add(Integer.valueOf(eVar.vd()));
                            i2 = vc;
                            break;
                        case 50:
                            vc = eVar.fo(eVar.vd());
                            if ((i2 & 32) != 32 && eVar.vg() > 0) {
                                this.Bxx = new ArrayList();
                                i2 |= 32;
                            }
                            while (eVar.vg() > 0) {
                                this.Bxx.add(Integer.valueOf(eVar.vd()));
                            }
                            eVar.fp(vc);
                            break;
                        default:
                            if (!a(eVar, e4, gVar, vc)) {
                                i = 1;
                                break;
                            }
                            break;
                    }
                } catch (k e7) {
                    e = e7;
                    vc = i2;
                    e.BzY = this;
                    AppMethodBeat.o(121153);
                    throw e;
                } catch (IOException e8) {
                    e3 = e8;
                    vc = i2;
                    e22 = new k(e3.getMessage());
                    e22.BzY = this;
                    AppMethodBeat.o(121153);
                    throw e22;
                } catch (Throwable th4) {
                    th = th4;
                    vc = i2;
                    if ((vc & 2) == 2) {
                        this.Bxs = this.Bxs.eiA();
                    }
                    if ((vc & 4) == 4) {
                        this.Bxt = Collections.unmodifiableList(this.Bxt);
                    }
                    if ((vc & 8) == 8) {
                        this.Bxv = this.Bxv.eiA();
                    }
                    if ((vc & 16) == 16) {
                        this.Bxw = this.Bxw.eiA();
                    }
                    if ((vc & 32) == 32) {
                        this.Bxx = Collections.unmodifiableList(this.Bxx);
                    }
                    e4.flush();
                    this.BsB = ehS.ehW();
                    eio();
                    AppMethodBeat.o(121153);
                    throw th;
                }
            }
            if ((i2 & 2) == 2) {
                this.Bxs = this.Bxs.eiA();
            }
            if ((i2 & 4) == 4) {
                this.Bxt = Collections.unmodifiableList(this.Bxt);
            }
            if ((i2 & 8) == 8) {
                this.Bxv = this.Bxv.eiA();
            }
            if ((i2 & 16) == 16) {
                this.Bxw = this.Bxw.eiA();
            }
            if ((i2 & 32) == 32) {
                this.Bxx = Collections.unmodifiableList(this.Bxx);
            }
            try {
                e4.flush();
                this.BsB = ehS.ehW();
            } catch (IOException e9) {
                this.BsB = ehS.ehW();
            } catch (Throwable th5) {
                this.BsB = ehS.ehW();
                AppMethodBeat.o(121153);
            }
            eio();
            AppMethodBeat.o(121153);
        }

        static {
            AppMethodBeat.i(121162);
            c cVar = new c();
            Bxq = cVar;
            cVar.ecA();
            AppMethodBeat.o(121162);
        }

        public final s<c> ecy() {
            return BsC;
        }

        public final boolean egz() {
            return (this.BsD & 1) == 1;
        }

        public final String egA() {
            AppMethodBeat.i(121154);
            Object obj = this.Bxr;
            if (obj instanceof String) {
                String str = (String) obj;
                AppMethodBeat.o(121154);
                return str;
            }
            a.i.b.a.c.g.d dVar = (a.i.b.a.c.g.d) obj;
            String dlY = dVar.dlY();
            if (dVar.ehQ()) {
                this.Bxr = dlY;
            }
            AppMethodBeat.o(121154);
            return dlY;
        }

        private a.i.b.a.c.g.d egB() {
            AppMethodBeat.i(121155);
            Object obj = this.Bxr;
            a.i.b.a.c.g.d awc;
            if (obj instanceof String) {
                awc = a.i.b.a.c.g.d.awc((String) obj);
                this.Bxr = awc;
                AppMethodBeat.o(121155);
                return awc;
            }
            awc = (a.i.b.a.c.g.d) obj;
            AppMethodBeat.o(121155);
            return awc;
        }

        private void ecA() {
            AppMethodBeat.i(121156);
            this.Bxr = "";
            this.Bxs = n.BAf;
            this.Bxt = Collections.emptyList();
            this.Bxv = n.BAf;
            this.Bxw = n.BAf;
            this.Bxx = Collections.emptyList();
            AppMethodBeat.o(121156);
        }

        public final boolean isInitialized() {
            AppMethodBeat.i(121157);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.o(121157);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.o(121157);
                return false;
            } else if (egz()) {
                this.BsG = (byte) 1;
                AppMethodBeat.o(121157);
                return true;
            } else {
                this.BsG = (byte) 0;
                AppMethodBeat.o(121157);
                return false;
            }
        }

        public final void a(f fVar) {
            int i;
            int i2 = 0;
            AppMethodBeat.i(121158);
            vq();
            if ((this.BsD & 1) == 1) {
                fVar.a(1, egB());
            }
            for (i = 0; i < this.Bxs.size(); i++) {
                fVar.a(2, this.Bxs.UC(i));
            }
            if (this.Bxt.size() > 0) {
                fVar.fw(26);
                fVar.fw(this.Bxu);
            }
            for (int i3 = 0; i3 < this.Bxt.size(); i3++) {
                fVar.Uy(((Integer) this.Bxt.get(i3)).intValue());
            }
            for (i = 0; i < this.Bxv.size(); i++) {
                fVar.a(4, this.Bxv.UC(i));
            }
            for (i = 0; i < this.Bxw.size(); i++) {
                fVar.a(5, this.Bxw.UC(i));
            }
            if (this.Bxx.size() > 0) {
                fVar.fw(50);
                fVar.fw(this.Bxy);
            }
            while (i2 < this.Bxx.size()) {
                fVar.Uy(((Integer) this.Bxx.get(i2)).intValue());
                i2++;
            }
            fVar.d(this.BsB);
            AppMethodBeat.o(121158);
        }

        public final int vq() {
            AppMethodBeat.i(121159);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.o(121159);
                return i;
            }
            int i2;
            if ((this.BsD & 1) == 1) {
                i = f.b(1, egB()) + 0;
            } else {
                i = 0;
            }
            int i3 = 0;
            for (i2 = 0; i2 < this.Bxs.size(); i2++) {
                i3 += f.c(this.Bxs.UC(i2));
            }
            int size = (i + i3) + (this.Bxs.size() * 1);
            i3 = 0;
            for (i2 = 0; i2 < this.Bxt.size(); i2++) {
                i3 += f.ft(((Integer) this.Bxt.get(i2)).intValue());
            }
            i = size + i3;
            if (!this.Bxt.isEmpty()) {
                i = (i + 1) + f.ft(i3);
            }
            this.Bxu = i3;
            i3 = 0;
            for (i2 = 0; i2 < this.Bxv.size(); i2++) {
                i3 += f.c(this.Bxv.UC(i2));
            }
            i3 = (i + i3) + (this.Bxv.size() * 1);
            i2 = 0;
            for (i = 0; i < this.Bxw.size(); i++) {
                i2 += f.c(this.Bxw.UC(i));
            }
            size = (i3 + i2) + (this.Bxw.size() * 1);
            i2 = 0;
            i3 = 0;
            while (i2 < this.Bxx.size()) {
                i2++;
                i3 = f.ft(((Integer) this.Bxx.get(i2)).intValue()) + i3;
            }
            i = size + i3;
            if (!this.Bxx.isEmpty()) {
                i = (i + 1) + f.ft(i3);
            }
            this.Bxy = i3;
            i += this.BsB.size();
            this.BsH = i;
            AppMethodBeat.o(121159);
            return i;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecC() {
            AppMethodBeat.i(121160);
            a h = a.egJ().h(this);
            AppMethodBeat.o(121160);
            return h;
        }

        public final /* synthetic */ a.i.b.a.c.g.q.a ecD() {
            AppMethodBeat.i(121161);
            a egJ = a.egJ();
            AppMethodBeat.o(121161);
            return egJ;
        }

        public final /* bridge */ /* synthetic */ q ecE() {
            return Bxq;
        }
    }
}
