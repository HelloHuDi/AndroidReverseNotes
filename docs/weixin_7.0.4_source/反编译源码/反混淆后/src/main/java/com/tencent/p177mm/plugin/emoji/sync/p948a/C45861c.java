package com.tencent.p177mm.plugin.emoji.sync.p948a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.sync.C11563d;
import com.tencent.p177mm.plugin.emoji.sync.C27745c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;

/* renamed from: com.tencent.mm.plugin.emoji.sync.a.c */
public final class C45861c extends C27745c {
    private String kWz;
    private C11563d kXJ;

    public C45861c(String str) {
        AppMethodBeat.m2504i(53207);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "[cpan] empty productid");
        }
        this.kWz = str;
        AppMethodBeat.m2505o(53207);
    }

    public final void run() {
        AppMethodBeat.m2504i(53208);
        if (this.kXJ != null) {
            this.kXJ.mo7131JH(getKey());
        } else {
            C4990ab.m7420w("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "call back is null");
        }
        EmojiGroupInfo bZ = C42952j.getEmojiStorageMgr().xYo.mo74770bZ(EmojiGroupInfo.yar, false);
        bZ.field_flag = 0;
        C42952j.getEmojiStorageMgr().xYo.mo10099a(bZ);
        if (this.kXJ != null) {
            this.kXJ.mo7139m(getKey(), 2, true);
        }
        AppMethodBeat.m2505o(53208);
    }

    public final String getKey() {
        return this.kWz == null ? "" : this.kWz;
    }

    /* renamed from: a */
    public final void mo23266a(C11563d c11563d) {
        this.kXJ = c11563d;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(53209);
        if (obj != null && (obj instanceof C45861c)) {
            C45861c c45861c = (C45861c) obj;
            if (!(C5046bo.isNullOrNil(this.kWz) || C5046bo.isNullOrNil(c45861c.getKey()) || !this.kWz.equals(c45861c.getKey()))) {
                AppMethodBeat.m2505o(53209);
                return true;
            }
        }
        AppMethodBeat.m2505o(53209);
        return false;
    }

    public final void cancel() {
    }
}
