package com.tencent.mm.emoji.view;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.b;
import com.tencent.mm.plugin.gif.d;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;

@l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, dWq = {"Lcom/tencent/mm/emoji/view/BaseEmojiView;", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "value", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "emojiInfo", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "isHevc", "", "setMMGIFFileByteArray", "", "bytes", "", "plugin-emojisdk_release"})
public class BaseEmojiView extends MMAnimateView {
    private final String TAG;
    public boolean eAi;
    private EmojiInfo exP;

    public BaseEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "MicroMsg.BaseEmojiView";
    }

    public BaseEmojiView(Context context) {
        this(context, null);
    }

    public BaseEmojiView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmojiInfo getEmojiInfo() {
        return this.exP;
    }

    public void setEmojiInfo(EmojiInfo emojiInfo) {
        AppMethodBeat.i(63304);
        if (j.j(this.exP, emojiInfo)) {
            AppMethodBeat.o(63304);
            return;
        }
        this.exP = emojiInfo;
        if (emojiInfo != null) {
            String dve = emojiInfo.dve();
            if (emojiInfo.getGroup() == EmojiGroupInfo.yas || emojiInfo.getGroup() == EmojiInfo.yaA || emojiInfo.getGroup() == EmojiInfo.yaz) {
                setImageBitmap(emojiInfo.w(getContext(), 300));
                AppMethodBeat.o(63304);
                return;
            } else if (emojiInfo.duS()) {
                b(EmojiInfo.bJ(getContext(), emojiInfo.getName()), "");
                AppMethodBeat.o(63304);
                return;
            } else if ((emojiInfo.duX() & EmojiInfo.zZi) == EmojiInfo.zZi) {
                a M = g.M(PluginEmoji.class);
                j.o(M, "MMKernel.plugin(PluginEmoji::class.java)");
                setMMGIFFileByteArray(((PluginEmoji) M).getProvider().l(getEmojiInfo()));
                AppMethodBeat.o(63304);
                return;
            } else {
                eE(dve, "");
            }
        }
        AppMethodBeat.o(63304);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0042 A:{Catch:{ MMGIFException -> 0x0061, IOException -> 0x00c9, NullPointerException -> 0x00db }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setMMGIFFileByteArray(byte[] bArr) {
        AppMethodBeat.i(63305);
        try {
            if (!bo.cb(bArr)) {
                b hVar;
                if (r.bU(bArr)) {
                    a M = g.M(PluginEmoji.class);
                    j.o(M, "MMKernel.plugin(PluginEmoji::class.java)");
                    e provider = ((PluginEmoji) M).getProvider();
                    j.o(provider, "MMKernel.plugin(PluginEmoji::class.java).provider");
                    if (provider.bjX()) {
                        hVar = new h(bArr);
                        this.eAi = true;
                        if (!hVar.isRunning()) {
                            hVar.reset();
                        }
                        setImageDrawable(hVar);
                        AppMethodBeat.o(63305);
                        return;
                    }
                }
                ab.v(this.TAG, "set with gif");
                hVar = new d(bArr);
                if (hVar.isRunning()) {
                }
                setImageDrawable(hVar);
                AppMethodBeat.o(63305);
                return;
            }
        } catch (MMGIFException e) {
            MMAnimateView.a(e);
            EmojiInfo emojiInfo;
            if (e.getErrorCode() == 103) {
                ab.d(this.TAG, "setMMGIFFileByteArray D_GIF_ERR_NOT_GIF_FILE");
                Bitmap bQ = com.tencent.mm.sdk.platformtools.d.bQ(bArr);
                if (bQ != null) {
                    bQ.setDensity(getEmojiDensity());
                    setImageBitmap(bQ);
                    AppMethodBeat.o(63305);
                    return;
                }
                ab.w(this.TAG, "setMMGIFFileByteArray failed bitmap is null. bytes %s", String.valueOf(bArr));
                emojiInfo = getEmojiInfo();
                if (emojiInfo != null) {
                    emojiInfo.duQ();
                }
                init();
                AppMethodBeat.o(63305);
                return;
            }
            ab.e(this.TAG, "setMMGIFFileByteArray failed. %s", e.toString());
            emojiInfo = getEmojiInfo();
            if (emojiInfo != null) {
                emojiInfo.duQ();
            }
        } catch (IOException e2) {
            ab.e(this.TAG, "setMMGIFFileByteArray failed. %s", e2.toString());
        } catch (NullPointerException e3) {
            ab.e(this.TAG, "setMMGIFFileByteArray failed. %s", e3.toString());
        }
        init();
        AppMethodBeat.o(63305);
    }
}
