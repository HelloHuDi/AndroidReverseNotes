package com.tencent.p177mm.plugin.sight.draft.p1021ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.sight.draft.ui.SightDraftTestActivity */
public class SightDraftTestActivity extends Activity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(25021);
        super.onCreate(bundle);
        SightDraftContainerView sightDraftContainerView = new SightDraftContainerView(this);
        setContentView(sightDraftContainerView);
        sightDraftContainerView.clx();
        AppMethodBeat.m2505o(25021);
    }
}
