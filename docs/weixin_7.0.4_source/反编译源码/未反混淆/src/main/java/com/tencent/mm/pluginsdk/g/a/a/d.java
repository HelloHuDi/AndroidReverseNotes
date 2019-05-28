package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.g.a.b.c;
import com.tencent.mm.pluginsdk.g.a.b.e;
import com.tencent.mm.pluginsdk.g.a.c.j;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.pluginsdk.g.a.c.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class d extends a<c> {
    public d(c cVar) {
        super(cVar);
    }

    public final String awa() {
        return "CheckResUpdate";
    }

    public final boolean gh(long j) {
        AppMethodBeat.i(79503);
        if (((c) awh()).fileSize <= 0 || ((c) awh()).fileSize == com.tencent.mm.pluginsdk.g.a.d.a.ek(getFilePath()) + j) {
            boolean gh = super.gh(j);
            AppMethodBeat.o(79503);
            return gh;
        }
        AppMethodBeat.o(79503);
        return false;
    }

    public final boolean awg() {
        AppMethodBeat.i(79504);
        if (super.awg()) {
            j.z(((c) awh()).vdK, 12);
            AppMethodBeat.o(79504);
            return true;
        }
        j.z(((c) awh()).vdK, 27);
        AppMethodBeat.o(79504);
        return false;
    }

    public final m a(j jVar) {
        AppMethodBeat.i(79505);
        c cVar = (c) awh();
        String aiX = i.aiX(cVar.vdC);
        String str = cVar.cvZ;
        m mVar;
        if (cVar.ufy && bo.nullAsNil(g.cz(i.aiX(cVar.vdC))).equals(str)) {
            ab.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "file already cached and valid, send complete status");
            mVar = new m(cVar, com.tencent.mm.pluginsdk.g.a.d.a.ek(aiX));
            AppMethodBeat.o(79505);
            return mVar;
        } else if (!bo.cb(((c) awh()).veh) && com.tencent.mm.pluginsdk.g.a.d.a.D(i.aiX(((c) awh()).vdC), ((c) awh()).veh) && bo.nullAsNil(g.cz(i.aiX(((c) awh()).vdC))).equals(((c) awh()).cvZ)) {
            m mVar2 = new m((l) awh(), com.tencent.mm.pluginsdk.g.a.d.a.ek(i.aiX(((c) awh()).vdC)));
            AppMethodBeat.o(79505);
            return mVar2;
        } else {
            m a = super.a(jVar);
            ab.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: network get over, received response = ".concat(String.valueOf(a)), cVar.vdC);
            if (a == null) {
                mVar = new m("CheckResUpdate", dib(), getURL(), getFilePath(), 0, "", new e());
                AppMethodBeat.o(79505);
                return mVar;
            }
            if (a.status == 2) {
                if (bo.isNullOrNil(((c) awh()).cvZ) || !((c) awh()).cvZ.equals(g.cz(getFilePath()))) {
                    ab.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file invalid, md5 not match", cVar.vdC);
                    mVar = new m("CheckResUpdate", dib(), getURL(), getFilePath(), a.aHW, a.bqF, new c());
                    AppMethodBeat.o(79505);
                    return mVar;
                }
                ab.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file valid, md5 ok", cVar.vdC);
            }
            AppMethodBeat.o(79505);
            return a;
        }
    }
}
