package p000a.p010i.p011b.p012a.p015c.p778f;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: a.i.b.a.c.f.b */
public final class C8174b {
    public static final C8174b ByP = new C8174b("");
    public final C8175c ByQ;
    private transient C8174b ByR;

    static {
        AppMethodBeat.m2504i(121372);
        AppMethodBeat.m2505o(121372);
    }

    public C8174b(String str) {
        AppMethodBeat.m2504i(121363);
        this.ByQ = new C8175c(str, this);
        AppMethodBeat.m2505o(121363);
    }

    public C8174b(C8175c c8175c) {
        this.ByQ = c8175c;
    }

    private C8174b(C8175c c8175c, C8174b c8174b) {
        this.ByQ = c8175c;
        this.ByR = c8174b;
    }

    public final boolean ehF() {
        AppMethodBeat.m2504i(139062);
        boolean isEmpty = this.ByQ.ByV.isEmpty();
        AppMethodBeat.m2505o(139062);
        return isEmpty;
    }

    public final C8174b ehG() {
        AppMethodBeat.m2504i(121365);
        C8174b c8174b;
        if (this.ByR != null) {
            c8174b = this.ByR;
            AppMethodBeat.m2505o(121365);
            return c8174b;
        } else if (ehF()) {
            IllegalStateException illegalStateException = new IllegalStateException("root");
            AppMethodBeat.m2505o(121365);
            throw illegalStateException;
        } else {
            this.ByR = new C8174b(this.ByQ.ehJ());
            c8174b = this.ByR;
            AppMethodBeat.m2505o(121365);
            return c8174b;
        }
    }

    /* renamed from: q */
    public final C8174b mo17976q(C37022f c37022f) {
        AppMethodBeat.m2504i(121366);
        C8174b c8174b = new C8174b(this.ByQ.mo17988t(c37022f), this);
        AppMethodBeat.m2505o(121366);
        return c8174b;
    }

    /* renamed from: r */
    public final boolean mo17977r(C37022f c37022f) {
        AppMethodBeat.m2504i(121367);
        boolean r = this.ByQ.mo17987r(c37022f);
        AppMethodBeat.m2505o(121367);
        return r;
    }

    /* renamed from: s */
    public static C8174b m14430s(C37022f c37022f) {
        AppMethodBeat.m2504i(121368);
        C8174b c8174b = new C8174b(C8175c.m14433u(c37022f));
        AppMethodBeat.m2505o(121368);
        return c8174b;
    }

    public final String toString() {
        AppMethodBeat.m2504i(121369);
        String c8175c = this.ByQ.toString();
        AppMethodBeat.m2505o(121369);
        return c8175c;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(121370);
        if (this == obj) {
            AppMethodBeat.m2505o(121370);
            return true;
        } else if (obj instanceof C8174b) {
            if (this.ByQ.equals(((C8174b) obj).ByQ)) {
                AppMethodBeat.m2505o(121370);
                return true;
            }
            AppMethodBeat.m2505o(121370);
            return false;
        } else {
            AppMethodBeat.m2505o(121370);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(121371);
        int hashCode = this.ByQ.hashCode();
        AppMethodBeat.m2505o(121371);
        return hashCode;
    }
}
