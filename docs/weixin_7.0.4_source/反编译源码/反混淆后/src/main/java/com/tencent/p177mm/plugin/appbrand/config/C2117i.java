package com.tencent.p177mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.config.i */
public enum C2117i {
    ;

    /* renamed from: yZ */
    public static int m4328yZ(String str) {
        int i;
        AppMethodBeat.m2504i(101815);
        C42409s.ayO();
        new String[1][0] = "dynamicInfo";
        WxaAttributes zB = C42409s.m75085zB(str);
        String str2 = "MicroMsg.AppServiceSettingMMManager";
        String str3 = "readAppFileStorageMaxSizeInBytes, appId = %s, MaxLocalstorageSize = %d";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (zB == null) {
            i = -1;
        } else {
            i = zB.ayK().hib.bQM;
        }
        objArr[1] = Integer.valueOf(i);
        C4990ab.m7417i(str2, str3, objArr);
        if (zB != null) {
            i = zB.ayK().hib.bQM;
        } else {
            i = 5;
        }
        i *= 1048576;
        AppMethodBeat.m2505o(101815);
        return i;
    }

    /* renamed from: za */
    public static int m4329za(String str) {
        int i;
        AppMethodBeat.m2504i(101816);
        C42409s.ayO();
        new String[1][0] = "dynamicInfo";
        WxaAttributes zB = C42409s.m75085zB(str);
        String str2 = "MicroMsg.AppServiceSettingMMManager";
        String str3 = "readAppOpendataLocalStorageMaxSizeInBytes, appId = %s, MaxLocalstorageSize = %d";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (zB == null) {
            i = -1;
        } else {
            i = zB.ayK().hib.hid;
        }
        objArr[1] = Integer.valueOf(i);
        C4990ab.m7417i(str2, str3, objArr);
        if (zB != null) {
            i = zB.ayK().hib.hid;
        } else {
            i = 5;
        }
        i *= 1048576;
        AppMethodBeat.m2505o(101816);
        return i;
    }
}
