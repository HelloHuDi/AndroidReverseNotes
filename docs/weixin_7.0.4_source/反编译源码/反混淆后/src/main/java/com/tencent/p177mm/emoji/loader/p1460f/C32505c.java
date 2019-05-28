package com.tencent.p177mm.emoji.loader.p1460f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.loader.p848c.C45307h;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, dWq = {"Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyFactory;", "", "()V", "createVerifyConfig", "Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyConfig;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "verify", "", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.loader.f.c */
public final class C32505c {
    public static final C32505c eyt = new C32505c();

    static {
        AppMethodBeat.m2504i(63236);
        AppMethodBeat.m2505o(63236);
    }

    private C32505c() {
    }

    /* renamed from: i */
    public static boolean m53223i(EmojiInfo emojiInfo) {
        int i;
        boolean z;
        AppMethodBeat.m2504i(63235);
        C25052j.m39376p(emojiInfo, "emojiInfo");
        C32503a c32503a = new C32503a();
        C25052j.m39376p(emojiInfo, "emojiInfo");
        String Aq = emojiInfo.mo20410Aq();
        String str = emojiInfo.dve() + "_temp";
        if (C45307h.m83556f(emojiInfo)) {
            i = 3;
            z = true;
        } else if (C45307h.m83557g(emojiInfo)) {
            i = 2;
            Aq = emojiInfo.field_externMd5;
            z = true;
        } else if (C45307h.m83558h(emojiInfo)) {
            i = 1;
            z = true;
        } else {
            i = 0;
            z = false;
        }
        if (Aq == null) {
            Aq = "";
        }
        String str2 = emojiInfo.field_aeskey;
        if (str2 == null) {
            str2 = "";
        }
        String dve = emojiInfo.dve();
        if (dve == null) {
            dve = "";
        }
        boolean a = c32503a.mo53143a(new C32504b(emojiInfo, Aq, z, str2, dve, str, i));
        AppMethodBeat.m2505o(63235);
        return a;
    }
}
