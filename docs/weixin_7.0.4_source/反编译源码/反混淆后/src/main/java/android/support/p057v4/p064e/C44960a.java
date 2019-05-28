package android.support.p057v4.p064e;

import android.os.Build.VERSION;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* renamed from: android.support.v4.e.a */
public final class C44960a {
    /* renamed from: KF */
    private static Method f17695KF;
    /* renamed from: KG */
    private static Method f17696KG;

    static {
        if (VERSION.SDK_INT >= 21) {
            try {
                f17696KG = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
                return;
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f17695KF = cls.getMethod("getScript", new Class[]{String.class});
                f17696KG = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Exception e2) {
            f17695KF = null;
            f17696KG = null;
        }
    }

    /* renamed from: a */
    public static String m82260a(Locale locale) {
        if (VERSION.SDK_INT >= 21) {
            try {
                return ((Locale) f17696KG.invoke(null, new Object[]{locale})).getScript();
            } catch (IllegalAccessException | InvocationTargetException e) {
                return locale.getScript();
            }
        }
        String b = C44960a.m82261b(locale);
        if (b != null) {
            return C44960a.getScript(b);
        }
        return null;
    }

    private static String getScript(String str) {
        try {
            if (f17695KF != null) {
                return (String) f17695KF.invoke(null, new Object[]{str});
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
        }
        return null;
    }

    /* renamed from: b */
    private static String m82261b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (f17696KG != null) {
                return (String) f17696KG.invoke(null, new Object[]{locale2});
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
        }
        return locale2;
    }
}
