package com.tencent.p177mm.plugin.emoji.p384ui.p385v2;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.emoji.p381a.C11548f;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C33944a;
import com.tencent.p177mm.plugin.emoji.p384ui.BaseEmojiStoreUI;
import com.tencent.p177mm.plugin.report.service.C7060h;

/* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RankUI */
public class EmojiStoreV2RankUI extends BaseEmojiStoreUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(53665);
        super.onCreate(bundle);
        C7060h.pYm.mo8381e(12740, Integer.valueOf(4), "", "", "", Integer.valueOf(5), Integer.valueOf(5));
        AppMethodBeat.m2505o(53665);
    }

    public final void initView() {
        AppMethodBeat.m2504i(53666);
        super.initView();
        setMMTitle((int) C25738R.string.bb2);
        AppMethodBeat.m2505o(53666);
    }

    public final C33944a bkO() {
        AppMethodBeat.m2504i(53667);
        C11548f c11548f = new C11548f(this.mController.ylL);
        AppMethodBeat.m2505o(53667);
        return c11548f;
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
