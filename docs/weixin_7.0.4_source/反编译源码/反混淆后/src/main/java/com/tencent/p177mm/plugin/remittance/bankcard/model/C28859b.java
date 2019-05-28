package com.tencent.p177mm.plugin.remittance.bankcard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.C23396hd;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Comparator;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.model.b */
public final class C28859b implements Comparator<C23396hd> {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        AppMethodBeat.m2504i(44490);
        C23396hd c23396hd = (C23396hd) obj;
        C23396hd c23396hd2 = (C23396hd) obj2;
        if (C5046bo.isNullOrNil(c23396hd.nuL) || C5046bo.isNullOrNil(c23396hd2.nuL)) {
            if (!(C5046bo.isNullOrNil(c23396hd.nuL) && C5046bo.isNullOrNil(c23396hd2.nuL))) {
                if (C5046bo.isNullOrNil(c23396hd.nuL)) {
                    AppMethodBeat.m2505o(44490);
                    return 1;
                } else if (C5046bo.isNullOrNil(c23396hd2.nuL)) {
                    AppMethodBeat.m2505o(44490);
                    return -1;
                }
            }
            AppMethodBeat.m2505o(44490);
            return 0;
        }
        char VL;
        char VL2;
        if (C5046bo.isNullOrNil(c23396hd.vJN)) {
            VL = C21625a.m33129VL(c23396hd.nuL);
        } else {
            VL = c23396hd.vJN.toUpperCase().charAt(0);
        }
        if (C5046bo.isNullOrNil(c23396hd2.vJN)) {
            VL2 = C21625a.m33129VL(c23396hd2.nuL);
        } else {
            VL2 = c23396hd2.vJN.toUpperCase().charAt(0);
        }
        if (VL < VL2) {
            AppMethodBeat.m2505o(44490);
            return -1;
        } else if (VL > VL2) {
            AppMethodBeat.m2505o(44490);
            return 1;
        } else {
            AppMethodBeat.m2505o(44490);
            return 0;
        }
    }
}
