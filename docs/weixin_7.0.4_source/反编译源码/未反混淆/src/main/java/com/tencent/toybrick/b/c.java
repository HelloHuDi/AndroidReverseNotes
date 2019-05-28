package com.tencent.toybrick.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.d.a.a;

public final class c extends h {
    private static final int[] MT = new int[]{16843284};
    public a AFT;
    private int mOrientation;
    private final Rect xv = new Rect();

    public c(Context context) {
        AppMethodBeat.i(113192);
        context.obtainStyledAttributes(MT).recycle();
        this.mOrientation = 1;
        AppMethodBeat.o(113192);
    }

    public final void a(Canvas canvas, RecyclerView recyclerView) {
        int i = 0;
        AppMethodBeat.i(113193);
        int childCount;
        int i2;
        int width;
        int round;
        if (recyclerView.getLayoutManager() == null || this.AFT.AGS == null) {
            AppMethodBeat.o(113193);
        } else if (this.mOrientation == 1) {
            if (this.AFT.AGR) {
                canvas.save();
                childCount = recyclerView.getChildCount();
                for (i2 = 0; i2 < childCount; i2++) {
                    View childAt = recyclerView.getChildAt(i2);
                    int kj = recyclerView.bm(childAt).kj();
                    if (kj >= 0) {
                        g Sg = ((b) recyclerView.getAdapter()).Sg(kj);
                        if (Sg.AGG) {
                            kj = Sg.fz(childAt)[0];
                            width = recyclerView.getWidth() - Sg.fz(childAt)[1];
                            RecyclerView.d(childAt, this.xv);
                            round = Math.round(childAt.getTranslationY()) + this.xv.bottom;
                            this.AFT.AGS.setBounds(kj, round - this.AFT.AGS.getIntrinsicHeight(), width, round);
                            this.AFT.AGS.draw(canvas);
                        }
                    }
                }
                canvas.restore();
            }
            AppMethodBeat.o(113193);
        } else {
            if (this.AFT.AGR) {
                canvas.save();
                if (recyclerView.getClipToPadding()) {
                    childCount = recyclerView.getPaddingTop();
                    width = recyclerView.getHeight() - recyclerView.getPaddingBottom();
                    canvas.clipRect(recyclerView.getPaddingLeft(), childCount, recyclerView.getWidth() - recyclerView.getPaddingRight(), width);
                    i2 = width;
                } else {
                    i2 = recyclerView.getHeight();
                    childCount = 0;
                }
                round = recyclerView.getChildCount();
                while (i < round) {
                    View childAt2 = recyclerView.getChildAt(i);
                    if (((g) this.AFT.AGQ.get(recyclerView.bm(childAt2).kj())).AGG) {
                        recyclerView.getLayoutManager();
                        i.d(childAt2, this.xv);
                        width = this.xv.right + Math.round(childAt2.getTranslationX());
                        this.AFT.AGS.setBounds(width - this.AFT.AGS.getIntrinsicWidth(), childCount, width, i2);
                        this.AFT.AGS.draw(canvas);
                    }
                    i++;
                }
                canvas.restore();
            }
            AppMethodBeat.o(113193);
        }
    }

    public final void a(Rect rect, View view, RecyclerView recyclerView, s sVar) {
        AppMethodBeat.i(113194);
        if (this.AFT.AGS == null) {
            rect.set(0, 0, 0, 0);
            AppMethodBeat.o(113194);
        } else if (this.mOrientation == 1) {
            rect.set(0, 0, 0, this.AFT.AGS.getIntrinsicHeight());
            AppMethodBeat.o(113194);
        } else {
            rect.set(0, 0, this.AFT.AGS.getIntrinsicWidth(), 0);
            AppMethodBeat.o(113194);
        }
    }
}
