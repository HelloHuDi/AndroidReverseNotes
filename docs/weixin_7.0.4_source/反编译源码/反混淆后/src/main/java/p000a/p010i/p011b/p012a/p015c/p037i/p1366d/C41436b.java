package p000a.p010i.p011b.p012a.p015c.p037i.p1366d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.i.d.b */
public final class C41436b {
    private C8174b BfP;
    public final String BrD;

    public static C41436b awj(String str) {
        AppMethodBeat.m2504i(122156);
        C41436b c41436b = new C41436b(str);
        AppMethodBeat.m2505o(122156);
        return c41436b;
    }

    /* renamed from: o */
    public static C41436b m72291o(C8174b c8174b) {
        AppMethodBeat.m2504i(122158);
        C41436b c41436b = new C41436b(c8174b.ByQ.ByV.replace('.', IOUtils.DIR_SEPARATOR_UNIX));
        c41436b.BfP = c8174b;
        AppMethodBeat.m2505o(122158);
        return c41436b;
    }

    private C41436b(String str) {
        this.BrD = str;
    }

    public final C8174b ejz() {
        AppMethodBeat.m2504i(122159);
        int lastIndexOf = this.BrD.lastIndexOf("/");
        C8174b c8174b;
        if (lastIndexOf == -1) {
            c8174b = C8174b.ByP;
            AppMethodBeat.m2505o(122159);
            return c8174b;
        }
        c8174b = new C8174b(this.BrD.substring(0, lastIndexOf).replace(IOUtils.DIR_SEPARATOR_UNIX, '.'));
        AppMethodBeat.m2505o(122159);
        return c8174b;
    }

    public final String toString() {
        return this.BrD;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(122160);
        if (this == obj) {
            AppMethodBeat.m2505o(122160);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(122160);
            return false;
        } else {
            boolean equals = this.BrD.equals(((C41436b) obj).BrD);
            AppMethodBeat.m2505o(122160);
            return equals;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(122161);
        int hashCode = this.BrD.hashCode();
        AppMethodBeat.m2505o(122161);
        return hashCode;
    }

    /* renamed from: h */
    public static C41436b m72290h(C8173a c8173a) {
        AppMethodBeat.m2504i(122157);
        C8174b c8174b = c8173a.BcW;
        String replace = c8173a.ByN.ByQ.ByV.replace('.', '$');
        C41436b c41436b;
        if (c8174b.ehF()) {
            c41436b = new C41436b(replace);
            AppMethodBeat.m2505o(122157);
            return c41436b;
        }
        c41436b = new C41436b(c8174b.ByQ.ByV.replace('.', IOUtils.DIR_SEPARATOR_UNIX) + "/" + replace);
        AppMethodBeat.m2505o(122157);
        return c41436b;
    }
}
