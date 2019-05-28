package p000a.p010i.p011b.p012a.p015c.p045l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;

/* renamed from: a.i.b.a.c.l.l */
public final class C41455l extends C44922as {
    public static final C8244a BJl = new C8244a();
    private final C44922as BJj;
    private final C44922as BJk;

    /* renamed from: a.i.b.a.c.l.l$a */
    public static final class C8244a {
        private C8244a() {
        }

        public /* synthetic */ C8244a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(122524);
        AppMethodBeat.m2505o(122524);
    }

    private /* synthetic */ C41455l(C44922as c44922as, C44922as c44922as2, byte b) {
        this(c44922as, c44922as2);
    }

    private C41455l(C44922as c44922as, C44922as c44922as2) {
        this.BJj = c44922as;
        this.BJk = c44922as2;
    }

    /* renamed from: O */
    public final C41446ap mo31386O(C46867w c46867w) {
        AppMethodBeat.m2504i(122519);
        C25052j.m39376p(c46867w, "key");
        C41446ap O = this.BJj.mo31386O(c46867w);
        if (O == null) {
            O = this.BJk.mo31386O(c46867w);
        }
        AppMethodBeat.m2505o(122519);
        return O;
    }

    /* renamed from: a */
    public final C46867w mo31387a(C46867w c46867w, C0163ba c0163ba) {
        AppMethodBeat.m2504i(122520);
        C25052j.m39376p(c46867w, "topLevelType");
        C25052j.m39376p(c0163ba, "position");
        C46867w a = this.BJk.mo31387a(this.BJj.mo31387a(c46867w, c0163ba), c0163ba);
        AppMethodBeat.m2505o(122520);
        return a;
    }

    public final boolean isEmpty() {
        return false;
    }

    public final boolean eki() {
        AppMethodBeat.m2504i(122521);
        if (this.BJj.eki() || this.BJk.eki()) {
            AppMethodBeat.m2505o(122521);
            return true;
        }
        AppMethodBeat.m2505o(122521);
        return false;
    }

    public final boolean ejx() {
        AppMethodBeat.m2504i(122522);
        if (this.BJj.ejx() || this.BJk.ejx()) {
            AppMethodBeat.m2505o(122522);
            return true;
        }
        AppMethodBeat.m2505o(122522);
        return false;
    }

    /* renamed from: h */
    public final C0026g mo31389h(C0026g c0026g) {
        AppMethodBeat.m2504i(122523);
        C25052j.m39376p(c0026g, "annotations");
        C0026g h = this.BJk.mo31389h(this.BJj.mo31389h(c0026g));
        AppMethodBeat.m2505o(122523);
        return h;
    }

    /* renamed from: a */
    public static final C44922as m72330a(C44922as c44922as, C44922as c44922as2) {
        AppMethodBeat.m2504i(122525);
        C25052j.m39376p(c44922as, "first");
        C25052j.m39376p(c44922as2, "second");
        if (c44922as.isEmpty()) {
            AppMethodBeat.m2505o(122525);
            return c44922as2;
        } else if (c44922as2.isEmpty()) {
            AppMethodBeat.m2505o(122525);
            return c44922as;
        } else {
            C44922as c41455l = new C41455l(c44922as, c44922as2, (byte) 0);
            AppMethodBeat.m2505o(122525);
            return c41455l;
        }
    }
}
