package com.tencent.p177mm.emoji.loader.p1190d;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.loader.C37682a;
import com.tencent.p177mm.emoji.loader.p1531a.C45305b;
import com.tencent.p177mm.emoji.loader.p849e.C37685c;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/emoji/loader/request/EmojiCoverRequest;", "Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "Landroid/widget/ImageView;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/widget/ImageView;)V", "createTask", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "onLoad", "", "success", "", "start", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.loader.d.b */
public final class C18205b extends C26080i<ImageView> {

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.emoji.loader.d.b$a */
    static final class C18206a extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ boolean eyb;
        final /* synthetic */ Bitmap eyc;
        final /* synthetic */ ImageView eyd;

        C18206a(boolean z, Bitmap bitmap, ImageView imageView) {
            this.eyb = z;
            this.eyc = bitmap;
            this.eyd = imageView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(63203);
            if (this.eyb && this.eyc != null) {
                ImageView imageView = this.eyd;
                if (imageView != null) {
                    imageView.setImageBitmap(this.eyc);
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(63203);
            return c37091y;
        }
    }

    public C18205b(EmojiInfo emojiInfo, ImageView imageView) {
        C25052j.m39376p(emojiInfo, "emojiInfo");
        C25052j.m39376p(imageView, "view");
        super(emojiInfo, imageView);
        AppMethodBeat.m2504i(63207);
        AppMethodBeat.m2505o(63207);
    }

    public final void start() {
        AppMethodBeat.m2504i(63204);
        C45305b c45305b = C45305b.exB;
        Bitmap kR = C45305b.m83553kR(this.exP.mo20410Aq());
        C4990ab.m7416i(C41956c.TAG, "start: " + this.exP.mo20410Aq() + ", " + kR);
        if (kR != null) {
            mo33677bX(true);
            AppMethodBeat.m2505o(63204);
            return;
        }
        WeakReference weakReference = this.eyi;
        if (weakReference != null) {
            ImageView imageView = (ImageView) weakReference.get();
            if (imageView != null) {
                imageView.setImageDrawable(null);
            }
        }
        reload();
        AppMethodBeat.m2505o(63204);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Oy */
    public final C37685c mo33679Oy() {
        AppMethodBeat.m2504i(63205);
        C37682a c37682a = C37682a.exs;
        C37685c b = C37682a.m63726b(this.exP);
        AppMethodBeat.m2505o(63205);
        return b;
    }

    /* renamed from: bX */
    public final void mo33677bX(boolean z) {
        AppMethodBeat.m2504i(63206);
        super.mo33677bX(z);
        WeakReference weakReference = this.eyi;
        ImageView imageView = weakReference != null ? (ImageView) weakReference.get() : null;
        C45305b c45305b = C45305b.exB;
        Bitmap kR = C45305b.m83553kR(this.exP.mo20410Aq());
        C4990ab.m7416i(C41956c.TAG, "onLoad: " + this.exP.mo20410Aq() + ", " + kR);
        C8902b.m16042a(new C18206a(z, kR, imageView));
        AppMethodBeat.m2505o(63206);
    }
}
