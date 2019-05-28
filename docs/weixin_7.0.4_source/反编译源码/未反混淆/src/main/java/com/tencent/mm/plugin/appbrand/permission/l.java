package com.tencent.mm.plugin.appbrand.permission;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bo;

public final class l extends e {
    @SuppressLint({"WrongConstant"})
    public l(i iVar) {
        boolean z = false;
        int i = -bo.getInt(ae.giu, 0);
        if (d.vxs || (d.vxo & 255) <= 47) {
            z = true;
        }
        super(iVar, i, z);
        AppMethodBeat.i(132512);
        AppMethodBeat.o(132512);
    }
}
