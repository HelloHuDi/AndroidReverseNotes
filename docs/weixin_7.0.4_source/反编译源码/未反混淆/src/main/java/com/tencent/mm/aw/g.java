package com.tencent.mm.aw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.bo;

public final class g extends f {
    public static e a(String str, TimeLineObject timeLineObject, int i) {
        String str2 = null;
        AppMethodBeat.i(108010);
        if (timeLineObject == null || timeLineObject.xfI == null || timeLineObject.xfI.wbK == null || timeLineObject.xfI.wbK.size() <= 0) {
            AppMethodBeat.o(108010);
            return null;
        }
        bau bau = (bau) timeLineObject.xfI.wbK.get(0);
        if (bau == null) {
            AppMethodBeat.o(108010);
            return null;
        }
        e eVar = new e();
        eVar.fJS = i;
        eVar.fJU = timeLineObject.Id;
        eVar.fJV = 0.0f;
        eVar.fJY = "";
        eVar.fJZ = bau.wEH;
        eVar.fKe = null;
        eVar.fJT = 1;
        eVar.fKd = null;
        eVar.fJW = bau.Title;
        eVar.fJX = bau.Desc;
        if (timeLineObject.xfI != null) {
            str2 = timeLineObject.xfI.Url;
        }
        eVar.fKc = str2;
        eVar.fKb = bau.wEL;
        eVar.fKa = bau.Url;
        eVar.fKi = bau.wEI;
        eVar.fKk = bau.Id;
        eVar.fKf = str;
        eVar.fKh = timeLineObject.xfH.Id;
        eVar.fKo = timeLineObject.jBB;
        AppMethodBeat.o(108010);
        return eVar;
    }

    public static e a(b bVar, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(108011);
        if (bVar == null) {
            AppMethodBeat.o(108011);
            return null;
        }
        e eVar = new e();
        eVar.fJS = 0;
        eVar.fJU = str;
        eVar.fJV = 0.0f;
        eVar.fJY = "";
        eVar.fJZ = str2;
        eVar.fKe = str4;
        eVar.fJT = 1;
        eVar.fKd = null;
        eVar.fJW = bVar.title;
        eVar.fJX = bVar.description;
        eVar.fKc = bVar.url;
        eVar.fKb = !bo.isNullOrNil(bVar.fgN) ? bVar.fgN : bVar.fgn;
        eVar.fKa = bVar.fgM;
        eVar.fKh = bVar.appId;
        eVar.fKf = str3;
        AppMethodBeat.o(108011);
        return eVar;
    }
}
