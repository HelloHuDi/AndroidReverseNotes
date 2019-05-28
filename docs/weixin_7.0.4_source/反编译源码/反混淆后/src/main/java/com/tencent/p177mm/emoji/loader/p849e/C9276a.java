package com.tencent.p177mm.emoji.loader.p849e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.loader.C37682a;
import com.tencent.p177mm.emoji.loader.p1190d.C18207h;
import com.tencent.p177mm.emoji.loader.p1190d.C18207h.C18208a;
import com.tencent.p177mm.emoji.loader.p1531a.C45305b;
import com.tencent.p177mm.emoji.loader.p848c.C18198b;
import com.tencent.p177mm.emoji.loader.p848c.C18198b.C18199b;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.p190at.p191a.p1527d.C37477b;
import com.tencent.p177mm.plugin.emoji.p382d.C20358a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5730e;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/emoji/loader/task/EmojiCoverTask;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Ljava/lang/Runnable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "dependRequest", "Lcom/tencent/mm/emoji/loader/request/Request;", "taskKey", "", "getTaskKey", "onResult", "", "success", "", "run", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.loader.e.a */
public final class C9276a extends C37685c implements Runnable {
    private final String eyl;
    private C18207h<?> eym;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    /* renamed from: com.tencent.mm.emoji.loader.e.a$a */
    static final class C9277a extends C25053k implements C17126b<Boolean, C37091y> {
        final /* synthetic */ C9276a eyn;

        C9277a(C9276a c9276a) {
            this.eyn = c9276a;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(63217);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            C4990ab.m7416i("MicroMsg.EmojiCoverTask", "run: " + this.eyn.eyl + ", " + booleanValue);
            this.eyn.mo20716bV(booleanValue);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(63217);
            return c37091y;
        }
    }

    public C9276a(EmojiInfo emojiInfo) {
        C25052j.m39376p(emojiInfo, "emojiInfo");
        super(emojiInfo);
        AppMethodBeat.m2504i(63220);
        this.eyl = emojiInfo.mo20410Aq() + "_cover";
        AppMethodBeat.m2505o(63220);
    }

    /* renamed from: OA */
    public final String mo20715OA() {
        return this.eyl;
    }

    /* JADX WARNING: Missing block: B:31:0x00f4, code skipped:
            if (r1 == null) goto L_0x00e1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        boolean z;
        C45305b c45305b;
        C18207h a;
        AppMethodBeat.m2504i(63218);
        super.run();
        C18198b c18198b = new C18198b();
        EmojiInfo emojiInfo = this.exP;
        C17126b c9277a = new C9277a(this);
        C25052j.m39376p(emojiInfo, "emojiInfo");
        C45305b c45305b2 = C45305b.exB;
        Bitmap kR = C45305b.m83553kR(emojiInfo.mo20410Aq());
        if (kR != null) {
            z = true;
        } else {
            if (C25052j.m39373j(emojiInfo.awa(), String.valueOf(EmojiGroupInfo.yar)) || emojiInfo.getGroup() == EmojiGroupInfo.yas || emojiInfo.getGroup() == EmojiInfo.yaA || emojiInfo.getGroup() == EmojiInfo.yaz) {
                String name = emojiInfo.getName();
                if (!C5046bo.isNullOrNil(name)) {
                    C25052j.m39375o(name, "name");
                    String i = C6163u.m9838i(name, ".png", "", false);
                    Context context = C4996ah.getContext();
                    C25052j.m39375o(context, "MMApplicationContext.getContext()");
                    Resources resources = context.getResources();
                    kR = MMBitmapFactory.decodeResource(resources, resources.getIdentifier(i, "drawable", C4996ah.getPackageName()));
                }
            } else if (C5730e.m8628ct(emojiInfo.dvf())) {
                Options options = new Options();
                options.outWidth = 120;
                options.outHeight = 120;
                kR = C5056d.decodeFile(emojiInfo.dvf(), options);
                if (kR != null) {
                    if (kR.getWidth() > 120 || kR.getHeight() > 120) {
                        kR = C5056d.m7615a(kR, 120, 120, false, true);
                    }
                }
                z = false;
            }
            if (kR != null) {
                c45305b = C45305b.exB;
                C45305b.m83552c(emojiInfo.mo20410Aq(), kR);
                z = true;
            }
            z = false;
        }
        if (z) {
            C4990ab.m7416i("MicroMsg.EmojiCoverFetcher", "fetch: from cache " + emojiInfo.mo20410Aq());
            c9277a.mo50am(Boolean.TRUE);
        } else if (C5046bo.isNullOrNil(emojiInfo.field_thumbUrl)) {
            C4990ab.m7416i("MicroMsg.EmojiCoverFetcher", "loadDataImp: load by gif " + emojiInfo.mo20410Aq());
            C37682a c37682a = C37682a.exs;
            a = C37682a.m63722a(emojiInfo, (C18208a) new C18199b(emojiInfo, c9277a));
            this.eym = a;
            AppMethodBeat.m2505o(63218);
        } else {
            byte[] bArr;
            C4990ab.m7416i("MicroMsg.EmojiCoverFetcher", "loadDataImp: load by url " + emojiInfo.mo20410Aq());
            C37477b sE = new C20358a().mo33454sE(emojiInfo.field_thumbUrl);
            if (sE != null) {
                bArr = sE.data;
            } else {
                bArr = null;
            }
            if (bArr != null) {
                kR = C5056d.m7652bQ(sE.data);
                c45305b = C45305b.exB;
                C45305b.m83552c(emojiInfo.mo20410Aq(), kR);
                C5730e.m8640q(emojiInfo.dvf(), sE.data);
                c9277a.mo50am(Boolean.TRUE);
            } else {
                c9277a.mo50am(Boolean.FALSE);
            }
        }
        a = null;
        this.eym = a;
        AppMethodBeat.m2505o(63218);
    }

    /* renamed from: bV */
    public final void mo20716bV(boolean z) {
        AppMethodBeat.m2504i(63219);
        C18207h c18207h = this.eym;
        if (c18207h != null) {
            c18207h.cancel();
        }
        super.mo20716bV(z);
        AppMethodBeat.m2505o(63219);
    }
}
