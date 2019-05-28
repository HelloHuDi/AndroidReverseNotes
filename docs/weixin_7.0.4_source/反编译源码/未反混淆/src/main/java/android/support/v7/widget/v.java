package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

final class v {
    final b aha;
    final a ahb = new a();
    final List<View> ahc = new ArrayList();

    static class a {
        long ahd = 0;
        a ahe;

        a() {
        }

        /* Access modifiers changed, original: final */
        public final void set(int i) {
            while (i >= 64) {
                this.hV();
                this = this.ahe;
                i -= 64;
            }
            this.ahd |= 1 << i;
        }

        private void hV() {
            if (this.ahe == null) {
                this.ahe = new a();
            }
        }

        /* Access modifiers changed, original: final */
        public final void clear(int i) {
            while (i >= 64) {
                if (this.ahe != null) {
                    this = this.ahe;
                    i -= 64;
                } else {
                    return;
                }
            }
            this.ahd &= (1 << i) ^ -1;
        }

        /* Access modifiers changed, original: final */
        public final boolean get(int i) {
            while (i >= 64) {
                this.hV();
                this = this.ahe;
                i -= 64;
            }
            return (this.ahd & (1 << i)) != 0;
        }

        /* Access modifiers changed, original: final */
        public final void m(int i, boolean z) {
            while (true) {
                if (i >= 64) {
                    this.hV();
                    this = this.ahe;
                    i -= 64;
                } else {
                    boolean z2 = (this.ahd & Long.MIN_VALUE) != 0;
                    long j = (1 << i) - 1;
                    this.ahd = (((j ^ -1) & this.ahd) << 1) | (this.ahd & j);
                    if (z) {
                        this.set(i);
                    } else {
                        this.clear(i);
                    }
                    if (z2 || this.ahe != null) {
                        this.hV();
                        this = this.ahe;
                        i = 0;
                        z = z2;
                    } else {
                        return;
                    }
                }
            }
        }

        /* Access modifiers changed, original: final */
        public final boolean bJ(int i) {
            while (i >= 64) {
                this.hV();
                this = this.ahe;
                i -= 64;
            }
            long j = 1 << i;
            boolean z = (this.ahd & j) != 0;
            this.ahd &= j ^ -1;
            j--;
            this.ahd = Long.rotateRight((j ^ -1) & this.ahd, 1) | (this.ahd & j);
            if (this.ahe != null) {
                if (this.ahe.get(0)) {
                    this.set(63);
                }
                this.ahe.bJ(0);
            }
            return z;
        }

        /* Access modifiers changed, original: final */
        public final int bK(int i) {
            if (this.ahe == null) {
                if (i >= 64) {
                    return Long.bitCount(this.ahd);
                }
                return Long.bitCount(this.ahd & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.ahd & ((1 << i) - 1));
            } else {
                return this.ahe.bK(i - 64) + Long.bitCount(this.ahd);
            }
        }

        public final String toString() {
            if (this.ahe == null) {
                return Long.toBinaryString(this.ahd);
            }
            return this.ahe.toString() + "xx" + Long.toBinaryString(this.ahd);
        }
    }

    interface b {
        android.support.v7.widget.RecyclerView.v aZ(View view);

        void addView(View view, int i);

        void attachViewToParent(View view, int i, LayoutParams layoutParams);

        void ba(View view);

        void bb(View view);

        void detachViewFromParent(int i);

        View getChildAt(int i);

        int getChildCount();

        int indexOfChild(View view);

        void removeAllViews();

        void removeViewAt(int i);
    }

    v(b bVar) {
        this.aha = bVar;
    }

    /* Access modifiers changed, original: final */
    public final void aW(View view) {
        this.ahc.add(view);
        this.aha.ba(view);
    }

    /* Access modifiers changed, original: final */
    public final boolean aX(View view) {
        if (!this.ahc.remove(view)) {
            return false;
        }
        this.aha.bb(view);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void a(View view, int i, boolean z) {
        int childCount;
        if (i < 0) {
            childCount = this.aha.getChildCount();
        } else {
            childCount = bH(i);
        }
        this.ahb.m(childCount, z);
        if (z) {
            aW(view);
        }
        this.aha.addView(view, childCount);
    }

    private int bH(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = this.aha.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int bK = i - (i2 - this.ahb.bK(i2));
            if (bK == 0) {
                while (this.ahb.get(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += bK;
        }
        return -1;
    }

    /* Access modifiers changed, original: final */
    public final void removeViewAt(int i) {
        int bH = bH(i);
        View childAt = this.aha.getChildAt(bH);
        if (childAt != null) {
            if (this.ahb.bJ(bH)) {
                aX(childAt);
            }
            this.aha.removeViewAt(bH);
        }
    }

    /* Access modifiers changed, original: final */
    public final View getChildAt(int i) {
        return this.aha.getChildAt(bH(i));
    }

    /* Access modifiers changed, original: final */
    public final void a(View view, int i, LayoutParams layoutParams, boolean z) {
        int childCount;
        if (i < 0) {
            childCount = this.aha.getChildCount();
        } else {
            childCount = bH(i);
        }
        this.ahb.m(childCount, z);
        if (z) {
            aW(view);
        }
        this.aha.attachViewToParent(view, childCount, layoutParams);
    }

    /* Access modifiers changed, original: final */
    public final int getChildCount() {
        return this.aha.getChildCount() - this.ahc.size();
    }

    /* Access modifiers changed, original: final */
    public final int hU() {
        return this.aha.getChildCount();
    }

    /* Access modifiers changed, original: final */
    public final View bI(int i) {
        return this.aha.getChildAt(i);
    }

    /* Access modifiers changed, original: final */
    public final void detachViewFromParent(int i) {
        int bH = bH(i);
        this.ahb.bJ(bH);
        this.aha.detachViewFromParent(bH);
    }

    /* Access modifiers changed, original: final */
    public final int indexOfChild(View view) {
        int indexOfChild = this.aha.indexOfChild(view);
        if (indexOfChild == -1 || this.ahb.get(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.ahb.bK(indexOfChild);
    }

    /* Access modifiers changed, original: final */
    public final boolean aY(View view) {
        return this.ahc.contains(view);
    }

    public final String toString() {
        return this.ahb.toString() + ", hidden list:" + this.ahc.size();
    }
}
