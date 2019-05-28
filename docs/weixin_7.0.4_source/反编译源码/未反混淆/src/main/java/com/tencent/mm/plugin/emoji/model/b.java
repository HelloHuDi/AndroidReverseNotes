package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.emoji.b.b.a;
import com.tencent.mm.plugin.emoji.e.h;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at;

public final class b extends q {
    public b() {
        super(c.akt("emoji"));
        AppMethodBeat.i(52997);
        a.kTl = new com.tencent.mm.plugin.emoji.b.b() {
            public final d getEmojiMgr() {
                AppMethodBeat.i(52994);
                h bki = j.bki();
                AppMethodBeat.o(52994);
                return bki;
            }

            public final at getEmojiStorageMgr() {
                AppMethodBeat.i(52995);
                at emojiStorageMgr = j.getEmojiStorageMgr();
                AppMethodBeat.o(52995);
                return emojiStorageMgr;
            }

            public final aq getEmojiDescMgr() {
                AppMethodBeat.i(52996);
                aq emojiDescMgr = j.getEmojiDescMgr();
                AppMethodBeat.o(52996);
                return emojiDescMgr;
            }
        };
        AppMethodBeat.o(52997);
    }
}
