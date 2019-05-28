package com.tencent.mm.pluginsdk.model;

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
import com.tencent.mm.R;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class o extends r {
    public static final String[] vbu = new String[]{"application/msword", "application/vnd.ms-powerpoint", "application/vnd.ms-excel", "application/pdf", "application/epub+zip", "text/plain", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "application/vnd.openxmlformats-officedocument.presentationml.presentation", "application/zip", "application/rar"};
    public static final int[] vbv = new int[]{R.raw.app_attach_file_icon_word, R.raw.app_attach_file_icon_ppt, R.raw.app_attach_file_icon_excel, R.raw.app_attach_file_icon_pdf, R.raw.app_attach_file_icon_epub, R.raw.app_attach_file_icon_txt, R.raw.app_attach_file_icon_word, R.raw.app_attach_file_icon_excel, R.raw.app_attach_file_icon_ppt, R.raw.app_attach_file_icon_rar, R.raw.app_attach_file_icon_rar};
    public static final int[] vbw = new int[]{R.raw.app_attach_file_icon_word, R.raw.app_attach_file_icon_ppt, R.raw.app_attach_file_icon_excel, R.raw.app_attach_file_icon_pdf, R.raw.app_attach_file_icon_epub, R.raw.app_attach_file_icon_txt, R.raw.app_attach_file_icon_word, R.raw.app_attach_file_icon_excel, R.raw.app_attach_file_icon_ppt, R.raw.app_attach_file_icon_rar, R.raw.app_attach_file_icon_rar};

    static class b {
        public String classname;
        public String vbz;

        private b() {
            this.classname = "";
            this.vbz = "";
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public static class a {
        public int vbx = -1;
        public String vby = "";
        public int ver = -1;
    }

    public final boolean fE(Context context) {
        AppMethodBeat.i(125819);
        a fG = fG(context);
        if (fG.vbx == -1) {
            AppMethodBeat.o(125819);
            return false;
        } else if (fG.vbx != 2 || fG.ver >= 33) {
            AppMethodBeat.o(125819);
            return true;
        } else {
            AppMethodBeat.o(125819);
            return false;
        }
    }

    public static boolean fF(Context context) {
        AppMethodBeat.i(125820);
        if (fG(context).vbx == -1) {
            AppMethodBeat.o(125820);
            return false;
        }
        AppMethodBeat.o(125820);
        return true;
    }

    public final boolean aix(String str) {
        AppMethodBeat.i(125821);
        if (TbsConfig.APP_QB.equals(str) || "com.tencent.qbx".equals(str) || "com.tencent.mtt.x86".equals(str) || "com.tencent.qbx5".equals(str)) {
            AppMethodBeat.o(125821);
            return true;
        }
        AppMethodBeat.o(125821);
        return false;
    }

    public final String anK() {
        return "http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10318";
    }

    public final String dgX() {
        return "qq_browser.apk";
    }

    public final com.tencent.mm.pluginsdk.model.s.a dgY() {
        AppMethodBeat.i(125822);
        com.tencent.mm.pluginsdk.model.s.a aVar = new com.tencent.mm.pluginsdk.model.s.a();
        aVar.vbD = R.string.df4;
        aVar.vbF = R.string.df5;
        aVar.vbC = R.drawable.icon_qqbrowser;
        AppMethodBeat.o(125822);
        return aVar;
    }

    public final String a(Context context, ResolveInfo resolveInfo) {
        AppMethodBeat.i(125823);
        if (context == null || resolveInfo == null || resolveInfo.activityInfo == null || resolveInfo.activityInfo.packageName == null) {
            AppMethodBeat.o(125823);
            return null;
        }
        String str = resolveInfo.activityInfo.packageName;
        if ("com.qihoo.browser".equals(str)) {
            str = "360浏览器";
            AppMethodBeat.o(125823);
            return str;
        } else if ("com.mx.browser".equals(str)) {
            str = "傲游云浏览器";
            AppMethodBeat.o(125823);
            return str;
        } else if ("com.dolphin.browser.xf".equals(str)) {
            str = "海豚浏览器";
            AppMethodBeat.o(125823);
            return str;
        } else if ("com.UCMobile".equals(str)) {
            str = "UC浏览器";
            AppMethodBeat.o(125823);
            return str;
        } else if ("com.baidu.browser.apps".equals(str)) {
            str = "百度浏览器";
            AppMethodBeat.o(125823);
            return str;
        } else if ("sogou.mobile.explorer".equals(str)) {
            str = "搜狗浏览器";
            AppMethodBeat.o(125823);
            return str;
        } else if ("com.ijinshan.browser".equals(str)) {
            str = "猎豹浏览器";
            AppMethodBeat.o(125823);
            return str;
        } else if ("com.mediawoz.xbrowser".equals(str)) {
            str = "GO浏览器";
            AppMethodBeat.o(125823);
            return str;
        } else if ("com.oupeng.browser".equals(str)) {
            str = "欧朋浏览器";
            AppMethodBeat.o(125823);
            return str;
        } else if ("com.tiantianmini.android.browser".equals(str)) {
            str = "天天浏览器";
            AppMethodBeat.o(125823);
            return str;
        } else {
            CharSequence loadLabel = resolveInfo.activityInfo.loadLabel(context.getPackageManager());
            if (loadLabel != null) {
                Matcher matcher = Pattern.compile("\\(.*推荐.*\\)", 2).matcher(loadLabel.toString());
                if (matcher.find()) {
                    str = matcher.replaceAll("");
                    AppMethodBeat.o(125823);
                    return str;
                }
            }
            str = resolveInfo.activityInfo.loadLabel(context.getPackageManager()).toString();
            AppMethodBeat.o(125823);
            return str;
        }
    }

    public static int bv(Context context, String str) {
        AppMethodBeat.i(125824);
        if (context == null) {
            AppMethodBeat.o(125824);
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
                AppMethodBeat.o(125824);
                return 2;
            }
            if (parse.getScheme().toLowerCase().equals("qb")) {
                Object obj;
                a fG = fG(context);
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
            a fG2 = fG(context);
            if (fG2.vbx == -1) {
                AppMethodBeat.o(125824);
                return 4;
            } else if (fG2.vbx != 2 || fG2.ver >= 33) {
                Intent intent = new Intent("android.intent.action.VIEW");
                b g;
                if (fG2.vbx == 2) {
                    if (fG2.ver >= 33 && fG2.ver <= 39) {
                        intent.setClassName(TbsConfig.APP_QB, "com.tencent.mtt.PhotoEditUI");
                    } else if (fG2.ver >= 40 && fG2.ver <= 45) {
                        intent.setClassName(TbsConfig.APP_QB, "com.tencent.mtt.SplashActivity");
                    } else if (fG2.ver >= 46) {
                        intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                        g = g(context, parse);
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
                    g = g(context, parse);
                    if (!(g == null || TextUtils.isEmpty(g.classname))) {
                        intent.setClassName(g.vbz, g.classname);
                    }
                } else if (fG2.ver >= 4 && fG2.ver <= 6) {
                    intent.setClassName("com.tencent.qbx", "com.tencent.qbx.SplashActivity");
                } else if (fG2.ver > 6) {
                    intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                    g = g(context, parse);
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
                    AppMethodBeat.o(125824);
                    return 0;
                } catch (ActivityNotFoundException e) {
                    AppMethodBeat.o(125824);
                    return 4;
                }
            } else {
                AppMethodBeat.o(125824);
                return 5;
            }
        } catch (Exception e2) {
            AppMethodBeat.o(125824);
            return 2;
        }
    }

    private static a fG(Context context) {
        AppMethodBeat.i(125825);
        a aVar = new a();
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = null;
            try {
                packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                aVar.vbx = 2;
                aVar.vby = "ADRQB_";
                if (packageInfo != null && packageInfo.versionCode > 420000) {
                    aVar.ver = packageInfo.versionCode;
                    aVar.vby += packageInfo.versionName.replaceAll("\\.", "");
                    AppMethodBeat.o(125825);
                    return aVar;
                }
            } catch (NameNotFoundException e) {
            }
            try {
                packageInfo = packageManager.getPackageInfo("com.tencent.qbx", 0);
                aVar.vbx = 0;
                aVar.vby = "ADRQBX_";
            } catch (NameNotFoundException e2) {
                try {
                    packageInfo = packageManager.getPackageInfo("com.tencent.qbx5", 0);
                    aVar.vbx = 1;
                    aVar.vby = "ADRQBX5_";
                } catch (NameNotFoundException e3) {
                    try {
                        packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                        aVar.vbx = 2;
                        aVar.vby = "ADRQB_";
                    } catch (NameNotFoundException e4) {
                        try {
                            packageInfo = packageManager.getPackageInfo("com.tencent.mtt.x86", 0);
                            aVar.vbx = 2;
                            aVar.vby = "ADRQB_";
                        } catch (Exception e5) {
                            try {
                                b g = g(context, Uri.parse("http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10375"));
                                if (!(g == null || TextUtils.isEmpty(g.vbz))) {
                                    packageInfo = packageManager.getPackageInfo(g.vbz, 0);
                                    aVar.vbx = 2;
                                    aVar.vby = "ADRQB_";
                                }
                            } catch (Exception e6) {
                            }
                        }
                    }
                }
            }
            if (packageInfo != null) {
                aVar.ver = packageInfo.versionCode;
                aVar.vby += packageInfo.versionName.replaceAll("\\.", "");
            }
        } catch (Exception e7) {
        }
        AppMethodBeat.o(125825);
        return aVar;
    }

    private static b g(Context context, Uri uri) {
        AppMethodBeat.i(125826);
        Intent intent = new Intent("com.tencent.QQBrowser.action.VIEW");
        intent.setData(uri);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.size() <= 0) {
            AppMethodBeat.o(125826);
            return null;
        }
        b bVar = new b();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            String str = resolveInfo.activityInfo.packageName;
            if (str.contains(TbsConfig.APP_QB)) {
                bVar.classname = resolveInfo.activityInfo.name;
                bVar.vbz = resolveInfo.activityInfo.packageName;
                AppMethodBeat.o(125826);
                return bVar;
            } else if (str.contains("com.tencent.qbx")) {
                bVar.classname = resolveInfo.activityInfo.name;
                bVar.vbz = resolveInfo.activityInfo.packageName;
            }
        }
        AppMethodBeat.o(125826);
        return bVar;
    }

    public final boolean F(Context context, Intent intent) {
        AppMethodBeat.i(125827);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                String str = resolveInfo.activityInfo.packageName;
                if (str.contains(TbsConfig.APP_QB)) {
                    AppMethodBeat.o(125827);
                    return true;
                } else if (str.contains("com.tencent.qbx")) {
                    AppMethodBeat.o(125827);
                    return true;
                }
            }
        }
        AppMethodBeat.o(125827);
        return false;
    }

    public static int aiD(String str) {
        AppMethodBeat.i(125828);
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
            AppMethodBeat.o(125828);
            return i3;
        }
        AppMethodBeat.o(125828);
        return R.raw.app_attach_file_icon_unknow;
    }
}
