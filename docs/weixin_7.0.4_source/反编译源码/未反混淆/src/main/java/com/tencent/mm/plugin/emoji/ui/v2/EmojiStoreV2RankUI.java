package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.f;
import com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI;
import com.tencent.mm.plugin.report.service.h;

public class EmojiStoreV2RankUI extends BaseEmojiStoreUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(53665);
        super.onCreate(bundle);
        h.pYm.e(12740, Integer.valueOf(4), "", "", "", Integer.valueOf(5), Integer.valueOf(5));
        AppMethodBeat.o(53665);
    }

    public final void initView() {
        AppMethodBeat.i(53666);
        super.initView();
        setMMTitle((int) R.string.bb2);
        AppMethodBeat.o(53666);
    }

    public final a bkO() {
        AppMethodBeat.i(53667);
        f fVar = new f(this.mController.ylL);
        AppMethodBeat.o(53667);
        return fVar;
    }

    public final int bkV() {
        return 10;
    }

    public final int bkM() {
        return 5;
    }

    public final int bkN() {
        return 105;
    }

    public final int getForceOrientation() {
        return 1;
    }
}
