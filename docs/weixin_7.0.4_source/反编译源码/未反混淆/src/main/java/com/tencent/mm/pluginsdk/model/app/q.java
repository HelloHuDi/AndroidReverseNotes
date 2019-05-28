package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.pluginsdk.permission.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import java.io.File;

public final class q {
    public static String aiQ(String str) {
        AppMethodBeat.i(79351);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.toLowerCase());
        stringBuffer.append("mMHc ItnStR");
        String x = g.x(stringBuffer.toString().getBytes());
        AppMethodBeat.o(79351);
        return x;
    }

    private static void a(final Context context, final Intent intent, final a aVar, boolean z) {
        AppMethodBeat.i(79352);
        ab.i("MicroMsg.ApplicationUtil", "installApp");
        if (z && Build.BRAND.equals("vivo")) {
            intent.putExtra("installDir", true);
            ab.i("MicroMsg.ApplicationUtil", "is vivo, try to prevent the interception");
        }
        try {
            if (VERSION.SDK_INT < 26 || context.getPackageManager().canRequestPackageInstalls()) {
                ab.i("MicroMsg.ApplicationUtil", "install directly");
                context.startActivity(intent);
                if (aVar != null) {
                    aVar.dT(true);
                }
                AppMethodBeat.o(79352);
                return;
            }
            ab.i("MicroMsg.ApplicationUtil", "request install apk permission");
            b.a(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + context.getPackageName())), ah.getContext().getString(R.string.dc8), ah.getContext().getString(R.string.cdy), new d() {
                public final void Cp(int i) {
                    AppMethodBeat.i(79350);
                    ab.i("MicroMsg.ApplicationUtil", "onRequestPermissionsResult, resultCode = %d", Integer.valueOf(i));
                    if (i == -1) {
                        try {
                            context.startActivity(intent);
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.ApplicationUtil", e, "install app failed! %s", intent);
                        }
                        if (aVar != null) {
                            aVar.dT(true);
                            AppMethodBeat.o(79350);
                            return;
                        }
                    }
                    ab.e("MicroMsg.ApplicationUtil", "no get!!!");
                    Toast.makeText(ah.getContext(), R.string.d7j, 1).show();
                    if (aVar != null) {
                        aVar.dT(false);
                    }
                    AppMethodBeat.o(79350);
                }
            });
            AppMethodBeat.o(79352);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ApplicationUtil", e, "install app failed! %s", intent);
            if (aVar != null) {
                aVar.dT(false);
            }
        }
    }

    public static void a(Context context, File file, a aVar, boolean z) {
        AppMethodBeat.i(79353);
        Intent intent = new Intent("android.intent.action.VIEW");
        k.a(context, intent, file, "application/vnd.android.package-archive");
        intent.addFlags(268435456);
        a(context, intent, aVar, z);
        AppMethodBeat.o(79353);
    }

    public static void a(Context context, Uri uri, a aVar) {
        AppMethodBeat.i(79354);
        Intent intent = new Intent("android.intent.action.VIEW");
        k.a(context, intent, uri, "application/vnd.android.package-archive");
        intent.addFlags(268435456);
        a(context, intent, aVar, false);
        AppMethodBeat.o(79354);
    }

    public static boolean by(Context context, String str) {
        AppMethodBeat.i(79355);
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW", parse);
        intent.addFlags(268435456);
        if (getPackageInfo(context, "com.android.vending") != null) {
            ab.v("MicroMsg.ApplicationUtil", "installAppWithGP, gp is installed, url = %s", str);
            intent.setPackage("com.android.vending");
        } else {
            ab.v("MicroMsg.ApplicationUtil", "installAppWithGP, gp is not installed, url = %s", str);
        }
        try {
            context.startActivity(intent);
            AppMethodBeat.o(79355);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.ApplicationUtil", "installAppWithGP first, ex = %s", e.getMessage());
            try {
                intent = new Intent("android.intent.action.VIEW", parse);
                intent.addFlags(268435456);
                context.startActivity(intent);
                AppMethodBeat.o(79355);
                return true;
            } catch (Exception e2) {
                ab.e("MicroMsg.ApplicationUtil", "installAppWithGP second, ex = %s", e2.getMessage());
                AppMethodBeat.o(79355);
                return false;
            }
        }
    }

    public static boolean u(Context context, String str) {
        AppMethodBeat.i(79356);
        if (getPackageInfo(context, str) != null) {
            AppMethodBeat.o(79356);
            return true;
        }
        AppMethodBeat.o(79356);
        return false;
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        PackageInfo packageInfo = null;
        AppMethodBeat.i(79357);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.ApplicationUtil", "getPackageInfo, packageName is null");
            AppMethodBeat.o(79357);
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (NameNotFoundException e) {
                ab.w("MicroMsg.ApplicationUtil", "app not installed, packageName = ".concat(String.valueOf(str)));
            }
            AppMethodBeat.o(79357);
        }
        return packageInfo;
    }

    public static String aiR(String str) {
        String str2 = null;
        AppMethodBeat.i(79358);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(79358);
        } else {
            try {
                PackageInfo packageArchiveInfo = ah.getContext().getPackageManager().getPackageArchiveInfo(str, 0);
                if (packageArchiveInfo == null) {
                    RuntimeException runtimeException = new RuntimeException("info is null; ".concat(String.valueOf(str)));
                    AppMethodBeat.o(79358);
                    throw runtimeException;
                }
                ab.i("MicroMsg.ApplicationUtil", "get package name from archive filepath  :%s, package name is : %s", str, packageArchiveInfo.packageName);
                str2 = packageArchiveInfo.packageName;
                AppMethodBeat.o(79358);
            } catch (Exception e) {
                ab.e("MicroMsg.ApplicationUtil", "get package name from archive file path, failed : %s", e.getMessage());
                AppMethodBeat.o(79358);
            }
        }
        return str2;
    }

    public static int aiS(String str) {
        int i = 0;
        AppMethodBeat.i(79359);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(79359);
        } else {
            try {
                PackageInfo packageArchiveInfo = ah.getContext().getPackageManager().getPackageArchiveInfo(str, 0);
                if (packageArchiveInfo == null) {
                    RuntimeException runtimeException = new RuntimeException("info is null; ".concat(String.valueOf(str)));
                    AppMethodBeat.o(79359);
                    throw runtimeException;
                }
                ab.i("MicroMsg.ApplicationUtil", "get package version code from archive filepath  :%s, package version code is : %d", str, Integer.valueOf(packageArchiveInfo.versionCode));
                i = packageArchiveInfo.versionCode;
                AppMethodBeat.o(79359);
            } catch (Exception e) {
                ab.e("MicroMsg.ApplicationUtil", "get package version code from archive file path, failed : %s", e.getMessage());
                AppMethodBeat.o(79359);
            }
        }
        return i;
    }
}
