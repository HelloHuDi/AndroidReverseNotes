package com.tencent.mm.emoji.loader.c;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;

@l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J9\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062#\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bJ\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCoverFetcher;", "", "()V", "fetch", "Lcom/tencent/mm/emoji/loader/request/Request;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "readFromCache", "Companion", "plugin-emojisdk_release"})
public final class b {
    public static final a exG = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCoverFetcher$Companion;", "", "()V", "ThumbSize", "", "createThumb", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static boolean d(EmojiInfo emojiInfo) {
            AppMethodBeat.i(63176);
            j.p(emojiInfo, "emojiInfo");
            ab.i("MicroMsg.EmojiCoverFetcher", "createThumb: " + emojiInfo.Aq());
            com.tencent.mm.emoji.decode.b decoder = MMGIFJNIFactory.Companion.getDecoder(emojiInfo);
            if (MMGIFJNIFactory.Companion.isValid(decoder)) {
                decoder.Or();
                Bitmap Os = decoder.Os();
                decoder.destroy();
                try {
                    d.a(Os, 100, CompressFormat.PNG, emojiInfo.dvf(), false);
                    if (Os.getWidth() > 120 || Os.getHeight() > 120) {
                        Os = d.a(Os, 120, 120, false, true);
                        if (Os == null) {
                            AppMethodBeat.o(63176);
                            return false;
                        }
                    }
                    com.tencent.mm.emoji.loader.a.b bVar = com.tencent.mm.emoji.loader.a.b.exB;
                    com.tencent.mm.emoji.loader.a.b.c(emojiInfo.Aq(), Os);
                    AppMethodBeat.o(63176);
                    return true;
                } catch (IOException e) {
                    ab.printErrStackTrace("MicroMsg.EmojiCoverFetcher", e, "saveBitmapToImage failed", new Object[0]);
                    AppMethodBeat.o(63176);
                    return false;
                }
            }
            decoder.destroy();
            AppMethodBeat.o(63176);
            return false;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/emoji/loader/fetcher/EmojiCoverFetcher$fetch$1", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "onResult", "", "success", "", "plugin-emojisdk_release"})
    public static final class b implements com.tencent.mm.emoji.loader.d.h.a {
        final /* synthetic */ EmojiInfo exH;
        final /* synthetic */ a.f.a.b exI;

        public b(EmojiInfo emojiInfo, a.f.a.b bVar) {
            this.exH = emojiInfo;
            this.exI = bVar;
        }

        public final void bV(boolean z) {
            AppMethodBeat.i(63177);
            ab.i("MicroMsg.EmojiCoverFetcher", "onResult: " + this.exH.Aq() + ", " + z);
            a.f.a.b bVar;
            if (z) {
                a aVar = b.exG;
                if (a.d(this.exH)) {
                    bVar = this.exI;
                    if (bVar != null) {
                        bVar.am(Boolean.TRUE);
                        AppMethodBeat.o(63177);
                        return;
                    }
                    AppMethodBeat.o(63177);
                    return;
                }
                bVar = this.exI;
                if (bVar != null) {
                    bVar.am(Boolean.FALSE);
                    AppMethodBeat.o(63177);
                    return;
                }
                AppMethodBeat.o(63177);
                return;
            }
            bVar = this.exI;
            if (bVar != null) {
                bVar.am(Boolean.FALSE);
                AppMethodBeat.o(63177);
                return;
            }
            AppMethodBeat.o(63177);
        }
    }

    static {
        AppMethodBeat.i(63178);
        AppMethodBeat.o(63178);
    }

    public static final boolean d(EmojiInfo emojiInfo) {
        AppMethodBeat.i(63179);
        boolean d = a.d(emojiInfo);
        AppMethodBeat.o(63179);
        return d;
    }
}
