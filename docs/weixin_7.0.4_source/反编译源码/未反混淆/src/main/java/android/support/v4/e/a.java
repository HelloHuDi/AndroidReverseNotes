package android.support.v4.e;

import android.os.Build.VERSION;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class a {
    private static Method KF;
    private static Method KG;

    static {
        if (VERSION.SDK_INT >= 21) {
            try {
                KG = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
                return;
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                KF = cls.getMethod("getScript", new Class[]{String.class});
                KG = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Exception e2) {
            KF = null;
            KG = null;
        }
    }

    public static String a(Locale locale) {
        if (VERSION.SDK_INT >= 21) {
            try {
                return ((Locale) KG.invoke(null, new Object[]{locale})).getScript();
            } catch (IllegalAccessException | InvocationTargetException e) {
                return locale.getScript();
            }
        }
        String b = b(locale);
        if (b != null) {
            return getScript(b);
        }
        return null;
    }

    private static String getScript(String str) {
        try {
            if (KF != null) {
                return (String) KF.invoke(null, new Object[]{str});
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
        }
        return null;
    }

    private static String b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (KG != null) {
                return (String) KG.invoke(null, new Object[]{locale2});
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
        }
        return locale2;
    }
}
