package com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p1289a;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.a.a */
public final class C21496a implements C44041a {
    /* renamed from: a */
    public final boolean mo7165a(Context context, String[] strArr, String str) {
        AppMethodBeat.m2504i(23932);
        if ("//usenewprofile".equals(strArr[0])) {
            SharedPreferences doB = C4996ah.doB();
            if (strArr.length <= 1) {
                doB.edit().putBoolean("use_new_profile", true).commit();
                AppMethodBeat.m2505o(23932);
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
                AppMethodBeat.m2505o(23932);
            }
        } else {
            AppMethodBeat.m2505o(23932);
        }
        return true;
    }
}
