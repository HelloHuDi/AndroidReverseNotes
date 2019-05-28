package a.i.b.a.c.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

public final class f implements Comparable<f> {
    public final boolean ByZ;
    public final String name;

    public final /* synthetic */ int compareTo(Object obj) {
        AppMethodBeat.i(121399);
        int v = v((f) obj);
        AppMethodBeat.o(121399);
        return v;
    }

    private f(String str, boolean z) {
        this.name = str;
        this.ByZ = z;
    }

    public final String ehN() {
        AppMethodBeat.i(121391);
        if (this.ByZ) {
            IllegalStateException illegalStateException = new IllegalStateException("not identifier: ".concat(String.valueOf(this)));
            AppMethodBeat.o(121391);
            throw illegalStateException;
        }
        String str = this.name;
        AppMethodBeat.o(121391);
        return str;
    }

    public final int v(f fVar) {
        AppMethodBeat.i(121392);
        int compareTo = this.name.compareTo(fVar.name);
        AppMethodBeat.o(121392);
        return compareTo;
    }

    public static f avX(String str) {
        AppMethodBeat.i(121393);
        f fVar = new f(str, false);
        AppMethodBeat.o(121393);
        return fVar;
    }

    public static boolean avY(String str) {
        AppMethodBeat.i(121394);
        if (str.isEmpty() || str.startsWith("<")) {
            AppMethodBeat.o(121394);
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '.' || charAt == IOUtils.DIR_SEPARATOR_UNIX || charAt == IOUtils.DIR_SEPARATOR_WINDOWS) {
                AppMethodBeat.o(121394);
                return false;
            }
        }
        AppMethodBeat.o(121394);
        return true;
    }

    public static f avZ(String str) {
        AppMethodBeat.i(121395);
        if (str.startsWith("<")) {
            f fVar = new f(str, true);
            AppMethodBeat.o(121395);
            return fVar;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("special name must start with '<': ".concat(String.valueOf(str)));
        AppMethodBeat.o(121395);
        throw illegalArgumentException;
    }

    public static f awa(String str) {
        AppMethodBeat.i(121396);
        f avZ;
        if (str.startsWith("<")) {
            avZ = avZ(str);
            AppMethodBeat.o(121396);
            return avZ;
        }
        avZ = avX(str);
        AppMethodBeat.o(121396);
        return avZ;
    }

    public final String toString() {
        return this.name;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(121397);
        if (this == obj) {
            AppMethodBeat.o(121397);
            return true;
        } else if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.ByZ != fVar.ByZ) {
                AppMethodBeat.o(121397);
                return false;
            } else if (this.name.equals(fVar.name)) {
                AppMethodBeat.o(121397);
                return true;
            } else {
                AppMethodBeat.o(121397);
                return false;
            }
        } else {
            AppMethodBeat.o(121397);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(121398);
        int hashCode = (this.ByZ ? 1 : 0) + (this.name.hashCode() * 31);
        AppMethodBeat.o(121398);
        return hashCode;
    }
}
