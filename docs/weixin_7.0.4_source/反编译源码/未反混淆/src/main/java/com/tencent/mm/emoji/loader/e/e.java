package com.tencent.mm.emoji.loader.e;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.EmojiLoaderProxy;
import com.tencent.mm.emoji.loader.EmojiLoaderProxy.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016¨\u0006\f"}, dWq = {"Lcom/tencent/mm/emoji/loader/task/ProcessTask;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getTaskKey", "", "onResult", "", "success", "", "run", "plugin-emojisdk_release"})
public final class e extends c {
    public e(EmojiInfo emojiInfo) {
        j.p(emojiInfo, "emojiInfo");
        super(emojiInfo);
        AppMethodBeat.i(63228);
        AppMethodBeat.o(63228);
    }

    public final void run() {
        AppMethodBeat.i(63226);
        super.run();
        a aVar = EmojiLoaderProxy.exx;
        EmojiLoaderProxy.exv = EmojiLoaderProxy.exv + 1;
        if (EmojiLoaderProxy.exw) {
            EmojiLoaderProxy.exw = false;
            EmojiLoaderProxy emojiLoaderProxy = new EmojiLoaderProxy(new d(ah.getContext()));
            j.p(emojiLoaderProxy, "<set-?>");
            EmojiLoaderProxy.exu = emojiLoaderProxy;
        }
        aVar = EmojiLoaderProxy.exx;
        EmojiLoaderProxy.exu.load(this.exP);
        AppMethodBeat.o(63226);
    }

    public final void bV(boolean z) {
        AppMethodBeat.i(63227);
        super.bV(z);
        a aVar = EmojiLoaderProxy.exx;
        EmojiLoaderProxy.exv = EmojiLoaderProxy.exv - 1;
        if (EmojiLoaderProxy.exv <= 0) {
            EmojiLoaderProxy.exw = true;
            d serverProxy = EmojiLoaderProxy.exu.getServerProxy();
            if (serverProxy != null) {
                serverProxy.release();
                AppMethodBeat.o(63227);
                return;
            }
        }
        AppMethodBeat.o(63227);
    }

    public final String OA() {
        AppMethodBeat.i(63225);
        String Aq = this.exP.Aq();
        j.o(Aq, "emojiInfo.md5");
        AppMethodBeat.o(63225);
        return Aq;
    }
}
