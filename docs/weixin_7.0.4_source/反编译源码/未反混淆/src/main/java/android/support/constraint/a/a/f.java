package android.support.constraint.a.a;

import android.support.constraint.a.a.e.b;
import android.support.constraint.a.a.e.c;
import android.support.constraint.a.e;
import android.support.constraint.a.h;
import android.support.v4.widget.j;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.ArrayList;

public class f {
    public static float iU = 0.5f;
    protected int dg;
    protected int dh;
    public int hX = -1;
    public int hY = -1;
    n hZ;
    e iA = new e(this, c.CENTER_X);
    e iB = new e(this, c.CENTER_Y);
    e iC = new e(this, c.CENTER);
    protected e[] iD = new e[]{this.iu, this.ix, this.iw, this.iy, this.iz, this.iC};
    protected ArrayList<e> iE = new ArrayList();
    protected a[] iF = new a[]{a.FIXED, a.FIXED};
    f iG = null;
    protected float iH = 0.0f;
    protected int iI = -1;
    protected int iJ = 0;
    protected int iK = 0;
    int iL = 0;
    int iM = 0;
    private int iN = 0;
    private int iO = 0;
    private int iP = 0;
    private int iQ = 0;
    public int iR = 0;
    public int iS;
    public int iT;
    public float iV = iU;
    public float iW = iU;
    public Object iX;
    private int iY = 0;
    public int iZ = 0;
    n ia;
    public int ib = 0;
    public int ic = 0;
    int[] ie = new int[2];
    /* renamed from: if */
    public int f3if = 0;
    public int ig = 0;
    public float ih = 1.0f;
    public int ii = 0;
    public int ij = 0;
    public float ik = 1.0f;
    public boolean il;
    public boolean im;
    int io = -1;
    float iq = 1.0f;
    h ir = null;
    public int[] is = new int[]{BaseClientBuilder.API_PRIORITY_OTHER, BaseClientBuilder.API_PRIORITY_OTHER};
    public float it = 0.0f;
    e iu = new e(this, c.LEFT);
    e iw = new e(this, c.TOP);
    e ix = new e(this, c.RIGHT);
    e iy = new e(this, c.BOTTOM);
    e iz = new e(this, c.BASELINE);
    public String ja = null;
    boolean jb;
    boolean jc;
    boolean jd = false;
    boolean je = false;
    boolean jf = false;
    public int jg = 0;
    public int jh = 0;
    boolean ji;
    boolean jj;
    public float[] jk = new float[]{-1.0f, -1.0f};
    protected f[] jl = new f[]{null, null};
    protected f[] jm = new f[]{null, null};
    f jn = null;
    f jo = null;
    int mHeight = 0;
    protected int mOffsetX = 0;
    protected int mOffsetY = 0;
    private String mType = null;
    int mWidth = 0;

    public enum a {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public final boolean aI() {
        return this.ib == 0 && this.iH == 0.0f && this.f3if == 0 && this.ig == 0 && this.iF[0] == a.MATCH_CONSTRAINT;
    }

    public final boolean aJ() {
        return this.ic == 0 && this.iH == 0.0f && this.ii == 0 && this.ij == 0 && this.iF[1] == a.MATCH_CONSTRAINT;
    }

    public void reset() {
        this.iu.reset();
        this.iw.reset();
        this.ix.reset();
        this.iy.reset();
        this.iz.reset();
        this.iA.reset();
        this.iB.reset();
        this.iC.reset();
        this.iG = null;
        this.it = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.iH = 0.0f;
        this.iI = -1;
        this.iJ = 0;
        this.iK = 0;
        this.iN = 0;
        this.iO = 0;
        this.iP = 0;
        this.iQ = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.iR = 0;
        this.dg = 0;
        this.dh = 0;
        this.iS = 0;
        this.iT = 0;
        this.iV = iU;
        this.iW = iU;
        this.iF[0] = a.FIXED;
        this.iF[1] = a.FIXED;
        this.iX = null;
        this.iY = 0;
        this.iZ = 0;
        this.mType = null;
        this.jb = false;
        this.jc = false;
        this.jg = 0;
        this.jh = 0;
        this.ji = false;
        this.jj = false;
        this.jk[0] = -1.0f;
        this.jk[1] = -1.0f;
        this.hX = -1;
        this.hY = -1;
        this.is[0] = BaseClientBuilder.API_PRIORITY_OTHER;
        this.is[1] = BaseClientBuilder.API_PRIORITY_OTHER;
        this.ib = 0;
        this.ic = 0;
        this.ih = 1.0f;
        this.ik = 1.0f;
        this.ig = BaseClientBuilder.API_PRIORITY_OTHER;
        this.ij = BaseClientBuilder.API_PRIORITY_OTHER;
        this.f3if = 0;
        this.ii = 0;
        this.io = -1;
        this.iq = 1.0f;
        if (this.hZ != null) {
            this.hZ.reset();
        }
        if (this.ia != null) {
            this.ia.reset();
        }
        this.ir = null;
        this.jd = false;
        this.je = false;
        this.jf = false;
    }

    public void aD() {
        for (int i = 0; i < 6; i++) {
            this.iD[i].hv.reset();
        }
    }

    public final void aK() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 6) {
                m mVar = this.iD[i2].hv;
                e eVar = mVar.kj.hy;
                if (eVar != null) {
                    if (eVar.hy == mVar.kj) {
                        mVar.type = 4;
                        eVar.hv.type = 4;
                    }
                    i = mVar.kj.aH();
                    if (mVar.kj.hx == c.RIGHT || mVar.kj.hx == c.BOTTOM) {
                        i = -i;
                    }
                    mVar.b(eVar.hv, i);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void u(int i) {
        k.a(i, this);
    }

    public void aE() {
    }

    public final boolean aL() {
        if (this.iu.hv.state == 1 && this.ix.hv.state == 1 && this.iw.hv.state == 1 && this.iy.hv.state == 1) {
            return true;
        }
        return false;
    }

    public final n aM() {
        if (this.hZ == null) {
            this.hZ = new n();
        }
        return this.hZ;
    }

    public final n aN() {
        if (this.ia == null) {
            this.ia = new n();
        }
        return this.ia;
    }

    public f() {
        this.iE.add(this.iu);
        this.iE.add(this.iw);
        this.iE.add(this.ix);
        this.iE.add(this.iy);
        this.iE.add(this.iA);
        this.iE.add(this.iB);
        this.iE.add(this.iC);
        this.iE.add(this.iz);
    }

    public void a(android.support.constraint.a.c cVar) {
        this.iu.aG();
        this.iw.aG();
        this.ix.aG();
        this.iy.aG();
        this.iz.aG();
        this.iC.aG();
        this.iA.aG();
        this.iB.aG();
    }

    public final void b(e eVar) {
        eVar.g(this.iu);
        eVar.g(this.iw);
        eVar.g(this.ix);
        eVar.g(this.iy);
        if (this.iR > 0) {
            eVar.g(this.iz);
        }
    }

    public String toString() {
        return (this.mType != null ? "type: " + this.mType + " " : "") + (this.ja != null ? "id: " + this.ja + " " : "") + "(" + this.iJ + ", " + this.iK + ") - (" + this.mWidth + " x " + this.mHeight + ") wrap: (" + this.iS + " x " + this.iT + ")";
    }

    public final int getX() {
        return this.iJ;
    }

    public final int getY() {
        return this.iK;
    }

    public final int getWidth() {
        if (this.iZ == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public final int getHeight() {
        if (this.iZ == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public final int v(int i) {
        if (i == 0) {
            return getWidth();
        }
        if (i == 1) {
            return getHeight();
        }
        return 0;
    }

    public final int aO() {
        return this.iN + this.mOffsetX;
    }

    public final int aP() {
        return this.iO + this.mOffsetY;
    }

    /* Access modifiers changed, original: protected|final */
    public final int aQ() {
        return this.iJ + this.mOffsetX;
    }

    /* Access modifiers changed, original: protected|final */
    public final int aR() {
        return this.iK + this.mOffsetY;
    }

    public final boolean aS() {
        return this.iR > 0;
    }

    public ArrayList<e> aT() {
        return this.iE;
    }

    public final void setX(int i) {
        this.iJ = i;
    }

    public final void setY(int i) {
        this.iK = i;
    }

    public final void f(int i, int i2) {
        this.iJ = i;
        this.iK = i2;
    }

    public void setOffset(int i, int i2) {
        this.mOffsetX = i;
        this.mOffsetY = i2;
    }

    public void aU() {
        int i = this.iJ;
        int i2 = this.iK;
        int i3 = this.iJ + this.mWidth;
        int i4 = this.iK + this.mHeight;
        this.iN = i;
        this.iO = i2;
        this.iP = i3 - i;
        this.iQ = i4 - i2;
    }

    public final void setWidth(int i) {
        this.mWidth = i;
        if (this.mWidth < this.dg) {
            this.mWidth = this.dg;
        }
    }

    public final void setHeight(int i) {
        this.mHeight = i;
        if (this.mHeight < this.dh) {
            this.mHeight = this.dh;
        }
    }

    public final void B(String str) {
        int i = 0;
        if (str == null || str.length() == 0) {
            this.iH = 0.0f;
            return;
        }
        int i2;
        float parseFloat;
        int length = str.length();
        int indexOf = str.indexOf(44);
        if (indexOf <= 0 || indexOf >= length - 1) {
            indexOf = 0;
            i2 = -1;
        } else {
            String substring = str.substring(0, indexOf);
            if (!substring.equalsIgnoreCase(QLog.TAG_REPORTLEVEL_COLORUSER)) {
                if (substring.equalsIgnoreCase("H")) {
                    i = 1;
                } else {
                    i = -1;
                }
            }
            indexOf++;
            i2 = i;
        }
        i = str.indexOf(58);
        String substring2;
        if (i < 0 || i >= length - 1) {
            substring2 = str.substring(indexOf);
            if (substring2.length() > 0) {
                try {
                    parseFloat = Float.parseFloat(substring2);
                } catch (NumberFormatException e) {
                }
            }
            parseFloat = 0.0f;
        } else {
            String substring3 = str.substring(indexOf, i);
            substring2 = str.substring(i + 1);
            if (substring3.length() > 0 && substring2.length() > 0) {
                try {
                    float parseFloat2 = Float.parseFloat(substring3);
                    parseFloat = Float.parseFloat(substring2);
                    if (parseFloat2 > 0.0f && parseFloat > 0.0f) {
                        parseFloat = i2 == 1 ? Math.abs(parseFloat / parseFloat2) : Math.abs(parseFloat2 / parseFloat);
                    }
                    parseFloat = 0.0f;
                } catch (NumberFormatException e2) {
                }
            }
            parseFloat = 0.0f;
        }
        if (parseFloat > 0.0f) {
            this.iH = parseFloat;
            this.iI = i2;
        }
    }

    public final void setMinWidth(int i) {
        if (i < 0) {
            this.dg = 0;
        } else {
            this.dg = i;
        }
    }

    public final void setMinHeight(int i) {
        if (i < 0) {
            this.dh = 0;
        } else {
            this.dh = i;
        }
    }

    public final void e(int i, int i2, int i3) {
        if (i3 == 0) {
            g(i, i2);
        } else if (i3 == 1) {
            h(i, i2);
        }
        this.je = true;
    }

    public final void g(int i, int i2) {
        this.iJ = i;
        this.mWidth = i2 - i;
        if (this.mWidth < this.dg) {
            this.mWidth = this.dg;
        }
    }

    public final void h(int i, int i2) {
        this.iK = i;
        this.mHeight = i2 - i;
        if (this.mHeight < this.dh) {
            this.mHeight = this.dh;
        }
    }

    /* Access modifiers changed, original: final */
    public final int w(int i) {
        if (i == 0) {
            return this.iL;
        }
        if (i == 1) {
            return this.iM;
        }
        return 0;
    }

    /* Access modifiers changed, original: final */
    public final void i(int i, int i2) {
        if (i2 == 0) {
            this.iL = i;
        } else if (i2 == 1) {
            this.iM = i;
        }
    }

    public boolean aC() {
        return this.iZ != 8;
    }

    public final void a(c cVar, f fVar, c cVar2, int i, int i2) {
        a(cVar).a(fVar.a(cVar2), i, i2, b.STRONG, 0, true);
    }

    public final void aV() {
        int size = this.iE.size();
        for (int i = 0; i < size; i++) {
            ((e) this.iE.get(i)).reset();
        }
    }

    public e a(c cVar) {
        switch (cVar) {
            case LEFT:
                return this.iu;
            case TOP:
                return this.iw;
            case RIGHT:
                return this.ix;
            case BOTTOM:
                return this.iy;
            case BASELINE:
                return this.iz;
            case CENTER:
                return this.iC;
            case CENTER_X:
                return this.iA;
            case CENTER_Y:
                return this.iB;
            case NONE:
                return null;
            default:
                throw new AssertionError(cVar.name());
        }
    }

    public final a aW() {
        return this.iF[0];
    }

    public final a aX() {
        return this.iF[1];
    }

    public final a x(int i) {
        if (i == 0) {
            return this.iF[0];
        }
        return i == 1 ? this.iF[1] : null;
    }

    public final void a(a aVar) {
        this.iF[0] = aVar;
        if (aVar == a.WRAP_CONTENT) {
            setWidth(this.iS);
        }
    }

    public final void b(a aVar) {
        this.iF[1] = aVar;
        if (aVar == a.WRAP_CONTENT) {
            setHeight(this.iT);
        }
    }

    private boolean y(int i) {
        int i2 = i * 2;
        return (this.iD[i2].hy == null || this.iD[i2].hy.hy == this.iD[i2] || this.iD[i2 + 1].hy == null || this.iD[i2 + 1].hy.hy != this.iD[i2 + 1]) ? false : true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:127:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x029e  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x04a6  */
    /* JADX WARNING: Removed duplicated region for block: B:252:? A:{SYNTHETIC, RETURN, ORIG_RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x029e  */
    /* JADX WARNING: Removed duplicated region for block: B:252:? A:{SYNTHETIC, RETURN, ORIG_RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x04a6  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x029e  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x04a6  */
    /* JADX WARNING: Removed duplicated region for block: B:252:? A:{SYNTHETIC, RETURN, ORIG_RETURN} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(e eVar) {
        int i;
        int i2;
        Object obj;
        int i3;
        int i4;
        boolean z;
        boolean z2;
        boolean z3;
        h g = eVar.g(this.iu);
        h g2 = eVar.g(this.ix);
        h g3 = eVar.g(this.iw);
        h g4 = eVar.g(this.iy);
        h g5 = eVar.g(this.iz);
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        if (this.iG != null) {
            z6 = this.iG != null ? this.iG.iF[0] == a.WRAP_CONTENT : false;
            z7 = this.iG != null ? this.iG.iF[1] == a.WRAP_CONTENT : false;
            if (y(0)) {
                ((g) this.iG).b(this, 0);
                z4 = true;
            } else if ((this.iu.hy == null || this.iu.hy.hy != this.iu) && (this.ix.hy == null || this.ix.hy.hy != this.ix)) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (y(1)) {
                ((g) this.iG).b(this, 1);
                z5 = true;
            } else if ((this.iw.hy == null || this.iw.hy.hy != this.iw) && (this.iy.hy == null || this.iy.hy.hy != this.iy)) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (z6 && this.iZ != 8 && this.iu.hy == null && this.ix.hy == null) {
                eVar.a(eVar.g(this.iG.ix), g2, 0, 1);
            }
            if (z7 && this.iZ != 8 && this.iw.hy == null && this.iy.hy == null && this.iz == null) {
                eVar.a(eVar.g(this.iG.iy), g4, 0, 1);
            }
        }
        boolean z8 = z7;
        boolean z9 = z6;
        boolean z10 = z5;
        boolean z11 = z4;
        int i5 = this.mWidth;
        if (i5 < this.dg) {
            i5 = this.dg;
        }
        int i6 = this.mHeight;
        if (i6 < this.dh) {
            i6 = this.dh;
        }
        Object obj2 = this.iF[0] != a.MATCH_CONSTRAINT ? 1 : null;
        Object obj3 = this.iF[1] != a.MATCH_CONSTRAINT ? 1 : null;
        Object obj4 = null;
        this.io = this.iI;
        this.iq = this.iH;
        int i7 = this.ib;
        int i8 = this.ic;
        if (this.iH > 0.0f && this.iZ != 8) {
            obj4 = 1;
            if (this.iF[0] == a.MATCH_CONSTRAINT && i7 == 0) {
                i7 = 3;
            }
            if (this.iF[1] == a.MATCH_CONSTRAINT && i8 == 0) {
                i8 = 3;
            }
            int obj5;
            if (this.iF[0] == a.MATCH_CONSTRAINT && this.iF[1] == a.MATCH_CONSTRAINT && i7 == 3 && i8 == 3) {
                if (this.io == -1) {
                    if (obj2 != null && obj3 == null) {
                        this.io = 0;
                    } else if (obj2 == null && obj3 != null) {
                        this.io = 1;
                        if (this.iI == -1) {
                            this.iq = 1.0f / this.iq;
                        }
                    }
                }
                if (this.io == 0 && (!this.iw.isConnected() || !this.iy.isConnected())) {
                    this.io = 1;
                } else if (this.io == 1 && !(this.iu.isConnected() && this.ix.isConnected())) {
                    this.io = 0;
                }
                if (this.io == -1 && !(this.iw.isConnected() && this.iy.isConnected() && this.iu.isConnected() && this.ix.isConnected())) {
                    if (this.iw.isConnected() && this.iy.isConnected()) {
                        this.io = 0;
                    } else if (this.iu.isConnected() && this.ix.isConnected()) {
                        this.iq = 1.0f / this.iq;
                        this.io = 1;
                    }
                }
                if (this.io == -1) {
                    if (z9 && !z8) {
                        this.io = 0;
                    } else if (!z9 && z8) {
                        this.iq = 1.0f / this.iq;
                        this.io = 1;
                    }
                }
                if (this.io == -1) {
                    if (this.f3if > 0 && this.ii == 0) {
                        this.io = 0;
                    } else if (this.f3if == 0 && this.ii > 0) {
                        this.iq = 1.0f / this.iq;
                        this.io = 1;
                    }
                }
                if (this.io == -1 && z9 && z8) {
                    this.iq = 1.0f / this.iq;
                    this.io = 1;
                }
                i = i8;
                i2 = i7;
                obj5 = 1;
                i3 = i6;
                i4 = i5;
                this.ie[0] = i2;
                this.ie[1] = i;
                if (obj5 == null) {
                }
                if (this.iF[0] != a.WRAP_CONTENT) {
                }
                z3 = true;
                if (this.iC.isConnected()) {
                }
                if (this.hX != 2) {
                }
                if (this.hY == 2) {
                }
            } else if (this.iF[0] == a.MATCH_CONSTRAINT && i7 == 3) {
                this.io = 0;
                i4 = (int) (this.iq * ((float) this.mHeight));
                if (this.iF[1] != a.MATCH_CONSTRAINT) {
                    i = i8;
                    i2 = 4;
                    obj5 = null;
                    i3 = i6;
                } else {
                    i = i8;
                    i2 = i7;
                    obj5 = 1;
                    i3 = i6;
                }
                this.ie[0] = i2;
                this.ie[1] = i;
                if (obj5 == null) {
                }
                if (this.iF[0] != a.WRAP_CONTENT) {
                }
                z3 = true;
                if (this.iC.isConnected()) {
                }
                if (this.hX != 2) {
                }
                if (this.hY == 2) {
                }
            } else if (this.iF[1] == a.MATCH_CONSTRAINT && i8 == 3) {
                this.io = 1;
                if (this.iI == -1) {
                    this.iq = 1.0f / this.iq;
                }
                int i9 = (int) (this.iq * ((float) this.mWidth));
                if (this.iF[0] != a.MATCH_CONSTRAINT) {
                    i = 4;
                    i2 = i7;
                    obj5 = null;
                    i3 = i9;
                    i4 = i5;
                } else {
                    i = i8;
                    i2 = i7;
                    obj5 = 1;
                    i3 = i9;
                    i4 = i5;
                }
                this.ie[0] = i2;
                this.ie[1] = i;
                z = obj5 == null && (this.io == 0 || this.io == -1);
                z2 = this.iF[0] != a.WRAP_CONTENT && (this instanceof g);
                z3 = true;
                if (this.iC.isConnected()) {
                    z3 = false;
                }
                if (this.hX != 2) {
                    a(eVar, z9, this.iG != null ? eVar.g(this.iG.iu) : null, this.iG != null ? eVar.g(this.iG.ix) : null, this.iF[0], z2, this.iu, this.ix, this.iJ, i4, this.dg, this.is[0], this.iV, z, z11, i2, this.f3if, this.ig, this.ih, z3);
                }
                if (this.hY == 2) {
                    z2 = this.iF[1] == a.WRAP_CONTENT && (this instanceof g);
                    z = obj5 != null && (this.io == 1 || this.io == -1);
                    if (this.iR > 0) {
                        if (this.iz.hv.state == 1) {
                            this.iz.hv.c(eVar);
                        } else {
                            eVar.c(g5, g3, this.iR, 6);
                            if (this.iz.hy != null) {
                                eVar.c(g5, eVar.g(this.iz.hy), 0, 6);
                                z3 = false;
                            }
                        }
                    }
                    a(eVar, z8, this.iG != null ? eVar.g(this.iG.iw) : null, this.iG != null ? eVar.g(this.iG.iy) : null, this.iF[1], z2, this.iw, this.iy, this.iK, i3, this.dh, this.is[1], this.iW, z, z10, i, this.ii, this.ij, this.ik, z3);
                    if (obj5 != null) {
                        if (this.io == 1) {
                            eVar.c(g4, g3, g2, g, this.iq);
                        } else {
                            eVar.c(g2, g, g4, g3, this.iq);
                        }
                    }
                    if (this.iC.isConnected()) {
                        f fVar = this.iC.hy.hw;
                        float toRadians = (float) Math.toRadians((double) (this.it + 90.0f));
                        int aH = this.iC.aH();
                        h g6 = eVar.g(a(c.LEFT));
                        h g7 = eVar.g(a(c.TOP));
                        h g8 = eVar.g(a(c.RIGHT));
                        h g9 = eVar.g(a(c.BOTTOM));
                        h g10 = eVar.g(fVar.a(c.LEFT));
                        h g11 = eVar.g(fVar.a(c.TOP));
                        h g12 = eVar.g(fVar.a(c.RIGHT));
                        h g13 = eVar.g(fVar.a(c.BOTTOM));
                        android.support.constraint.a.b ax = eVar.ax();
                        ax.b(g7, g9, g11, g13, (float) (Math.sin((double) toRadians) * ((double) aH)));
                        eVar.b(ax);
                        ax = eVar.ax();
                        ax.b(g6, g8, g10, g12, (float) (Math.cos((double) toRadians) * ((double) aH)));
                        eVar.b(ax);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        i = i8;
        i2 = i7;
        obj5 = obj4;
        i3 = i6;
        i4 = i5;
        this.ie[0] = i2;
        this.ie[1] = i;
        if (obj5 == null) {
        }
        if (this.iF[0] != a.WRAP_CONTENT) {
        }
        z3 = true;
        if (this.iC.isConnected()) {
        }
        if (this.hX != 2) {
        }
        if (this.hY == 2) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:133:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02db  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(e eVar, boolean z, h hVar, h hVar2, a aVar, boolean z2, e eVar2, e eVar3, int i, int i2, int i3, int i4, float f, boolean z3, boolean z4, int i5, int i6, int i7, float f2, boolean z5) {
        h g = eVar.g(eVar2);
        h g2 = eVar.g(eVar3);
        h g3 = eVar.g(eVar2.hy);
        h g4 = eVar.g(eVar3.hy);
        android.support.constraint.a.f au;
        if (eVar.fU && eVar2.hv.state == 1 && eVar3.hv.state == 1) {
            if (e.au() != null) {
                au = e.au();
                au.gv++;
            }
            eVar2.hv.c(eVar);
            eVar3.hv.c(eVar);
            if (!z4 && z) {
                eVar.a(hVar2, g2, 0, 6);
                return;
            }
            return;
        }
        int i8;
        int max;
        Object obj;
        if (e.au() != null) {
            au = e.au();
            au.gE++;
        }
        boolean isConnected = eVar2.isConnected();
        boolean isConnected2 = eVar3.isConnected();
        boolean isConnected3 = this.iC.isConnected();
        Object obj2 = null;
        int i9 = 0;
        if (isConnected) {
            i9 = 1;
        }
        if (isConnected2) {
            i9++;
        }
        if (isConnected3) {
            i8 = i9 + 1;
        } else {
            i8 = i9;
        }
        if (z3) {
            i5 = 3;
        }
        switch (aVar) {
            case FIXED:
                obj2 = null;
                break;
            case WRAP_CONTENT:
                obj2 = null;
                break;
            case MATCH_PARENT:
                obj2 = null;
                break;
            case MATCH_CONSTRAINT:
                obj2 = 1;
                if (i5 == 4) {
                    obj2 = null;
                    break;
                }
                break;
        }
        if (this.iZ == 8) {
            i9 = 0;
            obj2 = null;
        } else {
            i9 = i2;
        }
        if (z5) {
            if (!isConnected && !isConnected2 && !isConnected3) {
                eVar.a(g, i);
            } else if (isConnected && !isConnected2) {
                eVar.c(g, g3, eVar2.aH(), 6);
            }
        }
        if (obj2 != null) {
            int min;
            if (i6 == -2) {
                i6 = i9;
            }
            if (i7 == -2) {
                i7 = i9;
            }
            if (i6 > 0) {
                eVar.a(g2, g, i6, 6);
                i9 = Math.max(i9, i6);
            }
            if (i7 > 0) {
                eVar.b(g2, g, i7, 6);
                min = Math.min(i9, i7);
            } else {
                min = i9;
            }
            if (i5 == 1) {
                if (z) {
                    eVar.c(g2, g, min, 6);
                } else if (z4) {
                    eVar.c(g2, g, min, 4);
                } else {
                    eVar.c(g2, g, min, 1);
                }
            } else if (i5 == 2) {
                h g5;
                h g6;
                if (eVar2.hx == c.TOP || eVar2.hx == c.BOTTOM) {
                    g5 = eVar.g(this.iG.a(c.TOP));
                    g6 = eVar.g(this.iG.a(c.BOTTOM));
                } else {
                    g5 = eVar.g(this.iG.a(c.LEFT));
                    g6 = eVar.g(this.iG.a(c.RIGHT));
                }
                eVar.b(eVar.ax().a(g2, g, g6, g5, f2));
                obj2 = null;
            }
            if (!(obj2 == null || i8 == 2 || z3)) {
                max = Math.max(i6, min);
                if (i7 > 0) {
                    max = Math.min(i7, max);
                }
                eVar.c(g2, g, max, 6);
                obj = null;
            }
            obj = obj2;
        } else if (z2) {
            eVar.c(g2, g, 0, 3);
            if (i3 > 0) {
                eVar.a(g2, g, i3, 6);
            }
            if (i4 < Integer.MAX_VALUE) {
                eVar.b(g2, g, i4, 6);
                obj = obj2;
            }
            obj = obj2;
        } else {
            eVar.c(g2, g, i9, 6);
            obj = obj2;
        }
        if (z5 && !z4) {
            if (isConnected || isConnected2 || isConnected3) {
                if (!isConnected || isConnected2) {
                    if (!isConnected && isConnected2) {
                        eVar.c(g2, g4, -eVar3.aH(), 6);
                        if (z) {
                            eVar.a(g, hVar, 0, 5);
                        }
                    } else if (isConnected && isConnected2) {
                        Object obj3;
                        boolean z6;
                        boolean z7;
                        Object obj4 = null;
                        Object obj5 = null;
                        int i10 = 5;
                        int obj52;
                        if (obj != null) {
                            if (z && i3 == 0) {
                                eVar.a(g2, g, 0, 6);
                            }
                            int obj32;
                            if (i5 == 0) {
                                max = 6;
                                if (i7 > 0 || i6 > 0) {
                                    max = 4;
                                    obj4 = 1;
                                }
                                eVar.c(g, g3, eVar2.aH(), max);
                                eVar.c(g2, g4, -eVar3.aH(), max);
                                if (i7 > 0 || i6 > 0) {
                                    obj2 = 1;
                                } else {
                                    obj2 = null;
                                }
                                obj52 = obj2;
                                obj32 = obj4;
                            } else if (i5 == 1) {
                                i10 = 6;
                                obj52 = 1;
                                obj32 = 1;
                            } else if (i5 == 3) {
                                obj52 = 1;
                                max = 4;
                                if (!(z3 || this.io == -1 || i7 > 0)) {
                                    max = 6;
                                }
                                eVar.c(g, g3, eVar2.aH(), max);
                                eVar.c(g2, g4, -eVar3.aH(), max);
                                obj32 = 1;
                            } else {
                                obj32 = null;
                            }
                        } else {
                            obj52 = 1;
                            obj32 = null;
                        }
                        max = 5;
                        if (obj52 != null) {
                            eVar.a(g, g3, eVar2.aH(), f, g4, g2, eVar3.aH(), i10);
                            boolean z8 = eVar2.hy.hw instanceof b;
                            z6 = eVar3.hy.hw instanceof b;
                            if (z8 && !z6) {
                                max = 6;
                                z6 = true;
                                z7 = z;
                                i9 = 5;
                                if (obj32 != null) {
                                }
                                eVar.a(g, g3, eVar2.aH(), i9);
                                eVar.b(g2, g4, -eVar3.aH(), max);
                                if (z) {
                                }
                            } else if (!z8 && z6) {
                                i9 = 6;
                                z7 = true;
                                z6 = z;
                                if (obj32 != null) {
                                    i9 = 6;
                                    max = 6;
                                }
                                if ((obj == null && z7) || obj32 != null) {
                                    eVar.a(g, g3, eVar2.aH(), i9);
                                }
                                if ((obj == null && r6) || obj32 != null) {
                                    eVar.b(g2, g4, -eVar3.aH(), max);
                                }
                                if (z) {
                                    eVar.a(g, hVar, 0, 6);
                                }
                            }
                        }
                        z6 = z;
                        z7 = z;
                        i9 = 5;
                        if (obj32 != null) {
                        }
                        eVar.a(g, g3, eVar2.aH(), i9);
                        eVar.b(g2, g4, -eVar3.aH(), max);
                        if (z) {
                        }
                    }
                } else if (z) {
                    eVar.a(hVar2, g2, 0, 5);
                }
            } else if (z) {
                eVar.a(hVar2, g2, 0, 5);
            }
            if (z) {
                eVar.a(hVar2, g2, 0, 6);
            }
        } else if (i8 < 2 && z) {
            eVar.a(g, hVar, 0, 6);
            eVar.a(hVar2, g2, 0, 6);
        }
    }

    public void aY() {
        int h = e.h(this.iu);
        int h2 = e.h(this.iw);
        int h3 = e.h(this.ix);
        int h4 = e.h(this.iy);
        int i = h4 - h2;
        if (h3 - h < 0 || i < 0 || h == j.INVALID_ID || h == BaseClientBuilder.API_PRIORITY_OTHER || h2 == j.INVALID_ID || h2 == BaseClientBuilder.API_PRIORITY_OTHER || h3 == j.INVALID_ID || h3 == BaseClientBuilder.API_PRIORITY_OTHER || h4 == j.INVALID_ID || h4 == BaseClientBuilder.API_PRIORITY_OTHER) {
            h4 = 0;
            h3 = 0;
            h2 = 0;
            h = 0;
        }
        h3 -= h;
        int i2 = h4 - h2;
        this.iJ = h;
        this.iK = h2;
        if (this.iZ == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        int i3;
        if (this.iF[0] != a.FIXED || h3 >= this.mWidth) {
            h4 = h3;
        } else {
            h4 = this.mWidth;
        }
        if (this.iF[1] != a.FIXED || i2 >= this.mHeight) {
            i3 = i2;
        } else {
            i3 = this.mHeight;
        }
        this.mWidth = h4;
        this.mHeight = i3;
        if (this.mHeight < this.dh) {
            this.mHeight = this.dh;
        }
        if (this.mWidth < this.dg) {
            this.mWidth = this.dg;
        }
        this.je = true;
    }

    public final int getRight() {
        return this.iJ + this.mWidth;
    }

    public final int getBottom() {
        return this.iK + this.mHeight;
    }
}
