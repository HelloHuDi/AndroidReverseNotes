package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.at.e;
import com.tencent.mm.at.o;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class ad {
    public static String nb(long j) {
        AppMethodBeat.i(30941);
        String h = h(o.ahl().fJ(j));
        if (h != null) {
            AppMethodBeat.o(30941);
            return h;
        }
        AppMethodBeat.o(30941);
        return null;
    }

    public static String nc(long j) {
        AppMethodBeat.i(30942);
        String h = h(o.ahl().fI(j));
        if (h != null) {
            AppMethodBeat.o(30942);
            return h;
        }
        AppMethodBeat.o(30942);
        return null;
    }

    private static String h(e eVar) {
        AppMethodBeat.i(30943);
        if (eVar != null) {
            String str;
            if (eVar.agQ()) {
                str = eVar.fDz;
                if (str != null && com.tencent.mm.vfs.e.ct(str)) {
                    AppMethodBeat.o(30943);
                    return str;
                }
            }
            str = o.ahl().q(eVar.fDz, null, null);
            if (str == null || !com.tencent.mm.vfs.e.ct(str)) {
                str = o.ahl().q(eVar.fDB, null, null);
                if (str != null && com.tencent.mm.vfs.e.ct(str)) {
                    AppMethodBeat.o(30943);
                    return str;
                }
            }
            AppMethodBeat.o(30943);
            return str;
        }
        AppMethodBeat.o(30943);
        return null;
    }

    public static String a(bi biVar, b bVar) {
        AppMethodBeat.i(30944);
        String str = "";
        if (!(bVar == null || bo.isNullOrNil(bVar.csD))) {
            com.tencent.mm.pluginsdk.model.app.b aiE = am.aUq().aiE(bVar.csD);
            if (aiE != null && aiE.bCR() && com.tencent.mm.vfs.e.ct(aiE.field_fileFullPath)) {
                str = aiE.field_fileFullPath;
            }
        }
        if (bo.isNullOrNil(str)) {
            if (biVar != null) {
                str = o.ahl().I(biVar.field_imgPath, true);
            }
            ab.d("MicroMsg.HistoryExportUtil", "try get thumb appmsg image path finish, %s", str);
            AppMethodBeat.o(30944);
        } else {
            ab.d("MicroMsg.HistoryExportUtil", "get hd appmsg image path ok, %s", str);
            AppMethodBeat.o(30944);
        }
        return str;
    }
}
