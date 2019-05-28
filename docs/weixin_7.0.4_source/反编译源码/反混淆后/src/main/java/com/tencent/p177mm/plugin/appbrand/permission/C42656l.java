package com.tencent.p177mm.plugin.appbrand.permission;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.permission.l */
public final class C42656l extends C33491e {
    @SuppressLint({"WrongConstant"})
    public C42656l(C6750i c6750i) {
        boolean z = false;
        int i = -C5046bo.getInt(C1947ae.giu, 0);
        if (C7243d.vxs || (C7243d.vxo & 255) <= 47) {
            z = true;
        }
        super(c6750i, i, z);
        AppMethodBeat.m2504i(132512);
        AppMethodBeat.m2505o(132512);
    }
}
