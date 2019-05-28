package com.tencent.p177mm.plugin.topstory.p541ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.plugin.topstory.ui.home.TopStoryHomeUI */
public class TopStoryHomeUI extends MMActivity {
    private C46302b sBF = new C46302b(this, true);

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.TopStoryHomeUI$1 */
    class C139461 implements Runnable {
        C139461() {
        }

        public final void run() {
            AppMethodBeat.m2504i(1554);
            C4990ab.m7416i("MicroMsg.TopStory.TopStoryHomeUI", " finish");
            TopStoryHomeUI.m22092a(TopStoryHomeUI.this);
            AppMethodBeat.m2505o(1554);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public TopStoryHomeUI() {
        AppMethodBeat.m2504i(1555);
        AppMethodBeat.m2505o(1555);
    }

    /* renamed from: a */
    static /* synthetic */ void m22092a(TopStoryHomeUI topStoryHomeUI) {
        AppMethodBeat.m2504i(1565);
        super.finish();
        AppMethodBeat.m2505o(1565);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(1557);
        if (this.sBF.mo74465FA(i)) {
            AppMethodBeat.m2505o(1557);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(1557);
        return onKeyDown;
    }

    public void onResume() {
        AppMethodBeat.m2504i(1558);
        super.onResume();
        this.sBF.onResume();
        AppMethodBeat.m2505o(1558);
    }

    public void onPause() {
        AppMethodBeat.m2504i(1559);
        this.sBF.onPause();
        super.onPause();
        AppMethodBeat.m2505o(1559);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(1560);
        this.sBF.onDestroy();
        super.onDestroy();
        AppMethodBeat.m2505o(1560);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(1561);
        this.sBF.onNewIntent(intent);
        super.onNewIntent(intent);
        AppMethodBeat.m2505o(1561);
    }

    public final int getLayoutId() {
        return 2130970950;
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.m2504i(1562);
        super.onSaveInstanceState(bundle);
        this.sBF.onSaveInstanceState(bundle);
        AppMethodBeat.m2505o(1562);
    }

    public void onBackPressed() {
        Object obj;
        AppMethodBeat.m2504i(1563);
        C46302b c46302b = this.sBF;
        if (c46302b.sBS) {
            c46302b.cFD();
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            super.onBackPressed();
        }
        AppMethodBeat.m2505o(1563);
    }

    public void finish() {
        AppMethodBeat.m2504i(1564);
        int i = 100;
        if (!this.mController.hideVKB()) {
            i = 0;
        }
        C5004al.m7442n(new C139461(), (long) i);
        AppMethodBeat.m2505o(1564);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(1556);
        this.yll = true;
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.TopStory.TopStoryHomeUI", "use TopStoryHomeUI");
        this.sBF.onCreate(bundle);
        AppMethodBeat.m2505o(1556);
    }
}
