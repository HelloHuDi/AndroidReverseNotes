package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class d {
    public List<String> phg = new ArrayList();

    public d() {
        AppMethodBeat.i(43979);
        Kh();
        AppMethodBeat.o(43979);
    }

    private void Kh() {
        AppMethodBeat.i(43980);
        this.phg.clear();
        g.RQ();
        String str = (String) g.RP().Ry().get(270340, (Object) "");
        ab.d("MicroMsg.MallNewsManager", "data : ".concat(String.valueOf(str)));
        for (String str2 : bo.P(str2.split(";"))) {
            if (!bo.isNullOrNil(str2)) {
                this.phg.add(str2);
            }
        }
        AppMethodBeat.o(43980);
    }

    public final boolean bZX() {
        AppMethodBeat.i(43981);
        ab.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.phg.size());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.phg) {
            if (!(bo.isNullOrNil(str) || str.contains(";"))) {
                stringBuffer.append(str);
            }
        }
        ab.d("MicroMsg.MallNewsManager", "save data  : " + stringBuffer.toString());
        g.RQ();
        g.RP().Ry().set(270340, stringBuffer.toString());
        AppMethodBeat.o(43981);
        return true;
    }
}
