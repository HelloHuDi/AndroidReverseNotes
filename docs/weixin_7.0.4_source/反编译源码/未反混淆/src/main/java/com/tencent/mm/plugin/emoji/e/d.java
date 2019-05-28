package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;

public class d {
    public static d kTE;
    public ArrayList<String> kTF = new ArrayList();
    public boolean kTG = true;
    public boolean kTH = false;

    /* renamed from: com.tencent.mm.plugin.emoji.e.d$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ EmojiInfo kTI;

        AnonymousClass2(EmojiInfo emojiInfo) {
            this.kTI = emojiInfo;
        }

        /* JADX WARNING: Missing block: B:9:0x002c, code skipped:
            if (r2.field_sync > 0) goto L_0x002e;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            boolean z = true;
            AppMethodBeat.i(52850);
            if (!(this.kTI == null || this.kTI.duP())) {
                String str = this.kTI.field_groupId;
                if (!bo.isNullOrNil(str)) {
                    EmojiGroupInfo bZ = j.getEmojiStorageMgr().xYo.bZ(str, true);
                    if (bZ != null) {
                    }
                }
                z = false;
                if (z) {
                    d.a(d.this, this.kTI);
                    AppMethodBeat.o(52850);
                    return;
                }
                d.a(this.kTI, false);
            }
            AppMethodBeat.o(52850);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.e.d$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ EmojiInfo kTI;

        AnonymousClass1(EmojiInfo emojiInfo) {
            this.kTI = emojiInfo;
        }

        public final void run() {
            AppMethodBeat.i(52849);
            if (!(this.kTI == null || this.kTI.duP())) {
                ab.i("MicroMsg.emoji.EmojiFileCheckerMgr", "chatting emoji broken. try to recover:%s", this.kTI.Aq());
                d.a(this.kTI, true);
            }
            AppMethodBeat.o(52849);
        }
    }

    public d() {
        AppMethodBeat.i(52852);
        AppMethodBeat.o(52852);
    }

    public static d bjH() {
        AppMethodBeat.i(52853);
        if (kTE == null) {
            synchronized (d.class) {
                try {
                    kTE = new d();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(52853);
                    }
                }
            }
        }
        d dVar = kTE;
        AppMethodBeat.o(52853);
        return dVar;
    }

    public static void a(EmojiInfo emojiInfo, boolean z) {
        AppMethodBeat.i(52854);
        if (emojiInfo != null) {
            emojiInfo.field_reserved4 = 0;
            j.getEmojiStorageMgr().xYn.H(emojiInfo);
            j.bkh().s(emojiInfo);
            if (z) {
                h.pYm.a(231, 0, 1, false);
                AppMethodBeat.o(52854);
                return;
            }
            h.pYm.a(231, 1, 1, false);
        }
        AppMethodBeat.o(52854);
    }

    private void b(EmojiInfo emojiInfo, boolean z) {
        AppMethodBeat.i(52855);
        if (this.kTF == null) {
            this.kTF = new ArrayList();
        }
        this.kTF.add(emojiInfo.field_groupId);
        g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.g(emojiInfo.field_groupId), 0);
        if (z) {
            h.pYm.a(231, 3, 1, false);
            AppMethodBeat.o(52855);
            return;
        }
        h.pYm.a(231, 2, 1, false);
        AppMethodBeat.o(52855);
    }

    private static boolean bjI() {
        AppMethodBeat.i(52856);
        if (at.is3G(ah.getContext()) || at.is4G(ah.getContext()) || at.is2G(ah.getContext())) {
            AppMethodBeat.o(52856);
            return true;
        }
        AppMethodBeat.o(52856);
        return false;
    }
}
