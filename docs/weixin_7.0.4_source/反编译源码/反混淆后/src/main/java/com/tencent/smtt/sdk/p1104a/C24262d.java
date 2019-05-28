package com.tencent.smtt.sdk.p1104a;

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

/* renamed from: com.tencent.smtt.sdk.a.d */
public class C24262d {

    /* renamed from: com.tencent.smtt.sdk.a.d$a */
    public static class C24263a {
        /* renamed from: a */
        public int f4509a = -1;
        /* renamed from: b */
        public int f4510b = -1;
        /* renamed from: c */
        public String f4511c = "";
        /* renamed from: d */
        public String f4512d = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        /* renamed from: e */
        public String f4513e = null;
    }

    /* renamed from: com.tencent.smtt.sdk.a.d$b */
    static class C24264b {
        /* renamed from: a */
        public String f4514a;
        /* renamed from: b */
        public String f4515b;

        private C24264b() {
            this.f4514a = "";
            this.f4515b = "";
        }
    }

    /* renamed from: a */
    public static int m37417a(Context context, String str, HashMap<String, String> hashMap, WebView webView) {
        AppMethodBeat.m2504i(65155);
        if (context == null) {
            AppMethodBeat.m2505o(65155);
            return 3;
        }
        if (!C24262d.m37425a(str)) {
            str = "http://".concat(String.valueOf(str));
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                AppMethodBeat.m2505o(65155);
                return 2;
            }
            C24263a a = C24262d.m37420a(context);
            if (a.f4509a == -1) {
                AppMethodBeat.m2505o(65155);
                return 4;
            } else if (a.f4509a != 2 || a.f4510b >= 33) {
                Intent intent;
                Intent intent2 = new Intent("android.intent.action.VIEW");
                C24264b a2;
                if (a.f4509a == 2) {
                    if (a.f4510b >= 33 && a.f4510b <= 39) {
                        intent2.setClassName(TbsConfig.APP_QB, "com.tencent.mtt.MainActivity");
                        intent = intent2;
                    } else if (a.f4510b < 40 || a.f4510b > 45) {
                        if (a.f4510b >= 46) {
                            intent2 = new Intent("com.tencent.QQBrowser.action.VIEW");
                            a2 = C24262d.m37421a(context, parse);
                            if (!(a2 == null || TextUtils.isEmpty(a2.f4514a))) {
                                intent2.setClassName(a2.f4515b, a2.f4514a);
                            }
                            intent = intent2;
                        }
                        intent = intent2;
                    } else {
                        intent2.setClassName(TbsConfig.APP_QB, "com.tencent.mtt.SplashActivity");
                        intent = intent2;
                    }
                } else if (a.f4509a == 1) {
                    if (a.f4510b == 1) {
                        intent2.setClassName("com.tencent.qbx5", "com.tencent.qbx5.MainActivity");
                        intent = intent2;
                    } else {
                        if (a.f4510b == 2) {
                            intent2.setClassName("com.tencent.qbx5", "com.tencent.qbx5.SplashActivity");
                            intent = intent2;
                        }
                        intent = intent2;
                    }
                } else if (a.f4509a != 0) {
                    intent2 = new Intent("com.tencent.QQBrowser.action.VIEW");
                    a2 = C24262d.m37421a(context, parse);
                    if (!(a2 == null || TextUtils.isEmpty(a2.f4514a))) {
                        intent2.setClassName(a2.f4515b, a2.f4514a);
                    }
                    intent = intent2;
                } else if (a.f4510b < 4 || a.f4510b > 6) {
                    if (a.f4510b > 6) {
                        intent2 = new Intent("com.tencent.QQBrowser.action.VIEW");
                        a2 = C24262d.m37421a(context, parse);
                        if (!(a2 == null || TextUtils.isEmpty(a2.f4514a))) {
                            intent2.setClassName(a2.f4515b, a2.f4514a);
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
                    intent.putExtra("loginType", C24262d.m37428d(context));
                    intent.addFlags(268435456);
                    if (webView != null) {
                        intent.putExtra("AnchorPoint", new Point(webView.getScrollX(), webView.getScrollY()));
                        intent.putExtra("ContentSize", new Point(webView.getContentWidth(), webView.getContentHeight()));
                    }
                    context.startActivity(intent);
                    AppMethodBeat.m2505o(65155);
                    return 0;
                } catch (ActivityNotFoundException e) {
                    AppMethodBeat.m2505o(65155);
                    return 4;
                }
            } else {
                AppMethodBeat.m2505o(65155);
                return 5;
            }
        } catch (Exception e2) {
            AppMethodBeat.m2505o(65155);
            return 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static int m37418a(Context context, String str, HashMap<String, String> hashMap, String str2, WebView webView) {
        Object obj;
        String encode;
        int a;
        Object obj2 = null;
        AppMethodBeat.m2504i(65154);
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
                    a = C24262d.m37417a(context, stringBuilder.toString(), hashMap, webView);
                    AppMethodBeat.m2505o(65154);
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
        a = C24262d.m37417a(context, stringBuilder.toString(), hashMap, webView);
        AppMethodBeat.m2505o(65154);
        return a;
    }

    /* renamed from: a */
    private static Uri m37419a(Context context, String str) {
        AppMethodBeat.m2504i(65152);
        Uri fromFile = Uri.fromFile(new File(str));
        AppMethodBeat.m2505o(65152);
        return fromFile;
    }

    /* renamed from: a */
    public static C24263a m37420a(Context context) {
        AppMethodBeat.m2504i(65158);
        boolean z = context.getApplicationContext().getSharedPreferences("x5_proxy_setting", 0).getBoolean("qb_install_status", false);
        C24263a c24263a = new C24263a();
        if (z) {
            AppMethodBeat.m2505o(65158);
            return c24263a;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = null;
            try {
                packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                c24263a.f4509a = 2;
                c24263a.f4513e = TbsConfig.APP_QB;
                c24263a.f4511c = "ADRQB_";
                if (packageInfo != null && packageInfo.versionCode > 420000) {
                    c24263a.f4510b = packageInfo.versionCode;
                    c24263a.f4511c += packageInfo.versionName.replaceAll("\\.", "");
                    c24263a.f4512d = packageInfo.versionName.replaceAll("\\.", "");
                    AppMethodBeat.m2505o(65158);
                    return c24263a;
                }
            } catch (NameNotFoundException e) {
            }
            try {
                packageInfo = packageManager.getPackageInfo("com.tencent.qbx", 0);
                c24263a.f4509a = 0;
                c24263a.f4513e = "com.tencent.qbx";
                c24263a.f4511c = "ADRQBX_";
            } catch (NameNotFoundException e2) {
                try {
                    packageInfo = packageManager.getPackageInfo("com.tencent.qbx5", 0);
                    c24263a.f4509a = 1;
                    c24263a.f4513e = "com.tencent.qbx5";
                    c24263a.f4511c = "ADRQBX5_";
                } catch (NameNotFoundException e3) {
                    try {
                        packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                        c24263a.f4513e = TbsConfig.APP_QB;
                        c24263a.f4509a = 2;
                        c24263a.f4511c = "ADRQB_";
                    } catch (NameNotFoundException e4) {
                        try {
                            packageInfo = packageManager.getPackageInfo("com.tencent.mtt.x86", 0);
                            c24263a.f4513e = "com.tencent.mtt.x86";
                            c24263a.f4509a = 2;
                            c24263a.f4511c = "ADRQB_";
                        } catch (Exception e5) {
                            try {
                                C24264b a = C24262d.m37421a(context, Uri.parse("http://mdc.html5.qq.com/mh?channel_id=50079&u="));
                                if (!(a == null || TextUtils.isEmpty(a.f4515b))) {
                                    packageInfo = packageManager.getPackageInfo(a.f4515b, 0);
                                    c24263a.f4513e = a.f4515b;
                                    c24263a.f4509a = 2;
                                    c24263a.f4511c = "ADRQB_";
                                }
                            } catch (Exception e6) {
                            }
                        }
                    }
                }
            }
            if (packageInfo != null) {
                c24263a.f4510b = packageInfo.versionCode;
                c24263a.f4511c += packageInfo.versionName.replaceAll("\\.", "");
                c24263a.f4512d = packageInfo.versionName.replaceAll("\\.", "");
            }
        } catch (Exception e7) {
        }
        AppMethodBeat.m2505o(65158);
        return c24263a;
    }

    /* renamed from: a */
    private static C24264b m37421a(Context context, Uri uri) {
        AppMethodBeat.m2504i(65157);
        Intent intent = new Intent("com.tencent.QQBrowser.action.VIEW");
        intent.setData(uri);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.size() <= 0) {
            AppMethodBeat.m2505o(65157);
            return null;
        }
        C24264b c24264b = new C24264b();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            String str = resolveInfo.activityInfo.packageName;
            if (str.contains(TbsConfig.APP_QB)) {
                c24264b.f4514a = resolveInfo.activityInfo.name;
                c24264b.f4515b = resolveInfo.activityInfo.packageName;
                AppMethodBeat.m2505o(65157);
                return c24264b;
            } else if (str.contains("com.tencent.qbx")) {
                c24264b.f4514a = resolveInfo.activityInfo.name;
                c24264b.f4515b = resolveInfo.activityInfo.packageName;
            }
        }
        AppMethodBeat.m2505o(65157);
        return c24264b;
    }

    /* renamed from: a */
    public static boolean m37422a(Context context, long j, long j2) {
        boolean z = true;
        AppMethodBeat.m2504i(65162);
        C24263a a = C24262d.m37420a(context);
        boolean z2 = false;
        try {
            if (Long.valueOf(a.f4512d).longValue() >= j) {
                z2 = true;
            }
        } catch (NumberFormatException e) {
        }
        if (((long) a.f4510b) < j2) {
            z = z2;
        }
        AppMethodBeat.m2505o(65162);
        return z;
    }

    /* renamed from: a */
    public static boolean m37423a(Context context, String str, int i, String str2, HashMap<String, String> hashMap, Bundle bundle) {
        AppMethodBeat.m2504i(65151);
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
            intent.setDataAndType(C24262d.m37419a(context, str), "mtt/".concat(String.valueOf(str2)));
            intent.putExtra("loginType", C24262d.m37428d(context.getApplicationContext()));
            if (bundle != null) {
                intent.putExtra("key_reader_sdk_extrals", bundle);
            }
            context.startActivity(intent);
            AppMethodBeat.m2505o(65151);
            return true;
        } catch (Exception e) {
            AppMethodBeat.m2505o(65151);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m37424a(Context context, String str, HashMap<String, String> hashMap) {
        Object obj;
        AppMethodBeat.m2504i(65153);
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
            intent.putExtra("loginType", C24262d.m37428d(context));
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
                AppMethodBeat.m2505o(65153);
                return false;
            }
        }
        AppMethodBeat.m2505o(65153);
        return true;
    }

    /* renamed from: a */
    private static boolean m37425a(String str) {
        AppMethodBeat.m2504i(65159);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(65159);
            return false;
        }
        String trim = str.trim();
        int indexOf = trim.toLowerCase().indexOf("://");
        int indexOf2 = trim.toLowerCase().indexOf(46);
        if (indexOf <= 0 || indexOf2 <= 0 || indexOf <= indexOf2) {
            boolean contains = trim.toLowerCase().contains("://");
            AppMethodBeat.m2505o(65159);
            return contains;
        }
        AppMethodBeat.m2505o(65159);
        return false;
    }

    /* renamed from: b */
    public static boolean m37426b(Context context) {
        AppMethodBeat.m2504i(65160);
        if (C24262d.m37420a(context).f4509a == -1) {
            AppMethodBeat.m2505o(65160);
            return false;
        }
        AppMethodBeat.m2505o(65160);
        return true;
    }

    /* renamed from: c */
    public static boolean m37427c(Context context) {
        boolean z = true;
        AppMethodBeat.m2504i(65161);
        C24263a a = C24262d.m37420a(context);
        boolean z2 = false;
        try {
            if (Long.valueOf(a.f4512d).longValue() >= 6001500) {
                z2 = true;
            }
        } catch (NumberFormatException e) {
        }
        if (a.f4510b < 601500) {
            z = z2;
        }
        AppMethodBeat.m2505o(65161);
        return z;
    }

    /* renamed from: d */
    private static int m37428d(Context context) {
        AppMethodBeat.m2504i(65156);
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
        AppMethodBeat.m2505o(65156);
        return i;
    }
}
