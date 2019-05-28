package com.tencent.p177mm.plugin.webview.fts.p1327a.p1328a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a.C32718b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.C37934g;
import com.tencent.p177mm.modelappbrand.C45447x;
import com.tencent.p177mm.p230g.p232b.p233a.C1596cz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.webview.fts.a.a.a */
public final class C46410a {
    private static C46410a ugq = new C46410a();

    /* renamed from: com.tencent.mm.plugin.webview.fts.a.a.a$1 */
    public class C402121 implements Runnable {
        public final void run() {
            boolean z;
            long j;
            AppMethodBeat.m2504i(5763);
            C4990ab.m7416i("WidgetPkgCoverageReport", "begin check");
            C40213b.cWr();
            C42142a c42142a = C32718b.eGM;
            C5141c ll = C42142a.m74295ll("100429");
            if (ll == null || !ll.isValid()) {
                z = false;
            } else {
                z = C40213b.m68970a(ll);
            }
            List<C45447x> abA = ((C37934g) C1720g.m3528K(C37934g.class)).abA();
            StringBuilder stringBuilder = new StringBuilder();
            for (C45447x c45447x : abA) {
                stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(c45447x.csB).append("_").append(c45447x.version).append("_").append(c45447x.cvZ);
            }
            C1596cz c1596cz = new C1596cz();
            if (z) {
                j = 1;
            } else {
                j = 0;
            }
            c1596cz.diz = j;
            c1596cz.mo5035ia(stringBuilder.toString()).ajK();
            C4990ab.m7416i("WidgetPkgCoverageReport", "end check");
            AppMethodBeat.m2505o(5763);
        }
    }

    static {
        AppMethodBeat.m2504i(5764);
        AppMethodBeat.m2505o(5764);
    }

    public static C46410a cWq() {
        return ugq;
    }
}
