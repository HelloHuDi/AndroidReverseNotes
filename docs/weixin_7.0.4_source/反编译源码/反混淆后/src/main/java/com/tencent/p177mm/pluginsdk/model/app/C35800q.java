package com.tencent.p177mm.pluginsdk.model.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.pluginsdk.permission.C14900a;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.pluginsdk.permission.C35808d;
import com.tencent.p177mm.sdk.platformtools.C15429k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;

/* renamed from: com.tencent.mm.pluginsdk.model.app.q */
public final class C35800q {
    public static String aiQ(String str) {
        AppMethodBeat.m2504i(79351);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.toLowerCase());
        stringBuffer.append("mMHc ItnStR");
        String x = C1178g.m2591x(stringBuffer.toString().getBytes());
        AppMethodBeat.m2505o(79351);
        return x;
    }

    /* renamed from: a */
    private static void m58696a(final Context context, final Intent intent, final C14900a c14900a, boolean z) {
        AppMethodBeat.m2504i(79352);
        C4990ab.m7416i("MicroMsg.ApplicationUtil", "installApp");
        if (z && Build.BRAND.equals("vivo")) {
            intent.putExtra("installDir", true);
            C4990ab.m7416i("MicroMsg.ApplicationUtil", "is vivo, try to prevent the interception");
        }
        try {
            if (VERSION.SDK_INT < 26 || context.getPackageManager().canRequestPackageInstalls()) {
                C4990ab.m7416i("MicroMsg.ApplicationUtil", "install directly");
                context.startActivity(intent);
                if (c14900a != null) {
                    c14900a.mo9734dT(true);
                }
                AppMethodBeat.m2505o(79352);
                return;
            }
            C4990ab.m7416i("MicroMsg.ApplicationUtil", "request install apk permission");
            C35805b.m58705a(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + context.getPackageName())), C4996ah.getContext().getString(C25738R.string.dc8), C4996ah.getContext().getString(C25738R.string.cdy), new C35808d() {
                /* renamed from: Cp */
                public final void mo8477Cp(int i) {
                    AppMethodBeat.m2504i(79350);
                    C4990ab.m7417i("MicroMsg.ApplicationUtil", "onRequestPermissionsResult, resultCode = %d", Integer.valueOf(i));
                    if (i == -1) {
                        try {
                            context.startActivity(intent);
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.ApplicationUtil", e, "install app failed! %s", intent);
                        }
                        if (c14900a != null) {
                            c14900a.mo9734dT(true);
                            AppMethodBeat.m2505o(79350);
                            return;
                        }
                    }
                    C4990ab.m7412e("MicroMsg.ApplicationUtil", "no get!!!");
                    Toast.makeText(C4996ah.getContext(), C25738R.string.d7j, 1).show();
                    if (c14900a != null) {
                        c14900a.mo9734dT(false);
                    }
                    AppMethodBeat.m2505o(79350);
                }
            });
            AppMethodBeat.m2505o(79352);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ApplicationUtil", e, "install app failed! %s", intent);
            if (c14900a != null) {
                c14900a.mo9734dT(false);
            }
        }
    }

    /* renamed from: a */
    public static void m58698a(Context context, File file, C14900a c14900a, boolean z) {
        AppMethodBeat.m2504i(79353);
        Intent intent = new Intent("android.intent.action.VIEW");
        C15429k.m23713a(context, intent, file, "application/vnd.android.package-archive");
        intent.addFlags(268435456);
        C35800q.m58696a(context, intent, c14900a, z);
        AppMethodBeat.m2505o(79353);
    }

    /* renamed from: a */
    public static void m58697a(Context context, Uri uri, C14900a c14900a) {
        AppMethodBeat.m2504i(79354);
        Intent intent = new Intent("android.intent.action.VIEW");
        C15429k.m23712a(context, intent, uri, "application/vnd.android.package-archive");
        intent.addFlags(268435456);
        C35800q.m58696a(context, intent, c14900a, false);
        AppMethodBeat.m2505o(79354);
    }

    /* renamed from: by */
    public static boolean m58699by(Context context, String str) {
        AppMethodBeat.m2504i(79355);
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW", parse);
        intent.addFlags(268435456);
        if (C35800q.getPackageInfo(context, "com.android.vending") != null) {
            C4990ab.m7419v("MicroMsg.ApplicationUtil", "installAppWithGP, gp is installed, url = %s", str);
            intent.setPackage("com.android.vending");
        } else {
            C4990ab.m7419v("MicroMsg.ApplicationUtil", "installAppWithGP, gp is not installed, url = %s", str);
        }
        try {
            context.startActivity(intent);
            AppMethodBeat.m2505o(79355);
            return true;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ApplicationUtil", "installAppWithGP first, ex = %s", e.getMessage());
            try {
                intent = new Intent("android.intent.action.VIEW", parse);
                intent.addFlags(268435456);
                context.startActivity(intent);
                AppMethodBeat.m2505o(79355);
                return true;
            } catch (Exception e2) {
                C4990ab.m7413e("MicroMsg.ApplicationUtil", "installAppWithGP second, ex = %s", e2.getMessage());
                AppMethodBeat.m2505o(79355);
                return false;
            }
        }
    }

    /* renamed from: u */
    public static boolean m58700u(Context context, String str) {
        AppMethodBeat.m2504i(79356);
        if (C35800q.getPackageInfo(context, str) != null) {
            AppMethodBeat.m2505o(79356);
            return true;
        }
        AppMethodBeat.m2505o(79356);
        return false;
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        PackageInfo packageInfo = null;
        AppMethodBeat.m2504i(79357);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.ApplicationUtil", "getPackageInfo, packageName is null");
            AppMethodBeat.m2505o(79357);
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (NameNotFoundException e) {
                C4990ab.m7420w("MicroMsg.ApplicationUtil", "app not installed, packageName = ".concat(String.valueOf(str)));
            }
            AppMethodBeat.m2505o(79357);
        }
        return packageInfo;
    }

    public static String aiR(String str) {
        String str2 = null;
        AppMethodBeat.m2504i(79358);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(79358);
        } else {
            try {
                PackageInfo packageArchiveInfo = C4996ah.getContext().getPackageManager().getPackageArchiveInfo(str, 0);
                if (packageArchiveInfo == null) {
                    RuntimeException runtimeException = new RuntimeException("info is null; ".concat(String.valueOf(str)));
                    AppMethodBeat.m2505o(79358);
                    throw runtimeException;
                }
                C4990ab.m7417i("MicroMsg.ApplicationUtil", "get package name from archive filepath  :%s, package name is : %s", str, packageArchiveInfo.packageName);
                str2 = packageArchiveInfo.packageName;
                AppMethodBeat.m2505o(79358);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.ApplicationUtil", "get package name from archive file path, failed : %s", e.getMessage());
                AppMethodBeat.m2505o(79358);
            }
        }
        return str2;
    }

    public static int aiS(String str) {
        int i = 0;
        AppMethodBeat.m2504i(79359);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(79359);
        } else {
            try {
                PackageInfo packageArchiveInfo = C4996ah.getContext().getPackageManager().getPackageArchiveInfo(str, 0);
                if (packageArchiveInfo == null) {
                    RuntimeException runtimeException = new RuntimeException("info is null; ".concat(String.valueOf(str)));
                    AppMethodBeat.m2505o(79359);
                    throw runtimeException;
                }
                C4990ab.m7417i("MicroMsg.ApplicationUtil", "get package version code from archive filepath  :%s, package version code is : %d", str, Integer.valueOf(packageArchiveInfo.versionCode));
                i = packageArchiveInfo.versionCode;
                AppMethodBeat.m2505o(79359);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.ApplicationUtil", "get package version code from archive file path, failed : %s", e.getMessage());
                AppMethodBeat.m2505o(79359);
            }
        }
        return i;
    }
}
