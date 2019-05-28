package com.tencent.p177mm.emoji.loader.p848c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.loader.p848c.C18200c.C18201a;
import com.tencent.p177mm.p187al.C31259b;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.ByteArrayOutputStream;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J5\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122#\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R+\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher;", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "cdnCallback", "com/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher$cdnCallback$1", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher$cdnCallback$1;", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "createCdnTask", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "fetch", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.loader.c.a */
public final class C26077a implements C18200c {
    final String TAG = "MicroMsg.EmojiLoader.EmojiFetcher";
    private C26078d exC;
    private C17126b<? super Boolean, C37091y> exD;
    private final C9273a exE = new C9273a(this);

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¨\u0006\u0014"}, dWq = {"com/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.loader.c.a$a */
    public static final class C9273a implements C1628a {
        final /* synthetic */ C26077a exF;

        C9273a(C26077a c26077a) {
            this.exF = c26077a;
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
            AppMethodBeat.m2504i(63172);
            C4990ab.m7410d(this.exF.TAG, "callback " + i + ' ' + c18496c + ' ' + c9545d);
            C17126b b;
            if (i == 0 && c9545d != null && c9545d.field_retCode == 0) {
                C4990ab.m7416i(this.exF.TAG, "download " + C26077a.m41640a(this.exF).exP.mo20410Aq() + " finish");
                b = this.exF.exD;
                if (b != null) {
                    b.mo50am(Boolean.TRUE);
                }
                AppMethodBeat.m2505o(63172);
            } else {
                if (!(i == 0 && (c9545d == null || c9545d.field_retCode == 0))) {
                    b = this.exF.exD;
                    if (b != null) {
                        b.mo50am(Boolean.FALSE);
                    }
                }
                AppMethodBeat.m2505o(63172);
            }
            return 0;
        }

        /* renamed from: a */
        public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        /* renamed from: l */
        public final byte[] mo5084l(String str, byte[] bArr) {
            return new byte[0];
        }
    }

    public C26077a() {
        AppMethodBeat.m2504i(63174);
        AppMethodBeat.m2505o(63174);
    }

    /* renamed from: a */
    public static final /* synthetic */ C26078d m41640a(C26077a c26077a) {
        AppMethodBeat.m2504i(63175);
        C26078d c26078d = c26077a.exC;
        if (c26078d == null) {
            C25052j.avw("fetcherConfig");
        }
        AppMethodBeat.m2505o(63175);
        return c26078d;
    }

    /* renamed from: a */
    public final void mo33676a(C26078d c26078d, C17126b<? super Boolean, C37091y> c17126b) {
        AppMethodBeat.m2504i(63173);
        C25052j.m39376p(c26078d, "fetcherConfig");
        this.exC = c26078d;
        this.exD = c17126b;
        C31259b afx = C37461f.afx();
        C42130g c42130g = new C42130g();
        C26078d c26078d2 = this.exC;
        if (c26078d2 == null) {
            C25052j.avw("fetcherConfig");
        }
        c42130g.field_authKey = c26078d2.exQ;
        c42130g.field_fileType = 19;
        StringBuilder append = new StringBuilder().append(C18201a.m28644Ox());
        C26078d c26078d3 = this.exC;
        if (c26078d3 == null) {
            C25052j.avw("fetcherConfig");
        }
        c42130g.field_mediaId = append.append(c26078d3.exP.mo20410Aq()).toString();
        c26078d2 = this.exC;
        if (c26078d2 == null) {
            C25052j.avw("fetcherConfig");
        }
        c42130g.field_fullpath = c26078d2.path;
        c26078d2 = this.exC;
        if (c26078d2 == null) {
            C25052j.avw("fetcherConfig");
        }
        c42130g.egm = c26078d2.url;
        c42130g.egl = this.exE;
        afx.mo51224d(c42130g);
        AppMethodBeat.m2505o(63173);
    }
}
