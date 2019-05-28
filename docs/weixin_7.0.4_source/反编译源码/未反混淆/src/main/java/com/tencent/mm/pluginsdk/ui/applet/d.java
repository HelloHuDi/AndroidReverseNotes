package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.a.j;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.sdk.platformtools.bo;

public final class d implements p {
    public final boolean ajy(String str) {
        AppMethodBeat.i(11682);
        boolean kq = f.kq(str);
        AppMethodBeat.o(11682);
        return kq;
    }

    public final Object ajz(String str) {
        AppMethodBeat.i(11683);
        Object cH = z.aeV().cH(str);
        if (cH == null || bo.isNullOrNil(cH.field_userId) || !cH.field_userId.equals(str)) {
            cH = new j();
            cH.field_userId = str;
        }
        AppMethodBeat.o(11683);
        return cH;
    }

    public final c ajA(String str) {
        AppMethodBeat.i(11684);
        a aVar = new a();
        aVar.ePK = e.rz(str);
        aVar.ePH = true;
        aVar.ePZ = true;
        aVar.ePT = R.raw.default_avatar;
        c ahG = aVar.ahG();
        AppMethodBeat.o(11684);
        return ahG;
    }

    public final String cu(Object obj) {
        return ((j) obj).field_userName;
    }

    public final String cv(Object obj) {
        return ((j) obj).field_headImageUrl;
    }

    public final String cw(Object obj) {
        return ((j) obj).field_userId;
    }
}
