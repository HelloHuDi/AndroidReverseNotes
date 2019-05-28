package com.tencent.mm.emoji.loader.d;

import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;

@l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/emoji/loader/request/ChatEmojiViewRequest;", "Lcom/tencent/mm/emoji/loader/request/EmojiViewRequest;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "Lcom/tencent/mm/pluginsdk/ui/emoji/ChattingEmojiView;", "cacheKey", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/pluginsdk/ui/emoji/ChattingEmojiView;Ljava/lang/String;)V", "firstLoad", "", "onLoad", "", "success", "onSize", "width", "", "height", "start", "plugin-emojisdk_release"})
public final class a extends e {
    private final String cacheKey;
    private boolean exX = true;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class a extends k implements a.f.a.a<y> {
        final /* synthetic */ a exY;
        final /* synthetic */ Drawable exZ;
        final /* synthetic */ BaseEmojiView eya;
        final /* synthetic */ boolean eyb;

        a(a aVar, Drawable drawable, BaseEmojiView baseEmojiView, boolean z) {
            this.exY = aVar;
            this.exZ = drawable;
            this.eya = baseEmojiView;
            this.eyb = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(63197);
            com.tencent.mm.emoji.loader.a.a aVar = com.tencent.mm.emoji.loader.a.a.exz;
            com.tencent.mm.emoji.loader.a.a.b(this.exY.cacheKey, this.exZ);
            BaseEmojiView baseEmojiView = this.eya;
            if (baseEmojiView != null) {
                baseEmojiView.setImageDrawable(this.exZ);
            }
            baseEmojiView = this.eya;
            if (baseEmojiView != null) {
                baseEmojiView.resume();
            }
            com.tencent.mm.emoji.loader.d.h.a aVar2 = this.exY.eyf;
            if (aVar2 != null) {
                boolean z;
                if (!this.eyb || this.exZ == null) {
                    z = false;
                } else {
                    z = true;
                }
                aVar2.bV(z);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(63197);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "width", "", "height", "invoke"})
    static final class b extends k implements m<Integer, Integer, y> {
        final /* synthetic */ a exY;

        b(a aVar) {
            this.exY = aVar;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(63198);
            a.a(this.exY, ((Number) obj).intValue(), ((Number) obj2).intValue());
            y yVar = y.AUy;
            AppMethodBeat.o(63198);
            return yVar;
        }
    }

    public a(EmojiInfo emojiInfo, ChattingEmojiView chattingEmojiView, String str) {
        j.p(emojiInfo, "emojiInfo");
        j.p(chattingEmojiView, "view");
        j.p(str, "cacheKey");
        super(emojiInfo, chattingEmojiView, chattingEmojiView);
        AppMethodBeat.i(63201);
        this.cacheKey = str;
        AppMethodBeat.o(63201);
    }

    /* JADX WARNING: Missing block: B:11:0x005d, code skipped:
            if (a.f.b.j.j(r3, r0) != false) goto L_0x005f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void start() {
        AppMethodBeat.i(63199);
        com.tencent.mm.emoji.loader.a.a aVar = com.tencent.mm.emoji.loader.a.a.exz;
        Drawable kQ = com.tencent.mm.emoji.loader.a.a.kQ(this.cacheKey);
        String str = "MicroMsg.ChatEmojiViewRequest";
        StringBuilder append = new StringBuilder("start: ").append(kQ).append(' ');
        WeakReference weakReference = this.eyi;
        ab.i(str, append.append(weakReference != null ? (BaseEmojiView) weakReference.get() : null).append(' ').append(this.cacheKey).toString());
        if (kQ != null) {
            BaseEmojiView baseEmojiView;
            if (kQ.getCallback() != null) {
                Callback callback = kQ.getCallback();
                weakReference = this.eyi;
                Object obj;
                if (weakReference != null) {
                    obj = (BaseEmojiView) weakReference.get();
                } else {
                    obj = null;
                }
            }
            weakReference = this.eyi;
            if (weakReference != null) {
                baseEmojiView = (BaseEmojiView) weakReference.get();
                if (baseEmojiView != null) {
                    baseEmojiView.setImageDrawable(kQ);
                }
            }
            weakReference = this.eyi;
            if (weakReference != null) {
                baseEmojiView = (BaseEmojiView) weakReference.get();
                if (baseEmojiView != null) {
                    baseEmojiView.resume();
                }
            }
            com.tencent.mm.emoji.loader.d.h.a aVar2 = this.eyf;
            if (aVar2 != null) {
                aVar2.bV(true);
                AppMethodBeat.o(63199);
                return;
            }
            AppMethodBeat.o(63199);
            return;
        }
        reload();
        AppMethodBeat.o(63199);
    }

    public final void bX(boolean z) {
        Object obj;
        BaseEmojiView baseEmojiView;
        Drawable drawable = null;
        AppMethodBeat.i(63200);
        String str = "MicroMsg.ChatEmojiViewRequest";
        StringBuilder append = new StringBuilder("onLoad ").append(this).append(' ');
        WeakReference weakReference = this.eyi;
        if (weakReference != null) {
            obj = (BaseEmojiView) weakReference.get();
        } else {
            obj = null;
        }
        ab.i(str, append.append(obj).append(' ').append(z).toString());
        weakReference = this.eyi;
        if (weakReference != null) {
            baseEmojiView = (BaseEmojiView) weakReference.get();
        } else {
            baseEmojiView = null;
        }
        if (z) {
            drawable = new com.tencent.mm.emoji.loader.b.a().a(this.exP, new b(this));
        }
        if (drawable == null && this.exX) {
            this.exX = false;
            reload();
            AppMethodBeat.o(63200);
            return;
        }
        com.tencent.mm.ab.b.a(new a(this, drawable, baseEmojiView, z));
        AppMethodBeat.o(63200);
    }

    public static final /* synthetic */ void a(a aVar, int i, int i2) {
        AppMethodBeat.i(63202);
        if (aVar.exP.field_width == 0 || aVar.exP.field_height == 0) {
            aVar.exP.field_width = i;
            aVar.exP.field_height = i2;
            com.tencent.mm.kernel.b.a M = g.M(d.class);
            j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            ((d) M).getProvider().updateEmojiInfo(aVar.exP);
        }
        AppMethodBeat.o(63202);
    }
}
