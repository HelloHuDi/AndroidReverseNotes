package com.tencent.p177mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import java.util.Locale;

/* renamed from: com.tencent.mm.sdk.platformtools.aa */
public final class C4988aa {
    public static Locale xyO;

    public static boolean amv(String str) {
        AppMethodBeat.m2504i(115219);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(115219);
            return false;
        } else if (str.equalsIgnoreCase("zh_TW") || str.equalsIgnoreCase("zh_HK") || str.equalsIgnoreCase("zh_CN") || str.equalsIgnoreCase("en") || str.equalsIgnoreCase("th") || str.equals("id") || str.equals("in") || str.equals("vi") || str.equalsIgnoreCase("pt") || str.equalsIgnoreCase("es") || str.equalsIgnoreCase("ru") || str.equalsIgnoreCase("ar") || str.equalsIgnoreCase("ja") || str.equalsIgnoreCase("it") || str.equalsIgnoreCase("ko") || str.equalsIgnoreCase("ms") || str.equalsIgnoreCase("tr") || str.equalsIgnoreCase("de") || str.equalsIgnoreCase("fr") || str.equalsIgnoreCase("my") || str.equalsIgnoreCase("lo")) {
            AppMethodBeat.m2505o(115219);
            return true;
        } else {
            AppMethodBeat.m2505o(115219);
            return false;
        }
    }

    public static boolean don() {
        AppMethodBeat.m2504i(115220);
        String dor = C4988aa.dor();
        if (dor.equals("zh_CN") || dor.equals("zh_TW") || dor.equals("zh_HK")) {
            AppMethodBeat.m2505o(115220);
            return true;
        }
        AppMethodBeat.m2505o(115220);
        return false;
    }

    public static boolean doo() {
        AppMethodBeat.m2504i(115221);
        if (C4988aa.dor().equals("zh_CN")) {
            AppMethodBeat.m2505o(115221);
            return true;
        }
        AppMethodBeat.m2505o(115221);
        return false;
    }

    public static boolean dop() {
        AppMethodBeat.m2504i(115222);
        if (C4988aa.dor().equals("zh_TW") || C4988aa.dor().equals("zh_HK")) {
            AppMethodBeat.m2505o(115222);
            return true;
        }
        AppMethodBeat.m2505o(115222);
        return false;
    }

    /* renamed from: a */
    public static void m7399a(Context context, Locale locale) {
        AppMethodBeat.m2504i(115223);
        try {
            Resources resources = context.getResources();
            Configuration configuration = resources.getConfiguration();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration.locale = locale;
            resources.updateConfiguration(configuration, displayMetrics);
            Resources.getSystem().updateConfiguration(configuration, displayMetrics);
            AppMethodBeat.m2505o(115223);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.LocaleUtil", e, "updateApplicationResourceLocale err~~~", new Object[0]);
            AppMethodBeat.m2505o(115223);
        }
    }

    /* renamed from: c */
    public static String m7400c(Locale locale) {
        AppMethodBeat.m2504i(115224);
        String language = locale.getLanguage();
        if (language.equals("zh")) {
            language = language + "_" + locale.getCountry().toUpperCase();
            AppMethodBeat.m2505o(115224);
            return language;
        }
        AppMethodBeat.m2505o(115224);
        return language;
    }

    public static Locale amw(String str) {
        AppMethodBeat.m2504i(115225);
        Locale locale;
        if (str.equals("zh_TW")) {
            locale = Locale.TAIWAN;
            AppMethodBeat.m2505o(115225);
            return locale;
        } else if (str.equals("zh_HK")) {
            locale = new Locale("zh", "HK");
            AppMethodBeat.m2505o(115225);
            return locale;
        } else if (str.equals("en")) {
            locale = Locale.ENGLISH;
            AppMethodBeat.m2505o(115225);
            return locale;
        } else if (str.equals("zh_CN")) {
            locale = Locale.CHINA;
            AppMethodBeat.m2505o(115225);
            return locale;
        } else if (str.equalsIgnoreCase("th") || str.equalsIgnoreCase("id") || str.equalsIgnoreCase("in") || str.equalsIgnoreCase("vi") || str.equalsIgnoreCase("pt") || str.equalsIgnoreCase("es") || str.equalsIgnoreCase("ru") || str.equalsIgnoreCase("ar") || str.equalsIgnoreCase("ja") || str.equalsIgnoreCase("it") || str.equalsIgnoreCase("ko") || str.equalsIgnoreCase("ms") || str.equalsIgnoreCase("tr") || str.equalsIgnoreCase("de") || str.equalsIgnoreCase("fr") || str.equalsIgnoreCase("my") || str.equalsIgnoreCase("lo")) {
            locale = new Locale(str);
            AppMethodBeat.m2505o(115225);
            return locale;
        } else {
            C4990ab.m7412e("MicroMsg.LocaleUtil", "transLanguageToLocale country = ".concat(String.valueOf(str)));
            locale = Locale.ENGLISH;
            AppMethodBeat.m2505o(115225);
            return locale;
        }
    }

    public static String doq() {
        AppMethodBeat.m2504i(115226);
        String trim = Locale.getDefault().getCountry().trim();
        AppMethodBeat.m2505o(115226);
        return trim;
    }

    private static String amx(String str) {
        AppMethodBeat.m2504i(115227);
        String trim = Locale.getDefault().getLanguage().trim();
        String str2 = trim + "_" + Locale.getDefault().getCountry().trim();
        if (trim.equals("en")) {
            AppMethodBeat.m2505o(115227);
            return trim;
        } else if (str2.equals("zh_TW")) {
            str = "zh_TW";
            AppMethodBeat.m2505o(115227);
            return str;
        } else if (str2.equals("zh_HK")) {
            str = "zh_HK";
            AppMethodBeat.m2505o(115227);
            return str;
        } else if (str2.equals("zh_CN")) {
            str = "zh_CN";
            AppMethodBeat.m2505o(115227);
            return str;
        } else if (trim.equals("th")) {
            str = "th";
            AppMethodBeat.m2505o(115227);
            return str;
        } else if (trim.equals("id")) {
            str = "id";
            AppMethodBeat.m2505o(115227);
            return str;
        } else if (trim.equals("in")) {
            str = "id";
            AppMethodBeat.m2505o(115227);
            return str;
        } else if (trim.equals("vi")) {
            str = "vi";
            AppMethodBeat.m2505o(115227);
            return str;
        } else if (trim.equals("pt")) {
            str = "pt";
            AppMethodBeat.m2505o(115227);
            return str;
        } else if (trim.equals("es")) {
            str = "es";
            AppMethodBeat.m2505o(115227);
            return str;
        } else if (trim.equals("ru")) {
            str = "ru";
            AppMethodBeat.m2505o(115227);
            return str;
        } else if (trim.equals("ar")) {
            str = "ar";
            AppMethodBeat.m2505o(115227);
            return str;
        } else if (trim.equals("ja")) {
            str = "ja";
            AppMethodBeat.m2505o(115227);
            return str;
        } else if (trim.equals("it")) {
            str = "it";
            AppMethodBeat.m2505o(115227);
            return str;
        } else if (trim.equals("ko")) {
            str = "ko";
            AppMethodBeat.m2505o(115227);
            return str;
        } else if (trim.equals("ms")) {
            str = "ms";
            AppMethodBeat.m2505o(115227);
            return str;
        } else if (trim.equals("tr")) {
            str = "tr";
            AppMethodBeat.m2505o(115227);
            return str;
        } else if (trim.equals("de")) {
            str = "de";
            AppMethodBeat.m2505o(115227);
            return str;
        } else if (trim.equals("fr")) {
            str = "fr";
            AppMethodBeat.m2505o(115227);
            return str;
        } else if (trim.equals("my")) {
            str = "my";
            AppMethodBeat.m2505o(115227);
            return str;
        } else if (trim.equals("lo")) {
            str = "lo";
            AppMethodBeat.m2505o(115227);
            return str;
        } else {
            AppMethodBeat.m2505o(115227);
            return str;
        }
    }

    public static String dor() {
        AppMethodBeat.m2504i(115228);
        String nullAsNil = C5046bo.nullAsNil(C5040bk.getProperty("language_key"));
        if (nullAsNil.length() <= 0 || nullAsNil.equals("language_default")) {
            nullAsNil = C4988aa.amx("en");
            AppMethodBeat.m2505o(115228);
            return nullAsNil;
        }
        AppMethodBeat.m2505o(115228);
        return nullAsNil;
    }

    /* renamed from: g */
    public static String m7402g(SharedPreferences sharedPreferences) {
        AppMethodBeat.m2504i(115229);
        String nullAsNil = C5046bo.nullAsNil(sharedPreferences.getString("language_key", null));
        if (nullAsNil.length() <= 0 || nullAsNil.equals("language_default")) {
            nullAsNil = C4988aa.amx("en");
            C5040bk.setProperty("language_key", nullAsNil);
            AppMethodBeat.m2505o(115229);
            return nullAsNil;
        }
        C5040bk.setProperty("language_key", nullAsNil);
        AppMethodBeat.m2505o(115229);
        return nullAsNil;
    }

    /* renamed from: h */
    public static String m7405h(SharedPreferences sharedPreferences) {
        AppMethodBeat.m2504i(115230);
        String nullAsNil = C5046bo.nullAsNil(sharedPreferences.getString("language_key", null));
        if (C5046bo.isNullOrNil(nullAsNil)) {
            nullAsNil = "language_default";
            AppMethodBeat.m2505o(115230);
            return nullAsNil;
        }
        AppMethodBeat.m2505o(115230);
        return nullAsNil;
    }

    /* renamed from: c */
    public static void m7401c(SharedPreferences sharedPreferences, String str) {
        AppMethodBeat.m2504i(115231);
        if (sharedPreferences.edit().putString("language_key", str).commit()) {
            C5040bk.setProperty("language_key", str);
            C4990ab.m7420w("MicroMsg.LocaleUtil", "save application lang as:".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(115231);
            return;
        }
        C4990ab.m7412e("MicroMsg.LocaleUtil", "saving application lang failed");
        AppMethodBeat.m2505o(115231);
    }

    /* renamed from: gw */
    public static String m7403gw(Context context) {
        AppMethodBeat.m2504i(115232);
        String h = C4988aa.m7405h(context.getSharedPreferences(C4996ah.doA(), 0));
        String dor = C4988aa.dor();
        if (!h.equalsIgnoreCase("language_default")) {
            dor = h;
        }
        AppMethodBeat.m2505o(115232);
        return dor;
    }

    /* renamed from: gx */
    public static String m7404gx(Context context) {
        AppMethodBeat.m2504i(115233);
        String[] stringArray = context.getResources().getStringArray(C25738R.array.f12616q);
        String h = C4988aa.m7405h(context.getSharedPreferences(C4996ah.doA(), 0));
        String string;
        if (h == null) {
            string = context.getString(C25738R.string.f9158ra);
            AppMethodBeat.m2505o(115233);
            return string;
        }
        String[] strArr = C5070z.qno;
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            if (strArr[i].equals(h)) {
                string = stringArray[i2];
                AppMethodBeat.m2505o(115233);
                return string;
            }
            i++;
            i2++;
        }
        string = context.getString(C25738R.string.f9158ra);
        AppMethodBeat.m2505o(115233);
        return string;
    }

    public static Locale initLanguage(Context context) {
        AppMethodBeat.m2504i(115234);
        String g = C4988aa.m7402g(context.getSharedPreferences(C4996ah.doA(), 0));
        Locale locale;
        if (g.equals("language_default")) {
            C4988aa.m7399a(context, Locale.ENGLISH);
            locale = Locale.getDefault();
            AppMethodBeat.m2505o(115234);
            return locale;
        }
        locale = C4988aa.amw(g);
        C4988aa.m7399a(context, locale);
        AppMethodBeat.m2505o(115234);
        return locale;
    }

    static {
        AppMethodBeat.m2504i(115235);
        if (VERSION.SDK_INT < 24) {
            xyO = Locale.getDefault();
        } else {
            xyO = LocaleList.getDefault().get(0);
        }
        Locale.setDefault(xyO);
        AppMethodBeat.m2505o(115235);
    }
}
