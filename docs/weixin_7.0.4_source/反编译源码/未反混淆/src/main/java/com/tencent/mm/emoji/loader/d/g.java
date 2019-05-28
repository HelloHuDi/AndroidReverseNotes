package com.tencent.mm.emoji.loader.d;

import a.f.b.j;
import a.l;
import a.y;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.sync.EmojiUpdateReceiver;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, dWq = {"Lcom/tencent/mm/emoji/loader/request/ProcessRequest;", "Lcom/tencent/mm/emoji/loader/request/Request;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "onLoad", "success", "", "plugin-emojisdk_release"})
public final class g extends h<y> {
    public g(EmojiInfo emojiInfo) {
        j.p(emojiInfo, "emojiInfo");
        super(emojiInfo);
        AppMethodBeat.i(63216);
        AppMethodBeat.o(63216);
    }

    public final void bX(boolean z) {
        AppMethodBeat.i(63215);
        Intent intent = new Intent();
        intent.setAction(EmojiUpdateReceiver.ACTION);
        intent.putExtra(EmojiUpdateReceiver.ezN, EmojiUpdateReceiver.ezT);
        intent.putExtra("md5", this.exP.Aq());
        intent.putExtra("result", z);
        ah.getContext().sendBroadcast(intent);
        AppMethodBeat.o(63215);
    }
}
