package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;

public final class z extends h {
    private static final int[] MT = new int[]{16843284};
    private Drawable ahS;
    private int mOrientation;
    private final Rect xv = new Rect();

    public z(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(MT);
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

    public final void a(Canvas canvas, RecyclerView recyclerView, s sVar) {
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
                    RecyclerView.d(childAt, this.xv);
                    round = Math.round(childAt.getTranslationY()) + this.xv.bottom;
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
                i.d(childAt, this.xv);
                round = Math.round(childAt.getTranslationX()) + this.xv.right;
                this.ahS.setBounds(round - this.ahS.getIntrinsicWidth(), paddingLeft, round, width);
                this.ahS.draw(canvas);
                i++;
            }
            canvas.restore();
        }
    }

    public final void a(Rect rect, View view, RecyclerView recyclerView, s sVar) {
        if (this.ahS == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.mOrientation == 1) {
            rect.set(0, 0, 0, this.ahS.getIntrinsicHeight());
        } else {
            rect.set(0, 0, this.ahS.getIntrinsicWidth(), 0);
        }
    }
}
