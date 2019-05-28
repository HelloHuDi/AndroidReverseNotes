package com.tencent.p177mm.emoji.loader.p1190d;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.sync.EmojiUpdateReceiver;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, dWq = {"Lcom/tencent/mm/emoji/loader/request/ProcessRequest;", "Lcom/tencent/mm/emoji/loader/request/Request;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "onLoad", "success", "", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.loader.d.g */
public final class C41959g extends C18207h<C37091y> {
    public C41959g(EmojiInfo emojiInfo) {
        C25052j.m39376p(emojiInfo, "emojiInfo");
        super(emojiInfo);
        AppMethodBeat.m2504i(63216);
        AppMethodBeat.m2505o(63216);
    }

    /* renamed from: bX */
    public final void mo33677bX(boolean z) {
        AppMethodBeat.m2504i(63215);
        Intent intent = new Intent();
        intent.setAction(EmojiUpdateReceiver.ACTION);
        intent.putExtra(EmojiUpdateReceiver.ezN, EmojiUpdateReceiver.ezT);
        intent.putExtra("md5", this.exP.mo20410Aq());
        intent.putExtra("result", z);
        C4996ah.getContext().sendBroadcast(intent);
        AppMethodBeat.m2505o(63215);
    }
}
