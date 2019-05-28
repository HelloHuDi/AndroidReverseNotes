package com.tencent.p177mm.emoji.loader.p849e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.loader.p1460f.C32505c;
import com.tencent.p177mm.emoji.loader.p848c.C37683g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/emoji/loader/task/EmojiLoadTask;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkCache", "", "getTaskKey", "run", "", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.loader.e.b */
public final class C41960b extends C37685c {
    final String TAG = "MicroMsg.EmojiLoadTask";

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    /* renamed from: com.tencent.mm.emoji.loader.e.b$a */
    static final class C31267a extends C25053k implements C17126b<Boolean, C37091y> {
        final /* synthetic */ C41960b eyo;

        C31267a(C41960b c41960b) {
            this.eyo = c41960b;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(63221);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            C4990ab.m7416i(this.eyo.TAG, this.eyo.exP.mo20410Aq() + " fetch " + booleanValue);
            if (booleanValue) {
                C32505c c32505c = C32505c.eyt;
                booleanValue = C32505c.m53223i(this.eyo.exP);
                C4990ab.m7416i(this.eyo.TAG, this.eyo.exP.mo20410Aq() + " verify " + booleanValue);
                this.eyo.mo20716bV(booleanValue);
            } else {
                this.eyo.mo20716bV(false);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(63221);
            return c37091y;
        }
    }

    public C41960b(EmojiInfo emojiInfo) {
        C25052j.m39376p(emojiInfo, "emojiInfo");
        super(emojiInfo);
        AppMethodBeat.m2504i(63224);
        AppMethodBeat.m2505o(63224);
    }

    public final void run() {
        AppMethodBeat.m2504i(63223);
        super.run();
        if (this.exP.duP()) {
            mo20716bV(true);
            AppMethodBeat.m2505o(63223);
            return;
        }
        C37683g c37683g = C37683g.exW;
        C37683g.m63731a(this.exP, new C31267a(this));
        AppMethodBeat.m2505o(63223);
    }

    /* renamed from: OA */
    public final String mo20715OA() {
        AppMethodBeat.m2504i(63222);
        String Aq = this.exP.mo20410Aq();
        C25052j.m39375o(Aq, "emojiInfo.md5");
        AppMethodBeat.m2505o(63222);
        return Aq;
    }
}
