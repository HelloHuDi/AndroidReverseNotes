package a.i.b.a.c.l.d;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a<T> {
    final T BLm;
    public final T BLn;

    /* JADX WARNING: Missing block: B:7:0x0020, code skipped:
            if (a.f.b.j.j(r3.BLn, r4.BLn) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.i(122829);
        if (this != obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (j.j(this.BLm, aVar.BLm)) {
                }
            }
            AppMethodBeat.o(122829);
            return false;
        }
        AppMethodBeat.o(122829);
        return true;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(122828);
        Object obj = this.BLm;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Object obj2 = this.BLn;
        if (obj2 != null) {
            i = obj2.hashCode();
        }
        hashCode += i;
        AppMethodBeat.o(122828);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(122827);
        String str = "ApproximationBounds(lower=" + this.BLm + ", upper=" + this.BLn + ")";
        AppMethodBeat.o(122827);
        return str;
    }

    public a(T t, T t2) {
        this.BLm = t;
        this.BLn = t2;
    }
}
