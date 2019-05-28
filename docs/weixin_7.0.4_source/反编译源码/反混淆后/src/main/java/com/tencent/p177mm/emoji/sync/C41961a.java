package com.tencent.p177mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.decode.C26076b;
import com.tencent.p177mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.p177mm.emoji.loader.p1460f.C32505c;
import com.tencent.p177mm.emoji.loader.p848c.C37683g;
import com.tencent.p177mm.emoji.p227a.C32497a;
import com.tencent.p177mm.loader.p864g.C26365c;
import com.tencent.p177mm.loader.p864g.C45423h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C23505at;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, dWq = {"Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "call", "", "checkUpdate", "uniqueId", "", "Companion", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.sync.a */
public final class C41961a extends C26365c {
    private static final String TAG = TAG;
    public static final C26081a ezo = new C26081a();
    final EmojiInfo exP;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.sync.a$a */
    public static final class C26081a {
        private C26081a() {
        }

        public /* synthetic */ C26081a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    /* renamed from: com.tencent.mm.emoji.sync.a$b */
    static final class C31268b extends C25053k implements C17126b<Boolean, C37091y> {
        final /* synthetic */ C41961a ezp;

        C31268b(C41961a c41961a) {
            this.ezp = c41961a;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            C37091y c37091y;
            AppMethodBeat.m2504i(63252);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            C4990ab.m7416i(C41961a.TAG, this.ezp + ' ' + this.ezp.exP.mo20410Aq() + " fetcher " + booleanValue);
            if (booleanValue) {
                C32505c c32505c = C32505c.eyt;
                booleanValue = C32505c.m53223i(this.ezp.exP);
                C4990ab.m7416i(C41961a.TAG, this.ezp.exP.mo20410Aq() + " verify " + booleanValue);
                if (booleanValue) {
                    Thread.sleep(300);
                    C41961a.m74108a(this.ezp);
                    this.ezp.mo44157a(C45423h.OK);
                    c37091y = C37091y.AUy;
                    AppMethodBeat.m2505o(63252);
                    return c37091y;
                }
            }
            this.ezp.mo44157a(C45423h.Fail);
            c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(63252);
            return c37091y;
        }
    }

    public C41961a(EmojiInfo emojiInfo) {
        C25052j.m39376p(emojiInfo, "emojiInfo");
        AppMethodBeat.m2504i(63256);
        this.exP = emojiInfo;
        AppMethodBeat.m2505o(63256);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m74108a(C41961a c41961a) {
        AppMethodBeat.m2504i(63258);
        c41961a.m74107Pb();
        AppMethodBeat.m2505o(63258);
    }

    static {
        AppMethodBeat.m2504i(63257);
        AppMethodBeat.m2505o(63257);
    }

    /* renamed from: Pa */
    public final void mo9026Pa() {
        AppMethodBeat.m2504i(63253);
        if (this.exP.duP()) {
            C4990ab.m7416i(TAG, this + ' ' + this.exP.mo20410Aq() + ": already load");
            m74107Pb();
            mo44157a(C45423h.OK);
            AppMethodBeat.m2505o(63253);
            return;
        }
        C37683g c37683g = C37683g.exW;
        C37683g.m63731a(this.exP, new C31268b(this));
        AppMethodBeat.m2505o(63253);
    }

    /* renamed from: Pb */
    private final void m74107Pb() {
        AppMethodBeat.m2504i(63254);
        boolean z = false;
        C23505at dsZ = C23505at.dsZ();
        C25052j.m39375o(dsZ, "EmojiStorageMgr.getInstance()");
        EmojiInfo aqi = dsZ.aUp().aqi(this.exP.mo20410Aq());
        if (aqi == null) {
            AppMethodBeat.m2505o(63254);
            return;
        }
        if (aqi.getState() != EmojiInfo.zZb) {
            aqi.setState(EmojiInfo.zZb);
            z = true;
        }
        if (aqi.field_width <= 0 || aqi.field_width <= 0) {
            C26076b decoder = MMGIFJNIFactory.Companion.getDecoder(aqi);
            if (MMGIFJNIFactory.Companion.isValid(decoder)) {
                aqi.field_width = decoder.mo33672Ou();
                aqi.field_height = decoder.mo33673Ov();
                z = true;
            }
            decoder.destroy();
        }
        if (z) {
            C23505at dsZ2 = C23505at.dsZ();
            C25052j.m39375o(dsZ2, "EmojiStorageMgr.getInstance()");
            dsZ2.aUp().mo48555G(aqi);
            if (C25052j.m39373j(this.exP.awa(), "capture")) {
                C32497a.m53203OB().mo53141cd(true);
            }
        }
        AppMethodBeat.m2505o(63254);
    }

    /* renamed from: Pc */
    public final String mo9027Pc() {
        AppMethodBeat.m2504i(63255);
        String Aq = this.exP.mo20410Aq();
        C25052j.m39375o(Aq, "emojiInfo.md5");
        AppMethodBeat.m2505o(63255);
        return Aq;
    }
}
