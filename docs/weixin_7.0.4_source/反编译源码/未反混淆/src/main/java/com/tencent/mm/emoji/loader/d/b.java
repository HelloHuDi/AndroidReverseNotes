package com.tencent.mm.emoji.loader.d;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;

@l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/emoji/loader/request/EmojiCoverRequest;", "Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "Landroid/widget/ImageView;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/widget/ImageView;)V", "createTask", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "onLoad", "", "success", "", "start", "plugin-emojisdk_release"})
public final class b extends i<ImageView> {

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class a extends k implements a.f.a.a<y> {
        final /* synthetic */ boolean eyb;
        final /* synthetic */ Bitmap eyc;
        final /* synthetic */ ImageView eyd;

        a(boolean z, Bitmap bitmap, ImageView imageView) {
            this.eyb = z;
            this.eyc = bitmap;
            this.eyd = imageView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(63203);
            if (this.eyb && this.eyc != null) {
                ImageView imageView = this.eyd;
                if (imageView != null) {
                    imageView.setImageBitmap(this.eyc);
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(63203);
            return yVar;
        }
    }

    public b(EmojiInfo emojiInfo, ImageView imageView) {
        j.p(emojiInfo, "emojiInfo");
        j.p(imageView, "view");
        super(emojiInfo, imageView);
        AppMethodBeat.i(63207);
        AppMethodBeat.o(63207);
    }

    public final void start() {
        AppMethodBeat.i(63204);
        com.tencent.mm.emoji.loader.a.b bVar = com.tencent.mm.emoji.loader.a.b.exB;
        Bitmap kR = com.tencent.mm.emoji.loader.a.b.kR(this.exP.Aq());
        ab.i(c.TAG, "start: " + this.exP.Aq() + ", " + kR);
        if (kR != null) {
            bX(true);
            AppMethodBeat.o(63204);
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
        AppMethodBeat.o(63204);
    }

    /* Access modifiers changed, original: protected|final */
    public final c Oy() {
        AppMethodBeat.i(63205);
        com.tencent.mm.emoji.loader.a aVar = com.tencent.mm.emoji.loader.a.exs;
        c b = com.tencent.mm.emoji.loader.a.b(this.exP);
        AppMethodBeat.o(63205);
        return b;
    }

    public final void bX(boolean z) {
        AppMethodBeat.i(63206);
        super.bX(z);
        WeakReference weakReference = this.eyi;
        ImageView imageView = weakReference != null ? (ImageView) weakReference.get() : null;
        com.tencent.mm.emoji.loader.a.b bVar = com.tencent.mm.emoji.loader.a.b.exB;
        Bitmap kR = com.tencent.mm.emoji.loader.a.b.kR(this.exP.Aq());
        ab.i(c.TAG, "onLoad: " + this.exP.Aq() + ", " + kR);
        com.tencent.mm.ab.b.a(new a(z, kR, imageView));
        AppMethodBeat.o(63206);
    }
}
