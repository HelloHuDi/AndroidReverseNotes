package android.support.constraint.p780a.p781a;

import android.support.constraint.p780a.C17377e;
import android.support.constraint.p780a.C36667b;
import android.support.constraint.p780a.C41477f;
import android.support.constraint.p780a.C41479h;
import android.support.constraint.p780a.p781a.C17368f.C17370a;
import java.util.ArrayList;

/* renamed from: android.support.constraint.a.a.b */
public final class C37093b extends C41473j {
    /* renamed from: hc */
    public int f15636hc = 0;
    /* renamed from: hd */
    private ArrayList<C41476m> f15637hd = new ArrayList(4);
    /* renamed from: he */
    public boolean f15638he = true;

    /* renamed from: aC */
    public final boolean mo31450aC() {
        return true;
    }

    /* renamed from: aD */
    public final void mo31451aD() {
        super.mo31451aD();
        this.f15637hd.clear();
    }

    /* renamed from: u */
    public final void mo31492u(int i) {
        if (this.f3620iG != null && ((C31242g) this.f3620iG).mo51199z(2)) {
            C41476m c41476m;
            switch (this.f15636hc) {
                case 0:
                    c41476m = this.f3656iu.f5029hv;
                    break;
                case 1:
                    c41476m = this.f3658ix.f5029hv;
                    break;
                case 2:
                    c41476m = this.f3657iw.f5029hv;
                    break;
                case 3:
                    c41476m = this.f3659iy.f5029hv;
                    break;
                default:
                    return;
            }
            c41476m.type = 5;
            if (this.f15636hc == 0 || this.f15636hc == 1) {
                this.f3657iw.f5029hv.mo66147a(null, 0.0f);
                this.f3659iy.f5029hv.mo66147a(null, 0.0f);
            } else {
                this.f3656iu.f5029hv.mo66147a(null, 0.0f);
                this.f3658ix.f5029hv.mo66147a(null, 0.0f);
            }
            this.f15637hd.clear();
            for (int i2 = 0; i2 < this.f16635hn; i2++) {
                C17368f c17368f = this.f16636kh[i2];
                if (this.f15638he || c17368f.mo31450aC()) {
                    Object obj;
                    switch (this.f15636hc) {
                        case 0:
                            obj = c17368f.f3656iu.f5029hv;
                            break;
                        case 1:
                            obj = c17368f.f3658ix.f5029hv;
                            break;
                        case 2:
                            obj = c17368f.f3657iw.f5029hv;
                            break;
                        case 3:
                            obj = c17368f.f3659iy.f5029hv;
                            break;
                        default:
                            obj = null;
                            break;
                    }
                    if (obj != null) {
                        this.f15637hd.add(obj);
                        obj.mo42142a(c41476m);
                    }
                }
            }
        }
    }

    /* renamed from: aE */
    public final void mo31452aE() {
        C41476m c41476m;
        float f = Float.MAX_VALUE;
        switch (this.f15636hc) {
            case 0:
                c41476m = this.f3656iu.f5029hv;
                break;
            case 1:
                c41476m = this.f3658ix.f5029hv;
                f = 0.0f;
                break;
            case 2:
                c41476m = this.f3657iw.f5029hv;
                break;
            case 3:
                c41476m = this.f3659iy.f5029hv;
                f = 0.0f;
                break;
            default:
                return;
        }
        int size = this.f15637hd.size();
        C41476m c41476m2 = null;
        int i = 0;
        while (i < size) {
            C41476m c41476m3 = (C41476m) this.f15637hd.get(i);
            if (c41476m3.state == 1) {
                if (this.f15636hc == 0 || this.f15636hc == 2) {
                    if (c41476m3.f16642km < f) {
                        f = c41476m3.f16642km;
                        c41476m3 = c41476m3.f16641kl;
                    }
                    c41476m3 = c41476m2;
                } else {
                    if (c41476m3.f16642km > f) {
                        f = c41476m3.f16642km;
                        c41476m3 = c41476m3.f16641kl;
                    }
                    c41476m3 = c41476m2;
                }
                i++;
                c41476m2 = c41476m3;
            } else {
                return;
            }
        }
        if (C17377e.m26934au() != null) {
            C41477f au = C17377e.m26934au();
            au.f16651gC++;
        }
        c41476m.f16641kl = c41476m2;
        c41476m.f16642km = f;
        c41476m.mo42144bf();
        switch (this.f15636hc) {
            case 0:
                this.f3658ix.f5029hv.mo66147a(c41476m2, f);
                return;
            case 1:
                this.f3656iu.f5029hv.mo66147a(c41476m2, f);
                return;
            case 2:
                this.f3659iy.f5029hv.mo66147a(c41476m2, f);
                return;
            case 3:
                this.f3657iw.f5029hv.mo66147a(c41476m2, f);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public final void mo31449a(C17377e c17377e) {
        int i;
        this.f3617iD[0] = this.f3656iu;
        this.f3617iD[2] = this.f3657iw;
        this.f3617iD[1] = this.f3658ix;
        this.f3617iD[3] = this.f3659iy;
        for (i = 0; i < this.f3617iD.length; i++) {
            this.f3617iD[i].f5028hE = c17377e.mo31526g(this.f3617iD[i]);
        }
        if (this.f15636hc >= 0 && this.f15636hc < 4) {
            C25284e c25284e = this.f3617iD[this.f15636hc];
            for (i = 0; i < this.f16635hn; i++) {
                C17368f c17368f = this.f16636kh[i];
                if (this.f15638he || c17368f.mo31450aC()) {
                    if ((this.f15636hc != 0 && this.f15636hc != 1) || c17368f.mo31467aW() != C17370a.MATCH_CONSTRAINT) {
                        if ((this.f15636hc == 2 || this.f15636hc == 3) && c17368f.mo31468aX() == C17370a.MATCH_CONSTRAINT) {
                            i = 1;
                            break;
                        }
                    }
                    i = 1;
                    break;
                }
            }
            i = 0;
            if (this.f15636hc == 0 || this.f15636hc == 1) {
                if (this.f3620iG.mo31467aW() == C17370a.WRAP_CONTENT) {
                    i = 0;
                }
            } else if (this.f3620iG.mo31468aX() == C17370a.WRAP_CONTENT) {
                i = 0;
            }
            for (int i2 = 0; i2 < this.f16635hn; i2++) {
                C17368f c17368f2 = this.f16636kh[i2];
                if (this.f15638he || c17368f2.mo31450aC()) {
                    C41479h g = c17377e.mo31526g(c17368f2.f3617iD[this.f15636hc]);
                    c17368f2.f3617iD[this.f15636hc].f5028hE = g;
                    C41479h c41479h;
                    C36667b ax;
                    C41479h ay;
                    if (this.f15636hc == 0 || this.f15636hc == 2) {
                        c41479h = c25284e.f5028hE;
                        ax = c17377e.mo31518ax();
                        ay = c17377e.mo31519ay();
                        ay.f16685gP = 0;
                        ax.mo58530b(c41479h, g, ay, 0);
                        if (i != 0) {
                            c17377e.mo31514a(ax, (int) (ax.f15473fI.mo31508b(ay) * -1.0f), 1);
                        }
                        c17377e.mo31521b(ax);
                    } else {
                        c41479h = c25284e.f5028hE;
                        ax = c17377e.mo31518ax();
                        ay = c17377e.mo31519ay();
                        ay.f16685gP = 0;
                        ax.mo58528a(c41479h, g, ay, 0);
                        if (i != 0) {
                            c17377e.mo31514a(ax, (int) (ax.f15473fI.mo31508b(ay) * -1.0f), 1);
                        }
                        c17377e.mo31521b(ax);
                    }
                }
            }
            if (this.f15636hc == 0) {
                c17377e.mo31524c(this.f3658ix.f5028hE, this.f3656iu.f5028hE, 0, 6);
                if (i == 0) {
                    c17377e.mo31524c(this.f3656iu.f5028hE, this.f3620iG.f3658ix.f5028hE, 0, 5);
                }
            } else if (this.f15636hc == 1) {
                c17377e.mo31524c(this.f3656iu.f5028hE, this.f3658ix.f5028hE, 0, 6);
                if (i == 0) {
                    c17377e.mo31524c(this.f3656iu.f5028hE, this.f3620iG.f3656iu.f5028hE, 0, 5);
                }
            } else if (this.f15636hc == 2) {
                c17377e.mo31524c(this.f3659iy.f5028hE, this.f3657iw.f5028hE, 0, 6);
                if (i == 0) {
                    c17377e.mo31524c(this.f3657iw.f5028hE, this.f3620iG.f3659iy.f5028hE, 0, 5);
                }
            } else if (this.f15636hc == 3) {
                c17377e.mo31524c(this.f3657iw.f5028hE, this.f3659iy.f5028hE, 0, 6);
                if (i == 0) {
                    c17377e.mo31524c(this.f3657iw.f5028hE, this.f3620iG.f3657iw.f5028hE, 0, 5);
                }
            }
        }
    }
}
