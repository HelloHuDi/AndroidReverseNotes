package com.tencent.mm.plugin.remittance.bankcard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.hd;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Comparator;

public final class b implements Comparator<hd> {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        AppMethodBeat.i(44490);
        hd hdVar = (hd) obj;
        hd hdVar2 = (hd) obj2;
        if (bo.isNullOrNil(hdVar.nuL) || bo.isNullOrNil(hdVar2.nuL)) {
            if (!(bo.isNullOrNil(hdVar.nuL) && bo.isNullOrNil(hdVar2.nuL))) {
                if (bo.isNullOrNil(hdVar.nuL)) {
                    AppMethodBeat.o(44490);
                    return 1;
                } else if (bo.isNullOrNil(hdVar2.nuL)) {
                    AppMethodBeat.o(44490);
                    return -1;
                }
            }
            AppMethodBeat.o(44490);
            return 0;
        }
        char VL;
        char VL2;
        if (bo.isNullOrNil(hdVar.vJN)) {
            VL = a.VL(hdVar.nuL);
        } else {
            VL = hdVar.vJN.toUpperCase().charAt(0);
        }
        if (bo.isNullOrNil(hdVar2.vJN)) {
            VL2 = a.VL(hdVar2.nuL);
        } else {
            VL2 = hdVar2.vJN.toUpperCase().charAt(0);
        }
        if (VL < VL2) {
            AppMethodBeat.o(44490);
            return -1;
        } else if (VL > VL2) {
            AppMethodBeat.o(44490);
            return 1;
        } else {
            AppMethodBeat.o(44490);
            return 0;
        }
    }
}
