package com.tencent.mm.plugin.webview.ui.tools.emojistore;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class EmojiStoreSearchWebViewUI extends BaseEmojiStoreSearchWebViewUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void t(int i, Bundle bundle) {
        AppMethodBeat.i(8302);
        ab.i("MicroMsg.emoji.EmojiStoreSearchWebViewUI", "handleEmojiStoreAction action:%d", Integer.valueOf(i));
        super.t(i, bundle);
        AppMethodBeat.o(8302);
    }
}
