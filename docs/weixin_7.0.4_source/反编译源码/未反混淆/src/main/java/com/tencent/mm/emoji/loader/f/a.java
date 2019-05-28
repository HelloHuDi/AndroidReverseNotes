package com.tencent.mm.emoji.loader.f;

import a.f.b.j;
import a.k.u;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emoji.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;
import com.tencent.tmassistantsdk.util.Base64;

@l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/emoji/loader/verify/EmojiFileVerify;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "reportDecrypt", "", "verifyConfig", "Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyConfig;", "success", "", "reportVerify", "verify", "plugin-emojisdk_release"})
public final class a {
    private final String TAG = "MicroMsg.EmojiLoader.EmojiFileVerify";

    private static void a(b bVar, boolean z) {
        AppMethodBeat.i(63230);
        if (z) {
            switch (bVar.exR) {
                case 1:
                    c.hF(7);
                    AppMethodBeat.o(63230);
                    return;
                case 2:
                    c.hF(11);
                    break;
            }
            AppMethodBeat.o(63230);
            return;
        }
        EmojiInfo emojiInfo = bVar.exP;
        switch (bVar.exR) {
            case 1:
                c.hF(8);
                c.a(emojiInfo.Aq(), 3, 0, 1, emojiInfo.awa(), 1, emojiInfo.field_designerID);
                AppMethodBeat.o(63230);
                return;
            case 2:
                c.hF(12);
                c.a(emojiInfo.Aq(), 4, 0, 1, emojiInfo.awa(), 1, emojiInfo.field_designerID);
                break;
        }
        AppMethodBeat.o(63230);
    }

    public final boolean a(b bVar) {
        boolean z;
        AppMethodBeat.i(63229);
        j.p(bVar, "verifyConfig");
        if (bVar.eyq) {
            try {
                boolean g = com.tencent.mm.a.a.g(Base64.encodeToString(bo.anf(bVar.eyr), 0), bVar.eys, bVar.path);
                e.deleteFile(bVar.eys);
                if (g) {
                    a(bVar, true);
                } else {
                    a(bVar, false);
                    AppMethodBeat.o(63229);
                    return false;
                }
            } catch (Exception e) {
                ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
                a(bVar, false);
                AppMethodBeat.o(63229);
                return false;
            }
        }
        e.aQ(bVar.eys, bVar.path);
        String atg = e.atg(bVar.path);
        ab.i(this.TAG, "file md5 ".concat(String.valueOf(atg)));
        if (bo.isNullOrNil(atg) || !u.I(atg, bVar.eyp, true)) {
            z = false;
        } else {
            z = true;
        }
        EmojiInfo emojiInfo = bVar.exP;
        if (!z) {
            switch (bVar.exR) {
                case 0:
                    c.a(emojiInfo.Aq(), 4, 1, 1, emojiInfo.awa(), 1, emojiInfo.field_designerID);
                    c.hF(5);
                    break;
                case 1:
                    c.a(emojiInfo.Aq(), 2, 1, 1, emojiInfo.awa(), 1, emojiInfo.field_designerID);
                    c.hF(5);
                    break;
                case 2:
                    c.a(emojiInfo.Aq(), 4, 1, 1, emojiInfo.awa(), 1, emojiInfo.field_designerID);
                    c.hF(14);
                    break;
            }
        }
        switch (bVar.exR) {
            case 0:
                c.a(emojiInfo.Aq(), 4, 0, 0, emojiInfo.awa(), 0, emojiInfo.field_designerID);
                c.hF(4);
                break;
            case 1:
                c.a(emojiInfo.Aq(), 2, 0, 0, emojiInfo.awa(), 0, emojiInfo.field_designerID);
                c.hF(4);
                break;
            case 2:
                c.a(emojiInfo.Aq(), 4, 0, 0, emojiInfo.awa(), 1, emojiInfo.field_designerID);
                c.hF(13);
                break;
        }
        if (z && g.RN().QY()) {
            com.tencent.mm.kernel.b.a M = g.M(d.class);
            j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            ((d) M).getEmojiMgr().c(bVar.exP, true);
            AppMethodBeat.o(63229);
            return true;
        }
        AppMethodBeat.o(63229);
        return false;
    }
}
