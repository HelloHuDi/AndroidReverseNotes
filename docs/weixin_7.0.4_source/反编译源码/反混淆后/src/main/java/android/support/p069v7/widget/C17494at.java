package android.support.p069v7.widget;

import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.view.View;

/* renamed from: android.support.v7.widget.at */
final class C17494at {
    /* renamed from: a */
    static int m27290a(C31880s c31880s, C17487am c17487am, View view, View view2, C17480i c17480i, boolean z, boolean z2) {
        if (c17480i.getChildCount() == 0 || c31880s.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max;
        int min = Math.min(C17480i.m27148bt(view), C17480i.m27148bt(view2));
        int max2 = Math.max(C17480i.m27148bt(view), C17480i.m27148bt(view2));
        if (z2) {
            max = Math.max(0, (c31880s.getItemCount() - max2) - 1);
        } else {
            max = Math.max(0, min);
        }
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(c17487am.mo31894bg(view2) - c17487am.mo31893bf(view))) / ((float) (Math.abs(C17480i.m27148bt(view) - C17480i.m27148bt(view2)) + 1)))) + ((float) (c17487am.mo31905je() - c17487am.mo31893bf(view))));
    }

    /* renamed from: a */
    static int m27289a(C31880s c31880s, C17487am c17487am, View view, View view2, C17480i c17480i, boolean z) {
        if (c17480i.getChildCount() == 0 || c31880s.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(C17480i.m27148bt(view) - C17480i.m27148bt(view2)) + 1;
        }
        return Math.min(c17487am.mo31907jg(), c17487am.mo31894bg(view2) - c17487am.mo31893bf(view));
    }

    /* renamed from: b */
    static int m27291b(C31880s c31880s, C17487am c17487am, View view, View view2, C17480i c17480i, boolean z) {
        if (c17480i.getChildCount() == 0 || c31880s.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return c31880s.getItemCount();
        }
        return (int) ((((float) (c17487am.mo31894bg(view2) - c17487am.mo31893bf(view))) / ((float) (Math.abs(C17480i.m27148bt(view) - C17480i.m27148bt(view2)) + 1))) * ((float) c31880s.getItemCount()));
    }
}
