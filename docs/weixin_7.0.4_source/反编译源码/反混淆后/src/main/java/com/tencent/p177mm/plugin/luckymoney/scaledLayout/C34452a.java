package com.tencent.p177mm.plugin.luckymoney.scaledLayout;

import android.content.Context;
import android.support.p069v7.widget.C17487am;
import android.support.p069v7.widget.C17491an;
import android.support.p069v7.widget.C41189ah;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C37139r;
import android.support.p069v7.widget.RecyclerView.C37139r.C37138a;
import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.luckymoney.scaledLayout.a */
public final class C34452a extends C17491an {
    public Context context;
    public View oaV;

    /* renamed from: a */
    public final View mo31910a(C17480i c17480i) {
        AppMethodBeat.m2504i(42465);
        View a = super.mo31910a(c17480i);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < c17480i.getChildCount()) {
            int i4;
            View childAt = c17480i.getChildAt(i);
            if (childAt == a) {
                i4 = i;
            } else {
                i4 = i2;
            }
            if (childAt == this.oaV) {
                i3 = i;
            }
            i++;
            i2 = i4;
        }
        View bW;
        if (i2 - i3 > 1) {
            bW = c17480i.mo1760bW(i3 + 1);
            AppMethodBeat.m2505o(42465);
            return bW;
        } else if (i2 - i3 < -1) {
            bW = c17480i.mo1760bW(i3 - 1);
            AppMethodBeat.m2505o(42465);
            return bW;
        } else {
            AppMethodBeat.m2505o(42465);
            return a;
        }
    }

    /* renamed from: a */
    public final int mo31909a(C17480i c17480i, int i, int i2) {
        AppMethodBeat.m2504i(42466);
        if (c17480i.getItemCount() == 0) {
            AppMethodBeat.m2505o(42466);
            return -1;
        }
        View h = C34452a.m56457h(c17480i);
        if (h == null) {
            AppMethodBeat.m2505o(42466);
            return -1;
        }
        if (!(this.oaV == null || this.oaV == h)) {
            h = this.oaV;
        }
        int bt = C17480i.m27148bt(h);
        C4990ab.m7411d("CusPager", "pos: %s", Integer.valueOf(bt));
        if (i >= 100 && bt + 1 < c17480i.getItemCount()) {
            bt++;
            AppMethodBeat.m2505o(42466);
            return bt;
        } else if (i > -100 || bt - 1 < 0) {
            AppMethodBeat.m2505o(42466);
            return bt;
        } else {
            bt--;
            AppMethodBeat.m2505o(42466);
            return bt;
        }
    }

    /* renamed from: h */
    public static View m56457h(C17480i c17480i) {
        View view = null;
        AppMethodBeat.m2504i(42467);
        int childCount = c17480i.getChildCount();
        if (childCount == 0) {
            AppMethodBeat.m2505o(42467);
        } else {
            int je;
            C17487am d = C17487am.m27241d(c17480i);
            if (c17480i.getClipToPadding()) {
                je = d.mo31905je() + (d.mo31907jg() / 2);
            } else {
                je = d.getEnd() / 2;
            }
            int i = BaseClientBuilder.API_PRIORITY_OTHER;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = c17480i.getChildAt(i2);
                int abs = Math.abs((d.mo31893bf(childAt) + (d.mo31897bj(childAt) / 2)) - je);
                if (abs >= i) {
                    abs = i;
                    childAt = view;
                }
                i2++;
                i = abs;
                view = childAt;
            }
            AppMethodBeat.m2505o(42467);
        }
        return view;
    }

    /* renamed from: g */
    public final C37139r mo42392g(final C17480i c17480i) {
        AppMethodBeat.m2504i(42468);
        C344531 c344531 = new C41189ah(this.context) {
            /* renamed from: a */
            public final void mo9234a(View view, C37138a c37138a) {
                AppMethodBeat.m2504i(42463);
                int[] a = C34452a.this.mo9101a(c17480i, view);
                int i = a[0];
                int i2 = a[1];
                int ca = mo65816ca(Math.max(Math.abs(i), Math.abs(i2)));
                if (ca > 0) {
                    c37138a.mo59203a(i, i2, ca, this.f16584Sf);
                }
                AppMethodBeat.m2505o(42463);
            }

            /* renamed from: c */
            public final float mo9235c(DisplayMetrics displayMetrics) {
                return 50.0f / ((float) displayMetrics.densityDpi);
            }

            /* renamed from: cb */
            public final int mo30874cb(int i) {
                AppMethodBeat.m2504i(42464);
                int min = Math.min(50, super.mo30874cb(i));
                AppMethodBeat.m2505o(42464);
                return min;
            }
        };
        AppMethodBeat.m2505o(42468);
        return c344531;
    }
}
