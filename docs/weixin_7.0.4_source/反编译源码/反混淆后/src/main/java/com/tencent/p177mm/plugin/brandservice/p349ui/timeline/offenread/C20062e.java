package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.protocal.protobuf.bfb;
import com.tencent.p177mm.protocal.protobuf.bfe;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e */
public final class C20062e {
    public HashMap<String, bfe> jQB = new HashMap();
    public LinkedList<bfb> jQC = new LinkedList();

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e$1 */
    public class C200631 implements C1224a {
        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(14344);
            C4990ab.m7417i("MicroMsg.BizTimeLineOftenReadReport", "often_read_bar_report CGI return, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(14344);
            return 0;
        }
    }

    public C20062e() {
        AppMethodBeat.m2504i(14345);
        AppMethodBeat.m2505o(14345);
    }
}
