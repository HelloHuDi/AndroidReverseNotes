package com.tencent.p177mm.emoji.loader.p848c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2%\b\u0002\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\fR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/emoji/loader/fetcher/FetcherFactory;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "fetch", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.loader.c.g */
public final class C37683g {
    private static final String TAG = TAG;
    public static final C37683g exW = new C37683g();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "success", "", "config", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "invoke"})
    /* renamed from: com.tencent.mm.emoji.loader.c.g$a */
    static final class C9275a extends C25053k implements C31591m<Boolean, C26078d, C37091y> {
        final /* synthetic */ EmojiInfo exH;
        final /* synthetic */ C17126b exI;

        C9275a(EmojiInfo emojiInfo, C17126b c17126b) {
            this.exH = emojiInfo;
            this.exI = c17126b;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(63191);
            C26078d c26078d = (C26078d) obj2;
            C37683g c37683g;
            if (!((Boolean) obj).booleanValue() || c26078d == null) {
                c37683g = C37683g.exW;
                C4990ab.m7416i(C37683g.getTAG(), "fetch: get config fail " + this.exH.mo20410Aq());
                C17126b c17126b = this.exI;
                if (c17126b != null) {
                    c17126b.mo50am(Boolean.FALSE);
                }
            } else {
                Object obj3;
                C18200c c26077a;
                c37683g = C37683g.exW;
                C4990ab.m7416i(C37683g.getTAG(), c26078d.exR + ' ' + c26078d.exP.mo20410Aq());
                if (c26078d.exR == 3) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (obj3 != null) {
                    c26077a = new C26077a();
                } else {
                    c26077a = new C45306f();
                }
                c26077a.mo33676a(c26078d, this.exI);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(63191);
            return c37091y;
        }
    }

    static {
        AppMethodBeat.m2504i(63193);
        AppMethodBeat.m2505o(63193);
    }

    private C37683g() {
    }

    public static String getTAG() {
        return TAG;
    }

    /* renamed from: a */
    public static void m63731a(EmojiInfo emojiInfo, C17126b<? super Boolean, C37091y> c17126b) {
        AppMethodBeat.m2504i(63192);
        C25052j.m39376p(emojiInfo, "emojiInfo");
        C41955e c41955e = new C41955e(emojiInfo, new C9275a(emojiInfo, c17126b));
        AppMethodBeat.m2505o(63192);
    }
}
