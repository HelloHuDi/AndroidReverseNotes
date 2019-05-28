package com.tencent.tinker.loader.shareutil;

import android.content.Intent;
import java.io.Serializable;
import java.util.HashMap;

public class ShareIntentUtil {
    public static void b(Intent intent, int i) {
        intent.putExtra("intent_return_code", i);
    }

    public static int be(Intent intent) {
        return v(intent, "intent_return_code");
    }

    public static void a(Intent intent, long j) {
        intent.putExtra("intent_patch_cost_time", j);
    }

    public static long bf(Intent intent) {
        return intent.getLongExtra("intent_patch_cost_time", 0);
    }

    public static Throwable bg(Intent intent) {
        Serializable u = u(intent, "intent_patch_exception");
        if (u != null) {
            return (Throwable) u;
        }
        return null;
    }

    public static Throwable bh(Intent intent) {
        Serializable u = u(intent, "intent_patch_interpret_exception");
        if (u != null) {
            return (Throwable) u;
        }
        return null;
    }

    public static HashMap<String, String> bi(Intent intent) {
        Serializable u = u(intent, "intent_patch_dexes_path");
        if (u != null) {
            return (HashMap) u;
        }
        return null;
    }

    public static HashMap<String, String> bj(Intent intent) {
        Serializable u = u(intent, "intent_patch_libs_path");
        if (u != null) {
            return (HashMap) u;
        }
        return null;
    }

    public static HashMap<String, String> bk(Intent intent) {
        Serializable u = u(intent, "intent_patch_package_config");
        if (u != null) {
            return (HashMap) u;
        }
        return null;
    }

    public static String n(Intent intent, String str) {
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

    public static Serializable u(Intent intent, String str) {
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

    private static int v(Intent intent, String str) {
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

    public static boolean w(Intent intent, String str) {
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

    public static void a(Intent intent, ClassLoader classLoader) {
        try {
            intent.setExtrasClassLoader(classLoader);
        } catch (Throwable th) {
        }
    }
}
