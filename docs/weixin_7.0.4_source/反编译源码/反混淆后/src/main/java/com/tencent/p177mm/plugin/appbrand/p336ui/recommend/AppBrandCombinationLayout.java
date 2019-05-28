package com.tencent.p177mm.plugin.appbrand.p336ui.recommend;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\rH\u0002¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandCombinationLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "getChildDrawingOrder", "", "childCount", "i", "init", "", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandCombinationLayout */
public final class AppBrandCombinationLayout extends FrameLayout {
    public AppBrandCombinationLayout(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.m2504i(135139);
        setChildrenDrawingOrderEnabled(true);
        AppMethodBeat.m2505o(135139);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getChildDrawingOrder(int i, int i2) {
        return i2 == 0 ? 1 : 0;
    }
}
