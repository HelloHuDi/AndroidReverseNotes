package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public class a extends ap {
    private static int kWe = 0;
    private static a kWf;
    private static q kWg;
    private static f kWh = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(53084);
            if (i == 0 && i2 == 0) {
                a.kWe = 0;
                a.bkq().ae(50, 50);
                AppMethodBeat.o(53084);
                return;
            }
            a.bkq().bks();
            AppMethodBeat.o(53084);
        }
    };

    public static class a implements com.tencent.mm.sdk.platformtools.ap.a {
        public a() {
            AppMethodBeat.i(53085);
            a.kWe = 0;
            AppMethodBeat.o(53085);
        }

        public final boolean BI() {
            AppMethodBeat.i(53086);
            if (a.kWe >= 100) {
                a.kWe = 0;
                ab.d("MicroMsg.emoji.EmojiTuziTool", "insert tuzi");
                com.tencent.mm.storage.emotion.a aVar = j.getEmojiStorageMgr().xYo;
                EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                emojiGroupInfo.field_productID = com.tencent.mm.plugin.emoji.h.a.bmu();
                emojiGroupInfo.field_packName = "emoji_custom_all";
                emojiGroupInfo.field_type = EmojiGroupInfo.TYPE_SYSTEM;
                emojiGroupInfo.field_sort = 1;
                emojiGroupInfo.field_idx = 0;
                emojiGroupInfo.field_packType = 4;
                emojiGroupInfo.field_packFlag = 1;
                emojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
                aVar.c(emojiGroupInfo);
                j.bkn().g(com.tencent.mm.plugin.emoji.h.a.bmu(), 7, a.kWe, "");
                a.removeListener();
                AppMethodBeat.o(53086);
                return false;
            }
            j.bkn().g(com.tencent.mm.plugin.emoji.h.a.bmu(), 6, a.kWe, "");
            a.kWe = a.kWe + 2;
            AppMethodBeat.o(53086);
            return true;
        }
    }

    static {
        AppMethodBeat.i(53092);
        AppMethodBeat.o(53092);
    }

    public static final a bkq() {
        AppMethodBeat.i(53087);
        if (kWf == null) {
            synchronized (a.class) {
                try {
                    if (kWf == null) {
                        kWf = new a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(53087);
                    }
                }
            }
        } else {
            kWf.stopTimer();
        }
        a aVar = kWf;
        AppMethodBeat.o(53087);
        return aVar;
    }

    public static void bkr() {
        AppMethodBeat.i(53088);
        kWe = 0;
        kWg = new q("com.tencent.xin.emoticon.tusiji", 1);
        g.RO().eJo.a(kWg, 0);
        g.RO().eJo.a(413, kWh);
        ab.d("MicroMsg.emoji.MockTuziDownloading", "add listener");
        AppMethodBeat.o(53088);
    }

    public final void bks() {
        AppMethodBeat.i(53089);
        stopTimer();
        j.bkn().g(com.tencent.mm.plugin.emoji.h.a.bmu(), 3, kWe, "");
        removeListener();
        AppMethodBeat.o(53089);
    }

    public static void removeListener() {
        AppMethodBeat.i(53090);
        if (kWg != null) {
            g.RO().eJo.c(kWg);
        }
        g.RO().eJo.b(413, kWh);
        ab.d("MicroMsg.emoji.MockTuziDownloading", "remove listener");
        AppMethodBeat.o(53090);
    }

    private a() {
        super(new a(), true);
        AppMethodBeat.i(53091);
        AppMethodBeat.o(53091);
    }
}
