package com.tencent.p177mm.emoji.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.loader.C37682a;
import com.tencent.p177mm.emoji.loader.p1190d.C18207h.C18208a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0002&'B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020\u001fH\u0014J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001fH\u0016J\u000e\u0010%\u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\nR(\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006("}, dWq = {"Lcom/tencent/mm/emoji/view/EmojiStatusView;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "emojiInfo", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "status", "getStatus", "()I", "setStatus", "(I)V", "statusListener", "Lcom/tencent/mm/emoji/view/EmojiStatusView$StatusListener;", "getStatusListener", "()Lcom/tencent/mm/emoji/view/EmojiStatusView$StatusListener;", "setStatusListener", "(Lcom/tencent/mm/emoji/view/EmojiStatusView$StatusListener;)V", "destroy", "", "onDetachedFromWindow", "onResult", "success", "", "reload", "setStatusNotify", "Companion", "StatusListener", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.view.EmojiStatusView */
public class EmojiStatusView extends BaseEmojiView implements C18208a {
    public static final C37686a eAo = new C37686a();
    private C37687b eAn;
    private EmojiInfo exP;
    private int status;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/emoji/view/EmojiStatusView$Companion;", "", "()V", "StatusFail", "", "StatusLoading", "StatusSuccess", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.view.EmojiStatusView$a */
    public static final class C37686a {
        private C37686a() {
        }

        public /* synthetic */ C37686a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/emoji/view/EmojiStatusView$StatusListener;", "", "onStatus", "", "status", "", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.view.EmojiStatusView$b */
    public interface C37687b {
        /* renamed from: jm */
        void mo7155jm(int i);
    }

    static {
        AppMethodBeat.m2504i(63316);
        AppMethodBeat.m2505o(63316);
    }

    public EmojiStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public EmojiStatusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final C37687b getStatusListener() {
        return this.eAn;
    }

    public final void setStatusListener(C37687b c37687b) {
        this.eAn = c37687b;
    }

    public EmojiInfo getEmojiInfo() {
        return this.exP;
    }

    public void setEmojiInfo(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(63311);
        this.exP = emojiInfo;
        reload();
        AppMethodBeat.m2505o(63311);
    }

    public void reload() {
        AppMethodBeat.m2504i(63312);
        EmojiInfo emojiInfo = getEmojiInfo();
        C37682a c37682a;
        if (emojiInfo != null) {
            C4990ab.m7416i("MicroMsg.EmojiStatusView", "reload: " + emojiInfo.mo20410Aq());
            setStatusNotify(0);
            c37682a = C37682a.exs;
            C37682a.m63723a(emojiInfo, (BaseEmojiView) this, (C18208a) this);
            AppMethodBeat.m2505o(63312);
            return;
        }
        C4990ab.m7416i("MicroMsg.EmojiStatusView", "reload: emojiInfo is null");
        c37682a = C37682a.exs;
        C37682a.m63728cf(this);
        AppMethodBeat.m2505o(63312);
    }

    public final void setStatusNotify(int i) {
        AppMethodBeat.m2504i(63313);
        this.status = i;
        C37687b c37687b = this.eAn;
        if (c37687b != null) {
            c37687b.mo7155jm(i);
            AppMethodBeat.m2505o(63313);
            return;
        }
        AppMethodBeat.m2505o(63313);
    }

    /* renamed from: bV */
    public final void mo33675bV(boolean z) {
        AppMethodBeat.m2504i(63314);
        setStatusNotify(z ? 1 : -1);
        AppMethodBeat.m2505o(63314);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(63315);
        C4990ab.m7416i("MicroMsg.EmojiStatusView", "destroy: ".concat(String.valueOf(this)));
        C37682a c37682a = C37682a.exs;
        C37682a.m63728cf(this);
        this.eAn = null;
        super.onDetachedFromWindow();
        AppMethodBeat.m2505o(63315);
    }
}
