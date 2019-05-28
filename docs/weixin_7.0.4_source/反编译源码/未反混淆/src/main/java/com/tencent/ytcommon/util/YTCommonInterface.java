package com.tencent.ytcommon.util;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ytcommon.auth.Auth;

public class YTCommonInterface {
    public static int preCheckAndInitWithLicenceStr(Context context, String str) {
        AppMethodBeat.i(26);
        int preCheckAndInitWithLicenceStr = Auth.preCheckAndInitWithLicenceStr(context, str);
        AppMethodBeat.o(26);
        return preCheckAndInitWithLicenceStr;
    }

    public static int initAuth(Context context, String str, int i, boolean z) {
        AppMethodBeat.i(27);
        int init = Auth.init(context, str, i, z);
        AppMethodBeat.o(27);
        return init;
    }
}
