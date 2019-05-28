package com.tencent.p177mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.plugin.api.C10041a;
import com.tencent.p177mm.plugin.api.C45507b.C18991a;
import com.tencent.p177mm.plugin.api.recordView.C38092e;
import com.tencent.p177mm.plugin.mmsight.api.C39375b;
import com.tencent.p177mm.plugin.mmsight.api.C46074a;
import com.tencent.p177mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.mmsight.PluginMMSight */
public class PluginMMSight extends C7597f implements C7606a {
    public String name() {
        return "plugin-mmsight";
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(76426);
        if (c1681g != null) {
            C4990ab.m7417i("MicroMsg.PluginMMSight", "execute, process: %s", c1681g.eHT);
        }
        C39375b.ota = new C18991a();
        MMSightRecordView.osZ = new C38092e();
        C46074a.osX = new C10041a();
        pin(new C7485q(C34541e.class));
        AppMethodBeat.m2505o(76426);
    }
}
