package com.tencent.p177mm.emoji.loader.p848c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.p227a.C26072e;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u000e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u000e\u0010\b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, dWq = {"checkUseCdn", "", "fetcherType", "", "checkUseEncrypt", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "checkUseTpUrl", "checkUseWxam", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.loader.c.h */
public final class C45307h {
    /* renamed from: f */
    public static final boolean m83556f(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(63194);
        C25052j.m39376p(emojiInfo, "emojiInfo");
        if (C5046bo.isNullOrNil(emojiInfo.field_tpurl)) {
            AppMethodBeat.m2505o(63194);
            return false;
        }
        AppMethodBeat.m2505o(63194);
        return true;
    }

    /* renamed from: g */
    public static final boolean m83557g(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(63195);
        C25052j.m39376p(emojiInfo, "emojiInfo");
        if (!C26072e.m41622OQ() || C5046bo.isNullOrNil(emojiInfo.field_externUrl) || C5046bo.isNullOrNil(emojiInfo.field_aeskey)) {
            AppMethodBeat.m2505o(63195);
            return false;
        }
        AppMethodBeat.m2505o(63195);
        return true;
    }

    /* renamed from: h */
    public static final boolean m83558h(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(63196);
        C25052j.m39376p(emojiInfo, "emojiInfo");
        if (C5046bo.isNullOrNil(emojiInfo.field_encrypturl) || C5046bo.isNullOrNil(emojiInfo.field_aeskey)) {
            AppMethodBeat.m2505o(63196);
            return false;
        }
        AppMethodBeat.m2505o(63196);
        return true;
    }
}
