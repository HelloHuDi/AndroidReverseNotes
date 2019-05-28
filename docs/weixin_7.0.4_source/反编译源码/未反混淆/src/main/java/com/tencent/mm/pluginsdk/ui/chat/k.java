package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.t;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class k extends t implements j {
    public final boolean bOe() {
        return true;
    }

    public final boolean bOf() {
        return true;
    }

    public final void A(EmojiInfo emojiInfo) {
        AppMethodBeat.i(62452);
        this.ccZ.a(emojiInfo);
        AppMethodBeat.o(62452);
    }

    public final void B(EmojiInfo emojiInfo) {
        AppMethodBeat.i(62453);
        this.ccZ.a(emojiInfo);
        AppMethodBeat.o(62453);
    }

    public final void bOg() {
        AppMethodBeat.i(62454);
        this.ccZ.onHide();
        AppMethodBeat.o(62454);
    }
}
