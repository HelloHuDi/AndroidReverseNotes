package android.support.v7.widget;

import android.graphics.PointF;
import android.support.v4.widget.j;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.r.b;
import android.view.View;
import com.google.android.gms.common.api.Api.BaseClientBuilder;

public final class ai extends aw {
    private am amf;
    private am amg;

    public final int[] a(i iVar, View view) {
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
        return iArr;
    }

    public final int a(i iVar, int i, int i2) {
        if (!(iVar instanceof b)) {
            return -1;
        }
        int itemCount = iVar.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        View a = a(iVar);
        if (a == null) {
            return -1;
        }
        int bt = i.bt(a);
        if (bt == -1) {
            return -1;
        }
        PointF bX = ((b) iVar).bX(itemCount - 1);
        if (bX == null) {
            return -1;
        }
        int a2;
        int a3;
        if (iVar.iG()) {
            a2 = a(iVar, c(iVar), i, 0);
            if (bX.x < 0.0f) {
                a2 = -a2;
            }
        } else {
            a2 = 0;
        }
        if (iVar.iH()) {
            a3 = a(iVar, b(iVar), 0, i2);
            if (bX.y < 0.0f) {
                a3 = -a3;
            }
        } else {
            a3 = 0;
        }
        if (!iVar.iH()) {
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

    public final View a(i iVar) {
        if (iVar.iH()) {
            return a(iVar, b(iVar));
        }
        if (iVar.iG()) {
            return a(iVar, c(iVar));
        }
        return null;
    }

    private static int a(i iVar, View view, am amVar) {
        int je;
        int bj = (amVar.bj(view) / 2) + amVar.bf(view);
        if (iVar.getClipToPadding()) {
            je = amVar.je() + (amVar.jg() / 2);
        } else {
            je = amVar.getEnd() / 2;
        }
        return bj - je;
    }

    private int a(i iVar, am amVar, int i, int i2) {
        int[] aJ = aJ(i, i2);
        float b = b(iVar, amVar);
        if (b <= 0.0f) {
            return 0;
        }
        return Math.round(((float) (Math.abs(aJ[0]) > Math.abs(aJ[1]) ? aJ[0] : aJ[1])) / b);
    }

    private static View a(i iVar, am amVar) {
        View view = null;
        int childCount = iVar.getChildCount();
        if (childCount != 0) {
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
        }
        return view;
    }

    private static float b(i iVar, am amVar) {
        int i = BaseClientBuilder.API_PRIORITY_OTHER;
        int i2 = j.INVALID_ID;
        int childCount = iVar.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        int bt;
        int i3 = 0;
        View view = null;
        View view2 = null;
        while (i3 < childCount) {
            View childAt = iVar.getChildAt(i3);
            bt = i.bt(childAt);
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
        bt = Math.max(amVar.bg(view2), amVar.bg(view)) - Math.min(amVar.bf(view2), amVar.bf(view));
        if (bt == 0) {
            return 1.0f;
        }
        return (((float) bt) * 1.0f) / ((float) ((i2 - i) + 1));
    }

    private am b(i iVar) {
        if (this.amf == null || this.amf.amP != iVar) {
            this.amf = am.e(iVar);
        }
        return this.amf;
    }

    private am c(i iVar) {
        if (this.amg == null || this.amg.amP != iVar) {
            this.amg = am.d(iVar);
        }
        return this.amg;
    }
}
