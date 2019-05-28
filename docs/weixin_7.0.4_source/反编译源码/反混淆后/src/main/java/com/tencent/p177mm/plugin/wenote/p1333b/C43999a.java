package com.tencent.p177mm.plugin.wenote.p1333b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wenote.b.a */
public final class C43999a {
    public static boolean dfJ() {
        int i;
        AppMethodBeat.m2504i(26976);
        String str = (String) C18624c.abi().mo17131ll("100352").dru().get("Close");
        if (C5046bo.isNullOrNil(str)) {
            i = 0;
        } else {
            i = C5046bo.getInt(str, 0);
        }
        if (i == 0) {
            AppMethodBeat.m2505o(26976);
            return true;
        }
        AppMethodBeat.m2505o(26976);
        return false;
    }
}
