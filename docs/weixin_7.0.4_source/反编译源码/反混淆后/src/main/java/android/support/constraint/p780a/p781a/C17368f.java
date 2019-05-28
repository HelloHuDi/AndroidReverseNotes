package android.support.constraint.p780a.p781a;

import android.support.constraint.p780a.C17375c;
import android.support.constraint.p780a.C17377e;
import android.support.constraint.p780a.C36667b;
import android.support.constraint.p780a.C41477f;
import android.support.constraint.p780a.C41479h;
import android.support.constraint.p780a.p781a.C25284e.C25285b;
import android.support.constraint.p780a.p781a.C25284e.C25287c;
import android.support.p057v4.widget.C8415j;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.ArrayList;

/* renamed from: android.support.constraint.a.a.f */
public class C17368f {
    /* renamed from: iU */
    public static float f3608iU = 0.5f;
    /* renamed from: dg */
    protected int f3609dg;
    /* renamed from: dh */
    protected int f3610dh;
    /* renamed from: hX */
    public int f3611hX = -1;
    /* renamed from: hY */
    public int f3612hY = -1;
    /* renamed from: hZ */
    C17372n f3613hZ;
    /* renamed from: iA */
    C25284e f3614iA = new C25284e(this, C25287c.CENTER_X);
    /* renamed from: iB */
    C25284e f3615iB = new C25284e(this, C25287c.CENTER_Y);
    /* renamed from: iC */
    C25284e f3616iC = new C25284e(this, C25287c.CENTER);
    /* renamed from: iD */
    protected C25284e[] f3617iD = new C25284e[]{this.f3656iu, this.f3658ix, this.f3657iw, this.f3659iy, this.f3660iz, this.f3616iC};
    /* renamed from: iE */
    protected ArrayList<C25284e> f3618iE = new ArrayList();
    /* renamed from: iF */
    protected C17370a[] f3619iF = new C17370a[]{C17370a.FIXED, C17370a.FIXED};
    /* renamed from: iG */
    C17368f f3620iG = null;
    /* renamed from: iH */
    protected float f3621iH = 0.0f;
    /* renamed from: iI */
    protected int f3622iI = -1;
    /* renamed from: iJ */
    protected int f3623iJ = 0;
    /* renamed from: iK */
    protected int f3624iK = 0;
    /* renamed from: iL */
    int f3625iL = 0;
    /* renamed from: iM */
    int f3626iM = 0;
    /* renamed from: iN */
    private int f3627iN = 0;
    /* renamed from: iO */
    private int f3628iO = 0;
    /* renamed from: iP */
    private int f3629iP = 0;
    /* renamed from: iQ */
    private int f3630iQ = 0;
    /* renamed from: iR */
    public int f3631iR = 0;
    /* renamed from: iS */
    public int f3632iS;
    /* renamed from: iT */
    public int f3633iT;
    /* renamed from: iV */
    public float f3634iV = f3608iU;
    /* renamed from: iW */
    public float f3635iW = f3608iU;
    /* renamed from: iX */
    public Object f3636iX;
    /* renamed from: iY */
    private int f3637iY = 0;
    /* renamed from: iZ */
    public int f3638iZ = 0;
    /* renamed from: ia */
    C17372n f3639ia;
    /* renamed from: ib */
    public int f3640ib = 0;
    /* renamed from: ic */
    public int f3641ic = 0;
    /* renamed from: ie */
    int[] f3642ie = new int[2];
    /* renamed from: if */
    public int f3643if = 0;
    /* renamed from: ig */
    public int f3644ig = 0;
    /* renamed from: ih */
    public float f3645ih = 1.0f;
    /* renamed from: ii */
    public int f3646ii = 0;
    /* renamed from: ij */
    public int f3647ij = 0;
    /* renamed from: ik */
    public float f3648ik = 1.0f;
    /* renamed from: il */
    public boolean f3649il;
    /* renamed from: im */
    public boolean f3650im;
    /* renamed from: io */
    int f3651io = -1;
    /* renamed from: iq */
    float f3652iq = 1.0f;
    /* renamed from: ir */
    C17371h f3653ir = null;
    /* renamed from: is */
    public int[] f3654is = new int[]{BaseClientBuilder.API_PRIORITY_OTHER, BaseClientBuilder.API_PRIORITY_OTHER};
    /* renamed from: it */
    public float f3655it = 0.0f;
    /* renamed from: iu */
    C25284e f3656iu = new C25284e(this, C25287c.LEFT);
    /* renamed from: iw */
    C25284e f3657iw = new C25284e(this, C25287c.TOP);
    /* renamed from: ix */
    C25284e f3658ix = new C25284e(this, C25287c.RIGHT);
    /* renamed from: iy */
    C25284e f3659iy = new C25284e(this, C25287c.BOTTOM);
    /* renamed from: iz */
    C25284e f3660iz = new C25284e(this, C25287c.BASELINE);
    /* renamed from: ja */
    public String f3661ja = null;
    /* renamed from: jb */
    boolean f3662jb;
    /* renamed from: jc */
    boolean f3663jc;
    /* renamed from: jd */
    boolean f3664jd = false;
    /* renamed from: je */
    boolean f3665je = false;
    /* renamed from: jf */
    boolean f3666jf = false;
    /* renamed from: jg */
    public int f3667jg = 0;
    /* renamed from: jh */
    public int f3668jh = 0;
    /* renamed from: ji */
    boolean f3669ji;
    /* renamed from: jj */
    boolean f3670jj;
    /* renamed from: jk */
    public float[] f3671jk = new float[]{-1.0f, -1.0f};
    /* renamed from: jl */
    protected C17368f[] f3672jl = new C17368f[]{null, null};
    /* renamed from: jm */
    protected C17368f[] f3673jm = new C17368f[]{null, null};
    /* renamed from: jn */
    C17368f f3674jn = null;
    /* renamed from: jo */
    C17368f f3675jo = null;
    int mHeight = 0;
    protected int mOffsetX = 0;
    protected int mOffsetY = 0;
    private String mType = null;
    int mWidth = 0;

    /* renamed from: android.support.constraint.a.a.f$a */
    public enum C17370a {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    /* renamed from: aI */
    public final boolean mo31453aI() {
        return this.f3640ib == 0 && this.f3621iH == 0.0f && this.f3643if == 0 && this.f3644ig == 0 && this.f3619iF[0] == C17370a.MATCH_CONSTRAINT;
    }

    /* renamed from: aJ */
    public final boolean mo31454aJ() {
        return this.f3641ic == 0 && this.f3621iH == 0.0f && this.f3646ii == 0 && this.f3647ij == 0 && this.f3619iF[1] == C17370a.MATCH_CONSTRAINT;
    }

    public void reset() {
        this.f3656iu.reset();
        this.f3657iw.reset();
        this.f3658ix.reset();
        this.f3659iy.reset();
        this.f3660iz.reset();
        this.f3614iA.reset();
        this.f3615iB.reset();
        this.f3616iC.reset();
        this.f3620iG = null;
        this.f3655it = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.f3621iH = 0.0f;
        this.f3622iI = -1;
        this.f3623iJ = 0;
        this.f3624iK = 0;
        this.f3627iN = 0;
        this.f3628iO = 0;
        this.f3629iP = 0;
        this.f3630iQ = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.f3631iR = 0;
        this.f3609dg = 0;
        this.f3610dh = 0;
        this.f3632iS = 0;
        this.f3633iT = 0;
        this.f3634iV = f3608iU;
        this.f3635iW = f3608iU;
        this.f3619iF[0] = C17370a.FIXED;
        this.f3619iF[1] = C17370a.FIXED;
        this.f3636iX = null;
        this.f3637iY = 0;
        this.f3638iZ = 0;
        this.mType = null;
        this.f3662jb = false;
        this.f3663jc = false;
        this.f3667jg = 0;
        this.f3668jh = 0;
        this.f3669ji = false;
        this.f3670jj = false;
        this.f3671jk[0] = -1.0f;
        this.f3671jk[1] = -1.0f;
        this.f3611hX = -1;
        this.f3612hY = -1;
        this.f3654is[0] = BaseClientBuilder.API_PRIORITY_OTHER;
        this.f3654is[1] = BaseClientBuilder.API_PRIORITY_OTHER;
        this.f3640ib = 0;
        this.f3641ic = 0;
        this.f3645ih = 1.0f;
        this.f3648ik = 1.0f;
        this.f3644ig = BaseClientBuilder.API_PRIORITY_OTHER;
        this.f3647ij = BaseClientBuilder.API_PRIORITY_OTHER;
        this.f3643if = 0;
        this.f3646ii = 0;
        this.f3651io = -1;
        this.f3652iq = 1.0f;
        if (this.f3613hZ != null) {
            this.f3613hZ.reset();
        }
        if (this.f3639ia != null) {
            this.f3639ia.reset();
        }
        this.f3653ir = null;
        this.f3664jd = false;
        this.f3665je = false;
        this.f3666jf = false;
    }

    /* renamed from: aD */
    public void mo31451aD() {
        for (int i = 0; i < 6; i++) {
            this.f3617iD[i].f5029hv.reset();
        }
    }

    /* renamed from: aK */
    public final void mo31455aK() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 6) {
                C41476m c41476m = this.f3617iD[i2].f5029hv;
                C25284e c25284e = c41476m.f16639kj.f5032hy;
                if (c25284e != null) {
                    if (c25284e.f5032hy == c41476m.f16639kj) {
                        c41476m.type = 4;
                        c25284e.f5029hv.type = 4;
                    }
                    i = c41476m.f16639kj.mo42138aH();
                    if (c41476m.f16639kj.f5031hx == C25287c.RIGHT || c41476m.f16639kj.f5031hx == C25287c.BOTTOM) {
                        i = -i;
                    }
                    c41476m.mo66151b(c25284e.f5029hv, i);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: u */
    public void mo31492u(int i) {
        C41474k.m72389a(i, this);
    }

    /* renamed from: aE */
    public void mo31452aE() {
    }

    /* renamed from: aL */
    public final boolean mo31456aL() {
        if (this.f3656iu.f5029hv.state == 1 && this.f3658ix.f5029hv.state == 1 && this.f3657iw.f5029hv.state == 1 && this.f3659iy.f5029hv.state == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: aM */
    public final C17372n mo31457aM() {
        if (this.f3613hZ == null) {
            this.f3613hZ = new C17372n();
        }
        return this.f3613hZ;
    }

    /* renamed from: aN */
    public final C17372n mo31458aN() {
        if (this.f3639ia == null) {
            this.f3639ia = new C17372n();
        }
        return this.f3639ia;
    }

    public C17368f() {
        this.f3618iE.add(this.f3656iu);
        this.f3618iE.add(this.f3657iw);
        this.f3618iE.add(this.f3658ix);
        this.f3618iE.add(this.f3659iy);
        this.f3618iE.add(this.f3614iA);
        this.f3618iE.add(this.f3615iB);
        this.f3618iE.add(this.f3616iC);
        this.f3618iE.add(this.f3660iz);
    }

    /* renamed from: a */
    public void mo31448a(C17375c c17375c) {
        this.f3656iu.mo42137aG();
        this.f3657iw.mo42137aG();
        this.f3658ix.mo42137aG();
        this.f3659iy.mo42137aG();
        this.f3660iz.mo42137aG();
        this.f3616iC.mo42137aG();
        this.f3614iA.mo42137aG();
        this.f3615iB.mo42137aG();
    }

    /* renamed from: b */
    public final void mo31471b(C17377e c17377e) {
        c17377e.mo31526g(this.f3656iu);
        c17377e.mo31526g(this.f3657iw);
        c17377e.mo31526g(this.f3658ix);
        c17377e.mo31526g(this.f3659iy);
        if (this.f3631iR > 0) {
            c17377e.mo31526g(this.f3660iz);
        }
    }

    public String toString() {
        return (this.mType != null ? "type: " + this.mType + " " : "") + (this.f3661ja != null ? "id: " + this.f3661ja + " " : "") + "(" + this.f3623iJ + ", " + this.f3624iK + ") - (" + this.mWidth + " x " + this.mHeight + ") wrap: (" + this.f3632iS + " x " + this.f3633iT + ")";
    }

    public final int getX() {
        return this.f3623iJ;
    }

    public final int getY() {
        return this.f3624iK;
    }

    public final int getWidth() {
        if (this.f3638iZ == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public final int getHeight() {
        if (this.f3638iZ == 8) {
            return 0;
        }
        return this.mHeight;
    }

    /* renamed from: v */
    public final int mo31493v(int i) {
        if (i == 0) {
            return getWidth();
        }
        if (i == 1) {
            return getHeight();
        }
        return 0;
    }

    /* renamed from: aO */
    public final int mo31459aO() {
        return this.f3627iN + this.mOffsetX;
    }

    /* renamed from: aP */
    public final int mo31460aP() {
        return this.f3628iO + this.mOffsetY;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: aQ */
    public final int mo31461aQ() {
        return this.f3623iJ + this.mOffsetX;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: aR */
    public final int mo31462aR() {
        return this.f3624iK + this.mOffsetY;
    }

    /* renamed from: aS */
    public final boolean mo31463aS() {
        return this.f3631iR > 0;
    }

    /* renamed from: aT */
    public ArrayList<C25284e> mo31464aT() {
        return this.f3618iE;
    }

    public final void setX(int i) {
        this.f3623iJ = i;
    }

    public final void setY(int i) {
        this.f3624iK = i;
    }

    /* renamed from: f */
    public final void mo31473f(int i, int i2) {
        this.f3623iJ = i;
        this.f3624iK = i2;
    }

    public void setOffset(int i, int i2) {
        this.mOffsetX = i;
        this.mOffsetY = i2;
    }

    /* renamed from: aU */
    public void mo31465aU() {
        int i = this.f3623iJ;
        int i2 = this.f3624iK;
        int i3 = this.f3623iJ + this.mWidth;
        int i4 = this.f3624iK + this.mHeight;
        this.f3627iN = i;
        this.f3628iO = i2;
        this.f3629iP = i3 - i;
        this.f3630iQ = i4 - i2;
    }

    public final void setWidth(int i) {
        this.mWidth = i;
        if (this.mWidth < this.f3609dg) {
            this.mWidth = this.f3609dg;
        }
    }

    public final void setHeight(int i) {
        this.mHeight = i;
        if (this.mHeight < this.f3610dh) {
            this.mHeight = this.f3610dh;
        }
    }

    /* renamed from: B */
    public final void mo31444B(String str) {
        int i = 0;
        if (str == null || str.length() == 0) {
            this.f3621iH = 0.0f;
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
            this.f3621iH = parseFloat;
            this.f3622iI = i2;
        }
    }

    public final void setMinWidth(int i) {
        if (i < 0) {
            this.f3609dg = 0;
        } else {
            this.f3609dg = i;
        }
    }

    public final void setMinHeight(int i) {
        if (i < 0) {
            this.f3610dh = 0;
        } else {
            this.f3610dh = i;
        }
    }

    /* renamed from: e */
    public final void mo31472e(int i, int i2, int i3) {
        if (i3 == 0) {
            mo31474g(i, i2);
        } else if (i3 == 1) {
            mo31481h(i, i2);
        }
        this.f3665je = true;
    }

    /* renamed from: g */
    public final void mo31474g(int i, int i2) {
        this.f3623iJ = i;
        this.mWidth = i2 - i;
        if (this.mWidth < this.f3609dg) {
            this.mWidth = this.f3609dg;
        }
    }

    /* renamed from: h */
    public final void mo31481h(int i, int i2) {
        this.f3624iK = i;
        this.mHeight = i2 - i;
        if (this.mHeight < this.f3610dh) {
            this.mHeight = this.f3610dh;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: w */
    public final int mo31494w(int i) {
        if (i == 0) {
            return this.f3625iL;
        }
        if (i == 1) {
            return this.f3626iM;
        }
        return 0;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: i */
    public final void mo31482i(int i, int i2) {
        if (i2 == 0) {
            this.f3625iL = i;
        } else if (i2 == 1) {
            this.f3626iM = i;
        }
    }

    /* renamed from: aC */
    public boolean mo31450aC() {
        return this.f3638iZ != 8;
    }

    /* renamed from: a */
    public final void mo31446a(C25287c c25287c, C17368f c17368f, C25287c c25287c2, int i, int i2) {
        mo31445a(c25287c).mo42136a(c17368f.mo31445a(c25287c2), i, i2, C25285b.STRONG, 0, true);
    }

    /* renamed from: aV */
    public final void mo31466aV() {
        int size = this.f3618iE.size();
        for (int i = 0; i < size; i++) {
            ((C25284e) this.f3618iE.get(i)).reset();
        }
    }

    /* renamed from: a */
    public C25284e mo31445a(C25287c c25287c) {
        switch (c25287c) {
            case LEFT:
                return this.f3656iu;
            case TOP:
                return this.f3657iw;
            case RIGHT:
                return this.f3658ix;
            case BOTTOM:
                return this.f3659iy;
            case BASELINE:
                return this.f3660iz;
            case CENTER:
                return this.f3616iC;
            case CENTER_X:
                return this.f3614iA;
            case CENTER_Y:
                return this.f3615iB;
            case NONE:
                return null;
            default:
                throw new AssertionError(c25287c.name());
        }
    }

    /* renamed from: aW */
    public final C17370a mo31467aW() {
        return this.f3619iF[0];
    }

    /* renamed from: aX */
    public final C17370a mo31468aX() {
        return this.f3619iF[1];
    }

    /* renamed from: x */
    public final C17370a mo31495x(int i) {
        if (i == 0) {
            return this.f3619iF[0];
        }
        return i == 1 ? this.f3619iF[1] : null;
    }

    /* renamed from: a */
    public final void mo31447a(C17370a c17370a) {
        this.f3619iF[0] = c17370a;
        if (c17370a == C17370a.WRAP_CONTENT) {
            setWidth(this.f3632iS);
        }
    }

    /* renamed from: b */
    public final void mo31470b(C17370a c17370a) {
        this.f3619iF[1] = c17370a;
        if (c17370a == C17370a.WRAP_CONTENT) {
            setHeight(this.f3633iT);
        }
    }

    /* renamed from: y */
    private boolean m26877y(int i) {
        int i2 = i * 2;
        return (this.f3617iD[i2].f5032hy == null || this.f3617iD[i2].f5032hy.f5032hy == this.f3617iD[i2] || this.f3617iD[i2 + 1].f5032hy == null || this.f3617iD[i2 + 1].f5032hy.f5032hy != this.f3617iD[i2 + 1]) ? false : true;
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
    /* renamed from: a */
    public void mo31449a(C17377e c17377e) {
        int i;
        int i2;
        Object obj;
        int i3;
        int i4;
        boolean z;
        boolean z2;
        boolean z3;
        C41479h g = c17377e.mo31526g(this.f3656iu);
        C41479h g2 = c17377e.mo31526g(this.f3658ix);
        C41479h g3 = c17377e.mo31526g(this.f3657iw);
        C41479h g4 = c17377e.mo31526g(this.f3659iy);
        C41479h g5 = c17377e.mo31526g(this.f3660iz);
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        if (this.f3620iG != null) {
            z6 = this.f3620iG != null ? this.f3620iG.f3619iF[0] == C17370a.WRAP_CONTENT : false;
            z7 = this.f3620iG != null ? this.f3620iG.f3619iF[1] == C17370a.WRAP_CONTENT : false;
            if (m26877y(0)) {
                ((C31242g) this.f3620iG).mo51195b(this, 0);
                z4 = true;
            } else if ((this.f3656iu.f5032hy == null || this.f3656iu.f5032hy.f5032hy != this.f3656iu) && (this.f3658ix.f5032hy == null || this.f3658ix.f5032hy.f5032hy != this.f3658ix)) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (m26877y(1)) {
                ((C31242g) this.f3620iG).mo51195b(this, 1);
                z5 = true;
            } else if ((this.f3657iw.f5032hy == null || this.f3657iw.f5032hy.f5032hy != this.f3657iw) && (this.f3659iy.f5032hy == null || this.f3659iy.f5032hy.f5032hy != this.f3659iy)) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (z6 && this.f3638iZ != 8 && this.f3656iu.f5032hy == null && this.f3658ix.f5032hy == null) {
                c17377e.mo31517a(c17377e.mo31526g(this.f3620iG.f3658ix), g2, 0, 1);
            }
            if (z7 && this.f3638iZ != 8 && this.f3657iw.f5032hy == null && this.f3659iy.f5032hy == null && this.f3660iz == null) {
                c17377e.mo31517a(c17377e.mo31526g(this.f3620iG.f3659iy), g4, 0, 1);
            }
        }
        boolean z8 = z7;
        boolean z9 = z6;
        boolean z10 = z5;
        boolean z11 = z4;
        int i5 = this.mWidth;
        if (i5 < this.f3609dg) {
            i5 = this.f3609dg;
        }
        int i6 = this.mHeight;
        if (i6 < this.f3610dh) {
            i6 = this.f3610dh;
        }
        Object obj2 = this.f3619iF[0] != C17370a.MATCH_CONSTRAINT ? 1 : null;
        Object obj3 = this.f3619iF[1] != C17370a.MATCH_CONSTRAINT ? 1 : null;
        Object obj4 = null;
        this.f3651io = this.f3622iI;
        this.f3652iq = this.f3621iH;
        int i7 = this.f3640ib;
        int i8 = this.f3641ic;
        if (this.f3621iH > 0.0f && this.f3638iZ != 8) {
            obj4 = 1;
            if (this.f3619iF[0] == C17370a.MATCH_CONSTRAINT && i7 == 0) {
                i7 = 3;
            }
            if (this.f3619iF[1] == C17370a.MATCH_CONSTRAINT && i8 == 0) {
                i8 = 3;
            }
            int obj5;
            if (this.f3619iF[0] == C17370a.MATCH_CONSTRAINT && this.f3619iF[1] == C17370a.MATCH_CONSTRAINT && i7 == 3 && i8 == 3) {
                if (this.f3651io == -1) {
                    if (obj2 != null && obj3 == null) {
                        this.f3651io = 0;
                    } else if (obj2 == null && obj3 != null) {
                        this.f3651io = 1;
                        if (this.f3622iI == -1) {
                            this.f3652iq = 1.0f / this.f3652iq;
                        }
                    }
                }
                if (this.f3651io == 0 && (!this.f3657iw.isConnected() || !this.f3659iy.isConnected())) {
                    this.f3651io = 1;
                } else if (this.f3651io == 1 && !(this.f3656iu.isConnected() && this.f3658ix.isConnected())) {
                    this.f3651io = 0;
                }
                if (this.f3651io == -1 && !(this.f3657iw.isConnected() && this.f3659iy.isConnected() && this.f3656iu.isConnected() && this.f3658ix.isConnected())) {
                    if (this.f3657iw.isConnected() && this.f3659iy.isConnected()) {
                        this.f3651io = 0;
                    } else if (this.f3656iu.isConnected() && this.f3658ix.isConnected()) {
                        this.f3652iq = 1.0f / this.f3652iq;
                        this.f3651io = 1;
                    }
                }
                if (this.f3651io == -1) {
                    if (z9 && !z8) {
                        this.f3651io = 0;
                    } else if (!z9 && z8) {
                        this.f3652iq = 1.0f / this.f3652iq;
                        this.f3651io = 1;
                    }
                }
                if (this.f3651io == -1) {
                    if (this.f3643if > 0 && this.f3646ii == 0) {
                        this.f3651io = 0;
                    } else if (this.f3643if == 0 && this.f3646ii > 0) {
                        this.f3652iq = 1.0f / this.f3652iq;
                        this.f3651io = 1;
                    }
                }
                if (this.f3651io == -1 && z9 && z8) {
                    this.f3652iq = 1.0f / this.f3652iq;
                    this.f3651io = 1;
                }
                i = i8;
                i2 = i7;
                obj5 = 1;
                i3 = i6;
                i4 = i5;
                this.f3642ie[0] = i2;
                this.f3642ie[1] = i;
                if (obj5 == null) {
                }
                if (this.f3619iF[0] != C17370a.WRAP_CONTENT) {
                }
                z3 = true;
                if (this.f3616iC.isConnected()) {
                }
                if (this.f3611hX != 2) {
                }
                if (this.f3612hY == 2) {
                }
            } else if (this.f3619iF[0] == C17370a.MATCH_CONSTRAINT && i7 == 3) {
                this.f3651io = 0;
                i4 = (int) (this.f3652iq * ((float) this.mHeight));
                if (this.f3619iF[1] != C17370a.MATCH_CONSTRAINT) {
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
                this.f3642ie[0] = i2;
                this.f3642ie[1] = i;
                if (obj5 == null) {
                }
                if (this.f3619iF[0] != C17370a.WRAP_CONTENT) {
                }
                z3 = true;
                if (this.f3616iC.isConnected()) {
                }
                if (this.f3611hX != 2) {
                }
                if (this.f3612hY == 2) {
                }
            } else if (this.f3619iF[1] == C17370a.MATCH_CONSTRAINT && i8 == 3) {
                this.f3651io = 1;
                if (this.f3622iI == -1) {
                    this.f3652iq = 1.0f / this.f3652iq;
                }
                int i9 = (int) (this.f3652iq * ((float) this.mWidth));
                if (this.f3619iF[0] != C17370a.MATCH_CONSTRAINT) {
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
                this.f3642ie[0] = i2;
                this.f3642ie[1] = i;
                z = obj5 == null && (this.f3651io == 0 || this.f3651io == -1);
                z2 = this.f3619iF[0] != C17370a.WRAP_CONTENT && (this instanceof C31242g);
                z3 = true;
                if (this.f3616iC.isConnected()) {
                    z3 = false;
                }
                if (this.f3611hX != 2) {
                    m26876a(c17377e, z9, this.f3620iG != null ? c17377e.mo31526g(this.f3620iG.f3656iu) : null, this.f3620iG != null ? c17377e.mo31526g(this.f3620iG.f3658ix) : null, this.f3619iF[0], z2, this.f3656iu, this.f3658ix, this.f3623iJ, i4, this.f3609dg, this.f3654is[0], this.f3634iV, z, z11, i2, this.f3643if, this.f3644ig, this.f3645ih, z3);
                }
                if (this.f3612hY == 2) {
                    z2 = this.f3619iF[1] == C17370a.WRAP_CONTENT && (this instanceof C31242g);
                    z = obj5 != null && (this.f3651io == 1 || this.f3651io == -1);
                    if (this.f3631iR > 0) {
                        if (this.f3660iz.f5029hv.state == 1) {
                            this.f3660iz.f5029hv.mo66153c(c17377e);
                        } else {
                            c17377e.mo31524c(g5, g3, this.f3631iR, 6);
                            if (this.f3660iz.f5032hy != null) {
                                c17377e.mo31524c(g5, c17377e.mo31526g(this.f3660iz.f5032hy), 0, 6);
                                z3 = false;
                            }
                        }
                    }
                    m26876a(c17377e, z8, this.f3620iG != null ? c17377e.mo31526g(this.f3620iG.f3657iw) : null, this.f3620iG != null ? c17377e.mo31526g(this.f3620iG.f3659iy) : null, this.f3619iF[1], z2, this.f3657iw, this.f3659iy, this.f3624iK, i3, this.f3610dh, this.f3654is[1], this.f3635iW, z, z10, i, this.f3646ii, this.f3647ij, this.f3648ik, z3);
                    if (obj5 != null) {
                        if (this.f3651io == 1) {
                            c17377e.mo31525c(g4, g3, g2, g, this.f3652iq);
                        } else {
                            c17377e.mo31525c(g2, g, g4, g3, this.f3652iq);
                        }
                    }
                    if (this.f3616iC.isConnected()) {
                        C17368f c17368f = this.f3616iC.f5032hy.f5030hw;
                        float toRadians = (float) Math.toRadians((double) (this.f3655it + 90.0f));
                        int aH = this.f3616iC.mo42138aH();
                        C41479h g6 = c17377e.mo31526g(mo31445a(C25287c.LEFT));
                        C41479h g7 = c17377e.mo31526g(mo31445a(C25287c.TOP));
                        C41479h g8 = c17377e.mo31526g(mo31445a(C25287c.RIGHT));
                        C41479h g9 = c17377e.mo31526g(mo31445a(C25287c.BOTTOM));
                        C41479h g10 = c17377e.mo31526g(c17368f.mo31445a(C25287c.LEFT));
                        C41479h g11 = c17377e.mo31526g(c17368f.mo31445a(C25287c.TOP));
                        C41479h g12 = c17377e.mo31526g(c17368f.mo31445a(C25287c.RIGHT));
                        C41479h g13 = c17377e.mo31526g(c17368f.mo31445a(C25287c.BOTTOM));
                        C36667b ax = c17377e.mo31518ax();
                        ax.mo58531b(g7, g9, g11, g13, (float) (Math.sin((double) toRadians) * ((double) aH)));
                        c17377e.mo31521b(ax);
                        ax = c17377e.mo31518ax();
                        ax.mo58531b(g6, g8, g10, g12, (float) (Math.cos((double) toRadians) * ((double) aH)));
                        c17377e.mo31521b(ax);
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
        this.f3642ie[0] = i2;
        this.f3642ie[1] = i;
        if (obj5 == null) {
        }
        if (this.f3619iF[0] != C17370a.WRAP_CONTENT) {
        }
        z3 = true;
        if (this.f3616iC.isConnected()) {
        }
        if (this.f3611hX != 2) {
        }
        if (this.f3612hY == 2) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:133:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02db  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m26876a(C17377e c17377e, boolean z, C41479h c41479h, C41479h c41479h2, C17370a c17370a, boolean z2, C25284e c25284e, C25284e c25284e2, int i, int i2, int i3, int i4, float f, boolean z3, boolean z4, int i5, int i6, int i7, float f2, boolean z5) {
        C41479h g = c17377e.mo31526g(c25284e);
        C41479h g2 = c17377e.mo31526g(c25284e2);
        C41479h g3 = c17377e.mo31526g(c25284e.f5032hy);
        C41479h g4 = c17377e.mo31526g(c25284e2.f5032hy);
        C41477f au;
        if (c17377e.f3719fU && c25284e.f5029hv.state == 1 && c25284e2.f5029hv.state == 1) {
            if (C17377e.m26934au() != null) {
                au = C17377e.m26934au();
                au.f16674gv++;
            }
            c25284e.f5029hv.mo66153c(c17377e);
            c25284e2.f5029hv.mo66153c(c17377e);
            if (!z4 && z) {
                c17377e.mo31517a(c41479h2, g2, 0, 6);
                return;
            }
            return;
        }
        int i8;
        int max;
        Object obj;
        if (C17377e.m26934au() != null) {
            au = C17377e.m26934au();
            au.f16653gE++;
        }
        boolean isConnected = c25284e.isConnected();
        boolean isConnected2 = c25284e2.isConnected();
        boolean isConnected3 = this.f3616iC.isConnected();
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
        switch (c17370a) {
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
        if (this.f3638iZ == 8) {
            i9 = 0;
            obj2 = null;
        } else {
            i9 = i2;
        }
        if (z5) {
            if (!isConnected && !isConnected2 && !isConnected3) {
                c17377e.mo31515a(g, i);
            } else if (isConnected && !isConnected2) {
                c17377e.mo31524c(g, g3, c25284e.mo42138aH(), 6);
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
                c17377e.mo31517a(g2, g, i6, 6);
                i9 = Math.max(i9, i6);
            }
            if (i7 > 0) {
                c17377e.mo31523b(g2, g, i7, 6);
                min = Math.min(i9, i7);
            } else {
                min = i9;
            }
            if (i5 == 1) {
                if (z) {
                    c17377e.mo31524c(g2, g, min, 6);
                } else if (z4) {
                    c17377e.mo31524c(g2, g, min, 4);
                } else {
                    c17377e.mo31524c(g2, g, min, 1);
                }
            } else if (i5 == 2) {
                C41479h g5;
                C41479h g6;
                if (c25284e.f5031hx == C25287c.TOP || c25284e.f5031hx == C25287c.BOTTOM) {
                    g5 = c17377e.mo31526g(this.f3620iG.mo31445a(C25287c.TOP));
                    g6 = c17377e.mo31526g(this.f3620iG.mo31445a(C25287c.BOTTOM));
                } else {
                    g5 = c17377e.mo31526g(this.f3620iG.mo31445a(C25287c.LEFT));
                    g6 = c17377e.mo31526g(this.f3620iG.mo31445a(C25287c.RIGHT));
                }
                c17377e.mo31521b(c17377e.mo31518ax().mo58529a(g2, g, g6, g5, f2));
                obj2 = null;
            }
            if (!(obj2 == null || i8 == 2 || z3)) {
                max = Math.max(i6, min);
                if (i7 > 0) {
                    max = Math.min(i7, max);
                }
                c17377e.mo31524c(g2, g, max, 6);
                obj = null;
            }
            obj = obj2;
        } else if (z2) {
            c17377e.mo31524c(g2, g, 0, 3);
            if (i3 > 0) {
                c17377e.mo31517a(g2, g, i3, 6);
            }
            if (i4 < Integer.MAX_VALUE) {
                c17377e.mo31523b(g2, g, i4, 6);
                obj = obj2;
            }
            obj = obj2;
        } else {
            c17377e.mo31524c(g2, g, i9, 6);
            obj = obj2;
        }
        if (z5 && !z4) {
            if (isConnected || isConnected2 || isConnected3) {
                if (!isConnected || isConnected2) {
                    if (!isConnected && isConnected2) {
                        c17377e.mo31524c(g2, g4, -c25284e2.mo42138aH(), 6);
                        if (z) {
                            c17377e.mo31517a(g, c41479h, 0, 5);
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
                                c17377e.mo31517a(g2, g, 0, 6);
                            }
                            int obj32;
                            if (i5 == 0) {
                                max = 6;
                                if (i7 > 0 || i6 > 0) {
                                    max = 4;
                                    obj4 = 1;
                                }
                                c17377e.mo31524c(g, g3, c25284e.mo42138aH(), max);
                                c17377e.mo31524c(g2, g4, -c25284e2.mo42138aH(), max);
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
                                if (!(z3 || this.f3651io == -1 || i7 > 0)) {
                                    max = 6;
                                }
                                c17377e.mo31524c(g, g3, c25284e.mo42138aH(), max);
                                c17377e.mo31524c(g2, g4, -c25284e2.mo42138aH(), max);
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
                            c17377e.mo31516a(g, g3, c25284e.mo42138aH(), f, g4, g2, c25284e2.mo42138aH(), i10);
                            boolean z8 = c25284e.f5032hy.f5030hw instanceof C37093b;
                            z6 = c25284e2.f5032hy.f5030hw instanceof C37093b;
                            if (z8 && !z6) {
                                max = 6;
                                z6 = true;
                                z7 = z;
                                i9 = 5;
                                if (obj32 != null) {
                                }
                                c17377e.mo31517a(g, g3, c25284e.mo42138aH(), i9);
                                c17377e.mo31523b(g2, g4, -c25284e2.mo42138aH(), max);
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
                                    c17377e.mo31517a(g, g3, c25284e.mo42138aH(), i9);
                                }
                                if ((obj == null && r6) || obj32 != null) {
                                    c17377e.mo31523b(g2, g4, -c25284e2.mo42138aH(), max);
                                }
                                if (z) {
                                    c17377e.mo31517a(g, c41479h, 0, 6);
                                }
                            }
                        }
                        z6 = z;
                        z7 = z;
                        i9 = 5;
                        if (obj32 != null) {
                        }
                        c17377e.mo31517a(g, g3, c25284e.mo42138aH(), i9);
                        c17377e.mo31523b(g2, g4, -c25284e2.mo42138aH(), max);
                        if (z) {
                        }
                    }
                } else if (z) {
                    c17377e.mo31517a(c41479h2, g2, 0, 5);
                }
            } else if (z) {
                c17377e.mo31517a(c41479h2, g2, 0, 5);
            }
            if (z) {
                c17377e.mo31517a(c41479h2, g2, 0, 6);
            }
        } else if (i8 < 2 && z) {
            c17377e.mo31517a(g, c41479h, 0, 6);
            c17377e.mo31517a(c41479h2, g2, 0, 6);
        }
    }

    /* renamed from: aY */
    public void mo31469aY() {
        int h = C17377e.m26939h(this.f3656iu);
        int h2 = C17377e.m26939h(this.f3657iw);
        int h3 = C17377e.m26939h(this.f3658ix);
        int h4 = C17377e.m26939h(this.f3659iy);
        int i = h4 - h2;
        if (h3 - h < 0 || i < 0 || h == C8415j.INVALID_ID || h == BaseClientBuilder.API_PRIORITY_OTHER || h2 == C8415j.INVALID_ID || h2 == BaseClientBuilder.API_PRIORITY_OTHER || h3 == C8415j.INVALID_ID || h3 == BaseClientBuilder.API_PRIORITY_OTHER || h4 == C8415j.INVALID_ID || h4 == BaseClientBuilder.API_PRIORITY_OTHER) {
            h4 = 0;
            h3 = 0;
            h2 = 0;
            h = 0;
        }
        h3 -= h;
        int i2 = h4 - h2;
        this.f3623iJ = h;
        this.f3624iK = h2;
        if (this.f3638iZ == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        int i3;
        if (this.f3619iF[0] != C17370a.FIXED || h3 >= this.mWidth) {
            h4 = h3;
        } else {
            h4 = this.mWidth;
        }
        if (this.f3619iF[1] != C17370a.FIXED || i2 >= this.mHeight) {
            i3 = i2;
        } else {
            i3 = this.mHeight;
        }
        this.mWidth = h4;
        this.mHeight = i3;
        if (this.mHeight < this.f3610dh) {
            this.mHeight = this.f3610dh;
        }
        if (this.mWidth < this.f3609dg) {
            this.mWidth = this.f3609dg;
        }
        this.f3665je = true;
    }

    public final int getRight() {
        return this.f3623iJ + this.mWidth;
    }

    public final int getBottom() {
        return this.f3624iK + this.mHeight;
    }
}
