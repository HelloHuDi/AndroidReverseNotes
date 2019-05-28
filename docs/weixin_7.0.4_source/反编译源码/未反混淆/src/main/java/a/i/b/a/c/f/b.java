package a.i.b.a.c.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public static final b ByP = new b("");
    public final c ByQ;
    private transient b ByR;

    static {
        AppMethodBeat.i(121372);
        AppMethodBeat.o(121372);
    }

    public b(String str) {
        AppMethodBeat.i(121363);
        this.ByQ = new c(str, this);
        AppMethodBeat.o(121363);
    }

    public b(c cVar) {
        this.ByQ = cVar;
    }

    private b(c cVar, b bVar) {
        this.ByQ = cVar;
        this.ByR = bVar;
    }

    public final boolean ehF() {
        AppMethodBeat.i(139062);
        boolean isEmpty = this.ByQ.ByV.isEmpty();
        AppMethodBeat.o(139062);
        return isEmpty;
    }

    public final b ehG() {
        AppMethodBeat.i(121365);
        b bVar;
        if (this.ByR != null) {
            bVar = this.ByR;
            AppMethodBeat.o(121365);
            return bVar;
        } else if (ehF()) {
            IllegalStateException illegalStateException = new IllegalStateException("root");
            AppMethodBeat.o(121365);
            throw illegalStateException;
        } else {
            this.ByR = new b(this.ByQ.ehJ());
            bVar = this.ByR;
            AppMethodBeat.o(121365);
            return bVar;
        }
    }

    public final b q(f fVar) {
        AppMethodBeat.i(121366);
        b bVar = new b(this.ByQ.t(fVar), this);
        AppMethodBeat.o(121366);
        return bVar;
    }

    public final boolean r(f fVar) {
        AppMethodBeat.i(121367);
        boolean r = this.ByQ.r(fVar);
        AppMethodBeat.o(121367);
        return r;
    }

    public static b s(f fVar) {
        AppMethodBeat.i(121368);
        b bVar = new b(c.u(fVar));
        AppMethodBeat.o(121368);
        return bVar;
    }

    public final String toString() {
        AppMethodBeat.i(121369);
        String cVar = this.ByQ.toString();
        AppMethodBeat.o(121369);
        return cVar;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(121370);
        if (this == obj) {
            AppMethodBeat.o(121370);
            return true;
        } else if (obj instanceof b) {
            if (this.ByQ.equals(((b) obj).ByQ)) {
                AppMethodBeat.o(121370);
                return true;
            }
            AppMethodBeat.o(121370);
            return false;
        } else {
            AppMethodBeat.o(121370);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(121371);
        int hashCode = this.ByQ.hashCode();
        AppMethodBeat.o(121371);
        return hashCode;
    }
}
