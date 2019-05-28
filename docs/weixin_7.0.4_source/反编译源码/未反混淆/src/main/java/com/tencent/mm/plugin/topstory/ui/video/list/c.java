package com.tencent.mm.plugin.topstory.ui.video.list;

import android.graphics.PointF;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.r.a;
import android.support.v7.widget.ah;
import android.support.v7.widget.am;
import android.util.DisplayMetrics;
import android.view.View;
import com.facebook.device.yearclass.YearClass;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.widget.g;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends g {
    private am amf;
    private am amg;
    b sDo;

    public c(b bVar) {
        this.sDo = bVar;
    }

    public final int[] a(i iVar, View view) {
        AppMethodBeat.i(2015);
        int[] iArr = new int[2];
        if (iVar.iG()) {
            iArr[0] = a(view, c(iVar));
        } else {
            iArr[0] = 0;
        }
        if (iVar.iH()) {
            iArr[1] = a(view, b(iVar));
        } else {
            iArr[1] = 0;
        }
        AppMethodBeat.o(2015);
        return iArr;
    }

    public final View a(i iVar) {
        AppMethodBeat.i(YearClass.CLASS_2016);
        View a;
        if (iVar.iH()) {
            a = a(iVar, b(iVar));
            AppMethodBeat.o(YearClass.CLASS_2016);
            return a;
        } else if (iVar.iG()) {
            a = a(iVar, c(iVar));
            AppMethodBeat.o(YearClass.CLASS_2016);
            return a;
        } else {
            AppMethodBeat.o(YearClass.CLASS_2016);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(i iVar, int i, int i2) {
        int i3 = -1;
        AppMethodBeat.i(2017);
        if (Math.abs(i2) <= 500 || Math.abs(i) >= Math.abs(i2)) {
            AppMethodBeat.o(2017);
        } else {
            int itemCount = iVar.getItemCount();
            if (itemCount == 0) {
                AppMethodBeat.o(2017);
            } else {
                int cFY = this.sDo.cFY() + 1;
                if (cFY == -1) {
                    AppMethodBeat.o(2017);
                } else {
                    boolean z = iVar.iG() ? i > 0 : i2 > 0;
                    if (iVar instanceof r.b) {
                        PointF bX = ((r.b) iVar).bX(itemCount - 1);
                        if (bX != null) {
                            if (bX.x < 0.0f || bX.y < 0.0f) {
                                i3 = 1;
                            } else {
                                i3 = 0;
                            }
                            if (i3 == 0) {
                                if (!z) {
                                    i3 = cFY + 1;
                                }
                                i3 = cFY - 1;
                            } else {
                                if (z) {
                                    i3 = cFY + 1;
                                }
                                i3 = cFY - 1;
                            }
                            ab.i("MicroMsg.TopStory.TopStoryVideoPagerSnapHelper", "findTargetSnapPosition velocityY: %d centerPosition: %d forwardDirection: %b result: %d currentPlayPos: %d", Integer.valueOf(i2), Integer.valueOf(cFY), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(this.sDo.cFY() + 1));
                            AppMethodBeat.o(2017);
                        }
                    }
                    i3 = 0;
                    if (i3 == 0) {
                    }
                    ab.i("MicroMsg.TopStory.TopStoryVideoPagerSnapHelper", "findTargetSnapPosition velocityY: %d centerPosition: %d forwardDirection: %b result: %d currentPlayPos: %d", Integer.valueOf(i2), Integer.valueOf(cFY), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(this.sDo.cFY() + 1));
                    AppMethodBeat.o(2017);
                }
            }
        }
        return i3;
    }

    public final ah f(i iVar) {
        AppMethodBeat.i(2018);
        if (iVar instanceof r.b) {
            ah anonymousClass1 = new ah(this.aiB.getContext()) {
                public final void a(View view, a aVar) {
                    AppMethodBeat.i(2013);
                    int[] a = c.this.a(c.this.aiB.getLayoutManager(), view);
                    int i = a[0];
                    int i2 = a[1];
                    int ca = ca(Math.max(Math.abs(i), Math.abs(i2)));
                    if (ca > 0) {
                        aVar.a(i, i2, ca, this.Sf);
                    }
                    AppMethodBeat.o(2013);
                }

                public final float c(DisplayMetrics displayMetrics) {
                    return 100.0f / ((float) displayMetrics.densityDpi);
                }

                public final int cb(int i) {
                    AppMethodBeat.i(2014);
                    int min = Math.min(100, super.cb(i));
                    AppMethodBeat.o(2014);
                    return min;
                }
            };
            AppMethodBeat.o(2018);
            return anonymousClass1;
        }
        AppMethodBeat.o(2018);
        return null;
    }

    private int a(View view, am amVar) {
        AppMethodBeat.i(2019);
        int bf = amVar.bf(view) - this.sDo.cGd();
        AppMethodBeat.o(2019);
        return bf;
    }

    private static View a(i iVar, am amVar) {
        View view = null;
        AppMethodBeat.i(2020);
        int childCount = iVar.getChildCount();
        if (childCount == 0) {
            AppMethodBeat.o(2020);
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
            AppMethodBeat.o(2020);
        }
        return view;
    }

    private am b(i iVar) {
        AppMethodBeat.i(2021);
        if (this.amf == null || this.amf.getLayoutManager() != iVar) {
            this.amf = am.e(iVar);
        }
        am amVar = this.amf;
        AppMethodBeat.o(2021);
        return amVar;
    }

    private am c(i iVar) {
        AppMethodBeat.i(2022);
        if (this.amg == null || this.amg.getLayoutManager() != iVar) {
            this.amg = am.d(iVar);
        }
        am amVar = this.amg;
        AppMethodBeat.o(2022);
        return amVar;
    }
}
