package com.tencent.mm.loader.c;

import android.graphics.drawable.Drawable;
import com.tencent.mm.R;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.ak;

public final class e {
    public static boolean DEBUG = true;
    public static final b ePE = b.NETWORK;
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
    private final b ePM;
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
    private final com.tencent.mm.loader.d.b eQc;
    private final Object[] eQd;
    private final ak handler;

    public static class a {
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
        b ePM = e.ePE;
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
        com.tencent.mm.loader.d.b eQc = null;
        Object[] eQd = null;
        private com.tencent.mm.loader.e.c.a eQe = null;
        private boolean eQf = false;
        private float eQg = 0.0f;
        private boolean eQh = false;
        ak handler = null;

        public final a TI() {
            this.ePF = true;
            return this;
        }

        public final a TJ() {
            this.ePH = true;
            return this;
        }

        public final a jY(int i) {
            this.ePN = i;
            return this;
        }

        public final a jZ(int i) {
            this.ePO = i;
            return this;
        }

        public final a TK() {
            this.ePV = R.drawable.b66;
            return this;
        }

        public final e TL() {
            return new e(this, (byte) 0);
        }
    }

    public enum b {
        NETWORK,
        FILE
    }

    /* synthetic */ e(a aVar, byte b) {
        this(aVar);
    }

    private e(a aVar) {
        this.ePF = aVar.ePF;
        this.ePH = aVar.ePH;
        this.ePG = aVar.ePG;
        this.ePI = aVar.ePI;
        this.ePJ = aVar.ePJ;
        this.ePK = aVar.ePK;
        this.ePL = aVar.ePL;
        this.ePM = aVar.ePM;
        this.ePN = aVar.ePN;
        this.ePO = aVar.ePO;
        this.ePP = aVar.ePP;
        this.cvZ = aVar.cvZ;
        this.density = aVar.density;
        this.alpha = aVar.alpha;
        this.ePQ = aVar.ePQ;
        this.ePR = aVar.ePR;
        this.ePS = aVar.ePS;
        this.ePT = aVar.ePT;
        this.ePU = aVar.ePU;
        this.ePV = aVar.ePV;
        this.ePW = aVar.ePW;
        this.ePZ = aVar.ePZ;
        this.eQa = aVar.eQa;
        this.eQb = aVar.eQb;
        this.ePY = aVar.ePY;
        this.handler = aVar.handler;
        this.eQd = aVar.eQd;
        this.eQc = aVar.eQc;
        this.ePX = aVar.ePX;
    }

    public static e Tr() {
        return new a().TL();
    }

    public final boolean Ts() {
        return this.ePF;
    }

    public final boolean Tt() {
        return this.ePH;
    }

    public final boolean Tu() {
        return this.ePG;
    }

    public final String Tv() {
        return this.ePJ;
    }

    public final String Tw() {
        return this.ePK;
    }

    public final String Tx() {
        return this.ePL;
    }

    public final b Ty() {
        return this.ePM;
    }

    public final int Tz() {
        return this.ePN;
    }

    public final int TA() {
        return this.ePO;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final boolean TB() {
        return this.ePQ;
    }

    public final int TC() {
        return this.ePV;
    }

    public final boolean TD() {
        return this.ePP;
    }

    public final String TE() {
        return this.cvZ;
    }

    public final SFSContext TF() {
        return this.ePY;
    }

    public final Object[] TG() {
        if (this.eQd == null) {
            return new Object[0];
        }
        return this.eQd;
    }

    public final boolean TH() {
        return this.ePS;
    }
}
