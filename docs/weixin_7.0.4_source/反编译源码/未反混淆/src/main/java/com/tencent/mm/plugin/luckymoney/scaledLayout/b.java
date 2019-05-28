package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.graphics.Rect;
import android.support.v4.widget.j;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class b {
    protected final i amP;
    private int amQ;
    final Rect oT;

    public abstract int bLR();

    public abstract int bj(View view);

    public abstract int bk(View view);

    public abstract int je();

    public abstract int jg();

    /* synthetic */ b(i iVar, byte b) {
        this(iVar);
    }

    private b(i iVar) {
        this.amQ = j.INVALID_ID;
        this.oT = new Rect();
        this.amP = iVar;
    }

    public static b a(i iVar, int i) {
        switch (i) {
            case 0:
                return new b(iVar) {
                    public final int je() {
                        AppMethodBeat.i(42469);
                        int paddingLeft = this.amP.getPaddingLeft();
                        AppMethodBeat.o(42469);
                        return paddingLeft;
                    }

                    public final int bj(View view) {
                        AppMethodBeat.i(42470);
                        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                        int bv = layoutParams.rightMargin + (i.bv(view) + layoutParams.leftMargin);
                        AppMethodBeat.o(42470);
                        return bv;
                    }

                    public final int bk(View view) {
                        AppMethodBeat.i(42471);
                        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                        int bw = layoutParams.bottomMargin + (i.bw(view) + layoutParams.topMargin);
                        AppMethodBeat.o(42471);
                        return bw;
                    }

                    public final int jg() {
                        AppMethodBeat.i(42472);
                        int paddingLeft = (this.amP.mWidth - this.amP.getPaddingLeft()) - this.amP.getPaddingRight();
                        AppMethodBeat.o(42472);
                        return paddingLeft;
                    }

                    public final int bLR() {
                        AppMethodBeat.i(42473);
                        int paddingTop = (this.amP.mHeight - this.amP.getPaddingTop()) - this.amP.getPaddingBottom();
                        AppMethodBeat.o(42473);
                        return paddingTop;
                    }
                };
            case 1:
                return new b(iVar) {
                    public final int je() {
                        AppMethodBeat.i(42474);
                        int paddingTop = this.amP.getPaddingTop();
                        AppMethodBeat.o(42474);
                        return paddingTop;
                    }

                    public final int bj(View view) {
                        AppMethodBeat.i(42475);
                        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                        int bw = layoutParams.bottomMargin + (i.bw(view) + layoutParams.topMargin);
                        AppMethodBeat.o(42475);
                        return bw;
                    }

                    public final int bk(View view) {
                        AppMethodBeat.i(42476);
                        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                        int bv = layoutParams.rightMargin + (i.bv(view) + layoutParams.leftMargin);
                        AppMethodBeat.o(42476);
                        return bv;
                    }

                    public final int jg() {
                        AppMethodBeat.i(42477);
                        int paddingTop = (this.amP.mHeight - this.amP.getPaddingTop()) - this.amP.getPaddingBottom();
                        AppMethodBeat.o(42477);
                        return paddingTop;
                    }

                    public final int bLR() {
                        AppMethodBeat.i(42478);
                        int paddingLeft = (this.amP.mWidth - this.amP.getPaddingLeft()) - this.amP.getPaddingRight();
                        AppMethodBeat.o(42478);
                        return paddingLeft;
                    }
                };
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }
}
