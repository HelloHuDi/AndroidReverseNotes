package com.tencent.tinker.loader.shareutil;

import android.content.Intent;
import java.io.Serializable;
import java.util.HashMap;

public class ShareIntentUtil {
    /* renamed from: b */
    public static void m9354b(Intent intent, int i) {
        intent.putExtra("intent_return_code", i);
    }

    /* renamed from: be */
    public static int m9355be(Intent intent) {
        return m9364v(intent, "intent_return_code");
    }

    /* renamed from: a */
    public static void m9352a(Intent intent, long j) {
        intent.putExtra("intent_patch_cost_time", j);
    }

    /* renamed from: bf */
    public static long m9356bf(Intent intent) {
        return intent.getLongExtra("intent_patch_cost_time", 0);
    }

    /* renamed from: bg */
    public static Throwable m9357bg(Intent intent) {
        Serializable u = m9363u(intent, "intent_patch_exception");
        if (u != null) {
            return (Throwable) u;
        }
        return null;
    }

    /* renamed from: bh */
    public static Throwable m9358bh(Intent intent) {
        Serializable u = m9363u(intent, "intent_patch_interpret_exception");
        if (u != null) {
            return (Throwable) u;
        }
        return null;
    }

    /* renamed from: bi */
    public static HashMap<String, String> m9359bi(Intent intent) {
        Serializable u = m9363u(intent, "intent_patch_dexes_path");
        if (u != null) {
            return (HashMap) u;
        }
        return null;
    }

    /* renamed from: bj */
    public static HashMap<String, String> m9360bj(Intent intent) {
        Serializable u = m9363u(intent, "intent_patch_libs_path");
        if (u != null) {
            return (HashMap) u;
        }
        return null;
    }

    /* renamed from: bk */
    public static HashMap<String, String> m9361bk(Intent intent) {
        Serializable u = m9363u(intent, "intent_patch_package_config");
        if (u != null) {
            return (HashMap) u;
        }
        return null;
    }

    /* renamed from: n */
    public static String m9362n(Intent intent, String str) {
        String str2 = null;
        if (intent == null) {
            return str2;
        }
        try {
            return intent.getStringExtra(str);
        } catch (Exception e) {
            new StringBuilder("getStringExtra exception:").append(e.getMessage());
            return str2;
        }
    }

    /* renamed from: u */
    public static Serializable m9363u(Intent intent, String str) {
        Serializable serializable = null;
        if (intent == null) {
            return serializable;
        }
        try {
            return intent.getSerializableExtra(str);
        } catch (Exception e) {
            new StringBuilder("getSerializableExtra exception:").append(e.getMessage());
            return serializable;
        }
    }

    /* renamed from: v */
    private static int m9364v(Intent intent, String str) {
        int i = -10000;
        if (intent == null) {
            return i;
        }
        try {
            return intent.getIntExtra(str, -10000);
        } catch (Exception e) {
            new StringBuilder("getIntExtra exception:").append(e.getMessage());
            return i;
        }
    }

    /* renamed from: w */
    public static boolean m9365w(Intent intent, String str) {
        boolean z = false;
        if (intent == null) {
            return z;
        }
        try {
            return intent.getBooleanExtra(str, false);
        } catch (Exception e) {
            new StringBuilder("getBooleanExtra exception:").append(e.getMessage());
            return z;
        }
    }

    /* renamed from: a */
    public static void m9353a(Intent intent, ClassLoader classLoader) {
        try {
            intent.setExtrasClassLoader(classLoader);
        } catch (Throwable th) {
        }
    }
}
