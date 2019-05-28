package com.tencent.mm.emoji.loader.c;

import a.f.a.b;
import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.c;
import com.tencent.mm.plugin.emoji.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;

@l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J5\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2#\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R+\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/emoji/loader/fetcher/EmojiHttpFetcher;", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "fetch", "getEmojiData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "reportResult", "reportStart", "plugin-emojisdk_release"})
public final class f implements c {
    private final String TAG = "MicroMsg.EmojiLoader.EmojiHttpFetcher";
    private d exC;
    private b<? super Boolean, y> exD;

    public final void a(d dVar, b<? super Boolean, y> bVar) {
        com.tencent.mm.at.a.d.b sE;
        AppMethodBeat.i(63189);
        j.p(dVar, "fetcherConfig");
        this.exC = dVar;
        this.exD = bVar;
        d dVar2 = this.exC;
        if (dVar2 != null) {
            switch (dVar2.exR) {
                case 0:
                    c.hF(1);
                    break;
                case 1:
                    c.hF(6);
                    break;
                case 2:
                    c.hF(10);
                    break;
            }
        }
        dVar2 = this.exC;
        if (dVar2 != null) {
            sE = new a().sE(dVar2.url);
        } else {
            sE = null;
        }
        byte[] bArr = sE != null ? sE.data : null;
        if (bArr != null) {
            boolean z;
            if (bArr.length == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                ab.i(this.TAG, "download success " + dVar.exP.Aq() + ", " + dVar.path);
                new com.tencent.mm.vfs.b(dVar.path).dMC().mkdirs();
                e.q(dVar.path, bArr);
                bW(true);
                if (bVar != null) {
                    bVar.am(Boolean.TRUE);
                    AppMethodBeat.o(63189);
                    return;
                }
                AppMethodBeat.o(63189);
                return;
            }
        }
        ab.i(this.TAG, "download fail " + dVar.exP.Aq());
        bW(false);
        if (bVar != null) {
            bVar.am(Boolean.FALSE);
            AppMethodBeat.o(63189);
            return;
        }
        AppMethodBeat.o(63189);
    }

    private final void bW(boolean z) {
        AppMethodBeat.i(63190);
        d dVar = this.exC;
        if (dVar == null) {
            AppMethodBeat.o(63190);
        } else if (z) {
            c.hF(2);
            AppMethodBeat.o(63190);
        } else {
            c.hF(3);
            switch (dVar.exR) {
                case 0:
                    c.a(dVar.exP.Aq(), 4, 1, 1, dVar.exP.awa(), 1, dVar.exP.field_designerID);
                    AppMethodBeat.o(63190);
                    return;
                case 1:
                    c.a(dVar.exP.Aq(), 2, 1, 1, dVar.exP.awa(), 1, dVar.exP.field_designerID);
                    AppMethodBeat.o(63190);
                    return;
                case 2:
                    c.a(dVar.exP.Aq(), 4, 1, 1, dVar.exP.awa(), 1, dVar.exP.field_designerID);
                    break;
            }
            AppMethodBeat.o(63190);
        }
    }
}
