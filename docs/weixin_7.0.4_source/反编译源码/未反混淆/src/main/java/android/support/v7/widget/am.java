package android.support.v7.widget;

import android.graphics.Rect;
import android.support.v4.widget.j;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;

public abstract class am {
    protected final i amP;
    int amQ;
    final Rect oT;

    public abstract int bf(View view);

    public abstract int bg(View view);

    public abstract int bh(View view);

    public abstract int bi(View view);

    public abstract int bj(View view);

    public abstract int bk(View view);

    public abstract void cc(int i);

    public abstract int getEnd();

    public abstract int getEndPadding();

    public abstract int getMode();

    public abstract int je();

    public abstract int jf();

    public abstract int jg();

    public abstract int jh();

    /* synthetic */ am(i iVar, byte b) {
        this(iVar);
    }

    private am(i iVar) {
        this.amQ = j.INVALID_ID;
        this.oT = new Rect();
        this.amP = iVar;
    }

    public final i getLayoutManager() {
        return this.amP;
    }

    public final int jd() {
        return j.INVALID_ID == this.amQ ? 0 : jg() - this.amQ;
    }

    public static am d(i iVar) {
        return new am(iVar) {
            public final int jf() {
                return this.amP.mWidth - this.amP.getPaddingRight();
            }

            public final int getEnd() {
                return this.amP.mWidth;
            }

            public final void cc(int i) {
                this.amP.ck(i);
            }

            public final int je() {
                return this.amP.getPaddingLeft();
            }

            public final int bj(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + (i.bv(view) + layoutParams.leftMargin);
            }

            public final int bk(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + (i.bw(view) + layoutParams.topMargin);
            }

            public final int bg(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + i.bz(view);
            }

            public final int bf(View view) {
                return i.bx(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
            }

            public final int bh(View view) {
                this.amP.f(view, this.oT);
                return this.oT.right;
            }

            public final int bi(View view) {
                this.amP.f(view, this.oT);
                return this.oT.left;
            }

            public final int jg() {
                return (this.amP.mWidth - this.amP.getPaddingLeft()) - this.amP.getPaddingRight();
            }

            public final int getEndPadding() {
                return this.amP.getPaddingRight();
            }

            public final int getMode() {
                return this.amP.aoJ;
            }

            public final int jh() {
                return this.amP.aoK;
            }
        };
    }

    public static am e(i iVar) {
        return new am(iVar) {
            public final int jf() {
                return this.amP.mHeight - this.amP.getPaddingBottom();
            }

            public final int getEnd() {
                return this.amP.mHeight;
            }

            public final void cc(int i) {
                this.amP.cl(i);
            }

            public final int je() {
                return this.amP.getPaddingTop();
            }

            public final int bj(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + (i.bw(view) + layoutParams.topMargin);
            }

            public final int bk(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + (i.bv(view) + layoutParams.leftMargin);
            }

            public final int bg(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + i.bA(view);
            }

            public final int bf(View view) {
                return i.by(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
            }

            public final int bh(View view) {
                this.amP.f(view, this.oT);
                return this.oT.bottom;
            }

            public final int bi(View view) {
                this.amP.f(view, this.oT);
                return this.oT.top;
            }

            public final int jg() {
                return (this.amP.mHeight - this.amP.getPaddingTop()) - this.amP.getPaddingBottom();
            }

            public final int getEndPadding() {
                return this.amP.getPaddingBottom();
            }

            public final int getMode() {
                return this.amP.aoK;
            }

            public final int jh() {
                return this.amP.aoJ;
            }
        };
    }
}
