package com.tencent.p177mm.plugin.webview.p580ui.tools.emojistore;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.emojistore.EmojiStoreSearchWebViewUI */
public class EmojiStoreSearchWebViewUI extends BaseEmojiStoreSearchWebViewUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: t */
    public final void mo9678t(int i, Bundle bundle) {
        AppMethodBeat.m2504i(8302);
        C4990ab.m7417i("MicroMsg.emoji.EmojiStoreSearchWebViewUI", "handleEmojiStoreAction action:%d", Integer.valueOf(i));
        super.mo9678t(i, bundle);
        AppMethodBeat.m2505o(8302);
    }
}
