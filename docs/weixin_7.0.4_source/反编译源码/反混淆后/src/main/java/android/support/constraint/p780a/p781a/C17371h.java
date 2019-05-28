package android.support.constraint.p780a.p781a;

import android.support.constraint.p780a.p781a.C25284e.C25287c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: android.support.constraint.a.a.h */
public final class C17371h {
    /* renamed from: jL */
    public boolean f3683jL = false;
    /* renamed from: jP */
    public List<C17368f> f3684jP;
    /* renamed from: jQ */
    int f3685jQ = -1;
    /* renamed from: jR */
    int f3686jR = -1;
    /* renamed from: jS */
    public final int[] f3687jS = new int[]{this.f3685jQ, this.f3686jR};
    /* renamed from: jT */
    List<C17368f> f3688jT = new ArrayList();
    /* renamed from: jU */
    List<C17368f> f3689jU = new ArrayList();
    /* renamed from: jV */
    HashSet<C17368f> f3690jV = new HashSet();
    /* renamed from: jW */
    HashSet<C17368f> f3691jW = new HashSet();
    /* renamed from: jX */
    List<C17368f> f3692jX = new ArrayList();
    /* renamed from: jY */
    List<C17368f> f3693jY = new ArrayList();

    C17371h(List<C17368f> list) {
        this.f3684jP = list;
    }

    C17371h(List<C17368f> list, byte b) {
        this.f3684jP = list;
        this.f3683jL = true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: A */
    public final Set<C17368f> mo31496A(int i) {
        if (i == 0) {
            return this.f3690jV;
        }
        if (i == 1) {
            return this.f3691jW;
        }
        return null;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final void mo31498c(C17368f c17368f, int i) {
        if (i == 0) {
            this.f3690jV.add(c17368f);
        } else if (i == 1) {
            this.f3691jW.add(c17368f);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo31497a(ArrayList<C17368f> arrayList, C17368f c17368f) {
        if (!c17368f.f3666jf) {
            arrayList.add(c17368f);
            c17368f.f3666jf = true;
            if (!c17368f.mo31456aL()) {
                int i;
                if (c17368f instanceof C41473j) {
                    C41473j c41473j = (C41473j) c17368f;
                    int i2 = c41473j.f16635hn;
                    for (i = 0; i < i2; i++) {
                        mo31497a(arrayList, c41473j.f16636kh[i]);
                    }
                }
                for (C25284e c25284e : c17368f.f3617iD) {
                    C25284e c25284e2 = c25284e2.f5032hy;
                    if (c25284e2 != null) {
                        C17368f c17368f2 = c25284e2.f5030hw;
                        if (!(c25284e2 == null || c17368f2 == c17368f.f3620iG)) {
                            mo31497a(arrayList, c17368f2);
                        }
                    }
                }
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    public final void mo31499d(C17368f c17368f) {
        if (c17368f.f3664jd && !c17368f.mo31456aL()) {
            C25284e c25284e;
            int width;
            boolean z = c17368f.f3658ix.f5032hy != null;
            if (z) {
                c25284e = c17368f.f3658ix.f5032hy;
            } else {
                c25284e = c17368f.f3656iu.f5032hy;
            }
            if (c25284e != null) {
                if (!c25284e.f5030hw.f3665je) {
                    mo31499d(c25284e.f5030hw);
                }
                if (c25284e.f5031hx == C25287c.RIGHT) {
                    width = c25284e.f5030hw.getWidth() + c25284e.f5030hw.f3623iJ;
                } else if (c25284e.f5031hx == C25287c.LEFT) {
                    width = c25284e.f5030hw.f3623iJ;
                }
                if (z) {
                    width += c17368f.f3656iu.mo42138aH() + c17368f.getWidth();
                } else {
                    width -= c17368f.f3658ix.mo42138aH();
                }
                c17368f.mo31474g(width - c17368f.getWidth(), width);
                if (c17368f.f3660iz.f5032hy == null) {
                    c25284e = c17368f.f3660iz.f5032hy;
                    if (!c25284e.f5030hw.f3665je) {
                        mo31499d(c25284e.f5030hw);
                    }
                    width = (c25284e.f5030hw.f3631iR + c25284e.f5030hw.f3624iK) - c17368f.f3631iR;
                    c17368f.mo31481h(width, c17368f.mHeight + width);
                    c17368f.f3665je = true;
                    return;
                }
                C25284e c25284e2;
                z = c17368f.f3659iy.f5032hy != null;
                if (z) {
                    c25284e2 = c17368f.f3659iy.f5032hy;
                } else {
                    c25284e2 = c17368f.f3657iw.f5032hy;
                }
                if (c25284e2 != null) {
                    if (!c25284e2.f5030hw.f3665je) {
                        mo31499d(c25284e2.f5030hw);
                    }
                    if (c25284e2.f5031hx == C25287c.BOTTOM) {
                        width = c25284e2.f5030hw.f3624iK + c25284e2.f5030hw.getHeight();
                    } else if (c25284e2.f5031hx == C25287c.TOP) {
                        width = c25284e2.f5030hw.f3624iK;
                    }
                }
                if (z) {
                    width -= c17368f.f3659iy.mo42138aH();
                } else {
                    width += c17368f.f3657iw.mo42138aH() + c17368f.getHeight();
                }
                c17368f.mo31481h(width - c17368f.getHeight(), width);
                c17368f.f3665je = true;
                return;
            }
            width = 0;
            if (z) {
            }
            c17368f.mo31474g(width - c17368f.getWidth(), width);
            if (c17368f.f3660iz.f5032hy == null) {
            }
        }
    }
}
