package p000a.p010i.p011b.p012a.p015c.p033e;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42464aa;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.C33279c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C33332f;
import com.tencent.view.C31128d;
import com.tencent.wcdb.FileUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p000a.p010i.p011b.p012a.p015c.p035g.C0114a.C0115a;
import p000a.p010i.p011b.p012a.p015c.p035g.C0117b;
import p000a.p010i.p011b.p012a.p015c.p035g.C17270r;
import p000a.p010i.p011b.p012a.p015c.p035g.C25155i;
import p000a.p010i.p011b.p012a.p015c.p035g.C25155i.C25157b;
import p000a.p010i.p011b.p012a.p015c.p035g.C25155i.C25158c;
import p000a.p010i.p011b.p012a.p015c.p035g.C25155i.C25158c.C8178a;
import p000a.p010i.p011b.p012a.p015c.p035g.C25155i.C25159a;
import p000a.p010i.p011b.p012a.p015c.p035g.C25155i.C8179d;
import p000a.p010i.p011b.p012a.p015c.p035g.C25163s;
import p000a.p010i.p011b.p012a.p015c.p035g.C31710d;
import p000a.p010i.p011b.p012a.p015c.p035g.C31710d.C31711b;
import p000a.p010i.p011b.p012a.p015c.p035g.C31713e;
import p000a.p010i.p011b.p012a.p015c.p035g.C31715g;
import p000a.p010i.p011b.p012a.p015c.p035g.C37024f;
import p000a.p010i.p011b.p012a.p015c.p035g.C37026o;
import p000a.p010i.p011b.p012a.p015c.p035g.C41425k;
import p000a.p010i.p011b.p012a.p015c.p035g.C44903n;
import p000a.p010i.p011b.p012a.p015c.p035g.C44904w;
import p000a.p010i.p011b.p012a.p015c.p035g.C8181j.C8182b;
import p000a.p010i.p011b.p012a.p015c.p035g.C8181j.C8183a;
import p000a.p010i.p011b.p012a.p015c.p035g.C8185q;
import p000a.p010i.p011b.p012a.p015c.p035g.C8185q.C8186a;

/* renamed from: a.i.b.a.c.e.a */
public final class C37009a {

    /* renamed from: a.i.b.a.c.e.a$p */
    public interface C0085p extends C8179d {
    }

    /* renamed from: a.i.b.a.c.e.a$q */
    public enum C0086q implements C8183a {
        DECLARATION(0),
        FAKE_OVERRIDE(1),
        DELEGATION(2),
        SYNTHESIZED(3);
        
        private static C8182b<C0086q> Btk;
        private final int value;

        /* renamed from: a.i.b.a.c.e.a$q$1 */
        static class C00871 implements C8182b<C0086q> {
            C00871() {
            }

            /* renamed from: SW */
            public final /* synthetic */ C8183a mo146SW(int i) {
                AppMethodBeat.m2504i(120669);
                C0086q Tp = C0086q.m131Tp(i);
                AppMethodBeat.m2505o(120669);
                return Tp;
            }
        }

        static {
            Btk = new C00871();
            AppMethodBeat.m2505o(120672);
        }

        public final int edd() {
            return this.value;
        }

        /* renamed from: Tp */
        public static C0086q m131Tp(int i) {
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

        private C0086q(int i) {
            this.value = i;
        }
    }

    /* renamed from: a.i.b.a.c.e.a$r */
    public enum C0088r implements C8183a {
        FINAL(0),
        OPEN(1),
        ABSTRACT(2),
        SEALED(3);
        
        private static C8182b<C0088r> Btk;
        private final int value;

        /* renamed from: a.i.b.a.c.e.a$r$1 */
        static class C00891 implements C8182b<C0088r> {
            C00891() {
            }

            /* renamed from: SW */
            public final /* synthetic */ C8183a mo146SW(int i) {
                AppMethodBeat.m2504i(120673);
                C0088r Tq = C0088r.m133Tq(i);
                AppMethodBeat.m2505o(120673);
                return Tq;
            }
        }

        static {
            Btk = new C00891();
            AppMethodBeat.m2505o(120676);
        }

        public final int edd() {
            return this.value;
        }

        /* renamed from: Tq */
        public static C0088r m133Tq(int i) {
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

        private C0088r(int i) {
            this.value = i;
        }
    }

    /* renamed from: a.i.b.a.c.e.a$t */
    public interface C0090t extends C8179d {
    }

    /* renamed from: a.i.b.a.c.e.a$s */
    public static final class C6143s extends C25158c<C6143s> implements C0090t {
        public static C25163s<C6143s> BsC = new C61441();
        private static final C6143s BuI;
        private final C31710d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        public C36999ag BtC;
        public C36655am BtE;
        public List<C31694o> Btw;
        public List<C36656u> Btx;
        public List<C17244ab> Bty;

        /* renamed from: a.i.b.a.c.e.a$s$1 */
        static class C61441 extends C0117b<C6143s> {
            C61441() {
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo157a(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120677);
                C6143s c6143s = new C6143s(c31713e, c31715g, (byte) 0);
                AppMethodBeat.m2505o(120677);
                return c6143s;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$s$a */
        public static final class C6145a extends C25157b<C6143s, C6145a> implements C0090t {
            private int BsD;
            private C36999ag BtC = C36999ag.efM();
            private C36655am BtE = C36655am.egi();
            private List<C31694o> Btw = Collections.emptyList();
            private List<C36656u> Btx = Collections.emptyList();
            private List<C17244ab> Bty = Collections.emptyList();

            /* renamed from: a */
            public final /* synthetic */ C25159a mo147a(C25155i c25155i) {
                AppMethodBeat.m2504i(120692);
                C6145a e = mo13659e((C6143s) c25155i);
                AppMethodBeat.m2505o(120692);
                return e;
            }

            /* renamed from: c */
            public final /* synthetic */ C0115a mo148c(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120694);
                C6145a n = m9726n(c31713e, c31715g);
                AppMethodBeat.m2505o(120694);
                return n;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.m2504i(120698);
                C6145a eev = eev();
                AppMethodBeat.m2505o(120698);
                return eev;
            }

            /* renamed from: d */
            public final /* synthetic */ C8186a mo150d(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120696);
                C6145a n = m9726n(c31713e, c31715g);
                AppMethodBeat.m2505o(120696);
                return n;
            }

            public final /* synthetic */ C25159a ecK() {
                AppMethodBeat.m2504i(120693);
                C6145a eev = eev();
                AppMethodBeat.m2505o(120693);
                return eev;
            }

            public final /* synthetic */ C0115a ecL() {
                AppMethodBeat.m2504i(120695);
                C6145a eev = eev();
                AppMethodBeat.m2505o(120695);
                return eev;
            }

            public final /* synthetic */ C25157b edA() {
                AppMethodBeat.m2504i(120689);
                C6145a eev = eev();
                AppMethodBeat.m2505o(120689);
                return eev;
            }

            private C6145a() {
                AppMethodBeat.m2504i(120678);
                AppMethodBeat.m2505o(120678);
            }

            private C6143s eew() {
                int i = 1;
                AppMethodBeat.m2504i(120680);
                C6143s c6143s = new C6143s((C25157b) this, (byte) 0);
                int i2 = this.BsD;
                if ((this.BsD & 1) == 1) {
                    this.Btw = Collections.unmodifiableList(this.Btw);
                    this.BsD &= -2;
                }
                c6143s.Btw = this.Btw;
                if ((this.BsD & 2) == 2) {
                    this.Btx = Collections.unmodifiableList(this.Btx);
                    this.BsD &= -3;
                }
                c6143s.Btx = this.Btx;
                if ((this.BsD & 4) == 4) {
                    this.Bty = Collections.unmodifiableList(this.Bty);
                    this.BsD &= -5;
                }
                c6143s.Bty = this.Bty;
                if ((i2 & 8) != 8) {
                    i = 0;
                }
                c6143s.BtC = this.BtC;
                if ((i2 & 16) == 16) {
                    i |= 2;
                }
                c6143s.BtE = this.BtE;
                c6143s.BsD = i;
                AppMethodBeat.m2505o(120680);
                return c6143s;
            }

            /* renamed from: e */
            public final C6145a mo13659e(C6143s c6143s) {
                AppMethodBeat.m2504i(120681);
                if (c6143s == C6143s.eeu()) {
                    AppMethodBeat.m2505o(120681);
                } else {
                    if (!c6143s.Btw.isEmpty()) {
                        if (this.Btw.isEmpty()) {
                            this.Btw = c6143s.Btw;
                            this.BsD &= -2;
                        } else {
                            edu();
                            this.Btw.addAll(c6143s.Btw);
                        }
                    }
                    if (!c6143s.Btx.isEmpty()) {
                        if (this.Btx.isEmpty()) {
                            this.Btx = c6143s.Btx;
                            this.BsD &= -3;
                        } else {
                            edv();
                            this.Btx.addAll(c6143s.Btx);
                        }
                    }
                    if (!c6143s.Bty.isEmpty()) {
                        if (this.Bty.isEmpty()) {
                            this.Bty = c6143s.Bty;
                            this.BsD &= -5;
                        } else {
                            edw();
                            this.Bty.addAll(c6143s.Bty);
                        }
                    }
                    if (c6143s.edl()) {
                        m9725c(c6143s.BtC);
                    }
                    if (c6143s.edm()) {
                        m9724b(c6143s.BtE);
                    }
                    mo42015a((C25158c) c6143s);
                    this.BsB = this.BsB.mo51672a(c6143s.BsB);
                    AppMethodBeat.m2505o(120681);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: n */
            private C6145a m9726n(C31713e c31713e, C31715g c31715g) {
                C6143s c6143s;
                Throwable th;
                AppMethodBeat.m2504i(120683);
                C6143s c6143s2 = null;
                try {
                    mo13659e((C6143s) C6143s.BsC.mo157a(c31713e, c31715g));
                    AppMethodBeat.m2505o(120683);
                    return this;
                } catch (C41425k e) {
                    C41425k c41425k = e;
                    c6143s = (C6143s) c41425k.BzY;
                    AppMethodBeat.m2505o(120683);
                    throw c41425k;
                } catch (Throwable th2) {
                    th = th2;
                    c6143s2 = c6143s;
                    if (c6143s2 != null) {
                    }
                    AppMethodBeat.m2505o(120683);
                    throw th;
                }
            }

            private void edu() {
                AppMethodBeat.m2504i(120684);
                if ((this.BsD & 1) != 1) {
                    this.Btw = new ArrayList(this.Btw);
                    this.BsD |= 1;
                }
                AppMethodBeat.m2505o(120684);
            }

            private void edv() {
                AppMethodBeat.m2504i(120685);
                if ((this.BsD & 2) != 2) {
                    this.Btx = new ArrayList(this.Btx);
                    this.BsD |= 2;
                }
                AppMethodBeat.m2505o(120685);
            }

            private void edw() {
                AppMethodBeat.m2504i(120686);
                if ((this.BsD & 4) != 4) {
                    this.Bty = new ArrayList(this.Bty);
                    this.BsD |= 4;
                }
                AppMethodBeat.m2505o(120686);
            }

            /* renamed from: c */
            private C6145a m9725c(C36999ag c36999ag) {
                AppMethodBeat.m2504i(120687);
                if ((this.BsD & 8) != 8 || this.BtC == C36999ag.efM()) {
                    this.BtC = c36999ag;
                } else {
                    this.BtC = C36999ag.m61815d(this.BtC).mo42006g(c36999ag).efP();
                }
                this.BsD |= 8;
                AppMethodBeat.m2505o(120687);
                return this;
            }

            /* renamed from: b */
            private C6145a m9724b(C36655am c36655am) {
                AppMethodBeat.m2504i(120688);
                if ((this.BsD & 16) != 16 || this.BtE == C36655am.egi()) {
                    this.BtE = c36655am;
                } else {
                    this.BtE = C36655am.m60755c(this.BtE).mo42008f(c36655am).egk();
                }
                this.BsD |= 16;
                AppMethodBeat.m2505o(120688);
                return this;
            }

            private C6145a eev() {
                AppMethodBeat.m2504i(120679);
                C6145a e = new C6145a().mo13659e(eew());
                AppMethodBeat.m2505o(120679);
                return e;
            }

            public final boolean isInitialized() {
                boolean z;
                AppMethodBeat.m2504i(120682);
                int i = 0;
                while (i < this.Btw.size()) {
                    if (((C31694o) this.Btw.get(i)).isInitialized()) {
                        i++;
                    } else {
                        AppMethodBeat.m2505o(120682);
                        return false;
                    }
                }
                i = 0;
                while (i < this.Btx.size()) {
                    if (((C36656u) this.Btx.get(i)).isInitialized()) {
                        i++;
                    } else {
                        AppMethodBeat.m2505o(120682);
                        return false;
                    }
                }
                i = 0;
                while (i < this.Bty.size()) {
                    if (((C17244ab) this.Bty.get(i)).isInitialized()) {
                        i++;
                    } else {
                        AppMethodBeat.m2505o(120682);
                        return false;
                    }
                }
                if ((this.BsD & 8) == 8) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && !this.BtC.isInitialized()) {
                    AppMethodBeat.m2505o(120682);
                    return false;
                } else if (this.BzI.isInitialized()) {
                    AppMethodBeat.m2505o(120682);
                    return true;
                } else {
                    AppMethodBeat.m2505o(120682);
                    return false;
                }
            }

            public final /* synthetic */ C8185q ecE() {
                AppMethodBeat.m2504i(120690);
                C6143s eeu = C6143s.eeu();
                AppMethodBeat.m2505o(120690);
                return eeu;
            }

            public final /* synthetic */ C25155i ecJ() {
                AppMethodBeat.m2504i(120691);
                C6143s eeu = C6143s.eeu();
                AppMethodBeat.m2505o(120691);
                return eeu;
            }

            public final /* synthetic */ C8185q ecM() {
                AppMethodBeat.m2504i(120697);
                C6143s eew = eew();
                if (eew.isInitialized()) {
                    AppMethodBeat.m2505o(120697);
                    return eew;
                }
                C44904w c44904w = new C44904w();
                AppMethodBeat.m2505o(120697);
                throw c44904w;
            }

            static /* synthetic */ C6145a eex() {
                AppMethodBeat.m2504i(120699);
                C6145a c6145a = new C6145a();
                AppMethodBeat.m2505o(120699);
                return c6145a;
            }
        }

        /* synthetic */ C6143s(C31713e c31713e, C31715g c31715g, byte b) {
            this(c31713e, c31715g);
        }

        private C6143s(C25157b<C6143s, ?> c25157b) {
            super(c25157b);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = c25157b.BsB;
        }

        private C6143s() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = C31710d.Bzq;
        }

        public static C6143s eeu() {
            return BuI;
        }

        private C6143s(C31713e c31713e, C31715g c31715g) {
            AppMethodBeat.m2504i(120700);
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            int i = 0;
            C31711b ehS = C31710d.ehS();
            C37024f e = C37024f.m61953e(ehS, 1);
            int i2 = 0;
            while (i2 == 0) {
                try {
                    int vc = c31713e.mo51692vc();
                    switch (vc) {
                        case 0:
                            i2 = 1;
                            break;
                        case 26:
                            if ((i & 1) != 1) {
                                this.Btw = new ArrayList();
                                i |= 1;
                            }
                            this.Btw.add(c31713e.mo51683a(C31694o.BsC, c31715g));
                            break;
                        case 34:
                            if ((i & 2) != 2) {
                                this.Btx = new ArrayList();
                                i |= 2;
                            }
                            this.Btx.add(c31713e.mo51683a(C36656u.BsC, c31715g));
                            break;
                        case 42:
                            if ((i & 4) != 4) {
                                this.Bty = new ArrayList();
                                i |= 4;
                            }
                            this.Bty.add(c31713e.mo51683a(C17244ab.BsC, c31715g));
                            break;
                        case 242:
                            C25141a d;
                            if ((this.BsD & 1) == 1) {
                                d = C36999ag.m61815d(this.BtC);
                            } else {
                                d = null;
                            }
                            this.BtC = (C36999ag) c31713e.mo51683a(C36999ag.BsC, c31715g);
                            if (d != null) {
                                d.mo42006g(this.BtC);
                                this.BtC = d.efP();
                            }
                            this.BsD |= 1;
                            break;
                        case C31128d.MIC_PTU_ZIPAI_SAPPORO /*258*/:
                            C25142a c;
                            if ((this.BsD & 2) == 2) {
                                c = C36655am.m60755c(this.BtE);
                            } else {
                                c = null;
                            }
                            this.BtE = (C36655am) c31713e.mo51683a(C36655am.BsC, c31715g);
                            if (c != null) {
                                c.mo42008f(this.BtE);
                                this.BtE = c.egk();
                            }
                            this.BsD |= 2;
                            break;
                        default:
                            if (!mo42012a(c31713e, e, c31715g, vc)) {
                                i2 = 1;
                                break;
                            }
                            break;
                    }
                } catch (C41425k e2) {
                    e2.BzY = this;
                    AppMethodBeat.m2505o(120700);
                    throw e2;
                } catch (IOException e3) {
                    C41425k c41425k = new C41425k(e3.getMessage());
                    c41425k.BzY = this;
                    AppMethodBeat.m2505o(120700);
                    throw c41425k;
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
                        AppMethodBeat.m2505o(120700);
                    }
                    this.BzI.eii();
                    AppMethodBeat.m2505o(120700);
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
                AppMethodBeat.m2505o(120700);
            }
            this.BzI.eii();
            AppMethodBeat.m2505o(120700);
        }

        static {
            AppMethodBeat.m2504i(120708);
            C6143s c6143s = new C6143s();
            BuI = c6143s;
            c6143s.ecA();
            AppMethodBeat.m2505o(120708);
        }

        public final C25163s<C6143s> ecy() {
            return BsC;
        }

        public final boolean edl() {
            return (this.BsD & 1) == 1;
        }

        public final boolean edm() {
            return (this.BsD & 2) == 2;
        }

        private void ecA() {
            AppMethodBeat.m2504i(120701);
            this.Btw = Collections.emptyList();
            this.Btx = Collections.emptyList();
            this.Bty = Collections.emptyList();
            this.BtC = C36999ag.efM();
            this.BtE = C36655am.egi();
            AppMethodBeat.m2505o(120701);
        }

        public final boolean isInitialized() {
            AppMethodBeat.m2504i(120702);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.m2505o(120702);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.m2505o(120702);
                return false;
            } else {
                int i = 0;
                while (i < this.Btw.size()) {
                    if (((C31694o) this.Btw.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120702);
                        return false;
                    }
                }
                i = 0;
                while (i < this.Btx.size()) {
                    if (((C36656u) this.Btx.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120702);
                        return false;
                    }
                }
                i = 0;
                while (i < this.Bty.size()) {
                    if (((C17244ab) this.Bty.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120702);
                        return false;
                    }
                }
                if (edl() && !this.BtC.isInitialized()) {
                    this.BsG = (byte) 0;
                    AppMethodBeat.m2505o(120702);
                    return false;
                } else if (this.BzI.isInitialized()) {
                    this.BsG = (byte) 1;
                    AppMethodBeat.m2505o(120702);
                    return true;
                } else {
                    this.BsG = (byte) 0;
                    AppMethodBeat.m2505o(120702);
                    return false;
                }
            }
        }

        /* renamed from: a */
        public final void mo128a(C37024f c37024f) {
            int i;
            int i2 = 0;
            AppMethodBeat.m2504i(120703);
            mo144vq();
            C8178a eip = eip();
            for (i = 0; i < this.Btw.size(); i++) {
                c37024f.mo59046a(3, (C8185q) this.Btw.get(i));
            }
            for (i = 0; i < this.Btx.size(); i++) {
                c37024f.mo59046a(4, (C8185q) this.Btx.get(i));
            }
            while (i2 < this.Bty.size()) {
                c37024f.mo59046a(5, (C8185q) this.Bty.get(i2));
                i2++;
            }
            if ((this.BsD & 1) == 1) {
                c37024f.mo59046a(30, this.BtC);
            }
            if ((this.BsD & 2) == 2) {
                c37024f.mo59046a(32, this.BtE);
            }
            eip.mo17990b(200, c37024f);
            c37024f.mo59056d(this.BsB);
            AppMethodBeat.m2505o(120703);
        }

        /* renamed from: vq */
        public final int mo144vq() {
            int i = 0;
            AppMethodBeat.m2504i(120704);
            int i2 = this.BsH;
            if (i2 != -1) {
                AppMethodBeat.m2505o(120704);
                return i2;
            }
            int i3;
            int i4 = 0;
            for (i3 = 0; i3 < this.Btw.size(); i3++) {
                i4 += C37024f.m61948c(3, (C8185q) this.Btw.get(i3));
            }
            for (i3 = 0; i3 < this.Btx.size(); i3++) {
                i4 += C37024f.m61948c(4, (C8185q) this.Btx.get(i3));
            }
            while (i < this.Bty.size()) {
                i4 += C37024f.m61948c(5, (C8185q) this.Bty.get(i));
                i++;
            }
            if ((this.BsD & 1) == 1) {
                i4 += C37024f.m61948c(30, this.BtC);
            }
            if ((this.BsD & 2) == 2) {
                i4 += C37024f.m61948c(32, this.BtE);
            }
            i2 = (this.BzI.mo31345vq() + i4) + this.BsB.size();
            this.BsH = i2;
            AppMethodBeat.m2505o(120704);
            return i2;
        }

        /* renamed from: c */
        public static C6143s m9717c(InputStream inputStream, C31715g c31715g) {
            AppMethodBeat.m2504i(120705);
            C6143s c6143s = (C6143s) BsC.mo190j(inputStream, c31715g);
            AppMethodBeat.m2505o(120705);
            return c6143s;
        }

        public final /* bridge */ /* synthetic */ C8185q ecE() {
            return BuI;
        }

        public final /* synthetic */ C8186a ecC() {
            AppMethodBeat.m2504i(120706);
            C6145a e = C6145a.eex().mo13659e(this);
            AppMethodBeat.m2505o(120706);
            return e;
        }

        public final /* synthetic */ C8186a ecD() {
            AppMethodBeat.m2504i(120707);
            C6145a eex = C6145a.eex();
            AppMethodBeat.m2505o(120707);
            return eex;
        }
    }

    /* renamed from: a.i.b.a.c.e.a$ai */
    public static final class C8154ai extends C25158c<C8154ai> implements C31684aj {
        public static C25163s<C8154ai> BsC = new C81561();
        private static final C8154ai BvO;
        private final C31710d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        public int BsW;
        public int Buf;
        public C25133aa BvP;
        public int BvQ;
        public C25133aa Bvo;
        public int Bvp;

        /* renamed from: a.i.b.a.c.e.a$ai$a */
        public static final class C8155a extends C25157b<C8154ai, C8155a> implements C31684aj {
            private int BsD;
            private int BsW;
            private int Buf;
            private C25133aa BvP = C25133aa.eeX();
            private int BvQ;
            private C25133aa Bvo = C25133aa.eeX();
            private int Bvp;

            /* renamed from: a */
            public final /* synthetic */ C25159a mo147a(C25155i c25155i) {
                AppMethodBeat.m2504i(120989);
                C8155a d = mo17955d((C8154ai) c25155i);
                AppMethodBeat.m2505o(120989);
                return d;
            }

            /* renamed from: c */
            public final /* synthetic */ C0115a mo148c(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120991);
                C8155a x = m14378x(c31713e, c31715g);
                AppMethodBeat.m2505o(120991);
                return x;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.m2504i(120995);
                C8155a efV = efV();
                AppMethodBeat.m2505o(120995);
                return efV;
            }

            /* renamed from: d */
            public final /* synthetic */ C8186a mo150d(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120993);
                C8155a x = m14378x(c31713e, c31715g);
                AppMethodBeat.m2505o(120993);
                return x;
            }

            public final /* synthetic */ C25159a ecK() {
                AppMethodBeat.m2504i(120990);
                C8155a efV = efV();
                AppMethodBeat.m2505o(120990);
                return efV;
            }

            public final /* synthetic */ C0115a ecL() {
                AppMethodBeat.m2504i(120992);
                C8155a efV = efV();
                AppMethodBeat.m2505o(120992);
                return efV;
            }

            public final /* synthetic */ C25157b edA() {
                AppMethodBeat.m2504i(120986);
                C8155a efV = efV();
                AppMethodBeat.m2505o(120986);
                return efV;
            }

            private C8155a() {
                AppMethodBeat.m2504i(120978);
                AppMethodBeat.m2505o(120978);
            }

            public final C8154ai efW() {
                int i = 1;
                AppMethodBeat.m2504i(120980);
                C8154ai c8154ai = new C8154ai((C25157b) this, (byte) 0);
                int i2 = this.BsD;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                c8154ai.BsW = this.BsW;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                c8154ai.Buf = this.Buf;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                c8154ai.Bvo = this.Bvo;
                if ((i2 & 8) == 8) {
                    i |= 8;
                }
                c8154ai.Bvp = this.Bvp;
                if ((i2 & 16) == 16) {
                    i |= 16;
                }
                c8154ai.BvP = this.BvP;
                if ((i2 & 32) == 32) {
                    i |= 32;
                }
                c8154ai.BvQ = this.BvQ;
                c8154ai.BsD = i;
                AppMethodBeat.m2505o(120980);
                return c8154ai;
            }

            /* renamed from: d */
            public final C8155a mo17955d(C8154ai c8154ai) {
                AppMethodBeat.m2504i(120981);
                if (c8154ai == C8154ai.efS()) {
                    AppMethodBeat.m2505o(120981);
                } else {
                    if (c8154ai.ecY()) {
                        m14372TV(c8154ai.BsW);
                    }
                    if (c8154ai.edW()) {
                        m14373TW(c8154ai.Buf);
                    }
                    if (c8154ai.ecP()) {
                        m14376p(c8154ai.Bvo);
                    }
                    if (c8154ai.efn()) {
                        m14374TX(c8154ai.Bvp);
                    }
                    if (c8154ai.efT()) {
                        m14377q(c8154ai.BvP);
                    }
                    if (c8154ai.efU()) {
                        m14375TY(c8154ai.BvQ);
                    }
                    mo42015a((C25158c) c8154ai);
                    this.BsB = this.BsB.mo51672a(c8154ai.BsB);
                    AppMethodBeat.m2505o(120981);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: x */
            private C8155a m14378x(C31713e c31713e, C31715g c31715g) {
                C8154ai c8154ai;
                Throwable th;
                AppMethodBeat.m2504i(120983);
                C8154ai c8154ai2 = null;
                try {
                    mo17955d((C8154ai) C8154ai.BsC.mo157a(c31713e, c31715g));
                    AppMethodBeat.m2505o(120983);
                    return this;
                } catch (C41425k e) {
                    C41425k c41425k = e;
                    c8154ai = (C8154ai) c41425k.BzY;
                    AppMethodBeat.m2505o(120983);
                    throw c41425k;
                } catch (Throwable th2) {
                    th = th2;
                    c8154ai2 = c8154ai;
                    if (c8154ai2 != null) {
                    }
                    AppMethodBeat.m2505o(120983);
                    throw th;
                }
            }

            /* renamed from: TV */
            private C8155a m14372TV(int i) {
                this.BsD |= 1;
                this.BsW = i;
                return this;
            }

            /* renamed from: TW */
            private C8155a m14373TW(int i) {
                this.BsD |= 2;
                this.Buf = i;
                return this;
            }

            /* renamed from: p */
            private C8155a m14376p(C25133aa c25133aa) {
                AppMethodBeat.m2504i(120984);
                if ((this.BsD & 4) != 4 || this.Bvo == C25133aa.eeX()) {
                    this.Bvo = c25133aa;
                } else {
                    this.Bvo = C25133aa.m39555f(this.Bvo).mo42000j(c25133aa).eft();
                }
                this.BsD |= 4;
                AppMethodBeat.m2505o(120984);
                return this;
            }

            /* renamed from: TX */
            private C8155a m14374TX(int i) {
                this.BsD |= 8;
                this.Bvp = i;
                return this;
            }

            /* renamed from: q */
            private C8155a m14377q(C25133aa c25133aa) {
                AppMethodBeat.m2504i(120985);
                if ((this.BsD & 16) != 16 || this.BvP == C25133aa.eeX()) {
                    this.BvP = c25133aa;
                } else {
                    this.BvP = C25133aa.m39555f(this.BvP).mo42000j(c25133aa).eft();
                }
                this.BsD |= 16;
                AppMethodBeat.m2505o(120985);
                return this;
            }

            /* renamed from: TY */
            private C8155a m14375TY(int i) {
                this.BsD |= 32;
                this.BvQ = i;
                return this;
            }

            private C8155a efV() {
                AppMethodBeat.m2504i(120979);
                C8155a d = new C8155a().mo17955d(efW());
                AppMethodBeat.m2505o(120979);
                return d;
            }

            public final boolean isInitialized() {
                boolean z;
                AppMethodBeat.m2504i(120982);
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
                            AppMethodBeat.m2505o(120982);
                            return false;
                        } else if (this.BzI.isInitialized()) {
                            AppMethodBeat.m2505o(120982);
                            return true;
                        } else {
                            AppMethodBeat.m2505o(120982);
                            return false;
                        }
                    }
                    AppMethodBeat.m2505o(120982);
                    return false;
                }
                AppMethodBeat.m2505o(120982);
                return false;
            }

            public final /* synthetic */ C8185q ecE() {
                AppMethodBeat.m2504i(120987);
                C8154ai efS = C8154ai.efS();
                AppMethodBeat.m2505o(120987);
                return efS;
            }

            public final /* synthetic */ C25155i ecJ() {
                AppMethodBeat.m2504i(120988);
                C8154ai efS = C8154ai.efS();
                AppMethodBeat.m2505o(120988);
                return efS;
            }

            public final /* synthetic */ C8185q ecM() {
                AppMethodBeat.m2504i(120994);
                C8154ai efW = efW();
                if (efW.isInitialized()) {
                    AppMethodBeat.m2505o(120994);
                    return efW;
                }
                C44904w c44904w = new C44904w();
                AppMethodBeat.m2505o(120994);
                throw c44904w;
            }

            static /* synthetic */ C8155a efX() {
                AppMethodBeat.m2504i(120996);
                C8155a c8155a = new C8155a();
                AppMethodBeat.m2505o(120996);
                return c8155a;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$ai$1 */
        static class C81561 extends C0117b<C8154ai> {
            C81561() {
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo157a(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120977);
                C8154ai c8154ai = new C8154ai(c31713e, c31715g, (byte) 0);
                AppMethodBeat.m2505o(120977);
                return c8154ai;
            }
        }

        /* synthetic */ C8154ai(C31713e c31713e, C31715g c31715g, byte b) {
            this(c31713e, c31715g);
        }

        private C8154ai(C25157b<C8154ai, ?> c25157b) {
            super(c25157b);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = c25157b.BsB;
        }

        private C8154ai() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = C31710d.Bzq;
        }

        public static C8154ai efS() {
            return BvO;
        }

        private C8154ai(C31713e c31713e, C31715g c31715g) {
            AppMethodBeat.m2504i(120997);
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            C31711b ehS = C31710d.ehS();
            C37024f e = C37024f.m61953e(ehS, 1);
            int i = 0;
            while (i == 0) {
                try {
                    int vc = c31713e.mo51692vc();
                    C25135c efk;
                    switch (vc) {
                        case 0:
                            i = 1;
                            break;
                        case 8:
                            this.BsD |= 1;
                            this.BsW = c31713e.mo51693vd();
                            break;
                        case 16:
                            this.BsD |= 2;
                            this.Buf = c31713e.mo51693vd();
                            break;
                        case 26:
                            if ((this.BsD & 4) == 4) {
                                efk = this.Bvo.efk();
                            } else {
                                efk = null;
                            }
                            this.Bvo = (C25133aa) c31713e.mo51683a(C25133aa.BsC, c31715g);
                            if (efk != null) {
                                efk.mo42000j(this.Bvo);
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
                            this.BvP = (C25133aa) c31713e.mo51683a(C25133aa.BsC, c31715g);
                            if (efk != null) {
                                efk.mo42000j(this.BvP);
                                this.BvP = efk.eft();
                            }
                            this.BsD |= 16;
                            break;
                        case 40:
                            this.BsD |= 8;
                            this.Bvp = c31713e.mo51693vd();
                            break;
                        case 48:
                            this.BsD |= 32;
                            this.BvQ = c31713e.mo51693vd();
                            break;
                        default:
                            if (!mo42012a(c31713e, e, c31715g, vc)) {
                                i = 1;
                                break;
                            }
                            break;
                    }
                } catch (C41425k e2) {
                    e2.BzY = this;
                    AppMethodBeat.m2505o(120997);
                    throw e2;
                } catch (IOException e3) {
                    C41425k c41425k = new C41425k(e3.getMessage());
                    c41425k.BzY = this;
                    AppMethodBeat.m2505o(120997);
                    throw c41425k;
                } catch (Throwable th) {
                    try {
                        e.flush();
                        this.BsB = ehS.ehW();
                    } catch (IOException e4) {
                        this.BsB = ehS.ehW();
                    } catch (Throwable th2) {
                        this.BsB = ehS.ehW();
                        AppMethodBeat.m2505o(120997);
                    }
                    this.BzI.eii();
                    AppMethodBeat.m2505o(120997);
                }
            }
            try {
                e.flush();
                this.BsB = ehS.ehW();
            } catch (IOException e5) {
                this.BsB = ehS.ehW();
            } catch (Throwable th3) {
                this.BsB = ehS.ehW();
                AppMethodBeat.m2505o(120997);
            }
            this.BzI.eii();
            AppMethodBeat.m2505o(120997);
        }

        static {
            AppMethodBeat.m2504i(121005);
            C8154ai c8154ai = new C8154ai();
            BvO = c8154ai;
            c8154ai.ecA();
            AppMethodBeat.m2505o(121005);
        }

        public final C25163s<C8154ai> ecy() {
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
            AppMethodBeat.m2504i(120998);
            this.BsW = 0;
            this.Buf = 0;
            this.Bvo = C25133aa.eeX();
            this.Bvp = 0;
            this.BvP = C25133aa.eeX();
            this.BvQ = 0;
            AppMethodBeat.m2505o(120998);
        }

        public final boolean isInitialized() {
            AppMethodBeat.m2504i(120999);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.m2505o(120999);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.m2505o(120999);
                return false;
            } else if (!edW()) {
                this.BsG = (byte) 0;
                AppMethodBeat.m2505o(120999);
                return false;
            } else if (ecP() && !this.Bvo.isInitialized()) {
                this.BsG = (byte) 0;
                AppMethodBeat.m2505o(120999);
                return false;
            } else if (efT() && !this.BvP.isInitialized()) {
                this.BsG = (byte) 0;
                AppMethodBeat.m2505o(120999);
                return false;
            } else if (this.BzI.isInitialized()) {
                this.BsG = (byte) 1;
                AppMethodBeat.m2505o(120999);
                return true;
            } else {
                this.BsG = (byte) 0;
                AppMethodBeat.m2505o(120999);
                return false;
            }
        }

        /* renamed from: a */
        public final void mo128a(C37024f c37024f) {
            AppMethodBeat.m2504i(121000);
            mo144vq();
            C8178a eip = eip();
            if ((this.BsD & 1) == 1) {
                c37024f.mo59052bq(1, this.BsW);
            }
            if ((this.BsD & 2) == 2) {
                c37024f.mo59052bq(2, this.Buf);
            }
            if ((this.BsD & 4) == 4) {
                c37024f.mo59046a(3, this.Bvo);
            }
            if ((this.BsD & 16) == 16) {
                c37024f.mo59046a(4, this.BvP);
            }
            if ((this.BsD & 8) == 8) {
                c37024f.mo59052bq(5, this.Bvp);
            }
            if ((this.BsD & 32) == 32) {
                c37024f.mo59052bq(6, this.BvQ);
            }
            eip.mo17990b(200, c37024f);
            c37024f.mo59056d(this.BsB);
            AppMethodBeat.m2505o(121000);
        }

        /* renamed from: vq */
        public final int mo144vq() {
            AppMethodBeat.m2504i(121001);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.m2505o(121001);
                return i;
            }
            i = 0;
            if ((this.BsD & 1) == 1) {
                i = C37024f.m61947bs(1, this.BsW) + 0;
            }
            if ((this.BsD & 2) == 2) {
                i += C37024f.m61947bs(2, this.Buf);
            }
            if ((this.BsD & 4) == 4) {
                i += C37024f.m61948c(3, this.Bvo);
            }
            if ((this.BsD & 16) == 16) {
                i += C37024f.m61948c(4, this.BvP);
            }
            if ((this.BsD & 8) == 8) {
                i += C37024f.m61947bs(5, this.Bvp);
            }
            if ((this.BsD & 32) == 32) {
                i += C37024f.m61947bs(6, this.BvQ);
            }
            i = (i + this.BzI.mo31345vq()) + this.BsB.size();
            this.BsH = i;
            AppMethodBeat.m2505o(121001);
            return i;
        }

        /* renamed from: b */
        public static C8155a m14365b(C8154ai c8154ai) {
            AppMethodBeat.m2504i(121002);
            C8155a d = C8155a.efX().mo17955d(c8154ai);
            AppMethodBeat.m2505o(121002);
            return d;
        }

        public final /* bridge */ /* synthetic */ C8185q ecE() {
            return BvO;
        }

        public final /* synthetic */ C8186a ecC() {
            AppMethodBeat.m2504i(121003);
            C8155a d = C8155a.efX().mo17955d(this);
            AppMethodBeat.m2505o(121003);
            return d;
        }

        public final /* synthetic */ C8186a ecD() {
            AppMethodBeat.m2504i(121004);
            C8155a efX = C8155a.efX();
            AppMethodBeat.m2505o(121004);
            return efX;
        }
    }

    /* renamed from: a.i.b.a.c.e.a$al */
    public interface C8157al extends C17270r {
    }

    /* renamed from: a.i.b.a.c.e.a$h */
    public interface C8159h extends C17270r {
    }

    /* renamed from: a.i.b.a.c.e.a$z */
    public interface C8166z extends C17270r {
    }

    /* renamed from: a.i.b.a.c.e.a$ak */
    public static final class C16485ak extends C25155i implements C8157al {
        public static C25163s<C16485ak> BsC = new C164881();
        private static final C16485ak BvR;
        private final C31710d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        public int BvS;
        public int BvT;
        public C16486b BvU;
        public int BvV;
        public int BvW;
        public C16489c BvX;

        /* renamed from: a.i.b.a.c.e.a$ak$b */
        public enum C16486b implements C8183a {
            WARNING(0),
            ERROR(1),
            HIDDEN(2);
            
            private static C8182b<C16486b> Btk;
            final int value;

            /* renamed from: a.i.b.a.c.e.a$ak$b$1 */
            static class C164871 implements C8182b<C16486b> {
                C164871() {
                }

                /* renamed from: SW */
                public final /* synthetic */ C8183a mo146SW(int i) {
                    AppMethodBeat.m2504i(121023);
                    C16486b Ud = C16486b.m25297Ud(i);
                    AppMethodBeat.m2505o(121023);
                    return Ud;
                }
            }

            static {
                Btk = new C164871();
                AppMethodBeat.m2505o(121026);
            }

            public final int edd() {
                return this.value;
            }

            /* renamed from: Ud */
            public static C16486b m25297Ud(int i) {
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

            private C16486b(int i) {
                this.value = i;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$ak$1 */
        static class C164881 extends C0117b<C16485ak> {
            C164881() {
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo157a(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(121006);
                C16485ak c16485ak = new C16485ak(c31713e, c31715g, (byte) 0);
                AppMethodBeat.m2505o(121006);
                return c16485ak;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$ak$c */
        public enum C16489c implements C8183a {
            LANGUAGE_VERSION(0),
            COMPILER_VERSION(1),
            API_VERSION(2);
            
            private static C8182b<C16489c> Btk;
            final int value;

            /* renamed from: a.i.b.a.c.e.a$ak$c$1 */
            static class C164901 implements C8182b<C16489c> {
                C164901() {
                }

                /* renamed from: SW */
                public final /* synthetic */ C8183a mo146SW(int i) {
                    AppMethodBeat.m2504i(121027);
                    C16489c Ue = C16489c.m25300Ue(i);
                    AppMethodBeat.m2505o(121027);
                    return Ue;
                }
            }

            static {
                Btk = new C164901();
                AppMethodBeat.m2505o(121030);
            }

            public final int edd() {
                return this.value;
            }

            /* renamed from: Ue */
            public static C16489c m25300Ue(int i) {
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

            private C16489c(int i) {
                this.value = i;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$ak$a */
        public static final class C16491a extends C25159a<C16485ak, C16491a> implements C8157al {
            private int BsD;
            private int BvS;
            private int BvT;
            private C16486b BvU = C16486b.ERROR;
            private int BvV;
            private int BvW;
            private C16489c BvX = C16489c.LANGUAGE_VERSION;

            /* renamed from: c */
            public final /* synthetic */ C0115a mo148c(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(121016);
                C16491a y = m25308y(c31713e, c31715g);
                AppMethodBeat.m2505o(121016);
                return y;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.m2504i(121021);
                C16491a egf = egf();
                AppMethodBeat.m2505o(121021);
                return egf;
            }

            /* renamed from: d */
            public final /* synthetic */ C8186a mo150d(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(121018);
                C16491a y = m25308y(c31713e, c31715g);
                AppMethodBeat.m2505o(121018);
                return y;
            }

            public final /* synthetic */ C25159a ecK() {
                AppMethodBeat.m2504i(121015);
                C16491a egf = egf();
                AppMethodBeat.m2505o(121015);
                return egf;
            }

            public final /* synthetic */ C0115a ecL() {
                AppMethodBeat.m2504i(121017);
                C16491a egf = egf();
                AppMethodBeat.m2505o(121017);
                return egf;
            }

            private C16491a() {
            }

            private C16485ak egg() {
                int i = 1;
                AppMethodBeat.m2504i(121008);
                C16485ak c16485ak = new C16485ak((C25159a) this, (byte) 0);
                int i2 = this.BsD;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                c16485ak.BvS = this.BvS;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                c16485ak.BvT = this.BvT;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                c16485ak.BvU = this.BvU;
                if ((i2 & 8) == 8) {
                    i |= 8;
                }
                c16485ak.BvV = this.BvV;
                if ((i2 & 16) == 16) {
                    i |= 16;
                }
                c16485ak.BvW = this.BvW;
                if ((i2 & 32) == 32) {
                    i |= 32;
                }
                c16485ak.BvX = this.BvX;
                c16485ak.BsD = i;
                AppMethodBeat.m2505o(121008);
                return c16485ak;
            }

            /* renamed from: b */
            public final C16491a mo30413b(C16485ak c16485ak) {
                AppMethodBeat.m2504i(121009);
                if (c16485ak == C16485ak.efY()) {
                    AppMethodBeat.m2505o(121009);
                } else {
                    if (c16485ak.efZ()) {
                        m25302TZ(c16485ak.BvS);
                    }
                    if (c16485ak.ega()) {
                        m25303Ua(c16485ak.BvT);
                    }
                    if (c16485ak.egb()) {
                        m25306a(c16485ak.BvU);
                    }
                    if (c16485ak.egc()) {
                        m25304Ub(c16485ak.BvV);
                    }
                    if (c16485ak.egd()) {
                        m25305Uc(c16485ak.BvW);
                    }
                    if (c16485ak.ege()) {
                        m25307a(c16485ak.BvX);
                    }
                    this.BsB = this.BsB.mo51672a(c16485ak.BsB);
                    AppMethodBeat.m2505o(121009);
                }
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: y */
            private C16491a m25308y(C31713e c31713e, C31715g c31715g) {
                C16485ak c16485ak;
                Throwable th;
                AppMethodBeat.m2504i(121010);
                C16485ak c16485ak2 = null;
                try {
                    mo30413b((C16485ak) C16485ak.BsC.mo157a(c31713e, c31715g));
                    AppMethodBeat.m2505o(121010);
                    return this;
                } catch (C41425k e) {
                    C41425k c41425k = e;
                    c16485ak = (C16485ak) c41425k.BzY;
                    AppMethodBeat.m2505o(121010);
                    throw c41425k;
                } catch (Throwable th2) {
                    th = th2;
                    c16485ak2 = c16485ak;
                    if (c16485ak2 != null) {
                    }
                    AppMethodBeat.m2505o(121010);
                    throw th;
                }
            }

            /* renamed from: TZ */
            private C16491a m25302TZ(int i) {
                this.BsD |= 1;
                this.BvS = i;
                return this;
            }

            /* renamed from: Ua */
            private C16491a m25303Ua(int i) {
                this.BsD |= 2;
                this.BvT = i;
                return this;
            }

            /* renamed from: a */
            private C16491a m25306a(C16486b c16486b) {
                AppMethodBeat.m2504i(121011);
                if (c16486b == null) {
                    NullPointerException nullPointerException = new NullPointerException();
                    AppMethodBeat.m2505o(121011);
                    throw nullPointerException;
                }
                this.BsD |= 4;
                this.BvU = c16486b;
                AppMethodBeat.m2505o(121011);
                return this;
            }

            /* renamed from: Ub */
            private C16491a m25304Ub(int i) {
                this.BsD |= 8;
                this.BvV = i;
                return this;
            }

            /* renamed from: Uc */
            private C16491a m25305Uc(int i) {
                this.BsD |= 16;
                this.BvW = i;
                return this;
            }

            /* renamed from: a */
            private C16491a m25307a(C16489c c16489c) {
                AppMethodBeat.m2504i(121012);
                if (c16489c == null) {
                    NullPointerException nullPointerException = new NullPointerException();
                    AppMethodBeat.m2505o(121012);
                    throw nullPointerException;
                }
                this.BsD |= 32;
                this.BvX = c16489c;
                AppMethodBeat.m2505o(121012);
                return this;
            }

            private C16491a egf() {
                AppMethodBeat.m2504i(121007);
                C16491a b = new C16491a().mo30413b(egg());
                AppMethodBeat.m2505o(121007);
                return b;
            }

            public final /* synthetic */ C25155i ecJ() {
                AppMethodBeat.m2504i(121013);
                C16485ak efY = C16485ak.efY();
                AppMethodBeat.m2505o(121013);
                return efY;
            }

            public final /* synthetic */ C8185q ecM() {
                AppMethodBeat.m2504i(121019);
                C16485ak egg = egg();
                if (egg.isInitialized()) {
                    AppMethodBeat.m2505o(121019);
                    return egg;
                }
                C44904w c44904w = new C44904w();
                AppMethodBeat.m2505o(121019);
                throw c44904w;
            }

            public final /* synthetic */ C8185q ecE() {
                AppMethodBeat.m2504i(121020);
                C16485ak efY = C16485ak.efY();
                AppMethodBeat.m2505o(121020);
                return efY;
            }

            static /* synthetic */ C16491a egh() {
                AppMethodBeat.m2504i(121022);
                C16491a c16491a = new C16491a();
                AppMethodBeat.m2505o(121022);
                return c16491a;
            }
        }

        /* synthetic */ C16485ak(C31713e c31713e, C31715g c31715g, byte b) {
            this(c31713e, c31715g);
        }

        private C16485ak(C25159a c25159a) {
            super((byte) 0);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = c25159a.BsB;
        }

        private C16485ak() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = C31710d.Bzq;
        }

        public static C16485ak efY() {
            return BvR;
        }

        private C16485ak(C31713e c31713e, C31715g c31715g) {
            AppMethodBeat.m2504i(121031);
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            C31711b ehS = C31710d.ehS();
            C37024f e = C37024f.m61953e(ehS, 1);
            int i = 0;
            while (i == 0) {
                try {
                    int vc = c31713e.mo51692vc();
                    int vd;
                    switch (vc) {
                        case 0:
                            i = 1;
                            break;
                        case 8:
                            this.BsD |= 1;
                            this.BvS = c31713e.mo51693vd();
                            break;
                        case 16:
                            this.BsD |= 2;
                            this.BvT = c31713e.mo51693vd();
                            break;
                        case 24:
                            vd = c31713e.mo51693vd();
                            C16486b Ud = C16486b.m25297Ud(vd);
                            if (Ud != null) {
                                this.BsD |= 4;
                                this.BvU = Ud;
                                break;
                            }
                            e.mo59058fw(vc);
                            e.mo59058fw(vd);
                            break;
                        case 32:
                            this.BsD |= 8;
                            this.BvV = c31713e.mo51693vd();
                            break;
                        case 40:
                            this.BsD |= 16;
                            this.BvW = c31713e.mo51693vd();
                            break;
                        case 48:
                            vd = c31713e.mo51693vd();
                            C16489c Ue = C16489c.m25300Ue(vd);
                            if (Ue != null) {
                                this.BsD |= 32;
                                this.BvX = Ue;
                                break;
                            }
                            e.mo59058fw(vc);
                            e.mo59058fw(vd);
                            break;
                        default:
                            if (!mo42012a(c31713e, e, c31715g, vc)) {
                                i = 1;
                                break;
                            }
                            break;
                    }
                } catch (C41425k e2) {
                    e2.BzY = this;
                    AppMethodBeat.m2505o(121031);
                    throw e2;
                } catch (IOException e3) {
                    C41425k c41425k = new C41425k(e3.getMessage());
                    c41425k.BzY = this;
                    AppMethodBeat.m2505o(121031);
                    throw c41425k;
                } catch (Throwable th) {
                    try {
                        e.flush();
                        this.BsB = ehS.ehW();
                    } catch (IOException e4) {
                        this.BsB = ehS.ehW();
                    } catch (Throwable th2) {
                        this.BsB = ehS.ehW();
                        AppMethodBeat.m2505o(121031);
                    }
                    eio();
                    AppMethodBeat.m2505o(121031);
                }
            }
            try {
                e.flush();
                this.BsB = ehS.ehW();
            } catch (IOException e5) {
                this.BsB = ehS.ehW();
            } catch (Throwable th3) {
                this.BsB = ehS.ehW();
                AppMethodBeat.m2505o(121031);
            }
            eio();
            AppMethodBeat.m2505o(121031);
        }

        static {
            AppMethodBeat.m2504i(121036);
            C16485ak c16485ak = new C16485ak();
            BvR = c16485ak;
            c16485ak.ecA();
            AppMethodBeat.m2505o(121036);
        }

        public final C25163s<C16485ak> ecy() {
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
            this.BvU = C16486b.ERROR;
            this.BvV = 0;
            this.BvW = 0;
            this.BvX = C16489c.LANGUAGE_VERSION;
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

        /* renamed from: a */
        public final void mo128a(C37024f c37024f) {
            AppMethodBeat.m2504i(121032);
            mo144vq();
            if ((this.BsD & 1) == 1) {
                c37024f.mo59052bq(1, this.BvS);
            }
            if ((this.BsD & 2) == 2) {
                c37024f.mo59052bq(2, this.BvT);
            }
            if ((this.BsD & 4) == 4) {
                c37024f.mo59059io(3, this.BvU.value);
            }
            if ((this.BsD & 8) == 8) {
                c37024f.mo59052bq(4, this.BvV);
            }
            if ((this.BsD & 16) == 16) {
                c37024f.mo59052bq(5, this.BvW);
            }
            if ((this.BsD & 32) == 32) {
                c37024f.mo59059io(6, this.BvX.value);
            }
            c37024f.mo59056d(this.BsB);
            AppMethodBeat.m2505o(121032);
        }

        /* renamed from: vq */
        public final int mo144vq() {
            AppMethodBeat.m2504i(121033);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.m2505o(121033);
                return i;
            }
            i = 0;
            if ((this.BsD & 1) == 1) {
                i = C37024f.m61947bs(1, this.BvS) + 0;
            }
            if ((this.BsD & 2) == 2) {
                i += C37024f.m61947bs(2, this.BvT);
            }
            if ((this.BsD & 4) == 4) {
                i += C37024f.m61957ip(3, this.BvU.value);
            }
            if ((this.BsD & 8) == 8) {
                i += C37024f.m61947bs(4, this.BvV);
            }
            if ((this.BsD & 16) == 16) {
                i += C37024f.m61947bs(5, this.BvW);
            }
            if ((this.BsD & 32) == 32) {
                i += C37024f.m61957ip(6, this.BvX.value);
            }
            i += this.BsB.size();
            this.BsH = i;
            AppMethodBeat.m2505o(121033);
            return i;
        }

        public final /* synthetic */ C8186a ecC() {
            AppMethodBeat.m2504i(121034);
            C16491a b = C16491a.egh().mo30413b(this);
            AppMethodBeat.m2505o(121034);
            return b;
        }

        public final /* synthetic */ C8186a ecD() {
            AppMethodBeat.m2504i(121035);
            C16491a egh = C16491a.egh();
            AppMethodBeat.m2505o(121035);
            return egh;
        }

        public final /* bridge */ /* synthetic */ C8185q ecE() {
            return BvR;
        }
    }

    /* renamed from: a.i.b.a.c.e.a$a */
    public static final class C17238a extends C25155i implements C25144b {
        private static final C17238a BsA;
        public static C25163s<C17238a> BsC = new C172431();
        private final C31710d BsB;
        private int BsD;
        public int BsE;
        public List<C17239a> BsF;
        private byte BsG;
        private int BsH;

        /* renamed from: a.i.b.a.c.e.a$a$b */
        public interface C8151b extends C17270r {
        }

        /* renamed from: a.i.b.a.c.e.a$a$a */
        public static final class C17239a extends C25155i implements C8151b {
            public static C25163s<C17239a> BsC = new C172411();
            private static final C17239a BsI;
            private final C31710d BsB;
            private int BsD;
            private byte BsG;
            private int BsH;
            public int BsJ;
            public C0079b BsK;

            /* renamed from: a.i.b.a.c.e.a$a$a$b */
            public static final class C0079b extends C25155i implements C17240c {
                public static C25163s<C0079b> BsC = new C00831();
                private static final C0079b BsL;
                private final C31710d BsB;
                private int BsD;
                private byte BsG;
                private int BsH;
                public C0080b BsM;
                public long BsN;
                public float BsO;
                public double BsP;
                public int BsQ;
                public int BsR;
                public int BsS;
                public C17238a BsT;
                public List<C0079b> BsU;
                public int BsV;
                public int BsW;

                /* renamed from: a.i.b.a.c.e.a$a$a$b$b */
                public enum C0080b implements C8183a {
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
                    
                    private static C8182b<C0080b> Btk;
                    final int value;

                    /* renamed from: a.i.b.a.c.e.a$a$a$b$b$1 */
                    static class C00811 implements C8182b<C0080b> {
                        C00811() {
                        }

                        /* renamed from: SW */
                        public final /* synthetic */ C8183a mo146SW(int i) {
                            AppMethodBeat.m2504i(120392);
                            C0080b SV = C0080b.m112SV(i);
                            AppMethodBeat.m2505o(120392);
                            return SV;
                        }
                    }

                    static {
                        Btk = new C00811();
                        AppMethodBeat.m2505o(120395);
                    }

                    public final int edd() {
                        return this.value;
                    }

                    /* renamed from: SV */
                    public static C0080b m112SV(int i) {
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

                    private C0080b(int i) {
                        this.value = i;
                    }
                }

                /* renamed from: a.i.b.a.c.e.a$a$a$b$a */
                public static final class C0082a extends C25159a<C0079b, C0082a> implements C17240c {
                    private int BsD;
                    private C0080b BsM = C0080b.BYTE;
                    private long BsN;
                    private float BsO;
                    private double BsP;
                    private int BsQ;
                    private int BsR;
                    private int BsS;
                    private C17238a BsT = C17238a.ecx();
                    private List<C0079b> BsU = Collections.emptyList();
                    private int BsV;
                    private int BsW;

                    /* renamed from: c */
                    public final /* synthetic */ C0115a mo148c(C31713e c31713e, C31715g c31715g) {
                        AppMethodBeat.m2504i(120385);
                        C0082a e = m123e(c31713e, c31715g);
                        AppMethodBeat.m2505o(120385);
                        return e;
                    }

                    public final /* synthetic */ Object clone() {
                        AppMethodBeat.m2504i(120390);
                        C0082a ecZ = ecZ();
                        AppMethodBeat.m2505o(120390);
                        return ecZ;
                    }

                    /* renamed from: d */
                    public final /* synthetic */ C8186a mo150d(C31713e c31713e, C31715g c31715g) {
                        AppMethodBeat.m2504i(120387);
                        C0082a e = m123e(c31713e, c31715g);
                        AppMethodBeat.m2505o(120387);
                        return e;
                    }

                    public final /* synthetic */ C25159a ecK() {
                        AppMethodBeat.m2504i(120384);
                        C0082a ecZ = ecZ();
                        AppMethodBeat.m2505o(120384);
                        return ecZ;
                    }

                    public final /* synthetic */ C0115a ecL() {
                        AppMethodBeat.m2504i(120386);
                        C0082a ecZ = ecZ();
                        AppMethodBeat.m2505o(120386);
                        return ecZ;
                    }

                    private C0082a() {
                        AppMethodBeat.m2504i(120373);
                        AppMethodBeat.m2505o(120373);
                    }

                    public final C0079b eda() {
                        int i = 1;
                        AppMethodBeat.m2504i(120375);
                        C0079b c0079b = new C0079b((C25159a) this, (byte) 0);
                        int i2 = this.BsD;
                        if ((i2 & 1) != 1) {
                            i = 0;
                        }
                        c0079b.BsM = this.BsM;
                        if ((i2 & 2) == 2) {
                            i |= 2;
                        }
                        c0079b.BsN = this.BsN;
                        if ((i2 & 4) == 4) {
                            i |= 4;
                        }
                        c0079b.BsO = this.BsO;
                        if ((i2 & 8) == 8) {
                            i |= 8;
                        }
                        c0079b.BsP = this.BsP;
                        if ((i2 & 16) == 16) {
                            i |= 16;
                        }
                        c0079b.BsQ = this.BsQ;
                        if ((i2 & 32) == 32) {
                            i |= 32;
                        }
                        c0079b.BsR = this.BsR;
                        if ((i2 & 64) == 64) {
                            i |= 64;
                        }
                        c0079b.BsS = this.BsS;
                        if ((i2 & 128) == 128) {
                            i |= 128;
                        }
                        c0079b.BsT = this.BsT;
                        if ((this.BsD & 256) == 256) {
                            this.BsU = Collections.unmodifiableList(this.BsU);
                            this.BsD &= -257;
                        }
                        c0079b.BsU = this.BsU;
                        if ((i2 & 512) == 512) {
                            i |= 256;
                        }
                        c0079b.BsV = this.BsV;
                        if ((i2 & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                            i |= 512;
                        }
                        c0079b.BsW = this.BsW;
                        c0079b.BsD = i;
                        AppMethodBeat.m2505o(120375);
                        return c0079b;
                    }

                    /* renamed from: e */
                    public final C0082a mo151e(C0079b c0079b) {
                        AppMethodBeat.m2504i(120376);
                        if (c0079b == C0079b.ecO()) {
                            AppMethodBeat.m2505o(120376);
                        } else {
                            if (c0079b.ecP()) {
                                m120a(c0079b.BsM);
                            }
                            if (c0079b.ecQ()) {
                                m124nR(c0079b.BsN);
                            }
                            if (c0079b.ecR()) {
                                m121by(c0079b.BsO);
                            }
                            if (c0079b.ecS()) {
                                m114I(c0079b.BsP);
                            }
                            if (c0079b.ecT()) {
                                m115SQ(c0079b.BsQ);
                            }
                            if (c0079b.ecU()) {
                                m116SR(c0079b.BsR);
                            }
                            if (c0079b.ecV()) {
                                m117SS(c0079b.BsS);
                            }
                            if (c0079b.ecW()) {
                                m122d(c0079b.BsT);
                            }
                            if (!c0079b.BsU.isEmpty()) {
                                if (this.BsU.isEmpty()) {
                                    this.BsU = c0079b.BsU;
                                    this.BsD &= -257;
                                } else {
                                    edb();
                                    this.BsU.addAll(c0079b.BsU);
                                }
                            }
                            if (c0079b.ecX()) {
                                m118ST(c0079b.BsV);
                            }
                            if (c0079b.ecY()) {
                                m119SU(c0079b.BsW);
                            }
                            this.BsB = this.BsB.mo51672a(c0079b.BsB);
                            AppMethodBeat.m2505o(120376);
                        }
                        return this;
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    /* renamed from: e */
                    private C0082a m123e(C31713e c31713e, C31715g c31715g) {
                        C0079b c0079b;
                        Throwable th;
                        AppMethodBeat.m2504i(120378);
                        C0079b c0079b2 = null;
                        try {
                            mo151e((C0079b) C0079b.BsC.mo157a(c31713e, c31715g));
                            AppMethodBeat.m2505o(120378);
                            return this;
                        } catch (C41425k e) {
                            C41425k c41425k = e;
                            c0079b = (C0079b) c41425k.BzY;
                            AppMethodBeat.m2505o(120378);
                            throw c41425k;
                        } catch (Throwable th2) {
                            th = th2;
                            c0079b2 = c0079b;
                            if (c0079b2 != null) {
                            }
                            AppMethodBeat.m2505o(120378);
                            throw th;
                        }
                    }

                    /* renamed from: a */
                    private C0082a m120a(C0080b c0080b) {
                        AppMethodBeat.m2504i(120379);
                        if (c0080b == null) {
                            NullPointerException nullPointerException = new NullPointerException();
                            AppMethodBeat.m2505o(120379);
                            throw nullPointerException;
                        }
                        this.BsD |= 1;
                        this.BsM = c0080b;
                        AppMethodBeat.m2505o(120379);
                        return this;
                    }

                    /* renamed from: nR */
                    private C0082a m124nR(long j) {
                        this.BsD |= 2;
                        this.BsN = j;
                        return this;
                    }

                    /* renamed from: by */
                    private C0082a m121by(float f) {
                        this.BsD |= 4;
                        this.BsO = f;
                        return this;
                    }

                    /* renamed from: I */
                    private C0082a m114I(double d) {
                        this.BsD |= 8;
                        this.BsP = d;
                        return this;
                    }

                    /* renamed from: SQ */
                    private C0082a m115SQ(int i) {
                        this.BsD |= 16;
                        this.BsQ = i;
                        return this;
                    }

                    /* renamed from: SR */
                    private C0082a m116SR(int i) {
                        this.BsD |= 32;
                        this.BsR = i;
                        return this;
                    }

                    /* renamed from: SS */
                    private C0082a m117SS(int i) {
                        this.BsD |= 64;
                        this.BsS = i;
                        return this;
                    }

                    /* renamed from: d */
                    private C0082a m122d(C17238a c17238a) {
                        AppMethodBeat.m2504i(120380);
                        if ((this.BsD & 128) != 128 || this.BsT == C17238a.ecx()) {
                            this.BsT = c17238a;
                        } else {
                            this.BsT = C17238a.m26639a(this.BsT).mo31301e(c17238a).edf();
                        }
                        this.BsD |= 128;
                        AppMethodBeat.m2505o(120380);
                        return this;
                    }

                    private void edb() {
                        AppMethodBeat.m2504i(120381);
                        if ((this.BsD & 256) != 256) {
                            this.BsU = new ArrayList(this.BsU);
                            this.BsD |= 256;
                        }
                        AppMethodBeat.m2505o(120381);
                    }

                    /* renamed from: ST */
                    private C0082a m118ST(int i) {
                        this.BsD |= 512;
                        this.BsV = i;
                        return this;
                    }

                    /* renamed from: SU */
                    private C0082a m119SU(int i) {
                        this.BsD |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                        this.BsW = i;
                        return this;
                    }

                    private C0082a ecZ() {
                        AppMethodBeat.m2504i(120374);
                        C0082a e = new C0082a().mo151e(eda());
                        AppMethodBeat.m2505o(120374);
                        return e;
                    }

                    public final boolean isInitialized() {
                        boolean z;
                        AppMethodBeat.m2504i(120377);
                        if ((this.BsD & 128) == 128) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z || this.BsT.isInitialized()) {
                            int i = 0;
                            while (i < this.BsU.size()) {
                                if (((C0079b) this.BsU.get(i)).isInitialized()) {
                                    i++;
                                } else {
                                    AppMethodBeat.m2505o(120377);
                                    return false;
                                }
                            }
                            AppMethodBeat.m2505o(120377);
                            return true;
                        }
                        AppMethodBeat.m2505o(120377);
                        return false;
                    }

                    public final /* synthetic */ C25155i ecJ() {
                        AppMethodBeat.m2504i(120382);
                        C0079b ecO = C0079b.ecO();
                        AppMethodBeat.m2505o(120382);
                        return ecO;
                    }

                    public final /* synthetic */ C8185q ecM() {
                        AppMethodBeat.m2504i(120388);
                        C0079b eda = eda();
                        if (eda.isInitialized()) {
                            AppMethodBeat.m2505o(120388);
                            return eda;
                        }
                        C44904w c44904w = new C44904w();
                        AppMethodBeat.m2505o(120388);
                        throw c44904w;
                    }

                    public final /* synthetic */ C8185q ecE() {
                        AppMethodBeat.m2504i(120389);
                        C0079b ecO = C0079b.ecO();
                        AppMethodBeat.m2505o(120389);
                        return ecO;
                    }

                    static /* synthetic */ C0082a edc() {
                        AppMethodBeat.m2504i(120391);
                        C0082a c0082a = new C0082a();
                        AppMethodBeat.m2505o(120391);
                        return c0082a;
                    }
                }

                /* renamed from: a.i.b.a.c.e.a$a$a$b$1 */
                static class C00831 extends C0117b<C0079b> {
                    C00831() {
                    }

                    /* renamed from: a */
                    public final /* synthetic */ Object mo157a(C31713e c31713e, C31715g c31715g) {
                        AppMethodBeat.m2504i(120372);
                        C0079b c0079b = new C0079b(c31713e, c31715g, (byte) 0);
                        AppMethodBeat.m2505o(120372);
                        return c0079b;
                    }
                }

                /* synthetic */ C0079b(C31713e c31713e, C31715g c31715g, byte b) {
                    this(c31713e, c31715g);
                }

                private C0079b(C25159a c25159a) {
                    super((byte) 0);
                    this.BsG = (byte) -1;
                    this.BsH = -1;
                    this.BsB = c25159a.BsB;
                }

                private C0079b() {
                    this.BsG = (byte) -1;
                    this.BsH = -1;
                    this.BsB = C31710d.Bzq;
                }

                public static C0079b ecO() {
                    return BsL;
                }

                private C0079b(C31713e c31713e, C31715g c31715g) {
                    AppMethodBeat.m2504i(120396);
                    this.BsG = (byte) -1;
                    this.BsH = -1;
                    ecA();
                    C31711b ehS = C31710d.ehS();
                    C37024f e = C37024f.m61953e(ehS, 1);
                    int i = 0;
                    int i2 = 0;
                    while (i == 0) {
                        try {
                            int vc = c31713e.mo51692vc();
                            switch (vc) {
                                case 0:
                                    i = 1;
                                    break;
                                case 8:
                                    int vd = c31713e.mo51693vd();
                                    C0080b SV = C0080b.m112SV(vd);
                                    if (SV != null) {
                                        this.BsD |= 1;
                                        this.BsM = SV;
                                        break;
                                    }
                                    e.mo59058fw(vc);
                                    e.mo59058fw(vd);
                                    break;
                                case 16:
                                    this.BsD |= 2;
                                    this.BsN = C31713e.m51328nS(c31713e.mo51694ve());
                                    break;
                                case 29:
                                    this.BsD |= 4;
                                    this.BsO = Float.intBitsToFloat(c31713e.eia());
                                    break;
                                case 33:
                                    this.BsD |= 8;
                                    this.BsP = Double.longBitsToDouble(c31713e.eib());
                                    break;
                                case 40:
                                    this.BsD |= 16;
                                    this.BsQ = c31713e.mo51693vd();
                                    break;
                                case 48:
                                    this.BsD |= 32;
                                    this.BsR = c31713e.mo51693vd();
                                    break;
                                case FileUtils.S_IRWXG /*56*/:
                                    this.BsD |= 64;
                                    this.BsS = c31713e.mo51693vd();
                                    break;
                                case 66:
                                    C17242c ecB;
                                    if ((this.BsD & 128) == 128) {
                                        ecB = this.BsT.ecB();
                                    } else {
                                        ecB = null;
                                    }
                                    this.BsT = (C17238a) c31713e.mo51683a(C17238a.BsC, c31715g);
                                    if (ecB != null) {
                                        ecB.mo31301e(this.BsT);
                                        this.BsT = ecB.edf();
                                    }
                                    this.BsD |= 128;
                                    break;
                                case 74:
                                    if ((i2 & 256) != 256) {
                                        this.BsU = new ArrayList();
                                        i2 |= 256;
                                    }
                                    this.BsU.add(c31713e.mo51683a(BsC, c31715g));
                                    break;
                                case 80:
                                    this.BsD |= 512;
                                    this.BsW = c31713e.mo51693vd();
                                    break;
                                case 88:
                                    this.BsD |= 256;
                                    this.BsV = c31713e.mo51693vd();
                                    break;
                                default:
                                    if (!mo42012a(c31713e, e, c31715g, vc)) {
                                        i = 1;
                                        break;
                                    }
                                    break;
                            }
                        } catch (C41425k e2) {
                            e2.BzY = this;
                            AppMethodBeat.m2505o(120396);
                            throw e2;
                        } catch (IOException e3) {
                            C41425k c41425k = new C41425k(e3.getMessage());
                            c41425k.BzY = this;
                            AppMethodBeat.m2505o(120396);
                            throw c41425k;
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
                                AppMethodBeat.m2505o(120396);
                            }
                            eio();
                            AppMethodBeat.m2505o(120396);
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
                        AppMethodBeat.m2505o(120396);
                    }
                    eio();
                    AppMethodBeat.m2505o(120396);
                }

                static {
                    AppMethodBeat.m2504i(120404);
                    C0079b c0079b = new C0079b();
                    BsL = c0079b;
                    c0079b.ecA();
                    AppMethodBeat.m2505o(120404);
                }

                public final C25163s<C0079b> ecy() {
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
                    AppMethodBeat.m2504i(120397);
                    this.BsM = C0080b.BYTE;
                    this.BsN = 0;
                    this.BsO = 0.0f;
                    this.BsP = 0.0d;
                    this.BsQ = 0;
                    this.BsR = 0;
                    this.BsS = 0;
                    this.BsT = C17238a.ecx();
                    this.BsU = Collections.emptyList();
                    this.BsV = 0;
                    this.BsW = 0;
                    AppMethodBeat.m2505o(120397);
                }

                public final boolean isInitialized() {
                    AppMethodBeat.m2504i(120398);
                    byte b = this.BsG;
                    if (b == (byte) 1) {
                        AppMethodBeat.m2505o(120398);
                        return true;
                    } else if (b == (byte) 0) {
                        AppMethodBeat.m2505o(120398);
                        return false;
                    } else if (!ecW() || this.BsT.isInitialized()) {
                        int i = 0;
                        while (i < this.BsU.size()) {
                            if (((C0079b) this.BsU.get(i)).isInitialized()) {
                                i++;
                            } else {
                                this.BsG = (byte) 0;
                                AppMethodBeat.m2505o(120398);
                                return false;
                            }
                        }
                        this.BsG = (byte) 1;
                        AppMethodBeat.m2505o(120398);
                        return true;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120398);
                        return false;
                    }
                }

                /* renamed from: a */
                public final void mo128a(C37024f c37024f) {
                    int i = 0;
                    AppMethodBeat.m2504i(120399);
                    mo144vq();
                    if ((this.BsD & 1) == 1) {
                        c37024f.mo59059io(1, this.BsM.value);
                    }
                    if ((this.BsD & 2) == 2) {
                        long j = this.BsN;
                        c37024f.mo59053bu(2, 0);
                        c37024f.mo59060nT(j);
                    }
                    if ((this.BsD & 4) == 4) {
                        float f = this.BsO;
                        c37024f.mo59053bu(3, 5);
                        c37024f.mo59054bz(f);
                    }
                    if ((this.BsD & 8) == 8) {
                        double d = this.BsP;
                        c37024f.mo59053bu(4, 1);
                        c37024f.mo59041J(d);
                    }
                    if ((this.BsD & 16) == 16) {
                        c37024f.mo59052bq(5, this.BsQ);
                    }
                    if ((this.BsD & 32) == 32) {
                        c37024f.mo59052bq(6, this.BsR);
                    }
                    if ((this.BsD & 64) == 64) {
                        c37024f.mo59052bq(7, this.BsS);
                    }
                    if ((this.BsD & 128) == 128) {
                        c37024f.mo59046a(8, this.BsT);
                    }
                    while (true) {
                        int i2 = i;
                        if (i2 >= this.BsU.size()) {
                            break;
                        }
                        c37024f.mo59046a(9, (C8185q) this.BsU.get(i2));
                        i = i2 + 1;
                    }
                    if ((this.BsD & 512) == 512) {
                        c37024f.mo59052bq(10, this.BsW);
                    }
                    if ((this.BsD & 256) == 256) {
                        c37024f.mo59052bq(11, this.BsV);
                    }
                    c37024f.mo59056d(this.BsB);
                    AppMethodBeat.m2505o(120399);
                }

                /* renamed from: vq */
                public final int mo144vq() {
                    int i = 0;
                    AppMethodBeat.m2504i(120400);
                    int i2 = this.BsH;
                    if (i2 != -1) {
                        AppMethodBeat.m2505o(120400);
                        return i2;
                    }
                    int i3;
                    if ((this.BsD & 1) == 1) {
                        i2 = C37024f.m61957ip(1, this.BsM.value) + 0;
                    } else {
                        i2 = 0;
                    }
                    if ((this.BsD & 2) == 2) {
                        i2 += C37024f.m61958nU(this.BsN);
                    }
                    if ((this.BsD & 4) == 4) {
                        i2 += C37024f.m61955fv(3) + 4;
                    }
                    if ((this.BsD & 8) == 8) {
                        i2 += C37024f.m61955fv(4) + 8;
                    }
                    if ((this.BsD & 16) == 16) {
                        i2 += C37024f.m61947bs(5, this.BsQ);
                    }
                    if ((this.BsD & 32) == 32) {
                        i2 += C37024f.m61947bs(6, this.BsR);
                    }
                    if ((this.BsD & 64) == 64) {
                        i2 += C37024f.m61947bs(7, this.BsS);
                    }
                    if ((this.BsD & 128) == 128) {
                        i2 += C37024f.m61948c(8, this.BsT);
                    }
                    while (true) {
                        i3 = i2;
                        if (i >= this.BsU.size()) {
                            break;
                        }
                        i2 = C37024f.m61948c(9, (C8185q) this.BsU.get(i)) + i3;
                        i++;
                    }
                    if ((this.BsD & 512) == 512) {
                        i3 += C37024f.m61947bs(10, this.BsW);
                    }
                    if ((this.BsD & 256) == 256) {
                        i3 += C37024f.m61947bs(11, this.BsV);
                    }
                    i2 = this.BsB.size() + i3;
                    this.BsH = i2;
                    AppMethodBeat.m2505o(120400);
                    return i2;
                }

                /* renamed from: b */
                public static C0082a m103b(C0079b c0079b) {
                    AppMethodBeat.m2504i(120401);
                    C0082a e = C0082a.edc().mo151e(c0079b);
                    AppMethodBeat.m2505o(120401);
                    return e;
                }

                public final /* synthetic */ C8186a ecC() {
                    AppMethodBeat.m2504i(120402);
                    C0082a e = C0082a.edc().mo151e(this);
                    AppMethodBeat.m2505o(120402);
                    return e;
                }

                public final /* synthetic */ C8186a ecD() {
                    AppMethodBeat.m2504i(120403);
                    C0082a edc = C0082a.edc();
                    AppMethodBeat.m2505o(120403);
                    return edc;
                }

                public final /* bridge */ /* synthetic */ C8185q ecE() {
                    return BsL;
                }
            }

            /* renamed from: a.i.b.a.c.e.a$a$a$a */
            public static final class C17237a extends C25159a<C17239a, C17237a> implements C8151b {
                private int BsD;
                private int BsJ;
                private C0079b BsK = C0079b.ecO();

                /* renamed from: c */
                public final /* synthetic */ C0115a mo148c(C31713e c31713e, C31715g c31715g) {
                    AppMethodBeat.m2504i(120365);
                    C17237a b = m26633b(c31713e, c31715g);
                    AppMethodBeat.m2505o(120365);
                    return b;
                }

                public final /* synthetic */ Object clone() {
                    AppMethodBeat.m2504i(120370);
                    C17237a ecH = ecH();
                    AppMethodBeat.m2505o(120370);
                    return ecH;
                }

                /* renamed from: d */
                public final /* synthetic */ C8186a mo150d(C31713e c31713e, C31715g c31715g) {
                    AppMethodBeat.m2504i(120367);
                    C17237a b = m26633b(c31713e, c31715g);
                    AppMethodBeat.m2505o(120367);
                    return b;
                }

                public final /* synthetic */ C25159a ecK() {
                    AppMethodBeat.m2504i(120364);
                    C17237a ecH = ecH();
                    AppMethodBeat.m2505o(120364);
                    return ecH;
                }

                public final /* synthetic */ C0115a ecL() {
                    AppMethodBeat.m2504i(120366);
                    C17237a ecH = ecH();
                    AppMethodBeat.m2505o(120366);
                    return ecH;
                }

                private C17237a() {
                    AppMethodBeat.m2504i(120355);
                    AppMethodBeat.m2505o(120355);
                }

                private C17239a ecI() {
                    int i = 1;
                    AppMethodBeat.m2504i(120357);
                    C17239a c17239a = new C17239a((C25159a) this, (byte) 0);
                    int i2 = this.BsD;
                    if ((i2 & 1) != 1) {
                        i = 0;
                    }
                    c17239a.BsJ = this.BsJ;
                    if ((i2 & 2) == 2) {
                        i |= 2;
                    }
                    c17239a.BsK = this.BsK;
                    c17239a.BsD = i;
                    AppMethodBeat.m2505o(120357);
                    return c17239a;
                }

                /* renamed from: b */
                public final C17237a mo31295b(C17239a c17239a) {
                    AppMethodBeat.m2504i(120358);
                    if (c17239a == C17239a.ecF()) {
                        AppMethodBeat.m2505o(120358);
                    } else {
                        if (c17239a.ecG()) {
                            m26631SP(c17239a.BsJ);
                        }
                        if (c17239a.hasValue()) {
                            m26632a(c17239a.BsK);
                        }
                        this.BsB = this.BsB.mo51672a(c17239a.BsB);
                        AppMethodBeat.m2505o(120358);
                    }
                    return this;
                }

                /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                /* renamed from: b */
                private C17237a m26633b(C31713e c31713e, C31715g c31715g) {
                    C17239a c17239a;
                    Throwable th;
                    AppMethodBeat.m2504i(120360);
                    C17239a c17239a2 = null;
                    try {
                        mo31295b((C17239a) C17239a.BsC.mo157a(c31713e, c31715g));
                        AppMethodBeat.m2505o(120360);
                        return this;
                    } catch (C41425k e) {
                        C41425k c41425k = e;
                        c17239a = (C17239a) c41425k.BzY;
                        AppMethodBeat.m2505o(120360);
                        throw c41425k;
                    } catch (Throwable th2) {
                        th = th2;
                        c17239a2 = c17239a;
                        if (c17239a2 != null) {
                        }
                        AppMethodBeat.m2505o(120360);
                        throw th;
                    }
                }

                /* renamed from: SP */
                private C17237a m26631SP(int i) {
                    this.BsD |= 1;
                    this.BsJ = i;
                    return this;
                }

                /* renamed from: a */
                private C17237a m26632a(C0079b c0079b) {
                    AppMethodBeat.m2504i(120361);
                    if ((this.BsD & 2) != 2 || this.BsK == C0079b.ecO()) {
                        this.BsK = c0079b;
                    } else {
                        this.BsK = C0079b.m103b(this.BsK).mo151e(c0079b).eda();
                    }
                    this.BsD |= 2;
                    AppMethodBeat.m2505o(120361);
                    return this;
                }

                private C17237a ecH() {
                    AppMethodBeat.m2504i(120356);
                    C17237a b = new C17237a().mo31295b(ecI());
                    AppMethodBeat.m2505o(120356);
                    return b;
                }

                public final boolean isInitialized() {
                    boolean z;
                    AppMethodBeat.m2504i(120359);
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
                            AppMethodBeat.m2505o(120359);
                            return false;
                        } else if (this.BsK.isInitialized()) {
                            AppMethodBeat.m2505o(120359);
                            return true;
                        } else {
                            AppMethodBeat.m2505o(120359);
                            return false;
                        }
                    }
                    AppMethodBeat.m2505o(120359);
                    return false;
                }

                public final /* synthetic */ C25155i ecJ() {
                    AppMethodBeat.m2504i(120362);
                    C17239a ecF = C17239a.ecF();
                    AppMethodBeat.m2505o(120362);
                    return ecF;
                }

                public final /* synthetic */ C8185q ecM() {
                    AppMethodBeat.m2504i(120368);
                    C17239a ecI = ecI();
                    if (ecI.isInitialized()) {
                        AppMethodBeat.m2505o(120368);
                        return ecI;
                    }
                    C44904w c44904w = new C44904w();
                    AppMethodBeat.m2505o(120368);
                    throw c44904w;
                }

                public final /* synthetic */ C8185q ecE() {
                    AppMethodBeat.m2504i(120369);
                    C17239a ecF = C17239a.ecF();
                    AppMethodBeat.m2505o(120369);
                    return ecF;
                }

                static /* synthetic */ C17237a ecN() {
                    AppMethodBeat.m2504i(120371);
                    C17237a c17237a = new C17237a();
                    AppMethodBeat.m2505o(120371);
                    return c17237a;
                }
            }

            /* renamed from: a.i.b.a.c.e.a$a$a$c */
            public interface C17240c extends C17270r {
            }

            /* renamed from: a.i.b.a.c.e.a$a$a$1 */
            static class C172411 extends C0117b<C17239a> {
                C172411() {
                }

                /* renamed from: a */
                public final /* synthetic */ Object mo157a(C31713e c31713e, C31715g c31715g) {
                    AppMethodBeat.m2504i(120354);
                    C17239a c17239a = new C17239a(c31713e, c31715g, (byte) 0);
                    AppMethodBeat.m2505o(120354);
                    return c17239a;
                }
            }

            /* synthetic */ C17239a(C31713e c31713e, C31715g c31715g, byte b) {
                this(c31713e, c31715g);
            }

            private C17239a(C25159a c25159a) {
                super((byte) 0);
                this.BsG = (byte) -1;
                this.BsH = -1;
                this.BsB = c25159a.BsB;
            }

            private C17239a() {
                this.BsG = (byte) -1;
                this.BsH = -1;
                this.BsB = C31710d.Bzq;
            }

            public static C17239a ecF() {
                return BsI;
            }

            private C17239a(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120405);
                this.BsG = (byte) -1;
                this.BsH = -1;
                ecA();
                C31711b ehS = C31710d.ehS();
                C37024f e = C37024f.m61953e(ehS, 1);
                int i = 0;
                while (i == 0) {
                    try {
                        int vc = c31713e.mo51692vc();
                        switch (vc) {
                            case 0:
                                i = 1;
                                break;
                            case 8:
                                this.BsD |= 1;
                                this.BsJ = c31713e.mo51693vd();
                                break;
                            case 18:
                                C0082a b;
                                if ((this.BsD & 2) == 2) {
                                    b = C0079b.m103b(this.BsK);
                                } else {
                                    b = null;
                                }
                                this.BsK = (C0079b) c31713e.mo51683a(C0079b.BsC, c31715g);
                                if (b != null) {
                                    b.mo151e(this.BsK);
                                    this.BsK = b.eda();
                                }
                                this.BsD |= 2;
                                break;
                            default:
                                if (!mo42012a(c31713e, e, c31715g, vc)) {
                                    i = 1;
                                    break;
                                }
                                break;
                        }
                    } catch (C41425k e2) {
                        e2.BzY = this;
                        AppMethodBeat.m2505o(120405);
                        throw e2;
                    } catch (IOException e3) {
                        C41425k c41425k = new C41425k(e3.getMessage());
                        c41425k.BzY = this;
                        AppMethodBeat.m2505o(120405);
                        throw c41425k;
                    } catch (Throwable th) {
                        try {
                            e.flush();
                            this.BsB = ehS.ehW();
                        } catch (IOException e4) {
                            this.BsB = ehS.ehW();
                        } catch (Throwable th2) {
                            this.BsB = ehS.ehW();
                            AppMethodBeat.m2505o(120405);
                        }
                        eio();
                        AppMethodBeat.m2505o(120405);
                    }
                }
                try {
                    e.flush();
                    this.BsB = ehS.ehW();
                } catch (IOException e5) {
                    this.BsB = ehS.ehW();
                } catch (Throwable th3) {
                    this.BsB = ehS.ehW();
                    AppMethodBeat.m2505o(120405);
                }
                eio();
                AppMethodBeat.m2505o(120405);
            }

            static {
                AppMethodBeat.m2504i(120412);
                C17239a c17239a = new C17239a();
                BsI = c17239a;
                c17239a.ecA();
                AppMethodBeat.m2505o(120412);
            }

            public final C25163s<C17239a> ecy() {
                return BsC;
            }

            public final boolean ecG() {
                return (this.BsD & 1) == 1;
            }

            public final boolean hasValue() {
                return (this.BsD & 2) == 2;
            }

            private void ecA() {
                AppMethodBeat.m2504i(120406);
                this.BsJ = 0;
                this.BsK = C0079b.ecO();
                AppMethodBeat.m2505o(120406);
            }

            public final boolean isInitialized() {
                AppMethodBeat.m2504i(120407);
                byte b = this.BsG;
                if (b == (byte) 1) {
                    AppMethodBeat.m2505o(120407);
                    return true;
                } else if (b == (byte) 0) {
                    AppMethodBeat.m2505o(120407);
                    return false;
                } else if (!ecG()) {
                    this.BsG = (byte) 0;
                    AppMethodBeat.m2505o(120407);
                    return false;
                } else if (!hasValue()) {
                    this.BsG = (byte) 0;
                    AppMethodBeat.m2505o(120407);
                    return false;
                } else if (this.BsK.isInitialized()) {
                    this.BsG = (byte) 1;
                    AppMethodBeat.m2505o(120407);
                    return true;
                } else {
                    this.BsG = (byte) 0;
                    AppMethodBeat.m2505o(120407);
                    return false;
                }
            }

            /* renamed from: a */
            public final void mo128a(C37024f c37024f) {
                AppMethodBeat.m2504i(120408);
                mo144vq();
                if ((this.BsD & 1) == 1) {
                    c37024f.mo59052bq(1, this.BsJ);
                }
                if ((this.BsD & 2) == 2) {
                    c37024f.mo59046a(2, this.BsK);
                }
                c37024f.mo59056d(this.BsB);
                AppMethodBeat.m2505o(120408);
            }

            /* renamed from: vq */
            public final int mo144vq() {
                AppMethodBeat.m2504i(120409);
                int i = this.BsH;
                if (i != -1) {
                    AppMethodBeat.m2505o(120409);
                    return i;
                }
                i = 0;
                if ((this.BsD & 1) == 1) {
                    i = C37024f.m61947bs(1, this.BsJ) + 0;
                }
                if ((this.BsD & 2) == 2) {
                    i += C37024f.m61948c(2, this.BsK);
                }
                i += this.BsB.size();
                this.BsH = i;
                AppMethodBeat.m2505o(120409);
                return i;
            }

            public final /* synthetic */ C8186a ecC() {
                AppMethodBeat.m2504i(120410);
                C17237a b = C17237a.ecN().mo31295b(this);
                AppMethodBeat.m2505o(120410);
                return b;
            }

            public final /* synthetic */ C8186a ecD() {
                AppMethodBeat.m2504i(120411);
                C17237a ecN = C17237a.ecN();
                AppMethodBeat.m2505o(120411);
                return ecN;
            }

            public final /* bridge */ /* synthetic */ C8185q ecE() {
                return BsI;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$a$c */
        public static final class C17242c extends C25159a<C17238a, C17242c> implements C25144b {
            private int BsD;
            private int BsE;
            private List<C17239a> BsF = Collections.emptyList();

            /* renamed from: a */
            public final /* synthetic */ C25159a mo147a(C25155i c25155i) {
                AppMethodBeat.m2504i(120421);
                C17242c e = mo31301e((C17238a) c25155i);
                AppMethodBeat.m2505o(120421);
                return e;
            }

            /* renamed from: c */
            public final /* synthetic */ C0115a mo148c(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120423);
                C17242c f = m26654f(c31713e, c31715g);
                AppMethodBeat.m2505o(120423);
                return f;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.m2504i(120428);
                C17242c ede = ede();
                AppMethodBeat.m2505o(120428);
                return ede;
            }

            /* renamed from: d */
            public final /* synthetic */ C8186a mo150d(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120425);
                C17242c f = m26654f(c31713e, c31715g);
                AppMethodBeat.m2505o(120425);
                return f;
            }

            public final /* synthetic */ C25159a ecK() {
                AppMethodBeat.m2504i(120422);
                C17242c ede = ede();
                AppMethodBeat.m2505o(120422);
                return ede;
            }

            public final /* synthetic */ C0115a ecL() {
                AppMethodBeat.m2504i(120424);
                C17242c ede = ede();
                AppMethodBeat.m2505o(120424);
                return ede;
            }

            private C17242c() {
                AppMethodBeat.m2504i(120413);
                AppMethodBeat.m2505o(120413);
            }

            public final C17238a edf() {
                int i = 1;
                AppMethodBeat.m2504i(120415);
                C17238a c17238a = new C17238a((C25159a) this, (byte) 0);
                if ((this.BsD & 1) != 1) {
                    i = 0;
                }
                c17238a.BsE = this.BsE;
                if ((this.BsD & 2) == 2) {
                    this.BsF = Collections.unmodifiableList(this.BsF);
                    this.BsD &= -3;
                }
                c17238a.BsF = this.BsF;
                c17238a.BsD = i;
                AppMethodBeat.m2505o(120415);
                return c17238a;
            }

            /* renamed from: e */
            public final C17242c mo31301e(C17238a c17238a) {
                AppMethodBeat.m2504i(120416);
                if (c17238a == C17238a.ecx()) {
                    AppMethodBeat.m2505o(120416);
                } else {
                    if (c17238a.ecz()) {
                        m26653SX(c17238a.BsE);
                    }
                    if (!c17238a.BsF.isEmpty()) {
                        if (this.BsF.isEmpty()) {
                            this.BsF = c17238a.BsF;
                            this.BsD &= -3;
                        } else {
                            edg();
                            this.BsF.addAll(c17238a.BsF);
                        }
                    }
                    this.BsB = this.BsB.mo51672a(c17238a.BsB);
                    AppMethodBeat.m2505o(120416);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: f */
            private C17242c m26654f(C31713e c31713e, C31715g c31715g) {
                C17238a c17238a;
                Throwable th;
                AppMethodBeat.m2504i(120418);
                C17238a c17238a2 = null;
                try {
                    mo31301e((C17238a) C17238a.BsC.mo157a(c31713e, c31715g));
                    AppMethodBeat.m2505o(120418);
                    return this;
                } catch (C41425k e) {
                    C41425k c41425k = e;
                    c17238a = (C17238a) c41425k.BzY;
                    AppMethodBeat.m2505o(120418);
                    throw c41425k;
                } catch (Throwable th2) {
                    th = th2;
                    c17238a2 = c17238a;
                    if (c17238a2 != null) {
                    }
                    AppMethodBeat.m2505o(120418);
                    throw th;
                }
            }

            /* renamed from: SX */
            private C17242c m26653SX(int i) {
                this.BsD |= 1;
                this.BsE = i;
                return this;
            }

            private void edg() {
                AppMethodBeat.m2504i(120419);
                if ((this.BsD & 2) != 2) {
                    this.BsF = new ArrayList(this.BsF);
                    this.BsD |= 2;
                }
                AppMethodBeat.m2505o(120419);
            }

            private C17242c ede() {
                AppMethodBeat.m2504i(120414);
                C17242c e = new C17242c().mo31301e(edf());
                AppMethodBeat.m2505o(120414);
                return e;
            }

            public final boolean isInitialized() {
                boolean z;
                AppMethodBeat.m2504i(120417);
                if ((this.BsD & 1) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    int i = 0;
                    while (i < this.BsF.size()) {
                        if (((C17239a) this.BsF.get(i)).isInitialized()) {
                            i++;
                        } else {
                            AppMethodBeat.m2505o(120417);
                            return false;
                        }
                    }
                    AppMethodBeat.m2505o(120417);
                    return true;
                }
                AppMethodBeat.m2505o(120417);
                return false;
            }

            public final /* synthetic */ C25155i ecJ() {
                AppMethodBeat.m2504i(120420);
                C17238a ecx = C17238a.ecx();
                AppMethodBeat.m2505o(120420);
                return ecx;
            }

            public final /* synthetic */ C8185q ecM() {
                AppMethodBeat.m2504i(120426);
                C17238a edf = edf();
                if (edf.isInitialized()) {
                    AppMethodBeat.m2505o(120426);
                    return edf;
                }
                C44904w c44904w = new C44904w();
                AppMethodBeat.m2505o(120426);
                throw c44904w;
            }

            public final /* synthetic */ C8185q ecE() {
                AppMethodBeat.m2504i(120427);
                C17238a ecx = C17238a.ecx();
                AppMethodBeat.m2505o(120427);
                return ecx;
            }

            static /* synthetic */ C17242c edh() {
                AppMethodBeat.m2504i(120429);
                C17242c c17242c = new C17242c();
                AppMethodBeat.m2505o(120429);
                return c17242c;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$a$1 */
        static class C172431 extends C0117b<C17238a> {
            C172431() {
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo157a(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120353);
                C17238a c17238a = new C17238a(c31713e, c31715g, (byte) 0);
                AppMethodBeat.m2505o(120353);
                return c17238a;
            }
        }

        /* synthetic */ C17238a(C31713e c31713e, C31715g c31715g, byte b) {
            this(c31713e, c31715g);
        }

        public final /* synthetic */ C8186a ecC() {
            AppMethodBeat.m2504i(120438);
            C17242c ecB = ecB();
            AppMethodBeat.m2505o(120438);
            return ecB;
        }

        private C17238a(C25159a c25159a) {
            super((byte) 0);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = c25159a.BsB;
        }

        private C17238a() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = C31710d.Bzq;
        }

        public static C17238a ecx() {
            return BsA;
        }

        private C17238a(C31713e c31713e, C31715g c31715g) {
            AppMethodBeat.m2504i(120430);
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            C31711b ehS = C31710d.ehS();
            C37024f e = C37024f.m61953e(ehS, 1);
            int i = 0;
            int i2 = 0;
            while (i == 0) {
                try {
                    int vc = c31713e.mo51692vc();
                    switch (vc) {
                        case 0:
                            i = 1;
                            break;
                        case 8:
                            this.BsD |= 1;
                            this.BsE = c31713e.mo51693vd();
                            break;
                        case 18:
                            if ((i2 & 2) != 2) {
                                this.BsF = new ArrayList();
                                i2 |= 2;
                            }
                            this.BsF.add(c31713e.mo51683a(C17239a.BsC, c31715g));
                            break;
                        default:
                            if (!mo42012a(c31713e, e, c31715g, vc)) {
                                i = 1;
                                break;
                            }
                            break;
                    }
                } catch (C41425k e2) {
                    e2.BzY = this;
                    AppMethodBeat.m2505o(120430);
                    throw e2;
                } catch (IOException e3) {
                    C41425k c41425k = new C41425k(e3.getMessage());
                    c41425k.BzY = this;
                    AppMethodBeat.m2505o(120430);
                    throw c41425k;
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
                        AppMethodBeat.m2505o(120430);
                    }
                    eio();
                    AppMethodBeat.m2505o(120430);
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
                AppMethodBeat.m2505o(120430);
            }
            eio();
            AppMethodBeat.m2505o(120430);
        }

        static {
            AppMethodBeat.m2504i(120440);
            C17238a c17238a = new C17238a();
            BsA = c17238a;
            c17238a.ecA();
            AppMethodBeat.m2505o(120440);
        }

        public final C25163s<C17238a> ecy() {
            return BsC;
        }

        public final boolean ecz() {
            return (this.BsD & 1) == 1;
        }

        public final int getArgumentCount() {
            AppMethodBeat.m2504i(120431);
            int size = this.BsF.size();
            AppMethodBeat.m2505o(120431);
            return size;
        }

        private void ecA() {
            AppMethodBeat.m2504i(120432);
            this.BsE = 0;
            this.BsF = Collections.emptyList();
            AppMethodBeat.m2505o(120432);
        }

        public final boolean isInitialized() {
            AppMethodBeat.m2504i(120433);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.m2505o(120433);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.m2505o(120433);
                return false;
            } else if (ecz()) {
                int i = 0;
                while (i < getArgumentCount()) {
                    if (((C17239a) this.BsF.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120433);
                        return false;
                    }
                }
                this.BsG = (byte) 1;
                AppMethodBeat.m2505o(120433);
                return true;
            } else {
                this.BsG = (byte) 0;
                AppMethodBeat.m2505o(120433);
                return false;
            }
        }

        /* renamed from: a */
        public final void mo128a(C37024f c37024f) {
            AppMethodBeat.m2504i(120434);
            mo144vq();
            if ((this.BsD & 1) == 1) {
                c37024f.mo59052bq(1, this.BsE);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.BsF.size()) {
                    c37024f.mo59046a(2, (C8185q) this.BsF.get(i2));
                    i = i2 + 1;
                } else {
                    c37024f.mo59056d(this.BsB);
                    AppMethodBeat.m2505o(120434);
                    return;
                }
            }
        }

        /* renamed from: vq */
        public final int mo144vq() {
            int i = 0;
            AppMethodBeat.m2504i(120435);
            int i2 = this.BsH;
            if (i2 != -1) {
                AppMethodBeat.m2505o(120435);
                return i2;
            }
            if ((this.BsD & 1) == 1) {
                i2 = C37024f.m61947bs(1, this.BsE) + 0;
            } else {
                i2 = 0;
            }
            while (true) {
                int i3 = i2;
                if (i < this.BsF.size()) {
                    i2 = C37024f.m61948c(2, (C8185q) this.BsF.get(i)) + i3;
                    i++;
                } else {
                    i2 = this.BsB.size() + i3;
                    this.BsH = i2;
                    AppMethodBeat.m2505o(120435);
                    return i2;
                }
            }
        }

        /* renamed from: a */
        public static C17242c m26639a(C17238a c17238a) {
            AppMethodBeat.m2504i(120436);
            C17242c e = C17242c.edh().mo31301e(c17238a);
            AppMethodBeat.m2505o(120436);
            return e;
        }

        public final C17242c ecB() {
            AppMethodBeat.m2504i(120437);
            C17242c e = C17242c.edh().mo31301e(this);
            AppMethodBeat.m2505o(120437);
            return e;
        }

        public final /* synthetic */ C8186a ecD() {
            AppMethodBeat.m2504i(120439);
            C17242c edh = C17242c.edh();
            AppMethodBeat.m2505o(120439);
            return edh;
        }

        public final /* bridge */ /* synthetic */ C8185q ecE() {
            return BsA;
        }
    }

    /* renamed from: a.i.b.a.c.e.a$ab */
    public static final class C17244ab extends C25158c<C17244ab> implements C25138ac {
        public static C25163s<C17244ab> BsC = new C172451();
        private static final C17244ab Bvv;
        private final C31710d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        public int BsW;
        public List<Integer> BtD;
        public List<C37014ae> Btp;
        public int Buf;
        public List<C17238a> BvA;
        public C25133aa Bvw;
        public int Bvx;
        public C25133aa Bvy;
        public int Bvz;

        /* renamed from: a.i.b.a.c.e.a$ab$1 */
        static class C172451 extends C0117b<C17244ab> {
            C172451() {
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo157a(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120885);
                C17244ab c17244ab = new C17244ab(c31713e, c31715g, (byte) 0);
                AppMethodBeat.m2505o(120885);
                return c17244ab;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$ab$a */
        public static final class C17246a extends C25157b<C17244ab, C17246a> implements C25138ac {
            private int BsD;
            private int BsW = 6;
            private List<Integer> BtD = Collections.emptyList();
            private List<C37014ae> Btp = Collections.emptyList();
            private int Buf;
            private List<C17238a> BvA = Collections.emptyList();
            private C25133aa Bvw = C25133aa.eeX();
            private int Bvx;
            private C25133aa Bvy = C25133aa.eeX();
            private int Bvz;

            /* renamed from: a */
            public final /* synthetic */ C25159a mo147a(C25155i c25155i) {
                AppMethodBeat.m2504i(120900);
                C17246a e = mo31309e((C17244ab) c25155i);
                AppMethodBeat.m2505o(120900);
                return e;
            }

            /* renamed from: c */
            public final /* synthetic */ C0115a mo148c(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120902);
                C17246a u = m26684u(c31713e, c31715g);
                AppMethodBeat.m2505o(120902);
                return u;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.m2504i(120906);
                C17246a efA = efA();
                AppMethodBeat.m2505o(120906);
                return efA;
            }

            /* renamed from: d */
            public final /* synthetic */ C8186a mo150d(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120904);
                C17246a u = m26684u(c31713e, c31715g);
                AppMethodBeat.m2505o(120904);
                return u;
            }

            public final /* synthetic */ C25159a ecK() {
                AppMethodBeat.m2504i(120901);
                C17246a efA = efA();
                AppMethodBeat.m2505o(120901);
                return efA;
            }

            public final /* synthetic */ C0115a ecL() {
                AppMethodBeat.m2504i(120903);
                C17246a efA = efA();
                AppMethodBeat.m2505o(120903);
                return efA;
            }

            public final /* synthetic */ C25157b edA() {
                AppMethodBeat.m2504i(120897);
                C17246a efA = efA();
                AppMethodBeat.m2505o(120897);
                return efA;
            }

            private C17246a() {
                AppMethodBeat.m2504i(120886);
                AppMethodBeat.m2505o(120886);
            }

            private C17244ab efB() {
                int i = 1;
                AppMethodBeat.m2504i(120888);
                C17244ab c17244ab = new C17244ab((C25157b) this, (byte) 0);
                int i2 = this.BsD;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                c17244ab.BsW = this.BsW;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                c17244ab.Buf = this.Buf;
                if ((this.BsD & 4) == 4) {
                    this.Btp = Collections.unmodifiableList(this.Btp);
                    this.BsD &= -5;
                }
                c17244ab.Btp = this.Btp;
                if ((i2 & 8) == 8) {
                    i |= 4;
                }
                c17244ab.Bvw = this.Bvw;
                if ((i2 & 16) == 16) {
                    i |= 8;
                }
                c17244ab.Bvx = this.Bvx;
                if ((i2 & 32) == 32) {
                    i |= 16;
                }
                c17244ab.Bvy = this.Bvy;
                if ((i2 & 64) == 64) {
                    i |= 32;
                }
                c17244ab.Bvz = this.Bvz;
                if ((this.BsD & 128) == 128) {
                    this.BvA = Collections.unmodifiableList(this.BvA);
                    this.BsD &= -129;
                }
                c17244ab.BvA = this.BvA;
                if ((this.BsD & 256) == 256) {
                    this.BtD = Collections.unmodifiableList(this.BtD);
                    this.BsD &= -257;
                }
                c17244ab.BtD = this.BtD;
                c17244ab.BsD = i;
                AppMethodBeat.m2505o(120888);
                return c17244ab;
            }

            /* renamed from: e */
            public final C17246a mo31309e(C17244ab c17244ab) {
                AppMethodBeat.m2504i(120889);
                if (c17244ab == C17244ab.efv()) {
                    AppMethodBeat.m2505o(120889);
                } else {
                    if (c17244ab.ecY()) {
                        m26678TN(c17244ab.BsW);
                    }
                    if (c17244ab.edW()) {
                        m26679TO(c17244ab.Buf);
                    }
                    if (!c17244ab.Btp.isEmpty()) {
                        if (this.Btp.isEmpty()) {
                            this.Btp = c17244ab.Btp;
                            this.BsD &= -5;
                        } else {
                            edp();
                            this.Btp.addAll(c17244ab.Btp);
                        }
                    }
                    if (c17244ab.efw()) {
                        m26682n(c17244ab.Bvw);
                    }
                    if (c17244ab.efx()) {
                        m26680TP(c17244ab.Bvx);
                    }
                    if (c17244ab.efy()) {
                        m26683o(c17244ab.Bvy);
                    }
                    if (c17244ab.efz()) {
                        m26681TQ(c17244ab.Bvz);
                    }
                    if (!c17244ab.BvA.isEmpty()) {
                        if (this.BvA.isEmpty()) {
                            this.BvA = c17244ab.BvA;
                            this.BsD &= -129;
                        } else {
                            efC();
                            this.BvA.addAll(c17244ab.BvA);
                        }
                    }
                    if (!c17244ab.BtD.isEmpty()) {
                        if (this.BtD.isEmpty()) {
                            this.BtD = c17244ab.BtD;
                            this.BsD &= -257;
                        } else {
                            edz();
                            this.BtD.addAll(c17244ab.BtD);
                        }
                    }
                    mo42015a((C25158c) c17244ab);
                    this.BsB = this.BsB.mo51672a(c17244ab.BsB);
                    AppMethodBeat.m2505o(120889);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: u */
            private C17246a m26684u(C31713e c31713e, C31715g c31715g) {
                C17244ab c17244ab;
                Throwable th;
                AppMethodBeat.m2504i(120891);
                C17244ab c17244ab2 = null;
                try {
                    mo31309e((C17244ab) C17244ab.BsC.mo157a(c31713e, c31715g));
                    AppMethodBeat.m2505o(120891);
                    return this;
                } catch (C41425k e) {
                    C41425k c41425k = e;
                    c17244ab = (C17244ab) c41425k.BzY;
                    AppMethodBeat.m2505o(120891);
                    throw c41425k;
                } catch (Throwable th2) {
                    th = th2;
                    c17244ab2 = c17244ab;
                    if (c17244ab2 != null) {
                    }
                    AppMethodBeat.m2505o(120891);
                    throw th;
                }
            }

            /* renamed from: TN */
            private C17246a m26678TN(int i) {
                this.BsD |= 1;
                this.BsW = i;
                return this;
            }

            /* renamed from: TO */
            private C17246a m26679TO(int i) {
                this.BsD |= 2;
                this.Buf = i;
                return this;
            }

            private void edp() {
                AppMethodBeat.m2504i(120892);
                if ((this.BsD & 4) != 4) {
                    this.Btp = new ArrayList(this.Btp);
                    this.BsD |= 4;
                }
                AppMethodBeat.m2505o(120892);
            }

            /* renamed from: n */
            private C17246a m26682n(C25133aa c25133aa) {
                AppMethodBeat.m2504i(120893);
                if ((this.BsD & 8) != 8 || this.Bvw == C25133aa.eeX()) {
                    this.Bvw = c25133aa;
                } else {
                    this.Bvw = C25133aa.m39555f(this.Bvw).mo42000j(c25133aa).eft();
                }
                this.BsD |= 8;
                AppMethodBeat.m2505o(120893);
                return this;
            }

            /* renamed from: TP */
            private C17246a m26680TP(int i) {
                this.BsD |= 16;
                this.Bvx = i;
                return this;
            }

            /* renamed from: o */
            private C17246a m26683o(C25133aa c25133aa) {
                AppMethodBeat.m2504i(120894);
                if ((this.BsD & 32) != 32 || this.Bvy == C25133aa.eeX()) {
                    this.Bvy = c25133aa;
                } else {
                    this.Bvy = C25133aa.m39555f(this.Bvy).mo42000j(c25133aa).eft();
                }
                this.BsD |= 32;
                AppMethodBeat.m2505o(120894);
                return this;
            }

            /* renamed from: TQ */
            private C17246a m26681TQ(int i) {
                this.BsD |= 64;
                this.Bvz = i;
                return this;
            }

            private void efC() {
                AppMethodBeat.m2504i(120895);
                if ((this.BsD & 128) != 128) {
                    this.BvA = new ArrayList(this.BvA);
                    this.BsD |= 128;
                }
                AppMethodBeat.m2505o(120895);
            }

            private void edz() {
                AppMethodBeat.m2504i(120896);
                if ((this.BsD & 256) != 256) {
                    this.BtD = new ArrayList(this.BtD);
                    this.BsD |= 256;
                }
                AppMethodBeat.m2505o(120896);
            }

            private C17246a efA() {
                AppMethodBeat.m2504i(120887);
                C17246a e = new C17246a().mo31309e(efB());
                AppMethodBeat.m2505o(120887);
                return e;
            }

            public final boolean isInitialized() {
                boolean z;
                AppMethodBeat.m2504i(120890);
                if ((this.BsD & 2) == 2) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    int i = 0;
                    while (i < this.Btp.size()) {
                        if (((C37014ae) this.Btp.get(i)).isInitialized()) {
                            i++;
                        } else {
                            AppMethodBeat.m2505o(120890);
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
                                if (((C17238a) this.BvA.get(i)).isInitialized()) {
                                    i++;
                                } else {
                                    AppMethodBeat.m2505o(120890);
                                    return false;
                                }
                            }
                            if (this.BzI.isInitialized()) {
                                AppMethodBeat.m2505o(120890);
                                return true;
                            }
                            AppMethodBeat.m2505o(120890);
                            return false;
                        }
                        AppMethodBeat.m2505o(120890);
                        return false;
                    }
                    AppMethodBeat.m2505o(120890);
                    return false;
                }
                AppMethodBeat.m2505o(120890);
                return false;
            }

            public final /* synthetic */ C8185q ecE() {
                AppMethodBeat.m2504i(120898);
                C17244ab efv = C17244ab.efv();
                AppMethodBeat.m2505o(120898);
                return efv;
            }

            public final /* synthetic */ C25155i ecJ() {
                AppMethodBeat.m2504i(120899);
                C17244ab efv = C17244ab.efv();
                AppMethodBeat.m2505o(120899);
                return efv;
            }

            public final /* synthetic */ C8185q ecM() {
                AppMethodBeat.m2504i(120905);
                C17244ab efB = efB();
                if (efB.isInitialized()) {
                    AppMethodBeat.m2505o(120905);
                    return efB;
                }
                C44904w c44904w = new C44904w();
                AppMethodBeat.m2505o(120905);
                throw c44904w;
            }

            static /* synthetic */ C17246a efD() {
                AppMethodBeat.m2504i(120907);
                C17246a c17246a = new C17246a();
                AppMethodBeat.m2505o(120907);
                return c17246a;
            }
        }

        /* synthetic */ C17244ab(C31713e c31713e, C31715g c31715g, byte b) {
            this(c31713e, c31715g);
        }

        private C17244ab(C25157b<C17244ab, ?> c25157b) {
            super(c25157b);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = c25157b.BsB;
        }

        private C17244ab() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = C31710d.Bzq;
        }

        public static C17244ab efv() {
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
        private C17244ab(C31713e c31713e, C31715g c31715g) {
            C41425k c41425k;
            Throwable th;
            IOException iOException;
            C41425k c41425k2;
            AppMethodBeat.m2504i(120908);
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            int i = 0;
            C31711b ehS = C31710d.ehS();
            C37024f e = C37024f.m61953e(ehS, 1);
            int i2 = 0;
            while (i2 == 0) {
                try {
                    int vc = c31713e.mo51692vc();
                    C25135c efk;
                    switch (vc) {
                        case 0:
                            i2 = 1;
                            break;
                        case 8:
                            this.BsD |= 1;
                            this.BsW = c31713e.mo51693vd();
                            break;
                        case 16:
                            this.BsD |= 2;
                            this.Buf = c31713e.mo51693vd();
                            break;
                        case 26:
                            if ((i & 4) != 4) {
                                this.Btp = new ArrayList();
                                i |= 4;
                            }
                            this.Btp.add(c31713e.mo51683a(C37014ae.BsC, c31715g));
                            break;
                        case 34:
                            if ((this.BsD & 4) == 4) {
                                efk = this.Bvw.efk();
                            } else {
                                efk = null;
                            }
                            this.Bvw = (C25133aa) c31713e.mo51683a(C25133aa.BsC, c31715g);
                            if (efk != null) {
                                efk.mo42000j(this.Bvw);
                                this.Bvw = efk.eft();
                            }
                            this.BsD |= 4;
                            break;
                        case 40:
                            this.BsD |= 8;
                            this.Bvx = c31713e.mo51693vd();
                            break;
                        case 50:
                            if ((this.BsD & 16) == 16) {
                                efk = this.Bvy.efk();
                            } else {
                                efk = null;
                            }
                            this.Bvy = (C25133aa) c31713e.mo51683a(C25133aa.BsC, c31715g);
                            if (efk != null) {
                                efk.mo42000j(this.Bvy);
                                this.Bvy = efk.eft();
                            }
                            this.BsD |= 16;
                            break;
                        case FileUtils.S_IRWXG /*56*/:
                            this.BsD |= 32;
                            this.Bvz = c31713e.mo51693vd();
                            break;
                        case 66:
                            if ((i & 128) != 128) {
                                this.BvA = new ArrayList();
                                i |= 128;
                            }
                            this.BvA.add(c31713e.mo51683a(C17238a.BsC, c31715g));
                            break;
                        case C31128d.MIC_PTU_ZIPAI_THURSDAY /*248*/:
                            if ((i & 256) != 256) {
                                this.BtD = new ArrayList();
                                i |= 256;
                            }
                            this.BtD.add(Integer.valueOf(c31713e.mo51693vd()));
                            break;
                        case 250:
                            int fo = c31713e.mo51690fo(c31713e.mo51693vd());
                            if ((i & 256) == 256 || c31713e.mo51695vg() <= 0) {
                                vc = i;
                            } else {
                                this.BtD = new ArrayList();
                                vc = i | 256;
                            }
                            while (c31713e.mo51695vg() > 0) {
                                try {
                                    this.BtD.add(Integer.valueOf(c31713e.mo51693vd()));
                                } catch (C41425k e2) {
                                    c41425k = e2;
                                    i2 = vc;
                                    try {
                                        c41425k.BzY = this;
                                        AppMethodBeat.m2505o(120908);
                                        throw c41425k;
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
                                            AppMethodBeat.m2505o(120908);
                                        }
                                        this.BzI.eii();
                                        AppMethodBeat.m2505o(120908);
                                        throw th;
                                    }
                                } catch (IOException e4) {
                                    iOException = e4;
                                    i2 = vc;
                                    c41425k2 = new C41425k(iOException.getMessage());
                                    c41425k2.BzY = this;
                                    AppMethodBeat.m2505o(120908);
                                    throw c41425k2;
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
                                    AppMethodBeat.m2505o(120908);
                                    throw th;
                                }
                            }
                            c31713e.mo51691fp(fo);
                            break;
                        default:
                            if (!mo42012a(c31713e, e, c31715g, vc)) {
                                i2 = 1;
                                break;
                            } else {
                                vc = i;
                                break;
                            }
                    }
                } catch (C41425k c41425k22) {
                    c41425k = c41425k22;
                    i2 = i;
                    c41425k.BzY = this;
                    AppMethodBeat.m2505o(120908);
                    throw c41425k;
                } catch (IOException e5) {
                    iOException = e5;
                    i2 = i;
                    c41425k22 = new C41425k(iOException.getMessage());
                    c41425k22.BzY = this;
                    AppMethodBeat.m2505o(120908);
                    throw c41425k22;
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
                    AppMethodBeat.m2505o(120908);
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
                AppMethodBeat.m2505o(120908);
            }
            this.BzI.eii();
            AppMethodBeat.m2505o(120908);
        }

        static {
            AppMethodBeat.m2504i(120916);
            C17244ab c17244ab = new C17244ab();
            Bvv = c17244ab;
            c17244ab.ecA();
            AppMethodBeat.m2505o(120916);
        }

        public final C25163s<C17244ab> ecy() {
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
            AppMethodBeat.m2504i(120909);
            this.BsW = 6;
            this.Buf = 0;
            this.Btp = Collections.emptyList();
            this.Bvw = C25133aa.eeX();
            this.Bvx = 0;
            this.Bvy = C25133aa.eeX();
            this.Bvz = 0;
            this.BvA = Collections.emptyList();
            this.BtD = Collections.emptyList();
            AppMethodBeat.m2505o(120909);
        }

        public final boolean isInitialized() {
            AppMethodBeat.m2504i(120910);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.m2505o(120910);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.m2505o(120910);
                return false;
            } else if (edW()) {
                int i = 0;
                while (i < this.Btp.size()) {
                    if (((C37014ae) this.Btp.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120910);
                        return false;
                    }
                }
                if (efw() && !this.Bvw.isInitialized()) {
                    this.BsG = (byte) 0;
                    AppMethodBeat.m2505o(120910);
                    return false;
                } else if (!efy() || this.Bvy.isInitialized()) {
                    i = 0;
                    while (i < this.BvA.size()) {
                        if (((C17238a) this.BvA.get(i)).isInitialized()) {
                            i++;
                        } else {
                            this.BsG = (byte) 0;
                            AppMethodBeat.m2505o(120910);
                            return false;
                        }
                    }
                    if (this.BzI.isInitialized()) {
                        this.BsG = (byte) 1;
                        AppMethodBeat.m2505o(120910);
                        return true;
                    }
                    this.BsG = (byte) 0;
                    AppMethodBeat.m2505o(120910);
                    return false;
                } else {
                    this.BsG = (byte) 0;
                    AppMethodBeat.m2505o(120910);
                    return false;
                }
            } else {
                this.BsG = (byte) 0;
                AppMethodBeat.m2505o(120910);
                return false;
            }
        }

        /* renamed from: a */
        public final void mo128a(C37024f c37024f) {
            int i;
            int i2 = 0;
            AppMethodBeat.m2504i(120911);
            mo144vq();
            C8178a eip = eip();
            if ((this.BsD & 1) == 1) {
                c37024f.mo59052bq(1, this.BsW);
            }
            if ((this.BsD & 2) == 2) {
                c37024f.mo59052bq(2, this.Buf);
            }
            for (i = 0; i < this.Btp.size(); i++) {
                c37024f.mo59046a(3, (C8185q) this.Btp.get(i));
            }
            if ((this.BsD & 4) == 4) {
                c37024f.mo59046a(4, this.Bvw);
            }
            if ((this.BsD & 8) == 8) {
                c37024f.mo59052bq(5, this.Bvx);
            }
            if ((this.BsD & 16) == 16) {
                c37024f.mo59046a(6, this.Bvy);
            }
            if ((this.BsD & 32) == 32) {
                c37024f.mo59052bq(7, this.Bvz);
            }
            for (i = 0; i < this.BvA.size(); i++) {
                c37024f.mo59046a(8, (C8185q) this.BvA.get(i));
            }
            while (i2 < this.BtD.size()) {
                c37024f.mo59052bq(31, ((Integer) this.BtD.get(i2)).intValue());
                i2++;
            }
            eip.mo17990b(200, c37024f);
            c37024f.mo59056d(this.BsB);
            AppMethodBeat.m2505o(120911);
        }

        /* renamed from: vq */
        public final int mo144vq() {
            AppMethodBeat.m2504i(120912);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.m2505o(120912);
                return i;
            }
            int i2;
            if ((this.BsD & 1) == 1) {
                i = C37024f.m61947bs(1, this.BsW) + 0;
            } else {
                i = 0;
            }
            if ((this.BsD & 2) == 2) {
                i += C37024f.m61947bs(2, this.Buf);
            }
            int i3 = i;
            for (i2 = 0; i2 < this.Btp.size(); i2++) {
                i3 += C37024f.m61948c(3, (C8185q) this.Btp.get(i2));
            }
            if ((this.BsD & 4) == 4) {
                i3 += C37024f.m61948c(4, this.Bvw);
            }
            if ((this.BsD & 8) == 8) {
                i3 += C37024f.m61947bs(5, this.Bvx);
            }
            if ((this.BsD & 16) == 16) {
                i3 += C37024f.m61948c(6, this.Bvy);
            }
            if ((this.BsD & 32) == 32) {
                i3 += C37024f.m61947bs(7, this.Bvz);
            }
            for (i2 = 0; i2 < this.BvA.size(); i2++) {
                i3 += C37024f.m61948c(8, (C8185q) this.BvA.get(i2));
            }
            i2 = 0;
            int i4 = 0;
            while (i2 < this.BtD.size()) {
                i2++;
                i4 = C37024f.m61954ft(((Integer) this.BtD.get(i2)).intValue()) + i4;
            }
            i = (((i3 + i4) + (this.BtD.size() * 2)) + this.BzI.mo31345vq()) + this.BsB.size();
            this.BsH = i;
            AppMethodBeat.m2505o(120912);
            return i;
        }

        /* renamed from: d */
        public static C17244ab m26672d(InputStream inputStream, C31715g c31715g) {
            AppMethodBeat.m2504i(120913);
            C17244ab c17244ab = (C17244ab) BsC.mo189i(inputStream, c31715g);
            AppMethodBeat.m2505o(120913);
            return c17244ab;
        }

        public final /* bridge */ /* synthetic */ C8185q ecE() {
            return Bvv;
        }

        public final /* synthetic */ C8186a ecC() {
            AppMethodBeat.m2504i(120914);
            C17246a e = C17246a.efD().mo31309e(this);
            AppMethodBeat.m2505o(120914);
            return e;
        }

        public final /* synthetic */ C8186a ecD() {
            AppMethodBeat.m2504i(120915);
            C17246a efD = C17246a.efD();
            AppMethodBeat.m2505o(120915);
            return efD;
        }
    }

    /* renamed from: a.i.b.a.c.e.a$ad */
    public interface C17247ad extends C8179d {
    }

    /* renamed from: a.i.b.a.c.e.a$j */
    public interface C24616j extends C17270r {
    }

    /* renamed from: a.i.b.a.c.e.a$aa */
    public static final class C25133aa extends C25158c<C25133aa> implements C17247ad {
        public static C25163s<C25133aa> BsC = new C251311();
        private static final C25133aa BuZ;
        private final C31710d BsB;
        private int BsD;
        public List<C25136a> BsF;
        private byte BsG;
        private int BsH;
        public int BsW;
        public boolean Bva;
        public int Bvb;
        public C25133aa Bvc;
        public int Bvd;
        public int Bve;
        public int Bvf;
        public int Bvg;
        public int Bvh;
        public C25133aa Bvi;
        public int Bvj;
        public C25133aa Bvk;
        public int Bvl;

        /* renamed from: a.i.b.a.c.e.a$aa$1 */
        static class C251311 extends C0117b<C25133aa> {
            C251311() {
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo157a(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120820);
                C25133aa c25133aa = new C25133aa(c31713e, c31715g, (byte) 0);
                AppMethodBeat.m2505o(120820);
                return c25133aa;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$aa$b */
        public interface C25134b extends C17270r {
        }

        /* renamed from: a.i.b.a.c.e.a$aa$c */
        public static final class C25135c extends C25157b<C25133aa, C25135c> implements C17247ad {
            private int BsD;
            private List<C25136a> BsF = Collections.emptyList();
            private int BsW;
            private boolean Bva;
            private int Bvb;
            private C25133aa Bvc = C25133aa.eeX();
            private int Bvd;
            private int Bve;
            private int Bvf;
            private int Bvg;
            private int Bvh;
            private C25133aa Bvi = C25133aa.eeX();
            private int Bvj;
            private C25133aa Bvk = C25133aa.eeX();
            private int Bvl;

            /* renamed from: a */
            public final /* synthetic */ C25159a mo147a(C25155i c25155i) {
                AppMethodBeat.m2504i(120866);
                C25135c j = mo42000j((C25133aa) c25155i);
                AppMethodBeat.m2505o(120866);
                return j;
            }

            /* renamed from: c */
            public final /* synthetic */ C0115a mo148c(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120868);
                C25135c t = m39576t(c31713e, c31715g);
                AppMethodBeat.m2505o(120868);
                return t;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.m2504i(120872);
                C25135c efr = efr();
                AppMethodBeat.m2505o(120872);
                return efr;
            }

            /* renamed from: d */
            public final /* synthetic */ C8186a mo150d(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120870);
                C25135c t = m39576t(c31713e, c31715g);
                AppMethodBeat.m2505o(120870);
                return t;
            }

            public final /* synthetic */ C25159a ecK() {
                AppMethodBeat.m2504i(120867);
                C25135c efr = efr();
                AppMethodBeat.m2505o(120867);
                return efr;
            }

            public final /* synthetic */ C0115a ecL() {
                AppMethodBeat.m2504i(120869);
                C25135c efr = efr();
                AppMethodBeat.m2505o(120869);
                return efr;
            }

            public final /* synthetic */ C8185q ecM() {
                AppMethodBeat.m2504i(120871);
                C25133aa efs = efs();
                AppMethodBeat.m2505o(120871);
                return efs;
            }

            public final /* synthetic */ C25157b edA() {
                AppMethodBeat.m2504i(120863);
                C25135c efr = efr();
                AppMethodBeat.m2505o(120863);
                return efr;
            }

            private C25135c() {
                AppMethodBeat.m2504i(120852);
                AppMethodBeat.m2505o(120852);
            }

            public final C25133aa efs() {
                AppMethodBeat.m2504i(120854);
                C25133aa eft = eft();
                if (eft.isInitialized()) {
                    AppMethodBeat.m2505o(120854);
                    return eft;
                }
                C44904w c44904w = new C44904w();
                AppMethodBeat.m2505o(120854);
                throw c44904w;
            }

            public final C25133aa eft() {
                int i = 1;
                AppMethodBeat.m2504i(120855);
                C25133aa c25133aa = new C25133aa((C25157b) this, (byte) 0);
                int i2 = this.BsD;
                if ((this.BsD & 1) == 1) {
                    this.BsF = Collections.unmodifiableList(this.BsF);
                    this.BsD &= -2;
                }
                c25133aa.BsF = this.BsF;
                if ((i2 & 2) != 2) {
                    i = 0;
                }
                c25133aa.Bva = this.Bva;
                if ((i2 & 4) == 4) {
                    i |= 2;
                }
                c25133aa.Bvb = this.Bvb;
                if ((i2 & 8) == 8) {
                    i |= 4;
                }
                c25133aa.Bvc = this.Bvc;
                if ((i2 & 16) == 16) {
                    i |= 8;
                }
                c25133aa.Bvd = this.Bvd;
                if ((i2 & 32) == 32) {
                    i |= 16;
                }
                c25133aa.Bve = this.Bve;
                if ((i2 & 64) == 64) {
                    i |= 32;
                }
                c25133aa.Bvf = this.Bvf;
                if ((i2 & 128) == 128) {
                    i |= 64;
                }
                c25133aa.Bvg = this.Bvg;
                if ((i2 & 256) == 256) {
                    i |= 128;
                }
                c25133aa.Bvh = this.Bvh;
                if ((i2 & 512) == 512) {
                    i |= 256;
                }
                c25133aa.Bvi = this.Bvi;
                if ((i2 & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                    i |= 512;
                }
                c25133aa.Bvj = this.Bvj;
                if ((i2 & 2048) == 2048) {
                    i |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                }
                c25133aa.Bvk = this.Bvk;
                if ((i2 & 4096) == 4096) {
                    i |= 2048;
                }
                c25133aa.Bvl = this.Bvl;
                if ((i2 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == Utility.DEFAULT_STREAM_BUFFER_SIZE) {
                    i |= 4096;
                }
                c25133aa.BsW = this.BsW;
                c25133aa.BsD = i;
                AppMethodBeat.m2505o(120855);
                return c25133aa;
            }

            /* renamed from: j */
            public final C25135c mo42000j(C25133aa c25133aa) {
                AppMethodBeat.m2504i(120856);
                if (c25133aa == C25133aa.eeX()) {
                    AppMethodBeat.m2505o(120856);
                } else {
                    if (!c25133aa.BsF.isEmpty()) {
                        if (this.BsF.isEmpty()) {
                            this.BsF = c25133aa.BsF;
                            this.BsD &= -2;
                        } else {
                            edg();
                            this.BsF.addAll(c25133aa.BsF);
                        }
                    }
                    if (c25133aa.eeY()) {
                        mo42001rN(c25133aa.Bva);
                    }
                    if (c25133aa.eeZ()) {
                        m39564TE(c25133aa.Bvb);
                    }
                    if (c25133aa.efa()) {
                        m39573k(c25133aa.Bvc);
                    }
                    if (c25133aa.efb()) {
                        m39565TF(c25133aa.Bvd);
                    }
                    if (c25133aa.efc()) {
                        m39566TG(c25133aa.Bve);
                    }
                    if (c25133aa.efd()) {
                        m39567TH(c25133aa.Bvf);
                    }
                    if (c25133aa.efe()) {
                        m39568TI(c25133aa.Bvg);
                    }
                    if (c25133aa.eff()) {
                        m39569TJ(c25133aa.Bvh);
                    }
                    if (c25133aa.efg()) {
                        m39574l(c25133aa.Bvi);
                    }
                    if (c25133aa.efh()) {
                        m39570TK(c25133aa.Bvj);
                    }
                    if (c25133aa.efi()) {
                        m39575m(c25133aa.Bvk);
                    }
                    if (c25133aa.efj()) {
                        m39571TL(c25133aa.Bvl);
                    }
                    if (c25133aa.ecY()) {
                        m39572TM(c25133aa.BsW);
                    }
                    mo42015a((C25158c) c25133aa);
                    this.BsB = this.BsB.mo51672a(c25133aa.BsB);
                    AppMethodBeat.m2505o(120856);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: t */
            private C25135c m39576t(C31713e c31713e, C31715g c31715g) {
                C25133aa c25133aa;
                Throwable th;
                AppMethodBeat.m2504i(120858);
                C25133aa c25133aa2 = null;
                try {
                    mo42000j((C25133aa) C25133aa.BsC.mo157a(c31713e, c31715g));
                    AppMethodBeat.m2505o(120858);
                    return this;
                } catch (C41425k e) {
                    C41425k c41425k = e;
                    c25133aa = (C25133aa) c41425k.BzY;
                    AppMethodBeat.m2505o(120858);
                    throw c41425k;
                } catch (Throwable th2) {
                    th = th2;
                    c25133aa2 = c25133aa;
                    if (c25133aa2 != null) {
                    }
                    AppMethodBeat.m2505o(120858);
                    throw th;
                }
            }

            private void edg() {
                AppMethodBeat.m2504i(120859);
                if ((this.BsD & 1) != 1) {
                    this.BsF = new ArrayList(this.BsF);
                    this.BsD |= 1;
                }
                AppMethodBeat.m2505o(120859);
            }

            /* renamed from: rN */
            public final C25135c mo42001rN(boolean z) {
                this.BsD |= 2;
                this.Bva = z;
                return this;
            }

            /* renamed from: TE */
            private C25135c m39564TE(int i) {
                this.BsD |= 4;
                this.Bvb = i;
                return this;
            }

            /* renamed from: k */
            private C25135c m39573k(C25133aa c25133aa) {
                AppMethodBeat.m2504i(120860);
                if ((this.BsD & 8) != 8 || this.Bvc == C25133aa.eeX()) {
                    this.Bvc = c25133aa;
                } else {
                    this.Bvc = C25133aa.m39555f(this.Bvc).mo42000j(c25133aa).eft();
                }
                this.BsD |= 8;
                AppMethodBeat.m2505o(120860);
                return this;
            }

            /* renamed from: TF */
            private C25135c m39565TF(int i) {
                this.BsD |= 16;
                this.Bvd = i;
                return this;
            }

            /* renamed from: TG */
            private C25135c m39566TG(int i) {
                this.BsD |= 32;
                this.Bve = i;
                return this;
            }

            /* renamed from: TH */
            private C25135c m39567TH(int i) {
                this.BsD |= 64;
                this.Bvf = i;
                return this;
            }

            /* renamed from: TI */
            private C25135c m39568TI(int i) {
                this.BsD |= 128;
                this.Bvg = i;
                return this;
            }

            /* renamed from: TJ */
            private C25135c m39569TJ(int i) {
                this.BsD |= 256;
                this.Bvh = i;
                return this;
            }

            /* renamed from: l */
            private C25135c m39574l(C25133aa c25133aa) {
                AppMethodBeat.m2504i(120861);
                if ((this.BsD & 512) != 512 || this.Bvi == C25133aa.eeX()) {
                    this.Bvi = c25133aa;
                } else {
                    this.Bvi = C25133aa.m39555f(this.Bvi).mo42000j(c25133aa).eft();
                }
                this.BsD |= 512;
                AppMethodBeat.m2505o(120861);
                return this;
            }

            /* renamed from: TK */
            private C25135c m39570TK(int i) {
                this.BsD |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                this.Bvj = i;
                return this;
            }

            /* renamed from: m */
            private C25135c m39575m(C25133aa c25133aa) {
                AppMethodBeat.m2504i(120862);
                if ((this.BsD & 2048) != 2048 || this.Bvk == C25133aa.eeX()) {
                    this.Bvk = c25133aa;
                } else {
                    this.Bvk = C25133aa.m39555f(this.Bvk).mo42000j(c25133aa).eft();
                }
                this.BsD |= 2048;
                AppMethodBeat.m2505o(120862);
                return this;
            }

            /* renamed from: TL */
            private C25135c m39571TL(int i) {
                this.BsD |= 4096;
                this.Bvl = i;
                return this;
            }

            /* renamed from: TM */
            private C25135c m39572TM(int i) {
                this.BsD |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                this.BsW = i;
                return this;
            }

            private C25135c efr() {
                AppMethodBeat.m2504i(120853);
                C25135c j = new C25135c().mo42000j(eft());
                AppMethodBeat.m2505o(120853);
                return j;
            }

            public final boolean isInitialized() {
                boolean z;
                AppMethodBeat.m2504i(120857);
                int i = 0;
                while (i < this.BsF.size()) {
                    if (((C25136a) this.BsF.get(i)).isInitialized()) {
                        i++;
                    } else {
                        AppMethodBeat.m2505o(120857);
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
                            AppMethodBeat.m2505o(120857);
                            return false;
                        } else if (this.BzI.isInitialized()) {
                            AppMethodBeat.m2505o(120857);
                            return true;
                        } else {
                            AppMethodBeat.m2505o(120857);
                            return false;
                        }
                    }
                    AppMethodBeat.m2505o(120857);
                    return false;
                }
                AppMethodBeat.m2505o(120857);
                return false;
            }

            public final /* synthetic */ C8185q ecE() {
                AppMethodBeat.m2504i(120864);
                C25133aa eeX = C25133aa.eeX();
                AppMethodBeat.m2505o(120864);
                return eeX;
            }

            public final /* synthetic */ C25155i ecJ() {
                AppMethodBeat.m2504i(120865);
                C25133aa eeX = C25133aa.eeX();
                AppMethodBeat.m2505o(120865);
                return eeX;
            }

            static /* synthetic */ C25135c efu() {
                AppMethodBeat.m2504i(120873);
                C25135c c25135c = new C25135c();
                AppMethodBeat.m2505o(120873);
                return c25135c;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$aa$a */
        public static final class C25136a extends C25155i implements C25134b {
            public static C25163s<C25136a> BsC = new C251371();
            private static final C25136a Bvm;
            private final C31710d BsB;
            private int BsD;
            private byte BsG;
            private int BsH;
            public C8152b Bvn;
            public C25133aa Bvo;
            public int Bvp;

            /* renamed from: a.i.b.a.c.e.a$aa$a$b */
            public enum C8152b implements C8183a {
                IN(0),
                OUT(1),
                INV(2),
                STAR(3);
                
                private static C8182b<C8152b> Btk;
                final int value;

                /* renamed from: a.i.b.a.c.e.a$aa$a$b$1 */
                static class C81531 implements C8182b<C8152b> {
                    C81531() {
                    }

                    /* renamed from: SW */
                    public final /* synthetic */ C8183a mo146SW(int i) {
                        AppMethodBeat.m2504i(120840);
                        C8152b TD = C8152b.m14359TD(i);
                        AppMethodBeat.m2505o(120840);
                        return TD;
                    }
                }

                static {
                    Btk = new C81531();
                    AppMethodBeat.m2505o(120843);
                }

                public final int edd() {
                    return this.value;
                }

                /* renamed from: TD */
                public static C8152b m14359TD(int i) {
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

                private C8152b(int i) {
                    this.value = i;
                }
            }

            /* renamed from: a.i.b.a.c.e.a$aa$a$a */
            public static final class C25132a extends C25159a<C25136a, C25132a> implements C25134b {
                private int BsD;
                private C8152b Bvn = C8152b.INV;
                private C25133aa Bvo = C25133aa.eeX();
                private int Bvp;

                /* renamed from: c */
                public final /* synthetic */ C0115a mo148c(C31713e c31713e, C31715g c31715g) {
                    AppMethodBeat.m2504i(120833);
                    C25132a s = m39539s(c31713e, c31715g);
                    AppMethodBeat.m2505o(120833);
                    return s;
                }

                public final /* synthetic */ Object clone() {
                    AppMethodBeat.m2504i(120838);
                    C25132a efo = efo();
                    AppMethodBeat.m2505o(120838);
                    return efo;
                }

                /* renamed from: d */
                public final /* synthetic */ C8186a mo150d(C31713e c31713e, C31715g c31715g) {
                    AppMethodBeat.m2504i(120835);
                    C25132a s = m39539s(c31713e, c31715g);
                    AppMethodBeat.m2505o(120835);
                    return s;
                }

                public final /* synthetic */ C25159a ecK() {
                    AppMethodBeat.m2504i(120832);
                    C25132a efo = efo();
                    AppMethodBeat.m2505o(120832);
                    return efo;
                }

                public final /* synthetic */ C0115a ecL() {
                    AppMethodBeat.m2504i(120834);
                    C25132a efo = efo();
                    AppMethodBeat.m2505o(120834);
                    return efo;
                }

                private C25132a() {
                    AppMethodBeat.m2504i(120822);
                    AppMethodBeat.m2505o(120822);
                }

                private C25136a efp() {
                    int i = 1;
                    AppMethodBeat.m2504i(120824);
                    C25136a c25136a = new C25136a((C25159a) this, (byte) 0);
                    int i2 = this.BsD;
                    if ((i2 & 1) != 1) {
                        i = 0;
                    }
                    c25136a.Bvn = this.Bvn;
                    if ((i2 & 2) == 2) {
                        i |= 2;
                    }
                    c25136a.Bvo = this.Bvo;
                    if ((i2 & 4) == 4) {
                        i |= 4;
                    }
                    c25136a.Bvp = this.Bvp;
                    c25136a.BsD = i;
                    AppMethodBeat.m2505o(120824);
                    return c25136a;
                }

                /* renamed from: b */
                public final C25132a mo41982b(C25136a c25136a) {
                    AppMethodBeat.m2504i(120825);
                    if (c25136a == C25136a.efl()) {
                        AppMethodBeat.m2505o(120825);
                    } else {
                        if (c25136a.efm()) {
                            m39537a(c25136a.Bvn);
                        }
                        if (c25136a.ecP()) {
                            m39538i(c25136a.Bvo);
                        }
                        if (c25136a.efn()) {
                            m39536TC(c25136a.Bvp);
                        }
                        this.BsB = this.BsB.mo51672a(c25136a.BsB);
                        AppMethodBeat.m2505o(120825);
                    }
                    return this;
                }

                /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                /* renamed from: s */
                private C25132a m39539s(C31713e c31713e, C31715g c31715g) {
                    C25136a c25136a;
                    Throwable th;
                    AppMethodBeat.m2504i(120827);
                    C25136a c25136a2 = null;
                    try {
                        mo41982b((C25136a) C25136a.BsC.mo157a(c31713e, c31715g));
                        AppMethodBeat.m2505o(120827);
                        return this;
                    } catch (C41425k e) {
                        C41425k c41425k = e;
                        c25136a = (C25136a) c41425k.BzY;
                        AppMethodBeat.m2505o(120827);
                        throw c41425k;
                    } catch (Throwable th2) {
                        th = th2;
                        c25136a2 = c25136a;
                        if (c25136a2 != null) {
                        }
                        AppMethodBeat.m2505o(120827);
                        throw th;
                    }
                }

                /* renamed from: a */
                private C25132a m39537a(C8152b c8152b) {
                    AppMethodBeat.m2504i(120828);
                    if (c8152b == null) {
                        NullPointerException nullPointerException = new NullPointerException();
                        AppMethodBeat.m2505o(120828);
                        throw nullPointerException;
                    }
                    this.BsD |= 1;
                    this.Bvn = c8152b;
                    AppMethodBeat.m2505o(120828);
                    return this;
                }

                /* renamed from: i */
                private C25132a m39538i(C25133aa c25133aa) {
                    AppMethodBeat.m2504i(120829);
                    if ((this.BsD & 2) != 2 || this.Bvo == C25133aa.eeX()) {
                        this.Bvo = c25133aa;
                    } else {
                        this.Bvo = C25133aa.m39555f(this.Bvo).mo42000j(c25133aa).eft();
                    }
                    this.BsD |= 2;
                    AppMethodBeat.m2505o(120829);
                    return this;
                }

                /* renamed from: TC */
                private C25132a m39536TC(int i) {
                    this.BsD |= 4;
                    this.Bvp = i;
                    return this;
                }

                private C25132a efo() {
                    AppMethodBeat.m2504i(120823);
                    C25132a b = new C25132a().mo41982b(efp());
                    AppMethodBeat.m2505o(120823);
                    return b;
                }

                public final boolean isInitialized() {
                    boolean z;
                    AppMethodBeat.m2504i(120826);
                    if ((this.BsD & 2) == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z || this.Bvo.isInitialized()) {
                        AppMethodBeat.m2505o(120826);
                        return true;
                    }
                    AppMethodBeat.m2505o(120826);
                    return false;
                }

                public final /* synthetic */ C25155i ecJ() {
                    AppMethodBeat.m2504i(120830);
                    C25136a efl = C25136a.efl();
                    AppMethodBeat.m2505o(120830);
                    return efl;
                }

                public final /* synthetic */ C8185q ecM() {
                    AppMethodBeat.m2504i(120836);
                    C25136a efp = efp();
                    if (efp.isInitialized()) {
                        AppMethodBeat.m2505o(120836);
                        return efp;
                    }
                    C44904w c44904w = new C44904w();
                    AppMethodBeat.m2505o(120836);
                    throw c44904w;
                }

                public final /* synthetic */ C8185q ecE() {
                    AppMethodBeat.m2504i(120837);
                    C25136a efl = C25136a.efl();
                    AppMethodBeat.m2505o(120837);
                    return efl;
                }

                static /* synthetic */ C25132a efq() {
                    AppMethodBeat.m2504i(120839);
                    C25132a c25132a = new C25132a();
                    AppMethodBeat.m2505o(120839);
                    return c25132a;
                }
            }

            /* renamed from: a.i.b.a.c.e.a$aa$a$1 */
            static class C251371 extends C0117b<C25136a> {
                C251371() {
                }

                /* renamed from: a */
                public final /* synthetic */ Object mo157a(C31713e c31713e, C31715g c31715g) {
                    AppMethodBeat.m2504i(120821);
                    C25136a c25136a = new C25136a(c31713e, c31715g, (byte) 0);
                    AppMethodBeat.m2505o(120821);
                    return c25136a;
                }
            }

            /* synthetic */ C25136a(C31713e c31713e, C31715g c31715g, byte b) {
                this(c31713e, c31715g);
            }

            private C25136a(C25159a c25159a) {
                super((byte) 0);
                this.BsG = (byte) -1;
                this.BsH = -1;
                this.BsB = c25159a.BsB;
            }

            private C25136a() {
                this.BsG = (byte) -1;
                this.BsH = -1;
                this.BsB = C31710d.Bzq;
            }

            public static C25136a efl() {
                return Bvm;
            }

            private C25136a(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120844);
                this.BsG = (byte) -1;
                this.BsH = -1;
                ecA();
                C31711b ehS = C31710d.ehS();
                C37024f e = C37024f.m61953e(ehS, 1);
                int i = 0;
                while (i == 0) {
                    try {
                        int vc = c31713e.mo51692vc();
                        switch (vc) {
                            case 0:
                                i = 1;
                                break;
                            case 8:
                                int vd = c31713e.mo51693vd();
                                C8152b TD = C8152b.m14359TD(vd);
                                if (TD != null) {
                                    this.BsD |= 1;
                                    this.Bvn = TD;
                                    break;
                                }
                                e.mo59058fw(vc);
                                e.mo59058fw(vd);
                                break;
                            case 18:
                                C25135c efk;
                                if ((this.BsD & 2) == 2) {
                                    efk = this.Bvo.efk();
                                } else {
                                    efk = null;
                                }
                                this.Bvo = (C25133aa) c31713e.mo51683a(C25133aa.BsC, c31715g);
                                if (efk != null) {
                                    efk.mo42000j(this.Bvo);
                                    this.Bvo = efk.eft();
                                }
                                this.BsD |= 2;
                                break;
                            case 24:
                                this.BsD |= 4;
                                this.Bvp = c31713e.mo51693vd();
                                break;
                            default:
                                if (!mo42012a(c31713e, e, c31715g, vc)) {
                                    i = 1;
                                    break;
                                }
                                break;
                        }
                    } catch (C41425k e2) {
                        e2.BzY = this;
                        AppMethodBeat.m2505o(120844);
                        throw e2;
                    } catch (IOException e3) {
                        C41425k c41425k = new C41425k(e3.getMessage());
                        c41425k.BzY = this;
                        AppMethodBeat.m2505o(120844);
                        throw c41425k;
                    } catch (Throwable th) {
                        try {
                            e.flush();
                            this.BsB = ehS.ehW();
                        } catch (IOException e4) {
                            this.BsB = ehS.ehW();
                        } catch (Throwable th2) {
                            this.BsB = ehS.ehW();
                            AppMethodBeat.m2505o(120844);
                        }
                        eio();
                        AppMethodBeat.m2505o(120844);
                    }
                }
                try {
                    e.flush();
                    this.BsB = ehS.ehW();
                } catch (IOException e5) {
                    this.BsB = ehS.ehW();
                } catch (Throwable th3) {
                    this.BsB = ehS.ehW();
                    AppMethodBeat.m2505o(120844);
                }
                eio();
                AppMethodBeat.m2505o(120844);
            }

            static {
                AppMethodBeat.m2504i(120851);
                C25136a c25136a = new C25136a();
                Bvm = c25136a;
                c25136a.ecA();
                AppMethodBeat.m2505o(120851);
            }

            public final C25163s<C25136a> ecy() {
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
                AppMethodBeat.m2504i(120845);
                this.Bvn = C8152b.INV;
                this.Bvo = C25133aa.eeX();
                this.Bvp = 0;
                AppMethodBeat.m2505o(120845);
            }

            public final boolean isInitialized() {
                AppMethodBeat.m2504i(120846);
                byte b = this.BsG;
                if (b == (byte) 1) {
                    AppMethodBeat.m2505o(120846);
                    return true;
                } else if (b == (byte) 0) {
                    AppMethodBeat.m2505o(120846);
                    return false;
                } else if (!ecP() || this.Bvo.isInitialized()) {
                    this.BsG = (byte) 1;
                    AppMethodBeat.m2505o(120846);
                    return true;
                } else {
                    this.BsG = (byte) 0;
                    AppMethodBeat.m2505o(120846);
                    return false;
                }
            }

            /* renamed from: a */
            public final void mo128a(C37024f c37024f) {
                AppMethodBeat.m2504i(120847);
                mo144vq();
                if ((this.BsD & 1) == 1) {
                    c37024f.mo59059io(1, this.Bvn.value);
                }
                if ((this.BsD & 2) == 2) {
                    c37024f.mo59046a(2, this.Bvo);
                }
                if ((this.BsD & 4) == 4) {
                    c37024f.mo59052bq(3, this.Bvp);
                }
                c37024f.mo59056d(this.BsB);
                AppMethodBeat.m2505o(120847);
            }

            /* renamed from: vq */
            public final int mo144vq() {
                AppMethodBeat.m2504i(120848);
                int i = this.BsH;
                if (i != -1) {
                    AppMethodBeat.m2505o(120848);
                    return i;
                }
                i = 0;
                if ((this.BsD & 1) == 1) {
                    i = C37024f.m61957ip(1, this.Bvn.value) + 0;
                }
                if ((this.BsD & 2) == 2) {
                    i += C37024f.m61948c(2, this.Bvo);
                }
                if ((this.BsD & 4) == 4) {
                    i += C37024f.m61947bs(3, this.Bvp);
                }
                i += this.BsB.size();
                this.BsH = i;
                AppMethodBeat.m2505o(120848);
                return i;
            }

            public final /* synthetic */ C8186a ecC() {
                AppMethodBeat.m2504i(120849);
                C25132a b = C25132a.efq().mo41982b(this);
                AppMethodBeat.m2505o(120849);
                return b;
            }

            public final /* synthetic */ C8186a ecD() {
                AppMethodBeat.m2504i(120850);
                C25132a efq = C25132a.efq();
                AppMethodBeat.m2505o(120850);
                return efq;
            }

            public final /* bridge */ /* synthetic */ C8185q ecE() {
                return Bvm;
            }
        }

        /* synthetic */ C25133aa(C31713e c31713e, C31715g c31715g, byte b) {
            this(c31713e, c31715g);
        }

        public final /* synthetic */ C8186a ecC() {
            AppMethodBeat.m2504i(120882);
            C25135c efk = efk();
            AppMethodBeat.m2505o(120882);
            return efk;
        }

        private C25133aa(C25157b<C25133aa, ?> c25157b) {
            super(c25157b);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = c25157b.BsB;
        }

        private C25133aa() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = C31710d.Bzq;
        }

        public static C25133aa eeX() {
            return BuZ;
        }

        private C25133aa(C31713e c31713e, C31715g c31715g) {
            AppMethodBeat.m2504i(120874);
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            C31711b ehS = C31710d.ehS();
            C37024f e = C37024f.m61953e(ehS, 1);
            int i = 0;
            int i2 = 0;
            while (i == 0) {
                try {
                    int vc = c31713e.mo51692vc();
                    C25135c j;
                    switch (vc) {
                        case 0:
                            i = 1;
                            break;
                        case 8:
                            this.BsD |= 4096;
                            this.BsW = c31713e.mo51693vd();
                            break;
                        case 18:
                            if ((i2 & 1) != 1) {
                                this.BsF = new ArrayList();
                                i2 |= 1;
                            }
                            this.BsF.add(c31713e.mo51683a(C25136a.BsC, c31715g));
                            break;
                        case 24:
                            this.BsD |= 1;
                            this.Bva = c31713e.ehX();
                            break;
                        case 32:
                            this.BsD |= 2;
                            this.Bvb = c31713e.mo51693vd();
                            break;
                        case 42:
                            if ((this.BsD & 4) == 4) {
                                j = C25135c.efu().mo42000j(this.Bvc);
                            } else {
                                j = null;
                            }
                            this.Bvc = (C25133aa) c31713e.mo51683a(BsC, c31715g);
                            if (j != null) {
                                j.mo42000j(this.Bvc);
                                this.Bvc = j.eft();
                            }
                            this.BsD |= 4;
                            break;
                        case 48:
                            this.BsD |= 16;
                            this.Bve = c31713e.mo51693vd();
                            break;
                        case FileUtils.S_IRWXG /*56*/:
                            this.BsD |= 32;
                            this.Bvf = c31713e.mo51693vd();
                            break;
                        case 64:
                            this.BsD |= 8;
                            this.Bvd = c31713e.mo51693vd();
                            break;
                        case C33279c.CTRL_INDEX /*72*/:
                            this.BsD |= 64;
                            this.Bvg = c31713e.mo51693vd();
                            break;
                        case 82:
                            if ((this.BsD & 256) == 256) {
                                j = C25135c.efu().mo42000j(this.Bvi);
                            } else {
                                j = null;
                            }
                            this.Bvi = (C25133aa) c31713e.mo51683a(BsC, c31715g);
                            if (j != null) {
                                j.mo42000j(this.Bvi);
                                this.Bvi = j.eft();
                            }
                            this.BsD |= 256;
                            break;
                        case 88:
                            this.BsD |= 512;
                            this.Bvj = c31713e.mo51693vd();
                            break;
                        case 96:
                            this.BsD |= 128;
                            this.Bvh = c31713e.mo51693vd();
                            break;
                        case 106:
                            if ((this.BsD & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                                j = C25135c.efu().mo42000j(this.Bvk);
                            } else {
                                j = null;
                            }
                            this.Bvk = (C25133aa) c31713e.mo51683a(BsC, c31715g);
                            if (j != null) {
                                j.mo42000j(this.Bvk);
                                this.Bvk = j.eft();
                            }
                            this.BsD |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                            break;
                        case 112:
                            this.BsD |= 2048;
                            this.Bvl = c31713e.mo51693vd();
                            break;
                        default:
                            if (!mo42012a(c31713e, e, c31715g, vc)) {
                                i = 1;
                                break;
                            }
                            break;
                    }
                } catch (C41425k e2) {
                    e2.BzY = this;
                    AppMethodBeat.m2505o(120874);
                    throw e2;
                } catch (IOException e3) {
                    C41425k c41425k = new C41425k(e3.getMessage());
                    c41425k.BzY = this;
                    AppMethodBeat.m2505o(120874);
                    throw c41425k;
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
                        AppMethodBeat.m2505o(120874);
                    }
                    this.BzI.eii();
                    AppMethodBeat.m2505o(120874);
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
                AppMethodBeat.m2505o(120874);
            }
            this.BzI.eii();
            AppMethodBeat.m2505o(120874);
        }

        static {
            AppMethodBeat.m2504i(120884);
            C25133aa c25133aa = new C25133aa();
            BuZ = c25133aa;
            c25133aa.ecA();
            AppMethodBeat.m2505o(120884);
        }

        public final C25163s<C25133aa> ecy() {
            return BsC;
        }

        public final int getArgumentCount() {
            AppMethodBeat.m2504i(120875);
            int size = this.BsF.size();
            AppMethodBeat.m2505o(120875);
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
            AppMethodBeat.m2504i(120876);
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
            AppMethodBeat.m2505o(120876);
        }

        public final boolean isInitialized() {
            AppMethodBeat.m2504i(120877);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.m2505o(120877);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.m2505o(120877);
                return false;
            } else {
                int i = 0;
                while (i < getArgumentCount()) {
                    if (((C25136a) this.BsF.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120877);
                        return false;
                    }
                }
                if (efa() && !this.Bvc.isInitialized()) {
                    this.BsG = (byte) 0;
                    AppMethodBeat.m2505o(120877);
                    return false;
                } else if (efg() && !this.Bvi.isInitialized()) {
                    this.BsG = (byte) 0;
                    AppMethodBeat.m2505o(120877);
                    return false;
                } else if (efi() && !this.Bvk.isInitialized()) {
                    this.BsG = (byte) 0;
                    AppMethodBeat.m2505o(120877);
                    return false;
                } else if (this.BzI.isInitialized()) {
                    this.BsG = (byte) 1;
                    AppMethodBeat.m2505o(120877);
                    return true;
                } else {
                    this.BsG = (byte) 0;
                    AppMethodBeat.m2505o(120877);
                    return false;
                }
            }
        }

        /* renamed from: a */
        public final void mo128a(C37024f c37024f) {
            AppMethodBeat.m2504i(120878);
            mo144vq();
            C8178a eip = eip();
            if ((this.BsD & 4096) == 4096) {
                c37024f.mo59052bq(1, this.BsW);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.BsF.size()) {
                    break;
                }
                c37024f.mo59046a(2, (C8185q) this.BsF.get(i2));
                i = i2 + 1;
            }
            if ((this.BsD & 1) == 1) {
                c37024f.mo59062rP(this.Bva);
            }
            if ((this.BsD & 2) == 2) {
                c37024f.mo59052bq(4, this.Bvb);
            }
            if ((this.BsD & 4) == 4) {
                c37024f.mo59046a(5, this.Bvc);
            }
            if ((this.BsD & 16) == 16) {
                c37024f.mo59052bq(6, this.Bve);
            }
            if ((this.BsD & 32) == 32) {
                c37024f.mo59052bq(7, this.Bvf);
            }
            if ((this.BsD & 8) == 8) {
                c37024f.mo59052bq(8, this.Bvd);
            }
            if ((this.BsD & 64) == 64) {
                c37024f.mo59052bq(9, this.Bvg);
            }
            if ((this.BsD & 256) == 256) {
                c37024f.mo59046a(10, this.Bvi);
            }
            if ((this.BsD & 512) == 512) {
                c37024f.mo59052bq(11, this.Bvj);
            }
            if ((this.BsD & 128) == 128) {
                c37024f.mo59052bq(12, this.Bvh);
            }
            if ((this.BsD & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                c37024f.mo59046a(13, this.Bvk);
            }
            if ((this.BsD & 2048) == 2048) {
                c37024f.mo59052bq(14, this.Bvl);
            }
            eip.mo17990b(200, c37024f);
            c37024f.mo59056d(this.BsB);
            AppMethodBeat.m2505o(120878);
        }

        /* renamed from: vq */
        public final int mo144vq() {
            int i = 0;
            AppMethodBeat.m2504i(120879);
            int i2 = this.BsH;
            if (i2 != -1) {
                AppMethodBeat.m2505o(120879);
                return i2;
            }
            int i3;
            if ((this.BsD & 4096) == 4096) {
                i2 = C37024f.m61947bs(1, this.BsW) + 0;
            } else {
                i2 = 0;
            }
            while (true) {
                i3 = i2;
                if (i >= this.BsF.size()) {
                    break;
                }
                i2 = C37024f.m61948c(2, (C8185q) this.BsF.get(i)) + i3;
                i++;
            }
            if ((this.BsD & 1) == 1) {
                i3 += C37024f.m61955fv(3) + 1;
            }
            if ((this.BsD & 2) == 2) {
                i3 += C37024f.m61947bs(4, this.Bvb);
            }
            if ((this.BsD & 4) == 4) {
                i3 += C37024f.m61948c(5, this.Bvc);
            }
            if ((this.BsD & 16) == 16) {
                i3 += C37024f.m61947bs(6, this.Bve);
            }
            if ((this.BsD & 32) == 32) {
                i3 += C37024f.m61947bs(7, this.Bvf);
            }
            if ((this.BsD & 8) == 8) {
                i3 += C37024f.m61947bs(8, this.Bvd);
            }
            if ((this.BsD & 64) == 64) {
                i3 += C37024f.m61947bs(9, this.Bvg);
            }
            if ((this.BsD & 256) == 256) {
                i3 += C37024f.m61948c(10, this.Bvi);
            }
            if ((this.BsD & 512) == 512) {
                i3 += C37024f.m61947bs(11, this.Bvj);
            }
            if ((this.BsD & 128) == 128) {
                i3 += C37024f.m61947bs(12, this.Bvh);
            }
            if ((this.BsD & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                i3 += C37024f.m61948c(13, this.Bvk);
            }
            if ((this.BsD & 2048) == 2048) {
                i3 += C37024f.m61947bs(14, this.Bvl);
            }
            i2 = (this.BzI.mo31345vq() + i3) + this.BsB.size();
            this.BsH = i2;
            AppMethodBeat.m2505o(120879);
            return i2;
        }

        /* renamed from: f */
        public static C25135c m39555f(C25133aa c25133aa) {
            AppMethodBeat.m2504i(139059);
            C25135c j = C25135c.efu().mo42000j(c25133aa);
            AppMethodBeat.m2505o(139059);
            return j;
        }

        public final C25135c efk() {
            AppMethodBeat.m2504i(139060);
            C25135c j = C25135c.efu().mo42000j(this);
            AppMethodBeat.m2505o(139060);
            return j;
        }

        public final /* bridge */ /* synthetic */ C8185q ecE() {
            return BuZ;
        }

        public final /* synthetic */ C8186a ecD() {
            AppMethodBeat.m2504i(120883);
            C25135c efu = C25135c.efu();
            AppMethodBeat.m2505o(120883);
            return efu;
        }
    }

    /* renamed from: a.i.b.a.c.e.a$ac */
    public interface C25138ac extends C8179d {
    }

    /* renamed from: a.i.b.a.c.e.a$b */
    public interface C25144b extends C17270r {
    }

    /* renamed from: a.i.b.a.c.e.a$k */
    public static final class C25147k extends C25158c<C25147k> implements C31691l {
        public static C25163s<C25147k> BsC = new C251481();
        private static final C25147k Bue;
        private final C31710d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        public int Buf;

        /* renamed from: a.i.b.a.c.e.a$k$a */
        public static final class C8163a extends C25157b<C25147k, C8163a> implements C31691l {
            private int BsD;
            private int Buf;

            /* renamed from: a */
            public final /* synthetic */ C25159a mo147a(C25155i c25155i) {
                AppMethodBeat.m2504i(120586);
                C8163a b = mo17957b((C25147k) c25155i);
                AppMethodBeat.m2505o(120586);
                return b;
            }

            /* renamed from: c */
            public final /* synthetic */ C0115a mo148c(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120588);
                C8163a k = m14389k(c31713e, c31715g);
                AppMethodBeat.m2505o(120588);
                return k;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.m2504i(120592);
                C8163a edX = edX();
                AppMethodBeat.m2505o(120592);
                return edX;
            }

            /* renamed from: d */
            public final /* synthetic */ C8186a mo150d(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120590);
                C8163a k = m14389k(c31713e, c31715g);
                AppMethodBeat.m2505o(120590);
                return k;
            }

            public final /* synthetic */ C25159a ecK() {
                AppMethodBeat.m2504i(120587);
                C8163a edX = edX();
                AppMethodBeat.m2505o(120587);
                return edX;
            }

            public final /* synthetic */ C0115a ecL() {
                AppMethodBeat.m2504i(120589);
                C8163a edX = edX();
                AppMethodBeat.m2505o(120589);
                return edX;
            }

            public final /* synthetic */ C25157b edA() {
                AppMethodBeat.m2504i(120583);
                C8163a edX = edX();
                AppMethodBeat.m2505o(120583);
                return edX;
            }

            private C8163a() {
            }

            private C25147k edY() {
                int i = 1;
                AppMethodBeat.m2504i(120579);
                C25147k c25147k = new C25147k((C25157b) this, (byte) 0);
                if ((this.BsD & 1) != 1) {
                    i = 0;
                }
                c25147k.Buf = this.Buf;
                c25147k.BsD = i;
                AppMethodBeat.m2505o(120579);
                return c25147k;
            }

            /* renamed from: b */
            public final C8163a mo17957b(C25147k c25147k) {
                AppMethodBeat.m2504i(120580);
                if (c25147k == C25147k.edV()) {
                    AppMethodBeat.m2505o(120580);
                } else {
                    if (c25147k.edW()) {
                        m14388Tf(c25147k.Buf);
                    }
                    mo42015a((C25158c) c25147k);
                    this.BsB = this.BsB.mo51672a(c25147k.BsB);
                    AppMethodBeat.m2505o(120580);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: k */
            private C8163a m14389k(C31713e c31713e, C31715g c31715g) {
                C25147k c25147k;
                Throwable th;
                AppMethodBeat.m2504i(120582);
                C25147k c25147k2 = null;
                try {
                    mo17957b((C25147k) C25147k.BsC.mo157a(c31713e, c31715g));
                    AppMethodBeat.m2505o(120582);
                    return this;
                } catch (C41425k e) {
                    C41425k c41425k = e;
                    c25147k = (C25147k) c41425k.BzY;
                    AppMethodBeat.m2505o(120582);
                    throw c41425k;
                } catch (Throwable th2) {
                    th = th2;
                    c25147k2 = c25147k;
                    if (c25147k2 != null) {
                    }
                    AppMethodBeat.m2505o(120582);
                    throw th;
                }
            }

            /* renamed from: Tf */
            private C8163a m14388Tf(int i) {
                this.BsD |= 1;
                this.Buf = i;
                return this;
            }

            private C8163a edX() {
                AppMethodBeat.m2504i(120578);
                C8163a b = new C8163a().mo17957b(edY());
                AppMethodBeat.m2505o(120578);
                return b;
            }

            public final boolean isInitialized() {
                AppMethodBeat.m2504i(120581);
                if (this.BzI.isInitialized()) {
                    AppMethodBeat.m2505o(120581);
                    return true;
                }
                AppMethodBeat.m2505o(120581);
                return false;
            }

            public final /* synthetic */ C8185q ecE() {
                AppMethodBeat.m2504i(120584);
                C25147k edV = C25147k.edV();
                AppMethodBeat.m2505o(120584);
                return edV;
            }

            public final /* synthetic */ C25155i ecJ() {
                AppMethodBeat.m2504i(120585);
                C25147k edV = C25147k.edV();
                AppMethodBeat.m2505o(120585);
                return edV;
            }

            public final /* synthetic */ C8185q ecM() {
                AppMethodBeat.m2504i(120591);
                C25147k edY = edY();
                if (edY.isInitialized()) {
                    AppMethodBeat.m2505o(120591);
                    return edY;
                }
                C44904w c44904w = new C44904w();
                AppMethodBeat.m2505o(120591);
                throw c44904w;
            }

            static /* synthetic */ C8163a edZ() {
                AppMethodBeat.m2504i(120593);
                C8163a c8163a = new C8163a();
                AppMethodBeat.m2505o(120593);
                return c8163a;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$k$1 */
        static class C251481 extends C0117b<C25147k> {
            C251481() {
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo157a(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120577);
                C25147k c25147k = new C25147k(c31713e, c31715g, (byte) 0);
                AppMethodBeat.m2505o(120577);
                return c25147k;
            }
        }

        /* synthetic */ C25147k(C31713e c31713e, C31715g c31715g, byte b) {
            this(c31713e, c31715g);
        }

        private C25147k(C25157b<C25147k, ?> c25157b) {
            super(c25157b);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = c25157b.BsB;
        }

        private C25147k() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = C31710d.Bzq;
        }

        public static C25147k edV() {
            return Bue;
        }

        private C25147k(C31713e c31713e, C31715g c31715g) {
            int i = 0;
            AppMethodBeat.m2504i(120594);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.Buf = 0;
            C31711b ehS = C31710d.ehS();
            C37024f e = C37024f.m61953e(ehS, 1);
            while (i == 0) {
                try {
                    int vc = c31713e.mo51692vc();
                    switch (vc) {
                        case 0:
                            i = 1;
                            break;
                        case 8:
                            this.BsD |= 1;
                            this.Buf = c31713e.mo51693vd();
                            break;
                        default:
                            if (!mo42012a(c31713e, e, c31715g, vc)) {
                                i = 1;
                                break;
                            }
                            break;
                    }
                } catch (C41425k e2) {
                    e2.BzY = this;
                    AppMethodBeat.m2505o(120594);
                    throw e2;
                } catch (IOException e3) {
                    C41425k c41425k = new C41425k(e3.getMessage());
                    c41425k.BzY = this;
                    AppMethodBeat.m2505o(120594);
                    throw c41425k;
                } catch (Throwable th) {
                    try {
                        e.flush();
                        this.BsB = ehS.ehW();
                    } catch (IOException e4) {
                        this.BsB = ehS.ehW();
                    } catch (Throwable th2) {
                        this.BsB = ehS.ehW();
                        AppMethodBeat.m2505o(120594);
                    }
                    this.BzI.eii();
                    AppMethodBeat.m2505o(120594);
                }
            }
            try {
                e.flush();
                this.BsB = ehS.ehW();
            } catch (IOException e5) {
                this.BsB = ehS.ehW();
            } catch (Throwable th3) {
                this.BsB = ehS.ehW();
                AppMethodBeat.m2505o(120594);
            }
            this.BzI.eii();
            AppMethodBeat.m2505o(120594);
        }

        static {
            AppMethodBeat.m2504i(120600);
            C25147k c25147k = new C25147k();
            Bue = c25147k;
            c25147k.Buf = 0;
            AppMethodBeat.m2505o(120600);
        }

        public final C25163s<C25147k> ecy() {
            return BsC;
        }

        public final boolean edW() {
            return (this.BsD & 1) == 1;
        }

        public final boolean isInitialized() {
            AppMethodBeat.m2504i(120595);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.m2505o(120595);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.m2505o(120595);
                return false;
            } else if (this.BzI.isInitialized()) {
                this.BsG = (byte) 1;
                AppMethodBeat.m2505o(120595);
                return true;
            } else {
                this.BsG = (byte) 0;
                AppMethodBeat.m2505o(120595);
                return false;
            }
        }

        /* renamed from: a */
        public final void mo128a(C37024f c37024f) {
            AppMethodBeat.m2504i(120596);
            mo144vq();
            C8178a eip = eip();
            if ((this.BsD & 1) == 1) {
                c37024f.mo59052bq(1, this.Buf);
            }
            eip.mo17990b(200, c37024f);
            c37024f.mo59056d(this.BsB);
            AppMethodBeat.m2505o(120596);
        }

        /* renamed from: vq */
        public final int mo144vq() {
            AppMethodBeat.m2504i(120597);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.m2505o(120597);
                return i;
            }
            i = 0;
            if ((this.BsD & 1) == 1) {
                i = C37024f.m61947bs(1, this.Buf) + 0;
            }
            i = (i + this.BzI.mo31345vq()) + this.BsB.size();
            this.BsH = i;
            AppMethodBeat.m2505o(120597);
            return i;
        }

        public final /* bridge */ /* synthetic */ C8185q ecE() {
            return Bue;
        }

        public final /* synthetic */ C8186a ecC() {
            AppMethodBeat.m2504i(120598);
            C8163a b = C8163a.edZ().mo17957b(this);
            AppMethodBeat.m2505o(120598);
            return b;
        }

        public final /* synthetic */ C8186a ecD() {
            AppMethodBeat.m2504i(120599);
            C8163a edZ = C8163a.edZ();
            AppMethodBeat.m2505o(120599);
            return edZ;
        }
    }

    /* renamed from: a.i.b.a.c.e.a$i */
    public static final class C31223i extends C25155i implements C24616j {
        public static C25163s<C31223i> BsC = new C81601();
        private static final C31223i BtR;
        private final C31710d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        C31225b BtS;
        private List<C37003m> BtT;
        C37003m BtU;
        C8161c BtV;

        /* renamed from: a.i.b.a.c.e.a$i$1 */
        static class C81601 extends C0117b<C31223i> {
            C81601() {
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo157a(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120540);
                C31223i c31223i = new C31223i(c31713e, c31715g, (byte) 0);
                AppMethodBeat.m2505o(120540);
                return c31223i;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$i$c */
        public enum C8161c implements C8183a {
            AT_MOST_ONCE(0),
            EXACTLY_ONCE(1),
            AT_LEAST_ONCE(2);
            
            private static C8182b<C8161c> Btk;
            final int value;

            /* renamed from: a.i.b.a.c.e.a$i$c$1 */
            static class C81621 implements C8182b<C8161c> {
                C81621() {
                }

                /* renamed from: SW */
                public final /* synthetic */ C8183a mo146SW(int i) {
                    AppMethodBeat.m2504i(120565);
                    C8161c Te = C8161c.m14386Te(i);
                    AppMethodBeat.m2505o(120565);
                    return Te;
                }
            }

            static {
                Btk = new C81621();
                AppMethodBeat.m2505o(120568);
            }

            public final int edd() {
                return this.value;
            }

            /* renamed from: Te */
            public static C8161c m14386Te(int i) {
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

            private C8161c(int i) {
                this.value = i;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$i$a */
        public static final class C31224a extends C25159a<C31223i, C31224a> implements C24616j {
            private int BsD;
            private C31225b BtS = C31225b.RETURNS_CONSTANT;
            private List<C37003m> BtT = Collections.emptyList();
            private C37003m BtU = C37003m.eea();
            private C8161c BtV = C8161c.AT_MOST_ONCE;

            /* renamed from: c */
            public final /* synthetic */ C0115a mo148c(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120554);
                C31224a j = m50347j(c31713e, c31715g);
                AppMethodBeat.m2505o(120554);
                return j;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.m2504i(120559);
                C31224a edR = edR();
                AppMethodBeat.m2505o(120559);
                return edR;
            }

            /* renamed from: d */
            public final /* synthetic */ C8186a mo150d(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120556);
                C31224a j = m50347j(c31713e, c31715g);
                AppMethodBeat.m2505o(120556);
                return j;
            }

            public final /* synthetic */ C25159a ecK() {
                AppMethodBeat.m2504i(120553);
                C31224a edR = edR();
                AppMethodBeat.m2505o(120553);
                return edR;
            }

            public final /* synthetic */ C0115a ecL() {
                AppMethodBeat.m2504i(120555);
                C31224a edR = edR();
                AppMethodBeat.m2505o(120555);
                return edR;
            }

            private C31224a() {
                AppMethodBeat.m2504i(120541);
                AppMethodBeat.m2505o(120541);
            }

            private C31223i edS() {
                int i = 1;
                AppMethodBeat.m2504i(120543);
                C31223i c31223i = new C31223i((C25159a) this, (byte) 0);
                int i2 = this.BsD;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                c31223i.BtS = this.BtS;
                if ((this.BsD & 2) == 2) {
                    this.BtT = Collections.unmodifiableList(this.BtT);
                    this.BsD &= -3;
                }
                c31223i.BtT = this.BtT;
                if ((i2 & 4) == 4) {
                    i |= 2;
                }
                c31223i.BtU = this.BtU;
                if ((i2 & 8) == 8) {
                    i |= 4;
                }
                c31223i.BtV = this.BtV;
                c31223i.BsD = i;
                AppMethodBeat.m2505o(120543);
                return c31223i;
            }

            /* renamed from: c */
            public final C31224a mo51187c(C31223i c31223i) {
                AppMethodBeat.m2504i(120544);
                if (c31223i == C31223i.edN()) {
                    AppMethodBeat.m2505o(120544);
                } else {
                    if (c31223i.edO()) {
                        m50344a(c31223i.BtS);
                    }
                    if (!c31223i.BtT.isEmpty()) {
                        if (this.BtT.isEmpty()) {
                            this.BtT = c31223i.BtT;
                            this.BsD &= -3;
                        } else {
                            edT();
                            this.BtT.addAll(c31223i.BtT);
                        }
                    }
                    if (c31223i.edP()) {
                        m50346a(c31223i.BtU);
                    }
                    if (c31223i.edQ()) {
                        m50345a(c31223i.BtV);
                    }
                    this.BsB = this.BsB.mo51672a(c31223i.BsB);
                    AppMethodBeat.m2505o(120544);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: j */
            private C31224a m50347j(C31713e c31713e, C31715g c31715g) {
                C31223i c31223i;
                Throwable th;
                AppMethodBeat.m2504i(120546);
                C31223i c31223i2 = null;
                try {
                    mo51187c((C31223i) C31223i.BsC.mo157a(c31713e, c31715g));
                    AppMethodBeat.m2505o(120546);
                    return this;
                } catch (C41425k e) {
                    C41425k c41425k = e;
                    c31223i = (C31223i) c41425k.BzY;
                    AppMethodBeat.m2505o(120546);
                    throw c41425k;
                } catch (Throwable th2) {
                    th = th2;
                    c31223i2 = c31223i;
                    if (c31223i2 != null) {
                    }
                    AppMethodBeat.m2505o(120546);
                    throw th;
                }
            }

            /* renamed from: a */
            private C31224a m50344a(C31225b c31225b) {
                AppMethodBeat.m2504i(120547);
                if (c31225b == null) {
                    NullPointerException nullPointerException = new NullPointerException();
                    AppMethodBeat.m2505o(120547);
                    throw nullPointerException;
                }
                this.BsD |= 1;
                this.BtS = c31225b;
                AppMethodBeat.m2505o(120547);
                return this;
            }

            private void edT() {
                AppMethodBeat.m2504i(120548);
                if ((this.BsD & 2) != 2) {
                    this.BtT = new ArrayList(this.BtT);
                    this.BsD |= 2;
                }
                AppMethodBeat.m2505o(120548);
            }

            /* renamed from: a */
            private C31224a m50346a(C37003m c37003m) {
                AppMethodBeat.m2504i(120549);
                if ((this.BsD & 4) != 4 || this.BtU == C37003m.eea()) {
                    this.BtU = c37003m;
                } else {
                    this.BtU = C37003m.m61858b(this.BtU).mo59022f(c37003m).eeg();
                }
                this.BsD |= 4;
                AppMethodBeat.m2505o(120549);
                return this;
            }

            /* renamed from: a */
            private C31224a m50345a(C8161c c8161c) {
                AppMethodBeat.m2504i(120550);
                if (c8161c == null) {
                    NullPointerException nullPointerException = new NullPointerException();
                    AppMethodBeat.m2505o(120550);
                    throw nullPointerException;
                }
                this.BsD |= 8;
                this.BtV = c8161c;
                AppMethodBeat.m2505o(120550);
                return this;
            }

            private C31224a edR() {
                AppMethodBeat.m2504i(120542);
                C31224a c = new C31224a().mo51187c(edS());
                AppMethodBeat.m2505o(120542);
                return c;
            }

            public final boolean isInitialized() {
                boolean z;
                AppMethodBeat.m2504i(120545);
                int i = 0;
                while (i < this.BtT.size()) {
                    if (((C37003m) this.BtT.get(i)).isInitialized()) {
                        i++;
                    } else {
                        AppMethodBeat.m2505o(120545);
                        return false;
                    }
                }
                if ((this.BsD & 4) == 4) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z || this.BtU.isInitialized()) {
                    AppMethodBeat.m2505o(120545);
                    return true;
                }
                AppMethodBeat.m2505o(120545);
                return false;
            }

            public final /* synthetic */ C25155i ecJ() {
                AppMethodBeat.m2504i(120551);
                C31223i edN = C31223i.edN();
                AppMethodBeat.m2505o(120551);
                return edN;
            }

            public final /* synthetic */ C8185q ecM() {
                AppMethodBeat.m2504i(120557);
                C31223i edS = edS();
                if (edS.isInitialized()) {
                    AppMethodBeat.m2505o(120557);
                    return edS;
                }
                C44904w c44904w = new C44904w();
                AppMethodBeat.m2505o(120557);
                throw c44904w;
            }

            public final /* synthetic */ C8185q ecE() {
                AppMethodBeat.m2504i(120558);
                C31223i edN = C31223i.edN();
                AppMethodBeat.m2505o(120558);
                return edN;
            }

            static /* synthetic */ C31224a edU() {
                AppMethodBeat.m2504i(120560);
                C31224a c31224a = new C31224a();
                AppMethodBeat.m2505o(120560);
                return c31224a;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$i$b */
        public enum C31225b implements C8183a {
            RETURNS_CONSTANT(0),
            CALLS(1),
            RETURNS_NOT_NULL(2);
            
            private static C8182b<C31225b> Btk;
            final int value;

            /* renamed from: a.i.b.a.c.e.a$i$b$1 */
            static class C312261 implements C8182b<C31225b> {
                C312261() {
                }

                /* renamed from: SW */
                public final /* synthetic */ C8183a mo146SW(int i) {
                    AppMethodBeat.m2504i(120561);
                    C31225b Td = C31225b.m50352Td(i);
                    AppMethodBeat.m2505o(120561);
                    return Td;
                }
            }

            static {
                Btk = new C312261();
                AppMethodBeat.m2505o(120564);
            }

            public final int edd() {
                return this.value;
            }

            /* renamed from: Td */
            public static C31225b m50352Td(int i) {
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

            private C31225b(int i) {
                this.value = i;
            }
        }

        /* synthetic */ C31223i(C31713e c31713e, C31715g c31715g, byte b) {
            this(c31713e, c31715g);
        }

        private C31223i(C25159a c25159a) {
            super((byte) 0);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = c25159a.BsB;
        }

        private C31223i() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = C31710d.Bzq;
        }

        public static C31223i edN() {
            return BtR;
        }

        private C31223i(C31713e c31713e, C31715g c31715g) {
            AppMethodBeat.m2504i(120569);
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            C31711b ehS = C31710d.ehS();
            C37024f e = C37024f.m61953e(ehS, 1);
            int i = 0;
            int i2 = 0;
            while (i == 0) {
                try {
                    int vc = c31713e.mo51692vc();
                    int vd;
                    switch (vc) {
                        case 0:
                            i = 1;
                            break;
                        case 8:
                            vd = c31713e.mo51693vd();
                            C31225b Td = C31225b.m50352Td(vd);
                            if (Td != null) {
                                this.BsD |= 1;
                                this.BtS = Td;
                                break;
                            }
                            e.mo59058fw(vc);
                            e.mo59058fw(vd);
                            break;
                        case 18:
                            if ((i2 & 2) != 2) {
                                this.BtT = new ArrayList();
                                i2 |= 2;
                            }
                            this.BtT.add(c31713e.mo51683a(C37003m.BsC, c31715g));
                            break;
                        case 26:
                            C37004a b;
                            if ((this.BsD & 2) == 2) {
                                b = C37003m.m61858b(this.BtU);
                            } else {
                                b = null;
                            }
                            this.BtU = (C37003m) c31713e.mo51683a(C37003m.BsC, c31715g);
                            if (b != null) {
                                b.mo59022f(this.BtU);
                                this.BtU = b.eeg();
                            }
                            this.BsD |= 2;
                            break;
                        case 32:
                            vd = c31713e.mo51693vd();
                            C8161c Te = C8161c.m14386Te(vd);
                            if (Te != null) {
                                this.BsD |= 4;
                                this.BtV = Te;
                                break;
                            }
                            e.mo59058fw(vc);
                            e.mo59058fw(vd);
                            break;
                        default:
                            if (!mo42012a(c31713e, e, c31715g, vc)) {
                                i = 1;
                                break;
                            }
                            break;
                    }
                } catch (C41425k e2) {
                    e2.BzY = this;
                    AppMethodBeat.m2505o(120569);
                    throw e2;
                } catch (IOException e3) {
                    C41425k c41425k = new C41425k(e3.getMessage());
                    c41425k.BzY = this;
                    AppMethodBeat.m2505o(120569);
                    throw c41425k;
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
                        AppMethodBeat.m2505o(120569);
                    }
                    eio();
                    AppMethodBeat.m2505o(120569);
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
                AppMethodBeat.m2505o(120569);
            }
            eio();
            AppMethodBeat.m2505o(120569);
        }

        static {
            AppMethodBeat.m2504i(120576);
            C31223i c31223i = new C31223i();
            BtR = c31223i;
            c31223i.ecA();
            AppMethodBeat.m2505o(120576);
        }

        public final C25163s<C31223i> ecy() {
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
            AppMethodBeat.m2504i(120570);
            this.BtS = C31225b.RETURNS_CONSTANT;
            this.BtT = Collections.emptyList();
            this.BtU = C37003m.eea();
            this.BtV = C8161c.AT_MOST_ONCE;
            AppMethodBeat.m2505o(120570);
        }

        public final boolean isInitialized() {
            AppMethodBeat.m2504i(120571);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.m2505o(120571);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.m2505o(120571);
                return false;
            } else {
                int i = 0;
                while (i < this.BtT.size()) {
                    if (((C37003m) this.BtT.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120571);
                        return false;
                    }
                }
                if (!edP() || this.BtU.isInitialized()) {
                    this.BsG = (byte) 1;
                    AppMethodBeat.m2505o(120571);
                    return true;
                }
                this.BsG = (byte) 0;
                AppMethodBeat.m2505o(120571);
                return false;
            }
        }

        /* renamed from: a */
        public final void mo128a(C37024f c37024f) {
            AppMethodBeat.m2504i(120572);
            mo144vq();
            if ((this.BsD & 1) == 1) {
                c37024f.mo59059io(1, this.BtS.value);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.BtT.size()) {
                    break;
                }
                c37024f.mo59046a(2, (C8185q) this.BtT.get(i2));
                i = i2 + 1;
            }
            if ((this.BsD & 2) == 2) {
                c37024f.mo59046a(3, this.BtU);
            }
            if ((this.BsD & 4) == 4) {
                c37024f.mo59059io(4, this.BtV.value);
            }
            c37024f.mo59056d(this.BsB);
            AppMethodBeat.m2505o(120572);
        }

        /* renamed from: vq */
        public final int mo144vq() {
            int i = 0;
            AppMethodBeat.m2504i(120573);
            int i2 = this.BsH;
            if (i2 != -1) {
                AppMethodBeat.m2505o(120573);
                return i2;
            }
            int i3;
            if ((this.BsD & 1) == 1) {
                i2 = C37024f.m61957ip(1, this.BtS.value) + 0;
            } else {
                i2 = 0;
            }
            while (true) {
                i3 = i2;
                if (i >= this.BtT.size()) {
                    break;
                }
                i2 = C37024f.m61948c(2, (C8185q) this.BtT.get(i)) + i3;
                i++;
            }
            if ((this.BsD & 2) == 2) {
                i3 += C37024f.m61948c(3, this.BtU);
            }
            if ((this.BsD & 4) == 4) {
                i3 += C37024f.m61957ip(4, this.BtV.value);
            }
            i2 = this.BsB.size() + i3;
            this.BsH = i2;
            AppMethodBeat.m2505o(120573);
            return i2;
        }

        public final /* synthetic */ C8186a ecC() {
            AppMethodBeat.m2504i(120574);
            C31224a c = C31224a.edU().mo51187c(this);
            AppMethodBeat.m2505o(120574);
            return c;
        }

        public final /* synthetic */ C8186a ecD() {
            AppMethodBeat.m2504i(120575);
            C31224a edU = C31224a.edU();
            AppMethodBeat.m2505o(120575);
            return edU;
        }

        public final /* bridge */ /* synthetic */ C8185q ecE() {
            return BtR;
        }
    }

    /* renamed from: a.i.b.a.c.e.a$aj */
    public interface C31684aj extends C8179d {
    }

    /* renamed from: a.i.b.a.c.e.a$an */
    public interface C31686an extends C17270r {
    }

    /* renamed from: a.i.b.a.c.e.a$ao */
    public enum C31687ao implements C8183a {
        INTERNAL(0),
        PRIVATE(1),
        PROTECTED(2),
        PUBLIC(3),
        PRIVATE_TO_THIS(4),
        LOCAL(5);
        
        private static C8182b<C31687ao> Btk;
        private final int value;

        /* renamed from: a.i.b.a.c.e.a$ao$1 */
        static class C251431 implements C8182b<C31687ao> {
            C251431() {
            }

            /* renamed from: SW */
            public final /* synthetic */ C8183a mo146SW(int i) {
                AppMethodBeat.m2504i(121061);
                C31687ao Uf = C31687ao.m51242Uf(i);
                AppMethodBeat.m2505o(121061);
                return Uf;
            }
        }

        static {
            Btk = new C251431();
            AppMethodBeat.m2505o(121064);
        }

        public final int edd() {
            return this.value;
        }

        /* renamed from: Uf */
        public static C31687ao m51242Uf(int i) {
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

        private C31687ao(int i) {
            this.value = i;
        }
    }

    /* renamed from: a.i.b.a.c.e.a$l */
    public interface C31691l extends C8179d {
    }

    /* renamed from: a.i.b.a.c.e.a$n */
    public interface C31692n extends C17270r {
    }

    /* renamed from: a.i.b.a.c.e.a$o */
    public static final class C31694o extends C25158c<C31694o> implements C0085p {
        public static C25163s<C31694o> BsC = new C316931();
        private static final C31694o Bur;
        private final C31710d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        public int BsW;
        public C36999ag BtC;
        public List<Integer> BtD;
        public List<C8154ai> BtO;
        public List<C37014ae> Btp;
        public int Buf;
        public int Bus;
        public C25133aa But;
        public int Buu;
        public C25133aa Buv;
        public int Buw;
        C37013g Bux;

        /* renamed from: a.i.b.a.c.e.a$o$a */
        public static final class C8164a extends C25157b<C31694o, C8164a> implements C0085p {
            private int BsD;
            private int BsW = 6;
            private C36999ag BtC = C36999ag.efM();
            private List<Integer> BtD = Collections.emptyList();
            private List<C8154ai> BtO = Collections.emptyList();
            private List<C37014ae> Btp = Collections.emptyList();
            private int Buf;
            private int Bus = 6;
            private C25133aa But = C25133aa.eeX();
            private int Buu;
            private C25133aa Buv = C25133aa.eeX();
            private int Buw;
            private C37013g Bux = C37013g.edH();

            /* renamed from: a */
            public final /* synthetic */ C25159a mo147a(C25155i c25155i) {
                AppMethodBeat.m2504i(120652);
                C8164a e = mo17958e((C31694o) c25155i);
                AppMethodBeat.m2505o(120652);
                return e;
            }

            /* renamed from: c */
            public final /* synthetic */ C0115a mo148c(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120654);
                C8164a m = m14403m(c31713e, c31715g);
                AppMethodBeat.m2505o(120654);
                return m;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.m2504i(120658);
                C8164a eer = eer();
                AppMethodBeat.m2505o(120658);
                return eer;
            }

            /* renamed from: d */
            public final /* synthetic */ C8186a mo150d(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120656);
                C8164a m = m14403m(c31713e, c31715g);
                AppMethodBeat.m2505o(120656);
                return m;
            }

            public final /* synthetic */ C25159a ecK() {
                AppMethodBeat.m2504i(120653);
                C8164a eer = eer();
                AppMethodBeat.m2505o(120653);
                return eer;
            }

            public final /* synthetic */ C0115a ecL() {
                AppMethodBeat.m2504i(120655);
                C8164a eer = eer();
                AppMethodBeat.m2505o(120655);
                return eer;
            }

            public final /* synthetic */ C25157b edA() {
                AppMethodBeat.m2504i(120649);
                C8164a eer = eer();
                AppMethodBeat.m2505o(120649);
                return eer;
            }

            private C8164a() {
                AppMethodBeat.m2504i(120636);
                AppMethodBeat.m2505o(120636);
            }

            private C31694o ees() {
                int i = 1;
                AppMethodBeat.m2504i(120638);
                C31694o c31694o = new C31694o((C25157b) this, (byte) 0);
                int i2 = this.BsD;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                c31694o.BsW = this.BsW;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                c31694o.Bus = this.Bus;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                c31694o.Buf = this.Buf;
                if ((i2 & 8) == 8) {
                    i |= 8;
                }
                c31694o.But = this.But;
                if ((i2 & 16) == 16) {
                    i |= 16;
                }
                c31694o.Buu = this.Buu;
                if ((this.BsD & 32) == 32) {
                    this.Btp = Collections.unmodifiableList(this.Btp);
                    this.BsD &= -33;
                }
                c31694o.Btp = this.Btp;
                if ((i2 & 64) == 64) {
                    i |= 32;
                }
                c31694o.Buv = this.Buv;
                if ((i2 & 128) == 128) {
                    i |= 64;
                }
                c31694o.Buw = this.Buw;
                if ((this.BsD & 256) == 256) {
                    this.BtO = Collections.unmodifiableList(this.BtO);
                    this.BsD &= -257;
                }
                c31694o.BtO = this.BtO;
                if ((i2 & 512) == 512) {
                    i |= 128;
                }
                c31694o.BtC = this.BtC;
                if ((this.BsD & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                    this.BtD = Collections.unmodifiableList(this.BtD);
                    this.BsD &= -1025;
                }
                c31694o.BtD = this.BtD;
                if ((i2 & 2048) == 2048) {
                    i |= 256;
                }
                c31694o.Bux = this.Bux;
                c31694o.BsD = i;
                AppMethodBeat.m2505o(120638);
                return c31694o;
            }

            /* renamed from: e */
            public final C8164a mo17958e(C31694o c31694o) {
                AppMethodBeat.m2504i(120639);
                if (c31694o == C31694o.eek()) {
                    AppMethodBeat.m2505o(120639);
                } else {
                    if (c31694o.ecY()) {
                        m14394Tk(c31694o.BsW);
                    }
                    if (c31694o.eel()) {
                        m14395Tl(c31694o.Bus);
                    }
                    if (c31694o.edW()) {
                        m14396Tm(c31694o.Buf);
                    }
                    if (c31694o.eem()) {
                        m14399b(c31694o.But);
                    }
                    if (c31694o.een()) {
                        m14397Tn(c31694o.Buu);
                    }
                    if (!c31694o.Btp.isEmpty()) {
                        if (this.Btp.isEmpty()) {
                            this.Btp = c31694o.Btp;
                            this.BsD &= -33;
                        } else {
                            edp();
                            this.Btp.addAll(c31694o.Btp);
                        }
                    }
                    if (c31694o.eeo()) {
                        m14401c(c31694o.Buv);
                    }
                    if (c31694o.eep()) {
                        m14398To(c31694o.Buw);
                    }
                    if (!c31694o.BtO.isEmpty()) {
                        if (this.BtO.isEmpty()) {
                            this.BtO = c31694o.BtO;
                            this.BsD &= -257;
                        } else {
                            edF();
                            this.BtO.addAll(c31694o.BtO);
                        }
                    }
                    if (c31694o.edl()) {
                        m14400b(c31694o.BtC);
                    }
                    if (!c31694o.BtD.isEmpty()) {
                        if (this.BtD.isEmpty()) {
                            this.BtD = c31694o.BtD;
                            this.BsD &= -1025;
                        } else {
                            edz();
                            this.BtD.addAll(c31694o.BtD);
                        }
                    }
                    if (c31694o.eeq()) {
                        m14402e(c31694o.Bux);
                    }
                    mo42015a((C25158c) c31694o);
                    this.BsB = this.BsB.mo51672a(c31694o.BsB);
                    AppMethodBeat.m2505o(120639);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: m */
            private C8164a m14403m(C31713e c31713e, C31715g c31715g) {
                C31694o c31694o;
                Throwable th;
                AppMethodBeat.m2504i(120641);
                C31694o c31694o2 = null;
                try {
                    mo17958e((C31694o) C31694o.BsC.mo157a(c31713e, c31715g));
                    AppMethodBeat.m2505o(120641);
                    return this;
                } catch (C41425k e) {
                    C41425k c41425k = e;
                    c31694o = (C31694o) c41425k.BzY;
                    AppMethodBeat.m2505o(120641);
                    throw c41425k;
                } catch (Throwable th2) {
                    th = th2;
                    c31694o2 = c31694o;
                    if (c31694o2 != null) {
                    }
                    AppMethodBeat.m2505o(120641);
                    throw th;
                }
            }

            /* renamed from: Tk */
            private C8164a m14394Tk(int i) {
                this.BsD |= 1;
                this.BsW = i;
                return this;
            }

            /* renamed from: Tl */
            private C8164a m14395Tl(int i) {
                this.BsD |= 2;
                this.Bus = i;
                return this;
            }

            /* renamed from: Tm */
            private C8164a m14396Tm(int i) {
                this.BsD |= 4;
                this.Buf = i;
                return this;
            }

            /* renamed from: b */
            private C8164a m14399b(C25133aa c25133aa) {
                AppMethodBeat.m2504i(120642);
                if ((this.BsD & 8) != 8 || this.But == C25133aa.eeX()) {
                    this.But = c25133aa;
                } else {
                    this.But = C25133aa.m39555f(this.But).mo42000j(c25133aa).eft();
                }
                this.BsD |= 8;
                AppMethodBeat.m2505o(120642);
                return this;
            }

            /* renamed from: Tn */
            private C8164a m14397Tn(int i) {
                this.BsD |= 16;
                this.Buu = i;
                return this;
            }

            private void edp() {
                AppMethodBeat.m2504i(120643);
                if ((this.BsD & 32) != 32) {
                    this.Btp = new ArrayList(this.Btp);
                    this.BsD |= 32;
                }
                AppMethodBeat.m2505o(120643);
            }

            /* renamed from: c */
            private C8164a m14401c(C25133aa c25133aa) {
                AppMethodBeat.m2504i(120644);
                if ((this.BsD & 64) != 64 || this.Buv == C25133aa.eeX()) {
                    this.Buv = c25133aa;
                } else {
                    this.Buv = C25133aa.m39555f(this.Buv).mo42000j(c25133aa).eft();
                }
                this.BsD |= 64;
                AppMethodBeat.m2505o(120644);
                return this;
            }

            /* renamed from: To */
            private C8164a m14398To(int i) {
                this.BsD |= 128;
                this.Buw = i;
                return this;
            }

            private void edF() {
                AppMethodBeat.m2504i(120645);
                if ((this.BsD & 256) != 256) {
                    this.BtO = new ArrayList(this.BtO);
                    this.BsD |= 256;
                }
                AppMethodBeat.m2505o(120645);
            }

            /* renamed from: b */
            private C8164a m14400b(C36999ag c36999ag) {
                AppMethodBeat.m2504i(120646);
                if ((this.BsD & 512) != 512 || this.BtC == C36999ag.efM()) {
                    this.BtC = c36999ag;
                } else {
                    this.BtC = C36999ag.m61815d(this.BtC).mo42006g(c36999ag).efP();
                }
                this.BsD |= 512;
                AppMethodBeat.m2505o(120646);
                return this;
            }

            private void edz() {
                AppMethodBeat.m2504i(120647);
                if ((this.BsD & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                    this.BtD = new ArrayList(this.BtD);
                    this.BsD |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                }
                AppMethodBeat.m2505o(120647);
            }

            /* renamed from: e */
            private C8164a m14402e(C37013g c37013g) {
                AppMethodBeat.m2504i(120648);
                if ((this.BsD & 2048) != 2048 || this.Bux == C37013g.edH()) {
                    this.Bux = c37013g;
                } else {
                    this.Bux = C37013g.m61894a(this.Bux).mo42009d(c37013g).edK();
                }
                this.BsD |= 2048;
                AppMethodBeat.m2505o(120648);
                return this;
            }

            private C8164a eer() {
                AppMethodBeat.m2504i(120637);
                C8164a e = new C8164a().mo17958e(ees());
                AppMethodBeat.m2505o(120637);
                return e;
            }

            public final boolean isInitialized() {
                boolean z;
                AppMethodBeat.m2504i(120640);
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
                            if (((C37014ae) this.Btp.get(i)).isInitialized()) {
                                i++;
                            } else {
                                AppMethodBeat.m2505o(120640);
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
                                if (((C8154ai) this.BtO.get(i)).isInitialized()) {
                                    i++;
                                } else {
                                    AppMethodBeat.m2505o(120640);
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
                                    AppMethodBeat.m2505o(120640);
                                    return false;
                                } else if (this.BzI.isInitialized()) {
                                    AppMethodBeat.m2505o(120640);
                                    return true;
                                } else {
                                    AppMethodBeat.m2505o(120640);
                                    return false;
                                }
                            }
                            AppMethodBeat.m2505o(120640);
                            return false;
                        }
                        AppMethodBeat.m2505o(120640);
                        return false;
                    }
                    AppMethodBeat.m2505o(120640);
                    return false;
                }
                AppMethodBeat.m2505o(120640);
                return false;
            }

            public final /* synthetic */ C8185q ecE() {
                AppMethodBeat.m2504i(120650);
                C31694o eek = C31694o.eek();
                AppMethodBeat.m2505o(120650);
                return eek;
            }

            public final /* synthetic */ C25155i ecJ() {
                AppMethodBeat.m2504i(120651);
                C31694o eek = C31694o.eek();
                AppMethodBeat.m2505o(120651);
                return eek;
            }

            public final /* synthetic */ C8185q ecM() {
                AppMethodBeat.m2504i(120657);
                C31694o ees = ees();
                if (ees.isInitialized()) {
                    AppMethodBeat.m2505o(120657);
                    return ees;
                }
                C44904w c44904w = new C44904w();
                AppMethodBeat.m2505o(120657);
                throw c44904w;
            }

            static /* synthetic */ C8164a eet() {
                AppMethodBeat.m2504i(120659);
                C8164a c8164a = new C8164a();
                AppMethodBeat.m2505o(120659);
                return c8164a;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$o$1 */
        static class C316931 extends C0117b<C31694o> {
            C316931() {
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo157a(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120635);
                C31694o c31694o = new C31694o(c31713e, c31715g, (byte) 0);
                AppMethodBeat.m2505o(120635);
                return c31694o;
            }
        }

        /* synthetic */ C31694o(C31713e c31713e, C31715g c31715g, byte b) {
            this(c31713e, c31715g);
        }

        private C31694o(C25157b<C31694o, ?> c25157b) {
            super(c25157b);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = c25157b.BsB;
        }

        private C31694o() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = C31710d.Bzq;
        }

        public static C31694o eek() {
            return Bur;
        }

        private C31694o(C31713e c31713e, C31715g c31715g) {
            AppMethodBeat.m2504i(120660);
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            int i = 0;
            C31711b ehS = C31710d.ehS();
            C37024f e = C37024f.m61953e(ehS, 1);
            Object obj = null;
            while (obj == null) {
                try {
                    int vc = c31713e.mo51692vc();
                    C25135c f;
                    switch (vc) {
                        case 0:
                            obj = 1;
                            break;
                        case 8:
                            this.BsD |= 2;
                            this.Bus = c31713e.mo51693vd();
                            break;
                        case 16:
                            this.BsD |= 4;
                            this.Buf = c31713e.mo51693vd();
                            break;
                        case 26:
                            if ((this.BsD & 8) == 8) {
                                f = C25133aa.m39555f(this.But);
                            } else {
                                f = null;
                            }
                            this.But = (C25133aa) c31713e.mo51683a(C25133aa.BsC, c31715g);
                            if (f != null) {
                                f.mo42000j(this.But);
                                this.But = f.eft();
                            }
                            this.BsD |= 8;
                            break;
                        case 34:
                            if ((i & 32) != 32) {
                                this.Btp = new ArrayList();
                                i |= 32;
                            }
                            this.Btp.add(c31713e.mo51683a(C37014ae.BsC, c31715g));
                            break;
                        case 42:
                            if ((this.BsD & 32) == 32) {
                                f = C25133aa.m39555f(this.Buv);
                            } else {
                                f = null;
                            }
                            this.Buv = (C25133aa) c31713e.mo51683a(C25133aa.BsC, c31715g);
                            if (f != null) {
                                f.mo42000j(this.Buv);
                                this.Buv = f.eft();
                            }
                            this.BsD |= 32;
                            break;
                        case 50:
                            if ((i & 256) != 256) {
                                this.BtO = new ArrayList();
                                i |= 256;
                            }
                            this.BtO.add(c31713e.mo51683a(C8154ai.BsC, c31715g));
                            break;
                        case FileUtils.S_IRWXG /*56*/:
                            this.BsD |= 16;
                            this.Buu = c31713e.mo51693vd();
                            break;
                        case 64:
                            this.BsD |= 64;
                            this.Buw = c31713e.mo51693vd();
                            break;
                        case C33279c.CTRL_INDEX /*72*/:
                            this.BsD |= 1;
                            this.BsW = c31713e.mo51693vd();
                            break;
                        case 242:
                            C25141a d;
                            if ((this.BsD & 128) == 128) {
                                d = C36999ag.m61815d(this.BtC);
                            } else {
                                d = null;
                            }
                            this.BtC = (C36999ag) c31713e.mo51683a(C36999ag.BsC, c31715g);
                            if (d != null) {
                                d.mo42006g(this.BtC);
                                this.BtC = d.efP();
                            }
                            this.BsD |= 128;
                            break;
                        case C31128d.MIC_PTU_ZIPAI_THURSDAY /*248*/:
                            if ((i & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                                this.BtD = new ArrayList();
                                i |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                            }
                            this.BtD.add(Integer.valueOf(c31713e.mo51693vd()));
                            break;
                        case 250:
                            vc = c31713e.mo51690fo(c31713e.mo51693vd());
                            if ((i & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && c31713e.mo51695vg() > 0) {
                                this.BtD = new ArrayList();
                                i |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                            }
                            while (c31713e.mo51695vg() > 0) {
                                this.BtD.add(Integer.valueOf(c31713e.mo51693vd()));
                            }
                            c31713e.mo51691fp(vc);
                            break;
                        case C31128d.MIC_PTU_ZIPAI_SAPPORO /*258*/:
                            C25146a edI;
                            if ((this.BsD & 256) == 256) {
                                edI = this.Bux.edI();
                            } else {
                                edI = null;
                            }
                            this.Bux = (C37013g) c31713e.mo51683a(C37013g.BsC, c31715g);
                            if (edI != null) {
                                edI.mo42009d(this.Bux);
                                this.Bux = edI.edK();
                            }
                            this.BsD |= 256;
                            break;
                        default:
                            if (!mo42012a(c31713e, e, c31715g, vc)) {
                                obj = 1;
                                break;
                            }
                            break;
                    }
                } catch (C41425k e2) {
                    e2.BzY = this;
                    AppMethodBeat.m2505o(120660);
                    throw e2;
                } catch (IOException e3) {
                    C41425k c41425k = new C41425k(e3.getMessage());
                    c41425k.BzY = this;
                    AppMethodBeat.m2505o(120660);
                    throw c41425k;
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
                        AppMethodBeat.m2505o(120660);
                    }
                    this.BzI.eii();
                    AppMethodBeat.m2505o(120660);
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
                AppMethodBeat.m2505o(120660);
            }
            this.BzI.eii();
            AppMethodBeat.m2505o(120660);
        }

        static {
            AppMethodBeat.m2504i(120668);
            C31694o c31694o = new C31694o();
            Bur = c31694o;
            c31694o.ecA();
            AppMethodBeat.m2505o(120668);
        }

        public final C25163s<C31694o> ecy() {
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
            AppMethodBeat.m2504i(120661);
            this.BsW = 6;
            this.Bus = 6;
            this.Buf = 0;
            this.But = C25133aa.eeX();
            this.Buu = 0;
            this.Btp = Collections.emptyList();
            this.Buv = C25133aa.eeX();
            this.Buw = 0;
            this.BtO = Collections.emptyList();
            this.BtC = C36999ag.efM();
            this.BtD = Collections.emptyList();
            this.Bux = C37013g.edH();
            AppMethodBeat.m2505o(120661);
        }

        public final boolean isInitialized() {
            AppMethodBeat.m2504i(120662);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.m2505o(120662);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.m2505o(120662);
                return false;
            } else if (!edW()) {
                this.BsG = (byte) 0;
                AppMethodBeat.m2505o(120662);
                return false;
            } else if (!eem() || this.But.isInitialized()) {
                int i = 0;
                while (i < this.Btp.size()) {
                    if (((C37014ae) this.Btp.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120662);
                        return false;
                    }
                }
                if (!eeo() || this.Buv.isInitialized()) {
                    i = 0;
                    while (i < this.BtO.size()) {
                        if (((C8154ai) this.BtO.get(i)).isInitialized()) {
                            i++;
                        } else {
                            this.BsG = (byte) 0;
                            AppMethodBeat.m2505o(120662);
                            return false;
                        }
                    }
                    if (edl() && !this.BtC.isInitialized()) {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120662);
                        return false;
                    } else if (eeq() && !this.Bux.isInitialized()) {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120662);
                        return false;
                    } else if (this.BzI.isInitialized()) {
                        this.BsG = (byte) 1;
                        AppMethodBeat.m2505o(120662);
                        return true;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120662);
                        return false;
                    }
                }
                this.BsG = (byte) 0;
                AppMethodBeat.m2505o(120662);
                return false;
            } else {
                this.BsG = (byte) 0;
                AppMethodBeat.m2505o(120662);
                return false;
            }
        }

        /* renamed from: a */
        public final void mo128a(C37024f c37024f) {
            int i;
            int i2 = 0;
            AppMethodBeat.m2504i(120663);
            mo144vq();
            C8178a eip = eip();
            if ((this.BsD & 2) == 2) {
                c37024f.mo59052bq(1, this.Bus);
            }
            if ((this.BsD & 4) == 4) {
                c37024f.mo59052bq(2, this.Buf);
            }
            if ((this.BsD & 8) == 8) {
                c37024f.mo59046a(3, this.But);
            }
            for (i = 0; i < this.Btp.size(); i++) {
                c37024f.mo59046a(4, (C8185q) this.Btp.get(i));
            }
            if ((this.BsD & 32) == 32) {
                c37024f.mo59046a(5, this.Buv);
            }
            for (i = 0; i < this.BtO.size(); i++) {
                c37024f.mo59046a(6, (C8185q) this.BtO.get(i));
            }
            if ((this.BsD & 16) == 16) {
                c37024f.mo59052bq(7, this.Buu);
            }
            if ((this.BsD & 64) == 64) {
                c37024f.mo59052bq(8, this.Buw);
            }
            if ((this.BsD & 1) == 1) {
                c37024f.mo59052bq(9, this.BsW);
            }
            if ((this.BsD & 128) == 128) {
                c37024f.mo59046a(30, this.BtC);
            }
            while (i2 < this.BtD.size()) {
                c37024f.mo59052bq(31, ((Integer) this.BtD.get(i2)).intValue());
                i2++;
            }
            if ((this.BsD & 256) == 256) {
                c37024f.mo59046a(32, this.Bux);
            }
            eip.mo17990b(19000, c37024f);
            c37024f.mo59056d(this.BsB);
            AppMethodBeat.m2505o(120663);
        }

        /* renamed from: vq */
        public final int mo144vq() {
            AppMethodBeat.m2504i(120664);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.m2505o(120664);
                return i;
            }
            int i2;
            if ((this.BsD & 2) == 2) {
                i = C37024f.m61947bs(1, this.Bus) + 0;
            } else {
                i = 0;
            }
            if ((this.BsD & 4) == 4) {
                i += C37024f.m61947bs(2, this.Buf);
            }
            if ((this.BsD & 8) == 8) {
                i += C37024f.m61948c(3, this.But);
            }
            int i3 = i;
            for (i2 = 0; i2 < this.Btp.size(); i2++) {
                i3 += C37024f.m61948c(4, (C8185q) this.Btp.get(i2));
            }
            if ((this.BsD & 32) == 32) {
                i3 += C37024f.m61948c(5, this.Buv);
            }
            for (i2 = 0; i2 < this.BtO.size(); i2++) {
                i3 += C37024f.m61948c(6, (C8185q) this.BtO.get(i2));
            }
            if ((this.BsD & 16) == 16) {
                i3 += C37024f.m61947bs(7, this.Buu);
            }
            if ((this.BsD & 64) == 64) {
                i3 += C37024f.m61947bs(8, this.Buw);
            }
            if ((this.BsD & 1) == 1) {
                i3 += C37024f.m61947bs(9, this.BsW);
            }
            if ((this.BsD & 128) == 128) {
                i3 += C37024f.m61948c(30, this.BtC);
            }
            i2 = 0;
            int i4 = 0;
            while (i2 < this.BtD.size()) {
                i2++;
                i4 = C37024f.m61954ft(((Integer) this.BtD.get(i2)).intValue()) + i4;
            }
            i = (i3 + i4) + (this.BtD.size() * 2);
            if ((this.BsD & 256) == 256) {
                i += C37024f.m61948c(32, this.Bux);
            }
            i = (i + this.BzI.mo31345vq()) + this.BsB.size();
            this.BsH = i;
            AppMethodBeat.m2505o(120664);
            return i;
        }

        /* renamed from: b */
        public static C31694o m51264b(InputStream inputStream, C31715g c31715g) {
            AppMethodBeat.m2504i(120665);
            C31694o c31694o = (C31694o) BsC.mo190j(inputStream, c31715g);
            AppMethodBeat.m2505o(120665);
            return c31694o;
        }

        public final /* bridge */ /* synthetic */ C8185q ecE() {
            return Bur;
        }

        public final /* synthetic */ C8186a ecC() {
            AppMethodBeat.m2504i(120666);
            C8164a e = C8164a.eet().mo17958e(this);
            AppMethodBeat.m2505o(120666);
            return e;
        }

        public final /* synthetic */ C8186a ecD() {
            AppMethodBeat.m2504i(120667);
            C8164a eet = C8164a.eet();
            AppMethodBeat.m2505o(120667);
            return eet;
        }
    }

    /* renamed from: a.i.b.a.c.e.a$v */
    public interface C31695v extends C8179d {
    }

    /* renamed from: a.i.b.a.c.e.a$y */
    public static final class C31696y extends C25155i implements C8166z {
        public static C25163s<C31696y> BsC = new C316971();
        private static final C31696y BuX;
        private final C31710d BsB;
        private byte BsG;
        private int BsH;
        private C37026o BuY;

        /* renamed from: a.i.b.a.c.e.a$y$a */
        public static final class C17252a extends C25159a<C31696y, C17252a> implements C8166z {
            private int BsD;
            private C37026o BuY = C44903n.BAf;

            /* renamed from: a */
            public final /* synthetic */ C25159a mo147a(C25155i c25155i) {
                AppMethodBeat.m2504i(120802);
                C17252a d = mo31312d((C31696y) c25155i);
                AppMethodBeat.m2505o(120802);
                return d;
            }

            /* renamed from: c */
            public final /* synthetic */ C0115a mo148c(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120804);
                C17252a r = m26714r(c31713e, c31715g);
                AppMethodBeat.m2505o(120804);
                return r;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.m2504i(120809);
                C17252a eeT = eeT();
                AppMethodBeat.m2505o(120809);
                return eeT;
            }

            /* renamed from: d */
            public final /* synthetic */ C8186a mo150d(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120806);
                C17252a r = m26714r(c31713e, c31715g);
                AppMethodBeat.m2505o(120806);
                return r;
            }

            public final /* synthetic */ C25159a ecK() {
                AppMethodBeat.m2504i(120803);
                C17252a eeT = eeT();
                AppMethodBeat.m2505o(120803);
                return eeT;
            }

            public final /* synthetic */ C0115a ecL() {
                AppMethodBeat.m2504i(120805);
                C17252a eeT = eeT();
                AppMethodBeat.m2505o(120805);
                return eeT;
            }

            private C17252a() {
            }

            public final C31696y eeU() {
                AppMethodBeat.m2504i(120797);
                C31696y c31696y = new C31696y((C25159a) this, (byte) 0);
                if ((this.BsD & 1) == 1) {
                    this.BuY = this.BuY.eiA();
                    this.BsD &= -2;
                }
                c31696y.BuY = this.BuY;
                AppMethodBeat.m2505o(120797);
                return c31696y;
            }

            /* renamed from: d */
            public final C17252a mo31312d(C31696y c31696y) {
                AppMethodBeat.m2504i(120798);
                if (c31696y == C31696y.eeR()) {
                    AppMethodBeat.m2505o(120798);
                } else {
                    if (!c31696y.BuY.isEmpty()) {
                        if (this.BuY.isEmpty()) {
                            this.BuY = c31696y.BuY;
                            this.BsD &= -2;
                        } else {
                            eeV();
                            this.BuY.addAll(c31696y.BuY);
                        }
                    }
                    this.BsB = this.BsB.mo51672a(c31696y.BsB);
                    AppMethodBeat.m2505o(120798);
                }
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: r */
            private C17252a m26714r(C31713e c31713e, C31715g c31715g) {
                C31696y c31696y;
                Throwable th;
                AppMethodBeat.m2504i(120799);
                C31696y c31696y2 = null;
                try {
                    mo31312d((C31696y) C31696y.BsC.mo157a(c31713e, c31715g));
                    AppMethodBeat.m2505o(120799);
                    return this;
                } catch (C41425k e) {
                    C41425k c41425k = e;
                    c31696y = (C31696y) c41425k.BzY;
                    AppMethodBeat.m2505o(120799);
                    throw c41425k;
                } catch (Throwable th2) {
                    th = th2;
                    c31696y2 = c31696y;
                    if (c31696y2 != null) {
                    }
                    AppMethodBeat.m2505o(120799);
                    throw th;
                }
            }

            private void eeV() {
                AppMethodBeat.m2504i(120800);
                if ((this.BsD & 1) != 1) {
                    this.BuY = new C44903n(this.BuY);
                    this.BsD |= 1;
                }
                AppMethodBeat.m2505o(120800);
            }

            private C17252a eeT() {
                AppMethodBeat.m2504i(120796);
                C17252a d = new C17252a().mo31312d(eeU());
                AppMethodBeat.m2505o(120796);
                return d;
            }

            public final /* synthetic */ C25155i ecJ() {
                AppMethodBeat.m2504i(120801);
                C31696y eeR = C31696y.eeR();
                AppMethodBeat.m2505o(120801);
                return eeR;
            }

            public final /* synthetic */ C8185q ecM() {
                AppMethodBeat.m2504i(120807);
                C31696y eeU = eeU();
                if (eeU.isInitialized()) {
                    AppMethodBeat.m2505o(120807);
                    return eeU;
                }
                C44904w c44904w = new C44904w();
                AppMethodBeat.m2505o(120807);
                throw c44904w;
            }

            public final /* synthetic */ C8185q ecE() {
                AppMethodBeat.m2504i(120808);
                C31696y eeR = C31696y.eeR();
                AppMethodBeat.m2505o(120808);
                return eeR;
            }

            static /* synthetic */ C17252a eeW() {
                AppMethodBeat.m2504i(120810);
                C17252a c17252a = new C17252a();
                AppMethodBeat.m2505o(120810);
                return c17252a;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$y$1 */
        static class C316971 extends C0117b<C31696y> {
            C316971() {
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo157a(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120795);
                C31696y c31696y = new C31696y(c31713e, c31715g, (byte) 0);
                AppMethodBeat.m2505o(120795);
                return c31696y;
            }
        }

        /* synthetic */ C31696y(C31713e c31713e, C31715g c31715g, byte b) {
            this(c31713e, c31715g);
        }

        public final /* synthetic */ C8186a ecC() {
            AppMethodBeat.m2504i(120817);
            C17252a eeS = eeS();
            AppMethodBeat.m2505o(120817);
            return eeS;
        }

        private C31696y(C25159a c25159a) {
            super((byte) 0);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = c25159a.BsB;
        }

        private C31696y() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = C31710d.Bzq;
        }

        public static C31696y eeR() {
            return BuX;
        }

        private C31696y(C31713e c31713e, C31715g c31715g) {
            AppMethodBeat.m2504i(120811);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BuY = C44903n.BAf;
            C31711b ehS = C31710d.ehS();
            C37024f e = C37024f.m61953e(ehS, 1);
            int i = 0;
            int i2 = 0;
            while (i == 0) {
                try {
                    int vc = c31713e.mo51692vc();
                    switch (vc) {
                        case 0:
                            i = 1;
                            break;
                        case 10:
                            C31710d ehY = c31713e.ehY();
                            if ((i2 & 1) != 1) {
                                this.BuY = new C44903n();
                                i2 |= 1;
                            }
                            this.BuY.mo31353e(ehY);
                            break;
                        default:
                            if (!mo42012a(c31713e, e, c31715g, vc)) {
                                i = 1;
                                break;
                            }
                            break;
                    }
                } catch (C41425k e2) {
                    e2.BzY = this;
                    AppMethodBeat.m2505o(120811);
                    throw e2;
                } catch (IOException e3) {
                    C41425k c41425k = new C41425k(e3.getMessage());
                    c41425k.BzY = this;
                    AppMethodBeat.m2505o(120811);
                    throw c41425k;
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
                        AppMethodBeat.m2505o(120811);
                    }
                    eio();
                    AppMethodBeat.m2505o(120811);
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
                AppMethodBeat.m2505o(120811);
            }
            eio();
            AppMethodBeat.m2505o(120811);
        }

        static {
            AppMethodBeat.m2504i(120819);
            C31696y c31696y = new C31696y();
            BuX = c31696y;
            c31696y.BuY = C44903n.BAf;
            AppMethodBeat.m2505o(120819);
        }

        public final C25163s<C31696y> ecy() {
            return BsC;
        }

        public final String getString(int i) {
            AppMethodBeat.m2504i(120812);
            String str = (String) this.BuY.get(i);
            AppMethodBeat.m2505o(120812);
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

        /* renamed from: a */
        public final void mo128a(C37024f c37024f) {
            AppMethodBeat.m2504i(120813);
            mo144vq();
            for (int i = 0; i < this.BuY.size(); i++) {
                c37024f.mo59045a(1, this.BuY.mo31352UC(i));
            }
            c37024f.mo59056d(this.BsB);
            AppMethodBeat.m2505o(120813);
        }

        /* renamed from: vq */
        public final int mo144vq() {
            int i = 0;
            AppMethodBeat.m2504i(120814);
            int i2 = this.BsH;
            if (i2 != -1) {
                AppMethodBeat.m2505o(120814);
                return i2;
            }
            i2 = 0;
            while (true) {
                int i3 = i;
                if (i2 < this.BuY.size()) {
                    i = C37024f.m61949c(this.BuY.mo31352UC(i2)) + i3;
                    i2++;
                } else {
                    i2 = ((i3 + 0) + (this.BuY.size() * 1)) + this.BsB.size();
                    this.BsH = i2;
                    AppMethodBeat.m2505o(120814);
                    return i2;
                }
            }
        }

        /* renamed from: a */
        public static C17252a m51276a(C31696y c31696y) {
            AppMethodBeat.m2504i(120815);
            C17252a d = C17252a.eeW().mo31312d(c31696y);
            AppMethodBeat.m2505o(120815);
            return d;
        }

        public final C17252a eeS() {
            AppMethodBeat.m2504i(120816);
            C17252a d = C17252a.eeW().mo31312d(this);
            AppMethodBeat.m2505o(120816);
            return d;
        }

        public final /* synthetic */ C8186a ecD() {
            AppMethodBeat.m2504i(120818);
            C17252a eeW = C17252a.eeW();
            AppMethodBeat.m2505o(120818);
            return eeW;
        }

        public final /* bridge */ /* synthetic */ C8185q ecE() {
            return BuX;
        }
    }

    /* renamed from: a.i.b.a.c.e.a$am */
    public static final class C36655am extends C25155i implements C31686an {
        public static C25163s<C36655am> BsC = new C316851();
        private static final C36655am Bwg;
        private final C31710d BsB;
        private byte BsG;
        private int BsH;
        public List<C16485ak> Bwh;

        /* renamed from: a.i.b.a.c.e.a$am$a */
        public static final class C25142a extends C25159a<C36655am, C25142a> implements C31686an {
            private int BsD;
            private List<C16485ak> Bwh = Collections.emptyList();

            /* renamed from: a */
            public final /* synthetic */ C25159a mo147a(C25155i c25155i) {
                AppMethodBeat.m2504i(121045);
                C25142a f = mo42008f((C36655am) c25155i);
                AppMethodBeat.m2505o(121045);
                return f;
            }

            /* renamed from: c */
            public final /* synthetic */ C0115a mo148c(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(121047);
                C25142a z = m39598z(c31713e, c31715g);
                AppMethodBeat.m2505o(121047);
                return z;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.m2504i(121052);
                C25142a egj = egj();
                AppMethodBeat.m2505o(121052);
                return egj;
            }

            /* renamed from: d */
            public final /* synthetic */ C8186a mo150d(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(121049);
                C25142a z = m39598z(c31713e, c31715g);
                AppMethodBeat.m2505o(121049);
                return z;
            }

            public final /* synthetic */ C25159a ecK() {
                AppMethodBeat.m2504i(121046);
                C25142a egj = egj();
                AppMethodBeat.m2505o(121046);
                return egj;
            }

            public final /* synthetic */ C0115a ecL() {
                AppMethodBeat.m2504i(121048);
                C25142a egj = egj();
                AppMethodBeat.m2505o(121048);
                return egj;
            }

            private C25142a() {
                AppMethodBeat.m2504i(121038);
                AppMethodBeat.m2505o(121038);
            }

            public final C36655am egk() {
                AppMethodBeat.m2504i(121040);
                C36655am c36655am = new C36655am((C25159a) this, (byte) 0);
                if ((this.BsD & 1) == 1) {
                    this.Bwh = Collections.unmodifiableList(this.Bwh);
                    this.BsD &= -2;
                }
                c36655am.Bwh = this.Bwh;
                AppMethodBeat.m2505o(121040);
                return c36655am;
            }

            /* renamed from: f */
            public final C25142a mo42008f(C36655am c36655am) {
                AppMethodBeat.m2504i(121041);
                if (c36655am == C36655am.egi()) {
                    AppMethodBeat.m2505o(121041);
                } else {
                    if (!c36655am.Bwh.isEmpty()) {
                        if (this.Bwh.isEmpty()) {
                            this.Bwh = c36655am.Bwh;
                            this.BsD &= -2;
                        } else {
                            egl();
                            this.Bwh.addAll(c36655am.Bwh);
                        }
                    }
                    this.BsB = this.BsB.mo51672a(c36655am.BsB);
                    AppMethodBeat.m2505o(121041);
                }
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: z */
            private C25142a m39598z(C31713e c31713e, C31715g c31715g) {
                C36655am c36655am;
                Throwable th;
                AppMethodBeat.m2504i(121042);
                C36655am c36655am2 = null;
                try {
                    mo42008f((C36655am) C36655am.BsC.mo157a(c31713e, c31715g));
                    AppMethodBeat.m2505o(121042);
                    return this;
                } catch (C41425k e) {
                    C41425k c41425k = e;
                    c36655am = (C36655am) c41425k.BzY;
                    AppMethodBeat.m2505o(121042);
                    throw c41425k;
                } catch (Throwable th2) {
                    th = th2;
                    c36655am2 = c36655am;
                    if (c36655am2 != null) {
                    }
                    AppMethodBeat.m2505o(121042);
                    throw th;
                }
            }

            private void egl() {
                AppMethodBeat.m2504i(121043);
                if ((this.BsD & 1) != 1) {
                    this.Bwh = new ArrayList(this.Bwh);
                    this.BsD |= 1;
                }
                AppMethodBeat.m2505o(121043);
            }

            private C25142a egj() {
                AppMethodBeat.m2504i(121039);
                C25142a f = new C25142a().mo42008f(egk());
                AppMethodBeat.m2505o(121039);
                return f;
            }

            public final /* synthetic */ C25155i ecJ() {
                AppMethodBeat.m2504i(121044);
                C36655am egi = C36655am.egi();
                AppMethodBeat.m2505o(121044);
                return egi;
            }

            public final /* synthetic */ C8185q ecM() {
                AppMethodBeat.m2504i(121050);
                C36655am egk = egk();
                if (egk.isInitialized()) {
                    AppMethodBeat.m2505o(121050);
                    return egk;
                }
                C44904w c44904w = new C44904w();
                AppMethodBeat.m2505o(121050);
                throw c44904w;
            }

            public final /* synthetic */ C8185q ecE() {
                AppMethodBeat.m2504i(121051);
                C36655am egi = C36655am.egi();
                AppMethodBeat.m2505o(121051);
                return egi;
            }

            static /* synthetic */ C25142a egm() {
                AppMethodBeat.m2504i(121053);
                C25142a c25142a = new C25142a();
                AppMethodBeat.m2505o(121053);
                return c25142a;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$am$1 */
        static class C316851 extends C0117b<C36655am> {
            C316851() {
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo157a(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(121037);
                C36655am c36655am = new C36655am(c31713e, c31715g, (byte) 0);
                AppMethodBeat.m2505o(121037);
                return c36655am;
            }
        }

        /* synthetic */ C36655am(C31713e c31713e, C31715g c31715g, byte b) {
            this(c31713e, c31715g);
        }

        private C36655am(C25159a c25159a) {
            super((byte) 0);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = c25159a.BsB;
        }

        private C36655am() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = C31710d.Bzq;
        }

        public static C36655am egi() {
            return Bwg;
        }

        private C36655am(C31713e c31713e, C31715g c31715g) {
            AppMethodBeat.m2504i(121054);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.Bwh = Collections.emptyList();
            C31711b ehS = C31710d.ehS();
            C37024f e = C37024f.m61953e(ehS, 1);
            int i = 0;
            int i2 = 0;
            while (i == 0) {
                try {
                    int vc = c31713e.mo51692vc();
                    switch (vc) {
                        case 0:
                            i = 1;
                            break;
                        case 10:
                            if ((i2 & 1) != 1) {
                                this.Bwh = new ArrayList();
                                i2 |= 1;
                            }
                            this.Bwh.add(c31713e.mo51683a(C16485ak.BsC, c31715g));
                            break;
                        default:
                            if (!mo42012a(c31713e, e, c31715g, vc)) {
                                i = 1;
                                break;
                            }
                            break;
                    }
                } catch (C41425k e2) {
                    e2.BzY = this;
                    AppMethodBeat.m2505o(121054);
                    throw e2;
                } catch (IOException e3) {
                    C41425k c41425k = new C41425k(e3.getMessage());
                    c41425k.BzY = this;
                    AppMethodBeat.m2505o(121054);
                    throw c41425k;
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
                        AppMethodBeat.m2505o(121054);
                    }
                    eio();
                    AppMethodBeat.m2505o(121054);
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
                AppMethodBeat.m2505o(121054);
            }
            eio();
            AppMethodBeat.m2505o(121054);
        }

        static {
            AppMethodBeat.m2504i(121060);
            C36655am c36655am = new C36655am();
            Bwg = c36655am;
            c36655am.Bwh = Collections.emptyList();
            AppMethodBeat.m2505o(121060);
        }

        public final C25163s<C36655am> ecy() {
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

        /* renamed from: a */
        public final void mo128a(C37024f c37024f) {
            AppMethodBeat.m2504i(121055);
            mo144vq();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.Bwh.size()) {
                    c37024f.mo59046a(1, (C8185q) this.Bwh.get(i2));
                    i = i2 + 1;
                } else {
                    c37024f.mo59056d(this.BsB);
                    AppMethodBeat.m2505o(121055);
                    return;
                }
            }
        }

        /* renamed from: vq */
        public final int mo144vq() {
            AppMethodBeat.m2504i(121056);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.m2505o(121056);
                return i;
            }
            int i2 = 0;
            for (i = 0; i < this.Bwh.size(); i++) {
                i2 += C37024f.m61948c(1, (C8185q) this.Bwh.get(i));
            }
            int size = this.BsB.size() + i2;
            this.BsH = size;
            AppMethodBeat.m2505o(121056);
            return size;
        }

        /* renamed from: c */
        public static C25142a m60755c(C36655am c36655am) {
            AppMethodBeat.m2504i(121057);
            C25142a f = C25142a.egm().mo42008f(c36655am);
            AppMethodBeat.m2505o(121057);
            return f;
        }

        public final /* synthetic */ C8186a ecC() {
            AppMethodBeat.m2504i(121058);
            C25142a f = C25142a.egm().mo42008f(this);
            AppMethodBeat.m2505o(121058);
            return f;
        }

        public final /* synthetic */ C8186a ecD() {
            AppMethodBeat.m2504i(121059);
            C25142a egm = C25142a.egm();
            AppMethodBeat.m2505o(121059);
            return egm;
        }

        public final /* bridge */ /* synthetic */ C8185q ecE() {
            return Bwg;
        }
    }

    /* renamed from: a.i.b.a.c.e.a$u */
    public static final class C36656u extends C25158c<C36656u> implements C31695v {
        public static C25163s<C36656u> BsC = new C366571();
        private static final C36656u BuJ;
        private final C31710d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        public int BsW;
        public List<Integer> BtD;
        public List<C37014ae> Btp;
        public C8154ai BuK;
        public int BuL;
        public int BuM;
        public int Buf;
        public int Bus;
        public C25133aa But;
        public int Buu;
        public C25133aa Buv;
        public int Buw;

        /* renamed from: a.i.b.a.c.e.a$u$a */
        public static final class C17249a extends C25157b<C36656u, C17249a> implements C31695v {
            private int BsD;
            private int BsW = C33332f.CTRL_INDEX;
            private List<Integer> BtD = Collections.emptyList();
            private List<C37014ae> Btp = Collections.emptyList();
            private C8154ai BuK = C8154ai.efS();
            private int BuL;
            private int BuM;
            private int Buf;
            private int Bus = 2054;
            private C25133aa But = C25133aa.eeX();
            private int Buu;
            private C25133aa Buv = C25133aa.eeX();
            private int Buw;

            /* renamed from: c */
            public final /* synthetic */ C0115a mo148c(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120726);
                C17249a o = m26700o(c31713e, c31715g);
                AppMethodBeat.m2505o(120726);
                return o;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.m2504i(120730);
                C17249a eeC = eeC();
                AppMethodBeat.m2505o(120730);
                return eeC;
            }

            /* renamed from: d */
            public final /* synthetic */ C8186a mo150d(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120728);
                C17249a o = m26700o(c31713e, c31715g);
                AppMethodBeat.m2505o(120728);
                return o;
            }

            public final /* synthetic */ C25159a ecK() {
                AppMethodBeat.m2504i(120725);
                C17249a eeC = eeC();
                AppMethodBeat.m2505o(120725);
                return eeC;
            }

            public final /* synthetic */ C0115a ecL() {
                AppMethodBeat.m2504i(120727);
                C17249a eeC = eeC();
                AppMethodBeat.m2505o(120727);
                return eeC;
            }

            public final /* synthetic */ C25157b edA() {
                AppMethodBeat.m2504i(120721);
                C17249a eeC = eeC();
                AppMethodBeat.m2505o(120721);
                return eeC;
            }

            private C17249a() {
                AppMethodBeat.m2504i(120710);
                AppMethodBeat.m2505o(120710);
            }

            private C36656u eeD() {
                int i = 1;
                AppMethodBeat.m2504i(120712);
                C36656u c36656u = new C36656u((C25157b) this, (byte) 0);
                int i2 = this.BsD;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                c36656u.BsW = this.BsW;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                c36656u.Bus = this.Bus;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                c36656u.Buf = this.Buf;
                if ((i2 & 8) == 8) {
                    i |= 8;
                }
                c36656u.But = this.But;
                if ((i2 & 16) == 16) {
                    i |= 16;
                }
                c36656u.Buu = this.Buu;
                if ((this.BsD & 32) == 32) {
                    this.Btp = Collections.unmodifiableList(this.Btp);
                    this.BsD &= -33;
                }
                c36656u.Btp = this.Btp;
                if ((i2 & 64) == 64) {
                    i |= 32;
                }
                c36656u.Buv = this.Buv;
                if ((i2 & 128) == 128) {
                    i |= 64;
                }
                c36656u.Buw = this.Buw;
                if ((i2 & 256) == 256) {
                    i |= 128;
                }
                c36656u.BuK = this.BuK;
                if ((i2 & 512) == 512) {
                    i |= 256;
                }
                c36656u.BuL = this.BuL;
                if ((i2 & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                    i |= 512;
                }
                c36656u.BuM = this.BuM;
                if ((this.BsD & 2048) == 2048) {
                    this.BtD = Collections.unmodifiableList(this.BtD);
                    this.BsD &= -2049;
                }
                c36656u.BtD = this.BtD;
                c36656u.BsD = i;
                AppMethodBeat.m2505o(120712);
                return c36656u;
            }

            /* renamed from: d */
            public final C17249a mo31310d(C36656u c36656u) {
                AppMethodBeat.m2504i(120713);
                if (c36656u == C36656u.eey()) {
                    AppMethodBeat.m2505o(120713);
                } else {
                    if (c36656u.ecY()) {
                        m26690Tr(c36656u.BsW);
                    }
                    if (c36656u.eel()) {
                        m26691Ts(c36656u.Bus);
                    }
                    if (c36656u.edW()) {
                        m26692Tt(c36656u.Buf);
                    }
                    if (c36656u.eem()) {
                        m26698d(c36656u.But);
                    }
                    if (c36656u.een()) {
                        m26693Tu(c36656u.Buu);
                    }
                    if (!c36656u.Btp.isEmpty()) {
                        if (this.Btp.isEmpty()) {
                            this.Btp = c36656u.Btp;
                            this.BsD &= -33;
                        } else {
                            edp();
                            this.Btp.addAll(c36656u.Btp);
                        }
                    }
                    if (c36656u.eeo()) {
                        m26699e(c36656u.Buv);
                    }
                    if (c36656u.eep()) {
                        m26694Tv(c36656u.Buw);
                    }
                    if (c36656u.eez()) {
                        m26697a(c36656u.BuK);
                    }
                    if (c36656u.eeA()) {
                        m26695Tw(c36656u.BuL);
                    }
                    if (c36656u.eeB()) {
                        m26696Tx(c36656u.BuM);
                    }
                    if (!c36656u.BtD.isEmpty()) {
                        if (this.BtD.isEmpty()) {
                            this.BtD = c36656u.BtD;
                            this.BsD &= -2049;
                        } else {
                            edz();
                            this.BtD.addAll(c36656u.BtD);
                        }
                    }
                    mo42015a((C25158c) c36656u);
                    this.BsB = this.BsB.mo51672a(c36656u.BsB);
                    AppMethodBeat.m2505o(120713);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: o */
            private C17249a m26700o(C31713e c31713e, C31715g c31715g) {
                C36656u c36656u;
                Throwable th;
                AppMethodBeat.m2504i(120715);
                C36656u c36656u2 = null;
                try {
                    mo31310d((C36656u) C36656u.BsC.mo157a(c31713e, c31715g));
                    AppMethodBeat.m2505o(120715);
                    return this;
                } catch (C41425k e) {
                    C41425k c41425k = e;
                    c36656u = (C36656u) c41425k.BzY;
                    AppMethodBeat.m2505o(120715);
                    throw c41425k;
                } catch (Throwable th2) {
                    th = th2;
                    c36656u2 = c36656u;
                    if (c36656u2 != null) {
                    }
                    AppMethodBeat.m2505o(120715);
                    throw th;
                }
            }

            /* renamed from: Tr */
            private C17249a m26690Tr(int i) {
                this.BsD |= 1;
                this.BsW = i;
                return this;
            }

            /* renamed from: Ts */
            private C17249a m26691Ts(int i) {
                this.BsD |= 2;
                this.Bus = i;
                return this;
            }

            /* renamed from: Tt */
            private C17249a m26692Tt(int i) {
                this.BsD |= 4;
                this.Buf = i;
                return this;
            }

            /* renamed from: d */
            private C17249a m26698d(C25133aa c25133aa) {
                AppMethodBeat.m2504i(120716);
                if ((this.BsD & 8) != 8 || this.But == C25133aa.eeX()) {
                    this.But = c25133aa;
                } else {
                    this.But = C25133aa.m39555f(this.But).mo42000j(c25133aa).eft();
                }
                this.BsD |= 8;
                AppMethodBeat.m2505o(120716);
                return this;
            }

            /* renamed from: Tu */
            private C17249a m26693Tu(int i) {
                this.BsD |= 16;
                this.Buu = i;
                return this;
            }

            private void edp() {
                AppMethodBeat.m2504i(120717);
                if ((this.BsD & 32) != 32) {
                    this.Btp = new ArrayList(this.Btp);
                    this.BsD |= 32;
                }
                AppMethodBeat.m2505o(120717);
            }

            /* renamed from: e */
            private C17249a m26699e(C25133aa c25133aa) {
                AppMethodBeat.m2504i(120718);
                if ((this.BsD & 64) != 64 || this.Buv == C25133aa.eeX()) {
                    this.Buv = c25133aa;
                } else {
                    this.Buv = C25133aa.m39555f(this.Buv).mo42000j(c25133aa).eft();
                }
                this.BsD |= 64;
                AppMethodBeat.m2505o(120718);
                return this;
            }

            /* renamed from: Tv */
            private C17249a m26694Tv(int i) {
                this.BsD |= 128;
                this.Buw = i;
                return this;
            }

            /* renamed from: a */
            private C17249a m26697a(C8154ai c8154ai) {
                AppMethodBeat.m2504i(120719);
                if ((this.BsD & 256) != 256 || this.BuK == C8154ai.efS()) {
                    this.BuK = c8154ai;
                } else {
                    this.BuK = C8154ai.m14365b(this.BuK).mo17955d(c8154ai).efW();
                }
                this.BsD |= 256;
                AppMethodBeat.m2505o(120719);
                return this;
            }

            /* renamed from: Tw */
            private C17249a m26695Tw(int i) {
                this.BsD |= 512;
                this.BuL = i;
                return this;
            }

            /* renamed from: Tx */
            private C17249a m26696Tx(int i) {
                this.BsD |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                this.BuM = i;
                return this;
            }

            private void edz() {
                AppMethodBeat.m2504i(120720);
                if ((this.BsD & 2048) != 2048) {
                    this.BtD = new ArrayList(this.BtD);
                    this.BsD |= 2048;
                }
                AppMethodBeat.m2505o(120720);
            }

            private C17249a eeC() {
                AppMethodBeat.m2504i(120711);
                C17249a d = new C17249a().mo31310d(eeD());
                AppMethodBeat.m2505o(120711);
                return d;
            }

            public final boolean isInitialized() {
                boolean z;
                AppMethodBeat.m2504i(120714);
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
                            if (((C37014ae) this.Btp.get(i)).isInitialized()) {
                                i++;
                            } else {
                                AppMethodBeat.m2505o(120714);
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
                                AppMethodBeat.m2505o(120714);
                                return false;
                            } else if (this.BzI.isInitialized()) {
                                AppMethodBeat.m2505o(120714);
                                return true;
                            } else {
                                AppMethodBeat.m2505o(120714);
                                return false;
                            }
                        }
                        AppMethodBeat.m2505o(120714);
                        return false;
                    }
                    AppMethodBeat.m2505o(120714);
                    return false;
                }
                AppMethodBeat.m2505o(120714);
                return false;
            }

            public final /* synthetic */ C8185q ecE() {
                AppMethodBeat.m2504i(120722);
                C36656u eey = C36656u.eey();
                AppMethodBeat.m2505o(120722);
                return eey;
            }

            public final /* synthetic */ C25155i ecJ() {
                AppMethodBeat.m2504i(120723);
                C36656u eey = C36656u.eey();
                AppMethodBeat.m2505o(120723);
                return eey;
            }

            public final /* synthetic */ C8185q ecM() {
                AppMethodBeat.m2504i(120729);
                C36656u eeD = eeD();
                if (eeD.isInitialized()) {
                    AppMethodBeat.m2505o(120729);
                    return eeD;
                }
                C44904w c44904w = new C44904w();
                AppMethodBeat.m2505o(120729);
                throw c44904w;
            }

            static /* synthetic */ C17249a eeE() {
                AppMethodBeat.m2504i(120731);
                C17249a c17249a = new C17249a();
                AppMethodBeat.m2505o(120731);
                return c17249a;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$u$1 */
        static class C366571 extends C0117b<C36656u> {
            C366571() {
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo157a(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120709);
                C36656u c36656u = new C36656u(c31713e, c31715g, (byte) 0);
                AppMethodBeat.m2505o(120709);
                return c36656u;
            }
        }

        /* synthetic */ C36656u(C31713e c31713e, C31715g c31715g, byte b) {
            this(c31713e, c31715g);
        }

        private C36656u(C25157b<C36656u, ?> c25157b) {
            super(c25157b);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = c25157b.BsB;
        }

        private C36656u() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = C31710d.Bzq;
        }

        public static C36656u eey() {
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
        private C36656u(C31713e c31713e, C31715g c31715g) {
            C41425k c41425k;
            int i;
            Throwable th;
            IOException iOException;
            C41425k c41425k2;
            AppMethodBeat.m2504i(120732);
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            int i2 = 0;
            C31711b ehS = C31710d.ehS();
            C37024f e = C37024f.m61953e(ehS, 1);
            int i3 = 0;
            while (i3 == 0) {
                try {
                    int vc = c31713e.mo51692vc();
                    C25135c f;
                    switch (vc) {
                        case 0:
                            i3 = 1;
                            break;
                        case 8:
                            this.BsD |= 2;
                            this.Bus = c31713e.mo51693vd();
                            break;
                        case 16:
                            this.BsD |= 4;
                            this.Buf = c31713e.mo51693vd();
                            break;
                        case 26:
                            if ((this.BsD & 8) == 8) {
                                f = C25133aa.m39555f(this.But);
                            } else {
                                f = null;
                            }
                            this.But = (C25133aa) c31713e.mo51683a(C25133aa.BsC, c31715g);
                            if (f != null) {
                                f.mo42000j(this.But);
                                this.But = f.eft();
                            }
                            this.BsD |= 8;
                            break;
                        case 34:
                            if ((i2 & 32) != 32) {
                                this.Btp = new ArrayList();
                                i2 |= 32;
                            }
                            this.Btp.add(c31713e.mo51683a(C37014ae.BsC, c31715g));
                            break;
                        case 42:
                            if ((this.BsD & 32) == 32) {
                                f = C25133aa.m39555f(this.Buv);
                            } else {
                                f = null;
                            }
                            this.Buv = (C25133aa) c31713e.mo51683a(C25133aa.BsC, c31715g);
                            if (f != null) {
                                f.mo42000j(this.Buv);
                                this.Buv = f.eft();
                            }
                            this.BsD |= 32;
                            break;
                        case 50:
                            C8155a b;
                            if ((this.BsD & 128) == 128) {
                                b = C8154ai.m14365b(this.BuK);
                            } else {
                                b = null;
                            }
                            this.BuK = (C8154ai) c31713e.mo51683a(C8154ai.BsC, c31715g);
                            if (b != null) {
                                b.mo17955d(this.BuK);
                                this.BuK = b.efW();
                            }
                            this.BsD |= 128;
                            break;
                        case FileUtils.S_IRWXG /*56*/:
                            this.BsD |= 256;
                            this.BuL = c31713e.mo51693vd();
                            break;
                        case 64:
                            this.BsD |= 512;
                            this.BuM = c31713e.mo51693vd();
                            break;
                        case C33279c.CTRL_INDEX /*72*/:
                            this.BsD |= 16;
                            this.Buu = c31713e.mo51693vd();
                            break;
                        case 80:
                            this.BsD |= 64;
                            this.Buw = c31713e.mo51693vd();
                            break;
                        case 88:
                            this.BsD |= 1;
                            this.BsW = c31713e.mo51693vd();
                            break;
                        case C31128d.MIC_PTU_ZIPAI_THURSDAY /*248*/:
                            if ((i2 & 2048) != 2048) {
                                this.BtD = new ArrayList();
                                i2 |= 2048;
                            }
                            this.BtD.add(Integer.valueOf(c31713e.mo51693vd()));
                            break;
                        case 250:
                            int fo = c31713e.mo51690fo(c31713e.mo51693vd());
                            if ((i2 & 2048) == 2048 || c31713e.mo51695vg() <= 0) {
                                vc = i2;
                            } else {
                                this.BtD = new ArrayList();
                                vc = i2 | 2048;
                            }
                            while (c31713e.mo51695vg() > 0) {
                                try {
                                    this.BtD.add(Integer.valueOf(c31713e.mo51693vd()));
                                } catch (C41425k e2) {
                                    c41425k = e2;
                                    i = vc;
                                    try {
                                        c41425k.BzY = this;
                                        AppMethodBeat.m2505o(120732);
                                        throw c41425k;
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
                                            AppMethodBeat.m2505o(120732);
                                        }
                                        this.BzI.eii();
                                        AppMethodBeat.m2505o(120732);
                                        throw th;
                                    }
                                } catch (IOException e4) {
                                    iOException = e4;
                                    i = vc;
                                    c41425k2 = new C41425k(iOException.getMessage());
                                    c41425k2.BzY = this;
                                    AppMethodBeat.m2505o(120732);
                                    throw c41425k2;
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
                                    AppMethodBeat.m2505o(120732);
                                    throw th;
                                }
                            }
                            c31713e.mo51691fp(fo);
                            break;
                        default:
                            if (!mo42012a(c31713e, e, c31715g, vc)) {
                                i3 = 1;
                                break;
                            } else {
                                vc = i2;
                                break;
                            }
                    }
                } catch (C41425k c41425k22) {
                    c41425k = c41425k22;
                    i = i2;
                    c41425k.BzY = this;
                    AppMethodBeat.m2505o(120732);
                    throw c41425k;
                } catch (IOException e5) {
                    iOException = e5;
                    i = i2;
                    c41425k22 = new C41425k(iOException.getMessage());
                    c41425k22.BzY = this;
                    AppMethodBeat.m2505o(120732);
                    throw c41425k22;
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
                    AppMethodBeat.m2505o(120732);
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
                AppMethodBeat.m2505o(120732);
            }
            this.BzI.eii();
            AppMethodBeat.m2505o(120732);
        }

        static {
            AppMethodBeat.m2504i(120739);
            C36656u c36656u = new C36656u();
            BuJ = c36656u;
            c36656u.ecA();
            AppMethodBeat.m2505o(120739);
        }

        public final C25163s<C36656u> ecy() {
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
            AppMethodBeat.m2504i(120733);
            this.BsW = C33332f.CTRL_INDEX;
            this.Bus = 2054;
            this.Buf = 0;
            this.But = C25133aa.eeX();
            this.Buu = 0;
            this.Btp = Collections.emptyList();
            this.Buv = C25133aa.eeX();
            this.Buw = 0;
            this.BuK = C8154ai.efS();
            this.BuL = 0;
            this.BuM = 0;
            this.BtD = Collections.emptyList();
            AppMethodBeat.m2505o(120733);
        }

        public final boolean isInitialized() {
            AppMethodBeat.m2504i(120734);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.m2505o(120734);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.m2505o(120734);
                return false;
            } else if (!edW()) {
                this.BsG = (byte) 0;
                AppMethodBeat.m2505o(120734);
                return false;
            } else if (!eem() || this.But.isInitialized()) {
                int i = 0;
                while (i < this.Btp.size()) {
                    if (((C37014ae) this.Btp.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120734);
                        return false;
                    }
                }
                if (eeo() && !this.Buv.isInitialized()) {
                    this.BsG = (byte) 0;
                    AppMethodBeat.m2505o(120734);
                    return false;
                } else if (eez() && !this.BuK.isInitialized()) {
                    this.BsG = (byte) 0;
                    AppMethodBeat.m2505o(120734);
                    return false;
                } else if (this.BzI.isInitialized()) {
                    this.BsG = (byte) 1;
                    AppMethodBeat.m2505o(120734);
                    return true;
                } else {
                    this.BsG = (byte) 0;
                    AppMethodBeat.m2505o(120734);
                    return false;
                }
            } else {
                this.BsG = (byte) 0;
                AppMethodBeat.m2505o(120734);
                return false;
            }
        }

        /* renamed from: a */
        public final void mo128a(C37024f c37024f) {
            int i = 0;
            AppMethodBeat.m2504i(120735);
            mo144vq();
            C8178a eip = eip();
            if ((this.BsD & 2) == 2) {
                c37024f.mo59052bq(1, this.Bus);
            }
            if ((this.BsD & 4) == 4) {
                c37024f.mo59052bq(2, this.Buf);
            }
            if ((this.BsD & 8) == 8) {
                c37024f.mo59046a(3, this.But);
            }
            for (int i2 = 0; i2 < this.Btp.size(); i2++) {
                c37024f.mo59046a(4, (C8185q) this.Btp.get(i2));
            }
            if ((this.BsD & 32) == 32) {
                c37024f.mo59046a(5, this.Buv);
            }
            if ((this.BsD & 128) == 128) {
                c37024f.mo59046a(6, this.BuK);
            }
            if ((this.BsD & 256) == 256) {
                c37024f.mo59052bq(7, this.BuL);
            }
            if ((this.BsD & 512) == 512) {
                c37024f.mo59052bq(8, this.BuM);
            }
            if ((this.BsD & 16) == 16) {
                c37024f.mo59052bq(9, this.Buu);
            }
            if ((this.BsD & 64) == 64) {
                c37024f.mo59052bq(10, this.Buw);
            }
            if ((this.BsD & 1) == 1) {
                c37024f.mo59052bq(11, this.BsW);
            }
            while (i < this.BtD.size()) {
                c37024f.mo59052bq(31, ((Integer) this.BtD.get(i)).intValue());
                i++;
            }
            eip.mo17990b(19000, c37024f);
            c37024f.mo59056d(this.BsB);
            AppMethodBeat.m2505o(120735);
        }

        /* renamed from: vq */
        public final int mo144vq() {
            AppMethodBeat.m2504i(120736);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.m2505o(120736);
                return i;
            }
            int i2;
            if ((this.BsD & 2) == 2) {
                i = C37024f.m61947bs(1, this.Bus) + 0;
            } else {
                i = 0;
            }
            if ((this.BsD & 4) == 4) {
                i += C37024f.m61947bs(2, this.Buf);
            }
            if ((this.BsD & 8) == 8) {
                i += C37024f.m61948c(3, this.But);
            }
            int i3 = i;
            for (i2 = 0; i2 < this.Btp.size(); i2++) {
                i3 += C37024f.m61948c(4, (C8185q) this.Btp.get(i2));
            }
            if ((this.BsD & 32) == 32) {
                i3 += C37024f.m61948c(5, this.Buv);
            }
            if ((this.BsD & 128) == 128) {
                i3 += C37024f.m61948c(6, this.BuK);
            }
            if ((this.BsD & 256) == 256) {
                i3 += C37024f.m61947bs(7, this.BuL);
            }
            if ((this.BsD & 512) == 512) {
                i3 += C37024f.m61947bs(8, this.BuM);
            }
            if ((this.BsD & 16) == 16) {
                i3 += C37024f.m61947bs(9, this.Buu);
            }
            if ((this.BsD & 64) == 64) {
                i3 += C37024f.m61947bs(10, this.Buw);
            }
            if ((this.BsD & 1) == 1) {
                i3 += C37024f.m61947bs(11, this.BsW);
            }
            i2 = 0;
            int i4 = 0;
            while (i2 < this.BtD.size()) {
                i2++;
                i4 = C37024f.m61954ft(((Integer) this.BtD.get(i2)).intValue()) + i4;
            }
            i = (((i3 + i4) + (this.BtD.size() * 2)) + this.BzI.mo31345vq()) + this.BsB.size();
            this.BsH = i;
            AppMethodBeat.m2505o(120736);
            return i;
        }

        public final /* bridge */ /* synthetic */ C8185q ecE() {
            return BuJ;
        }

        public final /* synthetic */ C8186a ecC() {
            AppMethodBeat.m2504i(120737);
            C17249a d = C17249a.eeE().mo31310d(this);
            AppMethodBeat.m2505o(120737);
            return d;
        }

        public final /* synthetic */ C8186a ecD() {
            AppMethodBeat.m2504i(120738);
            C17249a eeE = C17249a.eeE();
            AppMethodBeat.m2505o(120738);
            return eeE;
        }
    }

    /* renamed from: a.i.b.a.c.e.a$ag */
    public static final class C36999ag extends C25155i implements C37016ah {
        public static C25163s<C36999ag> BsC = new C251401();
        private static final C36999ag BvL;
        private final C31710d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        public List<C25133aa> BvM;
        public int BvN;

        /* renamed from: a.i.b.a.c.e.a$ag$1 */
        static class C251401 extends C0117b<C36999ag> {
            C251401() {
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo157a(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120950);
                C36999ag c36999ag = new C36999ag(c31713e, c31715g, (byte) 0);
                AppMethodBeat.m2505o(120950);
                return c36999ag;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$ag$a */
        public static final class C25141a extends C25159a<C36999ag, C25141a> implements C37016ah {
            private int BsD;
            private List<C25133aa> BvM = Collections.emptyList();
            private int BvN = -1;

            /* renamed from: a */
            public final /* synthetic */ C25159a mo147a(C25155i c25155i) {
                AppMethodBeat.m2504i(120959);
                C25141a g = mo42006g((C36999ag) c25155i);
                AppMethodBeat.m2505o(120959);
                return g;
            }

            /* renamed from: c */
            public final /* synthetic */ C0115a mo148c(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120961);
                C25141a w = m39593w(c31713e, c31715g);
                AppMethodBeat.m2505o(120961);
                return w;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.m2504i(120966);
                C25141a efO = efO();
                AppMethodBeat.m2505o(120966);
                return efO;
            }

            /* renamed from: d */
            public final /* synthetic */ C8186a mo150d(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120963);
                C25141a w = m39593w(c31713e, c31715g);
                AppMethodBeat.m2505o(120963);
                return w;
            }

            public final /* synthetic */ C25159a ecK() {
                AppMethodBeat.m2504i(120960);
                C25141a efO = efO();
                AppMethodBeat.m2505o(120960);
                return efO;
            }

            public final /* synthetic */ C0115a ecL() {
                AppMethodBeat.m2504i(120962);
                C25141a efO = efO();
                AppMethodBeat.m2505o(120962);
                return efO;
            }

            private C25141a() {
                AppMethodBeat.m2504i(120951);
                AppMethodBeat.m2505o(120951);
            }

            public final C36999ag efP() {
                int i = 1;
                AppMethodBeat.m2504i(120953);
                C36999ag c36999ag = new C36999ag((C25159a) this, (byte) 0);
                int i2 = this.BsD;
                if ((this.BsD & 1) == 1) {
                    this.BvM = Collections.unmodifiableList(this.BvM);
                    this.BsD &= -2;
                }
                c36999ag.BvM = this.BvM;
                if ((i2 & 2) != 2) {
                    i = 0;
                }
                c36999ag.BvN = this.BvN;
                c36999ag.BsD = i;
                AppMethodBeat.m2505o(120953);
                return c36999ag;
            }

            /* renamed from: g */
            public final C25141a mo42006g(C36999ag c36999ag) {
                AppMethodBeat.m2504i(120954);
                if (c36999ag == C36999ag.efM()) {
                    AppMethodBeat.m2505o(120954);
                } else {
                    if (!c36999ag.BvM.isEmpty()) {
                        if (this.BvM.isEmpty()) {
                            this.BvM = c36999ag.BvM;
                            this.BsD &= -2;
                        } else {
                            efQ();
                            this.BvM.addAll(c36999ag.BvM);
                        }
                    }
                    if (c36999ag.efN()) {
                        m39592TU(c36999ag.BvN);
                    }
                    this.BsB = this.BsB.mo51672a(c36999ag.BsB);
                    AppMethodBeat.m2505o(120954);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: w */
            private C25141a m39593w(C31713e c31713e, C31715g c31715g) {
                C36999ag c36999ag;
                Throwable th;
                AppMethodBeat.m2504i(120956);
                C36999ag c36999ag2 = null;
                try {
                    mo42006g((C36999ag) C36999ag.BsC.mo157a(c31713e, c31715g));
                    AppMethodBeat.m2505o(120956);
                    return this;
                } catch (C41425k e) {
                    C41425k c41425k = e;
                    c36999ag = (C36999ag) c41425k.BzY;
                    AppMethodBeat.m2505o(120956);
                    throw c41425k;
                } catch (Throwable th2) {
                    th = th2;
                    c36999ag2 = c36999ag;
                    if (c36999ag2 != null) {
                    }
                    AppMethodBeat.m2505o(120956);
                    throw th;
                }
            }

            private void efQ() {
                AppMethodBeat.m2504i(120957);
                if ((this.BsD & 1) != 1) {
                    this.BvM = new ArrayList(this.BvM);
                    this.BsD |= 1;
                }
                AppMethodBeat.m2505o(120957);
            }

            /* renamed from: TU */
            private C25141a m39592TU(int i) {
                this.BsD |= 2;
                this.BvN = i;
                return this;
            }

            private C25141a efO() {
                AppMethodBeat.m2504i(120952);
                C25141a g = new C25141a().mo42006g(efP());
                AppMethodBeat.m2505o(120952);
                return g;
            }

            public final boolean isInitialized() {
                AppMethodBeat.m2504i(120955);
                int i = 0;
                while (i < this.BvM.size()) {
                    if (((C25133aa) this.BvM.get(i)).isInitialized()) {
                        i++;
                    } else {
                        AppMethodBeat.m2505o(120955);
                        return false;
                    }
                }
                AppMethodBeat.m2505o(120955);
                return true;
            }

            public final /* synthetic */ C25155i ecJ() {
                AppMethodBeat.m2504i(120958);
                C36999ag efM = C36999ag.efM();
                AppMethodBeat.m2505o(120958);
                return efM;
            }

            public final /* synthetic */ C8185q ecM() {
                AppMethodBeat.m2504i(120964);
                C36999ag efP = efP();
                if (efP.isInitialized()) {
                    AppMethodBeat.m2505o(120964);
                    return efP;
                }
                C44904w c44904w = new C44904w();
                AppMethodBeat.m2505o(120964);
                throw c44904w;
            }

            public final /* synthetic */ C8185q ecE() {
                AppMethodBeat.m2504i(120965);
                C36999ag efM = C36999ag.efM();
                AppMethodBeat.m2505o(120965);
                return efM;
            }

            static /* synthetic */ C25141a efR() {
                AppMethodBeat.m2504i(120967);
                C25141a c25141a = new C25141a();
                AppMethodBeat.m2505o(120967);
                return c25141a;
            }
        }

        /* synthetic */ C36999ag(C31713e c31713e, C31715g c31715g, byte b) {
            this(c31713e, c31715g);
        }

        private C36999ag(C25159a c25159a) {
            super((byte) 0);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = c25159a.BsB;
        }

        private C36999ag() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = C31710d.Bzq;
        }

        public static C36999ag efM() {
            return BvL;
        }

        private C36999ag(C31713e c31713e, C31715g c31715g) {
            AppMethodBeat.m2504i(120968);
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            C31711b ehS = C31710d.ehS();
            C37024f e = C37024f.m61953e(ehS, 1);
            int i = 0;
            int i2 = 0;
            while (i == 0) {
                try {
                    int vc = c31713e.mo51692vc();
                    switch (vc) {
                        case 0:
                            i = 1;
                            break;
                        case 10:
                            if ((i2 & 1) != 1) {
                                this.BvM = new ArrayList();
                                i2 |= 1;
                            }
                            this.BvM.add(c31713e.mo51683a(C25133aa.BsC, c31715g));
                            break;
                        case 16:
                            this.BsD |= 1;
                            this.BvN = c31713e.mo51693vd();
                            break;
                        default:
                            if (!mo42012a(c31713e, e, c31715g, vc)) {
                                i = 1;
                                break;
                            }
                            break;
                    }
                } catch (C41425k e2) {
                    e2.BzY = this;
                    AppMethodBeat.m2505o(120968);
                    throw e2;
                } catch (IOException e3) {
                    C41425k c41425k = new C41425k(e3.getMessage());
                    c41425k.BzY = this;
                    AppMethodBeat.m2505o(120968);
                    throw c41425k;
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
                        AppMethodBeat.m2505o(120968);
                    }
                    eio();
                    AppMethodBeat.m2505o(120968);
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
                AppMethodBeat.m2505o(120968);
            }
            eio();
            AppMethodBeat.m2505o(120968);
        }

        static {
            AppMethodBeat.m2504i(120976);
            C36999ag c36999ag = new C36999ag();
            BvL = c36999ag;
            c36999ag.ecA();
            AppMethodBeat.m2505o(120976);
        }

        public final C25163s<C36999ag> ecy() {
            return BsC;
        }

        public final boolean efN() {
            return (this.BsD & 1) == 1;
        }

        private void ecA() {
            AppMethodBeat.m2504i(120969);
            this.BvM = Collections.emptyList();
            this.BvN = -1;
            AppMethodBeat.m2505o(120969);
        }

        public final boolean isInitialized() {
            AppMethodBeat.m2504i(120970);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.m2505o(120970);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.m2505o(120970);
                return false;
            } else {
                int i = 0;
                while (i < this.BvM.size()) {
                    if (((C25133aa) this.BvM.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120970);
                        return false;
                    }
                }
                this.BsG = (byte) 1;
                AppMethodBeat.m2505o(120970);
                return true;
            }
        }

        /* renamed from: a */
        public final void mo128a(C37024f c37024f) {
            AppMethodBeat.m2504i(120971);
            mo144vq();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.BvM.size()) {
                    break;
                }
                c37024f.mo59046a(1, (C8185q) this.BvM.get(i2));
                i = i2 + 1;
            }
            if ((this.BsD & 1) == 1) {
                c37024f.mo59052bq(2, this.BvN);
            }
            c37024f.mo59056d(this.BsB);
            AppMethodBeat.m2505o(120971);
        }

        /* renamed from: vq */
        public final int mo144vq() {
            AppMethodBeat.m2504i(120972);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.m2505o(120972);
                return i;
            }
            int i2 = 0;
            for (i = 0; i < this.BvM.size(); i++) {
                i2 += C37024f.m61948c(1, (C8185q) this.BvM.get(i));
            }
            if ((this.BsD & 1) == 1) {
                i2 += C37024f.m61947bs(2, this.BvN);
            }
            int size = this.BsB.size() + i2;
            this.BsH = size;
            AppMethodBeat.m2505o(120972);
            return size;
        }

        /* renamed from: d */
        public static C25141a m61815d(C36999ag c36999ag) {
            AppMethodBeat.m2504i(120973);
            C25141a g = C25141a.efR().mo42006g(c36999ag);
            AppMethodBeat.m2505o(120973);
            return g;
        }

        public final /* synthetic */ C8186a ecC() {
            AppMethodBeat.m2504i(120974);
            C25141a g = C25141a.efR().mo42006g(this);
            AppMethodBeat.m2505o(120974);
            return g;
        }

        public final /* synthetic */ C8186a ecD() {
            AppMethodBeat.m2504i(120975);
            C25141a efR = C25141a.efR();
            AppMethodBeat.m2505o(120975);
            return efR;
        }

        public final /* bridge */ /* synthetic */ C8185q ecE() {
            return BvL;
        }
    }

    /* renamed from: a.i.b.a.c.e.a$c */
    public static final class C37000c extends C25158c<C37000c> implements C37017d {
        public static C25163s<C37000c> BsC = new C81581();
        private static final C37000c Btm;
        private final C31710d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        public int BsW;
        public List<Integer> BtA;
        private int BtB;
        public C36999ag BtC;
        public List<Integer> BtD;
        public C36655am BtE;
        public int Btn;
        public int Bto;
        public List<C37014ae> Btp;
        public List<C25133aa> Btq;
        public List<Integer> Btr;
        private int Bts;
        public List<Integer> Btt;
        private int Btu;
        public List<C37011e> Btv;
        public List<C31694o> Btw;
        public List<C36656u> Btx;
        public List<C17244ab> Bty;
        public List<C25147k> Btz;

        /* renamed from: a.i.b.a.c.e.a$c$1 */
        static class C81581 extends C0117b<C37000c> {
            C81581() {
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo157a(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120441);
                C37000c c37000c = new C37000c(c31713e, c31715g, (byte) 0);
                AppMethodBeat.m2505o(120441);
                return c37000c;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$c$a */
        public static final class C31688a extends C25157b<C37000c, C31688a> implements C37017d {
            private int BsD;
            private int BsW = 6;
            private List<Integer> BtA = Collections.emptyList();
            private C36999ag BtC = C36999ag.efM();
            private List<Integer> BtD = Collections.emptyList();
            private C36655am BtE = C36655am.egi();
            private int Btn;
            private int Bto;
            private List<C37014ae> Btp = Collections.emptyList();
            private List<C25133aa> Btq = Collections.emptyList();
            private List<Integer> Btr = Collections.emptyList();
            private List<Integer> Btt = Collections.emptyList();
            private List<C37011e> Btv = Collections.emptyList();
            private List<C31694o> Btw = Collections.emptyList();
            private List<C36656u> Btx = Collections.emptyList();
            private List<C17244ab> Bty = Collections.emptyList();
            private List<C25147k> Btz = Collections.emptyList();

            /* renamed from: c */
            public final /* synthetic */ C0115a mo148c(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120466);
                C31688a g = m51248g(c31713e, c31715g);
                AppMethodBeat.m2505o(120466);
                return g;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.m2504i(120470);
                C31688a edn = edn();
                AppMethodBeat.m2505o(120470);
                return edn;
            }

            /* renamed from: d */
            public final /* synthetic */ C8186a mo150d(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120468);
                C31688a g = m51248g(c31713e, c31715g);
                AppMethodBeat.m2505o(120468);
                return g;
            }

            public final /* synthetic */ C25159a ecK() {
                AppMethodBeat.m2504i(120465);
                C31688a edn = edn();
                AppMethodBeat.m2505o(120465);
                return edn;
            }

            public final /* synthetic */ C0115a ecL() {
                AppMethodBeat.m2504i(120467);
                C31688a edn = edn();
                AppMethodBeat.m2505o(120467);
                return edn;
            }

            public final /* synthetic */ C25157b edA() {
                AppMethodBeat.m2504i(120461);
                C31688a edn = edn();
                AppMethodBeat.m2505o(120461);
                return edn;
            }

            private C31688a() {
                AppMethodBeat.m2504i(120442);
                AppMethodBeat.m2505o(120442);
            }

            private C37000c edo() {
                int i = 1;
                AppMethodBeat.m2504i(120444);
                C37000c c37000c = new C37000c((C25157b) this, (byte) 0);
                int i2 = this.BsD;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                c37000c.BsW = this.BsW;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                c37000c.Btn = this.Btn;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                c37000c.Bto = this.Bto;
                if ((this.BsD & 8) == 8) {
                    this.Btp = Collections.unmodifiableList(this.Btp);
                    this.BsD &= -9;
                }
                c37000c.Btp = this.Btp;
                if ((this.BsD & 16) == 16) {
                    this.Btq = Collections.unmodifiableList(this.Btq);
                    this.BsD &= -17;
                }
                c37000c.Btq = this.Btq;
                if ((this.BsD & 32) == 32) {
                    this.Btr = Collections.unmodifiableList(this.Btr);
                    this.BsD &= -33;
                }
                c37000c.Btr = this.Btr;
                if ((this.BsD & 64) == 64) {
                    this.Btt = Collections.unmodifiableList(this.Btt);
                    this.BsD &= -65;
                }
                c37000c.Btt = this.Btt;
                if ((this.BsD & 128) == 128) {
                    this.Btv = Collections.unmodifiableList(this.Btv);
                    this.BsD &= -129;
                }
                c37000c.Btv = this.Btv;
                if ((this.BsD & 256) == 256) {
                    this.Btw = Collections.unmodifiableList(this.Btw);
                    this.BsD &= -257;
                }
                c37000c.Btw = this.Btw;
                if ((this.BsD & 512) == 512) {
                    this.Btx = Collections.unmodifiableList(this.Btx);
                    this.BsD &= -513;
                }
                c37000c.Btx = this.Btx;
                if ((this.BsD & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                    this.Bty = Collections.unmodifiableList(this.Bty);
                    this.BsD &= -1025;
                }
                c37000c.Bty = this.Bty;
                if ((this.BsD & 2048) == 2048) {
                    this.Btz = Collections.unmodifiableList(this.Btz);
                    this.BsD &= -2049;
                }
                c37000c.Btz = this.Btz;
                if ((this.BsD & 4096) == 4096) {
                    this.BtA = Collections.unmodifiableList(this.BtA);
                    this.BsD &= -4097;
                }
                c37000c.BtA = this.BtA;
                if ((i2 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == Utility.DEFAULT_STREAM_BUFFER_SIZE) {
                    i |= 8;
                }
                c37000c.BtC = this.BtC;
                if ((this.BsD & 16384) == 16384) {
                    this.BtD = Collections.unmodifiableList(this.BtD);
                    this.BsD &= -16385;
                }
                c37000c.BtD = this.BtD;
                if ((i2 & 32768) == 32768) {
                    i |= 16;
                }
                c37000c.BtE = this.BtE;
                c37000c.BsD = i;
                AppMethodBeat.m2505o(120444);
                return c37000c;
            }

            /* renamed from: m */
            public final C31688a mo51655m(C37000c c37000c) {
                AppMethodBeat.m2504i(120445);
                if (c37000c == C37000c.edi()) {
                    AppMethodBeat.m2505o(120445);
                } else {
                    if (c37000c.ecY()) {
                        m51243SY(c37000c.BsW);
                    }
                    if (c37000c.edj()) {
                        m51244SZ(c37000c.Btn);
                    }
                    if (c37000c.edk()) {
                        m51245Ta(c37000c.Bto);
                    }
                    if (!c37000c.Btp.isEmpty()) {
                        if (this.Btp.isEmpty()) {
                            this.Btp = c37000c.Btp;
                            this.BsD &= -9;
                        } else {
                            edp();
                            this.Btp.addAll(c37000c.Btp);
                        }
                    }
                    if (!c37000c.Btq.isEmpty()) {
                        if (this.Btq.isEmpty()) {
                            this.Btq = c37000c.Btq;
                            this.BsD &= -17;
                        } else {
                            edq();
                            this.Btq.addAll(c37000c.Btq);
                        }
                    }
                    if (!c37000c.Btr.isEmpty()) {
                        if (this.Btr.isEmpty()) {
                            this.Btr = c37000c.Btr;
                            this.BsD &= -33;
                        } else {
                            edr();
                            this.Btr.addAll(c37000c.Btr);
                        }
                    }
                    if (!c37000c.Btt.isEmpty()) {
                        if (this.Btt.isEmpty()) {
                            this.Btt = c37000c.Btt;
                            this.BsD &= -65;
                        } else {
                            eds();
                            this.Btt.addAll(c37000c.Btt);
                        }
                    }
                    if (!c37000c.Btv.isEmpty()) {
                        if (this.Btv.isEmpty()) {
                            this.Btv = c37000c.Btv;
                            this.BsD &= -129;
                        } else {
                            edt();
                            this.Btv.addAll(c37000c.Btv);
                        }
                    }
                    if (!c37000c.Btw.isEmpty()) {
                        if (this.Btw.isEmpty()) {
                            this.Btw = c37000c.Btw;
                            this.BsD &= -257;
                        } else {
                            edu();
                            this.Btw.addAll(c37000c.Btw);
                        }
                    }
                    if (!c37000c.Btx.isEmpty()) {
                        if (this.Btx.isEmpty()) {
                            this.Btx = c37000c.Btx;
                            this.BsD &= -513;
                        } else {
                            edv();
                            this.Btx.addAll(c37000c.Btx);
                        }
                    }
                    if (!c37000c.Bty.isEmpty()) {
                        if (this.Bty.isEmpty()) {
                            this.Bty = c37000c.Bty;
                            this.BsD &= -1025;
                        } else {
                            edw();
                            this.Bty.addAll(c37000c.Bty);
                        }
                    }
                    if (!c37000c.Btz.isEmpty()) {
                        if (this.Btz.isEmpty()) {
                            this.Btz = c37000c.Btz;
                            this.BsD &= -2049;
                        } else {
                            edx();
                            this.Btz.addAll(c37000c.Btz);
                        }
                    }
                    if (!c37000c.BtA.isEmpty()) {
                        if (this.BtA.isEmpty()) {
                            this.BtA = c37000c.BtA;
                            this.BsD &= -4097;
                        } else {
                            edy();
                            this.BtA.addAll(c37000c.BtA);
                        }
                    }
                    if (c37000c.edl()) {
                        m51246a(c37000c.BtC);
                    }
                    if (!c37000c.BtD.isEmpty()) {
                        if (this.BtD.isEmpty()) {
                            this.BtD = c37000c.BtD;
                            this.BsD &= -16385;
                        } else {
                            edz();
                            this.BtD.addAll(c37000c.BtD);
                        }
                    }
                    if (c37000c.edm()) {
                        m51247a(c37000c.BtE);
                    }
                    mo42015a((C25158c) c37000c);
                    this.BsB = this.BsB.mo51672a(c37000c.BsB);
                    AppMethodBeat.m2505o(120445);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: g */
            private C31688a m51248g(C31713e c31713e, C31715g c31715g) {
                C37000c c37000c;
                Throwable th;
                AppMethodBeat.m2504i(120447);
                C37000c c37000c2 = null;
                try {
                    mo51655m((C37000c) C37000c.BsC.mo157a(c31713e, c31715g));
                    AppMethodBeat.m2505o(120447);
                    return this;
                } catch (C41425k e) {
                    C41425k c41425k = e;
                    c37000c = (C37000c) c41425k.BzY;
                    AppMethodBeat.m2505o(120447);
                    throw c41425k;
                } catch (Throwable th2) {
                    th = th2;
                    c37000c2 = c37000c;
                    if (c37000c2 != null) {
                    }
                    AppMethodBeat.m2505o(120447);
                    throw th;
                }
            }

            /* renamed from: SY */
            private C31688a m51243SY(int i) {
                this.BsD |= 1;
                this.BsW = i;
                return this;
            }

            /* renamed from: SZ */
            private C31688a m51244SZ(int i) {
                this.BsD |= 2;
                this.Btn = i;
                return this;
            }

            /* renamed from: Ta */
            private C31688a m51245Ta(int i) {
                this.BsD |= 4;
                this.Bto = i;
                return this;
            }

            private void edp() {
                AppMethodBeat.m2504i(120448);
                if ((this.BsD & 8) != 8) {
                    this.Btp = new ArrayList(this.Btp);
                    this.BsD |= 8;
                }
                AppMethodBeat.m2505o(120448);
            }

            private void edq() {
                AppMethodBeat.m2504i(120449);
                if ((this.BsD & 16) != 16) {
                    this.Btq = new ArrayList(this.Btq);
                    this.BsD |= 16;
                }
                AppMethodBeat.m2505o(120449);
            }

            private void edr() {
                AppMethodBeat.m2504i(120450);
                if ((this.BsD & 32) != 32) {
                    this.Btr = new ArrayList(this.Btr);
                    this.BsD |= 32;
                }
                AppMethodBeat.m2505o(120450);
            }

            private void eds() {
                AppMethodBeat.m2504i(120451);
                if ((this.BsD & 64) != 64) {
                    this.Btt = new ArrayList(this.Btt);
                    this.BsD |= 64;
                }
                AppMethodBeat.m2505o(120451);
            }

            private void edt() {
                AppMethodBeat.m2504i(120452);
                if ((this.BsD & 128) != 128) {
                    this.Btv = new ArrayList(this.Btv);
                    this.BsD |= 128;
                }
                AppMethodBeat.m2505o(120452);
            }

            private void edu() {
                AppMethodBeat.m2504i(120453);
                if ((this.BsD & 256) != 256) {
                    this.Btw = new ArrayList(this.Btw);
                    this.BsD |= 256;
                }
                AppMethodBeat.m2505o(120453);
            }

            private void edv() {
                AppMethodBeat.m2504i(120454);
                if ((this.BsD & 512) != 512) {
                    this.Btx = new ArrayList(this.Btx);
                    this.BsD |= 512;
                }
                AppMethodBeat.m2505o(120454);
            }

            private void edw() {
                AppMethodBeat.m2504i(120455);
                if ((this.BsD & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                    this.Bty = new ArrayList(this.Bty);
                    this.BsD |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                }
                AppMethodBeat.m2505o(120455);
            }

            private void edx() {
                AppMethodBeat.m2504i(120456);
                if ((this.BsD & 2048) != 2048) {
                    this.Btz = new ArrayList(this.Btz);
                    this.BsD |= 2048;
                }
                AppMethodBeat.m2505o(120456);
            }

            private void edy() {
                AppMethodBeat.m2504i(120457);
                if ((this.BsD & 4096) != 4096) {
                    this.BtA = new ArrayList(this.BtA);
                    this.BsD |= 4096;
                }
                AppMethodBeat.m2505o(120457);
            }

            /* renamed from: a */
            private C31688a m51246a(C36999ag c36999ag) {
                AppMethodBeat.m2504i(120458);
                if ((this.BsD & Utility.DEFAULT_STREAM_BUFFER_SIZE) != Utility.DEFAULT_STREAM_BUFFER_SIZE || this.BtC == C36999ag.efM()) {
                    this.BtC = c36999ag;
                } else {
                    this.BtC = C36999ag.m61815d(this.BtC).mo42006g(c36999ag).efP();
                }
                this.BsD |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                AppMethodBeat.m2505o(120458);
                return this;
            }

            private void edz() {
                AppMethodBeat.m2504i(120459);
                if ((this.BsD & 16384) != 16384) {
                    this.BtD = new ArrayList(this.BtD);
                    this.BsD |= 16384;
                }
                AppMethodBeat.m2505o(120459);
            }

            /* renamed from: a */
            private C31688a m51247a(C36655am c36655am) {
                AppMethodBeat.m2504i(120460);
                if ((this.BsD & 32768) != 32768 || this.BtE == C36655am.egi()) {
                    this.BtE = c36655am;
                } else {
                    this.BtE = C36655am.m60755c(this.BtE).mo42008f(c36655am).egk();
                }
                this.BsD |= 32768;
                AppMethodBeat.m2505o(120460);
                return this;
            }

            private C31688a edn() {
                AppMethodBeat.m2504i(120443);
                C31688a m = new C31688a().mo51655m(edo());
                AppMethodBeat.m2505o(120443);
                return m;
            }

            public final boolean isInitialized() {
                boolean z;
                AppMethodBeat.m2504i(120446);
                if ((this.BsD & 2) == 2) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    int i = 0;
                    while (i < this.Btp.size()) {
                        if (((C37014ae) this.Btp.get(i)).isInitialized()) {
                            i++;
                        } else {
                            AppMethodBeat.m2505o(120446);
                            return false;
                        }
                    }
                    i = 0;
                    while (i < this.Btq.size()) {
                        if (((C25133aa) this.Btq.get(i)).isInitialized()) {
                            i++;
                        } else {
                            AppMethodBeat.m2505o(120446);
                            return false;
                        }
                    }
                    i = 0;
                    while (i < this.Btv.size()) {
                        if (((C37011e) this.Btv.get(i)).isInitialized()) {
                            i++;
                        } else {
                            AppMethodBeat.m2505o(120446);
                            return false;
                        }
                    }
                    i = 0;
                    while (i < this.Btw.size()) {
                        if (((C31694o) this.Btw.get(i)).isInitialized()) {
                            i++;
                        } else {
                            AppMethodBeat.m2505o(120446);
                            return false;
                        }
                    }
                    i = 0;
                    while (i < this.Btx.size()) {
                        if (((C36656u) this.Btx.get(i)).isInitialized()) {
                            i++;
                        } else {
                            AppMethodBeat.m2505o(120446);
                            return false;
                        }
                    }
                    i = 0;
                    while (i < this.Bty.size()) {
                        if (((C17244ab) this.Bty.get(i)).isInitialized()) {
                            i++;
                        } else {
                            AppMethodBeat.m2505o(120446);
                            return false;
                        }
                    }
                    i = 0;
                    while (i < this.Btz.size()) {
                        if (((C25147k) this.Btz.get(i)).isInitialized()) {
                            i++;
                        } else {
                            AppMethodBeat.m2505o(120446);
                            return false;
                        }
                    }
                    if ((this.BsD & Utility.DEFAULT_STREAM_BUFFER_SIZE) == Utility.DEFAULT_STREAM_BUFFER_SIZE) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z && !this.BtC.isInitialized()) {
                        AppMethodBeat.m2505o(120446);
                        return false;
                    } else if (this.BzI.isInitialized()) {
                        AppMethodBeat.m2505o(120446);
                        return true;
                    } else {
                        AppMethodBeat.m2505o(120446);
                        return false;
                    }
                }
                AppMethodBeat.m2505o(120446);
                return false;
            }

            public final /* synthetic */ C8185q ecE() {
                AppMethodBeat.m2504i(120462);
                C37000c edi = C37000c.edi();
                AppMethodBeat.m2505o(120462);
                return edi;
            }

            public final /* synthetic */ C25155i ecJ() {
                AppMethodBeat.m2504i(120463);
                C37000c edi = C37000c.edi();
                AppMethodBeat.m2505o(120463);
                return edi;
            }

            public final /* synthetic */ C8185q ecM() {
                AppMethodBeat.m2504i(120469);
                C37000c edo = edo();
                if (edo.isInitialized()) {
                    AppMethodBeat.m2505o(120469);
                    return edo;
                }
                C44904w c44904w = new C44904w();
                AppMethodBeat.m2505o(120469);
                throw c44904w;
            }

            static /* synthetic */ C31688a edB() {
                AppMethodBeat.m2504i(120471);
                C31688a c31688a = new C31688a();
                AppMethodBeat.m2505o(120471);
                return c31688a;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$c$b */
        public enum C31689b implements C8183a {
            CLASS(0),
            INTERFACE(1),
            ENUM_CLASS(2),
            ENUM_ENTRY(3),
            ANNOTATION_CLASS(4),
            OBJECT(5),
            COMPANION_OBJECT(6);
            
            private static C8182b<C31689b> Btk;
            private final int value;

            /* renamed from: a.i.b.a.c.e.a$c$b$1 */
            static class C316901 implements C8182b<C31689b> {
                C316901() {
                }

                /* renamed from: SW */
                public final /* synthetic */ C8183a mo146SW(int i) {
                    AppMethodBeat.m2504i(120472);
                    C31689b Tb = C31689b.m51253Tb(i);
                    AppMethodBeat.m2505o(120472);
                    return Tb;
                }
            }

            static {
                Btk = new C316901();
                AppMethodBeat.m2505o(120475);
            }

            public final int edd() {
                return this.value;
            }

            /* renamed from: Tb */
            public static C31689b m51253Tb(int i) {
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

            private C31689b(int i) {
                this.value = i;
            }
        }

        /* synthetic */ C37000c(C31713e c31713e, C31715g c31715g, byte b) {
            this(c31713e, c31715g);
        }

        private C37000c(C25157b<C37000c, ?> c25157b) {
            super(c25157b);
            this.Bts = -1;
            this.Btu = -1;
            this.BtB = -1;
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = c25157b.BsB;
        }

        private C37000c() {
            this.Bts = -1;
            this.Btu = -1;
            this.BtB = -1;
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = C31710d.Bzq;
        }

        public static C37000c edi() {
            return Btm;
        }

        private C37000c(C31713e c31713e, C31715g c31715g) {
            AppMethodBeat.m2504i(120476);
            this.Bts = -1;
            this.Btu = -1;
            this.BtB = -1;
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            int i = 0;
            C31711b ehS = C31710d.ehS();
            C37024f e = C37024f.m61953e(ehS, 1);
            Object obj = null;
            while (obj == null) {
                try {
                    int vc = c31713e.mo51692vc();
                    switch (vc) {
                        case 0:
                            obj = 1;
                            break;
                        case 8:
                            this.BsD |= 1;
                            this.BsW = c31713e.mo51693vd();
                            break;
                        case 16:
                            if ((i & 32) != 32) {
                                this.Btr = new ArrayList();
                                i |= 32;
                            }
                            this.Btr.add(Integer.valueOf(c31713e.mo51693vd()));
                            break;
                        case 18:
                            vc = c31713e.mo51690fo(c31713e.mo51693vd());
                            if ((i & 32) != 32 && c31713e.mo51695vg() > 0) {
                                this.Btr = new ArrayList();
                                i |= 32;
                            }
                            while (c31713e.mo51695vg() > 0) {
                                this.Btr.add(Integer.valueOf(c31713e.mo51693vd()));
                            }
                            c31713e.mo51691fp(vc);
                            break;
                        case 24:
                            this.BsD |= 2;
                            this.Btn = c31713e.mo51693vd();
                            break;
                        case 32:
                            this.BsD |= 4;
                            this.Bto = c31713e.mo51693vd();
                            break;
                        case 42:
                            if ((i & 8) != 8) {
                                this.Btp = new ArrayList();
                                i |= 8;
                            }
                            this.Btp.add(c31713e.mo51683a(C37014ae.BsC, c31715g));
                            break;
                        case 50:
                            if ((i & 16) != 16) {
                                this.Btq = new ArrayList();
                                i |= 16;
                            }
                            this.Btq.add(c31713e.mo51683a(C25133aa.BsC, c31715g));
                            break;
                        case FileUtils.S_IRWXG /*56*/:
                            if ((i & 64) != 64) {
                                this.Btt = new ArrayList();
                                i |= 64;
                            }
                            this.Btt.add(Integer.valueOf(c31713e.mo51693vd()));
                            break;
                        case C42464aa.CTRL_INDEX /*58*/:
                            vc = c31713e.mo51690fo(c31713e.mo51693vd());
                            if ((i & 64) != 64 && c31713e.mo51695vg() > 0) {
                                this.Btt = new ArrayList();
                                i |= 64;
                            }
                            while (c31713e.mo51695vg() > 0) {
                                this.Btt.add(Integer.valueOf(c31713e.mo51693vd()));
                            }
                            c31713e.mo51691fp(vc);
                            break;
                        case 66:
                            if ((i & 128) != 128) {
                                this.Btv = new ArrayList();
                                i |= 128;
                            }
                            this.Btv.add(c31713e.mo51683a(C37011e.BsC, c31715g));
                            break;
                        case 74:
                            if ((i & 256) != 256) {
                                this.Btw = new ArrayList();
                                i |= 256;
                            }
                            this.Btw.add(c31713e.mo51683a(C31694o.BsC, c31715g));
                            break;
                        case 82:
                            if ((i & 512) != 512) {
                                this.Btx = new ArrayList();
                                i |= 512;
                            }
                            this.Btx.add(c31713e.mo51683a(C36656u.BsC, c31715g));
                            break;
                        case 90:
                            if ((i & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                                this.Bty = new ArrayList();
                                i |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                            }
                            this.Bty.add(c31713e.mo51683a(C17244ab.BsC, c31715g));
                            break;
                        case 106:
                            if ((i & 2048) != 2048) {
                                this.Btz = new ArrayList();
                                i |= 2048;
                            }
                            this.Btz.add(c31713e.mo51683a(C25147k.BsC, c31715g));
                            break;
                        case 128:
                            if ((i & 4096) != 4096) {
                                this.BtA = new ArrayList();
                                i |= 4096;
                            }
                            this.BtA.add(Integer.valueOf(c31713e.mo51693vd()));
                            break;
                        case 130:
                            vc = c31713e.mo51690fo(c31713e.mo51693vd());
                            if ((i & 4096) != 4096 && c31713e.mo51695vg() > 0) {
                                this.BtA = new ArrayList();
                                i |= 4096;
                            }
                            while (c31713e.mo51695vg() > 0) {
                                this.BtA.add(Integer.valueOf(c31713e.mo51693vd()));
                            }
                            c31713e.mo51691fp(vc);
                            break;
                        case 242:
                            C25141a d;
                            if ((this.BsD & 8) == 8) {
                                d = C36999ag.m61815d(this.BtC);
                            } else {
                                d = null;
                            }
                            this.BtC = (C36999ag) c31713e.mo51683a(C36999ag.BsC, c31715g);
                            if (d != null) {
                                d.mo42006g(this.BtC);
                                this.BtC = d.efP();
                            }
                            this.BsD |= 8;
                            break;
                        case C31128d.MIC_PTU_ZIPAI_THURSDAY /*248*/:
                            if ((i & 16384) != 16384) {
                                this.BtD = new ArrayList();
                                i |= 16384;
                            }
                            this.BtD.add(Integer.valueOf(c31713e.mo51693vd()));
                            break;
                        case 250:
                            vc = c31713e.mo51690fo(c31713e.mo51693vd());
                            if ((i & 16384) != 16384 && c31713e.mo51695vg() > 0) {
                                this.BtD = new ArrayList();
                                i |= 16384;
                            }
                            while (c31713e.mo51695vg() > 0) {
                                this.BtD.add(Integer.valueOf(c31713e.mo51693vd()));
                            }
                            c31713e.mo51691fp(vc);
                            break;
                        case C31128d.MIC_PTU_ZIPAI_SAPPORO /*258*/:
                            C25142a c;
                            if ((this.BsD & 16) == 16) {
                                c = C36655am.m60755c(this.BtE);
                            } else {
                                c = null;
                            }
                            this.BtE = (C36655am) c31713e.mo51683a(C36655am.BsC, c31715g);
                            if (c != null) {
                                c.mo42008f(this.BtE);
                                this.BtE = c.egk();
                            }
                            this.BsD |= 16;
                            break;
                        default:
                            if (!mo42012a(c31713e, e, c31715g, vc)) {
                                obj = 1;
                                break;
                            }
                            break;
                    }
                } catch (C41425k e2) {
                    e2.BzY = this;
                    AppMethodBeat.m2505o(120476);
                    throw e2;
                } catch (IOException e3) {
                    C41425k c41425k = new C41425k(e3.getMessage());
                    c41425k.BzY = this;
                    AppMethodBeat.m2505o(120476);
                    throw c41425k;
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
                        AppMethodBeat.m2505o(120476);
                    }
                    this.BzI.eii();
                    AppMethodBeat.m2505o(120476);
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
                AppMethodBeat.m2505o(120476);
            }
            this.BzI.eii();
            AppMethodBeat.m2505o(120476);
        }

        static {
            AppMethodBeat.m2504i(120484);
            C37000c c37000c = new C37000c();
            Btm = c37000c;
            c37000c.ecA();
            AppMethodBeat.m2505o(120484);
        }

        public final C25163s<C37000c> ecy() {
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
            AppMethodBeat.m2504i(120477);
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
            this.BtC = C36999ag.efM();
            this.BtD = Collections.emptyList();
            this.BtE = C36655am.egi();
            AppMethodBeat.m2505o(120477);
        }

        public final boolean isInitialized() {
            AppMethodBeat.m2504i(120478);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.m2505o(120478);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.m2505o(120478);
                return false;
            } else if (edj()) {
                int i = 0;
                while (i < this.Btp.size()) {
                    if (((C37014ae) this.Btp.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120478);
                        return false;
                    }
                }
                i = 0;
                while (i < this.Btq.size()) {
                    if (((C25133aa) this.Btq.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120478);
                        return false;
                    }
                }
                i = 0;
                while (i < this.Btv.size()) {
                    if (((C37011e) this.Btv.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120478);
                        return false;
                    }
                }
                i = 0;
                while (i < this.Btw.size()) {
                    if (((C31694o) this.Btw.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120478);
                        return false;
                    }
                }
                i = 0;
                while (i < this.Btx.size()) {
                    if (((C36656u) this.Btx.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120478);
                        return false;
                    }
                }
                i = 0;
                while (i < this.Bty.size()) {
                    if (((C17244ab) this.Bty.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120478);
                        return false;
                    }
                }
                i = 0;
                while (i < this.Btz.size()) {
                    if (((C25147k) this.Btz.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120478);
                        return false;
                    }
                }
                if (edl() && !this.BtC.isInitialized()) {
                    this.BsG = (byte) 0;
                    AppMethodBeat.m2505o(120478);
                    return false;
                } else if (this.BzI.isInitialized()) {
                    this.BsG = (byte) 1;
                    AppMethodBeat.m2505o(120478);
                    return true;
                } else {
                    this.BsG = (byte) 0;
                    AppMethodBeat.m2505o(120478);
                    return false;
                }
            } else {
                this.BsG = (byte) 0;
                AppMethodBeat.m2505o(120478);
                return false;
            }
        }

        /* renamed from: a */
        public final void mo128a(C37024f c37024f) {
            int i;
            int i2 = 0;
            AppMethodBeat.m2504i(120479);
            mo144vq();
            C8178a eip = eip();
            if ((this.BsD & 1) == 1) {
                c37024f.mo59052bq(1, this.BsW);
            }
            if (this.Btr.size() > 0) {
                c37024f.mo59058fw(18);
                c37024f.mo59058fw(this.Bts);
            }
            for (i = 0; i < this.Btr.size(); i++) {
                c37024f.mo59043Uy(((Integer) this.Btr.get(i)).intValue());
            }
            if ((this.BsD & 2) == 2) {
                c37024f.mo59052bq(3, this.Btn);
            }
            if ((this.BsD & 4) == 4) {
                c37024f.mo59052bq(4, this.Bto);
            }
            for (i = 0; i < this.Btp.size(); i++) {
                c37024f.mo59046a(5, (C8185q) this.Btp.get(i));
            }
            for (i = 0; i < this.Btq.size(); i++) {
                c37024f.mo59046a(6, (C8185q) this.Btq.get(i));
            }
            if (this.Btt.size() > 0) {
                c37024f.mo59058fw(58);
                c37024f.mo59058fw(this.Btu);
            }
            for (i = 0; i < this.Btt.size(); i++) {
                c37024f.mo59043Uy(((Integer) this.Btt.get(i)).intValue());
            }
            for (i = 0; i < this.Btv.size(); i++) {
                c37024f.mo59046a(8, (C8185q) this.Btv.get(i));
            }
            for (i = 0; i < this.Btw.size(); i++) {
                c37024f.mo59046a(9, (C8185q) this.Btw.get(i));
            }
            for (i = 0; i < this.Btx.size(); i++) {
                c37024f.mo59046a(10, (C8185q) this.Btx.get(i));
            }
            for (i = 0; i < this.Bty.size(); i++) {
                c37024f.mo59046a(11, (C8185q) this.Bty.get(i));
            }
            for (i = 0; i < this.Btz.size(); i++) {
                c37024f.mo59046a(13, (C8185q) this.Btz.get(i));
            }
            if (this.BtA.size() > 0) {
                c37024f.mo59058fw(130);
                c37024f.mo59058fw(this.BtB);
            }
            for (i = 0; i < this.BtA.size(); i++) {
                c37024f.mo59043Uy(((Integer) this.BtA.get(i)).intValue());
            }
            if ((this.BsD & 8) == 8) {
                c37024f.mo59046a(30, this.BtC);
            }
            while (i2 < this.BtD.size()) {
                c37024f.mo59052bq(31, ((Integer) this.BtD.get(i2)).intValue());
                i2++;
            }
            if ((this.BsD & 16) == 16) {
                c37024f.mo59046a(32, this.BtE);
            }
            eip.mo17990b(19000, c37024f);
            c37024f.mo59056d(this.BsB);
            AppMethodBeat.m2505o(120479);
        }

        /* renamed from: vq */
        public final int mo144vq() {
            AppMethodBeat.m2504i(120480);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.m2505o(120480);
                return i;
            }
            int bs;
            int i2;
            if ((this.BsD & 1) == 1) {
                bs = C37024f.m61947bs(1, this.BsW) + 0;
            } else {
                bs = 0;
            }
            int i3 = 0;
            for (i2 = 0; i2 < this.Btr.size(); i2++) {
                i3 += C37024f.m61954ft(((Integer) this.Btr.get(i2)).intValue());
            }
            i = bs + i3;
            if (!this.Btr.isEmpty()) {
                i = (i + 1) + C37024f.m61954ft(i3);
            }
            this.Bts = i3;
            if ((this.BsD & 2) == 2) {
                i += C37024f.m61947bs(3, this.Btn);
            }
            if ((this.BsD & 4) == 4) {
                i += C37024f.m61947bs(4, this.Bto);
            }
            i2 = i;
            for (bs = 0; bs < this.Btp.size(); bs++) {
                i2 += C37024f.m61948c(5, (C8185q) this.Btp.get(bs));
            }
            for (bs = 0; bs < this.Btq.size(); bs++) {
                i2 += C37024f.m61948c(6, (C8185q) this.Btq.get(bs));
            }
            i3 = 0;
            for (bs = 0; bs < this.Btt.size(); bs++) {
                i3 += C37024f.m61954ft(((Integer) this.Btt.get(bs)).intValue());
            }
            i = i2 + i3;
            if (!this.Btt.isEmpty()) {
                i = (i + 1) + C37024f.m61954ft(i3);
            }
            this.Btu = i3;
            i2 = i;
            for (bs = 0; bs < this.Btv.size(); bs++) {
                i2 += C37024f.m61948c(8, (C8185q) this.Btv.get(bs));
            }
            for (bs = 0; bs < this.Btw.size(); bs++) {
                i2 += C37024f.m61948c(9, (C8185q) this.Btw.get(bs));
            }
            for (bs = 0; bs < this.Btx.size(); bs++) {
                i2 += C37024f.m61948c(10, (C8185q) this.Btx.get(bs));
            }
            for (bs = 0; bs < this.Bty.size(); bs++) {
                i2 += C37024f.m61948c(11, (C8185q) this.Bty.get(bs));
            }
            for (bs = 0; bs < this.Btz.size(); bs++) {
                i2 += C37024f.m61948c(13, (C8185q) this.Btz.get(bs));
            }
            i3 = 0;
            for (bs = 0; bs < this.BtA.size(); bs++) {
                i3 += C37024f.m61954ft(((Integer) this.BtA.get(bs)).intValue());
            }
            i = i2 + i3;
            if (!this.BtA.isEmpty()) {
                i = (i + 2) + C37024f.m61954ft(i3);
            }
            this.BtB = i3;
            if ((this.BsD & 8) == 8) {
                bs = i + C37024f.m61948c(30, this.BtC);
            } else {
                bs = i;
            }
            i2 = 0;
            i3 = 0;
            while (i2 < this.BtD.size()) {
                i2++;
                i3 = C37024f.m61954ft(((Integer) this.BtD.get(i2)).intValue()) + i3;
            }
            i = (bs + i3) + (this.BtD.size() * 2);
            if ((this.BsD & 16) == 16) {
                i += C37024f.m61948c(32, this.BtE);
            }
            i = (i + this.BzI.mo31345vq()) + this.BsB.size();
            this.BsH = i;
            AppMethodBeat.m2505o(120480);
            return i;
        }

        /* renamed from: a */
        public static C37000c m61823a(InputStream inputStream, C31715g c31715g) {
            AppMethodBeat.m2504i(120481);
            C37000c c37000c = (C37000c) BsC.mo190j(inputStream, c31715g);
            AppMethodBeat.m2505o(120481);
            return c37000c;
        }

        public final /* bridge */ /* synthetic */ C8185q ecE() {
            return Btm;
        }

        public final /* synthetic */ C8186a ecC() {
            AppMethodBeat.m2504i(120482);
            C31688a m = C31688a.edB().mo51655m(this);
            AppMethodBeat.m2505o(120482);
            return m;
        }

        public final /* synthetic */ C8186a ecD() {
            AppMethodBeat.m2504i(120483);
            C31688a edB = C31688a.edB();
            AppMethodBeat.m2505o(120483);
            return edB;
        }
    }

    /* renamed from: a.i.b.a.c.e.a$f */
    public interface C37001f extends C8179d {
    }

    /* renamed from: a.i.b.a.c.e.a$m */
    public static final class C37003m extends C25155i implements C31692n {
        public static C25163s<C37003m> BsC = new C172481();
        private static final C37003m Bug;
        private final C31710d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        int BsW;
        int Buh;
        C37005b Bui;
        C25133aa Buj;
        int Buk;
        private List<C37003m> Bul;
        private List<C37003m> Bum;

        /* renamed from: a.i.b.a.c.e.a$m$1 */
        static class C172481 extends C0117b<C37003m> {
            C172481() {
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo157a(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120601);
                C37003m c37003m = new C37003m(c31713e, c31715g, (byte) 0);
                AppMethodBeat.m2505o(120601);
                return c37003m;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$m$a */
        public static final class C37004a extends C25159a<C37003m, C37004a> implements C31692n {
            private int BsD;
            private int BsW;
            private int Buh;
            private C37005b Bui = C37005b.TRUE;
            private C25133aa Buj = C25133aa.eeX();
            private int Buk;
            private List<C37003m> Bul = Collections.emptyList();
            private List<C37003m> Bum = Collections.emptyList();

            /* renamed from: c */
            public final /* synthetic */ C0115a mo148c(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120615);
                C37004a l = m61872l(c31713e, c31715g);
                AppMethodBeat.m2505o(120615);
                return l;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.m2504i(120620);
                C37004a eef = eef();
                AppMethodBeat.m2505o(120620);
                return eef;
            }

            /* renamed from: d */
            public final /* synthetic */ C8186a mo150d(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120617);
                C37004a l = m61872l(c31713e, c31715g);
                AppMethodBeat.m2505o(120617);
                return l;
            }

            public final /* synthetic */ C25159a ecK() {
                AppMethodBeat.m2504i(120614);
                C37004a eef = eef();
                AppMethodBeat.m2505o(120614);
                return eef;
            }

            public final /* synthetic */ C0115a ecL() {
                AppMethodBeat.m2504i(120616);
                C37004a eef = eef();
                AppMethodBeat.m2505o(120616);
                return eef;
            }

            private C37004a() {
                AppMethodBeat.m2504i(120602);
                AppMethodBeat.m2505o(120602);
            }

            public final C37003m eeg() {
                int i = 1;
                AppMethodBeat.m2504i(120604);
                C37003m c37003m = new C37003m((C25159a) this, (byte) 0);
                int i2 = this.BsD;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                c37003m.BsW = this.BsW;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                c37003m.Buh = this.Buh;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                c37003m.Bui = this.Bui;
                if ((i2 & 8) == 8) {
                    i |= 8;
                }
                c37003m.Buj = this.Buj;
                if ((i2 & 16) == 16) {
                    i |= 16;
                }
                c37003m.Buk = this.Buk;
                if ((this.BsD & 32) == 32) {
                    this.Bul = Collections.unmodifiableList(this.Bul);
                    this.BsD &= -33;
                }
                c37003m.Bul = this.Bul;
                if ((this.BsD & 64) == 64) {
                    this.Bum = Collections.unmodifiableList(this.Bum);
                    this.BsD &= -65;
                }
                c37003m.Bum = this.Bum;
                c37003m.BsD = i;
                AppMethodBeat.m2505o(120604);
                return c37003m;
            }

            /* renamed from: f */
            public final C37004a mo59022f(C37003m c37003m) {
                AppMethodBeat.m2504i(120605);
                if (c37003m == C37003m.eea()) {
                    AppMethodBeat.m2505o(120605);
                } else {
                    if (c37003m.ecY()) {
                        m61867Tg(c37003m.BsW);
                    }
                    if (c37003m.eeb()) {
                        m61868Th(c37003m.Buh);
                    }
                    if (c37003m.eec()) {
                        m61871a(c37003m.Bui);
                    }
                    if (c37003m.eed()) {
                        m61870a(c37003m.Buj);
                    }
                    if (c37003m.eee()) {
                        m61869Ti(c37003m.Buk);
                    }
                    if (!c37003m.Bul.isEmpty()) {
                        if (this.Bul.isEmpty()) {
                            this.Bul = c37003m.Bul;
                            this.BsD &= -33;
                        } else {
                            eeh();
                            this.Bul.addAll(c37003m.Bul);
                        }
                    }
                    if (!c37003m.Bum.isEmpty()) {
                        if (this.Bum.isEmpty()) {
                            this.Bum = c37003m.Bum;
                            this.BsD &= -65;
                        } else {
                            eei();
                            this.Bum.addAll(c37003m.Bum);
                        }
                    }
                    this.BsB = this.BsB.mo51672a(c37003m.BsB);
                    AppMethodBeat.m2505o(120605);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: l */
            private C37004a m61872l(C31713e c31713e, C31715g c31715g) {
                C37003m c37003m;
                Throwable th;
                AppMethodBeat.m2504i(120607);
                C37003m c37003m2 = null;
                try {
                    mo59022f((C37003m) C37003m.BsC.mo157a(c31713e, c31715g));
                    AppMethodBeat.m2505o(120607);
                    return this;
                } catch (C41425k e) {
                    C41425k c41425k = e;
                    c37003m = (C37003m) c41425k.BzY;
                    AppMethodBeat.m2505o(120607);
                    throw c41425k;
                } catch (Throwable th2) {
                    th = th2;
                    c37003m2 = c37003m;
                    if (c37003m2 != null) {
                    }
                    AppMethodBeat.m2505o(120607);
                    throw th;
                }
            }

            /* renamed from: Tg */
            private C37004a m61867Tg(int i) {
                this.BsD |= 1;
                this.BsW = i;
                return this;
            }

            /* renamed from: Th */
            private C37004a m61868Th(int i) {
                this.BsD |= 2;
                this.Buh = i;
                return this;
            }

            /* renamed from: a */
            private C37004a m61871a(C37005b c37005b) {
                AppMethodBeat.m2504i(120608);
                if (c37005b == null) {
                    NullPointerException nullPointerException = new NullPointerException();
                    AppMethodBeat.m2505o(120608);
                    throw nullPointerException;
                }
                this.BsD |= 4;
                this.Bui = c37005b;
                AppMethodBeat.m2505o(120608);
                return this;
            }

            /* renamed from: a */
            private C37004a m61870a(C25133aa c25133aa) {
                AppMethodBeat.m2504i(120609);
                if ((this.BsD & 8) != 8 || this.Buj == C25133aa.eeX()) {
                    this.Buj = c25133aa;
                } else {
                    this.Buj = C25133aa.m39555f(this.Buj).mo42000j(c25133aa).eft();
                }
                this.BsD |= 8;
                AppMethodBeat.m2505o(120609);
                return this;
            }

            /* renamed from: Ti */
            private C37004a m61869Ti(int i) {
                this.BsD |= 16;
                this.Buk = i;
                return this;
            }

            private void eeh() {
                AppMethodBeat.m2504i(120610);
                if ((this.BsD & 32) != 32) {
                    this.Bul = new ArrayList(this.Bul);
                    this.BsD |= 32;
                }
                AppMethodBeat.m2505o(120610);
            }

            private void eei() {
                AppMethodBeat.m2504i(120611);
                if ((this.BsD & 64) != 64) {
                    this.Bum = new ArrayList(this.Bum);
                    this.BsD |= 64;
                }
                AppMethodBeat.m2505o(120611);
            }

            private C37004a eef() {
                AppMethodBeat.m2504i(120603);
                C37004a f = new C37004a().mo59022f(eeg());
                AppMethodBeat.m2505o(120603);
                return f;
            }

            public final boolean isInitialized() {
                boolean z;
                AppMethodBeat.m2504i(120606);
                if ((this.BsD & 8) == 8) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z || this.Buj.isInitialized()) {
                    int i = 0;
                    while (i < this.Bul.size()) {
                        if (((C37003m) this.Bul.get(i)).isInitialized()) {
                            i++;
                        } else {
                            AppMethodBeat.m2505o(120606);
                            return false;
                        }
                    }
                    i = 0;
                    while (i < this.Bum.size()) {
                        if (((C37003m) this.Bum.get(i)).isInitialized()) {
                            i++;
                        } else {
                            AppMethodBeat.m2505o(120606);
                            return false;
                        }
                    }
                    AppMethodBeat.m2505o(120606);
                    return true;
                }
                AppMethodBeat.m2505o(120606);
                return false;
            }

            public final /* synthetic */ C25155i ecJ() {
                AppMethodBeat.m2504i(120612);
                C37003m eea = C37003m.eea();
                AppMethodBeat.m2505o(120612);
                return eea;
            }

            public final /* synthetic */ C8185q ecM() {
                AppMethodBeat.m2504i(120618);
                C37003m eeg = eeg();
                if (eeg.isInitialized()) {
                    AppMethodBeat.m2505o(120618);
                    return eeg;
                }
                C44904w c44904w = new C44904w();
                AppMethodBeat.m2505o(120618);
                throw c44904w;
            }

            public final /* synthetic */ C8185q ecE() {
                AppMethodBeat.m2504i(120619);
                C37003m eea = C37003m.eea();
                AppMethodBeat.m2505o(120619);
                return eea;
            }

            static /* synthetic */ C37004a eej() {
                AppMethodBeat.m2504i(120621);
                C37004a c37004a = new C37004a();
                AppMethodBeat.m2505o(120621);
                return c37004a;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$m$b */
        public enum C37005b implements C8183a {
            TRUE(0),
            FALSE(1),
            NULL(2);
            
            private static C8182b<C37005b> Btk;
            final int value;

            /* renamed from: a.i.b.a.c.e.a$m$b$1 */
            static class C00841 implements C8182b<C37005b> {
                C00841() {
                }

                /* renamed from: SW */
                public final /* synthetic */ C8183a mo146SW(int i) {
                    AppMethodBeat.m2504i(120622);
                    C37005b Tj = C37005b.m61877Tj(i);
                    AppMethodBeat.m2505o(120622);
                    return Tj;
                }
            }

            static {
                Btk = new C00841();
                AppMethodBeat.m2505o(120625);
            }

            public final int edd() {
                return this.value;
            }

            /* renamed from: Tj */
            public static C37005b m61877Tj(int i) {
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

            private C37005b(int i) {
                this.value = i;
            }
        }

        /* synthetic */ C37003m(C31713e c31713e, C31715g c31715g, byte b) {
            this(c31713e, c31715g);
        }

        private C37003m(C25159a c25159a) {
            super((byte) 0);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = c25159a.BsB;
        }

        private C37003m() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = C31710d.Bzq;
        }

        public static C37003m eea() {
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
        private C37003m(C31713e c31713e, C31715g c31715g) {
            C41425k c41425k;
            Throwable th;
            IOException iOException;
            C41425k c41425k2;
            AppMethodBeat.m2504i(120626);
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            int i = 0;
            C31711b ehS = C31710d.ehS();
            C37024f e = C37024f.m61953e(ehS, 1);
            int i2 = 0;
            while (i2 == 0) {
                try {
                    int vc = c31713e.mo51692vc();
                    switch (vc) {
                        case 0:
                            i2 = 1;
                            break;
                        case 8:
                            this.BsD |= 1;
                            this.BsW = c31713e.mo51693vd();
                            break;
                        case 16:
                            this.BsD |= 2;
                            this.Buh = c31713e.mo51693vd();
                            break;
                        case 24:
                            int vd = c31713e.mo51693vd();
                            C37005b Tj = C37005b.m61877Tj(vd);
                            if (Tj != null) {
                                this.BsD |= 4;
                                this.Bui = Tj;
                                break;
                            }
                            e.mo59058fw(vc);
                            e.mo59058fw(vd);
                            break;
                        case 34:
                            C25135c f;
                            if ((this.BsD & 8) == 8) {
                                f = C25133aa.m39555f(this.Buj);
                            } else {
                                f = null;
                            }
                            this.Buj = (C25133aa) c31713e.mo51683a(C25133aa.BsC, c31715g);
                            if (f != null) {
                                f.mo42000j(this.Buj);
                                this.Buj = f.eft();
                            }
                            this.BsD |= 8;
                            break;
                        case 40:
                            this.BsD |= 16;
                            this.Buk = c31713e.mo51693vd();
                            break;
                        case 50:
                            if ((i & 32) != 32) {
                                this.Bul = new ArrayList();
                                i |= 32;
                            }
                            this.Bul.add(c31713e.mo51683a(BsC, c31715g));
                            break;
                        case C42464aa.CTRL_INDEX /*58*/:
                            if ((i & 64) != 64) {
                                this.Bum = new ArrayList();
                                vc = i | 64;
                            } else {
                                vc = i;
                            }
                            try {
                                this.Bum.add(c31713e.mo51683a(BsC, c31715g));
                                break;
                            } catch (C41425k e2) {
                                c41425k = e2;
                                i2 = vc;
                                try {
                                    c41425k.BzY = this;
                                    AppMethodBeat.m2505o(120626);
                                    throw c41425k;
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
                                        AppMethodBeat.m2505o(120626);
                                    }
                                    eio();
                                    AppMethodBeat.m2505o(120626);
                                    throw th;
                                }
                            } catch (IOException e4) {
                                iOException = e4;
                                i2 = vc;
                                c41425k2 = new C41425k(iOException.getMessage());
                                c41425k2.BzY = this;
                                AppMethodBeat.m2505o(120626);
                                throw c41425k2;
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
                                AppMethodBeat.m2505o(120626);
                                throw th;
                            }
                        default:
                            if (!mo42012a(c31713e, e, c31715g, vc)) {
                                i2 = 1;
                                break;
                            } else {
                                vc = i;
                                break;
                            }
                    }
                } catch (C41425k c41425k22) {
                    c41425k = c41425k22;
                    i2 = i;
                    c41425k.BzY = this;
                    AppMethodBeat.m2505o(120626);
                    throw c41425k;
                } catch (IOException e5) {
                    iOException = e5;
                    i2 = i;
                    c41425k22 = new C41425k(iOException.getMessage());
                    c41425k22.BzY = this;
                    AppMethodBeat.m2505o(120626);
                    throw c41425k22;
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
                    AppMethodBeat.m2505o(120626);
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
                AppMethodBeat.m2505o(120626);
            }
            eio();
            AppMethodBeat.m2505o(120626);
        }

        static {
            AppMethodBeat.m2504i(120634);
            C37003m c37003m = new C37003m();
            Bug = c37003m;
            c37003m.ecA();
            AppMethodBeat.m2505o(120634);
        }

        public final C25163s<C37003m> ecy() {
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
            AppMethodBeat.m2504i(120627);
            this.BsW = 0;
            this.Buh = 0;
            this.Bui = C37005b.TRUE;
            this.Buj = C25133aa.eeX();
            this.Buk = 0;
            this.Bul = Collections.emptyList();
            this.Bum = Collections.emptyList();
            AppMethodBeat.m2505o(120627);
        }

        public final boolean isInitialized() {
            AppMethodBeat.m2504i(120628);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.m2505o(120628);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.m2505o(120628);
                return false;
            } else if (!eed() || this.Buj.isInitialized()) {
                int i = 0;
                while (i < this.Bul.size()) {
                    if (((C37003m) this.Bul.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120628);
                        return false;
                    }
                }
                i = 0;
                while (i < this.Bum.size()) {
                    if (((C37003m) this.Bum.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120628);
                        return false;
                    }
                }
                this.BsG = (byte) 1;
                AppMethodBeat.m2505o(120628);
                return true;
            } else {
                this.BsG = (byte) 0;
                AppMethodBeat.m2505o(120628);
                return false;
            }
        }

        /* renamed from: a */
        public final void mo128a(C37024f c37024f) {
            int i = 0;
            AppMethodBeat.m2504i(120629);
            mo144vq();
            if ((this.BsD & 1) == 1) {
                c37024f.mo59052bq(1, this.BsW);
            }
            if ((this.BsD & 2) == 2) {
                c37024f.mo59052bq(2, this.Buh);
            }
            if ((this.BsD & 4) == 4) {
                c37024f.mo59059io(3, this.Bui.value);
            }
            if ((this.BsD & 8) == 8) {
                c37024f.mo59046a(4, this.Buj);
            }
            if ((this.BsD & 16) == 16) {
                c37024f.mo59052bq(5, this.Buk);
            }
            for (int i2 = 0; i2 < this.Bul.size(); i2++) {
                c37024f.mo59046a(6, (C8185q) this.Bul.get(i2));
            }
            while (i < this.Bum.size()) {
                c37024f.mo59046a(7, (C8185q) this.Bum.get(i));
                i++;
            }
            c37024f.mo59056d(this.BsB);
            AppMethodBeat.m2505o(120629);
        }

        /* renamed from: vq */
        public final int mo144vq() {
            int i = 0;
            AppMethodBeat.m2504i(120630);
            int i2 = this.BsH;
            if (i2 != -1) {
                AppMethodBeat.m2505o(120630);
                return i2;
            }
            if ((this.BsD & 1) == 1) {
                i2 = C37024f.m61947bs(1, this.BsW) + 0;
            } else {
                i2 = 0;
            }
            if ((this.BsD & 2) == 2) {
                i2 += C37024f.m61947bs(2, this.Buh);
            }
            if ((this.BsD & 4) == 4) {
                i2 += C37024f.m61957ip(3, this.Bui.value);
            }
            if ((this.BsD & 8) == 8) {
                i2 += C37024f.m61948c(4, this.Buj);
            }
            if ((this.BsD & 16) == 16) {
                i2 += C37024f.m61947bs(5, this.Buk);
            }
            int i3 = i2;
            for (int i4 = 0; i4 < this.Bul.size(); i4++) {
                i3 += C37024f.m61948c(6, (C8185q) this.Bul.get(i4));
            }
            while (i < this.Bum.size()) {
                i3 += C37024f.m61948c(7, (C8185q) this.Bum.get(i));
                i++;
            }
            i2 = this.BsB.size() + i3;
            this.BsH = i2;
            AppMethodBeat.m2505o(120630);
            return i2;
        }

        /* renamed from: b */
        public static C37004a m61858b(C37003m c37003m) {
            AppMethodBeat.m2504i(120631);
            C37004a f = C37004a.eej().mo59022f(c37003m);
            AppMethodBeat.m2505o(120631);
            return f;
        }

        public final /* synthetic */ C8186a ecC() {
            AppMethodBeat.m2504i(120632);
            C37004a f = C37004a.eej().mo59022f(this);
            AppMethodBeat.m2505o(120632);
            return f;
        }

        public final /* synthetic */ C8186a ecD() {
            AppMethodBeat.m2504i(120633);
            C37004a eej = C37004a.eej();
            AppMethodBeat.m2505o(120633);
            return eej;
        }

        public final /* bridge */ /* synthetic */ C8185q ecE() {
            return Bug;
        }
    }

    /* renamed from: a.i.b.a.c.e.a$x */
    public interface C37006x extends C17270r {
    }

    /* renamed from: a.i.b.a.c.e.a$af */
    public interface C37010af extends C8179d {
    }

    /* renamed from: a.i.b.a.c.e.a$e */
    public static final class C37011e extends C25158c<C37011e> implements C37001f {
        public static C25163s<C37011e> BsC = new C251451();
        private static final C37011e BtN;
        private final C31710d BsB;
        private int BsD;
        private byte BsG;
        private int BsH;
        public int BsW;
        public List<Integer> BtD;
        public List<C8154ai> BtO;

        /* renamed from: a.i.b.a.c.e.a$e$1 */
        static class C251451 extends C0117b<C37011e> {
            C251451() {
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo157a(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120485);
                C37011e c37011e = new C37011e(c31713e, c31715g, (byte) 0);
                AppMethodBeat.m2505o(120485);
                return c37011e;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$e$a */
        public static final class C37012a extends C25157b<C37011e, C37012a> implements C37001f {
            private int BsD;
            private int BsW = 6;
            private List<Integer> BtD = Collections.emptyList();
            private List<C8154ai> BtO = Collections.emptyList();

            /* renamed from: a */
            public final /* synthetic */ C25159a mo147a(C25155i c25155i) {
                AppMethodBeat.m2504i(120497);
                C37012a d = mo59024d((C37011e) c25155i);
                AppMethodBeat.m2505o(120497);
                return d;
            }

            /* renamed from: c */
            public final /* synthetic */ C0115a mo148c(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120499);
                C37012a h = m61889h(c31713e, c31715g);
                AppMethodBeat.m2505o(120499);
                return h;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.m2504i(120503);
                C37012a edD = edD();
                AppMethodBeat.m2505o(120503);
                return edD;
            }

            /* renamed from: d */
            public final /* synthetic */ C8186a mo150d(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120501);
                C37012a h = m61889h(c31713e, c31715g);
                AppMethodBeat.m2505o(120501);
                return h;
            }

            public final /* synthetic */ C25159a ecK() {
                AppMethodBeat.m2504i(120498);
                C37012a edD = edD();
                AppMethodBeat.m2505o(120498);
                return edD;
            }

            public final /* synthetic */ C0115a ecL() {
                AppMethodBeat.m2504i(120500);
                C37012a edD = edD();
                AppMethodBeat.m2505o(120500);
                return edD;
            }

            public final /* synthetic */ C25157b edA() {
                AppMethodBeat.m2504i(120494);
                C37012a edD = edD();
                AppMethodBeat.m2505o(120494);
                return edD;
            }

            private C37012a() {
                AppMethodBeat.m2504i(120486);
                AppMethodBeat.m2505o(120486);
            }

            private C37011e edE() {
                int i = 1;
                AppMethodBeat.m2504i(120488);
                C37011e c37011e = new C37011e((C25157b) this, (byte) 0);
                if ((this.BsD & 1) != 1) {
                    i = 0;
                }
                c37011e.BsW = this.BsW;
                if ((this.BsD & 2) == 2) {
                    this.BtO = Collections.unmodifiableList(this.BtO);
                    this.BsD &= -3;
                }
                c37011e.BtO = this.BtO;
                if ((this.BsD & 4) == 4) {
                    this.BtD = Collections.unmodifiableList(this.BtD);
                    this.BsD &= -5;
                }
                c37011e.BtD = this.BtD;
                c37011e.BsD = i;
                AppMethodBeat.m2505o(120488);
                return c37011e;
            }

            /* renamed from: d */
            public final C37012a mo59024d(C37011e c37011e) {
                AppMethodBeat.m2504i(120489);
                if (c37011e == C37011e.edC()) {
                    AppMethodBeat.m2505o(120489);
                } else {
                    if (c37011e.ecY()) {
                        m61888Tc(c37011e.BsW);
                    }
                    if (!c37011e.BtO.isEmpty()) {
                        if (this.BtO.isEmpty()) {
                            this.BtO = c37011e.BtO;
                            this.BsD &= -3;
                        } else {
                            edF();
                            this.BtO.addAll(c37011e.BtO);
                        }
                    }
                    if (!c37011e.BtD.isEmpty()) {
                        if (this.BtD.isEmpty()) {
                            this.BtD = c37011e.BtD;
                            this.BsD &= -5;
                        } else {
                            edz();
                            this.BtD.addAll(c37011e.BtD);
                        }
                    }
                    mo42015a((C25158c) c37011e);
                    this.BsB = this.BsB.mo51672a(c37011e.BsB);
                    AppMethodBeat.m2505o(120489);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: h */
            private C37012a m61889h(C31713e c31713e, C31715g c31715g) {
                C37011e c37011e;
                Throwable th;
                AppMethodBeat.m2504i(120491);
                C37011e c37011e2 = null;
                try {
                    mo59024d((C37011e) C37011e.BsC.mo157a(c31713e, c31715g));
                    AppMethodBeat.m2505o(120491);
                    return this;
                } catch (C41425k e) {
                    C41425k c41425k = e;
                    c37011e = (C37011e) c41425k.BzY;
                    AppMethodBeat.m2505o(120491);
                    throw c41425k;
                } catch (Throwable th2) {
                    th = th2;
                    c37011e2 = c37011e;
                    if (c37011e2 != null) {
                    }
                    AppMethodBeat.m2505o(120491);
                    throw th;
                }
            }

            /* renamed from: Tc */
            private C37012a m61888Tc(int i) {
                this.BsD |= 1;
                this.BsW = i;
                return this;
            }

            private void edF() {
                AppMethodBeat.m2504i(120492);
                if ((this.BsD & 2) != 2) {
                    this.BtO = new ArrayList(this.BtO);
                    this.BsD |= 2;
                }
                AppMethodBeat.m2505o(120492);
            }

            private void edz() {
                AppMethodBeat.m2504i(120493);
                if ((this.BsD & 4) != 4) {
                    this.BtD = new ArrayList(this.BtD);
                    this.BsD |= 4;
                }
                AppMethodBeat.m2505o(120493);
            }

            private C37012a edD() {
                AppMethodBeat.m2504i(120487);
                C37012a d = new C37012a().mo59024d(edE());
                AppMethodBeat.m2505o(120487);
                return d;
            }

            public final boolean isInitialized() {
                AppMethodBeat.m2504i(120490);
                int i = 0;
                while (i < this.BtO.size()) {
                    if (((C8154ai) this.BtO.get(i)).isInitialized()) {
                        i++;
                    } else {
                        AppMethodBeat.m2505o(120490);
                        return false;
                    }
                }
                if (this.BzI.isInitialized()) {
                    AppMethodBeat.m2505o(120490);
                    return true;
                }
                AppMethodBeat.m2505o(120490);
                return false;
            }

            public final /* synthetic */ C8185q ecE() {
                AppMethodBeat.m2504i(120495);
                C37011e edC = C37011e.edC();
                AppMethodBeat.m2505o(120495);
                return edC;
            }

            public final /* synthetic */ C25155i ecJ() {
                AppMethodBeat.m2504i(120496);
                C37011e edC = C37011e.edC();
                AppMethodBeat.m2505o(120496);
                return edC;
            }

            public final /* synthetic */ C8185q ecM() {
                AppMethodBeat.m2504i(120502);
                C37011e edE = edE();
                if (edE.isInitialized()) {
                    AppMethodBeat.m2505o(120502);
                    return edE;
                }
                C44904w c44904w = new C44904w();
                AppMethodBeat.m2505o(120502);
                throw c44904w;
            }

            static /* synthetic */ C37012a edG() {
                AppMethodBeat.m2504i(120504);
                C37012a c37012a = new C37012a();
                AppMethodBeat.m2505o(120504);
                return c37012a;
            }
        }

        /* synthetic */ C37011e(C31713e c31713e, C31715g c31715g, byte b) {
            this(c31713e, c31715g);
        }

        private C37011e(C25157b<C37011e, ?> c25157b) {
            super(c25157b);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = c25157b.BsB;
        }

        private C37011e() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = C31710d.Bzq;
        }

        public static C37011e edC() {
            return BtN;
        }

        /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0040=Splitter:B:13:0x0040, B:57:0x00dd=Splitter:B:57:0x00dd} */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x004f  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x005b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private C37011e(C31713e c31713e, C31715g c31715g) {
            C41425k e;
            C41425k e2;
            Throwable th;
            IOException e3;
            AppMethodBeat.m2504i(120505);
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            int i = 0;
            C31711b ehS = C31710d.ehS();
            C37024f e4 = C37024f.m61953e(ehS, 1);
            int i2 = 0;
            while (i2 == 0) {
                int vc;
                try {
                    vc = c31713e.mo51692vc();
                    switch (vc) {
                        case 0:
                            i2 = 1;
                            break;
                        case 8:
                            this.BsD |= 1;
                            this.BsW = c31713e.mo51693vd();
                            break;
                        case 18:
                            if ((i & 2) != 2) {
                                this.BtO = new ArrayList();
                                vc = i | 2;
                            } else {
                                vc = i;
                            }
                            try {
                                this.BtO.add(c31713e.mo51683a(C8154ai.BsC, c31715g));
                                i = vc;
                                break;
                            } catch (C41425k e22) {
                                e = e22;
                                try {
                                    e.BzY = this;
                                    AppMethodBeat.m2505o(120505);
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
                                        AppMethodBeat.m2505o(120505);
                                    }
                                    this.BzI.eii();
                                    AppMethodBeat.m2505o(120505);
                                    throw th;
                                }
                            } catch (IOException e6) {
                                e3 = e6;
                                e22 = new C41425k(e3.getMessage());
                                e22.BzY = this;
                                AppMethodBeat.m2505o(120505);
                                throw e22;
                            }
                            break;
                        case C31128d.MIC_PTU_ZIPAI_THURSDAY /*248*/:
                            if ((i & 4) != 4) {
                                this.BtD = new ArrayList();
                                vc = i | 4;
                            } else {
                                vc = i;
                            }
                            this.BtD.add(Integer.valueOf(c31713e.mo51693vd()));
                            i = vc;
                            break;
                        case 250:
                            vc = c31713e.mo51690fo(c31713e.mo51693vd());
                            if ((i & 4) != 4 && c31713e.mo51695vg() > 0) {
                                this.BtD = new ArrayList();
                                i |= 4;
                            }
                            while (c31713e.mo51695vg() > 0) {
                                this.BtD.add(Integer.valueOf(c31713e.mo51693vd()));
                            }
                            c31713e.mo51691fp(vc);
                            break;
                        default:
                            if (!mo42012a(c31713e, e4, c31715g, vc)) {
                                i2 = 1;
                                break;
                            }
                            break;
                    }
                } catch (C41425k e7) {
                    e = e7;
                    vc = i;
                    e.BzY = this;
                    AppMethodBeat.m2505o(120505);
                    throw e;
                } catch (IOException e8) {
                    e3 = e8;
                    vc = i;
                    e22 = new C41425k(e3.getMessage());
                    e22.BzY = this;
                    AppMethodBeat.m2505o(120505);
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
                    AppMethodBeat.m2505o(120505);
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
                AppMethodBeat.m2505o(120505);
            }
            this.BzI.eii();
            AppMethodBeat.m2505o(120505);
        }

        static {
            AppMethodBeat.m2504i(120512);
            C37011e c37011e = new C37011e();
            BtN = c37011e;
            c37011e.ecA();
            AppMethodBeat.m2505o(120512);
        }

        public final C25163s<C37011e> ecy() {
            return BsC;
        }

        public final boolean ecY() {
            return (this.BsD & 1) == 1;
        }

        private void ecA() {
            AppMethodBeat.m2504i(120506);
            this.BsW = 6;
            this.BtO = Collections.emptyList();
            this.BtD = Collections.emptyList();
            AppMethodBeat.m2505o(120506);
        }

        public final boolean isInitialized() {
            AppMethodBeat.m2504i(120507);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.m2505o(120507);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.m2505o(120507);
                return false;
            } else {
                int i = 0;
                while (i < this.BtO.size()) {
                    if (((C8154ai) this.BtO.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120507);
                        return false;
                    }
                }
                if (this.BzI.isInitialized()) {
                    this.BsG = (byte) 1;
                    AppMethodBeat.m2505o(120507);
                    return true;
                }
                this.BsG = (byte) 0;
                AppMethodBeat.m2505o(120507);
                return false;
            }
        }

        /* renamed from: a */
        public final void mo128a(C37024f c37024f) {
            int i = 0;
            AppMethodBeat.m2504i(120508);
            mo144vq();
            C8178a eip = eip();
            if ((this.BsD & 1) == 1) {
                c37024f.mo59052bq(1, this.BsW);
            }
            for (int i2 = 0; i2 < this.BtO.size(); i2++) {
                c37024f.mo59046a(2, (C8185q) this.BtO.get(i2));
            }
            while (i < this.BtD.size()) {
                c37024f.mo59052bq(31, ((Integer) this.BtD.get(i)).intValue());
                i++;
            }
            eip.mo17990b(19000, c37024f);
            c37024f.mo59056d(this.BsB);
            AppMethodBeat.m2505o(120508);
        }

        /* renamed from: vq */
        public final int mo144vq() {
            AppMethodBeat.m2504i(120509);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.m2505o(120509);
                return i;
            }
            int i2;
            if ((this.BsD & 1) == 1) {
                i = C37024f.m61947bs(1, this.BsW) + 0;
            } else {
                i = 0;
            }
            int i3 = i;
            for (i2 = 0; i2 < this.BtO.size(); i2++) {
                i3 += C37024f.m61948c(2, (C8185q) this.BtO.get(i2));
            }
            i2 = 0;
            int i4 = 0;
            while (i2 < this.BtD.size()) {
                i2++;
                i4 = C37024f.m61954ft(((Integer) this.BtD.get(i2)).intValue()) + i4;
            }
            i = (((i3 + i4) + (this.BtD.size() * 2)) + this.BzI.mo31345vq()) + this.BsB.size();
            this.BsH = i;
            AppMethodBeat.m2505o(120509);
            return i;
        }

        public final /* bridge */ /* synthetic */ C8185q ecE() {
            return BtN;
        }

        public final /* synthetic */ C8186a ecC() {
            AppMethodBeat.m2504i(120510);
            C37012a d = C37012a.edG().mo59024d(this);
            AppMethodBeat.m2505o(120510);
            return d;
        }

        public final /* synthetic */ C8186a ecD() {
            AppMethodBeat.m2504i(120511);
            C37012a edG = C37012a.edG();
            AppMethodBeat.m2505o(120511);
            return edG;
        }
    }

    /* renamed from: a.i.b.a.c.e.a$g */
    public static final class C37013g extends C25155i implements C8159h {
        public static C25163s<C37013g> BsC = new C370021();
        private static final C37013g BtP;
        private final C31710d BsB;
        private byte BsG;
        private int BsH;
        private List<C31223i> BtQ;

        /* renamed from: a.i.b.a.c.e.a$g$a */
        public static final class C25146a extends C25159a<C37013g, C25146a> implements C8159h {
            private int BsD;
            private List<C31223i> BtQ = Collections.emptyList();

            /* renamed from: a */
            public final /* synthetic */ C25159a mo147a(C25155i c25155i) {
                AppMethodBeat.m2504i(120522);
                C25146a d = mo42009d((C37013g) c25155i);
                AppMethodBeat.m2505o(120522);
                return d;
            }

            /* renamed from: c */
            public final /* synthetic */ C0115a mo148c(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120524);
                C25146a i = m39605i(c31713e, c31715g);
                AppMethodBeat.m2505o(120524);
                return i;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.m2504i(120529);
                C25146a edJ = edJ();
                AppMethodBeat.m2505o(120529);
                return edJ;
            }

            /* renamed from: d */
            public final /* synthetic */ C8186a mo150d(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120526);
                C25146a i = m39605i(c31713e, c31715g);
                AppMethodBeat.m2505o(120526);
                return i;
            }

            public final /* synthetic */ C25159a ecK() {
                AppMethodBeat.m2504i(120523);
                C25146a edJ = edJ();
                AppMethodBeat.m2505o(120523);
                return edJ;
            }

            public final /* synthetic */ C0115a ecL() {
                AppMethodBeat.m2504i(120525);
                C25146a edJ = edJ();
                AppMethodBeat.m2505o(120525);
                return edJ;
            }

            private C25146a() {
                AppMethodBeat.m2504i(120514);
                AppMethodBeat.m2505o(120514);
            }

            public final C37013g edK() {
                AppMethodBeat.m2504i(120516);
                C37013g c37013g = new C37013g((C25159a) this, (byte) 0);
                if ((this.BsD & 1) == 1) {
                    this.BtQ = Collections.unmodifiableList(this.BtQ);
                    this.BsD &= -2;
                }
                c37013g.BtQ = this.BtQ;
                AppMethodBeat.m2505o(120516);
                return c37013g;
            }

            /* renamed from: d */
            public final C25146a mo42009d(C37013g c37013g) {
                AppMethodBeat.m2504i(120517);
                if (c37013g == C37013g.edH()) {
                    AppMethodBeat.m2505o(120517);
                } else {
                    if (!c37013g.BtQ.isEmpty()) {
                        if (this.BtQ.isEmpty()) {
                            this.BtQ = c37013g.BtQ;
                            this.BsD &= -2;
                        } else {
                            edL();
                            this.BtQ.addAll(c37013g.BtQ);
                        }
                    }
                    this.BsB = this.BsB.mo51672a(c37013g.BsB);
                    AppMethodBeat.m2505o(120517);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: i */
            private C25146a m39605i(C31713e c31713e, C31715g c31715g) {
                C37013g c37013g;
                Throwable th;
                AppMethodBeat.m2504i(120519);
                C37013g c37013g2 = null;
                try {
                    mo42009d((C37013g) C37013g.BsC.mo157a(c31713e, c31715g));
                    AppMethodBeat.m2505o(120519);
                    return this;
                } catch (C41425k e) {
                    C41425k c41425k = e;
                    c37013g = (C37013g) c41425k.BzY;
                    AppMethodBeat.m2505o(120519);
                    throw c41425k;
                } catch (Throwable th2) {
                    th = th2;
                    c37013g2 = c37013g;
                    if (c37013g2 != null) {
                    }
                    AppMethodBeat.m2505o(120519);
                    throw th;
                }
            }

            private void edL() {
                AppMethodBeat.m2504i(120520);
                if ((this.BsD & 1) != 1) {
                    this.BtQ = new ArrayList(this.BtQ);
                    this.BsD |= 1;
                }
                AppMethodBeat.m2505o(120520);
            }

            private C25146a edJ() {
                AppMethodBeat.m2504i(120515);
                C25146a d = new C25146a().mo42009d(edK());
                AppMethodBeat.m2505o(120515);
                return d;
            }

            public final boolean isInitialized() {
                AppMethodBeat.m2504i(120518);
                int i = 0;
                while (i < this.BtQ.size()) {
                    if (((C31223i) this.BtQ.get(i)).isInitialized()) {
                        i++;
                    } else {
                        AppMethodBeat.m2505o(120518);
                        return false;
                    }
                }
                AppMethodBeat.m2505o(120518);
                return true;
            }

            public final /* synthetic */ C25155i ecJ() {
                AppMethodBeat.m2504i(120521);
                C37013g edH = C37013g.edH();
                AppMethodBeat.m2505o(120521);
                return edH;
            }

            public final /* synthetic */ C8185q ecM() {
                AppMethodBeat.m2504i(120527);
                C37013g edK = edK();
                if (edK.isInitialized()) {
                    AppMethodBeat.m2505o(120527);
                    return edK;
                }
                C44904w c44904w = new C44904w();
                AppMethodBeat.m2505o(120527);
                throw c44904w;
            }

            public final /* synthetic */ C8185q ecE() {
                AppMethodBeat.m2504i(120528);
                C37013g edH = C37013g.edH();
                AppMethodBeat.m2505o(120528);
                return edH;
            }

            static /* synthetic */ C25146a edM() {
                AppMethodBeat.m2504i(120530);
                C25146a c25146a = new C25146a();
                AppMethodBeat.m2505o(120530);
                return c25146a;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$g$1 */
        static class C370021 extends C0117b<C37013g> {
            C370021() {
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo157a(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120513);
                C37013g c37013g = new C37013g(c31713e, c31715g, (byte) 0);
                AppMethodBeat.m2505o(120513);
                return c37013g;
            }
        }

        /* synthetic */ C37013g(C31713e c31713e, C31715g c31715g, byte b) {
            this(c31713e, c31715g);
        }

        public final /* synthetic */ C8186a ecC() {
            AppMethodBeat.m2504i(120537);
            C25146a edI = edI();
            AppMethodBeat.m2505o(120537);
            return edI;
        }

        private C37013g(C25159a c25159a) {
            super((byte) 0);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = c25159a.BsB;
        }

        private C37013g() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = C31710d.Bzq;
        }

        public static C37013g edH() {
            return BtP;
        }

        private C37013g(C31713e c31713e, C31715g c31715g) {
            AppMethodBeat.m2504i(120531);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BtQ = Collections.emptyList();
            C31711b ehS = C31710d.ehS();
            C37024f e = C37024f.m61953e(ehS, 1);
            int i = 0;
            int i2 = 0;
            while (i == 0) {
                try {
                    int vc = c31713e.mo51692vc();
                    switch (vc) {
                        case 0:
                            i = 1;
                            break;
                        case 10:
                            if ((i2 & 1) != 1) {
                                this.BtQ = new ArrayList();
                                i2 |= 1;
                            }
                            this.BtQ.add(c31713e.mo51683a(C31223i.BsC, c31715g));
                            break;
                        default:
                            if (!mo42012a(c31713e, e, c31715g, vc)) {
                                i = 1;
                                break;
                            }
                            break;
                    }
                } catch (C41425k e2) {
                    e2.BzY = this;
                    AppMethodBeat.m2505o(120531);
                    throw e2;
                } catch (IOException e3) {
                    C41425k c41425k = new C41425k(e3.getMessage());
                    c41425k.BzY = this;
                    AppMethodBeat.m2505o(120531);
                    throw c41425k;
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
                        AppMethodBeat.m2505o(120531);
                    }
                    eio();
                    AppMethodBeat.m2505o(120531);
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
                AppMethodBeat.m2505o(120531);
            }
            eio();
            AppMethodBeat.m2505o(120531);
        }

        static {
            AppMethodBeat.m2504i(120539);
            C37013g c37013g = new C37013g();
            BtP = c37013g;
            c37013g.BtQ = Collections.emptyList();
            AppMethodBeat.m2505o(120539);
        }

        public final C25163s<C37013g> ecy() {
            return BsC;
        }

        public final boolean isInitialized() {
            AppMethodBeat.m2504i(120532);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.m2505o(120532);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.m2505o(120532);
                return false;
            } else {
                int i = 0;
                while (i < this.BtQ.size()) {
                    if (((C31223i) this.BtQ.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120532);
                        return false;
                    }
                }
                this.BsG = (byte) 1;
                AppMethodBeat.m2505o(120532);
                return true;
            }
        }

        /* renamed from: a */
        public final void mo128a(C37024f c37024f) {
            AppMethodBeat.m2504i(120533);
            mo144vq();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.BtQ.size()) {
                    c37024f.mo59046a(1, (C8185q) this.BtQ.get(i2));
                    i = i2 + 1;
                } else {
                    c37024f.mo59056d(this.BsB);
                    AppMethodBeat.m2505o(120533);
                    return;
                }
            }
        }

        /* renamed from: vq */
        public final int mo144vq() {
            AppMethodBeat.m2504i(120534);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.m2505o(120534);
                return i;
            }
            int i2 = 0;
            for (i = 0; i < this.BtQ.size(); i++) {
                i2 += C37024f.m61948c(1, (C8185q) this.BtQ.get(i));
            }
            int size = this.BsB.size() + i2;
            this.BsH = size;
            AppMethodBeat.m2505o(120534);
            return size;
        }

        /* renamed from: a */
        public static C25146a m61894a(C37013g c37013g) {
            AppMethodBeat.m2504i(120535);
            C25146a d = C25146a.edM().mo42009d(c37013g);
            AppMethodBeat.m2505o(120535);
            return d;
        }

        public final C25146a edI() {
            AppMethodBeat.m2504i(120536);
            C25146a d = C25146a.edM().mo42009d(this);
            AppMethodBeat.m2505o(120536);
            return d;
        }

        public final /* synthetic */ C8186a ecD() {
            AppMethodBeat.m2504i(120538);
            C25146a edM = C25146a.edM();
            AppMethodBeat.m2505o(120538);
            return edM;
        }

        public final /* bridge */ /* synthetic */ C8185q ecE() {
            return BtP;
        }
    }

    /* renamed from: a.i.b.a.c.e.a$ae */
    public static final class C37014ae extends C25158c<C37014ae> implements C37010af {
        public static C25163s<C37014ae> BsC = new C316831();
        private static final C37014ae BvB;
        private final C31710d BsB;
        private int BsD;
        public int BsE;
        private byte BsG;
        private int BsH;
        public int Buf;
        public boolean BvC;
        public C36998b BvD;
        public List<C25133aa> BvE;
        public List<Integer> BvF;
        private int BvG;

        /* renamed from: a.i.b.a.c.e.a$ae$1 */
        static class C316831 extends C0117b<C37014ae> {
            C316831() {
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo157a(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120917);
                C37014ae c37014ae = new C37014ae(c31713e, c31715g, (byte) 0);
                AppMethodBeat.m2505o(120917);
                return c37014ae;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$ae$b */
        public enum C36998b implements C8183a {
            IN(0),
            OUT(1),
            INV(2);
            
            private static C8182b<C36998b> Btk;
            final int value;

            /* renamed from: a.i.b.a.c.e.a$ae$b$1 */
            static class C251391 implements C8182b<C36998b> {
                C251391() {
                }

                /* renamed from: SW */
                public final /* synthetic */ C8183a mo146SW(int i) {
                    AppMethodBeat.m2504i(120938);
                    C36998b TT = C36998b.m61811TT(i);
                    AppMethodBeat.m2505o(120938);
                    return TT;
                }
            }

            static {
                Btk = new C251391();
                AppMethodBeat.m2505o(120941);
            }

            public final int edd() {
                return this.value;
            }

            /* renamed from: TT */
            public static C36998b m61811TT(int i) {
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

            private C36998b(int i) {
                this.value = i;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$ae$a */
        public static final class C37015a extends C25157b<C37014ae, C37015a> implements C37010af {
            private int BsD;
            private int BsE;
            private int Buf;
            private boolean BvC;
            private C36998b BvD = C36998b.INV;
            private List<C25133aa> BvE = Collections.emptyList();
            private List<Integer> BvF = Collections.emptyList();

            /* renamed from: c */
            public final /* synthetic */ C0115a mo148c(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120932);
                C37015a v = m61916v(c31713e, c31715g);
                AppMethodBeat.m2505o(120932);
                return v;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.m2504i(120936);
                C37015a efH = efH();
                AppMethodBeat.m2505o(120936);
                return efH;
            }

            /* renamed from: d */
            public final /* synthetic */ C8186a mo150d(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120934);
                C37015a v = m61916v(c31713e, c31715g);
                AppMethodBeat.m2505o(120934);
                return v;
            }

            public final /* synthetic */ C25159a ecK() {
                AppMethodBeat.m2504i(120931);
                C37015a efH = efH();
                AppMethodBeat.m2505o(120931);
                return efH;
            }

            public final /* synthetic */ C0115a ecL() {
                AppMethodBeat.m2504i(120933);
                C37015a efH = efH();
                AppMethodBeat.m2505o(120933);
                return efH;
            }

            public final /* synthetic */ C25157b edA() {
                AppMethodBeat.m2504i(120927);
                C37015a efH = efH();
                AppMethodBeat.m2505o(120927);
                return efH;
            }

            private C37015a() {
                AppMethodBeat.m2504i(120918);
                AppMethodBeat.m2505o(120918);
            }

            private C37014ae efI() {
                int i = 1;
                AppMethodBeat.m2504i(120920);
                C37014ae c37014ae = new C37014ae((C25157b) this, (byte) 0);
                int i2 = this.BsD;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                c37014ae.BsE = this.BsE;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                c37014ae.Buf = this.Buf;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                c37014ae.BvC = this.BvC;
                if ((i2 & 8) == 8) {
                    i |= 8;
                }
                c37014ae.BvD = this.BvD;
                if ((this.BsD & 16) == 16) {
                    this.BvE = Collections.unmodifiableList(this.BvE);
                    this.BsD &= -17;
                }
                c37014ae.BvE = this.BvE;
                if ((this.BsD & 32) == 32) {
                    this.BvF = Collections.unmodifiableList(this.BvF);
                    this.BsD &= -33;
                }
                c37014ae.BvF = this.BvF;
                c37014ae.BsD = i;
                AppMethodBeat.m2505o(120920);
                return c37014ae;
            }

            /* renamed from: d */
            public final C37015a mo59030d(C37014ae c37014ae) {
                AppMethodBeat.m2504i(120921);
                if (c37014ae == C37014ae.efE()) {
                    AppMethodBeat.m2505o(120921);
                } else {
                    if (c37014ae.ecz()) {
                        m61912TR(c37014ae.BsE);
                    }
                    if (c37014ae.edW()) {
                        m61913TS(c37014ae.Buf);
                    }
                    if (c37014ae.efF()) {
                        m61915rO(c37014ae.BvC);
                    }
                    if (c37014ae.efG()) {
                        m61914a(c37014ae.BvD);
                    }
                    if (!c37014ae.BvE.isEmpty()) {
                        if (this.BvE.isEmpty()) {
                            this.BvE = c37014ae.BvE;
                            this.BsD &= -17;
                        } else {
                            efJ();
                            this.BvE.addAll(c37014ae.BvE);
                        }
                    }
                    if (!c37014ae.BvF.isEmpty()) {
                        if (this.BvF.isEmpty()) {
                            this.BvF = c37014ae.BvF;
                            this.BsD &= -33;
                        } else {
                            efK();
                            this.BvF.addAll(c37014ae.BvF);
                        }
                    }
                    mo42015a((C25158c) c37014ae);
                    this.BsB = this.BsB.mo51672a(c37014ae.BsB);
                    AppMethodBeat.m2505o(120921);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: v */
            private C37015a m61916v(C31713e c31713e, C31715g c31715g) {
                C37014ae c37014ae;
                Throwable th;
                AppMethodBeat.m2504i(120923);
                C37014ae c37014ae2 = null;
                try {
                    mo59030d((C37014ae) C37014ae.BsC.mo157a(c31713e, c31715g));
                    AppMethodBeat.m2505o(120923);
                    return this;
                } catch (C41425k e) {
                    C41425k c41425k = e;
                    c37014ae = (C37014ae) c41425k.BzY;
                    AppMethodBeat.m2505o(120923);
                    throw c41425k;
                } catch (Throwable th2) {
                    th = th2;
                    c37014ae2 = c37014ae;
                    if (c37014ae2 != null) {
                    }
                    AppMethodBeat.m2505o(120923);
                    throw th;
                }
            }

            /* renamed from: TR */
            private C37015a m61912TR(int i) {
                this.BsD |= 1;
                this.BsE = i;
                return this;
            }

            /* renamed from: TS */
            private C37015a m61913TS(int i) {
                this.BsD |= 2;
                this.Buf = i;
                return this;
            }

            /* renamed from: rO */
            private C37015a m61915rO(boolean z) {
                this.BsD |= 4;
                this.BvC = z;
                return this;
            }

            /* renamed from: a */
            private C37015a m61914a(C36998b c36998b) {
                AppMethodBeat.m2504i(120924);
                if (c36998b == null) {
                    NullPointerException nullPointerException = new NullPointerException();
                    AppMethodBeat.m2505o(120924);
                    throw nullPointerException;
                }
                this.BsD |= 8;
                this.BvD = c36998b;
                AppMethodBeat.m2505o(120924);
                return this;
            }

            private void efJ() {
                AppMethodBeat.m2504i(120925);
                if ((this.BsD & 16) != 16) {
                    this.BvE = new ArrayList(this.BvE);
                    this.BsD |= 16;
                }
                AppMethodBeat.m2505o(120925);
            }

            private void efK() {
                AppMethodBeat.m2504i(120926);
                if ((this.BsD & 32) != 32) {
                    this.BvF = new ArrayList(this.BvF);
                    this.BsD |= 32;
                }
                AppMethodBeat.m2505o(120926);
            }

            private C37015a efH() {
                AppMethodBeat.m2504i(120919);
                C37015a d = new C37015a().mo59030d(efI());
                AppMethodBeat.m2505o(120919);
                return d;
            }

            public final boolean isInitialized() {
                boolean z;
                AppMethodBeat.m2504i(120922);
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
                            if (((C25133aa) this.BvE.get(i)).isInitialized()) {
                                i++;
                            } else {
                                AppMethodBeat.m2505o(120922);
                                return false;
                            }
                        }
                        if (this.BzI.isInitialized()) {
                            AppMethodBeat.m2505o(120922);
                            return true;
                        }
                        AppMethodBeat.m2505o(120922);
                        return false;
                    }
                    AppMethodBeat.m2505o(120922);
                    return false;
                }
                AppMethodBeat.m2505o(120922);
                return false;
            }

            public final /* synthetic */ C8185q ecE() {
                AppMethodBeat.m2504i(120928);
                C37014ae efE = C37014ae.efE();
                AppMethodBeat.m2505o(120928);
                return efE;
            }

            public final /* synthetic */ C25155i ecJ() {
                AppMethodBeat.m2504i(120929);
                C37014ae efE = C37014ae.efE();
                AppMethodBeat.m2505o(120929);
                return efE;
            }

            public final /* synthetic */ C8185q ecM() {
                AppMethodBeat.m2504i(120935);
                C37014ae efI = efI();
                if (efI.isInitialized()) {
                    AppMethodBeat.m2505o(120935);
                    return efI;
                }
                C44904w c44904w = new C44904w();
                AppMethodBeat.m2505o(120935);
                throw c44904w;
            }

            static /* synthetic */ C37015a efL() {
                AppMethodBeat.m2504i(120937);
                C37015a c37015a = new C37015a();
                AppMethodBeat.m2505o(120937);
                return c37015a;
            }
        }

        /* synthetic */ C37014ae(C31713e c31713e, C31715g c31715g, byte b) {
            this(c31713e, c31715g);
        }

        private C37014ae(C25157b<C37014ae, ?> c25157b) {
            super(c25157b);
            this.BvG = -1;
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = c25157b.BsB;
        }

        private C37014ae() {
            this.BvG = -1;
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = C31710d.Bzq;
        }

        public static C37014ae efE() {
            return BvB;
        }

        /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0044=Splitter:B:13:0x0044, B:34:0x0088=Splitter:B:34:0x0088} */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x005f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private C37014ae(C31713e c31713e, C31715g c31715g) {
            C41425k e;
            C41425k e2;
            Throwable th;
            IOException e3;
            AppMethodBeat.m2504i(120942);
            this.BvG = -1;
            this.BsG = (byte) -1;
            this.BsH = -1;
            ecA();
            int i = 0;
            C31711b ehS = C31710d.ehS();
            C37024f e4 = C37024f.m61953e(ehS, 1);
            int i2 = 0;
            while (i2 == 0) {
                int vc;
                try {
                    vc = c31713e.mo51692vc();
                    switch (vc) {
                        case 0:
                            i2 = 1;
                            break;
                        case 8:
                            this.BsD |= 1;
                            this.BsE = c31713e.mo51693vd();
                            break;
                        case 16:
                            this.BsD |= 2;
                            this.Buf = c31713e.mo51693vd();
                            break;
                        case 24:
                            this.BsD |= 4;
                            this.BvC = c31713e.ehX();
                            break;
                        case 32:
                            int vd = c31713e.mo51693vd();
                            C36998b TT = C36998b.m61811TT(vd);
                            if (TT != null) {
                                this.BsD |= 8;
                                this.BvD = TT;
                                break;
                            }
                            e4.mo59058fw(vc);
                            e4.mo59058fw(vd);
                            break;
                        case 42:
                            if ((i & 16) != 16) {
                                this.BvE = new ArrayList();
                                vc = i | 16;
                            } else {
                                vc = i;
                            }
                            try {
                                this.BvE.add(c31713e.mo51683a(C25133aa.BsC, c31715g));
                                i = vc;
                                break;
                            } catch (C41425k e22) {
                                e = e22;
                                try {
                                    e.BzY = this;
                                    AppMethodBeat.m2505o(120942);
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
                                        AppMethodBeat.m2505o(120942);
                                    }
                                    this.BzI.eii();
                                    AppMethodBeat.m2505o(120942);
                                    throw th;
                                }
                            } catch (IOException e6) {
                                e3 = e6;
                                e22 = new C41425k(e3.getMessage());
                                e22.BzY = this;
                                AppMethodBeat.m2505o(120942);
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
                            this.BvF.add(Integer.valueOf(c31713e.mo51693vd()));
                            i = vc;
                            break;
                        case 50:
                            vc = c31713e.mo51690fo(c31713e.mo51693vd());
                            if ((i & 32) != 32 && c31713e.mo51695vg() > 0) {
                                this.BvF = new ArrayList();
                                i |= 32;
                            }
                            while (c31713e.mo51695vg() > 0) {
                                this.BvF.add(Integer.valueOf(c31713e.mo51693vd()));
                            }
                            c31713e.mo51691fp(vc);
                            break;
                        default:
                            if (!mo42012a(c31713e, e4, c31715g, vc)) {
                                i2 = 1;
                                break;
                            }
                            break;
                    }
                } catch (C41425k e7) {
                    e = e7;
                    vc = i;
                    e.BzY = this;
                    AppMethodBeat.m2505o(120942);
                    throw e;
                } catch (IOException e8) {
                    e3 = e8;
                    vc = i;
                    e22 = new C41425k(e3.getMessage());
                    e22.BzY = this;
                    AppMethodBeat.m2505o(120942);
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
                    AppMethodBeat.m2505o(120942);
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
                AppMethodBeat.m2505o(120942);
            }
            this.BzI.eii();
            AppMethodBeat.m2505o(120942);
        }

        static {
            AppMethodBeat.m2504i(120949);
            C37014ae c37014ae = new C37014ae();
            BvB = c37014ae;
            c37014ae.ecA();
            AppMethodBeat.m2505o(120949);
        }

        public final C25163s<C37014ae> ecy() {
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
            AppMethodBeat.m2504i(120943);
            this.BsE = 0;
            this.Buf = 0;
            this.BvC = false;
            this.BvD = C36998b.INV;
            this.BvE = Collections.emptyList();
            this.BvF = Collections.emptyList();
            AppMethodBeat.m2505o(120943);
        }

        public final boolean isInitialized() {
            AppMethodBeat.m2504i(120944);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.m2505o(120944);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.m2505o(120944);
                return false;
            } else if (!ecz()) {
                this.BsG = (byte) 0;
                AppMethodBeat.m2505o(120944);
                return false;
            } else if (edW()) {
                int i = 0;
                while (i < this.BvE.size()) {
                    if (((C25133aa) this.BvE.get(i)).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120944);
                        return false;
                    }
                }
                if (this.BzI.isInitialized()) {
                    this.BsG = (byte) 1;
                    AppMethodBeat.m2505o(120944);
                    return true;
                }
                this.BsG = (byte) 0;
                AppMethodBeat.m2505o(120944);
                return false;
            } else {
                this.BsG = (byte) 0;
                AppMethodBeat.m2505o(120944);
                return false;
            }
        }

        /* renamed from: a */
        public final void mo128a(C37024f c37024f) {
            int i = 0;
            AppMethodBeat.m2504i(120945);
            mo144vq();
            C8178a eip = eip();
            if ((this.BsD & 1) == 1) {
                c37024f.mo59052bq(1, this.BsE);
            }
            if ((this.BsD & 2) == 2) {
                c37024f.mo59052bq(2, this.Buf);
            }
            if ((this.BsD & 4) == 4) {
                c37024f.mo59062rP(this.BvC);
            }
            if ((this.BsD & 8) == 8) {
                c37024f.mo59059io(4, this.BvD.value);
            }
            for (int i2 = 0; i2 < this.BvE.size(); i2++) {
                c37024f.mo59046a(5, (C8185q) this.BvE.get(i2));
            }
            if (this.BvF.size() > 0) {
                c37024f.mo59058fw(50);
                c37024f.mo59058fw(this.BvG);
            }
            while (i < this.BvF.size()) {
                c37024f.mo59043Uy(((Integer) this.BvF.get(i)).intValue());
                i++;
            }
            eip.mo17990b(1000, c37024f);
            c37024f.mo59056d(this.BsB);
            AppMethodBeat.m2505o(120945);
        }

        /* renamed from: vq */
        public final int mo144vq() {
            AppMethodBeat.m2504i(120946);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.m2505o(120946);
                return i;
            }
            int i2;
            if ((this.BsD & 1) == 1) {
                i = C37024f.m61947bs(1, this.BsE) + 0;
            } else {
                i = 0;
            }
            if ((this.BsD & 2) == 2) {
                i += C37024f.m61947bs(2, this.Buf);
            }
            if ((this.BsD & 4) == 4) {
                i += C37024f.m61955fv(3) + 1;
            }
            if ((this.BsD & 8) == 8) {
                i += C37024f.m61957ip(4, this.BvD.value);
            }
            int i3 = i;
            for (i2 = 0; i2 < this.BvE.size(); i2++) {
                i3 += C37024f.m61948c(5, (C8185q) this.BvE.get(i2));
            }
            i2 = 0;
            int i4 = 0;
            while (i2 < this.BvF.size()) {
                i2++;
                i4 = C37024f.m61954ft(((Integer) this.BvF.get(i2)).intValue()) + i4;
            }
            i = i3 + i4;
            if (!this.BvF.isEmpty()) {
                i = (i + 1) + C37024f.m61954ft(i4);
            }
            this.BvG = i4;
            i = (i + this.BzI.mo31345vq()) + this.BsB.size();
            this.BsH = i;
            AppMethodBeat.m2505o(120946);
            return i;
        }

        public final /* bridge */ /* synthetic */ C8185q ecE() {
            return BvB;
        }

        public final /* synthetic */ C8186a ecC() {
            AppMethodBeat.m2504i(120947);
            C37015a d = C37015a.efL().mo59030d(this);
            AppMethodBeat.m2505o(120947);
            return d;
        }

        public final /* synthetic */ C8186a ecD() {
            AppMethodBeat.m2504i(120948);
            C37015a efL = C37015a.efL();
            AppMethodBeat.m2505o(120948);
            return efL;
        }
    }

    /* renamed from: a.i.b.a.c.e.a$ah */
    public interface C37016ah extends C17270r {
    }

    /* renamed from: a.i.b.a.c.e.a$d */
    public interface C37017d extends C8179d {
    }

    /* renamed from: a.i.b.a.c.e.a$w */
    public static final class C37018w extends C25155i implements C37006x {
        public static C25163s<C37018w> BsC = new C172501();
        private static final C37018w BuN;
        private final C31710d BsB;
        private byte BsG;
        private int BsH;
        private List<C31227b> BuO;

        /* renamed from: a.i.b.a.c.e.a$w$c */
        public interface C8165c extends C17270r {
        }

        /* renamed from: a.i.b.a.c.e.a$w$1 */
        static class C172501 extends C0117b<C37018w> {
            C172501() {
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo157a(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120740);
                C37018w c37018w = new C37018w(c31713e, c31715g, (byte) 0);
                AppMethodBeat.m2505o(120740);
                return c37018w;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$w$b */
        public static final class C31227b extends C25155i implements C8165c {
            public static C25163s<C31227b> BsC = new C312281();
            private static final C31227b BuP;
            private final C31710d BsB;
            private int BsD;
            private byte BsG;
            private int BsH;
            public int BuQ;
            public int BuR;
            public C25150b BuS;

            /* renamed from: a.i.b.a.c.e.a$w$b$a */
            public static final class C17251a extends C25159a<C31227b, C17251a> implements C8165c {
                private int BsD;
                private int BuQ = -1;
                private int BuR;
                private C25150b BuS = C25150b.PACKAGE;

                /* renamed from: c */
                public final /* synthetic */ C0115a mo148c(C31713e c31713e, C31715g c31715g) {
                    AppMethodBeat.m2504i(120767);
                    C17251a q = m26709q(c31713e, c31715g);
                    AppMethodBeat.m2505o(120767);
                    return q;
                }

                public final /* synthetic */ Object clone() {
                    AppMethodBeat.m2504i(120772);
                    C17251a eeO = eeO();
                    AppMethodBeat.m2505o(120772);
                    return eeO;
                }

                /* renamed from: d */
                public final /* synthetic */ C8186a mo150d(C31713e c31713e, C31715g c31715g) {
                    AppMethodBeat.m2504i(120769);
                    C17251a q = m26709q(c31713e, c31715g);
                    AppMethodBeat.m2505o(120769);
                    return q;
                }

                public final /* synthetic */ C25159a ecK() {
                    AppMethodBeat.m2504i(120766);
                    C17251a eeO = eeO();
                    AppMethodBeat.m2505o(120766);
                    return eeO;
                }

                public final /* synthetic */ C0115a ecL() {
                    AppMethodBeat.m2504i(120768);
                    C17251a eeO = eeO();
                    AppMethodBeat.m2505o(120768);
                    return eeO;
                }

                private C17251a() {
                }

                private C31227b eeP() {
                    int i = 1;
                    AppMethodBeat.m2504i(120760);
                    C31227b c31227b = new C31227b((C25159a) this, (byte) 0);
                    int i2 = this.BsD;
                    if ((i2 & 1) != 1) {
                        i = 0;
                    }
                    c31227b.BuQ = this.BuQ;
                    if ((i2 & 2) == 2) {
                        i |= 2;
                    }
                    c31227b.BuR = this.BuR;
                    if ((i2 & 4) == 4) {
                        i |= 4;
                    }
                    c31227b.BuS = this.BuS;
                    c31227b.BsD = i;
                    AppMethodBeat.m2505o(120760);
                    return c31227b;
                }

                /* renamed from: b */
                public final C17251a mo31311b(C31227b c31227b) {
                    AppMethodBeat.m2504i(120761);
                    if (c31227b == C31227b.eeL()) {
                        AppMethodBeat.m2505o(120761);
                    } else {
                        if (c31227b.eeM()) {
                            m26707Tz(c31227b.BuQ);
                        }
                        if (c31227b.eeN()) {
                            m26706TA(c31227b.BuR);
                        }
                        if (c31227b.edQ()) {
                            m26708a(c31227b.BuS);
                        }
                        this.BsB = this.BsB.mo51672a(c31227b.BsB);
                        AppMethodBeat.m2505o(120761);
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
                /* renamed from: q */
                private C17251a m26709q(C31713e c31713e, C31715g c31715g) {
                    C31227b c31227b;
                    Throwable th;
                    AppMethodBeat.m2504i(120762);
                    C31227b c31227b2 = null;
                    try {
                        mo31311b((C31227b) C31227b.BsC.mo157a(c31713e, c31715g));
                        AppMethodBeat.m2505o(120762);
                        return this;
                    } catch (C41425k e) {
                        C41425k c41425k = e;
                        c31227b = (C31227b) c41425k.BzY;
                        AppMethodBeat.m2505o(120762);
                        throw c41425k;
                    } catch (Throwable th2) {
                        th = th2;
                        c31227b2 = c31227b;
                        if (c31227b2 != null) {
                        }
                        AppMethodBeat.m2505o(120762);
                        throw th;
                    }
                }

                /* renamed from: Tz */
                private C17251a m26707Tz(int i) {
                    this.BsD |= 1;
                    this.BuQ = i;
                    return this;
                }

                /* renamed from: TA */
                private C17251a m26706TA(int i) {
                    this.BsD |= 2;
                    this.BuR = i;
                    return this;
                }

                /* renamed from: a */
                private C17251a m26708a(C25150b c25150b) {
                    AppMethodBeat.m2504i(120763);
                    if (c25150b == null) {
                        NullPointerException nullPointerException = new NullPointerException();
                        AppMethodBeat.m2505o(120763);
                        throw nullPointerException;
                    }
                    this.BsD |= 4;
                    this.BuS = c25150b;
                    AppMethodBeat.m2505o(120763);
                    return this;
                }

                private C17251a eeO() {
                    AppMethodBeat.m2504i(120759);
                    C17251a b = new C17251a().mo31311b(eeP());
                    AppMethodBeat.m2505o(120759);
                    return b;
                }

                public final /* synthetic */ C25155i ecJ() {
                    AppMethodBeat.m2504i(120764);
                    C31227b eeL = C31227b.eeL();
                    AppMethodBeat.m2505o(120764);
                    return eeL;
                }

                public final /* synthetic */ C8185q ecM() {
                    AppMethodBeat.m2504i(120770);
                    C31227b eeP = eeP();
                    if (eeP.isInitialized()) {
                        AppMethodBeat.m2505o(120770);
                        return eeP;
                    }
                    C44904w c44904w = new C44904w();
                    AppMethodBeat.m2505o(120770);
                    throw c44904w;
                }

                public final /* synthetic */ C8185q ecE() {
                    AppMethodBeat.m2504i(120771);
                    C31227b eeL = C31227b.eeL();
                    AppMethodBeat.m2505o(120771);
                    return eeL;
                }

                static /* synthetic */ C17251a eeQ() {
                    AppMethodBeat.m2504i(120773);
                    C17251a c17251a = new C17251a();
                    AppMethodBeat.m2505o(120773);
                    return c17251a;
                }
            }

            /* renamed from: a.i.b.a.c.e.a$w$b$b */
            public enum C25150b implements C8183a {
                CLASS(0),
                PACKAGE(1),
                LOCAL(2);
                
                private static C8182b<C25150b> Btk;
                final int value;

                /* renamed from: a.i.b.a.c.e.a$w$b$b$1 */
                static class C251491 implements C8182b<C25150b> {
                    C251491() {
                    }

                    /* renamed from: SW */
                    public final /* synthetic */ C8183a mo146SW(int i) {
                        AppMethodBeat.m2504i(120774);
                        C25150b TB = C25150b.m39617TB(i);
                        AppMethodBeat.m2505o(120774);
                        return TB;
                    }
                }

                static {
                    Btk = new C251491();
                    AppMethodBeat.m2505o(120777);
                }

                public final int edd() {
                    return this.value;
                }

                /* renamed from: TB */
                public static C25150b m39617TB(int i) {
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

                private C25150b(int i) {
                    this.value = i;
                }
            }

            /* renamed from: a.i.b.a.c.e.a$w$b$1 */
            static class C312281 extends C0117b<C31227b> {
                C312281() {
                }

                /* renamed from: a */
                public final /* synthetic */ Object mo157a(C31713e c31713e, C31715g c31715g) {
                    AppMethodBeat.m2504i(120758);
                    C31227b c31227b = new C31227b(c31713e, c31715g, (byte) 0);
                    AppMethodBeat.m2505o(120758);
                    return c31227b;
                }
            }

            /* synthetic */ C31227b(C31713e c31713e, C31715g c31715g, byte b) {
                this(c31713e, c31715g);
            }

            private C31227b(C25159a c25159a) {
                super((byte) 0);
                this.BsG = (byte) -1;
                this.BsH = -1;
                this.BsB = c25159a.BsB;
            }

            private C31227b() {
                this.BsG = (byte) -1;
                this.BsH = -1;
                this.BsB = C31710d.Bzq;
            }

            public static C31227b eeL() {
                return BuP;
            }

            private C31227b(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120778);
                this.BsG = (byte) -1;
                this.BsH = -1;
                ecA();
                C31711b ehS = C31710d.ehS();
                C37024f e = C37024f.m61953e(ehS, 1);
                int i = 0;
                while (i == 0) {
                    try {
                        int vc = c31713e.mo51692vc();
                        switch (vc) {
                            case 0:
                                i = 1;
                                break;
                            case 8:
                                this.BsD |= 1;
                                this.BuQ = c31713e.mo51693vd();
                                break;
                            case 16:
                                this.BsD |= 2;
                                this.BuR = c31713e.mo51693vd();
                                break;
                            case 24:
                                int vd = c31713e.mo51693vd();
                                C25150b TB = C25150b.m39617TB(vd);
                                if (TB != null) {
                                    this.BsD |= 4;
                                    this.BuS = TB;
                                    break;
                                }
                                e.mo59058fw(vc);
                                e.mo59058fw(vd);
                                break;
                            default:
                                if (!mo42012a(c31713e, e, c31715g, vc)) {
                                    i = 1;
                                    break;
                                }
                                break;
                        }
                    } catch (C41425k e2) {
                        e2.BzY = this;
                        AppMethodBeat.m2505o(120778);
                        throw e2;
                    } catch (IOException e3) {
                        C41425k c41425k = new C41425k(e3.getMessage());
                        c41425k.BzY = this;
                        AppMethodBeat.m2505o(120778);
                        throw c41425k;
                    } catch (Throwable th) {
                        try {
                            e.flush();
                            this.BsB = ehS.ehW();
                        } catch (IOException e4) {
                            this.BsB = ehS.ehW();
                        } catch (Throwable th2) {
                            this.BsB = ehS.ehW();
                            AppMethodBeat.m2505o(120778);
                        }
                        eio();
                        AppMethodBeat.m2505o(120778);
                    }
                }
                try {
                    e.flush();
                    this.BsB = ehS.ehW();
                } catch (IOException e5) {
                    this.BsB = ehS.ehW();
                } catch (Throwable th3) {
                    this.BsB = ehS.ehW();
                    AppMethodBeat.m2505o(120778);
                }
                eio();
                AppMethodBeat.m2505o(120778);
            }

            static {
                AppMethodBeat.m2504i(120784);
                C31227b c31227b = new C31227b();
                BuP = c31227b;
                c31227b.ecA();
                AppMethodBeat.m2505o(120784);
            }

            public final C25163s<C31227b> ecy() {
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
                this.BuS = C25150b.PACKAGE;
            }

            public final boolean isInitialized() {
                AppMethodBeat.m2504i(120779);
                byte b = this.BsG;
                if (b == (byte) 1) {
                    AppMethodBeat.m2505o(120779);
                    return true;
                } else if (b == (byte) 0) {
                    AppMethodBeat.m2505o(120779);
                    return false;
                } else if (eeN()) {
                    this.BsG = (byte) 1;
                    AppMethodBeat.m2505o(120779);
                    return true;
                } else {
                    this.BsG = (byte) 0;
                    AppMethodBeat.m2505o(120779);
                    return false;
                }
            }

            /* renamed from: a */
            public final void mo128a(C37024f c37024f) {
                AppMethodBeat.m2504i(120780);
                mo144vq();
                if ((this.BsD & 1) == 1) {
                    c37024f.mo59052bq(1, this.BuQ);
                }
                if ((this.BsD & 2) == 2) {
                    c37024f.mo59052bq(2, this.BuR);
                }
                if ((this.BsD & 4) == 4) {
                    c37024f.mo59059io(3, this.BuS.value);
                }
                c37024f.mo59056d(this.BsB);
                AppMethodBeat.m2505o(120780);
            }

            /* renamed from: vq */
            public final int mo144vq() {
                AppMethodBeat.m2504i(120781);
                int i = this.BsH;
                if (i != -1) {
                    AppMethodBeat.m2505o(120781);
                    return i;
                }
                i = 0;
                if ((this.BsD & 1) == 1) {
                    i = C37024f.m61947bs(1, this.BuQ) + 0;
                }
                if ((this.BsD & 2) == 2) {
                    i += C37024f.m61947bs(2, this.BuR);
                }
                if ((this.BsD & 4) == 4) {
                    i += C37024f.m61957ip(3, this.BuS.value);
                }
                i += this.BsB.size();
                this.BsH = i;
                AppMethodBeat.m2505o(120781);
                return i;
            }

            public final /* synthetic */ C8186a ecC() {
                AppMethodBeat.m2504i(120782);
                C17251a b = C17251a.eeQ().mo31311b(this);
                AppMethodBeat.m2505o(120782);
                return b;
            }

            public final /* synthetic */ C8186a ecD() {
                AppMethodBeat.m2504i(120783);
                C17251a eeQ = C17251a.eeQ();
                AppMethodBeat.m2505o(120783);
                return eeQ;
            }

            public final /* bridge */ /* synthetic */ C8185q ecE() {
                return BuP;
            }
        }

        /* renamed from: a.i.b.a.c.e.a$w$a */
        public static final class C37019a extends C25159a<C37018w, C37019a> implements C37006x {
            private int BsD;
            private List<C31227b> BuO = Collections.emptyList();

            /* renamed from: a */
            public final /* synthetic */ C25159a mo147a(C25155i c25155i) {
                AppMethodBeat.m2504i(120749);
                C37019a d = mo59033d((C37018w) c25155i);
                AppMethodBeat.m2505o(120749);
                return d;
            }

            /* renamed from: c */
            public final /* synthetic */ C0115a mo148c(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120751);
                C37019a p = m61928p(c31713e, c31715g);
                AppMethodBeat.m2505o(120751);
                return p;
            }

            public final /* synthetic */ Object clone() {
                AppMethodBeat.m2504i(120756);
                C37019a eeH = eeH();
                AppMethodBeat.m2505o(120756);
                return eeH;
            }

            /* renamed from: d */
            public final /* synthetic */ C8186a mo150d(C31713e c31713e, C31715g c31715g) {
                AppMethodBeat.m2504i(120753);
                C37019a p = m61928p(c31713e, c31715g);
                AppMethodBeat.m2505o(120753);
                return p;
            }

            public final /* synthetic */ C25159a ecK() {
                AppMethodBeat.m2504i(120750);
                C37019a eeH = eeH();
                AppMethodBeat.m2505o(120750);
                return eeH;
            }

            public final /* synthetic */ C0115a ecL() {
                AppMethodBeat.m2504i(120752);
                C37019a eeH = eeH();
                AppMethodBeat.m2505o(120752);
                return eeH;
            }

            private C37019a() {
                AppMethodBeat.m2504i(120741);
                AppMethodBeat.m2505o(120741);
            }

            public final C37018w eeI() {
                AppMethodBeat.m2504i(120743);
                C37018w c37018w = new C37018w((C25159a) this, (byte) 0);
                if ((this.BsD & 1) == 1) {
                    this.BuO = Collections.unmodifiableList(this.BuO);
                    this.BsD &= -2;
                }
                c37018w.BuO = this.BuO;
                AppMethodBeat.m2505o(120743);
                return c37018w;
            }

            /* renamed from: d */
            public final C37019a mo59033d(C37018w c37018w) {
                AppMethodBeat.m2504i(120744);
                if (c37018w == C37018w.eeF()) {
                    AppMethodBeat.m2505o(120744);
                } else {
                    if (!c37018w.BuO.isEmpty()) {
                        if (this.BuO.isEmpty()) {
                            this.BuO = c37018w.BuO;
                            this.BsD &= -2;
                        } else {
                            eeJ();
                            this.BuO.addAll(c37018w.BuO);
                        }
                    }
                    this.BsB = this.BsB.mo51672a(c37018w.BsB);
                    AppMethodBeat.m2505o(120744);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: p */
            private C37019a m61928p(C31713e c31713e, C31715g c31715g) {
                C37018w c37018w;
                Throwable th;
                AppMethodBeat.m2504i(120746);
                C37018w c37018w2 = null;
                try {
                    mo59033d((C37018w) C37018w.BsC.mo157a(c31713e, c31715g));
                    AppMethodBeat.m2505o(120746);
                    return this;
                } catch (C41425k e) {
                    C41425k c41425k = e;
                    c37018w = (C37018w) c41425k.BzY;
                    AppMethodBeat.m2505o(120746);
                    throw c41425k;
                } catch (Throwable th2) {
                    th = th2;
                    c37018w2 = c37018w;
                    if (c37018w2 != null) {
                    }
                    AppMethodBeat.m2505o(120746);
                    throw th;
                }
            }

            private void eeJ() {
                AppMethodBeat.m2504i(120747);
                if ((this.BsD & 1) != 1) {
                    this.BuO = new ArrayList(this.BuO);
                    this.BsD |= 1;
                }
                AppMethodBeat.m2505o(120747);
            }

            private C37019a eeH() {
                AppMethodBeat.m2504i(120742);
                C37019a d = new C37019a().mo59033d(eeI());
                AppMethodBeat.m2505o(120742);
                return d;
            }

            public final boolean isInitialized() {
                AppMethodBeat.m2504i(120745);
                int i = 0;
                while (i < this.BuO.size()) {
                    if (((C31227b) this.BuO.get(i)).isInitialized()) {
                        i++;
                    } else {
                        AppMethodBeat.m2505o(120745);
                        return false;
                    }
                }
                AppMethodBeat.m2505o(120745);
                return true;
            }

            public final /* synthetic */ C25155i ecJ() {
                AppMethodBeat.m2504i(120748);
                C37018w eeF = C37018w.eeF();
                AppMethodBeat.m2505o(120748);
                return eeF;
            }

            public final /* synthetic */ C8185q ecM() {
                AppMethodBeat.m2504i(120754);
                C37018w eeI = eeI();
                if (eeI.isInitialized()) {
                    AppMethodBeat.m2505o(120754);
                    return eeI;
                }
                C44904w c44904w = new C44904w();
                AppMethodBeat.m2505o(120754);
                throw c44904w;
            }

            public final /* synthetic */ C8185q ecE() {
                AppMethodBeat.m2504i(120755);
                C37018w eeF = C37018w.eeF();
                AppMethodBeat.m2505o(120755);
                return eeF;
            }

            static /* synthetic */ C37019a eeK() {
                AppMethodBeat.m2504i(120757);
                C37019a c37019a = new C37019a();
                AppMethodBeat.m2505o(120757);
                return c37019a;
            }
        }

        /* synthetic */ C37018w(C31713e c31713e, C31715g c31715g, byte b) {
            this(c31713e, c31715g);
        }

        public final /* synthetic */ C8186a ecC() {
            AppMethodBeat.m2504i(120792);
            C37019a eeG = eeG();
            AppMethodBeat.m2505o(120792);
            return eeG;
        }

        private C37018w(C25159a c25159a) {
            super((byte) 0);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = c25159a.BsB;
        }

        private C37018w() {
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BsB = C31710d.Bzq;
        }

        public static C37018w eeF() {
            return BuN;
        }

        private C37018w(C31713e c31713e, C31715g c31715g) {
            AppMethodBeat.m2504i(120785);
            this.BsG = (byte) -1;
            this.BsH = -1;
            this.BuO = Collections.emptyList();
            C31711b ehS = C31710d.ehS();
            C37024f e = C37024f.m61953e(ehS, 1);
            int i = 0;
            int i2 = 0;
            while (i == 0) {
                try {
                    int vc = c31713e.mo51692vc();
                    switch (vc) {
                        case 0:
                            i = 1;
                            break;
                        case 10:
                            if ((i2 & 1) != 1) {
                                this.BuO = new ArrayList();
                                i2 |= 1;
                            }
                            this.BuO.add(c31713e.mo51683a(C31227b.BsC, c31715g));
                            break;
                        default:
                            if (!mo42012a(c31713e, e, c31715g, vc)) {
                                i = 1;
                                break;
                            }
                            break;
                    }
                } catch (C41425k e2) {
                    e2.BzY = this;
                    AppMethodBeat.m2505o(120785);
                    throw e2;
                } catch (IOException e3) {
                    C41425k c41425k = new C41425k(e3.getMessage());
                    c41425k.BzY = this;
                    AppMethodBeat.m2505o(120785);
                    throw c41425k;
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
                        AppMethodBeat.m2505o(120785);
                    }
                    eio();
                    AppMethodBeat.m2505o(120785);
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
                AppMethodBeat.m2505o(120785);
            }
            eio();
            AppMethodBeat.m2505o(120785);
        }

        static {
            AppMethodBeat.m2504i(120794);
            C37018w c37018w = new C37018w();
            BuN = c37018w;
            c37018w.BuO = Collections.emptyList();
            AppMethodBeat.m2505o(120794);
        }

        public final C25163s<C37018w> ecy() {
            return BsC;
        }

        /* renamed from: Ty */
        public final C31227b mo59031Ty(int i) {
            AppMethodBeat.m2504i(120786);
            C31227b c31227b = (C31227b) this.BuO.get(i);
            AppMethodBeat.m2505o(120786);
            return c31227b;
        }

        public final boolean isInitialized() {
            AppMethodBeat.m2504i(120787);
            byte b = this.BsG;
            if (b == (byte) 1) {
                AppMethodBeat.m2505o(120787);
                return true;
            } else if (b == (byte) 0) {
                AppMethodBeat.m2505o(120787);
                return false;
            } else {
                int i = 0;
                while (i < this.BuO.size()) {
                    if (mo59031Ty(i).isInitialized()) {
                        i++;
                    } else {
                        this.BsG = (byte) 0;
                        AppMethodBeat.m2505o(120787);
                        return false;
                    }
                }
                this.BsG = (byte) 1;
                AppMethodBeat.m2505o(120787);
                return true;
            }
        }

        /* renamed from: a */
        public final void mo128a(C37024f c37024f) {
            AppMethodBeat.m2504i(120788);
            mo144vq();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.BuO.size()) {
                    c37024f.mo59046a(1, (C8185q) this.BuO.get(i2));
                    i = i2 + 1;
                } else {
                    c37024f.mo59056d(this.BsB);
                    AppMethodBeat.m2505o(120788);
                    return;
                }
            }
        }

        /* renamed from: vq */
        public final int mo144vq() {
            AppMethodBeat.m2504i(120789);
            int i = this.BsH;
            if (i != -1) {
                AppMethodBeat.m2505o(120789);
                return i;
            }
            int i2 = 0;
            for (i = 0; i < this.BuO.size(); i++) {
                i2 += C37024f.m61948c(1, (C8185q) this.BuO.get(i));
            }
            int size = this.BsB.size() + i2;
            this.BsH = size;
            AppMethodBeat.m2505o(120789);
            return size;
        }

        /* renamed from: a */
        public static C37019a m61921a(C37018w c37018w) {
            AppMethodBeat.m2504i(120790);
            C37019a d = C37019a.eeK().mo59033d(c37018w);
            AppMethodBeat.m2505o(120790);
            return d;
        }

        public final C37019a eeG() {
            AppMethodBeat.m2504i(120791);
            C37019a d = C37019a.eeK().mo59033d(this);
            AppMethodBeat.m2505o(120791);
            return d;
        }

        public final /* synthetic */ C8186a ecD() {
            AppMethodBeat.m2504i(120793);
            C37019a eeK = C37019a.eeK();
            AppMethodBeat.m2505o(120793);
            return eeK;
        }

        public final /* bridge */ /* synthetic */ C8185q ecE() {
            return BuN;
        }
    }
}
