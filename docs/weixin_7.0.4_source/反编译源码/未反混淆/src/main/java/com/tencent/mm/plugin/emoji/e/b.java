package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.sync.a.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Random;

public final class b {
    static void IY(String str) {
        AppMethodBeat.i(52823);
        for (String Je : str.replace("delete", "").trim().split(",")) {
            ((d) g.M(d.class)).getEmojiMgr().Je(Je).duQ();
        }
        AppMethodBeat.o(52823);
    }

    static void IZ(String str) {
        AppMethodBeat.i(52824);
        String[] split = str.split(" ");
        if (split.length <= 1) {
            AppMethodBeat.o(52824);
        } else if (split[1].equals("custom")) {
            for (EmojiInfo duQ : at.dsZ().xYz.OC()) {
                duQ.duQ();
            }
            AppMethodBeat.o(52824);
        } else {
            if (split[1].equals("customRandom")) {
                Random random = new Random();
                for (EmojiInfo duQ2 : at.dsZ().xYz.OC()) {
                    if (random.nextBoolean()) {
                        duQ2.duQ();
                    }
                }
            }
            AppMethodBeat.o(52824);
        }
    }

    static void Ja(String str) {
        AppMethodBeat.i(52825);
        String[] split = str.replace("add", "").trim().split(",");
        ArrayList arrayList = new ArrayList();
        for (String aVar : split) {
            arrayList.add(new a(aVar, "", "", "", "", "", "", "", "", ""));
        }
        j.bkj().kXj.bs(arrayList);
        j.bkj().kXj.bkG();
        AppMethodBeat.o(52825);
    }
}
