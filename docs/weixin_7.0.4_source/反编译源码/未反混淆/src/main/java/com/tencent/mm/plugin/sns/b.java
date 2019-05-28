package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fg;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

public final class b extends c<fg> {
    public b() {
        AppMethodBeat.i(35597);
        this.xxI = fg.class.getName().hashCode();
        AppMethodBeat.o(35597);
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        boolean z = false;
        AppMethodBeat.i(35598);
        fg fgVar = (fg) bVar;
        if (!(fgVar instanceof fg)) {
            ab.f("MicroMsg.ExtGetSnsDataEventListener", "mismatched event");
            AppMethodBeat.o(35598);
            return false;
        } else if (fgVar.cyJ.cyL == null) {
            AppMethodBeat.o(35598);
            return false;
        } else {
            n nVar = new n();
            nVar.d(fgVar.cyJ.cyL);
            if (nVar.reX <= 0) {
                ab.e("MicroMsg.ExtGetSnsDataEventListener", "sns == null || sns.getLocalid()<=0");
                AppMethodBeat.o(35598);
                return false;
            }
            TimeLineObject cqu = nVar.cqu();
            fgVar.cyK.cyQ = 0;
            fgVar.cyK.cyU = 0;
            fgVar.cyK.cyV = 0;
            fgVar.cyK.cyS = new LinkedList();
            fgVar.cyK.cyT = new LinkedList();
            if (cqu.xfI != null) {
                fgVar.cyK.cyQ = cqu.xfI.wbJ;
                if (cqu.xfI.wbJ != 1 && cqu.xfI.wbJ != 7 && cqu.xfI.wbJ != 8) {
                    fgVar.cyK.cyS.add(cqu.xfI.Url);
                } else if (cqu.xfI.wbK != null) {
                    while (true) {
                        boolean z2 = z;
                        if (z2 >= cqu.xfI.wbK.size()) {
                            break;
                        }
                        List list = fgVar.cyK.cyS;
                        af.cnC();
                        list.add(g.r((bau) cqu.xfI.wbK.get(z2)));
                        list = fgVar.cyK.cyT;
                        af.cnC();
                        list.add(g.s((bau) cqu.xfI.wbK.get(z2)));
                        if (!(z2 || cqu.xfI.wbK.get(z2) == null)) {
                            fgVar.cyK.cyU = (int) ((bau) cqu.xfI.wbK.get(z2)).wEK.wFx;
                            fgVar.cyK.cyV = (int) ((bau) cqu.xfI.wbK.get(z2)).wEK.wFy;
                        }
                        z = z2 + 1;
                    }
                }
            }
            fgVar.cyK.cyR = fgVar.cyK.cyS.size();
            fgVar.cyK.cyN = nVar.reX;
            fgVar.cyK.cyM = nVar.field_userName;
            fgVar.cyK.cyO = cqu.xfF;
            fgVar.cyK.cyP = (long) cqu.pcX;
            AppMethodBeat.o(35598);
            return true;
        }
    }
}
