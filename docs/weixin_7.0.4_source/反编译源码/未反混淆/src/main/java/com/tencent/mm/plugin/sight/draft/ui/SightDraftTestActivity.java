package com.tencent.mm.plugin.sight.draft.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SightDraftTestActivity extends Activity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25021);
        super.onCreate(bundle);
        SightDraftContainerView sightDraftContainerView = new SightDraftContainerView(this);
        setContentView(sightDraftContainerView);
        sightDraftContainerView.clx();
        AppMethodBeat.o(25021);
    }
}
