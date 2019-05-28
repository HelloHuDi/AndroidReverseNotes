package p000a.p010i.p011b.p012a.p015c.p778f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: a.i.b.a.c.f.f */
public final class C37022f implements Comparable<C37022f> {
    public final boolean ByZ;
    public final String name;

    public final /* synthetic */ int compareTo(Object obj) {
        AppMethodBeat.m2504i(121399);
        int v = mo59040v((C37022f) obj);
        AppMethodBeat.m2505o(121399);
        return v;
    }

    private C37022f(String str, boolean z) {
        this.name = str;
        this.ByZ = z;
    }

    public final String ehN() {
        AppMethodBeat.m2504i(121391);
        if (this.ByZ) {
            IllegalStateException illegalStateException = new IllegalStateException("not identifier: ".concat(String.valueOf(this)));
            AppMethodBeat.m2505o(121391);
            throw illegalStateException;
        }
        String str = this.name;
        AppMethodBeat.m2505o(121391);
        return str;
    }

    /* renamed from: v */
    public final int mo59040v(C37022f c37022f) {
        AppMethodBeat.m2504i(121392);
        int compareTo = this.name.compareTo(c37022f.name);
        AppMethodBeat.m2505o(121392);
        return compareTo;
    }

    public static C37022f avX(String str) {
        AppMethodBeat.m2504i(121393);
        C37022f c37022f = new C37022f(str, false);
        AppMethodBeat.m2505o(121393);
        return c37022f;
    }

    public static boolean avY(String str) {
        AppMethodBeat.m2504i(121394);
        if (str.isEmpty() || str.startsWith("<")) {
            AppMethodBeat.m2505o(121394);
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '.' || charAt == IOUtils.DIR_SEPARATOR_UNIX || charAt == IOUtils.DIR_SEPARATOR_WINDOWS) {
                AppMethodBeat.m2505o(121394);
                return false;
            }
        }
        AppMethodBeat.m2505o(121394);
        return true;
    }

    public static C37022f avZ(String str) {
        AppMethodBeat.m2504i(121395);
        if (str.startsWith("<")) {
            C37022f c37022f = new C37022f(str, true);
            AppMethodBeat.m2505o(121395);
            return c37022f;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("special name must start with '<': ".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(121395);
        throw illegalArgumentException;
    }

    public static C37022f awa(String str) {
        AppMethodBeat.m2504i(121396);
        C37022f avZ;
        if (str.startsWith("<")) {
            avZ = C37022f.avZ(str);
            AppMethodBeat.m2505o(121396);
            return avZ;
        }
        avZ = C37022f.avX(str);
        AppMethodBeat.m2505o(121396);
        return avZ;
    }

    public final String toString() {
        return this.name;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(121397);
        if (this == obj) {
            AppMethodBeat.m2505o(121397);
            return true;
        } else if (obj instanceof C37022f) {
            C37022f c37022f = (C37022f) obj;
            if (this.ByZ != c37022f.ByZ) {
                AppMethodBeat.m2505o(121397);
                return false;
            } else if (this.name.equals(c37022f.name)) {
                AppMethodBeat.m2505o(121397);
                return true;
            } else {
                AppMethodBeat.m2505o(121397);
                return false;
            }
        } else {
            AppMethodBeat.m2505o(121397);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(121398);
        int hashCode = (this.ByZ ? 1 : 0) + (this.name.hashCode() * 31);
        AppMethodBeat.m2505o(121398);
        return hashCode;
    }
}
