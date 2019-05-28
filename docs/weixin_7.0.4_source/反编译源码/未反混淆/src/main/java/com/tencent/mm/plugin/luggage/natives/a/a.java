package com.tencent.mm.plugin.luggage.natives.a;

import android.support.v4.widget.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;

public final class a {
    public int iUG;
    public int mColor;
    public a[] oiC;
    public g[] oiD;
    public int[] oiE;
    public g[] oiF;
    public int ojA;
    public int ojB;
    public int ojC;
    public int ojD;
    public g ojE;
    public int ojF;
    public int ojG;
    public g ojH;
    public g ojI;
    public boolean ojJ;
    public c ojK;
    public d ojL;
    public String[] ojM;
    public e ojN;
    public boolean ojO;
    public b ojP;
    public int ojQ;
    public g ojR;
    public g ojS;
    public String[] ojT;
    public c ojU;
    public d ojV;
    public int ojW;
    public g ojd;
    public g oje;
    public g ojf;
    public g ojg;
    public g ojh;
    public g oji;
    public g ojj;
    public g ojk;
    public g ojl;
    public g ojm;
    public g ojn;
    public g ojo;
    public g ojp;
    public g ojq;
    public g ojr;
    public g ojs;
    public g ojt;
    public g oju;
    public int ojv;
    public int ojw;
    public int ojx;
    public int ojy;
    public int ojz;

    public enum c {
        UNDEFINED,
        NORMAL,
        ITALIC,
        INHERIT;

        static {
            AppMethodBeat.o(116910);
        }
    }

    public enum a {
        UNDEFINED,
        NONE,
        SOLID,
        DASHED,
        DOTTED;

        static {
            AppMethodBeat.o(116904);
        }
    }

    public enum b {
        CONTENTBOX,
        BORDERBOX;

        static {
            AppMethodBeat.o(116907);
        }
    }

    public enum d {
        UNDEFINED,
        WEIGHT100,
        WEIGHT200,
        WEIGHT300,
        WEIGHT400,
        WEIGHT500,
        WEIGHT600,
        WEIGHT700,
        WEIGHT800,
        WEIGHT900,
        INHERIT;

        static {
            AppMethodBeat.o(116913);
        }
    }

    public enum e {
        UNDEFINED,
        ABSOLUTE,
        FIXED;

        static {
            AppMethodBeat.o(116916);
        }
    }

    public enum f {
        UNDEFINED,
        POINT,
        PERCENT,
        AUTO,
        WRAP_CONTENT,
        MULTIPLIER;

        static {
            AppMethodBeat.o(116919);
        }
    }

    public static class g {
        public f okI;
        public float value;

        public final boolean equals(Object obj) {
            AppMethodBeat.i(116920);
            if (this == obj) {
                AppMethodBeat.o(116920);
                return true;
            } else if (obj instanceof g) {
                g gVar = (g) obj;
                if (Float.compare(gVar.value, this.value) == 0 && this.okI == gVar.okI) {
                    AppMethodBeat.o(116920);
                    return true;
                }
                AppMethodBeat.o(116920);
                return false;
            } else {
                AppMethodBeat.o(116920);
                return false;
            }
        }

        public final int hashCode() {
            AppMethodBeat.i(116921);
            int hash = Objects.hash(new Object[]{this.okI, Float.valueOf(this.value)});
            AppMethodBeat.o(116921);
            return hash;
        }

        public final String toString() {
            AppMethodBeat.i(116922);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{unit:").append(this.okI).append(", value:").append(this.value).append("}");
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(116922);
            return stringBuilder2;
        }
    }

    public a() {
        this((byte) 0);
    }

    private a(byte b) {
        AppMethodBeat.i(116923);
        this.ojd = null;
        this.oje = null;
        this.ojf = null;
        this.ojg = null;
        this.ojh = null;
        this.oji = null;
        this.ojj = null;
        this.ojk = null;
        this.ojl = null;
        this.ojm = null;
        this.ojn = null;
        this.ojo = null;
        this.ojp = null;
        this.ojq = null;
        this.ojr = null;
        this.ojs = null;
        this.ojt = null;
        this.oju = null;
        this.oiC = new a[4];
        this.oiD = new g[4];
        this.oiE = new int[]{j.INVALID_ID, j.INVALID_ID, j.INVALID_ID, j.INVALID_ID};
        this.oiF = new g[4];
        this.ojv = 0;
        this.ojw = j.INVALID_ID;
        this.ojx = j.INVALID_ID;
        this.ojy = j.INVALID_ID;
        this.ojz = j.INVALID_ID;
        this.ojA = j.INVALID_ID;
        this.ojB = j.INVALID_ID;
        this.ojC = j.INVALID_ID;
        this.ojD = j.INVALID_ID;
        this.ojE = null;
        this.ojF = j.INVALID_ID;
        this.mColor = j.INVALID_ID;
        this.iUG = j.INVALID_ID;
        this.ojG = j.INVALID_ID;
        this.ojH = null;
        this.ojI = null;
        this.ojJ = true;
        this.ojK = c.UNDEFINED;
        this.ojL = d.UNDEFINED;
        this.ojM = null;
        this.ojN = e.UNDEFINED;
        this.ojO = false;
        this.ojP = b.CONTENTBOX;
        this.ojQ = j.INVALID_ID;
        this.ojR = null;
        this.ojS = null;
        this.ojT = null;
        this.ojU = c.UNDEFINED;
        this.ojV = d.UNDEFINED;
        this.ojW = j.INVALID_ID;
        AppMethodBeat.o(116923);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(116924);
        if (this == obj) {
            AppMethodBeat.o(116924);
            return true;
        } else if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.ojv == aVar.ojv && this.ojw == aVar.ojw && this.ojx == aVar.ojx && this.ojy == aVar.ojy && this.ojz == aVar.ojz && this.ojA == aVar.ojA && this.ojB == aVar.ojB && this.ojC == aVar.ojC && this.ojD == aVar.ojD && this.ojF == aVar.ojF && this.mColor == aVar.mColor && this.iUG == aVar.iUG && this.ojG == aVar.ojG && this.ojN == aVar.ojN && Objects.equals(this.ojd, aVar.ojd) && Objects.equals(this.oje, aVar.oje) && Objects.equals(this.ojf, aVar.ojf) && Objects.equals(this.ojg, aVar.ojg) && Objects.equals(this.ojh, aVar.ojh) && Objects.equals(this.oji, aVar.oji) && Objects.equals(this.ojj, aVar.ojj) && Objects.equals(this.ojk, aVar.ojk) && Objects.equals(this.ojl, aVar.ojl) && Objects.equals(this.ojm, aVar.ojm) && Objects.equals(this.ojn, aVar.ojn) && Objects.equals(this.ojo, aVar.ojo) && Objects.equals(this.ojp, aVar.ojp) && Objects.equals(this.ojq, aVar.ojq) && Objects.equals(this.ojE, aVar.ojE) && Objects.equals(this.ojI, aVar.ojI) && Objects.equals(this.ojt, aVar.ojt) && Objects.equals(this.oju, aVar.oju) && Objects.equals(this.ojr, aVar.ojr) && Objects.equals(this.ojs, aVar.ojs)) {
                AppMethodBeat.o(116924);
                return true;
            }
            AppMethodBeat.o(116924);
            return false;
        } else {
            AppMethodBeat.o(116924);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(116925);
        int hash = Objects.hash(new Object[]{this.ojd, this.oje, this.ojf, this.ojg, this.ojh, this.oji, this.ojj, this.ojk, this.ojl, this.ojm, this.ojn, this.ojo, this.ojp, this.ojq, Integer.valueOf(this.ojv), Integer.valueOf(this.ojw), Integer.valueOf(this.ojx), Integer.valueOf(this.ojy), Integer.valueOf(this.ojz), Integer.valueOf(this.ojA), Integer.valueOf(this.ojB), Integer.valueOf(this.ojC), Integer.valueOf(this.ojD), this.ojE, Integer.valueOf(this.ojF), Integer.valueOf(this.mColor), Integer.valueOf(this.iUG), Integer.valueOf(this.ojG)});
        AppMethodBeat.o(116925);
        return hash;
    }

    public final String toString() {
        AppMethodBeat.i(116926);
        new StringBuilder("{displaytype:").append(this.ojv).append(", flexalignitems:").append(this.ojx);
        String obj = super.toString();
        AppMethodBeat.o(116926);
        return obj;
    }
}
