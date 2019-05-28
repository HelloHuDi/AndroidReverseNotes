package com.tencent.p177mm.emoji.loader.p848c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.p191a.p1527d.C37477b;
import com.tencent.p177mm.plugin.emoji.C38876c;
import com.tencent.p177mm.plugin.emoji.p382d.C20358a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J5\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2#\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R+\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/emoji/loader/fetcher/EmojiHttpFetcher;", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "fetch", "getEmojiData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "reportResult", "reportStart", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.loader.c.f */
public final class C45306f implements C18200c {
    private final String TAG = "MicroMsg.EmojiLoader.EmojiHttpFetcher";
    private C26078d exC;
    private C17126b<? super Boolean, C37091y> exD;

    /* renamed from: a */
    public final void mo33676a(C26078d c26078d, C17126b<? super Boolean, C37091y> c17126b) {
        C37477b sE;
        AppMethodBeat.m2504i(63189);
        C25052j.m39376p(c26078d, "fetcherConfig");
        this.exC = c26078d;
        this.exD = c17126b;
        C26078d c26078d2 = this.exC;
        if (c26078d2 != null) {
            switch (c26078d2.exR) {
                case 0:
                    C38876c.m65942hF(1);
                    break;
                case 1:
                    C38876c.m65942hF(6);
                    break;
                case 2:
                    C38876c.m65942hF(10);
                    break;
            }
        }
        c26078d2 = this.exC;
        if (c26078d2 != null) {
            sE = new C20358a().mo33454sE(c26078d2.url);
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
                C4990ab.m7416i(this.TAG, "download success " + c26078d.exP.mo20410Aq() + ", " + c26078d.path);
                new C5728b(c26078d.path).dMC().mkdirs();
                C5730e.m8640q(c26078d.path, bArr);
                m83554bW(true);
                if (c17126b != null) {
                    c17126b.mo50am(Boolean.TRUE);
                    AppMethodBeat.m2505o(63189);
                    return;
                }
                AppMethodBeat.m2505o(63189);
                return;
            }
        }
        C4990ab.m7416i(this.TAG, "download fail " + c26078d.exP.mo20410Aq());
        m83554bW(false);
        if (c17126b != null) {
            c17126b.mo50am(Boolean.FALSE);
            AppMethodBeat.m2505o(63189);
            return;
        }
        AppMethodBeat.m2505o(63189);
    }

    /* renamed from: bW */
    private final void m83554bW(boolean z) {
        AppMethodBeat.m2504i(63190);
        C26078d c26078d = this.exC;
        if (c26078d == null) {
            AppMethodBeat.m2505o(63190);
        } else if (z) {
            C38876c.m65942hF(2);
            AppMethodBeat.m2505o(63190);
        } else {
            C38876c.m65942hF(3);
            switch (c26078d.exR) {
                case 0:
                    C38876c.m65941a(c26078d.exP.mo20410Aq(), 4, 1, 1, c26078d.exP.awa(), 1, c26078d.exP.field_designerID);
                    AppMethodBeat.m2505o(63190);
                    return;
                case 1:
                    C38876c.m65941a(c26078d.exP.mo20410Aq(), 2, 1, 1, c26078d.exP.awa(), 1, c26078d.exP.field_designerID);
                    AppMethodBeat.m2505o(63190);
                    return;
                case 2:
                    C38876c.m65941a(c26078d.exP.mo20410Aq(), 4, 1, 1, c26078d.exP.awa(), 1, c26078d.exP.field_designerID);
                    break;
            }
            AppMethodBeat.m2505o(63190);
        }
    }
}
