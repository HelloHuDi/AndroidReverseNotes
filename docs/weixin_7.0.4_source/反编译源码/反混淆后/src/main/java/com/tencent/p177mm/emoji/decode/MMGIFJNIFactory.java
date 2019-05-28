package com.tencent.p177mm.emoji.decode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1677a;
import com.tencent.p177mm.plugin.emoji.PluginEmoji;
import com.tencent.p177mm.plugin.gif.MMGIFException;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.io.InputStream;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C41379g;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/emoji/decode/MMGIFJNIFactory;", "", "()V", "Companion", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.decode.MMGIFJNIFactory */
public final class MMGIFJNIFactory {
    public static final Companion Companion = new Companion();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004¨\u0006\n"}, dWq = {"Lcom/tencent/mm/emoji/decode/MMGIFJNIFactory$Companion;", "", "()V", "getDecoder", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isValid", "", "decoder", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.decode.MMGIFJNIFactory$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C41379g c41379g) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x00bb  */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final C26076b getDecoder(EmojiInfo emojiInfo) {
            AppMethodBeat.m2504i(63145);
            C25052j.m39376p(emojiInfo, "emojiInfo");
            C26076b c18196c;
            C1677a M;
            byte[] l;
            try {
                if (emojiInfo.getGroup() == EmojiGroupInfo.yas || emojiInfo.getGroup() == EmojiInfo.yaA || emojiInfo.getGroup() == EmojiInfo.yaz) {
                    c18196c = new C18196c(emojiInfo.mo20411w(C4996ah.getContext(), 300));
                    if (c18196c != null) {
                        c18196c = new C18195a();
                        AppMethodBeat.m2505o(63145);
                        return c18196c;
                    }
                    AppMethodBeat.m2505o(63145);
                    return c18196c;
                }
                if (emojiInfo.duS()) {
                    InputStream bJ = EmojiInfo.m48210bJ(C4996ah.getContext(), emojiInfo.getName());
                    C25052j.m39375o(bJ, "EmojiInfo.getEmojiFile(M…ontext(), emojiInfo.name)");
                    c18196c = new C41951d(bJ);
                } else {
                    M = C1720g.m3530M(PluginEmoji.class);
                    C25052j.m39375o(M, "MMKernel.plugin(PluginEmoji::class.java)");
                    l = ((PluginEmoji) M).getProvider().mo35656l(emojiInfo);
                    if (l != null) {
                        if (C5063r.m7679bU(l)) {
                            c18196c = new C41952e(l);
                        } else {
                            c18196c = new C41951d(l);
                        }
                    }
                    c18196c = null;
                }
                if (c18196c != null) {
                }
            } catch (MMGIFException e) {
                if (e.getErrorCode() == 103) {
                    M = C1720g.m3530M(PluginEmoji.class);
                    C25052j.m39375o(M, "MMKernel.plugin(PluginEmoji::class.java)");
                    l = ((PluginEmoji) M).getProvider().mo35656l(emojiInfo);
                    if (l != null) {
                        c18196c = new C18196c(l);
                    }
                }
            }
        }

        public final boolean isValid(C26076b c26076b) {
            return (c26076b == null || (c26076b instanceof C18195a)) ? false : true;
        }
    }

    static {
        AppMethodBeat.m2504i(63146);
        AppMethodBeat.m2505o(63146);
    }
}
