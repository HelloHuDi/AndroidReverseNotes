package com.tencent.p177mm.plugin.topstory.p541ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.topstory.ui.home.TopStoryTabHomeUI */
public class TopStoryTabHomeUI extends MMActivity {
    private C22402c sCP = new C22402c(this);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public TopStoryTabHomeUI() {
        AppMethodBeat.m2504i(1671);
        AppMethodBeat.m2505o(1671);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(1672);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.TopStory.TopStoryHomeUI", "use TopStoryHomeUI");
        this.sCP.onCreate(bundle);
        AppMethodBeat.m2505o(1672);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(1673);
        if (this.sCP.mo74465FA(i)) {
            AppMethodBeat.m2505o(1673);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(1673);
        return onKeyDown;
    }

    public void onResume() {
        AppMethodBeat.m2504i(1674);
        super.onResume();
        this.sCP.onResume();
        AppMethodBeat.m2505o(1674);
    }

    public void onPause() {
        AppMethodBeat.m2504i(1675);
        this.sCP.onPause();
        super.onPause();
        AppMethodBeat.m2505o(1675);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(1676);
        this.sCP.onDestroy();
        super.onDestroy();
        AppMethodBeat.m2505o(1676);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(1677);
        this.sCP.onNewIntent(intent);
        super.onNewIntent(intent);
        AppMethodBeat.m2505o(1677);
    }

    public final int getLayoutId() {
        return 2130970950;
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.m2504i(1678);
        super.onSaveInstanceState(bundle);
        this.sCP.onSaveInstanceState(bundle);
        AppMethodBeat.m2505o(1678);
    }
}
