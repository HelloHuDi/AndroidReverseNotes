package com.tencent.mm.emoji.loader.e;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.c.g;
import com.tencent.mm.emoji.loader.f.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/emoji/loader/task/EmojiLoadTask;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkCache", "", "getTaskKey", "run", "", "plugin-emojisdk_release"})
public final class b extends c {
    final String TAG = "MicroMsg.EmojiLoadTask";

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    static final class a extends k implements a.f.a.b<Boolean, y> {
        final /* synthetic */ b eyo;

        a(b bVar) {
            this.eyo = bVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(63221);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            ab.i(this.eyo.TAG, this.eyo.exP.Aq() + " fetch " + booleanValue);
            if (booleanValue) {
                c cVar = c.eyt;
                booleanValue = c.i(this.eyo.exP);
                ab.i(this.eyo.TAG, this.eyo.exP.Aq() + " verify " + booleanValue);
                this.eyo.bV(booleanValue);
            } else {
                this.eyo.bV(false);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(63221);
            return yVar;
        }
    }

    public b(EmojiInfo emojiInfo) {
        j.p(emojiInfo, "emojiInfo");
        super(emojiInfo);
        AppMethodBeat.i(63224);
        AppMethodBeat.o(63224);
    }

    public final void run() {
        AppMethodBeat.i(63223);
        super.run();
        if (this.exP.duP()) {
            bV(true);
            AppMethodBeat.o(63223);
            return;
        }
        g gVar = g.exW;
        g.a(this.exP, new a(this));
        AppMethodBeat.o(63223);
    }

    public final String OA() {
        AppMethodBeat.i(63222);
        String Aq = this.exP.Aq();
        j.o(Aq, "emojiInfo.md5");
        AppMethodBeat.o(63222);
        return Aq;
    }
}
