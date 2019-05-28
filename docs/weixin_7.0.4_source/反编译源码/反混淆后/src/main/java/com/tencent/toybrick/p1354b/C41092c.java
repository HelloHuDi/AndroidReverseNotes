package com.tencent.toybrick.p1354b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.p680c.C44830g;
import com.tencent.toybrick.p681d.C5969a.C5970a;

/* renamed from: com.tencent.toybrick.b.c */
public final class C41092c extends C25373h {
    /* renamed from: MT */
    private static final int[] f16555MT = new int[]{16843284};
    public C5970a AFT;
    private int mOrientation;
    /* renamed from: xv */
    private final Rect f16556xv = new Rect();

    public C41092c(Context context) {
        AppMethodBeat.m2504i(113192);
        context.obtainStyledAttributes(f16555MT).recycle();
        this.mOrientation = 1;
        AppMethodBeat.m2505o(113192);
    }

    /* renamed from: a */
    public final void mo18494a(Canvas canvas, RecyclerView recyclerView) {
        int i = 0;
        AppMethodBeat.m2504i(113193);
        int childCount;
        int i2;
        int width;
        int round;
        if (recyclerView.getLayoutManager() == null || this.AFT.AGS == null) {
            AppMethodBeat.m2505o(113193);
        } else if (this.mOrientation == 1) {
            if (this.AFT.AGR) {
                canvas.save();
                childCount = recyclerView.getChildCount();
                for (i2 = 0; i2 < childCount; i2++) {
                    View childAt = recyclerView.getChildAt(i2);
                    int kj = recyclerView.mo66351bm(childAt).mo66454kj();
                    if (kj >= 0) {
                        C44830g Sg = ((C46820b) recyclerView.getAdapter()).mo75668Sg(kj);
                        if (Sg.AGG) {
                            kj = Sg.mo72038fz(childAt)[0];
                            width = recyclerView.getWidth() - Sg.mo72038fz(childAt)[1];
                            RecyclerView.m72551d(childAt, this.f16556xv);
                            round = Math.round(childAt.getTranslationY()) + this.f16556xv.bottom;
                            this.AFT.AGS.setBounds(kj, round - this.AFT.AGS.getIntrinsicHeight(), width, round);
                            this.AFT.AGS.draw(canvas);
                        }
                    }
                }
                canvas.restore();
            }
            AppMethodBeat.m2505o(113193);
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
                    if (((C44830g) this.AFT.AGQ.get(recyclerView.mo66351bm(childAt2).mo66454kj())).AGG) {
                        recyclerView.getLayoutManager();
                        C17480i.m27157d(childAt2, this.f16556xv);
                        width = this.f16556xv.right + Math.round(childAt2.getTranslationX());
                        this.AFT.AGS.setBounds(width - this.AFT.AGS.getIntrinsicWidth(), childCount, width, i2);
                        this.AFT.AGS.draw(canvas);
                    }
                    i++;
                }
                canvas.restore();
            }
            AppMethodBeat.m2505o(113193);
        }
    }

    /* renamed from: a */
    public final void mo18495a(Rect rect, View view, RecyclerView recyclerView, C31880s c31880s) {
        AppMethodBeat.m2504i(113194);
        if (this.AFT.AGS == null) {
            rect.set(0, 0, 0, 0);
            AppMethodBeat.m2505o(113194);
        } else if (this.mOrientation == 1) {
            rect.set(0, 0, 0, this.AFT.AGS.getIntrinsicHeight());
            AppMethodBeat.m2505o(113194);
        } else {
            rect.set(0, 0, this.AFT.AGS.getIntrinsicWidth(), 0);
            AppMethodBeat.m2505o(113194);
        }
    }
}
