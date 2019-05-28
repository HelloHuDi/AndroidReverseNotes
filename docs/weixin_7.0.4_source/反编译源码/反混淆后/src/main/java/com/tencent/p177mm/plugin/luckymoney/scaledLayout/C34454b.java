package com.tencent.p177mm.plugin.luckymoney.scaledLayout;

import android.graphics.Rect;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.luckymoney.scaledLayout.b */
public abstract class C34454b {
    protected final C17480i amP;
    private int amQ;
    /* renamed from: oT */
    final Rect f15056oT;

    public abstract int bLR();

    /* renamed from: bj */
    public abstract int mo24294bj(View view);

    /* renamed from: bk */
    public abstract int mo24295bk(View view);

    /* renamed from: je */
    public abstract int mo24296je();

    /* renamed from: jg */
    public abstract int mo24297jg();

    /* synthetic */ C34454b(C17480i c17480i, byte b) {
        this(c17480i);
    }

    private C34454b(C17480i c17480i) {
        this.amQ = C8415j.INVALID_ID;
        this.f15056oT = new Rect();
        this.amP = c17480i;
    }

    /* renamed from: a */
    public static C34454b m56464a(C17480i c17480i, int i) {
        switch (i) {
            case 0:
                return new C34454b(c17480i) {
                    /* renamed from: je */
                    public final int mo24296je() {
                        AppMethodBeat.m2504i(42469);
                        int paddingLeft = this.amP.getPaddingLeft();
                        AppMethodBeat.m2505o(42469);
                        return paddingLeft;
                    }

                    /* renamed from: bj */
                    public final int mo24294bj(View view) {
                        AppMethodBeat.m2504i(42470);
                        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                        int bv = layoutParams.rightMargin + (C17480i.m27149bv(view) + layoutParams.leftMargin);
                        AppMethodBeat.m2505o(42470);
                        return bv;
                    }

                    /* renamed from: bk */
                    public final int mo24295bk(View view) {
                        AppMethodBeat.m2504i(42471);
                        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                        int bw = layoutParams.bottomMargin + (C17480i.m27150bw(view) + layoutParams.topMargin);
                        AppMethodBeat.m2505o(42471);
                        return bw;
                    }

                    /* renamed from: jg */
                    public final int mo24297jg() {
                        AppMethodBeat.m2504i(42472);
                        int paddingLeft = (this.amP.mWidth - this.amP.getPaddingLeft()) - this.amP.getPaddingRight();
                        AppMethodBeat.m2505o(42472);
                        return paddingLeft;
                    }

                    public final int bLR() {
                        AppMethodBeat.m2504i(42473);
                        int paddingTop = (this.amP.mHeight - this.amP.getPaddingTop()) - this.amP.getPaddingBottom();
                        AppMethodBeat.m2505o(42473);
                        return paddingTop;
                    }
                };
            case 1:
                return new C34454b(c17480i) {
                    /* renamed from: je */
                    public final int mo24296je() {
                        AppMethodBeat.m2504i(42474);
                        int paddingTop = this.amP.getPaddingTop();
                        AppMethodBeat.m2505o(42474);
                        return paddingTop;
                    }

                    /* renamed from: bj */
                    public final int mo24294bj(View view) {
                        AppMethodBeat.m2504i(42475);
                        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                        int bw = layoutParams.bottomMargin + (C17480i.m27150bw(view) + layoutParams.topMargin);
                        AppMethodBeat.m2505o(42475);
                        return bw;
                    }

                    /* renamed from: bk */
                    public final int mo24295bk(View view) {
                        AppMethodBeat.m2504i(42476);
                        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                        int bv = layoutParams.rightMargin + (C17480i.m27149bv(view) + layoutParams.leftMargin);
                        AppMethodBeat.m2505o(42476);
                        return bv;
                    }

                    /* renamed from: jg */
                    public final int mo24297jg() {
                        AppMethodBeat.m2504i(42477);
                        int paddingTop = (this.amP.mHeight - this.amP.getPaddingTop()) - this.amP.getPaddingBottom();
                        AppMethodBeat.m2505o(42477);
                        return paddingTop;
                    }

                    public final int bLR() {
                        AppMethodBeat.m2504i(42478);
                        int paddingLeft = (this.amP.mWidth - this.amP.getPaddingLeft()) - this.amP.getPaddingRight();
                        AppMethodBeat.m2505o(42478);
                        return paddingLeft;
                    }
                };
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }
}
