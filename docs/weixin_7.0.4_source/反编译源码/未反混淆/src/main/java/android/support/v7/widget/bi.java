package android.support.v7.widget;

import android.view.View;

final class bi {
    final b auR;
    a auS = new a();

    static class a {
        int auT = 0;
        int auU;
        int auV;
        int auW;
        int auX;

        a() {
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
        public final boolean lx() {
            if ((this.auT & 7) != 0 && (this.auT & (compare(this.auW, this.auU) << 0)) == 0) {
                return false;
            }
            if ((this.auT & 112) != 0 && (this.auT & (compare(this.auW, this.auV) << 4)) == 0) {
                return false;
            }
            if ((this.auT & 1792) != 0 && (this.auT & (compare(this.auX, this.auU) << 8)) == 0) {
                return false;
            }
            if ((this.auT & 28672) == 0 || (this.auT & (compare(this.auX, this.auV) << 12)) != 0) {
                return true;
            }
            return false;
        }
    }

    interface b {
        int bF(View view);

        int bG(View view);

        View getChildAt(int i);

        int jY();

        int jZ();
    }

    bi(b bVar) {
        this.auR = bVar;
    }

    /* Access modifiers changed, original: final */
    public final View k(int i, int i2, int i3, int i4) {
        int jY = this.auR.jY();
        int jZ = this.auR.jZ();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View childAt = this.auR.getChildAt(i);
            this.auS.setBounds(jY, jZ, this.auR.bF(childAt), this.auR.bG(childAt));
            if (i3 != 0) {
                this.auS.auT = 0;
                this.auS.addFlags(i3);
                if (this.auS.lx()) {
                    return childAt;
                }
            }
            if (i4 != 0) {
                this.auS.auT = 0;
                this.auS.addFlags(i4);
                if (this.auS.lx()) {
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
    public final boolean bV(View view) {
        this.auS.setBounds(this.auR.jY(), this.auR.jZ(), this.auR.bF(view), this.auR.bG(view));
        this.auS.auT = 0;
        this.auS.addFlags(24579);
        return this.auS.lx();
    }
}
