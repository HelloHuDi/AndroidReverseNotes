package com.tencent.mm.plugin.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.na;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.record.a.a;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.plugin.record.b.i;
import com.tencent.mm.plugin.record.b.j;
import com.tencent.mm.plugin.record.b.m;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.record.b.q;
import com.tencent.mm.plugin.record.b.r;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.Iterator;

public class PluginRecord extends f implements b, c, a {
    private g pIZ;
    private e pJa;
    private q pJb = null;
    private i pJc = null;
    private r pJd = new r();
    private com.tencent.mm.sdk.b.c pJe = new com.tencent.mm.sdk.b.c<na>() {
        {
            AppMethodBeat.i(135608);
            this.xxI = na.class.getName().hashCode();
            AppMethodBeat.o(135608);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(135609);
            na naVar = (na) bVar;
            String str = naVar.cJc.cHz;
            long j = naVar.cJc.cuQ;
            com.tencent.mm.protocal.b.a.c VI = n.VI(str);
            str = "";
            Iterator it = VI.fjr.iterator();
            while (true) {
                String str2 = str;
                if (it.hasNext()) {
                    str = str2 + n.c((aar) it.next(), j) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D;
                } else {
                    naVar.cJd.cJe = str2;
                    AppMethodBeat.o(135609);
                    return true;
                }
            }
        }
    };

    public PluginRecord() {
        AppMethodBeat.i(135610);
        AppMethodBeat.o(135610);
    }

    private static void checkDir() {
        AppMethodBeat.i(135611);
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.RQ();
        File file = new File(stringBuilder.append(com.tencent.mm.kernel.g.RP().eJM).append("record/").toString());
        if (!(file.exists() && file.isDirectory())) {
            ab.d("MicroMsg.PluginRecord", "record stg dir[%s] not exsit, create it");
            file.mkdirs();
        }
        AppMethodBeat.o(135611);
    }

    public void parallelsDependency() {
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        AppMethodBeat.i(135612);
        this.pIZ = new m(com.tencent.mm.kernel.g.RP().eJN);
        this.pJa = new j(com.tencent.mm.kernel.g.RP().eJN);
        ab.i("MicroMsg.PluginRecord", "on account post reset");
        com.tencent.mm.sdk.b.a.xxA.c(this.pJd);
        com.tencent.mm.sdk.b.a.xxA.c(this.pJe);
        checkDir();
        getRecordMsgService().a(null);
        ab.i("MicroMsg.PluginRecord", "onAccountInitialized start recordMsgSendService");
        AppMethodBeat.o(135612);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(135613);
        ab.d("MicroMsg.PluginRecord", "on account post release");
        com.tencent.mm.sdk.b.a.xxA.d(this.pJd);
        com.tencent.mm.sdk.b.a.xxA.d(this.pJe);
        if (this.pJb != null) {
            d dVar = this.pJb;
            dVar.finish();
            com.tencent.mm.kernel.g.RO().eJo.b(632, (com.tencent.mm.ai.f) dVar);
            ((a) com.tencent.mm.kernel.g.M(a.class)).getRecordMsgCDNStorage().b(dVar);
        }
        if (this.pJc != null) {
            this.pJc.finish();
        }
        AppMethodBeat.o(135613);
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    public e getRecordMsgCDNStorage() {
        return this.pJa;
    }

    public g getRecordMsgInfoStorage() {
        return this.pIZ;
    }

    public g getRecordMsgStorage() {
        AppMethodBeat.i(135614);
        g recordMsgInfoStorage = getRecordMsgInfoStorage();
        AppMethodBeat.o(135614);
        return recordMsgInfoStorage;
    }

    public q getRecordMsgService() {
        AppMethodBeat.i(135615);
        com.tencent.mm.kernel.g.RN().QU();
        if (this.pJb == null) {
            this.pJb = new q();
        }
        q qVar = this.pJb;
        AppMethodBeat.o(135615);
        return qVar;
    }

    public i getRecordMsgCDNService() {
        AppMethodBeat.i(135616);
        com.tencent.mm.kernel.g.RN().QU();
        if (this.pJc == null) {
            this.pJc = new i();
        }
        i iVar = this.pJc;
        AppMethodBeat.o(135616);
        return iVar;
    }
}
