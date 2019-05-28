package com.tencent.p177mm.plugin.emoji.sync.p948a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p726f.C20372f;
import com.tencent.p177mm.plugin.emoji.sync.C11563d;
import com.tencent.p177mm.plugin.emoji.sync.C27745c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;

/* renamed from: com.tencent.mm.plugin.emoji.sync.a.d */
public final class C11561d extends C27745c {
    private C11563d kXJ;
    private C1207m kXU;
    private EmojiInfo kXV;
    private String mKey;

    public C11561d(String str) {
        AppMethodBeat.m2504i(53210);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.BKGLoader.EmojiUploadTask", "[cpan] can not create task. md5 is null.");
        }
        this.mKey = str;
        this.kXV = C42952j.getEmojiStorageMgr().xYn.aqi(this.mKey);
        AppMethodBeat.m2505o(53210);
    }

    public final void run() {
        AppMethodBeat.m2504i(53211);
        if (this.kXJ != null) {
            this.kXJ.mo7131JH(this.mKey);
        } else {
            C4990ab.m7420w("MicroMsg.BKGLoader.EmojiUploadTask", "call back is null.");
        }
        if (this.kXV == null) {
            this.kXJ.mo7139m(this.mKey, 1, false);
            AppMethodBeat.m2505o(53211);
            return;
        }
        this.kXU = new C20372f(this.kXV);
        C1720g.m3535RO().eJo.mo14541a(this.kXU, 0);
        AppMethodBeat.m2505o(53211);
    }

    public final String getKey() {
        return this.mKey;
    }

    /* renamed from: a */
    public final void mo23266a(C11563d c11563d) {
        this.kXJ = c11563d;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(53212);
        if (obj != null && (obj instanceof C11561d)) {
            C11561d c11561d = (C11561d) obj;
            if (!(C5046bo.isNullOrNil(this.mKey) || C5046bo.isNullOrNil(c11561d.mKey) || !this.mKey.equals(c11561d.mKey))) {
                AppMethodBeat.m2505o(53212);
                return true;
            }
        }
        AppMethodBeat.m2505o(53212);
        return false;
    }

    public final void cancel() {
    }
}
