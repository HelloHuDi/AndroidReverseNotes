package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.api.b.a;
import com.tencent.mm.plugin.api.recordView.e;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.b;
import com.tencent.mm.sdk.platformtools.ab;

public class PluginMMSight extends f implements a {
    public String name() {
        return "plugin-mmsight";
    }

    public void execute(g gVar) {
        AppMethodBeat.i(76426);
        if (gVar != null) {
            ab.i("MicroMsg.PluginMMSight", "execute, process: %s", gVar.eHT);
        }
        b.ota = new a();
        MMSightRecordView.osZ = new e();
        com.tencent.mm.plugin.mmsight.api.a.osX = new com.tencent.mm.plugin.api.a();
        pin(new q(e.class));
        AppMethodBeat.o(76426);
    }
}
