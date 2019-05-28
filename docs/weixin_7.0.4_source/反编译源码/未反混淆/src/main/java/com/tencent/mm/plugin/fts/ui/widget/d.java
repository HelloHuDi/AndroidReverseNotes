package com.tencent.mm.plugin.fts.ui.widget;

import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.o;

public final class d extends o {
    public boolean mNe;

    public final boolean amG() {
        return this.mNe;
    }

    public final void a(FragmentActivity fragmentActivity, Menu menu) {
        AppMethodBeat.i(62204);
        if (fragmentActivity == null) {
            ab.w("MicroMsg.FTSVoiceSearchViewHelper", "on add search menu, activity is null");
            AppMethodBeat.o(62204);
            return;
        }
        if (this.zGZ == null) {
            this.zGZ = new FTSActionBarSearchView(fragmentActivity);
        }
        super.a(fragmentActivity, menu);
        AppMethodBeat.o(62204);
    }

    public final void setCursorVisible(boolean z) {
        AppMethodBeat.i(62205);
        ((FTSActionBarSearchView) this.zGZ).setCursorVisible(z);
        AppMethodBeat.o(62205);
    }

    public final void setSearchContent(String str) {
        AppMethodBeat.i(62206);
        try {
            super.setSearchContent(str);
            AppMethodBeat.o(62206);
        } catch (Exception e) {
            ab.e("MicroMsg.FTSVoiceSearchViewHelper", "setSearchContent exception: " + e.getMessage());
            AppMethodBeat.o(62206);
        }
    }
}
