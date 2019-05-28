package com.tencent.p177mm.plugin.topstory.p541ui.video.list;

import android.graphics.PointF;
import android.support.p069v7.widget.C17487am;
import android.support.p069v7.widget.C41189ah;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C37139r.C37138a;
import android.support.p069v7.widget.RecyclerView.C37139r.C37140b;
import android.util.DisplayMetrics;
import android.view.View;
import com.facebook.device.yearclass.YearClass;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C4232b;
import com.tencent.p177mm.plugin.topstory.p541ui.widget.C14004g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.c */
public final class C16896c extends C14004g {
    private C17487am amf;
    private C17487am amg;
    C4232b sDo;

    public C16896c(C4232b c4232b) {
        this.sDo = c4232b;
    }

    /* renamed from: a */
    public final int[] mo26234a(C17480i c17480i, View view) {
        AppMethodBeat.m2504i(2015);
        int[] iArr = new int[2];
        if (c17480i.mo1776iG()) {
            iArr[0] = m26064a(view, m26067c(c17480i));
        } else {
            iArr[0] = 0;
        }
        if (c17480i.mo1777iH()) {
            iArr[1] = m26064a(view, m26066b(c17480i));
        } else {
            iArr[1] = 0;
        }
        AppMethodBeat.m2505o(2015);
        return iArr;
    }

    /* renamed from: a */
    public final View mo26233a(C17480i c17480i) {
        AppMethodBeat.m2504i(YearClass.CLASS_2016);
        View a;
        if (c17480i.mo1777iH()) {
            a = C16896c.m26065a(c17480i, m26066b(c17480i));
            AppMethodBeat.m2505o(YearClass.CLASS_2016);
            return a;
        } else if (c17480i.mo1776iG()) {
            a = C16896c.m26065a(c17480i, m26067c(c17480i));
            AppMethodBeat.m2505o(YearClass.CLASS_2016);
            return a;
        } else {
            AppMethodBeat.m2505o(YearClass.CLASS_2016);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final int mo26232a(C17480i c17480i, int i, int i2) {
        int i3 = -1;
        AppMethodBeat.m2504i(2017);
        if (Math.abs(i2) <= 500 || Math.abs(i) >= Math.abs(i2)) {
            AppMethodBeat.m2505o(2017);
        } else {
            int itemCount = c17480i.getItemCount();
            if (itemCount == 0) {
                AppMethodBeat.m2505o(2017);
            } else {
                int cFY = this.sDo.cFY() + 1;
                if (cFY == -1) {
                    AppMethodBeat.m2505o(2017);
                } else {
                    boolean z = c17480i.mo1776iG() ? i > 0 : i2 > 0;
                    if (c17480i instanceof C37140b) {
                        PointF bX = ((C37140b) c17480i).mo1761bX(itemCount - 1);
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
                            C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoPagerSnapHelper", "findTargetSnapPosition velocityY: %d centerPosition: %d forwardDirection: %b result: %d currentPlayPos: %d", Integer.valueOf(i2), Integer.valueOf(cFY), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(this.sDo.cFY() + 1));
                            AppMethodBeat.m2505o(2017);
                        }
                    }
                    i3 = 0;
                    if (i3 == 0) {
                    }
                    C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoPagerSnapHelper", "findTargetSnapPosition velocityY: %d centerPosition: %d forwardDirection: %b result: %d currentPlayPos: %d", Integer.valueOf(i2), Integer.valueOf(cFY), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(this.sDo.cFY() + 1));
                    AppMethodBeat.m2505o(2017);
                }
            }
        }
        return i3;
    }

    /* renamed from: f */
    public final C41189ah mo26236f(C17480i c17480i) {
        AppMethodBeat.m2504i(2018);
        if (c17480i instanceof C37140b) {
            C41189ah c168971 = new C41189ah(this.aiB.getContext()) {
                /* renamed from: a */
                public final void mo9234a(View view, C37138a c37138a) {
                    AppMethodBeat.m2504i(2013);
                    int[] a = C16896c.this.mo26234a(C16896c.this.aiB.getLayoutManager(), view);
                    int i = a[0];
                    int i2 = a[1];
                    int ca = mo65816ca(Math.max(Math.abs(i), Math.abs(i2)));
                    if (ca > 0) {
                        c37138a.mo59203a(i, i2, ca, this.f16584Sf);
                    }
                    AppMethodBeat.m2505o(2013);
                }

                /* renamed from: c */
                public final float mo9235c(DisplayMetrics displayMetrics) {
                    return 100.0f / ((float) displayMetrics.densityDpi);
                }

                /* renamed from: cb */
                public final int mo30874cb(int i) {
                    AppMethodBeat.m2504i(2014);
                    int min = Math.min(100, super.mo30874cb(i));
                    AppMethodBeat.m2505o(2014);
                    return min;
                }
            };
            AppMethodBeat.m2505o(2018);
            return c168971;
        }
        AppMethodBeat.m2505o(2018);
        return null;
    }

    /* renamed from: a */
    private int m26064a(View view, C17487am c17487am) {
        AppMethodBeat.m2504i(2019);
        int bf = c17487am.mo31893bf(view) - this.sDo.cGd();
        AppMethodBeat.m2505o(2019);
        return bf;
    }

    /* renamed from: a */
    private static View m26065a(C17480i c17480i, C17487am c17487am) {
        View view = null;
        AppMethodBeat.m2504i(2020);
        int childCount = c17480i.getChildCount();
        if (childCount == 0) {
            AppMethodBeat.m2505o(2020);
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
            AppMethodBeat.m2505o(2020);
        }
        return view;
    }

    /* renamed from: b */
    private C17487am m26066b(C17480i c17480i) {
        AppMethodBeat.m2504i(2021);
        if (this.amf == null || this.amf.getLayoutManager() != c17480i) {
            this.amf = C17487am.m27242e(c17480i);
        }
        C17487am c17487am = this.amf;
        AppMethodBeat.m2505o(2021);
        return c17487am;
    }

    /* renamed from: c */
    private C17487am m26067c(C17480i c17480i) {
        AppMethodBeat.m2504i(2022);
        if (this.amg == null || this.amg.getLayoutManager() != c17480i) {
            this.amg = C17487am.m27241d(c17480i);
        }
        C17487am c17487am = this.amg;
        AppMethodBeat.m2505o(2022);
        return c17487am;
    }
}
