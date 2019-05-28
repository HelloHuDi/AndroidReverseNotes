package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.ActionBarSearchView;

public class FTSActionBarSearchView extends ActionBarSearchView {
    public FTSActionBarSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FTSActionBarSearchView(Context context) {
        super(context);
    }

    public int getLayoutId() {
        AppMethodBeat.i(62103);
        ab.i("FTSActionBarSearchView", "getLayoutId");
        AppMethodBeat.o(62103);
        return R.layout.a1m;
    }

    public void setCursorVisible(boolean z) {
        AppMethodBeat.i(62104);
        this.zzZ.setCursorVisible(z);
        AppMethodBeat.o(62104);
    }
}
