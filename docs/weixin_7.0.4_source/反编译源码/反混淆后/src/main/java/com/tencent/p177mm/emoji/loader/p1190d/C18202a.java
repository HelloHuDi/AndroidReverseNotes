package com.tencent.p177mm.emoji.loader.p1190d;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.loader.p1190d.C18207h.C18208a;
import com.tencent.p177mm.emoji.loader.p1531a.C37680a;
import com.tencent.p177mm.emoji.loader.p1599b.C41954a;
import com.tencent.p177mm.emoji.view.BaseEmojiView;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1677a;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.pluginsdk.p597ui.emoji.ChattingEmojiView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/emoji/loader/request/ChatEmojiViewRequest;", "Lcom/tencent/mm/emoji/loader/request/EmojiViewRequest;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "Lcom/tencent/mm/pluginsdk/ui/emoji/ChattingEmojiView;", "cacheKey", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/pluginsdk/ui/emoji/ChattingEmojiView;Ljava/lang/String;)V", "firstLoad", "", "onLoad", "", "success", "onSize", "width", "", "height", "start", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.loader.d.a */
public final class C18202a extends C37684e {
    private final String cacheKey;
    private boolean exX = true;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.emoji.loader.d.a$a */
    static final class C18203a extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C18202a exY;
        final /* synthetic */ Drawable exZ;
        final /* synthetic */ BaseEmojiView eya;
        final /* synthetic */ boolean eyb;

        C18203a(C18202a c18202a, Drawable drawable, BaseEmojiView baseEmojiView, boolean z) {
            this.exY = c18202a;
            this.exZ = drawable;
            this.eya = baseEmojiView;
            this.eyb = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(63197);
            C37680a c37680a = C37680a.exz;
            C37680a.m63717b(this.exY.cacheKey, this.exZ);
            BaseEmojiView baseEmojiView = this.eya;
            if (baseEmojiView != null) {
                baseEmojiView.setImageDrawable(this.exZ);
            }
            baseEmojiView = this.eya;
            if (baseEmojiView != null) {
                baseEmojiView.resume();
            }
            C18208a c18208a = this.exY.eyf;
            if (c18208a != null) {
                boolean z;
                if (!this.eyb || this.exZ == null) {
                    z = false;
                } else {
                    z = true;
                }
                c18208a.mo33675bV(z);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(63197);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "width", "", "height", "invoke"})
    /* renamed from: com.tencent.mm.emoji.loader.d.a$b */
    static final class C18204b extends C25053k implements C31591m<Integer, Integer, C37091y> {
        final /* synthetic */ C18202a exY;

        C18204b(C18202a c18202a) {
            this.exY = c18202a;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(63198);
            C18202a.m28646a(this.exY, ((Number) obj).intValue(), ((Number) obj2).intValue());
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(63198);
            return c37091y;
        }
    }

    public C18202a(EmojiInfo emojiInfo, ChattingEmojiView chattingEmojiView, String str) {
        C25052j.m39376p(emojiInfo, "emojiInfo");
        C25052j.m39376p(chattingEmojiView, "view");
        C25052j.m39376p(str, "cacheKey");
        super(emojiInfo, chattingEmojiView, chattingEmojiView);
        AppMethodBeat.m2504i(63201);
        this.cacheKey = str;
        AppMethodBeat.m2505o(63201);
    }

    /* JADX WARNING: Missing block: B:11:0x005d, code skipped:
            if (p000a.p005f.p007b.C25052j.m39373j(r3, r0) != false) goto L_0x005f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void start() {
        AppMethodBeat.m2504i(63199);
        C37680a c37680a = C37680a.exz;
        Drawable kQ = C37680a.m63718kQ(this.cacheKey);
        String str = "MicroMsg.ChatEmojiViewRequest";
        StringBuilder append = new StringBuilder("start: ").append(kQ).append(' ');
        WeakReference weakReference = this.eyi;
        C4990ab.m7416i(str, append.append(weakReference != null ? (BaseEmojiView) weakReference.get() : null).append(' ').append(this.cacheKey).toString());
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
            C18208a c18208a = this.eyf;
            if (c18208a != null) {
                c18208a.mo33675bV(true);
                AppMethodBeat.m2505o(63199);
                return;
            }
            AppMethodBeat.m2505o(63199);
            return;
        }
        reload();
        AppMethodBeat.m2505o(63199);
    }

    /* renamed from: bX */
    public final void mo33677bX(boolean z) {
        Object obj;
        BaseEmojiView baseEmojiView;
        Drawable drawable = null;
        AppMethodBeat.m2504i(63200);
        String str = "MicroMsg.ChatEmojiViewRequest";
        StringBuilder append = new StringBuilder("onLoad ").append(this).append(' ');
        WeakReference weakReference = this.eyi;
        if (weakReference != null) {
            obj = (BaseEmojiView) weakReference.get();
        } else {
            obj = null;
        }
        C4990ab.m7416i(str, append.append(obj).append(' ').append(z).toString());
        weakReference = this.eyi;
        if (weakReference != null) {
            baseEmojiView = (BaseEmojiView) weakReference.get();
        } else {
            baseEmojiView = null;
        }
        if (z) {
            drawable = new C41954a().mo67590a(this.exP, new C18204b(this));
        }
        if (drawable == null && this.exX) {
            this.exX = false;
            reload();
            AppMethodBeat.m2505o(63200);
            return;
        }
        C8902b.m16042a(new C18203a(this, drawable, baseEmojiView, z));
        AppMethodBeat.m2505o(63200);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m28646a(C18202a c18202a, int i, int i2) {
        AppMethodBeat.m2504i(63202);
        if (c18202a.exP.field_width == 0 || c18202a.exP.field_height == 0) {
            c18202a.exP.field_width = i;
            c18202a.exP.field_height = i2;
            C1677a M = C1720g.m3530M(C6835d.class);
            C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            ((C6835d) M).getProvider().updateEmojiInfo(c18202a.exP);
        }
        AppMethodBeat.m2505o(63202);
    }
}
