package com.tencent.mm.at.a.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.a.c.b;
import com.tencent.mm.at.a.c.o;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.ak;

public final class c {
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
    public final b fGV;
    public final int fHe;
    public final boolean fHf;
    public final int fHg;
    public final boolean fHh;
    private final int fHi;
    private final Drawable fHj;
    public final o fHk;
    public final ak handler;
    public final String thumbPath;

    public static class a {
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
        public b fGV = null;
        public int fHe = 5;
        public boolean fHf;
        public int fHg;
        boolean fHh;
        int fHi = 0;
        Drawable fHj = null;
        o fHk = null;
        ak handler = null;
        String thumbPath;

        public final a ahC() {
            this.ePF = true;
            return this;
        }

        public final a ahD() {
            this.ePH = true;
            return this;
        }

        public final a sC(String str) {
            this.ePJ = str;
            return this;
        }

        public final a sD(String str) {
            this.ePK = str;
            return this;
        }

        public final a lI(int i) {
            this.ePN = i;
            return this;
        }

        public final a lJ(int i) {
            this.ePO = i;
            return this;
        }

        public final a ct(int i, int i2) {
            this.ePN = i;
            this.ePO = i2;
            return this;
        }

        public final a lK(int i) {
            this.ePT = R.drawable.gp;
            return this;
        }

        public final a ahE() {
            this.ePV = R.color.k8;
            return this;
        }

        public final a ahF() {
            this.eQa = true;
            return this;
        }

        public final a a(SFSContext sFSContext) {
            this.ePY = sFSContext;
            return this;
        }

        public final a a(b bVar) {
            this.fGV = bVar;
            return this;
        }

        public final c ahG() {
            AppMethodBeat.i(116072);
            c cVar = new c(this, (byte) 0);
            AppMethodBeat.o(116072);
            return cVar;
        }
    }

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.ePF = aVar.ePF;
        this.ePH = aVar.ePH;
        this.ePG = aVar.ePG;
        this.ePI = aVar.ePI;
        this.ePJ = aVar.ePJ;
        this.ePK = aVar.ePK;
        this.ePL = aVar.ePL;
        this.fHe = aVar.fHe;
        this.ePN = aVar.ePN;
        this.ePO = aVar.ePO;
        this.ePP = aVar.ePP;
        this.cvZ = aVar.cvZ;
        this.density = aVar.density;
        this.alpha = aVar.alpha;
        this.ePQ = aVar.ePQ;
        this.fHf = aVar.fHf;
        this.fHg = aVar.fHg;
        this.thumbPath = aVar.thumbPath;
        this.fHh = aVar.fHh;
        this.ePR = aVar.ePR;
        this.ePS = aVar.ePS;
        this.ePT = aVar.ePT;
        this.ePU = aVar.ePU;
        this.fHi = aVar.fHi;
        this.fHj = aVar.fHj;
        this.ePV = aVar.ePV;
        this.ePW = aVar.ePW;
        this.ePZ = aVar.ePZ;
        this.eQf = aVar.eQf;
        this.eQg = aVar.eQg;
        this.eQa = aVar.eQa;
        this.eQb = aVar.eQb;
        this.eQh = aVar.eQh;
        this.ePY = aVar.ePY;
        this.handler = aVar.handler;
        this.eQd = aVar.eQd;
        this.fGV = aVar.fGV;
        this.fHk = aVar.fHk;
        this.ePX = aVar.ePX;
    }

    public static c ahz() {
        AppMethodBeat.i(116073);
        c ahG = new a().ahG();
        AppMethodBeat.o(116073);
        return ahG;
    }

    public final boolean ahA() {
        return this.ePT > 0 || this.ePU != null;
    }

    public final boolean ahB() {
        return this.ePV > 0 || this.ePW != null;
    }

    public final Drawable d(Resources resources) {
        AppMethodBeat.i(116074);
        Drawable drawable;
        if (this.ePT != 0) {
            drawable = resources.getDrawable(this.ePT);
            AppMethodBeat.o(116074);
            return drawable;
        }
        drawable = this.ePU;
        AppMethodBeat.o(116074);
        return drawable;
    }

    public final Drawable e(Resources resources) {
        AppMethodBeat.i(116075);
        Drawable drawable;
        if (this.ePV != 0) {
            drawable = resources.getDrawable(this.ePV);
            AppMethodBeat.o(116075);
            return drawable;
        }
        drawable = this.ePW;
        AppMethodBeat.o(116075);
        return drawable;
    }
}
