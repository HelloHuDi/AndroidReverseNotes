package com.tencent.p177mm.emoji.loader.p849e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.loader.EmojiLoaderProxy;
import com.tencent.p177mm.emoji.loader.EmojiLoaderProxy.C1518a;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016¨\u0006\f"}, dWq = {"Lcom/tencent/mm/emoji/loader/task/ProcessTask;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getTaskKey", "", "onResult", "", "success", "", "run", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.loader.e.e */
public final class C41209e extends C37685c {
    public C41209e(EmojiInfo emojiInfo) {
        C25052j.m39376p(emojiInfo, "emojiInfo");
        super(emojiInfo);
        AppMethodBeat.m2504i(63228);
        AppMethodBeat.m2505o(63228);
    }

    public final void run() {
        AppMethodBeat.m2504i(63226);
        super.run();
        C1518a c1518a = EmojiLoaderProxy.exx;
        EmojiLoaderProxy.exv = EmojiLoaderProxy.exv + 1;
        if (EmojiLoaderProxy.exw) {
            EmojiLoaderProxy.exw = false;
            EmojiLoaderProxy emojiLoaderProxy = new EmojiLoaderProxy(new C46607d(C4996ah.getContext()));
            C25052j.m39376p(emojiLoaderProxy, "<set-?>");
            EmojiLoaderProxy.exu = emojiLoaderProxy;
        }
        c1518a = EmojiLoaderProxy.exx;
        EmojiLoaderProxy.exu.load(this.exP);
        AppMethodBeat.m2505o(63226);
    }

    /* renamed from: bV */
    public final void mo20716bV(boolean z) {
        AppMethodBeat.m2504i(63227);
        super.mo20716bV(z);
        C1518a c1518a = EmojiLoaderProxy.exx;
        EmojiLoaderProxy.exv = EmojiLoaderProxy.exv - 1;
        if (EmojiLoaderProxy.exv <= 0) {
            EmojiLoaderProxy.exw = true;
            C46607d serverProxy = EmojiLoaderProxy.exu.getServerProxy();
            if (serverProxy != null) {
                serverProxy.release();
                AppMethodBeat.m2505o(63227);
                return;
            }
        }
        AppMethodBeat.m2505o(63227);
    }

    /* renamed from: OA */
    public final String mo20715OA() {
        AppMethodBeat.m2504i(63225);
        String Aq = this.exP.mo20410Aq();
        C25052j.m39375o(Aq, "emojiInfo.md5");
        AppMethodBeat.m2505o(63225);
        return Aq;
    }
}
