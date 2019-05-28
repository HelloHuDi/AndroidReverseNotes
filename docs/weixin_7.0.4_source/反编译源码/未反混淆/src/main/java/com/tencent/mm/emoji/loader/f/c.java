package com.tencent.mm.emoji.loader.f;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.c.h;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, dWq = {"Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyFactory;", "", "()V", "createVerifyConfig", "Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyConfig;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "verify", "", "plugin-emojisdk_release"})
public final class c {
    public static final c eyt = new c();

    static {
        AppMethodBeat.i(63236);
        AppMethodBeat.o(63236);
    }

    private c() {
    }

    public static boolean i(EmojiInfo emojiInfo) {
        int i;
        boolean z;
        AppMethodBeat.i(63235);
        j.p(emojiInfo, "emojiInfo");
        a aVar = new a();
        j.p(emojiInfo, "emojiInfo");
        String Aq = emojiInfo.Aq();
        String str = emojiInfo.dve() + "_temp";
        if (h.f(emojiInfo)) {
            i = 3;
            z = true;
        } else if (h.g(emojiInfo)) {
            i = 2;
            Aq = emojiInfo.field_externMd5;
            z = true;
        } else if (h.h(emojiInfo)) {
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
        boolean a = aVar.a(new b(emojiInfo, Aq, z, str2, dve, str, i));
        AppMethodBeat.o(63235);
        return a;
    }
}
