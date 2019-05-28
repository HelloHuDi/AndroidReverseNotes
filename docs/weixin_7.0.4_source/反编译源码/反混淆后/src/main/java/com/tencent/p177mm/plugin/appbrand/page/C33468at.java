package com.tencent.p177mm.plugin.appbrand.page;

import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p1358me.imid.swipebacklayout.lib.SwipeBackLayout;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/page/SwipeBackLayoutSettingsAlignmentWC;", "", "()V", "alignSettings", "", "maybeSwipeLayout", "Landroid/view/View;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.page.at */
public final class C33468at {
    public static final C33468at ivg = new C33468at();

    static {
        AppMethodBeat.m2504i(134776);
        AppMethodBeat.m2505o(134776);
    }

    private C33468at() {
    }

    /* renamed from: cr */
    public static final void m54677cr(View view) {
        View view2;
        AppMethodBeat.m2504i(134775);
        if (view instanceof SwipeBackLayout) {
            view2 = view;
        } else {
            view2 = null;
        }
        SwipeBackLayout swipeBackLayout = (SwipeBackLayout) view2;
        if (swipeBackLayout != null) {
            Resources resources = swipeBackLayout.getResources();
            C25052j.m39375o(resources, "page.resources");
            float f = resources.getDisplayMetrics().density;
            float f2 = 300.0f * f;
            swipeBackLayout.setMinVelocity(100.0f * f);
            swipeBackLayout.setMaxVelocity(f2);
            swipeBackLayout.setEdgeTrackingEnabled(1);
            swipeBackLayout.setEdgeSize((int) ((f * 20.0f) + 0.5f));
            swipeBackLayout.setEdgeTrackingEnabled(1);
            swipeBackLayout.setScrimColor(0);
            AppMethodBeat.m2505o(134775);
            return;
        }
        AppMethodBeat.m2505o(134775);
    }
}
