package com.tencent.p177mm.plugin.webview.stub;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsConfig;

/* renamed from: com.tencent.mm.plugin.webview.stub.a */
public final class C14550a {
    /* renamed from: fq */
    public static final boolean m22752fq(Context context) {
        AppMethodBeat.m2504i(7057);
        try {
            PackageInfo packageInfo = C30152u.getPackageInfo(context, TbsConfig.APP_QQ);
            String str = "MicroMsg.ConstantsWebViewStub";
            String str2 = "isQQSupportShare(%s).";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(packageInfo != null);
            C4990ab.m7411d(str, str2, objArr);
            if (packageInfo != null) {
                AppMethodBeat.m2505o(7057);
                return true;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ConstantsWebViewStub", "exception has occurred in isQQSupportShare(), e : %s.", e.getMessage());
        }
        AppMethodBeat.m2505o(7057);
        return false;
    }

    /* renamed from: bl */
    public static final boolean m22751bl(Context context, String str) {
        AppMethodBeat.m2504i(7058);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(7058);
            return false;
        }
        try {
            boolean z;
            PackageInfo packageInfo = C30152u.getPackageInfo(context, "com.tencent.weread");
            String str2 = "MicroMsg.ConstantsWebViewStub";
            String str3 = "isWeReadSupportShare(%s).";
            Object[] objArr = new Object[1];
            if (packageInfo != null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            C4990ab.m7411d(str2, str3, objArr);
            if (packageInfo == null) {
                AppMethodBeat.m2505o(7058);
                return false;
            } else if (Uri.parse(str).getHost().startsWith("mp.weixin.qq.com")) {
                if (packageInfo.versionCode > 2000812) {
                    AppMethodBeat.m2505o(7058);
                    return true;
                }
                AppMethodBeat.m2505o(7058);
                return false;
            } else {
                AppMethodBeat.m2505o(7058);
                return false;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ConstantsWebViewStub", "exception has occurred in isQzoneSupportShare(), e : %s.", e.getMessage());
        }
    }
}
