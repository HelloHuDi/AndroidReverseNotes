package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

public final class k {
    private ViewParent Mn;
    private ViewParent Mo;
    public boolean Mp;
    private int[] Mq;
    private final View mView;

    public k(View view) {
        this.mView = view;
    }

    public final void setNestedScrollingEnabled(boolean z) {
        if (this.Mp) {
            s.ar(this.mView);
        }
        this.Mp = z;
    }

    public final boolean aI(int i) {
        return aK(i) != null;
    }

    public final boolean w(int i, int i2) {
        if (aI(i2)) {
            return true;
        }
        if (this.Mp) {
            View view = this.mView;
            for (ViewParent parent = this.mView.getParent(); parent != null; parent = parent.getParent()) {
                if (v.a(parent, view, this.mView, i, i2)) {
                    a(i2, parent);
                    v.b(parent, view, this.mView, i, i2);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public final void aJ(int i) {
        ViewParent aK = aK(i);
        if (aK != null) {
            v.a(aK, this.mView, i);
            a(i, null);
        }
    }

    public final boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return a(i, i2, i3, i4, iArr, 0);
    }

    public final boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return a(i, i2, iArr, iArr2, 0);
    }

    public final boolean a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        if (this.Mp) {
            ViewParent aK = aK(i3);
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
                    if (this.Mq == null) {
                        this.Mq = new int[2];
                    }
                    iArr3 = this.Mq;
                } else {
                    iArr3 = iArr;
                }
                iArr3[0] = 0;
                iArr3[1] = 0;
                v.a(aK, this.mView, i, i2, iArr3, i3);
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
        if (!this.Mp) {
            return false;
        }
        ViewParent aK = aK(0);
        if (aK != null) {
            return v.a(aK, this.mView, f, f2, z);
        }
        return false;
    }

    public final boolean dispatchNestedPreFling(float f, float f2) {
        if (!this.Mp) {
            return false;
        }
        ViewParent aK = aK(0);
        if (aK != null) {
            return v.a(aK, this.mView, f, f2);
        }
        return false;
    }

    private ViewParent aK(int i) {
        switch (i) {
            case 0:
                return this.Mn;
            case 1:
                return this.Mo;
            default:
                return null;
        }
    }

    private void a(int i, ViewParent viewParent) {
        switch (i) {
            case 0:
                this.Mn = viewParent;
                return;
            case 1:
                this.Mo = viewParent;
                return;
            default:
                return;
        }
    }

    public final boolean a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        if (this.Mp) {
            ViewParent aK = aK(i5);
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
                v.a(aK, this.mView, i, i2, i3, i4, i5);
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
