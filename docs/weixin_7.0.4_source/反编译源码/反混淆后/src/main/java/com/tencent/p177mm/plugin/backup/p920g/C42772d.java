package com.tencent.p177mm.plugin.backup.p920g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.backup.p921i.C42779z;
import com.tencent.p177mm.plugin.backup.p921i.C45750aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.backup.g.d */
public final class C42772d extends C19978b {
    private C1202f fur;
    private C42779z jxx = new C42779z();
    public C45750aa jxy = new C45750aa();

    public C42772d(String str, long j, long j2, String str2, String str3, LinkedList<String> linkedList, C1202f c1202f) {
        AppMethodBeat.m2504i(17655);
        C4990ab.m7417i("MicroMsg.BackupDataTagScene", "init DataTag, BakChatName:%s, startTime:%d, endTime:%d, mediaIdList size:%d", str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(linkedList.size()));
        this.jxx.jBt = str;
        this.jxx.jCE = j;
        this.jxx.jCF = j2;
        this.jxx.jCG = str2;
        this.jxx.jCH = str3;
        this.jxx.jCl = linkedList;
        this.fur = c1202f;
        AppMethodBeat.m2505o(17655);
    }

    public final boolean aUc() {
        AppMethodBeat.m2504i(17656);
        boolean aUd = super.aUd();
        if (!aUd) {
            this.fur.onSceneEnd(1, -2, "doScene failed", this);
        }
        AppMethodBeat.m2505o(17656);
        return aUd;
    }

    public final int getType() {
        return 15;
    }

    public final C1331a aTS() {
        return this.jxy;
    }

    public final C1331a aTT() {
        return this.jxx;
    }

    /* renamed from: rw */
    public final void mo6711rw(int i) {
        AppMethodBeat.m2504i(17657);
        C4990ab.m7416i("MicroMsg.BackupDataTagScene", "onSceneEnd");
        mo35227l(0, 0, "success");
        this.fur.onSceneEnd(0, 0, "", this);
        AppMethodBeat.m2505o(17657);
    }
}
