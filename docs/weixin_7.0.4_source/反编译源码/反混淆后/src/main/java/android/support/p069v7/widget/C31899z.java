package android.support.p069v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.view.View;

/* renamed from: android.support.v7.widget.z */
public final class C31899z extends C25373h {
    /* renamed from: MT */
    private static final int[] f14657MT = new int[]{16843284};
    private Drawable ahS;
    private int mOrientation;
    /* renamed from: xv */
    private final Rect f14658xv = new Rect();

    public C31899z(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f14657MT);
        this.ahS = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        this.mOrientation = 1;
    }

    public final void setDrawable(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        this.ahS = drawable;
    }

    /* renamed from: a */
    public final void mo6920a(Canvas canvas, RecyclerView recyclerView, C31880s c31880s) {
        int i = 0;
        if (recyclerView.getLayoutManager() != null && this.ahS != null) {
            int paddingLeft;
            int width;
            int childCount;
            View childAt;
            int round;
            if (this.mOrientation == 1) {
                canvas.save();
                if (recyclerView.getClipToPadding()) {
                    paddingLeft = recyclerView.getPaddingLeft();
                    width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                    canvas.clipRect(paddingLeft, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
                } else {
                    width = recyclerView.getWidth();
                    paddingLeft = 0;
                }
                childCount = recyclerView.getChildCount();
                while (i < childCount) {
                    childAt = recyclerView.getChildAt(i);
                    RecyclerView.m72551d(childAt, this.f14658xv);
                    round = Math.round(childAt.getTranslationY()) + this.f14658xv.bottom;
                    this.ahS.setBounds(paddingLeft, round - this.ahS.getIntrinsicHeight(), width, round);
                    this.ahS.draw(canvas);
                    i++;
                }
                canvas.restore();
                return;
            }
            canvas.save();
            if (recyclerView.getClipToPadding()) {
                paddingLeft = recyclerView.getPaddingTop();
                width = recyclerView.getHeight() - recyclerView.getPaddingBottom();
                canvas.clipRect(recyclerView.getPaddingLeft(), paddingLeft, recyclerView.getWidth() - recyclerView.getPaddingRight(), width);
            } else {
                width = recyclerView.getHeight();
                paddingLeft = 0;
            }
            childCount = recyclerView.getChildCount();
            while (i < childCount) {
                childAt = recyclerView.getChildAt(i);
                recyclerView.getLayoutManager();
                C17480i.m27157d(childAt, this.f14658xv);
                round = Math.round(childAt.getTranslationX()) + this.f14658xv.right;
                this.ahS.setBounds(round - this.ahS.getIntrinsicWidth(), paddingLeft, round, width);
                this.ahS.draw(canvas);
                i++;
            }
            canvas.restore();
        }
    }

    /* renamed from: a */
    public final void mo18495a(Rect rect, View view, RecyclerView recyclerView, C31880s c31880s) {
        if (this.ahS == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.mOrientation == 1) {
            rect.set(0, 0, 0, this.ahS.getIntrinsicHeight());
        } else {
            rect.set(0, 0, this.ahS.getIntrinsicWidth(), 0);
        }
    }
}
