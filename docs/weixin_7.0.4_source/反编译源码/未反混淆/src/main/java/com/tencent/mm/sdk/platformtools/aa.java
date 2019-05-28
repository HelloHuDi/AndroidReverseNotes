package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.Locale;

public final class aa {
    public static Locale xyO;

    public static boolean amv(String str) {
        AppMethodBeat.i(115219);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(115219);
            return false;
        } else if (str.equalsIgnoreCase("zh_TW") || str.equalsIgnoreCase("zh_HK") || str.equalsIgnoreCase("zh_CN") || str.equalsIgnoreCase("en") || str.equalsIgnoreCase("th") || str.equals("id") || str.equals("in") || str.equals("vi") || str.equalsIgnoreCase("pt") || str.equalsIgnoreCase("es") || str.equalsIgnoreCase("ru") || str.equalsIgnoreCase("ar") || str.equalsIgnoreCase("ja") || str.equalsIgnoreCase("it") || str.equalsIgnoreCase("ko") || str.equalsIgnoreCase("ms") || str.equalsIgnoreCase("tr") || str.equalsIgnoreCase("de") || str.equalsIgnoreCase("fr") || str.equalsIgnoreCase("my") || str.equalsIgnoreCase("lo")) {
            AppMethodBeat.o(115219);
            return true;
        } else {
            AppMethodBeat.o(115219);
            return false;
        }
    }

    public static boolean don() {
        AppMethodBeat.i(115220);
        String dor = dor();
        if (dor.equals("zh_CN") || dor.equals("zh_TW") || dor.equals("zh_HK")) {
            AppMethodBeat.o(115220);
            return true;
        }
        AppMethodBeat.o(115220);
        return false;
    }

    public static boolean doo() {
        AppMethodBeat.i(115221);
        if (dor().equals("zh_CN")) {
            AppMethodBeat.o(115221);
            return true;
        }
        AppMethodBeat.o(115221);
        return false;
    }

    public static boolean dop() {
        AppMethodBeat.i(115222);
        if (dor().equals("zh_TW") || dor().equals("zh_HK")) {
            AppMethodBeat.o(115222);
            return true;
        }
        AppMethodBeat.o(115222);
        return false;
    }

    public static void a(Context context, Locale locale) {
        AppMethodBeat.i(115223);
        try {
            Resources resources = context.getResources();
            Configuration configuration = resources.getConfiguration();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration.locale = locale;
            resources.updateConfiguration(configuration, displayMetrics);
            Resources.getSystem().updateConfiguration(configuration, displayMetrics);
            AppMethodBeat.o(115223);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.LocaleUtil", e, "updateApplicationResourceLocale err~~~", new Object[0]);
            AppMethodBeat.o(115223);
        }
    }

    public static String c(Locale locale) {
        AppMethodBeat.i(115224);
        String language = locale.getLanguage();
        if (language.equals("zh")) {
            language = language + "_" + locale.getCountry().toUpperCase();
            AppMethodBeat.o(115224);
            return language;
        }
        AppMethodBeat.o(115224);
        return language;
    }

    public static Locale amw(String str) {
        AppMethodBeat.i(115225);
        Locale locale;
        if (str.equals("zh_TW")) {
            locale = Locale.TAIWAN;
            AppMethodBeat.o(115225);
            return locale;
        } else if (str.equals("zh_HK")) {
            locale = new Locale("zh", "HK");
            AppMethodBeat.o(115225);
            return locale;
        } else if (str.equals("en")) {
            locale = Locale.ENGLISH;
            AppMethodBeat.o(115225);
            return locale;
        } else if (str.equals("zh_CN")) {
            locale = Locale.CHINA;
            AppMethodBeat.o(115225);
            return locale;
        } else if (str.equalsIgnoreCase("th") || str.equalsIgnoreCase("id") || str.equalsIgnoreCase("in") || str.equalsIgnoreCase("vi") || str.equalsIgnoreCase("pt") || str.equalsIgnoreCase("es") || str.equalsIgnoreCase("ru") || str.equalsIgnoreCase("ar") || str.equalsIgnoreCase("ja") || str.equalsIgnoreCase("it") || str.equalsIgnoreCase("ko") || str.equalsIgnoreCase("ms") || str.equalsIgnoreCase("tr") || str.equalsIgnoreCase("de") || str.equalsIgnoreCase("fr") || str.equalsIgnoreCase("my") || str.equalsIgnoreCase("lo")) {
            locale = new Locale(str);
            AppMethodBeat.o(115225);
            return locale;
        } else {
            ab.e("MicroMsg.LocaleUtil", "transLanguageToLocale country = ".concat(String.valueOf(str)));
            locale = Locale.ENGLISH;
            AppMethodBeat.o(115225);
            return locale;
        }
    }

    public static String doq() {
        AppMethodBeat.i(115226);
        String trim = Locale.getDefault().getCountry().trim();
        AppMethodBeat.o(115226);
        return trim;
    }

    private static String amx(String str) {
        AppMethodBeat.i(115227);
        String trim = Locale.getDefault().getLanguage().trim();
        String str2 = trim + "_" + Locale.getDefault().getCountry().trim();
        if (trim.equals("en")) {
            AppMethodBeat.o(115227);
            return trim;
        } else if (str2.equals("zh_TW")) {
            str = "zh_TW";
            AppMethodBeat.o(115227);
            return str;
        } else if (str2.equals("zh_HK")) {
            str = "zh_HK";
            AppMethodBeat.o(115227);
            return str;
        } else if (str2.equals("zh_CN")) {
            str = "zh_CN";
            AppMethodBeat.o(115227);
            return str;
        } else if (trim.equals("th")) {
            str = "th";
            AppMethodBeat.o(115227);
            return str;
        } else if (trim.equals("id")) {
            str = "id";
            AppMethodBeat.o(115227);
            return str;
        } else if (trim.equals("in")) {
            str = "id";
            AppMethodBeat.o(115227);
            return str;
        } else if (trim.equals("vi")) {
            str = "vi";
            AppMethodBeat.o(115227);
            return str;
        } else if (trim.equals("pt")) {
            str = "pt";
            AppMethodBeat.o(115227);
            return str;
        } else if (trim.equals("es")) {
            str = "es";
            AppMethodBeat.o(115227);
            return str;
        } else if (trim.equals("ru")) {
            str = "ru";
            AppMethodBeat.o(115227);
            return str;
        } else if (trim.equals("ar")) {
            str = "ar";
            AppMethodBeat.o(115227);
            return str;
        } else if (trim.equals("ja")) {
            str = "ja";
            AppMethodBeat.o(115227);
            return str;
        } else if (trim.equals("it")) {
            str = "it";
            AppMethodBeat.o(115227);
            return str;
        } else if (trim.equals("ko")) {
            str = "ko";
            AppMethodBeat.o(115227);
            return str;
        } else if (trim.equals("ms")) {
            str = "ms";
            AppMethodBeat.o(115227);
            return str;
        } else if (trim.equals("tr")) {
            str = "tr";
            AppMethodBeat.o(115227);
            return str;
        } else if (trim.equals("de")) {
            str = "de";
            AppMethodBeat.o(115227);
            return str;
        } else if (trim.equals("fr")) {
            str = "fr";
            AppMethodBeat.o(115227);
            return str;
        } else if (trim.equals("my")) {
            str = "my";
            AppMethodBeat.o(115227);
            return str;
        } else if (trim.equals("lo")) {
            str = "lo";
            AppMethodBeat.o(115227);
            return str;
        } else {
            AppMethodBeat.o(115227);
            return str;
        }
    }

    public static String dor() {
        AppMethodBeat.i(115228);
        String nullAsNil = bo.nullAsNil(bk.getProperty("language_key"));
        if (nullAsNil.length() <= 0 || nullAsNil.equals("language_default")) {
            nullAsNil = amx("en");
            AppMethodBeat.o(115228);
            return nullAsNil;
        }
        AppMethodBeat.o(115228);
        return nullAsNil;
    }

    public static String g(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(115229);
        String nullAsNil = bo.nullAsNil(sharedPreferences.getString("language_key", null));
        if (nullAsNil.length() <= 0 || nullAsNil.equals("language_default")) {
            nullAsNil = amx("en");
            bk.setProperty("language_key", nullAsNil);
            AppMethodBeat.o(115229);
            return nullAsNil;
        }
        bk.setProperty("language_key", nullAsNil);
        AppMethodBeat.o(115229);
        return nullAsNil;
    }

    public static String h(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(115230);
        String nullAsNil = bo.nullAsNil(sharedPreferences.getString("language_key", null));
        if (bo.isNullOrNil(nullAsNil)) {
            nullAsNil = "language_default";
            AppMethodBeat.o(115230);
            return nullAsNil;
        }
        AppMethodBeat.o(115230);
        return nullAsNil;
    }

    public static void c(SharedPreferences sharedPreferences, String str) {
        AppMethodBeat.i(115231);
        if (sharedPreferences.edit().putString("language_key", str).commit()) {
            bk.setProperty("language_key", str);
            ab.w("MicroMsg.LocaleUtil", "save application lang as:".concat(String.valueOf(str)));
            AppMethodBeat.o(115231);
            return;
        }
        ab.e("MicroMsg.LocaleUtil", "saving application lang failed");
        AppMethodBeat.o(115231);
    }

    public static String gw(Context context) {
        AppMethodBeat.i(115232);
        String h = h(context.getSharedPreferences(ah.doA(), 0));
        String dor = dor();
        if (!h.equalsIgnoreCase("language_default")) {
            dor = h;
        }
        AppMethodBeat.o(115232);
        return dor;
    }

    public static String gx(Context context) {
        AppMethodBeat.i(115233);
        String[] stringArray = context.getResources().getStringArray(R.array.q);
        String h = h(context.getSharedPreferences(ah.doA(), 0));
        String string;
        if (h == null) {
            string = context.getString(R.string.ra);
            AppMethodBeat.o(115233);
            return string;
        }
        String[] strArr = z.qno;
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            if (strArr[i].equals(h)) {
                string = stringArray[i2];
                AppMethodBeat.o(115233);
                return string;
            }
            i++;
            i2++;
        }
        string = context.getString(R.string.ra);
        AppMethodBeat.o(115233);
        return string;
    }

    public static Locale initLanguage(Context context) {
        AppMethodBeat.i(115234);
        String g = g(context.getSharedPreferences(ah.doA(), 0));
        Locale locale;
        if (g.equals("language_default")) {
            a(context, Locale.ENGLISH);
            locale = Locale.getDefault();
            AppMethodBeat.o(115234);
            return locale;
        }
        locale = amw(g);
        a(context, locale);
        AppMethodBeat.o(115234);
        return locale;
    }

    static {
        AppMethodBeat.i(115235);
        if (VERSION.SDK_INT < 24) {
            xyO = Locale.getDefault();
        } else {
            xyO = LocaleList.getDefault().get(0);
        }
        Locale.setDefault(xyO);
        AppMethodBeat.o(115235);
    }
}
