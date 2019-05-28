package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.p.c.a;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;

public final class c implements a {
    public final String cUp() {
        AppMethodBeat.i(26286);
        ctv ctv = a.cUn().tXt.tXK.tYz;
        String str;
        if (ctv != null) {
            str = ctv.xqv + IOUtils.LINE_SEPARATOR_UNIX + ctv.xqw + IOUtils.LINE_SEPARATOR_UNIX + ctv.xqx;
            AppMethodBeat.o(26286);
            return str;
        }
        str = "Not Connect";
        AppMethodBeat.o(26286);
        return str;
    }

    public final void cUq() {
        AppMethodBeat.i(26287);
        a.cUn().tXz.a(new com.tencent.mm.plugin.wear.model.f.a());
        AppMethodBeat.o(26287);
    }

    public final boolean cUr() {
        String str = null;
        AppMethodBeat.i(26288);
        ctv ctv = a.cUn().tXt.tXK.tYz;
        if (bo.isNullOrNil(str) && bo.isNullOrNil(str)) {
            if (ctv != null) {
                AppMethodBeat.o(26288);
                return true;
            }
            AppMethodBeat.o(26288);
            return false;
        } else if (bo.isNullOrNil(str)) {
            if (ctv == null || !str.equals("gh_43f2581f6fd6")) {
                AppMethodBeat.o(26288);
                return false;
            }
            AppMethodBeat.o(26288);
            return true;
        } else if (bo.isNullOrNil(str)) {
            if (ctv == null || !str.equals(ctv.xqs)) {
                AppMethodBeat.o(26288);
                return false;
            }
            AppMethodBeat.o(26288);
            return true;
        } else if (ctv != null && str.equals("gh_43f2581f6fd6") && str.equals(ctv.xqs)) {
            AppMethodBeat.o(26288);
            return true;
        } else {
            AppMethodBeat.o(26288);
            return false;
        }
    }
}
