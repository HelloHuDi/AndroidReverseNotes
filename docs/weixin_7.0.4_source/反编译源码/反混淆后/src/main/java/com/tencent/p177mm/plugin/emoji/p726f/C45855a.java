package com.tencent.p177mm.plugin.emoji.p726f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p383h.C2932a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.emotion.C46623a;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;

/* renamed from: com.tencent.mm.plugin.emoji.f.a */
public class C45855a extends C7564ap {
    private static int kWe = 0;
    private static C45855a kWf;
    private static C42949q kWg;
    private static C1202f kWh = new C68361();

    /* renamed from: com.tencent.mm.plugin.emoji.f.a$1 */
    static class C68361 implements C1202f {
        C68361() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(53084);
            if (i == 0 && i2 == 0) {
                C45855a.kWe = 0;
                C45855a.bkq().mo16770ae(50, 50);
                AppMethodBeat.m2505o(53084);
                return;
            }
            C45855a.bkq().bks();
            AppMethodBeat.m2505o(53084);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.f.a$a */
    public static class C33948a implements C5015a {
        public C33948a() {
            AppMethodBeat.m2504i(53085);
            C45855a.kWe = 0;
            AppMethodBeat.m2505o(53085);
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(53086);
            if (C45855a.kWe >= 100) {
                C45855a.kWe = 0;
                C4990ab.m7410d("MicroMsg.emoji.EmojiTuziTool", "insert tuzi");
                C46623a c46623a = C42952j.getEmojiStorageMgr().xYo;
                EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                emojiGroupInfo.field_productID = C2932a.bmu();
                emojiGroupInfo.field_packName = "emoji_custom_all";
                emojiGroupInfo.field_type = EmojiGroupInfo.TYPE_SYSTEM;
                emojiGroupInfo.field_sort = 1;
                emojiGroupInfo.field_idx = 0;
                emojiGroupInfo.field_packType = 4;
                emojiGroupInfo.field_packFlag = 1;
                emojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
                c46623a.mo74771c(emojiGroupInfo);
                C42952j.bkn().mo35678g(C2932a.bmu(), 7, C45855a.kWe, "");
                C45855a.removeListener();
                AppMethodBeat.m2505o(53086);
                return false;
            }
            C42952j.bkn().mo35678g(C2932a.bmu(), 6, C45855a.kWe, "");
            C45855a.kWe = C45855a.kWe + 2;
            AppMethodBeat.m2505o(53086);
            return true;
        }
    }

    static {
        AppMethodBeat.m2504i(53092);
        AppMethodBeat.m2505o(53092);
    }

    public static final C45855a bkq() {
        AppMethodBeat.m2504i(53087);
        if (kWf == null) {
            synchronized (C45855a.class) {
                try {
                    if (kWf == null) {
                        kWf = new C45855a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(53087);
                    }
                }
            }
        } else {
            kWf.stopTimer();
        }
        C45855a c45855a = kWf;
        AppMethodBeat.m2505o(53087);
        return c45855a;
    }

    public static void bkr() {
        AppMethodBeat.m2504i(53088);
        kWe = 0;
        kWg = new C42949q("com.tencent.xin.emoticon.tusiji", 1);
        C1720g.m3535RO().eJo.mo14541a(kWg, 0);
        C1720g.m3535RO().eJo.mo14539a(413, kWh);
        C4990ab.m7410d("MicroMsg.emoji.MockTuziDownloading", "add listener");
        AppMethodBeat.m2505o(53088);
    }

    public final void bks() {
        AppMethodBeat.m2504i(53089);
        stopTimer();
        C42952j.bkn().mo35678g(C2932a.bmu(), 3, kWe, "");
        C45855a.removeListener();
        AppMethodBeat.m2505o(53089);
    }

    public static void removeListener() {
        AppMethodBeat.m2504i(53090);
        if (kWg != null) {
            C1720g.m3535RO().eJo.mo14547c(kWg);
        }
        C1720g.m3535RO().eJo.mo14546b(413, kWh);
        C4990ab.m7410d("MicroMsg.emoji.MockTuziDownloading", "remove listener");
        AppMethodBeat.m2505o(53090);
    }

    private C45855a() {
        super(new C33948a(), true);
        AppMethodBeat.m2504i(53091);
        AppMethodBeat.m2505o(53091);
    }
}
