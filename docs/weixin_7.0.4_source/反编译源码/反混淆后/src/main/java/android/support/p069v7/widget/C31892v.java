package android.support.p069v7.widget;

import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v7.widget.v */
final class C31892v {
    final C17499b aha;
    final C17498a ahb = new C17498a();
    final List<View> ahc = new ArrayList();

    /* renamed from: android.support.v7.widget.v$a */
    static class C17498a {
        long ahd = 0;
        C17498a ahe;

        C17498a() {
        }

        /* Access modifiers changed, original: final */
        public final void set(int i) {
            while (i >= 64) {
                this.m27310hV();
                this = this.ahe;
                i -= 64;
            }
            this.ahd |= 1 << i;
        }

        /* renamed from: hV */
        private void m27310hV() {
            if (this.ahe == null) {
                this.ahe = new C17498a();
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
                this.m27310hV();
                this = this.ahe;
                i -= 64;
            }
            return (this.ahd & (1 << i)) != 0;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: m */
        public final void mo31929m(int i, boolean z) {
            while (true) {
                if (i >= 64) {
                    this.m27310hV();
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
                        this.m27310hV();
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
        /* renamed from: bJ */
        public final boolean mo31925bJ(int i) {
            while (i >= 64) {
                this.m27310hV();
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
                this.ahe.mo31925bJ(0);
            }
            return z;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: bK */
        public final int mo31926bK(int i) {
            if (this.ahe == null) {
                if (i >= 64) {
                    return Long.bitCount(this.ahd);
                }
                return Long.bitCount(this.ahd & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.ahd & ((1 << i) - 1));
            } else {
                return this.ahe.mo31926bK(i - 64) + Long.bitCount(this.ahd);
            }
        }

        public final String toString() {
            if (this.ahe == null) {
                return Long.toBinaryString(this.ahd);
            }
            return this.ahe.toString() + "xx" + Long.toBinaryString(this.ahd);
        }
    }

    /* renamed from: android.support.v7.widget.v$b */
    interface C17499b {
        /* renamed from: aZ */
        C41531v mo18461aZ(View view);

        void addView(View view, int i);

        void attachViewToParent(View view, int i, LayoutParams layoutParams);

        /* renamed from: ba */
        void mo18464ba(View view);

        /* renamed from: bb */
        void mo18465bb(View view);

        void detachViewFromParent(int i);

        View getChildAt(int i);

        int getChildCount();

        int indexOfChild(View view);

        void removeAllViews();

        void removeViewAt(int i);
    }

    C31892v(C17499b c17499b) {
        this.aha = c17499b;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: aW */
    public final void mo51989aW(View view) {
        this.ahc.add(view);
        this.aha.mo18464ba(view);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: aX */
    public final boolean mo51990aX(View view) {
        if (!this.ahc.remove(view)) {
            return false;
        }
        this.aha.mo18465bb(view);
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo51988a(View view, int i, boolean z) {
        int childCount;
        if (i < 0) {
            childCount = this.aha.getChildCount();
        } else {
            childCount = m51735bH(i);
        }
        this.ahb.mo31929m(childCount, z);
        if (z) {
            mo51989aW(view);
        }
        this.aha.addView(view, childCount);
    }

    /* renamed from: bH */
    private int m51735bH(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = this.aha.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int bK = i - (i2 - this.ahb.mo31926bK(i2));
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
        int bH = m51735bH(i);
        View childAt = this.aha.getChildAt(bH);
        if (childAt != null) {
            if (this.ahb.mo31925bJ(bH)) {
                mo51990aX(childAt);
            }
            this.aha.removeViewAt(bH);
        }
    }

    /* Access modifiers changed, original: final */
    public final View getChildAt(int i) {
        return this.aha.getChildAt(m51735bH(i));
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo51987a(View view, int i, LayoutParams layoutParams, boolean z) {
        int childCount;
        if (i < 0) {
            childCount = this.aha.getChildCount();
        } else {
            childCount = m51735bH(i);
        }
        this.ahb.mo31929m(childCount, z);
        if (z) {
            mo51989aW(view);
        }
        this.aha.attachViewToParent(view, childCount, layoutParams);
    }

    /* Access modifiers changed, original: final */
    public final int getChildCount() {
        return this.aha.getChildCount() - this.ahc.size();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: hU */
    public final int mo51996hU() {
        return this.aha.getChildCount();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bI */
    public final View mo51992bI(int i) {
        return this.aha.getChildAt(i);
    }

    /* Access modifiers changed, original: final */
    public final void detachViewFromParent(int i) {
        int bH = m51735bH(i);
        this.ahb.mo31925bJ(bH);
        this.aha.detachViewFromParent(bH);
    }

    /* Access modifiers changed, original: final */
    public final int indexOfChild(View view) {
        int indexOfChild = this.aha.indexOfChild(view);
        if (indexOfChild == -1 || this.ahb.get(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.ahb.mo31926bK(indexOfChild);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: aY */
    public final boolean mo51991aY(View view) {
        return this.ahc.contains(view);
    }

    public final String toString() {
        return this.ahb.toString() + ", hidden list:" + this.ahc.size();
    }
}
