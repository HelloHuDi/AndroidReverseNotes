package com.tencent.mm.plugin.topstory.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;

public class TopStoryHomeUI extends MMActivity {
    private b sBF = new b(this, true);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public TopStoryHomeUI() {
        AppMethodBeat.i(1555);
        AppMethodBeat.o(1555);
    }

    static /* synthetic */ void a(TopStoryHomeUI topStoryHomeUI) {
        AppMethodBeat.i(1565);
        super.finish();
        AppMethodBeat.o(1565);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(1557);
        if (this.sBF.FA(i)) {
            AppMethodBeat.o(1557);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(1557);
        return onKeyDown;
    }

    public void onResume() {
        AppMethodBeat.i(1558);
        super.onResume();
        this.sBF.onResume();
        AppMethodBeat.o(1558);
    }

    public void onPause() {
        AppMethodBeat.i(1559);
        this.sBF.onPause();
        super.onPause();
        AppMethodBeat.o(1559);
    }

    public void onDestroy() {
        AppMethodBeat.i(1560);
        this.sBF.onDestroy();
        super.onDestroy();
        AppMethodBeat.o(1560);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(1561);
        this.sBF.onNewIntent(intent);
        super.onNewIntent(intent);
        AppMethodBeat.o(1561);
    }

    public final int getLayoutId() {
        return R.layout.b0a;
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(1562);
        super.onSaveInstanceState(bundle);
        this.sBF.onSaveInstanceState(bundle);
        AppMethodBeat.o(1562);
    }

    public void onBackPressed() {
        Object obj;
        AppMethodBeat.i(1563);
        b bVar = this.sBF;
        if (bVar.sBS) {
            bVar.cFD();
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            super.onBackPressed();
        }
        AppMethodBeat.o(1563);
    }

    public void finish() {
        AppMethodBeat.i(1564);
        int i = 100;
        if (!this.mController.hideVKB()) {
            i = 0;
        }
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(1554);
                ab.i("MicroMsg.TopStory.TopStoryHomeUI", " finish");
                TopStoryHomeUI.a(TopStoryHomeUI.this);
                AppMethodBeat.o(1554);
            }
        }, (long) i);
        AppMethodBeat.o(1564);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(1556);
        this.yll = true;
        super.onCreate(bundle);
        ab.i("MicroMsg.TopStory.TopStoryHomeUI", "use TopStoryHomeUI");
        this.sBF.onCreate(bundle);
        AppMethodBeat.o(1556);
    }
}
