package com.tencent.xweb.util;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import org.xwalk.core.Log;

public final class e {
    public static Object iJ(String str, String str2) {
        Object obj = null;
        AppMethodBeat.i(4018);
        try {
            obj = Class.forName(str).getMethod(str2, new Class[0]).invoke(null, new Object[0]);
            AppMethodBeat.o(4018);
        } catch (Throwable th) {
            AppMethodBeat.o(4018);
        }
        return obj;
    }

    public static Object b(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        Object obj = null;
        AppMethodBeat.i(4019);
        try {
            Method method = Class.forName(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            obj = method.invoke(null, objArr);
            AppMethodBeat.o(4019);
        } catch (Throwable th) {
            AppMethodBeat.o(4019);
        }
        return obj;
    }

    public static Object avm(String str) {
        Object obj = null;
        AppMethodBeat.i(4020);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(4020);
        } else {
            try {
                obj = Class.forName(str).newInstance();
                AppMethodBeat.o(4020);
            } catch (Throwable th) {
                AppMethodBeat.o(4020);
            }
        }
        return obj;
    }

    public static Object n(Object obj, String str) {
        AppMethodBeat.i(4021);
        Object c = c(obj, str, null, new Object[0]);
        AppMethodBeat.o(4021);
        return c;
    }

    public static Object c(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        AppMethodBeat.i(4022);
        if (obj == null) {
            AppMethodBeat.o(4022);
            return null;
        }
        Object invoke;
        try {
            Method method;
            Class cls = obj.getClass();
            if (VERSION.SDK_INT > 10) {
                method = cls.getMethod(str, clsArr);
            } else {
                method = cls.getDeclaredMethod(str, clsArr);
            }
            method.setAccessible(true);
            if (objArr.length == 0) {
                objArr = null;
            }
            invoke = method.invoke(obj, objArr);
            AppMethodBeat.o(4022);
            return invoke;
        } catch (Throwable th) {
            if (th.getCause() != null && th.getCause().toString().contains("AuthenticationFail")) {
                invoke = new String("AuthenticationFail");
                AppMethodBeat.o(4022);
                return invoke;
            } else if (str == null || !(str.equalsIgnoreCase("canLoadX5Core") || str.equalsIgnoreCase("initTesRuntimeEnvironment"))) {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                Log.e("ReflectionUtils", "invokeInstance -- exceptions:" + stringWriter.toString());
                AppMethodBeat.o(4022);
                return null;
            } else {
                AppMethodBeat.o(4022);
                return null;
            }
        }
    }
}
