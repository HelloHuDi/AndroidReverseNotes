package com.tencent.mm.emoji.loader.c;

import a.f.a.b;
import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;

@l(dWo = {1, 1, 13}, dWp = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J5\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122#\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R+\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher;", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "cdnCallback", "com/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher$cdnCallback$1", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher$cdnCallback$1;", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "createCdnTask", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "fetch", "plugin-emojisdk_release"})
public final class a implements c {
    final String TAG = "MicroMsg.EmojiLoader.EmojiFetcher";
    private d exC;
    private b<? super Boolean, y> exD;
    private final a exE = new a(this);

    @l(dWo = {1, 1, 13}, dWp = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¨\u0006\u0014"}, dWq = {"com/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-emojisdk_release"})
    public static final class a implements com.tencent.mm.i.g.a {
        final /* synthetic */ a exF;

        a(a aVar) {
            this.exF = aVar;
        }

        public final int a(String str, int i, c cVar, d dVar, boolean z) {
            AppMethodBeat.i(63172);
            ab.d(this.exF.TAG, "callback " + i + ' ' + cVar + ' ' + dVar);
            b b;
            if (i == 0 && dVar != null && dVar.field_retCode == 0) {
                ab.i(this.exF.TAG, "download " + a.a(this.exF).exP.Aq() + " finish");
                b = this.exF.exD;
                if (b != null) {
                    b.am(Boolean.TRUE);
                }
                AppMethodBeat.o(63172);
            } else {
                if (!(i == 0 && (dVar == null || dVar.field_retCode == 0))) {
                    b = this.exF.exD;
                    if (b != null) {
                        b.am(Boolean.FALSE);
                    }
                }
                AppMethodBeat.o(63172);
            }
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] l(String str, byte[] bArr) {
            return new byte[0];
        }
    }

    public a() {
        AppMethodBeat.i(63174);
        AppMethodBeat.o(63174);
    }

    public static final /* synthetic */ d a(a aVar) {
        AppMethodBeat.i(63175);
        d dVar = aVar.exC;
        if (dVar == null) {
            j.avw("fetcherConfig");
        }
        AppMethodBeat.o(63175);
        return dVar;
    }

    public final void a(d dVar, b<? super Boolean, y> bVar) {
        AppMethodBeat.i(63173);
        j.p(dVar, "fetcherConfig");
        this.exC = dVar;
        this.exD = bVar;
        com.tencent.mm.al.b afx = f.afx();
        g gVar = new g();
        d dVar2 = this.exC;
        if (dVar2 == null) {
            j.avw("fetcherConfig");
        }
        gVar.field_authKey = dVar2.exQ;
        gVar.field_fileType = 19;
        StringBuilder append = new StringBuilder().append(com.tencent.mm.emoji.loader.c.c.a.Ox());
        d dVar3 = this.exC;
        if (dVar3 == null) {
            j.avw("fetcherConfig");
        }
        gVar.field_mediaId = append.append(dVar3.exP.Aq()).toString();
        dVar2 = this.exC;
        if (dVar2 == null) {
            j.avw("fetcherConfig");
        }
        gVar.field_fullpath = dVar2.path;
        dVar2 = this.exC;
        if (dVar2 == null) {
            j.avw("fetcherConfig");
        }
        gVar.egm = dVar2.url;
        gVar.egl = this.exE;
        afx.d(gVar);
        AppMethodBeat.o(63173);
    }
}
