package com.tencent.p177mm.plugin.topstory.p541ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@C5271a(1)
/* renamed from: com.tencent.mm.plugin.topstory.ui.home.TopStorySubTaskHomeUI */
public class TopStorySubTaskHomeUI extends MMActivity {
    private C46302b sBF = new C46302b(this, false);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public TopStorySubTaskHomeUI() {
        AppMethodBeat.m2504i(1663);
        AppMethodBeat.m2505o(1663);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(1664);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.TopStory.TopStoryHomeUI", "use TopStoryHomeUI");
        this.sBF.onCreate(bundle);
        AppMethodBeat.m2505o(1664);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(1665);
        boolean FA = this.sBF.mo74465FA(i);
        AppMethodBeat.m2505o(1665);
        return FA;
    }

    public void onResume() {
        AppMethodBeat.m2504i(1666);
        super.onResume();
        this.sBF.onResume();
        AppMethodBeat.m2505o(1666);
    }

    public void onPause() {
        AppMethodBeat.m2504i(1667);
        this.sBF.onPause();
        super.onPause();
        AppMethodBeat.m2505o(1667);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(1668);
        this.sBF.onDestroy();
        super.onDestroy();
        AppMethodBeat.m2505o(1668);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(1669);
        this.sBF.onNewIntent(intent);
        super.onNewIntent(intent);
        AppMethodBeat.m2505o(1669);
    }

    public final int getLayoutId() {
        return 2130970950;
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.m2504i(1670);
        super.onSaveInstanceState(bundle);
        this.sBF.onSaveInstanceState(bundle);
        AppMethodBeat.m2505o(1670);
    }
}
