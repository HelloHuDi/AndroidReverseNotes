package com.tencent.p177mm.plugin.luggage.natives.p990a;

import android.support.p057v4.widget.C8415j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;

/* renamed from: com.tencent.mm.plugin.luggage.natives.a.a */
public final class C39346a {
    public int iUG;
    public int mColor;
    public C21260a[] oiC;
    public C39347g[] oiD;
    public int[] oiE;
    public C39347g[] oiF;
    public int ojA;
    public int ojB;
    public int ojC;
    public int ojD;
    public C39347g ojE;
    public int ojF;
    public int ojG;
    public C39347g ojH;
    public C39347g ojI;
    public boolean ojJ;
    public C12474c ojK;
    public C28463d ojL;
    public String[] ojM;
    public C39344e ojN;
    public boolean ojO;
    public C28462b ojP;
    public int ojQ;
    public C39347g ojR;
    public C39347g ojS;
    public String[] ojT;
    public C12474c ojU;
    public C28463d ojV;
    public int ojW;
    public C39347g ojd;
    public C39347g oje;
    public C39347g ojf;
    public C39347g ojg;
    public C39347g ojh;
    public C39347g oji;
    public C39347g ojj;
    public C39347g ojk;
    public C39347g ojl;
    public C39347g ojm;
    public C39347g ojn;
    public C39347g ojo;
    public C39347g ojp;
    public C39347g ojq;
    public C39347g ojr;
    public C39347g ojs;
    public C39347g ojt;
    public C39347g oju;
    public int ojv;
    public int ojw;
    public int ojx;
    public int ojy;
    public int ojz;

    /* renamed from: com.tencent.mm.plugin.luggage.natives.a.a$c */
    public enum C12474c {
        UNDEFINED,
        NORMAL,
        ITALIC,
        INHERIT;

        static {
            AppMethodBeat.m2505o(116910);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luggage.natives.a.a$a */
    public enum C21260a {
        UNDEFINED,
        NONE,
        SOLID,
        DASHED,
        DOTTED;

        static {
            AppMethodBeat.m2505o(116904);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luggage.natives.a.a$b */
    public enum C28462b {
        CONTENTBOX,
        BORDERBOX;

        static {
            AppMethodBeat.m2505o(116907);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luggage.natives.a.a$d */
    public enum C28463d {
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
            AppMethodBeat.m2505o(116913);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luggage.natives.a.a$e */
    public enum C39344e {
        UNDEFINED,
        ABSOLUTE,
        FIXED;

        static {
            AppMethodBeat.m2505o(116916);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luggage.natives.a.a$f */
    public enum C39345f {
        UNDEFINED,
        POINT,
        PERCENT,
        AUTO,
        WRAP_CONTENT,
        MULTIPLIER;

        static {
            AppMethodBeat.m2505o(116919);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luggage.natives.a.a$g */
    public static class C39347g {
        public C39345f okI;
        public float value;

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(116920);
            if (this == obj) {
                AppMethodBeat.m2505o(116920);
                return true;
            } else if (obj instanceof C39347g) {
                C39347g c39347g = (C39347g) obj;
                if (Float.compare(c39347g.value, this.value) == 0 && this.okI == c39347g.okI) {
                    AppMethodBeat.m2505o(116920);
                    return true;
                }
                AppMethodBeat.m2505o(116920);
                return false;
            } else {
                AppMethodBeat.m2505o(116920);
                return false;
            }
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(116921);
            int hash = Objects.hash(new Object[]{this.okI, Float.valueOf(this.value)});
            AppMethodBeat.m2505o(116921);
            return hash;
        }

        public final String toString() {
            AppMethodBeat.m2504i(116922);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{unit:").append(this.okI).append(", value:").append(this.value).append("}");
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(116922);
            return stringBuilder2;
        }
    }

    public C39346a() {
        this((byte) 0);
    }

    private C39346a(byte b) {
        AppMethodBeat.m2504i(116923);
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
        this.oiC = new C21260a[4];
        this.oiD = new C39347g[4];
        this.oiE = new int[]{C8415j.INVALID_ID, C8415j.INVALID_ID, C8415j.INVALID_ID, C8415j.INVALID_ID};
        this.oiF = new C39347g[4];
        this.ojv = 0;
        this.ojw = C8415j.INVALID_ID;
        this.ojx = C8415j.INVALID_ID;
        this.ojy = C8415j.INVALID_ID;
        this.ojz = C8415j.INVALID_ID;
        this.ojA = C8415j.INVALID_ID;
        this.ojB = C8415j.INVALID_ID;
        this.ojC = C8415j.INVALID_ID;
        this.ojD = C8415j.INVALID_ID;
        this.ojE = null;
        this.ojF = C8415j.INVALID_ID;
        this.mColor = C8415j.INVALID_ID;
        this.iUG = C8415j.INVALID_ID;
        this.ojG = C8415j.INVALID_ID;
        this.ojH = null;
        this.ojI = null;
        this.ojJ = true;
        this.ojK = C12474c.UNDEFINED;
        this.ojL = C28463d.UNDEFINED;
        this.ojM = null;
        this.ojN = C39344e.UNDEFINED;
        this.ojO = false;
        this.ojP = C28462b.CONTENTBOX;
        this.ojQ = C8415j.INVALID_ID;
        this.ojR = null;
        this.ojS = null;
        this.ojT = null;
        this.ojU = C12474c.UNDEFINED;
        this.ojV = C28463d.UNDEFINED;
        this.ojW = C8415j.INVALID_ID;
        AppMethodBeat.m2505o(116923);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(116924);
        if (this == obj) {
            AppMethodBeat.m2505o(116924);
            return true;
        } else if (obj instanceof C39346a) {
            C39346a c39346a = (C39346a) obj;
            if (this.ojv == c39346a.ojv && this.ojw == c39346a.ojw && this.ojx == c39346a.ojx && this.ojy == c39346a.ojy && this.ojz == c39346a.ojz && this.ojA == c39346a.ojA && this.ojB == c39346a.ojB && this.ojC == c39346a.ojC && this.ojD == c39346a.ojD && this.ojF == c39346a.ojF && this.mColor == c39346a.mColor && this.iUG == c39346a.iUG && this.ojG == c39346a.ojG && this.ojN == c39346a.ojN && Objects.equals(this.ojd, c39346a.ojd) && Objects.equals(this.oje, c39346a.oje) && Objects.equals(this.ojf, c39346a.ojf) && Objects.equals(this.ojg, c39346a.ojg) && Objects.equals(this.ojh, c39346a.ojh) && Objects.equals(this.oji, c39346a.oji) && Objects.equals(this.ojj, c39346a.ojj) && Objects.equals(this.ojk, c39346a.ojk) && Objects.equals(this.ojl, c39346a.ojl) && Objects.equals(this.ojm, c39346a.ojm) && Objects.equals(this.ojn, c39346a.ojn) && Objects.equals(this.ojo, c39346a.ojo) && Objects.equals(this.ojp, c39346a.ojp) && Objects.equals(this.ojq, c39346a.ojq) && Objects.equals(this.ojE, c39346a.ojE) && Objects.equals(this.ojI, c39346a.ojI) && Objects.equals(this.ojt, c39346a.ojt) && Objects.equals(this.oju, c39346a.oju) && Objects.equals(this.ojr, c39346a.ojr) && Objects.equals(this.ojs, c39346a.ojs)) {
                AppMethodBeat.m2505o(116924);
                return true;
            }
            AppMethodBeat.m2505o(116924);
            return false;
        } else {
            AppMethodBeat.m2505o(116924);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(116925);
        int hash = Objects.hash(new Object[]{this.ojd, this.oje, this.ojf, this.ojg, this.ojh, this.oji, this.ojj, this.ojk, this.ojl, this.ojm, this.ojn, this.ojo, this.ojp, this.ojq, Integer.valueOf(this.ojv), Integer.valueOf(this.ojw), Integer.valueOf(this.ojx), Integer.valueOf(this.ojy), Integer.valueOf(this.ojz), Integer.valueOf(this.ojA), Integer.valueOf(this.ojB), Integer.valueOf(this.ojC), Integer.valueOf(this.ojD), this.ojE, Integer.valueOf(this.ojF), Integer.valueOf(this.mColor), Integer.valueOf(this.iUG), Integer.valueOf(this.ojG)});
        AppMethodBeat.m2505o(116925);
        return hash;
    }

    public final String toString() {
        AppMethodBeat.m2504i(116926);
        new StringBuilder("{displaytype:").append(this.ojv).append(", flexalignitems:").append(this.ojx);
        String obj = super.toString();
        AppMethodBeat.m2505o(116926);
        return obj;
    }
}
