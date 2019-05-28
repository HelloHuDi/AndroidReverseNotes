package com.tencent.mm.emoji.d;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.loader.g.a.h;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(dWo = {1, 1, 13}, dWp = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/emoji/upload/EmojiUploadManager;", "", "()V", "emojiCaptureUploadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "uploadCallback", "com/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1", "Lcom/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1;", "addUploadTask", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "timeEnter", "", "plugin-emojisdk_release"})
public final class d {
    private static final com.tencent.mm.loader.g.d<c> eAf = new com.tencent.mm.loader.g.d(new g(new com.tencent.mm.loader.g.a.a(20), new h(), "EmojiUpload"));
    private static final a eAg = new a();
    public static final d eAh = new d();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
    public static final class a implements f<c> {
        a() {
        }

        public final /* synthetic */ void a(c cVar, com.tencent.mm.loader.g.h hVar) {
            AppMethodBeat.i(63300);
            c cVar2 = (c) cVar;
            j.p(cVar2, "task");
            j.p(hVar, "status");
            ab.i(e.TAG, "onLoaderFin: " + String.valueOf(cVar2.ezZ) + ", " + hVar);
            AppMethodBeat.o(63300);
        }
    }

    static {
        AppMethodBeat.i(63303);
        eAf.a((f) eAg);
        AppMethodBeat.o(63303);
    }

    private d() {
    }

    public static void k(EmojiInfo emojiInfo) {
        AppMethodBeat.i(63301);
        j.p(emojiInfo, "emojiInfo");
        ab.i(e.TAG, "addUploadTask: " + emojiInfo.Aq());
        eAf.a((c) new c(emojiInfo));
        AppMethodBeat.o(63301);
    }

    public static void eY(long j) {
        AppMethodBeat.i(63302);
        ab.i(e.TAG, "addUploadTask: ".concat(String.valueOf(j)));
        at dsZ = at.dsZ();
        j.o(dsZ, "EmojiStorageMgr.getInstance()");
        EmojiInfo mU = dsZ.aUp().mU(j);
        ab.i(e.TAG, "addUploadTask: " + (mU != null ? mU.Aq() : null));
        if (mU != null) {
            k(mU);
            AppMethodBeat.o(63302);
            return;
        }
        AppMethodBeat.o(63302);
    }
}
