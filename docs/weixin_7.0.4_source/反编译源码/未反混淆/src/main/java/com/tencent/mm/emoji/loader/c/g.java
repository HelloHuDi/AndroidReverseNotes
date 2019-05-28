package com.tencent.mm.emoji.loader.c;

import a.f.a.b;
import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2%\b\u0002\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\fR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/emoji/loader/fetcher/FetcherFactory;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "fetch", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "plugin-emojisdk_release"})
public final class g {
    private static final String TAG = TAG;
    public static final g exW = new g();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "success", "", "config", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "invoke"})
    static final class a extends k implements m<Boolean, d, y> {
        final /* synthetic */ EmojiInfo exH;
        final /* synthetic */ b exI;

        a(EmojiInfo emojiInfo, b bVar) {
            this.exH = emojiInfo;
            this.exI = bVar;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(63191);
            d dVar = (d) obj2;
            g gVar;
            if (!((Boolean) obj).booleanValue() || dVar == null) {
                gVar = g.exW;
                ab.i(g.getTAG(), "fetch: get config fail " + this.exH.Aq());
                b bVar = this.exI;
                if (bVar != null) {
                    bVar.am(Boolean.FALSE);
                }
            } else {
                Object obj3;
                c aVar;
                gVar = g.exW;
                ab.i(g.getTAG(), dVar.exR + ' ' + dVar.exP.Aq());
                if (dVar.exR == 3) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (obj3 != null) {
                    aVar = new a();
                } else {
                    aVar = new f();
                }
                aVar.a(dVar, this.exI);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(63191);
            return yVar;
        }
    }

    static {
        AppMethodBeat.i(63193);
        AppMethodBeat.o(63193);
    }

    private g() {
    }

    public static String getTAG() {
        return TAG;
    }

    public static void a(EmojiInfo emojiInfo, b<? super Boolean, y> bVar) {
        AppMethodBeat.i(63192);
        j.p(emojiInfo, "emojiInfo");
        e eVar = new e(emojiInfo, new a(emojiInfo, bVar));
        AppMethodBeat.o(63192);
    }
}
