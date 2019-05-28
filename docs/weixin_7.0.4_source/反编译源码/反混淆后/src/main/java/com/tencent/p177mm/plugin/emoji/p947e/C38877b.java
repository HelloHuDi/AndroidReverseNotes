package com.tencent.p177mm.plugin.emoji.p947e;

import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.decode.C26076b;
import com.tencent.p177mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.p177mm.emoji.p227a.C32497a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.emoji.sync.p948a.C45860a;
import com.tencent.p177mm.plugin.gif.C3266d;
import com.tencent.p177mm.plugin.gif.C36775h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.storage.C23505at;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.FileUtils;
import java.util.ArrayList;
import java.util.Random;

/* renamed from: com.tencent.mm.plugin.emoji.e.b */
public final class C38877b {

    /* renamed from: com.tencent.mm.plugin.emoji.e.b$1 */
    static class C277331 implements Runnable {
        C277331() {
        }

        public final void run() {
            AppMethodBeat.m2504i(52822);
            ArrayList<EmojiInfo> bZ = C32497a.m53203OB().mo53137bZ(true);
            bZ.addAll(C23505at.dsZ().xYn.dvj());
            for (EmojiInfo emojiInfo : bZ) {
                long currentTimeMillis = System.currentTimeMillis();
                byte[] l = C20362f.bjK().mo35593l(emojiInfo);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                try {
                    if (C5063r.m7679bU(l)) {
                        C36775h c36775h = new C36775h(l);
                    } else {
                        C3266d c3266d = new C3266d(l);
                    }
                } catch (Exception e) {
                }
                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                C4990ab.m7417i("MicroMsg.emoji.EmojiCommandMgr", "run: %s, %s", Long.valueOf(currentTimeMillis2), Long.valueOf(currentTimeMillis - currentTimeMillis2));
            }
            for (EmojiInfo emojiInfo2 : bZ) {
                long currentTimeMillis3 = System.currentTimeMillis();
                C5730e.asZ(emojiInfo2.dve());
                C26076b decoder = MMGIFJNIFactory.Companion.getDecoder(emojiInfo2);
                decoder.mo33669Or();
                decoder.destroy();
                C4990ab.m7417i("MicroMsg.emoji.EmojiCommandMgr", "run: time is %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                C5730e.m8643tf("/sdcard/temp/emoji/");
                currentTimeMillis3 = System.currentTimeMillis();
                BitmapFactory.decodeFile("/sdcard/temp/emoji/" + emojiInfo2.field_md5 + FileUtils.PIC_POSTFIX_JPEG);
                C4990ab.m7417i("MicroMsg.emoji.EmojiCommandMgr", "run: file time is %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
            }
            AppMethodBeat.m2505o(52822);
        }
    }

    /* renamed from: IY */
    static void m65943IY(String str) {
        AppMethodBeat.m2504i(52823);
        for (String Je : str.replace("delete", "").trim().split(",")) {
            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35597Je(Je).duQ();
        }
        AppMethodBeat.m2505o(52823);
    }

    /* renamed from: IZ */
    static void m65944IZ(String str) {
        AppMethodBeat.m2504i(52824);
        String[] split = str.split(" ");
        if (split.length <= 1) {
            AppMethodBeat.m2505o(52824);
        } else if (split[1].equals("custom")) {
            for (EmojiInfo duQ : C23505at.dsZ().xYz.mo53134OC()) {
                duQ.duQ();
            }
            AppMethodBeat.m2505o(52824);
        } else {
            if (split[1].equals("customRandom")) {
                Random random = new Random();
                for (EmojiInfo duQ2 : C23505at.dsZ().xYz.mo53134OC()) {
                    if (random.nextBoolean()) {
                        duQ2.duQ();
                    }
                }
            }
            AppMethodBeat.m2505o(52824);
        }
    }

    /* renamed from: Ja */
    static void m65945Ja(String str) {
        AppMethodBeat.m2504i(52825);
        String[] split = str.replace("add", "").trim().split(",");
        ArrayList arrayList = new ArrayList();
        for (String c45860a : split) {
            arrayList.add(new C45860a(c45860a, "", "", "", "", "", "", "", "", ""));
        }
        C42952j.bkj().kXj.mo7136bs(arrayList);
        C42952j.bkj().kXj.bkG();
        AppMethodBeat.m2505o(52825);
    }
}
