package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public enum i {
    ;

    public static int yZ(String str) {
        int i;
        AppMethodBeat.i(101815);
        s.ayO();
        new String[1][0] = "dynamicInfo";
        WxaAttributes zB = s.zB(str);
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
        ab.i(str2, str3, objArr);
        if (zB != null) {
            i = zB.ayK().hib.bQM;
        } else {
            i = 5;
        }
        i *= 1048576;
        AppMethodBeat.o(101815);
        return i;
    }

    public static int za(String str) {
        int i;
        AppMethodBeat.i(101816);
        s.ayO();
        new String[1][0] = "dynamicInfo";
        WxaAttributes zB = s.zB(str);
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
        ab.i(str2, str3, objArr);
        if (zB != null) {
            i = zB.ayK().hib.hid;
        } else {
            i = 5;
        }
        i *= 1048576;
        AppMethodBeat.o(101816);
        return i;
    }
}
