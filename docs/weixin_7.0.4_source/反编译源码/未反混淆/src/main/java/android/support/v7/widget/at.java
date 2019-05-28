package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;

final class at {
    static int a(s sVar, am amVar, View view, View view2, i iVar, boolean z, boolean z2) {
        if (iVar.getChildCount() == 0 || sVar.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max;
        int min = Math.min(i.bt(view), i.bt(view2));
        int max2 = Math.max(i.bt(view), i.bt(view2));
        if (z2) {
            max = Math.max(0, (sVar.getItemCount() - max2) - 1);
        } else {
            max = Math.max(0, min);
        }
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(amVar.bg(view2) - amVar.bf(view))) / ((float) (Math.abs(i.bt(view) - i.bt(view2)) + 1)))) + ((float) (amVar.je() - amVar.bf(view))));
    }

    static int a(s sVar, am amVar, View view, View view2, i iVar, boolean z) {
        if (iVar.getChildCount() == 0 || sVar.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(i.bt(view) - i.bt(view2)) + 1;
        }
        return Math.min(amVar.jg(), amVar.bg(view2) - amVar.bf(view));
    }

    static int b(s sVar, am amVar, View view, View view2, i iVar, boolean z) {
        if (iVar.getChildCount() == 0 || sVar.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return sVar.getItemCount();
        }
        return (int) ((((float) (amVar.bg(view2) - amVar.bf(view))) / ((float) (Math.abs(i.bt(view) - i.bt(view2)) + 1))) * ((float) sVar.getItemCount()));
    }
}
