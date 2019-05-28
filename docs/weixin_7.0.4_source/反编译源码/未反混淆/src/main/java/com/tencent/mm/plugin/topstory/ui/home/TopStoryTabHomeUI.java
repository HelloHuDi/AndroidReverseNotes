package com.tencent.mm.plugin.topstory.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public class TopStoryTabHomeUI extends MMActivity {
    private c sCP = new c(this);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public TopStoryTabHomeUI() {
        AppMethodBeat.i(1671);
        AppMethodBeat.o(1671);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(1672);
        super.onCreate(bundle);
        ab.i("MicroMsg.TopStory.TopStoryHomeUI", "use TopStoryHomeUI");
        this.sCP.onCreate(bundle);
        AppMethodBeat.o(1672);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(1673);
        if (this.sCP.FA(i)) {
            AppMethodBeat.o(1673);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(1673);
        return onKeyDown;
    }

    public void onResume() {
        AppMethodBeat.i(1674);
        super.onResume();
        this.sCP.onResume();
        AppMethodBeat.o(1674);
    }

    public void onPause() {
        AppMethodBeat.i(1675);
        this.sCP.onPause();
        super.onPause();
        AppMethodBeat.o(1675);
    }

    public void onDestroy() {
        AppMethodBeat.i(1676);
        this.sCP.onDestroy();
        super.onDestroy();
        AppMethodBeat.o(1676);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(1677);
        this.sCP.onNewIntent(intent);
        super.onNewIntent(intent);
        AppMethodBeat.o(1677);
    }

    public final int getLayoutId() {
        return R.layout.b0a;
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(1678);
        super.onSaveInstanceState(bundle);
        this.sCP.onSaveInstanceState(bundle);
        AppMethodBeat.o(1678);
    }
}
