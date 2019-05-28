package com.tencent.p177mm.plugin.fts.p424ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.tools.ActionBarSearchView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSActionBarSearchView */
public class FTSActionBarSearchView extends ActionBarSearchView {
    public FTSActionBarSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FTSActionBarSearchView(Context context) {
        super(context);
    }

    public int getLayoutId() {
        AppMethodBeat.m2504i(62103);
        C4990ab.m7416i("FTSActionBarSearchView", "getLayoutId");
        AppMethodBeat.m2505o(62103);
        return 2130969628;
    }

    public void setCursorVisible(boolean z) {
        AppMethodBeat.m2504i(62104);
        this.zzZ.setCursorVisible(z);
        AppMethodBeat.m2505o(62104);
    }
}
