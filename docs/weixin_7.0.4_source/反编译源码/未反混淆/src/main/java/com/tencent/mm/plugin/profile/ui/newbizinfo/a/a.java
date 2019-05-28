package com.tencent.mm.plugin.profile.ui.newbizinfo.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public final class a implements com.tencent.mm.pluginsdk.cmd.a {
    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(23932);
        if ("//usenewprofile".equals(strArr[0])) {
            SharedPreferences doB = ah.doB();
            if (strArr.length <= 1) {
                doB.edit().putBoolean("use_new_profile", true).commit();
                AppMethodBeat.o(23932);
            } else {
                String str2 = strArr[1];
                int i = -1;
                switch (str2.hashCode()) {
                    case 3569038:
                        if (str2.equals("true")) {
                            i = 0;
                            break;
                        }
                        break;
                    case 97196323:
                        if (str2.equals("false")) {
                            boolean i2 = true;
                            break;
                        }
                        break;
                }
                switch (i2) {
                    case 0:
                        doB.edit().putBoolean("use_new_profile", true).commit();
                        break;
                    case 1:
                        doB.edit().putBoolean("use_new_profile", false).commit();
                        break;
                }
                AppMethodBeat.o(23932);
            }
        } else {
            AppMethodBeat.o(23932);
        }
        return true;
    }
}
