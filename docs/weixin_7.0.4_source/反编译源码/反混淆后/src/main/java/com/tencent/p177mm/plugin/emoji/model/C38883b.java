package com.tencent.p177mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p842bp.C9204c;
import com.tencent.p177mm.plugin.emoji.p725b.C20355b;
import com.tencent.p177mm.plugin.emoji.p725b.C20355b.C20356a;
import com.tencent.p177mm.plugin.emoji.p947e.C20365h;
import com.tencent.p177mm.pluginsdk.p1336a.C44795d;
import com.tencent.p177mm.storage.C23505at;
import com.tencent.p177mm.storage.C44219aq;

/* renamed from: com.tencent.mm.plugin.emoji.model.b */
public final class C38883b extends C7485q {

    /* renamed from: com.tencent.mm.plugin.emoji.model.b$1 */
    class C29351 implements C20355b {
        C29351() {
        }

        public final C44795d getEmojiMgr() {
            AppMethodBeat.m2504i(52994);
            C20365h bki = C42952j.bki();
            AppMethodBeat.m2505o(52994);
            return bki;
        }

        public final C23505at getEmojiStorageMgr() {
            AppMethodBeat.m2504i(52995);
            C23505at emojiStorageMgr = C42952j.getEmojiStorageMgr();
            AppMethodBeat.m2505o(52995);
            return emojiStorageMgr;
        }

        public final C44219aq getEmojiDescMgr() {
            AppMethodBeat.m2504i(52996);
            C44219aq emojiDescMgr = C42952j.getEmojiDescMgr();
            AppMethodBeat.m2505o(52996);
            return emojiDescMgr;
        }
    }

    public C38883b() {
        super(C9204c.akt("emoji"));
        AppMethodBeat.m2504i(52997);
        C20356a.kTl = new C29351();
        AppMethodBeat.m2505o(52997);
    }
}
