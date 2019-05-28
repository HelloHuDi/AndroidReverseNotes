package com.tencent.p177mm.plugin.choosemsgfile;

import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.choosemsgfile.compat.C9236a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.plugin.choosemsgfile.p1644a.C45806a;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.C27638a;
import com.tencent.p177mm.plugin.comm.p1247a.C27697a;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.PluginChooseMsgFile */
public class PluginChooseMsgFile extends C7597f implements C45806a {
    public void installed() {
        AppMethodBeat.m2504i(54246);
        C45124d.m82925d("MicroMsg.PluginChooseMsgFile", "installed");
        alias(C45806a.class);
        AppMethodBeat.m2505o(54246);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(54247);
        C45124d.m82925d("MicroMsg.PluginChooseMsgFile", "execute");
        C1720g.m3542a(C9236a.class, new C27638a());
        AppMethodBeat.m2505o(54247);
    }

    public void dependency() {
        AppMethodBeat.m2504i(54248);
        dependsOn(C27697a.class);
        AppMethodBeat.m2505o(54248);
    }

    public String name() {
        return "plugin-choosemsgfile";
    }
}
