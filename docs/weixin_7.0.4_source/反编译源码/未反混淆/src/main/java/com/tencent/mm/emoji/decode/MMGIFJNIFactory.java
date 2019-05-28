package com.tencent.mm.emoji.decode;

import a.f.b.g;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.InputStream;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/emoji/decode/MMGIFJNIFactory;", "", "()V", "Companion", "plugin-emojisdk_release"})
public final class MMGIFJNIFactory {
    public static final Companion Companion = new Companion();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004¨\u0006\n"}, dWq = {"Lcom/tencent/mm/emoji/decode/MMGIFJNIFactory$Companion;", "", "()V", "getDecoder", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isValid", "", "decoder", "plugin-emojisdk_release"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x00bb  */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final b getDecoder(EmojiInfo emojiInfo) {
            AppMethodBeat.i(63145);
            j.p(emojiInfo, "emojiInfo");
            b cVar;
            a M;
            byte[] l;
            try {
                if (emojiInfo.getGroup() == EmojiGroupInfo.yas || emojiInfo.getGroup() == EmojiInfo.yaA || emojiInfo.getGroup() == EmojiInfo.yaz) {
                    cVar = new c(emojiInfo.w(ah.getContext(), 300));
                    if (cVar != null) {
                        cVar = new a();
                        AppMethodBeat.o(63145);
                        return cVar;
                    }
                    AppMethodBeat.o(63145);
                    return cVar;
                }
                if (emojiInfo.duS()) {
                    InputStream bJ = EmojiInfo.bJ(ah.getContext(), emojiInfo.getName());
                    j.o(bJ, "EmojiInfo.getEmojiFile(M…ontext(), emojiInfo.name)");
                    cVar = new d(bJ);
                } else {
                    M = com.tencent.mm.kernel.g.M(PluginEmoji.class);
                    j.o(M, "MMKernel.plugin(PluginEmoji::class.java)");
                    l = ((PluginEmoji) M).getProvider().l(emojiInfo);
                    if (l != null) {
                        if (r.bU(l)) {
                            cVar = new e(l);
                        } else {
                            cVar = new d(l);
                        }
                    }
                    cVar = null;
                }
                if (cVar != null) {
                }
            } catch (MMGIFException e) {
                if (e.getErrorCode() == 103) {
                    M = com.tencent.mm.kernel.g.M(PluginEmoji.class);
                    j.o(M, "MMKernel.plugin(PluginEmoji::class.java)");
                    l = ((PluginEmoji) M).getProvider().l(emojiInfo);
                    if (l != null) {
                        cVar = new c(l);
                    }
                }
            }
        }

        public final boolean isValid(b bVar) {
            return (bVar == null || (bVar instanceof a)) ? false : true;
        }
    }

    static {
        AppMethodBeat.i(63146);
        AppMethodBeat.o(63146);
    }
}
