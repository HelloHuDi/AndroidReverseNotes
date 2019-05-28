package com.tencent.mm.emoji.sync;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.loader.c.g;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, dWq = {"Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "call", "", "checkUpdate", "uniqueId", "", "Companion", "plugin-emojisdk_release"})
public final class a extends c {
    private static final String TAG = TAG;
    public static final a ezo = new a();
    final EmojiInfo exP;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    static final class b extends k implements a.f.a.b<Boolean, y> {
        final /* synthetic */ a ezp;

        b(a aVar) {
            this.ezp = aVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            y yVar;
            AppMethodBeat.i(63252);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            ab.i(a.TAG, this.ezp + ' ' + this.ezp.exP.Aq() + " fetcher " + booleanValue);
            if (booleanValue) {
                com.tencent.mm.emoji.loader.f.c cVar = com.tencent.mm.emoji.loader.f.c.eyt;
                booleanValue = com.tencent.mm.emoji.loader.f.c.i(this.ezp.exP);
                ab.i(a.TAG, this.ezp.exP.Aq() + " verify " + booleanValue);
                if (booleanValue) {
                    Thread.sleep(300);
                    a.a(this.ezp);
                    this.ezp.a(h.OK);
                    yVar = y.AUy;
                    AppMethodBeat.o(63252);
                    return yVar;
                }
            }
            this.ezp.a(h.Fail);
            yVar = y.AUy;
            AppMethodBeat.o(63252);
            return yVar;
        }
    }

    public a(EmojiInfo emojiInfo) {
        j.p(emojiInfo, "emojiInfo");
        AppMethodBeat.i(63256);
        this.exP = emojiInfo;
        AppMethodBeat.o(63256);
    }

    public static final /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(63258);
        aVar.Pb();
        AppMethodBeat.o(63258);
    }

    static {
        AppMethodBeat.i(63257);
        AppMethodBeat.o(63257);
    }

    public final void Pa() {
        AppMethodBeat.i(63253);
        if (this.exP.duP()) {
            ab.i(TAG, this + ' ' + this.exP.Aq() + ": already load");
            Pb();
            a(h.OK);
            AppMethodBeat.o(63253);
            return;
        }
        g gVar = g.exW;
        g.a(this.exP, new b(this));
        AppMethodBeat.o(63253);
    }

    private final void Pb() {
        AppMethodBeat.i(63254);
        boolean z = false;
        at dsZ = at.dsZ();
        j.o(dsZ, "EmojiStorageMgr.getInstance()");
        EmojiInfo aqi = dsZ.aUp().aqi(this.exP.Aq());
        if (aqi == null) {
            AppMethodBeat.o(63254);
            return;
        }
        if (aqi.getState() != EmojiInfo.zZb) {
            aqi.setState(EmojiInfo.zZb);
            z = true;
        }
        if (aqi.field_width <= 0 || aqi.field_width <= 0) {
            com.tencent.mm.emoji.decode.b decoder = MMGIFJNIFactory.Companion.getDecoder(aqi);
            if (MMGIFJNIFactory.Companion.isValid(decoder)) {
                aqi.field_width = decoder.Ou();
                aqi.field_height = decoder.Ov();
                z = true;
            }
            decoder.destroy();
        }
        if (z) {
            at dsZ2 = at.dsZ();
            j.o(dsZ2, "EmojiStorageMgr.getInstance()");
            dsZ2.aUp().G(aqi);
            if (j.j(this.exP.awa(), "capture")) {
                com.tencent.mm.emoji.a.a.OB().cd(true);
            }
        }
        AppMethodBeat.o(63254);
    }

    public final String Pc() {
        AppMethodBeat.i(63255);
        String Aq = this.exP.Aq();
        j.o(Aq, "emojiInfo.md5");
        AppMethodBeat.o(63255);
        return Aq;
    }
}
