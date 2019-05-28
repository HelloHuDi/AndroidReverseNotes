package com.tencent.mm.emoji.loader.d;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;

@l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/emoji/loader/request/EmojiViewRequest;", "Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "callback", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/view/BaseEmojiView;Lcom/tencent/mm/emoji/loader/request/Request$Callback;)V", "getCallback", "()Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "setCallback", "(Lcom/tencent/mm/emoji/loader/request/Request$Callback;)V", "cancel", "", "onLoad", "success", "", "start", "plugin-emojisdk_release"})
public class e extends i<BaseEmojiView> {
    com.tencent.mm.emoji.loader.d.h.a eyf;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class a extends k implements a.f.a.a<y> {
        final /* synthetic */ Drawable exZ;
        final /* synthetic */ BaseEmojiView eya;
        final /* synthetic */ boolean eyb;
        final /* synthetic */ e eyg;

        a(e eVar, boolean z, Drawable drawable, BaseEmojiView baseEmojiView) {
            this.eyg = eVar;
            this.eyb = z;
            this.exZ = drawable;
            this.eya = baseEmojiView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(63210);
            BaseEmojiView baseEmojiView;
            com.tencent.mm.emoji.loader.d.h.a aVar;
            if (!this.eyb || this.exZ == null) {
                baseEmojiView = this.eya;
                if (baseEmojiView != null) {
                    baseEmojiView.init();
                }
                aVar = this.eyg.eyf;
                if (aVar != null) {
                    aVar.bV(false);
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
                aVar = this.eyg.eyf;
                if (aVar != null) {
                    aVar.bV(true);
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(63210);
            return yVar;
        }
    }

    public e(EmojiInfo emojiInfo, BaseEmojiView baseEmojiView, com.tencent.mm.emoji.loader.d.h.a aVar) {
        j.p(emojiInfo, "emojiInfo");
        j.p(baseEmojiView, "view");
        super(emojiInfo, baseEmojiView);
        AppMethodBeat.i(63214);
        this.eyf = aVar;
        AppMethodBeat.o(63214);
    }

    public void bX(boolean z) {
        Object obj;
        BaseEmojiView baseEmojiView;
        Drawable drawable = null;
        AppMethodBeat.i(63212);
        String Ow = f.TAG;
        StringBuilder append = new StringBuilder("onLoad ").append(this).append(' ');
        WeakReference weakReference = this.eyi;
        if (weakReference != null) {
            obj = (BaseEmojiView) weakReference.get();
        } else {
            obj = null;
        }
        ab.i(Ow, append.append(obj).append(' ').append(z).toString());
        weakReference = this.eyi;
        if (weakReference != null) {
            baseEmojiView = (BaseEmojiView) weakReference.get();
        } else {
            baseEmojiView = null;
        }
        if (z) {
            drawable = new com.tencent.mm.emoji.loader.b.a().a(this.exP, null);
        }
        b.a(new a(this, z, drawable, baseEmojiView));
        AppMethodBeat.o(63212);
    }

    public final void cancel() {
        AppMethodBeat.i(63213);
        super.cancel();
        this.eyf = null;
        AppMethodBeat.o(63213);
    }

    public void start() {
        AppMethodBeat.i(63211);
        if (this.exP.duP()) {
            bX(true);
            AppMethodBeat.o(63211);
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
        AppMethodBeat.o(63211);
    }
}
