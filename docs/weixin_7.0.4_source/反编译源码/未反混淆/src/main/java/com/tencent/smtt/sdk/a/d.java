package com.tencent.smtt.sdk.a;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class d {

    public static class a {
        public int a = -1;
        public int b = -1;
        public String c = "";
        public String d = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        public String e = null;
    }

    static class b {
        public String a;
        public String b;

        private b() {
            this.a = "";
            this.b = "";
        }
    }

    public static int a(Context context, String str, HashMap<String, String> hashMap, WebView webView) {
        AppMethodBeat.i(65155);
        if (context == null) {
            AppMethodBeat.o(65155);
            return 3;
        }
        if (!a(str)) {
            str = "http://".concat(String.valueOf(str));
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                AppMethodBeat.o(65155);
                return 2;
            }
            a a = a(context);
            if (a.a == -1) {
                AppMethodBeat.o(65155);
                return 4;
            } else if (a.a != 2 || a.b >= 33) {
                Intent intent;
                Intent intent2 = new Intent("android.intent.action.VIEW");
                b a2;
                if (a.a == 2) {
                    if (a.b >= 33 && a.b <= 39) {
                        intent2.setClassName(TbsConfig.APP_QB, "com.tencent.mtt.MainActivity");
                        intent = intent2;
                    } else if (a.b < 40 || a.b > 45) {
                        if (a.b >= 46) {
                            intent2 = new Intent("com.tencent.QQBrowser.action.VIEW");
                            a2 = a(context, parse);
                            if (!(a2 == null || TextUtils.isEmpty(a2.a))) {
                                intent2.setClassName(a2.b, a2.a);
                            }
                            intent = intent2;
                        }
                        intent = intent2;
                    } else {
                        intent2.setClassName(TbsConfig.APP_QB, "com.tencent.mtt.SplashActivity");
                        intent = intent2;
                    }
                } else if (a.a == 1) {
                    if (a.b == 1) {
                        intent2.setClassName("com.tencent.qbx5", "com.tencent.qbx5.MainActivity");
                        intent = intent2;
                    } else {
                        if (a.b == 2) {
                            intent2.setClassName("com.tencent.qbx5", "com.tencent.qbx5.SplashActivity");
                            intent = intent2;
                        }
                        intent = intent2;
                    }
                } else if (a.a != 0) {
                    intent2 = new Intent("com.tencent.QQBrowser.action.VIEW");
                    a2 = a(context, parse);
                    if (!(a2 == null || TextUtils.isEmpty(a2.a))) {
                        intent2.setClassName(a2.b, a2.a);
                    }
                    intent = intent2;
                } else if (a.b < 4 || a.b > 6) {
                    if (a.b > 6) {
                        intent2 = new Intent("com.tencent.QQBrowser.action.VIEW");
                        a2 = a(context, parse);
                        if (!(a2 == null || TextUtils.isEmpty(a2.a))) {
                            intent2.setClassName(a2.b, a2.a);
                        }
                        intent = intent2;
                    }
                    intent = intent2;
                } else {
                    intent2.setClassName("com.tencent.qbx", "com.tencent.qbx.SplashActivity");
                    intent = intent2;
                }
                intent.setData(parse);
                if (hashMap != null) {
                    Set<String> keySet = hashMap.keySet();
                    if (keySet != null) {
                        for (String str2 : keySet) {
                            String str3 = (String) hashMap.get(str2);
                            if (!TextUtils.isEmpty(str3)) {
                                intent.putExtra(str2, str3);
                            }
                        }
                    }
                }
                try {
                    intent.putExtra("loginType", d(context));
                    intent.addFlags(268435456);
                    if (webView != null) {
                        intent.putExtra("AnchorPoint", new Point(webView.getScrollX(), webView.getScrollY()));
                        intent.putExtra("ContentSize", new Point(webView.getContentWidth(), webView.getContentHeight()));
                    }
                    context.startActivity(intent);
                    AppMethodBeat.o(65155);
                    return 0;
                } catch (ActivityNotFoundException e) {
                    AppMethodBeat.o(65155);
                    return 4;
                }
            } else {
                AppMethodBeat.o(65155);
                return 5;
            }
        } catch (Exception e2) {
            AppMethodBeat.o(65155);
            return 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(Context context, String str, HashMap<String, String> hashMap, String str2, WebView webView) {
        Object obj;
        String encode;
        int a;
        Object obj2 = null;
        AppMethodBeat.i(65154);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Object obj3;
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                PackageInfo packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                if (packageInfo != null && packageInfo.versionCode > 601000) {
                    obj3 = 1;
                    obj = obj3;
                    encode = URLEncoder.encode(str, "UTF-8");
                    if (obj != null) {
                        str = encode;
                    }
                    obj2 = obj;
                    stringBuilder.append("mttbrowser://url=").append(str).append(",product=TBS,packagename=").append(context.getPackageName()).append(",from=").append(str2).append(",version=4.3.0.1057").append(obj2 == null ? ",encoded=1" : "");
                    a = a(context, stringBuilder.toString(), hashMap, webView);
                    AppMethodBeat.o(65154);
                    return a;
                }
            }
            obj3 = null;
            obj = obj3;
        } catch (Throwable th) {
            obj = null;
        }
        try {
            encode = URLEncoder.encode(str, "UTF-8");
            if (obj != null) {
            }
            obj2 = obj;
        } catch (Exception e) {
        }
        if (obj2 == null) {
        }
        stringBuilder.append("mttbrowser://url=").append(str).append(",product=TBS,packagename=").append(context.getPackageName()).append(",from=").append(str2).append(",version=4.3.0.1057").append(obj2 == null ? ",encoded=1" : "");
        a = a(context, stringBuilder.toString(), hashMap, webView);
        AppMethodBeat.o(65154);
        return a;
    }

    private static Uri a(Context context, String str) {
        AppMethodBeat.i(65152);
        Uri fromFile = Uri.fromFile(new File(str));
        AppMethodBeat.o(65152);
        return fromFile;
    }

    public static a a(Context context) {
        AppMethodBeat.i(65158);
        boolean z = context.getApplicationContext().getSharedPreferences("x5_proxy_setting", 0).getBoolean("qb_install_status", false);
        a aVar = new a();
        if (z) {
            AppMethodBeat.o(65158);
            return aVar;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = null;
            try {
                packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                aVar.a = 2;
                aVar.e = TbsConfig.APP_QB;
                aVar.c = "ADRQB_";
                if (packageInfo != null && packageInfo.versionCode > 420000) {
                    aVar.b = packageInfo.versionCode;
                    aVar.c += packageInfo.versionName.replaceAll("\\.", "");
                    aVar.d = packageInfo.versionName.replaceAll("\\.", "");
                    AppMethodBeat.o(65158);
                    return aVar;
                }
            } catch (NameNotFoundException e) {
            }
            try {
                packageInfo = packageManager.getPackageInfo("com.tencent.qbx", 0);
                aVar.a = 0;
                aVar.e = "com.tencent.qbx";
                aVar.c = "ADRQBX_";
            } catch (NameNotFoundException e2) {
                try {
                    packageInfo = packageManager.getPackageInfo("com.tencent.qbx5", 0);
                    aVar.a = 1;
                    aVar.e = "com.tencent.qbx5";
                    aVar.c = "ADRQBX5_";
                } catch (NameNotFoundException e3) {
                    try {
                        packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                        aVar.e = TbsConfig.APP_QB;
                        aVar.a = 2;
                        aVar.c = "ADRQB_";
                    } catch (NameNotFoundException e4) {
                        try {
                            packageInfo = packageManager.getPackageInfo("com.tencent.mtt.x86", 0);
                            aVar.e = "com.tencent.mtt.x86";
                            aVar.a = 2;
                            aVar.c = "ADRQB_";
                        } catch (Exception e5) {
                            try {
                                b a = a(context, Uri.parse("http://mdc.html5.qq.com/mh?channel_id=50079&u="));
                                if (!(a == null || TextUtils.isEmpty(a.b))) {
                                    packageInfo = packageManager.getPackageInfo(a.b, 0);
                                    aVar.e = a.b;
                                    aVar.a = 2;
                                    aVar.c = "ADRQB_";
                                }
                            } catch (Exception e6) {
                            }
                        }
                    }
                }
            }
            if (packageInfo != null) {
                aVar.b = packageInfo.versionCode;
                aVar.c += packageInfo.versionName.replaceAll("\\.", "");
                aVar.d = packageInfo.versionName.replaceAll("\\.", "");
            }
        } catch (Exception e7) {
        }
        AppMethodBeat.o(65158);
        return aVar;
    }

    private static b a(Context context, Uri uri) {
        AppMethodBeat.i(65157);
        Intent intent = new Intent("com.tencent.QQBrowser.action.VIEW");
        intent.setData(uri);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.size() <= 0) {
            AppMethodBeat.o(65157);
            return null;
        }
        b bVar = new b();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            String str = resolveInfo.activityInfo.packageName;
            if (str.contains(TbsConfig.APP_QB)) {
                bVar.a = resolveInfo.activityInfo.name;
                bVar.b = resolveInfo.activityInfo.packageName;
                AppMethodBeat.o(65157);
                return bVar;
            } else if (str.contains("com.tencent.qbx")) {
                bVar.a = resolveInfo.activityInfo.name;
                bVar.b = resolveInfo.activityInfo.packageName;
            }
        }
        AppMethodBeat.o(65157);
        return bVar;
    }

    public static boolean a(Context context, long j, long j2) {
        boolean z = true;
        AppMethodBeat.i(65162);
        a a = a(context);
        boolean z2 = false;
        try {
            if (Long.valueOf(a.d).longValue() >= j) {
                z2 = true;
            }
        } catch (NumberFormatException e) {
        }
        if (((long) a.b) < j2) {
            z = z2;
        }
        AppMethodBeat.o(65162);
        return z;
    }

    public static boolean a(Context context, String str, int i, String str2, HashMap<String, String> hashMap, Bundle bundle) {
        AppMethodBeat.i(65151);
        try {
            Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
            if (hashMap != null) {
                Set<String> keySet = hashMap.keySet();
                if (keySet != null) {
                    for (String str3 : keySet) {
                        String str4 = (String) hashMap.get(str3);
                        if (!TextUtils.isEmpty(str4)) {
                            intent.putExtra(str3, str4);
                        }
                    }
                }
            }
            File file = new File(str);
            intent.putExtra("key_reader_sdk_id", 3);
            intent.putExtra("key_reader_sdk_type", i);
            if (i == 0) {
                intent.putExtra("key_reader_sdk_path", str);
            } else if (i == 1) {
                intent.putExtra("key_reader_sdk_url", str);
            }
            intent.putExtra("key_reader_sdk_format", str2);
            if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && VERSION.SDK_INT >= 24) {
                intent.addFlags(1);
            }
            intent.setDataAndType(a(context, str), "mtt/".concat(String.valueOf(str2)));
            intent.putExtra("loginType", d(context.getApplicationContext()));
            if (bundle != null) {
                intent.putExtra("key_reader_sdk_extrals", bundle);
            }
            context.startActivity(intent);
            AppMethodBeat.o(65151);
            return true;
        } catch (Exception e) {
            AppMethodBeat.o(65151);
            return false;
        }
    }

    public static boolean a(Context context, String str, HashMap<String, String> hashMap) {
        Object obj;
        AppMethodBeat.i(65153);
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setDataAndType(parse, "video/*");
        if (hashMap != null) {
            Set<String> keySet = hashMap.keySet();
            if (keySet != null) {
                for (String str2 : keySet) {
                    String str3 = (String) hashMap.get(str2);
                    if (!TextUtils.isEmpty(str3)) {
                        intent.putExtra(str2, str3);
                    }
                }
            }
        }
        try {
            intent.putExtra("loginType", d(context));
            intent.setComponent(new ComponentName(TbsConfig.APP_QB, "com.tencent.mtt.browser.video.H5VideoThrdcallActivity"));
            context.startActivity(intent);
            obj = 1;
        } catch (Throwable th) {
            obj = null;
        }
        if (obj == null) {
            try {
                intent.setComponent(null);
                context.startActivity(intent);
            } catch (Throwable th2) {
                AppMethodBeat.o(65153);
                return false;
            }
        }
        AppMethodBeat.o(65153);
        return true;
    }

    private static boolean a(String str) {
        AppMethodBeat.i(65159);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(65159);
            return false;
        }
        String trim = str.trim();
        int indexOf = trim.toLowerCase().indexOf("://");
        int indexOf2 = trim.toLowerCase().indexOf(46);
        if (indexOf <= 0 || indexOf2 <= 0 || indexOf <= indexOf2) {
            boolean contains = trim.toLowerCase().contains("://");
            AppMethodBeat.o(65159);
            return contains;
        }
        AppMethodBeat.o(65159);
        return false;
    }

    public static boolean b(Context context) {
        AppMethodBeat.i(65160);
        if (a(context).a == -1) {
            AppMethodBeat.o(65160);
            return false;
        }
        AppMethodBeat.o(65160);
        return true;
    }

    public static boolean c(Context context) {
        boolean z = true;
        AppMethodBeat.i(65161);
        a a = a(context);
        boolean z2 = false;
        try {
            if (Long.valueOf(a.d).longValue() >= 6001500) {
                z2 = true;
            }
        } catch (NumberFormatException e) {
        }
        if (a.b < 601500) {
            z = z2;
        }
        AppMethodBeat.o(65161);
        return z;
    }

    private static int d(Context context) {
        AppMethodBeat.i(65156);
        int i = 26;
        String str = context.getApplicationInfo().processName;
        if (str.equals(TbsConfig.APP_QQ)) {
            i = 13;
        } else if (str.equals(TbsConfig.APP_QZONE)) {
            i = 14;
        } else if (str.equals("com.tencent.WBlog")) {
            i = 15;
        } else if (str.equals("com.tencent.mm")) {
            i = 24;
        }
        AppMethodBeat.o(65156);
        return i;
    }
}
