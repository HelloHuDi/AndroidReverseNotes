package com.tencent.mm.plugin.topstory.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(1)
public class TopStorySubTaskHomeUI extends MMActivity {
    private b sBF = new b(this, false);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public TopStorySubTaskHomeUI() {
        AppMethodBeat.i(1663);
        AppMethodBeat.o(1663);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(1664);
        super.onCreate(bundle);
        ab.i("MicroMsg.TopStory.TopStoryHomeUI", "use TopStoryHomeUI");
        this.sBF.onCreate(bundle);
        AppMethodBeat.o(1664);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(1665);
        boolean FA = this.sBF.FA(i);
        AppMethodBeat.o(1665);
        return FA;
    }

    public void onResume() {
        AppMethodBeat.i(1666);
        super.onResume();
        this.sBF.onResume();
        AppMethodBeat.o(1666);
    }

    public void onPause() {
        AppMethodBeat.i(1667);
        this.sBF.onPause();
        super.onPause();
        AppMethodBeat.o(1667);
    }

    public void onDestroy() {
        AppMethodBeat.i(1668);
        this.sBF.onDestroy();
        super.onDestroy();
        AppMethodBeat.o(1668);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(1669);
        this.sBF.onNewIntent(intent);
        super.onNewIntent(intent);
        AppMethodBeat.o(1669);
    }

    public final int getLayoutId() {
        return R.layout.b0a;
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(1670);
        super.onSaveInstanceState(bundle);
        this.sBF.onSaveInstanceState(bundle);
        AppMethodBeat.o(1670);
    }
}
