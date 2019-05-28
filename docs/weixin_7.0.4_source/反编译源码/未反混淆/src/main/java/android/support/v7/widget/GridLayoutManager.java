package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.a.b.c;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    boolean akT = false;
    int akU = -1;
    int[] akV;
    View[] akW;
    final SparseIntArray akX = new SparseIntArray();
    final SparseIntArray akY = new SparseIntArray();
    public b akZ = new a();
    final Rect ala = new Rect();

    public static abstract class b {
        final SparseIntArray ald = new SparseIntArray();
        private boolean ale = false;

        public abstract int bU(int i);

        /* Access modifiers changed, original: final */
        public final int ab(int i, int i2) {
            if (!this.ale) {
                return aa(i, i2);
            }
            int i3 = this.ald.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            i3 = aa(i, i2);
            this.ald.put(i, i3);
            return i3;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0055  */
        /* JADX WARNING: Removed duplicated region for block: B:41:? A:{SYNTHETIC, RETURN} */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x006b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int aa(int i, int i2) {
            int bU = bU(i);
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
                    i3 = this.ald.get(size) + bU(size);
                    size++;
                    i4 = size;
                    while (i4 < i) {
                        size = bU(i4);
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

        public final int ac(int i, int i2) {
            int bU = bU(i);
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < i) {
                int bU2 = bU(i3);
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

    public static final class a extends b {
        public final int bU(int i) {
            return 1;
        }

        public final int aa(int i, int i2) {
            return i % i2;
        }
    }

    public static class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
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
        bT(i);
    }

    public GridLayoutManager(int i, byte b) {
        super(1);
        bT(i);
    }

    public final int a(o oVar, s sVar) {
        if (this.mOrientation == 0) {
            return this.akU;
        }
        if (sVar.getItemCount() <= 0) {
            return 0;
        }
        return a(oVar, sVar, sVar.getItemCount() - 1) + 1;
    }

    public final int b(o oVar, s sVar) {
        if (this.mOrientation == 1) {
            return this.akU;
        }
        if (sVar.getItemCount() <= 0) {
            return 0;
        }
        return a(oVar, sVar, sVar.getItemCount() - 1) + 1;
    }

    public final void a(o oVar, s sVar, View view, android.support.v4.view.a.b bVar) {
        boolean z = false;
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            int a = a(oVar, sVar, layoutParams2.aoM.ki());
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
                bVar.H(c.b(i, i2, a, 1, z2));
                return;
            }
            i = layoutParams2.alb;
            i2 = layoutParams2.alc;
            if (this.akU > 1 && layoutParams2.alc == this.akU) {
                z = true;
            }
            bVar.H(c.b(a, 1, i, i2, z));
            return;
        }
        super.a(view, bVar);
    }

    public final void a(s sVar) {
        super.a(sVar);
        this.akT = false;
    }

    public final void c(RecyclerView recyclerView, int i, int i2) {
        this.akZ.ald.clear();
    }

    public final void a(RecyclerView recyclerView) {
        this.akZ.ald.clear();
    }

    public final void d(RecyclerView recyclerView, int i, int i2) {
        this.akZ.ald.clear();
    }

    public final void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.akZ.ald.clear();
    }

    public final void a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.akZ.ald.clear();
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams iA() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams d(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public final boolean a(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final void a(b bVar) {
        this.akZ = bVar;
    }

    private void iB() {
        int paddingRight;
        if (getOrientation() == 1) {
            paddingRight = (this.mWidth - getPaddingRight()) - getPaddingLeft();
        } else {
            paddingRight = (this.mHeight - getPaddingBottom()) - getPaddingTop();
        }
        bS(paddingRight);
    }

    public final void a(Rect rect, int i, int i2) {
        if (this.akV == null) {
            super.a(rect, i, i2);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            paddingTop = i.l(i2, paddingTop + rect.height(), android.support.v4.view.s.aa(this.aiB));
            paddingRight = i.l(i, paddingRight + this.akV[this.akV.length - 1], android.support.v4.view.s.Z(this.aiB));
        } else {
            paddingRight = i.l(i, paddingRight + rect.width(), android.support.v4.view.s.Z(this.aiB));
            paddingTop = i.l(i2, paddingTop + this.akV[this.akV.length - 1], android.support.v4.view.s.aa(this.aiB));
        }
        setMeasuredDimension(paddingRight, paddingTop);
    }

    private void bS(int i) {
        this.akV = d(this.akV, this.akU, i);
    }

    private static int[] d(int[] iArr, int i, int i2) {
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

    private int Z(int i, int i2) {
        if (this.mOrientation == 1 && ib()) {
            return this.akV[this.akU - i] - this.akV[(this.akU - i) - i2];
        }
        return this.akV[i + i2] - this.akV[i];
    }

    /* Access modifiers changed, original: final */
    public final void a(o oVar, s sVar, a aVar, int i) {
        Object obj = 1;
        super.a(oVar, sVar, aVar, i);
        iB();
        if (sVar.getItemCount() > 0 && !sVar.apv) {
            if (i != 1) {
                obj = null;
            }
            int b = b(oVar, sVar, aVar.mPosition);
            if (obj != null) {
                while (b > 0 && aVar.mPosition > 0) {
                    aVar.mPosition--;
                    b = b(oVar, sVar, aVar.mPosition);
                }
            } else {
                int itemCount = sVar.getItemCount() - 1;
                int i2 = aVar.mPosition;
                while (i2 < itemCount) {
                    int b2 = b(oVar, sVar, i2 + 1);
                    if (b2 <= b) {
                        break;
                    }
                    i2++;
                    b = b2;
                }
                aVar.mPosition = i2;
            }
        }
        iC();
    }

    private void iC() {
        if (this.akW == null || this.akW.length != this.akU) {
            this.akW = new View[this.akU];
        }
    }

    public final int a(int i, o oVar, s sVar) {
        iB();
        iC();
        return super.a(i, oVar, sVar);
    }

    public final int b(int i, o oVar, s sVar) {
        iB();
        iC();
        return super.b(i, oVar, sVar);
    }

    /* Access modifiers changed, original: final */
    public final View a(o oVar, s sVar, int i, int i2, int i3) {
        int i4;
        iJ();
        int je = this.alA.je();
        int jf = this.alA.jf();
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
            int bt = i.bt(childAt);
            if (bt >= 0 && bt < i3 && b(oVar, sVar, bt) == 0) {
                if (((android.support.v7.widget.RecyclerView.LayoutParams) childAt.getLayoutParams()).aoM.isRemoved()) {
                    if (view2 == null) {
                        view3 = view;
                        view2 = childAt;
                        i += i4;
                        view = view3;
                    }
                } else if (this.alA.bf(childAt) < jf && this.alA.bg(childAt) >= je) {
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

    private int b(o oVar, s sVar, int i) {
        if (!sVar.apv) {
            return this.akZ.ab(i, this.akU);
        }
        int i2 = this.akY.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = oVar.cp(i);
        if (i2 == -1) {
            return 0;
        }
        return this.akZ.ab(i2, this.akU);
    }

    private int c(o oVar, s sVar, int i) {
        if (!sVar.apv) {
            return this.akZ.bU(i);
        }
        int i2 = this.akX.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = oVar.cp(i);
        if (i2 == -1) {
            return 1;
        }
        return this.akZ.bU(i2);
    }

    /* Access modifiers changed, original: final */
    public final void a(s sVar, c cVar, android.support.v7.widget.RecyclerView.i.a aVar) {
        int i = this.akU;
        for (int i2 = 0; i2 < this.akU && cVar.b(sVar) && i > 0; i2++) {
            int i3 = cVar.alh;
            aVar.T(i3, Math.max(0, cVar.alS));
            i -= this.akZ.bU(i3);
            cVar.alh += cVar.ali;
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(o oVar, s sVar, c cVar, b bVar) {
        boolean z;
        int i;
        int c;
        int jh = this.alA.jh();
        Object obj = jh != ErrorDialogData.SUPPRESSED ? 1 : null;
        int i2 = getChildCount() > 0 ? this.akV[this.akU] : 0;
        if (obj != null) {
            iB();
        }
        if (cVar.ali == 1) {
            z = true;
        } else {
            z = false;
        }
        int i3 = 0;
        int i4 = this.akU;
        if (!z) {
            i4 = b(oVar, sVar, cVar.alh) + c(oVar, sVar, cVar.alh);
        }
        while (i3 < this.akU && cVar.b(sVar) && i4 > 0) {
            i = cVar.alh;
            c = c(oVar, sVar, i);
            if (c <= this.akU) {
                i4 -= c;
                if (i4 < 0) {
                    break;
                }
                View a = cVar.a(oVar);
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
            bVar.mFinished = true;
            return;
        }
        int i5;
        int i6;
        LayoutParams layoutParams;
        c = 0;
        float f = 0.0f;
        a(oVar, sVar, i3, z);
        int i7 = 0;
        while (i7 < i3) {
            View view = this.akW[i7];
            if (cVar.alW == null) {
                if (z) {
                    addView(view, -1);
                } else {
                    addView(view, 0);
                }
            } else if (z) {
                z(view, -1);
            } else {
                z(view, 0);
            }
            g(view, this.ala);
            b(view, jh, false);
            i4 = this.alA.bj(view);
            if (i4 > c) {
                c = i4;
            }
            float bk = (((float) this.alA.bk(view)) * 1.0f) / ((float) ((LayoutParams) view.getLayoutParams()).alc);
            if (bk <= f) {
                bk = f;
            }
            i7++;
            f = bk;
        }
        if (obj != null) {
            bS(Math.max(Math.round(((float) this.akU) * f), i2));
            i5 = 0;
            i6 = 0;
            while (i6 < i3) {
                View view2 = this.akW[i6];
                b(view2, (int) ErrorDialogData.SUPPRESSED, true);
                i4 = this.alA.bj(view2);
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
            if (this.alA.bj(view3) != i5) {
                layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.ala;
                i = ((rect.top + rect.bottom) + layoutParams.topMargin) + layoutParams.bottomMargin;
                i6 = ((rect.right + rect.left) + layoutParams.leftMargin) + layoutParams.rightMargin;
                i2 = Z(layoutParams.alb, layoutParams.alc);
                if (this.mOrientation == 1) {
                    i4 = i.c(i2, ErrorDialogData.SUPPRESSED, i6, layoutParams.width, false);
                    i = MeasureSpec.makeMeasureSpec(i5 - i, ErrorDialogData.SUPPRESSED);
                } else {
                    i6 = MeasureSpec.makeMeasureSpec(i5 - i6, ErrorDialogData.SUPPRESSED);
                    i = i.c(i2, ErrorDialogData.SUPPRESSED, i, layoutParams.height, false);
                    i4 = i6;
                }
                a(view3, i4, i, true);
            }
        }
        bVar.alQ = i5;
        i4 = 0;
        c = 0;
        i = 0;
        if (this.mOrientation == 1) {
            if (cVar.sE == -1) {
                i6 = cVar.Lp;
                i = i6 - i5;
                i5 = i6;
            } else {
                i6 = cVar.Lp;
                i5 += i6;
                i = i6;
            }
        } else if (cVar.sE == -1) {
            c = cVar.Lp;
            i4 = c - i5;
            i5 = 0;
        } else {
            i4 = cVar.Lp;
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
                i = c + this.alA.bk(view4);
                i5 = i6;
            } else if (ib()) {
                i6 = this.akV[this.akU - layoutParams.alb] + getPaddingLeft();
                i5 = i6 - this.alA.bk(view4);
                i = i7;
                c = i2;
                jh = i6;
            } else {
                i5 = getPaddingLeft() + this.akV[layoutParams.alb];
                i = i7;
                c = i2;
                jh = this.alA.bk(view4) + i5;
            }
            i.k(view4, i5, c, jh, i);
            if (layoutParams.aoM.isRemoved() || layoutParams.aoM.kx()) {
                bVar.alR = true;
            }
            bVar.YP |= view4.hasFocusable();
            i8++;
            i6 = i5;
            i7 = i;
            i2 = c;
        }
        Arrays.fill(this.akW, null);
    }

    private void b(View view, int i, boolean z) {
        int c;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.ala;
        int i2 = ((rect.top + rect.bottom) + layoutParams.topMargin) + layoutParams.bottomMargin;
        int i3 = layoutParams.rightMargin + ((rect.right + rect.left) + layoutParams.leftMargin);
        int Z = Z(layoutParams.alb, layoutParams.alc);
        if (this.mOrientation == 1) {
            Z = i.c(Z, i, i3, layoutParams.width, false);
            c = i.c(this.alA.jg(), this.aoK, i2, layoutParams.height, true);
            i2 = Z;
        } else {
            Z = i.c(Z, i, i2, layoutParams.height, false);
            i2 = i.c(this.alA.jg(), this.aoJ, i3, layoutParams.width, true);
            c = Z;
        }
        a(view, i2, c, z);
    }

    private void a(View view, int i, int i2, boolean z) {
        boolean a;
        android.support.v7.widget.RecyclerView.LayoutParams layoutParams = (android.support.v7.widget.RecyclerView.LayoutParams) view.getLayoutParams();
        if (z) {
            a = a(view, i, i2, layoutParams);
        } else {
            a = b(view, i, i2, layoutParams);
        }
        if (a) {
            view.measure(i, i2);
        }
    }

    private void a(o oVar, s sVar, int i, boolean z) {
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
            layoutParams.alc = c(oVar, sVar, i.bt(view));
            layoutParams.alb = i4;
            i4 += layoutParams.alc;
            i3 += i2;
        }
    }

    public final int iD() {
        return this.akU;
    }

    public final void bT(int i) {
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

    public final View a(View view, int i, o oVar, s sVar) {
        View bl = bl(view);
        if (bl == null) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) bl.getLayoutParams();
        int i2 = layoutParams.alb;
        int i3 = layoutParams.alb + layoutParams.alc;
        if (super.a(view, i, oVar, sVar) == null) {
            return null;
        }
        int childCount;
        int i4;
        int i5;
        Object obj;
        if (((bZ(i) == 1) != this.alD ? 1 : null) != null) {
            childCount = getChildCount() - 1;
            i4 = -1;
            i5 = -1;
        } else {
            childCount = 0;
            i4 = 1;
            i5 = getChildCount();
        }
        if (this.mOrientation == 1 && ib()) {
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
        int a = a(oVar, sVar, childCount);
        for (int i10 = childCount; i10 != i5; i10 += i4) {
            int a2 = a(oVar, sVar, i10);
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
                        Object obj3 = (this.aoA.bV(childAt) && this.aoB.bV(childAt)) ? 1 : null;
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

    public boolean iE() {
        return this.alJ == null && !this.akT;
    }

    public void c(o oVar, s sVar) {
        if (sVar.apv) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
                int ki = layoutParams.aoM.ki();
                this.akX.put(ki, layoutParams.alc);
                this.akY.put(ki, layoutParams.alb);
            }
        }
        super.c(oVar, sVar);
        this.akX.clear();
        this.akY.clear();
    }

    private int a(o oVar, s sVar, int i) {
        if (!sVar.apv) {
            return this.akZ.ac(i, this.akU);
        }
        int cp = oVar.cp(i);
        if (cp == -1) {
            return 0;
        }
        return this.akZ.ac(cp, this.akU);
    }
}
