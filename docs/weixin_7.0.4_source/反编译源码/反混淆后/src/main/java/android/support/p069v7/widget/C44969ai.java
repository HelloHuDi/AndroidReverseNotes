package android.support.p069v7.widget;

import android.graphics.PointF;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C37139r.C37140b;
import android.view.View;
import com.google.android.gms.common.api.Api.BaseClientBuilder;

/* renamed from: android.support.v7.widget.ai */
public final class C44969ai extends C25379aw {
    private C17487am amf;
    private C17487am amg;

    /* renamed from: a */
    public final int[] mo9101a(C17480i c17480i, View view) {
        int[] iArr = new int[2];
        if (c17480i.mo1776iG()) {
            iArr[0] = C44969ai.m82314a(c17480i, view, m82318c(c17480i));
        } else {
            iArr[0] = 0;
        }
        if (c17480i.mo1777iH()) {
            iArr[1] = C44969ai.m82314a(c17480i, view, m82317b(c17480i));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    /* renamed from: a */
    public final int mo31909a(C17480i c17480i, int i, int i2) {
        if (!(c17480i instanceof C37140b)) {
            return -1;
        }
        int itemCount = c17480i.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        View a = mo31910a(c17480i);
        if (a == null) {
            return -1;
        }
        int bt = C17480i.m27148bt(a);
        if (bt == -1) {
            return -1;
        }
        PointF bX = ((C37140b) c17480i).mo1761bX(itemCount - 1);
        if (bX == null) {
            return -1;
        }
        int a2;
        int a3;
        if (c17480i.mo1776iG()) {
            a2 = m82313a(c17480i, m82318c(c17480i), i, 0);
            if (bX.x < 0.0f) {
                a2 = -a2;
            }
        } else {
            a2 = 0;
        }
        if (c17480i.mo1777iH()) {
            a3 = m82313a(c17480i, m82317b(c17480i), 0, i2);
            if (bX.y < 0.0f) {
                a3 = -a3;
            }
        } else {
            a3 = 0;
        }
        if (!c17480i.mo1777iH()) {
            a3 = a2;
        }
        if (a3 == 0) {
            return -1;
        }
        a2 = bt + a3;
        if (a2 < 0) {
            a2 = 0;
        }
        if (a2 >= itemCount) {
            return itemCount - 1;
        }
        return a2;
    }

    /* renamed from: a */
    public final View mo31910a(C17480i c17480i) {
        if (c17480i.mo1777iH()) {
            return C44969ai.m82315a(c17480i, m82317b(c17480i));
        }
        if (c17480i.mo1776iG()) {
            return C44969ai.m82315a(c17480i, m82318c(c17480i));
        }
        return null;
    }

    /* renamed from: a */
    private static int m82314a(C17480i c17480i, View view, C17487am c17487am) {
        int je;
        int bj = (c17487am.mo31897bj(view) / 2) + c17487am.mo31893bf(view);
        if (c17480i.getClipToPadding()) {
            je = c17487am.mo31905je() + (c17487am.mo31907jg() / 2);
        } else {
            je = c17487am.getEnd() / 2;
        }
        return bj - je;
    }

    /* renamed from: a */
    private int m82313a(C17480i c17480i, C17487am c17487am, int i, int i2) {
        int[] aJ = mo42391aJ(i, i2);
        float b = C44969ai.m82316b(c17480i, c17487am);
        if (b <= 0.0f) {
            return 0;
        }
        return Math.round(((float) (Math.abs(aJ[0]) > Math.abs(aJ[1]) ? aJ[0] : aJ[1])) / b);
    }

    /* renamed from: a */
    private static View m82315a(C17480i c17480i, C17487am c17487am) {
        View view = null;
        int childCount = c17480i.getChildCount();
        if (childCount != 0) {
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
        }
        return view;
    }

    /* renamed from: b */
    private static float m82316b(C17480i c17480i, C17487am c17487am) {
        int i = BaseClientBuilder.API_PRIORITY_OTHER;
        int i2 = C8415j.INVALID_ID;
        int childCount = c17480i.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        int bt;
        int i3 = 0;
        View view = null;
        View view2 = null;
        while (i3 < childCount) {
            View childAt = c17480i.getChildAt(i3);
            bt = C17480i.m27148bt(childAt);
            if (bt != -1) {
                if (bt < i) {
                    i = bt;
                    view2 = childAt;
                }
                if (bt > i2) {
                    i3++;
                    i2 = bt;
                    view = childAt;
                }
            }
            bt = i2;
            childAt = view;
            i3++;
            i2 = bt;
            view = childAt;
        }
        if (view2 == null || view == null) {
            return 1.0f;
        }
        bt = Math.max(c17487am.mo31894bg(view2), c17487am.mo31894bg(view)) - Math.min(c17487am.mo31893bf(view2), c17487am.mo31893bf(view));
        if (bt == 0) {
            return 1.0f;
        }
        return (((float) bt) * 1.0f) / ((float) ((i2 - i) + 1));
    }

    /* renamed from: b */
    private C17487am m82317b(C17480i c17480i) {
        if (this.amf == null || this.amf.amP != c17480i) {
            this.amf = C17487am.m27242e(c17480i);
        }
        return this.amf;
    }

    /* renamed from: c */
    private C17487am m82318c(C17480i c17480i) {
        if (this.amg == null || this.amg.amP != c17480i) {
            this.amg = C17487am.m27241d(c17480i);
        }
        return this.amg;
    }
}
