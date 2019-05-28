package com.tencent.p177mm.plugin.emoji.sync.p948a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p230g.p231a.C26107cx;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p726f.C20373l;
import com.tencent.p177mm.plugin.emoji.p726f.C42945g;
import com.tencent.p177mm.plugin.emoji.sync.C11563d;
import com.tencent.p177mm.plugin.emoji.sync.C27745c;
import com.tencent.p177mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.C44224i;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.emoji.sync.a.b */
public final class C38887b extends C27745c {
    private boolean kWV = false;
    private String kWz;
    private C11563d kXJ;
    private C42945g kXT;

    public C38887b(String str) {
        AppMethodBeat.m2504i(53202);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
        }
        this.kWz = str;
        AppMethodBeat.m2505o(53202);
    }

    public C38887b(String str, byte b) {
        AppMethodBeat.m2504i(53203);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
        }
        this.kWz = str;
        this.kWV = true;
        AppMethodBeat.m2505o(53203);
    }

    public final void run() {
        AppMethodBeat.m2504i(53204);
        if (this.kXJ != null) {
            this.kXJ.mo7131JH(getKey());
        } else {
            C4990ab.m7420w("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "call back is null");
        }
        EmojiGroupInfo bZ = C42952j.getEmojiStorageMgr().xYo.mo74770bZ(getKey(), true);
        if (this.kWV || bZ == null || bZ.field_sync != 2 || bZ.field_status != 7) {
            this.kXT = new C42945g(this.kWz);
            C1720g.m3535RO().eJo.mo14541a(this.kXT, 0);
            GetEmotionDetailResponse getEmotionDetailResponse = new GetEmotionDetailResponse();
            C44224i aqp = C42952j.getEmojiStorageMgr().xYr.aqp(this.kWz);
            if (!(aqp == null || aqp.field_content == null)) {
                try {
                    getEmotionDetailResponse.parseFrom(aqp.field_content);
                } catch (IOException e) {
                    C4990ab.m7413e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "exception:%s", C5046bo.m7574l(e));
                }
            }
            if (getEmotionDetailResponse.EmotionDetail == null) {
                C1720g.m3535RO().eJo.mo14541a(new C20373l(this.kWz, 15), 0);
            }
            AppMethodBeat.m2505o(53204);
            return;
        }
        C26107cx c26107cx = new C26107cx();
        c26107cx.cvY.cvZ = getKey();
        c26107cx.cvY.cuy = 2;
        c26107cx.cvY.success = true;
        C4879a.xxA.mo10055m(c26107cx);
        AppMethodBeat.m2505o(53204);
    }

    public final String getKey() {
        return this.kWz == null ? "" : this.kWz;
    }

    /* renamed from: a */
    public final void mo23266a(C11563d c11563d) {
        this.kXJ = c11563d;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(53205);
        if (obj != null && (obj instanceof C38887b)) {
            C38887b c38887b = (C38887b) obj;
            if (!(C5046bo.isNullOrNil(this.kWz) || C5046bo.isNullOrNil(c38887b.getKey()) || !this.kWz.equals(c38887b.getKey()))) {
                AppMethodBeat.m2505o(53205);
                return true;
            }
        }
        AppMethodBeat.m2505o(53205);
        return false;
    }

    public final void cancel() {
        AppMethodBeat.m2504i(53206);
        if (this.kXT == null || C5046bo.isNullOrNil(this.kXT.fFa)) {
            C4990ab.m7416i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "failed cancel exchange emotion pack.");
            AppMethodBeat.m2505o(53206);
            return;
        }
        C37461f.afx().mo51228rO(this.kXT.fFa);
        C4990ab.m7417i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "success cancel exchange emotion pack clientid:%s", this.kXT.fFa);
        AppMethodBeat.m2505o(53206);
    }
}
