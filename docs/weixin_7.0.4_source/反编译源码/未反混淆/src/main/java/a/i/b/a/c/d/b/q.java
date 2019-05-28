package a.i.b.a.c.d.b;

import a.f.b.j;
import a.i.b.a.c.e.a.c;
import a.i.b.a.c.e.b.a.f;
import a.i.b.a.c.e.b.a.f.b;
import a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q {
    public static final a BrI = new a();
    final String signature;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static q iT(String str, String str2) {
            AppMethodBeat.i(120292);
            j.p(str, "name");
            j.p(str2, "desc");
            q qVar = new q(str + str2, (byte) 0);
            AppMethodBeat.o(120292);
            return qVar;
        }

        public static q iU(String str, String str2) {
            AppMethodBeat.i(120293);
            j.p(str, "name");
            j.p(str2, "desc");
            q qVar = new q(str + "#" + str2, (byte) 0);
            AppMethodBeat.o(120293);
            return qVar;
        }

        public static q a(f fVar) {
            AppMethodBeat.i(120294);
            j.p(fVar, "signature");
            q iT;
            if (fVar instanceof b) {
                iT = iT(fVar.getName(), fVar.ehx());
                AppMethodBeat.o(120294);
                return iT;
            } else if (fVar instanceof a.i.b.a.c.e.b.a.f.a) {
                iT = iU(fVar.getName(), fVar.ehx());
                AppMethodBeat.o(120294);
                return iT;
            } else {
                m mVar = new m();
                AppMethodBeat.o(120294);
                throw mVar;
            }
        }

        public static q a(q qVar, int i) {
            AppMethodBeat.i(120295);
            j.p(qVar, "signature");
            q qVar2 = new q(qVar.signature + "@" + i, (byte) 0);
            AppMethodBeat.o(120295);
            return qVar2;
        }

        public static q a(c cVar, a.i.b.a.c.e.b.b.c cVar2) {
            AppMethodBeat.i(120291);
            j.p(cVar, "nameResolver");
            j.p(cVar2, "signature");
            q iT = iT(cVar.getString(cVar2.Buf), cVar.getString(cVar2.BxN));
            AppMethodBeat.o(120291);
            return iT;
        }
    }

    static {
        AppMethodBeat.i(120296);
        AppMethodBeat.o(120296);
    }

    /* JADX WARNING: Missing block: B:5:0x0016, code skipped:
            if (a.f.b.j.j(r3.signature, ((a.i.b.a.c.d.b.q) r4).signature) != false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.i(120299);
        if (this != obj) {
            if (obj instanceof q) {
            }
            AppMethodBeat.o(120299);
            return false;
        }
        AppMethodBeat.o(120299);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(120298);
        String str = this.signature;
        if (str != null) {
            int hashCode = str.hashCode();
            AppMethodBeat.o(120298);
            return hashCode;
        }
        AppMethodBeat.o(120298);
        return 0;
    }

    public final String toString() {
        AppMethodBeat.i(120297);
        String str = "MemberSignature(signature=" + this.signature + ")";
        AppMethodBeat.o(120297);
        return str;
    }

    private q(String str) {
        this.signature = str;
    }

    public /* synthetic */ q(String str, byte b) {
        this(str);
    }
}
