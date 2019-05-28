package com.tencent.p177mm.plugin.topstory.p541ui.video.p542fs;

import android.graphics.PointF;
import android.support.p069v7.widget.C17487am;
import android.support.p069v7.widget.C41189ah;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C37139r.C37138a;
import android.support.p069v7.widget.RecyclerView.C37139r.C37140b;
import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.topstory.p541ui.widget.C14004g;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.b */
public final class C43696b extends C14004g {
    private C17487am amf;
    private C17487am amg;

    /* renamed from: a */
    public final int[] mo26234a(C17480i c17480i, View view) {
        AppMethodBeat.m2504i(1862);
        int[] iArr = new int[2];
        if (c17480i.mo1776iG()) {
            iArr[0] = C43696b.m78287a(c17480i, view, m78290c(c17480i));
        } else {
            iArr[0] = 0;
        }
        if (c17480i.mo1777iH()) {
            iArr[1] = C43696b.m78287a(c17480i, view, m78289b(c17480i));
        } else {
            iArr[1] = 0;
        }
        AppMethodBeat.m2505o(1862);
        return iArr;
    }

    /* renamed from: a */
    public final View mo26233a(C17480i c17480i) {
        AppMethodBeat.m2504i(1863);
        View a;
        if (c17480i.mo1777iH()) {
            a = C43696b.m78288a(c17480i, m78289b(c17480i));
            AppMethodBeat.m2505o(1863);
            return a;
        } else if (c17480i.mo1776iG()) {
            a = C43696b.m78288a(c17480i, m78290c(c17480i));
            AppMethodBeat.m2505o(1863);
            return a;
        } else {
            AppMethodBeat.m2505o(1863);
            return null;
        }
    }

    /* renamed from: a */
    public final int mo26232a(C17480i c17480i, int i, int i2) {
        Object obj = null;
        AppMethodBeat.m2504i(1864);
        if (Math.abs(i2) <= 500 || Math.abs(i) >= Math.abs(i2)) {
            AppMethodBeat.m2505o(1864);
            return -1;
        }
        int itemCount = c17480i.getItemCount();
        if (itemCount == 0) {
            AppMethodBeat.m2505o(1864);
            return -1;
        }
        View view = null;
        if (c17480i.mo1777iH()) {
            view = C43696b.m78291c(c17480i, m78289b(c17480i));
        } else if (c17480i.mo1776iG()) {
            view = C43696b.m78291c(c17480i, m78290c(c17480i));
        }
        if (view == null) {
            AppMethodBeat.m2505o(1864);
            return -1;
        }
        int bt = C17480i.m27148bt(view);
        if (bt == -1) {
            AppMethodBeat.m2505o(1864);
            return -1;
        }
        Object obj2;
        int obj22;
        if (c17480i.mo1776iG()) {
            obj22 = i > 0 ? 1 : null;
        } else if (i2 > 0) {
            obj22 = 1;
        } else {
            obj22 = null;
        }
        if (c17480i instanceof C37140b) {
            PointF bX = ((C37140b) c17480i).mo1761bX(itemCount - 1);
            if (bX != null && (bX.x < 0.0f || bX.y < 0.0f)) {
                obj = 1;
            }
        }
        if (obj != null) {
            if (obj22 != null) {
                obj22 = bt - 1;
                AppMethodBeat.m2505o(1864);
                return obj22;
            }
            AppMethodBeat.m2505o(1864);
            return bt;
        } else if (obj22 != null) {
            obj22 = bt + 1;
            AppMethodBeat.m2505o(1864);
            return obj22;
        } else {
            AppMethodBeat.m2505o(1864);
            return bt;
        }
    }

    /* renamed from: f */
    public final C41189ah mo26236f(C17480i c17480i) {
        AppMethodBeat.m2504i(1865);
        if (c17480i instanceof C37140b) {
            C41189ah c436971 = new C41189ah(this.aiB.getContext()) {
                /* renamed from: a */
                public final void mo9234a(View view, C37138a c37138a) {
                    AppMethodBeat.m2504i(1860);
                    int[] a = C43696b.this.mo26234a(C43696b.this.aiB.getLayoutManager(), view);
                    int i = a[0];
                    int i2 = a[1];
                    int ca = mo65816ca(Math.max(Math.abs(i), Math.abs(i2)));
                    if (ca > 0) {
                        c37138a.mo59203a(i, i2, ca, this.f16584Sf);
                    }
                    AppMethodBeat.m2505o(1860);
                }

                /* renamed from: c */
                public final float mo9235c(DisplayMetrics displayMetrics) {
                    return 100.0f / ((float) displayMetrics.densityDpi);
                }

                /* renamed from: cb */
                public final int mo30874cb(int i) {
                    AppMethodBeat.m2504i(1861);
                    int min = Math.min(100, super.mo30874cb(i));
                    AppMethodBeat.m2505o(1861);
                    return min;
                }
            };
            AppMethodBeat.m2505o(1865);
            return c436971;
        }
        AppMethodBeat.m2505o(1865);
        return null;
    }

    /* renamed from: a */
    private static int m78287a(C17480i c17480i, View view, C17487am c17487am) {
        int je;
        AppMethodBeat.m2504i(1866);
        int bj = (c17487am.mo31897bj(view) / 2) + c17487am.mo31893bf(view);
        if (c17480i.getClipToPadding()) {
            je = c17487am.mo31905je() + (c17487am.mo31907jg() / 2);
        } else {
            je = c17487am.getEnd() / 2;
        }
        je = bj - je;
        AppMethodBeat.m2505o(1866);
        return je;
    }

    /* renamed from: a */
    private static View m78288a(C17480i c17480i, C17487am c17487am) {
        View view = null;
        AppMethodBeat.m2504i(1867);
        int childCount = c17480i.getChildCount();
        if (childCount == 0) {
            AppMethodBeat.m2505o(1867);
        } else {
            int je;
            if (c17480i.getClipToPadding()) {
                je = c17487am.mo31905je() + (c17487am.mo31907jg() / 2);
            } else {
                je = c17487am.getEnd() / 2;
            }
            int i = BaseClientBuilder.API_PRIORITY_OTHER;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = c17480i.getChildAt(i2);
                int abs = Math.abs((c17487am.mo31893bf(childAt) + (c17487am.mo31897bj(childAt) / 2)) - je);
                if (abs >= i) {
                    abs = i;
                    childAt = view;
                }
                i2++;
                i = abs;
                view = childAt;
            }
            AppMethodBeat.m2505o(1867);
        }
        return view;
    }

    /* renamed from: c */
    private static View m78291c(C17480i c17480i, C17487am c17487am) {
        View view = null;
        AppMethodBeat.m2504i(1868);
        int childCount = c17480i.getChildCount();
        if (childCount == 0) {
            AppMethodBeat.m2505o(1868);
        } else {
            int i = BaseClientBuilder.API_PRIORITY_OTHER;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = c17480i.getChildAt(i2);
                int bf = c17487am.mo31893bf(childAt);
                if (bf >= i) {
                    bf = i;
                    childAt = view;
                }
                i2++;
                i = bf;
                view = childAt;
            }
            AppMethodBeat.m2505o(1868);
        }
        return view;
    }

    /* renamed from: b */
    private C17487am m78289b(C17480i c17480i) {
        AppMethodBeat.m2504i(1869);
        if (this.amf == null || this.amf.getLayoutManager() != c17480i) {
            this.amf = C17487am.m27242e(c17480i);
        }
        C17487am c17487am = this.amf;
        AppMethodBeat.m2505o(1869);
        return c17487am;
    }

    /* renamed from: c */
    private C17487am m78290c(C17480i c17480i) {
        AppMethodBeat.m2504i(1870);
        if (this.amg == null || this.amg.getLayoutManager() != c17480i) {
            this.amg = C17487am.m27241d(c17480i);
        }
        C17487am c17487am = this.amg;
        AppMethodBeat.m2505o(1870);
        return c17487am;
    }
}
