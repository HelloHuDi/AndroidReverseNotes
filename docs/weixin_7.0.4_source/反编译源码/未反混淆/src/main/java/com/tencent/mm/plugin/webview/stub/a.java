package com.tencent.mm.plugin.webview.stub;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsConfig;

public final class a {
    public static final boolean fq(Context context) {
        AppMethodBeat.i(7057);
        try {
            PackageInfo packageInfo = u.getPackageInfo(context, TbsConfig.APP_QQ);
            String str = "MicroMsg.ConstantsWebViewStub";
            String str2 = "isQQSupportShare(%s).";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(packageInfo != null);
            ab.d(str, str2, objArr);
            if (packageInfo != null) {
                AppMethodBeat.o(7057);
                return true;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.ConstantsWebViewStub", "exception has occurred in isQQSupportShare(), e : %s.", e.getMessage());
        }
        AppMethodBeat.o(7057);
        return false;
    }

    public static final boolean bl(Context context, String str) {
        AppMethodBeat.i(7058);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(7058);
            return false;
        }
        try {
            boolean z;
            PackageInfo packageInfo = u.getPackageInfo(context, "com.tencent.weread");
            String str2 = "MicroMsg.ConstantsWebViewStub";
            String str3 = "isWeReadSupportShare(%s).";
            Object[] objArr = new Object[1];
            if (packageInfo != null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            ab.d(str2, str3, objArr);
            if (packageInfo == null) {
                AppMethodBeat.o(7058);
                return false;
            } else if (Uri.parse(str).getHost().startsWith("mp.weixin.qq.com")) {
                if (packageInfo.versionCode > 2000812) {
                    AppMethodBeat.o(7058);
                    return true;
                }
                AppMethodBeat.o(7058);
                return false;
            } else {
                AppMethodBeat.o(7058);
                return false;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.ConstantsWebViewStub", "exception has occurred in isQzoneSupportShare(), e : %s.", e.getMessage());
        }
    }
}
