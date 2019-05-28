package com.tencent.p177mm.loader.p861c;

import android.graphics.drawable.Drawable;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.loader.p245d.C32725b;
import com.tencent.p177mm.loader.p246e.p862c.C9569a;
import com.tencent.p177mm.modelsfs.SFSContext;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.loader.c.e */
public final class C37878e {
    public static boolean DEBUG = true;
    public static final C37879b ePE = C37879b.NETWORK;
    private final float alpha;
    private final String cvZ;
    private final int density;
    private final boolean ePF;
    private final boolean ePG;
    private final boolean ePH;
    private final boolean ePI;
    private final String ePJ;
    private final String ePK;
    private final String ePL;
    private final C37879b ePM;
    private final int ePN;
    private final int ePO;
    private final boolean ePP;
    private final boolean ePQ;
    private final boolean ePR;
    private final boolean ePS;
    private final int ePT;
    private final Drawable ePU;
    private final int ePV;
    private final Drawable ePW;
    private final String ePX;
    private final SFSContext ePY;
    private final boolean ePZ;
    private final boolean eQa;
    private final boolean eQb;
    private final C32725b eQc;
    private final Object[] eQd;
    private final C7306ak handler;

    /* renamed from: com.tencent.mm.loader.c.e$a */
    public static class C32724a {
        float alpha = 0.0f;
        String cvZ = "";
        int density = 0;
        boolean ePF = true;
        boolean ePG = false;
        boolean ePH = false;
        boolean ePI = true;
        String ePJ = "";
        String ePK = "";
        String ePL = "";
        C37879b ePM = C37878e.ePE;
        int ePN = 0;
        int ePO = 0;
        boolean ePP = false;
        boolean ePQ = false;
        boolean ePR = false;
        boolean ePS = false;
        int ePT = 0;
        Drawable ePU = null;
        int ePV = 0;
        Drawable ePW = null;
        String ePX = null;
        SFSContext ePY = null;
        boolean ePZ = true;
        boolean eQa = false;
        boolean eQb = true;
        C32725b eQc = null;
        Object[] eQd = null;
        private C9569a eQe = null;
        private boolean eQf = false;
        private float eQg = 0.0f;
        private boolean eQh = false;
        C7306ak handler = null;

        /* renamed from: TI */
        public final C32724a mo53277TI() {
            this.ePF = true;
            return this;
        }

        /* renamed from: TJ */
        public final C32724a mo53278TJ() {
            this.ePH = true;
            return this;
        }

        /* renamed from: jY */
        public final C32724a mo53281jY(int i) {
            this.ePN = i;
            return this;
        }

        /* renamed from: jZ */
        public final C32724a mo53282jZ(int i) {
            this.ePO = i;
            return this;
        }

        /* renamed from: TK */
        public final C32724a mo53279TK() {
            this.ePV = C25738R.drawable.b66;
            return this;
        }

        /* renamed from: TL */
        public final C37878e mo53280TL() {
            return new C37878e(this, (byte) 0);
        }
    }

    /* renamed from: com.tencent.mm.loader.c.e$b */
    public enum C37879b {
        NETWORK,
        FILE
    }

    /* synthetic */ C37878e(C32724a c32724a, byte b) {
        this(c32724a);
    }

    private C37878e(C32724a c32724a) {
        this.ePF = c32724a.ePF;
        this.ePH = c32724a.ePH;
        this.ePG = c32724a.ePG;
        this.ePI = c32724a.ePI;
        this.ePJ = c32724a.ePJ;
        this.ePK = c32724a.ePK;
        this.ePL = c32724a.ePL;
        this.ePM = c32724a.ePM;
        this.ePN = c32724a.ePN;
        this.ePO = c32724a.ePO;
        this.ePP = c32724a.ePP;
        this.cvZ = c32724a.cvZ;
        this.density = c32724a.density;
        this.alpha = c32724a.alpha;
        this.ePQ = c32724a.ePQ;
        this.ePR = c32724a.ePR;
        this.ePS = c32724a.ePS;
        this.ePT = c32724a.ePT;
        this.ePU = c32724a.ePU;
        this.ePV = c32724a.ePV;
        this.ePW = c32724a.ePW;
        this.ePZ = c32724a.ePZ;
        this.eQa = c32724a.eQa;
        this.eQb = c32724a.eQb;
        this.ePY = c32724a.ePY;
        this.handler = c32724a.handler;
        this.eQd = c32724a.eQd;
        this.eQc = c32724a.eQc;
        this.ePX = c32724a.ePX;
    }

    /* renamed from: Tr */
    public static C37878e m63924Tr() {
        return new C32724a().mo53280TL();
    }

    /* renamed from: Ts */
    public final boolean mo60620Ts() {
        return this.ePF;
    }

    /* renamed from: Tt */
    public final boolean mo60621Tt() {
        return this.ePH;
    }

    /* renamed from: Tu */
    public final boolean mo60622Tu() {
        return this.ePG;
    }

    /* renamed from: Tv */
    public final String mo60623Tv() {
        return this.ePJ;
    }

    /* renamed from: Tw */
    public final String mo60624Tw() {
        return this.ePK;
    }

    /* renamed from: Tx */
    public final String mo60625Tx() {
        return this.ePL;
    }

    /* renamed from: Ty */
    public final C37879b mo60626Ty() {
        return this.ePM;
    }

    /* renamed from: Tz */
    public final int mo60627Tz() {
        return this.ePN;
    }

    /* renamed from: TA */
    public final int mo60612TA() {
        return this.ePO;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    /* renamed from: TB */
    public final boolean mo60613TB() {
        return this.ePQ;
    }

    /* renamed from: TC */
    public final int mo60614TC() {
        return this.ePV;
    }

    /* renamed from: TD */
    public final boolean mo60615TD() {
        return this.ePP;
    }

    /* renamed from: TE */
    public final String mo60616TE() {
        return this.cvZ;
    }

    /* renamed from: TF */
    public final SFSContext mo60617TF() {
        return this.ePY;
    }

    /* renamed from: TG */
    public final Object[] mo60618TG() {
        if (this.eQd == null) {
            return new Object[0];
        }
        return this.eQd;
    }

    /* renamed from: TH */
    public final boolean mo60619TH() {
        return this.ePS;
    }
}
