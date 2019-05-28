package com.tencent.p177mm.plugin.comm;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.p612ui.p627e.p1575a.C40860b;
import com.tencent.p177mm.p612ui.p627e.p1575a.C46685a;
import com.tencent.p177mm.plugin.C37991a;
import com.tencent.p177mm.plugin.auth.p1239a.C19934b;
import com.tencent.p177mm.plugin.comm.p1247a.C27697a;
import com.tencent.p177mm.plugin.p1140r.C16841a;
import com.tencent.p177mm.plugin.p1506t.C35280a;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.plugin.p1614i.C46031b;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.plugin.p930c.C20118a;
import com.tencent.p177mm.plugin.p976g.C12074a;
import com.tencent.p177mm.plugin.p980h.C12217a;
import com.tencent.p177mm.plugin.p991m.C12478a;
import com.tencent.p177mm.plugin.p991m.C28464b;
import com.tencent.p177mm.plugin.p991m.p1488a.C34506a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C23240o;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;

/* renamed from: com.tencent.mm.plugin.comm.PluginComm */
public class PluginComm extends C7597f implements C9562c, C27697a {

    /* renamed from: com.tencent.mm.plugin.comm.PluginComm$1 */
    class C313491 implements C40860b {
        C313491() {
        }

        /* renamed from: b */
        public final void mo51299b(ImageView imageView, String str) {
            AppMethodBeat.m2504i(79087);
            C40460b.m69434b(imageView, str);
            AppMethodBeat.m2505o(79087);
        }
    }

    public void configure(C1681g c1681g) {
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(79088);
        if (c1681g.mo5181SG()) {
            pin(C37991a.aob());
            pin(C12074a.beP());
            pin(C12217a.bic());
            pin(C43217c.bGE());
            pin(C46031b.bGD());
            pin(C35280a.bZt());
            pin(C28464b.bOh());
            pin(C20118a.ask());
            pin(C34832a.bYF());
            pin(C16841a.bVs());
            pin(C23240o.vfu);
            C1720g.m3542a(C34506a.class, new C12478a());
            ((C19934b) C1720g.m3530M(C19934b.class)).addHandleAuthResponse(C12074a.beP());
            C46685a.m88421a(new C313491());
        }
        AppMethodBeat.m2505o(79088);
    }

    public void onAccountInitialized(C1705c c1705c) {
    }

    public void onAccountRelease() {
    }
}
