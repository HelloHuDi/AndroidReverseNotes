package p000a.p010i.p011b.p012a.p015c.p778f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import p000a.p001a.C36913i;
import p000a.p005f.p006a.C17126b;

/* renamed from: a.i.b.a.c.f.c */
public final class C8175c {
    private static final C37022f ByS = C37022f.avZ("<root>");
    private static final Pattern ByT = Pattern.compile("\\.");
    private static final C17126b<String, C37022f> ByU = new C81761();
    public final String ByV;
    private transient C8174b ByW;
    private transient C8175c ByX;
    private transient C37022f ByY;

    /* renamed from: a.i.b.a.c.f.c$1 */
    static class C81761 implements C17126b<String, C37022f> {
        C81761() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(121373);
            C37022f awa = C37022f.awa((String) obj);
            AppMethodBeat.m2505o(121373);
            return awa;
        }
    }

    static {
        AppMethodBeat.m2504i(121387);
        AppMethodBeat.m2505o(121387);
    }

    C8175c(String str, C8174b c8174b) {
        this.ByV = str;
        this.ByW = c8174b;
    }

    private C8175c(String str) {
        this.ByV = str;
    }

    private C8175c(String str, C8175c c8175c, C37022f c37022f) {
        this.ByV = str;
        this.ByX = c8175c;
        this.ByY = c37022f;
    }

    private void compute() {
        AppMethodBeat.m2504i(121374);
        int lastIndexOf = this.ByV.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            this.ByY = C37022f.awa(this.ByV.substring(lastIndexOf + 1));
            this.ByX = new C8175c(this.ByV.substring(0, lastIndexOf));
            AppMethodBeat.m2505o(121374);
            return;
        }
        this.ByY = C37022f.awa(this.ByV);
        this.ByX = C8174b.ByP.ByQ;
        AppMethodBeat.m2505o(121374);
    }

    public final boolean ehH() {
        AppMethodBeat.m2504i(121375);
        if (this.ByW != null || this.ByV.indexOf(60) < 0) {
            AppMethodBeat.m2505o(121375);
            return true;
        }
        AppMethodBeat.m2505o(121375);
        return false;
    }

    public final C8174b ehI() {
        AppMethodBeat.m2504i(121376);
        C8174b c8174b;
        if (this.ByW != null) {
            c8174b = this.ByW;
            AppMethodBeat.m2505o(121376);
            return c8174b;
        }
        this.ByW = new C8174b(this);
        c8174b = this.ByW;
        AppMethodBeat.m2505o(121376);
        return c8174b;
    }

    public final C8175c ehJ() {
        AppMethodBeat.m2504i(121377);
        C8175c c8175c;
        if (this.ByX != null) {
            c8175c = this.ByX;
            AppMethodBeat.m2505o(121377);
            return c8175c;
        } else if (this.ByV.isEmpty()) {
            IllegalStateException illegalStateException = new IllegalStateException("root");
            AppMethodBeat.m2505o(121377);
            throw illegalStateException;
        } else {
            compute();
            c8175c = this.ByX;
            AppMethodBeat.m2505o(121377);
            return c8175c;
        }
    }

    public final C37022f ehK() {
        AppMethodBeat.m2504i(121379);
        C37022f c37022f;
        if (this.ByY != null) {
            c37022f = this.ByY;
            AppMethodBeat.m2505o(121379);
            return c37022f;
        } else if (this.ByV.isEmpty()) {
            IllegalStateException illegalStateException = new IllegalStateException("root");
            AppMethodBeat.m2505o(121379);
            throw illegalStateException;
        } else {
            compute();
            c37022f = this.ByY;
            AppMethodBeat.m2505o(121379);
            return c37022f;
        }
    }

    /* renamed from: r */
    public final boolean mo17987r(C37022f c37022f) {
        AppMethodBeat.m2504i(121382);
        int indexOf = this.ByV.indexOf(46);
        if (!this.ByV.isEmpty()) {
            String str = this.ByV;
            String str2 = c37022f.name;
            if (indexOf == -1) {
                indexOf = this.ByV.length();
            }
            if (str.regionMatches(0, str2, 0, indexOf)) {
                AppMethodBeat.m2505o(121382);
                return true;
            }
        }
        AppMethodBeat.m2505o(121382);
        return false;
    }

    /* renamed from: u */
    public static C8175c m14433u(C37022f c37022f) {
        AppMethodBeat.m2504i(121383);
        C8175c c8175c = new C8175c(c37022f.name, C8174b.ByP.ByQ, c37022f);
        AppMethodBeat.m2505o(121383);
        return c8175c;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(121385);
        if (this == obj) {
            AppMethodBeat.m2505o(121385);
            return true;
        } else if (obj instanceof C8175c) {
            if (this.ByV.equals(((C8175c) obj).ByV)) {
                AppMethodBeat.m2505o(121385);
                return true;
            }
            AppMethodBeat.m2505o(121385);
            return false;
        } else {
            AppMethodBeat.m2505o(121385);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(121386);
        int hashCode = this.ByV.hashCode();
        AppMethodBeat.m2505o(121386);
        return hashCode;
    }

    /* renamed from: t */
    public final C8175c mo17988t(C37022f c37022f) {
        String str;
        AppMethodBeat.m2504i(121378);
        if (this.ByV.isEmpty()) {
            str = c37022f.name;
        } else {
            str = this.ByV + "." + c37022f.name;
        }
        C8175c c8175c = new C8175c(str, this, c37022f);
        AppMethodBeat.m2505o(121378);
        return c8175c;
    }

    public final C37022f ehL() {
        AppMethodBeat.m2504i(121380);
        C37022f c37022f;
        if (this.ByV.isEmpty()) {
            c37022f = ByS;
            AppMethodBeat.m2505o(121380);
            return c37022f;
        }
        c37022f = ehK();
        AppMethodBeat.m2505o(121380);
        return c37022f;
    }

    public final List<C37022f> ehM() {
        AppMethodBeat.m2504i(121381);
        if (this.ByV.isEmpty()) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.m2505o(121381);
            return emptyList;
        }
        List<C37022f> a = C36913i.m61692a((Object[]) ByT.split(this.ByV), ByU);
        AppMethodBeat.m2505o(121381);
        return a;
    }

    public final String toString() {
        AppMethodBeat.m2504i(121384);
        String str;
        if (this.ByV.isEmpty()) {
            str = ByS.name;
            AppMethodBeat.m2505o(121384);
            return str;
        }
        str = this.ByV;
        AppMethodBeat.m2505o(121384);
        return str;
    }
}
