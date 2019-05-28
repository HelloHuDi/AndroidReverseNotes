package android.support.p069v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.view.p067a.C0445b;
import android.support.p057v4.view.p067a.C0445b.C0444c;
import android.support.p069v7.widget.LinearLayoutManager.C0654c;
import android.support.p069v7.widget.LinearLayoutManager.C0655a;
import android.support.p069v7.widget.LinearLayoutManager.C0656b;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C17480i.C17481a;
import android.support.p069v7.widget.RecyclerView.C25374o;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import java.util.Arrays;

/* renamed from: android.support.v7.widget.GridLayoutManager */
public class GridLayoutManager extends LinearLayoutManager {
    boolean akT = false;
    int akU = -1;
    int[] akV;
    View[] akW;
    final SparseIntArray akX = new SparseIntArray();
    final SparseIntArray akY = new SparseIntArray();
    public C8440b akZ = new C25368a();
    final Rect ala = new Rect();

    /* renamed from: android.support.v7.widget.GridLayoutManager$b */
    public static abstract class C8440b {
        final SparseIntArray ald = new SparseIntArray();
        private boolean ale = false;

        /* renamed from: bU */
        public abstract int mo18459bU(int i);

        /* Access modifiers changed, original: final */
        /* renamed from: ab */
        public final int mo18457ab(int i, int i2) {
            if (!this.ale) {
                return mo18456aa(i, i2);
            }
            int i3 = this.ald.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            i3 = mo18456aa(i, i2);
            this.ald.put(i, i3);
            return i3;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0055  */
        /* JADX WARNING: Removed duplicated region for block: B:41:? A:{SYNTHETIC, RETURN} */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x006b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: aa */
        public int mo18456aa(int i, int i2) {
            int bU = mo18459bU(i);
            if (bU == i2) {
                return 0;
            }
            int size;
            int i3;
            int i4;
            if (this.ale && this.ald.size() > 0) {
                size = this.ald.size() - 1;
                i3 = 0;
                while (i3 <= size) {
                    i4 = (i3 + size) >>> 1;
                    if (this.ald.keyAt(i4) < i) {
                        i3 = i4 + 1;
                    } else {
                        size = i4 - 1;
                    }
                }
                size = i3 - 1;
                if (size < 0 || size >= this.ald.size()) {
                    size = -1;
                } else {
                    size = this.ald.keyAt(size);
                }
                if (size >= 0) {
                    i3 = this.ald.get(size) + mo18459bU(size);
                    size++;
                    i4 = size;
                    while (i4 < i) {
                        size = mo18459bU(i4);
                        i3 += size;
                        if (i3 == i2) {
                            size = 0;
                        } else if (i3 <= i2) {
                            size = i3;
                        }
                        i4++;
                        i3 = size;
                    }
                    if (i3 + bU > i2) {
                        return i3;
                    }
                    return 0;
                }
            }
            size = 0;
            i3 = 0;
            i4 = size;
            while (i4 < i) {
            }
            if (i3 + bU > i2) {
            }
        }

        /* renamed from: ac */
        public final int mo18458ac(int i, int i2) {
            int bU = mo18459bU(i);
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < i) {
                int bU2 = mo18459bU(i3);
                int i6 = i5 + bU2;
                if (i6 == i2) {
                    i4++;
                    bU2 = 0;
                } else if (i6 > i2) {
                    i4++;
                } else {
                    bU2 = i6;
                }
                i3++;
                i5 = bU2;
            }
            if (i5 + bU > i2) {
                return i4 + 1;
            }
            return i4;
        }
    }

    /* renamed from: android.support.v7.widget.GridLayoutManager$a */
    public static final class C25368a extends C8440b {
        /* renamed from: bU */
        public final int mo18459bU(int i) {
            return 1;
        }

        /* renamed from: aa */
        public final int mo18456aa(int i, int i2) {
            return i % i2;
        }
    }

    /* renamed from: android.support.v7.widget.GridLayoutManager$LayoutParams */
    public static class LayoutParams extends android.support.p069v7.widget.RecyclerView.LayoutParams {
        int alb = -1;
        int alc = 0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public GridLayoutManager(int i) {
        mo51942bT(i);
    }

    public GridLayoutManager(int i, byte b) {
        super(1);
        mo51942bT(i);
    }

    /* renamed from: a */
    public final int mo31824a(C25374o c25374o, C31880s c31880s) {
        if (this.mOrientation == 0) {
            return this.akU;
        }
        if (c31880s.getItemCount() <= 0) {
            return 0;
        }
        return m51657a(c25374o, c31880s, c31880s.getItemCount() - 1) + 1;
    }

    /* renamed from: b */
    public final int mo31844b(C25374o c25374o, C31880s c31880s) {
        if (this.mOrientation == 1) {
            return this.akU;
        }
        if (c31880s.getItemCount() <= 0) {
            return 0;
        }
        return m51657a(c25374o, c31880s, c31880s.getItemCount() - 1) + 1;
    }

    /* renamed from: a */
    public final void mo31828a(C25374o c25374o, C31880s c31880s, View view, C0445b c0445b) {
        boolean z = false;
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            int a = m51657a(c25374o, c31880s, layoutParams2.aoM.mo66453ki());
            int i;
            int i2;
            if (this.mOrientation == 0) {
                boolean z2;
                i = layoutParams2.alb;
                i2 = layoutParams2.alc;
                if (this.akU <= 1 || layoutParams2.alc != this.akU) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                c0445b.mo985H(C0444c.m769b(i, i2, a, 1, z2));
                return;
            }
            i = layoutParams2.alb;
            i2 = layoutParams2.alc;
            if (this.akU > 1 && layoutParams2.alc == this.akU) {
                z = true;
            }
            c0445b.mo985H(C0444c.m769b(a, 1, i, i2, z));
            return;
        }
        super.mo31832a(view, c0445b);
    }

    /* renamed from: a */
    public final void mo1753a(C31880s c31880s) {
        super.mo1753a(c31880s);
        this.akT = false;
    }

    /* renamed from: c */
    public final void mo15123c(RecyclerView recyclerView, int i, int i2) {
        this.akZ.ald.clear();
    }

    /* renamed from: a */
    public final void mo15122a(RecyclerView recyclerView) {
        this.akZ.ald.clear();
    }

    /* renamed from: d */
    public final void mo15125d(RecyclerView recyclerView, int i, int i2) {
        this.akZ.ald.clear();
    }

    /* renamed from: a */
    public final void mo31831a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.akZ.ald.clear();
    }

    /* renamed from: a */
    public final void mo31830a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.akZ.ald.clear();
    }

    /* renamed from: iA */
    public final RecyclerView.LayoutParams mo1773iA() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    /* renamed from: a */
    public final RecyclerView.LayoutParams mo31825a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    /* renamed from: d */
    public final RecyclerView.LayoutParams mo31853d(LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* renamed from: a */
    public final boolean mo31834a(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* renamed from: a */
    public final void mo51941a(C8440b c8440b) {
        this.akZ = c8440b;
    }

    /* renamed from: iB */
    private void m51665iB() {
        int paddingRight;
        if (getOrientation() == 1) {
            paddingRight = (this.mWidth - getPaddingRight()) - getPaddingLeft();
        } else {
            paddingRight = (this.mHeight - getPaddingBottom()) - getPaddingTop();
        }
        m51662bS(paddingRight);
    }

    /* renamed from: a */
    public final void mo31827a(Rect rect, int i, int i2) {
        if (this.akV == null) {
            super.mo31827a(rect, i, i2);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            paddingTop = C17480i.m27162l(i2, paddingTop + rect.height(), C0477s.m909aa(this.aiB));
            paddingRight = C17480i.m27162l(i, paddingRight + this.akV[this.akV.length - 1], C0477s.m899Z(this.aiB));
        } else {
            paddingRight = C17480i.m27162l(i, paddingRight + rect.width(), C0477s.m899Z(this.aiB));
            paddingTop = C17480i.m27162l(i2, paddingTop + this.akV[this.akV.length - 1], C0477s.m909aa(this.aiB));
        }
        setMeasuredDimension(paddingRight, paddingTop);
    }

    /* renamed from: bS */
    private void m51662bS(int i) {
        this.akV = GridLayoutManager.m51664d(this.akV, this.akU, i);
    }

    /* renamed from: d */
    private static int[] m51664d(int[] iArr, int i, int i2) {
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        iArr[0] = 0;
        int i3 = i2 / i;
        int i4 = i2 % i;
        int i5 = 1;
        int i6 = 0;
        int i7 = 0;
        while (i5 <= i) {
            int i8;
            i6 += i4;
            if (i6 <= 0 || i - i6 >= i4) {
                i8 = i3;
            } else {
                i8 = i3 + 1;
                i6 -= i;
            }
            int i9 = i7 + i8;
            iArr[i5] = i9;
            i5++;
            i7 = i9;
        }
        return iArr;
    }

    /* renamed from: Z */
    private int m51656Z(int i, int i2) {
        if (this.mOrientation == 1 && mo1784ib()) {
            return this.akV[this.akU - i] - this.akV[(this.akU - i) - i2];
        }
        return this.akV[i + i2] - this.akV[i];
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo1751a(C25374o c25374o, C31880s c31880s, C0655a c0655a, int i) {
        Object obj = 1;
        super.mo1751a(c25374o, c31880s, c0655a, i);
        m51665iB();
        if (c31880s.getItemCount() > 0 && !c31880s.apv) {
            if (i != 1) {
                obj = null;
            }
            int b = m51660b(c25374o, c31880s, c0655a.mPosition);
            if (obj != null) {
                while (b > 0 && c0655a.mPosition > 0) {
                    c0655a.mPosition--;
                    b = m51660b(c25374o, c31880s, c0655a.mPosition);
                }
            } else {
                int itemCount = c31880s.getItemCount() - 1;
                int i2 = c0655a.mPosition;
                while (i2 < itemCount) {
                    int b2 = m51660b(c25374o, c31880s, i2 + 1);
                    if (b2 <= b) {
                        break;
                    }
                    i2++;
                    b = b2;
                }
                c0655a.mPosition = i2;
            }
        }
        m51666iC();
    }

    /* renamed from: iC */
    private void m51666iC() {
        if (this.akW == null || this.akW.length != this.akU) {
            this.akW = new View[this.akU];
        }
    }

    /* renamed from: a */
    public final int mo1746a(int i, C25374o c25374o, C31880s c31880s) {
        m51665iB();
        m51666iC();
        return super.mo1746a(i, c25374o, c31880s);
    }

    /* renamed from: b */
    public final int mo1759b(int i, C25374o c25374o, C31880s c31880s) {
        m51665iB();
        m51666iC();
        return super.mo1759b(i, c25374o, c31880s);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final View mo1747a(C25374o c25374o, C31880s c31880s, int i, int i2, int i3) {
        int i4;
        mo1778iJ();
        int je = this.alA.mo31905je();
        int jf = this.alA.mo31906jf();
        if (i2 > i) {
            i4 = 1;
        } else {
            i4 = -1;
        }
        View view = null;
        View view2 = null;
        while (i != i2) {
            View view3;
            View childAt = getChildAt(i);
            int bt = C17480i.m27148bt(childAt);
            if (bt >= 0 && bt < i3 && m51660b(c25374o, c31880s, bt) == 0) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).aoM.isRemoved()) {
                    if (view2 == null) {
                        view3 = view;
                        view2 = childAt;
                        i += i4;
                        view = view3;
                    }
                } else if (this.alA.mo31893bf(childAt) < jf && this.alA.mo31894bg(childAt) >= je) {
                    return childAt;
                } else {
                    if (view == null) {
                        view3 = childAt;
                        i += i4;
                        view = view3;
                    }
                }
            }
            view3 = view;
            i += i4;
            view = view3;
        }
        return view != null ? view : view2;
    }

    /* renamed from: b */
    private int m51660b(C25374o c25374o, C31880s c31880s, int i) {
        if (!c31880s.apv) {
            return this.akZ.mo18457ab(i, this.akU);
        }
        int i2 = this.akY.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = c25374o.mo42371cp(i);
        if (i2 == -1) {
            return 0;
        }
        return this.akZ.mo18457ab(i2, this.akU);
    }

    /* renamed from: c */
    private int m51663c(C25374o c25374o, C31880s c31880s, int i) {
        if (!c31880s.apv) {
            return this.akZ.mo18459bU(i);
        }
        int i2 = this.akX.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = c25374o.mo42371cp(i);
        if (i2 == -1) {
            return 1;
        }
        return this.akZ.mo18459bU(i2);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo1754a(C31880s c31880s, C0654c c0654c, C17481a c17481a) {
        int i = this.akU;
        for (int i2 = 0; i2 < this.akU && c0654c.mo1790b(c31880s) && i > 0; i2++) {
            int i3 = c0654c.alh;
            c17481a.mo18521T(i3, Math.max(0, c0654c.alS));
            i -= this.akZ.mo18459bU(i3);
            c0654c.alh += c0654c.ali;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo1752a(C25374o c25374o, C31880s c31880s, C0654c c0654c, C0656b c0656b) {
        boolean z;
        int i;
        int c;
        int jh = this.alA.mo31908jh();
        Object obj = jh != ErrorDialogData.SUPPRESSED ? 1 : null;
        int i2 = getChildCount() > 0 ? this.akV[this.akU] : 0;
        if (obj != null) {
            m51665iB();
        }
        if (c0654c.ali == 1) {
            z = true;
        } else {
            z = false;
        }
        int i3 = 0;
        int i4 = this.akU;
        if (!z) {
            i4 = m51660b(c25374o, c31880s, c0654c.alh) + m51663c(c25374o, c31880s, c0654c.alh);
        }
        while (i3 < this.akU && c0654c.mo1790b(c31880s) && i4 > 0) {
            i = c0654c.alh;
            c = m51663c(c25374o, c31880s, i);
            if (c <= this.akU) {
                i4 -= c;
                if (i4 < 0) {
                    break;
                }
                View a = c0654c.mo1789a(c25374o);
                if (a == null) {
                    break;
                }
                this.akW[i3] = a;
                i3++;
            } else {
                throw new IllegalArgumentException("Item at position " + i + " requires " + c + " spans but GridLayoutManager has only " + this.akU + " spans.");
            }
        }
        if (i3 == 0) {
            c0656b.mFinished = true;
            return;
        }
        int i5;
        int i6;
        LayoutParams layoutParams;
        c = 0;
        float f = 0.0f;
        m51658a(c25374o, c31880s, i3, z);
        int i7 = 0;
        while (i7 < i3) {
            View view = this.akW[i7];
            if (c0654c.alW == null) {
                if (z) {
                    addView(view, -1);
                } else {
                    addView(view, 0);
                }
            } else if (z) {
                mo31882z(view, -1);
            } else {
                mo31882z(view, 0);
            }
            mo31859g(view, this.ala);
            m51661b(view, jh, false);
            i4 = this.alA.mo31897bj(view);
            if (i4 > c) {
                c = i4;
            }
            float bk = (((float) this.alA.mo31898bk(view)) * 1.0f) / ((float) ((LayoutParams) view.getLayoutParams()).alc);
            if (bk <= f) {
                bk = f;
            }
            i7++;
            f = bk;
        }
        if (obj != null) {
            m51662bS(Math.max(Math.round(((float) this.akU) * f), i2));
            i5 = 0;
            i6 = 0;
            while (i6 < i3) {
                View view2 = this.akW[i6];
                m51661b(view2, (int) ErrorDialogData.SUPPRESSED, true);
                i4 = this.alA.mo31897bj(view2);
                if (i4 <= i5) {
                    i4 = i5;
                }
                i6++;
                i5 = i4;
            }
        } else {
            i5 = c;
        }
        for (c = 0; c < i3; c++) {
            View view3 = this.akW[c];
            if (this.alA.mo31897bj(view3) != i5) {
                layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.ala;
                i = ((rect.top + rect.bottom) + layoutParams.topMargin) + layoutParams.bottomMargin;
                i6 = ((rect.right + rect.left) + layoutParams.leftMargin) + layoutParams.rightMargin;
                i2 = m51656Z(layoutParams.alb, layoutParams.alc);
                if (this.mOrientation == 1) {
                    i4 = C17480i.m27154c(i2, ErrorDialogData.SUPPRESSED, i6, layoutParams.width, false);
                    i = MeasureSpec.makeMeasureSpec(i5 - i, ErrorDialogData.SUPPRESSED);
                } else {
                    i6 = MeasureSpec.makeMeasureSpec(i5 - i6, ErrorDialogData.SUPPRESSED);
                    i = C17480i.m27154c(i2, ErrorDialogData.SUPPRESSED, i, layoutParams.height, false);
                    i4 = i6;
                }
                m51659a(view3, i4, i, true);
            }
        }
        c0656b.alQ = i5;
        i4 = 0;
        c = 0;
        i = 0;
        if (this.mOrientation == 1) {
            if (c0654c.f1000sE == -1) {
                i6 = c0654c.f999Lp;
                i = i6 - i5;
                i5 = i6;
            } else {
                i6 = c0654c.f999Lp;
                i5 += i6;
                i = i6;
            }
        } else if (c0654c.f1000sE == -1) {
            c = c0654c.f999Lp;
            i4 = c - i5;
            i5 = 0;
        } else {
            i4 = c0654c.f999Lp;
            c = i4 + i5;
            i5 = 0;
        }
        int i8 = 0;
        i6 = i4;
        i7 = i5;
        i2 = i;
        jh = c;
        while (i8 < i3) {
            View view4 = this.akW[i8];
            layoutParams = (LayoutParams) view4.getLayoutParams();
            if (this.mOrientation != 1) {
                c = getPaddingTop() + this.akV[layoutParams.alb];
                i = c + this.alA.mo31898bk(view4);
                i5 = i6;
            } else if (mo1784ib()) {
                i6 = this.akV[this.akU - layoutParams.alb] + getPaddingLeft();
                i5 = i6 - this.alA.mo31898bk(view4);
                i = i7;
                c = i2;
                jh = i6;
            } else {
                i5 = getPaddingLeft() + this.akV[layoutParams.alb];
                i = i7;
                c = i2;
                jh = this.alA.mo31898bk(view4) + i5;
            }
            C17480i.m27161k(view4, i5, c, jh, i);
            if (layoutParams.aoM.isRemoved() || layoutParams.aoM.mo66467kx()) {
                c0656b.alR = true;
            }
            c0656b.f1001YP |= view4.hasFocusable();
            i8++;
            i6 = i5;
            i7 = i;
            i2 = c;
        }
        Arrays.fill(this.akW, null);
    }

    /* renamed from: b */
    private void m51661b(View view, int i, boolean z) {
        int c;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.ala;
        int i2 = ((rect.top + rect.bottom) + layoutParams.topMargin) + layoutParams.bottomMargin;
        int i3 = layoutParams.rightMargin + ((rect.right + rect.left) + layoutParams.leftMargin);
        int Z = m51656Z(layoutParams.alb, layoutParams.alc);
        if (this.mOrientation == 1) {
            Z = C17480i.m27154c(Z, i, i3, layoutParams.width, false);
            c = C17480i.m27154c(this.alA.mo31907jg(), this.aoK, i2, layoutParams.height, true);
            i2 = Z;
        } else {
            Z = C17480i.m27154c(Z, i, i2, layoutParams.height, false);
            i2 = C17480i.m27154c(this.alA.mo31907jg(), this.aoJ, i3, layoutParams.width, true);
            c = Z;
        }
        m51659a(view, i2, c, z);
    }

    /* renamed from: a */
    private void m51659a(View view, int i, int i2, boolean z) {
        boolean a;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z) {
            a = mo31837a(view, i, i2, layoutParams);
        } else {
            a = mo31847b(view, i, i2, layoutParams);
        }
        if (a) {
            view.measure(i, i2);
        }
    }

    /* renamed from: a */
    private void m51658a(C25374o c25374o, C31880s c31880s, int i, boolean z) {
        int i2;
        int i3;
        int i4 = 0;
        if (z) {
            i2 = 1;
            i3 = 0;
        } else {
            i3 = i - 1;
            i2 = -1;
            i = -1;
        }
        while (i3 != i) {
            View view = this.akW[i3];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.alc = m51663c(c25374o, c31880s, C17480i.m27148bt(view));
            layoutParams.alb = i4;
            i4 += layoutParams.alc;
            i3 += i2;
        }
    }

    /* renamed from: iD */
    public final int mo51943iD() {
        return this.akU;
    }

    /* renamed from: bT */
    public final void mo51942bT(int i) {
        if (i != this.akU) {
            this.akT = true;
            if (i <= 0) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided ".concat(String.valueOf(i)));
            }
            this.akU = i;
            this.akZ.ald.clear();
            requestLayout();
        }
    }

    /* renamed from: a */
    public final View mo1748a(View view, int i, C25374o c25374o, C31880s c31880s) {
        View bl = mo31848bl(view);
        if (bl == null) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) bl.getLayoutParams();
        int i2 = layoutParams.alb;
        int i3 = layoutParams.alb + layoutParams.alc;
        if (super.mo1748a(view, i, c25374o, c31880s) == null) {
            return null;
        }
        int childCount;
        int i4;
        int i5;
        Object obj;
        if (((mo1763bZ(i) == 1) != this.alD ? 1 : null) != null) {
            childCount = getChildCount() - 1;
            i4 = -1;
            i5 = -1;
        } else {
            childCount = 0;
            i4 = 1;
            i5 = getChildCount();
        }
        if (this.mOrientation == 1 && mo1784ib()) {
            obj = 1;
        } else {
            obj = null;
        }
        View view2 = null;
        int i6 = -1;
        int i7 = 0;
        View view3 = null;
        int i8 = -1;
        int i9 = 0;
        int a = m51657a(c25374o, c31880s, childCount);
        for (int i10 = childCount; i10 != i5; i10 += i4) {
            int a2 = m51657a(c25374o, c31880s, i10);
            View childAt = getChildAt(i10);
            if (childAt == bl) {
                break;
            }
            if (!childAt.hasFocusable() || a2 == a) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i11 = layoutParams.alb;
                int i12 = layoutParams.alb + layoutParams.alc;
                if (childAt.hasFocusable() && i11 == i2 && i12 == i3) {
                    return childAt;
                }
                Object obj2 = null;
                if (!(childAt.hasFocusable() && view2 == null) && (childAt.hasFocusable() || view3 != null)) {
                    int min = Math.min(i12, i3) - Math.max(i11, i2);
                    if (childAt.hasFocusable()) {
                        if (min > i7) {
                            obj2 = 1;
                        } else if (min == i7) {
                            if (obj == (i11 > i6 ? 1 : null)) {
                                obj2 = 1;
                            }
                        }
                    } else if (view2 == null) {
                        Object obj3 = (this.aoA.mo31923bV(childAt) && this.aoB.mo31923bV(childAt)) ? 1 : null;
                        if (obj3 == null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (obj3 != null) {
                            if (min > i9) {
                                obj2 = 1;
                            } else if (min == i9) {
                                if (obj == (i11 > i8 ? 1 : null)) {
                                    obj2 = 1;
                                }
                            }
                        }
                    }
                } else {
                    obj2 = 1;
                }
                if (obj2 != null) {
                    if (childAt.hasFocusable()) {
                        i6 = layoutParams.alb;
                        i7 = Math.min(i12, i3) - Math.max(i11, i2);
                        a2 = i9;
                        childCount = i8;
                        view2 = childAt;
                    } else {
                        childCount = layoutParams.alb;
                        a2 = Math.min(i12, i3) - Math.max(i11, i2);
                        view3 = childAt;
                    }
                }
                a2 = i9;
                childCount = i8;
            } else {
                if (view2 != null) {
                    break;
                }
                a2 = i9;
                childCount = i8;
            }
            i9 = a2;
            i8 = childCount;
        }
        if (view2 != null) {
            return view2;
        }
        return view3;
    }

    /* renamed from: iE */
    public boolean mo1774iE() {
        return this.alJ == null && !this.akT;
    }

    /* renamed from: c */
    public void mo1765c(C25374o c25374o, C31880s c31880s) {
        if (c31880s.apv) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
                int ki = layoutParams.aoM.mo66453ki();
                this.akX.put(ki, layoutParams.alc);
                this.akY.put(ki, layoutParams.alb);
            }
        }
        super.mo1765c(c25374o, c31880s);
        this.akX.clear();
        this.akY.clear();
    }

    /* renamed from: a */
    private int m51657a(C25374o c25374o, C31880s c31880s, int i) {
        if (!c31880s.apv) {
            return this.akZ.mo18458ac(i, this.akU);
        }
        int cp = c25374o.mo42371cp(i);
        if (cp == -1) {
            return 0;
        }
        return this.akZ.mo18458ac(cp, this.akU);
    }
}
