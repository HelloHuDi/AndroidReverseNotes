package com.tencent.mm.emoji.loader.e;

import a.f.a.b;
import a.f.b.j;
import a.f.b.k;
import a.k.u;
import a.l;
import a.y;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.d.h;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;

@l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/emoji/loader/task/EmojiCoverTask;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Ljava/lang/Runnable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "dependRequest", "Lcom/tencent/mm/emoji/loader/request/Request;", "taskKey", "", "getTaskKey", "onResult", "", "success", "", "run", "plugin-emojisdk_release"})
public final class a extends c implements Runnable {
    private final String eyl;
    private h<?> eym;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    static final class a extends k implements b<Boolean, y> {
        final /* synthetic */ a eyn;

        a(a aVar) {
            this.eyn = aVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(63217);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            ab.i("MicroMsg.EmojiCoverTask", "run: " + this.eyn.eyl + ", " + booleanValue);
            this.eyn.bV(booleanValue);
            y yVar = y.AUy;
            AppMethodBeat.o(63217);
            return yVar;
        }
    }

    public a(EmojiInfo emojiInfo) {
        j.p(emojiInfo, "emojiInfo");
        super(emojiInfo);
        AppMethodBeat.i(63220);
        this.eyl = emojiInfo.Aq() + "_cover";
        AppMethodBeat.o(63220);
    }

    public final String OA() {
        return this.eyl;
    }

    /* JADX WARNING: Missing block: B:31:0x00f4, code skipped:
            if (r1 == null) goto L_0x00e1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        boolean z;
        com.tencent.mm.emoji.loader.a.b bVar;
        h a;
        AppMethodBeat.i(63218);
        super.run();
        com.tencent.mm.emoji.loader.c.b bVar2 = new com.tencent.mm.emoji.loader.c.b();
        EmojiInfo emojiInfo = this.exP;
        b aVar = new a(this);
        j.p(emojiInfo, "emojiInfo");
        com.tencent.mm.emoji.loader.a.b bVar3 = com.tencent.mm.emoji.loader.a.b.exB;
        Bitmap kR = com.tencent.mm.emoji.loader.a.b.kR(emojiInfo.Aq());
        if (kR != null) {
            z = true;
        } else {
            if (j.j(emojiInfo.awa(), String.valueOf(EmojiGroupInfo.yar)) || emojiInfo.getGroup() == EmojiGroupInfo.yas || emojiInfo.getGroup() == EmojiInfo.yaA || emojiInfo.getGroup() == EmojiInfo.yaz) {
                String name = emojiInfo.getName();
                if (!bo.isNullOrNil(name)) {
                    j.o(name, "name");
                    String i = u.i(name, ".png", "", false);
                    Context context = ah.getContext();
                    j.o(context, "MMApplicationContext.getContext()");
                    Resources resources = context.getResources();
                    kR = MMBitmapFactory.decodeResource(resources, resources.getIdentifier(i, "drawable", ah.getPackageName()));
                }
            } else if (e.ct(emojiInfo.dvf())) {
                Options options = new Options();
                options.outWidth = 120;
                options.outHeight = 120;
                kR = d.decodeFile(emojiInfo.dvf(), options);
                if (kR != null) {
                    if (kR.getWidth() > 120 || kR.getHeight() > 120) {
                        kR = d.a(kR, 120, 120, false, true);
                    }
                }
                z = false;
            }
            if (kR != null) {
                bVar = com.tencent.mm.emoji.loader.a.b.exB;
                com.tencent.mm.emoji.loader.a.b.c(emojiInfo.Aq(), kR);
                z = true;
            }
            z = false;
        }
        if (z) {
            ab.i("MicroMsg.EmojiCoverFetcher", "fetch: from cache " + emojiInfo.Aq());
            aVar.am(Boolean.TRUE);
        } else if (bo.isNullOrNil(emojiInfo.field_thumbUrl)) {
            ab.i("MicroMsg.EmojiCoverFetcher", "loadDataImp: load by gif " + emojiInfo.Aq());
            com.tencent.mm.emoji.loader.a aVar2 = com.tencent.mm.emoji.loader.a.exs;
            a = com.tencent.mm.emoji.loader.a.a(emojiInfo, (com.tencent.mm.emoji.loader.d.h.a) new com.tencent.mm.emoji.loader.c.b.b(emojiInfo, aVar));
            this.eym = a;
            AppMethodBeat.o(63218);
        } else {
            byte[] bArr;
            ab.i("MicroMsg.EmojiCoverFetcher", "loadDataImp: load by url " + emojiInfo.Aq());
            com.tencent.mm.at.a.d.b sE = new com.tencent.mm.plugin.emoji.d.a().sE(emojiInfo.field_thumbUrl);
            if (sE != null) {
                bArr = sE.data;
            } else {
                bArr = null;
            }
            if (bArr != null) {
                kR = d.bQ(sE.data);
                bVar = com.tencent.mm.emoji.loader.a.b.exB;
                com.tencent.mm.emoji.loader.a.b.c(emojiInfo.Aq(), kR);
                e.q(emojiInfo.dvf(), sE.data);
                aVar.am(Boolean.TRUE);
            } else {
                aVar.am(Boolean.FALSE);
            }
        }
        a = null;
        this.eym = a;
        AppMethodBeat.o(63218);
    }

    public final void bV(boolean z) {
        AppMethodBeat.i(63219);
        h hVar = this.eym;
        if (hVar != null) {
            hVar.cancel();
        }
        super.bV(z);
        AppMethodBeat.o(63219);
    }
}
