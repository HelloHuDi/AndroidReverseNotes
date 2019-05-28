package com.tencent.p177mm.emoji.loader.p1190d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.loader.p1190d.C18207h.C18208a;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/emoji/loader/request/EmojiFileRequest;", "Lcom/tencent/mm/emoji/loader/request/Request;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/loader/request/Request$Callback;)V", "onLoad", "success", "", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.loader.d.d */
public final class C41957d extends C18207h<C37091y> {
    private final C18208a eyf;

    public C41957d(EmojiInfo emojiInfo, C18208a c18208a) {
        C25052j.m39376p(emojiInfo, "emojiInfo");
        super(emojiInfo);
        AppMethodBeat.m2504i(63209);
        this.eyf = c18208a;
        AppMethodBeat.m2505o(63209);
    }

    /* renamed from: bX */
    public final void mo33677bX(boolean z) {
        AppMethodBeat.m2504i(63208);
        C18208a c18208a = this.eyf;
        if (c18208a != null) {
            c18208a.mo33675bV(z);
            AppMethodBeat.m2505o(63208);
            return;
        }
        AppMethodBeat.m2505o(63208);
    }
}
