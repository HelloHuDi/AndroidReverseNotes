package com.tencent.p177mm.emoji.loader.p1460f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1677a;
import com.tencent.p177mm.p178a.C1168a;
import com.tencent.p177mm.plugin.emoji.C38876c;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.tmassistantsdk.util.Base64;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/emoji/loader/verify/EmojiFileVerify;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "reportDecrypt", "", "verifyConfig", "Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyConfig;", "success", "", "reportVerify", "verify", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.loader.f.a */
public final class C32503a {
    private final String TAG = "MicroMsg.EmojiLoader.EmojiFileVerify";

    /* renamed from: a */
    private static void m53221a(C32504b c32504b, boolean z) {
        AppMethodBeat.m2504i(63230);
        if (z) {
            switch (c32504b.exR) {
                case 1:
                    C38876c.m65942hF(7);
                    AppMethodBeat.m2505o(63230);
                    return;
                case 2:
                    C38876c.m65942hF(11);
                    break;
            }
            AppMethodBeat.m2505o(63230);
            return;
        }
        EmojiInfo emojiInfo = c32504b.exP;
        switch (c32504b.exR) {
            case 1:
                C38876c.m65942hF(8);
                C38876c.m65941a(emojiInfo.mo20410Aq(), 3, 0, 1, emojiInfo.awa(), 1, emojiInfo.field_designerID);
                AppMethodBeat.m2505o(63230);
                return;
            case 2:
                C38876c.m65942hF(12);
                C38876c.m65941a(emojiInfo.mo20410Aq(), 4, 0, 1, emojiInfo.awa(), 1, emojiInfo.field_designerID);
                break;
        }
        AppMethodBeat.m2505o(63230);
    }

    /* renamed from: a */
    public final boolean mo53143a(C32504b c32504b) {
        boolean z;
        AppMethodBeat.m2504i(63229);
        C25052j.m39376p(c32504b, "verifyConfig");
        if (c32504b.eyq) {
            try {
                boolean g = C1168a.m2550g(Base64.encodeToString(C5046bo.anf(c32504b.eyr), 0), c32504b.eys, c32504b.path);
                C5730e.deleteFile(c32504b.eys);
                if (g) {
                    C32503a.m53221a(c32504b, true);
                } else {
                    C32503a.m53221a(c32504b, false);
                    AppMethodBeat.m2505o(63229);
                    return false;
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
                C32503a.m53221a(c32504b, false);
                AppMethodBeat.m2505o(63229);
                return false;
            }
        }
        C5730e.m8623aQ(c32504b.eys, c32504b.path);
        String atg = C5730e.atg(c32504b.path);
        C4990ab.m7416i(this.TAG, "file md5 ".concat(String.valueOf(atg)));
        if (C5046bo.isNullOrNil(atg) || !C6163u.m9833I(atg, c32504b.eyp, true)) {
            z = false;
        } else {
            z = true;
        }
        EmojiInfo emojiInfo = c32504b.exP;
        if (!z) {
            switch (c32504b.exR) {
                case 0:
                    C38876c.m65941a(emojiInfo.mo20410Aq(), 4, 1, 1, emojiInfo.awa(), 1, emojiInfo.field_designerID);
                    C38876c.m65942hF(5);
                    break;
                case 1:
                    C38876c.m65941a(emojiInfo.mo20410Aq(), 2, 1, 1, emojiInfo.awa(), 1, emojiInfo.field_designerID);
                    C38876c.m65942hF(5);
                    break;
                case 2:
                    C38876c.m65941a(emojiInfo.mo20410Aq(), 4, 1, 1, emojiInfo.awa(), 1, emojiInfo.field_designerID);
                    C38876c.m65942hF(14);
                    break;
            }
        }
        switch (c32504b.exR) {
            case 0:
                C38876c.m65941a(emojiInfo.mo20410Aq(), 4, 0, 0, emojiInfo.awa(), 0, emojiInfo.field_designerID);
                C38876c.m65942hF(4);
                break;
            case 1:
                C38876c.m65941a(emojiInfo.mo20410Aq(), 2, 0, 0, emojiInfo.awa(), 0, emojiInfo.field_designerID);
                C38876c.m65942hF(4);
                break;
            case 2:
                C38876c.m65941a(emojiInfo.mo20410Aq(), 4, 0, 0, emojiInfo.awa(), 1, emojiInfo.field_designerID);
                C38876c.m65942hF(13);
                break;
        }
        if (z && C1720g.m3534RN().mo5161QY()) {
            C1677a M = C1720g.m3530M(C6835d.class);
            C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            ((C6835d) M).getEmojiMgr().mo35642c(c32504b.exP, true);
            AppMethodBeat.m2505o(63229);
            return true;
        }
        AppMethodBeat.m2505o(63229);
        return false;
    }
}
