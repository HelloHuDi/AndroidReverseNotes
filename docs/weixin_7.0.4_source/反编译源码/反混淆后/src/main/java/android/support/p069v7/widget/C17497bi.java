package android.support.p069v7.widget;

import android.view.View;

/* renamed from: android.support.v7.widget.bi */
final class C17497bi {
    final C0708b auR;
    C0707a auS = new C0707a();

    /* renamed from: android.support.v7.widget.bi$a */
    static class C0707a {
        int auT = 0;
        int auU;
        int auV;
        int auW;
        int auX;

        C0707a() {
        }

        /* Access modifiers changed, original: final */
        public final void setBounds(int i, int i2, int i3, int i4) {
            this.auU = i;
            this.auV = i2;
            this.auW = i3;
            this.auX = i4;
        }

        /* Access modifiers changed, original: final */
        public final void addFlags(int i) {
            this.auT |= i;
        }

        private static int compare(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            if (i == i2) {
                return 2;
            }
            return 4;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: lx */
        public final boolean mo2055lx() {
            if ((this.auT & 7) != 0 && (this.auT & (C0707a.compare(this.auW, this.auU) << 0)) == 0) {
                return false;
            }
            if ((this.auT & 112) != 0 && (this.auT & (C0707a.compare(this.auW, this.auV) << 4)) == 0) {
                return false;
            }
            if ((this.auT & 1792) != 0 && (this.auT & (C0707a.compare(this.auX, this.auU) << 8)) == 0) {
                return false;
            }
            if ((this.auT & 28672) == 0 || (this.auT & (C0707a.compare(this.auX, this.auV) << 12)) != 0) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: android.support.v7.widget.bi$b */
    interface C0708b {
        /* renamed from: bF */
        int mo2057bF(View view);

        /* renamed from: bG */
        int mo2058bG(View view);

        View getChildAt(int i);

        /* renamed from: jY */
        int mo2060jY();

        /* renamed from: jZ */
        int mo2061jZ();
    }

    C17497bi(C0708b c0708b) {
        this.auR = c0708b;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: k */
    public final View mo31924k(int i, int i2, int i3, int i4) {
        int jY = this.auR.mo2060jY();
        int jZ = this.auR.mo2061jZ();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View childAt = this.auR.getChildAt(i);
            this.auS.setBounds(jY, jZ, this.auR.mo2057bF(childAt), this.auR.mo2058bG(childAt));
            if (i3 != 0) {
                this.auS.auT = 0;
                this.auS.addFlags(i3);
                if (this.auS.mo2055lx()) {
                    return childAt;
                }
            }
            if (i4 != 0) {
                this.auS.auT = 0;
                this.auS.addFlags(i4);
                if (this.auS.mo2055lx()) {
                    i += i5;
                    view = childAt;
                }
            }
            childAt = view;
            i += i5;
            view = childAt;
        }
        return view;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bV */
    public final boolean mo31923bV(View view) {
        this.auS.setBounds(this.auR.mo2060jY(), this.auR.mo2061jZ(), this.auR.mo2057bF(view), this.auR.mo2058bG(view));
        this.auS.auT = 0;
        this.auS.addFlags(24579);
        return this.auS.mo2055lx();
    }
}
