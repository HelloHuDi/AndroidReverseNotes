package com.tencent.mm.plugin.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;

public final class c extends com.tencent.mm.sdk.b.c<bh> {
    public c() {
        AppMethodBeat.i(52815);
        this.xxI = bh.class.getName().hashCode();
        AppMethodBeat.o(52815);
    }

    private static boolean a(bh bhVar) {
        AppMethodBeat.i(52816);
        if (bhVar.cuB.cut == 37) {
            if (bhVar.cuB.cuu == 5 && bhVar.cuB.cuy == 2) {
                j bkb = j.bkb();
                ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "delete emoji egg!");
                try {
                    e.deleteFile(g.RP().cachePath + "eggingfo.ini");
                    e.N(com.tencent.mm.vfs.j.w(new b(j.getDataEmojiPath(), j.kUd).mUri), true);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e, "", new Object[0]);
                }
                bkb.kUu = null;
            }
            if (bhVar.cuB.cuy == 0) {
                ab.i("MicroMsg.emoji.EmojiResUpdateOperationListener", "cache res type:%d subType:%d", Integer.valueOf(bhVar.cuB.cut), Integer.valueOf(bhVar.cuB.cuu));
            }
        }
        AppMethodBeat.o(52816);
        return false;
    }
}
