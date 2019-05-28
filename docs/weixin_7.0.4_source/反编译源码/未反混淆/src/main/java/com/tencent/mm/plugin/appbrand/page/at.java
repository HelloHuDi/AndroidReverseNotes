package com.tencent.mm.plugin.appbrand.page;

import a.f.b.j;
import a.l;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/page/SwipeBackLayoutSettingsAlignmentWC;", "", "()V", "alignSettings", "", "maybeSwipeLayout", "Landroid/view/View;", "plugin-appbrand-integration_release"})
public final class at {
    public static final at ivg = new at();

    static {
        AppMethodBeat.i(134776);
        AppMethodBeat.o(134776);
    }

    private at() {
    }

    public static final void cr(View view) {
        View view2;
        AppMethodBeat.i(134775);
        if (view instanceof SwipeBackLayout) {
            view2 = view;
        } else {
            view2 = null;
        }
        SwipeBackLayout swipeBackLayout = (SwipeBackLayout) view2;
        if (swipeBackLayout != null) {
            Resources resources = swipeBackLayout.getResources();
            j.o(resources, "page.resources");
            float f = resources.getDisplayMetrics().density;
            float f2 = 300.0f * f;
            swipeBackLayout.setMinVelocity(100.0f * f);
            swipeBackLayout.setMaxVelocity(f2);
            swipeBackLayout.setEdgeTrackingEnabled(1);
            swipeBackLayout.setEdgeSize((int) ((f * 20.0f) + 0.5f));
            swipeBackLayout.setEdgeTrackingEnabled(1);
            swipeBackLayout.setScrimColor(0);
            AppMethodBeat.o(134775);
            return;
        }
        AppMethodBeat.o(134775);
    }
}
