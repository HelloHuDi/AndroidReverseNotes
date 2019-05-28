package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.graphics.PointF;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.r.a;
import android.support.v7.widget.ah;
import android.support.v7.widget.am;
import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.widget.g;

public final class b extends g {
    private am amf;
    private am amg;

    public final int[] a(i iVar, View view) {
        AppMethodBeat.i(1862);
        int[] iArr = new int[2];
        if (iVar.iG()) {
            iArr[0] = a(iVar, view, c(iVar));
        } else {
            iArr[0] = 0;
        }
        if (iVar.iH()) {
            iArr[1] = a(iVar, view, b(iVar));
        } else {
            iArr[1] = 0;
        }
        AppMethodBeat.o(1862);
        return iArr;
    }

    public final View a(i iVar) {
        AppMethodBeat.i(1863);
        View a;
        if (iVar.iH()) {
            a = a(iVar, b(iVar));
            AppMethodBeat.o(1863);
            return a;
        } else if (iVar.iG()) {
            a = a(iVar, c(iVar));
            AppMethodBeat.o(1863);
            return a;
        } else {
            AppMethodBeat.o(1863);
            return null;
        }
    }

    public final int a(i iVar, int i, int i2) {
        Object obj = null;
        AppMethodBeat.i(1864);
        if (Math.abs(i2) <= 500 || Math.abs(i) >= Math.abs(i2)) {
            AppMethodBeat.o(1864);
            return -1;
        }
        int itemCount = iVar.getItemCount();
        if (itemCount == 0) {
            AppMethodBeat.o(1864);
            return -1;
        }
        View view = null;
        if (iVar.iH()) {
            view = c(iVar, b(iVar));
        } else if (iVar.iG()) {
            view = c(iVar, c(iVar));
        }
        if (view == null) {
            AppMethodBeat.o(1864);
            return -1;
        }
        int bt = i.bt(view);
        if (bt == -1) {
            AppMethodBeat.o(1864);
            return -1;
        }
        Object obj2;
        int obj22;
        if (iVar.iG()) {
            obj22 = i > 0 ? 1 : null;
        } else if (i2 > 0) {
            obj22 = 1;
        } else {
            obj22 = null;
        }
        if (iVar instanceof android.support.v7.widget.RecyclerView.r.b) {
            PointF bX = ((android.support.v7.widget.RecyclerView.r.b) iVar).bX(itemCount - 1);
            if (bX != null && (bX.x < 0.0f || bX.y < 0.0f)) {
                obj = 1;
            }
        }
        if (obj != null) {
            if (obj22 != null) {
                obj22 = bt - 1;
                AppMethodBeat.o(1864);
                return obj22;
            }
            AppMethodBeat.o(1864);
            return bt;
        } else if (obj22 != null) {
            obj22 = bt + 1;
            AppMethodBeat.o(1864);
            return obj22;
        } else {
            AppMethodBeat.o(1864);
            return bt;
        }
    }

    public final ah f(i iVar) {
        AppMethodBeat.i(1865);
        if (iVar instanceof android.support.v7.widget.RecyclerView.r.b) {
            ah anonymousClass1 = new ah(this.aiB.getContext()) {
                public final void a(View view, a aVar) {
                    AppMethodBeat.i(1860);
                    int[] a = b.this.a(b.this.aiB.getLayoutManager(), view);
                    int i = a[0];
                    int i2 = a[1];
                    int ca = ca(Math.max(Math.abs(i), Math.abs(i2)));
                    if (ca > 0) {
                        aVar.a(i, i2, ca, this.Sf);
                    }
                    AppMethodBeat.o(1860);
                }

                public final float c(DisplayMetrics displayMetrics) {
                    return 100.0f / ((float) displayMetrics.densityDpi);
                }

                public final int cb(int i) {
                    AppMethodBeat.i(1861);
                    int min = Math.min(100, super.cb(i));
                    AppMethodBeat.o(1861);
                    return min;
                }
            };
            AppMethodBeat.o(1865);
            return anonymousClass1;
        }
        AppMethodBeat.o(1865);
        return null;
    }

    private static int a(i iVar, View view, am amVar) {
        int je;
        AppMethodBeat.i(1866);
        int bj = (amVar.bj(view) / 2) + amVar.bf(view);
        if (iVar.getClipToPadding()) {
            je = amVar.je() + (amVar.jg() / 2);
        } else {
            je = amVar.getEnd() / 2;
        }
        je = bj - je;
        AppMethodBeat.o(1866);
        return je;
    }

    private static View a(i iVar, am amVar) {
        View view = null;
        AppMethodBeat.i(1867);
        int childCount = iVar.getChildCount();
        if (childCount == 0) {
            AppMethodBeat.o(1867);
        } else {
            int je;
            if (iVar.getClipToPadding()) {
                je = amVar.je() + (amVar.jg() / 2);
            } else {
                je = amVar.getEnd() / 2;
            }
            int i = BaseClientBuilder.API_PRIORITY_OTHER;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = iVar.getChildAt(i2);
                int abs = Math.abs((amVar.bf(childAt) + (amVar.bj(childAt) / 2)) - je);
                if (abs >= i) {
                    abs = i;
                    childAt = view;
                }
                i2++;
                i = abs;
                view = childAt;
            }
            AppMethodBeat.o(1867);
        }
        return view;
    }

    private static View c(i iVar, am amVar) {
        View view = null;
        AppMethodBeat.i(1868);
        int childCount = iVar.getChildCount();
        if (childCount == 0) {
            AppMethodBeat.o(1868);
        } else {
            int i = BaseClientBuilder.API_PRIORITY_OTHER;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = iVar.getChildAt(i2);
                int bf = amVar.bf(childAt);
                if (bf >= i) {
                    bf = i;
                    childAt = view;
                }
                i2++;
                i = bf;
                view = childAt;
            }
            AppMethodBeat.o(1868);
        }
        return view;
    }

    private am b(i iVar) {
        AppMethodBeat.i(1869);
        if (this.amf == null || this.amf.getLayoutManager() != iVar) {
            this.amf = am.e(iVar);
        }
        am amVar = this.amf;
        AppMethodBeat.o(1869);
        return amVar;
    }

    private am c(i iVar) {
        AppMethodBeat.i(1870);
        if (this.amg == null || this.amg.getLayoutManager() != iVar) {
            this.amg = am.d(iVar);
        }
        am amVar = this.amg;
        AppMethodBeat.o(1870);
        return amVar;
    }
}
