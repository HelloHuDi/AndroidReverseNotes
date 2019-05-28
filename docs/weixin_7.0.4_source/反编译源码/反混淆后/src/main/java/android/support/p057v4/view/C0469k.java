package android.support.p057v4.view;

import android.view.View;
import android.view.ViewParent;

/* renamed from: android.support.v4.view.k */
public final class C0469k {
    /* renamed from: Mn */
    private ViewParent f560Mn;
    /* renamed from: Mo */
    private ViewParent f561Mo;
    /* renamed from: Mp */
    public boolean f562Mp;
    /* renamed from: Mq */
    private int[] f563Mq;
    private final View mView;

    public C0469k(View view) {
        this.mView = view;
    }

    public final void setNestedScrollingEnabled(boolean z) {
        if (this.f562Mp) {
            C0477s.m926ar(this.mView);
        }
        this.f562Mp = z;
    }

    /* renamed from: aI */
    public final boolean mo1068aI(int i) {
        return m828aK(i) != null;
    }

    /* renamed from: w */
    public final boolean mo1075w(int i, int i2) {
        if (mo1068aI(i2)) {
            return true;
        }
        if (this.f562Mp) {
            View view = this.mView;
            for (ViewParent parent = this.mView.getParent(); parent != null; parent = parent.getParent()) {
                if (C0492v.m1026a(parent, view, this.mView, i, i2)) {
                    m827a(i2, parent);
                    C0492v.m1028b(parent, view, this.mView, i, i2);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    /* renamed from: aJ */
    public final void mo1069aJ(int i) {
        ViewParent aK = m828aK(i);
        if (aK != null) {
            C0492v.m1021a(aK, this.mView, i);
            m827a(i, null);
        }
    }

    public final boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return mo1066a(i, i2, i3, i4, iArr, 0);
    }

    public final boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return mo1067a(i, i2, iArr, iArr2, 0);
    }

    /* renamed from: a */
    public final boolean mo1067a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        if (this.f562Mp) {
            ViewParent aK = m828aK(i3);
            if (aK == null) {
                return false;
            }
            if (i != 0 || i2 != 0) {
                int i4;
                int i5;
                int[] iArr3;
                if (iArr2 != null) {
                    this.mView.getLocationInWindow(iArr2);
                    int i6 = iArr2[0];
                    i4 = iArr2[1];
                    i5 = i6;
                } else {
                    i4 = 0;
                    i5 = 0;
                }
                if (iArr == null) {
                    if (this.f563Mq == null) {
                        this.f563Mq = new int[2];
                    }
                    iArr3 = this.f563Mq;
                } else {
                    iArr3 = iArr;
                }
                iArr3[0] = 0;
                iArr3[1] = 0;
                C0492v.m1023a(aK, this.mView, i, i2, iArr3, i3);
                if (iArr2 != null) {
                    this.mView.getLocationInWindow(iArr2);
                    iArr2[0] = iArr2[0] - i5;
                    iArr2[1] = iArr2[1] - i4;
                }
                return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
            } else if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
        }
        return false;
    }

    public final boolean dispatchNestedFling(float f, float f2, boolean z) {
        if (!this.f562Mp) {
            return false;
        }
        ViewParent aK = m828aK(0);
        if (aK != null) {
            return C0492v.m1025a(aK, this.mView, f, f2, z);
        }
        return false;
    }

    public final boolean dispatchNestedPreFling(float f, float f2) {
        if (!this.f562Mp) {
            return false;
        }
        ViewParent aK = m828aK(0);
        if (aK != null) {
            return C0492v.m1024a(aK, this.mView, f, f2);
        }
        return false;
    }

    /* renamed from: aK */
    private ViewParent m828aK(int i) {
        switch (i) {
            case 0:
                return this.f560Mn;
            case 1:
                return this.f561Mo;
            default:
                return null;
        }
    }

    /* renamed from: a */
    private void m827a(int i, ViewParent viewParent) {
        switch (i) {
            case 0:
                this.f560Mn = viewParent;
                return;
            case 1:
                this.f561Mo = viewParent;
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public final boolean mo1066a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        if (this.f562Mp) {
            ViewParent aK = m828aK(i5);
            if (aK == null) {
                return false;
            }
            if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
                int i6;
                int i7;
                if (iArr != null) {
                    this.mView.getLocationInWindow(iArr);
                    int i8 = iArr[0];
                    i6 = iArr[1];
                    i7 = i8;
                } else {
                    i6 = 0;
                    i7 = 0;
                }
                C0492v.m1022a(aK, this.mView, i, i2, i3, i4, i5);
                if (iArr != null) {
                    this.mView.getLocationInWindow(iArr);
                    iArr[0] = iArr[0] - i7;
                    iArr[1] = iArr[1] - i6;
                }
                return true;
            } else if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
        }
        return false;
    }
}
