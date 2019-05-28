package p000a.p010i.p011b.p012a.p015c.p023d.p031b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Set;
import p000a.C31826o;
import p000a.p001a.C17115v;
import p000a.p001a.C25031ak;
import p000a.p001a.C7986al;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p018b.C36953ab;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.p032a.C8134a;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.p032a.C8134a.C8132a;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C37000c;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C6143s;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a.C41421g;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a.C41422h;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a.C41424j;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C31698a;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C31702c;
import p000a.p010i.p011b.p012a.p015c.p035g.C41425k;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C0144o;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C44914e;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C8225i;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.p043a.C44640e;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.p043a.C44912h;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.d.b.e */
public final class C0073e {
    private static final Set<C8132a> Brm = C25031ak.setOf(C8132a.CLASS);
    private static final Set<C8132a> Brn = C7986al.setOf(C8132a.FILE_FACADE, C8132a.MULTIFILE_CLASS_PART);
    private static final C41421g Bro = new C41421g(1, 1, 2);
    private static final C41421g Brp = new C41421g(1, 1, 11);
    private static final C41421g Brq = new C41421g(1, 1, 13);
    public static final C0075a Brr = new C0075a();
    public C8225i Brl;

    /* renamed from: a.i.b.a.c.d.b.e$b */
    static final class C0074b extends C25053k implements C31214a<List<? extends C37022f>> {
        public static final C0074b Brs = new C0074b();

        static {
            AppMethodBeat.m2504i(120251);
            AppMethodBeat.m2505o(120251);
        }

        C0074b() {
            super(0);
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            return C17115v.AUP;
        }
    }

    /* renamed from: a.i.b.a.c.d.b.e$a */
    public static final class C0075a {
        private C0075a() {
        }

        public /* synthetic */ C0075a(byte b) {
            this();
        }
    }

    public final C8225i ecp() {
        AppMethodBeat.m2504i(120252);
        C8225i c8225i = this.Brl;
        if (c8225i == null) {
            C25052j.avw("components");
        }
        AppMethodBeat.m2505o(120252);
        return c8225i;
    }

    private final boolean ecq() {
        AppMethodBeat.m2504i(120253);
        if (this.Brl == null) {
            C25052j.avw("components");
        }
        AppMethodBeat.m2505o(120253);
        return false;
    }

    /* renamed from: a */
    public final C44914e mo122a(C8143n c8143n) {
        AppMethodBeat.m2504i(120254);
        C25052j.m39376p(c8143n, "kotlinClass");
        String[] a = C0073e.m85a(c8143n, Brm);
        if (a == null) {
            AppMethodBeat.m2505o(120254);
            return null;
        }
        String[] strArr = c8143n.dXA().strings;
        if (strArr == null) {
            AppMethodBeat.m2505o(120254);
            return null;
        }
        C31826o d;
        try {
            d = C41424j.m72247d(a, strArr);
        } catch (C41425k e) {
            Throwable illegalStateException = new IllegalStateException("Could not read data from " + c8143n.getLocation(), e);
            AppMethodBeat.m2505o(120254);
            throw illegalStateException;
        } catch (Throwable th) {
            ecq();
            if (c8143n.dXA().Bsd.ehy()) {
                AppMethodBeat.m2505o(120254);
            } else {
                d = null;
            }
        }
        if (d == null) {
            AppMethodBeat.m2505o(120254);
            return null;
        }
        C41422h c41422h = (C41422h) d.first;
        C44914e c44914e = new C44914e(c41422h, (C37000c) d.second, c8143n.dXA().Bsd, new C8148p(c8143n, m86b(c8143n), m87c(c8143n)));
        AppMethodBeat.m2505o(120254);
        return c44914e;
    }

    /* renamed from: a */
    public final C31746h mo121a(C36953ab c36953ab, C8143n c8143n) {
        AppMethodBeat.m2504i(120255);
        C25052j.m39376p(c36953ab, "descriptor");
        C25052j.m39376p(c8143n, "kotlinClass");
        String[] a = C0073e.m85a(c8143n, Brn);
        if (a == null) {
            AppMethodBeat.m2505o(120255);
            return null;
        }
        String[] strArr = c8143n.dXA().strings;
        if (strArr == null) {
            AppMethodBeat.m2505o(120255);
            return null;
        }
        C31826o e;
        try {
            e = C41424j.m72248e(a, strArr);
        } catch (C41425k e2) {
            Throwable illegalStateException = new IllegalStateException("Could not read data from " + c8143n.getLocation(), e2);
            AppMethodBeat.m2505o(120255);
            throw illegalStateException;
        } catch (Throwable th) {
            ecq();
            if (c8143n.dXA().Bsd.ehy()) {
                AppMethodBeat.m2505o(120255);
            } else {
                e = null;
            }
        }
        if (e == null) {
            AppMethodBeat.m2505o(120255);
            return null;
        }
        C41422h c41422h = (C41422h) e.first;
        C6143s c6143s = (C6143s) e.second;
        C31702c c31702c = c41422h;
        C31698a c31698a = c8143n.dXA().Bsd;
        C44640e c31679i = new C31679i(c8143n, c6143s, c41422h, m86b(c8143n), m87c(c8143n));
        C8225i c8225i = this.Brl;
        if (c8225i == null) {
            C25052j.avw("components");
        }
        C31746h c44912h = new C44912h(c36953ab, c6143s, c31702c, c31698a, c31679i, c8225i, C0074b.Brs);
        AppMethodBeat.m2505o(120255);
        return c44912h;
    }

    /* renamed from: b */
    private final C0144o<C41421g> m86b(C8143n c8143n) {
        AppMethodBeat.m2504i(120256);
        ecq();
        if (c8143n.dXA().Bsd.ehy()) {
            AppMethodBeat.m2505o(120256);
            return null;
        }
        C0144o<C41421g> c0144o = new C0144o(c8143n.dXA().Bsd, C41421g.Byu, c8143n.getLocation(), c8143n.dWY());
        AppMethodBeat.m2505o(120256);
        return c0144o;
    }

    /* renamed from: c */
    private final boolean m87c(C8143n c8143n) {
        AppMethodBeat.m2504i(120257);
        if (this.Brl == null) {
            C25052j.avw("components");
        }
        if (m88d(c8143n)) {
            AppMethodBeat.m2505o(120257);
            return true;
        }
        AppMethodBeat.m2505o(120257);
        return false;
    }

    /* renamed from: d */
    private final boolean m88d(C8143n c8143n) {
        AppMethodBeat.m2504i(120258);
        if (this.Brl == null) {
            C25052j.avw("components");
        }
        if (c8143n.dXA().ecw() && C25052j.m39373j(c8143n.dXA().Bsd, Brp)) {
            AppMethodBeat.m2505o(120258);
            return true;
        }
        AppMethodBeat.m2505o(120258);
        return false;
    }

    /* renamed from: a */
    private static String[] m85a(C8143n c8143n, Set<? extends C8132a> set) {
        AppMethodBeat.m2504i(120259);
        C25052j.m39376p(c8143n, "kotlinClass");
        C25052j.m39376p(set, "expectedKinds");
        C8134a dXA = c8143n.dXA();
        String[] strArr = dXA.Bsf;
        if (strArr == null) {
            strArr = dXA.Bsg;
        }
        if (strArr == null) {
            AppMethodBeat.m2505o(120259);
            return null;
        } else if (set.contains(dXA.Bsc)) {
            AppMethodBeat.m2505o(120259);
            return strArr;
        } else {
            AppMethodBeat.m2505o(120259);
            return null;
        }
    }

    static {
        AppMethodBeat.m2504i(120260);
        AppMethodBeat.m2505o(120260);
    }
}
