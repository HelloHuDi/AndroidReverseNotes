package com.tencent.p177mm.plugin.cdndownloader.p935f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.cdndownloader.p1543b.C38782a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.util.VideoFilterUtil;

/* renamed from: com.tencent.mm.plugin.cdndownloader.f.b */
public final class C45805b {
    /* renamed from: a */
    public static void m84722a(C38783a c38783a) {
        AppMethodBeat.m2504i(959);
        C11368c beQ = C45805b.beQ();
        if (beQ != null) {
            C4990ab.m7416i("MicroMsg.CdnDownloadInfoDBHelp", "insert: ".concat(String.valueOf(beQ.mo10101b((C4925c) c38783a))));
        }
        AppMethodBeat.m2505o(959);
    }

    /* renamed from: HF */
    public static void m84721HF(String str) {
        AppMethodBeat.m2504i(VideoFilterUtil.IMAGE_HEIGHT);
        C11368c beQ = C45805b.beQ();
        if (beQ != null) {
            C4990ab.m7416i("MicroMsg.CdnDownloadInfoDBHelp", "removeDownloadInfoByDownloadUrl: ".concat(String.valueOf(beQ.mo23102HG(str))));
        }
        AppMethodBeat.m2505o(VideoFilterUtil.IMAGE_HEIGHT);
    }

    public static C11368c beQ() {
        AppMethodBeat.m2504i(961);
        C11368c beQ = ((C38782a) C1720g.m3528K(C38782a.class)).beQ();
        AppMethodBeat.m2505o(961);
        return beQ;
    }
}
