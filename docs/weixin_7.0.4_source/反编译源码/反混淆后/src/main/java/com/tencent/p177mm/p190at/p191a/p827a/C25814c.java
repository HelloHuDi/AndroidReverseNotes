package com.tencent.p177mm.p190at.p191a.p827a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelsfs.SFSContext;
import com.tencent.p177mm.p190at.p191a.p193c.C1283o;
import com.tencent.p177mm.p190at.p191a.p193c.C37474b;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.at.a.a.c */
public final class C25814c {
    public final float alpha;
    public final String cvZ;
    public final int density;
    public final boolean ePF;
    public final boolean ePG;
    public final boolean ePH;
    public final boolean ePI;
    public final String ePJ;
    public final String ePK;
    public final String ePL;
    public final int ePN;
    public final int ePO;
    public final boolean ePP;
    public final boolean ePQ;
    private final boolean ePR;
    public final boolean ePS;
    public final int ePT;
    private final Drawable ePU;
    public final int ePV;
    private final Drawable ePW;
    public final String ePX;
    public final SFSContext ePY;
    public final boolean ePZ;
    public final boolean eQa;
    public final boolean eQb;
    public final Object[] eQd;
    public final boolean eQf;
    public final float eQg;
    public final boolean eQh;
    public final C37474b fGV;
    public final int fHe;
    public final boolean fHf;
    public final int fHg;
    public final boolean fHh;
    private final int fHi;
    private final Drawable fHj;
    public final C1283o fHk;
    public final C7306ak handler;
    public final String thumbPath;

    /* renamed from: com.tencent.mm.at.a.a.c$a */
    public static class C17927a {
        float alpha = 0.0f;
        public String cvZ = "";
        int density = 0;
        public boolean ePF = true;
        public boolean ePG = true;
        public boolean ePH = true;
        public boolean ePI = true;
        public String ePJ = "";
        public String ePK = "";
        String ePL = "";
        public int ePN = 0;
        public int ePO = 0;
        public boolean ePP = false;
        public boolean ePQ = false;
        boolean ePR = false;
        boolean ePS = false;
        public int ePT = 0;
        public Drawable ePU = null;
        public int ePV = 0;
        public Drawable ePW = null;
        public String ePX = null;
        public SFSContext ePY = null;
        public boolean ePZ = true;
        public boolean eQa = false;
        public boolean eQb = true;
        public Object[] eQd = null;
        public boolean eQf = false;
        public float eQg = 0.0f;
        boolean eQh = false;
        public C37474b fGV = null;
        public int fHe = 5;
        public boolean fHf;
        public int fHg;
        boolean fHh;
        int fHi = 0;
        Drawable fHj = null;
        C1283o fHk = null;
        C7306ak handler = null;
        String thumbPath;

        public final C17927a ahC() {
            this.ePF = true;
            return this;
        }

        public final C17927a ahD() {
            this.ePH = true;
            return this;
        }

        /* renamed from: sC */
        public final C17927a mo33452sC(String str) {
            this.ePJ = str;
            return this;
        }

        /* renamed from: sD */
        public final C17927a mo33453sD(String str) {
            this.ePK = str;
            return this;
        }

        /* renamed from: lI */
        public final C17927a mo33449lI(int i) {
            this.ePN = i;
            return this;
        }

        /* renamed from: lJ */
        public final C17927a mo33450lJ(int i) {
            this.ePO = i;
            return this;
        }

        /* renamed from: ct */
        public final C17927a mo33448ct(int i, int i2) {
            this.ePN = i;
            this.ePO = i2;
            return this;
        }

        /* renamed from: lK */
        public final C17927a mo33451lK(int i) {
            this.ePT = C25738R.drawable.f6514gp;
            return this;
        }

        public final C17927a ahE() {
            this.ePV = C25738R.color.f11875k8;
            return this;
        }

        public final C17927a ahF() {
            this.eQa = true;
            return this;
        }

        /* renamed from: a */
        public final C17927a mo33442a(SFSContext sFSContext) {
            this.ePY = sFSContext;
            return this;
        }

        /* renamed from: a */
        public final C17927a mo33441a(C37474b c37474b) {
            this.fGV = c37474b;
            return this;
        }

        public final C25814c ahG() {
            AppMethodBeat.m2504i(116072);
            C25814c c25814c = new C25814c(this, (byte) 0);
            AppMethodBeat.m2505o(116072);
            return c25814c;
        }
    }

    /* synthetic */ C25814c(C17927a c17927a, byte b) {
        this(c17927a);
    }

    private C25814c(C17927a c17927a) {
        this.ePF = c17927a.ePF;
        this.ePH = c17927a.ePH;
        this.ePG = c17927a.ePG;
        this.ePI = c17927a.ePI;
        this.ePJ = c17927a.ePJ;
        this.ePK = c17927a.ePK;
        this.ePL = c17927a.ePL;
        this.fHe = c17927a.fHe;
        this.ePN = c17927a.ePN;
        this.ePO = c17927a.ePO;
        this.ePP = c17927a.ePP;
        this.cvZ = c17927a.cvZ;
        this.density = c17927a.density;
        this.alpha = c17927a.alpha;
        this.ePQ = c17927a.ePQ;
        this.fHf = c17927a.fHf;
        this.fHg = c17927a.fHg;
        this.thumbPath = c17927a.thumbPath;
        this.fHh = c17927a.fHh;
        this.ePR = c17927a.ePR;
        this.ePS = c17927a.ePS;
        this.ePT = c17927a.ePT;
        this.ePU = c17927a.ePU;
        this.fHi = c17927a.fHi;
        this.fHj = c17927a.fHj;
        this.ePV = c17927a.ePV;
        this.ePW = c17927a.ePW;
        this.ePZ = c17927a.ePZ;
        this.eQf = c17927a.eQf;
        this.eQg = c17927a.eQg;
        this.eQa = c17927a.eQa;
        this.eQb = c17927a.eQb;
        this.eQh = c17927a.eQh;
        this.ePY = c17927a.ePY;
        this.handler = c17927a.handler;
        this.eQd = c17927a.eQd;
        this.fGV = c17927a.fGV;
        this.fHk = c17927a.fHk;
        this.ePX = c17927a.ePX;
    }

    public static C25814c ahz() {
        AppMethodBeat.m2504i(116073);
        C25814c ahG = new C17927a().ahG();
        AppMethodBeat.m2505o(116073);
        return ahG;
    }

    public final boolean ahA() {
        return this.ePT > 0 || this.ePU != null;
    }

    public final boolean ahB() {
        return this.ePV > 0 || this.ePW != null;
    }

    /* renamed from: d */
    public final Drawable mo43763d(Resources resources) {
        AppMethodBeat.m2504i(116074);
        Drawable drawable;
        if (this.ePT != 0) {
            drawable = resources.getDrawable(this.ePT);
            AppMethodBeat.m2505o(116074);
            return drawable;
        }
        drawable = this.ePU;
        AppMethodBeat.m2505o(116074);
        return drawable;
    }

    /* renamed from: e */
    public final Drawable mo43764e(Resources resources) {
        AppMethodBeat.m2504i(116075);
        Drawable drawable;
        if (this.ePV != 0) {
            drawable = resources.getDrawable(this.ePV);
            AppMethodBeat.m2505o(116075);
            return drawable;
        }
        drawable = this.ePW;
        AppMethodBeat.m2505o(116075);
        return drawable;
    }
}
