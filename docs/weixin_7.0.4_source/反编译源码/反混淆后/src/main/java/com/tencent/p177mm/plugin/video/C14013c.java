package com.tencent.p177mm.plugin.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.math.BigInteger;

/* renamed from: com.tencent.mm.plugin.video.c */
public final class C14013c {
    public static String abR(String str) {
        AppMethodBeat.m2504i(50970);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(50970);
            return str2;
        }
        str2 = new BigInteger(Long.toBinaryString(C5046bo.getLong(str, 0)), 2).toString();
        AppMethodBeat.m2505o(50970);
        return str2;
    }
}
