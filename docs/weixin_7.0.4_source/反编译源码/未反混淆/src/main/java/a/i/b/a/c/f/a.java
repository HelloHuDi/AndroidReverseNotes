package a.i.b.a.c.f;

import a.k.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

public final class a {
    static final /* synthetic */ boolean $assertionsDisabled = (!a.class.desiredAssertionStatus());
    public final b BcW;
    public final b ByN;
    public final boolean ByO;

    static {
        AppMethodBeat.i(121362);
        AppMethodBeat.o(121362);
    }

    public static a n(b bVar) {
        AppMethodBeat.i(121348);
        a aVar = new a(bVar.ehG(), bVar.ByQ.ehK());
        AppMethodBeat.o(121348);
        return aVar;
    }

    public a(b bVar, b bVar2, boolean z) {
        AppMethodBeat.i(121349);
        this.BcW = bVar;
        if ($assertionsDisabled || !bVar2.ByQ.ByV.isEmpty()) {
            this.ByN = bVar2;
            this.ByO = z;
            AppMethodBeat.o(121349);
            return;
        }
        AssertionError assertionError = new AssertionError("Class name must not be root: " + bVar + (z ? " (local)" : ""));
        AppMethodBeat.o(121349);
        throw assertionError;
    }

    public a(b bVar, f fVar) {
        this(bVar, b.s(fVar), false);
        AppMethodBeat.i(121350);
        AppMethodBeat.o(121350);
    }

    public final f ehB() {
        AppMethodBeat.i(139061);
        f ehK = this.ByN.ByQ.ehK();
        AppMethodBeat.o(139061);
        return ehK;
    }

    public final a p(f fVar) {
        AppMethodBeat.i(121352);
        a aVar = new a(this.BcW, this.ByN.q(fVar), this.ByO);
        AppMethodBeat.o(121352);
        return aVar;
    }

    public final a ehC() {
        AppMethodBeat.i(121353);
        b ehG = this.ByN.ehG();
        if (ehG.ByQ.ByV.isEmpty()) {
            AppMethodBeat.o(121353);
            return null;
        }
        a aVar = new a(this.BcW, ehG, this.ByO);
        AppMethodBeat.o(121353);
        return aVar;
    }

    public final boolean ehD() {
        AppMethodBeat.i(121354);
        if (this.ByN.ehG().ByQ.ByV.isEmpty()) {
            AppMethodBeat.o(121354);
            return false;
        }
        AppMethodBeat.o(121354);
        return true;
    }

    public final b ehE() {
        AppMethodBeat.i(121355);
        b bVar;
        if (this.BcW.ByQ.ByV.isEmpty()) {
            bVar = this.ByN;
            AppMethodBeat.o(121355);
            return bVar;
        }
        bVar = new b(this.BcW.ByQ.ByV + "." + this.ByN.ByQ.ByV);
        AppMethodBeat.o(121355);
        return bVar;
    }

    public static a avW(String str) {
        AppMethodBeat.i(121356);
        a cv = cv(str, false);
        AppMethodBeat.o(121356);
        return cv;
    }

    public static a cv(String str, boolean z) {
        AppMethodBeat.i(121357);
        a aVar = new a(new b(v.jg(str, "").replace(IOUtils.DIR_SEPARATOR_UNIX, '.')), new b(v.a(str, (char) IOUtils.DIR_SEPARATOR_UNIX, str)), z);
        AppMethodBeat.o(121357);
        return aVar;
    }

    public final String pq() {
        AppMethodBeat.i(121358);
        String str;
        if (this.BcW.ByQ.ByV.isEmpty()) {
            str = this.ByN.ByQ.ByV;
            AppMethodBeat.o(121358);
            return str;
        }
        str = this.BcW.ByQ.ByV.replace('.', IOUtils.DIR_SEPARATOR_UNIX) + "/" + this.ByN.ByQ.ByV;
        AppMethodBeat.o(121358);
        return str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(121359);
        if (this == obj) {
            AppMethodBeat.o(121359);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(121359);
            return false;
        } else {
            a aVar = (a) obj;
            if (this.BcW.equals(aVar.BcW) && this.ByN.equals(aVar.ByN) && this.ByO == aVar.ByO) {
                AppMethodBeat.o(121359);
                return true;
            }
            AppMethodBeat.o(121359);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(121360);
        int hashCode = (((this.BcW.hashCode() * 31) + this.ByN.hashCode()) * 31) + Boolean.valueOf(this.ByO).hashCode();
        AppMethodBeat.o(121360);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(121361);
        String str;
        if (this.BcW.ByQ.ByV.isEmpty()) {
            str = "/" + pq();
            AppMethodBeat.o(121361);
            return str;
        }
        str = pq();
        AppMethodBeat.o(121361);
        return str;
    }
}
