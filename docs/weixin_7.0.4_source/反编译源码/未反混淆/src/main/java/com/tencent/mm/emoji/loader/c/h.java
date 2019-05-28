package com.tencent.mm.emoji.loader.c;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.e;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u000e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u000e\u0010\b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, dWq = {"checkUseCdn", "", "fetcherType", "", "checkUseEncrypt", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "checkUseTpUrl", "checkUseWxam", "plugin-emojisdk_release"})
public final class h {
    public static final boolean f(EmojiInfo emojiInfo) {
        AppMethodBeat.i(63194);
        j.p(emojiInfo, "emojiInfo");
        if (bo.isNullOrNil(emojiInfo.field_tpurl)) {
            AppMethodBeat.o(63194);
            return false;
        }
        AppMethodBeat.o(63194);
        return true;
    }

    public static final boolean g(EmojiInfo emojiInfo) {
        AppMethodBeat.i(63195);
        j.p(emojiInfo, "emojiInfo");
        if (!e.OQ() || bo.isNullOrNil(emojiInfo.field_externUrl) || bo.isNullOrNil(emojiInfo.field_aeskey)) {
            AppMethodBeat.o(63195);
            return false;
        }
        AppMethodBeat.o(63195);
        return true;
    }

    public static final boolean h(EmojiInfo emojiInfo) {
        AppMethodBeat.i(63196);
        j.p(emojiInfo, "emojiInfo");
        if (bo.isNullOrNil(emojiInfo.field_encrypturl) || bo.isNullOrNil(emojiInfo.field_aeskey)) {
            AppMethodBeat.o(63196);
            return false;
        }
        AppMethodBeat.o(63196);
        return true;
    }
}
