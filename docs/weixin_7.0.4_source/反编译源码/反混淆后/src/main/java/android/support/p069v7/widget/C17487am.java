package android.support.p069v7.widget;

import android.graphics.Rect;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.LayoutParams;
import android.view.View;

/* renamed from: android.support.v7.widget.am */
public abstract class C17487am {
    protected final C17480i amP;
    int amQ;
    /* renamed from: oT */
    final Rect f4038oT;

    /* renamed from: bf */
    public abstract int mo31893bf(View view);

    /* renamed from: bg */
    public abstract int mo31894bg(View view);

    /* renamed from: bh */
    public abstract int mo31895bh(View view);

    /* renamed from: bi */
    public abstract int mo31896bi(View view);

    /* renamed from: bj */
    public abstract int mo31897bj(View view);

    /* renamed from: bk */
    public abstract int mo31898bk(View view);

    /* renamed from: cc */
    public abstract void mo31899cc(int i);

    public abstract int getEnd();

    public abstract int getEndPadding();

    public abstract int getMode();

    /* renamed from: je */
    public abstract int mo31905je();

    /* renamed from: jf */
    public abstract int mo31906jf();

    /* renamed from: jg */
    public abstract int mo31907jg();

    /* renamed from: jh */
    public abstract int mo31908jh();

    /* synthetic */ C17487am(C17480i c17480i, byte b) {
        this(c17480i);
    }

    private C17487am(C17480i c17480i) {
        this.amQ = C8415j.INVALID_ID;
        this.f4038oT = new Rect();
        this.amP = c17480i;
    }

    public final C17480i getLayoutManager() {
        return this.amP;
    }

    /* renamed from: jd */
    public final int mo31904jd() {
        return C8415j.INVALID_ID == this.amQ ? 0 : mo31907jg() - this.amQ;
    }

    /* renamed from: d */
    public static C17487am m27241d(C17480i c17480i) {
        return new C17487am(c17480i) {
            /* renamed from: jf */
            public final int mo31906jf() {
                return this.amP.mWidth - this.amP.getPaddingRight();
            }

            public final int getEnd() {
                return this.amP.mWidth;
            }

            /* renamed from: cc */
            public final void mo31899cc(int i) {
                this.amP.mo31851ck(i);
            }

            /* renamed from: je */
            public final int mo31905je() {
                return this.amP.getPaddingLeft();
            }

            /* renamed from: bj */
            public final int mo31897bj(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + (C17480i.m27149bv(view) + layoutParams.leftMargin);
            }

            /* renamed from: bk */
            public final int mo31898bk(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + (C17480i.m27150bw(view) + layoutParams.topMargin);
            }

            /* renamed from: bg */
            public final int mo31894bg(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + C17480i.m27153bz(view);
            }

            /* renamed from: bf */
            public final int mo31893bf(View view) {
                return C17480i.m27151bx(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
            }

            /* renamed from: bh */
            public final int mo31895bh(View view) {
                this.amP.mo31857f(view, this.f4038oT);
                return this.f4038oT.right;
            }

            /* renamed from: bi */
            public final int mo31896bi(View view) {
                this.amP.mo31857f(view, this.f4038oT);
                return this.f4038oT.left;
            }

            /* renamed from: jg */
            public final int mo31907jg() {
                return (this.amP.mWidth - this.amP.getPaddingLeft()) - this.amP.getPaddingRight();
            }

            public final int getEndPadding() {
                return this.amP.getPaddingRight();
            }

            public final int getMode() {
                return this.amP.aoJ;
            }

            /* renamed from: jh */
            public final int mo31908jh() {
                return this.amP.aoK;
            }
        };
    }

    /* renamed from: e */
    public static C17487am m27242e(C17480i c17480i) {
        return new C17487am(c17480i) {
            /* renamed from: jf */
            public final int mo31906jf() {
                return this.amP.mHeight - this.amP.getPaddingBottom();
            }

            public final int getEnd() {
                return this.amP.mHeight;
            }

            /* renamed from: cc */
            public final void mo31899cc(int i) {
                this.amP.mo31852cl(i);
            }

            /* renamed from: je */
            public final int mo31905je() {
                return this.amP.getPaddingTop();
            }

            /* renamed from: bj */
            public final int mo31897bj(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + (C17480i.m27150bw(view) + layoutParams.topMargin);
            }

            /* renamed from: bk */
            public final int mo31898bk(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + (C17480i.m27149bv(view) + layoutParams.leftMargin);
            }

            /* renamed from: bg */
            public final int mo31894bg(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + C17480i.m27143bA(view);
            }

            /* renamed from: bf */
            public final int mo31893bf(View view) {
                return C17480i.m27152by(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
            }

            /* renamed from: bh */
            public final int mo31895bh(View view) {
                this.amP.mo31857f(view, this.f4038oT);
                return this.f4038oT.bottom;
            }

            /* renamed from: bi */
            public final int mo31896bi(View view) {
                this.amP.mo31857f(view, this.f4038oT);
                return this.f4038oT.top;
            }

            /* renamed from: jg */
            public final int mo31907jg() {
                return (this.amP.mHeight - this.amP.getPaddingTop()) - this.amP.getPaddingBottom();
            }

            public final int getEndPadding() {
                return this.amP.getPaddingBottom();
            }

            public final int getMode() {
                return this.amP.aoK;
            }

            /* renamed from: jh */
            public final int mo31908jh() {
                return this.amP.aoJ;
            }
        };
    }
}
