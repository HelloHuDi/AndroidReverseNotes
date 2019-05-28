package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.ah;
import android.support.v7.widget.am;
import android.support.v7.widget.an;
import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends an {
    public Context context;
    public View oaV;

    public final View a(i iVar) {
        AppMethodBeat.i(42465);
        View a = super.a(iVar);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < iVar.getChildCount()) {
            int i4;
            View childAt = iVar.getChildAt(i);
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
            bW = iVar.bW(i3 + 1);
            AppMethodBeat.o(42465);
            return bW;
        } else if (i2 - i3 < -1) {
            bW = iVar.bW(i3 - 1);
            AppMethodBeat.o(42465);
            return bW;
        } else {
            AppMethodBeat.o(42465);
            return a;
        }
    }

    public final int a(i iVar, int i, int i2) {
        AppMethodBeat.i(42466);
        if (iVar.getItemCount() == 0) {
            AppMethodBeat.o(42466);
            return -1;
        }
        View h = h(iVar);
        if (h == null) {
            AppMethodBeat.o(42466);
            return -1;
        }
        if (!(this.oaV == null || this.oaV == h)) {
            h = this.oaV;
        }
        int bt = i.bt(h);
        ab.d("CusPager", "pos: %s", Integer.valueOf(bt));
        if (i >= 100 && bt + 1 < iVar.getItemCount()) {
            bt++;
            AppMethodBeat.o(42466);
            return bt;
        } else if (i > -100 || bt - 1 < 0) {
            AppMethodBeat.o(42466);
            return bt;
        } else {
            bt--;
            AppMethodBeat.o(42466);
            return bt;
        }
    }

    public static View h(i iVar) {
        View view = null;
        AppMethodBeat.i(42467);
        int childCount = iVar.getChildCount();
        if (childCount == 0) {
            AppMethodBeat.o(42467);
        } else {
            int je;
            am d = am.d(iVar);
            if (iVar.getClipToPadding()) {
                je = d.je() + (d.jg() / 2);
            } else {
                je = d.getEnd() / 2;
            }
            int i = BaseClientBuilder.API_PRIORITY_OTHER;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = iVar.getChildAt(i2);
                int abs = Math.abs((d.bf(childAt) + (d.bj(childAt) / 2)) - je);
                if (abs >= i) {
                    abs = i;
                    childAt = view;
                }
                i2++;
                i = abs;
                view = childAt;
            }
            AppMethodBeat.o(42467);
        }
        return view;
    }

    public final r g(final i iVar) {
        AppMethodBeat.i(42468);
        AnonymousClass1 anonymousClass1 = new ah(this.context) {
            public final void a(View view, android.support.v7.widget.RecyclerView.r.a aVar) {
                AppMethodBeat.i(42463);
                int[] a = a.this.a(iVar, view);
                int i = a[0];
                int i2 = a[1];
                int ca = ca(Math.max(Math.abs(i), Math.abs(i2)));
                if (ca > 0) {
                    aVar.a(i, i2, ca, this.Sf);
                }
                AppMethodBeat.o(42463);
            }

            public final float c(DisplayMetrics displayMetrics) {
                return 50.0f / ((float) displayMetrics.densityDpi);
            }

            public final int cb(int i) {
                AppMethodBeat.i(42464);
                int min = Math.min(50, super.cb(i));
                AppMethodBeat.o(42464);
                return min;
            }
        };
        AppMethodBeat.o(42468);
        return anonymousClass1;
    }
}
