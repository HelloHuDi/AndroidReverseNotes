package com.tencent.p177mm.emoji.loader.p1190d;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.loader.p1190d.C18207h.C18208a;
import com.tencent.p177mm.emoji.loader.p1599b.C41954a;
import com.tencent.p177mm.emoji.view.BaseEmojiView;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/emoji/loader/request/EmojiViewRequest;", "Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "callback", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/view/BaseEmojiView;Lcom/tencent/mm/emoji/loader/request/Request$Callback;)V", "getCallback", "()Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "setCallback", "(Lcom/tencent/mm/emoji/loader/request/Request$Callback;)V", "cancel", "", "onLoad", "success", "", "start", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.loader.d.e */
public class C37684e extends C26080i<BaseEmojiView> {
    C18208a eyf;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.emoji.loader.d.e$a */
    static final class C31557a extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ Drawable exZ;
        final /* synthetic */ BaseEmojiView eya;
        final /* synthetic */ boolean eyb;
        final /* synthetic */ C37684e eyg;

        C31557a(C37684e c37684e, boolean z, Drawable drawable, BaseEmojiView baseEmojiView) {
            this.eyg = c37684e;
            this.eyb = z;
            this.exZ = drawable;
            this.eya = baseEmojiView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(63210);
            BaseEmojiView baseEmojiView;
            C18208a c18208a;
            if (!this.eyb || this.exZ == null) {
                baseEmojiView = this.eya;
                if (baseEmojiView != null) {
                    baseEmojiView.init();
                }
                c18208a = this.eyg.eyf;
                if (c18208a != null) {
                    c18208a.mo33675bV(false);
                }
            } else {
                baseEmojiView = this.eya;
                if (baseEmojiView != null) {
                    baseEmojiView.setImageDrawable(this.exZ);
                }
                baseEmojiView = this.eya;
                if (baseEmojiView != null) {
                    baseEmojiView.resume();
                }
                c18208a = this.eyg.eyf;
                if (c18208a != null) {
                    c18208a.mo33675bV(true);
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(63210);
            return c37091y;
        }
    }

    public C37684e(EmojiInfo emojiInfo, BaseEmojiView baseEmojiView, C18208a c18208a) {
        C25052j.m39376p(emojiInfo, "emojiInfo");
        C25052j.m39376p(baseEmojiView, "view");
        super(emojiInfo, baseEmojiView);
        AppMethodBeat.m2504i(63214);
        this.eyf = c18208a;
        AppMethodBeat.m2505o(63214);
    }

    /* renamed from: bX */
    public void mo33677bX(boolean z) {
        Object obj;
        BaseEmojiView baseEmojiView;
        Drawable drawable = null;
        AppMethodBeat.m2504i(63212);
        String Ow = C41958f.TAG;
        StringBuilder append = new StringBuilder("onLoad ").append(this).append(' ');
        WeakReference weakReference = this.eyi;
        if (weakReference != null) {
            obj = (BaseEmojiView) weakReference.get();
        } else {
            obj = null;
        }
        C4990ab.m7416i(Ow, append.append(obj).append(' ').append(z).toString());
        weakReference = this.eyi;
        if (weakReference != null) {
            baseEmojiView = (BaseEmojiView) weakReference.get();
        } else {
            baseEmojiView = null;
        }
        if (z) {
            drawable = new C41954a().mo67590a(this.exP, null);
        }
        C8902b.m16042a(new C31557a(this, z, drawable, baseEmojiView));
        AppMethodBeat.m2505o(63212);
    }

    public final void cancel() {
        AppMethodBeat.m2504i(63213);
        super.cancel();
        this.eyf = null;
        AppMethodBeat.m2505o(63213);
    }

    public void start() {
        AppMethodBeat.m2504i(63211);
        if (this.exP.duP()) {
            mo33677bX(true);
            AppMethodBeat.m2505o(63211);
            return;
        }
        WeakReference weakReference = this.eyi;
        if (weakReference != null) {
            BaseEmojiView baseEmojiView = (BaseEmojiView) weakReference.get();
            if (baseEmojiView != null) {
                baseEmojiView.init();
            }
        }
        reload();
        AppMethodBeat.m2505o(63211);
    }
}
