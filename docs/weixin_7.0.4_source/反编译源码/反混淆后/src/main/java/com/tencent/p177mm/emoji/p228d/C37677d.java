package com.tencent.p177mm.emoji.p228d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.p864g.C26365c;
import com.tencent.p177mm.loader.p864g.C26366d;
import com.tencent.p177mm.loader.p864g.C42155f;
import com.tencent.p177mm.loader.p864g.C45423h;
import com.tencent.p177mm.loader.p864g.p1196a.C18536g;
import com.tencent.p177mm.loader.p864g.p1196a.C18537h;
import com.tencent.p177mm.loader.p864g.p1196a.C46886a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C23505at;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/emoji/upload/EmojiUploadManager;", "", "()V", "emojiCaptureUploadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "uploadCallback", "com/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1", "Lcom/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1;", "addUploadTask", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "timeEnter", "", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.d.d */
public final class C37677d {
    private static final C26366d<C41950c> eAf = new C26366d(new C18536g(new C46886a(20), new C18537h(), "EmojiUpload"));
    private static final C37678a eAg = new C37678a();
    public static final C37677d eAh = new C37677d();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.d.d$a */
    public static final class C37678a implements C42155f<C41950c> {
        C37678a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo9004a(C26365c c26365c, C45423h c45423h) {
            AppMethodBeat.m2504i(63300);
            C41950c c41950c = (C41950c) c26365c;
            C25052j.m39376p(c41950c, "task");
            C25052j.m39376p(c45423h, "status");
            C4990ab.m7416i(C45304e.TAG, "onLoaderFin: " + String.valueOf(c41950c.ezZ) + ", " + c45423h);
            AppMethodBeat.m2505o(63300);
        }
    }

    static {
        AppMethodBeat.m2504i(63303);
        eAf.mo44160a((C42155f) eAg);
        AppMethodBeat.m2505o(63303);
    }

    private C37677d() {
    }

    /* renamed from: k */
    public static void m63711k(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(63301);
        C25052j.m39376p(emojiInfo, "emojiInfo");
        C4990ab.m7416i(C45304e.TAG, "addUploadTask: " + emojiInfo.mo20410Aq());
        eAf.mo44158a((C26365c) new C41950c(emojiInfo));
        AppMethodBeat.m2505o(63301);
    }

    /* renamed from: eY */
    public static void m63710eY(long j) {
        AppMethodBeat.m2504i(63302);
        C4990ab.m7416i(C45304e.TAG, "addUploadTask: ".concat(String.valueOf(j)));
        C23505at dsZ = C23505at.dsZ();
        C25052j.m39375o(dsZ, "EmojiStorageMgr.getInstance()");
        EmojiInfo mU = dsZ.aUp().mo48587mU(j);
        C4990ab.m7416i(C45304e.TAG, "addUploadTask: " + (mU != null ? mU.mo20410Aq() : null));
        if (mU != null) {
            C37677d.m63711k(mU);
            AppMethodBeat.m2505o(63302);
            return;
        }
        AppMethodBeat.m2505o(63302);
    }
}
