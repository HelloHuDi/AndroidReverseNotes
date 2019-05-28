package com.tencent.p177mm.pluginsdk.model;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.pluginsdk.model.C14893s.C14894a;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.pluginsdk.model.o */
public final class C44065o extends C30081r {
    public static final String[] vbu = new String[]{"application/msword", "application/vnd.ms-powerpoint", "application/vnd.ms-excel", "application/pdf", "application/epub+zip", "text/plain", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "application/vnd.openxmlformats-officedocument.presentationml.presentation", "application/zip", "application/rar"};
    public static final int[] vbv = new int[]{C1318a.app_attach_file_icon_word, C1318a.app_attach_file_icon_ppt, C1318a.app_attach_file_icon_excel, C1318a.app_attach_file_icon_pdf, C1318a.app_attach_file_icon_epub, C1318a.app_attach_file_icon_txt, C1318a.app_attach_file_icon_word, C1318a.app_attach_file_icon_excel, C1318a.app_attach_file_icon_ppt, C1318a.app_attach_file_icon_rar, C1318a.app_attach_file_icon_rar};
    public static final int[] vbw = new int[]{C1318a.app_attach_file_icon_word, C1318a.app_attach_file_icon_ppt, C1318a.app_attach_file_icon_excel, C1318a.app_attach_file_icon_pdf, C1318a.app_attach_file_icon_epub, C1318a.app_attach_file_icon_txt, C1318a.app_attach_file_icon_word, C1318a.app_attach_file_icon_excel, C1318a.app_attach_file_icon_ppt, C1318a.app_attach_file_icon_rar, C1318a.app_attach_file_icon_rar};

    /* renamed from: com.tencent.mm.pluginsdk.model.o$b */
    static class C35802b {
        public String classname;
        public String vbz;

        private C35802b() {
            this.classname = "";
            this.vbz = "";
        }

        /* synthetic */ C35802b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.model.o$a */
    public static class C40445a {
        public int vbx = -1;
        public String vby = "";
        public int ver = -1;
    }

    /* renamed from: fE */
    public final boolean mo27192fE(Context context) {
        AppMethodBeat.m2504i(125819);
        C40445a fG = C44065o.m79204fG(context);
        if (fG.vbx == -1) {
            AppMethodBeat.m2505o(125819);
            return false;
        } else if (fG.vbx != 2 || fG.ver >= 33) {
            AppMethodBeat.m2505o(125819);
            return true;
        } else {
            AppMethodBeat.m2505o(125819);
            return false;
        }
    }

    /* renamed from: fF */
    public static boolean m79203fF(Context context) {
        AppMethodBeat.m2504i(125820);
        if (C44065o.m79204fG(context).vbx == -1) {
            AppMethodBeat.m2505o(125820);
            return false;
        }
        AppMethodBeat.m2505o(125820);
        return true;
    }

    public final boolean aix(String str) {
        AppMethodBeat.m2504i(125821);
        if (TbsConfig.APP_QB.equals(str) || "com.tencent.qbx".equals(str) || "com.tencent.mtt.x86".equals(str) || "com.tencent.qbx5".equals(str)) {
            AppMethodBeat.m2505o(125821);
            return true;
        }
        AppMethodBeat.m2505o(125821);
        return false;
    }

    public final String anK() {
        return "http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10318";
    }

    public final String dgX() {
        return "qq_browser.apk";
    }

    public final C14894a dgY() {
        AppMethodBeat.m2504i(125822);
        C14894a c14894a = new C14894a();
        c14894a.vbD = C25738R.string.df4;
        c14894a.vbF = C25738R.string.df5;
        c14894a.vbC = C25738R.drawable.icon_qqbrowser;
        AppMethodBeat.m2505o(125822);
        return c14894a;
    }

    /* renamed from: a */
    public final String mo27187a(Context context, ResolveInfo resolveInfo) {
        AppMethodBeat.m2504i(125823);
        if (context == null || resolveInfo == null || resolveInfo.activityInfo == null || resolveInfo.activityInfo.packageName == null) {
            AppMethodBeat.m2505o(125823);
            return null;
        }
        String str = resolveInfo.activityInfo.packageName;
        if ("com.qihoo.browser".equals(str)) {
            str = "360浏览器";
            AppMethodBeat.m2505o(125823);
            return str;
        } else if ("com.mx.browser".equals(str)) {
            str = "傲游云浏览器";
            AppMethodBeat.m2505o(125823);
            return str;
        } else if ("com.dolphin.browser.xf".equals(str)) {
            str = "海豚浏览器";
            AppMethodBeat.m2505o(125823);
            return str;
        } else if ("com.UCMobile".equals(str)) {
            str = "UC浏览器";
            AppMethodBeat.m2505o(125823);
            return str;
        } else if ("com.baidu.browser.apps".equals(str)) {
            str = "百度浏览器";
            AppMethodBeat.m2505o(125823);
            return str;
        } else if ("sogou.mobile.explorer".equals(str)) {
            str = "搜狗浏览器";
            AppMethodBeat.m2505o(125823);
            return str;
        } else if ("com.ijinshan.browser".equals(str)) {
            str = "猎豹浏览器";
            AppMethodBeat.m2505o(125823);
            return str;
        } else if ("com.mediawoz.xbrowser".equals(str)) {
            str = "GO浏览器";
            AppMethodBeat.m2505o(125823);
            return str;
        } else if ("com.oupeng.browser".equals(str)) {
            str = "欧朋浏览器";
            AppMethodBeat.m2505o(125823);
            return str;
        } else if ("com.tiantianmini.android.browser".equals(str)) {
            str = "天天浏览器";
            AppMethodBeat.m2505o(125823);
            return str;
        } else {
            CharSequence loadLabel = resolveInfo.activityInfo.loadLabel(context.getPackageManager());
            if (loadLabel != null) {
                Matcher matcher = Pattern.compile("\\(.*推荐.*\\)", 2).matcher(loadLabel.toString());
                if (matcher.find()) {
                    str = matcher.replaceAll("");
                    AppMethodBeat.m2505o(125823);
                    return str;
                }
            }
            str = resolveInfo.activityInfo.loadLabel(context.getPackageManager()).toString();
            AppMethodBeat.m2505o(125823);
            return str;
        }
    }

    /* renamed from: bv */
    public static int m79202bv(Context context, String str) {
        AppMethodBeat.m2504i(125824);
        if (context == null) {
            AppMethodBeat.m2505o(125824);
            return 3;
        }
        boolean z;
        int indexOf;
        if (str == null || str.length() == 0) {
            z = false;
        } else {
            String trim = str.trim();
            indexOf = trim.toLowerCase().indexOf("://");
            int indexOf2 = trim.toLowerCase().indexOf(46);
            if (indexOf <= 0 || indexOf2 <= 0 || indexOf <= indexOf2) {
                z = trim.toLowerCase().contains("://");
            } else {
                z = false;
            }
        }
        if (!z) {
            str = "http://".concat(String.valueOf(str));
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                AppMethodBeat.m2505o(125824);
                return 2;
            }
            if (parse.getScheme().toLowerCase().equals("qb")) {
                Object obj;
                C40445a fG = C44065o.m79204fG(context);
                if (fG.vbx == -1) {
                    obj = null;
                } else if (fG.vbx != 2 || fG.ver >= 42) {
                    indexOf = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    parse = Uri.parse("http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10375" + URLEncoder.encode(str, "UTF-8"));
                }
            }
            C40445a fG2 = C44065o.m79204fG(context);
            if (fG2.vbx == -1) {
                AppMethodBeat.m2505o(125824);
                return 4;
            } else if (fG2.vbx != 2 || fG2.ver >= 33) {
                Intent intent = new Intent("android.intent.action.VIEW");
                C35802b g;
                if (fG2.vbx == 2) {
                    if (fG2.ver >= 33 && fG2.ver <= 39) {
                        intent.setClassName(TbsConfig.APP_QB, "com.tencent.mtt.PhotoEditUI");
                    } else if (fG2.ver >= 40 && fG2.ver <= 45) {
                        intent.setClassName(TbsConfig.APP_QB, "com.tencent.mtt.SplashActivity");
                    } else if (fG2.ver >= 46) {
                        intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                        g = C44065o.m79205g(context, parse);
                        if (!(g == null || TextUtils.isEmpty(g.classname))) {
                            intent.setClassName(g.vbz, g.classname);
                        }
                    }
                } else if (fG2.vbx == 1) {
                    if (fG2.ver == 1) {
                        intent.setClassName("com.tencent.qbx5", "com.tencent.qbx5.PhotoEditUI");
                    } else if (fG2.ver == 2) {
                        intent.setClassName("com.tencent.qbx5", "com.tencent.qbx5.SplashActivity");
                    }
                } else if (fG2.vbx != 0) {
                    intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                    g = C44065o.m79205g(context, parse);
                    if (!(g == null || TextUtils.isEmpty(g.classname))) {
                        intent.setClassName(g.vbz, g.classname);
                    }
                } else if (fG2.ver >= 4 && fG2.ver <= 6) {
                    intent.setClassName("com.tencent.qbx", "com.tencent.qbx.SplashActivity");
                } else if (fG2.ver > 6) {
                    intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                    g = C44065o.m79205g(context, parse);
                    if (!(g == null || TextUtils.isEmpty(g.classname))) {
                        intent.setClassName(g.vbz, g.classname);
                    }
                }
                intent.setData(parse);
                try {
                    intent.putExtra("loginType", 24);
                    intent.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, "com.tencent.mm");
                    intent.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, 0);
                    context.startActivity(intent);
                    AppMethodBeat.m2505o(125824);
                    return 0;
                } catch (ActivityNotFoundException e) {
                    AppMethodBeat.m2505o(125824);
                    return 4;
                }
            } else {
                AppMethodBeat.m2505o(125824);
                return 5;
            }
        } catch (Exception e2) {
            AppMethodBeat.m2505o(125824);
            return 2;
        }
    }

    /* renamed from: fG */
    private static C40445a m79204fG(Context context) {
        AppMethodBeat.m2504i(125825);
        C40445a c40445a = new C40445a();
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = null;
            try {
                packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                c40445a.vbx = 2;
                c40445a.vby = "ADRQB_";
                if (packageInfo != null && packageInfo.versionCode > 420000) {
                    c40445a.ver = packageInfo.versionCode;
                    c40445a.vby += packageInfo.versionName.replaceAll("\\.", "");
                    AppMethodBeat.m2505o(125825);
                    return c40445a;
                }
            } catch (NameNotFoundException e) {
            }
            try {
                packageInfo = packageManager.getPackageInfo("com.tencent.qbx", 0);
                c40445a.vbx = 0;
                c40445a.vby = "ADRQBX_";
            } catch (NameNotFoundException e2) {
                try {
                    packageInfo = packageManager.getPackageInfo("com.tencent.qbx5", 0);
                    c40445a.vbx = 1;
                    c40445a.vby = "ADRQBX5_";
                } catch (NameNotFoundException e3) {
                    try {
                        packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                        c40445a.vbx = 2;
                        c40445a.vby = "ADRQB_";
                    } catch (NameNotFoundException e4) {
                        try {
                            packageInfo = packageManager.getPackageInfo("com.tencent.mtt.x86", 0);
                            c40445a.vbx = 2;
                            c40445a.vby = "ADRQB_";
                        } catch (Exception e5) {
                            try {
                                C35802b g = C44065o.m79205g(context, Uri.parse("http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10375"));
                                if (!(g == null || TextUtils.isEmpty(g.vbz))) {
                                    packageInfo = packageManager.getPackageInfo(g.vbz, 0);
                                    c40445a.vbx = 2;
                                    c40445a.vby = "ADRQB_";
                                }
                            } catch (Exception e6) {
                            }
                        }
                    }
                }
            }
            if (packageInfo != null) {
                c40445a.ver = packageInfo.versionCode;
                c40445a.vby += packageInfo.versionName.replaceAll("\\.", "");
            }
        } catch (Exception e7) {
        }
        AppMethodBeat.m2505o(125825);
        return c40445a;
    }

    /* renamed from: g */
    private static C35802b m79205g(Context context, Uri uri) {
        AppMethodBeat.m2504i(125826);
        Intent intent = new Intent("com.tencent.QQBrowser.action.VIEW");
        intent.setData(uri);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.size() <= 0) {
            AppMethodBeat.m2505o(125826);
            return null;
        }
        C35802b c35802b = new C35802b();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            String str = resolveInfo.activityInfo.packageName;
            if (str.contains(TbsConfig.APP_QB)) {
                c35802b.classname = resolveInfo.activityInfo.name;
                c35802b.vbz = resolveInfo.activityInfo.packageName;
                AppMethodBeat.m2505o(125826);
                return c35802b;
            } else if (str.contains("com.tencent.qbx")) {
                c35802b.classname = resolveInfo.activityInfo.name;
                c35802b.vbz = resolveInfo.activityInfo.packageName;
            }
        }
        AppMethodBeat.m2505o(125826);
        return c35802b;
    }

    /* renamed from: F */
    public final boolean mo48338F(Context context, Intent intent) {
        AppMethodBeat.m2504i(125827);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                String str = resolveInfo.activityInfo.packageName;
                if (str.contains(TbsConfig.APP_QB)) {
                    AppMethodBeat.m2505o(125827);
                    return true;
                } else if (str.contains("com.tencent.qbx")) {
                    AppMethodBeat.m2505o(125827);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(125827);
        return false;
    }

    public static int aiD(String str) {
        AppMethodBeat.m2504i(125828);
        Object obj = null;
        if (str != null && str.length() > 0) {
            obj = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        }
        if (obj == null || obj.length() == 0) {
            obj = "*/".concat(String.valueOf(str));
        }
        int i = -1;
        for (int i2 = 0; i2 < vbu.length; i2++) {
            if (vbu[i2].equals(obj)) {
                i = i2;
            }
        }
        if (i != -1) {
            int i3 = vbv[i];
            AppMethodBeat.m2505o(125828);
            return i3;
        }
        AppMethodBeat.m2505o(125828);
        return C1318a.app_attach_file_icon_unknow;
    }
}
