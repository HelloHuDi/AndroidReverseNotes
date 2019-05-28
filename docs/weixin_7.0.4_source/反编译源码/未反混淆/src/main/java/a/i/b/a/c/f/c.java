package a.i.b.a.c.f;

import a.a.i;
import a.f.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public final class c {
    private static final f ByS = f.avZ("<root>");
    private static final Pattern ByT = Pattern.compile("\\.");
    private static final b<String, f> ByU = new b<String, f>() {
        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(121373);
            f awa = f.awa((String) obj);
            AppMethodBeat.o(121373);
            return awa;
        }
    };
    public final String ByV;
    private transient b ByW;
    private transient c ByX;
    private transient f ByY;

    static {
        AppMethodBeat.i(121387);
        AppMethodBeat.o(121387);
    }

    c(String str, b bVar) {
        this.ByV = str;
        this.ByW = bVar;
    }

    private c(String str) {
        this.ByV = str;
    }

    private c(String str, c cVar, f fVar) {
        this.ByV = str;
        this.ByX = cVar;
        this.ByY = fVar;
    }

    private void compute() {
        AppMethodBeat.i(121374);
        int lastIndexOf = this.ByV.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            this.ByY = f.awa(this.ByV.substring(lastIndexOf + 1));
            this.ByX = new c(this.ByV.substring(0, lastIndexOf));
            AppMethodBeat.o(121374);
            return;
        }
        this.ByY = f.awa(this.ByV);
        this.ByX = b.ByP.ByQ;
        AppMethodBeat.o(121374);
    }

    public final boolean ehH() {
        AppMethodBeat.i(121375);
        if (this.ByW != null || this.ByV.indexOf(60) < 0) {
            AppMethodBeat.o(121375);
            return true;
        }
        AppMethodBeat.o(121375);
        return false;
    }

    public final b ehI() {
        AppMethodBeat.i(121376);
        b bVar;
        if (this.ByW != null) {
            bVar = this.ByW;
            AppMethodBeat.o(121376);
            return bVar;
        }
        this.ByW = new b(this);
        bVar = this.ByW;
        AppMethodBeat.o(121376);
        return bVar;
    }

    public final c ehJ() {
        AppMethodBeat.i(121377);
        c cVar;
        if (this.ByX != null) {
            cVar = this.ByX;
            AppMethodBeat.o(121377);
            return cVar;
        } else if (this.ByV.isEmpty()) {
            IllegalStateException illegalStateException = new IllegalStateException("root");
            AppMethodBeat.o(121377);
            throw illegalStateException;
        } else {
            compute();
            cVar = this.ByX;
            AppMethodBeat.o(121377);
            return cVar;
        }
    }

    public final f ehK() {
        AppMethodBeat.i(121379);
        f fVar;
        if (this.ByY != null) {
            fVar = this.ByY;
            AppMethodBeat.o(121379);
            return fVar;
        } else if (this.ByV.isEmpty()) {
            IllegalStateException illegalStateException = new IllegalStateException("root");
            AppMethodBeat.o(121379);
            throw illegalStateException;
        } else {
            compute();
            fVar = this.ByY;
            AppMethodBeat.o(121379);
            return fVar;
        }
    }

    public final boolean r(f fVar) {
        AppMethodBeat.i(121382);
        int indexOf = this.ByV.indexOf(46);
        if (!this.ByV.isEmpty()) {
            String str = this.ByV;
            String str2 = fVar.name;
            if (indexOf == -1) {
                indexOf = this.ByV.length();
            }
            if (str.regionMatches(0, str2, 0, indexOf)) {
                AppMethodBeat.o(121382);
                return true;
            }
        }
        AppMethodBeat.o(121382);
        return false;
    }

    public static c u(f fVar) {
        AppMethodBeat.i(121383);
        c cVar = new c(fVar.name, b.ByP.ByQ, fVar);
        AppMethodBeat.o(121383);
        return cVar;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(121385);
        if (this == obj) {
            AppMethodBeat.o(121385);
            return true;
        } else if (obj instanceof c) {
            if (this.ByV.equals(((c) obj).ByV)) {
                AppMethodBeat.o(121385);
                return true;
            }
            AppMethodBeat.o(121385);
            return false;
        } else {
            AppMethodBeat.o(121385);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(121386);
        int hashCode = this.ByV.hashCode();
        AppMethodBeat.o(121386);
        return hashCode;
    }

    public final c t(f fVar) {
        String str;
        AppMethodBeat.i(121378);
        if (this.ByV.isEmpty()) {
            str = fVar.name;
        } else {
            str = this.ByV + "." + fVar.name;
        }
        c cVar = new c(str, this, fVar);
        AppMethodBeat.o(121378);
        return cVar;
    }

    public final f ehL() {
        AppMethodBeat.i(121380);
        f fVar;
        if (this.ByV.isEmpty()) {
            fVar = ByS;
            AppMethodBeat.o(121380);
            return fVar;
        }
        fVar = ehK();
        AppMethodBeat.o(121380);
        return fVar;
    }

    public final List<f> ehM() {
        AppMethodBeat.i(121381);
        if (this.ByV.isEmpty()) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.o(121381);
            return emptyList;
        }
        List<f> a = i.a((Object[]) ByT.split(this.ByV), ByU);
        AppMethodBeat.o(121381);
        return a;
    }

    public final String toString() {
        AppMethodBeat.i(121384);
        String str;
        if (this.ByV.isEmpty()) {
            str = ByS.name;
            AppMethodBeat.o(121384);
            return str;
        }
        str = this.ByV;
        AppMethodBeat.o(121384);
        return str;
    }
}
