package com.tencent.p177mm.plugin.appbrand.p336ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;

@Deprecated
/* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandRecommendCategoryListUI */
public class AppBrandRecommendCategoryListUI extends MMActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 0;
    }
}
