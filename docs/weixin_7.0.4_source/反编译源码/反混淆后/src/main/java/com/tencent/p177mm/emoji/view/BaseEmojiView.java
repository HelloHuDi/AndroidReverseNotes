package com.tencent.p177mm.emoji.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1677a;
import com.tencent.p177mm.plugin.emoji.PluginEmoji;
import com.tencent.p177mm.plugin.gif.C3266d;
import com.tencent.p177mm.plugin.gif.C34323b;
import com.tencent.p177mm.plugin.gif.C36775h;
import com.tencent.p177mm.plugin.gif.MMAnimateView;
import com.tencent.p177mm.plugin.gif.MMGIFException;
import com.tencent.p177mm.pluginsdk.p1336a.C44039e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.io.IOException;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, dWq = {"Lcom/tencent/mm/emoji/view/BaseEmojiView;", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "value", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "emojiInfo", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "isHevc", "", "setMMGIFFileByteArray", "", "bytes", "", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.view.BaseEmojiView */
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
        AppMethodBeat.m2504i(63304);
        if (C25052j.m39373j(this.exP, emojiInfo)) {
            AppMethodBeat.m2505o(63304);
            return;
        }
        this.exP = emojiInfo;
        if (emojiInfo != null) {
            String dve = emojiInfo.dve();
            if (emojiInfo.getGroup() == EmojiGroupInfo.yas || emojiInfo.getGroup() == EmojiInfo.yaA || emojiInfo.getGroup() == EmojiInfo.yaz) {
                setImageBitmap(emojiInfo.mo20411w(getContext(), 300));
                AppMethodBeat.m2505o(63304);
                return;
            } else if (emojiInfo.duS()) {
                mo46175b(EmojiInfo.m48210bJ(getContext(), emojiInfo.getName()), "");
                AppMethodBeat.m2505o(63304);
                return;
            } else if ((emojiInfo.duX() & EmojiInfo.zZi) == EmojiInfo.zZi) {
                C1677a M = C1720g.m3530M(PluginEmoji.class);
                C25052j.m39375o(M, "MMKernel.plugin(PluginEmoji::class.java)");
                setMMGIFFileByteArray(((PluginEmoji) M).getProvider().mo35656l(getEmojiInfo()));
                AppMethodBeat.m2505o(63304);
                return;
            } else {
                mo46176eE(dve, "");
            }
        }
        AppMethodBeat.m2505o(63304);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0042 A:{Catch:{ MMGIFException -> 0x0061, IOException -> 0x00c9, NullPointerException -> 0x00db }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setMMGIFFileByteArray(byte[] bArr) {
        AppMethodBeat.m2504i(63305);
        try {
            if (!C5046bo.m7540cb(bArr)) {
                C34323b c36775h;
                if (C5063r.m7679bU(bArr)) {
                    C1677a M = C1720g.m3530M(PluginEmoji.class);
                    C25052j.m39375o(M, "MMKernel.plugin(PluginEmoji::class.java)");
                    C44039e provider = ((PluginEmoji) M).getProvider();
                    C25052j.m39375o(provider, "MMKernel.plugin(PluginEmoji::class.java).provider");
                    if (provider.bjX()) {
                        c36775h = new C36775h(bArr);
                        this.eAi = true;
                        if (!c36775h.isRunning()) {
                            c36775h.reset();
                        }
                        setImageDrawable(c36775h);
                        AppMethodBeat.m2505o(63305);
                        return;
                    }
                }
                C4990ab.m7418v(this.TAG, "set with gif");
                c36775h = new C3266d(bArr);
                if (c36775h.isRunning()) {
                }
                setImageDrawable(c36775h);
                AppMethodBeat.m2505o(63305);
                return;
            }
        } catch (MMGIFException e) {
            MMAnimateView.m44846a(e);
            EmojiInfo emojiInfo;
            if (e.getErrorCode() == 103) {
                C4990ab.m7410d(this.TAG, "setMMGIFFileByteArray D_GIF_ERR_NOT_GIF_FILE");
                Bitmap bQ = C5056d.m7652bQ(bArr);
                if (bQ != null) {
                    bQ.setDensity(getEmojiDensity());
                    setImageBitmap(bQ);
                    AppMethodBeat.m2505o(63305);
                    return;
                }
                C4990ab.m7421w(this.TAG, "setMMGIFFileByteArray failed bitmap is null. bytes %s", String.valueOf(bArr));
                emojiInfo = getEmojiInfo();
                if (emojiInfo != null) {
                    emojiInfo.duQ();
                }
                init();
                AppMethodBeat.m2505o(63305);
                return;
            }
            C4990ab.m7413e(this.TAG, "setMMGIFFileByteArray failed. %s", e.toString());
            emojiInfo = getEmojiInfo();
            if (emojiInfo != null) {
                emojiInfo.duQ();
            }
        } catch (IOException e2) {
            C4990ab.m7413e(this.TAG, "setMMGIFFileByteArray failed. %s", e2.toString());
        } catch (NullPointerException e3) {
            C4990ab.m7413e(this.TAG, "setMMGIFFileByteArray failed. %s", e3.toString());
        }
        init();
        AppMethodBeat.m2505o(63305);
    }
}
