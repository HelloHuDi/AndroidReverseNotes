package com.tencent.p177mm.emoji.loader.p848c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.decode.C26076b;
import com.tencent.p177mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.p177mm.emoji.loader.p1190d.C18207h.C18208a;
import com.tencent.p177mm.emoji.loader.p1531a.C45305b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.io.IOException;
import p000a.C0220l;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J9\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062#\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bJ\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCoverFetcher;", "", "()V", "fetch", "Lcom/tencent/mm/emoji/loader/request/Request;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "readFromCache", "Companion", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.loader.c.b */
public final class C18198b {
    public static final C18197a exG = new C18197a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCoverFetcher$Companion;", "", "()V", "ThumbSize", "", "createThumb", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.loader.c.b$a */
    public static final class C18197a {
        private C18197a() {
        }

        public /* synthetic */ C18197a(byte b) {
            this();
        }

        /* renamed from: d */
        public static boolean m28640d(EmojiInfo emojiInfo) {
            AppMethodBeat.m2504i(63176);
            C25052j.m39376p(emojiInfo, "emojiInfo");
            C4990ab.m7416i("MicroMsg.EmojiCoverFetcher", "createThumb: " + emojiInfo.mo20410Aq());
            C26076b decoder = MMGIFJNIFactory.Companion.getDecoder(emojiInfo);
            if (MMGIFJNIFactory.Companion.isValid(decoder)) {
                decoder.mo33669Or();
                Bitmap Os = decoder.mo33670Os();
                decoder.destroy();
                try {
                    C5056d.m7625a(Os, 100, CompressFormat.PNG, emojiInfo.dvf(), false);
                    if (Os.getWidth() > 120 || Os.getHeight() > 120) {
                        Os = C5056d.m7615a(Os, 120, 120, false, true);
                        if (Os == null) {
                            AppMethodBeat.m2505o(63176);
                            return false;
                        }
                    }
                    C45305b c45305b = C45305b.exB;
                    C45305b.m83552c(emojiInfo.mo20410Aq(), Os);
                    AppMethodBeat.m2505o(63176);
                    return true;
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.EmojiCoverFetcher", e, "saveBitmapToImage failed", new Object[0]);
                    AppMethodBeat.m2505o(63176);
                    return false;
                }
            }
            decoder.destroy();
            AppMethodBeat.m2505o(63176);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/emoji/loader/fetcher/EmojiCoverFetcher$fetch$1", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "onResult", "", "success", "", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.loader.c.b$b */
    public static final class C18199b implements C18208a {
        final /* synthetic */ EmojiInfo exH;
        final /* synthetic */ C17126b exI;

        public C18199b(EmojiInfo emojiInfo, C17126b c17126b) {
            this.exH = emojiInfo;
            this.exI = c17126b;
        }

        /* renamed from: bV */
        public final void mo33675bV(boolean z) {
            AppMethodBeat.m2504i(63177);
            C4990ab.m7416i("MicroMsg.EmojiCoverFetcher", "onResult: " + this.exH.mo20410Aq() + ", " + z);
            C17126b c17126b;
            if (z) {
                C18197a c18197a = C18198b.exG;
                if (C18197a.m28640d(this.exH)) {
                    c17126b = this.exI;
                    if (c17126b != null) {
                        c17126b.mo50am(Boolean.TRUE);
                        AppMethodBeat.m2505o(63177);
                        return;
                    }
                    AppMethodBeat.m2505o(63177);
                    return;
                }
                c17126b = this.exI;
                if (c17126b != null) {
                    c17126b.mo50am(Boolean.FALSE);
                    AppMethodBeat.m2505o(63177);
                    return;
                }
                AppMethodBeat.m2505o(63177);
                return;
            }
            c17126b = this.exI;
            if (c17126b != null) {
                c17126b.mo50am(Boolean.FALSE);
                AppMethodBeat.m2505o(63177);
                return;
            }
            AppMethodBeat.m2505o(63177);
        }
    }

    static {
        AppMethodBeat.m2504i(63178);
        AppMethodBeat.m2505o(63178);
    }

    /* renamed from: d */
    public static final boolean m28641d(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(63179);
        boolean d = C18197a.m28640d(emojiInfo);
        AppMethodBeat.m2505o(63179);
        return d;
    }
}
