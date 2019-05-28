package com.tencent.p177mm.plugin.fts.p424ui.widget;

import android.support.p057v4.app.FragmentActivity;
import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.tools.C5601o;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.fts.ui.widget.d */
public final class C12073d extends C5601o {
    public boolean mNe;

    public final boolean amG() {
        return this.mNe;
    }

    /* renamed from: a */
    public final void mo11359a(FragmentActivity fragmentActivity, Menu menu) {
        AppMethodBeat.m2504i(62204);
        if (fragmentActivity == null) {
            C4990ab.m7420w("MicroMsg.FTSVoiceSearchViewHelper", "on add search menu, activity is null");
            AppMethodBeat.m2505o(62204);
            return;
        }
        if (this.zGZ == null) {
            this.zGZ = new FTSActionBarSearchView(fragmentActivity);
        }
        super.mo11359a(fragmentActivity, menu);
        AppMethodBeat.m2505o(62204);
    }

    public final void setCursorVisible(boolean z) {
        AppMethodBeat.m2504i(62205);
        ((FTSActionBarSearchView) this.zGZ).setCursorVisible(z);
        AppMethodBeat.m2505o(62205);
    }

    public final void setSearchContent(String str) {
        AppMethodBeat.m2504i(62206);
        try {
            super.setSearchContent(str);
            AppMethodBeat.m2505o(62206);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.FTSVoiceSearchViewHelper", "setSearchContent exception: " + e.getMessage());
            AppMethodBeat.m2505o(62206);
        }
    }
}
