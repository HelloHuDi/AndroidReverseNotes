package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.f.b.j;
import a.l;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003\u001a\u0012\u0010\u0004\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003¨\u0006\u0005"}, dWq = {"getDefaultAppCardBg", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "getDefaultCardContentImgBg", "plugin-appbrand-integration_release"})
public final class b {
    public static final Drawable a(a aVar) {
        AppMethodBeat.i(135182);
        j.p(aVar, "receiver$0");
        Drawable drawable = aVar.activity.getResources().getDrawable(R.drawable.c5);
        AppMethodBeat.o(135182);
        return drawable;
    }
}
